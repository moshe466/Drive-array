package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdte;

/* loaded from: classes.dex */
final class zzdif<KeyFormatProtoT extends zzdte, KeyProtoT extends zzdte> {
    private final zzdih<KeyFormatProtoT, KeyProtoT> zzgxs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdif(zzdih<KeyFormatProtoT, KeyProtoT> zzdihVar) {
        this.zzgxs = zzdihVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final KeyProtoT a(zzdqk zzdqkVar) {
        KeyFormatProtoT zzq = this.zzgxs.zzq(zzdqkVar);
        this.zzgxs.zzc(zzq);
        return this.zzgxs.zzd(zzq);
    }
}
