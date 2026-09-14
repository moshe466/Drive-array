package com.google.android.gms.internal.fido;

import java.math.RoundingMode;
import org.apache.tika.fork.ForkServer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class zzcg extends zzch {
    private volatile zzch zza;
    final zzcd zzb;
    final Character zzc;

    public zzcg(zzcd zzcdVar, Character ch) {
        this.zzb = zzcdVar;
        if (ch != null && zzcdVar.zzc('=')) {
            throw new IllegalArgumentException(zzaq.zza("Padding character %s was already in alphabet", ch));
        }
        this.zzc = ch;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzcg) {
            zzcg zzcgVar = (zzcg) obj;
            if (this.zzb.equals(zzcgVar.zzb)) {
                Character ch = this.zzc;
                Character ch2 = zzcgVar.zzc;
                if (ch != ch2) {
                    if (ch != null && ch.equals(ch2)) {
                        return true;
                    }
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2 = this.zzb.hashCode();
        Character ch = this.zzc;
        if (ch == null) {
            hashCode = 0;
        } else {
            hashCode = ch.hashCode();
        }
        return hashCode2 ^ hashCode;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BaseEncoding.");
        sb.append(this.zzb);
        if (8 % this.zzb.zzb != 0) {
            if (this.zzc == null) {
                sb.append(".omitPadding()");
            } else {
                sb.append(".withPadChar('");
                sb.append(this.zzc);
                sb.append("')");
            }
        }
        return sb.toString();
    }

    public zzch zza(zzcd zzcdVar, Character ch) {
        return new zzcg(zzcdVar, ch);
    }

    @Override // com.google.android.gms.internal.fido.zzch
    public void zzb(Appendable appendable, byte[] bArr, int i, int i3) {
        int i4 = 0;
        zzap.zze(0, i3, bArr.length);
        while (i4 < i3) {
            zze(appendable, bArr, i4, Math.min(this.zzb.zzd, i3 - i4));
            i4 += this.zzb.zzd;
        }
    }

    @Override // com.google.android.gms.internal.fido.zzch
    public final int zzc(int i) {
        zzcd zzcdVar = this.zzb;
        return zzcj.zza(i, zzcdVar.zzd, RoundingMode.CEILING) * zzcdVar.zzc;
    }

    @Override // com.google.android.gms.internal.fido.zzch
    public final zzch zzd() {
        zzch zzchVar = this.zza;
        if (zzchVar == null) {
            zzcd zzb = this.zzb.zzb();
            if (zzb == this.zzb) {
                zzchVar = this;
            } else {
                zzchVar = zza(zzb, this.zzc);
            }
            this.zza = zzchVar;
        }
        return zzchVar;
    }

    public final void zze(Appendable appendable, byte[] bArr, int i, int i3) {
        boolean z3;
        zzap.zze(i, i + i3, bArr.length);
        int i4 = 0;
        if (i3 <= this.zzb.zzd) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzap.zzc(z3);
        long j2 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            j2 = (j2 | (bArr[i + i5] & ForkServer.ERROR)) << 8;
        }
        int i6 = ((i3 + 1) * 8) - this.zzb.zzb;
        while (i4 < i3 * 8) {
            zzcd zzcdVar = this.zzb;
            appendable.append(zzcdVar.zza(zzcdVar.zza & ((int) (j2 >>> (i6 - i4)))));
            i4 += this.zzb.zzb;
        }
        if (this.zzc != null) {
            while (i4 < this.zzb.zzd * 8) {
                this.zzc.getClass();
                appendable.append('=');
                i4 += this.zzb.zzb;
            }
        }
    }

    public zzcg(String str, String str2, Character ch) {
        this(new zzcd(str, str2.toCharArray()), ch);
    }
}
