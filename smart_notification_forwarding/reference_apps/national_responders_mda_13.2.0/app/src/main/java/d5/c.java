package d5;

import com.google.gson.e;
import com.google.gson.x;
import com.google.gson.y;
import java.sql.Timestamp;
import java.util.Date;

/* loaded from: classes.dex */
class c extends x<Timestamp> {

    /* renamed from: b, reason: collision with root package name */
    static final y f8662b = new a();

    /* renamed from: a, reason: collision with root package name */
    private final x<Date> f8663a;

    /* loaded from: classes.dex */
    class a implements y {
        a() {
        }

        @Override // com.google.gson.y
        public <T> x<T> a(e eVar, e5.a<T> aVar) {
            a aVar2 = null;
            if (aVar.c() == Timestamp.class) {
                return new c(eVar.l(Date.class), aVar2);
            }
            return null;
        }
    }

    private c(x<Date> xVar) {
        this.f8663a = xVar;
    }

    /* synthetic */ c(x xVar, a aVar) {
        this(xVar);
    }

    @Override // com.google.gson.x
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public Timestamp b(f5.a aVar) {
        Date b10 = this.f8663a.b(aVar);
        if (b10 != null) {
            return new Timestamp(b10.getTime());
        }
        return null;
    }

    @Override // com.google.gson.x
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void d(f5.c cVar, Timestamp timestamp) {
        this.f8663a.d(cVar, timestamp);
    }
}
