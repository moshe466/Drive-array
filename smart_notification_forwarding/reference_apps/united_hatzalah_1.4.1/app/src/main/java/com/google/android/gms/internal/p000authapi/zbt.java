package com.google.android.gms.internal.p000authapi;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.auth.api.credentials.CredentialRequest;

/* loaded from: classes.dex */
public final class zbt extends zba implements IInterface {
    public zbt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
    }

    public final void zbc(zbs zbsVar, zbp zbpVar) {
        Parcel zba = zba();
        zbc.zbd(zba, zbsVar);
        zbc.zbc(zba, zbpVar);
        zbb(3, zba);
    }

    public final void zbd(zbs zbsVar, CredentialRequest credentialRequest) {
        Parcel zba = zba();
        zbc.zbd(zba, zbsVar);
        zbc.zbc(zba, credentialRequest);
        zbb(1, zba);
    }

    public final void zbe(zbs zbsVar, zbu zbuVar) {
        Parcel zba = zba();
        zbc.zbd(zba, zbsVar);
        zbc.zbc(zba, zbuVar);
        zbb(2, zba);
    }

    public final void zbf(zbs zbsVar) {
        Parcel zba = zba();
        zbc.zbd(zba, zbsVar);
        zbb(4, zba);
    }
}
