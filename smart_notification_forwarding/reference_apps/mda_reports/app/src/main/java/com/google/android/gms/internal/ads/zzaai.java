package com.google.android.gms.internal.ads;

import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public abstract class zzaai extends zzgb implements zzaaf {
    public zzaai() {
        super("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        String zzqs;
        if (i == 1) {
            zzqs = zzqs();
        } else {
            if (i != 2) {
                if (i == 3) {
                    zzn(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                } else if (i == 4) {
                    recordClick();
                } else {
                    if (i != 5) {
                        return false;
                    }
                    recordImpression();
                }
                parcel2.writeNoException();
                return true;
            }
            zzqs = getContent();
        }
        parcel2.writeNoException();
        parcel2.writeString(zzqs);
        return true;
    }
}
