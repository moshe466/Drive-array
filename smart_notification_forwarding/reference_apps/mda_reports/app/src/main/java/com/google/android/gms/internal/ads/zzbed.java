package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zzbed extends zzxe {

    @GuardedBy("lock")
    private boolean zzabw;

    @GuardedBy("lock")
    private boolean zzabx;

    @GuardedBy("lock")
    private int zzada;

    @GuardedBy("lock")
    private zzxg zzddj;
    private final zzbaz zzdxu;
    private final boolean zzehf;
    private final boolean zzehg;

    @GuardedBy("lock")
    private boolean zzehh;

    @GuardedBy("lock")
    private float zzehj;

    @GuardedBy("lock")
    private float zzehk;

    @GuardedBy("lock")
    private float zzehl;
    private final Object lock = new Object();

    @GuardedBy("lock")
    private boolean zzehi = true;

    public zzbed(zzbaz zzbazVar, float f, boolean z, boolean z2) {
        this.zzdxu = zzbazVar;
        this.zzehj = f;
        this.zzehf = z;
        this.zzehg = z2;
    }

    private final void zza(final int i, final int i2, final boolean z, final boolean z2) {
        zzazd.zzdwi.execute(new Runnable(this, i, i2, z, z2) { // from class: com.google.android.gms.internal.ads.zzbef
            private final int zzdtf;
            private final int zzdtg;
            private final boolean zzefe;
            private final boolean zzeff;
            private final zzbed zzehe;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzehe = this;
                this.zzdtf = i;
                this.zzdtg = i2;
                this.zzefe = z;
                this.zzeff = z2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzehe.a(this.zzdtf, this.zzdtg, this.zzefe, this.zzeff);
            }
        });
    }

    private final void zzf(String str, @Nullable Map<String, String> map) {
        final HashMap hashMap = map == null ? new HashMap() : new HashMap(map);
        hashMap.put("action", str);
        zzazd.zzdwi.execute(new Runnable(this, hashMap) { // from class: com.google.android.gms.internal.ads.zzbec
            private final Map zzdvw;
            private final zzbed zzehe;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzehe = this;
                this.zzdvw = hashMap;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzehe.a(this.zzdvw);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(int i, int i2, boolean z, boolean z2) {
        synchronized (this.lock) {
            boolean z3 = i != i2;
            boolean z4 = !this.zzehh && i2 == 1;
            boolean z5 = z3 && i2 == 1;
            boolean z6 = z3 && i2 == 2;
            boolean z7 = z3 && i2 == 3;
            boolean z8 = z != z2;
            this.zzehh = this.zzehh || z4;
            if (z4) {
                try {
                    if (this.zzddj != null) {
                        this.zzddj.onVideoStart();
                    }
                } catch (RemoteException e) {
                    zzayu.zze("#007 Could not call remote method.", e);
                }
            }
            if (z5 && this.zzddj != null) {
                this.zzddj.onVideoPlay();
            }
            if (z6 && this.zzddj != null) {
                this.zzddj.onVideoPause();
            }
            if (z7) {
                if (this.zzddj != null) {
                    this.zzddj.onVideoEnd();
                }
                this.zzdxu.zzyu();
            }
            if (z8 && this.zzddj != null) {
                this.zzddj.onVideoMute(z2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(Map map) {
        this.zzdxu.zza("pubVideoCmd", (Map<String, ?>) map);
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final float getAspectRatio() {
        float f;
        synchronized (this.lock) {
            f = this.zzehl;
        }
        return f;
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final int getPlaybackState() {
        int i;
        synchronized (this.lock) {
            i = this.zzada;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final boolean isClickToExpandEnabled() {
        boolean z;
        boolean isCustomControlsEnabled = isCustomControlsEnabled();
        synchronized (this.lock) {
            if (!isCustomControlsEnabled) {
                try {
                    z = this.zzabx && this.zzehg;
                } finally {
                }
            }
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final boolean isCustomControlsEnabled() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzehf && this.zzabw;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final boolean isMuted() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzehi;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final void mute(boolean z) {
        zzf(z ? "mute" : "unmute", null);
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final void pause() {
        zzf("pause", null);
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final void play() {
        zzf("play", null);
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final void stop() {
        zzf("stop", null);
    }

    public final void zza(float f, float f2, int i, boolean z, float f3) {
        boolean z2;
        int i2;
        synchronized (this.lock) {
            this.zzehj = f2;
            this.zzehk = f;
            z2 = this.zzehi;
            this.zzehi = z;
            i2 = this.zzada;
            this.zzada = i;
            float f4 = this.zzehl;
            this.zzehl = f3;
            if (Math.abs(this.zzehl - f4) > 1.0E-4f) {
                this.zzdxu.getView().invalidate();
            }
        }
        zza(i2, i, z2, z);
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final void zza(zzxg zzxgVar) {
        synchronized (this.lock) {
            this.zzddj = zzxgVar;
        }
    }

    public final void zzabo() {
        boolean z;
        int i;
        synchronized (this.lock) {
            z = this.zzehi;
            i = this.zzada;
            this.zzada = 3;
        }
        zza(i, 3, z, z);
    }

    public final void zzb(zzyw zzywVar) {
        boolean z = zzywVar.zzabv;
        boolean z2 = zzywVar.zzabw;
        boolean z3 = zzywVar.zzabx;
        synchronized (this.lock) {
            this.zzabw = z2;
            this.zzabx = z3;
        }
        zzf("initialState", CollectionUtils.mapOf("muteStart", z ? "1" : "0", "customControlsRequested", z2 ? "1" : "0", "clickToExpandRequested", z3 ? "1" : "0"));
    }

    public final void zze(float f) {
        synchronized (this.lock) {
            this.zzehk = f;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final float zzpk() {
        float f;
        synchronized (this.lock) {
            f = this.zzehj;
        }
        return f;
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final float zzpl() {
        float f;
        synchronized (this.lock) {
            f = this.zzehk;
        }
        return f;
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final zzxg zzpm() {
        zzxg zzxgVar;
        synchronized (this.lock) {
            zzxgVar = this.zzddj;
        }
        return zzxgVar;
    }
}
