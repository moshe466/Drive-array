package F0;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: F0.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0107z extends AbstractC0083t {

    /* renamed from: h, reason: collision with root package name */
    public static final ReentrantLock f717h = new ReentrantLock();
    public static volatile C0107z i;

    /* renamed from: b, reason: collision with root package name */
    public final String f718b;

    /* renamed from: c, reason: collision with root package name */
    public final String f719c;

    /* renamed from: d, reason: collision with root package name */
    public final C0062n1 f720d;

    /* renamed from: e, reason: collision with root package name */
    public final String f721e;

    /* renamed from: f, reason: collision with root package name */
    public final r f722f;

    /* renamed from: g, reason: collision with root package name */
    public final C0109z1 f723g;

    public C0107z(String str, String str2, C0062n1 c0062n1, String str3, r rVar, C0109z1 c0109z1) {
        this.f662a = new C0018c1(0);
        this.f718b = str;
        this.f719c = str2;
        this.f720d = c0062n1;
        this.f721e = str3;
        this.f722f = rVar;
        this.f723g = c0109z1;
    }

    @Override // F0.AbstractC0083t
    public final InterfaceC0056m b() {
        return this.f722f;
    }

    @Override // F0.AbstractC0083t
    public final String e() {
        C0109z1 c0109z1 = this.f723g;
        c0109z1.getClass();
        byte[] bArr = new byte[11];
        bArr[0] = -14;
        bArr[1] = -2;
        bArr[2] = 114;
        bArr[3] = 99;
        bArr[4] = -52;
        bArr[5] = 116;
        bArr[((((~C0109z1.class.getName().length()) | 108482089) & 3538960) + (((C0109z1.class.getName().length() | (-8211)) + 8211) | 67117122)) ^ 70656084] = ((((~C0109z1.class.getName().length()) | (-675755051)) & 563118724) + ((C0109z1.class.getName().length() & 1745092610) | (-937162734))) ^ (-374043947);
        bArr[7] = 51;
        bArr[8] = -64;
        bArr[9] = -61;
        bArr[10] = -83;
        int i3 = ((~C0109z1.class.getName().length()) | (-706040713)) & 901867522;
        int length = ((r18 & 1610695685) - 939260907) - (C0109z1.class.getName().length() & 1073742853);
        C0109z1.j(bArr, new byte[]{-105, -122, 6, 6, -66, 26, 34, 95, -97, D.a(i3, 3, -((length & 2) | D1.a(i3, length)), 1) ^ 37393341, -55});
        Charset charset = StandardCharsets.UTF_8;
        if (c0109z1.f(new String(bArr, charset).intern())) {
            byte[] bArr2 = new byte[11];
            bArr2[0] = 92;
            bArr2[1] = -71;
            int i4 = ((~C0109z1.class.getName().length()) | (-1477509622)) & (-2125853632);
            int length2 = C0109z1.class.getName().length();
            int i5 = i4 + (((length2 | 402653264) - (length2 ^ 402653264)) | 402670099);
            bArr2[(i5 - 1723183535) - ((i5 & (-1723183535)) * 2)] = 51;
            bArr2[3] = 90;
            bArr2[4] = 70;
            bArr2[5] = 92;
            bArr2[6] = 1536502825 ^ (((AbstractC0008a.f(C0109z1.class, -1) | 1008504274) & 1493500976) + ((C0109z1.class.getName().length() & 1132527648) | 43001856));
            bArr2[7] = -16;
            bArr2[8] = 76;
            bArr2[9] = -29;
            bArr2[10] = -27;
            C0109z1.j(bArr2, new byte[]{57, -63, 71, 63, 52, 50, 120, -100, 19, -118, -127});
            return c0109z1.c(new String(bArr2, charset).intern());
        }
        return null;
    }

    @Override // F0.AbstractC0083t
    public final String f() {
        return this.f718b;
    }
}
