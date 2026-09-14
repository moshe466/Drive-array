package nb;

/* loaded from: classes.dex */
public abstract class p0 extends u {

    /* renamed from: g, reason: collision with root package name */
    private long f12414g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f12415h;

    /* renamed from: i, reason: collision with root package name */
    private kotlinx.coroutines.internal.a<k0<?>> f12416i;

    private final long d0(boolean z10) {
        return z10 ? 4294967296L : 1L;
    }

    public static /* synthetic */ void h0(p0 p0Var, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        }
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        p0Var.g0(z10);
    }

    public final void c0(boolean z10) {
        long d02 = this.f12414g - d0(z10);
        this.f12414g = d02;
        if (d02 > 0) {
            return;
        }
        if (d0.a()) {
            if (!(this.f12414g == 0)) {
                throw new AssertionError();
            }
        }
        if (this.f12415h) {
            l0();
        }
    }

    public final void e0(k0<?> k0Var) {
        kotlinx.coroutines.internal.a<k0<?>> aVar = this.f12416i;
        if (aVar == null) {
            aVar = new kotlinx.coroutines.internal.a<>();
            this.f12416i = aVar;
        }
        aVar.a(k0Var);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long f0() {
        kotlinx.coroutines.internal.a<k0<?>> aVar = this.f12416i;
        return (aVar == null || aVar.c()) ? Long.MAX_VALUE : 0L;
    }

    public final void g0(boolean z10) {
        this.f12414g += d0(z10);
        if (z10) {
            return;
        }
        this.f12415h = true;
    }

    public final boolean i0() {
        return this.f12414g >= d0(true);
    }

    public final boolean j0() {
        kotlinx.coroutines.internal.a<k0<?>> aVar = this.f12416i;
        if (aVar == null) {
            return true;
        }
        return aVar.c();
    }

    public final boolean k0() {
        k0<?> d10;
        kotlinx.coroutines.internal.a<k0<?>> aVar = this.f12416i;
        if (aVar == null || (d10 = aVar.d()) == null) {
            return false;
        }
        d10.run();
        return true;
    }

    public void l0() {
    }
}
