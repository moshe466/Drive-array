package F1;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class f implements h, IInterface {

    /* renamed from: a, reason: collision with root package name */
    public final IBinder f737a;

    public f(IBinder iBinder) {
        this.f737a = iBinder;
    }

    @Override // F1.h
    public final void a(String str, Bundle bundle, E1.i iVar) {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken("com.google.android.play.core.appupdate.protocol.IAppUpdateService");
        obtain.writeString(str);
        int i = e.f736a;
        obtain.writeInt(1);
        bundle.writeToParcel(obtain, 0);
        obtain.writeStrongBinder(iVar);
        try {
            this.f737a.transact(3, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f737a;
    }

    @Override // F1.h
    public final void b(String str, Bundle bundle, E1.j jVar) {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken("com.google.android.play.core.appupdate.protocol.IAppUpdateService");
        obtain.writeString(str);
        int i = e.f736a;
        obtain.writeInt(1);
        bundle.writeToParcel(obtain, 0);
        obtain.writeStrongBinder(jVar);
        try {
            this.f737a.transact(2, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }
}
