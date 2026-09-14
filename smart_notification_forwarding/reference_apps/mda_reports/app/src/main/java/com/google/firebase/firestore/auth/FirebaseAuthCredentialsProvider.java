package com.google.firebase.firestore.auth;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.internal.IdTokenListener;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.util.Listener;
import com.google.firebase.internal.InternalTokenResult;

/* loaded from: classes2.dex */
public final class FirebaseAuthCredentialsProvider extends CredentialsProvider {
    private final InternalAuthProvider authProvider;

    @Nullable
    private Listener<User> changeListener;
    private boolean forceRefresh;
    private final IdTokenListener idTokenListener = FirebaseAuthCredentialsProvider$$Lambda$1.lambdaFactory$(this);
    private User currentUser = getUser();
    private int tokenCounter = 0;

    public FirebaseAuthCredentialsProvider(InternalAuthProvider internalAuthProvider) {
        this.authProvider = internalAuthProvider;
        internalAuthProvider.addIdTokenListener(this.idTokenListener);
    }

    public static /* synthetic */ String a(FirebaseAuthCredentialsProvider firebaseAuthCredentialsProvider, int i, Task task) {
        String token;
        synchronized (firebaseAuthCredentialsProvider) {
            if (i != firebaseAuthCredentialsProvider.tokenCounter) {
                throw new FirebaseFirestoreException("getToken aborted due to token change", FirebaseFirestoreException.Code.ABORTED);
            }
            if (!task.isSuccessful()) {
                throw task.getException();
            }
            token = ((GetTokenResult) task.getResult()).getToken();
        }
        return token;
    }

    public static /* synthetic */ void a(FirebaseAuthCredentialsProvider firebaseAuthCredentialsProvider, InternalTokenResult internalTokenResult) {
        synchronized (firebaseAuthCredentialsProvider) {
            firebaseAuthCredentialsProvider.currentUser = firebaseAuthCredentialsProvider.getUser();
            firebaseAuthCredentialsProvider.tokenCounter++;
            if (firebaseAuthCredentialsProvider.changeListener != null) {
                firebaseAuthCredentialsProvider.changeListener.onValue(firebaseAuthCredentialsProvider.currentUser);
            }
        }
    }

    private User getUser() {
        String uid = this.authProvider.getUid();
        return uid != null ? new User(uid) : User.UNAUTHENTICATED;
    }

    @Override // com.google.firebase.firestore.auth.CredentialsProvider
    public synchronized Task<String> getToken() {
        boolean z;
        z = this.forceRefresh;
        this.forceRefresh = false;
        return this.authProvider.getAccessToken(z).continueWith(FirebaseAuthCredentialsProvider$$Lambda$2.lambdaFactory$(this, this.tokenCounter));
    }

    @Override // com.google.firebase.firestore.auth.CredentialsProvider
    public synchronized void invalidateToken() {
        this.forceRefresh = true;
    }

    @Override // com.google.firebase.firestore.auth.CredentialsProvider
    public synchronized void removeChangeListener() {
        this.changeListener = null;
        this.authProvider.removeIdTokenListener(this.idTokenListener);
    }

    @Override // com.google.firebase.firestore.auth.CredentialsProvider
    public synchronized void setChangeListener(@NonNull Listener<User> listener) {
        this.changeListener = listener;
        listener.onValue(this.currentUser);
    }
}
