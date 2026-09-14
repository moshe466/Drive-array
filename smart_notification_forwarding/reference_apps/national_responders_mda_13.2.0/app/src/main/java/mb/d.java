package mb;

import java.util.List;

/* loaded from: classes.dex */
public interface d {

    /* loaded from: classes.dex */
    public static final class a {
        public static b a(d dVar) {
            return new b(dVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final d f12124a;

        public b(d dVar) {
            y8.k.e(dVar, "match");
            this.f12124a = dVar;
        }

        public final d a() {
            return this.f12124a;
        }
    }

    List<String> a();

    b b();
}
