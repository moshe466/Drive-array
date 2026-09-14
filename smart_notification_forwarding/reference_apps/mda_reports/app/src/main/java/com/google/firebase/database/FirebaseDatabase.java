package com.google.firebase.database;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.Logger;
import com.google.firebase.database.core.DatabaseConfig;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.Repo;
import com.google.firebase.database.core.RepoInfo;
import com.google.firebase.database.core.RepoManager;
import com.google.firebase.database.core.utilities.ParsedUrl;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.utilities.Validation;

/* loaded from: classes2.dex */
public class FirebaseDatabase {
    private static final String SDK_VERSION = "19.2.0";
    private final FirebaseApp app;
    private final DatabaseConfig config;
    private Repo repo;
    private final RepoInfo repoInfo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseDatabase(FirebaseApp firebaseApp, RepoInfo repoInfo, DatabaseConfig databaseConfig) {
        this.app = firebaseApp;
        this.repoInfo = repoInfo;
        this.config = databaseConfig;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FirebaseDatabase a(FirebaseApp firebaseApp, RepoInfo repoInfo, DatabaseConfig databaseConfig) {
        FirebaseDatabase firebaseDatabase = new FirebaseDatabase(firebaseApp, repoInfo, databaseConfig);
        firebaseDatabase.ensureRepo();
        return firebaseDatabase;
    }

    private void assertUnfrozen(String str) {
        if (this.repo == null) {
            return;
        }
        throw new DatabaseException("Calls to " + str + "() must be made before any other usage of FirebaseDatabase instance.");
    }

    private synchronized void ensureRepo() {
        if (this.repo == null) {
            this.repo = RepoManager.createRepo(this.config, this.repoInfo, this);
        }
    }

    @NonNull
    public static FirebaseDatabase getInstance() {
        FirebaseApp firebaseApp = FirebaseApp.getInstance();
        if (firebaseApp != null) {
            return getInstance(firebaseApp, firebaseApp.getOptions().getDatabaseUrl());
        }
        throw new DatabaseException("You must call FirebaseApp.initialize() first.");
    }

    @NonNull
    public static FirebaseDatabase getInstance(@NonNull FirebaseApp firebaseApp) {
        return getInstance(firebaseApp, firebaseApp.getOptions().getDatabaseUrl());
    }

    @NonNull
    public static synchronized FirebaseDatabase getInstance(@NonNull FirebaseApp firebaseApp, @NonNull String str) {
        FirebaseDatabase a;
        synchronized (FirebaseDatabase.class) {
            if (TextUtils.isEmpty(str)) {
                throw new DatabaseException("Failed to get FirebaseDatabase instance: Specify DatabaseURL within FirebaseApp or from your getInstance() call.");
            }
            ParsedUrl parseUrl = Utilities.parseUrl(str);
            if (!parseUrl.path.isEmpty()) {
                throw new DatabaseException("Specified Database URL '" + str + "' is invalid. It should point to the root of a Firebase Database but it includes a path: " + parseUrl.path.toString());
            }
            Preconditions.checkNotNull(firebaseApp, "Provided FirebaseApp must not be null.");
            FirebaseDatabaseComponent firebaseDatabaseComponent = (FirebaseDatabaseComponent) firebaseApp.get(FirebaseDatabaseComponent.class);
            Preconditions.checkNotNull(firebaseDatabaseComponent, "Firebase Database component is not present.");
            a = firebaseDatabaseComponent.a(parseUrl.repoInfo);
        }
        return a;
    }

    @NonNull
    public static FirebaseDatabase getInstance(@NonNull String str) {
        FirebaseApp firebaseApp = FirebaseApp.getInstance();
        if (firebaseApp != null) {
            return getInstance(firebaseApp, str);
        }
        throw new DatabaseException("You must call FirebaseApp.initialize() first.");
    }

    @NonNull
    public static String getSdkVersion() {
        return "19.2.0";
    }

    @NonNull
    public FirebaseApp getApp() {
        return this.app;
    }

    @NonNull
    public DatabaseReference getReference() {
        ensureRepo();
        return new DatabaseReference(this.repo, Path.getEmptyPath());
    }

    @NonNull
    public DatabaseReference getReference(@NonNull String str) {
        ensureRepo();
        if (str == null) {
            throw new NullPointerException("Can't pass null for argument 'pathString' in FirebaseDatabase.getReference()");
        }
        Validation.validateRootPathString(str);
        return new DatabaseReference(this.repo, new Path(str));
    }

    @NonNull
    public DatabaseReference getReferenceFromUrl(@NonNull String str) {
        ensureRepo();
        if (str == null) {
            throw new NullPointerException("Can't pass null for argument 'url' in FirebaseDatabase.getReferenceFromUrl()");
        }
        ParsedUrl parseUrl = Utilities.parseUrl(str);
        if (parseUrl.repoInfo.host.equals(this.repo.getRepoInfo().host)) {
            return new DatabaseReference(this.repo, parseUrl.path);
        }
        throw new DatabaseException("Invalid URL (" + str + ") passed to getReference().  URL was expected to match configured Database URL: " + getReference().toString());
    }

    public void goOffline() {
        ensureRepo();
        RepoManager.interrupt(this.repo);
    }

    public void goOnline() {
        ensureRepo();
        RepoManager.resume(this.repo);
    }

    public void purgeOutstandingWrites() {
        ensureRepo();
        this.repo.scheduleNow(new Runnable() { // from class: com.google.firebase.database.FirebaseDatabase.1
            @Override // java.lang.Runnable
            public void run() {
                FirebaseDatabase.this.repo.purgeOutstandingWrites();
            }
        });
    }

    public synchronized void setLogLevel(@NonNull Logger.Level level) {
        assertUnfrozen("setLogLevel");
        this.config.setLogLevel(level);
    }

    public synchronized void setPersistenceCacheSizeBytes(long j) {
        assertUnfrozen("setPersistenceCacheSizeBytes");
        this.config.setPersistenceCacheSizeBytes(j);
    }

    public synchronized void setPersistenceEnabled(boolean z) {
        assertUnfrozen("setPersistenceEnabled");
        this.config.setPersistenceEnabled(z);
    }
}
