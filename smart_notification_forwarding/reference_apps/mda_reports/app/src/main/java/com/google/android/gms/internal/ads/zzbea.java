package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzbea implements Runnable {
    private final /* synthetic */ zzbdz zzehd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbea(zzbdz zzbdzVar) {
        this.zzehd = zzbdzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        super/*android.webkit.WebView*/.destroy();
    }
}
