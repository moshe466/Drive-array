package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.splitinstall.model.SplitInstallErrorCode;
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus;

/* loaded from: classes.dex */
public final class n extends com.google.android.play.core.listener.a<SplitInstallSessionState> {
    private static n b;
    private final Handler c;
    private final c d;

    private n(Context context, c cVar) {
        super(new com.google.android.play.core.splitcompat.a("SplitInstallListenerRegistry"), new IntentFilter("com.google.android.play.core.splitinstall.receiver.SplitInstallUpdateIntentService"), context);
        this.c = new Handler(Looper.getMainLooper());
        this.d = cVar;
    }

    public static synchronized n a(Context context) {
        n nVar;
        synchronized (n.class) {
            if (b == null) {
                b = new n(context, g.a);
            }
            nVar = b;
        }
        return nVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(SplitInstallSessionState splitInstallSessionState, @SplitInstallSessionStatus int i, @SplitInstallErrorCode int i2) {
        this.c.post(new m(this, splitInstallSessionState, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.play.core.listener.a
    public final void a(Context context, Intent intent) {
        Bundle bundleExtra = intent.getBundleExtra("session_state");
        if (bundleExtra == null) {
            return;
        }
        SplitInstallSessionState a = SplitInstallSessionState.a(bundleExtra);
        this.a.b("ListenerRegistryBroadcastReceiver.onReceive: %s", a);
        a a2 = this.d.a();
        if (a.status() != 3 || a2 == null) {
            a((n) a);
        } else {
            a2.a(a.c(), new e(this, a, intent, context));
        }
    }
}
