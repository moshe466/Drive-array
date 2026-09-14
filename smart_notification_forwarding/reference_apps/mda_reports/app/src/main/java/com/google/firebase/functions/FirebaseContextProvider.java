package com.google.firebase.functions;

import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.inject.Provider;
import com.google.firebase.internal.api.FirebaseNoSignedInUserException;

/* loaded from: classes2.dex */
public class FirebaseContextProvider implements ContextProvider {
    private final Provider<FirebaseInstanceIdInternal> instanceId;

    @Nullable
    private final Provider<InternalAuthProvider> tokenProvider;

    public FirebaseContextProvider(@Nullable Provider<InternalAuthProvider> provider, Provider<FirebaseInstanceIdInternal> provider2) {
        this.tokenProvider = provider;
        this.instanceId = provider2;
    }

    public static /* synthetic */ HttpsCallableContext a(FirebaseContextProvider firebaseContextProvider, Task task) {
        String token;
        if (task.isSuccessful()) {
            token = ((GetTokenResult) task.getResult()).getToken();
        } else {
            Exception exception = task.getException();
            if (!(exception instanceof FirebaseNoSignedInUserException)) {
                throw exception;
            }
            token = null;
        }
        return new HttpsCallableContext(token, firebaseContextProvider.instanceId.get().getToken());
    }

    @Override // com.google.firebase.functions.ContextProvider
    public Task<HttpsCallableContext> getContext() {
        Provider<InternalAuthProvider> provider = this.tokenProvider;
        if (provider != null) {
            return provider.get().getAccessToken(false).continueWith(FirebaseContextProvider$$Lambda$1.lambdaFactory$(this));
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.setResult(new HttpsCallableContext(null, this.instanceId.get().getToken()));
        return taskCompletionSource.getTask();
    }
}
