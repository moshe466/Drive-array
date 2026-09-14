package com.google.android.play.core.integrity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bh extends bm {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bundle f3965a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Activity f3966b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f3967c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f3968d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ bn f3969e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bh(bn bnVar, TaskCompletionSource taskCompletionSource, Bundle bundle, Activity activity, TaskCompletionSource taskCompletionSource2, int i) {
        super(bnVar, taskCompletionSource);
        this.f3969e = bnVar;
        this.f3965a = bundle;
        this.f3966b = activity;
        this.f3967c = taskCompletionSource2;
        this.f3968d = i;
    }

    @Override // I1.z
    public final void b() {
        I1.y yVar;
        at atVar;
        if (bn.k(this.f3969e)) {
            a(new StandardIntegrityException(-2, null));
            return;
        }
        try {
            bn bnVar = this.f3969e;
            I1.d dVar = bnVar.f3979a;
            I1.o oVar = (I1.o) dVar.f918n;
            Bundle bundle = this.f3965a;
            atVar = bnVar.f3983e;
            as a2 = atVar.a(this.f3966b, this.f3967c, dVar);
            I1.m mVar = (I1.m) oVar;
            mVar.getClass();
            Parcel obtain = Parcel.obtain();
            obtain.writeInterfaceToken(mVar.f900b);
            int i = I1.k.f924a;
            obtain.writeInt(1);
            bundle.writeToParcel(obtain, 0);
            obtain.writeStrongBinder(a2);
            mVar.c(6, obtain);
        } catch (RemoteException e4) {
            bn bnVar2 = this.f3969e;
            int i3 = this.f3968d;
            yVar = bnVar2.f3980b;
            yVar.a(e4, "requestAndShowDialog(%s)", Integer.valueOf(i3));
            this.f3967c.trySetException(new StandardIntegrityException(-100, e4));
        }
    }
}
