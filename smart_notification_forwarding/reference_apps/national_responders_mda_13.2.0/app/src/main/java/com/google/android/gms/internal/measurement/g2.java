package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* loaded from: classes.dex */
final class g2 extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ e2 f5326a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g2(e2 e2Var, Handler handler) {
        super(null);
        this.f5326a = e2Var;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z10) {
        this.f5326a.c();
    }
}
