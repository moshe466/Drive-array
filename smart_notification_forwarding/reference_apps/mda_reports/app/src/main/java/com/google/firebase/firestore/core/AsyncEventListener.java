package com.google.firebase.firestore.core;

import androidx.annotation.Nullable;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public class AsyncEventListener<T> implements EventListener<T> {
    private final EventListener<T> eventListener;
    private final Executor executor;
    private volatile boolean muted = false;

    public AsyncEventListener(Executor executor, EventListener<T> eventListener) {
        this.executor = executor;
        this.eventListener = eventListener;
    }

    public static /* synthetic */ void a(AsyncEventListener asyncEventListener, Object obj, FirebaseFirestoreException firebaseFirestoreException) {
        if (asyncEventListener.muted) {
            return;
        }
        asyncEventListener.eventListener.onEvent(obj, firebaseFirestoreException);
    }

    public void mute() {
        this.muted = true;
    }

    @Override // com.google.firebase.firestore.EventListener
    public void onEvent(@Nullable T t, @Nullable FirebaseFirestoreException firebaseFirestoreException) {
        this.executor.execute(AsyncEventListener$$Lambda$1.lambdaFactory$(this, t, firebaseFirestoreException));
    }
}
