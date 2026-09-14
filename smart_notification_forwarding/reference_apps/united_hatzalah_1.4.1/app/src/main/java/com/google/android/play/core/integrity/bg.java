package com.google.android.play.core.integrity;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bg extends bm {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f3960a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f3961b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f3962c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f3963d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ bn f3964e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bg(bn bnVar, TaskCompletionSource taskCompletionSource, int i, String str, long j2, long j3, TaskCompletionSource taskCompletionSource2) {
        super(bnVar, taskCompletionSource);
        this.f3964e = bnVar;
        this.f3960a = str;
        this.f3961b = j2;
        this.f3962c = j3;
        this.f3963d = taskCompletionSource2;
    }

    @Override // I1.z
    public final void b() {
        I1.y yVar;
        if (!bn.k(this.f3964e)) {
            try {
                bn bnVar = this.f3964e;
                I1.o oVar = (I1.o) bnVar.f3979a.f918n;
                Bundle a2 = bn.a(bnVar, this.f3960a, this.f3961b, this.f3962c, 0);
                bk bkVar = new bk(this.f3964e, this.f3963d, this.f3961b);
                I1.m mVar = (I1.m) oVar;
                mVar.getClass();
                Parcel obtain = Parcel.obtain();
                obtain.writeInterfaceToken(mVar.f900b);
                int i = I1.k.f924a;
                obtain.writeInt(1);
                a2.writeToParcel(obtain, 0);
                obtain.writeStrongBinder(bkVar);
                mVar.c(3, obtain);
                return;
            } catch (RemoteException e4) {
                bn bnVar2 = this.f3964e;
                String str = this.f3960a;
                yVar = bnVar2.f3980b;
                yVar.a(e4, "requestExpressIntegrityToken(%s, %s)", str, Long.valueOf(this.f3961b));
                this.f3963d.trySetException(new StandardIntegrityException(-100, e4));
                return;
            }
        }
        a(new StandardIntegrityException(-2, null));
    }
}
