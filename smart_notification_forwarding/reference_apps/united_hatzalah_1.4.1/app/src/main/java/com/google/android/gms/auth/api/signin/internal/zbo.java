package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class zbo extends com.google.android.gms.internal.p000authapi.zbb implements zbp {
    public zbo() {
        super("com.google.android.gms.auth.api.signin.internal.IRevocationService");
    }

    @Override // com.google.android.gms.internal.p000authapi.zbb
    public final boolean zba(int i, Parcel parcel, Parcel parcel2, int i3) {
        if (i != 1) {
            if (i != 2) {
                return false;
            }
            zbb();
        } else {
            zbc();
        }
        return true;
    }
}
