package com.google.android.gms.common.api.internal;

import java.util.Objects;

/* loaded from: classes.dex */
final class zacj implements Runnable {
    final /* synthetic */ com.google.android.gms.signin.internal.zak zaa;
    final /* synthetic */ zacl zab;

    public zacj(zacl zaclVar, com.google.android.gms.signin.internal.zak zakVar) {
        this.zaa = zakVar;
        Objects.requireNonNull(zaclVar);
        this.zab = zaclVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zab.zae(this.zaa);
    }
}
