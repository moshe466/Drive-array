package F0;

import android.R;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.tika.fork.ForkServer;

/* loaded from: classes.dex */
public abstract class C1 extends T0 {

    /* renamed from: f, reason: collision with root package name */
    public final C0021d0 f180f;

    /* renamed from: g, reason: collision with root package name */
    public final C0054l1 f181g;

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0163, code lost:
    
        if (r2 != 0) goto L20;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x00e4. Please report as an issue. */
    static {
        /*
            Method dump skipped, instructions count: 736
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F0.C1.<clinit>():void");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1(C0093v1 c0093v1, C0021d0 c0021d0, C0054l1 c0054l1) {
        super(c0093v1);
        byte[] bArr = {-114, -72, -24, 40, -48, -38};
        k(bArr, new byte[]{-25, -88, -75, 61, -117, -13, 25, -43});
        Charset charset = StandardCharsets.UTF_8;
        new String(bArr, charset).intern();
        long j2 = -1759677833;
        long j3 = -33;
        long j4 = ((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845);
        long j5 = (((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
        long j6 = (((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
        long j7 = j6 + j5 + j4;
        long b4 = c3.b((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), j7, 6148914691236517205L);
        long j8 = (b4 >>> 48) & 43690;
        long j9 = ((j8 >>> 2) | (j8 >>> 1)) & 858993459;
        long j10 = ((j9 >>> 2) | j9) & 252645135;
        long j11 = (b4 >>> 32) & 43690;
        long j12 = ((j11 >>> 2) | (j11 >>> 1)) & 858993459;
        long j13 = ((j12 >>> 2) | j12) & 252645135;
        long j14 = ((((j13 >>> 4) | j13) & 16711935) << 16) | ((((j10 >>> 4) | j10) & 16711935) << 24);
        long j15 = (b4 >>> 16) & 43690;
        long j16 = ((j15 >>> 2) | (j15 >>> 1)) & 858993459;
        long j17 = ((j16 >>> 2) | j16) & 252645135;
        long j18 = b4 & 43690;
        long j19 = ((j18 >>> 2) | (j18 >>> 1)) & 858993459;
        long j20 = ((j19 >>> 2) | j19) & 252645135;
        long j21 = 1284967547;
        long j22 = (((int) ((((j20 >>> 4) | j20) & 16711935) + (((((j17 >>> 4) | j17) & 16711935) << 8) | j14))) & (-1855933692)) + 570966147;
        long j23 = (((((((((j21 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j21 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j21 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j21 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((j22 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j22 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j22 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j22 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
        long j24 = (j23 >>> 48) & 21845;
        long j25 = ((j24 >>> 1) | j24) & 858993459;
        long j26 = ((j25 >>> 2) | j25) & 252645135;
        long j27 = (j23 >>> 32) & 21845;
        long j28 = ((j27 >>> 1) | j27) & 858993459;
        long j29 = ((j28 >>> 2) | j28) & 252645135;
        long j30 = ((((j29 >>> 4) | j29) & 16711935) << 16) | ((((j26 >>> 4) | j26) & 16711935) << 24);
        long j31 = (j23 >>> 16) & 21845;
        long j32 = ((j31 >>> 1) | j31) & 858993459;
        long j33 = ((j32 >>> 2) | j32) & 252645135;
        long j34 = ((((j33 >>> 4) | j33) & 16711935) << 8) + j30;
        long j35 = j23 & 21845;
        long j36 = (j35 | (j35 >>> 1)) & 858993459;
        long j37 = (j36 | (j36 >>> 2)) & 252645135;
        byte[] bArr2 = {46, -43, (int) (((j37 | (j37 >>> 4)) & 16711935) | j34), -32, 2, 122};
        k(bArr2, new byte[]{-78, 8, 109, -92, 25, -94, 63, 41});
        kotlin.jvm.internal.j.e(c0021d0, new String(bArr2, charset).intern());
        byte[] bArr3 = new byte[8];
        long j38 = -1979543422;
        long j39 = ((((((((j38 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j38 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j38 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j38 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + j7;
        long j40 = (j39 >>> 48) & 43690;
        long j41 = ((j40 >>> 2) | (j40 >>> 1)) & 858993459;
        long j42 = ((j41 >>> 2) | j41) & 252645135;
        long j43 = (j39 >>> 32) & 43690;
        long j44 = ((j43 >>> 2) | (j43 >>> 1)) & 858993459;
        long j45 = ((j44 >>> 2) | j44) & 252645135;
        long j46 = ((((j45 >>> 4) | j45) & 16711935) << 16) + ((((j42 >>> 4) | j42) & 16711935) << 24);
        long j47 = (j39 >>> 16) & 43690;
        long j48 = ((j47 >>> 2) | (j47 >>> 1)) & 858993459;
        long j49 = ((j48 >>> 2) | j48) & 252645135;
        long j50 = j39 & 43690;
        long j51 = ((j50 >>> 2) | (j50 >>> 1)) & 858993459;
        long j52 = ((j51 >>> 2) | j51) & 252645135;
        long j53 = 16785992;
        long j54 = 0;
        long j55 = (((((((((j53 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j53 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j53 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j53 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j54 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j54 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j54 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j54 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + 6148914691236517205L;
        long j56 = (j55 >>> 48) & 43690;
        long j57 = ((j56 >>> 2) | (j56 >>> 1)) & 858993459;
        long j58 = ((j57 >>> 2) | j57) & 252645135;
        long j59 = (j55 >>> 32) & 43690;
        long j60 = ((j59 >>> 2) | (j59 >>> 1)) & 858993459;
        long j61 = ((j60 >>> 2) | j60) & 252645135;
        long j62 = ((((j61 >>> 4) | j61) & 16711935) << 16) | ((((j58 >>> 4) | j58) & 16711935) << 24);
        long j63 = (j55 >>> 16) & 43690;
        long j64 = ((j63 >>> 2) | (j63 >>> 1)) & 858993459;
        long j65 = ((j64 >>> 2) | j64) & 252645135;
        long j66 = j55 & 43690;
        long j67 = ((j66 >>> 2) | (j66 >>> 1)) & 858993459;
        long j68 = ((j67 >>> 2) | j67) & 252645135;
        bArr3[(((int) ((((j52 >>> 4) | j52) & 16711935) + (((((j49 >>> 4) | j49) & 16711935) << 8) | j46))) + ((int) ((((j68 >>> 4) | j68) & 16711935) + (((((j65 >>> 4) | j65) & 16711935) << 8) | j62)))) ^ (-1962757430)] = 48;
        bArr3[1] = 78;
        bArr3[2] = 93;
        bArr3[3] = 77;
        bArr3[4] = 123;
        bArr3[5] = 1;
        bArr3[6] = -61;
        bArr3[7] = -36;
        byte[] bArr4 = new byte[8];
        bArr4[0] = 92;
        bArr4[1] = -1;
        long j69 = -747298010;
        long b5 = c3.b((((((((j69 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j69 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j69 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j69 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), j6 + (j5 | j4), 6148914691236517205L);
        long j70 = (b5 >>> 48) & 43690;
        long j71 = ((j70 >>> 2) | (j70 >>> 1)) & 858993459;
        long j72 = (j71 | (j71 >>> 2)) & 252645135;
        long j73 = (b5 >>> 32) & 43690;
        long j74 = ((j73 >>> 2) | (j73 >>> 1)) & 858993459;
        long j75 = ((j74 >>> 2) | j74) & 252645135;
        long j76 = (((j72 | (j72 >>> 4)) & 16711935) << 24) | ((((j75 >>> 4) | j75) & 16711935) << 16);
        long j77 = (b5 >>> 16) & 43690;
        long j78 = ((j77 >>> 2) | (j77 >>> 1)) & 858993459;
        long j79 = ((j78 >>> 2) | j78) & 252645135;
        long j80 = b5 & 43690;
        long j81 = ((j80 >>> 2) | (j80 >>> 1)) & 858993459;
        long j82 = (j81 | (j81 >>> 2)) & 252645135;
        int i = 68423936 + (((int) (((((j79 >>> 4) | j79) & 16711935) << 8) | j76 | ((j82 | (j82 >>> 4)) & 16711935))) & (-1054342062));
        bArr4[B0.a((-985918128) | (~i), (-985918128) - i)] = -78;
        bArr4[3] = -6;
        bArr4[4] = -107;
        bArr4[5] = -6;
        bArr4[6] = -118;
        bArr4[7] = -46;
        k(bArr3, bArr4);
        new String(bArr3, charset).intern();
        this.f180f = c0021d0;
        this.f181g = c0054l1;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0135. Please report as an issue. */
    public static void k(byte[] bArr, byte[] bArr2) {
        int length;
        int i;
        int length2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = ~C1.class.getName().length();
        int length3 = (((~(((C1.class.getName().length() | 70245657) | i7) - (i7 | (C1.class.getName().length() & (-70245658))))) & (-1979440632)) + ((C1.class.getName().length() & 1074528264) | 1093142560)) ^ (-886298072);
        int f4 = AbstractC0008a.f(C1.class, -1);
        int length4 = (((f4 | (-1789924155)) - ((21884101 | f4) ^ (-1811767295))) + (((C1.class.getName().length() | 1811808253) - 1811808253) | 537399298)) ^ (-1274367997);
        int length5 = ((((~C1.class.getName().length()) | (-576567005)) & 276971586) + ((C1.class.getName().length() & 36928) | 1073844225)) ^ 1350815811;
        int length6 = ((((~C1.class.getName().length()) | (-1157759625)) & 1755853004) + ((C1.class.getName().length() & 1073973402) | (-2146202606))) ^ (-390349602);
        int i8 = ((~C1.class.getName().length()) | (-529537184)) & 457019905;
        int length7 = C1.class.getName().length();
        int i9 = (-1686268015) ^ ((((454038545 & length7) ^ (-2143287920)) + (length7 & 1040)) + i8);
        int length8 = ((((~C1.class.getName().length()) | (-1064961)) + 689325073) + ((C1.class.getName().length() & (-2112862208)) | (-2109732696))) ^ (-1420407624);
        int i10 = ((~C1.class.getName().length()) | 91711000) & (-1070824876);
        int length9 = C1.class.getName().length();
        int i11 = (i10 + (9457696 | ((length9 | (-1064779676)) - (length9 ^ (-1064779676))))) ^ 1492981618;
        short[] sArr = null;
        while (true) {
            switch (i11) {
                case -2143294076:
                    int i12 = ~C1.class.getName().length();
                    if (length3 < length4) {
                        int length10 = (C1.class.getName().length() & 268439810) | 285217280;
                        int i13 = -((i12 | (-1553600102)) - (((-1553600360) | i12) ^ 536887698));
                        i5 = (((~i13) & length10) * 2) - (i13 ^ length10);
                        i6 = -1524017045;
                        i11 = i6 ^ i5;
                    } else {
                        length = ((i12 | (-747233512)) & (-1862204400)) + ((C1.class.getName().length() & 1073807362) | 1116733474);
                        i = -375509041;
                        i11 = length ^ i;
                    }
                case -2038999444:
                    int i14 = ~C1.class.getName().length();
                    int length11 = (161497089 & (((((C1.class.getName().length() & (~i14)) & 797295576) + 797295576) + i14) - ((C1.class.getName().length() | i14) & 797295576))) + ((C1.class.getName().length() & (-2145386455)) | (-2147483476));
                    int a2 = ((short) ((length5 << E1.a(length11 | (-1985986391), -1985986391, length11)) + sArr[((((~C1.class.getName().length()) | (-1085986263)) & 1078327440) + ((C1.class.getName().length() & 1612763792) | 674234944)) ^ 1752562386])) ^ (length5 + i9);
                    int i15 = ~C1.class.getName().length();
                    int length12 = length5 >>> ((((~(((C1.class.getName().length() | 626856794) | i15) - ((C1.class.getName().length() & (-626856795)) | i15))) & 957405457) + ((C1.class.getName().length() & 588787984) | 36185216)) ^ 993590676);
                    short s3 = sArr[((((~C1.class.getName().length()) | 1248713193) & 826417528) + ((C1.class.getName().length() & 822288912) | (-2138488320))) ^ (-1312070789)];
                    int i16 = -length12;
                    int i17 = i16 | s3;
                    int i18 = (i17 - (i16 * 2)) + ((i16 ^ s3) ^ i17);
                    int i19 = -B0.a(i18 | (~a2), i18 - a2);
                    length6 = (short) D.a(length6, 3, -(D1.a(length6, i19) | (i19 & 2)), 1);
                    int i20 = ((~C1.class.getName().length()) | (-549847554)) + 1624126210;
                    int length13 = (C1.class.getName().length() & 549848649) | 67175498;
                    length5 = (short) (length5 - ((((short) ((length6 << (1691301711 ^ ((length13 & i20) + (i20 | length13)))) + sArr[((((~C1.class.getName().length()) | (-1005965450)) & 153223237) + ((C1.class.getName().length() & 220201009) | 335544368)) ^ 488767605])) ^ (((i9 | length6) - ((C1.class.getName().length() & (~length6)) & i9)) + ((C1.class.getName().length() | length6) & i9))) ^ ((length6 >>> (((((~C1.class.getName().length()) | (-30261291)) & (-1534000062)) + ((C1.class.getName().length() & 8609814) | 2285588)) ^ (-1531714477))) + sArr[((((~C1.class.getName().length()) | (-23496740)) & 827084804) + ((C1.class.getName().length() & (-2117787632)) | (-2139021104))) ^ (-1311936299)])));
                    int i21 = ((~C1.class.getName().length()) | (-412319609)) & (-1959782776);
                    int length14 = (C1.class.getName().length() & 403838542) | 268582982;
                    int i22 = -i21;
                    int i23 = (((~i22) & length14) * 2) - (i22 ^ length14);
                    i9 = (short) U0.a(1691170566 & i23, (-1691170567) - i23, i9);
                    length8++;
                    length = (((~C1.class.getName().length()) | (-961655275)) & 25184460) + ((C1.class.getName().length() & 150995145) | 140771329);
                    i = 1965034008;
                    i11 = length ^ i;
                case -1809249287:
                    byte b4 = bArr[(((((~C1.class.getName().length()) | 1233459797) & 125923146) + ((C1.class.getName().length() & 774137098) | 674496513)) ^ 800419659) + length3];
                    int length15 = ((((~C1.class.getName().length()) | (-7107622)) & 402932290) + ((C1.class.getName().length() & 546586672) | 546340912)) ^ 949273229;
                    int length16 = ((C1.class.getName().length() | length15) - (b4 | length15)) + I2.a(C1.class, b4) + (C1.class.getName().length() & length15);
                    int length17 = ((((~C1.class.getName().length()) | (-81143879)) & 438583424) + ((C1.class.getName().length() & 786435) | 8921603)) ^ 447505026;
                    byte b5 = bArr[((length17 & length3) * 2) + (length17 ^ length3)];
                    int i24 = ~C1.class.getName().length();
                    length5 = (short) (((b5 & ((-1954201202) ^ ((((C1.class.getName().length() | (-2105278367)) - (i24 | (-1545180443))) + (I2.a(C1.class, 568748773 | i24) + (C1.class.getName().length() & (-2105278367)))) + ((C1.class.getName().length() & (-2097135360)) | 151077136)))) << (((((~C1.class.getName().length()) | (-1592082969)) & 140665109) + ((C1.class.getName().length() & 142103568) | 1612800)) ^ 142277917)) | length16);
                    int i25 = ~C1.class.getName().length();
                    int length18 = (-1901610175) ^ ((((((~i25) & (-569955033)) + i25) | 2038255548) - 2038255548) + ((C1.class.getName().length() & 144806464) | 136645376));
                    int i26 = -length3;
                    int i27 = i26 | length18;
                    byte b6 = bArr[(i27 - (i26 * 2)) + ((length18 ^ i26) ^ i27)];
                    int i28 = (((-199685676) | r7) - 1591672428) - ((~C1.class.getName().length()) | (-180811308));
                    int length19 = (C1.class.getName().length() & 23072776) | 272636008;
                    int length20 = b6 & ((-1319036669) ^ (((length19 | i28) - ((C1.class.getName().length() & (~i28)) & length19)) + (length19 & (i28 | C1.class.getName().length()))));
                    int i29 = ((~C1.class.getName().length()) | (-1009031633)) & 545538049;
                    int length21 = (C1.class.getName().length() & 537143360) | 10560;
                    int length22 = bArr[(545548610 ^ ((length21 & i29) + (i29 | length21))) + length3] & (((((~C1.class.getName().length()) | 75364313) & 1242301609) + ((C1.class.getName().length() & 1249907040) | (-1602217664))) ^ (-359916266));
                    int length23 = C1.class.getName().length();
                    length6 = (short) (length20 | (length22 << ((((1779401364 | (((~length23) - length23) + length23)) & 447961710) + ((C1.class.getName().length() & (-1313580806)) | (-519831408))) ^ (-71869706))));
                    int i30 = ~C1.class.getName().length();
                    i9 = 758110381 ^ (((((-1343875612) | i30) + 311432716) - (i30 | (-1074391060))) + ((C1.class.getName().length() & 273678921) | (-1069545407)));
                    int i31 = ~C1.class.getName().length();
                    int length24 = 1409942802 & (((((C1.class.getName().length() & (~i31)) & 91135407) + 91135407) + i31) - ((i31 | C1.class.getName().length()) & 91135407));
                    int length25 = (C1.class.getName().length() & (-804257776)) | (-2094006112);
                    int i32 = -length24;
                    length8 = (-684063310) ^ (((~i32) & length25) - (i32 & (~length25)));
                    length2 = (((~C1.class.getName().length()) | (-537919489)) - (-806798471)) + ((C1.class.getName().length() & 674768897) | 153626665);
                    i3 = 1174056570 - length2;
                    i4 = -1174056571;
                    i11 = ((length2 & i4) * 2) + i3;
                case -1740520186:
                    sArr = new short[((((~C1.class.getName().length()) | (-382746167)) & 102532165) + ((C1.class.getName().length() & 105907748) | 4198960)) ^ 106731121];
                    length3 = ((((~C1.class.getName().length()) | (-6036961)) & 1233145505) + ((C1.class.getName().length() & 809508000) | 809603328)) ^ 2042748833;
                    int i33 = ((~C1.class.getName().length()) | 1688058452) & 872484865;
                    int length26 = C1.class.getName().length() & 268460041;
                    i5 = (((((C1.class.getName().length() & (~length26)) & 4218888) + 4218888) + length26) - ((length26 | C1.class.getName().length()) & 4218888)) + i33;
                    i6 = 434661073;
                    i11 = i6 ^ i5;
                case -1489518479:
                    int length27 = C1.class.getName().length();
                    int length28 = (((-2053077912) & ((516782023 - length27) + (((-((-1) - length27)) - 1) | (-516782024)))) + ((C1.class.getName().length() & (-1054752728)) | 1073823745)) ^ (-979254165);
                    int length29 = bArr2[(((~length3) & length28) * ((~length28) & length3)) + ((length28 & length3) * (length28 | length3))] & (((((~C1.class.getName().length()) | (-1883938358)) & (-738125179)) + ((C1.class.getName().length() & 1343232517) | 546308360)) ^ (-191816846));
                    int i34 = ~C1.class.getName().length();
                    int i35 = 73539736 & (((~i34) & (-1772650326)) + i34);
                    int length30 = (C1.class.getName().length() & 35664144) | 33608448;
                    int i36 = -i35;
                    byte b7 = bArr2[((107148186 ^ ((((~i36) & length30) * 2) - (i36 ^ length30))) * length3) + ((((I2.a(C1.class, -1) | (-532481)) - (-67641369)) + ((C1.class.getName().length() & 532546) | 1602)) ^ 67642971)];
                    int i37 = ~C1.class.getName().length();
                    int length31 = (b7 & (((663757504 & ((i37 + 1314070430) - (i37 & 1314070430))) + ((C1.class.getName().length() & 834674756) | 272630796)) ^ 936388147)) << ((((I2.a(C1.class, -1) | (-33554434)) - (-1107366402)) + ((C1.class.getName().length() & (-2113929151)) | (-2147475136))) ^ (-1040108727));
                    sArr[length3] = (short) ((length31 ^ length29) + (length29 & length31));
                    length3++;
                    length = ((I2.a(C1.class, -1) | (-167014194)) & 1157999680) + ((C1.class.getName().length() & 159661328) | (-2004872944));
                    i = -533943416;
                    i11 = length ^ i;
                case -473033593:
                    int i38 = -length3;
                    int i39 = -bArr.length;
                    int i40 = i39 | i38;
                    int i41 = (i40 - (i39 * 2)) + ((i39 ^ i38) ^ i40);
                    byte b8 = bArr[bArr.length - length3];
                    int length32 = C1.class.getName().length();
                    bArr[i41] = (byte) (b8 ^ bArr2[length3 % (((((-878819395) | ((length32 - 1) - (length32 * 2))) & 1490255976) + ((C1.class.getName().length() & 274827331) | 556017667)) ^ 2046273635)]);
                    length3--;
                    int f5 = (AbstractC0008a.f(C1.class, -1) | 114408723) & 1183666176;
                    int length33 = C1.class.getName().length() & 1074544770;
                    length = S.a(length33, (-268567684) | ((-length33) - 1), 268567684, f5);
                    i = 836032333;
                    i11 = length ^ i;
                case 766056152:
                    int i42 = ((~C1.class.getName().length()) | (-889871025)) & 1233748555;
                    int length34 = C1.class.getName().length();
                    int i43 = (length34 + 84675108) - (length34 | 84675108);
                    if (length3 < (1842188139 ^ ((((~i43) & 608439588) + i43) + i42))) {
                        int i44 = ((~C1.class.getName().length()) | 1878725846) & 1912684595;
                        int length35 = (C1.class.getName().length() & 268589089) | 661640;
                        length = AbstractC0099x.a(i44 | length35, 2, (~i44) ^ length35);
                        i = -717449014;
                    } else {
                        length = (((~C1.class.getName().length()) | (-1477955618)) & (-1604246503)) + ((C1.class.getName().length() & 1074350177) | 1342720098);
                        i = -887872332;
                    }
                    i11 = length ^ i;
                case 974072829:
                    int length36 = bArr.length;
                    int i45 = ((~C1.class.getName().length()) | 1711185063) & 170281206;
                    int length37 = (C1.class.getName().length() & 251684176) | 1694512896;
                    int i46 = -i45;
                    length3 = length36 % (1864794098 ^ (((~i46) & length37) - (i46 & (~length37))));
                    length = (((~C1.class.getName().length()) | 991120067) & (-2113137661)) + ((C1.class.getName().length() & (-1878240248)) | 285229064);
                    i = -195569723;
                    i11 = length ^ i;
                case 998066383:
                    length3 = (((AbstractC0008a.f(C1.class, -1) | 314136709) & 371231304) + (((C1.class.getName().length() | (-67142233)) + 67142233) | (-1996488432))) ^ (-1625257128);
                    length4 = bArr.length - (bArr.length % (((((~C1.class.getName().length()) | 366661365) & 1344150018) + ((C1.class.getName().length() & (-1006333853)) | (-2080341919))) ^ (-736191897)));
                    length = (((~C1.class.getName().length()) | (-1359635359)) & 49026131) + ((C1.class.getName().length() & (-1860698094)) | (-1190123008));
                    i = 1002689495;
                    i11 = length ^ i;
                case 1314339506:
                    break;
                case 1734050766:
                    int i47 = ~C1.class.getName().length();
                    if (length3 > 0) {
                        int length38 = C1.class.getName().length();
                        length = ((i47 | (-268772210)) & 282132586) + (168323072 | ((length38 + 402735200) - (length38 | 402735200)));
                        i = -115901203;
                        i11 = length ^ i;
                    } else {
                        int length39 = (C1.class.getName().length() & R.^attr-private.__removed0) | 553664516;
                        int i48 = -((i47 | 1510858717) & 403833600);
                        i5 = ((~i48) & length39) - (i48 & (~length39));
                        i6 = 2001041846;
                        i11 = i6 ^ i5;
                    }
                case 1771480224:
                    bArr[(((((~C1.class.getName().length()) | 1110430873) & 1241612298) + ((C1.class.getName().length() & 150996226) | 84419840)) ^ 1326032138) + length3] = (byte) ((((((~C1.class.getName().length()) | 1603962366) & 25199440) + (((C1.class.getName().length() | (-1311235)) + 1311235) | (-2146172766))) ^ (-2120973555)) & length5);
                    int length40 = (((((~C1.class.getName().length()) | (-1388708984)) & 706816128) + ((C1.class.getName().length() & 1124204552) | 1363312648)) ^ 2070128777) + length3;
                    int i49 = ((~C1.class.getName().length()) | 367288948) & 548745488;
                    int length41 = C1.class.getName().length();
                    bArr[length40] = (byte) ((length5 >> ((i49 + (21135364 | ((length41 + 558960896) - (length41 | 558960896)))) ^ 569880860)) & (((((~C1.class.getName().length()) | 2113158628) & 1026558002) + ((C1.class.getName().length() & 8392730) | 8525645)) ^ 1035083648));
                    int length42 = (((~C1.class.getName().length()) | 715175224) & 136512788) + ((C1.class.getName().length() & 196644) | (-2146430752));
                    int a4 = AbstractC0105y1.a((~length42) | (-2009917962), (-2009917962) - length42, length3);
                    int i50 = ((~C1.class.getName().length()) | (-1010633609)) & 678986012;
                    int length43 = C1.class.getName().length();
                    int i51 = ~(((951583497 & length43) + 276825601) - (length43 & 276824577));
                    int i52 = -i50;
                    bArr[a4] = (byte) ((V2.a(~i52, i51, (i51 + i52) + 1) ^ 955811810) & length6);
                    int length44 = (((((~C1.class.getName().length()) | (-1084937228)) & 438503696) + ((C1.class.getName().length() & 69369860) | (-2080078843))) ^ (-1641575146)) + length3;
                    int i53 = ~C1.class.getName().length();
                    int length45 = length6 >> (2092810490 ^ ((((C1.class.getName().length() | 674349280) - (i53 | 1869872636)) + (AbstractC0008a.f(C1.class, 1197735420 | i53) + (C1.class.getName().length() & 674349280))) + ((C1.class.getName().length() & 1754529808) | 1418461202)));
                    int i54 = ((~C1.class.getName().length()) | 1601418652) & 1439188132;
                    int length46 = (C1.class.getName().length() & 545800290) | (-1442676670);
                    int i55 = -i54;
                    bArr[length44] = (byte) (length45 & ((-3488743) ^ (((~i55) & length46) - (i55 & (~length46)))));
                    length3 += 4;
                    length = (((~C1.class.getName().length()) | (-171976913)) & 318775824) + ((C1.class.getName().length() & 33562640) | 136194);
                    i = -1824662634;
                    i11 = length ^ i;
                case 2093236949:
                    if (length8 < (((((~C1.class.getName().length()) | (-616910267)) & 1303391760) + ((C1.class.getName().length() & 75500825) | 537198861)) ^ 1840590653)) {
                        length2 = (((~C1.class.getName().length()) | 1297715640) & 556926729) + ((C1.class.getName().length() & 874653185) | 335552516);
                        i3 = (-1287294623) - length2;
                        i4 = 1287294622;
                        i11 = ((length2 & i4) * 2) + i3;
                    } else {
                        int i56 = ~C1.class.getName().length();
                        length = (1141965102 & ((-1207265904) + i56 + (((-i56) - 1) | 1207265904))) + ((C1.class.getName().length() & 1292960864) | 150996032);
                        i = 612868558;
                        i11 = length ^ i;
                    }
                default:
                    int i57 = ~C1.class.getName().length();
                    int i58 = (((-313266948) | i57) + 45165696) - (i57 | (-269226756));
                    length = D.a(i58, 3, -D1.a(i58, (C1.class.getName().length() & 44040224) | (-1811807712)), 1);
                    i = -361272203;
                    i11 = length ^ i;
            }
            return;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0048. Please report as an issue. */
    public static void r(byte[] bArr, byte[] bArr2) {
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
}
