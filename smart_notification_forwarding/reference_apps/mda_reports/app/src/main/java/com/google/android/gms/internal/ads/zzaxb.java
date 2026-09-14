package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzaxb implements Runnable {
    final /* synthetic */ Context a;
    private final /* synthetic */ String zzdto;
    private final /* synthetic */ boolean zzdtp;
    private final /* synthetic */ boolean zzdtq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaxb(zzawy zzawyVar, Context context, String str, boolean z, boolean z2) {
        this.a = context;
        this.zzdto = str;
        this.zzdtp = z;
        this.zzdtq = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.a);
        builder.setMessage(this.zzdto);
        builder.setTitle(this.zzdtp ? "Error" : "Info");
        if (this.zzdtq) {
            builder.setNeutralButton("Dismiss", (DialogInterface.OnClickListener) null);
        } else {
            builder.setPositiveButton("Learn More", new zzaxa(this));
            builder.setNegativeButton("Dismiss", (DialogInterface.OnClickListener) null);
        }
        builder.create().show();
    }
}
