package d5;

import com.google.gson.e;
import com.google.gson.t;
import com.google.gson.x;
import com.google.gson.y;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* loaded from: classes.dex */
final class a extends x<Date> {

    /* renamed from: b, reason: collision with root package name */
    static final y f8658b = new C0141a();

    /* renamed from: a, reason: collision with root package name */
    private final DateFormat f8659a;

    /* renamed from: d5.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0141a implements y {
        C0141a() {
        }

        @Override // com.google.gson.y
        public <T> x<T> a(e eVar, e5.a<T> aVar) {
            C0141a c0141a = null;
            if (aVar.c() == Date.class) {
                return new a(c0141a);
            }
            return null;
        }
    }

    private a() {
        this.f8659a = new SimpleDateFormat("MMM d, yyyy");
    }

    /* synthetic */ a(C0141a c0141a) {
        this();
    }

    @Override // com.google.gson.x
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public synchronized Date b(f5.a aVar) {
        if (aVar.m0() == f5.b.NULL) {
            aVar.i0();
            return null;
        }
        try {
            return new Date(this.f8659a.parse(aVar.k0()).getTime());
        } catch (ParseException e10) {
            throw new t(e10);
        }
    }

    @Override // com.google.gson.x
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public synchronized void d(f5.c cVar, Date date) {
        cVar.o0(date == null ? null : this.f8659a.format((java.util.Date) date));
    }
}
