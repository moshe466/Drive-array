package b7;

/* loaded from: classes.dex */
public abstract class h implements f {

    /* renamed from: a, reason: collision with root package name */
    protected f f4141a;

    /* renamed from: b, reason: collision with root package name */
    protected k f4142b;

    protected h() {
    }

    private void l() {
        if (!this.f4141a.a() && this.f4142b.a()) {
            throw new e("Operation cannot be performed with only the status channel open");
        }
    }

    @Override // b7.b
    public boolean a() {
        return this.f4141a.a() || this.f4142b.a();
    }

    @Override // b7.b
    public void b(byte[] bArr, int i10, int i11) {
        l();
        this.f4141a.b(bArr, i10, i11);
    }

    @Override // b7.b
    public void c() {
        boolean z10;
        boolean z11 = true;
        try {
            f();
            z10 = true;
        } catch (e unused) {
            z10 = false;
        }
        try {
            g();
        } catch (e unused2) {
            z11 = z10;
        }
        if (!z11) {
            throw new e("Could not open connection");
        }
    }

    @Override // b7.b
    public void close() {
        this.f4141a.close();
        this.f4142b.close();
    }

    public b d() {
        return this.f4141a;
    }

    public j e() {
        return this.f4142b;
    }

    public void f() {
        this.f4141a.c();
    }

    public void g() {
        this.f4142b.c();
    }

    @Override // b7.b
    public void h(byte[] bArr) {
        l();
        this.f4141a.h(bArr);
    }

    @Override // b7.b
    public int i() {
        return this.f4141a.i();
    }

    @Override // b7.b
    public byte[] j(byte[] bArr, int i10, int i11, i iVar) {
        l();
        return this.f4141a.j(bArr, i10, i11, iVar);
    }

    @Override // b7.b
    public int k() {
        return this.f4141a.k();
    }
}
