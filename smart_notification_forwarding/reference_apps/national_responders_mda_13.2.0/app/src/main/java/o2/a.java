package o2;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public class a implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    private final IBinder f12461a;

    /* renamed from: b, reason: collision with root package name */
    private final String f12462b;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IBinder iBinder, String str) {
        this.f12461a = iBinder;
        this.f12462b = str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f12461a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel i(int i10, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                this.f12461a.transact(i10, parcel, obtain, 0);
                obtain.readException();
                return obtain;
            } catch (RuntimeException e10) {
                obtain.recycle();
                throw e10;
            }
        } finally {
            parcel.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void n(int i10, Parcel parcel) {
        try {
            this.f12461a.transact(2, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel p() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f12462b);
        return obtain;
    }
}
