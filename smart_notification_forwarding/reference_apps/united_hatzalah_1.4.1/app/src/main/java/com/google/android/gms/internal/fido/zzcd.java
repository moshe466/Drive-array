package com.google.android.gms.internal.fido;

import e0.a;
import java.math.RoundingMode;
import java.util.Arrays;

/* loaded from: classes.dex */
final class zzcd {
    final int zza;
    final int zzb;
    final int zzc;
    final int zzd;
    private final String zze;
    private final char[] zzf;
    private final byte[] zzg;
    private final boolean zzh;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzcd(java.lang.String r10, char[] r11) {
        /*
            r9 = this;
            r0 = 128(0x80, float:1.794E-43)
            byte[] r1 = new byte[r0]
            r2 = -1
            java.util.Arrays.fill(r1, r2)
            r3 = 0
            r4 = r3
        La:
            int r5 = r11.length
            if (r4 >= r5) goto L2b
            char r5 = r11[r4]
            r6 = 1
            if (r5 >= r0) goto L14
            r7 = r6
            goto L15
        L14:
            r7 = r3
        L15:
            java.lang.String r8 = "Non-ASCII character: %s"
            com.google.android.gms.internal.fido.zzap.zzd(r7, r8, r5)
            r7 = r1[r5]
            if (r7 != r2) goto L1f
            goto L20
        L1f:
            r6 = r3
        L20:
            java.lang.String r7 = "Duplicate character: %s"
            com.google.android.gms.internal.fido.zzap.zzd(r6, r7, r5)
            byte r6 = (byte) r4
            r1[r5] = r6
            int r4 = r4 + 1
            goto La
        L2b:
            r9.<init>(r10, r11, r1, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.fido.zzcd.<init>(java.lang.String, char[]):void");
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzcd) {
            zzcd zzcdVar = (zzcd) obj;
            if (this.zzh == zzcdVar.zzh && Arrays.equals(this.zzf, zzcdVar.zzf)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int hashCode = Arrays.hashCode(this.zzf);
        if (true != this.zzh) {
            i = 1237;
        } else {
            i = 1231;
        }
        return hashCode + i;
    }

    public final String toString() {
        return this.zze;
    }

    public final char zza(int i) {
        return this.zzf[i];
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12 */
    public final zzcd zzb() {
        int i;
        boolean z3;
        int i3 = 0;
        for (char c4 : this.zzf) {
            if (zzad.zza(c4)) {
                char[] cArr = this.zzf;
                int length = cArr.length;
                int i4 = 0;
                while (true) {
                    if (i4 < length) {
                        char c5 = cArr[i4];
                        if (c5 >= 'A' && c5 <= 'Z') {
                            z3 = true;
                            break;
                        }
                        i4++;
                    } else {
                        z3 = false;
                        break;
                    }
                }
                if (!z3) {
                    char[] cArr2 = new char[this.zzf.length];
                    while (true) {
                        char[] cArr3 = this.zzf;
                        if (i3 >= cArr3.length) {
                            break;
                        }
                        char c6 = cArr3[i3];
                        if (zzad.zza(c6)) {
                            c6 ^= 32;
                        }
                        cArr2[i3] = (char) c6;
                        i3++;
                    }
                    zzcd zzcdVar = new zzcd(this.zze.concat(".upperCase()"), cArr2);
                    if (this.zzh && !zzcdVar.zzh) {
                        byte[] bArr = zzcdVar.zzg;
                        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
                        for (i = 65; i <= 90; i++) {
                            int i5 = i | 32;
                            byte[] bArr2 = zzcdVar.zzg;
                            byte b4 = bArr2[i];
                            byte b5 = bArr2[i5];
                            if (b4 == -1) {
                                copyOf[i] = b5;
                            } else {
                                char c7 = (char) i;
                                char c8 = (char) i5;
                                if (b5 == -1) {
                                    copyOf[i5] = b4;
                                } else {
                                    throw new IllegalStateException(zzaq.zza("Can't ignoreCase() since '%s' and '%s' encode different values", Character.valueOf(c7), Character.valueOf(c8)));
                                }
                            }
                        }
                        return new zzcd(zzcdVar.zze.concat(".ignoreCase()"), zzcdVar.zzf, copyOf, true);
                    }
                    return zzcdVar;
                }
                throw new IllegalStateException("Cannot call upperCase() on a mixed-case alphabet");
            }
        }
        return this;
    }

    public final boolean zzc(char c4) {
        byte[] bArr = this.zzg;
        if (bArr.length > 61 && bArr[61] != -1) {
            return true;
        }
        return false;
    }

    private zzcd(String str, char[] cArr, byte[] bArr, boolean z3) {
        this.zze = str;
        cArr.getClass();
        this.zzf = cArr;
        try {
            int length = cArr.length;
            int zzb = zzcj.zzb(length, RoundingMode.UNNECESSARY);
            this.zzb = zzb;
            int numberOfTrailingZeros = Integer.numberOfTrailingZeros(zzb);
            int i = 1 << (3 - numberOfTrailingZeros);
            this.zzc = i;
            this.zzd = zzb >> numberOfTrailingZeros;
            this.zza = length - 1;
            this.zzg = bArr;
            boolean[] zArr = new boolean[i];
            for (int i3 = 0; i3 < this.zzd; i3++) {
                zArr[zzcj.zza(i3 * 8, this.zzb, RoundingMode.CEILING)] = true;
            }
            this.zzh = z3;
        } catch (ArithmeticException e4) {
            throw new IllegalArgumentException(a.c(cArr.length, "Illegal alphabet length "), e4);
        }
    }
}
