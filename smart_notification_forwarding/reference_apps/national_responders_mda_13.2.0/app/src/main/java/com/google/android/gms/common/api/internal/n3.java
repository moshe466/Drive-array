package com.google.android.gms.common.api.internal;

import android.os.Bundle;

/* loaded from: classes.dex */
final class n3 implements t1 {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ y f4938a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ n3(y yVar, m3 m3Var) {
        this.f4938a = yVar;
    }

    @Override // com.google.android.gms.common.api.internal.t1
    public final void a(Bundle bundle) {
        y.p(this.f4938a).lock();
        try {
            y.u(this.f4938a, bundle);
            y.q(this.f4938a, com.google.android.gms.common.a.f4739j);
            y.v(this.f4938a);
        } finally {
            y.p(this.f4938a).unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.t1
    public final void b(int i10, boolean z10) {
        y.p(this.f4938a).lock();
        try {
            y yVar = this.f4938a;
            if (!y.w(yVar) && y.l(yVar) != null && y.l(yVar).t()) {
                y.s(this.f4938a, true);
                y.o(this.f4938a).i(i10);
            }
            y.s(this.f4938a, false);
            y.t(this.f4938a, i10, z10);
        } finally {
            y.p(this.f4938a).unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.t1
    public final void c(com.google.android.gms.common.a aVar) {
        y.p(this.f4938a).lock();
        try {
            y.q(this.f4938a, aVar);
            y.v(this.f4938a);
        } finally {
            y.p(this.f4938a).unlock();
        }
    }
}
