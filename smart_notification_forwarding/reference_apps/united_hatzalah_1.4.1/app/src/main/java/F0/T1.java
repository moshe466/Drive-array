package F0;

import android.util.Base64;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugins.sharedpreferences.SharedPreferencesAsyncApi;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

/* loaded from: classes.dex */
public final /* synthetic */ class T1 implements F2.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f383a;

    public /* synthetic */ T1(int i) {
        this.f383a = i;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x002f. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:36:0x0071. Please report as an issue. */
    @Override // F2.a
    public final Object invoke() {
        switch (this.f383a) {
            case 0:
                return UUID.randomUUID().toString();
            case 1:
                char c4 = 33443;
                ArrayList arrayList = null;
                C0082s2 c0082s2 = null;
                Iterator it = null;
                PublicKey publicKey = null;
                while (true) {
                    switch (c4) {
                        case 35092:
                            break;
                        case 1319:
                            c4 = 6008;
                        case 23565:
                            String str = (String) it.next();
                            c0082s2.getClass();
                            char c5 = 0;
                            String[] strArr = new String[0];
                            char c6 = 32686;
                            int i = 0;
                            int i3 = 0;
                            String str2 = null;
                            X509EncodedKeySpec x509EncodedKeySpec = null;
                            while (true) {
                                switch (c6) {
                                    case 19028:
                                        try {
                                            publicKey = KeyFactory.getInstance(str2).generatePublic(x509EncodedKeySpec);
                                            break;
                                        } catch (Exception unused) {
                                            c6 = 62495;
                                            break;
                                        }
                                    case 8182:
                                        if (i >= i3) {
                                            c6 = 37935;
                                            c5 = 0;
                                        }
                                        c6 = 9881;
                                        c5 = 0;
                                    case 37935:
                                        publicKey = null;
                                        break;
                                    case 32686:
                                        i3 = 2;
                                        x509EncodedKeySpec = new X509EncodedKeySpec(Base64.decode(str, 2));
                                        strArr = new String[2];
                                        byte[] bArr = {-43, -78, -112};
                                        C0082s2.a(bArr, new byte[]{-121, -31, -47, 107, 72, -109, 63, -73});
                                        Charset charset = StandardCharsets.UTF_8;
                                        strArr[c5] = new String(bArr, charset).intern();
                                        byte[] bArr2 = new byte[2];
                                        int i4 = ((~C0082s2.class.getName().length()) | (-831707284)) & 38831141;
                                        int length = (C0082s2.class.getName().length() & 1081473) | 786586;
                                        bArr2[(((length | i4) - ((C0082s2.class.getName().length() & (~i4)) & length)) + ((i4 | C0082s2.class.getName().length()) & length)) ^ 39617727] = -108;
                                        bArr2[((((~C0082s2.class.getName().length()) | 1938756249) & 436928649) + ((C0082s2.class.getName().length() & 136315680) | (-2145119454))) ^ (-1708190806)] = -60;
                                        C0082s2.a(bArr2, new byte[]{-47, -121, -17, 57, -62, -27, -99, 11});
                                        strArr[1] = new String(bArr2, charset).intern();
                                        c6 = 8182;
                                        c5 = 0;
                                        i = 0;
                                    case 9881:
                                        str2 = strArr[i];
                                        c6 = 19028;
                                    case 62495:
                                        i++;
                                        c6 = 8182;
                                    default:
                                        c6 = 9881;
                                        c5 = 0;
                                }
                            }
                            if (publicKey != null) {
                                c4 = 64020;
                            } else {
                                c4 = 1319;
                            }
                        case 42198:
                            if (it.hasNext()) {
                                c4 = 23565;
                            } else {
                                c4 = 53869;
                            }
                        case 33443:
                            Set set = C0086t2.f677g;
                            c0082s2 = C0086t2.f672b;
                            arrayList = new ArrayList();
                            it = set.iterator();
                            c4 = 42198;
                        case 64020:
                            arrayList.add(publicKey);
                            c4 = 6008;
                        case 6008:
                            c4 = 42198;
                        case 53869:
                            c4 = 35092;
                        default:
                            c4 = 1319;
                    }
                    return arrayList;
                }
            case 2:
                return new StandardMessageCodec();
            case 3:
                return Integer.valueOf(I2.e.f934b.a(2147418112) + 65536);
            default:
                return SharedPreferencesAsyncApi.Companion.k();
        }
    }
}
