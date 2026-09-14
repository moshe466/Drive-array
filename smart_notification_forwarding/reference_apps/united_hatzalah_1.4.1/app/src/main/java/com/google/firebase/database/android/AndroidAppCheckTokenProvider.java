package com.google.firebase.database.android;

import F0.RunnableC0064o;
import J0.d;
import com.google.firebase.appcheck.AppCheckTokenResult;
import com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider;
import com.google.firebase.database.core.TokenProvider;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class AndroidAppCheckTokenProvider implements TokenProvider {
    private final Deferred<InteropAppCheckTokenProvider> deferredAppCheckProvider;
    private final AtomicReference<InteropAppCheckTokenProvider> internalAppCheck = new AtomicReference<>();

    public AndroidAppCheckTokenProvider(Deferred<InteropAppCheckTokenProvider> deferred) {
        this.deferredAppCheckProvider = deferred;
        deferred.whenAvailable(new d(this, 13));
    }

    public static /* synthetic */ void f(TokenProvider.TokenChangeListener tokenChangeListener, AppCheckTokenResult appCheckTokenResult) {
        lambda$addTokenChangeListener$3(tokenChangeListener, appCheckTokenResult);
    }

    public static /* synthetic */ void lambda$addTokenChangeListener$3(TokenProvider.TokenChangeListener tokenChangeListener, AppCheckTokenResult appCheckTokenResult) {
        tokenChangeListener.onTokenChange(appCheckTokenResult.getToken());
    }

    public static /* synthetic */ void lambda$addTokenChangeListener$4(ExecutorService executorService, TokenProvider.TokenChangeListener tokenChangeListener, AppCheckTokenResult appCheckTokenResult) {
        executorService.execute(new RunnableC0064o(5, tokenChangeListener, appCheckTokenResult));
    }

    public static /* synthetic */ void lambda$addTokenChangeListener$5(ExecutorService executorService, TokenProvider.TokenChangeListener tokenChangeListener, Provider provider) {
        ((InteropAppCheckTokenProvider) provider.get()).addAppCheckTokenListener(new a(executorService, tokenChangeListener, 0));
    }

    public static /* synthetic */ void lambda$getToken$1(TokenProvider.GetTokenCompletionListener getTokenCompletionListener, AppCheckTokenResult appCheckTokenResult) {
        getTokenCompletionListener.onSuccess(appCheckTokenResult.getToken());
    }

    public static /* synthetic */ void lambda$getToken$2(TokenProvider.GetTokenCompletionListener getTokenCompletionListener, Exception exc) {
        getTokenCompletionListener.onError(exc.getMessage());
    }

    public /* synthetic */ void lambda$new$0(Provider provider) {
        this.internalAppCheck.set((InteropAppCheckTokenProvider) provider.get());
    }

    @Override // com.google.firebase.database.core.TokenProvider
    public void addTokenChangeListener(ExecutorService executorService, TokenProvider.TokenChangeListener tokenChangeListener) {
        this.deferredAppCheckProvider.whenAvailable(new a(executorService, tokenChangeListener, 1));
    }

    @Override // com.google.firebase.database.core.TokenProvider
    public void getToken(boolean z3, TokenProvider.GetTokenCompletionListener getTokenCompletionListener) {
        InteropAppCheckTokenProvider interopAppCheckTokenProvider = this.internalAppCheck.get();
        if (interopAppCheckTokenProvider != null) {
            interopAppCheckTokenProvider.getToken(z3).addOnSuccessListener(new b(getTokenCompletionListener, 0)).addOnFailureListener(new b(getTokenCompletionListener, 1));
        } else {
            getTokenCompletionListener.onSuccess(null);
        }
    }

    @Override // com.google.firebase.database.core.TokenProvider
    public void removeTokenChangeListener(TokenProvider.TokenChangeListener tokenChangeListener) {
    }
}
