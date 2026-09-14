package kb;

/* loaded from: classes.dex */
final class c<V> {

    /* renamed from: f, reason: collision with root package name */
    static final c<Object> f11331f = new c<>();

    /* renamed from: a, reason: collision with root package name */
    private final long f11332a;

    /* renamed from: b, reason: collision with root package name */
    private final V f11333b;

    /* renamed from: c, reason: collision with root package name */
    private final c<V> f11334c;

    /* renamed from: d, reason: collision with root package name */
    private final c<V> f11335d;

    /* renamed from: e, reason: collision with root package name */
    private final int f11336e;

    private c() {
        this.f11336e = 0;
        this.f11332a = 0L;
        this.f11333b = null;
        this.f11334c = null;
        this.f11335d = null;
    }

    private c(long j10, V v10, c<V> cVar, c<V> cVar2) {
        this.f11332a = j10;
        this.f11333b = v10;
        this.f11334c = cVar;
        this.f11335d = cVar2;
        this.f11336e = cVar.f11336e + 1 + cVar2.f11336e;
    }

    private static <V> c<V> c(long j10, V v10, c<V> cVar, c<V> cVar2) {
        int i10 = ((c) cVar).f11336e;
        int i11 = ((c) cVar2).f11336e;
        if (i10 + i11 > 1) {
            if (i10 >= i11 * 5) {
                c<V> cVar3 = ((c) cVar).f11334c;
                c<V> cVar4 = ((c) cVar).f11335d;
                if (((c) cVar4).f11336e < ((c) cVar3).f11336e * 2) {
                    long j11 = ((c) cVar).f11332a;
                    return new c<>(j11 + j10, ((c) cVar).f11333b, cVar3, new c(-j11, v10, cVar4.e(((c) cVar4).f11332a + j11), cVar2));
                }
                c<V> cVar5 = ((c) cVar4).f11334c;
                c<V> cVar6 = ((c) cVar4).f11335d;
                long j12 = ((c) cVar4).f11332a;
                long j13 = ((c) cVar).f11332a + j12 + j10;
                V v11 = ((c) cVar4).f11333b;
                c cVar7 = new c(-j12, ((c) cVar).f11333b, cVar3, cVar5.e(((c) cVar5).f11332a + j12));
                long j14 = ((c) cVar).f11332a;
                long j15 = ((c) cVar4).f11332a;
                return new c<>(j13, v11, cVar7, new c((-j14) - j15, v10, cVar6.e(((c) cVar6).f11332a + j15 + j14), cVar2));
            }
            if (i11 >= i10 * 5) {
                c<V> cVar8 = ((c) cVar2).f11334c;
                c<V> cVar9 = ((c) cVar2).f11335d;
                if (((c) cVar8).f11336e < ((c) cVar9).f11336e * 2) {
                    long j16 = ((c) cVar2).f11332a;
                    return new c<>(j16 + j10, ((c) cVar2).f11333b, new c(-j16, v10, cVar, cVar8.e(((c) cVar8).f11332a + j16)), cVar9);
                }
                c<V> cVar10 = ((c) cVar8).f11334c;
                c<V> cVar11 = ((c) cVar8).f11335d;
                long j17 = ((c) cVar8).f11332a;
                long j18 = ((c) cVar2).f11332a;
                long j19 = j17 + j18 + j10;
                V v12 = ((c) cVar8).f11333b;
                c cVar12 = new c((-j18) - j17, v10, cVar, cVar10.e(((c) cVar10).f11332a + j17 + j18));
                long j20 = ((c) cVar8).f11332a;
                return new c<>(j19, v12, cVar12, new c(-j20, ((c) cVar2).f11333b, cVar11.e(((c) cVar11).f11332a + j20), cVar9));
            }
        }
        return new c<>(j10, v10, cVar, cVar2);
    }

    private c<V> d(c<V> cVar, c<V> cVar2) {
        return (cVar == this.f11334c && cVar2 == this.f11335d) ? this : c(this.f11332a, this.f11333b, cVar, cVar2);
    }

    private c<V> e(long j10) {
        return (this.f11336e == 0 || j10 == this.f11332a) ? this : new c<>(j10, this.f11333b, this.f11334c, this.f11335d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public V a(long j10) {
        c<V> cVar;
        if (this.f11336e == 0) {
            return null;
        }
        long j11 = this.f11332a;
        if (j10 < j11) {
            cVar = this.f11334c;
        } else {
            if (j10 <= j11) {
                return this.f11333b;
            }
            cVar = this.f11335d;
        }
        return cVar.a(j10 - j11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c<V> b(long j10, V v10) {
        if (this.f11336e == 0) {
            return new c<>(j10, v10, this, this);
        }
        long j11 = this.f11332a;
        return j10 < j11 ? d(this.f11334c.b(j10 - j11, v10), this.f11335d) : j10 > j11 ? d(this.f11334c, this.f11335d.b(j10 - j11, v10)) : v10 == this.f11333b ? this : new c<>(j10, v10, this.f11334c, this.f11335d);
    }
}
