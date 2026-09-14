package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zzcot {

    @GuardedBy("this")
    private boolean zzadd = false;
    private final String zzbqz;
    private final zzcox<zzbmd> zzgdi;

    @Nullable
    @GuardedBy("this")
    private zzxa zzgdj;

    public zzcot(zzcox<zzbmd> zzcoxVar, String str) {
        this.zzgdi = zzcoxVar;
        this.zzbqz = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean a(zzcot zzcotVar, boolean z) {
        zzcotVar.zzadd = false;
        return false;
    }

    public final synchronized String getMediationAdapterClassName() {
        try {
            if (this.zzgdj == null) {
                return null;
            }
            return this.zzgdj.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final synchronized boolean isLoading() {
        return this.zzgdi.isLoading();
    }

    public final synchronized void zza(zzug zzugVar, int i) {
        this.zzgdj = null;
        this.zzadd = this.zzgdi.zza(zzugVar, this.zzbqz, new zzcpc(i), new zzcow(this));
    }

    public final synchronized String zzka() {
        try {
            if (this.zzgdj == null) {
                return null;
            }
            return this.zzgdj.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
            return null;
        }
    }
}
