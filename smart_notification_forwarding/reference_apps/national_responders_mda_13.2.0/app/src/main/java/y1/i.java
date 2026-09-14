package y1;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: e, reason: collision with root package name */
    private static i f15859e;

    /* renamed from: a, reason: collision with root package name */
    private final Context f15860a;

    /* renamed from: b, reason: collision with root package name */
    private final ScheduledExecutorService f15861b;

    /* renamed from: c, reason: collision with root package name */
    private j f15862c = new j(this);

    /* renamed from: d, reason: collision with root package name */
    private int f15863d = 1;

    private i(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f15861b = scheduledExecutorService;
        this.f15860a = context.getApplicationContext();
    }

    private final synchronized int a() {
        int i10;
        i10 = this.f15863d;
        this.f15863d = i10 + 1;
        return i10;
    }

    public static synchronized i c(Context context) {
        i iVar;
        synchronized (i.class) {
            if (f15859e == null) {
                f15859e = new i(context, n2.a.a().b(1, new h2.b("MessengerIpcClient"), n2.f.f12177b));
            }
            iVar = f15859e;
        }
        return iVar;
    }

    private final synchronized <T> z2.l<T> e(u<T> uVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(uVar);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 9);
            sb2.append("Queueing ");
            sb2.append(valueOf);
        }
        if (!this.f15862c.e(uVar)) {
            j jVar = new j(this);
            this.f15862c = jVar;
            jVar.e(uVar);
        }
        return uVar.f15881b.a();
    }

    public final z2.l<Void> d(int i10, Bundle bundle) {
        return e(new r(a(), 2, bundle));
    }

    public final z2.l<Bundle> g(int i10, Bundle bundle) {
        return e(new w(a(), 1, bundle));
    }
}
