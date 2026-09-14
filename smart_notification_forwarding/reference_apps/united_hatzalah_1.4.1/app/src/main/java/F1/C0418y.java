package f1;

import android.os.Build;
import com.google.android.gms.common.ConnectionResult;
import com.google.firebase.remoteconfig.internal.Code;
import d1.C0358a;
import io.flutter.Build;
import java.util.List;
import java.util.Map;
import s2.C0680e;
import t2.AbstractC0705g;
import t2.C0716r;

/* renamed from: f1.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0418y extends kotlin.jvm.internal.k implements F2.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4592a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0378A f4593b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0418y(C0378A c0378a, int i) {
        super(0);
        this.f4592a = i;
        this.f4593b = c0378a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v50, types: [java.util.List] */
    @Override // F2.a
    public final Object invoke() {
        String str;
        switch (this.f4592a) {
            case 0:
                return new C0396b(this.f4593b.f4525k.b("accessibility_enabled"));
            case 1:
                return new C0397c(this.f4593b.f4525k.a("adb_enabled"));
            case 2:
                return new C0398d(this.f4593b.f4525k.c("alarm_alert"));
            case 3:
                Object G3 = T.b.G(3000L, new g1.l(this.f4593b.f4524j, 0));
                if (G3 instanceof C0680e) {
                    G3 = C0716r.f6476a;
                }
                return new C0400f((List) G3);
            case 4:
                Object G4 = T.b.G(1000L, new g1.e(this.f4593b.f4526l, 0));
                String[] strArr = new String[0];
                if (G4 instanceof C0680e) {
                    G4 = strArr;
                }
                return new C0401g(AbstractC0705g.R((String[]) G4));
            case 5:
                Object G5 = T.b.G(1000L, new g1.a(this.f4593b.f4520e, 1));
                if (G5 instanceof C0680e) {
                    G5 = "";
                }
                return new C0402h((String) G5);
            case 6:
                Object G6 = T.b.G(1000L, new g1.a(this.f4593b.f4520e, 1));
                if (G6 instanceof C0680e) {
                    G6 = "";
                }
                return new C0403i((String) G6);
            case 7:
                Object G7 = T.b.G(1000L, new g1.a(this.f4593b.f4520e, 0));
                if (G7 instanceof C0680e) {
                    G7 = "";
                }
                return new C0404j((String) G7);
            case 8:
                Object G8 = T.b.G(1000L, new g1.d(this.f4593b.f4521f, 11));
                if (G8 instanceof C0680e) {
                    G8 = C0716r.f6476a;
                }
                return new C0405k((List) G8);
            case 9:
                Object G9 = T.b.G(1000L, new R.U(this.f4593b.f4523h, 6));
                boolean z3 = G9 instanceof C0680e;
                C0716r c0716r = C0716r.f6476a;
                if (z3) {
                    G9 = c0716r;
                }
                ?? r12 = (List) G9;
                if (r12 != 0) {
                    c0716r = r12;
                }
                return new C0406l(c0716r);
            case 10:
                return new C0408n(this.f4593b.f4525k.a("data_roaming"));
            case 11:
                return new C0409o(this.f4593b.f4525k.c("date_format"));
            case Code.UNIMPLEMENTED /* 12 */:
                return new C0410p(this.f4593b.f4525k.b("default_input_method"));
            case 13:
                return new r(this.f4593b.f4525k.a("development_settings_enabled"));
            case 14:
                Object G10 = T.b.G(1000L, new g1.f(this.f4593b.i, 0));
                if (G10 instanceof C0680e) {
                    G10 = "";
                }
                return new C0412s((String) G10);
            case 15:
                return new C0413t(this.f4593b.f4525k.c("end_button_behavior"));
            case 16:
                Object G11 = T.b.G(1000L, new R.U(this.f4593b.f4527m, 7));
                g1.g gVar = g1.g.f4690e;
                if (G11 instanceof C0680e) {
                    G11 = gVar;
                }
                return new C0414u(((g1.g) G11).f4692a);
            case 17:
                return new C0379B(this.f4593b.f4525k.c("font_scale"));
            case ConnectionResult.SERVICE_UPDATING /* 18 */:
                Object G12 = T.b.G(1000L, new R.U(this.f4593b.f4522g, 8));
                if (G12 instanceof C0680e) {
                    G12 = "";
                }
                return new C0380C((String) G12);
            case 19:
                return new C0381D(this.f4593b.f4525k.a("http_proxy"));
            case 20:
                Object G13 = T.b.G(1000L, new R.U(this.f4593b.f4519d, 9));
                if (G13 instanceof C0680e) {
                    G13 = C0716r.f6476a;
                }
                return new C0382E((List) G13);
            case 21:
                Object G14 = T.b.G(1000L, new R.U(this.f4593b.f4519d, 9));
                if (G14 instanceof C0680e) {
                    G14 = C0716r.f6476a;
                }
                return new C0383F((List) G14);
            case 22:
                Object G15 = T.b.G(1000L, new g1.f(this.f4593b.i, 1));
                Boolean bool = Boolean.FALSE;
                if (G15 instanceof C0680e) {
                    G15 = bool;
                }
                return new C0384G(((Boolean) G15).booleanValue());
            case 23:
                Object G16 = T.b.G(1000L, new g1.d(this.f4593b.f4516a, 12));
                if (G16 instanceof C0680e) {
                    G16 = t2.s.f6477a;
                }
                return new C0388K((Map) G16);
            case 24:
                Object G17 = T.b.G(1000L, new g1.d(this.f4593b.f4516a, 13));
                g1.c cVar = g1.c.f4668c;
                if (G17 instanceof C0680e) {
                    G17 = cVar;
                }
                return new C0389L((g1.c) G17);
            case Build.API_LEVELS.API_25 /* 25 */:
                Object G18 = T.b.G(1000L, new g1.e(this.f4593b.f4526l, 1));
                if (G18 instanceof C0680e) {
                    G18 = "";
                }
                return new C0390M((String) G18);
            case Build.API_LEVELS.API_26 /* 26 */:
                Object G19 = T.b.G(1000L, new g1.e(this.f4593b.f4526l, 2));
                if (G19 instanceof C0680e) {
                    G19 = "";
                }
                return new C0391N((String) G19);
            case Build.API_LEVELS.API_27 /* 27 */:
                C0358a c0358a = this.f4593b.f4525k;
                if (Build.VERSION.SDK_INT >= 28) {
                    str = c0358a.b("rtt_calling_mode");
                } else {
                    str = "";
                }
                return new C0392O(str);
            case Build.API_LEVELS.API_28 /* 28 */:
                return new C0393P(this.f4593b.f4525k.c("screen_off_timeout"));
            default:
                Object G20 = T.b.G(1000L, new R.U(this.f4593b.f4518c, 10));
                if (G20 instanceof C0680e) {
                    G20 = C0716r.f6476a;
                }
                return new T((List) G20);
        }
    }
}
