package r;

import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import b.InterfaceC0320e;

/* renamed from: r.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class BinderC0639n extends Binder implements InterfaceC0320e {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f6198a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0641p f6199b;

    public BinderC0639n(InterfaceC0641p interfaceC0641p) {
        this.f6199b = interfaceC0641p;
        attachInterface(this, InterfaceC0320e.i);
        this.f6198a = new Handler(Looper.getMainLooper());
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i3) {
        String str = InterfaceC0320e.i;
        if (i >= 1 && i <= 16777215) {
            parcel.enforceInterface(str);
        }
        if (i == 1598968902) {
            parcel2.writeString(str);
            return true;
        }
        Object obj = null;
        final boolean z3 = false;
        final InterfaceC0641p interfaceC0641p = this.f6199b;
        Handler handler = this.f6198a;
        if (i != 2) {
            if (i != 3) {
                if (i != 4) {
                    return super.onTransact(i, parcel, parcel2, i3);
                }
                if (parcel.readInt() != 0) {
                    z3 = true;
                }
                Parcelable.Creator creator = Bundle.CREATOR;
                if (parcel.readInt() != 0) {
                    obj = creator.createFromParcel(parcel);
                }
                final Bundle bundle = (Bundle) obj;
                final int i4 = 0;
                handler.post(new Runnable() { // from class: r.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i4) {
                            case 0:
                                interfaceC0641p.onSessionEnded(z3, bundle);
                                return;
                            default:
                                interfaceC0641p.onVerticalScrollEvent(z3, bundle);
                                return;
                        }
                    }
                });
                return true;
            }
            int readInt = parcel.readInt();
            Parcelable.Creator creator2 = Bundle.CREATOR;
            if (parcel.readInt() != 0) {
                obj = creator2.createFromParcel(parcel);
            }
            handler.post(new c.k(interfaceC0641p, readInt, 4, (Bundle) obj));
            return true;
        }
        if (parcel.readInt() != 0) {
            z3 = true;
        }
        Parcelable.Creator creator3 = Bundle.CREATOR;
        if (parcel.readInt() != 0) {
            obj = creator3.createFromParcel(parcel);
        }
        final Bundle bundle2 = (Bundle) obj;
        final int i5 = 1;
        handler.post(new Runnable() { // from class: r.m
            @Override // java.lang.Runnable
            public final void run() {
                switch (i5) {
                    case 0:
                        interfaceC0641p.onSessionEnded(z3, bundle2);
                        return;
                    default:
                        interfaceC0641p.onVerticalScrollEvent(z3, bundle2);
                        return;
                }
            }
        });
        return true;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}
