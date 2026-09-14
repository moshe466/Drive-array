package xa;

import java.util.Set;
import k9.k;
import m8.q0;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: c */
    public static final b f15575c = new b(null);

    /* renamed from: d */
    private static final Set<la.a> f15576d;

    /* renamed from: a */
    private final j f15577a;

    /* renamed from: b */
    private final x8.l<a, n9.e> f15578b;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a */
        private final la.a f15579a;

        /* renamed from: b */
        private final f f15580b;

        public a(la.a aVar, f fVar) {
            y8.k.e(aVar, "classId");
            this.f15579a = aVar;
            this.f15580b = fVar;
        }

        public final f a() {
            return this.f15580b;
        }

        public final la.a b() {
            return this.f15579a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && y8.k.a(this.f15579a, ((a) obj).f15579a);
        }

        public int hashCode() {
            return this.f15579a.hashCode();
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(y8.g gVar) {
            this();
        }

        public final Set<la.a> a() {
            return h.f15576d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class c extends y8.l implements x8.l<a, n9.e> {
        c() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a */
        public final n9.e h(a aVar) {
            y8.k.e(aVar, "key");
            return h.this.c(aVar);
        }
    }

    static {
        Set<la.a> a10;
        a10 = q0.a(la.a.m(k.a.f11257d.l()));
        f15576d = a10;
    }

    public h(j jVar) {
        y8.k.e(jVar, "components");
        this.f15577a = jVar;
        this.f15578b = jVar.u().c(new c());
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00bd A[EDGE_INSN: B:43:0x00bd->B:44:0x00bd BREAK  A[LOOP:1: B:34:0x0095->B:48:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[LOOP:1: B:34:0x0095->B:48:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final n9.e c(xa.h.a r13) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: xa.h.c(xa.h$a):n9.e");
    }

    public static /* synthetic */ n9.e e(h hVar, la.a aVar, f fVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            fVar = null;
        }
        return hVar.d(aVar, fVar);
    }

    public final n9.e d(la.a aVar, f fVar) {
        y8.k.e(aVar, "classId");
        return this.f15578b.h(new a(aVar, fVar));
    }
}
