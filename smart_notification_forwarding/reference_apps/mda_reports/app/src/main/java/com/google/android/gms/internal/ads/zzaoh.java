package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

/* loaded from: classes.dex */
final class zzaoh implements DialogInterface.OnClickListener {
    private final /* synthetic */ zzaof zzdfw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaoh(zzaof zzaofVar) {
        this.zzdfw = zzaofVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzdfw.zzds("User canceled the download.");
    }
}
