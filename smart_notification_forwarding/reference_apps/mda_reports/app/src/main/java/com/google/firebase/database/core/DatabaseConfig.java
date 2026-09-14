package com.google.firebase.database.core;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.Logger;
import com.google.firebase.database.logging.Logger;
import java.util.List;

/* loaded from: classes2.dex */
public class DatabaseConfig extends Context {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.database.core.DatabaseConfig$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[Logger.Level.values().length];

        static {
            try {
                a[Logger.Level.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Logger.Level.INFO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Logger.Level.WARN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Logger.Level.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Logger.Level.NONE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public void setAuthTokenProvider(AuthTokenProvider authTokenProvider) {
        this.c = authTokenProvider;
    }

    public synchronized void setDebugLogComponents(List<String> list) {
        a();
        setLogLevel(Logger.Level.DEBUG);
        this.f = list;
    }

    public synchronized void setEventTarget(EventTarget eventTarget) {
        a();
        this.b = eventTarget;
    }

    public synchronized void setFirebaseApp(FirebaseApp firebaseApp) {
        this.k = firebaseApp;
    }

    public synchronized void setLogLevel(Logger.Level level) {
        Logger.Level level2;
        a();
        int i = AnonymousClass1.a[level.ordinal()];
        if (i == 1) {
            level2 = Logger.Level.DEBUG;
        } else if (i == 2) {
            level2 = Logger.Level.INFO;
        } else if (i == 3) {
            level2 = Logger.Level.WARN;
        } else if (i == 4) {
            level2 = Logger.Level.ERROR;
        } else {
            if (i != 5) {
                throw new IllegalArgumentException("Unknown log level: " + level);
            }
            level2 = Logger.Level.NONE;
        }
        this.h = level2;
    }

    public synchronized void setLogger(com.google.firebase.database.logging.Logger logger) {
        a();
        this.a = logger;
    }

    public synchronized void setPersistenceCacheSizeBytes(long j) {
        a();
        if (j < PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            throw new DatabaseException("The minimum cache size must be at least 1MB");
        }
        if (j > 104857600) {
            throw new DatabaseException("Firebase Database currently doesn't support a cache size larger than 100MB");
        }
        this.j = j;
    }

    public synchronized void setPersistenceEnabled(boolean z) {
        a();
        this.i = z;
    }

    public void setRunLoop(RunLoop runLoop) {
        this.d = runLoop;
    }

    public synchronized void setSessionPersistenceKey(String str) {
        a();
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Session identifier is not allowed to be empty or null!");
        }
        this.e = str;
    }
}
