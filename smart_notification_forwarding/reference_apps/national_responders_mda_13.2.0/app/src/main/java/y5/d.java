package y5;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.v;
import okhttp3.y;

/* loaded from: classes.dex */
public class d {

    /* renamed from: d, reason: collision with root package name */
    private static d f15917d;

    /* renamed from: a, reason: collision with root package name */
    private final com.google.gson.e f15918a = new com.google.gson.e();

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, y5.a> f15919b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private e f15920c = f();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements okhttp3.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f15921a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15922b;

        a(c cVar, String str) {
            this.f15921a = cVar;
            this.f15922b = str;
        }

        @Override // okhttp3.e
        public void a(okhttp3.d dVar, a0 a0Var) {
            if (a0Var.H()) {
                b0 c10 = a0Var.c();
                String c11 = c(c10 != null ? c10.D() : "");
                d.this.f15919b.put(this.f15922b, new y5.a(new Date(), c11));
                this.f15921a.b(c11);
            }
        }

        @Override // okhttp3.e
        public void b(okhttp3.d dVar, IOException iOException) {
            this.f15921a.a(iOException);
        }

        public String c(String str) {
            y5.b bVar = (y5.b) d.this.f15918a.i(str, y5.b.class);
            return bVar.b() ? bVar.a() : "";
        }
    }

    /* loaded from: classes.dex */
    class b implements c {
        b(d dVar) {
        }

        @Override // y5.c
        public void a(IOException iOException) {
        }

        @Override // y5.c
        public void b(String str) {
        }
    }

    private d() {
    }

    public static d e() {
        if (f15917d == null) {
            f15917d = new d();
        }
        return f15917d;
    }

    private e f() {
        e eVar = new e();
        eVar.b(false);
        return eVar;
    }

    private boolean g(y5.a aVar) {
        return (new Date().getTime() / 1000) - (aVar.a().getTime() / 1000) > ((long) this.f15920c.a());
    }

    private void h(String str, String str2, c cVar) {
        new v().w(new y.a().h(str).a()).v(new a(cVar, str2));
    }

    public void c(String str, c cVar) {
        StringBuilder sb2;
        y5.a aVar = this.f15919b.get(str);
        if (aVar == null) {
            sb2 = new StringBuilder();
        } else {
            if (!g(aVar)) {
                cVar.b(aVar.b());
                return;
            }
            sb2 = new StringBuilder();
        }
        sb2.append("https://m.mda.org.il/RemoteConfig/api/config?paramName=");
        sb2.append(str);
        h(sb2.toString(), str, cVar);
    }

    public String d(String str) {
        y5.a aVar = this.f15919b.get(str);
        if (aVar != null) {
            return aVar.b();
        }
        c("CheckMockLocation", new b(this));
        return "";
    }
}
