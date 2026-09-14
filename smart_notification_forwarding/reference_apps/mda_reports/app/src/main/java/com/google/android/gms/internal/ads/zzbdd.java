package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* loaded from: classes.dex */
final class zzbdd implements DialogInterface.OnCancelListener {
    private final /* synthetic */ JsResult zzeea;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbdd(JsResult jsResult) {
        this.zzeea = jsResult;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.zzeea.cancel();
    }
}
