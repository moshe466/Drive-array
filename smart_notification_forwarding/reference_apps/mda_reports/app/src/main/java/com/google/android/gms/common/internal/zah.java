package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public final class zah extends com.google.android.gms.internal.base.zaa implements ISignInButtonCreator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zah(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ISignInButtonCreator");
    }

    @Override // com.google.android.gms.common.internal.ISignInButtonCreator
    public final IObjectWrapper newSignInButton(IObjectWrapper iObjectWrapper, int i, int i2) {
        Parcel c = c();
        com.google.android.gms.internal.base.zac.zaa(c, iObjectWrapper);
        c.writeInt(i);
        c.writeInt(i2);
        Parcel a = a(1, c);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a.readStrongBinder());
        a.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.common.internal.ISignInButtonCreator
    public final IObjectWrapper newSignInButtonFromConfig(IObjectWrapper iObjectWrapper, SignInButtonConfig signInButtonConfig) {
        Parcel c = c();
        com.google.android.gms.internal.base.zac.zaa(c, iObjectWrapper);
        com.google.android.gms.internal.base.zac.zaa(c, signInButtonConfig);
        Parcel a = a(2, c);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a.readStrongBinder());
        a.recycle();
        return asInterface;
    }
}
