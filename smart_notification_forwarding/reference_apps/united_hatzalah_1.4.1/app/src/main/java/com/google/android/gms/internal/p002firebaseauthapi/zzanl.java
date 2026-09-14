package com.google.android.gms.internal.p002firebaseauthapi;

/* loaded from: classes.dex */
public final class zzanl extends RuntimeException {
    public zzanl(zzamc zzamcVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final zzalf zza() {
        return new zzalf(getMessage());
    }
}
