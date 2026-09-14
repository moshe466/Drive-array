package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class zzcxp {
    public static <T> void zza(AtomicReference<T> atomicReference, zzcxo<T> zzcxoVar) {
        T t = atomicReference.get();
        if (t == null) {
            return;
        }
        try {
            zzcxoVar.zzt(t);
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
        }
    }
}
