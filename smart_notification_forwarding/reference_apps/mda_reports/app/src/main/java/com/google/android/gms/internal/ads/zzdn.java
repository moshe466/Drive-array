package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;

/* loaded from: classes.dex */
final class zzdn implements Runnable {
    private final /* synthetic */ Context zzwf;
    private final /* synthetic */ View zzwh;
    private final /* synthetic */ Activity zzwi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdn(zzdi zzdiVar, Context context, View view, Activity activity) {
        this.zzwf = context;
        this.zzwh = view;
        this.zzwi = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzdc zzdcVar;
        zzdcVar = zzdi.zzvc;
        zzdcVar.zza(this.zzwf, this.zzwh, this.zzwi);
    }
}
