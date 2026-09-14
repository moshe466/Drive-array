package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdte;

/* loaded from: classes.dex */
public abstract class zzdiu<KeyProtoT extends zzdte, PublicKeyProtoT extends zzdte> extends zzdii<KeyProtoT> {
    private final Class<PublicKeyProtoT> zzgym;

    /* JADX INFO: Access modifiers changed from: protected */
    @SafeVarargs
    public zzdiu(Class<KeyProtoT> cls, Class<PublicKeyProtoT> cls2, zzdik<?, KeyProtoT>... zzdikVarArr) {
        super(cls, zzdikVarArr);
        this.zzgym = cls2;
    }
}
