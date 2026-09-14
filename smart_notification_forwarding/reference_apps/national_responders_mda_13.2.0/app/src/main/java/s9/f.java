package s9;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.List;

/* loaded from: classes.dex */
public interface f extends ca.d {

    /* loaded from: classes.dex */
    public static final class a {
        public static c a(f fVar, la.b bVar) {
            Annotation[] declaredAnnotations;
            y8.k.e(fVar, "this");
            y8.k.e(bVar, "fqName");
            AnnotatedElement V = fVar.V();
            if (V == null || (declaredAnnotations = V.getDeclaredAnnotations()) == null) {
                return null;
            }
            return g.a(declaredAnnotations, bVar);
        }

        public static List<c> b(f fVar) {
            List<c> d10;
            y8.k.e(fVar, "this");
            AnnotatedElement V = fVar.V();
            Annotation[] declaredAnnotations = V == null ? null : V.getDeclaredAnnotations();
            if (declaredAnnotations != null) {
                return g.b(declaredAnnotations);
            }
            d10 = m8.q.d();
            return d10;
        }

        public static boolean c(f fVar) {
            y8.k.e(fVar, "this");
            return false;
        }
    }

    AnnotatedElement V();
}
