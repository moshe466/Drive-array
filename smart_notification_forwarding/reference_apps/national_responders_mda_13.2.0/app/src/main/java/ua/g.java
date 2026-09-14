package ua;

/* loaded from: classes.dex */
public final class g extends ua.a {

    /* renamed from: b, reason: collision with root package name */
    private final ab.i<h> f14535b;

    /* loaded from: classes.dex */
    static final class a extends y8.l implements x8.a<h> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ x8.a<h> f14536f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(x8.a<? extends h> aVar) {
            super(0);
            this.f14536f = aVar;
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final h b() {
            h b10 = this.f14536f.b();
            return b10 instanceof ua.a ? ((ua.a) b10).h() : b10;
        }
    }

    public g(ab.n nVar, x8.a<? extends h> aVar) {
        y8.k.e(nVar, "storageManager");
        y8.k.e(aVar, "getScope");
        this.f14535b = nVar.a(new a(aVar));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ g(ab.n r1, x8.a r2, int r3, y8.g r4) {
        /*
            r0 = this;
            r3 = r3 & 1
            if (r3 == 0) goto Lb
            ab.n r1 = ab.f.f359e
            java.lang.String r3 = "NO_LOCKS"
            y8.k.d(r1, r3)
        Lb:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ua.g.<init>(ab.n, x8.a, int, y8.g):void");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public g(x8.a<? extends h> aVar) {
        this(null, aVar, 1, 0 == true ? 1 : 0);
        y8.k.e(aVar, "getScope");
    }

    @Override // ua.a
    protected h i() {
        return this.f14535b.b();
    }
}
