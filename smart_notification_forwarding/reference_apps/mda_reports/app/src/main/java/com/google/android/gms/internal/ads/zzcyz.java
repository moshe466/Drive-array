package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zzcyz extends zzasj {
    private final String zzbqz;
    private final zzczs zzfhh;
    private final zzcyt zzgkw;
    private final zzcxz zzgkx;

    @Nullable
    @GuardedBy("this")
    private zzcbb zzgky;

    public zzcyz(@Nullable String str, zzcyt zzcytVar, zzcxz zzcxzVar, zzczs zzczsVar) {
        this.zzbqz = str;
        this.zzgkw = zzcytVar;
        this.zzgkx = zzcxzVar;
        this.zzfhh = zzczsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzasg
    public final Bundle getAdMetadata() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzcbb zzcbbVar = this.zzgky;
        return zzcbbVar != null ? zzcbbVar.getAdMetadata() : new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzasg
    public final synchronized String getMediationAdapterClassName() {
        if (this.zzgky == null || this.zzgky.zzags() == null) {
            return null;
        }
        return this.zzgky.zzags().getMediationAdapterClassName();
    }

    @Override // com.google.android.gms.internal.ads.zzasg
    public final boolean isLoaded() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzcbb zzcbbVar = this.zzgky;
        return (zzcbbVar == null || zzcbbVar.zzaks()) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzasg
    public final synchronized void zza(IObjectWrapper iObjectWrapper, boolean z) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzgky == null) {
            zzayu.zzez("Rewarded can not be shown before loaded");
            this.zzgkx.zzco(2);
        } else {
            this.zzgky.zzb(z, (Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzasg
    public final void zza(zzasl zzaslVar) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzgkx.zzb(zzaslVar);
    }

    @Override // com.google.android.gms.internal.ads.zzasg
    public final void zza(zzast zzastVar) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzgkx.zzb(zzastVar);
    }

    @Override // com.google.android.gms.internal.ads.zzasg
    public final synchronized void zza(zzatb zzatbVar) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzczs zzczsVar = this.zzfhh;
        zzczsVar.zzdnv = zzatbVar.zzdnv;
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcja)).booleanValue()) {
            zzczsVar.zzdnw = zzatbVar.zzdnw;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzasg
    public final synchronized void zza(zzug zzugVar, zzaso zzasoVar) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzgkx.zza(zzasoVar);
        if (this.zzgky != null) {
            return;
        }
        zzcyq zzcyqVar = new zzcyq(null);
        this.zzgkw.a();
        this.zzgkw.zza(zzugVar, this.zzbqz, zzcyqVar, new zzcyy(this));
    }

    @Override // com.google.android.gms.internal.ads.zzasg
    public final void zza(zzwv zzwvVar) {
        if (zzwvVar == null) {
            this.zzgkx.zza((AdMetadataListener) null);
        } else {
            this.zzgkx.zza(new zzczb(this, zzwvVar));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzasg
    public final synchronized void zzh(IObjectWrapper iObjectWrapper) {
        zza(iObjectWrapper, false);
    }

    @Override // com.google.android.gms.internal.ads.zzasg
    public final zzxa zzkb() {
        zzcbb zzcbbVar;
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcrf)).booleanValue() && (zzcbbVar = this.zzgky) != null) {
            return zzcbbVar.zzags();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzasg
    @Nullable
    public final zzasf zzpz() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzcbb zzcbbVar = this.zzgky;
        if (zzcbbVar != null) {
            return zzcbbVar.zzpz();
        }
        return null;
    }
}
