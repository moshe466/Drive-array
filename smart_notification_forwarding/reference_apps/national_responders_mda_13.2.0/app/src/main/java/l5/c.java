package l5;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.k;
import androidx.core.app.n;
import com.groboot.mdaemergency.ptt.p;
import com.groboot.mdaemergency.ui.main.SplashActivity;
import il.org.mda.health.R;

/* loaded from: classes.dex */
public class c {

    /* renamed from: c, reason: collision with root package name */
    public static int f11787c = 555555;

    /* renamed from: a, reason: collision with root package name */
    private final k.e f11788a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f11789b;

    public c(Context context) {
        this.f11789b = context;
        this.f11788a = new k.e(context, "VLNC").w(R.drawable.icon_notifications).k("נותקת מהמערכת").j("לחץ כדי להתחבר מחדש לאפליקציית הכוננים").t(0);
        a();
        b();
    }

    private void a() {
        if (Build.VERSION.SDK_INT >= 26) {
            ((NotificationManager) this.f11789b.getSystemService(NotificationManager.class)).createNotificationChannel(new NotificationChannel("VLNC", "שונות", 3));
        }
    }

    private void b() {
        Intent intent = new Intent(this.f11789b, (Class<?>) SplashActivity.class);
        intent.setFlags(268435456);
        intent.putExtra(p.f7896v, "Service");
        intent.putExtra(p.f7897w, p.f7899y);
        intent.putExtra(v5.a.f14662b, true);
        this.f11788a.i(PendingIntent.getActivity(this.f11789b, 999, intent, Build.VERSION.SDK_INT >= 23 ? 201326592 : 134217728));
    }

    public void c() {
        n.d(this.f11789b).f(f11787c, this.f11788a.b());
    }
}
