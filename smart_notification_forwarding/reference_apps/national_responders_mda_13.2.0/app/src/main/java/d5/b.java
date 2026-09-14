package d5;

import com.google.gson.e;
import com.google.gson.t;
import com.google.gson.x;
import com.google.gson.y;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
final class b extends x<Time> {

    /* renamed from: b, reason: collision with root package name */
    static final y f8660b = new a();

    /* renamed from: a, reason: collision with root package name */
    private final DateFormat f8661a;

    /* loaded from: classes.dex */
    class a implements y {
        a() {
        }

        @Override // com.google.gson.y
        public <T> x<T> a(e eVar, e5.a<T> aVar) {
            a aVar2 = null;
            if (aVar.c() == Time.class) {
                return new b(aVar2);
            }
            return null;
        }
    }

    private b() {
        this.f8661a = new SimpleDateFormat("hh:mm:ss a");
    }

    /* synthetic */ b(a aVar) {
        this();
    }

    @Override // com.google.gson.x
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public synchronized Time b(f5.a aVar) {
        if (aVar.m0() == f5.b.NULL) {
            aVar.i0();
            return null;
        }
        try {
            return new Time(this.f8661a.parse(aVar.k0()).getTime());
        } catch (ParseException e10) {
            throw new t(e10);
        }
    }

    @Override // com.google.gson.x
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public synchronized void d(f5.c cVar, Time time) {
        cVar.o0(time == null ? null : this.f8661a.format((Date) time));
    }
}
