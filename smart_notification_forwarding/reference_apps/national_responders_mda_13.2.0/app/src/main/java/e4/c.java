package e4;

import android.content.Context;
import com.google.firebase.crashlytics.internal.common.p;
import i1.e;
import i1.f;
import i1.g;
import k1.r;
import w3.v;
import x3.h;
import z2.l;
import z2.m;

/* loaded from: classes.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    private static final h f9143b = new h();

    /* renamed from: c, reason: collision with root package name */
    private static final String f9144c = d("hts/cahyiseot-agolai.o/1frlglgc/aclg", "tp:/rsltcrprsp.ogepscmv/ieo/eaybtho");

    /* renamed from: d, reason: collision with root package name */
    private static final String f9145d = d("AzSBpY4F0rHiHFdinTvM", "IayrSTFL9eJ69YeSUO2");

    /* renamed from: e, reason: collision with root package name */
    private static final e<v, byte[]> f9146e = b.a();

    /* renamed from: a, reason: collision with root package name */
    private final f<v> f9147a;

    c(f<v> fVar, e<v, byte[]> eVar) {
        this.f9147a = fVar;
    }

    public static c a(Context context) {
        r.f(context);
        g g10 = r.c().g(new com.google.android.datatransport.cct.a(f9144c, f9145d));
        i1.b b10 = i1.b.b("json");
        e<v, byte[]> eVar = f9146e;
        return new c(g10.a("FIREBASE_CRASHLYTICS_REPORT", v.class, b10, eVar), eVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(m mVar, p pVar, Exception exc) {
        if (exc != null) {
            mVar.d(exc);
        } else {
            mVar.e(pVar);
        }
    }

    private static String d(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb2 = new StringBuilder(str.length() + str2.length());
        for (int i10 = 0; i10 < str.length(); i10++) {
            sb2.append(str.charAt(i10));
            if (str2.length() > i10) {
                sb2.append(str2.charAt(i10));
            }
        }
        return sb2.toString();
    }

    public l<p> e(p pVar) {
        v b10 = pVar.b();
        m mVar = new m();
        this.f9147a.b(i1.c.e(b10), a.b(mVar, pVar));
        return mVar.a();
    }
}
