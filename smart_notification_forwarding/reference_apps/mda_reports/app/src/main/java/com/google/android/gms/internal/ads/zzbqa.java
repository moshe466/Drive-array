package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzbqa extends zzbrl<AdMetadataListener> implements zzaew {
    private Bundle zzfht;

    public zzbqa(Set<zzbsu<AdMetadataListener>> set) {
        super(set);
        this.zzfht = new Bundle();
    }

    public final synchronized Bundle getAdMetadata() {
        return new Bundle(this.zzfht);
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final synchronized void zza(String str, Bundle bundle) {
        this.zzfht.putAll(bundle);
        a(zzbqd.a);
    }
}
