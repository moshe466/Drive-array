package F0;

import android.app.Activity;
import android.content.IntentSender;
import android.util.Log;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import io.flutter.plugin.common.MethodChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import k2.C0496f;
import s2.C0679d;
import s2.C0684i;
import t2.AbstractC0707i;
import t2.AbstractC0709k;

/* renamed from: F0.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0068p implements F2.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f601a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f602b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f603c;

    public /* synthetic */ C0068p(int i, Object obj, Object obj2) {
        this.f601a = i;
        this.f602b = obj;
        this.f603c = obj2;
    }

    @Override // F2.l
    public final Object invoke(Object obj) {
        Integer num;
        boolean z3;
        int i = this.f601a;
        C0684i c0684i = C0684i.f6340a;
        Object obj2 = this.f603c;
        Object obj3 = this.f602b;
        boolean z4 = true;
        switch (i) {
            case 0:
                r rVar = (r) obj3;
                CountDownLatch countDownLatch = (CountDownLatch) obj2;
                c1.a aVar = (c1.a) obj;
                byte[] bArr = {68, 75, -35, 70, 85, -46};
                int length = r.class.getName().length();
                int i3 = (1340654234 - length) + (((-((-1) - length)) - 1) | (-1340654235));
                r.k(bArr, new byte[]{92, 29, 6, -109, 113, -30, (-416208406) ^ (((i3 | 403488770) - (403488770 ^ i3)) + ((r.class.getName().length() & 272893440) | 12719616)), -13});
                Charset charset = StandardCharsets.UTF_8;
                kotlin.jvm.internal.j.e(rVar, new String(bArr, charset).intern());
                byte[] bArr2 = new byte[11];
                bArr2[0] = 9;
                bArr2[1] = -105;
                bArr2[2] = 3;
                bArr2[3] = 31;
                bArr2[4] = -6;
                long j2 = 366825665;
                long length2 = (((~r.class.getName().length()) | (-8913089)) - (-349700293)) + ((r.class.getName().length() & 8978624) | 17125376);
                long j3 = (((((((((j2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((j2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)))) + (((((((((length2 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((length2 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((length2 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((length2 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                long j4 = (j3 >>> 48) & 21845;
                long j5 = ((j4 >>> 1) | j4) & 858993459;
                long j6 = ((j5 >>> 2) | j5) & 252645135;
                long j7 = (j3 >>> 32) & 21845;
                long j8 = ((j7 >>> 1) | j7) & 858993459;
                long j9 = ((j8 >>> 2) | j8) & 252645135;
                long j10 = ((((j9 >>> 4) | j9) & 16711935) << 16) | ((((j6 >>> 4) | j6) & 16711935) << 24);
                long j11 = (j3 >>> 16) & 21845;
                long j12 = ((j11 >>> 1) | j11) & 858993459;
                long j13 = ((j12 >>> 2) | j12) & 252645135;
                long j14 = j3 & 21845;
                long j15 = ((j14 >>> 1) | j14) & 858993459;
                long j16 = ((j15 >>> 2) | j15) & 252645135;
                bArr2[(int) (((((j13 >>> 4) | j13) & 16711935) << 8) | j10 | (((j16 >>> 4) | j16) & 16711935))] = -51;
                int length3 = r.class.getName().length();
                long j17 = -2080373759;
                long length4 = r.class.getName().length();
                long j18 = (((((((((j17 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | ((((((((j17 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | ((((((((j17 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((j17 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)) + (((((((((length4 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((length4 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + (((((((((length4 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) | ((((((length4 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))));
                long j19 = (j18 >>> 48) & 43690;
                long j20 = ((j19 >>> 2) | (j19 >>> 1)) & 858993459;
                long j21 = ((j20 >>> 2) | j20) & 252645135;
                long j22 = (j18 >>> 32) & 43690;
                long j23 = ((j22 >>> 2) | (j22 >>> 1)) & 858993459;
                long j24 = ((j23 >>> 2) | j23) & 252645135;
                long j25 = ((((j24 >>> 4) | j24) & 16711935) << 16) | ((((j21 >>> 4) | j21) & 16711935) << 24);
                long j26 = (j18 >>> 16) & 43690;
                long j27 = ((j26 >>> 2) | (j26 >>> 1)) & 858993459;
                long j28 = ((j27 >>> 2) | j27) & 252645135;
                long j29 = j18 & 43690;
                long j30 = ((j29 >>> 2) | (j29 >>> 1)) & 858993459;
                long j31 = ((j30 >>> 2) | j30) & 252645135;
                bArr2[6] = 1538411380 ^ (((717748926 | ((length3 - 1) - (length3 * 2))) & (-1538969598)) + (((int) ((((((j28 >>> 4) | j28) & 16711935) << 8) | j25) | (((j31 >>> 4) | j31) & 16711935))) | 558309));
                bArr2[7] = -12;
                bArr2[8] = -65;
                bArr2[9] = 50;
                bArr2[10] = 112;
                r.k(bArr2, new byte[]{-63, -63, -29, -49, -13, -83, 45, 55, -53, 81, 24});
                kotlin.jvm.internal.j.e(countDownLatch, new String(bArr2, charset).intern());
                byte[] bArr3 = new byte[6];
                bArr3[0] = -66;
                bArr3[1] = 16;
                bArr3[2] = -116;
                bArr3[3] = 69;
                bArr3[4] = -107;
                int i4 = ~r.class.getName().length();
                int length5 = ((r.class.getName().length() | (-1827618756)) - (i4 | (-684013698))) + AbstractC0008a.f(r.class, 1428850530 | i4) + (r.class.getName().length() & (-1827618756));
                int length6 = r.class.getName().length() | 2112798435;
                int i5 = (length6 - 2112339299) - (((-2112798435) + length6) & 459136);
                int i6 = ((i5 | length5) * 2) - (i5 ^ length5);
                long j32 = -1827159623;
                long j33 = i6;
                long j34 = (((((((((j32 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) | (((((((((j32 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) + ((((((((j32 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j32 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845))) + ((((((((j33 >>> 24) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 48) + (((((((((j33 >>> 16) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 32) | (((((((((j33 >>> 8) & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845) << 16) + ((((((j33 & 255) * 72340172838076673L) & (-9205322385119247871L)) * 72624976668147841L) >>> 49) & 21845)));
                long j35 = (j34 >>> 48) & 21845;
                long j36 = (j35 | (j35 >>> 1)) & 858993459;
                long j37 = (j36 | (j36 >>> 2)) & 252645135;
                long j38 = (j34 >>> 32) & 21845;
                long j39 = ((j38 >>> 1) | j38) & 858993459;
                long j40 = ((j39 >>> 2) | j39) & 252645135;
                long j41 = (((j37 | (j37 >>> 4)) & 16711935) << 24) | ((((j40 >>> 4) | j40) & 16711935) << 16);
                long j42 = (j34 >>> 16) & 21845;
                long j43 = ((j42 >>> 1) | j42) & 858993459;
                long j44 = ((j43 >>> 2) | j43) & 252645135;
                long j45 = j34 & 21845;
                long j46 = ((j45 >>> 1) | j45) & 858993459;
                long j47 = (j46 | (j46 >>> 2)) & 252645135;
                bArr3[(int) (((j47 | (j47 >>> 4)) & 16711935) | (((((j44 >>> 4) | j44) & 16711935) << 8) + j41))] = -79;
                r.k(bArr3, new byte[]{-88, 67, 105, -110, -7, -59, -69, -114});
                kotlin.jvm.internal.j.e(aVar, new String(bArr3, charset).intern());
                rVar.f617a = aVar;
                countDownLatch.countDown();
                return c0684i;
            case 1:
                C0496f c0496f = (C0496f) obj3;
                Activity activity = (Activity) obj2;
                E1.a aVar2 = (E1.a) obj;
                if (aVar2.f118c == 3 && (num = c0496f.f5299j) != null && num.intValue() == 1) {
                    try {
                        if (c0496f.f5301l != null) {
                            E1.d.c(aVar2, activity, E1.m.a(1));
                        }
                    } catch (IntentSender.SendIntentException e4) {
                        Log.e("in_app_update", "Could not start update flow", e4);
                    }
                }
                return c0684i;
            default:
                MethodChannel.Result result = (MethodChannel.Result) obj2;
                E1.a aVar3 = (E1.a) obj;
                ((C0496f) obj3).f5300k = aVar3;
                C0679d c0679d = new C0679d("updateAvailability", Integer.valueOf(aVar3.f118c));
                if (aVar3.b(E1.m.a(1)) != null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                C0679d c0679d2 = new C0679d("immediateAllowed", Boolean.valueOf(z3));
                Set<Integer> a2 = aVar3.a(E1.m.a(1));
                ArrayList arrayList = new ArrayList(AbstractC0709k.Y(a2, 10));
                for (Integer num2 : a2) {
                    num2.getClass();
                    arrayList.add(num2);
                }
                C0679d c0679d3 = new C0679d("immediateAllowedPreconditions", AbstractC0707i.q0(arrayList));
                if (aVar3.b(E1.m.a(0)) == null) {
                    z4 = false;
                }
                C0679d c0679d4 = new C0679d("flexibleAllowed", Boolean.valueOf(z4));
                Set<Integer> a4 = aVar3.a(E1.m.a(0));
                ArrayList arrayList2 = new ArrayList(AbstractC0709k.Y(a4, 10));
                for (Integer num3 : a4) {
                    num3.getClass();
                    arrayList2.add(num3);
                }
                result.success(t2.u.G(c0679d, c0679d2, c0679d3, c0679d4, new C0679d("flexibleAllowedPreconditions", AbstractC0707i.q0(arrayList2)), new C0679d("availableVersionCode", Integer.valueOf(aVar3.f117b)), new C0679d("installStatus", Integer.valueOf(aVar3.f119d)), new C0679d(RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, aVar3.f116a), new C0679d("clientVersionStalenessDays", aVar3.f120e), new C0679d("updatePriority", Integer.valueOf(aVar3.f121f))));
                return c0684i;
        }
    }
}
