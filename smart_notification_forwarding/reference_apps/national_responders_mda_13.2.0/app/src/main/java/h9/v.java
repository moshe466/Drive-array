package h9;

import bb.c1;
import h9.u;
import i9.e;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import n9.p0;

/* loaded from: classes.dex */
public final class v {

    /* loaded from: classes.dex */
    public static final class a extends y8.l implements x8.a<Boolean> {

        /* renamed from: f */
        final /* synthetic */ u.a f10672f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(u.a aVar) {
            super(0);
            this.f10672f = aVar;
        }

        public final boolean a() {
            return this.f10672f.q().p().u().r(k0.g());
        }

        @Override // x8.a
        public /* bridge */ /* synthetic */ Boolean b() {
            return Boolean.valueOf(a());
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends y8.l implements x8.a<Boolean> {

        /* renamed from: f */
        final /* synthetic */ u.a f10673f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(u.a aVar) {
            super(0);
            this.f10673f = aVar;
        }

        public final boolean a() {
            return !c1.l(this.f10673f.q().p().b());
        }

        @Override // x8.a
        public /* bridge */ /* synthetic */ Boolean b() {
            return Boolean.valueOf(a());
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends y8.l implements x8.l<Field, i9.e<? extends Field>> {

        /* renamed from: f */
        final /* synthetic */ u.a f10674f;

        /* renamed from: g */
        final /* synthetic */ boolean f10675g;

        /* renamed from: h */
        final /* synthetic */ b f10676h;

        /* renamed from: i */
        final /* synthetic */ a f10677i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(u.a aVar, boolean z10, b bVar, a aVar2) {
            super(1);
            this.f10674f = aVar;
            this.f10675g = z10;
            this.f10676h = bVar;
            this.f10677i = aVar2;
        }

        @Override // x8.l
        /* renamed from: a */
        public final i9.e<Field> h(Field field) {
            y8.k.e(field, "field");
            return (v.e(this.f10674f.q().p()) || !Modifier.isStatic(field.getModifiers())) ? this.f10675g ? this.f10674f.o() ? new e.f.a(field, v.d(this.f10674f)) : new e.f.c(field) : this.f10674f.o() ? new e.g.a(field, this.f10676h.a(), v.d(this.f10674f)) : new e.g.c(field, this.f10676h.a()) : this.f10677i.a() ? this.f10675g ? this.f10674f.o() ? new e.f.b(field) : new e.f.d(field) : this.f10674f.o() ? new e.g.b(field, this.f10676h.a()) : new e.g.d(field, this.f10676h.a()) : this.f10675g ? new e.f.C0203e(field) : new e.g.C0204e(field, this.f10676h.a());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final i9.d<?> c(h9.u.a<?, ?> r7, boolean r8) {
        /*
            Method dump skipped, instructions count: 593
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h9.v.c(h9.u$a, boolean):i9.d");
    }

    public static final Object d(u.a<?, ?> aVar) {
        y8.k.e(aVar, "$this$boundReceiver");
        return aVar.q().q();
    }

    public static final boolean e(p0 p0Var) {
        n9.m d10 = p0Var.d();
        y8.k.d(d10, "containingDeclaration");
        if (!na.d.x(d10)) {
            return false;
        }
        n9.m d11 = d10.d();
        return !(na.d.C(d11) || na.d.t(d11)) || ((p0Var instanceof za.j) && ka.h.f(((za.j) p0Var).Y()));
    }
}
