package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;

/* loaded from: classes.dex */
final class zzbde implements DialogInterface.OnCancelListener {
    private final /* synthetic */ JsPromptResult zzeeb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbde(JsPromptResult jsPromptResult) {
        this.zzeeb = jsPromptResult;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.zzeeb.cancel();
    }
}
