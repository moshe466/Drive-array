package nb;

import java.io.Closeable;
import p8.f;

/* loaded from: classes.dex */
public abstract class u0 extends u implements Closeable {

    /* loaded from: classes.dex */
    public static final class a extends p8.b<u, u0> {

        /* renamed from: nb.u0$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static final class C0261a extends y8.l implements x8.l<f.b, u0> {

            /* renamed from: f, reason: collision with root package name */
            public static final C0261a f12431f = new C0261a();

            C0261a() {
                super(1);
            }

            @Override // x8.l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final u0 h(f.b bVar) {
                if (bVar instanceof u0) {
                    return (u0) bVar;
                }
                return null;
            }
        }

        private a() {
            super(u.f12429f, C0261a.f12431f);
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }
    }

    static {
        new a(null);
    }
}
