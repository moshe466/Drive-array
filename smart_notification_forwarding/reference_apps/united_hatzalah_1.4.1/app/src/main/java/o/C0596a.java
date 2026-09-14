package o;

import java.util.HashMap;

/* renamed from: o.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0596a extends f {

    /* renamed from: e, reason: collision with root package name */
    public final HashMap f5895e = new HashMap();

    @Override // o.f
    public final c d(Object obj) {
        return (c) this.f5895e.get(obj);
    }

    @Override // o.f
    public final Object g(Object obj) {
        Object g3 = super.g(obj);
        this.f5895e.remove(obj);
        return g3;
    }
}
