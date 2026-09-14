package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import com.google.android.play.core.internal.bf;
import java.util.List;

/* loaded from: classes.dex */
class ai<T> extends bf {
    private final /* synthetic */ r b;
    final com.google.android.play.core.tasks.h<T> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(r rVar, com.google.android.play.core.tasks.h<T> hVar) {
        this.b = rVar;
        this.c = hVar;
    }

    @Override // com.google.android.play.core.internal.bd
    public final void a() {
        this.b.a.a();
        r.b.a("onCompleteInstallForAppUpdate", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.bd
    public final void a(int i) {
        this.b.a.a();
        r.b.a("onCompleteInstall(%d)", Integer.valueOf(i));
    }

    public void a(int i, Bundle bundle) {
        this.b.a.a();
        r.b.a("onCancelInstall(%d)", Integer.valueOf(i));
    }

    public void a(Bundle bundle) {
        this.b.a.a();
        r.b.a("onDeferredInstall", new Object[0]);
    }

    public void a(List<Bundle> list) {
        this.b.a.a();
        r.b.a("onGetSessionStates", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.bd
    public final void b() {
        this.b.a.a();
        r.b.a("onGetSplitsForAppUpdate", new Object[0]);
    }

    public void b(int i, Bundle bundle) {
        this.b.a.a();
        r.b.a("onGetSession(%d)", Integer.valueOf(i));
    }

    public void b(Bundle bundle) {
        this.b.a.a();
        r.b.a("onDeferredLanguageUninstall", new Object[0]);
    }

    public void c(int i, Bundle bundle) {
        this.b.a.a();
        r.b.a("onStartInstall(%d)", Integer.valueOf(i));
    }

    public void c(Bundle bundle) {
        this.b.a.a();
        r.b.a("onDeferredLanguageInstall", new Object[0]);
    }

    public void d(Bundle bundle) {
        this.b.a.a();
        r.b.a("onDeferredUninstall", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.bd
    public final void e(Bundle bundle) {
        this.b.a.a();
        int i = bundle.getInt("error_code");
        r.b.d("onError(%d)", Integer.valueOf(i));
        this.c.a(new SplitInstallException(i));
    }
}
