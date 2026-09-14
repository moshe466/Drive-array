package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h9 implements r9 {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ e9 f6090a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h9(e9 e9Var) {
        this.f6090a = e9Var;
    }

    @Override // com.google.android.gms.measurement.internal.r9
    public final void a(String str, Bundle bundle) {
        t4 t4Var;
        if (!TextUtils.isEmpty(str)) {
            this.f6090a.e().z(new j9(this, str, bundle));
        } else {
            t4Var = this.f6090a.f6010j;
            t4Var.h().F().a("AppId not known when logging error event");
        }
    }
}
