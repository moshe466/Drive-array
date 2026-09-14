package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* loaded from: classes.dex */
final class zzbdf implements DialogInterface.OnClickListener {
    private final /* synthetic */ JsResult zzeea;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbdf(JsResult jsResult) {
        this.zzeea = jsResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzeea.confirm();
    }
}
