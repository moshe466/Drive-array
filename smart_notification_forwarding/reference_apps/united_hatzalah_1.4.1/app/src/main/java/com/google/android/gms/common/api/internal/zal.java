package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Iterator;
import java.util.Set;
import t.C0689e;
import t.C0694j;

/* loaded from: classes.dex */
public final class zal {
    private int zad;
    private final C0689e zab = new C0694j(0);
    private final TaskCompletionSource zac = new TaskCompletionSource();
    private boolean zae = false;
    private final C0689e zaa = new C0694j(0);

    /* JADX WARN: Type inference failed for: r0v0, types: [t.j, t.e] */
    /* JADX WARN: Type inference failed for: r0v2, types: [t.j, t.e] */
    public zal(Iterable iterable) {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            this.zaa.put(((HasApiKey) it.next()).getApiKey(), null);
        }
        this.zad = this.zaa.f6366c;
    }

    public final Set zaa() {
        return this.zaa.keySet();
    }

    public final Task zab() {
        return this.zac.getTask();
    }

    public final void zac(ApiKey apiKey, ConnectionResult connectionResult, String str) {
        C0689e c0689e = this.zaa;
        c0689e.put(apiKey, connectionResult);
        C0689e c0689e2 = this.zab;
        c0689e2.put(apiKey, str);
        this.zad--;
        if (!connectionResult.isSuccess()) {
            this.zae = true;
        }
        if (this.zad == 0) {
            if (this.zae) {
                this.zac.setException(new AvailabilityException(c0689e));
            } else {
                this.zac.setResult(c0689e2);
            }
        }
    }
}
