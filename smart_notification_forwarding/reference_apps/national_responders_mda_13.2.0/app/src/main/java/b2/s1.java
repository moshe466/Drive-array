package b2;

import android.os.IBinder;
import android.os.Parcel;
import j2.a;

/* loaded from: classes.dex */
public final class s1 extends o2.a implements u1 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public s1(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    @Override // b2.u1
    public final int b() {
        Parcel i10 = i(2, p());
        int readInt = i10.readInt();
        i10.recycle();
        return readInt;
    }

    @Override // b2.u1
    public final j2.a c() {
        Parcel i10 = i(1, p());
        j2.a n10 = a.AbstractBinderC0212a.n(i10.readStrongBinder());
        i10.recycle();
        return n10;
    }
}
