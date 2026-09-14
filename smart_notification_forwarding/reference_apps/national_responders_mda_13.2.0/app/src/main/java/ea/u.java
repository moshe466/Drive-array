package ea;

import java.util.List;

/* loaded from: classes.dex */
public interface u {

    /* loaded from: classes.dex */
    public static final class a implements u {

        /* renamed from: a, reason: collision with root package name */
        public static final a f9329a = new a();

        private a() {
        }

        @Override // ea.u
        public List<String> a(String str) {
            List<String> d10;
            y8.k.e(str, "packageFqName");
            d10 = m8.q.d();
            return d10;
        }
    }

    List<String> a(String str);
}
