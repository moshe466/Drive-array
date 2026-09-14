package com.google.android.play.core.splitinstall;

/* loaded from: classes.dex */
final class m implements Runnable {
    private final /* synthetic */ SplitInstallSessionState a;
    private final /* synthetic */ int b;
    private final /* synthetic */ int c;
    private final /* synthetic */ n d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(n nVar, SplitInstallSessionState splitInstallSessionState, int i, int i2) {
        this.d = nVar;
        this.a = splitInstallSessionState;
        this.b = i;
        this.c = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        n nVar = this.d;
        SplitInstallSessionState splitInstallSessionState = this.a;
        nVar.a((n) new b(splitInstallSessionState.sessionId(), this.b, this.c, splitInstallSessionState.bytesDownloaded(), splitInstallSessionState.totalBytesToDownload(), splitInstallSessionState.a(), splitInstallSessionState.b(), splitInstallSessionState.resolutionIntent(), splitInstallSessionState.c()));
    }
}
