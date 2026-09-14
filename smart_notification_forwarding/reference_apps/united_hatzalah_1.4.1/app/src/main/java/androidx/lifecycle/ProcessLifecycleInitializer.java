package androidx.lifecycle;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import java.util.List;
import n0.C0592a;
import n0.InterfaceC0593b;
import t2.C0716r;

/* loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements InterfaceC0593b {
    @Override // n0.InterfaceC0593b
    public final Object a(Context context) {
        kotlin.jvm.internal.j.e(context, "context");
        C0592a c4 = C0592a.c(context);
        kotlin.jvm.internal.j.d(c4, "getInstance(context)");
        if (c4.f5882b.contains(ProcessLifecycleInitializer.class)) {
            if (!AbstractC0307q.f3613a.getAndSet(true)) {
                Context applicationContext = context.getApplicationContext();
                kotlin.jvm.internal.j.c(applicationContext, "null cannot be cast to non-null type android.app.Application");
                ((Application) applicationContext).registerActivityLifecycleCallbacks(new C0306p());
            }
            G g3 = G.f3549l;
            g3.getClass();
            g3.f3554e = new Handler();
            g3.f3555f.e(EnumC0303m.ON_CREATE);
            Context applicationContext2 = context.getApplicationContext();
            kotlin.jvm.internal.j.c(applicationContext2, "null cannot be cast to non-null type android.app.Application");
            ((Application) applicationContext2).registerActivityLifecycleCallbacks(new F(g3));
            return g3;
        }
        throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml");
    }

    @Override // n0.InterfaceC0593b
    public final List dependencies() {
        return C0716r.f6476a;
    }
}
