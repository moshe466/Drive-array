package androidx.fragment.app;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: androidx.fragment.app.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0287w extends e.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f3528a;

    public C0287w(AtomicReference atomicReference) {
        this.f3528a = atomicReference;
    }

    @Override // e.c
    public final void a(Object obj) {
        e.c cVar = (e.c) this.f3528a.get();
        if (cVar != null) {
            cVar.a(obj);
            return;
        }
        throw new IllegalStateException("Operation cannot be started before fragment is in created state");
    }
}
