package ea;

import ja.a;
import ka.e;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: b, reason: collision with root package name */
    public static final a f9327b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final String f9328a;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }

        public final r a(String str, String str2) {
            y8.k.e(str, "name");
            y8.k.e(str2, "desc");
            return new r(str + '#' + str2, null);
        }

        public final r b(ka.e eVar) {
            y8.k.e(eVar, "signature");
            if (eVar instanceof e.b) {
                return d(eVar.c(), eVar.b());
            }
            if (eVar instanceof e.a) {
                return a(eVar.c(), eVar.b());
            }
            throw new l8.l();
        }

        public final r c(ia.c cVar, a.c cVar2) {
            y8.k.e(cVar, "nameResolver");
            y8.k.e(cVar2, "signature");
            return d(cVar.a(cVar2.y()), cVar.a(cVar2.x()));
        }

        public final r d(String str, String str2) {
            y8.k.e(str, "name");
            y8.k.e(str2, "desc");
            return new r(y8.k.j(str, str2), null);
        }

        public final r e(r rVar, int i10) {
            y8.k.e(rVar, "signature");
            return new r(rVar.a() + '@' + i10, null);
        }
    }

    private r(String str) {
        this.f9328a = str;
    }

    public /* synthetic */ r(String str, y8.g gVar) {
        this(str);
    }

    public final String a() {
        return this.f9328a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof r) && y8.k.a(this.f9328a, ((r) obj).f9328a);
    }

    public int hashCode() {
        return this.f9328a.hashCode();
    }

    public String toString() {
        return "MemberSignature(signature=" + this.f9328a + ')';
    }
}
