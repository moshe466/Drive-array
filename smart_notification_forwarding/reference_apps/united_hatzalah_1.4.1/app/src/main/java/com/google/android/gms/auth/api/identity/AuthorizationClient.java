package com.google.android.gms.auth.api.identity;

import android.content.Intent;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;

/* loaded from: classes.dex */
public interface AuthorizationClient extends HasApiKey<zbc> {
    Task<AuthorizationResult> authorize(AuthorizationRequest authorizationRequest);

    AuthorizationResult getAuthorizationResultFromIntent(Intent intent);
}
