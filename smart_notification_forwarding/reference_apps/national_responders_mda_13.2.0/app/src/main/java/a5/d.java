package a5;

import com.google.gson.t;
import com.google.gson.x;
import com.google.gson.y;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class d<T extends Date> extends x<T> {

    /* renamed from: a, reason: collision with root package name */
    private final b<T> f199a;

    /* renamed from: b, reason: collision with root package name */
    private final List<DateFormat> f200b;

    /* loaded from: classes.dex */
    public static abstract class b<T extends Date> {

        /* renamed from: b, reason: collision with root package name */
        public static final b<Date> f201b = new a(Date.class);

        /* renamed from: a, reason: collision with root package name */
        private final Class<T> f202a;

        /* loaded from: classes.dex */
        class a extends b<Date> {
            a(Class cls) {
                super(cls);
            }

            @Override // a5.d.b
            protected Date d(Date date) {
                return date;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public b(Class<T> cls) {
            this.f202a = cls;
        }

        private final y c(d<T> dVar) {
            return n.b(this.f202a, dVar);
        }

        public final y a(int i10, int i11) {
            return c(new d<>(this, i10, i11));
        }

        public final y b(String str) {
            return c(new d<>(this, str));
        }

        protected abstract T d(Date date);
    }

    private d(b<T> bVar, int i10, int i11) {
        ArrayList arrayList = new ArrayList();
        this.f200b = arrayList;
        this.f199a = (b) z4.a.b(bVar);
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i10, i11, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(i10, i11));
        }
        if (z4.e.e()) {
            arrayList.add(z4.j.c(i10, i11));
        }
    }

    private d(b<T> bVar, String str) {
        ArrayList arrayList = new ArrayList();
        this.f200b = arrayList;
        this.f199a = (b) z4.a.b(bVar);
        Locale locale = Locale.US;
        arrayList.add(new SimpleDateFormat(str, locale));
        if (Locale.getDefault().equals(locale)) {
            return;
        }
        arrayList.add(new SimpleDateFormat(str));
    }

    private Date e(String str) {
        synchronized (this.f200b) {
            Iterator<DateFormat> it = this.f200b.iterator();
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
    }

    @Override // com.google.gson.x
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public T b(f5.a aVar) {
        if (aVar.m0() == f5.b.NULL) {
            aVar.i0();
            return null;
        }
        return this.f199a.d(e(aVar.k0()));
    }

    @Override // com.google.gson.x
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void d(f5.c cVar, Date date) {
        if (date == null) {
            cVar.b0();
            return;
        }
        synchronized (this.f200b) {
            cVar.o0(this.f200b.get(0).format(date));
        }
    }

    public String toString() {
        StringBuilder sb2;
        String simpleName;
        DateFormat dateFormat = this.f200b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            sb2 = new StringBuilder();
            sb2.append("DefaultDateTypeAdapter(");
            simpleName = ((SimpleDateFormat) dateFormat).toPattern();
        } else {
            sb2 = new StringBuilder();
            sb2.append("DefaultDateTypeAdapter(");
            simpleName = dateFormat.getClass().getSimpleName();
        }
        sb2.append(simpleName);
        sb2.append(')');
        return sb2.toString();
    }
}
