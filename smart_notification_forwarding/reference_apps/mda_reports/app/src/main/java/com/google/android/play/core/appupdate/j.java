package com.google.android.play.core.appupdate;

import android.os.Bundle;
import com.google.android.play.core.install.InstallException;

/* loaded from: classes.dex */
final class j extends g<Void> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public j(c cVar, com.google.android.play.core.tasks.h<Void> hVar) {
        super(cVar, new com.google.android.play.core.splitcompat.a("OnCompleteUpdateCallback"), hVar);
    }

    @Override // com.google.android.play.core.appupdate.g, com.google.android.play.core.internal.p
    public final void b(Bundle bundle) {
        int b;
        int b2;
        super.b(bundle);
        b = c.b(bundle);
        if (b == 0) {
            this.d.a((com.google.android.play.core.tasks.h<T>) null);
            return;
        }
        com.google.android.play.core.tasks.h<T> hVar = this.d;
        b2 = c.b(bundle);
        hVar.a(new InstallException(b2));
    }
}
