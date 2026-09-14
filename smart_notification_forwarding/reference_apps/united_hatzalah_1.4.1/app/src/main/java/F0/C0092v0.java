package F0;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertController$RecycleListView;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import h.C0434d;
import h.C0435e;
import h.C0437g;
import h.DialogInterfaceC0438h;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.tika.fork.ForkServer;

/* renamed from: F0.v0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0092v0 {

    /* renamed from: a, reason: collision with root package name */
    public int f692a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f693b;

    public C0092v0(C0096w0 c0096w0, int i) {
        this.f693b = c0096w0;
        this.f692a = i;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:26:0x04e4. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000b. Please report as an issue. */
    public int a() {
        app.talsec.rasp.j2 j2Var;
        boolean z3;
        app.talsec.rasp.j2 j2Var2;
        int i;
        int i3;
        boolean z4 = false;
        char c4 = 20029;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            switch (c4) {
                case 516:
                    int i6 = this.f692a;
                    int i7 = i6 - 5;
                    byte[] bArr = new byte[20];
                    bArr[0] = 105;
                    int i8 = 1;
                    bArr[1] = 25;
                    int i9 = (-1) - i6;
                    bArr[2] = ((((((((~i9) & i6) & 1806697734) + 1806697734) + i9) - (1806697734 & (i6 | i9))) & 641794307) + ((71376929 & i6) | 268968992)) ^ 910763341;
                    bArr[3] = 48;
                    bArr[4] = 35;
                    bArr[5] = 6;
                    bArr[6] = 3;
                    bArr[7] = 126;
                    bArr[8] = -63;
                    bArr[9] = -38;
                    bArr[10] = -81;
                    bArr[11] = -48;
                    int i10 = ~i6;
                    long j2 = 1417270645;
                    long j3 = i10;
                    long b4 = c3.b((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
                    long j4 = (b4 >>> 48) & 43690;
                    long j5 = ((j4 >>> 2) | (j4 >>> 1)) & 858993459;
                    long j6 = ((j5 >>> 2) | j5) & 252645135;
                    long j7 = (b4 >>> 32) & 43690;
                    long j8 = ((j7 >>> 2) | (j7 >>> 1)) & 858993459;
                    long j9 = ((j8 >>> 2) | j8) & 252645135;
                    long j10 = ((((j9 >>> 4) | j9) & 16711935) << 16) | ((((j6 >>> 4) | j6) & 16711935) << 24);
                    long j11 = (b4 >>> 16) & 43690;
                    long j12 = ((j11 >>> 2) | (j11 >>> 1)) & 858993459;
                    long j13 = ((j12 >>> 2) | j12) & 252645135;
                    long j14 = b4 & 43690;
                    long j15 = ((j14 >>> 2) | (j14 >>> 1)) & 858993459;
                    long j16 = ((j15 >>> 2) | j15) & 252645135;
                    int i11 = (((int) ((((j16 >>> 4) | j16) & 16711935) + (((((j13 >>> 4) | j13) & 16711935) << 8) | j10))) | (-1074809681)) + 1074809681 + (570623136 | ((i6 | (-537070209)) - (-537070209)));
                    bArr[12] = (((~i11) & (-1645432758)) - ((-1645432758) & i11)) + i11;
                    bArr[13] = 67;
                    bArr[14] = -62;
                    bArr[15] = 108;
                    int i12 = (-2138828620) & i6;
                    int i13 = 2;
                    bArr[((((~i12) & 1074856480) + i12) + ((i9 | 591048259) & (-2121524076))) ^ (-1046667612)] = 72;
                    bArr[17] = -115;
                    bArr[18] = 80;
                    bArr[19] = -51;
                    long j17 = -2147479480;
                    long j18 = i6 & (-1800924152);
                    long b5 = c3.b((((((((j17 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j17 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j17 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j17 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845), ((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
                    long j19 = (b5 >>> 48) & 43690;
                    long j20 = ((j19 >>> 2) | (j19 >>> 1)) & 858993459;
                    long j21 = ((j20 >>> 2) | j20) & 252645135;
                    long j22 = (b5 >>> 32) & 43690;
                    long j23 = ((j22 >>> 2) | (j22 >>> 1)) & 858993459;
                    long j24 = ((j23 >>> 2) | j23) & 252645135;
                    long j25 = ((((j24 >>> 4) | j24) & 16711935) << 16) | ((((j21 >>> 4) | j21) & 16711935) << 24);
                    long j26 = (b5 >>> 16) & 43690;
                    long j27 = ((j26 >>> 2) | (j26 >>> 1)) & 858993459;
                    long j28 = ((j27 >>> 2) | j27) & 252645135;
                    long j29 = b5 & 43690;
                    long j30 = ((j29 >>> 2) | (j29 >>> 1)) & 858993459;
                    long j31 = ((j30 >>> 2) | j30) & 252645135;
                    int i14 = ((-346555393) | i10) + 363529218 + ((int) ((((j31 >>> 4) | j31) & 16711935) + (((((j28 >>> 4) | j28) & 16711935) << 8) | j25)));
                    long j32 = -1783950325;
                    long j33 = i14;
                    long j34 = (((((((((j32 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j32 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j32 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j32 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j33 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j33 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j33 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j33 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                    long j35 = (j34 >>> 48) & 21845;
                    long j36 = ((j35 >>> 1) | j35) & 858993459;
                    long j37 = ((j36 >>> 2) | j36) & 252645135;
                    long j38 = (j34 >>> 32) & 21845;
                    long j39 = ((j38 >>> 1) | j38) & 858993459;
                    long j40 = ((j39 >>> 2) | j39) & 252645135;
                    long j41 = ((((j40 >>> 4) | j40) & 16711935) << 16) | ((((j37 >>> 4) | j37) & 16711935) << 24);
                    long j42 = (j34 >>> 16) & 21845;
                    long j43 = ((j42 >>> 1) | j42) & 858993459;
                    long j44 = ((j43 >>> 2) | j43) & 252645135;
                    long j45 = j34 & 21845;
                    long j46 = ((j45 >>> 1) | j45) & 858993459;
                    long j47 = ((j46 >>> 2) | j46) & 252645135;
                    int i15 = (i6 & 335568914) | 269484243;
                    int i16 = -((i10 | (-635462388)) & 1141406728);
                    int i17 = i16 | i15;
                    byte[] bArr2 = {6, 111, 11, (int) ((((j47 >>> 4) | j47) & 16711935) + (((((j44 >>> 4) | j44) & 16711935) << 8) | j41)), 79, 105, 109, 25, -31, -81, -61, -75, -40, 114, (-1410890965) ^ ((i17 - (i16 * 2)) + ((i15 ^ i16) ^ i17)), 84, 104, -20, 36, -19};
                    byte[] bArr3 = null;
                    int i18 = 0;
                    int i19 = 0;
                    int i20 = 0;
                    int i21 = -585497720;
                    byte[] bArr4 = null;
                    while (true) {
                        int i22 = ((i21 & 16777216) * (i21 | 16777216)) + ((i21 & (-16777217)) * ((~i21) & 16777216));
                        int i23 = i21 >>> 8;
                        int i24 = ~((((~i23) | (-238348293)) | i22) - ((i23 & (-238348293)) | i22));
                        int i25 = (-1081514022) - ((i24 & 2) | ((-10362931) - i24));
                        switch (E1.a(i25 | (-428181225), i25, -428181225)) {
                            case -1819084085:
                                z3 = z4;
                                app.talsec.rasp.j2 j2Var3 = j2Var;
                                int length = bArr3.length;
                                int i26 = 0 - i18;
                                int length2 = bArr3.length;
                                int i27 = 0 - i26;
                                byte b6 = bArr3[((~i27) & length2) - ((~length2) & i27)];
                                int length3 = bArr3.length;
                                byte b7 = bArr4[((length3 | i26) - (((~i26) & (-1678010279)) & length3)) + (((-1678010279) | i26) & length3)];
                                bArr3[((length | i26) * 2) - (length ^ i26)] = (byte) (((byte) (((byte) (((byte) 2) * ((byte) (b7 | b6)))) - b7)) - b6);
                                i20 = 4 - ((5 - i18) | (i18 & 2));
                                j2Var2 = j2Var3;
                                i = 2;
                                i3 = 1;
                                int i28 = ((i18 > 2 ? 1 : (i18 == 2 ? 0 : -1)) >>> 31) & 1;
                                int i29 = i28 != 0 ? 2100390411 : -897645243;
                                if (i28 != 0) {
                                    i13 = 2;
                                    i21 = i29;
                                    z4 = z3;
                                    j2Var = j2Var2;
                                    i8 = 1;
                                } else {
                                    i13 = i;
                                    z4 = z3;
                                    j2Var = j2Var2;
                                    i8 = i3;
                                    i21 = -2079636786;
                                }
                            case -1350640889:
                                i21 = -1469476344;
                                bArr4 = bArr2;
                                bArr3 = bArr;
                                z4 = false;
                                i8 = 1;
                                i19 = 0;
                                i13 = 2;
                            case -477594107:
                                app.talsec.rasp.j2 j2Var4 = j2Var;
                                int length4 = bArr3.length;
                                int i30 = 0 - i18;
                                int i31 = ((length4 | i30) - (((~i30) & (-515406864)) & length4)) + (((-515406864) | i30) & length4);
                                byte b8 = bArr4[i31];
                                int length5 = bArr3.length;
                                byte b9 = bArr4[((i30 | length5) * 2) - (length5 ^ i30)];
                                int i32 = ((byte) 0) - b8;
                                int i33 = i32 | b9;
                                bArr4[i31] = (byte) (((byte) (((byte) i33) - ((byte) (((byte) i13) * ((byte) i32))))) + ((byte) ((b9 ^ i32) ^ i33)));
                                j2Var = j2Var4;
                                z4 = false;
                                i8 = 1;
                                i21 = -1057239115;
                                i13 = 2;
                            case 769572960:
                                break;
                            case 783648904:
                                app.talsec.rasp.j2 j2Var5 = j2Var;
                                int i34 = i19 + 4 + (((-1) - i19) | (-4));
                                byte b10 = bArr4[i34];
                                int i35 = ((b10 & ForkServer.DONE) * (b10 | ForkServer.DONE)) + ((b10 & ForkServer.ERROR) * ((~b10) & 16777216));
                                int i36 = i19 & 2;
                                int i37 = (i19 + 2) - i36;
                                int i38 = bArr4[i37] & ForkServer.ERROR;
                                int i39 = i38 * ((~i38) & 65536);
                                int i40 = ~((i35 | ((~i39) | 467314697)) - ((i39 & 467314697) | i35));
                                int i41 = (i19 + 1) - (i19 & 1);
                                int i42 = bArr4[i41] & ForkServer.ERROR;
                                int i43 = i42 * ((~i42) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                                int i44 = ~((i40 | (1328859631 | (~i43))) - ((i43 & 1328859631) | i40));
                                int i45 = bArr4[i19] & ForkServer.ERROR;
                                int a2 = S.a(i44, i45, 1, ((-1) - i44) | ((-1) - i45));
                                byte b11 = bArr3[i34];
                                int i46 = ((b11 & ForkServer.DONE) * (b11 | ForkServer.DONE)) + ((b11 & ForkServer.ERROR) * ((~b11) & 16777216));
                                int i47 = bArr3[i37] & ForkServer.ERROR;
                                int i48 = i47 * ((~i47) & 65536);
                                int a4 = j3.a((~i46) & 1647046022 & i48, i48, i46, (i46 | 1647046022) & i48);
                                int i49 = bArr3[i41] & ForkServer.ERROR;
                                int i50 = i49 * ((~i49) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                                int i51 = ~((a4 | ((~i50) | (-2059442874))) - ((i50 & (-2059442874)) | a4));
                                int i52 = bArr3[i19] & ForkServer.ERROR;
                                int a5 = S.a(i51, i52, 1, ((-1) - i51) | ((-1) - i52));
                                int i53 = a2 << ((a2 > Double.NaN ? 1 : (a2 == Double.NaN ? 0 : -1)) >>> 31);
                                int i54 = (i53 + a5) - ((i53 & a5) * 2);
                                bArr3[i19] = (byte) i54;
                                bArr3[i41] = (byte) (i54 >>> 8);
                                bArr3[i37] = (byte) (i54 >>> 16);
                                bArr3[i34] = (byte) (i54 >>> 24);
                                i19 = (-11) - (i36 | ((-15) - i19));
                                int length6 = bArr3.length;
                                int a6 = AbstractC0044j.a(bArr3.length);
                                int i55 = ((i19 > (((length6 & (~a6)) * 2) - (length6 ^ a6)) ? 1 : (i19 == (((length6 & (~a6)) * 2) - (length6 ^ a6)) ? 0 : -1)) >>> 31) & 1;
                                i21 = i55 != 0 ? -897645243 : 1251644638;
                                if (i55 != 0) {
                                    i21 = -1469476344;
                                }
                                j2Var = j2Var5;
                                z4 = false;
                                i8 = 1;
                            case 1758587480:
                                j2Var2 = j2Var;
                                int length7 = bArr3.length;
                                int i56 = 0 - i20;
                                i21 = (((double) ((byte) bArr4[((length7 | i56) - ((822835569 & (~i56)) & length7)) + ((i56 | 822835569) & length7)])) > Double.NaN ? 1 : (((double) ((byte) bArr4[((length7 | i56) - ((822835569 & (~i56)) & length7)) + ((i56 | 822835569) & length7)])) == Double.NaN ? 0 : -1)) <= -1 ? -897645243 : -1057239115;
                                i18 = i20;
                                j2Var = j2Var2;
                                z4 = false;
                            case 2013813686:
                                i20 = bArr3.length % 4;
                                j2Var2 = j2Var;
                                int i57 = ((i20 > i8 ? 1 : (i20 == i8 ? 0 : -1)) >>> 31) & i8;
                                i21 = i57 != 0 ? 2100390411 : -897645243;
                                if (i57 != 0) {
                                    j2Var = j2Var2;
                                    z4 = false;
                                } else {
                                    i3 = i8;
                                    i = i13;
                                    z3 = false;
                                    i13 = i;
                                    z4 = z3;
                                    j2Var = j2Var2;
                                    i8 = i3;
                                    i21 = -2079636786;
                                }
                            default:
                                i21 = -897645243;
                        }
                        throw new app.talsec.rasp.j2(new String(bArr, StandardCharsets.UTF_8).intern() + i7);
                    }
                case 62004:
                    return i4;
                case 20029:
                    i4 = 0;
                    i5 = 0;
                    c4 = 65115;
                case 65115:
                    c4 = i5 <= 28 ? (char) 7932 : (char) 516;
                case 65198:
                    i5 += 7;
                    c4 = 65115;
                case 7932:
                    C0096w0 c0096w0 = (C0096w0) this.f693b;
                    int i58 = this.f692a;
                    this.f692a = i58 + 1;
                    int d2 = c0096w0.d(i58);
                    int i59 = (d2 & 127) << i5;
                    int i60 = this.f692a;
                    i4 = (((((~i4) & i60) & i59) + i59) + i4) - ((i4 | i60) & i59);
                    c4 = (d2 & 128) == 0 ? (char) 62004 : (char) 65198;
                default:
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1, types: [android.widget.ListAdapter] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    public DialogInterfaceC0438h b() {
        int i;
        C0435e c0435e = (C0435e) this.f693b;
        DialogInterfaceC0438h dialogInterfaceC0438h = new DialogInterfaceC0438h(c0435e.f4783a, this.f692a);
        View view = c0435e.f4787e;
        C0437g c0437g = dialogInterfaceC0438h.f4829f;
        if (view != null) {
            c0437g.f4824w = view;
        } else {
            CharSequence charSequence = c0435e.f4786d;
            if (charSequence != null) {
                c0437g.f4807d = charSequence;
                TextView textView = c0437g.f4822u;
                if (textView != null) {
                    textView.setText(charSequence);
                }
            }
            Drawable drawable = c0435e.f4785c;
            if (drawable != null) {
                c0437g.f4820s = drawable;
                ImageView imageView = c0437g.f4821t;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    c0437g.f4821t.setImageDrawable(drawable);
                }
            }
        }
        String str = c0435e.f4788f;
        if (str != null) {
            c0437g.f4808e = str;
            TextView textView2 = c0437g.f4823v;
            if (textView2 != null) {
                textView2.setText(str);
            }
        }
        CharSequence charSequence2 = c0435e.f4789g;
        if (charSequence2 != null) {
            c0437g.c(-1, charSequence2, c0435e.f4790h);
        }
        CharSequence charSequence3 = c0435e.i;
        if (charSequence3 != null) {
            c0437g.c(-2, charSequence3, c0435e.f4791j);
        }
        if (c0435e.f4794m != null) {
            AlertController$RecycleListView alertController$RecycleListView = (AlertController$RecycleListView) c0435e.f4784b.inflate(c0437g.f4798A, (ViewGroup) null);
            if (c0435e.p) {
                i = c0437g.f4799B;
            } else {
                i = c0437g.f4800C;
            }
            Object obj = c0435e.f4794m;
            ?? r8 = obj;
            if (obj == null) {
                r8 = new ArrayAdapter(c0435e.f4783a, i, R.id.text1, (Object[]) null);
            }
            c0437g.f4825x = r8;
            c0437g.y = c0435e.f4797q;
            if (c0435e.f4795n != null) {
                alertController$RecycleListView.setOnItemClickListener(new C0434d(c0435e, c0437g));
            }
            if (c0435e.p) {
                alertController$RecycleListView.setChoiceMode(1);
            }
            c0437g.f4809f = alertController$RecycleListView;
        }
        View view2 = c0435e.f4796o;
        if (view2 != null) {
            c0437g.f4810g = view2;
            c0437g.f4811h = false;
        }
        dialogInterfaceC0438h.setCancelable(true);
        dialogInterfaceC0438h.setCanceledOnTouchOutside(true);
        dialogInterfaceC0438h.setOnCancelListener(c0435e.f4792k);
        dialogInterfaceC0438h.setOnDismissListener(null);
        l.n nVar = c0435e.f4793l;
        if (nVar != null) {
            dialogInterfaceC0438h.setOnKeyListener(nVar);
        }
        return dialogInterfaceC0438h;
    }

    public C0092v0(int i) {
        if (i > 0) {
            this.f693b = new Object[i];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    public C0092v0(Context context) {
        this(context, DialogInterfaceC0438h.e(context, 0));
    }

    public C0092v0(Context context, int i) {
        this.f693b = new C0435e(new ContextThemeWrapper(context, DialogInterfaceC0438h.e(context, i)));
        this.f692a = i;
    }

    public C0092v0() {
        this.f692a = 1;
        this.f693b = Collections.singletonList(null);
    }

    public C0092v0(ArrayList arrayList) {
        this.f692a = 0;
        this.f693b = arrayList;
    }

    public C0092v0(N0.b bVar) {
        ByteBuffer slice = bVar.c().slice();
        this.f693b = slice;
        slice.order(bVar.c().order());
        this.f692a = slice.remaining() / 4;
    }
}
