package com.google.firebase.logger;

import F2.l;
import android.util.Log;
import e0.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public abstract class Logger {
    public static final Companion Companion = new Companion(null);
    private static final ConcurrentHashMap<String, Logger> loggers = new ConcurrentHashMap<>();
    private boolean enabled;
    private Level minLevel;
    private final String tag;

    /* loaded from: classes.dex */
    public static final class AndroidLogger extends Logger {

        /* loaded from: classes.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Level.values().length];
                try {
                    iArr[Level.VERBOSE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Level.DEBUG.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Level.INFO.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Level.WARN.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[Level.ERROR.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AndroidLogger(String tag, boolean z3, Level minLevel) {
            super(tag, z3, minLevel, null);
            j.e(tag, "tag");
            j.e(minLevel, "minLevel");
        }

        @Override // com.google.firebase.logger.Logger
        public int log(Level level, String format, Object[] args, Throwable th) {
            j.e(level, "level");
            j.e(format, "format");
            j.e(args, "args");
            if (args.length != 0) {
                Object[] copyOf = Arrays.copyOf(args, args.length);
                format = String.format(format, Arrays.copyOf(copyOf, copyOf.length));
            }
            int i = WhenMappings.$EnumSwitchMapping$0[level.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i == 5) {
                                String tag = getTag();
                                if (th != null) {
                                    return Log.e(tag, format, th);
                                }
                                return Log.e(tag, format);
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        String tag2 = getTag();
                        if (th != null) {
                            return Log.w(tag2, format, th);
                        }
                        return Log.w(tag2, format);
                    }
                    String tag3 = getTag();
                    if (th != null) {
                        return Log.i(tag3, format, th);
                    }
                    return Log.i(tag3, format);
                }
                String tag4 = getTag();
                if (th != null) {
                    return Log.d(tag4, format, th);
                }
                return Log.d(tag4, format);
            }
            String tag5 = getTag();
            if (th != null) {
                return Log.v(tag5, format, th);
            }
            return Log.v(tag5, format);
        }
    }

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public static /* synthetic */ Logger getLogger$default(Companion companion, String str, boolean z3, Level level, int i, Object obj) {
            if ((i & 2) != 0) {
                z3 = true;
            }
            if ((i & 4) != 0) {
                level = Level.INFO;
            }
            return companion.getLogger(str, z3, level);
        }

        public static /* synthetic */ FakeLogger setupFakeLogger$default(Companion companion, String str, boolean z3, Level level, int i, Object obj) {
            if ((i & 2) != 0) {
                z3 = true;
            }
            if ((i & 4) != 0) {
                level = Level.DEBUG;
            }
            return companion.setupFakeLogger(str, z3, level);
        }

        public final Logger getLogger(String tag, boolean z3, Level minLevel) {
            Object putIfAbsent;
            j.e(tag, "tag");
            j.e(minLevel, "minLevel");
            ConcurrentHashMap concurrentHashMap = Logger.loggers;
            Object obj = concurrentHashMap.get(tag);
            if (obj == null && (putIfAbsent = concurrentHashMap.putIfAbsent(tag, (obj = new AndroidLogger(tag, z3, minLevel)))) != null) {
                obj = putIfAbsent;
            }
            return (Logger) obj;
        }

        public final FakeLogger setupFakeLogger(String tag, boolean z3, Level minLevel) {
            j.e(tag, "tag");
            j.e(minLevel, "minLevel");
            FakeLogger fakeLogger = new FakeLogger(tag, z3, minLevel);
            Logger.loggers.put(tag, fakeLogger);
            return fakeLogger;
        }

        private Companion() {
        }
    }

    /* loaded from: classes.dex */
    public static final class FakeLogger extends Logger {
        private final List<String> record;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FakeLogger(String tag, boolean z3, Level minLevel) {
            super(tag, z3, minLevel, null);
            j.e(tag, "tag");
            j.e(minLevel, "minLevel");
            this.record = new ArrayList();
        }

        private final String toLogMessage(Level level, String str, Object[] objArr, Throwable th) {
            if (objArr.length != 0) {
                Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
                str = String.format(str, Arrays.copyOf(copyOf, copyOf.length));
            }
            if (th != null) {
                String str2 = level + ' ' + str + ' ' + Log.getStackTraceString(th);
                if (str2 != null) {
                    return str2;
                }
            }
            return level + ' ' + str;
        }

        public final void clearLogMessages() {
            this.record.clear();
        }

        public final boolean hasLogMessage(String message) {
            j.e(message, "message");
            List<String> list = this.record;
            if (list == null || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (N2.f.N((String) it.next(), message, false)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public final boolean hasLogMessageThat(l predicate) {
            j.e(predicate, "predicate");
            List<String> list = this.record;
            if (list != null && list.isEmpty()) {
                return false;
            }
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((Boolean) predicate.invoke(it.next())).booleanValue()) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.firebase.logger.Logger
        public int log(Level level, String format, Object[] args, Throwable th) {
            j.e(level, "level");
            j.e(format, "format");
            j.e(args, "args");
            String logMessage = toLogMessage(level, format, args, th);
            System.out.println((Object) a.d("Log: ", logMessage));
            this.record.add(logMessage);
            return logMessage.length();
        }
    }

    /* loaded from: classes.dex */
    public enum Level {
        VERBOSE(2),
        DEBUG(3),
        INFO(4),
        WARN(5),
        ERROR(6);

        private final int priority;

        Level(int i) {
            this.priority = i;
        }

        public final int getPriority$com_google_firebase_firebase_common() {
            return this.priority;
        }
    }

    public /* synthetic */ Logger(String str, boolean z3, Level level, f fVar) {
        this(str, z3, level);
    }

    public static /* synthetic */ int debug$default(Logger logger, String str, Object[] objArr, Throwable th, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: debug");
        }
        if ((i & 4) != 0) {
            th = null;
        }
        return logger.debug(str, objArr, th);
    }

    public static /* synthetic */ int error$default(Logger logger, String str, Object[] objArr, Throwable th, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: error");
        }
        if ((i & 4) != 0) {
            th = null;
        }
        return logger.error(str, objArr, th);
    }

    public static final Logger getLogger(String str, boolean z3, Level level) {
        return Companion.getLogger(str, z3, level);
    }

    public static /* synthetic */ int info$default(Logger logger, String str, Object[] objArr, Throwable th, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: info");
        }
        if ((i & 4) != 0) {
            th = null;
        }
        return logger.info(str, objArr, th);
    }

    private final int logIfAble(Level level, String str, Object[] objArr, Throwable th) {
        if (this.enabled) {
            if (this.minLevel.getPriority$com_google_firebase_firebase_common() <= level.getPriority$com_google_firebase_firebase_common() || Log.isLoggable(this.tag, level.getPriority$com_google_firebase_firebase_common())) {
                return log(level, str, objArr, th);
            }
            return 0;
        }
        return 0;
    }

    public static /* synthetic */ int logIfAble$default(Logger logger, Level level, String str, Object[] objArr, Throwable th, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                objArr = new Object[0];
            }
            return logger.logIfAble(level, str, objArr, th);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logIfAble");
    }

    public static final FakeLogger setupFakeLogger(String str, boolean z3, Level level) {
        return Companion.setupFakeLogger(str, z3, level);
    }

    public static /* synthetic */ int verbose$default(Logger logger, String str, Object[] objArr, Throwable th, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: verbose");
        }
        if ((i & 4) != 0) {
            th = null;
        }
        return logger.verbose(str, objArr, th);
    }

    public static /* synthetic */ int warn$default(Logger logger, String str, Object[] objArr, Throwable th, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: warn");
        }
        if ((i & 4) != 0) {
            th = null;
        }
        return logger.warn(str, objArr, th);
    }

    public final int debug(String msg) {
        j.e(msg, "msg");
        return debug$default(this, msg, null, 2, null);
    }

    public final int error(String msg) {
        j.e(msg, "msg");
        return error$default(this, msg, null, 2, null);
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final Level getMinLevel() {
        return this.minLevel;
    }

    public final String getTag() {
        return this.tag;
    }

    public final int info(String msg) {
        j.e(msg, "msg");
        return info$default(this, msg, null, 2, null);
    }

    public abstract int log(Level level, String str, Object[] objArr, Throwable th);

    public final void setEnabled(boolean z3) {
        this.enabled = z3;
    }

    public final void setMinLevel(Level level) {
        j.e(level, "<set-?>");
        this.minLevel = level;
    }

    public final int verbose(String msg) {
        j.e(msg, "msg");
        return verbose$default(this, msg, null, 2, null);
    }

    public final int warn(String msg) {
        j.e(msg, "msg");
        return warn$default(this, msg, null, 2, null);
    }

    private Logger(String str, boolean z3, Level level) {
        this.tag = str;
        this.enabled = z3;
        this.minLevel = level;
    }

    public static /* synthetic */ int debug$default(Logger logger, String str, Throwable th, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: debug");
        }
        if ((i & 2) != 0) {
            th = null;
        }
        return logger.debug(str, th);
    }

    public static /* synthetic */ int error$default(Logger logger, String str, Throwable th, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: error");
        }
        if ((i & 2) != 0) {
            th = null;
        }
        return logger.error(str, th);
    }

    public static /* synthetic */ int info$default(Logger logger, String str, Throwable th, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: info");
        }
        if ((i & 2) != 0) {
            th = null;
        }
        return logger.info(str, th);
    }

    public static /* synthetic */ int verbose$default(Logger logger, String str, Throwable th, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: verbose");
        }
        if ((i & 2) != 0) {
            th = null;
        }
        return logger.verbose(str, th);
    }

    public static /* synthetic */ int warn$default(Logger logger, String str, Throwable th, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: warn");
        }
        if ((i & 2) != 0) {
            th = null;
        }
        return logger.warn(str, th);
    }

    public final int debug(String format, Object... args) {
        j.e(format, "format");
        j.e(args, "args");
        return debug$default(this, format, args, null, 4, null);
    }

    public final int error(String format, Object... args) {
        j.e(format, "format");
        j.e(args, "args");
        return error$default(this, format, args, null, 4, null);
    }

    public final int info(String format, Object... args) {
        j.e(format, "format");
        j.e(args, "args");
        return info$default(this, format, args, null, 4, null);
    }

    public final int verbose(String format, Object... args) {
        j.e(format, "format");
        j.e(args, "args");
        return verbose$default(this, format, args, null, 4, null);
    }

    public final int warn(String format, Object... args) {
        j.e(format, "format");
        j.e(args, "args");
        return warn$default(this, format, args, null, 4, null);
    }

    public final int debug(String format, Object[] args, Throwable th) {
        j.e(format, "format");
        j.e(args, "args");
        return logIfAble(Level.DEBUG, format, args, th);
    }

    public final int error(String format, Object[] args, Throwable th) {
        j.e(format, "format");
        j.e(args, "args");
        return logIfAble(Level.ERROR, format, args, th);
    }

    public final int info(String format, Object[] args, Throwable th) {
        j.e(format, "format");
        j.e(args, "args");
        return logIfAble(Level.INFO, format, args, th);
    }

    public final int verbose(String format, Object[] args, Throwable th) {
        j.e(format, "format");
        j.e(args, "args");
        return logIfAble(Level.VERBOSE, format, args, th);
    }

    public final int warn(String format, Object[] args, Throwable th) {
        j.e(format, "format");
        j.e(args, "args");
        return logIfAble(Level.WARN, format, args, th);
    }

    public final int debug(String msg, Throwable th) {
        j.e(msg, "msg");
        return logIfAble$default(this, Level.DEBUG, msg, null, th, 4, null);
    }

    public final int error(String msg, Throwable th) {
        j.e(msg, "msg");
        return logIfAble$default(this, Level.ERROR, msg, null, th, 4, null);
    }

    public final int info(String msg, Throwable th) {
        j.e(msg, "msg");
        return logIfAble$default(this, Level.INFO, msg, null, th, 4, null);
    }

    public final int verbose(String msg, Throwable th) {
        j.e(msg, "msg");
        return logIfAble$default(this, Level.VERBOSE, msg, null, th, 4, null);
    }

    public final int warn(String msg, Throwable th) {
        j.e(msg, "msg");
        return logIfAble$default(this, Level.WARN, msg, null, th, 4, null);
    }
}
