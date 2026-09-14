package M1;

import androidx.datastore.preferences.protobuf.C0240g;
import com.google.crypto.tink.shaded.protobuf.C0336h;
import com.google.crypto.tink.shaded.protobuf.C0338j;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public int f1402a;

    /* renamed from: b, reason: collision with root package name */
    public Object f1403b;

    public static int d(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long e(long j2) {
        return (-(j2 & 1)) ^ (j2 >>> 1);
    }

    public static C0338j h(byte[] bArr, int i, int i3, boolean z3) {
        C0338j c0338j = new C0338j(bArr, i, i3, z3);
        try {
            c0338j.l(i3);
            return c0338j;
        } catch (InvalidProtocolBufferException e4) {
            throw new IllegalArgumentException(e4);
        }
    }

    public abstract String A();

    public abstract String B();

    public abstract int C();

    public abstract int D();

    public abstract long E();

    public abstract boolean F(int i);

    public void G() {
        int C3;
        do {
            C3 = C();
            if (C3 != 0) {
                int i = this.f1402a;
                if (i < 100) {
                    this.f1402a = i + 1;
                    this.f1402a--;
                } else {
                    throw new IOException("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
                }
            } else {
                return;
            }
        } while (F(C3));
    }

    public ByteBuffer a(byte[] bArr, int i) {
        int[] c4 = c(a.c(bArr), i);
        int[] iArr = (int[]) c4.clone();
        a.b(iArr);
        for (int i3 = 0; i3 < c4.length; i3++) {
            c4[i3] = c4[i3] + iArr[i3];
        }
        ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        order.asIntBuffer().put(c4, 0, 16);
        return order;
    }

    public abstract void b(int i);

    public abstract int[] c(int[] iArr, int i);

    public abstract int f();

    public abstract boolean g();

    public abstract int i();

    public abstract void j(int i);

    public void k(byte[] bArr, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        if (bArr.length == i()) {
            int remaining = byteBuffer2.remaining();
            int i = remaining / 64;
            int i3 = i + 1;
            for (int i4 = 0; i4 < i3; i4++) {
                ByteBuffer a2 = a(bArr, this.f1402a + i4);
                if (i4 == i) {
                    T.b.S(byteBuffer, byteBuffer2, a2, remaining % 64);
                } else {
                    T.b.S(byteBuffer, byteBuffer2, a2, 64);
                }
            }
            return;
        }
        throw new GeneralSecurityException("The nonce length (in bytes) must be " + i());
    }

    public abstract int l(int i);

    public abstract boolean m();

    public abstract C0240g n();

    public abstract C0336h o();

    public abstract double p();

    public abstract int q();

    public abstract int r();

    public abstract long s();

    public abstract float t();

    public abstract int u();

    public abstract long v();

    public abstract int w();

    public abstract long x();

    public abstract int y();

    public abstract long z();
}
