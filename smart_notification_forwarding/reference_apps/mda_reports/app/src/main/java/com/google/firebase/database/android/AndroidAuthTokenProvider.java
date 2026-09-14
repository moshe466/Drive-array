package com.google.firebase.database.android;

import androidx.annotation.NonNull;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.database.core.AuthTokenProvider;
import com.google.firebase.internal.api.FirebaseNoSignedInUserException;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public abstract class AndroidAuthTokenProvider implements AuthTokenProvider {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.database.android.AndroidAuthTokenProvider$1 */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 implements AuthTokenProvider {
        final /* synthetic */ InternalAuthProvider a;

        AnonymousClass1(InternalAuthProvider internalAuthProvider) {
            this.a = internalAuthProvider;
        }

        public static /* synthetic */ void a(AuthTokenProvider.GetTokenCompletionListener getTokenCompletionListener, Exception exc) {
            if (AndroidAuthTokenProvider.isUnauthenticatedUsage(exc)) {
                getTokenCompletionListener.onSuccess(null);
            } else {
                getTokenCompletionListener.onError(exc.getMessage());
            }
        }

        @Override // com.google.firebase.database.core.AuthTokenProvider
        public void addTokenChangeListener(ExecutorService executorService, AuthTokenProvider.TokenChangeListener tokenChangeListener) {
            this.a.addIdTokenListener(AndroidAuthTokenProvider$1$$Lambda$3.lambdaFactory$(executorService, tokenChangeListener));
        }

        @Override // com.google.firebase.database.core.AuthTokenProvider
        public void getToken(boolean z, @NonNull AuthTokenProvider.GetTokenCompletionListener getTokenCompletionListener) {
            this.a.getAccessToken(z).addOnSuccessListener(AndroidAuthTokenProvider$1$$Lambda$1.lambdaFactory$(getTokenCompletionListener)).addOnFailureListener(AndroidAuthTokenProvider$1$$Lambda$2.lambdaFactory$(getTokenCompletionListener));
        }

        @Override // com.google.firebase.database.core.AuthTokenProvider
        public void removeTokenChangeListener(AuthTokenProvider.TokenChangeListener tokenChangeListener) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.database.android.AndroidAuthTokenProvider$2 */
    /* loaded from: classes2.dex */
    public class AnonymousClass2 implements AuthTokenProvider {
        AnonymousClass2() {
        }

        @Override // com.google.firebase.database.core.AuthTokenProvider
        public void addTokenChangeListener(ExecutorService executorService, AuthTokenProvider.TokenChangeListener tokenChangeListener) {
            executorService.execute(AndroidAuthTokenProvider$2$$Lambda$1.lambdaFactory$(tokenChangeListener));
        }

        @Override // com.google.firebase.database.core.AuthTokenProvider
        public void getToken(boolean z, AuthTokenProvider.GetTokenCompletionListener getTokenCompletionListener) {
            getTokenCompletionListener.onSuccess(null);
        }

        @Override // com.google.firebase.database.core.AuthTokenProvider
        public void removeTokenChangeListener(AuthTokenProvider.TokenChangeListener tokenChangeListener) {
        }
    }

    public static AuthTokenProvider forAuthenticatedAccess(@NonNull InternalAuthProvider internalAuthProvider) {
        return new AnonymousClass1(internalAuthProvider);
    }

    public static AuthTokenProvider forUnauthenticatedAccess() {
        return new AnonymousClass2();
    }

    public static boolean isUnauthenticatedUsage(Exception exc) {
        return (exc instanceof FirebaseApiNotAvailableException) || (exc instanceof FirebaseNoSignedInUserException);
    }
}
