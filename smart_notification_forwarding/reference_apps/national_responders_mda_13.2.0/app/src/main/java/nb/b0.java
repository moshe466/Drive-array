package nb;

import p8.f;

/* loaded from: classes.dex */
public final class b0 extends p8.a {

    /* renamed from: g, reason: collision with root package name */
    public static final a f12363g = new a(null);

    /* renamed from: f, reason: collision with root package name */
    private final String f12364f;

    /* loaded from: classes.dex */
    public static final class a implements f.c<b0> {
        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }
    }

    public final String c() {
        return this.f12364f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b0) && y8.k.a(this.f12364f, ((b0) obj).f12364f);
    }

    public int hashCode() {
        return this.f12364f.hashCode();
    }

    public String toString() {
        return "CoroutineName(" + this.f12364f + ')';
    }
}
