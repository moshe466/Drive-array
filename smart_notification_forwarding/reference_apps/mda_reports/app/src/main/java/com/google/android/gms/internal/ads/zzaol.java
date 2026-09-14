package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzaol extends zzaoo implements zzafn<zzbdi> {
    private float density;
    private int maxHeight;
    private int maxWidth;
    private int rotation;
    private final WindowManager zzbnl;
    private final zzbdi zzcza;
    private final zzyy zzdge;
    private int zzdgf;
    private int zzdgg;
    private int zzdgh;
    private int zzdgi;
    private final Context zzup;
    private DisplayMetrics zzwe;

    public zzaol(zzbdi zzbdiVar, Context context, zzyy zzyyVar) {
        super(zzbdiVar);
        this.zzdgf = -1;
        this.zzdgg = -1;
        this.maxWidth = -1;
        this.maxHeight = -1;
        this.zzdgh = -1;
        this.zzdgi = -1;
        this.zzcza = zzbdiVar;
        this.zzup = context;
        this.zzdge = zzyyVar;
        this.zzbnl = (WindowManager) context.getSystemService("window");
    }

    @Override // com.google.android.gms.internal.ads.zzafn
    public final /* synthetic */ void zza(zzbdi zzbdiVar, Map map) {
        int i;
        this.zzwe = new DisplayMetrics();
        Display defaultDisplay = this.zzbnl.getDefaultDisplay();
        defaultDisplay.getMetrics(this.zzwe);
        this.density = this.zzwe.density;
        this.rotation = defaultDisplay.getRotation();
        zzve.zzou();
        DisplayMetrics displayMetrics = this.zzwe;
        this.zzdgf = zzayk.zzb(displayMetrics, displayMetrics.widthPixels);
        zzve.zzou();
        DisplayMetrics displayMetrics2 = this.zzwe;
        this.zzdgg = zzayk.zzb(displayMetrics2, displayMetrics2.heightPixels);
        Activity zzyn = this.zzcza.zzyn();
        if (zzyn == null || zzyn.getWindow() == null) {
            this.maxWidth = this.zzdgf;
            i = this.zzdgg;
        } else {
            com.google.android.gms.ads.internal.zzq.zzkq();
            int[] zzd = zzawb.zzd(zzyn);
            zzve.zzou();
            this.maxWidth = zzayk.zzb(this.zzwe, zzd[0]);
            zzve.zzou();
            i = zzayk.zzb(this.zzwe, zzd[1]);
        }
        this.maxHeight = i;
        if (this.zzcza.zzzy().zzabt()) {
            this.zzdgh = this.zzdgf;
            this.zzdgi = this.zzdgg;
        } else {
            this.zzcza.measure(0, 0);
        }
        zza(this.zzdgf, this.zzdgg, this.maxWidth, this.maxHeight, this.density, this.rotation);
        this.zzcza.zzb("onDeviceFeaturesReceived", new zzaok(new zzaom().zzae(this.zzdge.zzqb()).zzad(this.zzdge.zzqc()).zzaf(this.zzdge.zzqe()).zzag(this.zzdge.zzqd()).zzah(true)).zzth());
        int[] iArr = new int[2];
        this.zzcza.getLocationOnScreen(iArr);
        zzj(zzve.zzou().zzb(this.zzup, iArr[0]), zzve.zzou().zzb(this.zzup, iArr[1]));
        if (zzayu.isLoggable(2)) {
            zzayu.zzey("Dispatching Ready Event.");
        }
        zzdt(this.zzcza.zzyr().zzbma);
    }

    public final void zzj(int i, int i2) {
        int i3 = this.zzup instanceof Activity ? com.google.android.gms.ads.internal.zzq.zzkq().zzf((Activity) this.zzup)[0] : 0;
        if (this.zzcza.zzzy() == null || !this.zzcza.zzzy().zzabt()) {
            int width = this.zzcza.getWidth();
            int height = this.zzcza.getHeight();
            if (((Boolean) zzve.zzoy().zzd(zzzn.zzchq)).booleanValue()) {
                if (width == 0 && this.zzcza.zzzy() != null) {
                    width = this.zzcza.zzzy().widthPixels;
                }
                if (height == 0 && this.zzcza.zzzy() != null) {
                    height = this.zzcza.zzzy().heightPixels;
                }
            }
            this.zzdgh = zzve.zzou().zzb(this.zzup, width);
            this.zzdgi = zzve.zzou().zzb(this.zzup, height);
        }
        zzc(i, i2 - i3, this.zzdgh, this.zzdgi);
        this.zzcza.zzaaa().zzi(i, i2);
    }
}
