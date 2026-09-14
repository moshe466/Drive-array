package m9;

import ab.m;
import ab.n;
import java.util.List;
import kotlin.reflect.KProperty;
import m8.y;
import n9.d0;
import p9.x;
import y8.k;
import y8.l;
import y8.t;
import y8.w;

/* loaded from: classes.dex */
public final class f extends k9.h {

    /* renamed from: h, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f12083h = {w.g(new t(w.b(f.class), "customizer", "getCustomizer()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsCustomizer;"))};

    /* renamed from: f, reason: collision with root package name */
    private x8.a<b> f12084f;

    /* renamed from: g, reason: collision with root package name */
    private final ab.i f12085g;

    /* loaded from: classes.dex */
    public enum a {
        FROM_DEPENDENCIES,
        FROM_CLASS_LOADER,
        FALLBACK;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] valuesCustom = values();
            a[] aVarArr = new a[valuesCustom.length];
            System.arraycopy(valuesCustom, 0, aVarArr, 0, valuesCustom.length);
            return aVarArr;
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final d0 f12086a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f12087b;

        public b(d0 d0Var, boolean z10) {
            k.e(d0Var, "ownerModuleDescriptor");
            this.f12086a = d0Var;
            this.f12087b = z10;
        }

        public final d0 a() {
            return this.f12086a;
        }

        public final boolean b() {
            return this.f12087b;
        }
    }

    /* loaded from: classes.dex */
    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12088a;

        static {
            int[] iArr = new int[a.valuesCustom().length];
            iArr[a.FROM_DEPENDENCIES.ordinal()] = 1;
            iArr[a.FROM_CLASS_LOADER.ordinal()] = 2;
            iArr[a.FALLBACK.ordinal()] = 3;
            f12088a = iArr;
        }
    }

    /* loaded from: classes.dex */
    static final class d extends l implements x8.a<g> {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ n f12090g;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static final class a extends l implements x8.a<b> {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ f f12091f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(f fVar) {
                super(0);
                this.f12091f = fVar;
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final b b() {
                x8.a aVar = this.f12091f.f12084f;
                if (aVar == null) {
                    throw new AssertionError("JvmBuiltins instance has not been initialized properly");
                }
                b bVar = (b) aVar.b();
                this.f12091f.f12084f = null;
                return bVar;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(n nVar) {
            super(0);
            this.f12090g = nVar;
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final g b() {
            x r10 = f.this.r();
            k.d(r10, "builtInsModule");
            return new g(r10, this.f12090g, new a(f.this));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class e extends l implements x8.a<b> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ d0 f12092f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f12093g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(d0 d0Var, boolean z10) {
            super(0);
            this.f12092f = d0Var;
            this.f12093g = z10;
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b b() {
            return new b(this.f12092f, this.f12093g);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(n nVar, a aVar) {
        super(nVar);
        boolean z10;
        k.e(nVar, "storageManager");
        k.e(aVar, "kind");
        this.f12085g = nVar.a(new d(nVar));
        int i10 = c.f12088a[aVar.ordinal()];
        if (i10 == 2) {
            z10 = false;
        } else if (i10 != 3) {
            return;
        } else {
            z10 = true;
        }
        f(z10);
    }

    @Override // k9.h
    protected o9.c M() {
        return P0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // k9.h
    /* renamed from: O0, reason: merged with bridge method [inline-methods] */
    public List<o9.b> v() {
        List<o9.b> Z;
        Iterable<o9.b> v10 = super.v();
        k.d(v10, "super.getClassDescriptorFactories()");
        n T = T();
        k.d(T, "storageManager");
        x r10 = r();
        k.d(r10, "builtInsModule");
        Z = y.Z(v10, new m9.e(T, r10, null, 4, null));
        return Z;
    }

    public final g P0() {
        return (g) m.a(this.f12085g, this, f12083h[0]);
    }

    public final void Q0(d0 d0Var, boolean z10) {
        k.e(d0Var, "moduleDescriptor");
        R0(new e(d0Var, z10));
    }

    public final void R0(x8.a<b> aVar) {
        k.e(aVar, "computation");
        this.f12084f = aVar;
    }

    @Override // k9.h
    protected o9.a g() {
        return P0();
    }
}
