package y8;

/* loaded from: classes.dex */
public class x {
    public e9.e a(i iVar) {
        return iVar;
    }

    public e9.b b(Class cls) {
        return new e(cls);
    }

    public e9.d c(Class cls, String str) {
        return new p(cls, str);
    }

    public e9.f d(m mVar) {
        return mVar;
    }

    public e9.h e(q qVar) {
        return qVar;
    }

    public e9.i f(s sVar) {
        return sVar;
    }

    public String g(h hVar) {
        String obj = hVar.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith("kotlin.jvm.functions.") ? obj.substring(21) : obj;
    }

    public String h(l lVar) {
        return g(lVar);
    }
}
