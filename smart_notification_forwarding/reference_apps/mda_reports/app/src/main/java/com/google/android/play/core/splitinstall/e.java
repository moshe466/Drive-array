package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;
import com.google.android.play.core.splitinstall.model.SplitInstallErrorCode;

/* loaded from: classes.dex */
class e implements d {
    final /* synthetic */ SplitInstallSessionState a;
    final /* synthetic */ Intent b;
    final /* synthetic */ Context c;
    final /* synthetic */ n d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(n nVar, SplitInstallSessionState splitInstallSessionState, Intent intent, Context context) {
        this.d = nVar;
        this.a = splitInstallSessionState;
        this.b = intent;
        this.c = context;
    }

    @Override // com.google.android.play.core.splitinstall.d
    public void a() {
        this.d.a(this.a, 5, 0);
    }

    @Override // com.google.android.play.core.splitinstall.d
    public void a(@SplitInstallErrorCode int i) {
        this.d.a(this.a, 6, i);
    }

    @Override // com.google.android.play.core.splitinstall.d
    public void b() {
        com.google.android.play.core.splitcompat.a aVar;
        if (this.b.getBooleanExtra("triggered_from_app_after_verification", false)) {
            aVar = ((com.google.android.play.core.listener.a) this.d).a;
            aVar.d("Splits copied and verified more than once.", new Object[0]);
        } else {
            this.b.putExtra("triggered_from_app_after_verification", true);
            this.c.sendBroadcast(this.b);
        }
    }
}
