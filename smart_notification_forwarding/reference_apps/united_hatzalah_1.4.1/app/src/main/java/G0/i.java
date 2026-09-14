package G0;

import F0.AbstractC0014b1;
import F0.AbstractC0099x;
import F0.D;
import F0.D1;
import F0.S;
import F0.j3;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.fragment.app.C0261b;
import androidx.fragment.app.C0263c;
import androidx.fragment.app.C0264c0;
import androidx.fragment.app.i0;
import androidx.fragment.app.m0;
import androidx.versionedparcelable.ParcelImpl;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.firebase.remoteconfig.internal.Code;
import e.C0359a;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import k0.C0489m;
import k0.I;
import k0.J;
import m.P;
import org.apache.tika.fork.ForkServer;

/* loaded from: classes.dex */
public final class i implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f817a;

    public /* synthetic */ i(int i) {
        this.f817a = i;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:105:0x028d. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:68:0x01ad. Please report as an issue. */
    /* JADX WARN: Type inference failed for: r2v39, types: [android.view.View$BaseSavedState, M.h, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v42, types: [java.lang.Object, androidx.fragment.app.c0] */
    /* JADX WARN: Type inference failed for: r2v43, types: [androidx.fragment.app.i0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v50, types: [k0.m, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v51, types: [k0.I, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v52, types: [k0.J, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v53, types: [android.view.View$BaseSavedState, java.lang.Object, m.P] */
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        byte[] bArr;
        LinkedHashSet linkedHashSet;
        byte[] bArr2;
        LinkedHashSet linkedHashSet2;
        int i;
        int i3;
        int i4;
        int i5;
        Intent intent;
        boolean z3;
        boolean z4;
        boolean z5;
        Parcel parcel2 = parcel;
        switch (this.f817a) {
            case 0:
                int i6 = 0;
                char c4 = 18721;
                int i7 = 0;
                int i8 = 0;
                PackageInfo packageInfo = null;
                LinkedHashSet linkedHashSet3 = null;
                LinkedHashSet linkedHashSet4 = null;
                PackageInfo packageInfo2 = null;
                LinkedHashSet linkedHashSet5 = null;
                PackageInfo packageInfo3 = null;
                LinkedHashSet linkedHashSet6 = null;
                while (true) {
                    LinkedHashSet linkedHashSet7 = null;
                    while (true) {
                        switch (c4) {
                            case 29634:
                                i8 = parcel.readInt();
                                linkedHashSet4 = new LinkedHashSet(i8);
                                parcel2 = parcel;
                                packageInfo2 = packageInfo;
                                linkedHashSet5 = linkedHashSet3;
                                c4 = 35185;
                                i7 = i6;
                            case 41705:
                                break;
                            case 18721:
                                byte[] bArr3 = new byte[6];
                                bArr3[i6] = -116;
                                bArr3[1] = 97;
                                int i9 = 2;
                                bArr3[2] = -83;
                                int i10 = i6;
                                bArr3[3] = 54;
                                bArr3[4] = -36;
                                bArr3[5] = 104;
                                byte[] bArr4 = new byte[8];
                                bArr4[i10] = 19;
                                bArr4[1] = -47;
                                bArr4[2] = -12;
                                bArr4[3] = 60;
                                bArr4[4] = -71;
                                bArr4[5] = 4;
                                bArr4[6] = -7;
                                bArr4[7] = 111;
                                int i11 = 1516727821;
                                int i12 = 1;
                                int i13 = i10;
                                int i14 = i13;
                                int i15 = i14;
                                byte[] bArr5 = null;
                                byte[] bArr6 = null;
                                while (true) {
                                    int i16 = ((i11 & 16777216) * (i11 | 16777216)) + ((i11 & (-16777217)) * ((~i11) & 16777216));
                                    int i17 = i11 >>> 8;
                                    int i18 = i9;
                                    int a2 = j3.a((~i16) & 650911840 & i17, i17, i16, (i16 | 650911840) & i17);
                                    int i19 = (a2 ^ 642535957) + ((a2 & 642535957) * 2);
                                    switch (((~i19) + ((i19 | 1) * 2)) ^ 962785775) {
                                        case -1896910703:
                                            byte[] bArr7 = bArr4;
                                            LinkedHashSet linkedHashSet8 = linkedHashSet5;
                                            int length = bArr5.length;
                                            int i20 = 0 - i13;
                                            i9 = 2;
                                            int i21 = (length ^ i20) + ((length & i20) * 2);
                                            byte b4 = bArr6[i21];
                                            int length2 = bArr5.length;
                                            int i22 = 0 - i20;
                                            int i23 = i22 | length2;
                                            byte b5 = bArr6[D.a(i22, 2, i23, (length2 ^ i22) ^ i23)];
                                            bArr6[i21] = (byte) (((byte) (((byte) 2) * ((byte) (b5 | b4)))) - ((byte) (b5 ^ b4)));
                                            parcel2 = parcel;
                                            linkedHashSet5 = linkedHashSet8;
                                            bArr4 = bArr7;
                                            i11 = -746753280;
                                            i12 = 1;
                                        case -1725904394:
                                            bArr2 = bArr4;
                                            linkedHashSet2 = linkedHashSet5;
                                            i = i14;
                                            int length3 = bArr5.length % 4;
                                            i3 = 1;
                                            if ((((length3 > 1 ? 1 : (length3 == 1 ? 0 : -1)) >>> 31) & 1) != 0) {
                                                i15 = length3;
                                                parcel2 = parcel;
                                                i12 = i3;
                                                i14 = i;
                                                linkedHashSet5 = linkedHashSet2;
                                                bArr4 = bArr2;
                                                i9 = 2;
                                                i11 = -458924450;
                                            } else {
                                                parcel2 = parcel;
                                                i15 = length3;
                                                i12 = 1;
                                                i14 = i;
                                                linkedHashSet5 = linkedHashSet2;
                                                bArr4 = bArr2;
                                                i11 = -365117735;
                                                i9 = 2;
                                            }
                                        case -1399959314:
                                            bArr = bArr4;
                                            linkedHashSet = linkedHashSet5;
                                            int i24 = i14;
                                            int a4 = j3.a((-1205100636) & i24, i24, 3, (-1205100633) & i24);
                                            byte b6 = bArr6[a4];
                                            int i25 = ((b6 & ForkServer.DONE) * (b6 | ForkServer.DONE)) + ((b6 & ForkServer.ERROR) * ((~b6) & 16777216));
                                            int i26 = i24 - 1;
                                            int i27 = i26 - (i24 | (-3));
                                            int i28 = bArr6[i27] & ForkServer.ERROR;
                                            int i29 = i28 * ((~i28) & 65536);
                                            int a5 = S.a(i29, i25, i12, ((-1) - i29) | ((-1) - i25));
                                            int i30 = i26 - (i24 | (-2));
                                            int i31 = bArr6[i30] & ForkServer.ERROR;
                                            int i32 = i31 * ((~i31) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                                            int i33 = (i32 - 1) - ((~a5) | i32);
                                            int i34 = bArr6[i24] & ForkServer.ERROR;
                                            int a6 = S.a(i33, i34, 1, ((-1) - i33) | ((-1) - i34));
                                            byte b7 = bArr5[a4];
                                            int i35 = ((b7 & ForkServer.DONE) * (b7 | ForkServer.DONE)) + ((b7 & ForkServer.ERROR) * ((~b7) & 16777216));
                                            int i36 = bArr5[i27] & ForkServer.ERROR;
                                            int i37 = ((i36 * ((~i36) & 65536)) & (~i35)) + i35;
                                            int i38 = bArr5[i30] & ForkServer.ERROR;
                                            int i39 = i38 * ((~i38) & UserVerificationMethods.USER_VERIFY_HANDPRINT);
                                            int i40 = ~((((~i39) | 911399251) | i37) - ((i39 & 911399251) | i37));
                                            int i41 = bArr5[i24] & ForkServer.ERROR;
                                            int i42 = ~((((~i40) | 1433568692) | i41) - ((i40 & 1433568692) | i41));
                                            int i43 = a6 << ((a6 > Double.NaN ? 1 : (a6 == Double.NaN ? 0 : -1)) >>> 31);
                                            int i44 = (-1254002618) - ((i43 & 2) | ((-1672003491) - i43));
                                            int i45 = (i44 + i42) - ((i44 & i42) * 2);
                                            bArr5[i24] = (byte) i45;
                                            bArr5[i30] = (byte) (i45 >>> 8);
                                            bArr5[i27] = (byte) (i45 >>> 16);
                                            bArr5[a4] = (byte) (i45 >>> 24);
                                            int i46 = ((i24 & 4) * 2) + (i24 ^ 4);
                                            int length4 = bArr5.length;
                                            int length5 = 0 - (bArr5.length % 4);
                                            int i47 = ((i46 > AbstractC0014b1.a((length4 & 2) | D1.a(length5, length4), length5 * 3) ? 1 : (i46 == AbstractC0014b1.a((length4 & 2) | D1.a(length5, length4), length5 * 3) ? 0 : -1)) >>> 31) & 1;
                                            if (i47 != 0) {
                                                i11 = -1605440657;
                                            } else {
                                                i11 = -365117735;
                                            }
                                            if (i47 != 0) {
                                                i14 = i46;
                                                parcel2 = parcel;
                                                linkedHashSet5 = linkedHashSet;
                                                bArr4 = bArr;
                                                i9 = 2;
                                                i12 = 1;
                                            } else {
                                                i11 = -169475207;
                                                parcel2 = parcel;
                                                i14 = i46;
                                                linkedHashSet5 = linkedHashSet;
                                                bArr4 = bArr;
                                                i9 = 2;
                                                i12 = 1;
                                            }
                                        case -1135475043:
                                            break;
                                        case 180635757:
                                            bArr5 = bArr3;
                                            i14 = i10;
                                            bArr6 = bArr4;
                                            i11 = -1605440657;
                                            i9 = 2;
                                        case 511524454:
                                            LinkedHashSet linkedHashSet9 = linkedHashSet5;
                                            int length6 = bArr5.length;
                                            int i48 = 0 - i13;
                                            int i49 = 0 - i48;
                                            int i50 = ((~length6) & i49) * 2;
                                            int length7 = bArr5.length;
                                            byte b8 = bArr5[((length7 | i48) * 2) - (length7 ^ i48)];
                                            linkedHashSet2 = linkedHashSet9;
                                            int length8 = bArr5.length;
                                            byte b9 = bArr6[(length8 ^ i48) + ((length8 & i48) * 2)];
                                            bArr2 = bArr4;
                                            bArr5[(length6 ^ i49) - i50] = (byte) (((byte) (b9 - b8)) + ((byte) (((byte) i18) * ((byte) ((~b9) & b8)))));
                                            i15 = AbstractC0099x.a(i13, 3, (~i13) * 2);
                                            if ((((i13 > 2 ? 1 : (i13 == 2 ? 0 : -1)) >>> 31) & 1) != 0) {
                                                i3 = i12;
                                                i = i14;
                                                parcel2 = parcel;
                                                i12 = i3;
                                                i14 = i;
                                                linkedHashSet5 = linkedHashSet2;
                                                bArr4 = bArr2;
                                                i9 = 2;
                                                i11 = -458924450;
                                            } else {
                                                linkedHashSet5 = linkedHashSet2;
                                                bArr4 = bArr2;
                                                i11 = -365117735;
                                                i9 = 2;
                                            }
                                        case 961838909:
                                            int length9 = bArr5.length;
                                            int i51 = 0 - i15;
                                            LinkedHashSet linkedHashSet10 = linkedHashSet5;
                                            if ((bArr6[((length9 | i51) - (((~i51) & 165327505) & length9)) + ((i51 | 165327505) & length9)] > Double.NaN ? 1 : (bArr6[((length9 | i51) - (((~i51) & 165327505) & length9)) + ((i51 | 165327505) & length9)] == Double.NaN ? 0 : -1)) <= -1) {
                                                i4 = i10;
                                            } else {
                                                i4 = i12;
                                            }
                                            if (i4 != 0) {
                                                i5 = -365117735;
                                            } else {
                                                i5 = 1093626513;
                                            }
                                            if (i4 != 0) {
                                                i11 = -746753280;
                                            } else {
                                                i11 = i5;
                                            }
                                            linkedHashSet5 = linkedHashSet10;
                                            i13 = i15;
                                            i9 = i18;
                                        default:
                                            bArr = bArr4;
                                            linkedHashSet = linkedHashSet5;
                                            i11 = -365117735;
                                            parcel2 = parcel;
                                            linkedHashSet5 = linkedHashSet;
                                            bArr4 = bArr;
                                            i9 = 2;
                                            i12 = 1;
                                    }
                                    kotlin.jvm.internal.j.e(parcel2, new String(bArr3, StandardCharsets.UTF_8).intern());
                                    packageInfo2 = (PackageInfo) parcel2.readParcelable(j.class.getClassLoader());
                                    i8 = parcel2.readInt();
                                    linkedHashSet4 = new LinkedHashSet(i8);
                                    c4 = 17591;
                                    i6 = i10;
                                    i7 = i6;
                                }
                            case 35185:
                                if (i7 != i8) {
                                    c4 = 54323;
                                } else {
                                    c4 = 40846;
                                }
                            case 54323:
                                linkedHashSet4.add(parcel2.readString());
                                i7++;
                                c4 = 35185;
                            case 17591:
                                if (i7 != i8) {
                                    c4 = 28088;
                                } else {
                                    c4 = 63139;
                                }
                            case 63139:
                                if (parcel2.readInt() == 0) {
                                    c4 = 41705;
                                } else {
                                    c4 = 29634;
                                }
                                linkedHashSet3 = linkedHashSet4;
                                packageInfo = packageInfo2;
                            case 28088:
                                linkedHashSet4.add(parcel2.readString());
                                i7++;
                                c4 = 17591;
                            case 40846:
                                linkedHashSet7 = linkedHashSet4;
                                packageInfo3 = packageInfo2;
                                linkedHashSet6 = linkedHashSet5;
                                c4 = 40547;
                            case 40547:
                                break;
                            default:
                                c4 = 40846;
                        }
                        return new j(packageInfo3, linkedHashSet6, linkedHashSet7);
                    }
                    parcel2 = parcel;
                    packageInfo3 = packageInfo;
                    linkedHashSet6 = linkedHashSet3;
                    c4 = 40547;
                }
                break;
            case 1:
                ?? baseSavedState = new View.BaseSavedState(parcel2);
                baseSavedState.f1379a = parcel2.readInt();
                return baseSavedState;
            case 2:
                return new C0261b(parcel2);
            case 3:
                return new C0263c(parcel2);
            case 4:
                ?? obj = new Object();
                obj.f3355a = parcel2.readString();
                obj.f3356b = parcel2.readInt();
                return obj;
            case 5:
                ?? obj2 = new Object();
                obj2.f3419e = null;
                obj2.f3420f = new ArrayList();
                obj2.f3421j = new ArrayList();
                obj2.f3415a = parcel2.createStringArrayList();
                obj2.f3416b = parcel2.createStringArrayList();
                obj2.f3417c = (C0261b[]) parcel2.createTypedArray(C0261b.CREATOR);
                obj2.f3418d = parcel2.readInt();
                obj2.f3419e = parcel2.readString();
                obj2.f3420f = parcel2.createStringArrayList();
                obj2.f3421j = parcel2.createTypedArrayList(C0263c.CREATOR);
                obj2.f3422k = parcel2.createTypedArrayList(C0264c0.CREATOR);
                return obj2;
            case 6:
                return new m0(parcel2);
            case 7:
                return new androidx.swiperefreshlayout.widget.k(parcel2);
            case 8:
                kotlin.jvm.internal.j.e(parcel2, "parcel");
                int readInt = parcel2.readInt();
                if (parcel2.readInt() == 0) {
                    intent = null;
                } else {
                    intent = (Intent) Intent.CREATOR.createFromParcel(parcel2);
                }
                return new C0359a(readInt, intent);
            case 9:
                kotlin.jvm.internal.j.e(parcel2, "inParcel");
                Parcelable readParcelable = parcel2.readParcelable(IntentSender.class.getClassLoader());
                kotlin.jvm.internal.j.b(readParcelable);
                return new e.j((IntentSender) readParcelable, (Intent) parcel2.readParcelable(Intent.class.getClassLoader()), parcel2.readInt(), parcel2.readInt());
            case 10:
                ?? obj3 = new Object();
                obj3.f5260a = parcel2.readInt();
                obj3.f5261b = parcel2.readInt();
                boolean z6 = true;
                if (parcel2.readInt() != 1) {
                    z6 = false;
                }
                obj3.f5262c = z6;
                return obj3;
            case 11:
                ?? obj4 = new Object();
                obj4.f5178a = parcel2.readInt();
                obj4.f5179b = parcel2.readInt();
                boolean z7 = true;
                if (parcel2.readInt() != 1) {
                    z7 = false;
                }
                obj4.f5181d = z7;
                int readInt2 = parcel2.readInt();
                if (readInt2 > 0) {
                    int[] iArr = new int[readInt2];
                    obj4.f5180c = iArr;
                    parcel2.readIntArray(iArr);
                }
                return obj4;
            case Code.UNIMPLEMENTED /* 12 */:
                ?? obj5 = new Object();
                obj5.f5182a = parcel2.readInt();
                obj5.f5183b = parcel2.readInt();
                int readInt3 = parcel2.readInt();
                obj5.f5184c = readInt3;
                if (readInt3 > 0) {
                    int[] iArr2 = new int[readInt3];
                    obj5.f5185d = iArr2;
                    parcel2.readIntArray(iArr2);
                }
                int readInt4 = parcel2.readInt();
                obj5.f5186e = readInt4;
                if (readInt4 > 0) {
                    int[] iArr3 = new int[readInt4];
                    obj5.f5187f = iArr3;
                    parcel2.readIntArray(iArr3);
                }
                boolean z8 = false;
                if (parcel2.readInt() == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                obj5.f5189k = z3;
                if (parcel2.readInt() == 1) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                obj5.f5190l = z4;
                if (parcel2.readInt() == 1) {
                    z8 = true;
                }
                obj5.f5191m = z8;
                obj5.f5188j = parcel2.readArrayList(I.class.getClassLoader());
                return obj5;
            case 13:
                ?? baseSavedState2 = new View.BaseSavedState(parcel2);
                if (parcel2.readByte() != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                baseSavedState2.f5575a = z5;
                return baseSavedState2;
            default:
                return new ParcelImpl(parcel2);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.f817a) {
            case 0:
                return new j[i];
            case 1:
                return new M.h[i];
            case 2:
                return new C0261b[i];
            case 3:
                return new C0263c[i];
            case 4:
                return new C0264c0[i];
            case 5:
                return new i0[i];
            case 6:
                return new m0[i];
            case 7:
                return new androidx.swiperefreshlayout.widget.k[i];
            case 8:
                return new C0359a[i];
            case 9:
                return new e.j[i];
            case 10:
                return new C0489m[i];
            case 11:
                return new I[i];
            case Code.UNIMPLEMENTED /* 12 */:
                return new J[i];
            case 13:
                return new P[i];
            default:
                return new ParcelImpl[i];
        }
    }
}
