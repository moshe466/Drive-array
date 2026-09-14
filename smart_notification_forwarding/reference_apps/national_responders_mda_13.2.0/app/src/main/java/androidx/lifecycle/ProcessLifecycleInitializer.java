package androidx.lifecycle;

import android.content.Context;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements q0.a<l> {
    @Override // q0.a
    public List<Class<? extends q0.a<?>>> a() {
        return Collections.emptyList();
    }

    @Override // q0.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public l b(Context context) {
        if (!androidx.startup.a.e(context).g(ProcessLifecycleInitializer.class)) {
            throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily. \nPlease ensure that you have: \n<meta-data\n    android:name='androidx.lifecycle.ProcessLifecycleInitializer' \n    android:value='androidx.startup' /> \nunder InitializationProvider in your AndroidManifest.xml");
        }
        i.a(context);
        t.l(context);
        return t.k();
    }
}
