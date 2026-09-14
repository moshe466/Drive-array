package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;

/* loaded from: classes.dex */
public abstract class ResultCallbacks<R extends Result> implements ResultCallback<R> {
    public abstract void onFailure(Status status);

    @Override // com.google.android.gms.common.api.ResultCallback
    public final void onResult(R r3) {
        Status status = r3.getStatus();
        if (status.isSuccess()) {
            onSuccess(r3);
            return;
        }
        onFailure(status);
        if (r3 instanceof Releasable) {
            try {
                ((Releasable) r3).release();
            } catch (RuntimeException unused) {
                "Unable to release ".concat(String.valueOf(r3));
            }
        }
    }

    public abstract void onSuccess(R r3);
}
