package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.bc;
import com.google.android.gms.internal.measurement.nd;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

/* loaded from: classes.dex */
public final class y4 extends v2.d {

    /* renamed from: a, reason: collision with root package name */
    private final e9 f6633a;

    /* renamed from: b, reason: collision with root package name */
    private Boolean f6634b;

    /* renamed from: c, reason: collision with root package name */
    private String f6635c;

    public y4(e9 e9Var) {
        this(e9Var, null);
    }

    private y4(e9 e9Var, String str) {
        b2.p.k(e9Var);
        this.f6633a = e9Var;
        this.f6635c = null;
    }

    private final void x0(String str, boolean z10) {
        boolean z11;
        if (TextUtils.isEmpty(str)) {
            this.f6633a.h().F().a("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        if (z10) {
            try {
                if (this.f6634b == null) {
                    if (!"com.google.android.gms".equals(this.f6635c) && !g2.o.a(this.f6633a.i(), Binder.getCallingUid()) && !com.google.android.gms.common.f.a(this.f6633a.i()).c(Binder.getCallingUid())) {
                        z11 = false;
                        this.f6634b = Boolean.valueOf(z11);
                    }
                    z11 = true;
                    this.f6634b = Boolean.valueOf(z11);
                }
                if (this.f6634b.booleanValue()) {
                    return;
                }
            } catch (SecurityException e10) {
                this.f6633a.h().F().b("Measurement Service called with invalid calling package. appId", r3.x(str));
                throw e10;
            }
        }
        if (this.f6635c == null && com.google.android.gms.common.e.k(this.f6633a.i(), Binder.getCallingUid(), str)) {
            this.f6635c = str;
        }
        if (str.equals(this.f6635c)) {
        } else {
            throw new SecurityException(String.format("Unknown calling package name '%s'.", str));
        }
    }

    private final void z(Runnable runnable) {
        b2.p.k(runnable);
        if (this.f6633a.e().I()) {
            runnable.run();
        } else {
            this.f6633a.e().z(runnable);
        }
    }

    private final void z0(v9 v9Var, boolean z10) {
        b2.p.k(v9Var);
        x0(v9Var.f6560f, false);
        this.f6633a.h0().j0(v9Var.f6561g, v9Var.f6577w, v9Var.A);
    }

    @Override // v2.c
    public final void I(v9 v9Var) {
        z0(v9Var, false);
        z(new b5(this, v9Var));
    }

    @Override // v2.c
    public final void J(q qVar, String str, String str2) {
        b2.p.k(qVar);
        b2.p.g(str);
        x0(str, true);
        z(new l5(this, qVar, str));
    }

    @Override // v2.c
    public final List<n9> K(String str, String str2, String str3, boolean z10) {
        x0(str, true);
        try {
            List<p9> list = (List) this.f6633a.e().w(new f5(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (p9 p9Var : list) {
                if (z10 || !o9.C0(p9Var.f6330c)) {
                    arrayList.add(new n9(p9Var));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e10) {
            this.f6633a.h().F().c("Failed to get user properties as. appId", r3.x(str), e10);
            return Collections.emptyList();
        }
    }

    @Override // v2.c
    public final void V(q qVar, v9 v9Var) {
        b2.p.k(qVar);
        z0(v9Var, false);
        z(new i5(this, qVar, v9Var));
    }

    @Override // v2.c
    public final String W(v9 v9Var) {
        z0(v9Var, false);
        return this.f6633a.Z(v9Var);
    }

    @Override // v2.c
    public final void Y(final Bundle bundle, final v9 v9Var) {
        if (nd.a() && this.f6633a.L().t(s.A0)) {
            z0(v9Var, false);
            z(new Runnable(this, v9Var, bundle) { // from class: com.google.android.gms.measurement.internal.x4

                /* renamed from: f, reason: collision with root package name */
                private final y4 f6614f;

                /* renamed from: g, reason: collision with root package name */
                private final v9 f6615g;

                /* renamed from: h, reason: collision with root package name */
                private final Bundle f6616h;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f6614f = this;
                    this.f6615g = v9Var;
                    this.f6616h = bundle;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f6614f.p(this.f6615g, this.f6616h);
                }
            });
        }
    }

    @Override // v2.c
    public final void e0(long j10, String str, String str2, String str3) {
        z(new o5(this, str2, str3, str, j10));
    }

    @Override // v2.c
    public final void g0(n9 n9Var, v9 v9Var) {
        b2.p.k(n9Var);
        z0(v9Var, false);
        z(new n5(this, n9Var, v9Var));
    }

    @Override // v2.c
    public final void i0(v9 v9Var) {
        x0(v9Var.f6560f, false);
        z(new g5(this, v9Var));
    }

    @Override // v2.c
    public final List<ha> j0(String str, String str2, String str3) {
        x0(str, true);
        try {
            return (List) this.f6633a.e().w(new h5(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e10) {
            this.f6633a.h().F().b("Failed to get conditional user properties as", e10);
            return Collections.emptyList();
        }
    }

    @Override // v2.c
    public final void l0(ha haVar, v9 v9Var) {
        b2.p.k(haVar);
        b2.p.k(haVar.f6093h);
        z0(v9Var, false);
        ha haVar2 = new ha(haVar);
        haVar2.f6091f = v9Var.f6560f;
        z(new a5(this, haVar2, v9Var));
    }

    @Override // v2.c
    public final List<ha> m0(String str, String str2, v9 v9Var) {
        z0(v9Var, false);
        try {
            return (List) this.f6633a.e().w(new e5(this, v9Var, str, str2)).get();
        } catch (InterruptedException | ExecutionException e10) {
            this.f6633a.h().F().b("Failed to get conditional user properties", e10);
            return Collections.emptyList();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void p(v9 v9Var, Bundle bundle) {
        this.f6633a.a0().a0(v9Var.f6560f, bundle);
    }

    @Override // v2.c
    public final List<n9> r(String str, String str2, boolean z10, v9 v9Var) {
        z0(v9Var, false);
        try {
            List<p9> list = (List) this.f6633a.e().w(new c5(this, v9Var, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (p9 p9Var : list) {
                if (z10 || !o9.C0(p9Var.f6330c)) {
                    arrayList.add(new n9(p9Var));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e10) {
            this.f6633a.h().F().c("Failed to query user properties. appId", r3.x(v9Var.f6560f), e10);
            return Collections.emptyList();
        }
    }

    @Override // v2.c
    public final void r0(ha haVar) {
        b2.p.k(haVar);
        b2.p.k(haVar.f6093h);
        x0(haVar.f6091f, true);
        z(new d5(this, new ha(haVar)));
    }

    @Override // v2.c
    public final List<n9> s(v9 v9Var, boolean z10) {
        z0(v9Var, false);
        try {
            List<p9> list = (List) this.f6633a.e().w(new m5(this, v9Var)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (p9 p9Var : list) {
                if (z10 || !o9.C0(p9Var.f6330c)) {
                    arrayList.add(new n9(p9Var));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e10) {
            this.f6633a.h().F().c("Failed to get user properties. appId", r3.x(v9Var.f6560f), e10);
            return null;
        }
    }

    @Override // v2.c
    public final void t(v9 v9Var) {
        z0(v9Var, false);
        z(new p5(this, v9Var));
    }

    @Override // v2.c
    public final byte[] v(q qVar, String str) {
        b2.p.g(str);
        b2.p.k(qVar);
        x0(str, true);
        this.f6633a.h().M().b("Log and bundle. event", this.f6633a.g0().w(qVar.f6333f));
        long c10 = this.f6633a.f().c() / 1000000;
        try {
            byte[] bArr = (byte[]) this.f6633a.e().B(new k5(this, qVar, str)).get();
            if (bArr == null) {
                this.f6633a.h().F().b("Log and bundle returned null. appId", r3.x(str));
                bArr = new byte[0];
            }
            this.f6633a.h().M().d("Log and bundle processed. event, size, time_ms", this.f6633a.g0().w(qVar.f6333f), Integer.valueOf(bArr.length), Long.valueOf((this.f6633a.f().c() / 1000000) - c10));
            return bArr;
        } catch (InterruptedException | ExecutionException e10) {
            this.f6633a.h().F().d("Failed to log and bundle. appId, event, error", r3.x(str), this.f6633a.g0().w(qVar.f6333f), e10);
            return null;
        }
    }

    @Override // v2.c
    public final void x(v9 v9Var) {
        if (bc.a() && this.f6633a.L().t(s.J0)) {
            b2.p.g(v9Var.f6560f);
            b2.p.k(v9Var.B);
            j5 j5Var = new j5(this, v9Var);
            b2.p.k(j5Var);
            if (this.f6633a.e().I()) {
                j5Var.run();
            } else {
                this.f6633a.e().C(j5Var);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final q y0(q qVar, v9 v9Var) {
        p pVar;
        boolean z10 = false;
        if ("_cmp".equals(qVar.f6333f) && (pVar = qVar.f6334g) != null && pVar.g() != 0) {
            String v10 = qVar.f6334g.v("_cis");
            if ("referrer broadcast".equals(v10) || "referrer API".equals(v10)) {
                z10 = true;
            }
        }
        if (!z10) {
            return qVar;
        }
        this.f6633a.h().L().b("Event has been filtered ", qVar.toString());
        return new q("_cmpx", qVar.f6334g, qVar.f6335h, qVar.f6336i);
    }
}
