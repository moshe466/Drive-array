package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzanb extends zzanc {
    private final /* synthetic */ zzamw zza;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanc, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new zzamy(this.zza);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private zzanb(zzamw zzamwVar) {
        super(zzamwVar);
        this.zza = zzamwVar;
    }
}
