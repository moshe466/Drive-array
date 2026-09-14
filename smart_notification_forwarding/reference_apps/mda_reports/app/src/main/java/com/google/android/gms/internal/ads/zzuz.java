package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzuz extends zzvb<zzacp> {
    private final /* synthetic */ zzup zzcdi;
    private final /* synthetic */ View zzcdk;
    private final /* synthetic */ HashMap zzcdl;
    private final /* synthetic */ HashMap zzcdm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzuz(zzup zzupVar, View view, HashMap hashMap, HashMap hashMap2) {
        this.zzcdi = zzupVar;
        this.zzcdk = view;
        this.zzcdl = hashMap;
        this.zzcdm = hashMap2;
    }

    @Override // com.google.android.gms.internal.ads.zzvb
    public final /* synthetic */ zzacp zza(zzwd zzwdVar) {
        return zzwdVar.zza(ObjectWrapper.wrap(this.zzcdk), ObjectWrapper.wrap(this.zzcdl), ObjectWrapper.wrap(this.zzcdm));
    }

    @Override // com.google.android.gms.internal.ads.zzvb
    protected final /* synthetic */ zzacp zzop() {
        zzup.zza(this.zzcdk.getContext(), "native_ad_view_holder_delegate");
        return new zzyk();
    }

    @Override // com.google.android.gms.internal.ads.zzvb
    public final /* synthetic */ zzacp zzoq() {
        zzaem zzaemVar;
        zzaemVar = this.zzcdi.zzcde;
        return zzaemVar.zzb(this.zzcdk, this.zzcdl, this.zzcdm);
    }
}
