package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaje;
import com.google.android.gms.internal.p002firebaseauthapi.zzajf;
import e0.a;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public abstract class zzajf<MessageType extends zzajf<MessageType, BuilderType>, BuilderType extends zzaje<MessageType, BuilderType>> implements zzamc {
    protected int zza = 0;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamc
    public final zzajp a_() {
        try {
            zzaju zzc = zzajp.zzc(zzl());
            zza(zzc.zzb());
            return zzc.zza();
        } catch (IOException e4) {
            throw new RuntimeException(a.e("Serializing ", getClass().getName(), " to a ByteString threw an IOException (should never happen)."), e4);
        }
    }

    public int zza(zzamv zzamvVar) {
        int zzi = zzi();
        if (zzi != -1) {
            return zzi;
        }
        int zza = zzamvVar.zza(this);
        zzb(zza);
        return zza;
    }

    public void zzb(int i) {
        throw new UnsupportedOperationException();
    }

    public int zzi() {
        throw new UnsupportedOperationException();
    }

    public final byte[] zzk() {
        try {
            byte[] bArr = new byte[zzl()];
            zzakg zzb = zzakg.zzb(bArr);
            zza(zzb);
            zzb.zzb();
            return bArr;
        } catch (IOException e4) {
            throw new RuntimeException(a.e("Serializing ", getClass().getName(), " to a byte array threw an IOException (should never happen)."), e4);
        }
    }

    public final void zza(OutputStream outputStream) {
        zzakg zza = zzakg.zza(outputStream, zzakg.zzf(zzl()));
        zza(zza);
        zza.zzc();
    }
}
