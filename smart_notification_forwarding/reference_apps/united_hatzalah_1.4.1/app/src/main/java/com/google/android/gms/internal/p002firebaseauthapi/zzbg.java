package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.OutputStream;

/* loaded from: classes.dex */
public final class zzbg implements zzbx {
    private final OutputStream zza;

    private zzbg(OutputStream outputStream) {
        this.zza = outputStream;
    }

    public static zzbx zza(OutputStream outputStream) {
        return new zzbg(outputStream);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbx
    public final void zza(zzvq zzvqVar) {
        try {
            ((zzvq) ((zzaky) zzvqVar.zzn().zza().zze())).zza(this.zza);
        } finally {
            this.zza.close();
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbx
    public final void zza(zzxc zzxcVar) {
        try {
            zzxcVar.zza(this.zza);
        } finally {
            this.zza.close();
        }
    }
}
