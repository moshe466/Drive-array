package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzbmh<AdT> implements zzbmi<AdT> {
    private final Map<String, zzcio<AdT>> zzfft;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbmh(Map<String, zzcio<AdT>> map) {
        this.zzfft = map;
    }

    @Override // com.google.android.gms.internal.ads.zzbmi
    @Nullable
    public final zzcio<AdT> zzd(int i, String str) {
        return this.zzfft.get(str);
    }
}
