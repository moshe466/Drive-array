package com.google.firebase.database.android;

import F0.RunnableC0064o;
import J0.d;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.internal.IdTokenListener;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.database.core.TokenProvider;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import com.google.firebase.internal.InternalTokenResult;
import com.google.firebase.internal.api.FirebaseNoSignedInUserException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class AndroidAuthTokenProvider implements TokenProvider {
    private final Deferred<InternalAuthProvider> deferredAuthProvider;
    private final AtomicReference<InternalAuthProvider> internalAuth = new AtomicReference<>();

    public AndroidAuthTokenProvider(Deferred<InternalAuthProvider> deferred) {
        this.deferredAuthProvider = deferred;
        deferred.whenAvailable(new d(this, 14));
    }

    public static /* synthetic */ void c(TokenProvider.TokenChangeListener tokenChangeListener, InternalTokenResult internalTokenResult) {
        lambda$addTokenChangeListener$3(tokenChangeListener, internalTokenResult);
    }

    private static boolean isUnauthenticatedUsage(Exception exc) {
        if (!(exc instanceof FirebaseApiNotAvailableException) && !(exc instanceof FirebaseNoSignedInUserException)) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ void lambda$addTokenChangeListener$3(TokenProvider.TokenChangeListener tokenChangeListener, InternalTokenResult internalTokenResult) {
        tokenChangeListener.onTokenChange(internalTokenResult.getToken());
    }

    public static /* synthetic */ void lambda$addTokenChangeListener$4(ExecutorService executorService, TokenProvider.TokenChangeListener tokenChangeListener, InternalTokenResult internalTokenResult) {
        executorService.execute(new RunnableC0064o(6, tokenChangeListener, internalTokenResult));
    }

    public static /* synthetic */ void lambda$addTokenChangeListener$5(final ExecutorService executorService, final TokenProvider.TokenChangeListener tokenChangeListener, Provider provider) {
        ((InternalAuthProvider) provider.get()).addIdTokenListener(new IdTokenListener() { // from class: com.google.firebase.database.android.c
            @Override // com.google.firebase.auth.internal.IdTokenListener
            public final void onIdTokenChanged(InternalTokenResult internalTokenResult) {
                AndroidAuthTokenProvider.lambda$addTokenChangeListener$4(executorService, tokenChangeListener, internalTokenResult);
            }
        });
    }

    public static /* synthetic */ void lambda$getToken$1(TokenProvider.GetTokenCompletionListener getTokenCompletionListener, GetTokenResult getTokenResult) {
        getTokenCompletionListener.onSuccess(getTokenResult.getToken());
    }

    public static /* synthetic */ void lambda$getToken$2(TokenProvider.GetTokenCompletionListener getTokenCompletionListener, Exception exc) {
        if (isUnauthenticatedUsage(exc)) {
            getTokenCompletionListener.onSuccess(null);
        } else {
            getTokenCompletionListener.onError(exc.getMessage());
        }
    }

    public /* synthetic */ void lambda$new$0(Provider provider) {
        this.internalAuth.set((InternalAuthProvider) provider.get());
    }

    @Override // com.google.firebase.database.core.TokenProvider
    public void addTokenChangeListener(ExecutorService executorService, TokenProvider.TokenChangeListener tokenChangeListener) {
        this.deferredAuthProvider.whenAvailable(new a(executorService, tokenChangeListener, 2));
    }

    @Override // com.google.firebase.database.core.TokenProvider
    public void getToken(boolean z3, TokenProvider.GetTokenCompletionListener getTokenCompletionListener) {
        InternalAuthProvider internalAuthProvider = this.internalAuth.get();
        if (internalAuthProvider != null) {
            internalAuthProvider.getAccessToken(z3).addOnSuccessListener(new b(getTokenCompletionListener, 2)).addOnFailureListener(new b(getTokenCompletionListener, 3));
        } else {
            getTokenCompletionListener.onSuccess(null);
        }
    }

    @Override // com.google.firebase.database.core.TokenProvider
    public void removeTokenChangeListener(TokenProvider.TokenChangeListener tokenChangeListener) {
    }
}
