package com.google.android.gms.internal.p000authapi;

import android.os.Parcel;
import com.google.android.gms.auth.api.identity.SavePasswordResult;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public abstract class zbak extends zbb implements zbal {
    public zbak() {
        super("com.google.android.gms.auth.api.identity.internal.ISavePasswordCallback");
    }

    @Override // com.google.android.gms.internal.p000authapi.zbb
    public final boolean zba(int i, Parcel parcel, Parcel parcel2, int i3) {
        if (i == 1) {
            Status status = (Status) zbc.zba(parcel, Status.CREATOR);
            SavePasswordResult savePasswordResult = (SavePasswordResult) zbc.zba(parcel, SavePasswordResult.CREATOR);
            zbc.zbb(parcel);
            zbb(status, savePasswordResult);
            return true;
        }
        return false;
    }
}
