package bc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    final byte[] f4328a;

    /* renamed from: b, reason: collision with root package name */
    int f4329b;

    /* renamed from: c, reason: collision with root package name */
    int f4330c;

    /* renamed from: d, reason: collision with root package name */
    boolean f4331d;

    /* renamed from: e, reason: collision with root package name */
    boolean f4332e;

    /* renamed from: f, reason: collision with root package name */
    o f4333f;

    /* renamed from: g, reason: collision with root package name */
    o f4334g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o() {
        this.f4328a = new byte[8192];
        this.f4332e = true;
        this.f4331d = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(byte[] bArr, int i10, int i11, boolean z10, boolean z11) {
        this.f4328a = bArr;
        this.f4329b = i10;
        this.f4330c = i11;
        this.f4331d = z10;
        this.f4332e = z11;
    }

    public final void a() {
        o oVar = this.f4334g;
        if (oVar == this) {
            throw new IllegalStateException();
        }
        if (oVar.f4332e) {
            int i10 = this.f4330c - this.f4329b;
            if (i10 > (8192 - oVar.f4330c) + (oVar.f4331d ? 0 : oVar.f4329b)) {
                return;
            }
            f(oVar, i10);
            b();
            p.a(this);
        }
    }

    public final o b() {
        o oVar = this.f4333f;
        o oVar2 = oVar != this ? oVar : null;
        o oVar3 = this.f4334g;
        oVar3.f4333f = oVar;
        this.f4333f.f4334g = oVar3;
        this.f4333f = null;
        this.f4334g = null;
        return oVar2;
    }

    public final o c(o oVar) {
        oVar.f4334g = this;
        oVar.f4333f = this.f4333f;
        this.f4333f.f4334g = oVar;
        this.f4333f = oVar;
        return oVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final o d() {
        this.f4331d = true;
        return new o(this.f4328a, this.f4329b, this.f4330c, true, false);
    }

    public final o e(int i10) {
        o b10;
        if (i10 <= 0 || i10 > this.f4330c - this.f4329b) {
            throw new IllegalArgumentException();
        }
        if (i10 >= 1024) {
            b10 = d();
        } else {
            b10 = p.b();
            System.arraycopy(this.f4328a, this.f4329b, b10.f4328a, 0, i10);
        }
        b10.f4330c = b10.f4329b + i10;
        this.f4329b += i10;
        this.f4334g.c(b10);
        return b10;
    }

    public final void f(o oVar, int i10) {
        if (!oVar.f4332e) {
            throw new IllegalArgumentException();
        }
        int i11 = oVar.f4330c;
        if (i11 + i10 > 8192) {
            if (oVar.f4331d) {
                throw new IllegalArgumentException();
            }
            int i12 = oVar.f4329b;
            if ((i11 + i10) - i12 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = oVar.f4328a;
            System.arraycopy(bArr, i12, bArr, 0, i11 - i12);
            oVar.f4330c -= oVar.f4329b;
            oVar.f4329b = 0;
        }
        System.arraycopy(this.f4328a, this.f4329b, oVar.f4328a, oVar.f4330c, i10);
        oVar.f4330c += i10;
        this.f4329b += i10;
    }
}
