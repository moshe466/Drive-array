package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.ArrayList;
import java.util.List;
import m8.w;
import n9.a1;
import n9.g0;

/* loaded from: classes.dex */
public interface b {

    /* loaded from: classes.dex */
    public static final class a implements b {

        /* renamed from: a, reason: collision with root package name */
        public static final a f11495a = new a();

        private a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.renderer.b
        public String a(n9.h hVar, kotlin.reflect.jvm.internal.impl.renderer.c cVar) {
            y8.k.e(hVar, "classifier");
            y8.k.e(cVar, "renderer");
            if (hVar instanceof a1) {
                la.e c10 = ((a1) hVar).c();
                y8.k.d(c10, "classifier.name");
                return cVar.w(c10, false);
            }
            la.c m10 = na.d.m(hVar);
            y8.k.d(m10, "getFqName(classifier)");
            return cVar.v(m10);
        }
    }

    /* renamed from: kotlin.reflect.jvm.internal.impl.renderer.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0236b implements b {

        /* renamed from: a, reason: collision with root package name */
        public static final C0236b f11496a = new C0236b();

        private C0236b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [n9.h, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v1, types: [n9.e0, n9.m] */
        /* JADX WARN: Type inference failed for: r2v2, types: [n9.m] */
        @Override // kotlin.reflect.jvm.internal.impl.renderer.b
        public String a(n9.h hVar, kotlin.reflect.jvm.internal.impl.renderer.c cVar) {
            List w10;
            y8.k.e(hVar, "classifier");
            y8.k.e(cVar, "renderer");
            if (hVar instanceof a1) {
                la.e c10 = ((a1) hVar).c();
                y8.k.d(c10, "classifier.name");
                return cVar.w(c10, false);
            }
            ArrayList arrayList = new ArrayList();
            do {
                arrayList.add(hVar.c());
                hVar = hVar.d();
            } while (hVar instanceof n9.e);
            w10 = w.w(arrayList);
            return n.c(w10);
        }
    }

    /* loaded from: classes.dex */
    public static final class c implements b {

        /* renamed from: a, reason: collision with root package name */
        public static final c f11497a = new c();

        private c() {
        }

        private final String b(n9.h hVar) {
            la.e c10 = hVar.c();
            y8.k.d(c10, "descriptor.name");
            String b10 = n.b(c10);
            if (hVar instanceof a1) {
                return b10;
            }
            n9.m d10 = hVar.d();
            y8.k.d(d10, "descriptor.containingDeclaration");
            String c11 = c(d10);
            if (c11 == null || y8.k.a(c11, "")) {
                return b10;
            }
            return ((Object) c11) + '.' + b10;
        }

        private final String c(n9.m mVar) {
            if (mVar instanceof n9.e) {
                return b((n9.h) mVar);
            }
            if (!(mVar instanceof g0)) {
                return null;
            }
            la.c j10 = ((g0) mVar).f().j();
            y8.k.d(j10, "descriptor.fqName.toUnsafe()");
            return n.a(j10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.renderer.b
        public String a(n9.h hVar, kotlin.reflect.jvm.internal.impl.renderer.c cVar) {
            y8.k.e(hVar, "classifier");
            y8.k.e(cVar, "renderer");
            return b(hVar);
        }
    }

    String a(n9.h hVar, kotlin.reflect.jvm.internal.impl.renderer.c cVar);
}
