package x2;

import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class e extends m2.b implements f {
    public e() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:1:0x0000. Please report as an issue. */
    @Override // m2.b
    protected final boolean x0(int i10, Parcel parcel, Parcel parcel2, int i11) {
        switch (i10) {
            case 3:
                m2.c.b(parcel);
                parcel2.writeNoException();
                return true;
            case 4:
            case 6:
                m2.c.b(parcel);
                parcel2.writeNoException();
                return true;
            case 5:
            default:
                return false;
            case 7:
                m2.c.b(parcel);
                parcel2.writeNoException();
                return true;
            case 8:
                l lVar = (l) m2.c.a(parcel, l.CREATOR);
                m2.c.b(parcel);
                o0(lVar);
                parcel2.writeNoException();
                return true;
            case 9:
                m2.c.b(parcel);
                parcel2.writeNoException();
                return true;
        }
    }
}
