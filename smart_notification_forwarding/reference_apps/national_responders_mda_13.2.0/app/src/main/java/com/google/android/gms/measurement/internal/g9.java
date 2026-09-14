package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g9 implements a4 {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f6077a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ e9 f6078b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g9(e9 e9Var, String str) {
        this.f6078b = e9Var;
        this.f6077a = str;
    }

    @Override // com.google.android.gms.measurement.internal.a4
    public final void a(String str, int i10, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        this.f6078b.l(i10, th, bArr, this.f6077a);
    }
}
