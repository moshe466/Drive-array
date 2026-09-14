package R2;

/* loaded from: classes.dex */
public final class h extends i {

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f2056a;

    public h(Throwable th) {
        this.f2056a = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof h) {
            if (kotlin.jvm.internal.j.a(this.f2056a, ((h) obj).f2056a)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        Throwable th = this.f2056a;
        if (th != null) {
            return th.hashCode();
        }
        return 0;
    }

    @Override // R2.i
    public final String toString() {
        return "Closed(" + this.f2056a + ')';
    }
}
