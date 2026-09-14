package com.google.android.play.core.splitinstall.testing;

import android.content.Intent;
import java.util.List;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c implements com.google.android.play.core.splitinstall.d {
    private final /* synthetic */ List a;
    private final /* synthetic */ long b;
    private final /* synthetic */ boolean c;
    private final /* synthetic */ List d;
    private final /* synthetic */ FakeSplitInstallManager e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(FakeSplitInstallManager fakeSplitInstallManager, List list, long j, boolean z, List list2) {
        this.e = fakeSplitInstallManager;
        this.a = list;
        this.b = j;
        this.c = z;
        this.d = list2;
    }

    @Override // com.google.android.play.core.splitinstall.d
    public final void a() {
        Set set;
        set = this.e.l;
        set.addAll(this.a);
        this.e.b(5, 0, Long.valueOf(this.b), null, null, null);
    }

    @Override // com.google.android.play.core.splitinstall.d
    public final void a(int i) {
        this.e.b(6, i);
    }

    @Override // com.google.android.play.core.splitinstall.d
    public final void b() {
        if (this.c) {
            return;
        }
        this.e.a((List<Intent>) this.d, (List<String>) this.a, this.b, true);
    }
}
