package com.google.android.recaptcha.internal;

import N2.a;
import java.util.Collection;
import java.util.Objects;
import t2.AbstractC0705g;
import t2.AbstractC0707i;

/* loaded from: classes.dex */
public final class zzgp implements zzgx {
    public static final zzgp zza = new zzgp();

    private zzgp() {
    }

    @Override // com.google.android.recaptcha.internal.zzgx
    public final void zza(int i, zzgd zzgdVar, zzue... zzueVarArr) {
        String h02;
        String str;
        if (zzueVarArr.length == 1) {
            int i3 = 0;
            Object zza2 = zzgdVar.zzc().zza(zzueVarArr[0]);
            if (true != Objects.nonNull(zza2)) {
                zza2 = null;
            }
            if (zza2 != null) {
                if (zza2 instanceof int[]) {
                    int[] iArr = (int[]) zza2;
                    StringBuilder sb = new StringBuilder();
                    sb.append((CharSequence) "[");
                    int length = iArr.length;
                    int i4 = 0;
                    while (i3 < length) {
                        int i5 = iArr[i3];
                        i4++;
                        if (i4 > 1) {
                            sb.append((CharSequence) ",");
                        }
                        sb.append((CharSequence) String.valueOf(i5));
                        i3++;
                    }
                    sb.append((CharSequence) "]");
                    h02 = sb.toString();
                } else {
                    if (zza2 instanceof byte[]) {
                        str = new String((byte[]) zza2, a.f1508a);
                    } else if (zza2 instanceof long[]) {
                        long[] jArr = (long[]) zza2;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append((CharSequence) "[");
                        int length2 = jArr.length;
                        int i6 = 0;
                        while (i3 < length2) {
                            long j2 = jArr[i3];
                            i6++;
                            if (i6 > 1) {
                                sb2.append((CharSequence) ",");
                            }
                            sb2.append((CharSequence) String.valueOf(j2));
                            i3++;
                        }
                        sb2.append((CharSequence) "]");
                        h02 = sb2.toString();
                    } else if (zza2 instanceof short[]) {
                        short[] sArr = (short[]) zza2;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append((CharSequence) "[");
                        int length3 = sArr.length;
                        int i7 = 0;
                        while (i3 < length3) {
                            short s3 = sArr[i3];
                            i7++;
                            if (i7 > 1) {
                                sb3.append((CharSequence) ",");
                            }
                            sb3.append((CharSequence) String.valueOf((int) s3));
                            i3++;
                        }
                        sb3.append((CharSequence) "]");
                        h02 = sb3.toString();
                    } else if (zza2 instanceof float[]) {
                        float[] fArr = (float[]) zza2;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append((CharSequence) "[");
                        int length4 = fArr.length;
                        int i8 = 0;
                        while (i3 < length4) {
                            float f4 = fArr[i3];
                            i8++;
                            if (i8 > 1) {
                                sb4.append((CharSequence) ",");
                            }
                            sb4.append((CharSequence) String.valueOf(f4));
                            i3++;
                        }
                        sb4.append((CharSequence) "]");
                        h02 = sb4.toString();
                    } else if (zza2 instanceof double[]) {
                        double[] dArr = (double[]) zza2;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append((CharSequence) "[");
                        int length5 = dArr.length;
                        int i9 = 0;
                        while (i3 < length5) {
                            double d2 = dArr[i3];
                            i9++;
                            if (i9 > 1) {
                                sb5.append((CharSequence) ",");
                            }
                            sb5.append((CharSequence) String.valueOf(d2));
                            i3++;
                        }
                        sb5.append((CharSequence) "]");
                        h02 = sb5.toString();
                    } else if (zza2 instanceof char[]) {
                        str = new String((char[]) zza2);
                    } else if (zza2 instanceof Object[]) {
                        h02 = AbstractC0705g.M((Object[]) zza2);
                    } else if (zza2 instanceof Collection) {
                        h02 = AbstractC0707i.h0((Iterable) zza2, ",", "[", "]", null, 56);
                    } else {
                        throw new zzce(4, 5, null);
                    }
                    h02 = str;
                }
                zzgdVar.zzc().zze(i, h02);
                return;
            }
            throw new zzce(4, 5, null);
        }
        throw new zzce(4, 3, null);
    }
}
