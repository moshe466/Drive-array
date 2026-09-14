package com.google.firebase.database.logging;

import com.google.firebase.database.logging.Logger;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public class DefaultLogger implements Logger {
    private final Set<String> enabledComponents;
    private final Logger.Level minLevel;

    /* renamed from: com.google.firebase.database.logging.DefaultLogger$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[Logger.Level.values().length];

        static {
            try {
                a[Logger.Level.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Logger.Level.WARN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Logger.Level.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Logger.Level.DEBUG.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public DefaultLogger(Logger.Level level, List<String> list) {
        if (list != null) {
            this.enabledComponents = new HashSet(list);
        } else {
            this.enabledComponents = null;
        }
        this.minLevel = level;
    }

    protected String a(Logger.Level level, String str, String str2, long j) {
        return new Date(j).toString() + " [" + level + "] " + str + ": " + str2;
    }

    protected void a(String str, String str2) {
        System.out.println(str2);
    }

    protected boolean a(Logger.Level level, String str) {
        return level.ordinal() >= this.minLevel.ordinal() && (this.enabledComponents == null || level.ordinal() > Logger.Level.DEBUG.ordinal() || this.enabledComponents.contains(str));
    }

    protected void b(String str, String str2) {
        System.err.println(str2);
    }

    protected void c(String str, String str2) {
        System.out.println(str2);
    }

    protected void d(String str, String str2) {
        System.out.println(str2);
    }

    @Override // com.google.firebase.database.logging.Logger
    public Logger.Level getLogLevel() {
        return this.minLevel;
    }

    @Override // com.google.firebase.database.logging.Logger
    public void onLogMessage(Logger.Level level, String str, String str2, long j) {
        if (a(level, str)) {
            String a = a(level, str, str2, j);
            int i = AnonymousClass1.a[level.ordinal()];
            if (i == 1) {
                b(str, a);
                return;
            }
            if (i == 2) {
                d(str, a);
            } else if (i == 3) {
                c(str, a);
            } else {
                if (i != 4) {
                    throw new RuntimeException("Should not reach here!");
                }
                a(str, a);
            }
        }
    }
}
