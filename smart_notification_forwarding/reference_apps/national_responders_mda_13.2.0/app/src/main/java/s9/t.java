package s9;

import java.lang.reflect.Modifier;
import n9.g1;
import n9.h1;

/* loaded from: classes.dex */
public interface t extends ca.s {

    /* loaded from: classes.dex */
    public static final class a {
        public static h1 a(t tVar) {
            y8.k.e(tVar, "this");
            int y10 = tVar.y();
            return Modifier.isPublic(y10) ? g1.h.f12288c : Modifier.isPrivate(y10) ? g1.e.f12285c : Modifier.isProtected(y10) ? Modifier.isStatic(y10) ? q9.c.f13580c : q9.b.f13579c : q9.a.f13578c;
        }

        public static boolean b(t tVar) {
            y8.k.e(tVar, "this");
            return Modifier.isAbstract(tVar.y());
        }

        public static boolean c(t tVar) {
            y8.k.e(tVar, "this");
            return Modifier.isFinal(tVar.y());
        }

        public static boolean d(t tVar) {
            y8.k.e(tVar, "this");
            return Modifier.isStatic(tVar.y());
        }
    }

    int y();
}
