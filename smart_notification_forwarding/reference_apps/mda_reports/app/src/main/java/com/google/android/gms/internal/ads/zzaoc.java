package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzaoc implements DialogInterface.OnClickListener {
    private final /* synthetic */ zzanz zzdff;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaoc(zzanz zzanzVar) {
        this.zzdff = zzanzVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        Context context;
        Intent a = this.zzdff.a();
        com.google.android.gms.ads.internal.zzq.zzkq();
        context = this.zzdff.zzup;
        zzawb.zza(context, a);
    }
}
