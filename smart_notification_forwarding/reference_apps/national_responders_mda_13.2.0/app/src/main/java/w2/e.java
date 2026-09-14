package w2;

import a2.a;
import com.google.android.gms.common.api.Scope;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final a.g f14901a;

    /* renamed from: b, reason: collision with root package name */
    public static final a.g f14902b;

    /* renamed from: c, reason: collision with root package name */
    public static final a.AbstractC0006a f14903c;

    /* renamed from: d, reason: collision with root package name */
    static final a.AbstractC0006a f14904d;

    /* renamed from: e, reason: collision with root package name */
    public static final a2.a f14905e;

    static {
        a.g gVar = new a.g();
        f14901a = gVar;
        a.g gVar2 = new a.g();
        f14902b = gVar2;
        b bVar = new b();
        f14903c = bVar;
        c cVar = new c();
        f14904d = cVar;
        new Scope("profile");
        new Scope("email");
        f14905e = new a2.a("SignIn.API", bVar, gVar);
        new a2.a("SignIn.INTERNAL_API", cVar, gVar2);
    }
}
