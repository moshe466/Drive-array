package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzur extends zzvb<zzasg> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ String zzcdg;
    private final /* synthetic */ zzalc zzcdh;
    private final /* synthetic */ zzup zzcdi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzur(zzup zzupVar, Context context, String str, zzalc zzalcVar) {
        this.zzcdi = zzupVar;
        this.val$context = context;
        this.zzcdg = str;
        this.zzcdh = zzalcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzvb
    public final /* synthetic */ zzasg zza(zzwd zzwdVar) {
        return zzwdVar.zzb(ObjectWrapper.wrap(this.val$context), this.zzcdg, this.zzcdh, 19649000);
    }

    @Override // com.google.android.gms.internal.ads.zzvb
    protected final /* synthetic */ zzasg zzop() {
        zzup.zza(this.val$context, "rewarded");
        return new zzyj();
    }

    @Override // com.google.android.gms.internal.ads.zzvb
    public final /* synthetic */ zzasg zzoq() {
        return zzasw.zzd(this.val$context, this.zzcdg, this.zzcdh);
    }
}
