package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes.dex */
public abstract class bb extends j implements bc {
    public static bc a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.splitinstall.protocol.ISplitInstallService");
        return queryLocalInterface instanceof bc ? (bc) queryLocalInterface : new be(iBinder);
    }
}
