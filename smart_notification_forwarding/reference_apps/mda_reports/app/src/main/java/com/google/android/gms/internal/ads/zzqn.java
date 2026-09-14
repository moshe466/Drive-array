package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzqn implements ValueCallback<String> {
    private final /* synthetic */ zzqk zzbqd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzqn(zzqk zzqkVar) {
        this.zzbqd = zzqkVar;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(String str) {
        zzqk zzqkVar = this.zzbqd;
        zzqkVar.d.a(zzqkVar.a, zzqkVar.b, str, zzqkVar.c);
    }
}
