package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzdvs implements Cloneable {
    private static final zzdvr zzhtp = new zzdvr();
    private int mSize;
    private boolean zzhtq;
    private int[] zzhtr;
    private zzdvr[] zzhts;

    zzdvs() {
        this(10);
    }

    private zzdvs(int i) {
        this.zzhtq = false;
        int i2 = i << 2;
        int i3 = 4;
        while (true) {
            if (i3 >= 32) {
                break;
            }
            int i4 = (1 << i3) - 12;
            if (i2 <= i4) {
                i2 = i4;
                break;
            }
            i3++;
        }
        int i5 = i2 / 4;
        this.zzhtr = new int[i5];
        this.zzhts = new zzdvr[i5];
        this.mSize = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int a() {
        return this.mSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzdvr a(int i) {
        return this.zzhts[i];
    }

    public final /* synthetic */ Object clone() {
        int i = this.mSize;
        zzdvs zzdvsVar = new zzdvs(i);
        System.arraycopy(this.zzhtr, 0, zzdvsVar.zzhtr, 0, i);
        for (int i2 = 0; i2 < i; i2++) {
            zzdvr[] zzdvrVarArr = this.zzhts;
            if (zzdvrVarArr[i2] != null) {
                zzdvsVar.zzhts[i2] = (zzdvr) zzdvrVarArr[i2].clone();
            }
        }
        zzdvsVar.mSize = i;
        return zzdvsVar;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdvs)) {
            return false;
        }
        zzdvs zzdvsVar = (zzdvs) obj;
        int i = this.mSize;
        if (i != zzdvsVar.mSize) {
            return false;
        }
        int[] iArr = this.zzhtr;
        int[] iArr2 = zzdvsVar.zzhtr;
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                z = true;
                break;
            }
            if (iArr[i2] != iArr2[i2]) {
                z = false;
                break;
            }
            i2++;
        }
        if (z) {
            zzdvr[] zzdvrVarArr = this.zzhts;
            zzdvr[] zzdvrVarArr2 = zzdvsVar.zzhts;
            int i3 = this.mSize;
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    z2 = true;
                    break;
                }
                if (!zzdvrVarArr[i4].equals(zzdvrVarArr2[i4])) {
                    z2 = false;
                    break;
                }
                i4++;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = 17;
        for (int i2 = 0; i2 < this.mSize; i2++) {
            i = (((i * 31) + this.zzhtr[i2]) * 31) + this.zzhts[i2].hashCode();
        }
        return i;
    }
}
