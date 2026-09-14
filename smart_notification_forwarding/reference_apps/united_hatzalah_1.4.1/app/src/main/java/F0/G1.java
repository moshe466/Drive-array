package F0;

import J.C0118f;
import J.InterfaceC0115c;
import a.AbstractC0228a;
import android.content.ClipData;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.InstallSourceInfo;
import android.content.pm.PackageInfo;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.ContentInfo;
import android.widget.TextView;
import c2.C0328a;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.android.gms.security.ProviderInstaller;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.MessageCodec;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import m.InterfaceC0533a0;
import m.InterfaceC0555l0;
import org.apache.tika.fork.ForkServer;
import t2.AbstractC0707i;
import t2.AbstractC0708j;
import t2.AbstractC0709k;

/* loaded from: classes.dex */
public class G1 implements F1.c, InterfaceC0115c, Y0.a, X1.h, InterfaceC0555l0, m.p1, InterfaceC0533a0, androidx.lifecycle.C {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f217a;

    /* renamed from: b, reason: collision with root package name */
    public Object f218b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ G1() {
        this(false);
        this.f217a = 0;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0047. Please report as an issue. */
    public static void i(byte[] bArr, byte[] bArr2) {
        int i;
        int i3;
        int i4 = 0;
        byte[] bArr3 = null;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 1180709023;
        byte[] bArr4 = null;
        while (true) {
            int i9 = ((i8 & 16777216) * (i8 | 16777216)) + ((i8 & (-16777217)) * ((~i8) & 16777216));
            int i10 = i8 >>> 8;
            int a2 = S.a(i10, i9, 1, ((-1) - i10) | ((-1) - i9));
            int i11 = (a2 ^ (-201803027)) + ((a2 & (-201803027)) * 2);
            int i12 = 1565752577;
            int i13 = 1621215041;
            switch ((i11 - 814310662) - ((i11 & (-814310662)) * 2)) {
                case -2000520841:
                    i = i4;
                    int length = bArr4.length;
                    int i14 = 0 - (0 - i5);
                    if ((bArr3[((length & (~i14)) * 2) - (length ^ i14)] > Double.NaN ? 1 : (bArr3[((length & (~i14)) * 2) - (length ^ i14)] == Double.NaN ? 0 : -1)) <= -1) {
                        i3 = i;
                    } else {
                        i3 = 1;
                    }
                    if (i3 == 0) {
                        i12 = 1621215041;
                    }
                    if (i3 != 0) {
                        i8 = i12;
                    } else {
                        i8 = -1164716566;
                    }
                    i7 = i5;
                    i4 = i;
                case -870579640:
                    int i15 = (i6 - 1) - (i6 | (-4));
                    byte b4 = bArr3[i15];
                    int i16 = ((b4 & ForkServer.DONE) * (b4 | ForkServer.DONE)) + ((b4 & ForkServer.ERROR) * ((~b4) & 16777216));
                    int i17 = i6 + 3 + (((-1) - i6) | (-3));
                    int i18 = bArr3[i17] & ForkServer.ERROR;
                    i = i4;
                    int i19 = i18 * ((~i18) & 65536);
                    int i20 = ~((((-1268032266) | (~i19)) | i16) - ((i19 & (-1268032266)) | i16));
                    int a4 = j3.a((-132004404) & i6, i6, 1, (-132004403) & i6);
                    int i21 = bArr3[a4] & ForkServer.ERROR;
                    int i22 = i21 * ((~i21) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int i23 = (i22 + i20) - (i22 & i20);
                    int i24 = bArr3[i6] & ForkServer.ERROR;
                    int i25 = ((~i24) & i23) + i24;
                    byte b5 = bArr4[i15];
                    int i26 = ((b5 & ForkServer.DONE) * (b5 | ForkServer.DONE)) + (((-16777217) & b5) * ((~b5) & 16777216));
                    int i27 = bArr4[i17] & ForkServer.ERROR;
                    int i28 = i27 * ((~i27) & 65536);
                    int i29 = ~((i26 | ((~i28) | (-1355861741))) - ((i28 & (-1355861741)) | i26));
                    int i30 = bArr4[a4] & ForkServer.ERROR;
                    int i31 = i30 * ((~i30) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    int a5 = S.a(i31, i29, 1, ((-1) - i31) | ((-1) - i29));
                    int i32 = (a5 - 1) - ((~(bArr4[i6] & ForkServer.ERROR)) | a5);
                    int i33 = i25 << ((i25 > Double.NaN ? 1 : (i25 == Double.NaN ? 0 : -1)) >>> 31);
                    int i34 = (i33 ^ (-418000873)) + ((i33 & (-418000873)) * 2);
                    int i35 = (i34 + i32) - ((i34 & i32) * 2);
                    bArr4[i6] = (byte) i35;
                    bArr4[a4] = (byte) (i35 >>> 8);
                    bArr4[i17] = (byte) (i35 >>> 16);
                    bArr4[i15] = (byte) (i35 >>> 24);
                    i6 = (i6 ^ 4) + ((i6 & 4) * 2);
                    int length2 = bArr4.length;
                    int a6 = AbstractC0044j.a(bArr4.length);
                    if ((((i6 > (((length2 & (~a6)) * 2) - (length2 ^ a6)) ? 1 : (i6 == (((length2 & (~a6)) * 2) - (length2 ^ a6)) ? 0 : -1)) >>> 31) & 1) != 0) {
                        i8 = 1910359311;
                    } else {
                        i8 = 1621215041;
                    }
                    i4 = i;
                case -97532338:
                    i5 = bArr4.length % 4;
                    int i36 = ((i5 > 1 ? 1 : (i5 == 1 ? 0 : -1)) >>> 31) & 1;
                    if (i36 != 0) {
                        i13 = 986083301;
                    }
                    if (i36 != 0) {
                        i8 = i13;
                    } else {
                        i8 = -1138188205;
                    }
                case 298177592:
                    int length3 = bArr4.length;
                    int i37 = 0 - i7;
                    int a7 = AbstractC0014b1.a((length3 & 2) | D1.a(i37, length3), i37 * 3);
                    byte b6 = bArr3[a7];
                    int length4 = bArr4.length;
                    int i38 = 0 - i37;
                    int i39 = i38 | length4;
                    byte b7 = bArr3[D.a(i38, 2, i39, (length4 ^ i38) ^ i39)];
                    bArr3[a7] = (byte) (((byte) (b7 ^ b6)) + ((byte) (((byte) 2) * ((byte) (b7 & b6)))));
                    i8 = 1565752577;
                case 373627814:
                    break;
                case 975213712:
                    int length5 = bArr4.length;
                    int i40 = 0 - i7;
                    int length6 = bArr4.length;
                    int i41 = ~i40;
                    byte b8 = bArr4[((length6 | i40) - (((-656070458) & i41) & length6)) + ((i40 | (-656070458)) & length6)];
                    int length7 = bArr4.length;
                    byte b9 = bArr3[(length7 ^ i41) + ((length7 | i40) * 2) + 1];
                    bArr4[((length5 | i40) * 2) - (length5 ^ i40)] = (byte) (((byte) (b9 - b8)) + ((byte) (((byte) 2) * ((byte) ((~b9) & b8)))));
                    i5 = (~i7) + (i7 * 2);
                    int i42 = ((i7 > 2 ? 1 : (i7 == 2 ? 0 : -1)) >>> 31) & 1;
                    if (i42 != 0) {
                        i13 = 986083301;
                    }
                    if (i42 != 0) {
                        i8 = i13;
                    } else {
                        i8 = -1138188205;
                    }
                case 1548321255:
                    int length8 = bArr.length;
                    int length9 = 0 - (0 - (bArr.length % 4));
                    if ((length8 & (~length9)) - ((~length8) & length9) <= 0) {
                        i8 = 1621215041;
                    } else {
                        i8 = 1910359311;
                    }
                    bArr3 = bArr2;
                    bArr4 = bArr;
                    i6 = i4;
                default:
                    i8 = i13;
            }
            return;
        }
    }

    public static ArrayList j(NetworkCapabilities networkCapabilities) {
        ArrayList arrayList = new ArrayList();
        if (networkCapabilities != null && networkCapabilities.hasCapability(12)) {
            if (networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(5)) {
                arrayList.add("wifi");
            }
            if (networkCapabilities.hasTransport(3)) {
                arrayList.add("ethernet");
            }
            if (networkCapabilities.hasTransport(4)) {
                arrayList.add("vpn");
            }
            if (networkCapabilities.hasTransport(0)) {
                arrayList.add("mobile");
            }
            if (networkCapabilities.hasTransport(2)) {
                arrayList.add("bluetooth");
            }
            if (arrayList.isEmpty() && networkCapabilities.hasCapability(12)) {
                arrayList.add("other");
            }
            if (arrayList.isEmpty()) {
                arrayList.add(DevicePublicKeyStringDef.NONE);
            }
            return arrayList;
        }
        arrayList.add(DevicePublicKeyStringDef.NONE);
        return arrayList;
    }

    @Override // J.InterfaceC0115c
    public void b(Uri uri) {
        ((ContentInfo.Builder) this.f218b).setLinkUri(uri);
    }

    @Override // J.InterfaceC0115c
    public C0118f build() {
        ContentInfo build;
        build = ((ContentInfo.Builder) this.f218b).build();
        return new C0118f(new C0035g2(build));
    }

    @Override // J.InterfaceC0115c
    public void c(int i) {
        ((ContentInfo.Builder) this.f218b).setFlags(i);
    }

    @Override // Y0.a
    public void d(byte[] bArr, int i, int i3) {
        for (MessageDigest messageDigest : (MessageDigest[]) this.f218b) {
            messageDigest.update(bArr, 0, i3);
        }
    }

    @Override // Y0.a
    public void e(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        for (MessageDigest messageDigest : (MessageDigest[]) this.f218b) {
            byteBuffer.position(position);
            messageDigest.update(byteBuffer);
        }
    }

    @Override // androidx.lifecycle.C
    public void g(Object obj) {
        CharSequence charSequence = (CharSequence) obj;
        q.I i = (q.I) this.f218b;
        Handler handler = i.f6011a;
        G.a aVar = i.f6012b;
        handler.removeCallbacks(aVar);
        TextView textView = i.f6017j;
        if (textView != null) {
            textView.setText(charSequence);
        }
        handler.postDelayed(aVar, 2000L);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:17:0x006a. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0006. Please report as an issue. */
    public ArrayList h() {
        String str;
        Iterator it;
        ArrayList arrayList;
        Object obj;
        String str2;
        String str3;
        String str4;
        String str5;
        char c4;
        String str6;
        String str7;
        String str8;
        String str9;
        Iterator it2;
        ArrayList arrayList2;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        char c5;
        String str15;
        char c6;
        boolean z3;
        char c7 = 17065;
        Iterator it3 = null;
        ArrayList arrayList3 = null;
        Object obj2 = null;
        while (true) {
            switch (c7) {
                case 8793:
                    Iterator it4 = it3;
                    ArrayList arrayList4 = arrayList3;
                    c7 = it4.hasNext() ? (char) 58794 : (char) 10191;
                    it3 = it4;
                    arrayList3 = arrayList4;
                case 58794:
                    Object next = it3.next();
                    F1 f12 = (F1) next;
                    int i = f12.f206j;
                    String str16 = f12.f201d;
                    String str17 = f12.f205h;
                    String str18 = f12.f198a;
                    String str19 = f12.f204g;
                    String str20 = f12.f200c;
                    String str21 = f12.f199b;
                    String str22 = f12.f202e;
                    String str23 = f12.f203f;
                    char c8 = 58936;
                    boolean z4 = false;
                    F1 f13 = null;
                    F1 f14 = null;
                    while (true) {
                        switch (c8) {
                            case 57669:
                                str = str23;
                                it = it3;
                                arrayList = arrayList3;
                                obj = next;
                                str6 = str17;
                                str7 = str18;
                                str8 = str20;
                                str9 = str21;
                                if (f12.b(str8)) {
                                    str17 = str6;
                                    str18 = str7;
                                    str21 = str9;
                                    str20 = str8;
                                    str23 = str;
                                    it3 = it;
                                    arrayList3 = arrayList;
                                    c8 = 32716;
                                    next = obj;
                                } else {
                                    str17 = str6;
                                    str18 = str7;
                                    str21 = str9;
                                    str20 = str8;
                                    str23 = str;
                                    c8 = 459;
                                    it3 = it;
                                    arrayList3 = arrayList;
                                    next = obj;
                                }
                            case 19676:
                                it2 = it3;
                                arrayList2 = arrayList3;
                                f12.f207k++;
                                str23 = str23;
                                c8 = 16831;
                                it3 = it2;
                                arrayList3 = arrayList2;
                            case 9804:
                                it2 = it3;
                                arrayList2 = arrayList3;
                                f12.f207k++;
                                str23 = str23;
                                c8 = 16350;
                                it3 = it2;
                                arrayList3 = arrayList2;
                            case 58148:
                                it = it3;
                                arrayList = arrayList3;
                                obj = next;
                                int i3 = ~f12.f207k;
                                f12.f207k = i3 - (i3 * 2);
                                str23 = str23;
                                c8 = 19292;
                                it3 = it;
                                arrayList3 = arrayList;
                                next = obj;
                            case 1687:
                                str = str23;
                                it = it3;
                                arrayList = arrayList3;
                                obj = next;
                                str10 = str17;
                                str11 = str18;
                                str4 = str20;
                                str12 = str21;
                                if (f12.j(str12)) {
                                    str17 = str10;
                                    str18 = str11;
                                    str21 = str12;
                                    str23 = str;
                                    it3 = it;
                                    next = obj;
                                    str20 = str4;
                                    c8 = 44117;
                                    arrayList3 = arrayList;
                                } else {
                                    str17 = str10;
                                    str18 = str11;
                                    str21 = str12;
                                    str23 = str;
                                    c8 = 4145;
                                    it3 = it;
                                    arrayList3 = arrayList;
                                    next = obj;
                                    str20 = str4;
                                }
                            case 16831:
                                str = str23;
                                it = it3;
                                arrayList = arrayList3;
                                obj = next;
                                str2 = str17;
                                str3 = str18;
                                str4 = str20;
                                str5 = str21;
                                if (str19 != null) {
                                    c4 = 41338;
                                    str17 = str2;
                                    str18 = str3;
                                    str23 = str;
                                    arrayList3 = arrayList;
                                    next = obj;
                                    str20 = str4;
                                    str21 = str5;
                                    c8 = c4;
                                    it3 = it;
                                } else {
                                    str17 = str2;
                                    str18 = str3;
                                    str23 = str;
                                    c8 = 19292;
                                    it3 = it;
                                    arrayList3 = arrayList;
                                    next = obj;
                                    str20 = str4;
                                    str21 = str5;
                                }
                            case 39020:
                                str = str23;
                                it = it3;
                                arrayList = arrayList3;
                                obj = next;
                                str2 = str17;
                                str3 = str18;
                                str4 = str20;
                                str5 = str21;
                                if (f12.k(str3)) {
                                    c4 = 40918;
                                    str17 = str2;
                                    str18 = str3;
                                    str23 = str;
                                    arrayList3 = arrayList;
                                    next = obj;
                                    str20 = str4;
                                    str21 = str5;
                                    c8 = c4;
                                    it3 = it;
                                } else {
                                    str17 = str2;
                                    str18 = str3;
                                    str23 = str;
                                    c8 = 57314;
                                    it3 = it;
                                    arrayList3 = arrayList;
                                    next = obj;
                                    str20 = str4;
                                    str21 = str5;
                                }
                            case 61549:
                                break;
                            case 459:
                                str = str23;
                                it = it3;
                                arrayList = arrayList3;
                                obj = next;
                                str13 = str17;
                                str14 = str18;
                                str4 = str20;
                                str5 = str21;
                                if (str16 != null) {
                                    c5 = 26600;
                                    str17 = str13;
                                    str23 = str;
                                    it3 = it;
                                    arrayList3 = arrayList;
                                    next = obj;
                                    str20 = str4;
                                    str21 = str5;
                                    str18 = str14;
                                    c8 = c5;
                                } else {
                                    str17 = str13;
                                    str23 = str;
                                    c8 = 6853;
                                    it3 = it;
                                    arrayList3 = arrayList;
                                    next = obj;
                                    str20 = str4;
                                    str21 = str5;
                                    str18 = str14;
                                }
                            case 32716:
                                f12.f207k++;
                                str23 = str23;
                                c8 = 459;
                            case 15155:
                                str = str23;
                                it = it3;
                                arrayList = arrayList3;
                                obj = next;
                                str13 = str17;
                                str14 = str18;
                                str4 = str20;
                                str5 = str21;
                                if (f13.f(str13)) {
                                    c5 = 28703;
                                    str17 = str13;
                                    str23 = str;
                                    it3 = it;
                                    arrayList3 = arrayList;
                                    next = obj;
                                    str20 = str4;
                                    str21 = str5;
                                    str18 = str14;
                                    c8 = c5;
                                } else {
                                    str17 = str13;
                                    str23 = str;
                                    c8 = 34506;
                                    it3 = it;
                                    arrayList3 = arrayList;
                                    next = obj;
                                    str20 = str4;
                                    str21 = str5;
                                    str18 = str14;
                                }
                            case 62472:
                                z4 = false;
                                c8 = 61549;
                            case 26600:
                                c8 = 32837;
                                str23 = str23;
                                f14 = f12;
                            case 32837:
                                str = str23;
                                it = it3;
                                arrayList = arrayList3;
                                obj = next;
                                str15 = str17;
                                str14 = str18;
                                str4 = str20;
                                str5 = str21;
                                if (f14.d(str16)) {
                                    c6 = 21756;
                                    String str24 = str;
                                    c8 = c6;
                                    str23 = str24;
                                    it3 = it;
                                    arrayList3 = arrayList;
                                    next = obj;
                                    str20 = str4;
                                    str21 = str5;
                                    str17 = str15;
                                    str18 = str14;
                                } else {
                                    str13 = str15;
                                    str17 = str13;
                                    str23 = str;
                                    c8 = 6853;
                                    it3 = it;
                                    arrayList3 = arrayList;
                                    next = obj;
                                    str20 = str4;
                                    str21 = str5;
                                    str18 = str14;
                                }
                            case 37015:
                                c8 = 15155;
                                str23 = str23;
                                f13 = f12;
                            case 21756:
                                f12.f207k++;
                                str23 = str23;
                                c8 = 6853;
                            case 16350:
                                str = str23;
                                it = it3;
                                arrayList = arrayList3;
                                obj = next;
                                str15 = str17;
                                str14 = str18;
                                str4 = str20;
                                str5 = str21;
                                if (str != null) {
                                    c6 = 52770;
                                    String str242 = str;
                                    c8 = c6;
                                    str23 = str242;
                                    it3 = it;
                                    arrayList3 = arrayList;
                                    next = obj;
                                    str20 = str4;
                                    str21 = str5;
                                    str17 = str15;
                                    str18 = str14;
                                }
                                str23 = str;
                                c8 = 16831;
                                it3 = it;
                                arrayList3 = arrayList;
                                next = obj;
                                str20 = str4;
                                str21 = str5;
                                str17 = str15;
                                str18 = str14;
                            case 19292:
                                str = str23;
                                it = it3;
                                arrayList = arrayList3;
                                obj = next;
                                str15 = str17;
                                str14 = str18;
                                str4 = str20;
                                str5 = str21;
                                if (str15 != null) {
                                    c6 = 37015;
                                    String str2422 = str;
                                    c8 = c6;
                                    str23 = str2422;
                                    it3 = it;
                                    arrayList3 = arrayList;
                                    next = obj;
                                    str20 = str4;
                                    str21 = str5;
                                    str17 = str15;
                                    str18 = str14;
                                } else {
                                    str13 = str15;
                                    str17 = str13;
                                    str23 = str;
                                    c8 = 34506;
                                    it3 = it;
                                    arrayList3 = arrayList;
                                    next = obj;
                                    str20 = str4;
                                    str21 = str5;
                                    str18 = str14;
                                }
                            case 34506:
                                str = str23;
                                it = it3;
                                arrayList = arrayList3;
                                obj = next;
                                str15 = str17;
                                str14 = str18;
                                str4 = str20;
                                str5 = str21;
                                c6 = f12.f207k == i ? '0' : (char) 62472;
                                String str24222 = str;
                                c8 = c6;
                                str23 = str24222;
                                it3 = it;
                                arrayList3 = arrayList;
                                next = obj;
                                str20 = str4;
                                str21 = str5;
                                str17 = str15;
                                str18 = str14;
                            case '0':
                                z4 = true;
                                c8 = 61549;
                            case 6853:
                                str = str23;
                                it = it3;
                                arrayList = arrayList3;
                                obj = next;
                                str15 = str17;
                                str14 = str18;
                                str4 = str20;
                                str5 = str21;
                                if (str22 != null) {
                                    c6 = 58862;
                                    String str242222 = str;
                                    c8 = c6;
                                    str23 = str242222;
                                    it3 = it;
                                    arrayList3 = arrayList;
                                    next = obj;
                                    str20 = str4;
                                    str21 = str5;
                                    str17 = str15;
                                    str18 = str14;
                                }
                                str23 = str;
                                c8 = 16350;
                                it3 = it;
                                arrayList3 = arrayList;
                                next = obj;
                                str20 = str4;
                                str21 = str5;
                                str17 = str15;
                                str18 = str14;
                            case 58936:
                                str = str23;
                                it = it3;
                                arrayList = arrayList3;
                                obj = next;
                                str15 = str17;
                                str14 = str18;
                                str4 = str20;
                                str5 = str21;
                                if (str14 != null) {
                                    c6 = 39020;
                                    String str2422222 = str;
                                    c8 = c6;
                                    str23 = str2422222;
                                    it3 = it;
                                    arrayList3 = arrayList;
                                    next = obj;
                                    str20 = str4;
                                    str21 = str5;
                                    str17 = str15;
                                    str18 = str14;
                                } else {
                                    str2 = str15;
                                    str3 = str14;
                                    str17 = str2;
                                    str18 = str3;
                                    str23 = str;
                                    c8 = 57314;
                                    it3 = it;
                                    arrayList3 = arrayList;
                                    next = obj;
                                    str20 = str4;
                                    str21 = str5;
                                }
                            case 44117:
                                String str25 = str23;
                                int i4 = ~f12.f207k;
                                f12.f207k = i4 - (i4 * 2);
                                str23 = str25;
                                c8 = 4145;
                            case 40918:
                                String str26 = str23;
                                int i5 = f12.f207k;
                                f12.f207k = (i5 & 1) - ((~i5) | 1);
                                str23 = str26;
                                c8 = 57314;
                            case 41338:
                                str = str23;
                                it = it3;
                                arrayList = arrayList3;
                                obj = next;
                                str15 = str17;
                                str14 = str18;
                                str4 = str20;
                                str5 = str21;
                                if (f12.l(str19)) {
                                    c6 = 58148;
                                    String str24222222 = str;
                                    c8 = c6;
                                    str23 = str24222222;
                                    it3 = it;
                                    arrayList3 = arrayList;
                                    next = obj;
                                    str20 = str4;
                                    str21 = str5;
                                    str17 = str15;
                                    str18 = str14;
                                } else {
                                    str2 = str15;
                                    str3 = str14;
                                    str17 = str2;
                                    str18 = str3;
                                    str23 = str;
                                    c8 = 19292;
                                    it3 = it;
                                    arrayList3 = arrayList;
                                    next = obj;
                                    str20 = str4;
                                    str21 = str5;
                                }
                            case 4145:
                                str = str23;
                                it = it3;
                                arrayList = arrayList3;
                                obj = next;
                                str15 = str17;
                                str14 = str18;
                                str4 = str20;
                                str5 = str21;
                                if (str4 != null) {
                                    c6 = 57669;
                                    String str242222222 = str;
                                    c8 = c6;
                                    str23 = str242222222;
                                    it3 = it;
                                    arrayList3 = arrayList;
                                    next = obj;
                                    str20 = str4;
                                    str21 = str5;
                                    str17 = str15;
                                    str18 = str14;
                                } else {
                                    str8 = str4;
                                    str9 = str5;
                                    str6 = str15;
                                    str7 = str14;
                                    str17 = str6;
                                    str18 = str7;
                                    str21 = str9;
                                    str20 = str8;
                                    str23 = str;
                                    c8 = 459;
                                    it3 = it;
                                    arrayList3 = arrayList;
                                    next = obj;
                                }
                            case 28703:
                                f12.f207k++;
                                str23 = str23;
                                c8 = 34506;
                            case 57314:
                                str = str23;
                                it = it3;
                                arrayList = arrayList3;
                                obj = next;
                                str15 = str17;
                                str14 = str18;
                                str4 = str20;
                                str5 = str21;
                                if (str5 != null) {
                                    c6 = 1687;
                                    String str2422222222 = str;
                                    c8 = c6;
                                    str23 = str2422222222;
                                    it3 = it;
                                    arrayList3 = arrayList;
                                    next = obj;
                                    str20 = str4;
                                    str21 = str5;
                                    str17 = str15;
                                    str18 = str14;
                                } else {
                                    str12 = str5;
                                    str10 = str15;
                                    str11 = str14;
                                    str17 = str10;
                                    str18 = str11;
                                    str21 = str12;
                                    str23 = str;
                                    c8 = 4145;
                                    it3 = it;
                                    arrayList3 = arrayList;
                                    next = obj;
                                    str20 = str4;
                                }
                            case 58862:
                                str = str23;
                                it = it3;
                                arrayList = arrayList3;
                                obj = next;
                                str15 = str17;
                                str14 = str18;
                                str4 = str20;
                                str5 = str21;
                                if (f12.h(str22)) {
                                    c6 = 9804;
                                    String str24222222222 = str;
                                    c8 = c6;
                                    str23 = str24222222222;
                                    it3 = it;
                                    arrayList3 = arrayList;
                                    next = obj;
                                    str20 = str4;
                                    str21 = str5;
                                    str17 = str15;
                                    str18 = str14;
                                }
                                str23 = str;
                                c8 = 16350;
                                it3 = it;
                                arrayList3 = arrayList;
                                next = obj;
                                str20 = str4;
                                str21 = str5;
                                str17 = str15;
                                str18 = str14;
                            case 52770:
                                try {
                                    z3 = kotlin.jvm.internal.j.a(str23, Build.MODEL);
                                    str = str23;
                                    it = it3;
                                    arrayList = arrayList3;
                                    obj = next;
                                    str15 = str17;
                                    str14 = str18;
                                    str4 = str20;
                                    str5 = str21;
                                } catch (NoSuchFieldError unused) {
                                    str = str23;
                                    int i6 = f12.f207k;
                                    it = it3;
                                    int i7 = ~i6;
                                    int i8 = (i7 | (-1178622237)) & (-1543369133);
                                    arrayList = arrayList3;
                                    long j2 = 177516800;
                                    long j3 = i6 & 76548368;
                                    long b4 = c3.b((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48, ((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), ((((((((j3 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j3 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j3 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j3 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)), 6148914691236517205L);
                                    long j4 = (b4 >>> 48) & 43690;
                                    long j5 = ((j4 >>> 2) | (j4 >>> 1)) & 858993459;
                                    long j6 = ((j5 >>> 2) | j5) & 252645135;
                                    long j7 = (b4 >>> 32) & 43690;
                                    long j8 = ((j7 >>> 2) | (j7 >>> 1)) & 858993459;
                                    long j9 = ((j8 >>> 2) | j8) & 252645135;
                                    long j10 = ((((j9 >>> 4) | j9) & 16711935) << 16) + ((((j6 >>> 4) | j6) & 16711935) << 24);
                                    long j11 = (b4 >>> 16) & 43690;
                                    long j12 = ((j11 >>> 2) | (j11 >>> 1)) & 858993459;
                                    long j13 = ((j12 >>> 2) | j12) & 252645135;
                                    long j14 = b4 & 43690;
                                    long j15 = ((j14 >>> 2) | (j14 >>> 1)) & 858993459;
                                    long j16 = ((j15 >>> 2) | j15) & 252645135;
                                    byte[] bArr = {119, (i8 + ((int) ((((j16 >>> 4) | j16) & 16711935) + (((((j13 >>> 4) | j13) & 16711935) << 8) | j10)))) ^ (-1365852381), 113, -87, 97, -8, 19, (((i7 | (-15672454)) & (-1741678526)) + ((i6 & 35685385) | 100983817)) ^ (-1640694700), 109, 115, 20, -15, 123, -105, -47, -67};
                                    F1.c(bArr, new byte[]{57, 31, 34, -36, 2, -112, 85, 118, 8, 31, 112, -76, 9, -27, -66, -49});
                                    Charset charset = StandardCharsets.UTF_8;
                                    new String(bArr, charset).intern();
                                    byte[] bArr2 = new byte[39];
                                    bArr2[0] = 21;
                                    int i9 = f12.f207k;
                                    obj = next;
                                    int i10 = ~i9;
                                    str4 = str20;
                                    str5 = str21;
                                    long j17 = 34588713;
                                    long j18 = i10;
                                    long j19 = (((((((((j17 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j17 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j17 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j17 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (((((((((j18 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j18 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j18 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j18 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + 6148914691236517205L;
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
                                    long j30 = ((((j29 >>> 4) | j29) & 16711935) << 8) + j26;
                                    long j31 = j19 & 43690;
                                    long j32 = ((j31 >>> 2) | (j31 >>> 1)) & 858993459;
                                    long j33 = ((j32 >>> 2) | j32) & 252645135;
                                    bArr2[1] = ((((int) ((((j33 >>> 4) | j33) & 16711935) | j30)) & (-1836356091)) + ((i9 & (-1869601274)) | 1158713346)) ^ (-677642660);
                                    bArr2[2] = -89;
                                    bArr2[3] = 116;
                                    bArr2[4] = -20;
                                    bArr2[5] = -30;
                                    bArr2[6] = 74;
                                    bArr2[7] = 23;
                                    bArr2[8] = -36;
                                    bArr2[9] = 29;
                                    int i11 = ~i;
                                    long j34 = 462096653;
                                    long j35 = i11;
                                    long j36 = (((((j35 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845;
                                    long j37 = (((((((j35 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16;
                                    long j38 = (((((((j35 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32;
                                    long j39 = (((((((j35 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48;
                                    long j40 = (((((((((j34 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j34 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j34 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j34 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + (j39 | j38 | j37 | j36) + 6148914691236517205L;
                                    long j41 = (j40 >>> 48) & 43690;
                                    long j42 = ((j41 >>> 2) | (j41 >>> 1)) & 858993459;
                                    long j43 = ((j42 >>> 2) | j42) & 252645135;
                                    long j44 = (j40 >>> 32) & 43690;
                                    long j45 = ((j44 >>> 2) | (j44 >>> 1)) & 858993459;
                                    long j46 = ((j45 >>> 2) | j45) & 252645135;
                                    long j47 = ((((j46 >>> 4) | j46) & 16711935) << 16) + ((((j43 >>> 4) | j43) & 16711935) << 24);
                                    long j48 = (j40 >>> 16) & 43690;
                                    long j49 = ((j48 >>> 2) | (j48 >>> 1)) & 858993459;
                                    long j50 = ((j49 >>> 2) | j49) & 252645135;
                                    long j51 = j40 & 43690;
                                    long j52 = ((j51 >>> 2) | (j51 >>> 1)) & 858993459;
                                    long j53 = ((j52 >>> 2) | j52) & 252645135;
                                    bArr2[((((int) ((((j53 >>> 4) | j53) & 16711935) | (((((j50 >>> 4) | j50) & 16711935) << 8) + j47))) & 336087040) + ((67125440 & i) | 4194528)) ^ 340281578] = -103;
                                    bArr2[11] = 101;
                                    bArr2[12] = ((1376912713 & (1456901100 - ((~i11) | 1456901101))) + ((136340482 & i) | 220258434)) ^ 1597171105;
                                    bArr2[13] = 53;
                                    bArr2[14] = 696562544 ^ ((((134226442 & i) + 687898632) - (i & 134217736)) + ((1978602861 | i11) & 8663842));
                                    bArr2[15] = -75;
                                    bArr2[16] = -6;
                                    bArr2[17] = ((((-2798503) | i10) & 1099498644) + ((i9 & 4718725) | 6294025)) ^ 1105792665;
                                    bArr2[18] = 46;
                                    bArr2[19] = -101;
                                    bArr2[20] = -26;
                                    bArr2[21] = -68;
                                    bArr2[22] = 80;
                                    bArr2[23] = -124;
                                    bArr2[24] = -40;
                                    bArr2[25] = 83;
                                    bArr2[26] = -120;
                                    bArr2[27] = 55;
                                    int i12 = 1073837729 & i;
                                    bArr2[28] = (((((i - 1) - (i * 2)) | (-1087600171)) & 1075963748) + (~(((i9 | (-25170058)) | i12) - ((i9 & 25170057) | i12)))) ^ (-1101133765);
                                    bArr2[29] = 79;
                                    bArr2[30] = -41;
                                    bArr2[31] = 115;
                                    long j54 = 1479894392;
                                    long j55 = (((((((((j54 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j54 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j54 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j54 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + j39 + (j38 | (j37 + j36)) + 6148914691236517205L;
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
                                    bArr2[32] = ((((int) ((((j68 >>> 4) | j68) & 16711935) | (((((j65 >>> 4) | j65) & 16711935) << 8) + j62))) & 391188696) + ((123736224 & i) | (-2145336288))) ^ 1754147618;
                                    bArr2[33] = 96;
                                    bArr2[34] = 6;
                                    bArr2[35] = -87;
                                    bArr2[36] = 25;
                                    bArr2[37] = -122;
                                    bArr2[38] = 88;
                                    byte[] bArr3 = new byte[39];
                                    bArr3[0] = 80;
                                    bArr3[1] = 41;
                                    bArr3[2] = -43;
                                    bArr3[3] = 27;
                                    str15 = str17;
                                    str14 = str18;
                                    long j69 = 38158914;
                                    long j70 = i11 | 4587459;
                                    long j71 = (((((((((j69 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j69 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j69 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j69 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + ((((((((j70 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j70 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j70 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j70 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845));
                                    long j72 = (j71 >>> 48) & 43690;
                                    long j73 = ((j72 >>> 2) | (j72 >>> 1)) & 858993459;
                                    long j74 = ((j73 >>> 2) | j73) & 252645135;
                                    long j75 = (j71 >>> 32) & 43690;
                                    long j76 = ((j75 >>> 2) | (j75 >>> 1)) & 858993459;
                                    long j77 = ((j76 >>> 2) | j76) & 252645135;
                                    long j78 = ((((j77 >>> 4) | j77) & 16711935) << 16) | ((((j74 >>> 4) | j74) & 16711935) << 24);
                                    long j79 = (j71 >>> 16) & 43690;
                                    long j80 = ((j79 >>> 2) | (j79 >>> 1)) & 858993459;
                                    long j81 = ((j80 >>> 2) | j80) & 252645135;
                                    long j82 = j71 & 43690;
                                    long j83 = ((j82 >>> 2) | (j82 >>> 1)) & 858993459;
                                    long j84 = ((j83 >>> 2) | j83) & 252645135;
                                    bArr3[4] = (((int) ((((j84 >>> 4) | j84) & 16711935) + (((((j81 >>> 4) | j81) & 16711935) << 8) | j78))) + ((302121220 & i) | (-1876950740))) ^ 1838791920;
                                    bArr3[5] = -62;
                                    bArr3[6] = 61;
                                    bArr3[7] = Byte.MAX_VALUE;
                                    bArr3[8] = -75;
                                    bArr3[9] = 113;
                                    long j85 = 537019524;
                                    long j86 = 1854556911 | i10;
                                    long j87 = ((((((((j85 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + ((((((((j85 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j85 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j85 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((j86 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j86 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j86 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j86 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
                                    long j88 = (j87 >>> 48) & 43690;
                                    long j89 = ((j88 >>> 2) | (j88 >>> 1)) & 858993459;
                                    long j90 = ((j89 >>> 2) | j89) & 252645135;
                                    long j91 = (j87 >>> 32) & 43690;
                                    long j92 = ((j91 >>> 2) | (j91 >>> 1)) & 858993459;
                                    long j93 = ((j92 >>> 2) | j92) & 252645135;
                                    long j94 = ((((j93 >>> 4) | j93) & 16711935) << 16) + ((((j90 >>> 4) | j90) & 16711935) << 24);
                                    long j95 = (j87 >>> 16) & 43690;
                                    long j96 = ((j95 >>> 2) | (j95 >>> 1)) & 858993459;
                                    long j97 = ((j96 >>> 2) | j96) & 252645135;
                                    long j98 = j87 & 43690;
                                    long j99 = ((j98 >>> 2) | (j98 >>> 1)) & 858993459;
                                    long j100 = ((j99 >>> 2) | j99) & 252645135;
                                    int i13 = (int) ((((j100 >>> 4) | j100) & 16711935) | ((((j97 >>> 4) | j97) & 16711935) << 8) | j94);
                                    int i14 = (i9 | (-2098177)) - (-2098177);
                                    int i15 = i13 + (~(((i9 | (-2100017)) | i14) - (i14 | (i9 & 2100016))));
                                    bArr3[10] = (((~i15) & (-539119544)) - ((-539119544) & i15)) + i15;
                                    bArr3[11] = 69;
                                    bArr3[12] = 11;
                                    bArr3[((((-1219910689) | i10) & 570427562) + ((i9 & (-2139092960)) | (-2004868608))) ^ (-1434441049)] = 86;
                                    bArr3[14] = 57;
                                    bArr3[15] = -48;
                                    bArr3[16] = -119;
                                    bArr3[17] = ((((-30186846) | i10) & 338692608) + ((i9 & 329872) | (-2147155820))) ^ (-1808463133);
                                    bArr3[18] = 71;
                                    bArr3[19] = -11;
                                    bArr3[20] = -127;
                                    bArr3[21] = -100;
                                    bArr3[22] = 18;
                                    bArr3[23] = -15;
                                    bArr3[24] = -79;
                                    bArr3[25] = 63;
                                    bArr3[26] = -20;
                                    bArr3[27] = 25;
                                    bArr3[28] = -101;
                                    bArr3[29] = 0;
                                    bArr3[30] = -109;
                                    bArr3[31] = 54;
                                    bArr3[32] = -106;
                                    bArr3[33] = 64;
                                    bArr3[34] = 96;
                                    bArr3[35] = -64;
                                    bArr3[36] = 124;
                                    bArr3[37] = -22;
                                    int i16 = ((-268435521) | i10) + 281023555 + ((i9 & 269639744) | 1794048);
                                    bArr3[B0.a((~i16) | 282817636, 282817636 - i16)] = 60;
                                    F1.c(bArr2, bArr3);
                                    new String(bArr2, charset).intern();
                                    z3 = false;
                                }
                                if (z3) {
                                    c6 = 19676;
                                    String str242222222222 = str;
                                    c8 = c6;
                                    str23 = str242222222222;
                                    it3 = it;
                                    arrayList3 = arrayList;
                                    next = obj;
                                    str20 = str4;
                                    str21 = str5;
                                    str17 = str15;
                                    str18 = str14;
                                }
                                str23 = str;
                                c8 = 16831;
                                it3 = it;
                                arrayList3 = arrayList;
                                next = obj;
                                str20 = str4;
                                str21 = str5;
                                str17 = str15;
                                str18 = str14;
                            default:
                                str = str23;
                                it = it3;
                                arrayList = arrayList3;
                                obj = next;
                                str2 = str17;
                                str3 = str18;
                                str4 = str20;
                                str5 = str21;
                                c4 = 40918;
                                str17 = str2;
                                str18 = str3;
                                str23 = str;
                                arrayList3 = arrayList;
                                next = obj;
                                str20 = str4;
                                str21 = str5;
                                c8 = c4;
                                it3 = it;
                        }
                        Iterator it5 = it3;
                        ArrayList arrayList5 = arrayList3;
                        Object obj3 = next;
                        if (z4) {
                            c7 = 19390;
                            it3 = it5;
                            arrayList3 = arrayList5;
                            obj2 = obj3;
                        } else {
                            it3 = it5;
                            arrayList3 = arrayList5;
                            obj2 = obj3;
                            c7 = 8793;
                        }
                    }
                case 19390:
                    arrayList3.add(obj2);
                    c7 = 8793;
                case 10191:
                    break;
                case 17065:
                    List list = (List) this.f218b;
                    arrayList3 = new ArrayList();
                    it3 = list.iterator();
                    c7 = 8793;
                default:
                    c7 = 17065;
            }
            return arrayList3;
        }
    }

    @Override // X1.h
    public Object k(String str) {
        A.n nVar = (A.n) this.f218b;
        String[] strArr = {ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL"};
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (int i3 = 0; i3 < 2; i3++) {
            Provider provider = Security.getProvider(strArr[i3]);
            if (provider != null) {
                arrayList.add(provider);
            }
        }
        int size = arrayList.size();
        Exception exc = null;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            try {
                return nVar.b(str, (Provider) obj);
            } catch (Exception e4) {
                if (exc == null) {
                    exc = e4;
                }
            }
        }
        return nVar.b(str, null);
    }

    public R.k0 l() {
        S2.y yVar = (S2.y) this.f218b;
        yVar.getClass();
        Object obj = S2.y.f2243e.get(yVar);
        if (obj == T2.j.f2291a) {
            obj = null;
        }
        return (R.k0) obj;
    }

    public void m(ArrayList arrayList) {
        String str;
        String str2;
        String valueOf;
        String str3;
        InstallSourceInfo installSourceInfo;
        String installingPackageName;
        long longVersionCode;
        K0.d dVar = (K0.d) this.f218b;
        Context context = dVar.f1070a;
        if (context != null) {
            ArrayList arrayList2 = new ArrayList(AbstractC0709k.Y(arrayList, 10));
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                int i3 = i + 1;
                G0.j jVar = (G0.j) arrayList.get(i);
                kotlin.jvm.internal.j.e(jVar, "<this>");
                PackageInfo packageInfo = jVar.f818a;
                kotlin.jvm.internal.j.d(packageInfo, "getPackageInfo(...)");
                String packageName = packageInfo.packageName;
                kotlin.jvm.internal.j.d(packageName, "packageName");
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                List list = null;
                if (applicationInfo != null) {
                    CharSequence applicationLabel = context.getPackageManager().getApplicationLabel(applicationInfo);
                    kotlin.jvm.internal.j.c(applicationLabel, "null cannot be cast to non-null type kotlin.String");
                    str2 = (String) applicationLabel;
                } else {
                    str2 = null;
                }
                int i4 = Build.VERSION.SDK_INT;
                if (i4 >= 28) {
                    longVersionCode = packageInfo.getLongVersionCode();
                    valueOf = String.valueOf(longVersionCode);
                } else {
                    valueOf = String.valueOf(packageInfo.versionCode);
                }
                String str4 = valueOf;
                String packageName2 = packageInfo.packageName;
                kotlin.jvm.internal.j.d(packageName2, "packageName");
                if (i4 >= 30) {
                    try {
                        installSourceInfo = context.getPackageManager().getInstallSourceInfo(packageName2);
                        installingPackageName = installSourceInfo.getInstallingPackageName();
                    } catch (Throwable th) {
                        AbstractC0228a.g(th);
                        str3 = null;
                    }
                } else {
                    installingPackageName = context.getPackageManager().getInstallerPackageName(packageName2);
                }
                str3 = installingPackageName;
                J0.b bVar = new J0.b(packageName, null, str2, str4, str3);
                Set set = jVar.f819b;
                kotlin.jvm.internal.j.d(set, "getReasons(...)");
                List q02 = AbstractC0707i.q0(set);
                Set set2 = jVar.f820c;
                if (set2 != null) {
                    list = AbstractC0707i.q0(set2);
                }
                arrayList2.add(new J0.c(bVar, q02, list));
                i = i3;
            }
            J0.e eVar = dVar.f1072c;
            if (eVar != null) {
                C0029f0 c0029f0 = new C0029f0(4);
                String str5 = eVar.f1052b;
                if (str5.length() > 0) {
                    str = ".".concat(str5);
                } else {
                    str = "";
                }
                String d2 = e0.a.d("dev.flutter.pigeon.freerasp.TalsecPigeonApi.onMalwareDetected", str);
                new BasicMessageChannel(eVar.f1051a, d2, (MessageCodec) J0.e.f1050c.a()).send(T.b.B(arrayList2), new J0.d(c0029f0, d2));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0031, code lost:
    
        if (r7.f1910a > r3.f1910a) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void n(R.k0 r7) {
        /*
            r6 = this;
            java.lang.String r0 = "newState"
            kotlin.jvm.internal.j.e(r7, r0)
            java.lang.Object r0 = r6.f218b
            S2.y r0 = (S2.y) r0
        L9:
            r0.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = S2.y.f2243e
            java.lang.Object r1 = r1.get(r0)
            F0.G1 r2 = T2.j.f2291a
            if (r1 != r2) goto L17
            r1 = 0
        L17:
            r3 = r1
            R.k0 r3 = (R.k0) r3
            boolean r4 = r3 instanceof R.d0
            if (r4 == 0) goto L20
            r4 = 1
            goto L26
        L20:
            R.l0 r4 = R.l0.f1920b
            boolean r4 = kotlin.jvm.internal.j.a(r3, r4)
        L26:
            if (r4 == 0) goto L29
            goto L33
        L29:
            boolean r4 = r3 instanceof R.C0178c
            if (r4 == 0) goto L35
            int r4 = r7.f1910a
            int r5 = r3.f1910a
            if (r4 <= r5) goto L39
        L33:
            r3 = r7
            goto L39
        L35:
            boolean r4 = r3 instanceof R.b0
            if (r4 == 0) goto L47
        L39:
            if (r1 != 0) goto L3c
            r1 = r2
        L3c:
            if (r3 != 0) goto L3f
            goto L40
        L3f:
            r2 = r3
        L40:
            boolean r1 = r0.b(r1, r2)
            if (r1 == 0) goto L9
            return
        L47:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: F0.G1.n(R.k0):void");
    }

    @Override // J.InterfaceC0115c
    public void setExtras(Bundle bundle) {
        ((ContentInfo.Builder) this.f218b).setExtras(bundle);
    }

    public String toString() {
        switch (this.f217a) {
            case 8:
                return AbstractC0008a.s(new StringBuilder("<"), (String) this.f218b, '>');
            default:
                return super.toString();
        }
    }

    @Override // F1.c
    public Object zza() {
        return new E1.l(((E1.e) ((C0047j2) this.f218b).f546b).f134a);
    }

    public /* synthetic */ G1(int i) {
        this.f217a = i;
    }

    public /* synthetic */ G1(Object obj, int i) {
        this.f217a = i;
        this.f218b = obj;
    }

    public G1(boolean z3) {
        F1[] f1Arr = new F1[31];
        int i = ~G1.class.getName().length();
        byte[] bArr = {99, (((i | 783049063) - ((648831334 | i) ^ 168042817)) + ((G1.class.getName().length() & 134217737) | 84475912)) ^ (-252518732), 90, -27, 9, -93, -34, 41};
        i(bArr, new byte[]{-17, -65, 25, -94, 81, 7, -100, 116});
        Charset charset = StandardCharsets.UTF_8;
        String intern = new String(bArr, charset).intern();
        byte[] bArr2 = new byte[10];
        bArr2[0] = -30;
        bArr2[1] = 38;
        bArr2[2] = 5;
        bArr2[3] = -94;
        int i3 = ~G1.class.getName().length();
        bArr2[((((G1.class.getName().length() | 143437065) - (i3 | (-1164001893))) + (I2.a(G1.class, i3 | (-1307397989)) + (G1.class.getName().length() & 143437065))) + ((G1.class.getName().length() & 143400224) | 268505124)) ^ 411942185] = -114;
        bArr2[5] = 38;
        bArr2[6] = 46;
        bArr2[7] = -29;
        bArr2[8] = 102;
        bArr2[9] = -60;
        i(bArr2, new byte[]{-107, 121, 103, -101, -57, 122, 57, -77, 3, -74});
        f1Arr[0] = new F1(null, null, null, null, intern, null, null, null, new String(bArr2, charset).intern(), 239);
        int i4 = ((~G1.class.getName().length()) | 1554383739) & 1386227718;
        int length = G1.class.getName().length();
        byte[] bArr3 = {-83, Byte.MAX_VALUE, (i4 + (138416776 | ((171977220 | length) - (length ^ 171977220)))) ^ 1524644503, 48, -47, -66, 122, 54, 3, 73, -29, 87, 44, 60};
        byte[] bArr4 = new byte[14];
        bArr4[0] = -77;
        int a2 = (I2.a(G1.class, -1) | 1801966325) & 715423874;
        int length2 = G1.class.getName().length() & 276849154;
        bArr4[989127303 ^ (a2 + (~(((G1.class.getName().length() | (-273703429)) | length2) - ((G1.class.getName().length() & 273703428) | length2))))] = 64;
        bArr4[2] = 96;
        bArr4[3] = 112;
        bArr4[4] = -90;
        bArr4[5] = 11;
        bArr4[6] = 69;
        int a4 = (I2.a(G1.class, -1) | (-406122570)) & (-2130031614);
        bArr4[S.a(G1.class.getName().length() & 343949324, ((-r4) - 1) | (-880869421), 880869421, a4) ^ (-1249162199)] = Byte.MAX_VALUE;
        int i5 = ((~G1.class.getName().length()) | 1240211351) & 75507922;
        int length3 = G1.class.getName().length();
        bArr4[8] = (i5 + ((-536870652) | (((G1.class.getName().length() | 1140858948) - (length3 | 1140858948)) + (I2.a(G1.class, length3) + (G1.class.getName().length() & 1140858948))))) ^ (-461362811);
        bArr4[9] = 97;
        bArr4[10] = 112;
        bArr4[11] = 84;
        bArr4[12] = 12;
        bArr4[13] = 14;
        i(bArr3, bArr4);
        String intern2 = new String(bArr3, charset).intern();
        int length4 = G1.class.getName().length();
        byte[] bArr5 = {-26, ((((length4 ^ (-1628171838)) + ((~length4) & 1628171837)) & 704680708) + ((G1.class.getName().length() & 167784720) | 8248)) ^ (-704688968), 15, 28, -26};
        byte[] bArr6 = new byte[8];
        bArr6[0] = -70;
        bArr6[1] = -38;
        bArr6[2] = 40;
        bArr6[3] = 75;
        bArr6[4] = -44;
        bArr6[5] = 50;
        bArr6[((((~G1.class.getName().length()) | (-1263233461)) & (-2124412864)) + ((G1.class.getName().length() & 20973569) | 100663297)) ^ (-2023749561)] = 26;
        bArr6[7] = 38;
        i(bArr5, bArr6);
        String intern3 = new String(bArr5, charset).intern();
        byte[] bArr7 = {-25, -124, -44, -34, -79, 34, 49, 31, 21, -122};
        byte[] bArr8 = new byte[10];
        bArr8[0] = -110;
        bArr8[1] = 27;
        bArr8[2] = -105;
        bArr8[3] = 23;
        bArr8[4] = -54;
        int length5 = G1.class.getName().length();
        bArr8[((((-2031324465) | (((~length5) - length5) + length5)) & 738209865) + ((G1.class.getName().length() & 939525136) | 277234704)) ^ 1015444572] = 126;
        bArr8[6] = 58;
        bArr8[7] = Byte.MAX_VALUE;
        bArr8[8] = 112;
        bArr8[9] = -12;
        i(bArr7, bArr8);
        f1Arr[1] = new F1(intern2, null, null, null, null, null, intern3, null, new String(bArr7, charset).intern(), 190);
        byte[] bArr9 = new byte[8];
        bArr9[((((~G1.class.getName().length()) | (-160001053)) & 639732746) + ((G1.class.getName().length() & 16846604) | 16790308)) ^ 656523054] = -108;
        bArr9[1] = -62;
        bArr9[2] = -107;
        bArr9[3] = -11;
        bArr9[4] = -68;
        bArr9[5] = -102;
        bArr9[6] = ((((~G1.class.getName().length()) | (-974312068)) & 428752924) + (((G1.class.getName().length() | (-941804546)) - (-941804546)) | 1612745761)) ^ 2041498719;
        bArr9[7] = 48;
        i(bArr9, new byte[]{-48, -26, -34, -96, 119, 38, 1, 110});
        String intern4 = new String(bArr9, charset).intern();
        byte[] bArr10 = {-97, -15, 119, -36, -114};
        byte[] bArr11 = new byte[8];
        bArr11[0] = -111;
        bArr11[1] = 15;
        int i6 = ((~G1.class.getName().length()) | (-1956945767)) & 654498055;
        bArr11[V2.a((G1.class.getName().length() & (-1542416106)) | (-2146361328), ~i6, ((~r7) - i6) - 1) ^ (-1491863275)] = ((((~G1.class.getName().length()) | (-550308069)) & 135451210) + ((G1.class.getName().length() & (-2080366399)) | (-2079839851))) ^ (-1944388626);
        bArr11[3] = 11;
        bArr11[4] = -68;
        bArr11[5] = 65;
        int i7 = ~G1.class.getName().length();
        int length6 = (1174676480 & (((~i7) & 1775185443) + i7)) + ((G1.class.getName().length() & 234913794) | 151027714);
        bArr11[6] = ((-1325704198) | length6) - (length6 & (-1325704198));
        int a5 = (I2.a(G1.class, -1) | (-1588494939)) & (-2143219532);
        int length7 = (G1.class.getName().length() & 8650768) | 479477761;
        bArr11[(((length7 | a5) * 2) - (a5 ^ length7)) ^ (-1663741774)] = 101;
        i(bArr10, bArr11);
        String intern5 = new String(bArr10, charset).intern();
        byte[] bArr12 = new byte[10];
        bArr12[0] = 15;
        bArr12[1] = 103;
        bArr12[2] = 7;
        bArr12[3] = 109;
        bArr12[4] = 101;
        bArr12[5] = 42;
        bArr12[6] = 87;
        bArr12[7] = 125;
        bArr12[8] = 75;
        bArr12[((((~G1.class.getName().length()) | (-935940039)) & (-2109465074)) + ((G1.class.getName().length() & 38800934) | 17907744)) ^ (-2091557337)] = 49;
        byte[] bArr13 = new byte[10];
        bArr13[0] = 42;
        bArr13[1] = 56;
        bArr13[2] = 105;
        bArr13[3] = 102;
        bArr13[4] = 30;
        bArr13[(((I2.a(G1.class, -1) | (-1999297537)) & (-2057172628)) + ((G1.class.getName().length() & 94509056) | 580129792)) ^ (-1477042839)] = 118;
        bArr13[6] = 32;
        bArr13[7] = 29;
        bArr13[8] = 46;
        bArr13[9] = 67;
        i(bArr12, bArr13);
        f1Arr[2] = new F1(null, null, null, null, intern4, null, intern5, null, new String(bArr12, charset).intern(), 175);
        byte[] bArr14 = {-11, -51, 126};
        byte[] bArr15 = new byte[8];
        int i8 = ~G1.class.getName().length();
        bArr15[0] = (((i8 | (-1172475905)) - ((i8 | 941445054) ^ (-1845416763))) + ((G1.class.getName().length() & (-1979162271)) | 136856352)) ^ 1708560488;
        bArr15[(((I2.a(G1.class, -1) | (-235325972)) & 224659556) + ((G1.class.getName().length() & 201722113) | 268567811)) ^ 493227366] = -11;
        bArr15[2] = 72;
        int i9 = ((~G1.class.getName().length()) | (-1142962673)) & 537200956;
        int length8 = (G1.class.getName().length() & (-2147481296)) | (-2109733312);
        int i10 = -i9;
        bArr15[3] = ((length8 ^ i10) - ((i10 & (~length8)) * 2)) ^ 1572532380;
        bArr15[4] = 53;
        bArr15[5] = -5;
        bArr15[6] = -2;
        bArr15[7] = -11;
        i(bArr14, bArr15);
        String intern6 = new String(bArr14, charset).intern();
        byte[] bArr16 = {75, -56, -101, 84, -10, (((I2.a(G1.class, -1) | 109531804) & 1982156800) + ((G1.class.getName().length() & 1890582545) | 147849489)) ^ (-2130006398), 75, -104};
        byte[] bArr17 = new byte[8];
        bArr17[0] = 1;
        bArr17[1] = -75;
        bArr17[2] = -96;
        bArr17[3] = 44;
        int i11 = ((~G1.class.getName().length()) | 1063616327) & (-937425853);
        int length9 = (G1.class.getName().length() & (-1006632928)) | 67388192;
        int i12 = -i11;
        bArr17[(-870037657) ^ (((length9 & (~i12)) * 2) - (length9 ^ i12))] = -72;
        bArr17[5] = -43;
        bArr17[6] = 104;
        bArr17[7] = -17;
        i(bArr16, bArr17);
        String intern7 = new String(bArr16, charset).intern();
        byte[] bArr18 = new byte[10];
        bArr18[0] = 93;
        bArr18[1] = 29;
        bArr18[2] = 77;
        bArr18[3] = -25;
        bArr18[4] = 67;
        bArr18[5] = 33;
        bArr18[6] = -55;
        int i13 = ((~G1.class.getName().length()) | (-348513273)) & 1118765204;
        int length10 = G1.class.getName().length();
        bArr18[(i13 + ((((G1.class.getName().length() | (-2137717094)) - (length10 | (-2137717094))) + (I2.a(G1.class, length10) + (G1.class.getName().length() & (-2137717094)))) | (-2142239222))) ^ (-1023474023)] = -70;
        bArr18[8] = -28;
        int i14 = ((~G1.class.getName().length()) | 871516052) & (-2138499103);
        int length11 = G1.class.getName().length() & (-2109132703);
        bArr18[9] = (-1832044619) ^ ((((~length11) & 306454528) + length11) + i14);
        byte[] bArr19 = new byte[10];
        int i15 = ~G1.class.getName().length();
        bArr19[(((-1565385216) & (((((G1.class.getName().length() & (~i15)) & (-1937921863)) - 1937921863) + i15) - ((i15 | G1.class.getName().length()) & (-1937921863)))) + ((G1.class.getName().length() & 595769088) | 16818436)) ^ (-1548566780)] = (((((~G1.class.getName().length()) + (((-r7) - 1) | (-913910085))) + 913910085) & 725635073) + ((G1.class.getName().length() & 151048321) | 557248)) ^ (-726192323);
        int i16 = ~G1.class.getName().length();
        int i17 = (i16 | (-72958641)) - (((-1431956150) | i16) ^ 2040576005);
        int length12 = (G1.class.getName().length() & 1459661831) | 101188642;
        bArr19[2141764646 ^ (((length12 | i17) * 2) - (i17 ^ length12))] = -95;
        bArr19[2] = 31;
        bArr19[3] = -32;
        bArr19[4] = -4;
        bArr19[5] = 124;
        bArr19[6] = -110;
        bArr19[7] = -36;
        bArr19[8] = -127;
        bArr19[9] = 38;
        i(bArr18, bArr19);
        f1Arr[3] = new F1(null, null, null, intern6, null, intern7, null, null, new String(bArr18, charset).intern(), 215);
        int length13 = ((((~G1.class.getName().length()) | 1628239505) & (-2012871259)) + ((G1.class.getName().length() & (-2013134556)) | 276832280)) ^ (-1736038983);
        byte[] bArr20 = {-97, 18, 15, ((((~G1.class.getName().length()) | (-1451887026)) & 756556290) + ((G1.class.getName().length() & 103350304) | 35981424)) ^ 792537605, -36, 46, (((((~G1.class.getName().length()) - 1452023685) + (((-r5) - 1) | 1452023685)) & 704740483) + ((G1.class.getName().length() & 36740225) | (-2135916540))) ^ (-1431175993), -55, -51};
        i(bArr20, new byte[]{-68, -123, 44, 115, 115, 77, 90, 18, -122});
        String intern8 = new String(bArr20, charset).intern();
        byte[] bArr21 = {124, -32, -97, -1, -12};
        i(bArr21, new byte[]{52, -2, -104, -22, -58, -84, 66, 40});
        String intern9 = new String(bArr21, charset).intern();
        byte[] bArr22 = {-70, -44, -101, 63, 16, -69, 31, 31, 107, -77};
        i(bArr22, new byte[]{-35, -21, -51, 56, 41, 7, 105, Byte.MAX_VALUE, 14, -63});
        f1Arr[length13] = new F1(intern8, null, null, null, null, null, intern9, null, new String(bArr22, charset).intern(), 190);
        byte[] bArr23 = new byte[8];
        bArr23[0] = -123;
        bArr23[1] = 94;
        bArr23[2] = -2;
        bArr23[((((~G1.class.getName().length()) | (-800260165)) & 1074135752) + ((G1.class.getName().length() & 138543168) | 138969094)) ^ 1213104845] = -36;
        int i18 = ~G1.class.getName().length();
        bArr23[(((435120318 | ((1758976275 + i18) - (i18 & 1758976275))) - 435120318) + ((G1.class.getName().length() & (-2046818732)) | 140642324)) ^ (-294477999)] = -114;
        bArr23[5] = -38;
        bArr23[6] = 20;
        bArr23[7] = 18;
        i(bArr23, new byte[]{-69, 57, -117, -82, -89, 26, 16, 111});
        String intern10 = new String(bArr23, charset).intern();
        byte[] bArr24 = {79, 99, 47, -48, -89};
        byte[] bArr25 = new byte[8];
        bArr25[0] = 97;
        bArr25[1] = 125;
        bArr25[2] = 8;
        bArr25[3] = 23;
        bArr25[4] = -107;
        bArr25[5] = 62;
        bArr25[6] = 100;
        int length14 = G1.class.getName().length();
        bArr25[351454139 ^ ((((G1.class.getName().length() & 280133812) | 8421668) - (~((1187346251 | ((length14 - 1) - (length14 * 2))) & 343032472))) - 1)] = -127;
        i(bArr24, bArr25);
        String intern11 = new String(bArr24, charset).intern();
        byte length15 = ((((~G1.class.getName().length()) | (-1490616007)) & (-1503256574)) + ((G1.class.getName().length() & 1077948482) | 1082136800)) ^ (-421119772);
        int length16 = (((~G1.class.getName().length()) | (-1059313626)) & 820592804) + ((G1.class.getName().length() & (-1339998080)) | (-2146429696));
        byte[] bArr26 = {44, -52, 42, length15, (((~length16) & 1325836886) - (1325836886 & length16)) + length16, 111, -22, 124, 27, -79};
        i(bArr26, new byte[]{75, -45, 60, 63, -117, 51, 117, 30, 126, -61});
        f1Arr[5] = new F1(intern10, null, null, null, null, null, intern11, null, new String(bArr26, charset).intern(), 190);
        byte[] bArr27 = {-106, -5, -75, 33, -112, 58, 78, -114};
        byte[] bArr28 = new byte[8];
        bArr28[0] = -82;
        bArr28[1] = -26;
        int i19 = ((~G1.class.getName().length()) | (-1578671520)) & 489326628;
        int length17 = G1.class.getName().length();
        bArr28[(i19 + (8392970 | ((478710028 + length17) - (length17 | 478710028)))) ^ 497719596] = -126;
        bArr28[3] = Byte.MAX_VALUE;
        bArr28[((((~G1.class.getName().length()) | 1782513571) & 738201016) + ((G1.class.getName().length() & (-2063515624)) | (-2088648704))) ^ (-1350447684)] = -110;
        bArr28[5] = 50;
        bArr28[6] = 105;
        bArr28[7] = -41;
        i(bArr27, bArr28);
        String intern12 = new String(bArr27, charset).intern();
        byte[] bArr29 = {114, -70, 45, 125, -102};
        i(bArr29, new byte[]{46, -60, 6, 108, -88, -111, -85, 79});
        String intern13 = new String(bArr29, charset).intern();
        byte[] bArr30 = {-67, 62, -51, -30, -28, -31, 106, -124, Byte.MIN_VALUE, 64};
        byte[] bArr31 = new byte[10];
        bArr31[0] = -36;
        bArr31[1] = -127;
        bArr31[2] = -97;
        bArr31[3] = -37;
        bArr31[4] = -99;
        bArr31[5] = -67;
        bArr31[6] = -11;
        bArr31[7] = 21;
        bArr31[8] = -27;
        int i20 = ~G1.class.getName().length();
        int length18 = G1.class.getName().length() & 32784;
        bArr31[(-1476343148) ^ ((((~length18) & 134219929) + length18) + (((i20 + (((-i20) - 1) | 236828072)) - 236828072) & (-1610563068)))] = 50;
        i(bArr30, bArr31);
        f1Arr[6] = new F1(null, null, null, null, null, intern12, intern13, null, new String(bArr30, charset).intern(), 159);
        byte[] bArr32 = {-123, 69, -25, -83, 85, ((((~G1.class.getName().length()) | (-367197622)) & 611420807) + ((G1.class.getName().length() & 341870725) | 268570896)) ^ 879991685, -73, -104};
        byte[] bArr33 = new byte[(((I2.a(G1.class, -1) | (-537299457)) - (-876513795)) + ((G1.class.getName().length() & 554076736) | 1258291296)) ^ 2134805098];
        bArr33[0] = -65;
        bArr33[1] = 56;
        bArr33[2] = -76;
        bArr33[((((~G1.class.getName().length()) | 54316210) & 673103883) + ((G1.class.getName().length() & (-402519975)) | (-805304240))) ^ (-132200360)] = 3;
        bArr33[4] = 85;
        bArr33[5] = 85;
        bArr33[6] = ((((~G1.class.getName().length()) | (-298327132)) & 1612776608) + ((G1.class.getName().length() & 265216) | 134490627)) ^ 1747267277;
        bArr33[7] = -17;
        i(bArr32, bArr33);
        String intern14 = new String(bArr32, charset).intern();
        int a6 = (I2.a(G1.class, -1) | (-1485565191)) & 273177345;
        byte[] bArr34 = new byte[S.a(G1.class.getName().length() & 336087488, ((-r4) - 1) | (-218104001), 218104001, a6) ^ 491281348];
        bArr34[0] = Byte.MIN_VALUE;
        bArr34[1] = ((((~G1.class.getName().length()) | (-1637854295)) & (-1810661325)) + ((G1.class.getName().length() & 34832402) | 572542980)) ^ (-1238118360);
        int length19 = G1.class.getName().length();
        bArr34[2] = ((((-1867364547) | ((length19 - 1) - (length19 * 2))) & (-1606024439)) + ((G1.class.getName().length() & 684982288) | 143679504)) ^ 1462344856;
        bArr34[3] = -94;
        bArr34[4] = -68;
        i(bArr34, new byte[]{-96, 97, -102, -91, -114, -76, 35, 50});
        String intern15 = new String(bArr34, charset).intern();
        byte[] bArr35 = {65, -16, -4, -3, 113, 57, -124, 17, -39, 125};
        i(bArr35, new byte[]{-8, -50, 110, -10, 10, -123, -49, -127, -68, 15});
        f1Arr[7] = new F1(null, null, null, null, null, intern14, intern15, null, new String(bArr35, charset).intern(), 159);
        byte[] bArr36 = {-80, 13, 39};
        int length20 = (((~G1.class.getName().length()) | (-20973857)) - (-1094813995)) + ((G1.class.getName().length() & 20978020) | 12996);
        i(bArr36, new byte[]{-56, 53, 17, 18, 3, 118, 114, (((~length20) & 1094826963) - (1094826963 & length20)) + length20});
        String intern16 = new String(bArr36, charset).intern();
        byte[] bArr37 = {80, -40, ((((~G1.class.getName().length()) | 32478620) & 480513033) + ((G1.class.getName().length() & 469764225) | 1095762112)) ^ 1576275104, 10, 10, 124, 29, -36};
        i(bArr37, new byte[]{-20, -60, 46, 102, 28, 121, 18, -85});
        String intern17 = new String(bArr37, charset).intern();
        byte[] bArr38 = {-95, -31, -27, 14, 46, ((((~G1.class.getName().length()) | (-377503918)) & (-2068971068)) + ((G1.class.getName().length() & 210788516) | 139522080)) ^ 1929448995, -77, -114, Byte.MAX_VALUE, -21};
        i(bArr38, new byte[]{-40, -66, -121, 71, 103, -37, -68, 16, ((((~G1.class.getName().length()) | (-51122746)) & (-1808789456)) + ((G1.class.getName().length() & 4265008) | 1078003072)) ^ (-730786390), -103});
        f1Arr[8] = new F1(null, null, null, intern16, null, intern17, null, null, new String(bArr38, charset).intern(), 215);
        byte[] bArr39 = {13, 85, -93};
        byte[] bArr40 = new byte[((((~G1.class.getName().length()) | (-906397134)) & 1630036244) + ((G1.class.getName().length() & 549454148) | 47220800)) ^ 1677257052];
        int length21 = G1.class.getName().length();
        int length22 = (((-1807501958) | ((length21 - 1) - (length21 * 2))) & 170977167) + ((G1.class.getName().length() & 171000501) | 1627455536);
        bArr40[0] = B0.a((~length22) | 1798432714, 1798432714 - length22);
        bArr40[1] = 109;
        bArr40[2] = -107;
        bArr40[3] = -31;
        bArr40[4] = -88;
        bArr40[5] = 101;
        int i21 = ~G1.class.getName().length();
        bArr40[(((-1533787384) & ((((((~i21) & G1.class.getName().length()) & (-174107740)) - 174107740) + i21) - ((i21 | G1.class.getName().length()) & (-174107740)))) + (((G1.class.getName().length() | (-33631305)) + 33631305) | 50936896)) ^ (-1482850482)] = -62;
        bArr40[7] = -4;
        i(bArr39, bArr40);
        String intern18 = new String(bArr39, charset).intern();
        int length23 = G1.class.getName().length();
        byte[] bArr41 = {75, ((((-1196258691) | ((length23 - 1) - (length23 * 2))) & 293929186) + ((G1.class.getName().length() & 1092952706) | 1075849728)) ^ 1369778894, 17, -97, 82, 34, 42, -59};
        i(bArr41, new byte[]{1, -111, 38, -15, 84, 69, 6, -92});
        String intern19 = new String(bArr41, charset).intern();
        byte[] bArr42 = {-114, 83, 89, 112, -18, Byte.MAX_VALUE, -105, 32, 46, 62};
        i(bArr42, new byte[]{-87, 108, 11, 105, -89, 67, -32, 114, 75, 76});
        f1Arr[9] = new F1(null, null, null, intern18, null, intern19, null, null, new String(bArr42, charset).intern(), 215);
        byte[] bArr43 = {-77, 111, 3};
        i(bArr43, new byte[]{-53, 87, 53, -84, 68, -109, -126, -6});
        String intern20 = new String(bArr43, charset).intern();
        byte[] bArr44 = new byte[8];
        int length24 = (((~G1.class.getName().length()) | 1911448532) & (-1048564976)) + ((G1.class.getName().length() & (-2142627776)) | 139071592);
        bArr44[(((~length24) & (-909493384)) - ((-909493384) & length24)) + length24] = 47;
        bArr44[1] = 68;
        bArr44[2] = -116;
        bArr44[3] = -74;
        bArr44[4] = -94;
        bArr44[5] = ((((~G1.class.getName().length()) | (-2009553859)) & (-937259959)) + ((G1.class.getName().length() & 1187383362) | 113508390)) ^ (-823751661);
        bArr44[6] = -121;
        bArr44[7] = 8;
        i(bArr44, new byte[]{101, 57, -117, 10, -124, 123, -102, 95});
        String intern21 = new String(bArr44, charset).intern();
        byte[] bArr45 = {-123, -34, -8, 57, 23, 7, 80, 91, -3, 111};
        byte[] bArr46 = new byte[10];
        bArr46[0] = -76;
        bArr46[1] = -31;
        bArr46[2] = 106;
        bArr46[3] = 50;
        bArr46[4] = 48;
        bArr46[5] = (((I2.a(G1.class, -1) | 1725142669) & 1349585424) + ((G1.class.getName().length() & 270534680) | 33587213)) ^ (-1383172730);
        bArr46[6] = 27;
        int length25 = ((((~G1.class.getName().length()) | (-2098239827)) & 2080738817) + ((G1.class.getName().length() & 2080426240) | (-2130689784))) ^ (-49950962);
        int length26 = (((~G1.class.getName().length()) | 163428453) & 894048284) + ((G1.class.getName().length() & (-1136492456)) | (-2013151168));
        bArr46[length25] = ((length26 & 1119102872) * 2) + ((-1119102873) - length26);
        bArr46[8] = -104;
        bArr46[9] = 29;
        i(bArr45, bArr46);
        f1Arr[10] = new F1(null, null, null, intern20, null, intern21, null, null, new String(bArr45, charset).intern(), 215);
        byte[] bArr47 = {39, -127, 54};
        i(bArr47, new byte[]{95, -71, 0, -55, -68, 10, 40, -48});
        String intern22 = new String(bArr47, charset).intern();
        byte[] bArr48 = {-11, -98, -7, 85, -120, -15, -30, -3};
        byte[] bArr49 = new byte[8];
        bArr49[0] = -113;
        bArr49[1] = 3;
        int length27 = (((~G1.class.getName().length()) | (-73896021)) & 410064968) + ((G1.class.getName().length() & 543232576) | 553656960);
        bArr49[E1.a(963721930 | length27, 963721930, length27)] = -65;
        bArr49[3] = 43;
        int i22 = ~G1.class.getName().length();
        bArr49[(((-1957144320) & (((((G1.class.getName().length() & (~i22)) & 1201329489) + 1201329489) + i22) - ((i22 | G1.class.getName().length()) & 1201329489))) + ((G1.class.getName().length() & (-2009069520)) | 1073751217)) ^ (-883393099)] = -102;
        bArr49[5] = -7;
        bArr49[6] = -60;
        bArr49[7] = -52;
        i(bArr48, bArr49);
        String intern23 = new String(bArr48, charset).intern();
        byte[] bArr50 = {92, 18, 115, 0, 8, 78, 13, -23, -121, 16};
        byte[] bArr51 = new byte[10];
        bArr51[0] = -5;
        bArr51[1] = -84;
        bArr51[2] = -11;
        bArr51[3] = 56;
        bArr51[4] = 65;
        bArr51[5] = 82;
        bArr51[6] = 86;
        bArr51[7] = -87;
        bArr51[8] = -30;
        int a7 = ((I2.a(G1.class, -1) | (-152771537)) & 973094947) + ((G1.class.getName().length() & 142645256) | (-2138793960));
        bArr51[((-1165699022) + a7) - ((a7 & (-1165699022)) * 2)] = 98;
        i(bArr50, bArr51);
        f1Arr[11] = new F1(null, null, null, intern22, null, intern23, null, null, new String(bArr50, charset).intern(), 215);
        byte[] bArr52 = {-125, -12, 53};
        byte[] bArr53 = new byte[8];
        bArr53[((((~G1.class.getName().length()) | 1076176799) & 650161024) + ((G1.class.getName().length() & 650152032) | 1074266209)) ^ 1724427233] = -5;
        bArr53[1] = -52;
        bArr53[2] = 3;
        bArr53[3] = -15;
        bArr53[4] = -22;
        bArr53[5] = 10;
        bArr53[6] = -69;
        bArr53[((((~G1.class.getName().length()) | (-1878639229)) & 58766338) + ((G1.class.getName().length() & 63015424) | 272697856)) ^ 331464197] = -72;
        i(bArr52, bArr53);
        String intern24 = new String(bArr52, charset).intern();
        byte[] bArr54 = {19, -72, -105, 75, 46, 68, -96, -105};
        i(bArr54, new byte[]{41, 37, -91, 35, -1, -93, Byte.MAX_VALUE, -14});
        String intern25 = new String(bArr54, charset).intern();
        byte[] bArr55 = new byte[((((~G1.class.getName().length()) | (-1179444541)) & 1913967124) + ((G1.class.getName().length() & 1241827349) | 201852929)) ^ 2115820063];
        bArr55[0] = -122;
        bArr55[1] = 96;
        bArr55[2] = ((((~G1.class.getName().length()) | (-1451446712)) & 1346825729) + ((G1.class.getName().length() & 1343373473) | (-2009595740))) ^ (-662769982);
        bArr55[3] = -73;
        bArr55[4] = -16;
        bArr55[5] = 46;
        bArr55[6] = -89;
        bArr55[7] = -34;
        bArr55[8] = -90;
        bArr55[9] = 19;
        int a8 = (I2.a(G1.class, -1) | 1108835246) & 34417032;
        int length28 = G1.class.getName().length();
        i(bArr55, new byte[]{-83, 60, -4, -22, (a8 + (((length28 | 1277690368) - (length28 ^ 1277690368)) | 1277202980)) ^ (-1311620064), -118, -80, -42, -51, 96});
        f1Arr[12] = new F1(null, null, null, intern24, null, intern25, null, null, new String(bArr55, charset).intern(), 215);
        byte[] bArr56 = {-61, -4, -49};
        byte[] bArr57 = new byte[8];
        bArr57[0] = -69;
        bArr57[1] = -60;
        bArr57[2] = -7;
        bArr57[3] = 63;
        bArr57[4] = 46;
        int length29 = (((~G1.class.getName().length()) | (-1776727602)) & (-1005566976)) + ((G1.class.getName().length() & 1207960576) | 138412069);
        bArr57[(((~length29) & (-867154912)) - (length29 & (-867154912))) + length29] = ((((~G1.class.getName().length()) | 1582075177) & 339875856) + ((G1.class.getName().length() & 2232338) | 539492355)) ^ (-879368317);
        bArr57[6] = (((((-968493101) - G1.class.getName().length()) + (((-((-1) - r4)) - 1) | 968493100)) & 680010257) + ((G1.class.getName().length() & 680034308) | 4292612)) ^ 684302923;
        bArr57[7] = 4;
        i(bArr56, bArr57);
        String intern26 = new String(bArr56, charset).intern();
        byte[] bArr58 = new byte[6];
        bArr58[0] = -94;
        int length30 = G1.class.getName().length();
        int length31 = ((((-1386744846) | ((length30 - 1) - (length30 * 2))) & 4205080) + ((G1.class.getName().length() & 526344) | 3702784)) ^ 7907865;
        int length32 = G1.class.getName().length();
        int i23 = (1856376229 | (((~length32) - length32) + length32)) & 169935147;
        int length33 = (G1.class.getName().length() & (-1874395126)) | (-1874452480);
        bArr58[length31] = (-1704517302) ^ D.a(i23, 3, -((length33 & 2) | D1.a(i23, length33)), 1);
        bArr58[2] = -72;
        bArr58[3] = 95;
        bArr58[4] = 69;
        bArr58[5] = -20;
        i(bArr58, new byte[]{-38, 94, Byte.MAX_VALUE, -120, 116, -90, -102, -53});
        String intern27 = new String(bArr58, charset).intern();
        byte[] bArr59 = {45, 103, 66, -92, 16, -22, 44, 97, 21, 54};
        i(bArr59, new byte[]{88, 59, 33, -38, 44, -50, 55, 27, 126, 69});
        f1Arr[13] = new F1(null, null, null, intern26, null, intern27, null, null, new String(bArr59, charset).intern(), 215);
        int i24 = ((~G1.class.getName().length()) | (-1225240338)) & (-484440063);
        int length34 = G1.class.getName().length() | (-1157667394);
        byte[] bArr60 = {-106, 0, -33};
        byte[] bArr61 = new byte[8];
        bArr61[0] = -18;
        bArr61[((1780728888 & (939044837 - ((~(~G1.class.getName().length())) | 939044838))) + ((G1.class.getName().length() & 1501786136) | 293615616)) ^ 2074344505] = 56;
        bArr61[2] = -23;
        bArr61[3] = -78;
        bArr61[4] = 51;
        bArr61[5] = Byte.MIN_VALUE;
        bArr61[6] = -7;
        bArr61[7] = ((((~G1.class.getName().length()) | (-8390657)) - (-8935475)) + ((G1.class.getName().length() & 75696256) | 1141055620)) ^ (-1149991063);
        i(bArr60, bArr61);
        String intern28 = new String(bArr60, charset).intern();
        byte[] bArr62 = {-51, 9, -11, -80, -29, -40, -90, -113};
        byte[] bArr63 = new byte[8];
        bArr63[0] = -121;
        bArr63[1] = 116;
        bArr63[2] = -62;
        bArr63[3] = 16;
        bArr63[4] = -61;
        bArr63[5] = 29;
        int length35 = G1.class.getName().length();
        bArr63[((((-77873862) | ((length35 - 1) - (length35 * 2))) & 344073088) + ((G1.class.getName().length() & 77857416) | 35913736)) ^ 379986830] = 126;
        bArr63[7] = -30;
        i(bArr62, bArr63);
        String intern29 = new String(bArr62, charset).intern();
        byte[] bArr64 = new byte[10];
        bArr64[0] = -89;
        bArr64[1] = -120;
        bArr64[2] = 31;
        int i25 = ((~G1.class.getName().length()) | (-1651705362)) & (-2006971118);
        bArr64[3] = S.a(G1.class.getName().length() & 15746064, ((-r8) - 1) | (-9977921), 9977921, i25) ^ (-1996993163);
        bArr64[4] = 43;
        bArr64[5] = -62;
        bArr64[6] = 1;
        int i26 = ((~G1.class.getName().length()) | (-705722764)) & 746654232;
        int length36 = G1.class.getName().length() & (-1476384760);
        bArr64[(i26 + (~(((G1.class.getName().length() | 2147459003) | length36) - (length36 | (G1.class.getName().length() & (-2147459004)))))) ^ (-1400804773)] = -93;
        bArr64[8] = 42;
        bArr64[9] = -37;
        byte[] bArr65 = new byte[10];
        int i27 = ~G1.class.getName().length();
        int i28 = (~(((G1.class.getName().length() | 205444928) | i27) - (i27 | (G1.class.getName().length() & (-205444929))))) & 428872724;
        int length37 = G1.class.getName().length();
        int i29 = ((1209013512 & length37) + 1073744648) - (length37 & 1073742088);
        bArr65[0] = (-1502617390) ^ ((i29 & i28) + (i28 | i29));
        bArr65[1] = 20;
        bArr65[2] = 85;
        bArr65[3] = 91;
        bArr65[4] = 97;
        bArr65[5] = -26;
        bArr65[6] = 74;
        bArr65[7] = -39;
        bArr65[((((~G1.class.getName().length()) | 1942484701) & 295773185) + ((G1.class.getName().length() & 538968328) | 570458508)) ^ 866231685] = 65;
        bArr65[9] = -88;
        i(bArr64, bArr65);
        f1Arr[(-417293745) ^ (((length34 - (-1224813699)) + (((-(length34 - (-1157667394))) - 1) | (-67146305))) + i24)] = new F1(null, null, null, intern28, null, intern29, null, null, new String(bArr64, charset).intern(), 215);
        byte[] bArr66 = {66, -39, -96};
        i(bArr66, new byte[]{58, -31, -106, 78, -64, 12, 39, -29});
        String intern30 = new String(bArr66, charset).intern();
        byte[] bArr67 = {30, -110, 17, 29, 91, -82, 97, 112};
        i(bArr67, new byte[]{54, 15, 39, 115, 75, -57, 67, 75});
        String intern31 = new String(bArr67, charset).intern();
        byte[] bArr68 = {96, 71, -23, -112, -100, -68, 34, -37, -3, Byte.MIN_VALUE};
        i(bArr68, new byte[]{((((~G1.class.getName().length()) | (-1577939350)) & 241338608) + ((G1.class.getName().length() & 236257424) | 270344200)) ^ 511682803, 91, -122, 14, -72, -8, 45, -47, -106, -13});
        f1Arr[15] = new F1(null, null, null, intern30, null, intern31, null, null, new String(bArr68, charset).intern(), 215);
        byte[] bArr69 = new byte[3];
        bArr69[0] = -92;
        bArr69[1] = -76;
        int a9 = (I2.a(G1.class, -1) | 1546547625) & (-2077716417);
        int length38 = (G1.class.getName().length() & (-2113765354)) | 184691200;
        bArr69[D.a(a9, 3, -(D1.a(a9, length38) | (length38 & 2)), 1) ^ (-1893025219)] = 113;
        byte[] bArr70 = new byte[((((~G1.class.getName().length()) | (-1751965113)) & (-914287467)) + ((G1.class.getName().length() & 1207983762) | 33573442)) ^ (-880714017)];
        bArr70[0] = -36;
        bArr70[1] = -116;
        bArr70[2] = 71;
        bArr70[3] = -65;
        bArr70[4] = -50;
        bArr70[5] = 54;
        bArr70[6] = 58;
        bArr70[7] = 89;
        i(bArr69, bArr70);
        String intern32 = new String(bArr69, charset).intern();
        byte[] bArr71 = {86, 73, -116, -110, -104};
        i(bArr71, new byte[]{-18, 57, -75, -69, -86, 47, 103, -46});
        String intern33 = new String(bArr71, charset).intern();
        byte[] bArr72 = {-1, 5, 12, -59, -14, -18, -38, ((((~G1.class.getName().length()) | (-9023636)) & 271190596) + ((G1.class.getName().length() & 1078493184) | 1623244802)) ^ 1894435378, 2, 12};
        int i30 = ~G1.class.getName().length();
        int i31 = (-1207404136) & ((196068754 ^ i30) + (i30 & 196068754));
        i(bArr72, new byte[]{-90, -103, 99, -71, -118, -54, -91, 48, D.a(i31, 3, -(D1.a(i31, (G1.class.getName().length() & (-1341900792)) | 47448070) | 2), 1) ^ (-1159955977), Byte.MAX_VALUE});
        f1Arr[16] = new F1(null, null, null, intern32, null, intern33, null, null, new String(bArr72, charset).intern(), ((((~G1.class.getName().length()) | (-2060804958)) & 538772694) + ((G1.class.getName().length() & 806682708) | 1409320960)) ^ 1948093441);
        byte[] bArr73 = {-117, 112, 13};
        i(bArr73, new byte[]{-13, 72, 59, -93, 61, 104, -112, -57});
        String intern34 = new String(bArr73, charset).intern();
        byte[] bArr74 = {14, 39, 53, 1, 19, 63, 8, -18};
        i(bArr74, new byte[]{70, -102, 2, 95, 19, 56, 41, -59});
        String intern35 = new String(bArr74, charset).intern();
        byte[] bArr75 = new byte[10];
        bArr75[0] = -21;
        int i32 = ((~G1.class.getName().length()) | 1755609543) & 363075593;
        int length39 = G1.class.getName().length() & 1426096136;
        bArr75[2141493258 ^ (((1778417667 + length39) + (((-length39) - 1) | (-1778417667))) + i32)] = 114;
        bArr75[2] = -15;
        bArr75[3] = 13;
        bArr75[4] = 95;
        bArr75[5] = 10;
        bArr75[6] = 9;
        bArr75[7] = -56;
        bArr75[8] = -5;
        bArr75[9] = 80;
        i(bArr75, new byte[]{-110, 78, 110, -127, -11, -83, 82, -60, -112, 35});
        f1Arr[17] = new F1(null, null, null, intern34, null, intern35, null, null, new String(bArr75, charset).intern(), 215);
        byte[] bArr76 = {64, 40, 103};
        i(bArr76, new byte[]{56, 16, 81, 87, -36, -79, -1, ((((~G1.class.getName().length()) | 2147418111) - 2113073115) + ((G1.class.getName().length() & (-2009005952)) | 213909698)) ^ (-1899163413)});
        String intern36 = new String(bArr76, charset).intern();
        int i33 = ~G1.class.getName().length();
        int length40 = G1.class.getName().length() & (-1304424383);
        byte[] bArr77 = {-5, -109, 10, 120, S.a(length40, ((-length40) - 1) | 2138009599, -2138009599, (i33 | 910816751) - ((67761582 | i33) ^ 910180423)) ^ (-1227829160), -67, ((((~G1.class.getName().length()) | (-208580893)) & 831214085) + (((G1.class.getName().length() | (-1074663461)) - (-1074663461)) | (-1005322190))) ^ (-174108059), 66};
        byte[] bArr78 = new byte[8];
        bArr78[0] = -111;
        bArr78[1] = 14;
        bArr78[2] = 18;
        bArr78[3] = 88;
        bArr78[4] = 15;
        bArr78[5] = -70;
        int i34 = ((~G1.class.getName().length()) | 148072562) & (-1005561643);
        int i35 = ~((G1.class.getName().length() & (-1006038907)) | 537460746);
        int i36 = -i34;
        bArr78[V2.a(~i36, i35, (i35 + i36) + 1) ^ (-468100903)] = 75;
        bArr78[7] = 29;
        i(bArr77, bArr78);
        String intern37 = new String(bArr77, charset).intern();
        byte[] bArr79 = {18, -11, -83, 126, -121, 60, 70, 1, -46, -51};
        i(bArr79, new byte[]{57, -55, -62, 52, -67, 120, 17, 123, -71, -66});
        f1Arr[18] = new F1(null, null, null, intern36, null, intern37, null, null, new String(bArr79, charset).intern(), 215);
        byte[] bArr80 = {-32, -11, 66};
        i(bArr80, new byte[]{-104, -51, 116, -43, -97, -84, -77, 93});
        String intern38 = new String(bArr80, charset).intern();
        byte[] bArr81 = new byte[6];
        bArr81[0] = -102;
        bArr81[1] = 92;
        bArr81[2] = -40;
        bArr81[3] = -38;
        int i37 = ((~G1.class.getName().length()) | 1724614889) & 122683394;
        int i38 = ~((G1.class.getName().length() & (-2129657854)) | (-536739840));
        int i39 = -i37;
        bArr81[V2.a(~i39, i38, (i38 + i39) + 1) ^ (-414056442)] = -16;
        bArr81[5] = 18;
        i(bArr81, new byte[]{-70, 78, -44, ((((~G1.class.getName().length()) | (-1949474011)) & 155336737) + (((G1.class.getName().length() | (-537526275)) - (-537526275)) | 538448134)) ^ 693784868, -64, 35, 13, Byte.MAX_VALUE});
        String intern39 = new String(bArr81, charset).intern();
        byte[] bArr82 = {9, 17, 50, 18, -98, -24, -62, 24, 24, 87};
        i(bArr82, new byte[]{52, -83, 49, -112, -74, -52, -115, -108, 115, 36});
        f1Arr[19] = new F1(null, null, null, intern38, null, intern39, null, null, new String(bArr82, charset).intern(), 215);
        int i40 = ~G1.class.getName().length();
        int length41 = ((1120132680 & ((1364397033 + i40) + (((-i40) - 1) | (-1364397033)))) + ((G1.class.getName().length() & (-1701784560)) | (-1674575696))) ^ (-554443028);
        byte[] bArr83 = {-8, -61, -21};
        byte[] bArr84 = new byte[8];
        bArr84[0] = Byte.MIN_VALUE;
        bArr84[1] = -5;
        bArr84[2] = -35;
        bArr84[3] = -89;
        bArr84[4] = 55;
        bArr84[5] = 24;
        bArr84[6] = -48;
        bArr84[((((~G1.class.getName().length()) | 1200219640) & (-1071102850)) + ((G1.class.getName().length() & (-2144075386)) | 5546369)) ^ (-1065556488)] = 106;
        i(bArr83, bArr84);
        String intern40 = new String(bArr83, charset).intern();
        byte[] bArr85 = {42, -28, 91, 79, -66, -81, -10, 63, -25, 12, -125, -97, 4};
        byte[] bArr86 = new byte[13];
        bArr86[0] = 78;
        bArr86[1] = -38;
        bArr86[2] = 8;
        bArr86[3] = 56;
        bArr86[4] = -37;
        bArr86[5] = 42;
        bArr86[6] = -112;
        bArr86[7] = 56;
        bArr86[8] = -113;
        bArr86[9] = 105;
        bArr86[10] = -99;
        int i41 = ~G1.class.getName().length();
        int i42 = 231579716 & (((~i41) & (-31632465)) + i41);
        int length42 = G1.class.getName().length();
        int i43 = (297837120 + length42) - (length42 | 297837120);
        int length43 = (((((((~i43) & G1.class.getName().length()) & 304087817) + 304087817) + i43) - ((G1.class.getName().length() | i43) & 304087817)) + i42) ^ 535667526;
        int i44 = ((~G1.class.getName().length()) | (-17975730)) & 170069060;
        int length44 = (G1.class.getName().length() & 1181953) | 1311499;
        int i45 = -i44;
        bArr86[length43] = (-171380601) ^ (((~i45) & length44) - (i45 & (~length44)));
        bArr86[12] = 52;
        i(bArr85, bArr86);
        String intern41 = new String(bArr85, charset).intern();
        byte[] bArr87 = {82, -111, -96, 101, 101, 109, -74, 58, -116, 56};
        i(bArr87, new byte[]{-7, 44, -64, 25, 31, 73, -63, 114, -25, 75});
        f1Arr[length41] = new F1(null, null, null, intern40, null, intern41, null, null, new String(bArr87, charset).intern(), 215);
        byte[] bArr88 = {95, -10, -68};
        int i46 = ~G1.class.getName().length();
        i(bArr88, new byte[]{39, -50, -118, 19, (-602475251) ^ ((((G1.class.getName().length() | 1545007360) - (i46 | (-547881209))) + (I2.a(G1.class, (-1958613241) | i46) + (G1.class.getName().length() & 1545007360))) + ((G1.class.getName().length() & 1410732113) | (-2147482535))), -75, 43, 8});
        String intern42 = new String(bArr88, charset).intern();
        byte[] bArr89 = {83, 123, -115, -59, -90, Byte.MAX_VALUE, -125, -47, -86, 48, 42, 74, -18};
        int i47 = ((~G1.class.getName().length()) | (-1632285621)) & 5384305;
        int length45 = (G1.class.getName().length() & 1080172592) | 1210056960;
        int i48 = -i47;
        byte b4 = 1215441268 ^ (((~i48) & length45) - (i48 & (~length45)));
        int i49 = (((-1318619932) | r4) - 1861901312) - ((~G1.class.getName().length()) | (-1318587164));
        int length46 = G1.class.getName().length() & 49201;
        i(bArr89, new byte[]{b4, 101, -78, -82, -45, 90, -70, (-1853361093) ^ ((((~length46) & 8540209) + length46) + i49), -44, ((((~G1.class.getName().length()) | 956298709) & 77352210) + ((G1.class.getName().length() & 67110914) | (-1589571516))) ^ (-1512219291), 4, -108, -34});
        String intern43 = new String(bArr89, charset).intern();
        byte[] bArr90 = {42, 5, -2, -67, 89, 102, 55, 63, 81, -31};
        byte[] bArr91 = new byte[10];
        bArr91[0] = 81;
        bArr91[1] = -103;
        bArr91[2] = 117;
        int i50 = ((~G1.class.getName().length()) | 690666495) & 141067412;
        int length47 = (G1.class.getName().length() & 1094714376) | 1627390282;
        int i51 = -i50;
        bArr91[1768457693 ^ ((((~i51) & length47) * 2) - (i51 ^ length47))] = -15;
        bArr91[((((~G1.class.getName().length()) | 113946632) & 564271272) + (((G1.class.getName().length() | (-555788453)) - (-555788453)) | 67149830)) ^ 631421098] = -13;
        bArr91[5] = 65;
        bArr91[6] = 64;
        bArr91[7] = 117;
        bArr91[8] = 58;
        bArr91[9] = -110;
        i(bArr90, bArr91);
        f1Arr[21] = new F1(null, null, null, intern42, null, intern43, null, null, new String(bArr90, charset).intern(), 215);
        byte[] bArr92 = {-92, 35, 8};
        i(bArr92, new byte[]{-36, 27, 62, -69, 107, -40, 75, -45});
        String intern44 = new String(bArr92, charset).intern();
        byte[] bArr93 = {55, 52, 114, 124, -29, 29, -61};
        i(bArr93, new byte[]{100, -93, 73, 77, -38, 46, -13, ((((~G1.class.getName().length()) | (-61127406)) & 1082213258) + ((G1.class.getName().length() & 9994888) | (-2141683712))) ^ 1059470447});
        String intern45 = new String(bArr93, charset).intern();
        byte[] bArr94 = {56, 43, 97, -92, -41, -100, 110, (((I2.a(G1.class, -1) | (-893024273)) & 675414150) + ((G1.class.getName().length() & 537264177) | 269746225)) ^ (-945160439), 8, -108};
        i(bArr94, new byte[]{99, 119, -2, -39, 109, 24, -6, -11, 99, -25});
        String intern46 = new String(bArr94, charset).intern();
        int length48 = (((~G1.class.getName().length()) | 219978414) & 1090519749) + ((G1.class.getName().length() & 1074266193) | 134744080);
        f1Arr[22] = new F1(null, null, null, intern44, null, intern45, null, null, intern46, ((length48 & (-1225263619)) * 2) + (1225263618 - length48));
        byte[] bArr95 = {121, -65, 53};
        byte[] bArr96 = new byte[((((~G1.class.getName().length()) | 888368425) & 216364) + ((G1.class.getName().length() & 276828308) | 1384124624)) ^ 1384340980];
        bArr96[0] = ((((~G1.class.getName().length()) | 894281162) & 275618) + ((G1.class.getName().length() & 16781345) | 27394113)) ^ 27669730;
        bArr96[1] = -121;
        bArr96[2] = 3;
        bArr96[3] = -12;
        bArr96[4] = -100;
        int i52 = ((~G1.class.getName().length()) | (-587493595)) & 1208306192;
        int length49 = G1.class.getName().length();
        bArr96[5] = (-1479363288) ^ ((((2375824 & length49) ^ 271057088) + (length49 & 2097280)) + i52);
        bArr96[6] = 43;
        bArr96[7] = 125;
        i(bArr95, bArr96);
        String intern47 = new String(bArr95, charset).intern();
        byte[] bArr97 = new byte[((((~G1.class.getName().length()) | (-269395733)) & 202590216) + ((G1.class.getName().length() & 1342603392) | 1342473376)) ^ 1545063586];
        bArr97[0] = -101;
        bArr97[1] = 65;
        bArr97[2] = -65;
        bArr97[3] = -71;
        bArr97[4] = 29;
        bArr97[5] = 116;
        bArr97[6] = -12;
        bArr97[7] = 43;
        bArr97[8] = -119;
        bArr97[9] = 44;
        i(bArr97, new byte[]{-76, 56, -47, 21, 58, -124, -80, 36, -47, 96});
        String intern48 = new String(bArr97, charset).intern();
        byte[] bArr98 = {120, 15, 112, 30, -95, 83, 68, -41, -97, 18};
        i(bArr98, new byte[]{35, -109, -17, -109, -37, 87, 15, -51, -12, 97});
        f1Arr[23] = new F1(null, null, null, intern47, null, intern48, null, null, new String(bArr98, charset).intern(), 215);
        byte[] bArr99 = new byte[3];
        bArr99[0] = 11;
        bArr99[((((~G1.class.getName().length()) | 928665305) & 109326856) + ((G1.class.getName().length() & 8728594) | 2179090)) ^ 111505947] = -47;
        bArr99[2] = 34;
        i(bArr99, new byte[]{115, -23, 20, ((((~G1.class.getName().length()) | 1925320586) & 109887882) + ((G1.class.getName().length() & 1141819460) | 1073875044)) ^ 1183762926, 106, -9, -64, 50});
        String intern49 = new String(bArr99, charset).intern();
        byte[] bArr100 = {-98, 91, 3, -2, -44, -34, -88, 63, 21, -106};
        i(bArr100, new byte[]{-56, 56, 64, -58, 116, -76, -126, 39, 68, -46});
        String intern50 = new String(bArr100, charset).intern();
        byte[] bArr101 = new byte[10];
        bArr101[0] = 112;
        bArr101[1] = 37;
        bArr101[2] = -77;
        bArr101[((((~G1.class.getName().length()) | (-129)) - 2041968507) + ((G1.class.getName().length() & 129) | 74859)) ^ (-2041893652)] = -17;
        bArr101[4] = 14;
        bArr101[5] = -119;
        bArr101[6] = 16;
        bArr101[7] = 69;
        bArr101[8] = 111;
        bArr101[9] = 30;
        i(bArr101, new byte[]{27, 121, -80, -93, 70, 45, 92, 63, 4, 109});
        f1Arr[24] = new F1(null, null, null, intern49, null, intern50, null, null, new String(bArr101, charset).intern(), 215);
        byte[] bArr102 = {2, -61, 75, 94};
        int i53 = ~G1.class.getName().length();
        int length50 = ((G1.class.getName().length() | 1347429801) - (i53 | 1467678123)) + I2.a(G1.class, 1463483819 | i53) + (G1.class.getName().length() & 1347429801) + ((G1.class.getName().length() & (-2143252478)) | (-1610180538));
        i(bArr102, new byte[]{92, -48, 14, B0.a((~length50) | (-262750813), (-262750813) - length50), 11, -69, 126, -51});
        String intern51 = new String(bArr102, charset).intern();
        byte[] bArr103 = new byte[12];
        bArr103[0] = 69;
        bArr103[1] = 123;
        bArr103[((((~G1.class.getName().length()) | 689396150) & 6554034) + ((G1.class.getName().length() & 157290500) | 452988932)) ^ 459542964] = -84;
        int length51 = G1.class.getName().length();
        bArr103[3] = (((987176987 | (((~length51) - length51) + length51)) & 640901160) + ((G1.class.getName().length() & 69747232) | 139235856)) ^ 780137066;
        bArr103[4] = -110;
        bArr103[5] = -3;
        bArr103[6] = 85;
        bArr103[7] = 28;
        bArr103[((((~G1.class.getName().length()) | 596322851) & 1782923680) + ((G1.class.getName().length() & 1279542144) | 77595140)) ^ 1860518828] = -102;
        bArr103[9] = -93;
        int length52 = (((~G1.class.getName().length()) | 278774136) & 135438451) + ((G1.class.getName().length() & 167928579) | 33575680);
        bArr103[(((~length52) & 169014137) - (169014137 & length52)) + length52] = -7;
        bArr103[11] = -79;
        i(bArr103, new byte[]{-21, 77, -84, 64, -28, -61, 26, 110, -35, 7, -121, -10});
        String intern52 = new String(bArr103, charset).intern();
        byte[] bArr104 = {-12, 109, 53, 70, -107, -89, Byte.MAX_VALUE, 17, 102};
        byte[] bArr105 = new byte[((((~G1.class.getName().length()) | (-143737387)) & (-1859975070)) + ((G1.class.getName().length() & 1082724390) | 1155010564)) ^ (-704964497)];
        bArr105[0] = 106;
        bArr105[((42504938 & ((-1488009249) - ((~I2.a(G1.class, -1)) | (-1488009248)))) + ((G1.class.getName().length() & 27529226) | 287588372)) ^ 330093311] = 51;
        bArr105[2] = 59;
        bArr105[3] = 60;
        bArr105[4] = -36;
        bArr105[5] = -2;
        bArr105[6] = -5;
        bArr105[7] = -116;
        int i54 = ((~G1.class.getName().length()) | 2115051134) & (-2128002484);
        int i55 = ~((G1.class.getName().length() & (-1523038208)) | 605038592);
        int i56 = -i54;
        bArr105[V2.a(~i56, i55, (i55 + i56) + 1) ^ (-1522963900)] = 2;
        i(bArr104, bArr105);
        f1Arr[25] = new F1(null, intern51, null, null, null, null, null, intern52, new String(bArr104, charset).intern(), 125);
        int length53 = ((((~G1.class.getName().length()) | 166248167) & 14815425) + ((G1.class.getName().length() & 1627521544) | 1627719176)) ^ 1642534611;
        byte[] bArr106 = {-43, 20, -65, 126};
        i(bArr106, new byte[]{-115, -89, -70, 44, 2, -9, 87, -6});
        String intern53 = new String(bArr106, charset).intern();
        byte[] bArr107 = new byte[12];
        bArr107[0] = -126;
        bArr107[1] = -64;
        bArr107[2] = -66;
        bArr107[3] = -58;
        bArr107[4] = -51;
        bArr107[((((~G1.class.getName().length()) | 2130705149) - 2120217325) + ((G1.class.getName().length() & (-2126494462)) | 541147136)) ^ (-1579070185)] = -59;
        bArr107[6] = 11;
        bArr107[7] = 29;
        bArr107[8] = -96;
        bArr107[9] = 40;
        bArr107[10] = -31;
        bArr107[11] = -118;
        i(bArr107, new byte[]{-84, ((((~G1.class.getName().length()) | 1815192225) & (-1901672057)) + ((G1.class.getName().length() & (-1027192050)) | 1884291592)) ^ 17380458, -76, -57, -111, -37, 105, -115, -84, -103, -106, -25});
        String intern54 = new String(bArr107, charset).intern();
        byte[] bArr108 = {-8, -21, 24, -107, 8, 25, -79, -114, 105};
        i(bArr108, new byte[]{((((~G1.class.getName().length()) | 380911586) & 808136714) + ((G1.class.getName().length() & (-536150007)) | (-1073741039))) ^ (-265604243), -75, 102, 9, 87, -96, -55, 4, 13});
        f1Arr[length53] = new F1(null, intern53, null, null, null, null, null, intern54, new String(bArr108, charset).intern(), 125);
        byte[] bArr109 = {6, -40, -114, -22, 23, -64};
        i(bArr109, new byte[]{76, -48, -31, -99, 120, -77, 27, 116});
        String intern55 = new String(bArr109, charset).intern();
        byte[] bArr110 = {-48, Byte.MIN_VALUE, -8, -112, -18, -67, -52, 68, -35, 109, -110, ((((~G1.class.getName().length()) | (-647416026)) & (-1870525048)) + ((G1.class.getName().length() & 110233736) | 101711874)) ^ 1768813128};
        int i57 = ~G1.class.getName().length();
        int length54 = (113676824 & ((963418768 ^ i57) + (i57 & 963418768))) + ((G1.class.getName().length() & (-2038300632)) | (-2145386395));
        i(bArr110, new byte[]{Byte.MIN_VALUE, ((length54 & 2031709591) * 2) + ((-2031709592) - length54), -127, -2, 112, 3, -108, 38, -100, 73, -31, -57});
        String intern56 = new String(bArr110, charset).intern();
        byte[] bArr111 = {125, -4, -17, -27, -15, -44, -92, 64, 104};
        byte[] bArr112 = new byte[9];
        bArr112[0] = -15;
        bArr112[1] = -63;
        bArr112[2] = 117;
        bArr112[3] = -103;
        int i58 = ~G1.class.getName().length();
        bArr112[(-1427798521) ^ ((35717631 - ((~(G1.class.getName().length() & 583041027)) | 35717632)) + ((-1463516157) & (((-2012778868) + i58) - (i58 & (-2012778868)))))] = Byte.MIN_VALUE;
        bArr112[5] = -19;
        bArr112[6] = ((((~G1.class.getName().length()) | 1314510297) & (-1975163742)) + ((G1.class.getName().length() & (-1073471454)) | 1093304832)) ^ 881858838;
        bArr112[7] = 62;
        bArr112[8] = 12;
        i(bArr111, bArr112);
        f1Arr[27] = new F1(null, intern55, null, null, null, null, null, intern56, new String(bArr111, charset).intern(), 125);
        int length55 = ((((~G1.class.getName().length()) | 113639145) & 537977888) + ((G1.class.getName().length() & 537919490) | (-2009071606))) ^ (-1471093706);
        byte[] bArr113 = {-78, 25, 18, -38, 116, 125};
        i(bArr113, new byte[]{-64, -111, 85, -51, 27, 14, -120, -120});
        String intern57 = new String(bArr113, charset).intern();
        byte[] bArr114 = new byte[12];
        bArr114[0] = -16;
        bArr114[1] = -6;
        bArr114[2] = -6;
        bArr114[3] = -20;
        bArr114[4] = 77;
        bArr114[5] = -103;
        int i59 = ~G1.class.getName().length();
        bArr114[1425929168 ^ ((((933427659 | i59) + 346898900) - (i59 | 934279647)) + ((G1.class.getName().length() & 1908758) | 1079030274))] = 116;
        bArr114[7] = -73;
        bArr114[8] = -126;
        bArr114[9] = 58;
        bArr114[10] = -98;
        bArr114[11] = -95;
        byte[] bArr115 = new byte[((((~G1.class.getName().length()) | (-1115612887)) & 1101140112) + ((G1.class.getName().length() & 1075979408) | 268444704)) ^ 1369584828];
        bArr115[0] = -102;
        bArr115[1] = -65;
        bArr115[2] = 120;
        bArr115[3] = -99;
        bArr115[4] = 17;
        bArr115[5] = 39;
        bArr115[6] = -21;
        bArr115[7] = -10;
        bArr115[8] = -54;
        bArr115[9] = -85;
        bArr115[10] = -67;
        bArr115[11] = -2;
        i(bArr114, bArr115);
        String intern58 = new String(bArr114, charset).intern();
        int length56 = G1.class.getName().length();
        int i60 = ((-561108175) | (((~length56) - length56) + length56)) & (-1723203424);
        int length57 = G1.class.getName().length() & 121634944;
        byte[] bArr116 = {-67, 63, -52, S.a(length57, ((-length57) - 1) | (-100697098), 100697098, i60) ^ (-1622506321), -116, 52, -24, -116, 120};
        byte[] bArr117 = new byte[9];
        bArr117[0] = -79;
        bArr117[1] = -127;
        bArr117[2] = -110;
        int i61 = ((~G1.class.getName().length()) | (-1157896858)) & (-1677651693);
        int length58 = G1.class.getName().length();
        bArr117[3] = (i61 + (1644462272 | (((G1.class.getName().length() | 1711312913) - (length58 | 1711312913)) + (I2.a(G1.class, length58) + (G1.class.getName().length() & 1711312913))))) ^ (-33189457);
        bArr117[4] = -45;
        int i62 = ~G1.class.getName().length();
        bArr117[(((-2105343512) & ((1446576534 + i62) - (i62 & 1446576534))) + ((G1.class.getName().length() & (-2000551832)) | 138417152)) ^ (-1966926355)] = -115;
        bArr117[6] = 112;
        bArr117[7] = 2;
        bArr117[8] = 28;
        i(bArr116, bArr117);
        f1Arr[length55] = new F1(null, intern57, null, null, null, null, null, intern58, new String(bArr116, charset).intern(), 125);
        byte[] bArr118 = new byte[6];
        bArr118[0] = ((((~G1.class.getName().length()) | (-1834075099)) & (-1876391359)) + ((G1.class.getName().length() & 5276256) | 22024226)) ^ (-1854367181);
        int length59 = (((~G1.class.getName().length()) | (-1777129714)) & 1628827172) + ((G1.class.getName().length() & 1761921209) | 168296601);
        bArr118[((length59 & (-1797123773)) * 2) + (1797123772 - length59)] = 106;
        bArr118[2] = 76;
        bArr118[3] = 21;
        bArr118[4] = 90;
        int length60 = (((~G1.class.getName().length()) | (-1911482488)) & 352583818) + ((G1.class.getName().length() & 822346242) | (-1610087936));
        bArr118[5] = ((length60 & 1257504067) * 2) + ((-1257504068) - length60);
        byte[] bArr119 = new byte[8];
        bArr119[0] = 30;
        bArr119[1] = 66;
        int i63 = ((~G1.class.getName().length()) | 1279577343) & 877125;
        int length61 = G1.class.getName().length() & 273263106;
        bArr119[2] = 273541976 ^ ((((((G1.class.getName().length() & (~length61)) & 272664834) + 272664834) + length61) - ((length61 | G1.class.getName().length()) & 272664834)) + i63);
        bArr119[3] = -108;
        int length62 = (((~G1.class.getName().length()) | (-16778241)) - (-218107017)) + ((G1.class.getName().length() & 25363520) | 9633856);
        bArr119[4] = (227740925 | length62) - (length62 & 227740925);
        int length63 = ((((~G1.class.getName().length()) | 2071131486) & 1477481108) + ((G1.class.getName().length() & 84411008) | 86655041)) ^ 1564136144;
        int i64 = ((~G1.class.getName().length()) | (-2111373665)) & 576766474;
        int length64 = G1.class.getName().length() & 608305376;
        bArr119[length63] = 644011695 ^ ((((~length64) & 67245280) + length64) + i64);
        bArr119[6] = 119;
        bArr119[7] = 36;
        i(bArr118, bArr119);
        String intern59 = new String(bArr118, charset).intern();
        byte length65 = ((((~G1.class.getName().length()) | 1165187946) & 1078257738) + ((G1.class.getName().length() & 134522373) | 134223381)) ^ (-1212481066);
        int i65 = ((~G1.class.getName().length()) | 220736569) & 771934737;
        int length66 = G1.class.getName().length();
        int i66 = i65 + (1074341120 | ((1644414464 + length66) - (length66 | 1644414464)));
        byte[] bArr120 = {-83, -76, -93, length65, -10, -69, E1.a((-1846275949) | i66, -1846275949, i66), 55, 0, -56, -67, -61};
        byte[] bArr121 = new byte[12];
        bArr121[0] = -45;
        bArr121[1] = 1;
        bArr121[2] = -72;
        int i67 = ~G1.class.getName().length();
        int i68 = 621232648 & (((~i67) & (-1582341956)) + i67);
        int length67 = G1.class.getName().length() & 201335360;
        int i69 = 411051202 + length67 + (((-length67) - 1) | (-411051202));
        bArr121[D.a(i68, 3, -((i69 & 2) | D1.a(i68, i69)), 1) ^ 1032283850] = 21;
        int i70 = ((~G1.class.getName().length()) | (-1356079750)) & 73418118;
        int length68 = G1.class.getName().length();
        bArr121[4] = (i70 + (1342710337 | ((4719301 | length68) - (length68 ^ 4719301)))) ^ (-1416128433);
        bArr121[5] = 5;
        bArr121[6] = -46;
        bArr121[7] = -105;
        bArr121[8] = 87;
        bArr121[9] = -20;
        bArr121[((((~G1.class.getName().length()) | (-508592333)) & 1623607809) + ((G1.class.getName().length() & (-2040523764)) | (-2027932660))) ^ (-404324857)] = -62;
        bArr121[((((~G1.class.getName().length()) | (-1140850689)) + 1680867354) + ((G1.class.getName().length() & 1191194624) | 184580096)) ^ 1865447442] = -56;
        i(bArr120, bArr121);
        String intern60 = new String(bArr120, charset).intern();
        byte[] bArr122 = new byte[9];
        bArr122[0] = 98;
        bArr122[1] = -95;
        bArr122[((((~G1.class.getName().length()) | 40175047) & (-1960962702)) + ((G1.class.getName().length() & (-1189466064)) | 807411841)) ^ (-1153550863)] = -121;
        bArr122[3] = -73;
        bArr122[4] = -51;
        bArr122[5] = -99;
        bArr122[6] = 116;
        bArr122[7] = 58;
        bArr122[8] = 32;
        i(bArr122, new byte[]{0, -1, -51, -21, -108, 36, 5, 120, 68});
        f1Arr[29] = new F1(null, null, intern59, null, null, null, null, intern60, new String(bArr122, charset).intern(), 123);
        byte[] bArr123 = new byte[6];
        bArr123[0] = 59;
        int i71 = ~G1.class.getName().length();
        bArr123[((1369786528 & (((-1192620493) + i71) - (i71 & (-1192620493)))) + ((G1.class.getName().length() & 1090863236) | (-2046815996))) ^ (-677029467)] = -121;
        bArr123[2] = -59;
        bArr123[3] = -102;
        bArr123[4] = 10;
        bArr123[5] = 84;
        byte[] bArr124 = new byte[8];
        bArr124[0] = (((I2.a(G1.class, -1) | (-1128939506)) & 1137860742) + (((G1.class.getName().length() | (-1329995905)) - (-1329995905)) | 202115136)) ^ 1339975809;
        bArr124[1] = 47;
        bArr124[2] = -89;
        bArr124[((((~G1.class.getName().length()) | (-1385381598)) & 539689986) + (((G1.class.getName().length() | (-134415937)) + 134415937) | 167774784)) ^ 707464769] = 13;
        int a10 = I2.a(G1.class, -1);
        int length69 = ((G1.class.getName().length() | 1149796882) - (a10 | (-829902190))) + I2.a(G1.class, (-830459774) | a10) + (G1.class.getName().length() & 1149796882);
        int length70 = G1.class.getName().length() & (-2145877487);
        bArr124[(-593985001) ^ ((((~length70) & (-1743781887)) + length70) + length69)] = 101;
        bArr124[5] = 39;
        bArr124[6] = 117;
        bArr124[7] = -75;
        i(bArr123, bArr124);
        String intern61 = new String(bArr123, charset).intern();
        byte[] bArr125 = {-59, 15, 93, 30, -5, -81, -74, 15, ((((~G1.class.getName().length()) | 2098333833) & 1300779020) + ((G1.class.getName().length() & 42496005) | 33760257)) ^ 1334539283, 100, -88, 1};
        byte[] bArr126 = new byte[12];
        bArr126[0] = 109;
        bArr126[1] = -86;
        bArr126[2] = 19;
        bArr126[3] = -113;
        bArr126[4] = -121;
        bArr126[5] = -15;
        bArr126[6] = -84;
        bArr126[7] = Byte.MAX_VALUE;
        bArr126[8] = 102;
        int length71 = G1.class.getName().length();
        int i72 = ((~length71) - length71) + length71;
        bArr126[((((1726630326 | i72) + 1076891804) - (i72 | 1727683006)) + ((G1.class.getName().length() & 152080392) | 151617792)) ^ 1228509589] = 85;
        bArr126[((((~G1.class.getName().length()) | (-794483662)) & 537660640) + ((G1.class.getName().length() & 1611139264) | 1073778696)) ^ 1611439330] = -49;
        bArr126[11] = 94;
        i(bArr125, bArr126);
        String intern62 = new String(bArr125, charset).intern();
        byte[] bArr127 = new byte[9];
        bArr127[0] = 62;
        bArr127[1] = -71;
        bArr127[2] = -124;
        bArr127[3] = 20;
        bArr127[4] = -102;
        bArr127[5] = ((((~G1.class.getName().length()) | (-1537933853)) & 33857820) + ((G1.class.getName().length() & 33555998) | 5635)) ^ ForkServer.INIT_PARSER_FACTORY_FACTORY;
        bArr127[((((~G1.class.getName().length()) | 1589526169) & 1797013736) + ((G1.class.getName().length() & 553665888) | 272676608)) ^ 2069690350] = -98;
        bArr127[7] = (((I2.a(G1.class, -1) | 1677549824) & 574357940) + ((G1.class.getName().length() & 4214964) | (-2143070208))) ^ 1568712295;
        bArr127[8] = 34;
        byte[] bArr128 = new byte[9];
        bArr128[0] = 52;
        bArr128[1] = 7;
        bArr128[2] = -53;
        bArr128[3] = -118;
        bArr128[4] = -27;
        int a11 = (I2.a(G1.class, -1) | (-1646427722)) & 3936384;
        int length72 = (G1.class.getName().length() & 1075851264) | 1224744960;
        bArr128[(((a11 & length72) * 2) + (length72 ^ a11)) ^ 1228681349] = -96;
        bArr128[6] = -38;
        bArr128[7] = -49;
        bArr128[8] = 70;
        i(bArr127, bArr128);
        f1Arr[30] = new F1(null, null, intern61, null, null, null, null, intern62, new String(bArr127, charset).intern(), 123);
        this.f218b = AbstractC0708j.W(f1Arr);
    }

    @Override // m.InterfaceC0533a0
    public void a(int i) {
    }

    @Override // m.InterfaceC0533a0
    public void f(int i) {
    }

    public G1(androidx.lifecycle.N n4, C0328a c0328a) {
        this.f217a = 13;
        this.f218b = new AtomicReference();
    }

    public G1(byte b4) {
        this.f217a = 7;
        this.f218b = new S2.y(R.l0.f1920b);
    }

    public G1(ClipData clipData, int i) {
        this.f217a = 4;
        this.f218b = A.f.n(clipData, i);
    }
}
