package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzuy extends zzvb<zzvn> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ String zzcdg;
    private final /* synthetic */ zzalc zzcdh;
    private final /* synthetic */ zzup zzcdi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzuy(zzup zzupVar, Context context, String str, zzalc zzalcVar) {
        this.zzcdi = zzupVar;
        this.val$context = context;
        this.zzcdg = str;
        this.zzcdh = zzalcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzvb
    public final /* synthetic */ zzvn zza(zzwd zzwdVar) {
        return zzwdVar.zza(ObjectWrapper.wrap(this.val$context), this.zzcdg, this.zzcdh, 19649000);
    }

    @Override // com.google.android.gms.internal.ads.zzvb
    protected final /* synthetic */ zzvn zzop() {
        zzup.zza(this.val$context, "native_ad");
        return new zzxz();
    }

    @Override // com.google.android.gms.internal.ads.zzvb
    public final /* synthetic */ zzvn zzoq() {
        zzub zzubVar;
        zzubVar = this.zzcdi.zzccy;
        return zzubVar.zza(this.val$context, this.zzcdg, this.zzcdh);
    }
}
