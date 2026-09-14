package L0;

import java.security.cert.X509Certificate;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final String f1249a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f1250b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f1251c;

    public g(P0.c cVar) {
        this.f1249a = cVar.f1563a;
        this.f1250b = cVar.f1564b;
        this.f1251c = cVar.f1566d;
    }

    public final X509Certificate a() {
        ArrayList arrayList = this.f1250b;
        if (arrayList.isEmpty()) {
            return null;
        }
        return (X509Certificate) arrayList.get(0);
    }
}
