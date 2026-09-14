package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.Serializable;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
final class zzn extends zzl implements Serializable {
    private final Pattern zza;

    public zzn(Pattern pattern) {
        this.zza = (Pattern) zzw.zza(pattern);
    }

    public final String toString() {
        return this.zza.toString();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzl
    public final zzm zza(CharSequence charSequence) {
        return new zzq(this.zza.matcher(charSequence));
    }
}
