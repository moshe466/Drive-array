package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import androidx.annotation.Nullable;
import java.io.InputStream;
import java.util.concurrent.Future;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zzse {
    private final Object lock = new Object();

    @Nullable
    @GuardedBy("lock")
    private zzrz zzbrd;

    @GuardedBy("lock")
    private boolean zzbrq;
    private final Context zzup;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzse(Context context) {
        this.zzup = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean a(zzse zzseVar, boolean z) {
        zzseVar.zzbrq = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void disconnect() {
        synchronized (this.lock) {
            if (this.zzbrd == null) {
                return;
            }
            this.zzbrd.disconnect();
            this.zzbrd = null;
            Binder.flushPendingCommands();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Future<InputStream> a(zzry zzryVar) {
        zzsh zzshVar = new zzsh(this);
        zzsg zzsgVar = new zzsg(this, zzryVar, zzshVar);
        zzsk zzskVar = new zzsk(this, zzshVar);
        synchronized (this.lock) {
            this.zzbrd = new zzrz(this.zzup, com.google.android.gms.ads.internal.zzq.zzle().zzxb(), zzsgVar, zzskVar);
            this.zzbrd.checkAvailabilityAndConnect();
        }
        return zzshVar;
    }
}
