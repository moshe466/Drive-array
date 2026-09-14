package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f9 implements a4 {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ e9 f6057a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f9(e9 e9Var) {
        this.f6057a = e9Var;
    }

    @Override // com.google.android.gms.measurement.internal.a4
    public final void a(String str, int i10, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        this.f6057a.B(str, i10, th, bArr, map);
    }
}
