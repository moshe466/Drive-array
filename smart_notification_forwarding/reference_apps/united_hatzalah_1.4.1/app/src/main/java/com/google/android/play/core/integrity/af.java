package com.google.android.play.core.integrity;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class af extends I1.z {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte[] f3902a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Long f3903b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f3904c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ IntegrityTokenRequest f3905d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ aj f3906e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public af(aj ajVar, TaskCompletionSource taskCompletionSource, byte[] bArr, Long l3, Parcelable parcelable, TaskCompletionSource taskCompletionSource2, IntegrityTokenRequest integrityTokenRequest) {
        super(taskCompletionSource);
        this.f3906e = ajVar;
        this.f3902a = bArr;
        this.f3903b = l3;
        this.f3904c = taskCompletionSource2;
        this.f3905d = integrityTokenRequest;
    }

    @Override // I1.z
    public final void a(Exception exc) {
        if (exc instanceof com.google.android.play.integrity.internal.af) {
            super.a(new IntegrityServiceException(-9, exc));
        } else {
            super.a(exc);
        }
    }

    @Override // I1.z
    public final void b() {
        I1.y yVar;
        try {
            aj ajVar = this.f3906e;
            I1.t tVar = (I1.t) ajVar.f3916a.f918n;
            Bundle a2 = aj.a(ajVar, this.f3902a, this.f3903b, null);
            ai aiVar = new ai(this.f3906e, this.f3904c);
            I1.r rVar = (I1.r) tVar;
            rVar.getClass();
            Parcel obtain = Parcel.obtain();
            obtain.writeInterfaceToken(rVar.f900b);
            int i = I1.k.f924a;
            obtain.writeInt(1);
            a2.writeToParcel(obtain, 0);
            obtain.writeStrongBinder(aiVar);
            rVar.c(2, obtain);
        } catch (RemoteException e4) {
            aj ajVar2 = this.f3906e;
            IntegrityTokenRequest integrityTokenRequest = this.f3905d;
            yVar = ajVar2.f3917b;
            yVar.a(e4, "requestIntegrityToken(%s)", integrityTokenRequest);
            this.f3904c.trySetException(new IntegrityServiceException(-100, e4));
        }
    }
}
