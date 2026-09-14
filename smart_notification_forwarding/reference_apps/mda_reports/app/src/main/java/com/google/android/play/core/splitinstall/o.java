package com.google.android.play.core.splitinstall;

import java.util.List;

/* loaded from: classes.dex */
final class o implements Runnable {
    private final /* synthetic */ SplitInstallRequest a;
    private final /* synthetic */ p b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(p pVar, SplitInstallRequest splitInstallRequest) {
        this.b = pVar;
        this.a = splitInstallRequest;
    }

    @Override // java.lang.Runnable
    public final void run() {
        n nVar;
        List b;
        nVar = this.b.b;
        List<String> moduleNames = this.a.getModuleNames();
        b = p.b(this.a.getLanguages());
        nVar.a((n) SplitInstallSessionState.a(com.google.android.play.core.internal.ag.a(moduleNames, (List<String>) b)));
    }
}
