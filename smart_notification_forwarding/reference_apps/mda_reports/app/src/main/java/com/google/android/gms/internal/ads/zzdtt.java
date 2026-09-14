package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdtt extends zzdqk {
    static final int[] a = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    private final int zzhpv;
    private final zzdqk zzhpw;
    private final zzdqk zzhpx;
    private final int zzhpy;
    private final int zzhpz;

    private zzdtt(zzdqk zzdqkVar, zzdqk zzdqkVar2) {
        this.zzhpw = zzdqkVar;
        this.zzhpx = zzdqkVar2;
        this.zzhpy = zzdqkVar.size();
        this.zzhpv = this.zzhpy + zzdqkVar2.size();
        this.zzhpz = Math.max(zzdqkVar.a(), zzdqkVar2.a()) + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzdtt(zzdqk zzdqkVar, zzdqk zzdqkVar2, zzdtw zzdtwVar) {
        this(zzdqkVar, zzdqkVar2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdqk a(zzdqk zzdqkVar, zzdqk zzdqkVar2) {
        if (zzdqkVar2.size() == 0) {
            return zzdqkVar;
        }
        if (zzdqkVar.size() == 0) {
            return zzdqkVar2;
        }
        int size = zzdqkVar.size() + zzdqkVar2.size();
        if (size < 128) {
            return zzb(zzdqkVar, zzdqkVar2);
        }
        if (zzdqkVar instanceof zzdtt) {
            zzdtt zzdttVar = (zzdtt) zzdqkVar;
            if (zzdttVar.zzhpx.size() + zzdqkVar2.size() < 128) {
                return new zzdtt(zzdttVar.zzhpw, zzb(zzdttVar.zzhpx, zzdqkVar2));
            }
            if (zzdttVar.zzhpw.a() > zzdttVar.zzhpx.a() && zzdttVar.a() > zzdqkVar2.a()) {
                return new zzdtt(zzdttVar.zzhpw, new zzdtt(zzdttVar.zzhpx, zzdqkVar2));
            }
        }
        return size >= a[Math.max(zzdqkVar.a(), zzdqkVar2.a()) + 1] ? new zzdtt(zzdqkVar, zzdqkVar2) : zzdtv.a(new zzdtv(null), zzdqkVar, zzdqkVar2);
    }

    private static zzdqk zzb(zzdqk zzdqkVar, zzdqk zzdqkVar2) {
        int size = zzdqkVar.size();
        int size2 = zzdqkVar2.size();
        byte[] bArr = new byte[size + size2];
        zzdqkVar.zza(bArr, 0, 0, size);
        zzdqkVar2.zza(bArr, 0, size, size2);
        return zzdqk.a(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdqk
    public final byte a(int i) {
        int i2 = this.zzhpy;
        return i < i2 ? this.zzhpw.a(i) : this.zzhpx.a(i - i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdqk
    public final int a() {
        return this.zzhpz;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdqk
    public final int a(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.zzhpy;
        if (i4 <= i5) {
            return this.zzhpw.a(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.zzhpx.a(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.zzhpx.a(this.zzhpw.a(i, i2, i6), 0, i3 - i6);
    }

    @Override // com.google.android.gms.internal.ads.zzdqk
    protected final String a(Charset charset) {
        return new String(toByteArray(), charset);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdqk
    public final void a(zzdqh zzdqhVar) {
        this.zzhpw.a(zzdqhVar);
        this.zzhpx.a(zzdqhVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdqk
    public final void a(byte[] bArr, int i, int i2, int i3) {
        int i4 = i + i3;
        int i5 = this.zzhpy;
        if (i4 <= i5) {
            this.zzhpw.a(bArr, i, i2, i3);
        } else {
            if (i >= i5) {
                this.zzhpx.a(bArr, i - i5, i2, i3);
                return;
            }
            int i6 = i5 - i;
            this.zzhpw.a(bArr, i, i2, i6);
            this.zzhpx.a(bArr, 0, i2 + i6, i3 - i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdqk
    public final int b(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.zzhpy;
        if (i4 <= i5) {
            return this.zzhpw.b(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.zzhpx.b(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.zzhpx.b(this.zzhpw.b(i, i2, i6), 0, i3 - i6);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdqk
    public final boolean b() {
        return this.zzhpv >= a[this.zzhpz];
    }

    @Override // com.google.android.gms.internal.ads.zzdqk
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdqk)) {
            return false;
        }
        zzdqk zzdqkVar = (zzdqk) obj;
        if (this.zzhpv != zzdqkVar.size()) {
            return false;
        }
        if (this.zzhpv == 0) {
            return true;
        }
        int c = c();
        int c2 = zzdqkVar.c();
        if (c != 0 && c2 != 0 && c != c2) {
            return false;
        }
        zzdtw zzdtwVar = null;
        zzdty zzdtyVar = new zzdty(this, zzdtwVar);
        zzdqr next = zzdtyVar.next();
        zzdty zzdtyVar2 = new zzdty(zzdqkVar, zzdtwVar);
        zzdqr next2 = zzdtyVar2.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int size = next.size() - i;
            int size2 = next2.size() - i2;
            int min = Math.min(size, size2);
            if (!(i == 0 ? next.a(next2, i2, min) : next2.a(next, i, min))) {
                return false;
            }
            i3 += min;
            int i4 = this.zzhpv;
            if (i3 >= i4) {
                if (i3 == i4) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (min == size) {
                next = zzdtyVar.next();
                i = 0;
            } else {
                i += min;
                next = next;
            }
            if (min == size2) {
                next2 = zzdtyVar2.next();
                i2 = 0;
            } else {
                i2 += min;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdqk
    public final int size() {
        return this.zzhpv;
    }

    @Override // com.google.android.gms.internal.ads.zzdqk, java.lang.Iterable
    /* renamed from: zzaxs */
    public final zzdqp iterator() {
        return new zzdtw(this);
    }

    @Override // com.google.android.gms.internal.ads.zzdqk
    public final boolean zzaxu() {
        int a2 = this.zzhpw.a(0, 0, this.zzhpy);
        zzdqk zzdqkVar = this.zzhpx;
        return zzdqkVar.a(a2, 0, zzdqkVar.size()) == 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdqk
    public final zzdqw zzaxv() {
        return new zzdqx(new zzdtx(this));
    }

    @Override // com.google.android.gms.internal.ads.zzdqk
    public final byte zzfe(int i) {
        zzdqk.a(i, this.zzhpv);
        return a(i);
    }

    @Override // com.google.android.gms.internal.ads.zzdqk
    public final zzdqk zzy(int i, int i2) {
        int c = zzdqk.c(i, i2, this.zzhpv);
        if (c == 0) {
            return zzdqk.zzhhx;
        }
        if (c == this.zzhpv) {
            return this;
        }
        int i3 = this.zzhpy;
        if (i2 <= i3) {
            return this.zzhpw.zzy(i, i2);
        }
        if (i >= i3) {
            return this.zzhpx.zzy(i - i3, i2 - i3);
        }
        zzdqk zzdqkVar = this.zzhpw;
        return new zzdtt(zzdqkVar.zzy(i, zzdqkVar.size()), this.zzhpx.zzy(0, i2 - this.zzhpy));
    }
}
