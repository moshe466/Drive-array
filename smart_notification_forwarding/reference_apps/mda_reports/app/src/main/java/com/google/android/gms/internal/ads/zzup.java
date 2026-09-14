package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import java.util.HashMap;

/* loaded from: classes.dex */
public class zzup {
    private final zzue zzccx;
    private final zzub zzccy;
    private final zzya zzccz;
    private final zzaej zzcda;
    private final zzars zzcdb;
    private final zzasw zzcdc;
    private final zzaor zzcdd;
    private final zzaem zzcde;

    public zzup(zzue zzueVar, zzub zzubVar, zzya zzyaVar, zzaej zzaejVar, zzars zzarsVar, zzasw zzaswVar, zzaor zzaorVar, zzaem zzaemVar) {
        this.zzccx = zzueVar;
        this.zzccy = zzubVar;
        this.zzccz = zzyaVar;
        this.zzcda = zzaejVar;
        this.zzcdb = zzarsVar;
        this.zzcdc = zzaswVar;
        this.zzcdd = zzaorVar;
        this.zzcde = zzaemVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString("flow", str);
        zzve.zzou().zza(context, zzve.zzpa().zzbma, "gmob-apps", bundle, true);
    }

    public final zzacm zza(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        return new zzva(this, frameLayout, frameLayout2, context).zzd(context, false);
    }

    public final zzacp zza(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        return new zzuz(this, view, hashMap, hashMap2).zzd(view.getContext(), false);
    }

    public final zzvu zza(Context context, zzuj zzujVar, String str, zzalc zzalcVar) {
        return new zzut(this, context, zzujVar, str, zzalcVar).zzd(context, false);
    }

    @Nullable
    public final zzaot zzb(Activity activity) {
        zzuu zzuuVar = new zzuu(this, activity);
        Intent intent = activity.getIntent();
        boolean z = false;
        if (intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            z = intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        } else {
            zzayu.zzex("useClientJar flag not found in activity intent extras.");
        }
        return zzuuVar.zzd(activity, z);
    }

    public final zzvn zzb(Context context, String str, zzalc zzalcVar) {
        return new zzuy(this, context, str, zzalcVar).zzd(context, false);
    }

    public final zzasg zzc(Context context, String str, zzalc zzalcVar) {
        return new zzur(this, context, str, zzalcVar).zzd(context, false);
    }
}
