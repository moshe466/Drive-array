package v2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import b2.p;
import com.google.android.gms.measurement.internal.r3;
import com.google.android.gms.measurement.internal.t4;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final f f14622a;

    public e(f fVar) {
        p.k(fVar);
        this.f14622a = fVar;
    }

    public static boolean b(Context context) {
        ActivityInfo receiverInfo;
        p.k(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) != null) {
                if (receiverInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public final void a(Context context, Intent intent) {
        r3 h10 = t4.b(context, null, null).h();
        if (intent == null) {
            h10.I().a("Receiver called with null intent");
            return;
        }
        String action = intent.getAction();
        h10.N().b("Local receiver got", action);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(action)) {
            if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
                h10.I().a("Install Referrer Broadcasts are deprecated");
            }
        } else {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            h10.N().a("Starting wakeful intent.");
            this.f14622a.a(context, className);
        }
    }
}
