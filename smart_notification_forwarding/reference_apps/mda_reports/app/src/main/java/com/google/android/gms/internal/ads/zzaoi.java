package com.google.android.gms.internal.ads;

import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Environment;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzaoi implements DialogInterface.OnClickListener {
    private final /* synthetic */ zzaof zzdfw;
    private final /* synthetic */ String zzdfx;
    private final /* synthetic */ String zzdfy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaoi(zzaof zzaofVar, String str, String str2) {
        this.zzdfw = zzaofVar;
        this.zzdfx = str;
        this.zzdfy = str2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        Context context;
        context = this.zzdfw.zzup;
        DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
        try {
            String str = this.zzdfx;
            String str2 = this.zzdfy;
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
            com.google.android.gms.ads.internal.zzq.zzks();
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
            downloadManager.enqueue(request);
        } catch (IllegalStateException unused) {
            this.zzdfw.zzds("Could not store picture.");
        }
    }
}
