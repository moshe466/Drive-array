package com.google.firebase.firestore;

import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public interface EventListener<T> {
    void onEvent(@Nullable T t, @Nullable FirebaseFirestoreException firebaseFirestoreException);
}
