package androidx.emoji2.text;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
class l {

    /* loaded from: classes.dex */
    private static class a implements c {

        /* renamed from: a, reason: collision with root package name */
        private final ByteBuffer f2812a;

        a(ByteBuffer byteBuffer) {
            this.f2812a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // androidx.emoji2.text.l.c
        public long a() {
            return this.f2812a.position();
        }

        @Override // androidx.emoji2.text.l.c
        public void b(int i10) {
            ByteBuffer byteBuffer = this.f2812a;
            byteBuffer.position(byteBuffer.position() + i10);
        }

        @Override // androidx.emoji2.text.l.c
        public int c() {
            return l.d(this.f2812a.getShort());
        }

        @Override // androidx.emoji2.text.l.c
        public long d() {
            return l.c(this.f2812a.getInt());
        }

        @Override // androidx.emoji2.text.l.c
        public int e() {
            return this.f2812a.getInt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final long f2813a;

        b(long j10, long j11) {
            this.f2813a = j10;
        }

        long a() {
            return this.f2813a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface c {
        long a();

        void b(int i10);

        int c();

        long d();

        int e();
    }

    private static b a(c cVar) {
        long j10;
        cVar.b(4);
        int c10 = cVar.c();
        if (c10 > 100) {
            throw new IOException("Cannot read metadata.");
        }
        cVar.b(6);
        int i10 = 0;
        while (true) {
            if (i10 >= c10) {
                j10 = -1;
                break;
            }
            int e10 = cVar.e();
            cVar.b(4);
            j10 = cVar.d();
            cVar.b(4);
            if (1835365473 == e10) {
                break;
            }
            i10++;
        }
        if (j10 != -1) {
            cVar.b((int) (j10 - cVar.a()));
            cVar.b(12);
            long d10 = cVar.d();
            for (int i11 = 0; i11 < d10; i11++) {
                int e11 = cVar.e();
                long d11 = cVar.d();
                long d12 = cVar.d();
                if (1164798569 == e11 || 1701669481 == e11) {
                    return new b(d11 + j10, d12);
                }
            }
        }
        throw new IOException("Cannot read metadata.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b0.b b(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.position((int) a(new a(duplicate)).a());
        return b0.b.h(duplicate);
    }

    static long c(int i10) {
        return i10 & 4294967295L;
    }

    static int d(short s10) {
        return s10 & 65535;
    }
}
