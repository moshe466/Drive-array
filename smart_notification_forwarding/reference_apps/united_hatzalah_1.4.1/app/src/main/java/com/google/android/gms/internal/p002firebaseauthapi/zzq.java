package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.regex.Matcher;

/* loaded from: classes.dex */
final class zzq extends zzm {
    private final Matcher zza;

    public zzq(Matcher matcher) {
        this.zza = (Matcher) zzw.zza(matcher);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzm
    public final int zza() {
        return this.zza.end();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzm
    public final int zzb() {
        return this.zza.start();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzm
    public final boolean zzc() {
        return this.zza.matches();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzm
    public final boolean zza(int i) {
        return this.zza.find(i);
    }
}
