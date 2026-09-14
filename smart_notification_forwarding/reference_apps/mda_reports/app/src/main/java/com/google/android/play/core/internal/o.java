package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class o extends j implements p {
    public o() {
        super("com.google.android.play.core.appupdate.protocol.IAppUpdateServiceCallback");
    }

    @Override // com.google.android.play.core.internal.j
    protected final boolean a(int i, Parcel parcel) {
        if (i == 2) {
            a((Bundle) i.a(parcel, Bundle.CREATOR));
            return true;
        }
        if (i != 3) {
            return false;
        }
        b((Bundle) i.a(parcel, Bundle.CREATOR));
        return true;
    }
}
