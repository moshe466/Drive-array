package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

/* loaded from: classes.dex */
final class zzaob implements DialogInterface.OnClickListener {
    private final /* synthetic */ zzanz zzdff;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaob(zzanz zzanzVar) {
        this.zzdff = zzanzVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzdff.zzds("Operation denied by user.");
    }
}
