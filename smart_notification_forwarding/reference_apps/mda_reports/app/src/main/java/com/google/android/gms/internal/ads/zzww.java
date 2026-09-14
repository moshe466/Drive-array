package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.MuteThisAdReason;

/* loaded from: classes.dex */
public final class zzww implements MuteThisAdReason {
    private final String description;
    private zzwr zzcec;

    public zzww(zzwr zzwrVar) {
        String str;
        this.zzcec = zzwrVar;
        try {
            str = zzwrVar.getDescription();
        } catch (RemoteException e) {
            zzayu.zzc("", e);
            str = null;
        }
        this.description = str;
    }

    @Override // com.google.android.gms.ads.MuteThisAdReason
    public final String getDescription() {
        return this.description;
    }

    public final String toString() {
        return this.description;
    }

    public final zzwr zzpi() {
        return this.zzcec;
    }
}
