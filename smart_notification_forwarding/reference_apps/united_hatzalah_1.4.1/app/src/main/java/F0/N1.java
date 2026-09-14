package F0;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.tika.fork.ForkServer;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class N1 extends AbstractC0076r0 {

    /* renamed from: a, reason: collision with root package name */
    public final String f299a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f300b;

    public N1(String str, ArrayList arrayList) {
        byte[] bArr = {-10, 103, 34, -70, -83, 6, 88, -98, 2};
        f(bArr, new byte[]{-15, 49, -11, Byte.MAX_VALUE, -94, 58, -117, 81, 103});
        Charset charset = StandardCharsets.UTF_8;
        kotlin.jvm.internal.j.e(str, new String(bArr, charset).intern());
        byte[] bArr2 = new byte[12];
        bArr2[0] = 5;
        bArr2[1] = 86;
        bArr2[2] = -36;
        bArr2[3] = 39;
        bArr2[670566211 ^ ((((~N1.class.getName().length()) | 979006601) & 116917058) + ((N1.class.getName().length() & 77595458) | 553649157))] = -97;
        bArr2[5] = 124;
        bArr2[6] = -44;
        bArr2[7] = -123;
        bArr2[8] = -10;
        bArr2[9] = 44;
        bArr2[10] = 22;
        bArr2[11] = 39;
        f(bArr2, new byte[]{2, 5, 56, -15, -110, 40, 15, 64, -13, 78, -63, -14});
        new String(bArr2, charset).intern();
        this.f299a = str;
        this.f300b = arrayList;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x003f. Please report as an issue. */
    public static void f(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = null;
        int i = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = -894652659;
        byte[] bArr4 = null;
        while (true) {
            int i6 = ((i5 & 16777216) * (i5 | 16777216)) + ((i5 & (-16777217)) * ((~i5) & 16777216));
            int i7 = i5 >>> 8;
            int i8 = (i7 + i6) - (i7 & i6);
            int i9 = (i8 ^ 1458005263) + ((i8 & 1458005263) * 2);
            int i10 = 145880015;
            int i11 = 1298988808;
            boolean z3 = true;
            switch ((i9 - 1434379843) + (((~i9) & 1434379843) * 2)) {
                case -1970406716:
                    int length = bArr4.length;
                    int i12 = 0 - i;
                    int i13 = ~i12;
                    int i14 = ((length | i12) - ((602749225 & i13) & length)) + ((i12 | 602749225) & length);
                    byte b4 = bArr3[i14];
                    int length2 = bArr4.length;
                    byte b5 = bArr3[(length2 ^ i13) + ((i12 | length2) * 2) + 1];
                    int i15 = ((byte) 0) - b4;
                    bArr3[i14] = (byte) (((byte) (((byte) 2) * ((byte) (b5 & (~i15))))) - ((byte) (b5 ^ i15)));
                    i5 = -34715366;
                case -1882653318:
                    int i16 = (i3 - 1) - (i3 | (-4));
                    byte b6 = bArr3[i16];
                    int i17 = ((b6 & ForkServer.DONE) * (b6 | ForkServer.DONE)) + ((b6 & ForkServer.ERROR) * ((~b6) & 16777216));
                    int i18 = i3 + 3 + (((-1) - i3) | (-3));
                    int i19 = bArr3[i18] & ForkServer.ERROR;
                    int i20 = i19 * ((~i19) & 65536);
                    int i21 = ~((i17 | ((~i20) | 1169991170)) - ((i20 & 1169991170) | i17));
                    int a2 = j3.a(689061172 & i3, i3, 1, 689061173 & i3);
                    int i22 = bArr3[a2] & ForkServer.ERROR;
                    int i23 = ((~i21) & (i22 * ((~i22) & UserVerificationMethods.USER_VERIFY_HANDPRINT))) + i21;
                    int i24 = (i23 - 1) - ((~(bArr3[i3] & ForkServer.ERROR)) | i23);
                    byte b7 = bArr4[i16];
                    int i25 = ((b7 & ForkServer.DONE) * (b7 | ForkServer.DONE)) + ((b7 & ForkServer.ERROR) * ((~b7) & 16777216));
                    int i26 = bArr4[i18] & ForkServer.ERROR;
                    int i27 = i26 * ((~i26) & 65536);
                    int i28 = ~((i25 | ((~i27) | (-445685625))) - ((i27 & (-445685625)) | i25));
                    int i29 = bArr4[a2] & ForkServer.ERROR;
                    int i30 = i29 * ((~i29) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i31 = (i30 + i28) - (i30 & i28);
                    int i32 = bArr4[i3] & ForkServer.ERROR;
                    int i33 = (i31 & (~i32)) + i32;
                    int i34 = i24 << ((i24 > Double.NaN ? 1 : (i24 == Double.NaN ? 0 : -1)) >>> 31);
                    int i35 = (i34 + i33) - ((i34 & i33) * 2);
                    int i36 = 659933421 - ((i35 & 2) | ((-1983400303) - i35));
                    bArr4[i3] = (byte) i36;
                    bArr4[a2] = (byte) (i36 >>> 8);
                    bArr4[i18] = (byte) (i36 >>> 16);
                    bArr4[i16] = (byte) (i36 >>> 24);
                    i3 = (i3 ^ 4) + ((i3 & 4) * 2);
                    int length3 = bArr4.length;
                    int length4 = 0 - (bArr4.length % 4);
                    int i37 = ((i3 > ((length3 ^ length4) + ((length3 & length4) * 2)) ? 1 : (i3 == ((length3 ^ length4) + ((length3 & length4) * 2)) ? 0 : -1)) >>> 31) & 1;
                    if (i37 != 0) {
                        i10 = 196573321;
                    }
                    if (i37 != 0) {
                        i5 = -826922365;
                    } else {
                        i5 = i10;
                    }
                case -625567707:
                    break;
                case 172635213:
                    int length5 = bArr4.length;
                    int i38 = 0 - i4;
                    if ((bArr3[(length5 ^ i38) + ((length5 & i38) * 2)] > Double.NaN ? 1 : (bArr3[(length5 ^ i38) + ((length5 & i38) * 2)] == Double.NaN ? 0 : -1)) <= -1) {
                        i5 = 196573321;
                    } else {
                        i5 = -34715366;
                    }
                    i = i4;
                case 614184219:
                    int length6 = bArr4.length;
                    int i39 = 0 - i;
                    int i40 = i39 * 3;
                    int a4 = D1.a(i39, length6);
                    int length7 = bArr4.length;
                    byte b8 = bArr4[(length7 ^ i39) + ((length7 & i39) * 2)];
                    int length8 = bArr4.length;
                    int i41 = 0 - i39;
                    byte b9 = bArr3[(((~i41) & length8) * 2) - (length8 ^ i41)];
                    bArr4[AbstractC0014b1.a((length6 & 2) | a4, i40)] = (byte) (((byte) (b9 + b8)) - ((byte) (((byte) 2) * ((byte) (b9 & b8)))));
                    i4 = ((-338014207) | i) + (338014206 | i);
                    int i42 = ((i > 2 ? 1 : (i == 2 ? 0 : -1)) >>> 31) & 1;
                    if (i42 != 0) {
                        i11 = 196573321;
                    }
                    if (i42 == 0) {
                        i5 = i11;
                    } else {
                        i5 = -518432968;
                    }
                case 835516413:
                    int length9 = bArr.length;
                    int length10 = 0 - (0 - (bArr.length % 4));
                    if ((length9 ^ length10) - (((~length9) & length10) * 2) <= 0) {
                        z3 = false;
                    }
                    if (z3) {
                        i10 = 196573321;
                    }
                    if (z3) {
                        i5 = -826922365;
                    } else {
                        i5 = i10;
                    }
                    bArr3 = bArr2;
                    bArr4 = bArr;
                    i3 = 0;
                case 1888416065:
                    i4 = bArr4.length % 4;
                    int i43 = ((i4 > 1 ? 1 : (i4 == 1 ? 0 : -1)) >>> 31) & 1;
                    if (i43 != 0) {
                        i11 = 196573321;
                    }
                    if (i43 == 0) {
                        i5 = i11;
                    } else {
                        i5 = -518432968;
                    }
                default:
                    i5 = 196573321;
            }
            return;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x00c3. Please report as an issue. */
    @Override // F0.J
    public final void a(JSONObject jSONObject) {
        int i;
        int i3;
        int i4;
        N1 n12 = this;
        JSONObject jSONObject2 = jSONObject;
        char c4 = 5955;
        char c5 = 5955;
        Iterator it = null;
        JSONArray jSONArray = null;
        JSONArray jSONArray2 = null;
        while (true) {
            if (c5 != c4) {
                if (c5 != 20431) {
                    if (c5 != 5050) {
                        if (c5 == 35737) {
                            jSONArray2.put(AbstractC0076r0.c((X509Certificate) it.next()));
                            c5 = 20431;
                        } else {
                            c5 = 5050;
                        }
                    } else {
                        jSONObject2.put(n12.f299a, jSONArray);
                        return;
                    }
                } else if (it.hasNext()) {
                    c5 = 35737;
                } else {
                    c5 = 5050;
                }
            } else {
                int i5 = 0;
                int i6 = 1;
                int i7 = 2;
                int i8 = 3;
                byte[] bArr = {-11, 51, 54, -62};
                byte[] bArr2 = {-74, 16, 111, -109, 89, 11, 123, -123};
                int i9 = 1516727821;
                int i10 = 0;
                int i11 = 0;
                int i12 = 0;
                byte[] bArr3 = null;
                byte[] bArr4 = null;
                while (true) {
                    int i13 = ((i9 & 16777216) * (i9 | 16777216)) + ((i9 & (-16777217)) * ((~i9) & 16777216));
                    int i14 = i9 >>> 8;
                    int i15 = i5;
                    int a2 = j3.a((~i13) & 650911840 & i14, i14, i13, (i13 | 650911840) & i14);
                    int i16 = (a2 ^ 642535957) + ((a2 & 642535957) * i7);
                    switch (((~i16) + ((i16 | 1) * i7)) ^ 962785775) {
                        case -1896910703:
                            int i17 = i6;
                            int length = bArr3.length;
                            int i18 = 0 - i10;
                            int i19 = (length ^ i18) + ((length & i18) * 2);
                            byte b4 = bArr4[i19];
                            int length2 = bArr3.length;
                            int i20 = 0 - i18;
                            int i21 = i20 | length2;
                            byte b5 = bArr4[D.a(i20, 2, i21, (length2 ^ i20) ^ i21)];
                            bArr4[i19] = (byte) (((byte) (((byte) 2) * ((byte) (b5 | b4)))) - ((byte) (b5 ^ b4)));
                            n12 = this;
                            jSONObject2 = jSONObject;
                            i7 = 2;
                            i6 = i17;
                            i5 = i15;
                            i8 = 3;
                            i9 = -746753280;
                        case -1725904394:
                            int length3 = bArr3.length % 4;
                            i = 1;
                            if ((((length3 > 1 ? 1 : (length3 == 1 ? 0 : -1)) >>> 31) & 1) != 0) {
                                i12 = length3;
                                jSONObject2 = jSONObject;
                                i6 = i;
                                i5 = i15;
                                i7 = 2;
                                i8 = 3;
                                i9 = -458924450;
                                n12 = this;
                            } else {
                                jSONObject2 = jSONObject;
                                i12 = length3;
                                i6 = 1;
                                i5 = i15;
                                i7 = 2;
                                i8 = 3;
                                i9 = -365117735;
                                n12 = this;
                            }
                        case -1399959314:
                            int i22 = i6;
                            int a4 = j3.a((-1205100636) & i11, i11, i8, (-1205100633) & i11);
                            byte b6 = bArr4[a4];
                            int i23 = ((b6 & ForkServer.DONE) * (b6 | ForkServer.DONE)) + ((b6 & ForkServer.ERROR) * ((~b6) & 16777216));
                            int i24 = i11 - 1;
                            int i25 = i24 - (i11 | (-3));
                            int i26 = bArr4[i25] & ForkServer.ERROR;
                            int i27 = i26 * ((~i26) & 65536);
                            int a5 = S.a(i27, i23, i22, ((-1) - i27) | ((-1) - i23));
                            int i28 = i24 - (i11 | (-2));
                            int i29 = bArr4[i28] & ForkServer.ERROR;
                            int i30 = i29 * ((~i29) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                            int i31 = (i30 - 1) - ((~a5) | i30);
                            int i32 = bArr4[i11] & ForkServer.ERROR;
                            int a6 = S.a(i31, i32, 1, ((-1) - i31) | ((-1) - i32));
                            byte b7 = bArr3[a4];
                            int i33 = ((b7 & ForkServer.DONE) * (b7 | ForkServer.DONE)) + ((b7 & ForkServer.ERROR) * ((~b7) & 16777216));
                            int i34 = bArr3[i25] & ForkServer.ERROR;
                            int i35 = ((i34 * ((~i34) & 65536)) & (~i33)) + i33;
                            int i36 = bArr3[i28] & ForkServer.ERROR;
                            int i37 = i36 * ((~i36) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                            int i38 = ~((((~i37) | 911399251) | i35) - ((i37 & 911399251) | i35));
                            int i39 = bArr3[i11] & ForkServer.ERROR;
                            int i40 = ~((((~i38) | 1433568692) | i39) - ((i38 & 1433568692) | i39));
                            int i41 = a6 << ((a6 > Double.NaN ? 1 : (a6 == Double.NaN ? 0 : -1)) >>> 31);
                            int i42 = (-1254002618) - ((i41 & 2) | ((-1672003491) - i41));
                            int i43 = (i42 + i40) - ((i42 & i40) * 2);
                            bArr3[i11] = (byte) i43;
                            bArr3[i28] = (byte) (i43 >>> 8);
                            bArr3[i25] = (byte) (i43 >>> 16);
                            bArr3[a4] = (byte) (i43 >>> 24);
                            i11 = (i11 ^ 4) + ((i11 & 4) * 2);
                            int length4 = bArr3.length;
                            int length5 = 0 - (bArr3.length % 4);
                            int i44 = ((i11 > AbstractC0014b1.a((length4 & 2) | D1.a(length5, length4), length5 * 3) ? 1 : (i11 == AbstractC0014b1.a((length4 & 2) | D1.a(length5, length4), length5 * 3) ? 0 : -1)) >>> 31) & 1;
                            if (i44 != 0) {
                                i9 = -1605440657;
                            } else {
                                i9 = -365117735;
                            }
                            if (i44 == 0) {
                                i9 = -169475207;
                            }
                            n12 = this;
                            jSONObject2 = jSONObject;
                            i5 = i15;
                            i6 = 1;
                            i7 = 2;
                            i8 = 3;
                        case -1135475043:
                            break;
                        case 180635757:
                            bArr3 = bArr;
                            bArr4 = bArr2;
                            i11 = i15;
                            i5 = i11;
                            i9 = -1605440657;
                        case 511524454:
                            int length6 = bArr3.length;
                            int i45 = 0 - i10;
                            int i46 = 0 - i45;
                            int i47 = ((~length6) & i46) * i7;
                            int length7 = bArr3.length;
                            byte b8 = bArr3[((length7 | i45) * i7) - (length7 ^ i45)];
                            int i48 = i6;
                            int length8 = bArr3.length;
                            byte b9 = bArr4[(i45 ^ length8) + ((length8 & i45) * 2)];
                            int i49 = i7;
                            bArr3[(length6 ^ i46) - i47] = (byte) (((byte) (b9 - b8)) + ((byte) (((byte) i7) * ((byte) ((~b9) & b8)))));
                            i12 = AbstractC0099x.a(i10, i8, (~i10) * 2);
                            if ((((i10 > i49 ? 1 : (i10 == i49 ? 0 : -1)) >>> 31) & 1) != 0) {
                                i = i48;
                                jSONObject2 = jSONObject;
                                i6 = i;
                                i5 = i15;
                                i7 = 2;
                                i8 = 3;
                                i9 = -458924450;
                                n12 = this;
                            } else {
                                i5 = i15;
                                i6 = i48;
                                i7 = 2;
                                i9 = -365117735;
                            }
                        case 961838909:
                            int length9 = bArr3.length;
                            int i50 = 0 - i12;
                            if ((bArr4[((length9 | i50) - (((~i50) & 165327505) & length9)) + ((i50 | 165327505) & length9)] > Double.NaN ? 1 : (bArr4[((length9 | i50) - (((~i50) & 165327505) & length9)) + ((i50 | 165327505) & length9)] == Double.NaN ? 0 : -1)) <= -1) {
                                i3 = i15;
                            } else {
                                i3 = i6;
                            }
                            if (i3 != 0) {
                                i4 = -365117735;
                            } else {
                                i4 = 1093626513;
                            }
                            if (i3 != 0) {
                                i9 = -746753280;
                            } else {
                                i9 = i4;
                            }
                            i10 = i12;
                            i5 = i15;
                        default:
                            i9 = -365117735;
                            n12 = this;
                            jSONObject2 = jSONObject;
                            i5 = i15;
                            i6 = 1;
                            i7 = 2;
                            i8 = 3;
                    }
                    kotlin.jvm.internal.j.e(jSONObject2, new String(bArr, StandardCharsets.UTF_8).intern());
                    jSONArray2 = new JSONArray();
                    it = n12.f300b.iterator();
                    jSONArray = jSONArray2;
                    c4 = 5955;
                    c5 = 20431;
                }
            }
        }
    }
}
