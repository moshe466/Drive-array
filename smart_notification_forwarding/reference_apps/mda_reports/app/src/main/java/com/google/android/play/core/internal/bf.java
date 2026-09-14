package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class bf extends j implements bd {
    public bf() {
        super("com.google.android.play.core.splitinstall.protocol.ISplitInstallServiceCallback");
    }

    @Override // com.google.android.play.core.internal.j
    protected final boolean a(int i, Parcel parcel) {
        switch (i) {
            case 2:
                c(parcel.readInt(), (Bundle) i.a(parcel, Bundle.CREATOR));
                return true;
            case 3:
                int readInt = parcel.readInt();
                a(readInt);
                return true;
            case 4:
                a(parcel.readInt(), (Bundle) i.a(parcel, Bundle.CREATOR));
                return true;
            case 5:
                b(parcel.readInt(), (Bundle) i.a(parcel, Bundle.CREATOR));
                return true;
            case 6:
                e((Bundle) i.a(parcel, Bundle.CREATOR));
                return true;
            case 7:
                a(parcel.createTypedArrayList(Bundle.CREATOR));
                return true;
            case 8:
                d((Bundle) i.a(parcel, Bundle.CREATOR));
                return true;
            case 9:
                a((Bundle) i.a(parcel, Bundle.CREATOR));
                return true;
            case 10:
                b();
                return true;
            case 11:
                a();
                return true;
            case 12:
                c((Bundle) i.a(parcel, Bundle.CREATOR));
                return true;
            case 13:
                b((Bundle) i.a(parcel, Bundle.CREATOR));
                return true;
            default:
                return false;
        }
    }
}
