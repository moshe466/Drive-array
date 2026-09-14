package com.google.android.gms.signin.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.IAccountAccessor;

/* loaded from: classes.dex */
public final class zag extends com.google.android.gms.internal.base.zaa implements zaf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zag(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    @Override // com.google.android.gms.signin.internal.zaf
    public final void zaa(IAccountAccessor iAccountAccessor, int i, boolean z) {
        Parcel c = c();
        com.google.android.gms.internal.base.zac.zaa(c, iAccountAccessor);
        c.writeInt(i);
        com.google.android.gms.internal.base.zac.writeBoolean(c, z);
        b(9, c);
    }

    @Override // com.google.android.gms.signin.internal.zaf
    public final void zaa(zah zahVar, zad zadVar) {
        Parcel c = c();
        com.google.android.gms.internal.base.zac.zaa(c, zahVar);
        com.google.android.gms.internal.base.zac.zaa(c, zadVar);
        b(12, c);
    }

    @Override // com.google.android.gms.signin.internal.zaf
    public final void zam(int i) {
        Parcel c = c();
        c.writeInt(i);
        b(7, c);
    }
}
