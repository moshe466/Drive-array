package atlow.chemi.mymada.recieversAndServices;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Vibrator;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import atlow.chemi.mymada.R;
import atlow.chemi.mymada.smsRes;
import com.crashlytics.android.Crashlytics;

/* loaded from: classes.dex */
public class GrobootRec extends BroadcastReceiver {
    protected static String k = "T1";
    protected static PendingIntent l;
    public static Boolean testAp = false;
    private static int NOTIF_ID = 200;
    public static float vo = 0.0f;
    protected String a;
    protected Context c;
    protected int d;
    protected boolean f;
    protected boolean g;
    protected boolean h;
    protected boolean i;
    protected boolean j;
    protected String b = "notWithWin";
    public long[] lng = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    protected int e = 0;

    public static void madasApp(PendingIntent pendingIntent) {
        l = pendingIntent;
    }

    private boolean isCallable(Intent intent) {
        try {
            return this.c != null && this.c.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        this.c = context;
        if (context == null || intent == null) {
            return;
        }

        SharedPreferences sp = context.getSharedPreferences("Settings", 0);
        boolean isDetectionEnabled = sp.getBoolean("Mapp", true);
        if (!isDetectionEnabled) {
            return;
        }

        int callT = intent.getIntExtra("callT", 0);
        if (callT == 4 && !sp.getBoolean("callT4", true)) {
            return;
        }

        String time = intent.getStringExtra("time");
        String address = intent.getStringExtra("address");
        String sms = intent.getStringExtra("sms");
        String kod = intent.getStringExtra("kod");

        String suffix = "";
        String orgTitle = intent.hasExtra("org_title") ? intent.getStringExtra("org_title") : "מקרה חדש";
        if (callT == 1) {
            suffix = "T1";
            if (!intent.hasExtra("org_title")) orgTitle = "איחוד הצלה - קריאת חירום";
        } else if (callT == 2) {
            suffix = "T2";
            if (!intent.hasExtra("org_title")) orgTitle = "מד״א - קריאת חירום";
        } else if (callT == 4) {
            suffix = "T4";
            if (!intent.hasExtra("org_title")) orgTitle = "הודעה מנהלתית";
        } else if (callT == 7 || callT == 3) {
            suffix = "T3";
            if (!intent.hasExtra("org_title")) orgTitle = "הודעת צוות";
        } else if (callT == 6) {
            suffix = "T6";
            if (!intent.hasExtra("org_title")) orgTitle = "הודעת שירות";
        }

        // Check if sound/alert is enabled for this category
        boolean isSoundEnabled = sp.getBoolean("Nsou" + suffix, true);
        boolean isVibrate = sp.getBoolean("vibDev" + suffix, true);

        // 1. Day & Night Shift Mode Rules
        // nightStart (hour, default 23), nightEnd (hour, default 7)
        // 0 = Sound & Vibrate ("צליל ורטט"), 1 = Vibrate only ("רטט"), 2 = Silent ("שקט")
        int nightStart = sp.getInt("nightStart", 23);
        int nightEnd = sp.getInt("nightEnd", 7);
        java.util.Calendar cal = java.util.Calendar.getInstance();
        int currentHour = cal.get(java.util.Calendar.HOUR_OF_DAY);
        boolean isNight;
        if (nightStart > nightEnd) {
            isNight = (currentHour >= nightStart || currentHour < nightEnd);
        } else if (nightStart < nightEnd) {
            isNight = (currentHour >= nightStart && currentHour < nightEnd);
        } else {
            isNight = false;
        }

        int shiftMode = isNight ? sp.getInt("sleepNight", 0) : sp.getInt("sleepDay", 0);
        if (shiftMode == 1) {
            isSoundEnabled = false;
        } else if (shiftMode == 2) {
            isSoundEnabled = false;
            isVibrate = false;
        }

        // 2. Device Status Rules (stat & statVib)
        AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        if (audioManager != null) {
            int ringerMode = audioManager.getRingerMode();
            // stat: "התראה תצפצף רק כאשר המכשיר לא במצב רטט/שקט"
            if (sp.getBoolean("stat", false)) {
                if (ringerMode == AudioManager.RINGER_MODE_SILENT || ringerMode == AudioManager.RINGER_MODE_VIBRATE) {
                    isSoundEnabled = false;
                }
            }
            // statVib: "התראה תרטוט רק כאשר המכשיר לא במצב שקט"
            if (sp.getBoolean("statVib", false)) {
                if (ringerMode == AudioManager.RINGER_MODE_SILENT) {
                    isVibrate = false;
                }
            }
        }

        // Determine sound URI
        String soundUriStr = sp.getString("NuRi" + suffix, null);
        if (soundUriStr == null || soundUriStr.isEmpty()) {
            soundUriStr = sp.getString("NuRi", null);
        }
        Uri soundUri = null;
        if (soundUriStr != null && !soundUriStr.isEmpty()) {
            try {
                soundUri = Uri.parse(soundUriStr);
            } catch (Exception ignored) {
            }
        }
        if (soundUri == null) {
            soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        }

        // Notification Channel for Android 8.0+
        String channelId = "alerts_channel_" + (callT != 0 ? callT : "default");
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            if (nm != null && nm.getNotificationChannel(channelId) == null) {
                NotificationChannel channel = new NotificationChannel(channelId, orgTitle, NotificationManager.IMPORTANCE_HIGH);
                channel.setDescription("התראות מקרים ודיווחים");
                channel.enableVibration(true);
                channel.enableLights(true);
                AudioAttributes audioAttributes = new AudioAttributes.Builder()
                        .setUsage(AudioAttributes.USAGE_NOTIFICATION_EVENT)
                        .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                        .build();
                channel.setSound(soundUri, audioAttributes);
                nm.createNotificationChannel(channel);
            }
        }

        // Build Intent for Activity
        Intent resIntent = new Intent(context, smsRes.class);
        resIntent.putExtras(intent);
        resIntent.putExtra("org_title", orgTitle);
        resIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK 
                | Intent.FLAG_ACTIVITY_CLEAR_TOP 
                | Intent.FLAG_ACTIVITY_SINGLE_TOP 
                | Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        smsRes.alerT(l);
        smsRes.newC(orgTitle);

        boolean notEnabled = sp.getBoolean("not", true);
        boolean rideEnabled = sp.getBoolean("ride", false);
        int targetNotifId = rideEnabled ? 1001 : NOTIF_ID++;

        PendingIntent ourAppPendingIntent = PendingIntent.getActivity(
                context,
                targetNotifId,
                resIntent,
                PendingIntent.FLAG_UPDATE_CURRENT | (Build.VERSION.SDK_INT >= 23 ? PendingIntent.FLAG_IMMUTABLE : 0)
        );

        String contentBody = address != null && !address.isEmpty() ? address : (sms != null ? sms : "התקבלה קריאה חדשה");
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, channelId)
                .setSmallIcon(R.drawable.ic_noti)
                .setContentTitle(orgTitle)
                .setContentText(contentBody)
                .setContentIntent(ourAppPendingIntent)
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setCategory(NotificationCompat.CATEGORY_ALARM)
                .setAutoCancel(true);

        boolean winEnabled = sp.getBoolean("win", true);
        if (winEnabled) {
            builder.setFullScreenIntent(ourAppPendingIntent, true);
        }

        if (isSoundEnabled && soundUri != null) {
            builder.setSound(soundUri);
        }

        long[] vibPattern = {0, 500, 200, 500, 200, 500};
        if (isVibrate) {
            builder.setVibrate(vibPattern);
        }

        if (notEnabled) {
            try {
                if (rideEnabled) {
                    NotificationManagerCompat.from(context).cancelAll();
                }
                NotificationManagerCompat.from(context).notify(targetNotifId, builder.build());
            } catch (Exception e) {
                Crashlytics.logException(e);
            }
        }

        // Wake up screen and CPU immediately
        try {
            android.os.PowerManager pm = (android.os.PowerManager) context.getSystemService(Context.POWER_SERVICE);
            if (pm != null) {
                android.os.PowerManager.WakeLock wakeLock = pm.newWakeLock(
                        android.os.PowerManager.FULL_WAKE_LOCK |
                        android.os.PowerManager.ACQUIRE_CAUSES_WAKEUP |
                        android.os.PowerManager.ON_AFTER_RELEASE,
                        "NotiForward:EmergencyWakeLock"
                );
                wakeLock.acquire(10000L); // 10 seconds
            }
        } catch (Exception ignored) {
        }

        // Launch full-screen alert if enabled
        if (winEnabled) {
            try {
                context.startActivity(resIntent);
            } catch (Exception e) {
                Crashlytics.logException(e);
            }
        }
    }
}
