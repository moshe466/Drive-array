package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzvc extends zzvb<zzarl> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzalc zzcdh;
    private final /* synthetic */ zzup zzcdi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzvc(zzup zzupVar, Context context, zzalc zzalcVar) {
        this.zzcdi = zzupVar;
        this.val$context = context;
        this.zzcdh = zzalcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzvb
    public final /* synthetic */ zzarl zza(zzwd zzwdVar) {
        return zzwdVar.zza(ObjectWrapper.wrap(this.val$context), this.zzcdh, 19649000);
    }

    @Override // com.google.android.gms.internal.ads.zzvb
    protected final /* synthetic */ zzarl zzop() {
        zzup.zza(this.val$context, "rewarded_video");
        return new zzyl();
    }

    @Override // com.google.android.gms.internal.ads.zzvb
    public final /* synthetic */ zzarl zzoq() {
        zzars zzarsVar;
        zzarsVar = this.zzcdi.zzcdb;
        return zzarsVar.zza(this.val$context, this.zzcdh);
    }
}
