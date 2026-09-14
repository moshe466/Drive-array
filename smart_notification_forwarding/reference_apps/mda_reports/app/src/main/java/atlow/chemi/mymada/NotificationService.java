package atlow.chemi.mymada;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
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

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationPosted(StatusBarNotification statusBarNotification) {
        String str;
        String replace;
        int i;
        String str2;
        boolean z = getSharedPreferences("Settings", 0).getBoolean("Mapp", false);
        Log.e("Mapp is!", z ? "true" : "false");
        if (!z || statusBarNotification.getPackageName() == null) {
            return;
        }
        if (statusBarNotification.getPackageName().contains("mdaemergency") || statusBarNotification.getPackageName().contains("mda.health") || statusBarNotification.getPackageName().equals("atlow.mymadaadmin")) {
            Bundle bundle = statusBarNotification.getNotification().extras;
            String packageName = statusBarNotification.getPackageName();
            LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this.b);
            try {
                str = statusBarNotification.getNotification().tickerText.toString();
            } catch (Exception unused) {
                str = "";
            }
            String string = bundle.getString(NotificationCompat.EXTRA_TITLE);
            try {
                if (bundle.getCharSequence(NotificationCompat.EXTRA_TEXT) != null) {
                    CharSequence charSequence = bundle.getCharSequence(NotificationCompat.EXTRA_TEXT);
                    charSequence.getClass();
                    str2 = charSequence.toString();
                } else {
                    str2 = "תקלה";
                }
                this.a = str2;
            } catch (Exception e) {
                this.a = "\nתקלה!";
                Crashlytics.log("notification text is null!\n" + e);
            }
            Intent intent = new Intent("MADA_APP");
            intent.addFlags(268435456);
            intent.addFlags(67108864);
            intent.putExtra("pack", packageName);
            intent.putExtra("ticker", str);
            intent.putExtra(SettingsJsonConstants.PROMPT_TITLE_KEY, string);
            intent.putExtra("text", this.a);
            if (string != null) {
                if (string.equals("מגן דוד אדום") || string.equals("מערך הכוננים הלאומי")) {
                    return;
                }
                String str3 = "*אירוע חדש*";
                if (string.contains("*אירוע חדש*") || string.contains("*New Event*")) {
                    if (this.a.contains("שירות") || this.a.contains("כלכלה") || this.a.contains("תפילה")) {
                        intent.putExtra("callT", 6);
                    } else if (this.a.contains("מנהלתי") || this.a.contains("מינהלתי") || this.a.contains("משמרת בנה")) {
                        intent.putExtra("callT", 4);
                    } else {
                        if (!this.a.contains("אירוע חדש")) {
                            if (this.a.contains("הודעת קבוצת")) {
                                i = 2;
                            } else if (this.a.contains("הודעת צוות")) {
                                i = 3;
                            } else if (this.a.contains("על מידע זה חל חיסיון רפואי") || this.a.contains("על מידע זה חל חיסיון רפואי")) {
                                intent.putExtra("callT", 5);
                            }
                            intent.putExtra("callT", i);
                        }
                        i = 1;
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
                    if (this.a.contains("שירות") || this.a.contains("כלכלה") || this.a.contains("תפילה")) {
                        intent.putExtra("callT", 6);
                    }
                    if (this.a.contains("על מידע זה חל חיסיון רפואי")) {
                        intent.putExtra("callT", 5);
                    }
                }
                replace = string.replace(str3, "");
                intent.putExtra("time", replace);
            }
            GrobootRec.madasApp(statusBarNotification.getNotification().contentIntent);
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
