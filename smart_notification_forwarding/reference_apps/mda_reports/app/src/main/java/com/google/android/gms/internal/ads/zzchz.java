package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzchz {
    private int responseCode = 0;
    private long zzfxc = 0;
    private long zzfxd = 0;
    private long zzfxe = 0;
    private final Object zzfxf = new Object();
    private final Object zzfxg = new Object();
    private final Object zzfxh = new Object();
    private final Object zzfxi = new Object();

    public final int getResponseCode() {
        int i;
        synchronized (this.zzfxf) {
            i = this.responseCode;
        }
        return i;
    }

    public final long zzaly() {
        long j;
        synchronized (this.zzfxg) {
            j = this.zzfxc;
        }
        return j;
    }

    public final synchronized long zzalz() {
        long j;
        synchronized (this.zzfxh) {
            j = this.zzfxd;
        }
        return j;
    }

    public final synchronized long zzama() {
        long j;
        synchronized (this.zzfxi) {
            j = this.zzfxe;
        }
        return j;
    }

    public final void zzdk(int i) {
        synchronized (this.zzfxf) {
            this.responseCode = i;
        }
    }

    public final void zzeq(long j) {
        synchronized (this.zzfxg) {
            this.zzfxc = j;
        }
    }

    public final synchronized void zzer(long j) {
        synchronized (this.zzfxi) {
            this.zzfxe = j;
        }
    }

    public final synchronized void zzfe(long j) {
        synchronized (this.zzfxh) {
            this.zzfxd = j;
        }
    }
}
