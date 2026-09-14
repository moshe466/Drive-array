package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;

/* loaded from: classes.dex */
final class zzdm implements Runnable {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ Context zzwf;
    private final /* synthetic */ String zzwg;
    private final /* synthetic */ View zzwh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdm(zzdi zzdiVar, Context context, String str, View view, Activity activity) {
        this.zzwf = context;
        this.zzwg = str;
        this.zzwh = view;
        this.val$activity = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzdc zzdcVar;
        zzdcVar = zzdi.zzvc;
        zzdcVar.zza(this.zzwf, this.zzwg, this.zzwh, this.val$activity);
    }
}
