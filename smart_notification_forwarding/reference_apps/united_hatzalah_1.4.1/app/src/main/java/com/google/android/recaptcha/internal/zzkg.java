package com.google.android.recaptcha.internal;

import e0.a;
import java.math.RoundingMode;
import java.util.Objects;
import org.apache.tika.fork.ForkServer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class zzkg extends zzkh {
    final zzkd zza;
    final Character zzb;

    public zzkg(zzkd zzkdVar, Character ch) {
        this.zza = zzkdVar;
        if (ch != null && zzkdVar.zzd('=')) {
            throw new IllegalArgumentException(zzji.zza("Padding character %s was already in alphabet", ch));
        }
        this.zzb = ch;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzkg) {
            zzkg zzkgVar = (zzkg) obj;
            if (this.zza.equals(zzkgVar.zza) && Objects.equals(this.zzb, zzkgVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        Character ch = this.zzb;
        return Objects.hashCode(ch) ^ this.zza.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BaseEncoding.");
        sb.append(this.zza);
        if (8 % this.zza.zzb != 0) {
            if (this.zzb == null) {
                sb.append(".omitPadding()");
            } else {
                sb.append(".withPadChar('");
                sb.append(this.zzb);
                sb.append("')");
            }
        }
        return sb.toString();
    }

    @Override // com.google.android.recaptcha.internal.zzkh
    public int zza(byte[] bArr, CharSequence charSequence) {
        zzkd zzkdVar;
        CharSequence zze = zze(charSequence);
        if (this.zza.zzc(zze.length())) {
            int i = 0;
            int i3 = 0;
            while (i < zze.length()) {
                long j2 = 0;
                int i4 = 0;
                int i5 = 0;
                while (true) {
                    zzkdVar = this.zza;
                    if (i4 >= zzkdVar.zzc) {
                        break;
                    }
                    j2 <<= zzkdVar.zzb;
                    if (i + i4 < zze.length()) {
                        j2 |= this.zza.zzb(zze.charAt(i5 + i));
                        i5++;
                    }
                    i4++;
                }
                int i6 = zzkdVar.zzd;
                int i7 = i5 * zzkdVar.zzb;
                int i8 = (i6 - 1) * 8;
                while (i8 >= (i6 * 8) - i7) {
                    bArr[i3] = (byte) ((j2 >>> i8) & 255);
                    i8 -= 8;
                    i3++;
                }
                i += this.zza.zzc;
            }
            return i3;
        }
        throw new zzkf(a.c(zze.length(), "Invalid input length "));
    }

    @Override // com.google.android.recaptcha.internal.zzkh
    public void zzb(Appendable appendable, byte[] bArr, int i, int i3) {
        int i4 = 0;
        zzjf.zzd(0, i3, bArr.length);
        while (i4 < i3) {
            zzf(appendable, bArr, i4, Math.min(this.zza.zzd, i3 - i4));
            i4 += this.zza.zzd;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzkh
    public final int zzc(int i) {
        return (int) (((this.zza.zzb * i) + 7) / 8);
    }

    @Override // com.google.android.recaptcha.internal.zzkh
    public final int zzd(int i) {
        zzkd zzkdVar = this.zza;
        return zzkdVar.zzc * zzkj.zza(i, zzkdVar.zzd, RoundingMode.CEILING);
    }

    @Override // com.google.android.recaptcha.internal.zzkh
    public final CharSequence zze(CharSequence charSequence) {
        charSequence.getClass();
        if (this.zzb == null) {
            return charSequence;
        }
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                break;
            }
        } while (charSequence.charAt(length) == '=');
        return charSequence.subSequence(0, length + 1);
    }

    public final void zzf(Appendable appendable, byte[] bArr, int i, int i3) {
        boolean z3;
        zzjf.zzd(i, i + i3, bArr.length);
        int i4 = 0;
        if (i3 <= this.zza.zzd) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzjf.zza(z3);
        long j2 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            j2 = (j2 | (bArr[i + i5] & ForkServer.ERROR)) << 8;
        }
        int i6 = (i3 + 1) * 8;
        zzkd zzkdVar = this.zza;
        while (i4 < i3 * 8) {
            long j3 = j2 >>> ((i6 - zzkdVar.zzb) - i4);
            zzkd zzkdVar2 = this.zza;
            appendable.append(zzkdVar2.zza(((int) j3) & zzkdVar2.zza));
            i4 += this.zza.zzb;
        }
        if (this.zzb != null) {
            while (i4 < this.zza.zzd * 8) {
                this.zzb.getClass();
                appendable.append('=');
                i4 += this.zza.zzb;
            }
        }
    }

    public zzkg(String str, String str2, Character ch) {
        this(new zzkd(str, str2.toCharArray()), ch);
    }
}
