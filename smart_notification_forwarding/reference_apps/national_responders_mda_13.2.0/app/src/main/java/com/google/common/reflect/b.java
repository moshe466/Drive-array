package com.google.common.reflect;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import m3.d;

/* loaded from: classes.dex */
public abstract class b<T> extends a<T> implements Serializable {

    /* renamed from: f, reason: collision with root package name */
    private final Type f7044f;

    /* JADX INFO: Access modifiers changed from: protected */
    public b() {
        Type a10 = a();
        this.f7044f = a10;
        d.l(!(a10 instanceof TypeVariable), "Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", a10);
    }

    public final Type b() {
        return this.f7044f;
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            return this.f7044f.equals(((b) obj).f7044f);
        }
        return false;
    }

    public int hashCode() {
        return this.f7044f.hashCode();
    }

    public String toString() {
        return c.b(this.f7044f);
    }
}
