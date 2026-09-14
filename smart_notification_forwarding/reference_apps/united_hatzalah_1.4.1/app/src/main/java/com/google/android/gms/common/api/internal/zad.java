package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class zad extends zac {
    protected final TaskCompletionSource zaa;

    public zad(int i, TaskCompletionSource taskCompletionSource) {
        super(i);
        this.zaa = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void zad(Status status) {
        this.zaa.trySetException(new ApiException(status));
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void zae(Exception exc) {
        this.zaa.trySetException(exc);
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public void zaf(zaaa zaaaVar, boolean z3) {
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void zag(zabk zabkVar) {
        try {
            zah(zabkVar);
        } catch (DeadObjectException e4) {
            zad(zai.zai(e4));
            throw e4;
        } catch (RemoteException e5) {
            zad(zai.zai(e5));
        } catch (RuntimeException e6) {
            this.zaa.trySetException(e6);
        }
    }

    public abstract void zah(zabk zabkVar);
}
