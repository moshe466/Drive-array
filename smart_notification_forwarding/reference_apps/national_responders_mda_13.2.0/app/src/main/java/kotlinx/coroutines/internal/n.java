package kotlinx.coroutines.internal;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f11642a = new b0("CONDITION_FALSE");

    static {
        new b0("LIST_EMPTY");
    }

    public static final Object a() {
        return f11642a;
    }

    public static final o b(Object obj) {
        x xVar = obj instanceof x ? (x) obj : null;
        o oVar = xVar != null ? xVar.f11664a : null;
        return oVar == null ? (o) obj : oVar;
    }
}
