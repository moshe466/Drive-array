package q2;

import com.google.android.gms.common.api.internal.l;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p implements com.google.android.gms.common.api.internal.r, h0 {

    /* renamed from: a, reason: collision with root package name */
    private final o f13523a;

    /* renamed from: b, reason: collision with root package name */
    private com.google.android.gms.common.api.internal.l f13524b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f13525c = true;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ q f13526d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(q qVar, com.google.android.gms.common.api.internal.l lVar, o oVar) {
        this.f13526d = qVar;
        this.f13524b = lVar;
        this.f13523a = oVar;
    }

    @Override // q2.h0
    public final void a() {
        l.a<?> b10;
        synchronized (this) {
            this.f13525c = false;
            b10 = this.f13524b.b();
        }
        if (b10 != null) {
            this.f13526d.m(b10, 2441);
        }
    }

    @Override // q2.h0
    public final synchronized void b(com.google.android.gms.common.api.internal.l lVar) {
        com.google.android.gms.common.api.internal.l lVar2 = this.f13524b;
        if (lVar2 != lVar) {
            lVar2.a();
            this.f13524b = lVar;
        }
    }

    @Override // com.google.android.gms.common.api.internal.r
    public final /* bridge */ /* synthetic */ void c(Object obj, Object obj2) {
        l.a b10;
        boolean z10;
        n0 n0Var = (n0) obj;
        z2.m mVar = (z2.m) obj2;
        synchronized (this) {
            b10 = this.f13524b.b();
            z10 = this.f13525c;
            this.f13524b.a();
        }
        if (b10 == null) {
            mVar.c(Boolean.FALSE);
        } else {
            this.f13523a.a(n0Var, b10, z10, mVar);
        }
    }

    @Override // q2.h0
    public final synchronized com.google.android.gms.common.api.internal.l zza() {
        return this.f13524b;
    }
}
