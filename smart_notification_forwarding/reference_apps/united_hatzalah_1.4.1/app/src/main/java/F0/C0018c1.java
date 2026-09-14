package F0;

import android.content.Context;
import android.content.res.Configuration;
import android.security.keystore.KeyGenParameterSpec;
import android.text.Editable;
import android.text.Selection;
import android.text.TextPaint;
import android.view.KeyEvent;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.concurrent.locks.ReentrantLock;
import javax.crypto.Cipher;
import javax.security.auth.x500.X500Principal;
import org.apache.tika.fork.ForkServer;

/* renamed from: F0.c1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0018c1 {

    /* renamed from: a, reason: collision with root package name */
    public Object f476a;

    /* renamed from: b, reason: collision with root package name */
    public Object f477b;

    public /* synthetic */ C0018c1(Object obj, Object obj2) {
        this.f476a = obj;
        this.f477b = obj2;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x016f. Please report as an issue. */
    public static void a(Y0 y02, X0 x02, Long l3) {
        int i;
        int i3;
        int i4;
        int i5;
        Y0 y03 = y02;
        X0 x03 = x02;
        int i6 = 2;
        int i7 = 1;
        int i8 = 0;
        int i9 = 8;
        if (l3 != null) {
            byte[] bArr = new byte[8];
            bArr[0] = -126;
            bArr[1] = 111;
            bArr[2] = 85;
            bArr[1911525306 ^ ((((~Y0.class.getName().length()) | 339308205) & 300453288) + ((Y0.class.getName().length() & 566591761) | 1611072017))] = 29;
            bArr[4] = 7;
            bArr[5] = -67;
            bArr[6] = 29;
            bArr[7] = -92;
            Y0.b(bArr, new byte[]{-20, 10, 34, 78, 115, -36, 105, -63});
            kotlin.jvm.internal.j.e(x03, new String(bArr, StandardCharsets.UTF_8).intern());
            y03.f429a = x03;
            y03.f430b = l3;
            return;
        }
        int i10 = 3;
        byte[] bArr2 = {3, 59, -35, -87, 52, 46, -16, -38};
        byte[] bArr3 = new byte[((((~Y0.class.getName().length()) | 1365359067) & 1426391570) + ((Y0.class.getName().length() & (-2080079328)) | (-2139057120))) ^ (-712665542)];
        bArr3[0] = -124;
        bArr3[1] = 46;
        bArr3[2] = -64;
        bArr3[3] = -31;
        bArr3[4] = 87;
        int i11 = ((~Y0.class.getName().length()) | (-503074914)) & 44073388;
        int length = Y0.class.getName().length();
        bArr3[5] = 195408307 ^ (i11 + (151334912 | (((Y0.class.getName().length() | 27525152) - (length | 27525152)) + (AbstractC0008a.f(Y0.class, length) + (Y0.class.getName().length() & 27525152)))));
        bArr3[6] = -102;
        bArr3[7] = -90;
        byte[] bArr4 = null;
        int i12 = 1516727821;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        byte[] bArr5 = null;
        while (true) {
            int i16 = ((i12 & 16777216) * (i12 | 16777216)) + ((i12 & (-16777217)) * ((~i12) & 16777216));
            int i17 = i12 >>> i9;
            int i18 = i8;
            int a2 = j3.a((~i16) & 650911840 & i17, i17, i16, (i16 | 650911840) & i17);
            int i19 = (a2 ^ 642535957) + ((a2 & 642535957) * i6);
            switch (((~i19) + ((i19 | 1) * i6)) ^ 962785775) {
                case -1896910703:
                    int i20 = i7;
                    int length2 = bArr5.length;
                    int i21 = 0 - i13;
                    i6 = 2;
                    int i22 = (length2 ^ i21) + ((length2 & i21) * 2);
                    byte b4 = bArr4[i22];
                    int length3 = bArr5.length;
                    int i23 = 0 - i21;
                    int i24 = i23 | length3;
                    byte b5 = bArr4[D.a(i23, 2, i24, (length3 ^ i23) ^ i24)];
                    bArr4[i22] = (byte) (((byte) (((byte) 2) * ((byte) (b5 | b4)))) - ((byte) (b5 ^ b4)));
                    y03 = y02;
                    x03 = x02;
                    i12 = -746753280;
                    i7 = i20;
                    i8 = i18;
                    i9 = 8;
                    i10 = 3;
                case -1725904394:
                    int length4 = bArr5.length % 4;
                    i = 1;
                    if ((((length4 > 1 ? 1 : (length4 == 1 ? 0 : -1)) >>> 31) & 1) != 0) {
                        i15 = length4;
                        i12 = -458924450;
                        y03 = y02;
                        x03 = x02;
                        i7 = i;
                        i8 = i18;
                        i6 = 2;
                        i9 = 8;
                        i10 = 3;
                    } else {
                        x03 = x02;
                        i15 = length4;
                        i7 = 1;
                        i8 = i18;
                        i12 = -365117735;
                        i6 = 2;
                        i9 = 8;
                        i10 = 3;
                        y03 = y02;
                    }
                case -1399959314:
                    int i25 = i7;
                    int a4 = j3.a((-1205100636) & i14, i14, i10, (-1205100633) & i14);
                    byte b6 = bArr4[a4];
                    int i26 = ((b6 & ForkServer.DONE) * (b6 | ForkServer.DONE)) + ((b6 & ForkServer.ERROR) * ((~b6) & 16777216));
                    int i27 = i14 - 1;
                    int i28 = i27 - (i14 | (-3));
                    int i29 = bArr4[i28] & ForkServer.ERROR;
                    int i30 = i29 * ((~i29) & 65536);
                    int a5 = S.a(i30, i26, i25, ((-1) - i30) | ((-1) - i26));
                    int i31 = i27 - (i14 | (-2));
                    int i32 = bArr4[i31] & ForkServer.ERROR;
                    int i33 = i32 * ((~i32) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i34 = (i33 - 1) - ((~a5) | i33);
                    int i35 = bArr4[i14] & ForkServer.ERROR;
                    int a6 = S.a(i34, i35, 1, ((-1) - i34) | ((-1) - i35));
                    byte b7 = bArr5[a4];
                    int i36 = ((b7 & ForkServer.DONE) * (b7 | ForkServer.DONE)) + ((b7 & ForkServer.ERROR) * ((~b7) & 16777216));
                    int i37 = bArr5[i28] & ForkServer.ERROR;
                    int i38 = ((i37 * ((~i37) & 65536)) & (~i36)) + i36;
                    int i39 = bArr5[i31] & ForkServer.ERROR;
                    int i40 = i39 * ((~i39) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i41 = ~((((~i40) | 911399251) | i38) - ((i40 & 911399251) | i38));
                    int i42 = bArr5[i14] & ForkServer.ERROR;
                    int i43 = ~((((~i41) | 1433568692) | i42) - ((i41 & 1433568692) | i42));
                    int i44 = a6 << ((a6 > Double.NaN ? 1 : (a6 == Double.NaN ? 0 : -1)) >>> 31);
                    int i45 = (-1254002618) - ((i44 & 2) | ((-1672003491) - i44));
                    int i46 = (i45 + i43) - ((i45 & i43) * 2);
                    bArr5[i14] = (byte) i46;
                    bArr5[i31] = (byte) (i46 >>> 8);
                    bArr5[i28] = (byte) (i46 >>> 16);
                    bArr5[a4] = (byte) (i46 >>> 24);
                    i14 = (i14 ^ 4) + ((i14 & 4) * 2);
                    int length5 = bArr5.length;
                    int length6 = 0 - (bArr5.length % 4);
                    int i47 = ((i14 > AbstractC0014b1.a((length5 & 2) | D1.a(length6, length5), length6 * 3) ? 1 : (i14 == AbstractC0014b1.a((length5 & 2) | D1.a(length6, length5), length6 * 3) ? 0 : -1)) >>> 31) & 1;
                    if (i47 != 0) {
                        i3 = -1605440657;
                    } else {
                        i3 = -365117735;
                    }
                    if (i47 != 0) {
                        i12 = i3;
                    } else {
                        i12 = -169475207;
                    }
                    y03 = y02;
                    x03 = x02;
                    i8 = i18;
                    i6 = 2;
                    i7 = 1;
                    i9 = 8;
                    i10 = 3;
                case -1135475043:
                    break;
                case 180635757:
                    bArr5 = bArr2;
                    bArr4 = bArr3;
                    i8 = i18;
                    i14 = i8;
                    i12 = -1605440657;
                    i9 = 8;
                case 511524454:
                    int length7 = bArr5.length;
                    int i48 = 0 - i13;
                    int i49 = 0 - i48;
                    int i50 = ((~length7) & i49) * i6;
                    int length8 = bArr5.length;
                    byte b8 = bArr5[((length8 | i48) * i6) - (length8 ^ i48)];
                    int i51 = i7;
                    int length9 = bArr5.length;
                    byte b9 = bArr4[(i48 ^ length9) + ((length9 & i48) * 2)];
                    int i52 = i6;
                    bArr5[(length7 ^ i49) - i50] = (byte) (((byte) (b9 - b8)) + ((byte) (((byte) i6) * ((byte) ((~b9) & b8)))));
                    i15 = AbstractC0099x.a(i13, i10, (~i13) * 2);
                    if ((((i13 > i52 ? 1 : (i13 == i52 ? 0 : -1)) >>> 31) & 1) != 0) {
                        i = i51;
                        i12 = -458924450;
                        y03 = y02;
                        x03 = x02;
                        i7 = i;
                        i8 = i18;
                        i6 = 2;
                        i9 = 8;
                        i10 = 3;
                    } else {
                        i7 = i51;
                        i8 = i18;
                        i12 = -365117735;
                        i6 = 2;
                        i9 = 8;
                    }
                case 961838909:
                    int length10 = bArr5.length;
                    int i53 = 0 - i15;
                    if ((bArr4[((length10 | i53) - (((~i53) & 165327505) & length10)) + ((i53 | 165327505) & length10)] > Double.NaN ? 1 : (bArr4[((length10 | i53) - (((~i53) & 165327505) & length10)) + ((i53 | 165327505) & length10)] == Double.NaN ? 0 : -1)) <= -1) {
                        i4 = i18;
                    } else {
                        i4 = i7;
                    }
                    if (i4 != 0) {
                        i5 = -365117735;
                    } else {
                        i5 = 1093626513;
                    }
                    if (i4 != 0) {
                        i12 = -746753280;
                    } else {
                        i12 = i5;
                    }
                    i13 = i15;
                    i8 = i18;
                    i9 = 8;
                default:
                    i12 = -365117735;
                    y03 = y02;
                    x03 = x02;
                    i8 = i18;
                    i6 = 2;
                    i7 = 1;
                    i9 = 8;
                    i10 = 3;
            }
            kotlin.jvm.internal.j.e(x03, new String(bArr2, StandardCharsets.UTF_8).intern());
            y03.f429a = x03;
            return;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0045. Please report as an issue. */
    public static void b(byte[] bArr, byte[] bArr2) {
        boolean z3;
        int i;
        byte[] bArr3 = null;
        int i3 = -1003175592;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        byte[] bArr4 = null;
        while (true) {
            int i7 = ((i3 & 16777216) * (i3 | 16777216)) + ((i3 & (-16777217)) * ((~i3) & 16777216));
            int i8 = i3 >>> 8;
            int i9 = ~((((~i8) | (-1095531540)) | i7) - ((i8 & (-1095531540)) | i7));
            int i10 = (-1171264002) - ((i9 & 2) | ((-130029571) - i9));
            switch ((-1109882652) ^ ((~i10) + ((i10 | 1) * 2))) {
                case -1922532006:
                    byte[] bArr5 = bArr3;
                    int length = bArr4.length;
                    int i11 = 0 - i4;
                    if ((bArr5[AbstractC0014b1.a((length & 2) | D1.a(i11, length), i11 * 3)] > Double.NaN ? 1 : (bArr5[AbstractC0014b1.a((length & 2) | D1.a(i11, length), i11 * 3)] == Double.NaN ? 0 : -1)) <= -1) {
                        i3 = -1671996003;
                    } else {
                        i3 = 935800592;
                    }
                    i5 = i4;
                    bArr3 = bArr5;
                case -1486048729:
                    int length2 = bArr.length;
                    int length3 = 0 - (0 - (bArr.length % 4));
                    if ((length2 & (~length3)) - ((~length2) & length3) <= 0) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    if (z3) {
                        i = -1515449616;
                    } else {
                        i = 935800592;
                    }
                    if (z3) {
                        i3 = i;
                    } else {
                        i3 = -10521562;
                    }
                    bArr3 = bArr2;
                    bArr4 = bArr;
                    i6 = 0;
                case -497756741:
                    byte[] bArr6 = bArr3;
                    int length4 = bArr4.length;
                    int i12 = 0 - i5;
                    int i13 = ((length4 | i12) * 2) - (length4 ^ i12);
                    byte b4 = bArr6[i13];
                    int length5 = bArr4.length;
                    byte b5 = bArr6[((i12 | length5) - ((1163302289 & (~i12)) & length5)) + ((i12 | 1163302289) & length5)];
                    bArr6[i13] = (byte) (((byte) (((byte) (b5 ^ (~b4))) + ((byte) (((byte) 2) * ((byte) (b5 | b4)))))) + ((byte) 1));
                    bArr3 = bArr6;
                    i3 = 935800592;
                case 256719606:
                    int i14 = (i6 - 1) - (i6 | (-4));
                    byte b6 = bArr3[i14];
                    int i15 = ((b6 & ForkServer.DONE) * (b6 | ForkServer.DONE)) + ((b6 & ForkServer.ERROR) * ((~b6) & 16777216));
                    int i16 = i6 + 2;
                    int i17 = i16 - (i6 & 2);
                    int i18 = bArr3[i17] & ForkServer.ERROR;
                    int i19 = i18 * ((~i18) & 65536);
                    int a2 = S.a(i19, i15, 1, ((-1) - i19) | ((-1) - i15));
                    int i20 = i16 + (((-1) - i6) | (-2));
                    int i21 = bArr3[i20] & ForkServer.ERROR;
                    int i22 = i21 * ((~i21) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i23 = (i22 - 1) - ((~a2) | i22);
                    int i24 = bArr3[i6] & ForkServer.ERROR;
                    int i25 = ~((i24 | ((~i23) | (-755325340))) - ((i23 & (-755325340)) | i24));
                    byte b7 = bArr4[i14];
                    int i26 = ((b7 & ForkServer.DONE) * (b7 | ForkServer.DONE)) + ((b7 & ForkServer.ERROR) * ((~b7) & 16777216));
                    int i27 = bArr4[i17] & ForkServer.ERROR;
                    int i28 = i27 * ((~i27) & 65536);
                    int i29 = bArr4[i20] & ForkServer.ERROR;
                    int i30 = i29 * ((~i29) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i31 = bArr4[i6] & ForkServer.ERROR;
                    byte[] bArr7 = bArr3;
                    int i32 = i25 << ((i25 > Double.NaN ? 1 : (i25 == Double.NaN ? 0 : -1)) >>> 31);
                    int i33 = (-659933419) - ((1983400305 - i26) | (i26 & 2));
                    int i34 = (i33 ^ (~i28)) + ((i33 | i28) * 2) + 1;
                    int i35 = (i34 ^ i31) + ((i34 & i31) * 2);
                    int i36 = ((i35 | i30) - (((-2109111237) & (~i30)) & i35)) + ((i30 | (-2109111237)) & i35);
                    int a4 = E1.a(i32 | i36, i32, i36);
                    bArr4[i6] = (byte) a4;
                    bArr4[i20] = (byte) (a4 >>> 8);
                    bArr4[i17] = (byte) (a4 >>> 16);
                    bArr4[i14] = (byte) (a4 >>> 24);
                    i6 = (i6 ^ 4) + ((i6 & 4) * 2);
                    int length6 = bArr4.length;
                    int length7 = 0 - (bArr4.length % 4);
                    int i37 = ((i6 > (((length6 | length7) * 2) - (length6 ^ length7)) ? 1 : (i6 == (((length6 | length7) * 2) - (length6 ^ length7)) ? 0 : -1)) >>> 31) & 1;
                    if (i37 != 0) {
                        i3 = -1515449616;
                    } else {
                        i3 = 935800592;
                    }
                    bArr3 = bArr7;
                    if (i37 == 0) {
                        i3 = -10521562;
                    }
                case 1429728656:
                    i4 = bArr4.length % 4;
                    int i38 = 1 & ((i4 > 1 ? 1 : (i4 == 1 ? 0 : -1)) >>> 31);
                    if (i38 != 0) {
                        i3 = -1216566512;
                    } else {
                        i3 = 935800592;
                    }
                    if (i38 == 0) {
                        i3 = -1058029970;
                    }
                case 1870596681:
                    break;
                case 1879000533:
                    int length8 = bArr4.length;
                    int i39 = 0 - i5;
                    int i40 = 0 - i39;
                    int i41 = i40 | length8;
                    int i42 = (length8 ^ i40) ^ i41;
                    int i43 = i40 * 2;
                    int length9 = bArr4.length;
                    byte b8 = bArr4[(i40 ^ length9) - (((~length9) & i40) * 2)];
                    int length10 = bArr4.length;
                    byte b9 = bArr3[((i39 | length10) * 2) - (length10 ^ i39)];
                    bArr4[(i41 - i43) + i42] = (byte) (((((byte) (~b9)) + ((byte) (((byte) 2) * ((byte) (b9 | 1))))) ^ b8) ^ 1);
                    i4 = (~i5) + (i5 * 2);
                    int i44 = 1 & ((i5 > 2 ? 1 : (i5 == 2 ? 0 : -1)) >>> 31);
                    if (i44 != 0) {
                        i3 = -1216566512;
                    } else {
                        i3 = 935800592;
                    }
                    if (i44 == 0) {
                        i3 = -1058029970;
                    }
                default:
                    i3 = 935800592;
            }
            return;
        }
    }

    public static boolean d(Editable editable, KeyEvent keyEvent, boolean z3) {
        V.w[] wVarArr;
        if (KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState())) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (selectionStart != -1 && selectionEnd != -1 && selectionStart == selectionEnd && (wVarArr = (V.w[]) editable.getSpans(selectionStart, selectionEnd, V.w.class)) != null && wVarArr.length > 0) {
                for (V.w wVar : wVarArr) {
                    int spanStart = editable.getSpanStart(wVar);
                    int spanEnd = editable.getSpanEnd(wVar);
                    if ((z3 && spanStart == selectionStart) || ((!z3 && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                        editable.delete(spanStart, spanEnd);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public String c() {
        return ((Context) this.f477b).getPackageName() + ".FlutterSecureStoragePluginKey";
    }

    public AlgorithmParameterSpec e() {
        return null;
    }

    public Cipher f() {
        return Cipher.getInstance("RSA/ECB/PKCS1Padding", "AndroidKeyStoreBCWorkaround");
    }

    public boolean g(CharSequence charSequence, int i, int i3, V.p pVar) {
        int i4;
        if (pVar.f2412c == 0) {
            V.g gVar = (V.g) this.f477b;
            W.a b4 = pVar.b();
            int a2 = b4.a(8);
            if (a2 != 0) {
                ((ByteBuffer) b4.f946d).getShort(a2 + b4.f943a);
            }
            V.d dVar = (V.d) gVar;
            dVar.getClass();
            ThreadLocal threadLocal = V.d.f2388b;
            if (threadLocal.get() == null) {
                threadLocal.set(new StringBuilder());
            }
            StringBuilder sb = (StringBuilder) threadLocal.get();
            sb.setLength(0);
            while (i < i3) {
                sb.append(charSequence.charAt(i));
                i++;
            }
            TextPaint textPaint = dVar.f2389a;
            String sb2 = sb.toString();
            int i5 = A.d.f6a;
            if (textPaint.hasGlyph(sb2)) {
                i4 = 2;
            } else {
                i4 = 1;
            }
            pVar.f2412c = i4;
        }
        if (pVar.f2412c != 2) {
            return false;
        }
        return true;
    }

    public KeyGenParameterSpec h(Calendar calendar, Calendar calendar2) {
        String str = (String) this.f476a;
        return new KeyGenParameterSpec.Builder(str, 3).setCertificateSubject(new X500Principal(e0.a.d("CN=", str))).setDigests("SHA-256").setBlockModes("ECB").setEncryptionPaddings("PKCS1Padding").setCertificateSerialNumber(BigInteger.valueOf(1L)).setCertificateNotBefore(calendar.getTime()).setCertificateNotAfter(calendar2.getTime()).build();
    }

    public void i(G.g gVar) {
        F.d dVar = (F.d) this.f477b;
        G1 g12 = (G1) this.f476a;
        int i = gVar.f786b;
        if (i == 0) {
            dVar.execute(new RunnableC0091v(1, g12, gVar.f785a));
        } else {
            dVar.execute(new G.a(g12, i));
        }
    }

    public void j(Locale locale) {
        Locale.setDefault(locale);
        Context context = (Context) this.f477b;
        Configuration configuration = context.getResources().getConfiguration();
        configuration.setLocale(locale);
        context.createConfigurationContext(configuration);
    }

    public Key k(byte[] bArr) {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        String str = (String) this.f476a;
        Key key = keyStore.getKey(str, null);
        if (key != null) {
            if (key instanceof PrivateKey) {
                Cipher f4 = f();
                f4.init(4, (PrivateKey) key, e());
                return f4.unwrap(bArr, "AES", 3);
            }
            throw new Exception("Not an instance of a PrivateKey");
        }
        throw new Exception(e0.a.d("No key found under alias: ", str));
    }

    public C0018c1(int i) {
        switch (i) {
            case 7:
                this.f476a = new ReentrantLock();
                this.f477b = new LinkedHashMap();
                return;
            default:
                this.f476a = new ReentrantLock();
                this.f477b = new HashMap(15);
                return;
        }
    }

    public C0018c1(Context context) {
        this.f477b = context;
        String c4 = c();
        this.f476a = c4;
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        if (keyStore.getKey(c4, null) == null) {
            Locale locale = Locale.getDefault();
            try {
                j(Locale.ENGLISH);
                Calendar calendar = Calendar.getInstance();
                Calendar calendar2 = Calendar.getInstance();
                calendar2.add(1, 25);
                KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
                keyPairGenerator.initialize(h(calendar, calendar2));
                keyPairGenerator.generateKeyPair();
            } finally {
                j(locale);
            }
        }
    }
}
