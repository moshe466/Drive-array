package com.google.android.gms.internal.p000authapi;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.auth.api.identity.AuthorizationRequest;

/* loaded from: classes.dex */
public final class zbaa extends zba implements IInterface {
    public zbaa(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.identity.internal.IAuthorizationService");
    }

    public final void zbc(zbz zbzVar, AuthorizationRequest authorizationRequest) {
        Parcel zba = zba();
        zbc.zbd(zba, zbzVar);
        zbc.zbc(zba, authorizationRequest);
        zbb(1, zba);
    }
}
