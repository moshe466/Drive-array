package com.google.android.gms.internal.measurement;

import android.app.Activity;
import com.google.android.gms.internal.measurement.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n extends h.a {

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ Activity f5484j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ String f5485k;

    /* renamed from: l, reason: collision with root package name */
    private final /* synthetic */ String f5486l;

    /* renamed from: m, reason: collision with root package name */
    private final /* synthetic */ h f5487m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(h hVar, Activity activity, String str, String str2) {
        super(hVar);
        this.f5487m = hVar;
        this.f5484j = activity;
        this.f5485k = str;
        this.f5486l = str2;
    }

    @Override // com.google.android.gms.internal.measurement.h.a
    final void a() {
        qf qfVar;
        qfVar = this.f5487m.f5357h;
        qfVar.setCurrentScreen(j2.b.z(this.f5484j), this.f5485k, this.f5486l, this.f5358f);
    }
}
