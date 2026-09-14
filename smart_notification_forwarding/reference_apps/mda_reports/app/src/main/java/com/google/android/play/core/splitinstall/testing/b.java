package com.google.android.play.core.splitinstall.testing;

import java.io.File;
import java.util.List;

/* loaded from: classes.dex */
final class b implements Runnable {
    private final /* synthetic */ List a;
    private final /* synthetic */ FakeSplitInstallManager b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FakeSplitInstallManager fakeSplitInstallManager, List list) {
        this.b = fakeSplitInstallManager;
        this.a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a((List<File>) this.a);
    }
}
