package a5;

import com.google.gson.t;
import com.google.gson.x;
import com.google.gson.y;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class c extends x<Date> {

    /* renamed from: b, reason: collision with root package name */
    public static final y f197b = new a();

    /* renamed from: a, reason: collision with root package name */
    private final List<DateFormat> f198a;

    /* loaded from: classes.dex */
    class a implements y {
        a() {
        }

        @Override // com.google.gson.y
        public <T> x<T> a(com.google.gson.e eVar, e5.a<T> aVar) {
            if (aVar.c() == Date.class) {
                return new c();
            }
            return null;
        }
    }

    public c() {
        ArrayList arrayList = new ArrayList();
        this.f198a = arrayList;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (z4.e.e()) {
            arrayList.add(z4.j.c(2, 2));
        }
    }

    private synchronized Date e(String str) {
        Iterator<DateFormat> it = this.f198a.iterator();
        while (it.hasNext()) {
            try {
                return it.next().parse(str);
            } catch (ParseException unused) {
            }
        }
        try {
            return b5.a.c(str, new ParsePosition(0));
        } catch (ParseException e10) {
            throw new t(str, e10);
        }
    }

    @Override // com.google.gson.x
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Date b(f5.a aVar) {
        if (aVar.m0() != f5.b.NULL) {
            return e(aVar.k0());
        }
        aVar.i0();
        return null;
    }

    @Override // com.google.gson.x
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public synchronized void d(f5.c cVar, Date date) {
        if (date == null) {
            cVar.b0();
        } else {
            cVar.o0(this.f198a.get(0).format(date));
        }
    }
}
