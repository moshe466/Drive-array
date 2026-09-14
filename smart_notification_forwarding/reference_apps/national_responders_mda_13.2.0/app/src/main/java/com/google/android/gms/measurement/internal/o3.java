package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.internal.measurement.bc;
import com.google.android.gms.internal.measurement.md;
import com.google.android.gms.internal.measurement.ze;
import java.util.List;

/* loaded from: classes.dex */
public final class o3 extends z4 {

    /* renamed from: c, reason: collision with root package name */
    private String f6270c;

    /* renamed from: d, reason: collision with root package name */
    private String f6271d;

    /* renamed from: e, reason: collision with root package name */
    private int f6272e;

    /* renamed from: f, reason: collision with root package name */
    private String f6273f;

    /* renamed from: g, reason: collision with root package name */
    private long f6274g;

    /* renamed from: h, reason: collision with root package name */
    private long f6275h;

    /* renamed from: i, reason: collision with root package name */
    private List<String> f6276i;

    /* renamed from: j, reason: collision with root package name */
    private int f6277j;

    /* renamed from: k, reason: collision with root package name */
    private String f6278k;

    /* renamed from: l, reason: collision with root package name */
    private String f6279l;

    /* renamed from: m, reason: collision with root package name */
    private String f6280m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o3(t4 t4Var, long j10) {
        super(t4Var);
        this.f6275h = j10;
    }

    private final String J() {
        t3 J;
        String str;
        if (ze.a() && m().t(s.f6415l0)) {
            J = h().N();
            str = "Disabled IID for tests.";
        } else {
            try {
                Class<?> loadClass = i().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                if (loadClass == null) {
                    return null;
                }
                try {
                    Object invoke = loadClass.getDeclaredMethod("getInstance", Context.class).invoke(null, i());
                    if (invoke == null) {
                        return null;
                    }
                    try {
                        return (String) loadClass.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(invoke, new Object[0]);
                    } catch (Exception unused) {
                        J = h().K();
                        str = "Failed to retrieve Firebase Instance Id";
                    }
                } catch (Exception unused2) {
                    J = h().J();
                    str = "Failed to obtain Firebase Analytics instance";
                }
            } catch (ClassNotFoundException unused3) {
                return null;
            }
        }
        J.a(str);
        return null;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(29:1|(1:3)(6:105|106|(1:108)(2:123|(1:125))|109|110|(4:112|(1:114)(1:121)|116|117))|4|(1:104)(1:8)|9|(1:103)(1:13)|14|(1:(1:17)(1:18))|(4:20|21|23|(11:25|26|(1:28)|29|30|(1:90)(1:34)|35|(1:37)(1:89)|38|39|(8:86|(2:88|84)|(3:51|(1:53)(1:56)|54)|57|(3:59|(1:61)(3:63|(3:66|(1:68)(1:69)|64)|70)|62)|(1:72)|73|(1:(2:76|77)(2:79|80))(2:81|82))(10:43|(1:45)(1:85)|46|(2:83|84)|(0)|57|(0)|(0)|73|(0)(0))))|102|26|(0)|29|30|(1:32)|90|35|(0)(0)|38|39|(1:41)|86|(0)|(0)|57|(0)|(0)|73|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x020d, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x020e, code lost:
    
        h().F().c("Fetching Google App Id failed with exception. appId", com.google.android.gms.measurement.internal.r3.x(r0), r2);
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0174 A[Catch: IllegalStateException -> 0x020d, TryCatch #3 {IllegalStateException -> 0x020d, blocks: (B:30:0x016e, B:32:0x0174, B:34:0x0180, B:35:0x018f, B:38:0x0198, B:41:0x01a2, B:43:0x01ae, B:46:0x01c5, B:48:0x01cd, B:51:0x01f0, B:53:0x0204, B:54:0x0209, B:56:0x0207, B:83:0x01d3, B:84:0x01d7, B:86:0x01da, B:88:0x01e0, B:90:0x018b), top: B:29:0x016e }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01a2 A[Catch: IllegalStateException -> 0x020d, TRY_ENTER, TryCatch #3 {IllegalStateException -> 0x020d, blocks: (B:30:0x016e, B:32:0x0174, B:34:0x0180, B:35:0x018f, B:38:0x0198, B:41:0x01a2, B:43:0x01ae, B:46:0x01c5, B:48:0x01cd, B:51:0x01f0, B:53:0x0204, B:54:0x0209, B:56:0x0207, B:83:0x01d3, B:84:0x01d7, B:86:0x01da, B:88:0x01e0, B:90:0x018b), top: B:29:0x016e }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01f0 A[Catch: IllegalStateException -> 0x020d, TryCatch #3 {IllegalStateException -> 0x020d, blocks: (B:30:0x016e, B:32:0x0174, B:34:0x0180, B:35:0x018f, B:38:0x0198, B:41:0x01a2, B:43:0x01ae, B:46:0x01c5, B:48:0x01cd, B:51:0x01f0, B:53:0x0204, B:54:0x0209, B:56:0x0207, B:83:0x01d3, B:84:0x01d7, B:86:0x01da, B:88:0x01e0, B:90:0x018b), top: B:29:0x016e }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01e0 A[Catch: IllegalStateException -> 0x020d, TryCatch #3 {IllegalStateException -> 0x020d, blocks: (B:30:0x016e, B:32:0x0174, B:34:0x0180, B:35:0x018f, B:38:0x0198, B:41:0x01a2, B:43:0x01ae, B:46:0x01c5, B:48:0x01cd, B:51:0x01f0, B:53:0x0204, B:54:0x0209, B:56:0x0207, B:83:0x01d3, B:84:0x01d7, B:86:0x01da, B:88:0x01e0, B:90:0x018b), top: B:29:0x016e }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0197  */
    @Override // com.google.android.gms.measurement.internal.z4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final void A() {
        /*
            Method dump skipped, instructions count: 660
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.o3.A():void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final v9 B(String str) {
        c();
        String C = C();
        String D = D();
        w();
        String str2 = this.f6271d;
        long G = G();
        w();
        String str3 = this.f6273f;
        w();
        c();
        if (this.f6274g == 0) {
            this.f6274g = this.f6381a.G().y(i(), i().getPackageName());
        }
        long j10 = this.f6274g;
        boolean p10 = this.f6381a.p();
        boolean z10 = !l().f5975v;
        c();
        String J = !this.f6381a.p() ? null : J();
        t4 t4Var = this.f6381a;
        Long valueOf = Long.valueOf(t4Var.x().f5963j.a());
        long min = valueOf.longValue() == 0 ? t4Var.G : Math.min(t4Var.G, valueOf.longValue());
        int H = H();
        boolean booleanValue = m().G().booleanValue();
        Boolean E = m().E("google_analytics_ssaid_collection_enabled");
        boolean booleanValue2 = Boolean.valueOf(E == null || E.booleanValue()).booleanValue();
        e4 l10 = l();
        l10.c();
        boolean z11 = l10.E().getBoolean("deferred_analytics_collection", false);
        String E2 = E();
        Boolean E3 = m().E("google_analytics_default_allow_ad_personalization_signals");
        return new v9(C, D, str2, G, str3, 33025L, j10, str, p10, z10, J, 0L, min, H, booleanValue, booleanValue2, z11, E2, E3 == null ? null : Boolean.valueOf(true ^ E3.booleanValue()), this.f6275h, this.f6276i, (md.a() && m().t(s.f6411j0)) ? F() : null, (bc.a() && m().t(s.H0)) ? l().M().d() : "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String C() {
        w();
        return this.f6270c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String D() {
        w();
        return this.f6278k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String E() {
        w();
        return this.f6279l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String F() {
        w();
        return this.f6280m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int G() {
        w();
        return this.f6272e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int H() {
        w();
        return this.f6277j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<String> I() {
        return this.f6276i;
    }

    @Override // com.google.android.gms.measurement.internal.z4
    protected final boolean z() {
        return true;
    }
}
