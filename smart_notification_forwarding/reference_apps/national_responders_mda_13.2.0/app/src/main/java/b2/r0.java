package b2;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
final class r0 implements m {

    /* renamed from: a, reason: collision with root package name */
    private final IBinder f4073a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r0(IBinder iBinder) {
        this.f4073a = iBinder;
    }

    @Override // b2.m
    public final void E(l lVar, g gVar) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            obtain.writeStrongBinder(lVar != null ? lVar.asBinder() : null);
            if (gVar != null) {
                obtain.writeInt(1);
                h1.a(gVar, obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f4073a.transact(46, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f4073a;
    }
}
