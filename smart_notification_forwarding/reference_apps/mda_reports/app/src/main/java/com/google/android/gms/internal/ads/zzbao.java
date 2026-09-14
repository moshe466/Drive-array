package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

/* loaded from: classes.dex */
public final class zzbao {
    private final Context zzcgd;
    private final zzbaz zzdxu;
    private final ViewGroup zzdyp;
    private zzbai zzdyq;

    @VisibleForTesting
    private zzbao(Context context, ViewGroup viewGroup, zzbaz zzbazVar, zzbai zzbaiVar) {
        this.zzcgd = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzdyp = viewGroup;
        this.zzdxu = zzbazVar;
        this.zzdyq = null;
    }

    public zzbao(Context context, ViewGroup viewGroup, zzbdi zzbdiVar) {
        this(context, viewGroup, zzbdiVar, null);
    }

    public final void onDestroy() {
        Preconditions.checkMainThread("onDestroy must be called from the UI thread.");
        zzbai zzbaiVar = this.zzdyq;
        if (zzbaiVar != null) {
            zzbaiVar.destroy();
            this.zzdyp.removeView(this.zzdyq);
            this.zzdyq = null;
        }
    }

    public final void onPause() {
        Preconditions.checkMainThread("onPause must be called from the UI thread.");
        zzbai zzbaiVar = this.zzdyq;
        if (zzbaiVar != null) {
            zzbaiVar.pause();
        }
    }

    public final void zza(int i, int i2, int i3, int i4, int i5, boolean z, zzbaw zzbawVar) {
        if (this.zzdyq != null) {
            return;
        }
        zzzv.zza(this.zzdxu.zzyq().zzqp(), this.zzdxu.zzym(), "vpr2");
        Context context = this.zzcgd;
        zzbaz zzbazVar = this.zzdxu;
        this.zzdyq = new zzbai(context, zzbazVar, i5, z, zzbazVar.zzyq().zzqp(), zzbawVar);
        this.zzdyp.addView(this.zzdyq, 0, new ViewGroup.LayoutParams(-1, -1));
        this.zzdyq.zzd(i, i2, i3, i4);
        this.zzdxu.zzav(false);
    }

    public final void zze(int i, int i2, int i3, int i4) {
        Preconditions.checkMainThread("The underlay may only be modified from the UI thread.");
        zzbai zzbaiVar = this.zzdyq;
        if (zzbaiVar != null) {
            zzbaiVar.zzd(i, i2, i3, i4);
        }
    }

    public final zzbai zzye() {
        Preconditions.checkMainThread("getAdVideoUnderlay must be called from the UI thread.");
        return this.zzdyq;
    }
}
