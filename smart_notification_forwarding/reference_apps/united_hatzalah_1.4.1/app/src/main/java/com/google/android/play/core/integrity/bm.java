package com.google.android.play.core.integrity;

import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
abstract class bm extends I1.z {

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ bn f3978f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bm(bn bnVar, TaskCompletionSource taskCompletionSource) {
        super(taskCompletionSource);
        this.f3978f = bnVar;
    }

    @Override // I1.z
    public final void a(Exception exc) {
        if (!(exc instanceof com.google.android.play.integrity.internal.af)) {
            super.a(exc);
        } else if (bn.k(this.f3978f)) {
            super.a(new StandardIntegrityException(-2, exc));
        } else {
            super.a(new StandardIntegrityException(-9, exc));
        }
    }
}
