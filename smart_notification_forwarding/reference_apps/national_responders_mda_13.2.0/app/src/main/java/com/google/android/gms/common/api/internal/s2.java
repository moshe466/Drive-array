package com.google.android.gms.common.api.internal;

import a2.j;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class s2<R extends a2.j> extends a2.n<R> implements a2.k<R> {

    /* renamed from: a, reason: collision with root package name */
    private a2.m f4979a;

    /* renamed from: b, reason: collision with root package name */
    private s2 f4980b;

    /* renamed from: c, reason: collision with root package name */
    private volatile a2.l f4981c;

    /* renamed from: d, reason: collision with root package name */
    private final Object f4982d;

    /* renamed from: e, reason: collision with root package name */
    private Status f4983e;

    /* renamed from: f, reason: collision with root package name */
    private final WeakReference f4984f;

    /* renamed from: g, reason: collision with root package name */
    private final q2 f4985g;

    private final void g(Status status) {
        synchronized (this.f4982d) {
            this.f4983e = status;
            h(status);
        }
    }

    private final void h(Status status) {
        synchronized (this.f4982d) {
            a2.m mVar = this.f4979a;
            if (mVar != null) {
                ((s2) b2.p.k(this.f4980b)).g((Status) b2.p.l(mVar.a(status), "onFailure must not return null"));
            } else if (i()) {
                ((a2.l) b2.p.k(this.f4981c)).b(status);
            }
        }
    }

    private final boolean i() {
        return (this.f4981c == null || ((a2.f) this.f4984f.get()) == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(a2.j jVar) {
        if (jVar instanceof a2.h) {
            try {
                ((a2.h) jVar).a();
            } catch (RuntimeException unused) {
                "Unable to release ".concat(String.valueOf(jVar));
            }
        }
    }

    @Override // a2.k
    public final void a(a2.j jVar) {
        synchronized (this.f4982d) {
            if (!jVar.c().t()) {
                g(jVar.c());
                j(jVar);
            } else if (this.f4979a != null) {
                i2.a().submit(new p2(this, jVar));
            } else if (i()) {
                ((a2.l) b2.p.k(this.f4981c)).c(jVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f() {
        this.f4981c = null;
    }
}
