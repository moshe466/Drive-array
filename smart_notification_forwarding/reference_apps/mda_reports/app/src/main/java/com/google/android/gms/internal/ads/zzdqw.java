package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public abstract class zzdqw {
    int a;
    int b;
    int c;
    zzdqz d;
    private boolean zzhii;

    private zzdqw() {
        this.b = 100;
        this.c = Integer.MAX_VALUE;
        this.zzhii = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdqw a(byte[] bArr, int i, int i2, boolean z) {
        zzdqy zzdqyVar = new zzdqy(bArr, i, i2, z);
        try {
            zzdqyVar.zzfj(i2);
            return zzdqyVar;
        } catch (zzdse e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static long zzff(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static int zzfl(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public abstract double readDouble();

    public abstract float readFloat();

    public abstract String readString();

    public abstract int zzayc();

    public abstract long zzayd();

    public abstract long zzaye();

    public abstract int zzayf();

    public abstract long zzayg();

    public abstract int zzayh();

    public abstract boolean zzayi();

    public abstract String zzayj();

    public abstract zzdqk zzayk();

    public abstract int zzayl();

    public abstract int zzaym();

    public abstract int zzayn();

    public abstract long zzayo();

    public abstract int zzayp();

    public abstract long zzayq();

    public abstract boolean zzays();

    public abstract int zzayt();

    public abstract void zzfh(int i);

    public abstract boolean zzfi(int i);

    public abstract int zzfj(int i);

    public abstract void zzfk(int i);
}
