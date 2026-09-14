package l8;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class d<T> implements h<T>, Serializable {

    /* renamed from: f, reason: collision with root package name */
    private final T f11803f;

    public d(T t10) {
        this.f11803f = t10;
    }

    @Override // l8.h
    public T getValue() {
        return this.f11803f;
    }

    public String toString() {
        return String.valueOf(getValue());
    }
}
