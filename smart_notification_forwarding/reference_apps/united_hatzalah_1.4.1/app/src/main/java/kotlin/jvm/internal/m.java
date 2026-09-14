package kotlin.jvm.internal;

/* loaded from: classes.dex */
public abstract class m extends o implements L2.h {
    @Override // kotlin.jvm.internal.c
    public L2.b computeReflected() {
        s.f5313a.getClass();
        return this;
    }

    @Override // L2.h
    public Object getDelegate(Object obj) {
        return ((L2.h) getReflected()).getDelegate(obj);
    }

    public /* bridge */ /* synthetic */ L2.f getGetter() {
        mo23getGetter();
        return null;
    }

    @Override // F2.l
    public Object invoke(Object obj) {
        return get(obj);
    }

    @Override // L2.h
    /* renamed from: getGetter, reason: collision with other method in class */
    public L2.g mo23getGetter() {
        ((L2.h) getReflected()).mo23getGetter();
        return null;
    }
}
