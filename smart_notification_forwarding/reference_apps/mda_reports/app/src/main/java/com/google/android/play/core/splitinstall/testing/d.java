package com.google.android.play.core.splitinstall.testing;

import android.content.Intent;
import com.google.android.play.core.splitinstall.testing.FakeSplitInstallManager;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d implements Runnable {
    private final /* synthetic */ long a;
    private final /* synthetic */ List b;
    private final /* synthetic */ List c;
    private final /* synthetic */ FakeSplitInstallManager d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(FakeSplitInstallManager fakeSplitInstallManager, long j, List list, List list2) {
        this.d = fakeSplitInstallManager;
        this.a = j;
        this.b = list;
        this.c = list2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicBoolean atomicBoolean;
        FakeSplitInstallManager.a aVar;
        long j = this.a / 3;
        long j2 = 0;
        for (int i = 0; i < 3; i++) {
            j2 = Math.min(this.a, j2 + j);
            this.d.b(2, 0, Long.valueOf(j2), null, null, null);
            aVar = this.d.i;
            aVar.a();
        }
        atomicBoolean = this.d.n;
        if (atomicBoolean.get()) {
            this.d.b(6, -6);
            return;
        }
        this.d.a((List<Intent>) this.b, (List<String>) this.c, this.a);
    }
}
