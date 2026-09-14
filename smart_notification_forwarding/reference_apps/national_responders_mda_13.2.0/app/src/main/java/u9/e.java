package u9;

import java.io.Serializable;
import y8.g;

/* loaded from: classes.dex */
public final class e implements Serializable {

    /* renamed from: h, reason: collision with root package name */
    public static final a f14495h = new a(null);

    /* renamed from: i, reason: collision with root package name */
    private static final e f14496i = new e(-1, -1);

    /* renamed from: f, reason: collision with root package name */
    private final int f14497f;

    /* renamed from: g, reason: collision with root package name */
    private final int f14498g;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final e a() {
            return e.f14496i;
        }
    }

    public e(int i10, int i11) {
        this.f14497f = i10;
        this.f14498g = i11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f14497f == eVar.f14497f && this.f14498g == eVar.f14498g;
    }

    public int hashCode() {
        return (this.f14497f * 31) + this.f14498g;
    }

    public String toString() {
        return "Position(line=" + this.f14497f + ", column=" + this.f14498g + ')';
    }
}
