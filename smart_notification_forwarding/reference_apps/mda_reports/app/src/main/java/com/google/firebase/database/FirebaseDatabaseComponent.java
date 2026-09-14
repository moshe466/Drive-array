package com.google.firebase.database;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.database.android.AndroidAuthTokenProvider;
import com.google.firebase.database.core.AuthTokenProvider;
import com.google.firebase.database.core.DatabaseConfig;
import com.google.firebase.database.core.RepoInfo;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class FirebaseDatabaseComponent {
    private final FirebaseApp app;
    private final AuthTokenProvider authProvider;
    private final Map<RepoInfo, FirebaseDatabase> instances = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseDatabaseComponent(@NonNull FirebaseApp firebaseApp, @Nullable InternalAuthProvider internalAuthProvider) {
        this.app = firebaseApp;
        this.authProvider = internalAuthProvider != null ? AndroidAuthTokenProvider.forAuthenticatedAccess(internalAuthProvider) : AndroidAuthTokenProvider.forUnauthenticatedAccess();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public synchronized FirebaseDatabase a(RepoInfo repoInfo) {
        FirebaseDatabase firebaseDatabase;
        firebaseDatabase = this.instances.get(repoInfo);
        if (firebaseDatabase == null) {
            DatabaseConfig databaseConfig = new DatabaseConfig();
            if (!this.app.isDefaultApp()) {
                databaseConfig.setSessionPersistenceKey(this.app.getName());
            }
            databaseConfig.setFirebaseApp(this.app);
            databaseConfig.setAuthTokenProvider(this.authProvider);
            FirebaseDatabase firebaseDatabase2 = new FirebaseDatabase(this.app, repoInfo, databaseConfig);
            this.instances.put(repoInfo, firebaseDatabase2);
            firebaseDatabase = firebaseDatabase2;
        }
        return firebaseDatabase;
    }
}
