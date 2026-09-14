package I1;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: I1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0111a implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    public final IBinder f899a;

    /* renamed from: b, reason: collision with root package name */
    public final String f900b;

    public AbstractC0111a(IBinder iBinder, String str) {
        this.f899a = iBinder;
        this.f900b = str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f899a;
    }

    public final void c(int i, Parcel parcel) {
        try {
            this.f899a.transact(i, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
