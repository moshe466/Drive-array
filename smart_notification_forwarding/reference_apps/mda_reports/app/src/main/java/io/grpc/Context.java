package io.grpc;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

@CheckReturnValue
/* loaded from: classes2.dex */
public class Context {
    final CancellableContext a;
    final PersistentHashArrayMappedTrie<Key<?>, Object> b;
    final int c;
    private ArrayList<ExecutableListener> listeners;
    private CancellationListener parentListener;
    static final Logger d = Logger.getLogger(Context.class.getName());
    private static final PersistentHashArrayMappedTrie<Key<?>, Object> EMPTY_ENTRIES = new PersistentHashArrayMappedTrie<>();
    public static final Context ROOT = new Context((Context) null, EMPTY_ENTRIES);

    /* loaded from: classes2.dex */
    @interface CanIgnoreReturnValue {
    }

    /* loaded from: classes2.dex */
    public static final class CancellableContext extends Context implements Closeable {
        private Throwable cancellationCause;
        private boolean cancelled;
        private final Deadline deadline;
        private ScheduledFuture<?> pendingDeadline;
        private final Context uncancellableSurrogate;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private CancellableContext(io.grpc.Context r3) {
            /*
                r2 = this;
                io.grpc.PersistentHashArrayMappedTrie<io.grpc.Context$Key<?>, java.lang.Object> r0 = r3.b
                r1 = 0
                r2.<init>(r0)
                io.grpc.Deadline r3 = r3.getDeadline()
                r2.deadline = r3
                io.grpc.Context r3 = new io.grpc.Context
                io.grpc.PersistentHashArrayMappedTrie<io.grpc.Context$Key<?>, java.lang.Object> r0 = r2.b
                r3.<init>(r0)
                r2.uncancellableSurrogate = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.Context.CancellableContext.<init>(io.grpc.Context):void");
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private CancellableContext(io.grpc.Context r3, io.grpc.Deadline r4, java.util.concurrent.ScheduledExecutorService r5) {
            /*
                r2 = this;
                io.grpc.PersistentHashArrayMappedTrie<io.grpc.Context$Key<?>, java.lang.Object> r0 = r3.b
                r1 = 0
                r2.<init>(r0)
                io.grpc.Deadline r3 = r3.getDeadline()
                if (r3 == 0) goto L13
                int r0 = r3.compareTo(r4)
                if (r0 > 0) goto L13
                goto L30
            L13:
                boolean r3 = r4.isExpired()
                if (r3 != 0) goto L25
                io.grpc.Context$CancellableContext$1 r3 = new io.grpc.Context$CancellableContext$1
                r3.<init>()
                java.util.concurrent.ScheduledFuture r3 = r4.runOnExpiration(r3, r5)
                r2.pendingDeadline = r3
                goto L2f
            L25:
                java.util.concurrent.TimeoutException r3 = new java.util.concurrent.TimeoutException
                java.lang.String r5 = "context timed out"
                r3.<init>(r5)
                r2.cancel(r3)
            L2f:
                r3 = r4
            L30:
                r2.deadline = r3
                io.grpc.Context r3 = new io.grpc.Context
                io.grpc.PersistentHashArrayMappedTrie<io.grpc.Context$Key<?>, java.lang.Object> r4 = r2.b
                r3.<init>(r4)
                r2.uncancellableSurrogate = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.Context.CancellableContext.<init>(io.grpc.Context, io.grpc.Deadline, java.util.concurrent.ScheduledExecutorService):void");
        }

        @Override // io.grpc.Context
        boolean a() {
            return true;
        }

        @Override // io.grpc.Context
        public Context attach() {
            return this.uncancellableSurrogate.attach();
        }

        @CanIgnoreReturnValue
        public boolean cancel(Throwable th) {
            boolean z;
            synchronized (this) {
                z = true;
                if (this.cancelled) {
                    z = false;
                } else {
                    this.cancelled = true;
                    if (this.pendingDeadline != null) {
                        this.pendingDeadline.cancel(false);
                        this.pendingDeadline = null;
                    }
                    this.cancellationCause = th;
                }
            }
            if (z) {
                b();
            }
            return z;
        }

        @Override // io.grpc.Context
        public Throwable cancellationCause() {
            if (isCancelled()) {
                return this.cancellationCause;
            }
            return null;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            cancel(null);
        }

        @Override // io.grpc.Context
        public void detach(Context context) {
            this.uncancellableSurrogate.detach(context);
        }

        public void detachAndCancel(Context context, Throwable th) {
            try {
                detach(context);
            } finally {
                cancel(th);
            }
        }

        @Override // io.grpc.Context
        public Deadline getDeadline() {
            return this.deadline;
        }

        @Override // io.grpc.Context
        public boolean isCancelled() {
            synchronized (this) {
                if (this.cancelled) {
                    return true;
                }
                if (!super.isCancelled()) {
                    return false;
                }
                cancel(super.cancellationCause());
                return true;
            }
        }

        @Override // io.grpc.Context
        @Deprecated
        public boolean isCurrent() {
            return this.uncancellableSurrogate.isCurrent();
        }
    }

    /* loaded from: classes2.dex */
    public interface CancellationListener {
        void cancelled(Context context);
    }

    /* loaded from: classes2.dex */
    @interface CheckReturnValue {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum DirectExecutor implements Executor {
        INSTANCE;

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            runnable.run();
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Context.DirectExecutor";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class ExecutableListener implements Runnable {
        final CancellationListener a;
        private final Executor executor;

        ExecutableListener(Executor executor, CancellationListener cancellationListener) {
            this.executor = executor;
            this.a = cancellationListener;
        }

        void a() {
            try {
                this.executor.execute(this);
            } catch (Throwable th) {
                Context.d.log(Level.INFO, "Exception notifying context listener", th);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.cancelled(Context.this);
        }
    }

    /* loaded from: classes2.dex */
    public static final class Key<T> {
        private final T defaultValue;
        private final String name;

        Key(String str) {
            this(str, null);
        }

        Key(String str, T t) {
            Context.a(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
            this.name = str;
            this.defaultValue = t;
        }

        public T get() {
            return get(Context.current());
        }

        public T get(Context context) {
            T t = (T) context.a((Key<?>) this);
            return t == null ? this.defaultValue : t;
        }

        public String toString() {
            return this.name;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class LazyStorage {
        static final Storage a;

        static {
            AtomicReference atomicReference = new AtomicReference();
            a = createStorage(atomicReference);
            Throwable th = (Throwable) atomicReference.get();
            if (th != null) {
                Context.d.log(Level.FINE, "Storage override doesn't exist. Using default", th);
            }
        }

        private LazyStorage() {
        }

        private static Storage createStorage(AtomicReference<? super ClassNotFoundException> atomicReference) {
            try {
                return (Storage) Class.forName("io.grpc.override.ContextStorageOverride").asSubclass(Storage.class).getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException e) {
                atomicReference.set(e);
                return new ThreadLocalContextStorage();
            } catch (Exception e2) {
                throw new RuntimeException("Storage override failed to initialize", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class ParentListener implements CancellationListener {
        private ParentListener() {
        }

        @Override // io.grpc.Context.CancellationListener
        public void cancelled(Context context) {
            Context context2 = Context.this;
            if (context2 instanceof CancellableContext) {
                ((CancellableContext) context2).cancel(context.cancellationCause());
            } else {
                context2.b();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class Storage {
        @Deprecated
        public void attach(Context context) {
            throw new UnsupportedOperationException("Deprecated. Do not call.");
        }

        public abstract Context current();

        public abstract void detach(Context context, Context context2);

        public Context doAttach(Context context) {
            Context current = current();
            attach(context);
            return current;
        }
    }

    private Context(Context context, PersistentHashArrayMappedTrie<Key<?>, Object> persistentHashArrayMappedTrie) {
        this.parentListener = new ParentListener();
        this.a = a(context);
        this.b = persistentHashArrayMappedTrie;
        this.c = context == null ? 0 : context.c + 1;
        validateGeneration(this.c);
    }

    private Context(PersistentHashArrayMappedTrie<Key<?>, Object> persistentHashArrayMappedTrie, int i) {
        this.parentListener = new ParentListener();
        this.a = null;
        this.b = persistentHashArrayMappedTrie;
        this.c = i;
        validateGeneration(i);
    }

    static CancellableContext a(Context context) {
        if (context == null) {
            return null;
        }
        return context instanceof CancellableContext ? (CancellableContext) context : context.a;
    }

    @CanIgnoreReturnValue
    static <T> T a(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    static Storage c() {
        return LazyStorage.a;
    }

    public static Context current() {
        Context current = c().current();
        return current == null ? ROOT : current;
    }

    public static Executor currentContextExecutor(final Executor executor) {
        return new Executor() { // from class: io.grpc.Context.1CurrentContextExecutor
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                executor.execute(Context.current().wrap(runnable));
            }
        };
    }

    public static <T> Key<T> key(String str) {
        return new Key<>(str);
    }

    public static <T> Key<T> keyWithDefault(String str, T t) {
        return new Key<>(str, t);
    }

    private static void validateGeneration(int i) {
        if (i == 1000) {
            d.log(Level.SEVERE, "Context ancestry chain length is abnormally long. This suggests an error in application code. Length exceeded: 1000", (Throwable) new Exception());
        }
    }

    Object a(Key<?> key) {
        return this.b.get(key);
    }

    boolean a() {
        return this.a != null;
    }

    public void addListener(CancellationListener cancellationListener, Executor executor) {
        a(cancellationListener, "cancellationListener");
        a(executor, "executor");
        if (a()) {
            ExecutableListener executableListener = new ExecutableListener(executor, cancellationListener);
            synchronized (this) {
                if (isCancelled()) {
                    executableListener.a();
                } else if (this.listeners == null) {
                    this.listeners = new ArrayList<>();
                    this.listeners.add(executableListener);
                    if (this.a != null) {
                        this.a.addListener(this.parentListener, DirectExecutor.INSTANCE);
                    }
                } else {
                    this.listeners.add(executableListener);
                }
            }
        }
    }

    public Context attach() {
        Context doAttach = c().doAttach(this);
        return doAttach == null ? ROOT : doAttach;
    }

    void b() {
        if (a()) {
            synchronized (this) {
                if (this.listeners == null) {
                    return;
                }
                ArrayList<ExecutableListener> arrayList = this.listeners;
                this.listeners = null;
                for (int i = 0; i < arrayList.size(); i++) {
                    if (!(arrayList.get(i).a instanceof ParentListener)) {
                        arrayList.get(i).a();
                    }
                }
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    if (arrayList.get(i2).a instanceof ParentListener) {
                        arrayList.get(i2).a();
                    }
                }
                CancellableContext cancellableContext = this.a;
                if (cancellableContext != null) {
                    cancellableContext.removeListener(this.parentListener);
                }
            }
        }
    }

    @CanIgnoreReturnValue
    public <V> V call(Callable<V> callable) {
        Context attach = attach();
        try {
            return callable.call();
        } finally {
            detach(attach);
        }
    }

    public Throwable cancellationCause() {
        CancellableContext cancellableContext = this.a;
        if (cancellableContext == null) {
            return null;
        }
        return cancellableContext.cancellationCause();
    }

    public void detach(Context context) {
        a(context, "toAttach");
        c().detach(this, context);
    }

    public Executor fixedContextExecutor(final Executor executor) {
        return new Executor() { // from class: io.grpc.Context.1FixedContextExecutor
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                executor.execute(Context.this.wrap(runnable));
            }
        };
    }

    public Context fork() {
        return new Context(this.b, this.c + 1);
    }

    public Deadline getDeadline() {
        CancellableContext cancellableContext = this.a;
        if (cancellableContext == null) {
            return null;
        }
        return cancellableContext.getDeadline();
    }

    public boolean isCancelled() {
        CancellableContext cancellableContext = this.a;
        if (cancellableContext == null) {
            return false;
        }
        return cancellableContext.isCancelled();
    }

    boolean isCurrent() {
        return current() == this;
    }

    public void removeListener(CancellationListener cancellationListener) {
        if (a()) {
            synchronized (this) {
                if (this.listeners != null) {
                    int size = this.listeners.size() - 1;
                    while (true) {
                        if (size < 0) {
                            break;
                        }
                        if (this.listeners.get(size).a == cancellationListener) {
                            this.listeners.remove(size);
                            break;
                        }
                        size--;
                    }
                    if (this.listeners.isEmpty()) {
                        if (this.a != null) {
                            this.a.removeListener(this.parentListener);
                        }
                        this.listeners = null;
                    }
                }
            }
        }
    }

    public void run(Runnable runnable) {
        Context attach = attach();
        try {
            runnable.run();
        } finally {
            detach(attach);
        }
    }

    public CancellableContext withCancellation() {
        return new CancellableContext();
    }

    public CancellableContext withDeadline(Deadline deadline, ScheduledExecutorService scheduledExecutorService) {
        a(deadline, "deadline");
        a(scheduledExecutorService, "scheduler");
        return new CancellableContext(deadline, scheduledExecutorService);
    }

    public CancellableContext withDeadlineAfter(long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return withDeadline(Deadline.after(j, timeUnit), scheduledExecutorService);
    }

    public <V> Context withValue(Key<V> key, V v) {
        return new Context(this, this.b.put(key, v));
    }

    public <V1, V2> Context withValues(Key<V1> key, V1 v1, Key<V2> key2, V2 v2) {
        return new Context(this, this.b.put(key, v1).put(key2, v2));
    }

    public <V1, V2, V3> Context withValues(Key<V1> key, V1 v1, Key<V2> key2, V2 v2, Key<V3> key3, V3 v3) {
        return new Context(this, this.b.put(key, v1).put(key2, v2).put(key3, v3));
    }

    public <V1, V2, V3, V4> Context withValues(Key<V1> key, V1 v1, Key<V2> key2, V2 v2, Key<V3> key3, V3 v3, Key<V4> key4, V4 v4) {
        return new Context(this, this.b.put(key, v1).put(key2, v2).put(key3, v3).put(key4, v4));
    }

    public Runnable wrap(final Runnable runnable) {
        return new Runnable() { // from class: io.grpc.Context.1
            @Override // java.lang.Runnable
            public void run() {
                Context attach = Context.this.attach();
                try {
                    runnable.run();
                } finally {
                    Context.this.detach(attach);
                }
            }
        };
    }

    public <C> Callable<C> wrap(final Callable<C> callable) {
        return new Callable<C>() { // from class: io.grpc.Context.2
            @Override // java.util.concurrent.Callable
            public C call() {
                Context attach = Context.this.attach();
                try {
                    return (C) callable.call();
                } finally {
                    Context.this.detach(attach);
                }
            }
        };
    }
}
