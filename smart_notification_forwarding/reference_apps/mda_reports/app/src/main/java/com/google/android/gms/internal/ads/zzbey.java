package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbey {
    public final int heightPixels;
    private final int type;
    public final int widthPixels;

    private zzbey(int i, int i2, int i3) {
        this.type = i;
        this.widthPixels = i2;
        this.heightPixels = i3;
    }

    public static zzbey zzabq() {
        return new zzbey(0, 0, 0);
    }

    public static zzbey zzabr() {
        return new zzbey(4, 0, 0);
    }

    public static zzbey zzabs() {
        return new zzbey(5, 0, 0);
    }

    public static zzbey zzb(zzuj zzujVar) {
        return zzujVar.zzcco ? new zzbey(3, 0, 0) : zzujVar.zzccq ? new zzbey(2, 0, 0) : zzujVar.zzbmc ? zzabq() : zzq(zzujVar.widthPixels, zzujVar.heightPixels);
    }

    public static zzbey zzq(int i, int i2) {
        return new zzbey(1, i, i2);
    }

    public final boolean isFluid() {
        return this.type == 2;
    }

    public final boolean zzabt() {
        return this.type == 3;
    }

    public final boolean zzabu() {
        return this.type == 0;
    }

    public final boolean zzabv() {
        return this.type == 4;
    }

    public final boolean zzabw() {
        return this.type == 5;
    }
}
