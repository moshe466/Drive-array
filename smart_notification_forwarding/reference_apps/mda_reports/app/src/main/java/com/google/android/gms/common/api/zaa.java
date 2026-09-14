package com.google.android.gms.common.api;

import com.google.android.gms.common.api.PendingResult;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zaa implements PendingResult.StatusListener {
    private final /* synthetic */ Batch zabd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zaa(Batch batch) {
        this.zabd = batch;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void onComplete(Status status) {
        Object obj;
        int i;
        boolean z;
        boolean z2;
        PendingResult[] pendingResultArr;
        obj = this.zabd.mLock;
        synchronized (obj) {
            if (this.zabd.isCanceled()) {
                return;
            }
            if (status.isCanceled()) {
                Batch.a(this.zabd, true);
            } else if (!status.isSuccess()) {
                Batch.b(this.zabd, true);
            }
            Batch.b(this.zabd);
            i = this.zabd.zaaz;
            if (i == 0) {
                z = this.zabd.zabb;
                if (z) {
                    super/*com.google.android.gms.common.api.internal.BasePendingResult*/.cancel();
                } else {
                    z2 = this.zabd.zaba;
                    Status status2 = z2 ? new Status(13) : Status.RESULT_SUCCESS;
                    Batch batch = this.zabd;
                    pendingResultArr = this.zabd.zabc;
                    batch.setResult(new BatchResult(status2, pendingResultArr));
                }
            }
        }
    }
}
