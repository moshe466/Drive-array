package com.google.android.gms.internal.ads;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import sun.misc.Unsafe;

/* loaded from: classes.dex */
public class zzdfs<V> extends zzdhv implements zzdhe<V> {
    private static final Object NULL;
    private static final zza zzgvk;

    @NullableDecl
    private volatile zzd listeners;

    @NullableDecl
    private volatile Object value;

    @NullableDecl
    private volatile zzk waiters;
    private static final boolean GENERATE_CANCELLATION_CAUSES = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    private static final Logger zzgvj = Logger.getLogger(zzdfs.class.getName());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class zza {
        private zza() {
        }

        abstract void a(zzk zzkVar, zzk zzkVar2);

        abstract void a(zzk zzkVar, Thread thread);

        abstract boolean a(zzdfs<?> zzdfsVar, zzd zzdVar, zzd zzdVar2);

        abstract boolean a(zzdfs<?> zzdfsVar, zzk zzkVar, zzk zzkVar2);

        abstract boolean a(zzdfs<?> zzdfsVar, Object obj, Object obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class zzb {
        static final zzb b = new zzb(new Throwable("Failure occurred while trying to finish a future.") { // from class: com.google.android.gms.internal.ads.zzdfs.zzb.1
            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });
        final Throwable a;

        zzb(Throwable th) {
            this.a = (Throwable) zzdei.checkNotNull(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class zzc {
        static final zzc c;
        static final zzc d;
        final boolean a;

        @NullableDecl
        final Throwable b;

        static {
            if (zzdfs.GENERATE_CANCELLATION_CAUSES) {
                d = null;
                c = null;
            } else {
                d = new zzc(false, null);
                c = new zzc(true, null);
            }
        }

        zzc(boolean z, @NullableDecl Throwable th) {
            this.a = z;
            this.b = th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class zzd {
        static final zzd d = new zzd(null, null);
        final Runnable a;
        final Executor b;

        @NullableDecl
        zzd c;

        zzd(Runnable runnable, Executor executor) {
            this.a = runnable;
            this.b = executor;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class zze<V> implements Runnable {
        final zzdfs<V> a;
        final zzdhe<? extends V> b;

        zze(zzdfs<V> zzdfsVar, zzdhe<? extends V> zzdheVar) {
            this.a = zzdfsVar;
            this.b = zzdheVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (((zzdfs) this.a).value != this) {
                return;
            }
            if (zzdfs.zzgvk.a((zzdfs<?>) this.a, (Object) this, zzdfs.getFutureValue(this.b))) {
                zzdfs.zza((zzdfs<?>) this.a);
            }
        }
    }

    /* loaded from: classes.dex */
    static final class zzf extends zza {
        final AtomicReferenceFieldUpdater<zzk, Thread> a;
        final AtomicReferenceFieldUpdater<zzk, zzk> b;
        final AtomicReferenceFieldUpdater<zzdfs, zzk> c;
        final AtomicReferenceFieldUpdater<zzdfs, zzd> d;
        final AtomicReferenceFieldUpdater<zzdfs, Object> e;

        zzf(AtomicReferenceFieldUpdater<zzk, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<zzk, zzk> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<zzdfs, zzk> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<zzdfs, zzd> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<zzdfs, Object> atomicReferenceFieldUpdater5) {
            super();
            this.a = atomicReferenceFieldUpdater;
            this.b = atomicReferenceFieldUpdater2;
            this.c = atomicReferenceFieldUpdater3;
            this.d = atomicReferenceFieldUpdater4;
            this.e = atomicReferenceFieldUpdater5;
        }

        @Override // com.google.android.gms.internal.ads.zzdfs.zza
        final void a(zzk zzkVar, zzk zzkVar2) {
            this.b.lazySet(zzkVar, zzkVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzdfs.zza
        final void a(zzk zzkVar, Thread thread) {
            this.a.lazySet(zzkVar, thread);
        }

        @Override // com.google.android.gms.internal.ads.zzdfs.zza
        final boolean a(zzdfs<?> zzdfsVar, zzd zzdVar, zzd zzdVar2) {
            return this.d.compareAndSet(zzdfsVar, zzdVar, zzdVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzdfs.zza
        final boolean a(zzdfs<?> zzdfsVar, zzk zzkVar, zzk zzkVar2) {
            return this.c.compareAndSet(zzdfsVar, zzkVar, zzkVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzdfs.zza
        final boolean a(zzdfs<?> zzdfsVar, Object obj, Object obj2) {
            return this.e.compareAndSet(zzdfsVar, obj, obj2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface zzg<V> extends zzdhe<V> {
    }

    /* loaded from: classes.dex */
    static final class zzh extends zza {
        private zzh() {
            super();
        }

        @Override // com.google.android.gms.internal.ads.zzdfs.zza
        final void a(zzk zzkVar, zzk zzkVar2) {
            zzkVar.b = zzkVar2;
        }

        @Override // com.google.android.gms.internal.ads.zzdfs.zza
        final void a(zzk zzkVar, Thread thread) {
            zzkVar.a = thread;
        }

        @Override // com.google.android.gms.internal.ads.zzdfs.zza
        final boolean a(zzdfs<?> zzdfsVar, zzd zzdVar, zzd zzdVar2) {
            synchronized (zzdfsVar) {
                if (((zzdfs) zzdfsVar).listeners != zzdVar) {
                    return false;
                }
                ((zzdfs) zzdfsVar).listeners = zzdVar2;
                return true;
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdfs.zza
        final boolean a(zzdfs<?> zzdfsVar, zzk zzkVar, zzk zzkVar2) {
            synchronized (zzdfsVar) {
                if (((zzdfs) zzdfsVar).waiters != zzkVar) {
                    return false;
                }
                ((zzdfs) zzdfsVar).waiters = zzkVar2;
                return true;
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdfs.zza
        final boolean a(zzdfs<?> zzdfsVar, Object obj, Object obj2) {
            synchronized (zzdfsVar) {
                if (((zzdfs) zzdfsVar).value != obj) {
                    return false;
                }
                ((zzdfs) zzdfsVar).value = obj2;
                return true;
            }
        }
    }

    /* loaded from: classes.dex */
    static final class zzi extends zza {
        static final Unsafe a;
        static final long b;
        static final long c;
        static final long d;
        static final long e;
        static final long f;

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (PrivilegedActionException e2) {
                    throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
                }
            } catch (SecurityException unused) {
                unsafe = (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.android.gms.internal.ads.zzdfs.zzi.1
                    @Override // java.security.PrivilegedExceptionAction
                    public /* synthetic */ Unsafe run() {
                        for (Field field : Unsafe.class.getDeclaredFields()) {
                            field.setAccessible(true);
                            Object obj = field.get(null);
                            if (Unsafe.class.isInstance(obj)) {
                                return (Unsafe) Unsafe.class.cast(obj);
                            }
                        }
                        throw new NoSuchFieldError("the Unsafe");
                    }
                });
            }
            try {
                c = unsafe.objectFieldOffset(zzdfs.class.getDeclaredField("waiters"));
                b = unsafe.objectFieldOffset(zzdfs.class.getDeclaredField("listeners"));
                d = unsafe.objectFieldOffset(zzdfs.class.getDeclaredField("value"));
                e = unsafe.objectFieldOffset(zzk.class.getDeclaredField("a"));
                f = unsafe.objectFieldOffset(zzk.class.getDeclaredField("b"));
                a = unsafe;
            } catch (Exception e3) {
                zzdem.zzg(e3);
                throw new RuntimeException(e3);
            }
        }

        private zzi() {
            super();
        }

        @Override // com.google.android.gms.internal.ads.zzdfs.zza
        final void a(zzk zzkVar, zzk zzkVar2) {
            a.putObject(zzkVar, f, zzkVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzdfs.zza
        final void a(zzk zzkVar, Thread thread) {
            a.putObject(zzkVar, e, thread);
        }

        @Override // com.google.android.gms.internal.ads.zzdfs.zza
        final boolean a(zzdfs<?> zzdfsVar, zzd zzdVar, zzd zzdVar2) {
            return a.compareAndSwapObject(zzdfsVar, b, zzdVar, zzdVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzdfs.zza
        final boolean a(zzdfs<?> zzdfsVar, zzk zzkVar, zzk zzkVar2) {
            return a.compareAndSwapObject(zzdfsVar, c, zzkVar, zzkVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzdfs.zza
        final boolean a(zzdfs<?> zzdfsVar, Object obj, Object obj2) {
            return a.compareAndSwapObject(zzdfsVar, d, obj, obj2);
        }
    }

    /* loaded from: classes.dex */
    static abstract class zzj<V> extends zzdfs<V> implements zzg<V> {
        @Override // com.google.android.gms.internal.ads.zzdfs, java.util.concurrent.Future
        public final V get(long j, TimeUnit timeUnit) {
            return (V) super.get(j, timeUnit);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class zzk {
        static final zzk c = new zzk(false);

        @NullableDecl
        volatile Thread a;

        @NullableDecl
        volatile zzk b;

        zzk() {
            zzdfs.zzgvk.a(this, Thread.currentThread());
        }

        private zzk(boolean z) {
        }

        final void a(zzk zzkVar) {
            zzdfs.zzgvk.a(this, zzkVar);
        }
    }

    static {
        Throwable th;
        Throwable th2;
        zza zzhVar;
        try {
            zzhVar = new zzi();
            th = null;
            th2 = null;
        } catch (Throwable th3) {
            try {
                th = null;
                th2 = th3;
                zzhVar = new zzf(AtomicReferenceFieldUpdater.newUpdater(zzk.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(zzk.class, zzk.class, "b"), AtomicReferenceFieldUpdater.newUpdater(zzdfs.class, zzk.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(zzdfs.class, zzd.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(zzdfs.class, Object.class, "value"));
            } catch (Throwable th4) {
                th = th4;
                th2 = th3;
                zzhVar = new zzh();
            }
        }
        zzgvk = zzhVar;
        if (th != null) {
            zzgvj.logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "UnsafeAtomicHelper is broken!", th2);
            zzgvj.logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
        NULL = new Object();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static Object getFutureValue(zzdhe<?> zzdheVar) {
        Throwable zza2;
        if (zzdheVar instanceof zzg) {
            Object obj = ((zzdfs) zzdheVar).value;
            if (!(obj instanceof zzc)) {
                return obj;
            }
            zzc zzcVar = (zzc) obj;
            if (!zzcVar.a) {
                return obj;
            }
            Throwable th = zzcVar.b;
            return th != null ? new zzc(false, th) : zzc.d;
        }
        if ((zzdheVar instanceof zzdhv) && (zza2 = zzdhy.zza((zzdhv) zzdheVar)) != null) {
            return new zzb(zza2);
        }
        boolean isCancelled = zzdheVar.isCancelled();
        if ((!GENERATE_CANCELLATION_CAUSES) && isCancelled) {
            return zzc.d;
        }
        try {
            Object zza3 = zza(zzdheVar);
            if (!isCancelled) {
                return zza3 == null ? NULL : zza3;
            }
            String valueOf = String.valueOf(zzdheVar);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 84);
            sb.append("get() did not throw CancellationException, despite reporting isCancelled() == true: ");
            sb.append(valueOf);
            return new zzc(false, new IllegalArgumentException(sb.toString()));
        } catch (CancellationException e) {
            if (isCancelled) {
                return new zzc(false, e);
            }
            String valueOf2 = String.valueOf(zzdheVar);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 77);
            sb2.append("get() threw CancellationException, despite reporting isCancelled() == false: ");
            sb2.append(valueOf2);
            return new zzb(new IllegalArgumentException(sb2.toString(), e));
        } catch (ExecutionException e2) {
            if (!isCancelled) {
                return new zzb(e2.getCause());
            }
            String valueOf3 = String.valueOf(zzdheVar);
            StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf3).length() + 84);
            sb3.append("get() did not throw CancellationException, despite reporting isCancelled() == true: ");
            sb3.append(valueOf3);
            return new zzc(false, new IllegalArgumentException(sb3.toString(), e2));
        } catch (Throwable th2) {
            return new zzb(th2);
        }
    }

    private static <V> V zza(Future<V> future) {
        V v;
        boolean z = false;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return v;
    }

    private final void zza(zzk zzkVar) {
        zzkVar.a = null;
        while (true) {
            zzk zzkVar2 = this.waiters;
            if (zzkVar2 == zzk.c) {
                return;
            }
            zzk zzkVar3 = null;
            while (zzkVar2 != null) {
                zzk zzkVar4 = zzkVar2.b;
                if (zzkVar2.a != null) {
                    zzkVar3 = zzkVar2;
                } else if (zzkVar3 != null) {
                    zzkVar3.b = zzkVar4;
                    if (zzkVar3.a == null) {
                        break;
                    }
                } else if (zzgvk.a((zzdfs<?>) this, zzkVar2, zzkVar4)) {
                }
                zzkVar2 = zzkVar4;
            }
            return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(zzdfs<?> zzdfsVar) {
        zzd zzdVar;
        zzd zzdVar2;
        zzd zzdVar3 = null;
        while (true) {
            zzk zzkVar = ((zzdfs) zzdfsVar).waiters;
            if (zzgvk.a(zzdfsVar, zzkVar, zzk.c)) {
                while (zzkVar != null) {
                    Thread thread = zzkVar.a;
                    if (thread != null) {
                        zzkVar.a = null;
                        LockSupport.unpark(thread);
                    }
                    zzkVar = zzkVar.b;
                }
                zzdfsVar.b();
                do {
                    zzdVar = ((zzdfs) zzdfsVar).listeners;
                } while (!zzgvk.a(zzdfsVar, zzdVar, zzd.d));
                while (true) {
                    zzdVar2 = zzdVar3;
                    zzdVar3 = zzdVar;
                    if (zzdVar3 == null) {
                        break;
                    }
                    zzdVar = zzdVar3.c;
                    zzdVar3.c = zzdVar2;
                }
                while (zzdVar2 != null) {
                    zzdVar3 = zzdVar2.c;
                    Runnable runnable = zzdVar2.a;
                    if (runnable instanceof zze) {
                        zze zzeVar = (zze) runnable;
                        zzdfsVar = zzeVar.a;
                        if (((zzdfs) zzdfsVar).value == zzeVar) {
                            if (!zzgvk.a((zzdfs<?>) zzdfsVar, (Object) zzeVar, getFutureValue(zzeVar.b))) {
                            }
                        } else {
                            continue;
                        }
                    } else {
                        zza(runnable, zzdVar2.b);
                    }
                    zzdVar2 = zzdVar3;
                }
                return;
            }
        }
    }

    private static void zza(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            Logger logger = zzgvj;
            Level level = Level.SEVERE;
            String valueOf = String.valueOf(runnable);
            String valueOf2 = String.valueOf(executor);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 57 + String.valueOf(valueOf2).length());
            sb.append("RuntimeException while executing runnable ");
            sb.append(valueOf);
            sb.append(" with executor ");
            sb.append(valueOf2);
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "executeListener", sb.toString(), (Throwable) e);
        }
    }

    private final void zza(StringBuilder sb) {
        String str = "]";
        try {
            Object zza2 = zza(this);
            sb.append("SUCCESS, result=[");
            sb.append(zzai(zza2));
            sb.append("]");
        } catch (CancellationException unused) {
            str = "CANCELLED";
            sb.append(str);
        } catch (RuntimeException e) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e.getClass());
            str = " thrown from get()]";
            sb.append(str);
        } catch (ExecutionException e2) {
            sb.append("FAILURE, cause=[");
            sb.append(e2.getCause());
            sb.append(str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static V zzah(Object obj) {
        if (obj instanceof zzc) {
            Throwable th = ((zzc) obj).b;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof zzb) {
            throw new ExecutionException(((zzb) obj).a);
        }
        if (obj == NULL) {
            return null;
        }
        return obj;
    }

    private final String zzai(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdhv
    @NullableDecl
    public final Throwable a() {
        if (!(this instanceof zzg)) {
            return null;
        }
        Object obj = this.value;
        if (obj instanceof zzb) {
            return ((zzb) obj).a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(@NullableDecl Future<?> future) {
        if ((future != null) && isCancelled()) {
            future.cancel(e());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean a(zzdhe<? extends V> zzdheVar) {
        zzb zzbVar;
        zzdei.checkNotNull(zzdheVar);
        Object obj = this.value;
        if (obj == null) {
            if (zzdheVar.isDone()) {
                if (!zzgvk.a((zzdfs<?>) this, (Object) null, getFutureValue(zzdheVar))) {
                    return false;
                }
                zza((zzdfs<?>) this);
                return true;
            }
            zze zzeVar = new zze(this, zzdheVar);
            if (zzgvk.a((zzdfs<?>) this, (Object) null, (Object) zzeVar)) {
                try {
                    zzdheVar.addListener(zzeVar, zzdgl.INSTANCE);
                } catch (Throwable th) {
                    try {
                        zzbVar = new zzb(th);
                    } catch (Throwable unused) {
                        zzbVar = zzb.b;
                    }
                    zzgvk.a((zzdfs<?>) this, (Object) zzeVar, (Object) zzbVar);
                }
                return true;
            }
            obj = this.value;
        }
        if (obj instanceof zzc) {
            zzdheVar.cancel(((zzc) obj).a);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzdhe
    public void addListener(Runnable runnable, Executor executor) {
        zzd zzdVar;
        zzdei.checkNotNull(runnable, "Runnable was null.");
        zzdei.checkNotNull(executor, "Executor was null.");
        if (!isDone() && (zzdVar = this.listeners) != zzd.d) {
            zzd zzdVar2 = new zzd(runnable, executor);
            do {
                zzdVar2.c = zzdVar;
                if (zzgvk.a((zzdfs<?>) this, zzdVar, zzdVar2)) {
                    return;
                } else {
                    zzdVar = this.listeners;
                }
            } while (zzdVar != zzd.d);
        }
        zza(runnable, executor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
    }

    protected void c() {
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        Object obj = this.value;
        if (!(obj == null) && !(obj instanceof zze)) {
            return false;
        }
        zzc zzcVar = GENERATE_CANCELLATION_CAUSES ? new zzc(z, new CancellationException("Future.cancel() was called.")) : z ? zzc.c : zzc.d;
        boolean z2 = false;
        Object obj2 = obj;
        zzdfs<V> zzdfsVar = this;
        while (true) {
            if (zzgvk.a((zzdfs<?>) zzdfsVar, obj2, (Object) zzcVar)) {
                if (z) {
                    zzdfsVar.c();
                }
                zza((zzdfs<?>) zzdfsVar);
                if (!(obj2 instanceof zze)) {
                    return true;
                }
                zzdhe<? extends V> zzdheVar = ((zze) obj2).b;
                if (!(zzdheVar instanceof zzg)) {
                    zzdheVar.cancel(z);
                    return true;
                }
                zzdfsVar = (zzdfs) zzdheVar;
                obj2 = zzdfsVar.value;
                if (!(obj2 == null) && !(obj2 instanceof zze)) {
                    return true;
                }
                z2 = true;
            } else {
                obj2 = zzdfsVar.value;
                if (!(obj2 instanceof zze)) {
                    return z2;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @NullableDecl
    public String d() {
        Object obj = this.value;
        if (obj instanceof zze) {
            String zzai = zzai(((zze) obj).b);
            StringBuilder sb = new StringBuilder(String.valueOf(zzai).length() + 12);
            sb.append("setFuture=[");
            sb.append(zzai);
            sb.append("]");
            return sb.toString();
        }
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        long delay = ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS);
        StringBuilder sb2 = new StringBuilder(41);
        sb2.append("remaining delay=[");
        sb2.append(delay);
        sb2.append(" ms]");
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean e() {
        Object obj = this.value;
        return (obj instanceof zzc) && ((zzc) obj).a;
    }

    @Override // java.util.concurrent.Future
    public V get() {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.value;
        if ((obj2 != null) && (!(obj2 instanceof zze))) {
            return (V) zzah(obj2);
        }
        zzk zzkVar = this.waiters;
        if (zzkVar != zzk.c) {
            zzk zzkVar2 = new zzk();
            do {
                zzkVar2.a(zzkVar);
                if (zzgvk.a((zzdfs<?>) this, zzkVar, zzkVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            zza(zzkVar2);
                            throw new InterruptedException();
                        }
                        obj = this.value;
                    } while (!((obj != null) & (!(obj instanceof zze))));
                    return (V) zzah(obj);
                }
                zzkVar = this.waiters;
            } while (zzkVar != zzk.c);
        }
        return (V) zzah(this.value);
    }

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.value;
        if ((obj != null) && (!(obj instanceof zze))) {
            return (V) zzah(obj);
        }
        long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            zzk zzkVar = this.waiters;
            if (zzkVar != zzk.c) {
                zzk zzkVar2 = new zzk();
                do {
                    zzkVar2.a(zzkVar);
                    if (zzgvk.a((zzdfs<?>) this, zzkVar, zzkVar2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                zza(zzkVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.value;
                            if ((obj2 != null) && (!(obj2 instanceof zze))) {
                                return (V) zzah(obj2);
                            }
                            nanos = nanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        zza(zzkVar2);
                    } else {
                        zzkVar = this.waiters;
                    }
                } while (zzkVar != zzk.c);
            }
            return (V) zzah(this.value);
        }
        while (nanos > 0) {
            Object obj3 = this.value;
            if ((obj3 != null) && (!(obj3 instanceof zze))) {
                return (V) zzah(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = nanoTime - System.nanoTime();
        }
        String zzdfsVar = toString();
        String lowerCase = timeUnit.toString().toLowerCase(Locale.ROOT);
        String lowerCase2 = timeUnit.toString().toLowerCase(Locale.ROOT);
        StringBuilder sb = new StringBuilder(String.valueOf(lowerCase2).length() + 28);
        sb.append("Waited ");
        sb.append(j);
        sb.append(" ");
        sb.append(lowerCase2);
        String sb2 = sb.toString();
        if (nanos + 1000 < 0) {
            String concat = String.valueOf(sb2).concat(" (plus ");
            long j2 = -nanos;
            long convert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
            long nanos2 = j2 - timeUnit.toNanos(convert);
            boolean z = convert == 0 || nanos2 > 1000;
            if (convert > 0) {
                String valueOf = String.valueOf(concat);
                StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 21 + String.valueOf(lowerCase).length());
                sb3.append(valueOf);
                sb3.append(convert);
                sb3.append(" ");
                sb3.append(lowerCase);
                String sb4 = sb3.toString();
                if (z) {
                    sb4 = String.valueOf(sb4).concat(",");
                }
                concat = String.valueOf(sb4).concat(" ");
            }
            if (z) {
                String valueOf2 = String.valueOf(concat);
                StringBuilder sb5 = new StringBuilder(String.valueOf(valueOf2).length() + 33);
                sb5.append(valueOf2);
                sb5.append(nanos2);
                sb5.append(" nanoseconds ");
                concat = sb5.toString();
            }
            sb2 = String.valueOf(concat).concat("delay)");
        }
        if (isDone()) {
            throw new TimeoutException(String.valueOf(sb2).concat(" but future completed as timeout expired"));
        }
        StringBuilder sb6 = new StringBuilder(String.valueOf(sb2).length() + 5 + String.valueOf(zzdfsVar).length());
        sb6.append(sb2);
        sb6.append(" for ");
        sb6.append(zzdfsVar);
        throw new TimeoutException(sb6.toString());
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.value instanceof zzc;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return (!(r0 instanceof zze)) & (this.value != null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean set(@NullableDecl V v) {
        if (v == null) {
            v = (V) NULL;
        }
        if (!zzgvk.a((zzdfs<?>) this, (Object) null, (Object) v)) {
            return false;
        }
        zza((zzdfs<?>) this);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean setException(Throwable th) {
        if (!zzgvk.a((zzdfs<?>) this, (Object) null, (Object) new zzb((Throwable) zzdei.checkNotNull(th)))) {
            return false;
        }
        zza((zzdfs<?>) this);
        return true;
    }

    public String toString() {
        String sb;
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append("[status=");
        if (!isCancelled()) {
            if (!isDone()) {
                try {
                    sb = d();
                } catch (RuntimeException e) {
                    String valueOf = String.valueOf(e.getClass());
                    StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 38);
                    sb3.append("Exception thrown from implementation: ");
                    sb3.append(valueOf);
                    sb = sb3.toString();
                }
                if (sb != null && !sb.isEmpty()) {
                    sb2.append("PENDING, info=[");
                    sb2.append(sb);
                    sb2.append("]");
                    sb2.append("]");
                    return sb2.toString();
                }
                str = isDone() ? "CANCELLED" : "PENDING";
            }
            zza(sb2);
            sb2.append("]");
            return sb2.toString();
        }
        sb2.append(str);
        sb2.append("]");
        return sb2.toString();
    }
}
