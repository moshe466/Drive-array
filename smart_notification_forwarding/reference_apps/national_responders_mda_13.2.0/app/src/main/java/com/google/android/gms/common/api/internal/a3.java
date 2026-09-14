package com.google.android.gms.common.api.internal;

import a2.f;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a3 implements f.c {

    /* renamed from: a, reason: collision with root package name */
    public final int f4777a;

    /* renamed from: b, reason: collision with root package name */
    public final a2.f f4778b;

    /* renamed from: c, reason: collision with root package name */
    public final f.c f4779c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ b3 f4780d;

    public a3(b3 b3Var, int i10, a2.f fVar, f.c cVar) {
        this.f4780d = b3Var;
        this.f4777a = i10;
        this.f4778b = fVar;
        this.f4779c = cVar;
    }

    @Override // com.google.android.gms.common.api.internal.o
    public final void n(com.google.android.gms.common.a aVar) {
        "beginFailureResolution for ".concat(String.valueOf(aVar));
        this.f4780d.s(aVar, this.f4777a);
    }
}
