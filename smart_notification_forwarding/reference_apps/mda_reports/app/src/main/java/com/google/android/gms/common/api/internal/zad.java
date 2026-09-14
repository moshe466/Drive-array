package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class zad<T> extends zac {
    protected final TaskCompletionSource<T> a;

    public zad(int i, TaskCompletionSource<T> taskCompletionSource) {
        super(i);
        this.a = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.zab
    public void zaa(@NonNull Status status) {
        this.a.trySetException(new ApiException(status));
    }

    @Override // com.google.android.gms.common.api.internal.zab
    public final void zaa(GoogleApiManager.zaa<?> zaaVar) {
        Status zaa;
        Status zaa2;
        try {
            zad(zaaVar);
        } catch (DeadObjectException e) {
            zaa2 = zab.zaa(e);
            zaa(zaa2);
            throw e;
        } catch (RemoteException e2) {
            zaa = zab.zaa(e2);
            zaa(zaa);
        } catch (RuntimeException e3) {
            zaa(e3);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zab
    public void zaa(@NonNull zaab zaabVar, boolean z) {
    }

    @Override // com.google.android.gms.common.api.internal.zab
    public void zaa(@NonNull RuntimeException runtimeException) {
        this.a.trySetException(runtimeException);
    }

    protected abstract void zad(GoogleApiManager.zaa<?> zaaVar);
}
