package androidx.datastore.preferences.protobuf;

import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.util.Arrays;
import org.apache.tika.fork.ForkServer;

/* renamed from: androidx.datastore.preferences.protobuf.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0241h extends M1.d {

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f3178c;

    /* renamed from: d, reason: collision with root package name */
    public int f3179d;

    /* renamed from: e, reason: collision with root package name */
    public int f3180e;

    /* renamed from: f, reason: collision with root package name */
    public int f3181f;

    /* renamed from: g, reason: collision with root package name */
    public final int f3182g;

    /* renamed from: h, reason: collision with root package name */
    public int f3183h;
    public int i = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    public C0241h(byte[] bArr, int i, int i3, boolean z3) {
        this.f3178c = bArr;
        this.f3179d = i3 + i;
        this.f3181f = i;
        this.f3182g = i;
    }

    @Override // M1.d
    public final String A() {
        int J3 = J();
        if (J3 > 0) {
            int i = this.f3179d;
            int i3 = this.f3181f;
            if (J3 <= i - i3) {
                String str = new String(this.f3178c, i3, J3, AbstractC0255w.f3236a);
                this.f3181f += J3;
                return str;
            }
        }
        if (J3 == 0) {
            return "";
        }
        if (J3 < 0) {
            throw InvalidProtocolBufferException.e();
        }
        throw InvalidProtocolBufferException.f();
    }

    @Override // M1.d
    public final String B() {
        int J3 = J();
        if (J3 > 0) {
            int i = this.f3179d;
            int i3 = this.f3181f;
            if (J3 <= i - i3) {
                String k4 = i0.f3191a.k(this.f3178c, i3, J3);
                this.f3181f += J3;
                return k4;
            }
        }
        if (J3 == 0) {
            return "";
        }
        if (J3 <= 0) {
            throw InvalidProtocolBufferException.e();
        }
        throw InvalidProtocolBufferException.f();
    }

    @Override // M1.d
    public final int C() {
        if (g()) {
            this.f3183h = 0;
            return 0;
        }
        int J3 = J();
        this.f3183h = J3;
        if ((J3 >>> 3) != 0) {
            return J3;
        }
        throw new IOException("Protocol message contained an invalid tag (zero).");
    }

    @Override // M1.d
    public final int D() {
        return J();
    }

    @Override // M1.d
    public final long E() {
        return K();
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
                            N(4);
                            return true;
                        }
                        throw InvalidProtocolBufferException.b();
                    }
                    G();
                    b(((i >>> 3) << 3) | 4);
                    return true;
                }
                N(J());
                return true;
            }
            N(8);
            return true;
        }
        int i5 = this.f3179d - this.f3181f;
        byte[] bArr = this.f3178c;
        if (i5 >= 10) {
            while (i4 < 10) {
                int i6 = this.f3181f;
                this.f3181f = i6 + 1;
                if (bArr[i6] < 0) {
                    i4++;
                }
            }
            throw InvalidProtocolBufferException.c();
        }
        while (i4 < 10) {
            int i7 = this.f3181f;
            if (i7 != this.f3179d) {
                this.f3181f = i7 + 1;
                if (bArr[i7] < 0) {
                    i4++;
                }
            } else {
                throw InvalidProtocolBufferException.f();
            }
        }
        throw InvalidProtocolBufferException.c();
        return true;
    }

    public final int H() {
        int i = this.f3181f;
        if (this.f3179d - i >= 4) {
            this.f3181f = i + 4;
            byte[] bArr = this.f3178c;
            return ((bArr[i + 3] & ForkServer.ERROR) << 24) | (bArr[i] & ForkServer.ERROR) | ((bArr[i + 1] & ForkServer.ERROR) << 8) | ((bArr[i + 2] & ForkServer.ERROR) << 16);
        }
        throw InvalidProtocolBufferException.f();
    }

    public final long I() {
        int i = this.f3181f;
        if (this.f3179d - i >= 8) {
            this.f3181f = i + 8;
            byte[] bArr = this.f3178c;
            return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
        }
        throw InvalidProtocolBufferException.f();
    }

    public final int J() {
        int i;
        int i3 = this.f3181f;
        int i4 = this.f3179d;
        if (i4 != i3) {
            int i5 = i3 + 1;
            byte[] bArr = this.f3178c;
            byte b4 = bArr[i3];
            if (b4 >= 0) {
                this.f3181f = i5;
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
                this.f3181f = i6;
                return i;
            }
        }
        return (int) L();
    }

    public final long K() {
        long j2;
        long j3;
        long j4;
        long j5;
        int i = this.f3181f;
        int i3 = this.f3179d;
        if (i3 != i) {
            int i4 = i + 1;
            byte[] bArr = this.f3178c;
            byte b4 = bArr[i];
            if (b4 >= 0) {
                this.f3181f = i4;
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
                this.f3181f = i5;
                return j2;
            }
        }
        return L();
    }

    public final long L() {
        long j2 = 0;
        for (int i = 0; i < 64; i += 7) {
            int i3 = this.f3181f;
            if (i3 != this.f3179d) {
                this.f3181f = i3 + 1;
                j2 |= (r3 & Byte.MAX_VALUE) << i;
                if ((this.f3178c[i3] & 128) == 0) {
                    return j2;
                }
            } else {
                throw InvalidProtocolBufferException.f();
            }
        }
        throw InvalidProtocolBufferException.c();
    }

    public final void M() {
        int i = this.f3179d + this.f3180e;
        this.f3179d = i;
        int i3 = i - this.f3182g;
        int i4 = this.i;
        if (i3 > i4) {
            int i5 = i3 - i4;
            this.f3180e = i5;
            this.f3179d = i - i5;
            return;
        }
        this.f3180e = 0;
    }

    public final void N(int i) {
        if (i >= 0) {
            int i3 = this.f3179d;
            int i4 = this.f3181f;
            if (i <= i3 - i4) {
                this.f3181f = i4 + i;
                return;
            }
        }
        if (i < 0) {
            throw InvalidProtocolBufferException.e();
        }
        throw InvalidProtocolBufferException.f();
    }

    @Override // M1.d
    public final void b(int i) {
        if (this.f3183h == i) {
        } else {
            throw new IOException("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // M1.d
    public final int f() {
        return this.f3181f - this.f3182g;
    }

    @Override // M1.d
    public final boolean g() {
        if (this.f3181f == this.f3179d) {
            return true;
        }
        return false;
    }

    @Override // M1.d
    public final void j(int i) {
        this.i = i;
        M();
    }

    @Override // M1.d
    public final int l(int i) {
        if (i >= 0) {
            int f4 = f() + i;
            if (f4 >= 0) {
                int i3 = this.i;
                if (f4 <= i3) {
                    this.i = f4;
                    M();
                    return i3;
                }
                throw InvalidProtocolBufferException.f();
            }
            throw new IOException("Failed to parse the message.");
        }
        throw InvalidProtocolBufferException.e();
    }

    @Override // M1.d
    public final boolean m() {
        if (K() != 0) {
            return true;
        }
        return false;
    }

    @Override // M1.d
    public final C0240g n() {
        byte[] bArr;
        int J3 = J();
        byte[] bArr2 = this.f3178c;
        if (J3 > 0) {
            int i = this.f3179d;
            int i3 = this.f3181f;
            if (J3 <= i - i3) {
                C0240g i4 = C0240g.i(bArr2, i3, J3);
                this.f3181f += J3;
                return i4;
            }
        }
        if (J3 == 0) {
            return C0240g.f3173c;
        }
        if (J3 > 0) {
            int i5 = this.f3179d;
            int i6 = this.f3181f;
            if (J3 <= i5 - i6) {
                int i7 = J3 + i6;
                this.f3181f = i7;
                bArr = Arrays.copyOfRange(bArr2, i6, i7);
                C0240g c0240g = C0240g.f3173c;
                return new C0240g(bArr);
            }
        }
        if (J3 <= 0) {
            if (J3 == 0) {
                bArr = AbstractC0255w.f3237b;
                C0240g c0240g2 = C0240g.f3173c;
                return new C0240g(bArr);
            }
            throw InvalidProtocolBufferException.e();
        }
        throw InvalidProtocolBufferException.f();
    }

    @Override // M1.d
    public final double p() {
        return Double.longBitsToDouble(I());
    }

    @Override // M1.d
    public final int q() {
        return J();
    }

    @Override // M1.d
    public final int r() {
        return H();
    }

    @Override // M1.d
    public final long s() {
        return I();
    }

    @Override // M1.d
    public final float t() {
        return Float.intBitsToFloat(H());
    }

    @Override // M1.d
    public final int u() {
        return J();
    }

    @Override // M1.d
    public final long v() {
        return K();
    }

    @Override // M1.d
    public final int w() {
        return H();
    }

    @Override // M1.d
    public final long x() {
        return I();
    }

    @Override // M1.d
    public final int y() {
        int J3 = J();
        return (-(J3 & 1)) ^ (J3 >>> 1);
    }

    @Override // M1.d
    public final long z() {
        long K3 = K();
        return (-(K3 & 1)) ^ (K3 >>> 1);
    }
}
