package androidx.lifecycle;

import androidx.lifecycle.a;
import androidx.lifecycle.h;

/* JADX INFO: Access modifiers changed from: package-private */
@Deprecated
/* loaded from: classes.dex */
public class ReflectiveGenericLifecycleObserver implements j {

    /* renamed from: a, reason: collision with root package name */
    private final Object f3179a;

    /* renamed from: b, reason: collision with root package name */
    private final a.C0050a f3180b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.f3179a = obj;
        this.f3180b = a.f3186c.c(obj.getClass());
    }

    @Override // androidx.lifecycle.j
    public void d(l lVar, h.b bVar) {
        this.f3180b.a(lVar, bVar, this.f3179a);
    }
}
