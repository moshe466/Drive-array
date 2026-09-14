package com.google.android.recaptcha.internal;

import K2.e;
import K2.f;
import N2.a;
import T.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import t2.AbstractC0707i;
import t2.AbstractC0709k;

/* loaded from: classes.dex */
public final class zzht implements zzgx {
    public static final zzht zza = new zzht();

    private zzht() {
    }

    @Override // com.google.android.recaptcha.internal.zzgx
    public final void zza(int i, zzgd zzgdVar, zzue... zzueVarArr) {
        if (zzueVarArr.length == 2) {
            Object zza2 = zzgdVar.zzc().zza(zzueVarArr[0]);
            if (true != Objects.nonNull(zza2)) {
                zza2 = null;
            }
            if (zza2 != null) {
                Object zza3 = zzgdVar.zzc().zza(zzueVarArr[1]);
                if (true != Objects.nonNull(zza3)) {
                    zza3 = null;
                }
                if (zza3 != null) {
                    zzgdVar.zzc().zze(i, zzb(zza2, zza3));
                    return;
                }
                throw new zzce(4, 5, null);
            }
            throw new zzce(4, 5, null);
        }
        throw new zzce(4, 3, null);
    }

    public final Object zzb(Object obj, Object obj2) {
        boolean z3 = obj instanceof Byte;
        if (z3 && (obj2 instanceof Byte)) {
            return Byte.valueOf((byte) (((Number) obj).byteValue() ^ ((Number) obj2).byteValue()));
        }
        boolean z4 = obj instanceof Short;
        if (z4 && (obj2 instanceof Short)) {
            return Short.valueOf((short) (((Number) obj).shortValue() ^ ((Number) obj2).shortValue()));
        }
        boolean z5 = obj instanceof Integer;
        if (z5 && (obj2 instanceof Integer)) {
            return Integer.valueOf(((Number) obj).intValue() ^ ((Number) obj2).intValue());
        }
        boolean z6 = obj instanceof Long;
        if (z6 && (obj2 instanceof Long)) {
            return Long.valueOf(((Number) obj2).longValue() ^ ((Number) obj).longValue());
        }
        int i = 0;
        if (obj instanceof String) {
            if (obj2 instanceof Byte) {
                byte[] bytes = ((String) obj).getBytes(a.f1508a);
                int length = bytes.length;
                ArrayList arrayList = new ArrayList(length);
                while (i < length) {
                    arrayList.add(Byte.valueOf((byte) (bytes[i] ^ ((Number) obj2).byteValue())));
                    i++;
                }
                return AbstractC0707i.n0(arrayList);
            }
            if (obj2 instanceof Integer) {
                char[] charArray = ((String) obj).toCharArray();
                int length2 = charArray.length;
                ArrayList arrayList2 = new ArrayList(length2);
                while (i < length2) {
                    arrayList2.add(Integer.valueOf(charArray[i] ^ ((Number) obj2).intValue()));
                    i++;
                }
                return AbstractC0707i.p0(arrayList2);
            }
        }
        if (z3 && (obj2 instanceof byte[])) {
            byte[] bArr = (byte[]) obj2;
            ArrayList arrayList3 = new ArrayList(bArr.length);
            for (byte b4 : bArr) {
                arrayList3.add(Byte.valueOf((byte) (b4 ^ ((Number) obj).byteValue())));
            }
            return arrayList3.toArray(new Byte[0]);
        }
        if (z4 && (obj2 instanceof short[])) {
            short[] sArr = (short[]) obj2;
            ArrayList arrayList4 = new ArrayList(sArr.length);
            for (short s3 : sArr) {
                arrayList4.add(Short.valueOf((short) (s3 ^ ((Number) obj).shortValue())));
            }
            return arrayList4.toArray(new Short[0]);
        }
        if (z5 && (obj2 instanceof int[])) {
            int[] iArr = (int[]) obj2;
            ArrayList arrayList5 = new ArrayList(iArr.length);
            for (int i3 : iArr) {
                arrayList5.add(Integer.valueOf(i3 ^ ((Number) obj).intValue()));
            }
            return arrayList5.toArray(new Integer[0]);
        }
        if (z6 && (obj2 instanceof long[])) {
            long[] jArr = (long[]) obj2;
            ArrayList arrayList6 = new ArrayList(jArr.length);
            for (long j2 : jArr) {
                arrayList6.add(Long.valueOf(j2 ^ ((Number) obj).longValue()));
            }
            return arrayList6.toArray(new Long[0]);
        }
        boolean z7 = obj instanceof byte[];
        if (z7 && (obj2 instanceof Byte)) {
            byte[] bArr2 = (byte[]) obj;
            ArrayList arrayList7 = new ArrayList(bArr2.length);
            for (byte b5 : bArr2) {
                arrayList7.add(Byte.valueOf((byte) (b5 ^ ((Number) obj2).byteValue())));
            }
            return arrayList7.toArray(new Byte[0]);
        }
        boolean z8 = obj instanceof short[];
        if (z8 && (obj2 instanceof Short)) {
            short[] sArr2 = (short[]) obj;
            ArrayList arrayList8 = new ArrayList(sArr2.length);
            for (short s4 : sArr2) {
                arrayList8.add(Short.valueOf((short) (s4 ^ ((Number) obj2).shortValue())));
            }
            return arrayList8.toArray(new Short[0]);
        }
        boolean z9 = obj instanceof int[];
        if (z9 && (obj2 instanceof Integer)) {
            int[] iArr2 = (int[]) obj;
            ArrayList arrayList9 = new ArrayList(iArr2.length);
            for (int i4 : iArr2) {
                arrayList9.add(Integer.valueOf(i4 ^ ((Number) obj2).intValue()));
            }
            return arrayList9.toArray(new Integer[0]);
        }
        boolean z10 = obj instanceof long[];
        if (z10 && (obj2 instanceof Long)) {
            long[] jArr2 = (long[]) obj;
            ArrayList arrayList10 = new ArrayList(jArr2.length);
            for (long j3 : jArr2) {
                arrayList10.add(Long.valueOf(j3 ^ ((Number) obj2).longValue()));
            }
            return arrayList10.toArray(new Long[0]);
        }
        if (z7 && (obj2 instanceof byte[])) {
            byte[] bArr3 = (byte[]) obj;
            int length3 = bArr3.length;
            byte[] bArr4 = (byte[]) obj2;
            zzgw.zza(this, length3, bArr4.length);
            f Q3 = b.Q(0, length3);
            ArrayList arrayList11 = new ArrayList(AbstractC0709k.Y(Q3, 10));
            Iterator it = Q3.iterator();
            while (((e) it).f1123c) {
                int nextInt = ((e) it).nextInt();
                arrayList11.add(Byte.valueOf((byte) (bArr4[nextInt] ^ bArr3[nextInt])));
            }
            return arrayList11.toArray(new Byte[0]);
        }
        if (z8 && (obj2 instanceof short[])) {
            short[] sArr3 = (short[]) obj;
            int length4 = sArr3.length;
            short[] sArr4 = (short[]) obj2;
            zzgw.zza(this, length4, sArr4.length);
            f Q4 = b.Q(0, length4);
            ArrayList arrayList12 = new ArrayList(AbstractC0709k.Y(Q4, 10));
            Iterator it2 = Q4.iterator();
            while (((e) it2).f1123c) {
                int nextInt2 = ((e) it2).nextInt();
                arrayList12.add(Short.valueOf((short) (sArr4[nextInt2] ^ sArr3[nextInt2])));
            }
            return arrayList12.toArray(new Short[0]);
        }
        if (z9 && (obj2 instanceof int[])) {
            int[] iArr3 = (int[]) obj;
            int length5 = iArr3.length;
            int[] iArr4 = (int[]) obj2;
            zzgw.zza(this, length5, iArr4.length);
            f Q5 = b.Q(0, length5);
            ArrayList arrayList13 = new ArrayList(AbstractC0709k.Y(Q5, 10));
            Iterator it3 = Q5.iterator();
            while (((e) it3).f1123c) {
                int nextInt3 = ((e) it3).nextInt();
                arrayList13.add(Integer.valueOf(iArr4[nextInt3] ^ iArr3[nextInt3]));
            }
            return arrayList13.toArray(new Integer[0]);
        }
        if (z10 && (obj2 instanceof long[])) {
            long[] jArr3 = (long[]) obj;
            int length6 = jArr3.length;
            long[] jArr4 = (long[]) obj2;
            zzgw.zza(this, length6, jArr4.length);
            f Q6 = b.Q(0, length6);
            ArrayList arrayList14 = new ArrayList(AbstractC0709k.Y(Q6, 10));
            Iterator it4 = Q6.iterator();
            while (((e) it4).f1123c) {
                int nextInt4 = ((e) it4).nextInt();
                arrayList14.add(Long.valueOf(jArr3[nextInt4] ^ jArr4[nextInt4]));
            }
            return arrayList14.toArray(new Long[0]);
        }
        throw new zzce(4, 5, null);
    }
}
