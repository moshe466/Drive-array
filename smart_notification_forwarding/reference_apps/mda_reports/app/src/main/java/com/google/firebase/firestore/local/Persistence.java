package com.google.firebase.firestore.local;

import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.util.Supplier;

/* loaded from: classes2.dex */
public abstract class Persistence {
    public static boolean INDEXING_SUPPORT_ENABLED = false;
    static final String a = "Persistence";

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract IndexManager a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract MutationQueue a(User user);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <T> T a(String str, Supplier<T> supplier);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(String str, Runnable runnable);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract QueryCache b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract RemoteDocumentCache c();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract ReferenceDelegate getReferenceDelegate();

    public abstract boolean isStarted();

    public abstract void shutdown();

    public abstract void start();
}
