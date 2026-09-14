package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.Parcel;
import j2.a;

/* loaded from: classes.dex */
public final class m extends o2.a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public m(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    public final j2.a A0(j2.a aVar, String str, int i10, j2.a aVar2) {
        Parcel p10 = p();
        o2.c.e(p10, aVar);
        p10.writeString(str);
        p10.writeInt(i10);
        o2.c.e(p10, aVar2);
        Parcel i11 = i(8, p10);
        j2.a n10 = a.AbstractBinderC0212a.n(i11.readStrongBinder());
        i11.recycle();
        return n10;
    }

    public final j2.a B0(j2.a aVar, String str, int i10) {
        Parcel p10 = p();
        o2.c.e(p10, aVar);
        p10.writeString(str);
        p10.writeInt(i10);
        Parcel i11 = i(4, p10);
        j2.a n10 = a.AbstractBinderC0212a.n(i11.readStrongBinder());
        i11.recycle();
        return n10;
    }

    public final j2.a C0(j2.a aVar, String str, boolean z10, long j10) {
        Parcel p10 = p();
        o2.c.e(p10, aVar);
        p10.writeString(str);
        o2.c.c(p10, z10);
        p10.writeLong(j10);
        Parcel i10 = i(7, p10);
        j2.a n10 = a.AbstractBinderC0212a.n(i10.readStrongBinder());
        i10.recycle();
        return n10;
    }

    public final int x0(j2.a aVar, String str, boolean z10) {
        Parcel p10 = p();
        o2.c.e(p10, aVar);
        p10.writeString(str);
        o2.c.c(p10, z10);
        Parcel i10 = i(3, p10);
        int readInt = i10.readInt();
        i10.recycle();
        return readInt;
    }

    public final int y0(j2.a aVar, String str, boolean z10) {
        Parcel p10 = p();
        o2.c.e(p10, aVar);
        p10.writeString(str);
        o2.c.c(p10, z10);
        Parcel i10 = i(5, p10);
        int readInt = i10.readInt();
        i10.recycle();
        return readInt;
    }

    public final int z() {
        Parcel i10 = i(6, p());
        int readInt = i10.readInt();
        i10.recycle();
        return readInt;
    }

    public final j2.a z0(j2.a aVar, String str, int i10) {
        Parcel p10 = p();
        o2.c.e(p10, aVar);
        p10.writeString(str);
        p10.writeInt(i10);
        Parcel i11 = i(2, p10);
        j2.a n10 = a.AbstractBinderC0212a.n(i11.readStrongBinder());
        i11.recycle();
        return n10;
    }
}
