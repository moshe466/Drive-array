package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k6 implements r9 {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ w5 f6162a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k6(w5 w5Var) {
        this.f6162a = w5Var;
    }

    @Override // com.google.android.gms.measurement.internal.r9
    public final void a(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            this.f6162a.R("auto", "_err", bundle);
        } else {
            this.f6162a.S("auto", "_err", bundle, str);
        }
    }
}
