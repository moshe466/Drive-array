package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
final class zziw implements zziv {
    private final AtomicBoolean zza = new AtomicBoolean(false);

    public zziw(boolean z3) {
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zziv
    public final boolean zza() {
        return this.zza.get();
    }
}
