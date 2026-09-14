package bb;

import db.n;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class f implements db.n {

    /* renamed from: a, reason: collision with root package name */
    private int f4195a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f4196b;

    /* renamed from: c, reason: collision with root package name */
    private ArrayDeque<db.i> f4197c;

    /* renamed from: d, reason: collision with root package name */
    private Set<db.i> f4198d;

    /* loaded from: classes.dex */
    public enum a {
        CHECK_ONLY_LOWER,
        CHECK_SUBTYPE_AND_LOWER,
        SKIP_LOWER;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] valuesCustom = values();
            a[] aVarArr = new a[valuesCustom.length];
            System.arraycopy(valuesCustom, 0, aVarArr, 0, valuesCustom.length);
            return aVarArr;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b {

        /* loaded from: classes.dex */
        public static abstract class a extends b {
            public a() {
                super(null);
            }
        }

        /* renamed from: bb.f$b$b, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0071b extends b {

            /* renamed from: a, reason: collision with root package name */
            public static final C0071b f4199a = new C0071b();

            private C0071b() {
                super(null);
            }

            @Override // bb.f.b
            public db.i a(f fVar, db.h hVar) {
                y8.k.e(fVar, "context");
                y8.k.e(hVar, "type");
                return fVar.C(hVar);
            }
        }

        /* loaded from: classes.dex */
        public static final class c extends b {

            /* renamed from: a, reason: collision with root package name */
            public static final c f4200a = new c();

            private c() {
                super(null);
            }

            @Override // bb.f.b
            public /* bridge */ /* synthetic */ db.i a(f fVar, db.h hVar) {
                return (db.i) b(fVar, hVar);
            }

            public Void b(f fVar, db.h hVar) {
                y8.k.e(fVar, "context");
                y8.k.e(hVar, "type");
                throw new UnsupportedOperationException("Should not be called");
            }
        }

        /* loaded from: classes.dex */
        public static final class d extends b {

            /* renamed from: a, reason: collision with root package name */
            public static final d f4201a = new d();

            private d() {
                super(null);
            }

            @Override // bb.f.b
            public db.i a(f fVar, db.h hVar) {
                y8.k.e(fVar, "context");
                y8.k.e(hVar, "type");
                return fVar.i(hVar);
            }
        }

        private b() {
        }

        public /* synthetic */ b(y8.g gVar) {
            this();
        }

        public abstract db.i a(f fVar, db.h hVar);
    }

    public static /* synthetic */ Boolean l0(f fVar, db.h hVar, db.h hVar2, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addSubtypeConstraint");
        }
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return fVar.k0(hVar, hVar2, z10);
    }

    public boolean A0(db.i iVar) {
        return n.a.h(this, iVar);
    }

    public boolean B0(db.h hVar) {
        return n.a.j(this, hVar);
    }

    @Override // db.n
    public db.i C(db.h hVar) {
        return n.a.k(this, hVar);
    }

    public abstract boolean C0();

    public abstract db.h D0(db.h hVar);

    public abstract db.h E0(db.h hVar);

    public abstract b F0(db.i iVar);

    @Override // db.n
    public db.l J(db.h hVar) {
        return n.a.m(this, hVar);
    }

    @Override // db.n
    public boolean V(db.h hVar) {
        return n.a.i(this, hVar);
    }

    @Override // db.n
    public db.k c0(db.j jVar, int i10) {
        return n.a.b(this, jVar, i10);
    }

    @Override // db.n
    public db.i i(db.h hVar) {
        return n.a.n(this, hVar);
    }

    public Boolean k0(db.h hVar, db.h hVar2, boolean z10) {
        y8.k.e(hVar, "subType");
        y8.k.e(hVar2, "superType");
        return null;
    }

    @Override // db.n
    public int l(db.j jVar) {
        return n.a.l(this, jVar);
    }

    public final void m0() {
        ArrayDeque<db.i> arrayDeque = this.f4197c;
        y8.k.b(arrayDeque);
        arrayDeque.clear();
        Set<db.i> set = this.f4198d;
        y8.k.b(set);
        set.clear();
        this.f4196b = false;
    }

    public boolean n0(db.h hVar, db.h hVar2) {
        y8.k.e(hVar, "subType");
        y8.k.e(hVar2, "superType");
        return true;
    }

    public List<db.i> o0(db.i iVar, db.l lVar) {
        return n.a.a(this, iVar, lVar);
    }

    public db.k p0(db.i iVar, int i10) {
        return n.a.c(this, iVar, i10);
    }

    public a q0(db.i iVar, db.c cVar) {
        y8.k.e(iVar, "subType");
        y8.k.e(cVar, "superType");
        return a.CHECK_SUBTYPE_AND_LOWER;
    }

    public final ArrayDeque<db.i> r0() {
        return this.f4197c;
    }

    public final Set<db.i> s0() {
        return this.f4198d;
    }

    public boolean t0(db.h hVar) {
        return n.a.d(this, hVar);
    }

    public final void u0() {
        this.f4196b = true;
        if (this.f4197c == null) {
            this.f4197c = new ArrayDeque<>(4);
        }
        if (this.f4198d == null) {
            this.f4198d = jb.j.f11086h.a();
        }
    }

    public abstract boolean v0(db.h hVar);

    public boolean w0(db.i iVar) {
        return n.a.e(this, iVar);
    }

    public boolean x0(db.h hVar) {
        return n.a.f(this, hVar);
    }

    public boolean y0(db.h hVar) {
        return n.a.g(this, hVar);
    }

    public abstract boolean z0();
}
