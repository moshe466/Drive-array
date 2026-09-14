package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public final class zabs extends com.google.android.gms.internal.base.zaa implements IStatusCallback {
    public zabs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.api.internal.IStatusCallback");
    }

    @Override // com.google.android.gms.common.api.internal.IStatusCallback
    public final void onResult(Status status) {
        throw null;
    }
}
