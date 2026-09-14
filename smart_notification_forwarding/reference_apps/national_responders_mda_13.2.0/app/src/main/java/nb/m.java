package nb;

/* loaded from: classes.dex */
final class m {

    /* renamed from: a, reason: collision with root package name */
    public final Object f12401a;

    /* renamed from: b, reason: collision with root package name */
    public final e f12402b;

    /* renamed from: c, reason: collision with root package name */
    public final x8.l<Throwable, l8.w> f12403c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f12404d;

    /* renamed from: e, reason: collision with root package name */
    public final Throwable f12405e;

    /* JADX WARN: Multi-variable type inference failed */
    public m(Object obj, e eVar, x8.l<? super Throwable, l8.w> lVar, Object obj2, Throwable th) {
        this.f12401a = obj;
        this.f12402b = eVar;
        this.f12403c = lVar;
        this.f12404d = obj2;
        this.f12405e = th;
    }

    public /* synthetic */ m(Object obj, e eVar, x8.l lVar, Object obj2, Throwable th, int i10, y8.g gVar) {
        this(obj, (i10 & 2) != 0 ? null : eVar, (i10 & 4) != 0 ? null : lVar, (i10 & 8) != 0 ? null : obj2, (i10 & 16) != 0 ? null : th);
    }

    public static /* synthetic */ m b(m mVar, Object obj, e eVar, x8.l lVar, Object obj2, Throwable th, int i10, Object obj3) {
        if ((i10 & 1) != 0) {
            obj = mVar.f12401a;
        }
        if ((i10 & 2) != 0) {
            eVar = mVar.f12402b;
        }
        e eVar2 = eVar;
        if ((i10 & 4) != 0) {
            lVar = mVar.f12403c;
        }
        x8.l lVar2 = lVar;
        if ((i10 & 8) != 0) {
            obj2 = mVar.f12404d;
        }
        Object obj4 = obj2;
        if ((i10 & 16) != 0) {
            th = mVar.f12405e;
        }
        return mVar.a(obj, eVar2, lVar2, obj4, th);
    }

    public final m a(Object obj, e eVar, x8.l<? super Throwable, l8.w> lVar, Object obj2, Throwable th) {
        return new m(obj, eVar, lVar, obj2, th);
    }

    public final boolean c() {
        return this.f12405e != null;
    }

    public final void d(h<?> hVar, Throwable th) {
        e eVar = this.f12402b;
        if (eVar != null) {
            hVar.l(eVar, th);
        }
        x8.l<Throwable, l8.w> lVar = this.f12403c;
        if (lVar == null) {
            return;
        }
        hVar.m(lVar, th);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return y8.k.a(this.f12401a, mVar.f12401a) && y8.k.a(this.f12402b, mVar.f12402b) && y8.k.a(this.f12403c, mVar.f12403c) && y8.k.a(this.f12404d, mVar.f12404d) && y8.k.a(this.f12405e, mVar.f12405e);
    }

    public int hashCode() {
        Object obj = this.f12401a;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        e eVar = this.f12402b;
        int hashCode2 = (hashCode + (eVar == null ? 0 : eVar.hashCode())) * 31;
        x8.l<Throwable, l8.w> lVar = this.f12403c;
        int hashCode3 = (hashCode2 + (lVar == null ? 0 : lVar.hashCode())) * 31;
        Object obj2 = this.f12404d;
        int hashCode4 = (hashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f12405e;
        return hashCode4 + (th != null ? th.hashCode() : 0);
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.f12401a + ", cancelHandler=" + this.f12402b + ", onCancellation=" + this.f12403c + ", idempotentResume=" + this.f12404d + ", cancelCause=" + this.f12405e + ')';
    }
}
