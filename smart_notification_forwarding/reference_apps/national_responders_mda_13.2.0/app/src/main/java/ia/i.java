package ia;

import ga.v;
import ga.w;
import java.util.List;
import m8.o;
import m8.q;
import y8.k;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: b, reason: collision with root package name */
    public static final a f10840b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final i f10841c;

    /* renamed from: a, reason: collision with root package name */
    private final List<v> f10842a;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }

        public final i a(w wVar) {
            k.e(wVar, "table");
            if (wVar.w() == 0) {
                return b();
            }
            List<v> x10 = wVar.x();
            k.d(x10, "table.requirementList");
            return new i(x10, null);
        }

        public final i b() {
            return i.f10841c;
        }
    }

    static {
        List d10;
        d10 = q.d();
        f10841c = new i(d10);
    }

    private i(List<v> list) {
        this.f10842a = list;
    }

    public /* synthetic */ i(List list, y8.g gVar) {
        this(list);
    }

    public final v b(int i10) {
        return (v) o.K(this.f10842a, i10);
    }
}
