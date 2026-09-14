package com.google.android.gms.common.api.internal;

import android.os.Bundle;

/* loaded from: classes.dex */
final class p3 implements t1 {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ y f4956a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ p3(y yVar, o3 o3Var) {
        this.f4956a = yVar;
    }

    @Override // com.google.android.gms.common.api.internal.t1
    public final void a(Bundle bundle) {
        this.f4956a.f5054l.lock();
        try {
            this.f4956a.f5052j = com.google.android.gms.common.a.f4739j;
            y.v(this.f4956a);
        } finally {
            this.f4956a.f5054l.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.t1
    public final void b(int i10, boolean z10) {
        this.f4956a.f5054l.lock();
        try {
            y yVar = this.f4956a;
            if (yVar.f5053k) {
                yVar.f5053k = false;
                y.t(this.f4956a, i10, z10);
            } else {
                yVar.f5053k = true;
                this.f4956a.f5045c.i(i10);
            }
        } finally {
            this.f4956a.f5054l.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.t1
    public final void c(com.google.android.gms.common.a aVar) {
        this.f4956a.f5054l.lock();
        try {
            this.f4956a.f5052j = aVar;
            y.v(this.f4956a);
        } finally {
            this.f4956a.f5054l.unlock();
        }
    }
}
