package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdte;

/* loaded from: classes.dex */
public abstract class zzdih<KeyFormatProtoT extends zzdte, KeyT> {
    private final Class<KeyFormatProtoT> zzgxv;

    public zzdih(Class<KeyFormatProtoT> cls) {
        this.zzgxv = cls;
    }

    public final Class<KeyFormatProtoT> zzasb() {
        return this.zzgxv;
    }

    public abstract void zzc(KeyFormatProtoT keyformatprotot);

    public abstract KeyT zzd(KeyFormatProtoT keyformatprotot);

    public abstract KeyFormatProtoT zzq(zzdqk zzdqkVar);
}
