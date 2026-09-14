package com.google.android.play.core.appupdate;

import android.os.Bundle;
import com.google.android.play.core.install.InstallException;

/* loaded from: classes.dex */
final class i extends g<AppUpdateInfo> {
    private final String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(c cVar, com.google.android.play.core.tasks.h<AppUpdateInfo> hVar, String str) {
        super(cVar, new com.google.android.play.core.splitcompat.a("OnRequestInstallCallback"), hVar);
        this.b = str;
    }

    @Override // com.google.android.play.core.appupdate.g, com.google.android.play.core.internal.p
    public final void a(Bundle bundle) {
        int b;
        AppUpdateInfo b2;
        int b3;
        int b4;
        super.a(bundle);
        b = c.b(bundle);
        if (b != 0) {
            b3 = c.b(bundle);
            if (b3 != 1) {
                com.google.android.play.core.tasks.h<T> hVar = this.d;
                b4 = c.b(bundle);
                hVar.a(new InstallException(b4));
                return;
            }
        }
        com.google.android.play.core.tasks.h<T> hVar2 = this.d;
        b2 = c.b(bundle, this.b);
        hVar2.a((com.google.android.play.core.tasks.h<T>) b2);
    }
}
