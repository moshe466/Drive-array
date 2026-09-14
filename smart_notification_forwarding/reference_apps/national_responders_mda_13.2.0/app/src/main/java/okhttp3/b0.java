package okhttp3;

import java.io.Closeable;
import java.nio.charset.Charset;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class b0 implements Closeable {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends b0 {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ t f12683f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f12684g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ bc.e f12685h;

        a(t tVar, long j10, bc.e eVar) {
            this.f12683f = tVar;
            this.f12684g = j10;
            this.f12685h = eVar;
        }

        @Override // okhttp3.b0
        public long d() {
            return this.f12684g;
        }

        @Override // okhttp3.b0
        public t f() {
            return this.f12683f;
        }

        @Override // okhttp3.b0
        public bc.e v() {
            return this.f12685h;
        }
    }

    private Charset c() {
        t f10 = f();
        return f10 != null ? f10.b(sb.c.f14204i) : sb.c.f14204i;
    }

    public static b0 g(t tVar, long j10, bc.e eVar) {
        Objects.requireNonNull(eVar, "source == null");
        return new a(tVar, j10, eVar);
    }

    public static b0 j(t tVar, byte[] bArr) {
        return g(tVar, bArr.length, new bc.c().h(bArr));
    }

    public final String D() {
        bc.e v10 = v();
        try {
            return v10.X(sb.c.c(v10, c()));
        } finally {
            sb.c.g(v10);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        sb.c.g(v());
    }

    public abstract long d();

    public abstract t f();

    public abstract bc.e v();
}
