package com.google.crypto.tink.shaded.protobuf;

/* renamed from: com.google.crypto.tink.shaded.protobuf.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0349v implements P, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0351x f4157a;

    /* renamed from: b, reason: collision with root package name */
    public AbstractC0351x f4158b;

    public AbstractC0349v(AbstractC0351x abstractC0351x) {
        this.f4157a = abstractC0351x;
        if (!abstractC0351x.n()) {
            this.f4158b = abstractC0351x.q();
            return;
        }
        throw new IllegalArgumentException("Default instance must be immutable.");
    }

    public static void f(Object obj, Object obj2) {
        Y y = Y.f4075c;
        y.getClass();
        y.a(obj.getClass()).a(obj, obj2);
    }

    public final AbstractC0351x b() {
        AbstractC0351x c4 = c();
        c4.getClass();
        if (AbstractC0351x.m(c4, true)) {
            return c4;
        }
        throw new UninitializedMessageException();
    }

    public final AbstractC0351x c() {
        if (!this.f4158b.n()) {
            return this.f4158b;
        }
        AbstractC0351x abstractC0351x = this.f4158b;
        abstractC0351x.getClass();
        Y y = Y.f4075c;
        y.getClass();
        y.a(abstractC0351x.getClass()).b(abstractC0351x);
        abstractC0351x.o();
        return this.f4158b;
    }

    public final AbstractC0349v d() {
        AbstractC0349v d2 = this.f4157a.d();
        d2.f4158b = c();
        return d2;
    }

    public final void e() {
        if (!this.f4158b.n()) {
            AbstractC0351x q3 = this.f4157a.q();
            f(q3, this.f4158b);
            this.f4158b = q3;
        }
    }
}
