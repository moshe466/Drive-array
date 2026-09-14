package com.google.android.gms.internal.fido;

import java.util.Arrays;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class zzbc extends zzav implements Set {
    private transient zzaz zza;

    private static zzbc zzf(int i, Object... objArr) {
        if (i != 0) {
            if (i != 1) {
                int zzh = zzh(i);
                Object[] objArr2 = new Object[zzh];
                int i3 = zzh - 1;
                int i4 = 0;
                int i5 = 0;
                for (int i6 = 0; i6 < i; i6++) {
                    Object obj = objArr[i6];
                    zzbq.zza(obj, i6);
                    int hashCode = obj.hashCode();
                    int zza = zzau.zza(hashCode);
                    while (true) {
                        int i7 = zza & i3;
                        Object obj2 = objArr2[i7];
                        if (obj2 == null) {
                            objArr[i5] = obj;
                            objArr2[i7] = obj;
                            i4 += hashCode;
                            i5++;
                            break;
                        }
                        if (!obj2.equals(obj)) {
                            zza++;
                        }
                    }
                }
                Arrays.fill(objArr, i5, i, (Object) null);
                if (i5 == 1) {
                    Object obj3 = objArr[0];
                    obj3.getClass();
                    return new zzby(obj3);
                }
                if (zzh(i5) >= zzh / 2) {
                    if (i5 <= 0) {
                        objArr = Arrays.copyOf(objArr, i5);
                    }
                    return new zzbt(objArr, i4, objArr2, i3, i5);
                }
                return zzf(i5, objArr);
            }
            Object obj4 = objArr[0];
            obj4.getClass();
            return new zzby(obj4);
        }
        return zzbt.zza;
    }

    public static int zzh(int i) {
        int max = Math.max(i, 2);
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1);
            do {
                highestOneBit += highestOneBit;
            } while (highestOneBit * 0.7d < max);
            return highestOneBit;
        }
        if (max < 1073741824) {
            return 1073741824;
        }
        throw new IllegalArgumentException("collection too large");
    }

    public static zzbc zzk(Object obj, Object obj2) {
        return zzf(2, obj, obj2);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzbc) && zzg() && ((zzbc) obj).zzg() && hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    if (containsAll(set)) {
                        return true;
                    }
                    return false;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return zzbx.zza(this);
    }

    @Override // com.google.android.gms.internal.fido.zzav, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: zzd */
    public abstract zzcb iterator();

    public boolean zzg() {
        return false;
    }

    public zzaz zzi() {
        zzaz zzazVar = this.zza;
        if (zzazVar == null) {
            zzaz zzj = zzj();
            this.zza = zzj;
            return zzj;
        }
        return zzazVar;
    }

    public zzaz zzj() {
        Object[] array = toArray();
        int i = zzaz.zzd;
        return zzaz.zzh(array, array.length);
    }
}
