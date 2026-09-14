package com.google.android.recaptcha.internal;

import F0.AbstractC0008a;
import com.google.android.gms.common.api.Api;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes.dex */
final class zzmv extends zzkr implements RandomAccess, zznk, zzor {
    private static final float[] zza;
    private float[] zzb;
    private int zzc;

    static {
        float[] fArr = new float[0];
        zza = fArr;
        new zzmv(fArr, 0, false);
    }

    public zzmv() {
        this(zza, 0, true);
    }

    private static int zzh(int i) {
        return Math.max(((i * 3) / 2) + 1, 10);
    }

    private final String zzi(int i) {
        return AbstractC0008a.k("Index:", i, this.zzc, ", Size:");
    }

    private final void zzj(int i) {
        if (i >= 0 && i < this.zzc) {
        } else {
            throw new IndexOutOfBoundsException(zzi(i));
        }
    }

    @Override // com.google.android.recaptcha.internal.zzkr, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i3;
        float floatValue = ((Float) obj).floatValue();
        zza();
        if (i >= 0 && i <= (i3 = this.zzc)) {
            int i4 = i + 1;
            float[] fArr = this.zzb;
            int length = fArr.length;
            if (i3 < length) {
                System.arraycopy(fArr, i, fArr, i4, i3 - i);
            } else {
                float[] fArr2 = new float[zzh(length)];
                System.arraycopy(this.zzb, 0, fArr2, 0, i);
                System.arraycopy(this.zzb, i, fArr2, i4, this.zzc - i);
                this.zzb = fArr2;
            }
            this.zzb[i] = floatValue;
            this.zzc++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(zzi(i));
    }

    @Override // com.google.android.recaptcha.internal.zzkr, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zza();
        byte[] bArr = zznl.zzb;
        collection.getClass();
        if (!(collection instanceof zzmv)) {
            return super.addAll(collection);
        }
        zzmv zzmvVar = (zzmv) collection;
        int i = zzmvVar.zzc;
        if (i == 0) {
            return false;
        }
        int i3 = this.zzc;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i3 >= i) {
            int i4 = i3 + i;
            float[] fArr = this.zzb;
            if (i4 > fArr.length) {
                this.zzb = Arrays.copyOf(fArr, i4);
            }
            System.arraycopy(zzmvVar.zzb, 0, this.zzb, this.zzc, zzmvVar.zzc);
            this.zzc = i4;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (indexOf(obj) != -1) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.recaptcha.internal.zzkr, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzmv)) {
            return super.equals(obj);
        }
        zzmv zzmvVar = (zzmv) obj;
        if (this.zzc != zzmvVar.zzc) {
            return false;
        }
        float[] fArr = zzmvVar.zzb;
        for (int i = 0; i < this.zzc; i++) {
            if (Float.floatToIntBits(this.zzb[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        zzj(i);
        return Float.valueOf(this.zzb[i]);
    }

    @Override // com.google.android.recaptcha.internal.zzkr, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i3 = 0; i3 < this.zzc; i3++) {
            i = (i * 31) + Float.floatToIntBits(this.zzb[i3]);
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float floatValue = ((Float) obj).floatValue();
        int i = this.zzc;
        for (int i3 = 0; i3 < i; i3++) {
            if (this.zzb[i3] == floatValue) {
                return i3;
            }
        }
        return -1;
    }

    @Override // com.google.android.recaptcha.internal.zzkr, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        zza();
        zzj(i);
        float[] fArr = this.zzb;
        float f4 = fArr[i];
        if (i < this.zzc - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, (r2 - i) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f4);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i3) {
        zza();
        if (i3 >= i) {
            float[] fArr = this.zzb;
            System.arraycopy(fArr, i3, fArr, i, this.zzc - i3);
            this.zzc -= i3 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.recaptcha.internal.zzkr, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        zza();
        zzj(i);
        float[] fArr = this.zzb;
        float f4 = fArr[i];
        fArr[i] = floatValue;
        return Float.valueOf(f4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.recaptcha.internal.zznk
    public final /* bridge */ /* synthetic */ zznk zzd(int i) {
        float[] copyOf;
        if (i >= this.zzc) {
            if (i == 0) {
                copyOf = zza;
            } else {
                copyOf = Arrays.copyOf(this.zzb, i);
            }
            return new zzmv(copyOf, this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    public final float zze(int i) {
        zzj(i);
        return this.zzb[i];
    }

    public final void zzf(float f4) {
        zza();
        int i = this.zzc;
        int length = this.zzb.length;
        if (i == length) {
            float[] fArr = new float[zzh(length)];
            System.arraycopy(this.zzb, 0, fArr, 0, this.zzc);
            this.zzb = fArr;
        }
        float[] fArr2 = this.zzb;
        int i3 = this.zzc;
        this.zzc = i3 + 1;
        fArr2[i3] = f4;
    }

    public final void zzg(int i) {
        int length = this.zzb.length;
        if (i <= length) {
            return;
        }
        if (length != 0) {
            while (length < i) {
                length = zzh(length);
            }
            this.zzb = Arrays.copyOf(this.zzb, length);
            return;
        }
        this.zzb = new float[Math.max(i, 10)];
    }

    private zzmv(float[] fArr, int i, boolean z3) {
        super(z3);
        this.zzb = fArr;
        this.zzc = i;
    }

    @Override // com.google.android.recaptcha.internal.zzkr, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzf(((Float) obj).floatValue());
        return true;
    }
}
