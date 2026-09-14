package com.google.android.play.core.splitinstall;

import android.os.Bundle;

/* loaded from: classes.dex */
final class ae extends ai<SplitInstallSessionState> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(r rVar, com.google.android.play.core.tasks.h<SplitInstallSessionState> hVar) {
        super(rVar, hVar);
    }

    @Override // com.google.android.play.core.splitinstall.ai, com.google.android.play.core.internal.bd
    public final void b(int i, Bundle bundle) {
        super.b(i, bundle);
        this.c.a((com.google.android.play.core.tasks.h<T>) SplitInstallSessionState.a(bundle));
    }
}
