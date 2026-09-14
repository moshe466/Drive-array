package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;

/* loaded from: classes.dex */
final class zzbdh implements DialogInterface.OnClickListener {
    private final /* synthetic */ JsPromptResult zzeeb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbdh(JsPromptResult jsPromptResult) {
        this.zzeeb = jsPromptResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzeeb.cancel();
    }
}
