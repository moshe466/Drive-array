package com.google.android.gms.internal.p000authapi;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.GetPhoneNumberHintIntentRequest;
import com.google.android.gms.auth.api.identity.GetSignInIntentRequest;
import com.google.android.gms.common.api.internal.IStatusCallback;

/* loaded from: classes.dex */
public final class zbam extends zba implements IInterface {
    public zbam(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.identity.internal.ISignInService");
    }

    public final void zbc(zbac zbacVar, BeginSignInRequest beginSignInRequest) {
        Parcel zba = zba();
        zbc.zbd(zba, zbacVar);
        zbc.zbc(zba, beginSignInRequest);
        zbb(1, zba);
    }

    public final void zbd(zbaf zbafVar, GetPhoneNumberHintIntentRequest getPhoneNumberHintIntentRequest, String str) {
        Parcel zba = zba();
        zbc.zbd(zba, zbafVar);
        zbc.zbc(zba, getPhoneNumberHintIntentRequest);
        zba.writeString(str);
        zbb(4, zba);
    }

    public final void zbe(zbah zbahVar, GetSignInIntentRequest getSignInIntentRequest) {
        Parcel zba = zba();
        zbc.zbd(zba, zbahVar);
        zbc.zbc(zba, getSignInIntentRequest);
        zbb(3, zba);
    }

    public final void zbf(IStatusCallback iStatusCallback, String str) {
        Parcel zba = zba();
        zbc.zbd(zba, iStatusCallback);
        zba.writeString(str);
        zbb(2, zba);
    }
}
