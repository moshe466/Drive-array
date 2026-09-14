package F0;

import a.AbstractC0228a;
import android.content.Context;
import java.nio.charset.StandardCharsets;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;

/* loaded from: classes.dex */
public final class N extends AbstractC0793i implements F2.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f294a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f295b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f296c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ N(Object obj, Context context, InterfaceC0763d interfaceC0763d, int i) {
        super(2, interfaceC0763d);
        this.f294a = i;
        this.f296c = obj;
        this.f295b = context;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        switch (this.f294a) {
            case 0:
                return new N((T2) this.f296c, this.f295b, interfaceC0763d, 0);
            default:
                return new N((Q) this.f296c, this.f295b, interfaceC0763d, 1);
        }
    }

    @Override // F2.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f294a) {
            case 0:
                N n4 = new N((T2) this.f296c, this.f295b, (InterfaceC0763d) obj2, 0);
                C0684i c0684i = C0684i.f6340a;
                n4.invokeSuspend(c0684i);
                return c0684i;
            default:
                N n5 = new N((Q) this.f296c, this.f295b, (InterfaceC0763d) obj2, 1);
                C0684i c0684i2 = C0684i.f6340a;
                n5.invokeSuspend(c0684i2);
                return c0684i2;
        }
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        char c4;
        long j2;
        char c5;
        char c6;
        char c7;
        switch (this.f294a) {
            case 0:
                EnumC0779a enumC0779a = EnumC0779a.f6740a;
                AbstractC0228a.C(obj);
                ((T2) this.f296c).a(this.f295b);
                return C0684i.f6340a;
            default:
                EnumC0779a enumC0779a2 = EnumC0779a.f6740a;
                AbstractC0228a.C(obj);
                ((r3) ((Q) this.f296c).f364e).f628a.U(this.f295b);
                O2 o2 = ((r3) ((Q) this.f296c).f364e).f631d;
                Context context = this.f295b;
                o2.getClass();
                O2 o22 = null;
                C0031f2 c0031f2 = null;
                char c8 = 7592;
                while (true) {
                    int i = 1;
                    if (c8 != 7592) {
                        if (c8 != 2238) {
                            if (c8 != 20429) {
                                if (c8 == 9778) {
                                    o2.f348h = c0031f2;
                                    c8 = 20429;
                                }
                            } else {
                                o22 = o2;
                            }
                            c8 = 2238;
                        } else {
                            C0054l1 c0054l1 = o22.f713g;
                            c0054l1.f573a.getClass();
                            int i3 = AbstractC0041i0.f535a;
                            if (c0031f2.a()) {
                                c4 = 0;
                                o22.f712f.f(W.f402g, true);
                                byte[] bArr = new byte[5];
                                bArr[0] = -79;
                                bArr[1] = -14;
                                bArr[2] = 38;
                                j2 = 43690;
                                long j3 = 613730016;
                                c5 = '0';
                                c6 = 24;
                                c7 = ' ';
                                long j4 = -1;
                                long j5 = ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j4 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j4 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j4 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j4 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                                long j6 = (j5 >>> 48) & 43690;
                                long j7 = ((j6 >>> 2) | (j6 >>> 1)) & 858993459;
                                long j8 = ((j7 >>> 2) | j7) & 252645135;
                                long j9 = (j5 >>> 32) & 43690;
                                long j10 = ((j9 >>> 2) | (j9 >>> 1)) & 858993459;
                                long j11 = ((j10 >>> 2) | j10) & 252645135;
                                long j12 = ((((j11 >>> 4) | j11) & 16711935) << 16) + ((((j8 >>> 4) | j8) & 16711935) << 24);
                                long j13 = (j5 >>> 16) & 43690;
                                long j14 = ((j13 >>> 2) | (j13 >>> 1)) & 858993459;
                                long j15 = ((j14 >>> 2) | j14) & 252645135;
                                long j16 = j5 & 43690;
                                long j17 = ((j16 >>> 2) | (j16 >>> 1)) & 858993459;
                                long j18 = ((j17 >>> 2) | j17) & 252645135;
                                bArr[1016516349 ^ (402786333 - (~((int) ((((j18 >>> 4) | j18) & 16711935) | (((((j15 >>> 4) | j15) & 16711935) << 8) + j12)))))] = 27;
                                bArr[4] = 86;
                                AbstractC0101x1.r(bArr, new byte[]{-16, 109, 95, 87, 37, 33, -114, 11});
                                o22.d(new String(bArr, StandardCharsets.UTF_8).intern(), c0031f2);
                            } else {
                                c4 = 0;
                                j2 = 43690;
                                c5 = '0';
                                c6 = 24;
                                c7 = ' ';
                            }
                            if (c0031f2.b()) {
                                byte[] bArr2 = {-59, -83, -109, 49, -2};
                                AbstractC0101x1.r(bArr2, new byte[]{-60, -110, 18, 66, -115, 111, 57, 7});
                                String intern = new String(bArr2, StandardCharsets.UTF_8).intern();
                                c0054l1.f573a.getClass();
                                o22.m(intern);
                            }
                            if (c0031f2.a()) {
                                c0054l1.f573a.getClass();
                                byte[] bArr3 = new byte[5];
                                bArr3[c4] = 115;
                                long j19 = 101720137;
                                long j20 = 8;
                                long j21 = (((((((((j19 >>> c6) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c5) | (((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c7) + (((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) | ((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16)))) + ((((((((j20 >>> c6) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c5) + ((((((((j20 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c7) + (((((((j20 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) | ((((((((j20 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16));
                                long j22 = (j21 >>> c5) & j2;
                                long j23 = ((j22 >>> 2) | (j22 >>> 1)) & 858993459;
                                long j24 = (j23 | (j23 >>> 2)) & 252645135;
                                long j25 = (j21 >>> c7) & j2;
                                long j26 = ((j25 >>> 2) | (j25 >>> 1)) & 858993459;
                                long j27 = (j26 | (j26 >>> 2)) & 252645135;
                                long j28 = (((j27 | (j27 >>> 4)) & 16711935) << 16) + (((j24 | (j24 >>> 4)) & 16711935) << c6);
                                long j29 = (j21 >>> 16) & j2;
                                long j30 = ((j29 >>> 2) | (j29 >>> 1)) & 858993459;
                                long j31 = (j30 | (j30 >>> 2)) & 252645135;
                                long j32 = j21 & j2;
                                long j33 = ((j32 >>> 2) | (j32 >>> 1)) & 858993459;
                                long j34 = (j33 | (j33 >>> 2)) & 252645135;
                                int i4 = (-637337598) + (((int) (((j34 | (j34 >>> 4)) & 16711935) + (((j31 | (j31 >>> 4)) & 16711935) << 8) + j28)) | 68182353);
                                long j35 = -569155238;
                                long j36 = i4;
                                long j37 = ((((((((j35 >>> c6) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c5) + (((((((j35 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) | ((((((((j35 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((((j35 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c7)) + (((((((((j36 >>> c6) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c5) | (((((((((j36 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << c7) + ((((((((j36 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j36 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                                long j38 = (j37 >>> c5) & 21845;
                                long j39 = (j38 | (j38 >>> 1)) & 858993459;
                                long j40 = (j39 | (j39 >>> 2)) & 252645135;
                                long j41 = (j37 >>> c7) & 21845;
                                long j42 = (j41 | (j41 >>> 1)) & 858993459;
                                long j43 = (j42 | (j42 >>> 2)) & 252645135;
                                long j44 = (((j40 | (j40 >>> 4)) & 16711935) << c6) | (((j43 | (j43 >>> 4)) & 16711935) << 16);
                                long j45 = (j37 >>> 16) & 21845;
                                long j46 = (j45 | (j45 >>> 1)) & 858993459;
                                long j47 = (j46 | (j46 >>> 2)) & 252645135;
                                long j48 = j37 & 21845;
                                long j49 = ((j48 >>> 1) | j48) & 858993459;
                                long j50 = (j49 | (j49 >>> 2)) & 252645135;
                                bArr3[(int) (((j50 | (j50 >>> 4)) & 16711935) + (j44 | (((j47 | (j47 >>> 4)) & 16711935) << 8)))] = 120;
                                bArr3[2] = 18;
                                bArr3[3] = -4;
                                bArr3[4] = 116;
                                AbstractC0101x1.r(bArr3, new byte[]{50, -25, -110, 126, 7, 67, 52, 62});
                                c0054l1.c(new String(bArr3, StandardCharsets.UTF_8).intern(), null);
                            }
                            return C0684i.f6340a;
                        }
                    } else {
                        c0031f2 = T0.b(new N2(o2, context, i));
                        if (!c0031f2.a()) {
                            c8 = 20429;
                        } else {
                            c8 = 9778;
                        }
                    }
                }
        }
    }
}
