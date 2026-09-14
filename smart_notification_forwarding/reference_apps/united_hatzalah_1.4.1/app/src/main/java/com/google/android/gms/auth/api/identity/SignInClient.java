package com.google.android.gms.auth.api.identity;

import android.app.PendingIntent;
import android.content.Intent;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;

/* loaded from: classes.dex */
public interface SignInClient extends HasApiKey<zbu> {
    Task<BeginSignInResult> beginSignIn(BeginSignInRequest beginSignInRequest);

    String getPhoneNumberFromIntent(Intent intent);

    Task<PendingIntent> getPhoneNumberHintIntent(GetPhoneNumberHintIntentRequest getPhoneNumberHintIntentRequest);

    SignInCredential getSignInCredentialFromIntent(Intent intent);

    Task<PendingIntent> getSignInIntent(GetSignInIntentRequest getSignInIntentRequest);

    Task<Void> signOut();
}
