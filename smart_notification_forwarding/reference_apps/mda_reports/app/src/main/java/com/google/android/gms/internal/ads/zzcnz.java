package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
public final class zzcnz {
    private final zzcka zzftq;
    private final ConcurrentHashMap<String, zzani> zzgce = new ConcurrentHashMap<>();

    public zzcnz(zzcka zzckaVar) {
        this.zzftq = zzckaVar;
    }

    public final void zzgg(String str) {
        try {
            this.zzgce.put(str, this.zzftq.zzdi(str));
        } catch (RemoteException e) {
            zzayu.zzc("Couldn't create RTB adapter : ", e);
        }
    }

    @CheckForNull
    public final zzani zzgh(String str) {
        if (this.zzgce.containsKey(str)) {
            return this.zzgce.get(str);
        }
        return null;
    }
}
