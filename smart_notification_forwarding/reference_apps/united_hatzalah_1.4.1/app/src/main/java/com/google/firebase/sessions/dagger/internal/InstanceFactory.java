package com.google.firebase.sessions.dagger.internal;

import com.google.firebase.sessions.dagger.Lazy;

/* loaded from: classes.dex */
public final class InstanceFactory<T> implements Factory<T>, Lazy<T> {
    private static final InstanceFactory<Object> NULL_INSTANCE_FACTORY = new InstanceFactory<>(null);
    private final T instance;

    private InstanceFactory(T t3) {
        this.instance = t3;
    }

    public static <T> Factory<T> create(T t3) {
        return new InstanceFactory(Preconditions.checkNotNull(t3, "instance cannot be null"));
    }

    public static <T> Factory<T> createNullable(T t3) {
        if (t3 == null) {
            return nullInstanceFactory();
        }
        return new InstanceFactory(t3);
    }

    private static <T> InstanceFactory<T> nullInstanceFactory() {
        return (InstanceFactory<T>) NULL_INSTANCE_FACTORY;
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, r2.InterfaceC0645a
    public T get() {
        return this.instance;
    }
}
