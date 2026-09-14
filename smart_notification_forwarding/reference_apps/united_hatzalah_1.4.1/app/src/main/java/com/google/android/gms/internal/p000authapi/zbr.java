package com.google.android.gms.internal.p000authapi;

import android.os.Parcel;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public abstract class zbr extends zbb implements zbs {
    public zbr() {
        super("com.google.android.gms.auth.api.credentials.internal.ICredentialsCallbacks");
    }

    @Override // com.google.android.gms.internal.p000authapi.zbb
    public final boolean zba(int i, Parcel parcel, Parcel parcel2, int i3) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return false;
                }
                Status status = (Status) zbc.zba(parcel, Status.CREATOR);
                String readString = parcel.readString();
                zbc.zbb(parcel);
                zbd(status, readString);
            } else {
                Status status2 = (Status) zbc.zba(parcel, Status.CREATOR);
                zbc.zbb(parcel);
                zbc(status2);
            }
        } else {
            Status status3 = (Status) zbc.zba(parcel, Status.CREATOR);
            Credential credential = (Credential) zbc.zba(parcel, Credential.CREATOR);
            zbc.zbb(parcel);
            zbb(status3, credential);
        }
        parcel2.writeNoException();
        return true;
    }
}
