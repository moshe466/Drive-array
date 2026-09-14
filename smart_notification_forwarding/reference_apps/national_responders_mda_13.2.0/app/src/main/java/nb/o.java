package nb;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final Object f12409a;

    /* renamed from: b, reason: collision with root package name */
    public final x8.l<Throwable, l8.w> f12410b;

    /* JADX WARN: Multi-variable type inference failed */
    public o(Object obj, x8.l<? super Throwable, l8.w> lVar) {
        this.f12409a = obj;
        this.f12410b = lVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return y8.k.a(this.f12409a, oVar.f12409a) && y8.k.a(this.f12410b, oVar.f12410b);
    }

    public int hashCode() {
        Object obj = this.f12409a;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.f12410b.hashCode();
    }

    public String toString() {
        return "CompletedWithCancellation(result=" + this.f12409a + ", onCancellation=" + this.f12410b + ')';
    }
}
