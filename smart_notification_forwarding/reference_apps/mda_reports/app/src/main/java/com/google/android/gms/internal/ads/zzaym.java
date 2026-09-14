package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzaym extends Thread {
    private final /* synthetic */ String zzdug;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaym(zzayn zzaynVar, String str) {
        this.zzdug = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        new zzayy().zzen(this.zzdug);
    }
}
