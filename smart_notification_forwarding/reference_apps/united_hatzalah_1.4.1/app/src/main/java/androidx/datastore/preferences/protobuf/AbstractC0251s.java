package androidx.datastore.preferences.protobuf;

/* renamed from: androidx.datastore.preferences.protobuf.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0251s implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0253u f3234a;

    /* renamed from: b, reason: collision with root package name */
    public AbstractC0253u f3235b;

    public AbstractC0251s(AbstractC0253u abstractC0253u) {
        this.f3234a = abstractC0253u;
        if (!abstractC0253u.g()) {
            this.f3235b = abstractC0253u.i();
            return;
        }
        throw new IllegalArgumentException("Default instance must be immutable.");
    }

    public final AbstractC0253u a() {
        AbstractC0253u b4 = b();
        b4.getClass();
        if (AbstractC0253u.f(b4, true)) {
            return b4;
        }
        throw new UninitializedMessageException();
    }

    public final AbstractC0253u b() {
        if (!this.f3235b.g()) {
            return this.f3235b;
        }
        AbstractC0253u abstractC0253u = this.f3235b;
        abstractC0253u.getClass();
        O o2 = O.f3120c;
        o2.getClass();
        o2.a(abstractC0253u.getClass()).b(abstractC0253u);
        abstractC0253u.h();
        return this.f3235b;
    }

    public final void c() {
        if (!this.f3235b.g()) {
            AbstractC0253u i = this.f3234a.i();
            AbstractC0253u abstractC0253u = this.f3235b;
            O o2 = O.f3120c;
            o2.getClass();
            o2.a(i.getClass()).a(i, abstractC0253u);
            this.f3235b = i;
        }
    }

    public final Object clone() {
        AbstractC0251s abstractC0251s = (AbstractC0251s) this.f3234a.c(5);
        abstractC0251s.f3235b = b();
        return abstractC0251s;
    }
}
