package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzbbb implements Runnable {
    private boolean zzbpe = false;
    private zzbai zzdyq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbbb(zzbai zzbaiVar) {
        this.zzdyq = zzbaiVar;
    }

    private final void zzyw() {
        zzawb.zzdsr.removeCallbacks(this);
        zzawb.zzdsr.postDelayed(this, 250L);
    }

    public final void pause() {
        this.zzbpe = true;
        this.zzdyq.a();
    }

    public final void resume() {
        this.zzbpe = false;
        zzyw();
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzbpe) {
            return;
        }
        this.zzdyq.a();
        zzyw();
    }
}
