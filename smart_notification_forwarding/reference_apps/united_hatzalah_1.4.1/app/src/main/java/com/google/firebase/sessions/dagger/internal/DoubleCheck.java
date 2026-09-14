package com.google.firebase.sessions.dagger.internal;

import com.google.firebase.sessions.dagger.Lazy;
import r2.InterfaceC0645a;

/* loaded from: classes.dex */
public final class DoubleCheck<T> implements InterfaceC0645a, Lazy<T> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance = UNINITIALIZED;
    private volatile InterfaceC0645a provider;

    private DoubleCheck(InterfaceC0645a interfaceC0645a) {
        this.provider = interfaceC0645a;
    }

    public static <P extends InterfaceC0645a, T> Lazy<T> lazy(P p) {
        if (p instanceof Lazy) {
            return (Lazy) p;
        }
        return new DoubleCheck((InterfaceC0645a) Preconditions.checkNotNull(p));
    }

    public static <P extends InterfaceC0645a, T> InterfaceC0645a provider(P p) {
        Preconditions.checkNotNull(p);
        if (p instanceof DoubleCheck) {
            return p;
        }
        return new DoubleCheck(p);
    }

    private static Object reentrantCheck(Object obj, Object obj2) {
        if (obj != UNINITIALIZED) {
            if (obj == obj2) {
                return obj2;
            }
            throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
        }
        return obj2;
    }

    @Override // r2.InterfaceC0645a
    public T get() {
        T t3;
        T t4 = (T) this.instance;
        Object obj = UNINITIALIZED;
        if (t4 == obj) {
            synchronized (this) {
                try {
                    t3 = (T) this.instance;
                    if (t3 == obj) {
                        t3 = (T) this.provider.get();
                        this.instance = reentrantCheck(this.instance, t3);
                        this.provider = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return t3;
        }
        return t4;
    }
}
