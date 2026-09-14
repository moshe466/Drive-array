package S0;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final ByteBuffer f2090a;

    public g(ByteBuffer byteBuffer) {
        this.f2090a = byteBuffer.slice();
    }

    public g(byte[] bArr) {
        this.f2090a = ByteBuffer.wrap(bArr);
    }
}
