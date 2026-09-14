package com.google.firebase.components;

import com.google.firebase.inject.Provider;

/* loaded from: classes.dex */
public class Lazy<T> implements Provider<T> {
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance;
    private volatile Provider<T> provider;

    public Lazy(T t3) {
        this.instance = UNINITIALIZED;
        this.instance = t3;
    }

    @Override // com.google.firebase.inject.Provider
    public T get() {
        T t3;
        T t4 = (T) this.instance;
        Object obj = UNINITIALIZED;
        if (t4 == obj) {
            synchronized (this) {
                try {
                    t3 = (T) this.instance;
                    if (t3 == obj) {
                        t3 = this.provider.get();
                        this.instance = t3;
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

    public boolean isInitialized() {
        if (this.instance != UNINITIALIZED) {
            return true;
        }
        return false;
    }

    public Lazy(Provider<T> provider) {
        this.instance = UNINITIALIZED;
        this.provider = provider;
    }
}
