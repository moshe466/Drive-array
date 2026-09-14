package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;

/* loaded from: classes.dex */
public final class t5 {

    /* renamed from: a, reason: collision with root package name */
    final Context f6493a;

    /* renamed from: b, reason: collision with root package name */
    String f6494b;

    /* renamed from: c, reason: collision with root package name */
    String f6495c;

    /* renamed from: d, reason: collision with root package name */
    String f6496d;

    /* renamed from: e, reason: collision with root package name */
    Boolean f6497e;

    /* renamed from: f, reason: collision with root package name */
    long f6498f;

    /* renamed from: g, reason: collision with root package name */
    com.google.android.gms.internal.measurement.f f6499g;

    /* renamed from: h, reason: collision with root package name */
    boolean f6500h;

    /* renamed from: i, reason: collision with root package name */
    Long f6501i;

    public t5(Context context, com.google.android.gms.internal.measurement.f fVar, Long l10) {
        this.f6500h = true;
        b2.p.k(context);
        Context applicationContext = context.getApplicationContext();
        b2.p.k(applicationContext);
        this.f6493a = applicationContext;
        this.f6501i = l10;
        if (fVar != null) {
            this.f6499g = fVar;
            this.f6494b = fVar.f5300k;
            this.f6495c = fVar.f5299j;
            this.f6496d = fVar.f5298i;
            this.f6500h = fVar.f5297h;
            this.f6498f = fVar.f5296g;
            Bundle bundle = fVar.f5301l;
            if (bundle != null) {
                this.f6497e = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
