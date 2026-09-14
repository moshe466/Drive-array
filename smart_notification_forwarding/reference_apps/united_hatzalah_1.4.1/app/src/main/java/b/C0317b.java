package b;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import r.BinderC0632g;
import r.BinderC0639n;

/* renamed from: b.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0317b implements InterfaceC0319d {

    /* renamed from: a, reason: collision with root package name */
    public IBinder f3795a;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f3795a;
    }

    public final boolean c(BinderC0632g binderC0632g, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(InterfaceC0319d.f3797h);
            obtain.writeStrongInterface(binderC0632g);
            m3.b.X(obtain, bundle);
            boolean z3 = false;
            this.f3795a.transact(13, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z3 = true;
            }
            return z3;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final boolean d(BinderC0632g binderC0632g, Uri uri, Bundle bundle, List list) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(InterfaceC0319d.f3797h);
            obtain.writeStrongInterface(binderC0632g);
            m3.b.X(obtain, uri);
            m3.b.X(obtain, bundle);
            boolean z3 = false;
            if (list == null) {
                obtain.writeInt(-1);
            } else {
                int size = list.size();
                obtain.writeInt(size);
                for (int i = 0; i < size; i++) {
                    m3.b.X(obtain, (Parcelable) list.get(i));
                }
            }
            this.f3795a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z3 = true;
            }
            return z3;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final boolean e(BinderC0632g binderC0632g) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(InterfaceC0319d.f3797h);
            obtain.writeStrongInterface(binderC0632g);
            boolean z3 = false;
            this.f3795a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z3 = true;
            }
            return z3;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final int h(BinderC0632g binderC0632g, String str, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(InterfaceC0319d.f3797h);
            obtain.writeStrongInterface(binderC0632g);
            obtain.writeString(str);
            m3.b.X(obtain, bundle);
            this.f3795a.transact(8, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final boolean i(BinderC0632g binderC0632g, Uri uri) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(InterfaceC0319d.f3797h);
            obtain.writeStrongInterface(binderC0632g);
            m3.b.X(obtain, uri);
            boolean z3 = false;
            this.f3795a.transact(7, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z3 = true;
            }
            return z3;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final boolean j(BinderC0632g binderC0632g, Uri uri, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(InterfaceC0319d.f3797h);
            obtain.writeStrongInterface(binderC0632g);
            m3.b.X(obtain, uri);
            m3.b.X(obtain, bundle);
            boolean z3 = false;
            this.f3795a.transact(11, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z3 = true;
            }
            return z3;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final boolean k(BinderC0632g binderC0632g, BinderC0639n binderC0639n, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(InterfaceC0319d.f3797h);
            obtain.writeStrongInterface(binderC0632g);
            obtain.writeStrongBinder(binderC0639n);
            m3.b.X(obtain, bundle);
            boolean z3 = false;
            this.f3795a.transact(14, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z3 = true;
            }
            return z3;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final boolean l(BinderC0632g binderC0632g, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(InterfaceC0319d.f3797h);
            obtain.writeStrongInterface(binderC0632g);
            m3.b.X(obtain, bundle);
            boolean z3 = false;
            this.f3795a.transact(6, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z3 = true;
            }
            return z3;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final boolean m(BinderC0632g binderC0632g, int i, Uri uri, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(InterfaceC0319d.f3797h);
            obtain.writeStrongInterface(binderC0632g);
            obtain.writeInt(i);
            m3.b.X(obtain, uri);
            m3.b.X(obtain, bundle);
            boolean z3 = false;
            this.f3795a.transact(9, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z3 = true;
            }
            return z3;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final boolean n() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(InterfaceC0319d.f3797h);
            obtain.writeLong(0L);
            boolean z3 = false;
            this.f3795a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z3 = true;
            }
            return z3;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
