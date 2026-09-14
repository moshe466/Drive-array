package xb;

import bc.s;
import bc.t;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import xb.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h implements Closeable {

    /* renamed from: j, reason: collision with root package name */
    static final Logger f15777j = Logger.getLogger(e.class.getName());

    /* renamed from: f, reason: collision with root package name */
    private final bc.e f15778f;

    /* renamed from: g, reason: collision with root package name */
    private final a f15779g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f15780h;

    /* renamed from: i, reason: collision with root package name */
    final d.a f15781i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a implements s {

        /* renamed from: f, reason: collision with root package name */
        private final bc.e f15782f;

        /* renamed from: g, reason: collision with root package name */
        int f15783g;

        /* renamed from: h, reason: collision with root package name */
        byte f15784h;

        /* renamed from: i, reason: collision with root package name */
        int f15785i;

        /* renamed from: j, reason: collision with root package name */
        int f15786j;

        /* renamed from: k, reason: collision with root package name */
        short f15787k;

        a(bc.e eVar) {
            this.f15782f = eVar;
        }

        private void c() {
            int i10 = this.f15785i;
            int H = h.H(this.f15782f);
            this.f15786j = H;
            this.f15783g = H;
            byte Z = (byte) (this.f15782f.Z() & 255);
            this.f15784h = (byte) (this.f15782f.Z() & 255);
            Logger logger = h.f15777j;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(e.b(true, this.f15785i, this.f15783g, Z, this.f15784h));
            }
            int s10 = this.f15782f.s() & Integer.MAX_VALUE;
            this.f15785i = s10;
            if (Z != 9) {
                throw e.d("%s != TYPE_CONTINUATION", Byte.valueOf(Z));
            }
            if (s10 != i10) {
                throw e.d("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        @Override // bc.s
        public long G(bc.c cVar, long j10) {
            while (true) {
                int i10 = this.f15786j;
                if (i10 != 0) {
                    long G = this.f15782f.G(cVar, Math.min(j10, i10));
                    if (G == -1) {
                        return -1L;
                    }
                    this.f15786j = (int) (this.f15786j - G);
                    return G;
                }
                this.f15782f.q(this.f15787k);
                this.f15787k = (short) 0;
                if ((this.f15784h & 4) != 0) {
                    return -1L;
                }
                c();
            }
        }

        @Override // bc.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // bc.s
        public t e() {
            return this.f15782f.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface b {
        void a(boolean z10, m mVar);

        void b(boolean z10, int i10, bc.e eVar, int i11);

        void c();

        void d(boolean z10, int i10, int i11);

        void e(int i10, int i11, int i12, boolean z10);

        void f(boolean z10, int i10, int i11, List<c> list);

        void g(int i10, long j10);

        void h(int i10, int i11, List<c> list);

        void i(int i10, xb.b bVar, bc.f fVar);

        void j(int i10, xb.b bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(bc.e eVar, boolean z10) {
        this.f15778f = eVar;
        this.f15780h = z10;
        a aVar = new a(eVar);
        this.f15779g = aVar;
        this.f15781i = new d.a(4096, aVar);
    }

    private void D(b bVar, int i10, byte b10, int i11) {
        if (i11 == 0) {
            throw e.d("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }
        boolean z10 = (b10 & 1) != 0;
        short Z = (b10 & 8) != 0 ? (short) (this.f15778f.Z() & 255) : (short) 0;
        if ((b10 & 32) != 0) {
            N(bVar, i11);
            i10 -= 5;
        }
        bVar.f(z10, i11, -1, v(c(i10, b10, Z), Z, b10, i11));
    }

    static int H(bc.e eVar) {
        return (eVar.Z() & 255) | ((eVar.Z() & 255) << 16) | ((eVar.Z() & 255) << 8);
    }

    private void M(b bVar, int i10, byte b10, int i11) {
        if (i10 != 8) {
            throw e.d("TYPE_PING length != 8: %s", Integer.valueOf(i10));
        }
        if (i11 != 0) {
            throw e.d("TYPE_PING streamId != 0", new Object[0]);
        }
        bVar.d((b10 & 1) != 0, this.f15778f.s(), this.f15778f.s());
    }

    private void N(b bVar, int i10) {
        int s10 = this.f15778f.s();
        bVar.e(i10, s10 & Integer.MAX_VALUE, (this.f15778f.Z() & 255) + 1, (Integer.MIN_VALUE & s10) != 0);
    }

    private void O(b bVar, int i10, byte b10, int i11) {
        if (i10 != 5) {
            throw e.d("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i10));
        }
        if (i11 == 0) {
            throw e.d("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
        N(bVar, i11);
    }

    private void a0(b bVar, int i10, byte b10, int i11) {
        if (i11 == 0) {
            throw e.d("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
        short Z = (b10 & 8) != 0 ? (short) (this.f15778f.Z() & 255) : (short) 0;
        bVar.h(i11, this.f15778f.s() & Integer.MAX_VALUE, v(c(i10 - 4, b10, Z), Z, b10, i11));
    }

    private void b0(b bVar, int i10, byte b10, int i11) {
        if (i10 != 4) {
            throw e.d("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i10));
        }
        if (i11 == 0) {
            throw e.d("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
        int s10 = this.f15778f.s();
        xb.b fromHttp2 = xb.b.fromHttp2(s10);
        if (fromHttp2 == null) {
            throw e.d("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(s10));
        }
        bVar.j(i11, fromHttp2);
    }

    static int c(int i10, byte b10, short s10) {
        if ((b10 & 8) != 0) {
            i10--;
        }
        if (s10 <= i10) {
            return (short) (i10 - s10);
        }
        throw e.d("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s10), Integer.valueOf(i10));
    }

    private void c0(b bVar, int i10, byte b10, int i11) {
        if (i11 != 0) {
            throw e.d("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        if ((b10 & 1) != 0) {
            if (i10 != 0) {
                throw e.d("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
            bVar.c();
            return;
        }
        if (i10 % 6 != 0) {
            throw e.d("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i10));
        }
        m mVar = new m();
        for (int i12 = 0; i12 < i10; i12 += 6) {
            int L = this.f15778f.L() & 65535;
            int s10 = this.f15778f.s();
            if (L != 2) {
                if (L == 3) {
                    L = 4;
                } else if (L == 4) {
                    L = 7;
                    if (s10 < 0) {
                        throw e.d("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                    }
                } else if (L == 5 && (s10 < 16384 || s10 > 16777215)) {
                    throw e.d("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(s10));
                }
            } else if (s10 != 0 && s10 != 1) {
                throw e.d("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
            }
            mVar.i(L, s10);
        }
        bVar.a(false, mVar);
    }

    private void d0(b bVar, int i10, byte b10, int i11) {
        if (i10 != 4) {
            throw e.d("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i10));
        }
        long s10 = this.f15778f.s() & 2147483647L;
        if (s10 == 0) {
            throw e.d("windowSizeIncrement was 0", Long.valueOf(s10));
        }
        bVar.g(i11, s10);
    }

    private void g(b bVar, int i10, byte b10, int i11) {
        if (i11 == 0) {
            throw e.d("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        }
        boolean z10 = (b10 & 1) != 0;
        if ((b10 & 32) != 0) {
            throw e.d("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        short Z = (b10 & 8) != 0 ? (short) (this.f15778f.Z() & 255) : (short) 0;
        bVar.b(z10, i11, this.f15778f, c(i10, b10, Z));
        this.f15778f.q(Z);
    }

    private void j(b bVar, int i10, byte b10, int i11) {
        if (i10 < 8) {
            throw e.d("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i10));
        }
        if (i11 != 0) {
            throw e.d("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
        int s10 = this.f15778f.s();
        int s11 = this.f15778f.s();
        int i12 = i10 - 8;
        xb.b fromHttp2 = xb.b.fromHttp2(s11);
        if (fromHttp2 == null) {
            throw e.d("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(s11));
        }
        bc.f fVar = bc.f.f4300j;
        if (i12 > 0) {
            fVar = this.f15778f.p(i12);
        }
        bVar.i(s10, fromHttp2, fVar);
    }

    private List<c> v(int i10, short s10, byte b10, int i11) {
        a aVar = this.f15779g;
        aVar.f15786j = i10;
        aVar.f15783g = i10;
        aVar.f15787k = s10;
        aVar.f15784h = b10;
        aVar.f15785i = i11;
        this.f15781i.k();
        return this.f15781i.e();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f15778f.close();
    }

    public boolean d(boolean z10, b bVar) {
        try {
            this.f15778f.R(9L);
            int H = H(this.f15778f);
            if (H < 0 || H > 16384) {
                throw e.d("FRAME_SIZE_ERROR: %s", Integer.valueOf(H));
            }
            byte Z = (byte) (this.f15778f.Z() & 255);
            if (z10 && Z != 4) {
                throw e.d("Expected a SETTINGS frame but was %s", Byte.valueOf(Z));
            }
            byte Z2 = (byte) (this.f15778f.Z() & 255);
            int s10 = this.f15778f.s() & Integer.MAX_VALUE;
            Logger logger = f15777j;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(e.b(true, s10, H, Z, Z2));
            }
            switch (Z) {
                case 0:
                    g(bVar, H, Z2, s10);
                    return true;
                case 1:
                    D(bVar, H, Z2, s10);
                    return true;
                case 2:
                    O(bVar, H, Z2, s10);
                    return true;
                case 3:
                    b0(bVar, H, Z2, s10);
                    return true;
                case 4:
                    c0(bVar, H, Z2, s10);
                    return true;
                case 5:
                    a0(bVar, H, Z2, s10);
                    return true;
                case 6:
                    M(bVar, H, Z2, s10);
                    return true;
                case 7:
                    j(bVar, H, Z2, s10);
                    return true;
                case 8:
                    d0(bVar, H, Z2, s10);
                    return true;
                default:
                    this.f15778f.q(H);
                    return true;
            }
        } catch (IOException unused) {
            return false;
        }
    }

    public void f(b bVar) {
        if (this.f15780h) {
            if (!d(true, bVar)) {
                throw e.d("Required SETTINGS preface not received", new Object[0]);
            }
            return;
        }
        bc.e eVar = this.f15778f;
        bc.f fVar = e.f15701a;
        bc.f p10 = eVar.p(fVar.B());
        Logger logger = f15777j;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(sb.c.r("<< CONNECTION %s", p10.v()));
        }
        if (!fVar.equals(p10)) {
            throw e.d("Expected a connection header but was %s", p10.G());
        }
    }
}
