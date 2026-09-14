package atlow.chemi.mymada;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import atlow.chemi.mymada.recieversAndServices.GrobootRec;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;

@TargetApi(19)
/* loaded from: classes.dex */
public class NotificationService extends NotificationListenerService {
    protected String a;
    Context b;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.b = getApplicationContext();
    }

    @Override // android.service.notification.NotificationListenerService
    @TargetApi(24)
    public void onListenerConnected() {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                getActiveNotifications();
            } catch (Exception e) {
                String message = e.getMessage();
                message.getClass();
                Log.e("getActiveNotification", message);
                Crashlytics.logException(e);
            }
        }
    }

    @Override // android.service.notification.NotificationListenerService
    @TargetApi(24)
    public void onListenerDisconnected() {
        if (Build.VERSION.SDK_INT >= 24) {
            NotificationListenerService.requestRebind(new ComponentName(this, (Class<?>) NotificationListenerService.class));
        }
    }

    private static String sLastPackage = "";
    private static String sLastNormalizedText = "";
    private static long sLastNotifTime = 0;

    private static String normalizeText(String text) {
        if (text == null) return "";
        return text.replaceAll("[\\s\\r\\n\\t]+", " ").trim();
    }

    private static synchronized boolean isDuplicateNotification(String pkg, String title, String body) {
        long now = System.currentTimeMillis();
        String normTitle = normalizeText(title);
        String normBody = normalizeText(body);
        String combined = (normTitle + " " + normBody).trim();

        if (combined.isEmpty()) {
            return true;
        }

        // Deduplication window of 8000ms for identical content from same package
        if (pkg != null && pkg.equals(sLastPackage) && (now - sLastNotifTime < 8000)) {
            if (combined.equalsIgnoreCase(sLastNormalizedText) || 
                (!normBody.isEmpty() && normBody.equalsIgnoreCase(sLastNormalizedText))) {
                return true;
            }
        }

        sLastPackage = pkg != null ? pkg : "";
        sLastNormalizedText = !normBody.isEmpty() ? normBody : combined;
        sLastNotifTime = now;
        return false;
    }

    private static boolean isSystemMessage(String text) {
        if (text == null || text.trim().isEmpty()) return true;
        String[] blacklist = {
            "מחובר", "שירות פעיל", "השירות פועל", "עדכון מיקום", "בדיקת תקשורת",
            "סנכרון", "חיבור למוקד", "התחברות למערכת", "שירות רקע", "סטטוס כונן",
            "אין קריאות", "מצב כוננות", "פעיל ברקע", "שירות המיקום", "פועל ברקע",
            "connected", "syncing", "background service", "location service"
        };
        for (String b : blacklist) {
            if (text.contains(b)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationPosted(StatusBarNotification statusBarNotification) {
        String str;
        String replace;
        int i = 1;
        String str2;
        boolean z = getSharedPreferences("Settings", 0).getBoolean("Mapp", false);
        Log.e("Mapp is!", z ? "true" : "false");
        if (!z || statusBarNotification == null || statusBarNotification.getPackageName() == null) {
            return;
        }

        // Ignore ongoing / foreground service notifications (e.g., app running in background, GPS active)
        if (statusBarNotification.isOngoing()) {
            return;
        }
        Notification notification = statusBarNotification.getNotification();
        if (notification == null) {
            return;
        }
        if ((notification.flags & Notification.FLAG_ONGOING_EVENT) != 0 ||
            (notification.flags & Notification.FLAG_NO_CLEAR) != 0 ||
            (notification.flags & Notification.FLAG_FOREGROUND_SERVICE) != 0) {
            return;
        }

        String packageName = statusBarNotification.getPackageName();
        if (packageName.contains("mdaemergency") || packageName.contains("mda.health") || packageName.equals("atlow.mymadaadmin") || packageName.equals("com.uh.sf")) {
            Bundle bundle = notification.extras;
            LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this.b);
            try {
                str = notification.tickerText != null ? notification.tickerText.toString() : "";
            } catch (Exception unused) {
                str = "";
            }
            String string = bundle != null ? bundle.getString(NotificationCompat.EXTRA_TITLE) : null;
            try {
                if (bundle != null && bundle.getCharSequence(NotificationCompat.EXTRA_BIG_TEXT) != null) {
                    str2 = bundle.getCharSequence(NotificationCompat.EXTRA_BIG_TEXT).toString();
                } else if (bundle != null && bundle.getCharSequence(NotificationCompat.EXTRA_TEXT) != null) {
                    str2 = bundle.getCharSequence(NotificationCompat.EXTRA_TEXT).toString();
                } else {
                    str2 = "";
                }
                this.a = str2;
            } catch (Exception e) {
                this.a = "";
                Crashlytics.log("notification text is null!\n" + e);
            }

            // Deduplication check
            if (isDuplicateNotification(packageName, string, this.a)) {
                return;
            }

            Intent intent = new Intent("MADA_APP");
            intent.addFlags(268435456);
            intent.addFlags(67108864);
            intent.putExtra("pack", packageName);
            intent.putExtra("ticker", str);
            intent.putExtra(SettingsJsonConstants.PROMPT_TITLE_KEY, string);
            intent.putExtra("text", this.a);

            if ("com.uh.sf".equals(packageName)) {
                String fullText = ((string != null ? string : "") + " " + (this.a != null ? this.a : "")).trim();
                if (isSystemMessage(fullText)) {
                    return;
                }

                boolean isTeam = fullText.contains("רחובות 143") ||
                                 fullText.contains("מ 44") ||
                                 fullText.contains("הודעת צוות") ||
                                 fullText.contains("הודעת קבוצה") ||
                                 fullText.contains("צוות כוננים");

                boolean isAdministrative = fullText.contains("FORMS") ||
                                           fullText.contains("טפסים") ||
                                           fullText.contains("מילוי טופס") ||
                                           fullText.contains("פריסה מבצעית") ||
                                           fullText.contains("ניהול תקפים") ||
                                           fullText.contains("איוונט") ||
                                           fullText.contains("GIVERESPECT") ||
                                           fullText.contains("כבוד המת") ||
                                           fullText.contains("גנרל") ||
                                           fullText.contains("GENERAL") ||
                                           fullText.contains("שובצת לאירוע") ||
                                           fullText.contains("שיבוץ") ||
                                           fullText.contains("צוותת") ||
                                           fullText.contains("ביטול אירוע") ||
                                           fullText.contains("אירוע בוטל") ||
                                           fullText.contains("סיום אירוע") ||
                                           fullText.contains("מנהלתי") ||
                                           fullText.contains("מינהלתי") ||
                                           fullText.contains("הודעת מוקד") ||
                                           fullText.contains("עדכון מוקד") ||
                                           fullText.contains("הודעת סניף") ||
                                           fullText.contains("תזכורת");

                if (isTeam) {
                    intent.putExtra("callT", 7);
                    intent.putExtra("org_title", "איחוד הצלה - הודעת צוות");
                } else if (isAdministrative) {
                    boolean showAdmin = getSharedPreferences("Settings", 0).getBoolean("callT4", true);
                    if (!showAdmin) {
                        return;
                    }
                    intent.putExtra("callT", 4);
                    intent.putExtra("org_title", "איחוד הצלה - הודעה מנהלתית");
                } else {
                    intent.putExtra("callT", 1);
                    intent.putExtra("org_title", "איחוד הצלה - קריאת חירום");
                }
                intent.putExtra("address", this.a != null && !this.a.isEmpty() ? this.a : (string != null ? string : "קריאת חירום"));
                intent.putExtra("sms", this.a != null ? this.a : "");
                intent.putExtra("title", string != null ? string : "איחוד הצלה");
            } else if (string != null) {
                if (string.equals("מגן דוד אדום") || string.equals("מערך הכוננים הלאומי")) {
                    return;
                }
                String str3 = "*אירוע חדש*";
                if (string.contains("*אירוע חדש*") || string.contains("*New Event*")) {
                    if (this.a.contains("שירות") || this.a.contains("כלכלה") || this.a.contains("תפילה")) {
                        intent.putExtra("callT", 6);
                        intent.putExtra("org_title", "מד״א - הודעת שירות");
                    } else if (this.a.contains("מנהלתי") || this.a.contains("מינהלתי") || this.a.contains("משמרת בנה")) {
                        intent.putExtra("callT", 4);
                        intent.putExtra("org_title", "מד״א - הודעה מנהלתית");
                    } else {
                        if (!this.a.contains("אירוע חדש")) {
                            if (this.a.contains("הודעת קבוצת")) {
                                i = 3; // group message
                                intent.putExtra("org_title", "מד״א - הודעת קבוצה");
                            } else if (this.a.contains("הודעת צוות")) {
                                i = 7; // team message
                                intent.putExtra("org_title", "מד״א - הודעת צוות");
                            } else if (this.a.contains("על מידע זה חל חיסיון רפואי")) {
                                i = 5;
                                intent.putExtra("org_title", "מד״א - חיסיון רפואי");
                            } else {
                                i = 2; // MDA new event
                                intent.putExtra("org_title", "מד״א - קריאת חירום");
                            }
                        } else {
                            i = 2; // MDA new event
                            intent.putExtra("org_title", "מד״א - קריאת חירום");
                        }
                        intent.putExtra("callT", i);
                    }
                    if (!string.contains("אירוע חדש")) {
                        replace = string.replace("*New Event*", "");
                        intent.putExtra("time", replace);
                    }
                } else {
                    str3 = "*הודעה מנהלתית חדשה*";
                    if (!string.contains("*הודעה מנהלתית חדשה*")) {
                        return;
                    }
                    intent.putExtra("callT", 4);
                    intent.putExtra("org_title", "מד״א - הודעה מנהלתית");
                    if (this.a.contains("שירות") || this.a.contains("כלכלה") || this.a.contains("תפילה")) {
                        intent.putExtra("callT", 6);
                        intent.putExtra("org_title", "מד״א - הודעת שירות");
                    }
                    if (this.a.contains("על מידע זה חל חיסיון רפואי")) {
                        intent.putExtra("callT", 5);
                        intent.putExtra("org_title", "מד״א - חיסיון רפואי");
                    }
                }
                replace = string.replace(str3, "");
                intent.putExtra("time", replace);
                intent.putExtra("address", this.a != null && !this.a.isEmpty() ? this.a : string);
                intent.putExtra("sms", this.a != null ? this.a : "");
                intent.putExtra("title", string);
            } else {
                return;
            }

            if (intent.getIntExtra("callT", 0) == 4) {
                boolean showAdmin = getSharedPreferences("Settings", 0).getBoolean("callT4", true);
                if (!showAdmin) {
                    return;
                }
            }

            GrobootRec.madasApp(notification.contentIntent);
            localBroadcastManager.sendBroadcast(intent);
        }
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationRemoved(StatusBarNotification statusBarNotification) {
        if (Build.VERSION.SDK_INT < 26 || statusBarNotification == null || statusBarNotification.getPackageName() == null || !statusBarNotification.getPackageName().contains(BuildConfig.APPLICATION_ID)) {
            return;
        }
        NotificationManager notificationManager = (NotificationManager) this.b.getSystemService(NotificationManager.class);
        Notification notification = statusBarNotification.getNotification();
        if (!notification.getChannelId().contains("generated") || notificationManager == null) {
            return;
        }
        notificationManager.deleteNotificationChannel(notification.getChannelId());
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        Log.d("REBIND", "NotificationListenerService onStartCommand begin");
        if (intent == null) {
            return 1;
        }
        Applicatio.tryConnectService(this.b);
        return 1;
    }
}
