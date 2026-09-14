package ya;

import ab.n;
import ga.m;
import java.io.InputStream;
import n9.d0;
import xa.o;
import y8.g;
import y8.k;

/* loaded from: classes.dex */
public final class c extends o implements k9.b {

    /* renamed from: r, reason: collision with root package name */
    public static final a f16005r = new a(null);

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final c a(la.b bVar, n nVar, d0 d0Var, InputStream inputStream, boolean z10) {
            k.e(bVar, "fqName");
            k.e(nVar, "storageManager");
            k.e(d0Var, "module");
            k.e(inputStream, "inputStream");
            try {
                ha.a a10 = ha.a.f10697f.a(inputStream);
                if (a10 == null) {
                    k.o("version");
                    throw null;
                }
                if (a10.h()) {
                    m Y = m.Y(inputStream, ya.a.f16003m.e());
                    v8.a.a(inputStream, null);
                    k.d(Y, "proto");
                    return new c(bVar, nVar, d0Var, Y, a10, z10, null);
                }
                throw new UnsupportedOperationException("Kotlin built-in definition format version is not supported: expected " + ha.a.f10698g + ", actual " + a10 + ". Please update Kotlin");
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    v8.a.a(inputStream, th);
                    throw th2;
                }
            }
        }
    }

    private c(la.b bVar, n nVar, d0 d0Var, m mVar, ha.a aVar, boolean z10) {
        super(bVar, nVar, d0Var, mVar, aVar, null);
    }

    public /* synthetic */ c(la.b bVar, n nVar, d0 d0Var, m mVar, ha.a aVar, boolean z10, g gVar) {
        this(bVar, nVar, d0Var, mVar, aVar, z10);
    }
}
