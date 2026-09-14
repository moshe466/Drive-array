package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
final class p2 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ a2.j f4954f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ s2 f4955g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p2(s2 s2Var, a2.j jVar) {
        this.f4955g = s2Var;
        this.f4954f = jVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WeakReference weakReference;
        a2.m mVar;
        q2 unused;
        q2 unused2;
        q2 unused3;
        q2 unused4;
        try {
            try {
                BasePendingResult.f4756o.set(Boolean.TRUE);
                mVar = this.f4955g.f4979a;
                ((a2.m) b2.p.k(mVar)).b(this.f4954f);
                s2 s2Var = this.f4955g;
                unused = s2Var.f4985g;
                unused2 = s2Var.f4985g;
                throw null;
            } catch (RuntimeException unused5) {
                s2 s2Var2 = this.f4955g;
                unused3 = s2Var2.f4985g;
                unused4 = s2Var2.f4985g;
                throw null;
            }
        } catch (Throwable th) {
            BasePendingResult.f4756o.set(Boolean.FALSE);
            s2 s2Var3 = this.f4955g;
            s2.j(this.f4954f);
            weakReference = this.f4955g.f4984f;
            a2.f fVar = (a2.f) weakReference.get();
            if (fVar != null) {
                fVar.k(this.f4955g);
            }
            throw th;
        }
    }
}
