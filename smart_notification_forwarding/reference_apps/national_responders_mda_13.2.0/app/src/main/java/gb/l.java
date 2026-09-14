package gb;

import gb.b;
import n9.x;

/* loaded from: classes.dex */
public abstract class l implements gb.b {

    /* renamed from: a, reason: collision with root package name */
    private final String f10400a;

    /* loaded from: classes.dex */
    public static final class a extends l {

        /* renamed from: b, reason: collision with root package name */
        private final int f10401b;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public a(int r3) {
            /*
                r2 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "must have at least "
                r0.append(r1)
                r0.append(r3)
                java.lang.String r1 = " value parameter"
                r0.append(r1)
                r1 = 1
                if (r3 <= r1) goto L18
                java.lang.String r1 = "s"
                goto L1a
            L18:
                java.lang.String r1 = ""
            L1a:
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r1 = 0
                r2.<init>(r0, r1)
                r2.f10401b = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: gb.l.a.<init>(int):void");
        }

        @Override // gb.b
        public boolean b(x xVar) {
            y8.k.e(xVar, "functionDescriptor");
            return xVar.l().size() >= this.f10401b;
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends l {

        /* renamed from: b, reason: collision with root package name */
        private final int f10402b;

        public b(int i10) {
            super("must have exactly " + i10 + " value parameters", null);
            this.f10402b = i10;
        }

        @Override // gb.b
        public boolean b(x xVar) {
            y8.k.e(xVar, "functionDescriptor");
            return xVar.l().size() == this.f10402b;
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends l {

        /* renamed from: b, reason: collision with root package name */
        public static final c f10403b = new c();

        private c() {
            super("must have no value parameters", null);
        }

        @Override // gb.b
        public boolean b(x xVar) {
            y8.k.e(xVar, "functionDescriptor");
            return xVar.l().isEmpty();
        }
    }

    /* loaded from: classes.dex */
    public static final class d extends l {

        /* renamed from: b, reason: collision with root package name */
        public static final d f10404b = new d();

        private d() {
            super("must have a single value parameter", null);
        }

        @Override // gb.b
        public boolean b(x xVar) {
            y8.k.e(xVar, "functionDescriptor");
            return xVar.l().size() == 1;
        }
    }

    private l(String str) {
        this.f10400a = str;
    }

    public /* synthetic */ l(String str, y8.g gVar) {
        this(str);
    }

    @Override // gb.b
    public String a() {
        return this.f10400a;
    }

    @Override // gb.b
    public String c(x xVar) {
        return b.a.a(this, xVar);
    }
}
