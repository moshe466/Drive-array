package bc;

import java.nio.channels.WritableByteChannel;

/* loaded from: classes.dex */
public interface d extends r, WritableByteChannel {
    d A(int i10);

    d F();

    d K(f fVar);

    d S(String str);

    d U(long j10);

    c a();

    d b(byte[] bArr, int i10, int i11);

    @Override // bc.r, java.io.Flushable
    void flush();

    d h(byte[] bArr);

    long n(s sVar);

    d o(long j10);

    d r(int i10);

    d t(int i10);
}
