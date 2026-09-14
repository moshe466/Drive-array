package com.google.firebase.firestore.auth;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.firestore.util.Listener;

/* loaded from: classes2.dex */
public class EmptyCredentialsProvider extends CredentialsProvider {
    @Override // com.google.firebase.firestore.auth.CredentialsProvider
    public Task<String> getToken() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.setResult(null);
        return taskCompletionSource.getTask();
    }

    @Override // com.google.firebase.firestore.auth.CredentialsProvider
    public void invalidateToken() {
    }

    @Override // com.google.firebase.firestore.auth.CredentialsProvider
    public void removeChangeListener() {
    }

    @Override // com.google.firebase.firestore.auth.CredentialsProvider
    public void setChangeListener(Listener<User> listener) {
        listener.onValue(User.UNAUTHENTICATED);
    }
}
