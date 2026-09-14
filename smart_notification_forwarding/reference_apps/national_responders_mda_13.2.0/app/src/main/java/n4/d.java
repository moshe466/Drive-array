package n4;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import l4.f;
import l4.g;

/* loaded from: classes.dex */
public final class d implements m4.b<d> {

    /* renamed from: e, reason: collision with root package name */
    private static final l4.d<Object> f12208e = n4.a.b();

    /* renamed from: f, reason: collision with root package name */
    private static final f<String> f12209f = n4.b.b();

    /* renamed from: g, reason: collision with root package name */
    private static final f<Boolean> f12210g = c.b();

    /* renamed from: h, reason: collision with root package name */
    private static final b f12211h = new b(null);

    /* renamed from: a, reason: collision with root package name */
    private final Map<Class<?>, l4.d<?>> f12212a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Map<Class<?>, f<?>> f12213b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private l4.d<Object> f12214c = f12208e;

    /* renamed from: d, reason: collision with root package name */
    private boolean f12215d = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements l4.a {
        a() {
        }

        @Override // l4.a
        public String a(Object obj) {
            StringWriter stringWriter = new StringWriter();
            try {
                b(obj, stringWriter);
            } catch (IOException unused) {
            }
            return stringWriter.toString();
        }

        @Override // l4.a
        public void b(Object obj, Writer writer) {
            e eVar = new e(writer, d.this.f12212a, d.this.f12213b, d.this.f12214c, d.this.f12215d);
            eVar.k(obj, false);
            eVar.t();
        }
    }

    /* loaded from: classes.dex */
    private static final class b implements f<Date> {

        /* renamed from: a, reason: collision with root package name */
        private static final DateFormat f12217a;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            f12217a = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }

        private b() {
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        @Override // l4.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Date date, g gVar) {
            gVar.e(f12217a.format(date));
        }
    }

    public d() {
        m(String.class, f12209f);
        m(Boolean.class, f12210g);
        m(Date.class, f12211h);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void i(Object obj, l4.e eVar) {
        throw new l4.b("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
    }

    public l4.a f() {
        return new a();
    }

    public d g(m4.a aVar) {
        aVar.a(this);
        return this;
    }

    public d h(boolean z10) {
        this.f12215d = z10;
        return this;
    }

    @Override // m4.b
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public <T> d a(Class<T> cls, l4.d<? super T> dVar) {
        this.f12212a.put(cls, dVar);
        this.f12213b.remove(cls);
        return this;
    }

    public <T> d m(Class<T> cls, f<? super T> fVar) {
        this.f12213b.put(cls, fVar);
        this.f12212a.remove(cls);
        return this;
    }
}
