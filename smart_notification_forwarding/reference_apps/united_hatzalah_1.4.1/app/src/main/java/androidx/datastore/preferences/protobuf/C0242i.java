package androidx.datastore.preferences.protobuf;

import F0.AbstractC0008a;
import com.google.android.gms.common.api.Api;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import org.apache.tika.fork.ForkServer;

/* renamed from: androidx.datastore.preferences.protobuf.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0242i extends M1.d {

    /* renamed from: c, reason: collision with root package name */
    public final FileInputStream f3184c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f3185d;

    /* renamed from: e, reason: collision with root package name */
    public int f3186e;

    /* renamed from: f, reason: collision with root package name */
    public int f3187f;

    /* renamed from: g, reason: collision with root package name */
    public int f3188g;

    /* renamed from: h, reason: collision with root package name */
    public int f3189h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public int f3190j = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    public C0242i(FileInputStream fileInputStream) {
        Charset charset = AbstractC0255w.f3236a;
        this.f3184c = fileInputStream;
        this.f3185d = new byte[4096];
        this.f3186e = 0;
        this.f3188g = 0;
        this.i = 0;
    }

    @Override // M1.d
    public final String A() {
        int M3 = M();
        byte[] bArr = this.f3185d;
        if (M3 > 0) {
            int i = this.f3186e;
            int i3 = this.f3188g;
            if (M3 <= i - i3) {
                String str = new String(bArr, i3, M3, AbstractC0255w.f3236a);
                this.f3188g += M3;
                return str;
            }
        }
        if (M3 == 0) {
            return "";
        }
        if (M3 >= 0) {
            if (M3 <= this.f3186e) {
                Q(M3);
                String str2 = new String(bArr, this.f3188g, M3, AbstractC0255w.f3236a);
                this.f3188g += M3;
                return str2;
            }
            return new String(H(M3), AbstractC0255w.f3236a);
        }
        throw InvalidProtocolBufferException.e();
    }

    @Override // M1.d
    public final String B() {
        int M3 = M();
        int i = this.f3188g;
        int i3 = this.f3186e;
        int i4 = i3 - i;
        byte[] bArr = this.f3185d;
        if (M3 <= i4 && M3 > 0) {
            this.f3188g = i + M3;
        } else {
            if (M3 == 0) {
                return "";
            }
            if (M3 >= 0) {
                i = 0;
                if (M3 <= i3) {
                    Q(M3);
                    this.f3188g = M3;
                } else {
                    bArr = H(M3);
                }
            } else {
                throw InvalidProtocolBufferException.e();
            }
        }
        return i0.f3191a.k(bArr, i, M3);
    }

    @Override // M1.d
    public final int C() {
        if (g()) {
            this.f3189h = 0;
            return 0;
        }
        int M3 = M();
        this.f3189h = M3;
        if ((M3 >>> 3) != 0) {
            return M3;
        }
        throw new IOException("Protocol message contained an invalid tag (zero).");
    }

    @Override // M1.d
    public final int D() {
        return M();
    }

    @Override // M1.d
    public final long E() {
        return N();
    }

    @Override // M1.d
    public final boolean F(int i) {
        int i3 = i & 7;
        int i4 = 0;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            return false;
                        }
                        if (i3 == 5) {
                            R(4);
                            return true;
                        }
                        throw InvalidProtocolBufferException.b();
                    }
                    G();
                    b(((i >>> 3) << 3) | 4);
                    return true;
                }
                R(M());
                return true;
            }
            R(8);
            return true;
        }
        int i5 = this.f3186e - this.f3188g;
        byte[] bArr = this.f3185d;
        if (i5 >= 10) {
            while (i4 < 10) {
                int i6 = this.f3188g;
                this.f3188g = i6 + 1;
                if (bArr[i6] < 0) {
                    i4++;
                }
            }
            throw InvalidProtocolBufferException.c();
        }
        while (i4 < 10) {
            if (this.f3188g == this.f3186e) {
                Q(1);
            }
            int i7 = this.f3188g;
            this.f3188g = i7 + 1;
            if (bArr[i7] < 0) {
                i4++;
            }
        }
        throw InvalidProtocolBufferException.c();
        return true;
    }

    public final byte[] H(int i) {
        byte[] I3 = I(i);
        if (I3 != null) {
            return I3;
        }
        int i3 = this.f3188g;
        int i4 = this.f3186e;
        int i5 = i4 - i3;
        this.i += i4;
        this.f3188g = 0;
        this.f3186e = 0;
        ArrayList J3 = J(i - i5);
        byte[] bArr = new byte[i];
        System.arraycopy(this.f3185d, i3, bArr, 0, i5);
        int size = J3.size();
        int i6 = 0;
        while (i6 < size) {
            Object obj = J3.get(i6);
            i6++;
            byte[] bArr2 = (byte[]) obj;
            System.arraycopy(bArr2, 0, bArr, i5, bArr2.length);
            i5 += bArr2.length;
        }
        return bArr;
    }

    public final byte[] I(int i) {
        if (i == 0) {
            return AbstractC0255w.f3237b;
        }
        if (i >= 0) {
            int i3 = this.i;
            int i4 = this.f3188g;
            int i5 = i3 + i4 + i;
            if (i5 - Api.BaseClientBuilder.API_PRIORITY_OTHER <= 0) {
                int i6 = this.f3190j;
                if (i5 <= i6) {
                    int i7 = this.f3186e - i4;
                    int i8 = i - i7;
                    FileInputStream fileInputStream = this.f3184c;
                    if (i8 >= 4096) {
                        try {
                            if (i8 > fileInputStream.available()) {
                                return null;
                            }
                        } catch (InvalidProtocolBufferException e4) {
                            e4.f3100a = true;
                            throw e4;
                        }
                    }
                    byte[] bArr = new byte[i];
                    System.arraycopy(this.f3185d, this.f3188g, bArr, 0, i7);
                    this.i += this.f3186e;
                    this.f3188g = 0;
                    this.f3186e = 0;
                    while (i7 < i) {
                        try {
                            int read = fileInputStream.read(bArr, i7, i - i7);
                            if (read != -1) {
                                this.i += read;
                                i7 += read;
                            } else {
                                throw InvalidProtocolBufferException.f();
                            }
                        } catch (InvalidProtocolBufferException e5) {
                            e5.f3100a = true;
                            throw e5;
                        }
                    }
                    return bArr;
                }
                R((i6 - i3) - i4);
                throw InvalidProtocolBufferException.f();
            }
            throw new IOException("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
        }
        throw InvalidProtocolBufferException.e();
    }

    public final ArrayList J(int i) {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            int min = Math.min(i, 4096);
            byte[] bArr = new byte[min];
            int i3 = 0;
            while (i3 < min) {
                int read = this.f3184c.read(bArr, i3, min - i3);
                if (read != -1) {
                    this.i += read;
                    i3 += read;
                } else {
                    throw InvalidProtocolBufferException.f();
                }
            }
            i -= min;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    public final int K() {
        int i = this.f3188g;
        if (this.f3186e - i < 4) {
            Q(4);
            i = this.f3188g;
        }
        this.f3188g = i + 4;
        byte[] bArr = this.f3185d;
        return ((bArr[i + 3] & ForkServer.ERROR) << 24) | (bArr[i] & ForkServer.ERROR) | ((bArr[i + 1] & ForkServer.ERROR) << 8) | ((bArr[i + 2] & ForkServer.ERROR) << 16);
    }

    public final long L() {
        int i = this.f3188g;
        if (this.f3186e - i < 8) {
            Q(8);
            i = this.f3188g;
        }
        this.f3188g = i + 8;
        byte[] bArr = this.f3185d;
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    public final int M() {
        int i;
        int i3 = this.f3188g;
        int i4 = this.f3186e;
        if (i4 != i3) {
            int i5 = i3 + 1;
            byte[] bArr = this.f3185d;
            byte b4 = bArr[i3];
            if (b4 >= 0) {
                this.f3188g = i5;
                return b4;
            }
            if (i4 - i5 >= 9) {
                int i6 = i3 + 2;
                int i7 = (bArr[i5] << 7) ^ b4;
                if (i7 < 0) {
                    i = i7 ^ (-128);
                } else {
                    int i8 = i3 + 3;
                    int i9 = (bArr[i6] << 14) ^ i7;
                    if (i9 >= 0) {
                        i = i9 ^ 16256;
                    } else {
                        int i10 = i3 + 4;
                        int i11 = i9 ^ (bArr[i8] << 21);
                        if (i11 < 0) {
                            i = (-2080896) ^ i11;
                        } else {
                            i8 = i3 + 5;
                            byte b5 = bArr[i10];
                            int i12 = (i11 ^ (b5 << 28)) ^ 266354560;
                            if (b5 < 0) {
                                i10 = i3 + 6;
                                if (bArr[i8] < 0) {
                                    i8 = i3 + 7;
                                    if (bArr[i10] < 0) {
                                        i10 = i3 + 8;
                                        if (bArr[i8] < 0) {
                                            i8 = i3 + 9;
                                            if (bArr[i10] < 0) {
                                                int i13 = i3 + 10;
                                                if (bArr[i8] >= 0) {
                                                    i6 = i13;
                                                    i = i12;
                                                }
                                            }
                                        }
                                    }
                                }
                                i = i12;
                            }
                            i = i12;
                        }
                        i6 = i10;
                    }
                    i6 = i8;
                }
                this.f3188g = i6;
                return i;
            }
        }
        return (int) O();
    }

    public final long N() {
        long j2;
        long j3;
        long j4;
        long j5;
        int i = this.f3188g;
        int i3 = this.f3186e;
        if (i3 != i) {
            int i4 = i + 1;
            byte[] bArr = this.f3185d;
            byte b4 = bArr[i];
            if (b4 >= 0) {
                this.f3188g = i4;
                return b4;
            }
            if (i3 - i4 >= 9) {
                int i5 = i + 2;
                int i6 = (bArr[i4] << 7) ^ b4;
                if (i6 < 0) {
                    j2 = i6 ^ (-128);
                } else {
                    int i7 = i + 3;
                    int i8 = (bArr[i5] << 14) ^ i6;
                    if (i8 >= 0) {
                        j2 = i8 ^ 16256;
                        i5 = i7;
                    } else {
                        int i9 = i + 4;
                        int i10 = i8 ^ (bArr[i7] << 21);
                        if (i10 < 0) {
                            j5 = (-2080896) ^ i10;
                        } else {
                            long j6 = i10;
                            i5 = i + 5;
                            long j7 = j6 ^ (bArr[i9] << 28);
                            if (j7 >= 0) {
                                j4 = 266354560;
                            } else {
                                i9 = i + 6;
                                long j8 = j7 ^ (bArr[i5] << 35);
                                if (j8 < 0) {
                                    j3 = -34093383808L;
                                } else {
                                    i5 = i + 7;
                                    j7 = j8 ^ (bArr[i9] << 42);
                                    if (j7 >= 0) {
                                        j4 = 4363953127296L;
                                    } else {
                                        i9 = i + 8;
                                        j8 = j7 ^ (bArr[i5] << 49);
                                        if (j8 < 0) {
                                            j3 = -558586000294016L;
                                        } else {
                                            i5 = i + 9;
                                            long j9 = (j8 ^ (bArr[i9] << 56)) ^ 71499008037633920L;
                                            if (j9 < 0) {
                                                int i11 = i + 10;
                                                if (bArr[i5] >= 0) {
                                                    i5 = i11;
                                                }
                                            }
                                            j2 = j9;
                                        }
                                    }
                                }
                                j5 = j3 ^ j8;
                            }
                            j2 = j4 ^ j7;
                        }
                        i5 = i9;
                        j2 = j5;
                    }
                }
                this.f3188g = i5;
                return j2;
            }
        }
        return O();
    }

    public final long O() {
        long j2 = 0;
        for (int i = 0; i < 64; i += 7) {
            if (this.f3188g == this.f3186e) {
                Q(1);
            }
            int i3 = this.f3188g;
            this.f3188g = i3 + 1;
            j2 |= (r3 & Byte.MAX_VALUE) << i;
            if ((this.f3185d[i3] & 128) == 0) {
                return j2;
            }
        }
        throw InvalidProtocolBufferException.c();
    }

    public final void P() {
        int i = this.f3186e + this.f3187f;
        this.f3186e = i;
        int i3 = this.i + i;
        int i4 = this.f3190j;
        if (i3 > i4) {
            int i5 = i3 - i4;
            this.f3187f = i5;
            this.f3186e = i - i5;
            return;
        }
        this.f3187f = 0;
    }

    public final void Q(int i) {
        if (!S(i)) {
            if (i > (Api.BaseClientBuilder.API_PRIORITY_OTHER - this.i) - this.f3188g) {
                throw new IOException("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
            }
            throw InvalidProtocolBufferException.f();
        }
    }

    public final void R(int i) {
        int i3 = this.f3186e;
        int i4 = this.f3188g;
        int i5 = i3 - i4;
        if (i <= i5 && i >= 0) {
            this.f3188g = i4 + i;
            return;
        }
        FileInputStream fileInputStream = this.f3184c;
        if (i >= 0) {
            int i6 = this.i;
            int i7 = i6 + i4;
            int i8 = i7 + i;
            int i9 = this.f3190j;
            if (i8 <= i9) {
                this.i = i7;
                this.f3186e = 0;
                this.f3188g = 0;
                while (i5 < i) {
                    long j2 = i - i5;
                    try {
                        try {
                            long skip = fileInputStream.skip(j2);
                            if (skip >= 0 && skip <= j2) {
                                if (skip == 0) {
                                    break;
                                } else {
                                    i5 += (int) skip;
                                }
                            } else {
                                throw new IllegalStateException(fileInputStream.getClass() + "#skip returned invalid result: " + skip + "\nThe InputStream implementation is buggy.");
                            }
                        } catch (InvalidProtocolBufferException e4) {
                            e4.f3100a = true;
                            throw e4;
                        }
                    } catch (Throwable th) {
                        this.i += i5;
                        P();
                        throw th;
                    }
                }
                this.i += i5;
                P();
                if (i5 < i) {
                    int i10 = this.f3186e;
                    int i11 = i10 - this.f3188g;
                    this.f3188g = i10;
                    Q(1);
                    while (true) {
                        int i12 = i - i11;
                        int i13 = this.f3186e;
                        if (i12 > i13) {
                            i11 += i13;
                            this.f3188g = i13;
                            Q(1);
                        } else {
                            this.f3188g = i12;
                            return;
                        }
                    }
                }
            } else {
                R((i9 - i6) - i4);
                throw InvalidProtocolBufferException.f();
            }
        } else {
            throw InvalidProtocolBufferException.e();
        }
    }

    public final boolean S(int i) {
        FileInputStream fileInputStream = this.f3184c;
        int i3 = this.f3188g;
        int i4 = i3 + i;
        int i5 = this.f3186e;
        if (i4 > i5) {
            int i6 = this.i;
            if (i <= (Api.BaseClientBuilder.API_PRIORITY_OTHER - i6) - i3 && i6 + i3 + i <= this.f3190j) {
                byte[] bArr = this.f3185d;
                if (i3 > 0) {
                    if (i5 > i3) {
                        System.arraycopy(bArr, i3, bArr, 0, i5 - i3);
                    }
                    this.i += i3;
                    this.f3186e -= i3;
                    this.f3188g = 0;
                }
                int i7 = this.f3186e;
                try {
                    int read = fileInputStream.read(bArr, i7, Math.min(bArr.length - i7, (Api.BaseClientBuilder.API_PRIORITY_OTHER - this.i) - i7));
                    if (read != 0 && read >= -1 && read <= bArr.length) {
                        if (read > 0) {
                            this.f3186e += read;
                            P();
                            if (this.f3186e >= i) {
                                return true;
                            }
                            return S(i);
                        }
                    } else {
                        throw new IllegalStateException(fileInputStream.getClass() + "#read(byte[]) returned invalid result: " + read + "\nThe InputStream implementation is buggy.");
                    }
                } catch (InvalidProtocolBufferException e4) {
                    e4.f3100a = true;
                    throw e4;
                }
            }
            return false;
        }
        throw new IllegalStateException(AbstractC0008a.j(i, "refillBuffer() called when ", " bytes were already available in buffer"));
    }

    @Override // M1.d
    public final void b(int i) {
        if (this.f3189h == i) {
        } else {
            throw new IOException("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // M1.d
    public final int f() {
        return this.i + this.f3188g;
    }

    @Override // M1.d
    public final boolean g() {
        if (this.f3188g == this.f3186e && !S(1)) {
            return true;
        }
        return false;
    }

    @Override // M1.d
    public final void j(int i) {
        this.f3190j = i;
        P();
    }

    @Override // M1.d
    public final int l(int i) {
        if (i >= 0) {
            int i3 = this.i + this.f3188g + i;
            if (i3 >= 0) {
                int i4 = this.f3190j;
                if (i3 <= i4) {
                    this.f3190j = i3;
                    P();
                    return i4;
                }
                throw InvalidProtocolBufferException.f();
            }
            throw new IOException("Failed to parse the message.");
        }
        throw InvalidProtocolBufferException.e();
    }

    @Override // M1.d
    public final boolean m() {
        if (N() != 0) {
            return true;
        }
        return false;
    }

    @Override // M1.d
    public final C0240g n() {
        int M3 = M();
        int i = this.f3186e;
        int i3 = this.f3188g;
        int i4 = i - i3;
        byte[] bArr = this.f3185d;
        if (M3 <= i4 && M3 > 0) {
            C0240g i5 = C0240g.i(bArr, i3, M3);
            this.f3188g += M3;
            return i5;
        }
        if (M3 == 0) {
            return C0240g.f3173c;
        }
        if (M3 >= 0) {
            byte[] I3 = I(M3);
            if (I3 != null) {
                return C0240g.i(I3, 0, I3.length);
            }
            int i6 = this.f3188g;
            int i7 = this.f3186e;
            int i8 = i7 - i6;
            this.i += i7;
            this.f3188g = 0;
            this.f3186e = 0;
            ArrayList J3 = J(M3 - i8);
            byte[] bArr2 = new byte[M3];
            System.arraycopy(bArr, i6, bArr2, 0, i8);
            int size = J3.size();
            int i9 = 0;
            while (i9 < size) {
                Object obj = J3.get(i9);
                i9++;
                byte[] bArr3 = (byte[]) obj;
                System.arraycopy(bArr3, 0, bArr2, i8, bArr3.length);
                i8 += bArr3.length;
            }
            C0240g c0240g = C0240g.f3173c;
            return new C0240g(bArr2);
        }
        throw InvalidProtocolBufferException.e();
    }

    @Override // M1.d
    public final double p() {
        return Double.longBitsToDouble(L());
    }

    @Override // M1.d
    public final int q() {
        return M();
    }

    @Override // M1.d
    public final int r() {
        return K();
    }

    @Override // M1.d
    public final long s() {
        return L();
    }

    @Override // M1.d
    public final float t() {
        return Float.intBitsToFloat(K());
    }

    @Override // M1.d
    public final int u() {
        return M();
    }

    @Override // M1.d
    public final long v() {
        return N();
    }

    @Override // M1.d
    public final int w() {
        return K();
    }

    @Override // M1.d
    public final long x() {
        return L();
    }

    @Override // M1.d
    public final int y() {
        int M3 = M();
        return (-(M3 & 1)) ^ (M3 >>> 1);
    }

    @Override // M1.d
    public final long z() {
        long N3 = N();
        return (-(N3 & 1)) ^ (N3 >>> 1);
    }
}
