package s9;

/* loaded from: classes.dex */
public final class o extends d implements ca.m {

    /* renamed from: c, reason: collision with root package name */
    private final Enum<?> f14174c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(la.e eVar, Enum<?> r32) {
        super(eVar);
        y8.k.e(r32, "value");
        this.f14174c = r32;
    }

    @Override // ca.m
    public la.e a() {
        return la.e.r(this.f14174c.name());
    }

    @Override // ca.m
    public la.a e() {
        Class<?> cls = this.f14174c.getClass();
        if (!cls.isEnum()) {
            cls = cls.getEnclosingClass();
        }
        y8.k.d(cls, "enumClass");
        return b.b(cls);
    }
}
