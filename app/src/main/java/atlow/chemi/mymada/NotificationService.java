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
    private static final String TAG = "NotificationService";
    protected String a;
    Context b;

    private static String sLastPackage = "";
    private static String sLastNormalizedText = "";
    private static long sLastNotifTime = 0;

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
                Log.e("getActiveNotification", message != null ? message : "");
                Crashlytics.logException(e);
            }
        }
    }

    @Override // android.service.notification.NotificationListenerService
    @TargetApi(24)
    public void onListenerDisconnected() {
        if (Build.VERSION.SDK_INT >= 24) {
            NotificationListenerService.requestRebind(new ComponentName(this, (Class<?>) NotificationService.class));
        }
    }

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

        // Deduplication window of 1500ms for exact identical content from same package
        if (pkg != null && pkg.equals(sLastPackage) && (now - sLastNotifTime < 1500)) {
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
        String lower = text.toLowerCase();

        // Never filter if it contains emergency dispatch or active call indicators
        String[] emergencyKeywords = {
            "אירוע", "הזנקה", "קריאה", "כתובת", "נפגע", "חולה", "החייאה", "טראומה",
            "דום לב", "ת.ד", "תאונה", "מנהלתי", "מינהלתי", "צוות", "קבוצה", "שירות",
            "שובצת", "ביטול", "טופס", "טפסים", "forms", "event", "incident", "dispatch",
            "חיסיון רפואי", "giverespect", "איוונט"
        };
        for (String ek : emergencyKeywords) {
            if (lower.contains(ek)) {
                return false;
            }
        }

        String[] blacklist = {
            "שירות פעיל", "השירות פועל", "עדכון מיקום", "בדיקת תקשורת",
            "סנכרון", "חיבור למוקד", "התחברות למערכת", "שירות רקע", "סטטוס כונן",
            "אין קריאות", "מצב כוננות", "פעיל ברקע", "שירות המיקום", "פועל ברקע",
            "מחובר למוקד", "connected", "syncing", "background service", "location service",
            "service running", "running in background", "mda service"
        };
        for (String b : blacklist) {
            if (lower.contains(b)) {
                return true;
            }
        }
        return false;
    }

    private boolean isTargetEmergencyPackage(String pkg) {
        if (pkg == null) return false;
        String p = pkg.toLowerCase();
        return p.contains("mdaemergency") || 
               p.contains("mda.health") || 
               p.contains("il.org.mda") ||
               p.contains("com.mda") ||
               p.equals("atlow.mymadaadmin") || 
               p.contains("com.uh.sf") ||
               p.contains("hatzalah");
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationPosted(StatusBarNotification statusBarNotification) {
        if (statusBarNotification == null || statusBarNotification.getPackageName() == null) {
            return;
        }

        String packageName = statusBarNotification.getPackageName();

        // Ignore notifications originating from our own app
        if (packageName.equalsIgnoreCase(getPackageName())) {
            return;
        }

        boolean isAppEnabled = getSharedPreferences("Settings", 0).getBoolean("Mapp", false);
        if (!isAppEnabled) {
            return;
        }

        Notification notification = statusBarNotification.getNotification();
        if (notification == null) {
            return;
        }

        if (!isTargetEmergencyPackage(packageName)) {
            return;
        }

        Bundle bundle = notification.extras;
        String title = "";
        String text = "";
        String ticker = "";

        try {
            if (notification.tickerText != null) {
                ticker = notification.tickerText.toString().trim();
            }
        } catch (Exception ignored) {
        }

        if (bundle != null) {
            // Title extraction (safe CharSequence)
            CharSequence titleCs = bundle.getCharSequence(NotificationCompat.EXTRA_TITLE);
            if (titleCs == null || titleCs.length() == 0) {
                titleCs = bundle.getCharSequence(NotificationCompat.EXTRA_TITLE_BIG);
            }
            if (titleCs == null || titleCs.length() == 0) {
                titleCs = bundle.getCharSequence("android.title");
            }
            if (titleCs != null) {
                title = titleCs.toString().trim();
            }

            // Body extraction (safe CharSequence)
            CharSequence textCs = bundle.getCharSequence(NotificationCompat.EXTRA_BIG_TEXT);
            if (textCs == null || textCs.length() == 0) {
                textCs = bundle.getCharSequence(NotificationCompat.EXTRA_TEXT);
            }
            if (textCs == null || textCs.length() == 0) {
                textCs = bundle.getCharSequence(NotificationCompat.EXTRA_SUB_TEXT);
            }
            if (textCs == null || textCs.length() == 0) {
                textCs = bundle.getCharSequence(NotificationCompat.EXTRA_INFO_TEXT);
            }
            if (textCs == null || textCs.length() == 0) {
                textCs = bundle.getCharSequence(NotificationCompat.EXTRA_SUMMARY_TEXT);
            }
            if (textCs == null || textCs.length() == 0) {
                CharSequence[] textLines = bundle.getCharSequenceArray(NotificationCompat.EXTRA_TEXT_LINES);
                if (textLines != null && textLines.length > 0) {
                    StringBuilder sb = new StringBuilder();
                    for (CharSequence line : textLines) {
                        if (line != null && line.length() > 0) {
                            if (sb.length() > 0) sb.append("\n");
                            sb.append(line);
                        }
                    }
                    textCs = sb.toString();
                }
            }
            if (textCs != null) {
                text = textCs.toString().trim();
            }
        }

        if (title.isEmpty() && !ticker.isEmpty()) {
            title = ticker;
        }
        if (text.isEmpty() && !ticker.isEmpty() && !ticker.equals(title)) {
            text = ticker;
        }

        String fullText = (title + " " + text).trim();
        if (fullText.isEmpty() || isSystemMessage(fullText)) {
            return;
        }

        this.a = text;

        // Deduplication check
        if (isDuplicateNotification(packageName, title, text)) {
            return;
        }

        Intent intent = new Intent("MADA_APP");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("pack", packageName);
        intent.putExtra("ticker", ticker);
        intent.putExtra(SettingsJsonConstants.PROMPT_TITLE_KEY, title);
        intent.putExtra("text", text);

        boolean isUh = packageName.contains("com.uh") || packageName.contains("hatzalah");

        if (isUh) {
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
            intent.putExtra("address", !text.isEmpty() ? text : (!title.isEmpty() ? title : "קריאת חירום"));
            intent.putExtra("sms", !text.isEmpty() ? text : title);
            intent.putExtra("title", !title.isEmpty() ? title : "איחוד הצלה");
        } else {
            // MDA parsing
            int callType = 2; // Default MDA emergency call
            String orgTitle = "מד״א - קריאת חירום";
            String time = "";

            if (fullText.contains("שירות") || fullText.contains("כלכלה") || fullText.contains("תפילה")) {
                callType = 6;
                orgTitle = "מד״א - הודעת שירות";
            } else if (fullText.contains("מנהלתי") || fullText.contains("מינהלתי") || fullText.contains("משמרת בנה") || fullText.contains("*הודעה מנהלתית")) {
                boolean showAdmin = getSharedPreferences("Settings", 0).getBoolean("callT4", true);
                if (!showAdmin) {
                    return;
                }
                callType = 4;
                orgTitle = "מד״א - הודעה מנהלתית";
            } else if (fullText.contains("הודעת קבוצת") || fullText.contains("הודעת קבוצה")) {
                callType = 3;
                orgTitle = "מד״א - הודעת קבוצה";
            } else if (fullText.contains("הודעת צוות")) {
                callType = 7;
                orgTitle = "מד״א - הודעת צוות";
            } else if (fullText.contains("על מידע זה חל חיסיון רפואי")) {
                callType = 5;
                orgTitle = "מד״א - חיסיון רפואי";
            } else {
                callType = 2;
                orgTitle = "מד״א - קריאת חירום";
            }

            if (title.contains("*New Event*")) {
                time = title.replace("*New Event*", "").trim();
            } else if (title.contains("*אירוע חדש*")) {
                time = title.replace("*אירוע חדש*", "").trim();
            }

            intent.putExtra("callT", callType);
            intent.putExtra("org_title", orgTitle);
            intent.putExtra("time", time);
            intent.putExtra("address", !text.isEmpty() ? text : title);
            intent.putExtra("sms", !text.isEmpty() ? text : title);
            intent.putExtra("title", !title.isEmpty() ? title : "מד״א");
        }

        GrobootRec.madasApp(notification.contentIntent);
        LocalBroadcastManager.getInstance(this.b).sendBroadcast(intent);
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
