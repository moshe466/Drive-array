package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import java.util.HashSet;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zzdak implements zzavk, zzbow {
    private final zzavp zzdpz;

    @GuardedBy("this")
    private final HashSet<zzavd> zzgnb = new HashSet<>();
    private final Context zzup;

    public zzdak(Context context, zzavp zzavpVar) {
        this.zzup = context;
        this.zzdpz = zzavpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbow
    public final synchronized void onAdFailedToLoad(int i) {
        if (i != 3) {
            this.zzdpz.zzb(this.zzgnb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavk
    public final synchronized void zza(HashSet<zzavd> hashSet) {
        this.zzgnb.clear();
        this.zzgnb.addAll(hashSet);
    }

    public final Bundle zzaov() {
        return this.zzdpz.zza(this.zzup, this);
    }
}
