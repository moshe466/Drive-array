package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzux extends zzvb<zzwk> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzup zzcdi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzux(zzup zzupVar, Context context) {
        this.zzcdi = zzupVar;
        this.val$context = context;
    }

    @Override // com.google.android.gms.internal.ads.zzvb
    public final /* synthetic */ zzwk zza(zzwd zzwdVar) {
        return zzwdVar.zza(ObjectWrapper.wrap(this.val$context), 19649000);
    }

    @Override // com.google.android.gms.internal.ads.zzvb
    protected final /* synthetic */ zzwk zzop() {
        zzup.zza(this.val$context, "mobile_ads_settings");
        return new zzyf();
    }

    @Override // com.google.android.gms.internal.ads.zzvb
    public final /* synthetic */ zzwk zzoq() {
        zzya zzyaVar;
        zzyaVar = this.zzcdi.zzccz;
        return zzyaVar.zzi(this.val$context);
    }
}
