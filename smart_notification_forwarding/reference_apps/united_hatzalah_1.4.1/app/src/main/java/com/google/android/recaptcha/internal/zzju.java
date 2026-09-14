package com.google.android.recaptcha.internal;

import java.io.Serializable;
import org.apache.tika.fork.ForkServer;

/* loaded from: classes.dex */
final class zzju extends zzjv implements Serializable {
    final byte[] zza;

    public zzju(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.recaptcha.internal.zzjv
    public final int zza() {
        byte[] bArr = this.zza;
        int length = bArr.length;
        if (length >= 4) {
            int i = bArr[0] & ForkServer.ERROR;
            int i3 = bArr[1] & ForkServer.ERROR;
            int i4 = bArr[2] & ForkServer.ERROR;
            return ((bArr[3] & ForkServer.ERROR) << 24) | i | (i3 << 8) | (i4 << 16);
        }
        throw new IllegalStateException(zzji.zza("HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", Integer.valueOf(length)));
    }

    @Override // com.google.android.recaptcha.internal.zzjv
    public final int zzb() {
        return this.zza.length * 8;
    }

    @Override // com.google.android.recaptcha.internal.zzjv
    public final boolean zzc(zzjv zzjvVar) {
        boolean z3;
        if (this.zza.length != zzjvVar.zze().length) {
            return false;
        }
        boolean z4 = true;
        int i = 0;
        while (true) {
            byte[] bArr = this.zza;
            if (i < bArr.length) {
                if (bArr[i] == zzjvVar.zze()[i]) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                z4 &= z3;
                i++;
            } else {
                return z4;
            }
        }
    }

    @Override // com.google.android.recaptcha.internal.zzjv
    public final byte[] zzd() {
        return (byte[]) this.zza.clone();
    }

    @Override // com.google.android.recaptcha.internal.zzjv
    public final byte[] zze() {
        return this.zza;
    }
}
