package com.google.android.recaptcha.internal;

import T.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.j;
import t2.AbstractC0705g;
import t2.AbstractC0709k;
import t2.C0716r;

/* loaded from: classes.dex */
public final class zzgy implements zzgx {
    public static final zzgy zza = new zzgy();

    private zzgy() {
    }

    private static final List zzc(Object obj) {
        boolean z3 = obj instanceof byte[];
        C0716r c0716r = C0716r.f6476a;
        int i = 0;
        if (z3) {
            byte[] bArr = (byte[]) obj;
            j.e(bArr, "<this>");
            int length = bArr.length;
            if (length != 0) {
                if (length != 1) {
                    ArrayList arrayList = new ArrayList(bArr.length);
                    int length2 = bArr.length;
                    while (i < length2) {
                        arrayList.add(Byte.valueOf(bArr[i]));
                        i++;
                    }
                    return arrayList;
                }
                return b.B(Byte.valueOf(bArr[0]));
            }
            return c0716r;
        }
        if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            j.e(sArr, "<this>");
            int length3 = sArr.length;
            if (length3 != 0) {
                if (length3 != 1) {
                    ArrayList arrayList2 = new ArrayList(sArr.length);
                    int length4 = sArr.length;
                    while (i < length4) {
                        arrayList2.add(Short.valueOf(sArr[i]));
                        i++;
                    }
                    return arrayList2;
                }
                return b.B(Short.valueOf(sArr[0]));
            }
            return c0716r;
        }
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            j.e(iArr, "<this>");
            int length5 = iArr.length;
            if (length5 != 0) {
                if (length5 != 1) {
                    ArrayList arrayList3 = new ArrayList(iArr.length);
                    int length6 = iArr.length;
                    while (i < length6) {
                        arrayList3.add(Integer.valueOf(iArr[i]));
                        i++;
                    }
                    return arrayList3;
                }
                return b.B(Integer.valueOf(iArr[0]));
            }
            return c0716r;
        }
        if (obj instanceof long[]) {
            return AbstractC0705g.Q((long[]) obj);
        }
        if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            j.e(fArr, "<this>");
            int length7 = fArr.length;
            if (length7 != 0) {
                if (length7 != 1) {
                    ArrayList arrayList4 = new ArrayList(fArr.length);
                    int length8 = fArr.length;
                    while (i < length8) {
                        arrayList4.add(Float.valueOf(fArr[i]));
                        i++;
                    }
                    return arrayList4;
                }
                return b.B(Float.valueOf(fArr[0]));
            }
            return c0716r;
        }
        if (!(obj instanceof double[])) {
            return null;
        }
        double[] dArr = (double[]) obj;
        j.e(dArr, "<this>");
        int length9 = dArr.length;
        if (length9 != 0) {
            if (length9 != 1) {
                ArrayList arrayList5 = new ArrayList(dArr.length);
                int length10 = dArr.length;
                while (i < length10) {
                    arrayList5.add(Double.valueOf(dArr[i]));
                    i++;
                }
                return arrayList5;
            }
            return b.B(Double.valueOf(dArr[0]));
        }
        return c0716r;
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
        List zzc = zzc(obj);
        List zzc2 = zzc(obj2);
        if (obj instanceof Number) {
            if (obj2 instanceof Number) {
                return Double.valueOf(Math.pow(((Number) obj).doubleValue(), ((Number) obj2).doubleValue()));
            }
            if (zzc2 != null) {
                ArrayList arrayList = new ArrayList(AbstractC0709k.Y(zzc2, 10));
                Iterator it = zzc2.iterator();
                while (it.hasNext()) {
                    arrayList.add(Double.valueOf(Math.pow(((Number) it.next()).doubleValue(), ((Number) obj).doubleValue())));
                }
                return arrayList.toArray(new Double[0]);
            }
        }
        if (zzc != null && (obj2 instanceof Number)) {
            ArrayList arrayList2 = new ArrayList(AbstractC0709k.Y(zzc, 10));
            Iterator it2 = zzc.iterator();
            while (it2.hasNext()) {
                arrayList2.add(Double.valueOf(Math.pow(((Number) it2.next()).doubleValue(), ((Number) obj2).doubleValue())));
            }
            return arrayList2.toArray(new Double[0]);
        }
        if (zzc != null && zzc2 != null) {
            zzgw.zza(this, zzc.size(), zzc2.size());
            int size = zzc.size();
            Double[] dArr = new Double[size];
            for (int i = 0; i < size; i++) {
                dArr[i] = Double.valueOf(Math.pow(((Number) zzc.get(i)).doubleValue(), ((Number) zzc2.get(i)).doubleValue()));
            }
            return dArr;
        }
        throw new zzce(4, 5, null);
    }
}
