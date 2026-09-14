package q2;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e1 extends f1 {

    /* renamed from: h, reason: collision with root package name */
    final transient int f13485h;

    /* renamed from: i, reason: collision with root package name */
    final transient int f13486i;

    /* renamed from: j, reason: collision with root package name */
    final /* synthetic */ f1 f13487j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e1(f1 f1Var, int i10, int i11) {
        this.f13487j = f1Var;
        this.f13485h = i10;
        this.f13486i = i11;
    }

    @Override // q2.c1
    final int f() {
        return this.f13487j.g() + this.f13485h + this.f13486i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // q2.c1
    public final int g() {
        return this.f13487j.g() + this.f13485h;
    }

    @Override // java.util.List
    public final Object get(int i10) {
        z0.a(i10, this.f13486i, "index");
        return this.f13487j.get(i10 + this.f13485h);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // q2.c1
    public final boolean s() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f13486i;
    }

    @Override // q2.f1, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i10, int i11) {
        return subList(i10, i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // q2.c1
    public final Object[] t() {
        return this.f13487j.t();
    }

    @Override // q2.f1
    /* renamed from: u */
    public final f1 subList(int i10, int i11) {
        z0.c(i10, i11, this.f13486i);
        f1 f1Var = this.f13487j;
        int i12 = this.f13485h;
        return f1Var.subList(i10 + i12, i11 + i12);
    }
}
