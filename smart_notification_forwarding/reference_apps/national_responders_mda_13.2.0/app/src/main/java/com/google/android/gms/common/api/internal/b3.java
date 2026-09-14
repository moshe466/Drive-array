package com.google.android.gms.common.api.internal;

import a2.f;
import android.util.Log;
import android.util.SparseArray;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public final class b3 extends g3 {

    /* renamed from: k, reason: collision with root package name */
    private final SparseArray f4791k;

    private b3(k kVar) {
        super(kVar, com.google.android.gms.common.b.p());
        this.f4791k = new SparseArray();
        this.f4772f.c("AutoManageHelper", this);
    }

    public static b3 t(j jVar) {
        k d10 = LifecycleCallback.d(jVar);
        b3 b3Var = (b3) d10.i("AutoManageHelper", b3.class);
        return b3Var != null ? b3Var : new b3(d10);
    }

    private final a3 w(int i10) {
        if (this.f4791k.size() <= i10) {
            return null;
        }
        SparseArray sparseArray = this.f4791k;
        return (a3) sparseArray.get(sparseArray.keyAt(i10));
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i10 = 0; i10 < this.f4791k.size(); i10++) {
            a3 w10 = w(i10);
            if (w10 != null) {
                printWriter.append((CharSequence) str).append("GoogleApiClient #").print(w10.f4777a);
                printWriter.println(":");
                w10.f4778b.f(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.g3, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void j() {
        super.j();
        boolean z10 = this.f4862g;
        String valueOf = String.valueOf(this.f4791k);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onStart ");
        sb2.append(z10);
        sb2.append(" ");
        sb2.append(valueOf);
        if (this.f4863h.get() == null) {
            for (int i10 = 0; i10 < this.f4791k.size(); i10++) {
                a3 w10 = w(i10);
                if (w10 != null) {
                    w10.f4778b.d();
                }
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.g3, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void k() {
        super.k();
        for (int i10 = 0; i10 < this.f4791k.size(); i10++) {
            a3 w10 = w(i10);
            if (w10 != null) {
                w10.f4778b.e();
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.g3
    protected final void m(com.google.android.gms.common.a aVar, int i10) {
        if (i10 < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        a3 a3Var = (a3) this.f4791k.get(i10);
        if (a3Var != null) {
            v(i10);
            f.c cVar = a3Var.f4779c;
            if (cVar != null) {
                cVar.n(aVar);
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.g3
    protected final void n() {
        for (int i10 = 0; i10 < this.f4791k.size(); i10++) {
            a3 w10 = w(i10);
            if (w10 != null) {
                w10.f4778b.d();
            }
        }
    }

    public final void u(int i10, a2.f fVar, f.c cVar) {
        b2.p.l(fVar, "GoogleApiClient instance cannot be null");
        b2.p.o(this.f4791k.indexOfKey(i10) < 0, "Already managing a GoogleApiClient with id " + i10);
        d3 d3Var = (d3) this.f4863h.get();
        boolean z10 = this.f4862g;
        String valueOf = String.valueOf(d3Var);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("starting AutoManage for client ");
        sb2.append(i10);
        sb2.append(" ");
        sb2.append(z10);
        sb2.append(" ");
        sb2.append(valueOf);
        a3 a3Var = new a3(this, i10, fVar, cVar);
        fVar.i(a3Var);
        this.f4791k.put(i10, a3Var);
        if (this.f4862g && d3Var == null) {
            "connecting ".concat(fVar.toString());
            fVar.d();
        }
    }

    public final void v(int i10) {
        a3 a3Var = (a3) this.f4791k.get(i10);
        this.f4791k.remove(i10);
        if (a3Var != null) {
            a3Var.f4778b.j(a3Var);
            a3Var.f4778b.e();
        }
    }
}
