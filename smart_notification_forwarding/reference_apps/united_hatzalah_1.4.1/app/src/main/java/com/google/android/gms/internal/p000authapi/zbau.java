package com.google.android.gms.internal.p000authapi;

import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class zbau extends zbai {
    final /* synthetic */ TaskCompletionSource zba;

    public zbau(zbaw zbawVar, TaskCompletionSource taskCompletionSource) {
        this.zba = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.p000authapi.zbaj
    public final void zbb(Status status, SaveAccountLinkingTokenResult saveAccountLinkingTokenResult) {
        if (status.isSuccess()) {
            this.zba.setResult(saveAccountLinkingTokenResult);
        } else {
            this.zba.setException(ApiExceptionUtil.fromStatus(status));
        }
    }
}
