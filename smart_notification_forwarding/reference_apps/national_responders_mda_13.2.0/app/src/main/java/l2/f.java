package l2;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class f extends a implements d {
    /* JADX INFO: Access modifiers changed from: package-private */
    public f(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    }

    @Override // l2.d
    public final boolean Z(boolean z10) {
        Parcel i10 = i();
        c.a(i10, true);
        Parcel n10 = n(2, i10);
        boolean b10 = c.b(n10);
        n10.recycle();
        return b10;
    }

    @Override // l2.d
    public final String e() {
        Parcel n10 = n(1, i());
        String readString = n10.readString();
        n10.recycle();
        return readString;
    }
}
