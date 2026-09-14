package com.google.android.play.core.integrity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ag extends I1.z {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bundle f3907a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Activity f3908b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f3909c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f3910d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ aj f3911e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(aj ajVar, TaskCompletionSource taskCompletionSource, Bundle bundle, Activity activity, TaskCompletionSource taskCompletionSource2, int i) {
        super(taskCompletionSource);
        this.f3911e = ajVar;
        this.f3907a = bundle;
        this.f3908b = activity;
        this.f3909c = taskCompletionSource2;
        this.f3910d = i;
    }

    @Override // I1.z
    public final void b() {
        I1.y yVar;
        at atVar;
        try {
            aj ajVar = this.f3911e;
            I1.t tVar = (I1.t) ajVar.f3916a.f918n;
            Bundle bundle = this.f3907a;
            atVar = ajVar.f3919d;
            as a2 = atVar.a(this.f3908b, this.f3909c, ajVar.f3916a);
            I1.r rVar = (I1.r) tVar;
            rVar.getClass();
            Parcel obtain = Parcel.obtain();
            obtain.writeInterfaceToken(rVar.f900b);
            int i = I1.k.f924a;
            obtain.writeInt(1);
            bundle.writeToParcel(obtain, 0);
            obtain.writeStrongBinder(a2);
            rVar.c(3, obtain);
        } catch (RemoteException e4) {
            aj ajVar2 = this.f3911e;
            int i3 = this.f3910d;
            yVar = ajVar2.f3917b;
            yVar.a(e4, "requestAndShowDialog(%s)", Integer.valueOf(i3));
            this.f3909c.trySetException(new IntegrityServiceException(-100, e4));
        }
    }
}
