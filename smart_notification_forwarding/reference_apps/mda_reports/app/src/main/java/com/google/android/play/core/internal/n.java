package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes.dex */
public abstract class n extends j implements l {
    public static l a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.appupdate.protocol.IAppUpdateService");
        return queryLocalInterface instanceof l ? (l) queryLocalInterface : new m(iBinder);
    }
}
