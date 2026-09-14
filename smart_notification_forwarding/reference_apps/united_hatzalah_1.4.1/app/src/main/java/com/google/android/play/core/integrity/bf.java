package com.google.android.play.core.integrity;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bf extends bm {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f3957a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f3958b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ bn f3959c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bf(bn bnVar, TaskCompletionSource taskCompletionSource, int i, long j2, TaskCompletionSource taskCompletionSource2) {
        super(bnVar, taskCompletionSource);
        this.f3959c = bnVar;
        this.f3957a = j2;
        this.f3958b = taskCompletionSource2;
    }

    @Override // I1.z
    public final void b() {
        I1.y yVar;
        if (!bn.k(this.f3959c)) {
            try {
                bn bnVar = this.f3959c;
                I1.o oVar = (I1.o) bnVar.f3979a.f918n;
                Bundle b4 = bn.b(bnVar, this.f3957a, 0);
                bl blVar = new bl(this.f3959c, this.f3958b);
                I1.m mVar = (I1.m) oVar;
                mVar.getClass();
                Parcel obtain = Parcel.obtain();
                obtain.writeInterfaceToken(mVar.f900b);
                int i = I1.k.f924a;
                obtain.writeInt(1);
                b4.writeToParcel(obtain, 0);
                obtain.writeStrongBinder(blVar);
                mVar.c(2, obtain);
                return;
            } catch (RemoteException e4) {
                bn bnVar2 = this.f3959c;
                long j2 = this.f3957a;
                yVar = bnVar2.f3980b;
                yVar.a(e4, "warmUpIntegrityToken(%s)", Long.valueOf(j2));
                this.f3958b.trySetException(new StandardIntegrityException(-100, e4));
                return;
            }
        }
        a(new StandardIntegrityException(-2, null));
    }
}
