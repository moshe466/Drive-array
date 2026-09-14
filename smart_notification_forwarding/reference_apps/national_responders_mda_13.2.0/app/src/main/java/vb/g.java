package vb;

import java.util.List;
import okhttp3.a0;
import okhttp3.o;
import okhttp3.s;
import okhttp3.y;

/* loaded from: classes.dex */
public final class g implements s.a {

    /* renamed from: a, reason: collision with root package name */
    private final List<s> f14856a;

    /* renamed from: b, reason: collision with root package name */
    private final ub.g f14857b;

    /* renamed from: c, reason: collision with root package name */
    private final c f14858c;

    /* renamed from: d, reason: collision with root package name */
    private final ub.c f14859d;

    /* renamed from: e, reason: collision with root package name */
    private final int f14860e;

    /* renamed from: f, reason: collision with root package name */
    private final y f14861f;

    /* renamed from: g, reason: collision with root package name */
    private final okhttp3.d f14862g;

    /* renamed from: h, reason: collision with root package name */
    private final o f14863h;

    /* renamed from: i, reason: collision with root package name */
    private final int f14864i;

    /* renamed from: j, reason: collision with root package name */
    private final int f14865j;

    /* renamed from: k, reason: collision with root package name */
    private final int f14866k;

    /* renamed from: l, reason: collision with root package name */
    private int f14867l;

    public g(List<s> list, ub.g gVar, c cVar, ub.c cVar2, int i10, y yVar, okhttp3.d dVar, o oVar, int i11, int i12, int i13) {
        this.f14856a = list;
        this.f14859d = cVar2;
        this.f14857b = gVar;
        this.f14858c = cVar;
        this.f14860e = i10;
        this.f14861f = yVar;
        this.f14862g = dVar;
        this.f14863h = oVar;
        this.f14864i = i11;
        this.f14865j = i12;
        this.f14866k = i13;
    }

    @Override // okhttp3.s.a
    public int a() {
        return this.f14864i;
    }

    @Override // okhttp3.s.a
    public int b() {
        return this.f14865j;
    }

    @Override // okhttp3.s.a
    public int c() {
        return this.f14866k;
    }

    @Override // okhttp3.s.a
    public a0 d(y yVar) {
        return j(yVar, this.f14857b, this.f14858c, this.f14859d);
    }

    @Override // okhttp3.s.a
    public y e() {
        return this.f14861f;
    }

    public okhttp3.d f() {
        return this.f14862g;
    }

    public okhttp3.h g() {
        return this.f14859d;
    }

    public o h() {
        return this.f14863h;
    }

    public c i() {
        return this.f14858c;
    }

    public a0 j(y yVar, ub.g gVar, c cVar, ub.c cVar2) {
        if (this.f14860e >= this.f14856a.size()) {
            throw new AssertionError();
        }
        this.f14867l++;
        if (this.f14858c != null && !this.f14859d.s(yVar.h())) {
            throw new IllegalStateException("network interceptor " + this.f14856a.get(this.f14860e - 1) + " must retain the same host and port");
        }
        if (this.f14858c != null && this.f14867l > 1) {
            throw new IllegalStateException("network interceptor " + this.f14856a.get(this.f14860e - 1) + " must call proceed() exactly once");
        }
        g gVar2 = new g(this.f14856a, gVar, cVar, cVar2, this.f14860e + 1, yVar, this.f14862g, this.f14863h, this.f14864i, this.f14865j, this.f14866k);
        s sVar = this.f14856a.get(this.f14860e);
        a0 a10 = sVar.a(gVar2);
        if (cVar != null && this.f14860e + 1 < this.f14856a.size() && gVar2.f14867l != 1) {
            throw new IllegalStateException("network interceptor " + sVar + " must call proceed() exactly once");
        }
        if (a10 == null) {
            throw new NullPointerException("interceptor " + sVar + " returned null");
        }
        if (a10.c() != null) {
            return a10;
        }
        throw new IllegalStateException("interceptor " + sVar + " returned a response with no body");
    }

    public ub.g k() {
        return this.f14857b;
    }
}
