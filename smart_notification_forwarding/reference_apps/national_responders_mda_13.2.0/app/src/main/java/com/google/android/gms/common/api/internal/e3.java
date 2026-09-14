package com.google.android.gms.common.api.internal;

import android.app.Dialog;

/* loaded from: classes.dex */
final class e3 extends r1 {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Dialog f4832a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ f3 f4833b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e3(f3 f3Var, Dialog dialog) {
        this.f4833b = f3Var;
        this.f4832a = dialog;
    }

    @Override // com.google.android.gms.common.api.internal.r1
    public final void a() {
        this.f4833b.f4838g.o();
        if (this.f4832a.isShowing()) {
            this.f4832a.dismiss();
        }
    }
}
