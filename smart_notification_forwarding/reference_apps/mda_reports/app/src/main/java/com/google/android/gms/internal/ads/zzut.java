package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzut extends zzvb<zzvu> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ String zzcdg;
    private final /* synthetic */ zzalc zzcdh;
    private final /* synthetic */ zzup zzcdi;
    private final /* synthetic */ zzuj zzcdj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzut(zzup zzupVar, Context context, zzuj zzujVar, String str, zzalc zzalcVar) {
        this.zzcdi = zzupVar;
        this.val$context = context;
        this.zzcdj = zzujVar;
        this.zzcdg = str;
        this.zzcdh = zzalcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzvb
    public final /* synthetic */ zzvu zza(zzwd zzwdVar) {
        return zzwdVar.zzc(ObjectWrapper.wrap(this.val$context), this.zzcdj, this.zzcdg, this.zzcdh, 19649000);
    }

    @Override // com.google.android.gms.internal.ads.zzvb
    public final /* synthetic */ zzvu zzop() {
        zzup.zza(this.val$context, FirebaseAnalytics.Event.APP_OPEN);
        return new zzyd();
    }

    @Override // com.google.android.gms.internal.ads.zzvb
    public final /* synthetic */ zzvu zzoq() {
        zzue zzueVar;
        zzueVar = this.zzcdi.zzccx;
        return zzueVar.zza(this.val$context, this.zzcdj, this.zzcdg, this.zzcdh, 4);
    }
}
