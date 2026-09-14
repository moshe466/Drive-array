package F0;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import org.apache.tika.fork.ForkServer;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class T extends k3 {
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0048. Please report as an issue. */
    public static void g(byte[] bArr, byte[] bArr2) {
        int i;
        int i3;
        byte[] bArr3 = null;
        int i4 = 1516727821;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        byte[] bArr4 = null;
        while (true) {
            int i8 = ((i4 & 16777216) * (i4 | 16777216)) + ((i4 & (-16777217)) * ((~i4) & 16777216));
            int i9 = i4 >>> 8;
            int a2 = j3.a(650911840 & (~i8) & i9, i9, i8, (i8 | 650911840) & i9);
            int i10 = (a2 ^ 642535957) + ((a2 & 642535957) * 2);
            int i11 = -365117735;
            boolean z3 = true;
            switch (((~i10) + ((i10 | 1) * 2)) ^ 962785775) {
                case -1896910703:
                    int length = bArr4.length;
                    int i12 = 0 - i5;
                    int i13 = (length ^ i12) + ((length & i12) * 2);
                    byte b4 = bArr3[i13];
                    int length2 = bArr4.length;
                    int i14 = 0 - i12;
                    int i15 = i14 | length2;
                    byte b5 = bArr3[D.a(i14, 2, i15, (length2 ^ i14) ^ i15)];
                    bArr3[i13] = (byte) (((byte) (((byte) 2) * ((byte) (b5 | b4)))) - ((byte) (b5 ^ b4)));
                    i4 = -746753280;
                case -1725904394:
                    i7 = bArr4.length % 4;
                    if ((((i7 > 1 ? 1 : (i7 == 1 ? 0 : -1)) >>> 31) & 1) == 0) {
                        i4 = -365117735;
                    } else {
                        i4 = -458924450;
                    }
                case -1399959314:
                    int a4 = j3.a((-1205100636) & i6, i6, 3, (-1205100633) & i6);
                    byte b6 = bArr3[a4];
                    int i16 = ((b6 & ForkServer.DONE) * (b6 | ForkServer.DONE)) + ((b6 & ForkServer.ERROR) * ((~b6) & 16777216));
                    int i17 = i6 - 1;
                    int i18 = i17 - (i6 | (-3));
                    int i19 = bArr3[i18] & ForkServer.ERROR;
                    int i20 = i19 * ((~i19) & 65536);
                    int a5 = S.a(i20, i16, 1, ((-1) - i20) | ((-1) - i16));
                    int i21 = i17 - (i6 | (-2));
                    int i22 = bArr3[i21] & ForkServer.ERROR;
                    int i23 = i22 * ((~i22) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i24 = (i23 - 1) - ((~a5) | i23);
                    int i25 = bArr3[i6] & ForkServer.ERROR;
                    int a6 = S.a(i24, i25, 1, ((-1) - i24) | ((-1) - i25));
                    byte b7 = bArr4[a4];
                    int i26 = ((b7 & ForkServer.DONE) * (b7 | ForkServer.DONE)) + ((b7 & ForkServer.ERROR) * ((~b7) & 16777216));
                    int i27 = bArr4[i18] & ForkServer.ERROR;
                    int i28 = ((i27 * ((~i27) & 65536)) & (~i26)) + i26;
                    int i29 = bArr4[i21] & ForkServer.ERROR;
                    int i30 = i29 * ((~i29) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i31 = ~((((~i30) | 911399251) | i28) - ((i30 & 911399251) | i28));
                    int i32 = bArr4[i6] & ForkServer.ERROR;
                    int i33 = ~((((~i31) | 1433568692) | i32) - ((i31 & 1433568692) | i32));
                    int i34 = a6 << ((a6 > Double.NaN ? 1 : (a6 == Double.NaN ? 0 : -1)) >>> 31);
                    int i35 = (-1254002618) - ((i34 & 2) | ((-1672003491) - i34));
                    int i36 = (i35 + i33) - ((i35 & i33) * 2);
                    bArr4[i6] = (byte) i36;
                    bArr4[i21] = (byte) (i36 >>> 8);
                    bArr4[i18] = (byte) (i36 >>> 16);
                    bArr4[a4] = (byte) (i36 >>> 24);
                    i6 = (i6 ^ 4) + ((i6 & 4) * 2);
                    int length3 = bArr4.length;
                    int length4 = 0 - (bArr4.length % 4);
                    int i37 = ((i6 > AbstractC0014b1.a((length3 & 2) | D1.a(length4, length3), length4 * 3) ? 1 : (i6 == AbstractC0014b1.a((length3 & 2) | D1.a(length4, length3), length4 * 3) ? 0 : -1)) >>> 31) & 1;
                    if (i37 != 0) {
                        i = -1605440657;
                    } else {
                        i = -365117735;
                    }
                    if (i37 != 0) {
                        i4 = i;
                    } else {
                        i4 = -169475207;
                    }
                case -1135475043:
                    break;
                case 180635757:
                    int length5 = bArr.length;
                    int length6 = 0 - (bArr.length % 4);
                    if ((length5 ^ (~length6)) + ((length5 | length6) * 2) + 1 <= 0) {
                        z3 = false;
                    }
                    if (z3) {
                        i3 = -1605440657;
                    } else {
                        i3 = -365117735;
                    }
                    if (z3) {
                        i4 = i3;
                    } else {
                        i4 = -169475207;
                    }
                    bArr3 = bArr2;
                    bArr4 = bArr;
                    i6 = 0;
                case 511524454:
                    int length7 = bArr4.length;
                    int i38 = 0 - i5;
                    int i39 = 0 - i38;
                    int i40 = ((~length7) & i39) * 2;
                    int length8 = bArr4.length;
                    byte b8 = bArr4[((length8 | i38) * 2) - (length8 ^ i38)];
                    int length9 = bArr4.length;
                    byte b9 = bArr3[(i38 ^ length9) + ((length9 & i38) * 2)];
                    bArr4[(length7 ^ i39) - i40] = (byte) (((byte) (b9 - b8)) + ((byte) (((byte) 2) * ((byte) ((~b9) & b8)))));
                    i7 = AbstractC0099x.a(i5, 3, (~i5) * 2);
                    if ((((i5 > 2 ? 1 : (i5 == 2 ? 0 : -1)) >>> 31) & 1) == 0) {
                        i4 = -365117735;
                    } else {
                        i4 = -458924450;
                    }
                case 961838909:
                    int length10 = bArr4.length;
                    int i41 = 0 - i7;
                    if ((bArr3[((length10 | i41) - ((165327505 & (~i41)) & length10)) + ((i41 | 165327505) & length10)] > Double.NaN ? 1 : (bArr3[((length10 | i41) - ((165327505 & (~i41)) & length10)) + ((i41 | 165327505) & length10)] == Double.NaN ? 0 : -1)) <= -1) {
                        z3 = false;
                    }
                    if (!z3) {
                        i11 = 1093626513;
                    }
                    if (z3) {
                        i4 = -746753280;
                    } else {
                        i4 = i11;
                    }
                    i5 = i7;
                default:
                    i4 = -365117735;
            }
            return;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:31:0x02a3. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x000c. Please report as an issue. */
    @Override // F0.k3
    public final JSONObject a() {
        int i;
        boolean z3;
        Iterable iterable = null;
        JSONObject jSONObject = null;
        JSONArray jSONArray = null;
        Iterator it = null;
        JSONArray jSONArray2 = null;
        JSONObject jSONObject2 = null;
        while (true) {
            char c4 = 26102;
            while (true) {
                switch (c4) {
                    case 52722:
                        int i3 = ((~T.class.getName().length()) | 1582018493) & 806383960;
                        long j2 = 50659329;
                        long length = T.class.getName().length() & 571756609;
                        long j3 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((length >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + 6148914691236517205L;
                        long j4 = (j3 >>> 48) & 43690;
                        int i4 = 2;
                        long j5 = ((j4 >>> 2) | (j4 >>> 1)) & 858993459;
                        long j6 = ((j5 >>> 2) | j5) & 252645135;
                        long j7 = (j3 >>> 32) & 43690;
                        long j8 = ((j7 >>> 2) | (j7 >>> 1)) & 858993459;
                        long j9 = ((j8 >>> 2) | j8) & 252645135;
                        long j10 = ((((j9 >>> 4) | j9) & 16711935) << 16) | ((((j6 >>> 4) | j6) & 16711935) << 24);
                        long j11 = (j3 >>> 16) & 43690;
                        long j12 = ((j11 >>> 2) | (j11 >>> 1)) & 858993459;
                        long j13 = ((j12 >>> 2) | j12) & 252645135;
                        long j14 = j3 & 43690;
                        long j15 = ((j14 >>> 2) | (j14 >>> 1)) & 858993459;
                        long j16 = (j15 | (j15 >>> 2)) & 252645135;
                        byte[] bArr = {-11, 119, 51, -119, 15, (i3 + ((int) (((j16 | (j16 >>> 4)) & 16711935) + (((((j13 >>> 4) | j13) & 16711935) << 8) + j10)))) ^ 857043298, 45, -96, 20, -107, 8, -120, 65, -4, 27, -115, -40};
                        byte[] bArr2 = new byte[17];
                        bArr2[0] = -108;
                        bArr2[1] = 20;
                        bArr2[2] = 80;
                        bArr2[3] = -20;
                        bArr2[4] = 124;
                        bArr2[5] = 72;
                        bArr2[6] = 68;
                        bArr2[7] = -62;
                        bArr2[8] = 125;
                        bArr2[9] = -7;
                        bArr2[10] = 97;
                        int i5 = ~T.class.getName().length();
                        int i6 = (~(((T.class.getName().length() | 1370964980) | i5) - ((T.class.getName().length() & (-1370964981)) | i5))) & (-2124217216);
                        int length2 = (T.class.getName().length() & 19071368) | 1140850952;
                        bArr2[(((length2 & i6) * 2) + (length2 ^ i6)) ^ (-983366269)] = -4;
                        bArr2[12] = 56;
                        bArr2[13] = -67;
                        bArr2[14] = 107;
                        bArr2[15] = -3;
                        bArr2[16] = -85;
                        int i7 = -1850458006;
                        int i8 = 0;
                        int i9 = 0;
                        byte[] bArr3 = null;
                        byte[] bArr4 = null;
                        while (true) {
                            int i10 = ((i7 & 16777216) * (i7 | 16777216)) + ((i7 & (-16777217)) * ((~i7) & 16777216));
                            int i11 = i7 >>> 8;
                            int i12 = (i11 - 1) - ((~i10) | i11);
                            int i13 = (-1700147435) - ((2028104049 - i12) | (i12 & i4));
                            int i14 = -1396193641;
                            switch ((-1363443157) ^ ((~i13) + ((i13 | 1) * i4))) {
                                case -1940167324:
                                    i = i4;
                                    byte b4 = bArr4[i8];
                                    int i15 = ((byte) 0) - b4;
                                    bArr4[i8] = (byte) (((byte) (b4 & (~i15))) - ((byte) ((~b4) & i15)));
                                    i7 = 614229416;
                                    i4 = i;
                                case -360299937:
                                    i = i4;
                                    if ((bArr4[i9] > Double.NaN ? 1 : (bArr4[i9] == Double.NaN ? 0 : -1)) <= -1) {
                                        z3 = false;
                                    } else {
                                        z3 = true;
                                    }
                                    if (!z3) {
                                        i14 = 427928065;
                                    }
                                    if (z3) {
                                        i7 = 614229416;
                                    } else {
                                        i7 = i14;
                                    }
                                    i8 = i9;
                                    i4 = i;
                                case 399486784:
                                    break;
                                case 585276366:
                                    bArr4 = bArr2;
                                    bArr3 = bArr;
                                    i7 = 1985663266;
                                    i9 = 0;
                                case 1733787683:
                                    byte b5 = bArr3[i8];
                                    byte b6 = bArr4[i8];
                                    i = i4;
                                    bArr3[i8] = (byte) (((byte) (b6 + b5)) - ((byte) (((byte) i4) * ((byte) (b6 & b5)))));
                                    int i16 = (i8 ^ 1) + ((i8 & 1) * 2);
                                    int i17 = ((i16 > bArr3.length ? 1 : (i16 == bArr3.length ? 0 : -1)) >>> 31) & 1;
                                    i9 = i16;
                                    if (i17 != 0) {
                                        i4 = i;
                                        i7 = 1985663266;
                                    } else {
                                        i7 = -1396193641;
                                        i4 = i;
                                    }
                                default:
                                    i7 = -1396193641;
                            }
                            jSONObject.put(new String(bArr, StandardCharsets.UTF_8).intern(), jSONArray);
                            iterable = null;
                            c4 = 34065;
                        }
                    case 46442:
                        c4 = 34065;
                    case 57288:
                        if (it.hasNext()) {
                            c4 = 55078;
                        } else {
                            c4 = 52722;
                        }
                    case 55078:
                        jSONArray2.put((String) it.next());
                        c4 = 57288;
                    case 868:
                        jSONArray2 = new JSONArray();
                        it = iterable.iterator();
                        jSONArray = jSONArray2;
                        c4 = 57288;
                    case 26102:
                        jSONObject2 = super.a();
                        c4 = 46442;
                        jSONObject = jSONObject2;
                    case 34065:
                        break;
                }
                return jSONObject2;
            }
        }
    }
}
