package P0;

import L0.f;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f1563a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f1564b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f1565c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f1566d = new ArrayList();

    public c(String str, String str2, String str3) {
        this.f1563a = str;
    }

    public static void a(c cVar, L0.e eVar, Object[] objArr) {
        cVar.f1566d.add(new f(eVar, objArr));
    }

    public static void b(c cVar, L0.e eVar, Object[] objArr) {
        cVar.f1565c.add(new f(eVar, objArr));
    }
}
