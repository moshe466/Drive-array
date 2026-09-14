package com.google.android.play.core.splitinstall.testing;

import com.google.android.play.core.internal.q;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a implements Runnable {
    private final /* synthetic */ FakeSplitInstallManager a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FakeSplitInstallManager fakeSplitInstallManager) {
        this.a = fakeSplitInstallManager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        q qVar;
        AtomicReference atomicReference;
        qVar = this.a.g;
        atomicReference = FakeSplitInstallManager.k;
        qVar.a((q) atomicReference.get());
    }
}
