package v5;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.k;
import com.groboot.mdaemergency.enums.b;
import com.groboot.mdaemergency.ptt.p;
import com.groboot.mdaemergency.ui.main.SplashActivity;
import il.org.mda.health.R;
import w6.l0;
import w6.m;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static int f14661a = 198745;

    /* renamed from: b, reason: collision with root package name */
    public static String f14662b = "forceShowLock";

    /* renamed from: c, reason: collision with root package name */
    public static String f14663c = m.l() + "101";

    /* renamed from: d, reason: collision with root package name */
    public static String f14664d = m.l() + ".ptt_service";

    public static Notification a(Context context) {
        String str;
        p.n0();
        int i10 = (!m.t() || m.O() == b.NOT_AVAILABLE) ? R.drawable.icon_0_gray : R.drawable.icon_notifications;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(f14664d, "התראת כונן", 1);
            notificationChannel.setLockscreenVisibility(1);
            notificationChannel.setSound(null, null);
            notificationChannel.setShowBadge(false);
            ((NotificationManager) context.getSystemService("notification")).createNotificationChannel(notificationChannel);
        }
        String str2 = "";
        if (m.O() != null) {
            str = " - " + m.O().getTitle();
            str2 = "סטטוס זמינות " + m.O().getTitle();
        } else {
            str = "";
        }
        if (!l0.l0(r5.b.b().d()) || !l0.l0(r5.b.b().c())) {
            str2 = str2 + "\n";
        }
        if (!l0.l0(r5.b.b().d())) {
            str2 = str2 + "עדכון מיקום אחרון: " + r5.b.b().d() + "\n";
        }
        if (!l0.l0(r5.b.b().c())) {
            str2 = str2 + "מיקום אחרון נשלח: " + r5.b.b().c();
        }
        k.e s10 = new k.e(context, f14664d).w(i10).k(context.getResources().getString(R.string.mada) + str).y(new k.c().h(str2)).v(false).t(2).s(true);
        Intent intent = new Intent(context, (Class<?>) SplashActivity.class);
        intent.setFlags(268435456);
        intent.putExtra(p.f7896v, "Service");
        intent.putExtra(p.f7897w, p.f7899y);
        intent.putExtra(f14662b, true);
        s10.i(PendingIntent.getActivity(context, 999, intent, i11 >= 23 ? 201326592 : 134217728));
        return s10.b();
    }

    public static void b(Context context) {
        Notification a10 = a(context);
        if (a10 != null) {
            ((NotificationManager) context.getSystemService("notification")).notify(f14661a, a10);
        }
    }
}
