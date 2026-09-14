package m2;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public class a implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    private final IBinder f12010a;

    /* renamed from: b, reason: collision with root package name */
    private final String f12011b;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IBinder iBinder, String str) {
        this.f12010a = iBinder;
        this.f12011b = str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f12010a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel i() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f12011b);
        return obtain;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void n(int i10, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            this.f12010a.transact(i10, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void p(int i10, Parcel parcel) {
        try {
            this.f12010a.transact(1, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
