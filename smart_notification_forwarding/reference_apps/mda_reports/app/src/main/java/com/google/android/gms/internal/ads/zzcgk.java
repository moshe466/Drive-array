package com.google.android.gms.internal.ads;

import android.os.Binder;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.io.InputStream;

/* loaded from: classes.dex */
public abstract class zzcgk implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    protected final zzazl<InputStream> a = new zzazl<>();
    protected final Object b = new Object();
    protected boolean c = false;
    protected boolean d = false;
    protected zzaqk e;

    @GuardedBy("mLock")
    @VisibleForTesting(otherwise = 3)
    protected zzaps f;

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a() {
        synchronized (this.b) {
            this.d = true;
            if (this.f.isConnected() || this.f.isConnecting()) {
                this.f.disconnect();
            }
            Binder.flushPendingCommands();
        }
    }

    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        zzayu.zzea("Disconnected from remote ad request service.");
        this.a.setException(new zzcgr(0));
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public void onConnectionSuspended(int i) {
        zzayu.zzea("Cannot connect to remote service, fallback to local instance.");
    }
}
