package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.net.Uri;

/* loaded from: classes.dex */
final class zzaxa implements DialogInterface.OnClickListener {
    private final /* synthetic */ zzaxb zzdtn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaxa(zzaxb zzaxbVar) {
        this.zzdtn = zzaxbVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        com.google.android.gms.ads.internal.zzq.zzkq();
        zzawb.zza(this.zzdtn.a, Uri.parse("https://support.google.com/dfp_premium/answer/7160685#push"));
    }
}
