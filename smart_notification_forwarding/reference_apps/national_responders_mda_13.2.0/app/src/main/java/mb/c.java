package mb;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final String f12122a;

    /* renamed from: b, reason: collision with root package name */
    private final d9.c f12123b;

    public c(String str, d9.c cVar) {
        y8.k.e(str, "value");
        y8.k.e(cVar, "range");
        this.f12122a = str;
        this.f12123b = cVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return y8.k.a(this.f12122a, cVar.f12122a) && y8.k.a(this.f12123b, cVar.f12123b);
    }

    public int hashCode() {
        return (this.f12122a.hashCode() * 31) + this.f12123b.hashCode();
    }

    public String toString() {
        return "MatchGroup(value=" + this.f12122a + ", range=" + this.f12123b + ')';
    }
}
