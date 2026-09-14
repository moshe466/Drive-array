package com.google.android.recaptcha.internal;

import F0.AbstractC0008a;
import com.google.android.gms.common.api.Api;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzne extends zzkr implements RandomAccess, zzni, zzor {
    private static final int[] zza;
    private static final zzne zzb;
    private int[] zzc;
    private int zzd;

    static {
        int[] iArr = new int[0];
        zza = iArr;
        zzb = new zzne(iArr, 0, false);
    }

    public zzne() {
        this(zza, 0, true);
    }

    public static zzne zzf() {
        return zzb;
    }

    private static int zzj(int i) {
        return Math.max(((i * 3) / 2) + 1, 10);
    }

    private final String zzk(int i) {
        return AbstractC0008a.k("Index:", i, this.zzd, ", Size:");
    }

    private final void zzl(int i) {
        if (i >= 0 && i < this.zzd) {
        } else {
            throw new IndexOutOfBoundsException(zzk(i));
        }
    }

    @Override // com.google.android.recaptcha.internal.zzkr, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i3;
        int intValue = ((Integer) obj).intValue();
        zza();
        if (i >= 0 && i <= (i3 = this.zzd)) {
            int i4 = i + 1;
            int[] iArr = this.zzc;
            int length = iArr.length;
            if (i3 < length) {
                System.arraycopy(iArr, i, iArr, i4, i3 - i);
            } else {
                int[] iArr2 = new int[zzj(length)];
                System.arraycopy(this.zzc, 0, iArr2, 0, i);
                System.arraycopy(this.zzc, i, iArr2, i4, this.zzd - i);
                this.zzc = iArr2;
            }
            this.zzc[i] = intValue;
            this.zzd++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(zzk(i));
    }

    @Override // com.google.android.recaptcha.internal.zzkr, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zza();
        byte[] bArr = zznl.zzb;
        collection.getClass();
        if (!(collection instanceof zzne)) {
            return super.addAll(collection);
        }
        zzne zzneVar = (zzne) collection;
        int i = zzneVar.zzd;
        if (i == 0) {
            return false;
        }
        int i3 = this.zzd;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i3 >= i) {
            int i4 = i3 + i;
            int[] iArr = this.zzc;
            if (i4 > iArr.length) {
                this.zzc = Arrays.copyOf(iArr, i4);
            }
            System.arraycopy(zzneVar.zzc, 0, this.zzc, this.zzd, zzneVar.zzd);
            this.zzd = i4;
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
        if (!(obj instanceof zzne)) {
            return super.equals(obj);
        }
        zzne zzneVar = (zzne) obj;
        if (this.zzd != zzneVar.zzd) {
            return false;
        }
        int[] iArr = zzneVar.zzc;
        for (int i = 0; i < this.zzd; i++) {
            if (this.zzc[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        zzl(i);
        return Integer.valueOf(this.zzc[i]);
    }

    @Override // com.google.android.recaptcha.internal.zzkr, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i3 = 0; i3 < this.zzd; i3++) {
            i = (i * 31) + this.zzc[i3];
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int i = this.zzd;
        for (int i3 = 0; i3 < i; i3++) {
            if (this.zzc[i3] == intValue) {
                return i3;
            }
        }
        return -1;
    }

    @Override // com.google.android.recaptcha.internal.zzkr, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        zza();
        zzl(i);
        int[] iArr = this.zzc;
        int i3 = iArr[i];
        if (i < this.zzd - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (r2 - i) - 1);
        }
        this.zzd--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i3);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i3) {
        zza();
        if (i3 >= i) {
            int[] iArr = this.zzc;
            System.arraycopy(iArr, i3, iArr, i, this.zzd - i3);
            this.zzd -= i3 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.recaptcha.internal.zzkr, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        zza();
        zzl(i);
        int[] iArr = this.zzc;
        int i3 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzd;
    }

    public final int zze(int i) {
        zzl(i);
        return this.zzc[i];
    }

    @Override // com.google.android.recaptcha.internal.zznk
    /* renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final zzni zzd(int i) {
        int[] copyOf;
        if (i >= this.zzd) {
            if (i == 0) {
                copyOf = zza;
            } else {
                copyOf = Arrays.copyOf(this.zzc, i);
            }
            return new zzne(copyOf, this.zzd, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.recaptcha.internal.zzni
    public final void zzh(int i) {
        zza();
        int i3 = this.zzd;
        int length = this.zzc.length;
        if (i3 == length) {
            int[] iArr = new int[zzj(length)];
            System.arraycopy(this.zzc, 0, iArr, 0, this.zzd);
            this.zzc = iArr;
        }
        int[] iArr2 = this.zzc;
        int i4 = this.zzd;
        this.zzd = i4 + 1;
        iArr2[i4] = i;
    }

    public final void zzi(int i) {
        int length = this.zzc.length;
        if (i <= length) {
            return;
        }
        if (length != 0) {
            while (length < i) {
                length = zzj(length);
            }
            this.zzc = Arrays.copyOf(this.zzc, length);
            return;
        }
        this.zzc = new int[Math.max(i, 10)];
    }

    private zzne(int[] iArr, int i, boolean z3) {
        super(z3);
        this.zzc = iArr;
        this.zzd = i;
    }

    @Override // com.google.android.recaptcha.internal.zzkr, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzh(((Integer) obj).intValue());
        return true;
    }
}
