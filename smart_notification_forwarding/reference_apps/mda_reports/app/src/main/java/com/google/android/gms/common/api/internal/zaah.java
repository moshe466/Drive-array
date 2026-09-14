package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.SimpleClientAdapter;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class zaah implements zabd {
    private final zabe zaft;
    private boolean zafu = false;

    public zaah(zabe zabeVar) {
        this.zaft = zabeVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        if (this.zafu) {
            this.zafu = false;
            this.zaft.d.e.release();
            disconnect();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void begin() {
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void connect() {
        if (this.zafu) {
            this.zafu = false;
            this.zaft.a(new zaaj(this, this));
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final boolean disconnect() {
        if (this.zafu) {
            return false;
        }
        if (!this.zaft.d.c()) {
            this.zaft.a((ConnectionResult) null);
            return true;
        }
        this.zafu = true;
        Iterator<zacm> it = this.zaft.d.d.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        return false;
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T t) {
        return (T) execute(t);
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t) {
        try {
            this.zaft.d.e.a(t);
            zaaw zaawVar = this.zaft.d;
            Api.Client client = zaawVar.b.get(t.getClientKey());
            Preconditions.checkNotNull(client, "Appropriate Api was not requested.");
            if (client.isConnected() || !this.zaft.b.containsKey(t.getClientKey())) {
                boolean z = client instanceof SimpleClientAdapter;
                A a = client;
                if (z) {
                    a = ((SimpleClientAdapter) client).getClient();
                }
                t.run(a);
            } else {
                t.setFailedResult(new Status(17));
            }
        } catch (DeadObjectException unused) {
            this.zaft.a(new zaai(this, this));
        }
        return t;
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void onConnected(Bundle bundle) {
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void onConnectionSuspended(int i) {
        this.zaft.a((ConnectionResult) null);
        this.zaft.e.zab(i, this.zafu);
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void zaa(ConnectionResult connectionResult, Api<?> api, boolean z) {
    }
}
