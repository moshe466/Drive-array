package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d0 extends h.a {

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ Long f5244j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ String f5245k;

    /* renamed from: l, reason: collision with root package name */
    private final /* synthetic */ String f5246l;

    /* renamed from: m, reason: collision with root package name */
    private final /* synthetic */ Bundle f5247m;

    /* renamed from: n, reason: collision with root package name */
    private final /* synthetic */ boolean f5248n;

    /* renamed from: o, reason: collision with root package name */
    private final /* synthetic */ boolean f5249o;

    /* renamed from: p, reason: collision with root package name */
    private final /* synthetic */ h f5250p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(h hVar, Long l10, String str, String str2, Bundle bundle, boolean z10, boolean z11) {
        super(hVar);
        this.f5250p = hVar;
        this.f5244j = l10;
        this.f5245k = str;
        this.f5246l = str2;
        this.f5247m = bundle;
        this.f5248n = z10;
        this.f5249o = z11;
    }

    @Override // com.google.android.gms.internal.measurement.h.a
    final void a() {
        qf qfVar;
        Long l10 = this.f5244j;
        long longValue = l10 == null ? this.f5358f : l10.longValue();
        qfVar = this.f5250p.f5357h;
        qfVar.logEvent(this.f5245k, this.f5246l, this.f5247m, this.f5248n, this.f5249o, longValue);
    }
}
