package com.google.android.gms.internal.ads;

import com.google.common.primitives.Ints;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
public abstract class zzdfb<E> extends zzdet<E> implements Set<E> {

    @NullableDecl
    private transient zzdeu<E> zzguq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i) {
        int max = Math.max(i, 2);
        if (max >= 751619276) {
            zzdei.checkArgument(max < 1073741824, "collection too large");
            return Ints.MAX_POWER_OF_TWO;
        }
        int highestOneBit = Integer.highestOneBit(max - 1) << 1;
        while (true) {
            double d = highestOneBit;
            Double.isNaN(d);
            if (d * 0.7d >= max) {
                return highestOneBit;
            }
            highestOneBit <<= 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> zzdfb<E> zza(int i, Object... objArr) {
        while (i != 0) {
            if (i == 1) {
                return zzag(objArr[0]);
            }
            int a = a(i);
            Object[] objArr2 = new Object[a];
            int i2 = a - 1;
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                Object obj = objArr[i5];
                zzdff.a(obj, i5);
                int hashCode = obj.hashCode();
                int a2 = zzdeq.a(hashCode);
                while (true) {
                    int i6 = a2 & i2;
                    Object obj2 = objArr2[i6];
                    if (obj2 == null) {
                        objArr[i4] = obj;
                        objArr2[i6] = obj;
                        i3 += hashCode;
                        i4++;
                        break;
                    }
                    if (!obj2.equals(obj)) {
                        a2++;
                    }
                }
            }
            Arrays.fill(objArr, i4, i, (Object) null);
            if (i4 == 1) {
                return new zzdfm(objArr[0], i3);
            }
            if (a(i4) >= a / 2) {
                if (zzv(i4, objArr.length)) {
                    objArr = Arrays.copyOf(objArr, i4);
                }
                return new zzdfk(objArr, i3, objArr2, i2, i4);
            }
            i = i4;
        }
        return zzdfk.a;
    }

    @SafeVarargs
    public static <E> zzdfb<E> zza(E e, E e2, E e3, E e4, E e5, E e6, E... eArr) {
        zzdei.checkArgument(eArr.length <= 2147483641, "the total number of elements must fit in an int");
        Object[] objArr = new Object[eArr.length + 6];
        objArr[0] = e;
        objArr[1] = e2;
        objArr[2] = e3;
        objArr[3] = e4;
        objArr[4] = e5;
        objArr[5] = e6;
        System.arraycopy(eArr, 0, objArr, 6, eArr.length);
        return zza(objArr.length, objArr);
    }

    public static <E> zzdfb<E> zzag(E e) {
        return new zzdfm(e);
    }

    public static <E> zzdfa<E> zzdy(int i) {
        zzdeo.a(i, "expectedSize");
        return new zzdfa<>(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzv(int i, int i2) {
        return i < (i2 >> 1) + (i2 >> 2);
    }

    boolean d() {
        return false;
    }

    zzdeu<E> e() {
        return zzdeu.a(toArray());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzdfb) && d() && ((zzdfb) obj).d() && hashCode() != obj.hashCode()) {
            return false;
        }
        return zzdfn.a(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return zzdfn.a(this);
    }

    @Override // com.google.android.gms.internal.ads.zzdet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // com.google.android.gms.internal.ads.zzdet
    public zzdeu<E> zzarb() {
        zzdeu<E> zzdeuVar = this.zzguq;
        if (zzdeuVar != null) {
            return zzdeuVar;
        }
        zzdeu<E> e = e();
        this.zzguq = e;
        return e;
    }
}
