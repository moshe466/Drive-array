package E1;

import F0.C0035g2;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final C0035g2 f126a;

    /* renamed from: b, reason: collision with root package name */
    public final IntentFilter f127b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f128c;

    /* renamed from: d, reason: collision with root package name */
    public final HashSet f129d;

    /* renamed from: e, reason: collision with root package name */
    public F1.k f130e;

    public c(Context context) {
        C0035g2 c0035g2 = new C0035g2("AppUpdateListenerRegistry");
        IntentFilter intentFilter = new IntentFilter("com.google.android.play.core.install.ACTION_INSTALL_STATUS");
        this.f129d = new HashSet();
        this.f130e = null;
        this.f126a = c0035g2;
        this.f127b = intentFilter;
        Context applicationContext = context.getApplicationContext();
        this.f128c = applicationContext != null ? applicationContext : context;
    }

    public final void a() {
        F1.k kVar;
        HashSet hashSet = this.f129d;
        boolean isEmpty = hashSet.isEmpty();
        Context context = this.f128c;
        if (!isEmpty && this.f130e == null) {
            F1.k kVar2 = new F1.k(this, 0);
            this.f130e = kVar2;
            int i = Build.VERSION.SDK_INT;
            IntentFilter intentFilter = this.f127b;
            if (i >= 33) {
                context.registerReceiver(kVar2, intentFilter, 2);
            } else {
                context.registerReceiver(kVar2, intentFilter);
            }
        }
        if (hashSet.isEmpty() && (kVar = this.f130e) != null) {
            context.unregisterReceiver(kVar);
            this.f130e = null;
        }
    }
}
