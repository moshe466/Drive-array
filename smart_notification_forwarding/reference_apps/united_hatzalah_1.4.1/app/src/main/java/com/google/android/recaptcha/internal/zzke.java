package com.google.android.recaptcha.internal;

import e0.a;
import org.apache.tika.fork.ForkServer;

/* loaded from: classes.dex */
final class zzke extends zzkg {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzke(java.lang.String r2, java.lang.String r3, java.lang.Character r4) {
        /*
            r1 = this;
            com.google.android.recaptcha.internal.zzkd r0 = new com.google.android.recaptcha.internal.zzkd
            char[] r3 = r3.toCharArray()
            r0.<init>(r2, r3)
            r1.<init>(r0, r4)
            char[] r2 = com.google.android.recaptcha.internal.zzkd.zze(r0)
            int r2 = r2.length
            r3 = 64
            if (r2 != r3) goto L17
            r2 = 1
            goto L18
        L17:
            r2 = 0
        L18:
            com.google.android.recaptcha.internal.zzjf.zza(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzke.<init>(java.lang.String, java.lang.String, java.lang.Character):void");
    }

    @Override // com.google.android.recaptcha.internal.zzkg, com.google.android.recaptcha.internal.zzkh
    public final int zza(byte[] bArr, CharSequence charSequence) {
        CharSequence zze = zze(charSequence);
        if (this.zza.zzc(zze.length())) {
            int i = 0;
            int i3 = 0;
            while (i < zze.length()) {
                int i4 = i3 + 1;
                int zzb = (this.zza.zzb(zze.charAt(i)) << 18) | (this.zza.zzb(zze.charAt(i + 1)) << 12);
                bArr[i3] = (byte) (zzb >>> 16);
                int i5 = i + 2;
                if (i5 < zze.length()) {
                    int i6 = i + 3;
                    int zzb2 = zzb | (this.zza.zzb(zze.charAt(i5)) << 6);
                    int i7 = i3 + 2;
                    bArr[i4] = (byte) ((zzb2 >>> 8) & 255);
                    if (i6 < zze.length()) {
                        i += 4;
                        i3 += 3;
                        bArr[i7] = (byte) ((zzb2 | this.zza.zzb(zze.charAt(i6))) & 255);
                    } else {
                        i3 = i7;
                        i = i6;
                    }
                } else {
                    i = i5;
                    i3 = i4;
                }
            }
            return i3;
        }
        throw new zzkf(a.c(zze.length(), "Invalid input length "));
    }

    @Override // com.google.android.recaptcha.internal.zzkg, com.google.android.recaptcha.internal.zzkh
    public final void zzb(Appendable appendable, byte[] bArr, int i, int i3) {
        int i4 = 0;
        zzjf.zzd(0, i3, bArr.length);
        for (int i5 = i3; i5 >= 3; i5 -= 3) {
            int i6 = bArr[i4] & ForkServer.ERROR;
            int i7 = ((bArr[i4 + 1] & ForkServer.ERROR) << 8) | (i6 << 16) | (bArr[i4 + 2] & ForkServer.ERROR);
            appendable.append(this.zza.zza(i7 >>> 18));
            appendable.append(this.zza.zza((i7 >>> 12) & 63));
            appendable.append(this.zza.zza((i7 >>> 6) & 63));
            appendable.append(this.zza.zza(i7 & 63));
            i4 += 3;
        }
        if (i4 < i3) {
            zzf(appendable, bArr, i4, i3 - i4);
        }
    }
}
