package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class zzbga {
    private final zzazb zzbli;
    private final WeakReference<Context> zzejq;
    private final Context zzyv;

    /* loaded from: classes.dex */
    public static class zza {
        private zzazb zzbli;
        private WeakReference<Context> zzejq;
        private Context zzyv;

        public final zza zza(zzazb zzazbVar) {
            this.zzbli = zzazbVar;
            return this;
        }

        public final zza zzbs(Context context) {
            this.zzejq = new WeakReference<>(context);
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.zzyv = context;
            return this;
        }
    }

    private zzbga(zza zzaVar) {
        this.zzbli = zzaVar.zzbli;
        this.zzyv = zzaVar.zzyv;
        this.zzejq = zzaVar.zzejq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Context a() {
        return this.zzyv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final WeakReference<Context> b() {
        return this.zzejq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzazb c() {
        return this.zzbli;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String d() {
        return com.google.android.gms.ads.internal.zzq.zzkq().zzr(this.zzyv, this.zzbli.zzbma);
    }

    public final zzdq zzact() {
        return new zzdq(new com.google.android.gms.ads.internal.zzh(this.zzyv, this.zzbli));
    }
}
