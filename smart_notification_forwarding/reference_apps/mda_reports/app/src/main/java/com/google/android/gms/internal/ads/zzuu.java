package com.google.android.gms.internal.ads;

import android.app.Activity;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzuu extends zzvb<zzaot> {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ zzup zzcdi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzuu(zzup zzupVar, Activity activity) {
        this.zzcdi = zzupVar;
        this.val$activity = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzvb
    public final /* synthetic */ zzaot zza(zzwd zzwdVar) {
        return zzwdVar.zzb(ObjectWrapper.wrap(this.val$activity));
    }

    @Override // com.google.android.gms.internal.ads.zzvb
    protected final /* synthetic */ zzaot zzop() {
        zzup.zza(this.val$activity, "ad_overlay");
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzvb
    public final /* synthetic */ zzaot zzoq() {
        zzaor zzaorVar;
        zzaorVar = this.zzcdi.zzcdd;
        return zzaorVar.zzc(this.val$activity);
    }
}
