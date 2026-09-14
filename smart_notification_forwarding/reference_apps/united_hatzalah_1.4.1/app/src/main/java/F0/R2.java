package F0;

import android.R;
import android.util.Base64;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.apache.tika.fork.ForkServer;
import org.json.JSONException;

/* loaded from: classes.dex */
public final class R2 {

    /* renamed from: a, reason: collision with root package name */
    public Object f372a;

    /* renamed from: b, reason: collision with root package name */
    public Object f373b;

    /* renamed from: c, reason: collision with root package name */
    public Object f374c;

    /* renamed from: d, reason: collision with root package name */
    public Object f375d;

    /* renamed from: e, reason: collision with root package name */
    public Object f376e;

    public R2(Z1 z12, String str, Q q3) {
        byte[] bArr = {64, -39, 99, 53, -50, 35};
        e(bArr, new byte[]{71, -124, -125, -3, -89, 68, -61, -118});
        Charset charset = StandardCharsets.UTF_8;
        kotlin.jvm.internal.j.e(z12, new String(bArr, charset).intern());
        byte[] bArr2 = new byte[17];
        bArr2[0] = 20;
        bArr2[1] = -79;
        bArr2[2] = 60;
        bArr2[((((~R2.class.getName().length()) | (-791465993)) & (-602931195)) + ((R2.class.getName().length() & 230703232) | 29378688)) ^ (-573552506)] = 63;
        bArr2[4] = 93;
        bArr2[5] = 80;
        bArr2[6] = 125;
        bArr2[7] = -20;
        bArr2[8] = -41;
        bArr2[9] = 90;
        bArr2[10] = 80;
        bArr2[11] = 68;
        bArr2[12] = -34;
        bArr2[13] = -111;
        bArr2[14] = -7;
        int i = ((~R2.class.getName().length()) | (-714604040)) & 1905459755;
        int length = R2.class.getName().length();
        bArr2[(i + (((length | 548610691) - (length ^ 548610691)) | 2125952)) ^ 1907585700] = -74;
        bArr2[16] = -20;
        byte[] bArr3 = new byte[17];
        bArr3[0] = 19;
        int i3 = ~R2.class.getName().length();
        long j2 = -419360734;
        long j3 = (i3 + (((-i3) - 1) | 1375207247)) - 1375207247;
        long j4 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
        long j5 = (j4 >>> 48) & 43690;
        long j6 = ((j5 >>> 2) | (j5 >>> 1)) & 858993459;
        long j7 = ((j6 >>> 2) | j6) & 252645135;
        long j8 = (j4 >>> 32) & 43690;
        long j9 = ((j8 >>> 2) | (j8 >>> 1)) & 858993459;
        long j10 = ((j9 >>> 2) | j9) & 252645135;
        long j11 = ((((j10 >>> 4) | j10) & 16711935) << 16) + ((((j7 >>> 4) | j7) & 16711935) << 24);
        long j12 = (j4 >>> 16) & 43690;
        long j13 = ((j12 >>> 2) | (j12 >>> 1)) & 858993459;
        long j14 = ((j13 >>> 2) | j13) & 252645135;
        long j15 = j4 & 43690;
        long j16 = ((j15 >>> 2) | (j15 >>> 1)) & 858993459;
        long j17 = ((j16 >>> 2) | j16) & 252645135;
        int i4 = (int) ((((j17 >>> 4) | j17) & 16711935) | (((((j14 >>> 4) | j14) & 16711935) << 8) + j11));
        int length2 = (R2.class.getName().length() & 1224937538) | 134351168;
        bArr3[(-285009565) ^ (((length2 | i4) - (((~i4) & R2.class.getName().length()) & length2)) + ((R2.class.getName().length() | i4) & length2))] = -47;
        bArr3[2] = -41;
        bArr3[3] = -19;
        long j18 = 1701333679;
        long j19 = ~R2.class.getName().length();
        long j20 = (((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j19 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j19 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j19 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j19 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) + 6148914691236517205L;
        long j21 = (j20 >>> 48) & 43690;
        long j22 = ((j21 >>> 2) | (j21 >>> 1)) & 858993459;
        long j23 = ((j22 >>> 2) | j22) & 252645135;
        long j24 = (j20 >>> 32) & 43690;
        long j25 = ((j24 >>> 2) | (j24 >>> 1)) & 858993459;
        long j26 = ((j25 >>> 2) | j25) & 252645135;
        long j27 = ((((j26 >>> 4) | j26) & 16711935) << 16) + ((((j23 >>> 4) | j23) & 16711935) << 24);
        long j28 = (j20 >>> 16) & 43690;
        long j29 = ((j28 >>> 2) | (j28 >>> 1)) & 858993459;
        long j30 = ((j29 >>> 2) | j29) & 252645135;
        long j31 = j20 & 43690;
        long j32 = ((j31 >>> 2) | (j31 >>> 1)) & 858993459;
        long j33 = ((j32 >>> 2) | j32) & 252645135;
        int length3 = (((int) ((((j33 >>> 4) | j33) & 16711935) | ((((j30 >>> 4) | j30) & 16711935) << 8) | j27)) & 1157685252) + ((R2.class.getName().length() & 270574080) | 270664448);
        bArr3[4] = (length3 | 1428349761) - (length3 & 1428349761);
        bArr3[5] = 13;
        bArr3[6] = -92;
        bArr3[7] = 56;
        bArr3[8] = -46;
        bArr3[9] = 1;
        bArr3[10] = -22;
        bArr3[11] = -121;
        bArr3[12] = -52;
        bArr3[13] = -61;
        bArr3[14] = 39;
        bArr3[15] = 113;
        bArr3[16] = ((((~R2.class.getName().length()) | 2136239038) & 1078216070) + ((R2.class.getName().length() & (-2054552576)) | (-1786117568))) ^ 707901528;
        e(bArr2, bArr3);
        new String(bArr2, charset).intern();
        this.f372a = z12;
        this.f373b = str;
        this.f374c = q3;
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.f375d = newSingleThreadScheduledExecutor;
        this.f376e = new ConcurrentLinkedQueue();
        newSingleThreadScheduledExecutor.scheduleAtFixedRate(new Q2(this, 0), 1L, 5L, TimeUnit.SECONDS);
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type update terminated with stack overflow, arg: (r7v34 ??), method size: 8230
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    public static void b(java.lang.String r100, java.lang.String r101, java.lang.String r102, java.lang.String r103, java.lang.String r104, java.lang.String r105) {
        /*
            Method dump skipped, instructions count: 8230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F0.R2.b(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0135. Please report as an issue. */
    public static void c(byte[] bArr, byte[] bArr2) {
        int length;
        int i;
        int length2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = ~R2.class.getName().length();
        int length3 = (((~(((R2.class.getName().length() | 70245657) | i7) - (i7 | (R2.class.getName().length() & (-70245658))))) & (-1979440632)) + ((R2.class.getName().length() & 1074528264) | 1093142560)) ^ (-886298072);
        int f4 = AbstractC0008a.f(R2.class, -1);
        int length4 = (((f4 | (-1789924155)) - ((21884101 | f4) ^ (-1811767295))) + (((R2.class.getName().length() | 1811808253) - 1811808253) | 537399298)) ^ (-1274367997);
        int length5 = ((((~R2.class.getName().length()) | (-576567005)) & 276971586) + ((R2.class.getName().length() & 36928) | 1073844225)) ^ 1350815811;
        int length6 = ((((~R2.class.getName().length()) | (-1157759625)) & 1755853004) + ((R2.class.getName().length() & 1073973402) | (-2146202606))) ^ (-390349602);
        int i8 = ((~R2.class.getName().length()) | (-529537184)) & 457019905;
        int length7 = R2.class.getName().length();
        int i9 = (-1686268015) ^ ((((454038545 & length7) ^ (-2143287920)) + (length7 & 1040)) + i8);
        int length8 = ((((~R2.class.getName().length()) | (-1064961)) + 689325073) + ((R2.class.getName().length() & (-2112862208)) | (-2109732696))) ^ (-1420407624);
        int i10 = ((~R2.class.getName().length()) | 91711000) & (-1070824876);
        int length9 = R2.class.getName().length();
        int i11 = (i10 + (9457696 | ((length9 | (-1064779676)) - (length9 ^ (-1064779676))))) ^ 1492981618;
        short[] sArr = null;
        while (true) {
            switch (i11) {
                case -2143294076:
                    int i12 = ~R2.class.getName().length();
                    if (length3 < length4) {
                        int length10 = (R2.class.getName().length() & 268439810) | 285217280;
                        int i13 = -((i12 | (-1553600102)) - (((-1553600360) | i12) ^ 536887698));
                        i5 = (((~i13) & length10) * 2) - (i13 ^ length10);
                        i6 = -1524017045;
                        i11 = i6 ^ i5;
                    } else {
                        length = ((i12 | (-747233512)) & (-1862204400)) + ((R2.class.getName().length() & 1073807362) | 1116733474);
                        i = -375509041;
                        i11 = length ^ i;
                    }
                case -2038999444:
                    int i14 = ~R2.class.getName().length();
                    int length11 = (161497089 & (((((R2.class.getName().length() & (~i14)) & 797295576) + 797295576) + i14) - ((R2.class.getName().length() | i14) & 797295576))) + ((R2.class.getName().length() & (-2145386455)) | (-2147483476));
                    int a2 = ((short) ((length5 << E1.a(length11 | (-1985986391), -1985986391, length11)) + sArr[((((~R2.class.getName().length()) | (-1085986263)) & 1078327440) + ((R2.class.getName().length() & 1612763792) | 674234944)) ^ 1752562386])) ^ (length5 + i9);
                    int i15 = ~R2.class.getName().length();
                    int length12 = length5 >>> ((((~(((R2.class.getName().length() | 626856794) | i15) - ((R2.class.getName().length() & (-626856795)) | i15))) & 957405457) + ((R2.class.getName().length() & 588787984) | 36185216)) ^ 993590676);
                    short s3 = sArr[((((~R2.class.getName().length()) | 1248713193) & 826417528) + ((R2.class.getName().length() & 822288912) | (-2138488320))) ^ (-1312070789)];
                    int i16 = -length12;
                    int i17 = i16 | s3;
                    int i18 = (i17 - (i16 * 2)) + ((i16 ^ s3) ^ i17);
                    int i19 = -B0.a(i18 | (~a2), i18 - a2);
                    length6 = (short) D.a(length6, 3, -(D1.a(length6, i19) | (i19 & 2)), 1);
                    int i20 = ((~R2.class.getName().length()) | (-549847554)) + 1624126210;
                    int length13 = (R2.class.getName().length() & 549848649) | 67175498;
                    length5 = (short) (length5 - ((((short) ((length6 << (1691301711 ^ ((length13 & i20) + (i20 | length13)))) + sArr[((((~R2.class.getName().length()) | (-1005965450)) & 153223237) + ((R2.class.getName().length() & 220201009) | 335544368)) ^ 488767605])) ^ (((i9 | length6) - ((R2.class.getName().length() & (~length6)) & i9)) + ((R2.class.getName().length() | length6) & i9))) ^ ((length6 >>> (((((~R2.class.getName().length()) | (-30261291)) & (-1534000062)) + ((R2.class.getName().length() & 8609814) | 2285588)) ^ (-1531714477))) + sArr[((((~R2.class.getName().length()) | (-23496740)) & 827084804) + ((R2.class.getName().length() & (-2117787632)) | (-2139021104))) ^ (-1311936299)])));
                    int i21 = ((~R2.class.getName().length()) | (-412319609)) & (-1959782776);
                    int length14 = (R2.class.getName().length() & 403838542) | 268582982;
                    int i22 = -i21;
                    int i23 = (((~i22) & length14) * 2) - (i22 ^ length14);
                    i9 = (short) U0.a(1691170566 & i23, (-1691170567) - i23, i9);
                    length8++;
                    length = (((~R2.class.getName().length()) | (-961655275)) & 25184460) + ((R2.class.getName().length() & 150995145) | 140771329);
                    i = 1965034008;
                    i11 = length ^ i;
                case -1809249287:
                    byte b4 = bArr[(((((~R2.class.getName().length()) | 1233459797) & 125923146) + ((R2.class.getName().length() & 774137098) | 674496513)) ^ 800419659) + length3];
                    int length15 = ((((~R2.class.getName().length()) | (-7107622)) & 402932290) + ((R2.class.getName().length() & 546586672) | 546340912)) ^ 949273229;
                    int length16 = ((R2.class.getName().length() | length15) - (b4 | length15)) + I2.a(R2.class, b4) + (R2.class.getName().length() & length15);
                    int length17 = ((((~R2.class.getName().length()) | (-81143879)) & 438583424) + ((R2.class.getName().length() & 786435) | 8921603)) ^ 447505026;
                    byte b5 = bArr[((length17 & length3) * 2) + (length17 ^ length3)];
                    int i24 = ~R2.class.getName().length();
                    length5 = (short) (((b5 & ((-1954201202) ^ ((((R2.class.getName().length() | (-2105278367)) - (i24 | (-1545180443))) + (I2.a(R2.class, 568748773 | i24) + (R2.class.getName().length() & (-2105278367)))) + ((R2.class.getName().length() & (-2097135360)) | 151077136)))) << (((((~R2.class.getName().length()) | (-1592082969)) & 140665109) + ((R2.class.getName().length() & 142103568) | 1612800)) ^ 142277917)) | length16);
                    int i25 = ~R2.class.getName().length();
                    int length18 = (-1901610175) ^ ((((((~i25) & (-569955033)) + i25) | 2038255548) - 2038255548) + ((R2.class.getName().length() & 144806464) | 136645376));
                    int i26 = -length3;
                    int i27 = i26 | length18;
                    byte b6 = bArr[(i27 - (i26 * 2)) + ((length18 ^ i26) ^ i27)];
                    int i28 = (((-199685676) | r7) - 1591672428) - ((~R2.class.getName().length()) | (-180811308));
                    int length19 = (R2.class.getName().length() & 23072776) | 272636008;
                    int length20 = b6 & ((-1319036669) ^ (((length19 | i28) - ((R2.class.getName().length() & (~i28)) & length19)) + (length19 & (i28 | R2.class.getName().length()))));
                    int i29 = ((~R2.class.getName().length()) | (-1009031633)) & 545538049;
                    int length21 = (R2.class.getName().length() & 537143360) | 10560;
                    int length22 = bArr[(545548610 ^ ((length21 & i29) + (i29 | length21))) + length3] & (((((~R2.class.getName().length()) | 75364313) & 1242301609) + ((R2.class.getName().length() & 1249907040) | (-1602217664))) ^ (-359916266));
                    int length23 = R2.class.getName().length();
                    length6 = (short) (length20 | (length22 << ((((1779401364 | (((~length23) - length23) + length23)) & 447961710) + ((R2.class.getName().length() & (-1313580806)) | (-519831408))) ^ (-71869706))));
                    int i30 = ~R2.class.getName().length();
                    i9 = 758110381 ^ (((((-1343875612) | i30) + 311432716) - (i30 | (-1074391060))) + ((R2.class.getName().length() & 273678921) | (-1069545407)));
                    int i31 = ~R2.class.getName().length();
                    int length24 = 1409942802 & (((((R2.class.getName().length() & (~i31)) & 91135407) + 91135407) + i31) - ((i31 | R2.class.getName().length()) & 91135407));
                    int length25 = (R2.class.getName().length() & (-804257776)) | (-2094006112);
                    int i32 = -length24;
                    length8 = (-684063310) ^ (((~i32) & length25) - (i32 & (~length25)));
                    length2 = (((~R2.class.getName().length()) | (-537919489)) - (-806798471)) + ((R2.class.getName().length() & 674768897) | 153626665);
                    i3 = 1174056570 - length2;
                    i4 = -1174056571;
                    i11 = ((length2 & i4) * 2) + i3;
                case -1740520186:
                    sArr = new short[((((~R2.class.getName().length()) | (-382746167)) & 102532165) + ((R2.class.getName().length() & 105907748) | 4198960)) ^ 106731121];
                    length3 = ((((~R2.class.getName().length()) | (-6036961)) & 1233145505) + ((R2.class.getName().length() & 809508000) | 809603328)) ^ 2042748833;
                    int i33 = ((~R2.class.getName().length()) | 1688058452) & 872484865;
                    int length26 = R2.class.getName().length() & 268460041;
                    i5 = (((((R2.class.getName().length() & (~length26)) & 4218888) + 4218888) + length26) - ((length26 | R2.class.getName().length()) & 4218888)) + i33;
                    i6 = 434661073;
                    i11 = i6 ^ i5;
                case -1489518479:
                    int length27 = R2.class.getName().length();
                    int length28 = (((-2053077912) & ((516782023 - length27) + (((-((-1) - length27)) - 1) | (-516782024)))) + ((R2.class.getName().length() & (-1054752728)) | 1073823745)) ^ (-979254165);
                    int length29 = bArr2[(((~length3) & length28) * ((~length28) & length3)) + ((length28 & length3) * (length28 | length3))] & (((((~R2.class.getName().length()) | (-1883938358)) & (-738125179)) + ((R2.class.getName().length() & 1343232517) | 546308360)) ^ (-191816846));
                    int i34 = ~R2.class.getName().length();
                    int i35 = 73539736 & (((~i34) & (-1772650326)) + i34);
                    int length30 = (R2.class.getName().length() & 35664144) | 33608448;
                    int i36 = -i35;
                    byte b7 = bArr2[((107148186 ^ ((((~i36) & length30) * 2) - (i36 ^ length30))) * length3) + ((((I2.a(R2.class, -1) | (-532481)) - (-67641369)) + ((R2.class.getName().length() & 532546) | 1602)) ^ 67642971)];
                    int i37 = ~R2.class.getName().length();
                    int length31 = (b7 & (((663757504 & ((i37 + 1314070430) - (i37 & 1314070430))) + ((R2.class.getName().length() & 834674756) | 272630796)) ^ 936388147)) << ((((I2.a(R2.class, -1) | (-33554434)) - (-1107366402)) + ((R2.class.getName().length() & (-2113929151)) | (-2147475136))) ^ (-1040108727));
                    sArr[length3] = (short) ((length31 ^ length29) + (length29 & length31));
                    length3++;
                    length = ((I2.a(R2.class, -1) | (-167014194)) & 1157999680) + ((R2.class.getName().length() & 159661328) | (-2004872944));
                    i = -533943416;
                    i11 = length ^ i;
                case -473033593:
                    int i38 = -length3;
                    int i39 = -bArr.length;
                    int i40 = i39 | i38;
                    int i41 = (i40 - (i39 * 2)) + ((i39 ^ i38) ^ i40);
                    byte b8 = bArr[bArr.length - length3];
                    int length32 = R2.class.getName().length();
                    bArr[i41] = (byte) (b8 ^ bArr2[length3 % (((((-878819395) | ((length32 - 1) - (length32 * 2))) & 1490255976) + ((R2.class.getName().length() & 274827331) | 556017667)) ^ 2046273635)]);
                    length3--;
                    int f5 = (AbstractC0008a.f(R2.class, -1) | 114408723) & 1183666176;
                    int length33 = R2.class.getName().length() & 1074544770;
                    length = S.a(length33, (-268567684) | ((-length33) - 1), 268567684, f5);
                    i = 836032333;
                    i11 = length ^ i;
                case 766056152:
                    int i42 = ((~R2.class.getName().length()) | (-889871025)) & 1233748555;
                    int length34 = R2.class.getName().length();
                    int i43 = (length34 + 84675108) - (length34 | 84675108);
                    if (length3 < (1842188139 ^ ((((~i43) & 608439588) + i43) + i42))) {
                        int i44 = ((~R2.class.getName().length()) | 1878725846) & 1912684595;
                        int length35 = (R2.class.getName().length() & 268589089) | 661640;
                        length = AbstractC0099x.a(i44 | length35, 2, (~i44) ^ length35);
                        i = -717449014;
                    } else {
                        length = (((~R2.class.getName().length()) | (-1477955618)) & (-1604246503)) + ((R2.class.getName().length() & 1074350177) | 1342720098);
                        i = -887872332;
                    }
                    i11 = length ^ i;
                case 974072829:
                    int length36 = bArr.length;
                    int i45 = ((~R2.class.getName().length()) | 1711185063) & 170281206;
                    int length37 = (R2.class.getName().length() & 251684176) | 1694512896;
                    int i46 = -i45;
                    length3 = length36 % (1864794098 ^ (((~i46) & length37) - (i46 & (~length37))));
                    length = (((~R2.class.getName().length()) | 991120067) & (-2113137661)) + ((R2.class.getName().length() & (-1878240248)) | 285229064);
                    i = -195569723;
                    i11 = length ^ i;
                case 998066383:
                    length3 = (((AbstractC0008a.f(R2.class, -1) | 314136709) & 371231304) + (((R2.class.getName().length() | (-67142233)) + 67142233) | (-1996488432))) ^ (-1625257128);
                    length4 = bArr.length - (bArr.length % (((((~R2.class.getName().length()) | 366661365) & 1344150018) + ((R2.class.getName().length() & (-1006333853)) | (-2080341919))) ^ (-736191897)));
                    length = (((~R2.class.getName().length()) | (-1359635359)) & 49026131) + ((R2.class.getName().length() & (-1860698094)) | (-1190123008));
                    i = 1002689495;
                    i11 = length ^ i;
                case 1314339506:
                    break;
                case 1734050766:
                    int i47 = ~R2.class.getName().length();
                    if (length3 > 0) {
                        int length38 = R2.class.getName().length();
                        length = ((i47 | (-268772210)) & 282132586) + (168323072 | ((length38 + 402735200) - (length38 | 402735200)));
                        i = -115901203;
                        i11 = length ^ i;
                    } else {
                        int length39 = (R2.class.getName().length() & R.^attr-private.__removed0) | 553664516;
                        int i48 = -((i47 | 1510858717) & 403833600);
                        i5 = ((~i48) & length39) - (i48 & (~length39));
                        i6 = 2001041846;
                        i11 = i6 ^ i5;
                    }
                case 1771480224:
                    bArr[(((((~R2.class.getName().length()) | 1110430873) & 1241612298) + ((R2.class.getName().length() & 150996226) | 84419840)) ^ 1326032138) + length3] = (byte) ((((((~R2.class.getName().length()) | 1603962366) & 25199440) + (((R2.class.getName().length() | (-1311235)) + 1311235) | (-2146172766))) ^ (-2120973555)) & length5);
                    int length40 = (((((~R2.class.getName().length()) | (-1388708984)) & 706816128) + ((R2.class.getName().length() & 1124204552) | 1363312648)) ^ 2070128777) + length3;
                    int i49 = ((~R2.class.getName().length()) | 367288948) & 548745488;
                    int length41 = R2.class.getName().length();
                    bArr[length40] = (byte) ((length5 >> ((i49 + (21135364 | ((length41 + 558960896) - (length41 | 558960896)))) ^ 569880860)) & (((((~R2.class.getName().length()) | 2113158628) & 1026558002) + ((R2.class.getName().length() & 8392730) | 8525645)) ^ 1035083648));
                    int length42 = (((~R2.class.getName().length()) | 715175224) & 136512788) + ((R2.class.getName().length() & 196644) | (-2146430752));
                    int a4 = AbstractC0105y1.a((~length42) | (-2009917962), (-2009917962) - length42, length3);
                    int i50 = ((~R2.class.getName().length()) | (-1010633609)) & 678986012;
                    int length43 = R2.class.getName().length();
                    int i51 = ~(((951583497 & length43) + 276825601) - (length43 & 276824577));
                    int i52 = -i50;
                    bArr[a4] = (byte) ((V2.a(~i52, i51, (i51 + i52) + 1) ^ 955811810) & length6);
                    int length44 = (((((~R2.class.getName().length()) | (-1084937228)) & 438503696) + ((R2.class.getName().length() & 69369860) | (-2080078843))) ^ (-1641575146)) + length3;
                    int i53 = ~R2.class.getName().length();
                    int length45 = length6 >> (2092810490 ^ ((((R2.class.getName().length() | 674349280) - (i53 | 1869872636)) + (AbstractC0008a.f(R2.class, 1197735420 | i53) + (R2.class.getName().length() & 674349280))) + ((R2.class.getName().length() & 1754529808) | 1418461202)));
                    int i54 = ((~R2.class.getName().length()) | 1601418652) & 1439188132;
                    int length46 = (R2.class.getName().length() & 545800290) | (-1442676670);
                    int i55 = -i54;
                    bArr[length44] = (byte) (length45 & ((-3488743) ^ (((~i55) & length46) - (i55 & (~length46)))));
                    length3 += 4;
                    length = (((~R2.class.getName().length()) | (-171976913)) & 318775824) + ((R2.class.getName().length() & 33562640) | 136194);
                    i = -1824662634;
                    i11 = length ^ i;
                case 2093236949:
                    if (length8 < (((((~R2.class.getName().length()) | (-616910267)) & 1303391760) + ((R2.class.getName().length() & 75500825) | 537198861)) ^ 1840590653)) {
                        length2 = (((~R2.class.getName().length()) | 1297715640) & 556926729) + ((R2.class.getName().length() & 874653185) | 335552516);
                        i3 = (-1287294623) - length2;
                        i4 = 1287294622;
                        i11 = ((length2 & i4) * 2) + i3;
                    } else {
                        int i56 = ~R2.class.getName().length();
                        length = (1141965102 & ((-1207265904) + i56 + (((-i56) - 1) | 1207265904))) + ((R2.class.getName().length() & 1292960864) | 150996032);
                        i = 612868558;
                        i11 = length ^ i;
                    }
                default:
                    int i57 = ~R2.class.getName().length();
                    int i58 = (((-313266948) | i57) + 45165696) - (i57 | (-269226756));
                    length = D.a(i58, 3, -D1.a(i58, (R2.class.getName().length() & 44040224) | (-1811807712)), 1);
                    i = -361272203;
                    i11 = length ^ i;
            }
            return;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x003f. Please report as an issue. */
    public static void e(byte[] bArr, byte[] bArr2) {
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

    public void a(String str) {
        char c4 = 58046;
        char c5 = 58046;
        String str2 = null;
        while (true) {
            if (c5 == c4) {
                byte[] H3 = N2.n.H(str);
                try {
                    int i = ((~R2.class.getName().length()) | 437192814) & (-1576861682);
                    int length = R2.class.getName().length();
                    long j2 = 351338371;
                    long j3 = i + (((length | (-519569407)) - (length ^ (-519569407))) | 1225523201);
                    long j4 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                    long j5 = (j4 >>> 48) & 21845;
                    long j6 = ((j5 >>> 1) | j5) & 858993459;
                    long j7 = ((j6 >>> 2) | j6) & 252645135;
                    long j8 = (j4 >>> 32) & 21845;
                    long j9 = ((j8 >>> 1) | j8) & 858993459;
                    long j10 = ((j9 >>> 2) | j9) & 252645135;
                    long j11 = ((((j10 >>> 4) | j10) & 16711935) << 16) | ((((j7 >>> 4) | j7) & 16711935) << 24);
                    long j12 = (j4 >>> 16) & 21845;
                    long j13 = ((j12 >>> 1) | j12) & 858993459;
                    long j14 = ((j13 >>> 2) | j13) & 252645135;
                    long j15 = j4 & 21845;
                    long j16 = ((j15 >>> 1) | j15) & 858993459;
                    long j17 = ((j16 >>> 2) | j16) & 252645135;
                    byte[] bArr = {46, (int) ((((j17 >>> 4) | j17) & 16711935) + (((((j14 >>> 4) | j14) & 16711935) << 8) | j11)), -64, -3, -55, -61, 106};
                    c(bArr, new byte[]{-30, 92, -10, -5, -68, -70, -111, ((((~R2.class.getName().length()) | (-978025753)) & (-1003994522)) + ((R2.class.getName().length() & 973890560) | 977544200)) ^ (-26450402)});
                    str2 = Base64.encodeToString(MessageDigest.getInstance(new String(bArr, StandardCharsets.UTF_8).intern()).digest(H3), 2);
                } catch (Exception unused) {
                    byte[] bArr2 = {-98, -61, -78};
                    byte[] bArr3 = new byte[8];
                    bArr3[0] = 86;
                    bArr3[1] = -11;
                    bArr3[2] = -116;
                    bArr3[3] = -46;
                    bArr3[4] = -52;
                    bArr3[((((~R2.class.getName().length()) | 89738000) & 100796872) + ((R2.class.getName().length() & 33685720) | 545292304)) ^ 646089181] = ((((~R2.class.getName().length()) | 866208290) & 588460068) + ((R2.class.getName().length() & 3289094) | 6292738)) ^ 594752847;
                    bArr3[6] = 66;
                    bArr3[7] = -115;
                    c(bArr2, bArr3);
                    Charset charset = StandardCharsets.UTF_8;
                    new String(bArr2, charset).intern();
                    byte[] bArr4 = new byte[47];
                    bArr4[0] = -97;
                    bArr4[1] = 0;
                    bArr4[2] = -93;
                    bArr4[3] = 24;
                    bArr4[4] = -71;
                    bArr4[5] = 73;
                    bArr4[6] = 114;
                    int i3 = ((~R2.class.getName().length()) | (-34603013)) + 51380486;
                    long j18 = 101779460;
                    long length2 = R2.class.getName().length();
                    long j19 = ((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((length2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                    long j20 = (j19 >>> 48) & 43690;
                    long j21 = ((j20 >>> 2) | (j20 >>> 1)) & 858993459;
                    long j22 = ((j21 >>> 2) | j21) & 252645135;
                    long j23 = (j19 >>> 32) & 43690;
                    long j24 = ((j23 >>> 2) | (j23 >>> 1)) & 858993459;
                    long j25 = ((j24 >>> 2) | j24) & 252645135;
                    long j26 = ((((j25 >>> 4) | j25) & 16711935) << 16) | ((((j22 >>> 4) | j22) & 16711935) << 24);
                    long j27 = (j19 >>> 16) & 43690;
                    long j28 = ((j27 >>> 2) | (j27 >>> 1)) & 858993459;
                    long j29 = ((j28 >>> 2) | j28) & 252645135;
                    long j30 = j19 & 43690;
                    long j31 = ((j30 >>> 2) | (j30 >>> 1)) & 858993459;
                    long j32 = ((j31 >>> 2) | j31) & 252645135;
                    bArr4[(i3 + (((int) ((((((j29 >>> 4) | j29) & 16711935) << 8) | j26) | (((j32 >>> 4) | j32) & 16711935))) | 67307520)) ^ 118688002] = 49;
                    bArr4[8] = 85;
                    bArr4[9] = 68;
                    bArr4[10] = -10;
                    bArr4[11] = 40;
                    bArr4[12] = 16;
                    int i4 = ((~R2.class.getName().length()) | (-125851716)) & 1741693072;
                    int length3 = R2.class.getName().length();
                    bArr4[(i4 + ((((R2.class.getName().length() | 396382208) - (length3 | 396382208)) + (AbstractC0008a.f(R2.class, length3) + (R2.class.getName().length() & 396382208))) | 270684264)) ^ 2012377333] = -109;
                    bArr4[14] = -113;
                    bArr4[15] = -50;
                    bArr4[16] = -18;
                    bArr4[17] = 125;
                    bArr4[18] = 120;
                    bArr4[19] = -84;
                    bArr4[20] = 30;
                    bArr4[21] = -13;
                    bArr4[22] = -11;
                    bArr4[23] = 4;
                    bArr4[24] = -12;
                    bArr4[25] = 83;
                    bArr4[26] = -25;
                    bArr4[27] = 71;
                    int i5 = ((~R2.class.getName().length()) | (-524545)) - 2146664190;
                    long j33 = 67698944;
                    long length4 = R2.class.getName().length();
                    long j34 = ((((((((j33 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j33 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j33 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j33 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((length4 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length4 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length4 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length4 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                    long j35 = (j34 >>> 48) & 43690;
                    long j36 = ((j35 >>> 2) | (j35 >>> 1)) & 858993459;
                    long j37 = ((j36 >>> 2) | j36) & 252645135;
                    long j38 = (j34 >>> 32) & 43690;
                    long j39 = ((j38 >>> 2) | (j38 >>> 1)) & 858993459;
                    long j40 = ((j39 >>> 2) | j39) & 252645135;
                    long j41 = ((((j40 >>> 4) | j40) & 16711935) << 16) + ((((j37 >>> 4) | j37) & 16711935) << 24);
                    long j42 = (j34 >>> 16) & 43690;
                    long j43 = ((j42 >>> 2) | (j42 >>> 1)) & 858993459;
                    long j44 = ((j43 >>> 2) | j43) & 252645135;
                    long j45 = j34 & 43690;
                    long j46 = ((j45 >>> 2) | (j45 >>> 1)) & 858993459;
                    long j47 = ((j46 >>> 2) | j46) & 252645135;
                    int i6 = i5 + (((int) ((((j47 >>> 4) | j47) & 16711935) | (((((j44 >>> 4) | j44) & 16711935) << 8) + j41))) | 71389184);
                    bArr4[(((~i6) & (-2075274979)) - ((-2075274979) & i6)) + i6] = 39;
                    int i7 = ((~R2.class.getName().length()) | (-25183233)) - (-1098925083);
                    int length5 = (R2.class.getName().length() & 58737796) | 33558660;
                    int i8 = -i7;
                    int i9 = (length5 ^ i8) - ((i8 & (~length5)) * 2);
                    bArr4[29] = (1132483731 | i9) - (1132483731 & i9);
                    bArr4[30] = 25;
                    bArr4[31] = 71;
                    bArr4[32] = -19;
                    bArr4[33] = -126;
                    bArr4[34] = -74;
                    bArr4[35] = 71;
                    bArr4[36] = -55;
                    bArr4[37] = -65;
                    bArr4[38] = -13;
                    bArr4[39] = 11;
                    int i10 = ((~R2.class.getName().length()) | 800490906) & 1529872384;
                    int length6 = R2.class.getName().length();
                    bArr4[40] = (i10 + ((((R2.class.getName().length() | 1342177420) - (length6 | 1342177420)) + (AbstractC0008a.f(R2.class, length6) + (R2.class.getName().length() & 1342177420))) | 10444)) ^ 1529882847;
                    bArr4[41] = -24;
                    bArr4[42] = -63;
                    bArr4[43] = -32;
                    bArr4[44] = -87;
                    bArr4[45] = 109;
                    bArr4[46] = -79;
                    byte[] bArr5 = new byte[47];
                    bArr5[0] = -13;
                    bArr5[1] = -97;
                    bArr5[2] = 10;
                    bArr5[3] = -58;
                    bArr5[4] = -126;
                    bArr5[5] = 126;
                    bArr5[6] = -29;
                    bArr5[7] = -23;
                    long j48 = -6863789;
                    long j49 = ~R2.class.getName().length();
                    long j50 = (((((((((j48 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j48 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j48 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j48 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((j49 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j49 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j49 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j49 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
                    long j51 = (j50 >>> 48) & 43690;
                    long j52 = ((j51 >>> 2) | (j51 >>> 1)) & 858993459;
                    long j53 = ((j52 >>> 2) | j52) & 252645135;
                    long j54 = (j50 >>> 32) & 43690;
                    long j55 = ((j54 >>> 2) | (j54 >>> 1)) & 858993459;
                    long j56 = ((j55 >>> 2) | j55) & 252645135;
                    long j57 = ((((j56 >>> 4) | j56) & 16711935) << 16) + ((((j53 >>> 4) | j53) & 16711935) << 24);
                    long j58 = (j50 >>> 16) & 43690;
                    long j59 = ((j58 >>> 2) | (j58 >>> 1)) & 858993459;
                    long j60 = ((j59 >>> 2) | j59) & 252645135;
                    long j61 = j50 & 43690;
                    long j62 = ((j61 >>> 2) | (j61 >>> 1)) & 858993459;
                    long j63 = ((j62 >>> 2) | j62) & 252645135;
                    bArr5[((((int) ((((j63 >>> 4) | j63) & 16711935) + (((((j60 >>> 4) | j60) & 16711935) << 8) + j57))) & 1309820448) + ((R2.class.getName().length() & (-2122053088)) | (-2119948032))) ^ (-810127576)] = -89;
                    bArr5[9] = -30;
                    bArr5[10] = -50;
                    bArr5[11] = 20;
                    bArr5[12] = 57;
                    bArr5[13] = -49;
                    bArr5[14] = -45;
                    bArr5[15] = -109;
                    bArr5[16] = -18;
                    bArr5[17] = 29;
                    long j64 = -1;
                    long length7 = R2.class.getName().length();
                    long j65 = ((((((((j64 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j64 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j64 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j64 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((length7 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length7 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length7 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length7 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                    long j66 = (j65 >>> 48) & 21845;
                    long j67 = ((j66 >>> 1) | j66) & 858993459;
                    long j68 = ((j67 >>> 2) | j67) & 252645135;
                    long j69 = (j65 >>> 32) & 21845;
                    long j70 = ((j69 >>> 1) | j69) & 858993459;
                    long j71 = ((j70 >>> 2) | j70) & 252645135;
                    long j72 = ((((j71 >>> 4) | j71) & 16711935) << 16) | ((((j68 >>> 4) | j68) & 16711935) << 24);
                    long j73 = (j65 >>> 16) & 21845;
                    long j74 = ((j73 >>> 1) | j73) & 858993459;
                    long j75 = ((j74 >>> 2) | j74) & 252645135;
                    long j76 = j65 & 21845;
                    long j77 = ((j76 >>> 1) | j76) & 858993459;
                    long j78 = ((j77 >>> 2) | j77) & 252645135;
                    long j79 = -1884820739;
                    long j80 = (int) ((((j78 >>> 4) | j78) & 16711935) + (((((j75 >>> 4) | j75) & 16711935) << 8) | j72));
                    long j81 = (((((((((j79 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j79 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j79 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j79 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j80 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j80 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j80 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j80 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + 6148914691236517205L;
                    long j82 = (j81 >>> 48) & 43690;
                    long j83 = ((j82 >>> 2) | (j82 >>> 1)) & 858993459;
                    long j84 = ((j83 >>> 2) | j83) & 252645135;
                    long j85 = (j81 >>> 32) & 43690;
                    long j86 = ((j85 >>> 2) | (j85 >>> 1)) & 858993459;
                    long j87 = ((j86 >>> 2) | j86) & 252645135;
                    long j88 = ((((j87 >>> 4) | j87) & 16711935) << 16) + ((((j84 >>> 4) | j84) & 16711935) << 24);
                    long j89 = (j81 >>> 16) & 43690;
                    long j90 = ((j89 >>> 2) | (j89 >>> 1)) & 858993459;
                    long j91 = ((j90 >>> 2) | j90) & 252645135;
                    long j92 = j81 & 43690;
                    long j93 = ((j92 >>> 2) | (j92 >>> 1)) & 858993459;
                    long j94 = ((j93 >>> 2) | j93) & 252645135;
                    int length8 = R2.class.getName().length();
                    bArr5[681996387 ^ ((((int) ((((j94 >>> 4) | j94) & 16711935) | (((((j91 >>> 4) | j91) & 16711935) << 8) | j88))) & 673464368) + (8532033 | ((545263617 | length8) - (length8 ^ 545263617))))] = 96;
                    bArr5[19] = -123;
                    bArr5[20] = 40;
                    bArr5[21] = -33;
                    bArr5[22] = -107;
                    bArr5[23] = 37;
                    bArr5[24] = 97;
                    bArr5[25] = -74;
                    bArr5[26] = 47;
                    bArr5[27] = -87;
                    bArr5[28] = -117;
                    bArr5[29] = 10;
                    bArr5[30] = -25;
                    bArr5[31] = -29;
                    bArr5[32] = -52;
                    bArr5[33] = -24;
                    bArr5[34] = 3;
                    bArr5[35] = -55;
                    bArr5[36] = -81;
                    bArr5[37] = -83;
                    bArr5[38] = 67;
                    bArr5[39] = -73;
                    bArr5[40] = -40;
                    bArr5[41] = 10;
                    bArr5[42] = 43;
                    bArr5[43] = -26;
                    bArr5[44] = -55;
                    bArr5[45] = 95;
                    bArr5[46] = -53;
                    c(bArr4, bArr5);
                    new String(bArr4, charset).intern();
                    str2 = null;
                }
                if (str2 == null) {
                    c4 = 58046;
                    c5 = 61353;
                }
            } else {
                if (c5 == 61353) {
                    return;
                }
                if (c5 == 56664) {
                    ((Q) this.f374c).getClass();
                    byte[] bArr6 = new byte[5];
                    int i11 = ((~Q.class.getName().length()) | 514043799) & 35867649;
                    long j95 = 269488844;
                    long length9 = Q.class.getName().length() & 21004;
                    long j96 = (((((((((j95 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j95 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j95 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j95 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((length9 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length9 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length9 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length9 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
                    long j97 = (j96 >>> 48) & 43690;
                    long j98 = ((j97 >>> 2) | (j97 >>> 1)) & 858993459;
                    long j99 = ((j98 >>> 2) | j98) & 252645135;
                    long j100 = (j96 >>> 32) & 43690;
                    long j101 = ((j100 >>> 2) | (j100 >>> 1)) & 858993459;
                    long j102 = ((j101 >>> 2) | j101) & 252645135;
                    long j103 = ((((j102 >>> 4) | j102) & 16711935) << 16) | ((((j99 >>> 4) | j99) & 16711935) << 24);
                    long j104 = (j96 >>> 16) & 43690;
                    long j105 = ((j104 >>> 2) | (j104 >>> 1)) & 858993459;
                    long j106 = ((j105 >>> 2) | j105) & 252645135;
                    long j107 = j96 & 43690;
                    long j108 = ((j107 >>> 2) | (j107 >>> 1)) & 858993459;
                    long j109 = (j108 | (j108 >>> 2)) & 252645135;
                    int i12 = i11 + ((int) (((j109 | (j109 >>> 4)) & 16711935) | (((((j106 >>> 4) | j106) & 16711935) << 8) + j103)));
                    bArr6[(i12 + 305356493) - ((i12 & 305356493) * 2)] = -9;
                    bArr6[1] = -94;
                    bArr6[2] = 33;
                    bArr6[3] = -127;
                    bArr6[4] = 51;
                    int length10 = ((((-1790279297) | r5) - 1165557719) - ((~Q.class.getName().length()) | (-1076919937))) + ((Q.class.getName().length() & 713359872) | 68682306);
                    Q.e(bArr6, new byte[]{-103, -51, 79, -30, 86, 13, ((1096875458 & length10) * 2) + ((-1096875459) - length10), 88});
                    kotlin.jvm.internal.j.e(str2, new String(bArr6, StandardCharsets.UTF_8).intern());
                    return;
                }
            }
            c4 = 58046;
            c5 = 56664;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x005a. Please report as an issue. */
    public void d(k3 k3Var, String str) {
        String str2;
        String str3;
        Object b4;
        String jSONObject;
        char c4 = 60866;
        Object obj = null;
        String str4 = null;
        String str5 = null;
        while (true) {
            String str6 = null;
            while (true) {
                switch (c4) {
                    case 60866:
                        String str7 = str4;
                        str2 = str6;
                        long j2 = 1707114504;
                        long j3 = (~R2.class.getName().length()) | (-508386852);
                        long j4 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                        long j5 = (j4 >>> 48) & 43690;
                        long j6 = ((j5 >>> 2) | (j5 >>> 1)) & 858993459;
                        long j7 = ((j6 >>> 2) | j6) & 252645135;
                        long j8 = (j4 >>> 32) & 43690;
                        long j9 = ((j8 >>> 2) | (j8 >>> 1)) & 858993459;
                        long j10 = ((j9 >>> 2) | j9) & 252645135;
                        long j11 = ((((j10 >>> 4) | j10) & 16711935) << 16) | ((((j7 >>> 4) | j7) & 16711935) << 24);
                        long j12 = (j4 >>> 16) & 43690;
                        long j13 = ((j12 >>> 2) | (j12 >>> 1)) & 858993459;
                        long j14 = ((j13 >>> 2) | j13) & 252645135;
                        long j15 = j4 & 43690;
                        long j16 = ((j15 >>> 2) | (j15 >>> 1)) & 858993459;
                        long j17 = ((j16 >>> 2) | j16) & 252645135;
                        int length = ((int) (((((j14 >>> 4) | j14) & 16711935) << 8) | j11 | (((j17 >>> 4) | j17) & 16711935))) + ((R2.class.getName().length() & 71315456) | 33566741);
                        byte[] bArr = {-123, (length - 1740681343) - ((length & (-1740681343)) * 2), -101, -48, 60, -72, -2};
                        byte[] bArr2 = new byte[8];
                        bArr2[0] = 44;
                        bArr2[1] = -118;
                        long j18 = -1533061667;
                        long a2 = I2.a(R2.class, -1);
                        long j19 = (((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((a2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((a2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((a2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((a2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
                        long j20 = (j19 >>> 48) & 43690;
                        long j21 = ((j20 >>> 2) | (j20 >>> 1)) & 858993459;
                        long j22 = ((j21 >>> 2) | j21) & 252645135;
                        long j23 = (j19 >>> 32) & 43690;
                        long j24 = ((j23 >>> 2) | (j23 >>> 1)) & 858993459;
                        long j25 = ((j24 >>> 2) | j24) & 252645135;
                        long j26 = ((((j25 >>> 4) | j25) & 16711935) << 16) | ((((j22 >>> 4) | j22) & 16711935) << 24);
                        long j27 = (j19 >>> 16) & 43690;
                        long j28 = ((j27 >>> 2) | (j27 >>> 1)) & 858993459;
                        long j29 = ((j28 >>> 2) | j28) & 252645135;
                        long j30 = j19 & 43690;
                        long j31 = ((j30 >>> 2) | (j30 >>> 1)) & 858993459;
                        long j32 = ((j31 >>> 2) | j31) & 252645135;
                        int i = (int) ((((j32 >>> 4) | j32) & 16711935) + (((((j29 >>> 4) | j29) & 16711935) << 8) | j26));
                        long j33 = 4870441;
                        long j34 = i;
                        long j35 = ((((((((j33 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j33 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j33 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j33 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j34 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j34 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j34 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j34 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                        long j36 = (j35 >>> 48) & 43690;
                        long j37 = ((j36 >>> 2) | (j36 >>> 1)) & 858993459;
                        long j38 = ((j37 >>> 2) | j37) & 252645135;
                        long j39 = (j35 >>> 32) & 43690;
                        long j40 = ((j39 >>> 2) | (j39 >>> 1)) & 858993459;
                        long j41 = ((j40 >>> 2) | j40) & 252645135;
                        long j42 = ((((j41 >>> 4) | j41) & 16711935) << 16) | ((((j38 >>> 4) | j38) & 16711935) << 24);
                        long j43 = (j35 >>> 16) & 43690;
                        long j44 = ((j43 >>> 2) | (j43 >>> 1)) & 858993459;
                        long j45 = ((j44 >>> 2) | j44) & 252645135;
                        long j46 = j35 & 43690;
                        long j47 = ((j46 >>> 2) | (j46 >>> 1)) & 858993459;
                        long j48 = (j47 | (j47 >>> 2)) & 252645135;
                        int i3 = (int) (((j48 | (j48 >>> 4)) & 16711935) + ((((j45 >>> 4) | j45) & 16711935) << 8) + j42);
                        int length2 = R2.class.getName().length() & 37748770;
                        bArr2[1649040745 ^ ((((((R2.class.getName().length() & (~length2)) & 1644170306) + 1644170306) + length2) - ((length2 | R2.class.getName().length()) & 1644170306)) + i3)] = -53;
                        bArr2[3] = 89;
                        bArr2[4] = -96;
                        bArr2[5] = 29;
                        bArr2[6] = -56;
                        bArr2[7] = -20;
                        c(bArr, bArr2);
                        kotlin.jvm.internal.j.e(k3Var, new String(bArr, StandardCharsets.UTF_8).intern());
                        str4 = str7;
                        c4 = 62370;
                        str6 = str2;
                    case 30824:
                        str4 = str4;
                        c4 = 34462;
                    case 62128:
                        str3 = str4;
                        str2 = str6;
                        a(str3);
                        byte[] bArr3 = new byte[11];
                        bArr3[0] = -19;
                        bArr3[1] = 1;
                        bArr3[2] = -5;
                        bArr3[((((~R2.class.getName().length()) | (-241587791)) & 1611712600) + ((R2.class.getName().length() & 16584) | 67903618)) ^ 1679616217] = -72;
                        bArr3[4] = -38;
                        bArr3[5] = -118;
                        bArr3[6] = -18;
                        bArr3[7] = -26;
                        bArr3[8] = 4;
                        bArr3[9] = -105;
                        bArr3[10] = -104;
                        byte[] bArr4 = new byte[11];
                        bArr4[0] = 40;
                        bArr4[1] = -72;
                        bArr4[2] = -83;
                        bArr4[3] = 112;
                        bArr4[4] = ((((-1257006202) | ((-1) - R2.class.getName().length())) & 17304747) + ((R2.class.getName().length() & 35136553) | 38805520)) ^ (-56110227);
                        bArr4[5] = 94;
                        bArr4[((((~R2.class.getName().length()) | (-2115846113)) & 306194965) + ((R2.class.getName().length() & 304167424) | 2166816)) ^ 308361779] = 72;
                        bArr4[7] = 71;
                        bArr4[(((1623996335 | ((-1) - R2.class.getName().length())) & 542146882) + ((R2.class.getName().length() & 1081440) | 525472)) ^ 542672362] = -80;
                        bArr4[9] = -46;
                        long j49 = -1;
                        long length3 = R2.class.getName().length();
                        long j50 = (((((((((j49 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j49 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j49 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j49 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + ((((((((length3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((length3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                        long j51 = (j50 >>> 48) & 21845;
                        long j52 = (j51 | (j51 >>> 1)) & 858993459;
                        long j53 = (j52 | (j52 >>> 2)) & 252645135;
                        long j54 = (j50 >>> 32) & 21845;
                        long j55 = ((j54 >>> 1) | j54) & 858993459;
                        long j56 = ((j55 >>> 2) | j55) & 252645135;
                        long j57 = (((j53 | (j53 >>> 4)) & 16711935) << 24) | ((((j56 >>> 4) | j56) & 16711935) << 16);
                        long j58 = (j50 >>> 16) & 21845;
                        long j59 = ((j58 >>> 1) | j58) & 858993459;
                        long j60 = ((j59 >>> 2) | j59) & 252645135;
                        long j61 = j50 & 21845;
                        long j62 = (j61 | (j61 >>> 1)) & 858993459;
                        long j63 = (j62 | (j62 >>> 2)) & 252645135;
                        bArr4[(((((int) (((j63 | (j63 >>> 4)) & 16711935) + (((((j60 >>> 4) | j60) & 16711935) << 8) + j57))) | (-713222037)) & 273186819) + ((R2.class.getName().length() & 33783936) | 42139784)) ^ 315326593] = -107;
                        c(bArr3, bArr4);
                        String intern = new String(bArr3, StandardCharsets.UTF_8).intern();
                        StringBuilder sb = new StringBuilder();
                        sb.append(intern);
                        try {
                            sb.append((String) null);
                            str6 = sb.toString();
                            str4 = str3;
                            c4 = 30723;
                        } catch (JSONException e4) {
                            e = e4;
                            obj = e;
                            c4 = 61762;
                            str4 = str3;
                            str6 = str2;
                        }
                    case 61762:
                        obj = (JSONException) obj;
                        c4 = 30824;
                    case 43566:
                        str3 = str4;
                        str2 = str6;
                        ((C0043i2) obj).getClass();
                        c4 = 968;
                        str4 = str3;
                        str6 = str2;
                    case 48728:
                        String str8 = str4;
                        String str9 = str6;
                        String b5 = ((C0043i2) obj).b();
                        ((C0043i2) obj).getClass();
                        b(str8, b5, str5, (String) this.f373b, k3Var.d(), str);
                        str4 = str8;
                        str6 = str9;
                        c4 = 34462;
                    case 30723:
                        c4 = 48728;
                        str5 = str6;
                        str6 = str5;
                    case 62370:
                        try {
                            b4 = ((C0051k2) ((Z1) this.f372a)).b();
                            jSONObject = k3Var.a().toString();
                            byte[] bArr5 = new byte[13];
                            bArr5[0] = 102;
                            str2 = str6;
                            long j64 = -1;
                            long length4 = R2.class.getName().length();
                            long j65 = (((((j64 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                            long j66 = (((((((j64 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                            long j67 = (((((((j64 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                            long j68 = (((((((j64 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                            long j69 = j68 + j67 + j66 + j65 + (((((((((length4 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length4 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length4 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length4 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                            long j70 = (j69 >>> 48) & 21845;
                            long j71 = ((j70 >>> 1) | j70) & 858993459;
                            long j72 = ((j71 >>> 2) | j71) & 252645135;
                            long j73 = (j69 >>> 32) & 21845;
                            long j74 = ((j73 >>> 1) | j73) & 858993459;
                            long j75 = ((j74 >>> 2) | j74) & 252645135;
                            long j76 = ((((j75 >>> 4) | j75) & 16711935) << 16) | ((((j72 >>> 4) | j72) & 16711935) << 24);
                            long j77 = (j69 >>> 16) & 21845;
                            long j78 = ((j77 >>> 1) | j77) & 858993459;
                            long j79 = ((j78 >>> 2) | j78) & 252645135;
                            long j80 = ((((j79 >>> 4) | j79) & 16711935) << 8) + j76;
                            long j81 = j69 & 21845;
                            long j82 = ((j81 >>> 1) | j81) & 858993459;
                            long j83 = ((j82 >>> 2) | j82) & 252645135;
                            int i4 = (((int) ((((j83 >>> 4) | j83) & 16711935) | j80)) | 782908744) & 1118093;
                            try {
                                int length5 = R2.class.getName().length();
                                bArr5[1] = S.a((length5 + 3736197) - (length5 | 3736197), ((-r3) - 1) | (-2646017), 2646017, i4) ^ 3764187;
                                long length6 = R2.class.getName().length();
                                long j84 = j67 | j66 | j65;
                                long j85 = j68 + j84 + (((((((((length6 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length6 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length6 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length6 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                                long j86 = (j85 >>> 48) & 21845;
                                long j87 = ((j86 >>> 1) | j86) & 858993459;
                                long j88 = ((j87 >>> 2) | j87) & 252645135;
                                long j89 = (j85 >>> 32) & 21845;
                                long j90 = ((j89 >>> 1) | j89) & 858993459;
                                long j91 = ((j90 >>> 2) | j90) & 252645135;
                                long j92 = ((((j91 >>> 4) | j91) & 16711935) << 16) + ((((j88 >>> 4) | j88) & 16711935) << 24);
                                long j93 = (j85 >>> 16) & 21845;
                                long j94 = ((j93 >>> 1) | j93) & 858993459;
                                long j95 = ((j94 >>> 2) | j94) & 252645135;
                                long j96 = j85 & 21845;
                                long j97 = ((j96 >>> 1) | j96) & 858993459;
                                long j98 = ((j97 >>> 2) | j97) & 252645135;
                                int i5 = (((int) ((((j98 >>> 4) | j98) & 16711935) + (((((j95 >>> 4) | j95) & 16711935) << 8) | j92))) | 1167668148) & 873732448;
                                int length7 = R2.class.getName().length();
                                long j99 = 12730384;
                                long length8 = ((R2.class.getName().length() | 818153536) - (length7 | 818153536)) + (length7 - R2.class.getName().length()) + (R2.class.getName().length() & 818153536);
                                long j100 = (((((((((j99 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j99 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j99 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j99 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((length8 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length8 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length8 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length8 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + 6148914691236517205L;
                                long j101 = (j100 >>> 48) & 43690;
                                long j102 = ((j101 >>> 2) | (j101 >>> 1)) & 858993459;
                                long j103 = ((j102 >>> 2) | j102) & 252645135;
                                long j104 = (j100 >>> 32) & 43690;
                                long j105 = ((j104 >>> 2) | (j104 >>> 1)) & 858993459;
                                long j106 = ((j105 >>> 2) | j105) & 252645135;
                                long j107 = ((((j106 >>> 4) | j106) & 16711935) << 16) + ((((j103 >>> 4) | j103) & 16711935) << 24);
                                long j108 = (j100 >>> 16) & 43690;
                                long j109 = ((j108 >>> 2) | (j108 >>> 1)) & 858993459;
                                long j110 = ((j109 >>> 2) | j109) & 252645135;
                                long j111 = j100 & 43690;
                                long j112 = ((j111 >>> 2) | (j111 >>> 1)) & 858993459;
                                long j113 = ((j112 >>> 2) | j112) & 252645135;
                                bArr5[2] = (i5 + ((int) ((((j113 >>> 4) | j113) & 16711935) | (((((j110 >>> 4) | j110) & 16711935) << 8) + j107)))) ^ (-886462826);
                                bArr5[3] = -51;
                                bArr5[4] = 25;
                                bArr5[5] = 36;
                                long j114 = 1364299445;
                                long length9 = (-1) - R2.class.getName().length();
                                long j115 = (((((((((j114 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j114 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j114 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j114 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((length9 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((length9 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length9 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length9 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + 6148914691236517205L;
                                long j116 = (j115 >>> 48) & 43690;
                                long j117 = ((j116 >>> 2) | (j116 >>> 1)) & 858993459;
                                long j118 = (j117 | (j117 >>> 2)) & 252645135;
                                long j119 = (j115 >>> 32) & 43690;
                                long j120 = ((j119 >>> 2) | (j119 >>> 1)) & 858993459;
                                long j121 = ((j120 >>> 2) | j120) & 252645135;
                                long j122 = (((j118 | (j118 >>> 4)) & 16711935) << 24) | ((((j121 >>> 4) | j121) & 16711935) << 16);
                                long j123 = (j115 >>> 16) & 43690;
                                long j124 = ((j123 >>> 2) | (j123 >>> 1)) & 858993459;
                                long j125 = ((j124 >>> 2) | j124) & 252645135;
                                long j126 = j115 & 43690;
                                long j127 = ((j126 >>> 2) | (j126 >>> 1)) & 858993459;
                                long j128 = (j127 | (j127 >>> 2)) & 252645135;
                                int length10 = R2.class.getName().length() & 100827136;
                                bArr5[(((((int) (((j128 | (j128 >>> 4)) & 16711935) | (((((j125 >>> 4) | j125) & 16711935) << 8) + j122))) | (-106040881)) + 106040881) + (~(((R2.class.getName().length() | 2146906101) | length10) - (length10 | (R2.class.getName().length() & (-2146906102)))))) ^ (-2040865220)] = 48;
                                bArr5[7] = -55;
                                bArr5[8] = -49;
                                bArr5[9] = -110;
                                int i6 = ~R2.class.getName().length();
                                bArr5[267064944 ^ ((((R2.class.getName().length() | 216204834) - (i6 | (-1612212630))) + ((((-1622698424) | i6) - R2.class.getName().length()) + (R2.class.getName().length() & 216204834))) + ((R2.class.getName().length() & 61341738) | 50860120))] = -33;
                                long length11 = R2.class.getName().length();
                                long j129 = (j68 | j84) + (((((((((length11 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length11 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length11 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length11 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
                                long j130 = (j129 >>> 48) & 21845;
                                long j131 = ((j130 >>> 1) | j130) & 858993459;
                                long j132 = ((j131 >>> 2) | j131) & 252645135;
                                long j133 = (j129 >>> 32) & 21845;
                                long j134 = ((j133 >>> 1) | j133) & 858993459;
                                long j135 = ((j134 >>> 2) | j134) & 252645135;
                                long j136 = ((((j135 >>> 4) | j135) & 16711935) << 16) | ((((j132 >>> 4) | j132) & 16711935) << 24);
                                long j137 = (j129 >>> 16) & 21845;
                                long j138 = ((j137 >>> 1) | j137) & 858993459;
                                long j139 = ((j138 >>> 2) | j138) & 252645135;
                                long j140 = j129 & 21845;
                                long j141 = ((j140 >>> 1) | j140) & 858993459;
                                long j142 = ((j141 >>> 2) | j141) & 252645135;
                                int i7 = (((int) ((((j142 >>> 4) | j142) & 16711935) + (((((j139 >>> 4) | j139) & 16711935) << 8) | j136))) | (-1042310373)) & 1614893824;
                                long j143 = -1828714336;
                                str3 = str4;
                                long length12 = R2.class.getName().length() & (-1560264672);
                                long j144 = (((((((((j143 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j143 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j143 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j143 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((length12 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length12 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((length12 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length12 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + 6148914691236517205L;
                                long j145 = (j144 >>> 48) & 43690;
                                long j146 = ((j145 >>> 2) | (j145 >>> 1)) & 858993459;
                                long j147 = ((j146 >>> 2) | j146) & 252645135;
                                long j148 = (j144 >>> 32) & 43690;
                                long j149 = ((j148 >>> 2) | (j148 >>> 1)) & 858993459;
                                long j150 = ((j149 >>> 2) | j149) & 252645135;
                                long j151 = ((((j150 >>> 4) | j150) & 16711935) << 16) + ((((j147 >>> 4) | j147) & 16711935) << 24);
                                long j152 = (j144 >>> 16) & 43690;
                                long j153 = ((j152 >>> 2) | (j152 >>> 1)) & 858993459;
                                long j154 = ((j153 >>> 2) | j153) & 252645135;
                                long j155 = j144 & 43690;
                                long j156 = ((j155 >>> 2) | (j155 >>> 1)) & 858993459;
                                long j157 = ((j156 >>> 2) | j156) & 252645135;
                                int i8 = (int) ((((((j154 >>> 4) | j154) & 16711935) << 8) + j151) | (((j157 >>> 4) | j157) & 16711935));
                                try {
                                    bArr5[11] = (-213820461) ^ (((i8 | i7) * 2) - (i7 ^ i8));
                                    bArr5[12] = -33;
                                    byte[] bArr6 = new byte[13];
                                    bArr6[0] = -23;
                                    bArr6[1] = -10;
                                    bArr6[2] = 38;
                                    bArr6[3] = 19;
                                    bArr6[4] = 33;
                                    long j158 = -1607302546;
                                    long length13 = (1589921192 & ((-997306448) - ((~(~R2.class.getName().length())) | (-997306447)))) + ((R2.class.getName().length() & 440406104) | 17381460);
                                    long j159 = (((((((((j158 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j158 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j158 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j158 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (((((((((length13 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length13 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((length13 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length13 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                                    long j160 = (j159 >>> 48) & 21845;
                                    long j161 = ((j160 >>> 1) | j160) & 858993459;
                                    long j162 = ((j161 >>> 2) | j161) & 252645135;
                                    long j163 = (j159 >>> 32) & 21845;
                                    long j164 = ((j163 >>> 1) | j163) & 858993459;
                                    long j165 = ((j164 >>> 2) | j164) & 252645135;
                                    long j166 = ((((j165 >>> 4) | j165) & 16711935) << 16) | ((((j162 >>> 4) | j162) & 16711935) << 24);
                                    long j167 = (j159 >>> 16) & 21845;
                                    long j168 = ((j167 >>> 1) | j167) & 858993459;
                                    long j169 = ((j168 >>> 2) | j168) & 252645135;
                                    long j170 = j159 & 21845;
                                    long j171 = ((j170 >>> 1) | j170) & 858993459;
                                    long j172 = ((j171 >>> 2) | j171) & 252645135;
                                    bArr6[5] = (int) ((((j172 >>> 4) | j172) & 16711935) + (((((j169 >>> 4) | j169) & 16711935) << 8) | j166));
                                    bArr6[6] = 72;
                                    bArr6[7] = 82;
                                    bArr6[8] = -14;
                                    int i9 = ~R2.class.getName().length();
                                    bArr6[((377914120 & (((~i9) & (-884490427)) + i9)) + ((R2.class.getName().length() & 364908712) | (-2126491488))) ^ (-1748577375)] = 40;
                                    bArr6[10] = -54;
                                    bArr6[11] = -127;
                                    bArr6[12] = -38;
                                    c(bArr5, bArr6);
                                    kotlin.jvm.internal.j.d(jSONObject, new String(bArr5, StandardCharsets.UTF_8).intern());
                                } catch (JSONException e5) {
                                    e = e5;
                                }
                            } catch (JSONException e6) {
                                e = e6;
                                str3 = str4;
                            }
                        } catch (JSONException e7) {
                            e = e7;
                            str3 = str4;
                            str2 = str6;
                        }
                        try {
                            b4.getClass();
                            c4 = 43566;
                            str4 = jSONObject;
                            obj = b4;
                        } catch (JSONException e8) {
                            e = e8;
                            str3 = jSONObject;
                            obj = e;
                            c4 = 61762;
                            str4 = str3;
                            str6 = str2;
                        }
                        str6 = str2;
                    case 968:
                        break;
                    case 34462:
                        break;
                    default:
                        c4 = 62370;
                }
                return;
            }
            c4 = 30723;
        }
    }

    public L1.k f() {
        if (((Integer) this.f372a) != null) {
            if (((Integer) this.f373b) != null) {
                Integer num = (Integer) this.f374c;
                if (num != null) {
                    if (((L1.j) this.f375d) != null) {
                        if (((L1.j) this.f376e) != null) {
                            int intValue = num.intValue();
                            L1.j jVar = (L1.j) this.f375d;
                            if (jVar == L1.j.f1293c) {
                                if (intValue > 20) {
                                    throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 20 bytes for SHA1", num));
                                }
                            } else if (jVar == L1.j.f1294d) {
                                if (intValue > 28) {
                                    throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 28 bytes for SHA224", num));
                                }
                            } else if (jVar == L1.j.f1295e) {
                                if (intValue > 32) {
                                    throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 32 bytes for SHA256", num));
                                }
                            } else if (jVar == L1.j.f1296f) {
                                if (intValue > 48) {
                                    throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 48 bytes for SHA384", num));
                                }
                            } else if (jVar == L1.j.f1297g) {
                                if (intValue > 64) {
                                    throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 64 bytes for SHA512", num));
                                }
                            } else {
                                throw new GeneralSecurityException("unknown hash type; must be SHA1, SHA224, SHA256, SHA384 or SHA512");
                            }
                            return new L1.k(((Integer) this.f372a).intValue(), ((Integer) this.f373b).intValue(), ((Integer) this.f374c).intValue(), (L1.j) this.f376e, (L1.j) this.f375d);
                        }
                        throw new GeneralSecurityException("variant is not set");
                    }
                    throw new GeneralSecurityException("hash type is not set");
                }
                throw new GeneralSecurityException("tag size is not set");
            }
            throw new GeneralSecurityException("HMAC key size is not set");
        }
        throw new GeneralSecurityException("AES key size is not set");
    }
}
