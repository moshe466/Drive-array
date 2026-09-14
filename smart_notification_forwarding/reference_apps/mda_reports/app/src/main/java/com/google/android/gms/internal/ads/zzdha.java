package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
abstract class zzdha<T> extends AtomicReference<Runnable> implements Runnable {
    private static final Runnable zzgwy = new zzdhb();
    private static final Runnable zzgwz = new zzdhb();
    private static final Runnable zzgxa = new zzdhb();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        Runnable runnable = get();
        if ((runnable instanceof Thread) && compareAndSet(runnable, zzgwz)) {
            try {
                ((Thread) runnable).interrupt();
            } finally {
                if (getAndSet(zzgwy) == zzgxa) {
                    LockSupport.unpark((Thread) runnable);
                }
            }
        }
    }

    abstract void a(@NullableDecl T t, @NullableDecl Throwable th);

    abstract boolean b();

    abstract T c();

    abstract String d();

    @Override // java.lang.Runnable
    public final void run() {
        T c;
        Thread currentThread = Thread.currentThread();
        if (compareAndSet(null, currentThread)) {
            boolean z = !b();
            if (z) {
                try {
                    c = c();
                } catch (Throwable th) {
                    if (!compareAndSet(currentThread, zzgwy)) {
                        Runnable runnable = get();
                        boolean z2 = false;
                        int i = 0;
                        while (true) {
                            if (runnable != zzgwz && runnable != zzgxa) {
                                break;
                            }
                            i++;
                            if (i > 1000) {
                                Runnable runnable2 = zzgxa;
                                if (runnable == runnable2 || compareAndSet(zzgwz, runnable2)) {
                                    boolean z3 = Thread.interrupted() || z2;
                                    LockSupport.park(this);
                                    z2 = z3;
                                }
                            } else {
                                Thread.yield();
                            }
                            runnable = get();
                        }
                        if (z2) {
                            currentThread.interrupt();
                        }
                    }
                    if (z) {
                        a(null, th);
                        return;
                    }
                    return;
                }
            } else {
                c = null;
            }
            if (!compareAndSet(currentThread, zzgwy)) {
                Runnable runnable3 = get();
                boolean z4 = false;
                int i2 = 0;
                while (true) {
                    if (runnable3 != zzgwz && runnable3 != zzgxa) {
                        break;
                    }
                    i2++;
                    if (i2 > 1000) {
                        Runnable runnable4 = zzgxa;
                        if (runnable3 == runnable4 || compareAndSet(zzgwz, runnable4)) {
                            boolean z5 = Thread.interrupted() || z4;
                            LockSupport.park(this);
                            z4 = z5;
                        }
                    } else {
                        Thread.yield();
                    }
                    runnable3 = get();
                }
                if (z4) {
                    currentThread.interrupt();
                }
            }
            if (z) {
                a(c, null);
            }
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        String str;
        Runnable runnable = get();
        if (runnable == zzgwy) {
            str = "running=[DONE]";
        } else if (runnable == zzgwz) {
            str = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            String name = ((Thread) runnable).getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 21);
            sb.append("running=[RUNNING ON ");
            sb.append(name);
            sb.append("]");
            str = sb.toString();
        } else {
            str = "running=[NOT STARTED YET]";
        }
        String d = d();
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(d).length());
        sb2.append(str);
        sb2.append(", ");
        sb2.append(d);
        return sb2.toString();
    }
}
