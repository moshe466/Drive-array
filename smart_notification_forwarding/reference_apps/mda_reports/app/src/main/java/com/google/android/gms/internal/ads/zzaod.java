package com.google.android.gms.internal.ads;

import android.view.View;

/* loaded from: classes.dex */
final class zzaod implements View.OnClickListener {
    private final /* synthetic */ zzaoe zzdfg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaod(zzaoe zzaoeVar) {
        this.zzdfg = zzaoeVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.zzdfg.zzac(true);
    }
}
