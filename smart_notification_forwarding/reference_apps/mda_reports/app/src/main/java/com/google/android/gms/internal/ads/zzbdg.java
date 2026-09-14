package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;
import android.widget.EditText;

/* loaded from: classes.dex */
final class zzbdg implements DialogInterface.OnClickListener {
    private final /* synthetic */ JsPromptResult zzeeb;
    private final /* synthetic */ EditText zzeec;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbdg(JsPromptResult jsPromptResult, EditText editText) {
        this.zzeeb = jsPromptResult;
        this.zzeec = editText;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzeeb.confirm(this.zzeec.getText().toString());
    }
}
