package mb;

import java.util.Iterator;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import m8.y;
import mb.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e implements d {

    /* renamed from: a, reason: collision with root package name */
    private final Matcher f12125a;

    /* renamed from: b, reason: collision with root package name */
    private List<String> f12126b;

    /* loaded from: classes.dex */
    public static final class a extends m8.b<String> {
        a() {
        }

        @Override // m8.a
        public int c() {
            return e.this.d().groupCount() + 1;
        }

        @Override // m8.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof String) {
                return f((String) obj);
            }
            return false;
        }

        public /* bridge */ boolean f(String str) {
            return super.contains(str);
        }

        @Override // m8.b, java.util.List
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public String get(int i10) {
            String group = e.this.d().group(i10);
            return group == null ? "" : group;
        }

        @Override // m8.b, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof String) {
                return j((String) obj);
            }
            return -1;
        }

        public /* bridge */ int j(String str) {
            return super.indexOf(str);
        }

        @Override // m8.b, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof String) {
                return s((String) obj);
            }
            return -1;
        }

        public /* bridge */ int s(String str) {
            return super.lastIndexOf(str);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends m8.a<c> {

        /* loaded from: classes.dex */
        static final class a extends y8.l implements x8.l<Integer, c> {
            a() {
                super(1);
            }

            public final c a(int i10) {
                return b.this.g(i10);
            }

            @Override // x8.l
            public /* bridge */ /* synthetic */ c h(Integer num) {
                return a(num.intValue());
            }
        }

        b() {
        }

        @Override // m8.a
        public int c() {
            return e.this.d().groupCount() + 1;
        }

        @Override // m8.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj == null ? true : obj instanceof c) {
                return f((c) obj);
            }
            return false;
        }

        public /* bridge */ boolean f(c cVar) {
            return super.contains(cVar);
        }

        public c g(int i10) {
            d9.c d10;
            d10 = g.d(e.this.d(), i10);
            if (d10.u().intValue() < 0) {
                return null;
            }
            String group = e.this.d().group(i10);
            y8.k.d(group, "matchResult.group(index)");
            return new c(group, d10);
        }

        @Override // m8.a, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<c> iterator() {
            d9.c e10;
            lb.h A;
            lb.h q10;
            e10 = m8.q.e(this);
            A = y.A(e10);
            q10 = lb.n.q(A, new a());
            return q10.iterator();
        }
    }

    public e(Matcher matcher, CharSequence charSequence) {
        y8.k.e(matcher, "matcher");
        y8.k.e(charSequence, "input");
        this.f12125a = matcher;
        new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MatchResult d() {
        return this.f12125a;
    }

    @Override // mb.d
    public List<String> a() {
        if (this.f12126b == null) {
            this.f12126b = new a();
        }
        List<String> list = this.f12126b;
        y8.k.b(list);
        return list;
    }

    @Override // mb.d
    public d.b b() {
        return d.a.a(this);
    }
}
