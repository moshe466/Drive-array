package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.Parcel;
import j2.a;

/* loaded from: classes.dex */
public final class n extends o2.a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public n(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    public final j2.a x0(j2.a aVar, String str, int i10, j2.a aVar2) {
        Parcel p10 = p();
        o2.c.e(p10, aVar);
        p10.writeString(str);
        p10.writeInt(i10);
        o2.c.e(p10, aVar2);
        Parcel i11 = i(3, p10);
        j2.a n10 = a.AbstractBinderC0212a.n(i11.readStrongBinder());
        i11.recycle();
        return n10;
    }

    public final j2.a z(j2.a aVar, String str, int i10, j2.a aVar2) {
        Parcel p10 = p();
        o2.c.e(p10, aVar);
        p10.writeString(str);
        p10.writeInt(i10);
        o2.c.e(p10, aVar2);
        Parcel i11 = i(2, p10);
        j2.a n10 = a.AbstractBinderC0212a.n(i11.readStrongBinder());
        i11.recycle();
        return n10;
    }
}
