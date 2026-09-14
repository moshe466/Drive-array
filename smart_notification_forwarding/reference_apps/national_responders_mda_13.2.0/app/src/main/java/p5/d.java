package p5;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import androidx.core.app.k;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.gson.t;
import com.groboot.mdaemergency.MdaEmergencyApplication;
import com.groboot.mdaemergency.async.b;
import com.groboot.mdaemergency.enums.h;
import com.groboot.mdaemergency.enums.i;
import com.groboot.mdaemergency.enums.k;
import com.groboot.mdaemergency.enums.l;
import com.groboot.mdaemergency.models.AppUser;
import com.groboot.mdaemergency.models.FcmMessageData;
import com.groboot.mdaemergency.models.NotificationData;
import com.groboot.mdaemergency.models.Settings;
import com.groboot.mdaemergency.services.IncidentFloatViewService;
import com.groboot.mdaemergency.services.MessageFloatViewService;
import com.groboot.mdaemergency.ui.LockPatternActivity;
import com.groboot.mdaemergency.ui.main.SplashActivity;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import w6.c0;
import w6.d0;
import w6.g;
import w6.l0;
import w6.m;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static String f13065a = "Message";

    /* renamed from: b, reason: collision with root package name */
    public static String f13066b = "Title";

    /* renamed from: c, reason: collision with root package name */
    public static String f13067c = "S";

    /* renamed from: d, reason: collision with root package name */
    private static String f13068d = "D";

    /* renamed from: e, reason: collision with root package name */
    public static String f13069e = "Id";

    /* renamed from: f, reason: collision with root package name */
    public static String f13070f = "Type";

    /* renamed from: g, reason: collision with root package name */
    public static String f13071g = "fcm_Message_data";

    /* renamed from: h, reason: collision with root package name */
    public static String f13072h = "PTTSounds";

    /* renamed from: i, reason: collision with root package name */
    private static String f13073i = "JobDescription";

    /* renamed from: l, reason: collision with root package name */
    private static String f13076l;

    /* renamed from: n, reason: collision with root package name */
    public static MediaPlayer f13078n;

    /* renamed from: o, reason: collision with root package name */
    static Timer f13079o;

    /* renamed from: j, reason: collision with root package name */
    public static String f13074j = "[FcmManager]";

    /* renamed from: k, reason: collision with root package name */
    public static String f13075k = "AIzaSyAMn5Soa7OMIDdQq77KgAMamCoTFpSBalw";

    /* renamed from: m, reason: collision with root package name */
    private static int f13077m = 0;

    /* renamed from: p, reason: collision with root package name */
    private static Map<String, Boolean> f13080p = new HashMap();

    /* renamed from: q, reason: collision with root package name */
    private static o5.f f13081q = new o5.f();

    /* renamed from: r, reason: collision with root package name */
    static BroadcastReceiver f13082r = new c();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            d.f13078n.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f13083f;

        b(Context context) {
            this.f13083f = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f13083f.sendBroadcast(new Intent("com.groboot.mdaemergency.gcm.reseivedMessage"));
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes.dex */
    class c extends BroadcastReceiver {
        c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            d.f13078n.stop();
            context.unregisterReceiver(d.f13082r);
            Timer timer = d.f13079o;
            if (timer != null) {
                timer.cancel();
                d.f13079o = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: p5.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0269d extends e5.a<FcmMessageData> {
        C0269d() {
        }
    }

    /* loaded from: classes.dex */
    class e implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ f f13084f;

        e(f fVar) {
            this.f13084f = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = d.f13076l;
            if (str != null && str.length() > 0) {
                this.f13084f.a(str);
                return;
            }
            if (m.k() != null) {
                str = m.k().getPushID();
            }
            if (str != null) {
                this.f13084f.a(d.j());
            } else {
                this.f13084f.a(d.j());
            }
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(String str);
    }

    /* loaded from: classes.dex */
    private static class g implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        private Context f13085f;

        /* renamed from: g, reason: collision with root package name */
        private String f13086g;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a implements b.InterfaceC0098b {
            a() {
            }

            @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
            public void a(b.a aVar) {
                if (aVar == null) {
                    return;
                }
                String str = d.f13074j;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("send token: ");
                sb2.append(aVar.f7614b);
                sb2.append(", error:");
                sb2.append(aVar.f7617e);
            }
        }

        private g(Context context, String str) {
            this.f13085f = context;
            this.f13086g = str;
        }

        /* synthetic */ g(Context context, String str, a aVar) {
            this(context, str);
        }

        private static b.InterfaceC0098b a() {
            return new a();
        }

        @Override // java.lang.Runnable
        public void run() {
            d0.a(5000L);
            com.groboot.mdaemergency.async.d.w(this.f13085f).n0(this.f13086g, a());
        }
    }

    private static Uri c(Context context, int i10) {
        if (i10 == 0) {
            return Settings.System.DEFAULT_NOTIFICATION_URI;
        }
        return Uri.parse("android.resource://" + context.getPackageName() + "/" + i10);
    }

    private static w6.g d(FcmMessageData fcmMessageData) {
        int g10 = g(fcmMessageData.getMessageType());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("settingsVal:");
        sb2.append(g10);
        if (g10 <= g.d.Silence.getLevelValue()) {
            return null;
        }
        w6.g gVar = new w6.g(l0.v(), g.c.Notification, g.d.getByInt(g10));
        if (fcmMessageData.isTTS()) {
            gVar.d();
            return gVar;
        }
        gVar.c((int) TimeUnit.SECONDS.toMillis(5L));
        return gVar;
    }

    private static void e(final Context context, final Map map, boolean z10) {
        final String str = (String) map.get(f13069e);
        Boolean bool = f13080p.get(str);
        if (bool == null || !bool.booleanValue()) {
            if (!z10) {
                new Thread(new Runnable() { // from class: p5.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.m(str, context, map);
                    }
                }).start();
            }
            f13080p.put(str, Boolean.valueOf(z10));
        }
    }

    private static String f(Context context) {
        ApplicationInfo applicationInfo;
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
        } catch (Exception unused) {
            applicationInfo = null;
        }
        return (String) (applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo) : "");
    }

    private static int g(com.groboot.mdaemergency.enums.g gVar) {
        int levelValue = g.d.NONE.getLevelValue() - 1;
        if (gVar == com.groboot.mdaemergency.enums.g.Conan) {
            levelValue = l0.U(m.g());
        }
        return gVar == com.groboot.mdaemergency.enums.g.Team ? l0.U(m.h()) : levelValue;
    }

    public static Uri h(Context context, FcmMessageData fcmMessageData) {
        l lVar;
        if (com.groboot.mdaemergency.enums.f.getById(fcmMessageData.Type) == com.groboot.mdaemergency.enums.f.whatApp) {
            lVar = l.Message;
        } else {
            Settings.AlertSound alertSound = m.J().alertSounds.get(Integer.valueOf(fcmMessageData.SoundType));
            if (alertSound != null) {
                boolean z10 = k.getByKey(alertSound.settingVibrate) == k.withoutVibrate || k.getByKey(alertSound.settingVibrate) != k.onlyVibrate;
                i.getByKey(alertSound.settingSound);
                i iVar = i.continual;
                if (!(g(fcmMessageData.getMessageType()) != g.d.Silence.getLevelValue() ? z10 : false) || (lVar = alertSound.sound) == l.No_Sound) {
                    return null;
                }
            } else {
                lVar = com.groboot.mdaemergency.models.Settings.defaultSound;
            }
        }
        return c(context, lVar.getSoundId());
    }

    public static void i(Context context, f fVar) {
        new Thread(new e(fVar)).start();
    }

    public static String j() {
        return FirebaseInstanceId.i().n();
    }

    private static int k() {
        Calendar calendar = Calendar.getInstance();
        int i10 = (calendar.get(10) * 10000) + (calendar.get(12) * 100) + calendar.get(13);
        int i11 = f13077m;
        f13077m = i11 + 1;
        return i10 + i11;
    }

    public static void l(Context context) {
        FirebaseMessaging.d().k(true);
        com.google.android.gms.common.b.p().i(context);
        new p5.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void m(String str, Context context, Map map) {
        d0.a(TimeUnit.SECONDS.toMillis(5L));
        if (f13080p.get(str) == null || !f13080p.get(str).booleanValue()) {
            f13080p.put(str, Boolean.TRUE);
            q(context, map, true, false);
        }
    }

    public static void n(Context context, Map map, boolean z10) {
        q(context, map, z10, true);
        e(context, map, z10);
    }

    public static void o(Context context, NotificationData notificationData) {
        String str = notificationData.message;
        String str2 = notificationData.title;
        FcmMessageData fcmMessageData = notificationData.messageData;
        p(context, str, str2, fcmMessageData, fcmMessageData.Id);
    }

    private static void p(Context context, String str, String str2, FcmMessageData fcmMessageData, String str3) {
        boolean z10;
        if (str == null || str.isEmpty() || fcmMessageData == null) {
            return;
        }
        String string = context.getString(m.l());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("");
        if (str3 == null) {
            str3 = "";
        }
        if (str3.length() > 12) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("GSM Manager ");
            sb3.append(str);
            sb3.append("       id:");
            sb3.append(l0.o(str3, 12));
        }
        if (str2 == null) {
            str2 = f(context);
        }
        Intent intent = new Intent(context, (Class<?>) SplashActivity.class);
        intent.putExtra(f13069e, str3);
        int i10 = fcmMessageData.Type;
        if (i10 != -1) {
            intent.putExtra(f13070f, i10);
            intent.putExtra(f13071g, new com.google.gson.e().r(new NotificationData(str, str2, fcmMessageData)));
        }
        intent.addFlags(67108864);
        int k10 = k();
        int i11 = Build.VERSION.SDK_INT;
        k.e t10 = new k.e(context, v5.a.f14663c).w(m.j()).z(str2).k(str2).j(str).f(true).C(System.currentTimeMillis()).i(PendingIntent.getActivity(context, k10, intent, i11 >= 23 ? 1140850688 : 1073741824)).t(1);
        if (i11 >= 16) {
            t10.y(new k.c().h(str));
        }
        Settings.AlertSound alertSound = m.J().alertSounds.get(Integer.valueOf(fcmMessageData.SoundType));
        boolean z11 = false;
        if (alertSound != null) {
            z10 = com.groboot.mdaemergency.enums.k.getByKey(alertSound.settingVibrate) != com.groboot.mdaemergency.enums.k.withoutVibrate;
            if (i.getByKey(alertSound.settingSound) != i.continual) {
                z11 = true;
            }
        } else {
            z11 = true;
            z10 = true;
        }
        Uri h10 = h(context, fcmMessageData);
        if (h10 != null) {
            t10.x(h10);
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        Notification b10 = t10.b();
        if (!z11 && !MdaEmergencyApplication.c()) {
            b10.flags = 4;
        }
        if (z10) {
            b10.vibrate = new long[]{0, 500, 200, 500, 200, 750};
        }
        if (i11 >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(v5.a.f14663c, string, 4);
            notificationChannel.setDescription(context.getString(m.l()));
            if (z10) {
                notificationChannel.setVibrationPattern(new long[]{0, 500, 200, 500, 200, 750});
            } else {
                notificationManager.deleteNotificationChannel(v5.a.f14663c);
            }
            AudioAttributes.Builder builder = new AudioAttributes.Builder();
            builder.setContentType(4);
            builder.setUsage(5);
            new AudioAttributes.Builder().setUsage(5).setContentType(4).build();
            if (h10 != null) {
                notificationChannel.setSound(null, null);
                try {
                    MediaPlayer mediaPlayer = new MediaPlayer();
                    f13078n = mediaPlayer;
                    mediaPlayer.setDataSource(context, h10);
                    if (((AudioManager) context.getSystemService("audio")).getStreamVolume(5) != 0) {
                        f13078n.setAudioStreamType(5);
                        if (!z11 && !MdaEmergencyApplication.c()) {
                            f13078n.setLooping(true);
                            Timer timer = new Timer("timerContinueSound", true);
                            f13079o = timer;
                            timer.schedule(new a(), TimeUnit.MINUTES.toMillis(1L));
                        }
                        f13078n.prepare();
                        f13078n.start();
                        context.registerReceiver(f13082r, new IntentFilter("appOpen"));
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
        notificationManager.notify(k10, b10);
        new Thread(new b(context)).start();
    }

    private static void q(Context context, Map map, boolean z10, boolean z11) {
        String str = (String) map.get(f13065a);
        String str2 = (String) map.get(f13066b);
        String str3 = (String) map.get(f13067c);
        p5.e.a().c((String) map.get(f13073i));
        if (str == null && str2 == null && str3 == null) {
            return;
        }
        FcmMessageData fcmMessageData = null;
        String str4 = (String) map.get(f13068d);
        if (str4 == null || str4.isEmpty() || !w6.i.a(str4)) {
            fcmMessageData = new FcmMessageData(str4);
        } else {
            try {
                fcmMessageData = (FcmMessageData) new com.google.gson.e().j(str4, new C0269d().e());
            } catch (t e10) {
                e10.printStackTrace();
            }
        }
        if (fcmMessageData == null) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("NotificationMode: ");
        sb2.append(fcmMessageData.NotificationMode);
        h hVar = fcmMessageData.NotificationMode;
        if (hVar == h.External || fcmMessageData.ExternalNotification) {
            if (z11 && com.groboot.mdaemergency.a.k(context)) {
                LockPatternActivity.B();
                com.groboot.mdaemergency.alwaysOn.e.EXTERNAL_MESSAGE.setObjectAny(fcmMessageData.Id);
                boolean z12 = fcmMessageData.AddToStack;
                String str5 = fcmMessageData.Id;
                if (z12) {
                    MessageFloatViewService.k(context, str5, z12);
                } else {
                    IncidentFloatViewService.k(context, str5, z12);
                }
            }
        } else if (hVar == h.Silence || (hVar == h.SilenceInFront && MdaEmergencyApplication.c())) {
            f13081q.a(context, new NotificationData(str, str2, fcmMessageData));
            return;
        }
        w6.g d10 = d(fcmMessageData);
        if (z10) {
            p(context, str, str2, fcmMessageData, fcmMessageData.Id);
        }
        if (fcmMessageData.isTTS()) {
            c0.f(context, fcmMessageData.TextToSpeech, str3, d10);
        }
    }

    public static void r(Context context, String str) {
        f13076l = str;
        AppUser k10 = m.k();
        if (k10 != null) {
            k10.setPushID(str);
            m.U(k10);
            new Thread(new g(context, str, null)).start();
        }
    }
}
