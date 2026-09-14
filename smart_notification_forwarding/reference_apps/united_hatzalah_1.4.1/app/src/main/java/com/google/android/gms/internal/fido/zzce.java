package com.google.android.gms.internal.fido;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import org.apache.tika.fork.ForkServer;

/* loaded from: classes.dex */
final class zzce extends zzcg {
    final char[] zza;

    private zzce(zzcd zzcdVar) {
        super(zzcdVar, null);
        char[] cArr;
        this.zza = new char[UserVerificationMethods.USER_VERIFY_NONE];
        cArr = zzcdVar.zzf;
        zzap.zzc(cArr.length == 16);
        for (int i = 0; i < 256; i++) {
            this.zza[i] = zzcdVar.zza(i >>> 4);
            this.zza[i | UserVerificationMethods.USER_VERIFY_HANDPRINT] = zzcdVar.zza(i & 15);
        }
    }

    @Override // com.google.android.gms.internal.fido.zzcg
    public final zzch zza(zzcd zzcdVar, Character ch) {
        return new zzce(zzcdVar);
    }

    @Override // com.google.android.gms.internal.fido.zzcg, com.google.android.gms.internal.fido.zzch
    public final void zzb(Appendable appendable, byte[] bArr, int i, int i3) {
        zzap.zze(0, i3, bArr.length);
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = bArr[i4] & ForkServer.ERROR;
            appendable.append(this.zza[i5]);
            appendable.append(this.zza[i5 | UserVerificationMethods.USER_VERIFY_HANDPRINT]);
        }
    }

    public zzce(String str, String str2) {
        this(new zzcd("base16()", "0123456789ABCDEF".toCharArray()));
    }
}
