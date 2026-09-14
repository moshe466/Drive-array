package pa;

import bb.i0;
import n9.d0;

/* loaded from: classes.dex */
public abstract class k extends g<l8.w> {

    /* renamed from: b, reason: collision with root package name */
    public static final a f13334b = new a(null);

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }

        public final k a(String str) {
            y8.k.e(str, "message");
            return new b(str);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends k {

        /* renamed from: c, reason: collision with root package name */
        private final String f13335c;

        public b(String str) {
            y8.k.e(str, "message");
            this.f13335c = str;
        }

        @Override // pa.g
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public i0 a(d0 d0Var) {
            y8.k.e(d0Var, "module");
            i0 j10 = bb.t.j(this.f13335c);
            y8.k.d(j10, "createErrorType(message)");
            return j10;
        }

        @Override // pa.g
        public String toString() {
            return this.f13335c;
        }
    }

    public k() {
        super(l8.w.f11824a);
    }

    @Override // pa.g
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public l8.w b() {
        throw new UnsupportedOperationException();
    }
}
