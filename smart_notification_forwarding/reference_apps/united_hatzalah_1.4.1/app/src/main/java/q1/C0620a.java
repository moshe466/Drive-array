package q1;

/* renamed from: q1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0620a {

    /* renamed from: a, reason: collision with root package name */
    public final Object f6145a;

    /* renamed from: b, reason: collision with root package name */
    public final d f6146b;

    /* renamed from: c, reason: collision with root package name */
    public final C0621b f6147c;

    public C0620a(Object obj, d dVar, C0621b c0621b) {
        if (obj != null) {
            this.f6145a = obj;
            this.f6146b = dVar;
            this.f6147c = c0621b;
            return;
        }
        throw new NullPointerException("Null payload");
    }

    public final boolean equals(Object obj) {
        C0621b c0621b;
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0620a) {
            C0620a c0620a = (C0620a) obj;
            c0620a.getClass();
            Object obj2 = c0620a.f6145a;
            C0621b c0621b2 = c0620a.f6147c;
            if (this.f6145a.equals(obj2) && this.f6146b.equals(c0620a.f6146b) && ((c0621b = this.f6147c) != null ? c0621b.equals(c0621b2) : c0621b2 == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2 = ((((1000003 * 1000003) ^ this.f6145a.hashCode()) * 1000003) ^ this.f6146b.hashCode()) * 1000003;
        C0621b c0621b = this.f6147c;
        if (c0621b == null) {
            hashCode = 0;
        } else {
            hashCode = c0621b.hashCode();
        }
        return (hashCode2 ^ hashCode) * 1000003;
    }

    public final String toString() {
        return "Event{code=null, payload=" + this.f6145a + ", priority=" + this.f6146b + ", productData=" + this.f6147c + ", eventContext=null}";
    }
}
