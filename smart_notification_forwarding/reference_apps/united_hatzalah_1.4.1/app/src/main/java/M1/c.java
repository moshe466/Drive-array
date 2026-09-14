package M1;

import java.security.InvalidKeyException;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class c extends d {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1401c;

    public c(byte[] bArr, int i, int i3) {
        this.f1401c = i3;
        if (bArr.length == 32) {
            this.f1403b = a.c(bArr);
            this.f1402a = i;
            return;
        }
        throw new InvalidKeyException("The key length in bytes must be 32.");
    }

    @Override // M1.d
    public final int[] c(int[] iArr, int i) {
        switch (this.f1401c) {
            case 0:
                if (iArr.length == 3) {
                    int[] iArr2 = new int[16];
                    int[] iArr3 = (int[]) this.f1403b;
                    int[] iArr4 = a.f1397a;
                    System.arraycopy(iArr4, 0, iArr2, 0, iArr4.length);
                    System.arraycopy(iArr3, 0, iArr2, iArr4.length, 8);
                    iArr2[12] = i;
                    System.arraycopy(iArr, 0, iArr2, 13, iArr.length);
                    return iArr2;
                }
                throw new IllegalArgumentException(String.format("ChaCha20 uses 96-bit nonces, but got a %d-bit nonce", Integer.valueOf(iArr.length * 32)));
            default:
                if (iArr.length == 6) {
                    int[] iArr5 = new int[16];
                    int[] iArr6 = (int[]) this.f1403b;
                    int[] iArr7 = a.f1397a;
                    System.arraycopy(iArr7, 0, r0, 0, iArr7.length);
                    System.arraycopy(iArr6, 0, r0, iArr7.length, 8);
                    int[] iArr8 = {0, 0, 0, 0, iArr8[12], iArr8[13], iArr8[14], iArr8[15], 0, 0, 0, 0, iArr[0], iArr[1], iArr[2], iArr[3]};
                    a.b(iArr8);
                    int[] copyOf = Arrays.copyOf(iArr8, 8);
                    System.arraycopy(iArr7, 0, iArr5, 0, iArr7.length);
                    System.arraycopy(copyOf, 0, iArr5, iArr7.length, 8);
                    iArr5[12] = i;
                    iArr5[13] = 0;
                    iArr5[14] = iArr[4];
                    iArr5[15] = iArr[5];
                    return iArr5;
                }
                throw new IllegalArgumentException(String.format("XChaCha20 uses 192-bit nonces, but got a %d-bit nonce", Integer.valueOf(iArr.length * 32)));
        }
    }

    @Override // M1.d
    public final int i() {
        switch (this.f1401c) {
            case 0:
                return 12;
            default:
                return 24;
        }
    }
}
