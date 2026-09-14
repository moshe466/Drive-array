package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Sets;
import com.google.j2objc.annotations.ReflectionSupport;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

@ReflectionSupport(ReflectionSupport.Level.FULL)
@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
abstract class AggregateFutureState {
    private static final AtomicHelper ATOMIC_HELPER;
    private static final Logger log = Logger.getLogger(AggregateFutureState.class.getName());
    private volatile int remaining;
    private volatile Set<Throwable> seenExceptions = null;

    /* loaded from: classes2.dex */
    private static abstract class AtomicHelper {
        private AtomicHelper() {
        }

        abstract int a(AggregateFutureState aggregateFutureState);

        abstract void a(AggregateFutureState aggregateFutureState, Set<Throwable> set, Set<Throwable> set2);
    }

    /* loaded from: classes2.dex */
    private static final class SafeAtomicHelper extends AtomicHelper {
        final AtomicReferenceFieldUpdater<AggregateFutureState, Set<Throwable>> a;
        final AtomicIntegerFieldUpdater<AggregateFutureState> b;

        SafeAtomicHelper(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super();
            this.a = atomicReferenceFieldUpdater;
            this.b = atomicIntegerFieldUpdater;
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        int a(AggregateFutureState aggregateFutureState) {
            return this.b.decrementAndGet(aggregateFutureState);
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        void a(AggregateFutureState aggregateFutureState, Set<Throwable> set, Set<Throwable> set2) {
            this.a.compareAndSet(aggregateFutureState, set, set2);
        }
    }

    /* loaded from: classes2.dex */
    private static final class SynchronizedAtomicHelper extends AtomicHelper {
        private SynchronizedAtomicHelper() {
            super();
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        int a(AggregateFutureState aggregateFutureState) {
            int i;
            synchronized (aggregateFutureState) {
                AggregateFutureState.c(aggregateFutureState);
                i = aggregateFutureState.remaining;
            }
            return i;
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        void a(AggregateFutureState aggregateFutureState, Set<Throwable> set, Set<Throwable> set2) {
            synchronized (aggregateFutureState) {
                if (aggregateFutureState.seenExceptions == set) {
                    aggregateFutureState.seenExceptions = set2;
                }
            }
        }
    }

    static {
        AtomicHelper synchronizedAtomicHelper;
        try {
            synchronizedAtomicHelper = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(AggregateFutureState.class, Set.class, "seenExceptions"), AtomicIntegerFieldUpdater.newUpdater(AggregateFutureState.class, "remaining"));
            th = null;
        } catch (Throwable th) {
            th = th;
            synchronizedAtomicHelper = new SynchronizedAtomicHelper();
        }
        ATOMIC_HELPER = synchronizedAtomicHelper;
        if (th != null) {
            log.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AggregateFutureState(int i) {
        this.remaining = i;
    }

    static /* synthetic */ int c(AggregateFutureState aggregateFutureState) {
        int i = aggregateFutureState.remaining;
        aggregateFutureState.remaining = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int a() {
        return ATOMIC_HELPER.a(this);
    }

    abstract void a(Set<Throwable> set);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<Throwable> b() {
        Set<Throwable> set = this.seenExceptions;
        if (set != null) {
            return set;
        }
        Set<Throwable> newConcurrentHashSet = Sets.newConcurrentHashSet();
        a(newConcurrentHashSet);
        ATOMIC_HELPER.a(this, null, newConcurrentHashSet);
        return this.seenExceptions;
    }
}
