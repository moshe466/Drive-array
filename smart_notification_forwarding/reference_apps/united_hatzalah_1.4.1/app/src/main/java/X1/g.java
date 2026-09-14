package X1;

import com.google.android.gms.common.api.Api;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class g implements K1.a {

    /* renamed from: a, reason: collision with root package name */
    public final j f2609a;

    /* renamed from: b, reason: collision with root package name */
    public final K1.j f2610b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2611c;

    public g(j jVar, K1.j jVar2, int i) {
        this.f2609a = jVar;
        this.f2610b = jVar2;
        this.f2611c = i;
    }

    @Override // K1.a
    public final byte[] a(byte[] bArr, byte[] bArr2) {
        a aVar = (a) this.f2609a;
        aVar.getClass();
        int length = bArr.length;
        int i = aVar.f2591b;
        int i3 = Api.BaseClientBuilder.API_PRIORITY_OTHER - i;
        if (length <= i3) {
            byte[] bArr3 = new byte[bArr.length + i];
            byte[] a2 = n.a(i);
            System.arraycopy(a2, 0, bArr3, 0, i);
            aVar.a(bArr, 0, bArr.length, bArr3, aVar.f2591b, a2, true);
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            return T.b.e(bArr3, this.f2610b.b(T.b.e(bArr2, bArr3, Arrays.copyOf(ByteBuffer.allocate(8).putLong(bArr2.length * 8).array(), 8))));
        }
        throw new GeneralSecurityException(e0.a.c(i3, "plaintext length can not exceed "));
    }

    @Override // K1.a
    public final byte[] b(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i = this.f2611c;
        if (length >= i) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length - i);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, bArr.length - i, bArr.length);
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            this.f2610b.a(copyOfRange2, T.b.e(bArr2, copyOfRange, Arrays.copyOf(ByteBuffer.allocate(8).putLong(bArr2.length * 8).array(), 8)));
            a aVar = (a) this.f2609a;
            aVar.getClass();
            int length2 = copyOfRange.length;
            int i3 = aVar.f2591b;
            if (length2 >= i3) {
                byte[] bArr3 = new byte[i3];
                System.arraycopy(copyOfRange, 0, bArr3, 0, i3);
                int length3 = copyOfRange.length;
                int i4 = aVar.f2591b;
                byte[] bArr4 = new byte[length3 - i4];
                aVar.a(copyOfRange, i4, copyOfRange.length - i4, bArr4, 0, bArr3, false);
                return bArr4;
            }
            throw new GeneralSecurityException("ciphertext too short");
        }
        throw new GeneralSecurityException("ciphertext too short");
    }
}
