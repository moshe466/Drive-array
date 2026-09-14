package com.google.firebase.remoteconfig;

import com.google.firebase.remoteconfig.internal.ConfigCacheClient;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.j;
import org.apache.tika.pipes.PipesClient;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4347a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4348b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f4349c;

    public /* synthetic */ b(int i, Object obj, Object obj2) {
        this.f4347a = i;
        this.f4348b = obj;
        this.f4349c = obj2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        Void lambda$setCustomSignals$8;
        Void lambda$setConfigSettingsAsync$5;
        int i = this.f4347a;
        Object obj = this.f4349c;
        Object obj2 = this.f4348b;
        switch (i) {
            case 0:
                lambda$setCustomSignals$8 = ((FirebaseRemoteConfig) obj2).lambda$setCustomSignals$8((CustomSignals) obj);
                return lambda$setCustomSignals$8;
            case 1:
                lambda$setConfigSettingsAsync$5 = ((FirebaseRemoteConfig) obj2).lambda$setConfigSettingsAsync$5((FirebaseRemoteConfigSettings) obj);
                return lambda$setConfigSettingsAsync$5;
            case 2:
                return ConfigCacheClient.b((ConfigCacheClient) obj2, (ConfigContainer) obj);
            case 3:
                F2.a block = (F2.a) obj;
                j.e(block, "$block");
                ThreadLocal threadLocal = n1.b.f5885a;
                threadLocal.set(Boolean.TRUE);
                ((AtomicReference) obj2).set(Thread.currentThread());
                try {
                    Object invoke = block.invoke();
                    threadLocal.remove();
                    return invoke;
                } catch (Throwable th) {
                    ThreadLocal threadLocal2 = n1.b.f5885a;
                    n1.b.f5885a.remove();
                    throw th;
                }
            default:
                return PipesClient.a((PipesClient) obj2, (f3.c) obj);
        }
    }
}
