package X1;

import F0.AbstractC0008a;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.Cipher;

/* loaded from: classes.dex */
public final class c implements K1.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2599a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f2600b;

    public c(byte[] bArr, int i) {
        this.f2599a = i;
        switch (i) {
            case 1:
                this.f2600b = new M1.e(bArr, 0);
                return;
            case 2:
                this.f2600b = new M1.e(bArr, 1);
                return;
            default:
                if (AbstractC0008a.c(2)) {
                    this.f2600b = new M1.b(bArr);
                    return;
                }
                throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
        }
    }

    @Override // K1.a
    public final byte[] a(byte[] bArr, byte[] bArr2) {
        int length;
        int i;
        switch (this.f2599a) {
            case 0:
                byte[] a2 = n.a(12);
                M1.b bVar = (M1.b) this.f2600b;
                boolean z3 = bVar.f1400b;
                if (a2.length == 12) {
                    if (bArr.length <= 2147483619) {
                        if (z3) {
                            length = bArr.length + 28;
                        } else {
                            length = bArr.length + 16;
                        }
                        byte[] bArr3 = new byte[length];
                        if (z3) {
                            System.arraycopy(a2, 0, bArr3, 0, 12);
                        }
                        AlgorithmParameterSpec a4 = M1.b.a(a2);
                        I2.b bVar2 = M1.b.f1398c;
                        ((Cipher) bVar2.get()).init(1, bVar.f1399a, a4);
                        if (bArr2 != null && bArr2.length != 0) {
                            ((Cipher) bVar2.get()).updateAAD(bArr2);
                        }
                        if (z3) {
                            i = 12;
                        } else {
                            i = 0;
                        }
                        int doFinal = ((Cipher) bVar2.get()).doFinal(bArr, 0, bArr.length, bArr3, i);
                        if (doFinal == bArr.length + 16) {
                            return bArr3;
                        }
                        throw new GeneralSecurityException(AbstractC0008a.j(doFinal - bArr.length, "encryption failed; GCM tag must be 16 bytes, but got only ", " bytes"));
                    }
                    throw new GeneralSecurityException("plaintext too long");
                }
                throw new GeneralSecurityException("iv is wrong size");
            case 1:
                ByteBuffer allocate = ByteBuffer.allocate(bArr.length + 28);
                byte[] a5 = n.a(12);
                allocate.put(a5);
                ((M1.e) this.f2600b).f(allocate, a5, bArr, bArr2);
                return allocate.array();
            default:
                ByteBuffer allocate2 = ByteBuffer.allocate(bArr.length + 40);
                byte[] a6 = n.a(24);
                allocate2.put(a6);
                ((M1.e) this.f2600b).f(allocate2, a6, bArr, bArr2);
                return allocate2.array();
        }
    }

    @Override // K1.a
    public final byte[] b(byte[] bArr, byte[] bArr2) {
        int i;
        switch (this.f2599a) {
            case 0:
                byte[] copyOf = Arrays.copyOf(bArr, 12);
                M1.b bVar = (M1.b) this.f2600b;
                boolean z3 = bVar.f1400b;
                if (copyOf.length == 12) {
                    if (z3) {
                        i = 28;
                    } else {
                        i = 16;
                    }
                    if (bArr.length >= i) {
                        int i3 = 0;
                        if (z3 && !ByteBuffer.wrap(copyOf).equals(ByteBuffer.wrap(bArr, 0, 12))) {
                            throw new GeneralSecurityException("iv does not match prepended iv");
                        }
                        AlgorithmParameterSpec a2 = M1.b.a(copyOf);
                        I2.b bVar2 = M1.b.f1398c;
                        ((Cipher) bVar2.get()).init(2, bVar.f1399a, a2);
                        if (bArr2 != null && bArr2.length != 0) {
                            ((Cipher) bVar2.get()).updateAAD(bArr2);
                        }
                        if (z3) {
                            i3 = 12;
                        }
                        int length = bArr.length;
                        if (z3) {
                            length -= 12;
                        }
                        return ((Cipher) bVar2.get()).doFinal(bArr, i3, length);
                    }
                    throw new GeneralSecurityException("ciphertext too short");
                }
                throw new GeneralSecurityException("iv is wrong size");
            case 1:
                if (bArr.length >= 28) {
                    return ((M1.e) this.f2600b).e(ByteBuffer.wrap(bArr, 12, bArr.length - 12), Arrays.copyOf(bArr, 12), bArr2);
                }
                throw new GeneralSecurityException("ciphertext too short");
            default:
                if (bArr.length >= 40) {
                    return ((M1.e) this.f2600b).e(ByteBuffer.wrap(bArr, 24, bArr.length - 24), Arrays.copyOf(bArr, 24), bArr2);
                }
                throw new GeneralSecurityException("ciphertext too short");
        }
    }
}
