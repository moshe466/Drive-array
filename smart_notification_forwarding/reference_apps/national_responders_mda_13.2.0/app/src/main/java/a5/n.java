package a5;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* loaded from: classes.dex */
public final class n {
    public static final com.google.gson.x<BigInteger> A;
    public static final com.google.gson.y B;
    public static final com.google.gson.x<StringBuilder> C;
    public static final com.google.gson.y D;
    public static final com.google.gson.x<StringBuffer> E;
    public static final com.google.gson.y F;
    public static final com.google.gson.x<URL> G;
    public static final com.google.gson.y H;
    public static final com.google.gson.x<URI> I;
    public static final com.google.gson.y J;
    public static final com.google.gson.x<InetAddress> K;
    public static final com.google.gson.y L;
    public static final com.google.gson.x<UUID> M;
    public static final com.google.gson.y N;
    public static final com.google.gson.x<Currency> O;
    public static final com.google.gson.y P;
    public static final com.google.gson.x<Calendar> Q;
    public static final com.google.gson.y R;
    public static final com.google.gson.x<Locale> S;
    public static final com.google.gson.y T;
    public static final com.google.gson.x<com.google.gson.k> U;
    public static final com.google.gson.y V;
    public static final com.google.gson.y W;

    /* renamed from: a, reason: collision with root package name */
    public static final com.google.gson.x<Class> f260a;

    /* renamed from: b, reason: collision with root package name */
    public static final com.google.gson.y f261b;

    /* renamed from: c, reason: collision with root package name */
    public static final com.google.gson.x<BitSet> f262c;

    /* renamed from: d, reason: collision with root package name */
    public static final com.google.gson.y f263d;

    /* renamed from: e, reason: collision with root package name */
    public static final com.google.gson.x<Boolean> f264e;

    /* renamed from: f, reason: collision with root package name */
    public static final com.google.gson.x<Boolean> f265f;

    /* renamed from: g, reason: collision with root package name */
    public static final com.google.gson.y f266g;

    /* renamed from: h, reason: collision with root package name */
    public static final com.google.gson.x<Number> f267h;

    /* renamed from: i, reason: collision with root package name */
    public static final com.google.gson.y f268i;

    /* renamed from: j, reason: collision with root package name */
    public static final com.google.gson.x<Number> f269j;

    /* renamed from: k, reason: collision with root package name */
    public static final com.google.gson.y f270k;

    /* renamed from: l, reason: collision with root package name */
    public static final com.google.gson.x<Number> f271l;

    /* renamed from: m, reason: collision with root package name */
    public static final com.google.gson.y f272m;

    /* renamed from: n, reason: collision with root package name */
    public static final com.google.gson.x<AtomicInteger> f273n;

    /* renamed from: o, reason: collision with root package name */
    public static final com.google.gson.y f274o;

    /* renamed from: p, reason: collision with root package name */
    public static final com.google.gson.x<AtomicBoolean> f275p;

    /* renamed from: q, reason: collision with root package name */
    public static final com.google.gson.y f276q;

    /* renamed from: r, reason: collision with root package name */
    public static final com.google.gson.x<AtomicIntegerArray> f277r;

    /* renamed from: s, reason: collision with root package name */
    public static final com.google.gson.y f278s;

    /* renamed from: t, reason: collision with root package name */
    public static final com.google.gson.x<Number> f279t;

    /* renamed from: u, reason: collision with root package name */
    public static final com.google.gson.x<Number> f280u;

    /* renamed from: v, reason: collision with root package name */
    public static final com.google.gson.x<Number> f281v;

    /* renamed from: w, reason: collision with root package name */
    public static final com.google.gson.x<Character> f282w;

    /* renamed from: x, reason: collision with root package name */
    public static final com.google.gson.y f283x;

    /* renamed from: y, reason: collision with root package name */
    public static final com.google.gson.x<String> f284y;

    /* renamed from: z, reason: collision with root package name */
    public static final com.google.gson.x<BigDecimal> f285z;

    /* loaded from: classes.dex */
    class a extends com.google.gson.x<AtomicIntegerArray> {
        a() {
        }

        @Override // com.google.gson.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public AtomicIntegerArray b(f5.a aVar) {
            ArrayList arrayList = new ArrayList();
            aVar.c();
            while (aVar.N()) {
                try {
                    arrayList.add(Integer.valueOf(aVar.e0()));
                } catch (NumberFormatException e10) {
                    throw new com.google.gson.t(e10);
                }
            }
            aVar.v();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i10 = 0; i10 < size; i10++) {
                atomicIntegerArray.set(i10, ((Integer) arrayList.get(i10)).intValue());
            }
            return atomicIntegerArray;
        }

        @Override // com.google.gson.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(f5.c cVar, AtomicIntegerArray atomicIntegerArray) {
            cVar.f();
            int length = atomicIntegerArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                cVar.l0(atomicIntegerArray.get(i10));
            }
            cVar.v();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a0 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f286a;

        static {
            int[] iArr = new int[f5.b.values().length];
            f286a = iArr;
            try {
                iArr[f5.b.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f286a[f5.b.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f286a[f5.b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f286a[f5.b.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f286a[f5.b.BEGIN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f286a[f5.b.BEGIN_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f286a[f5.b.END_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f286a[f5.b.NAME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f286a[f5.b.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f286a[f5.b.END_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* loaded from: classes.dex */
    class b extends com.google.gson.x<Number> {
        b() {
        }

        @Override // com.google.gson.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(f5.a aVar) {
            if (aVar.m0() == f5.b.NULL) {
                aVar.i0();
                return null;
            }
            try {
                return Long.valueOf(aVar.f0());
            } catch (NumberFormatException e10) {
                throw new com.google.gson.t(e10);
            }
        }

        @Override // com.google.gson.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(f5.c cVar, Number number) {
            cVar.n0(number);
        }
    }

    /* loaded from: classes.dex */
    class b0 extends com.google.gson.x<Boolean> {
        b0() {
        }

        @Override // com.google.gson.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Boolean b(f5.a aVar) {
            f5.b m02 = aVar.m0();
            if (m02 != f5.b.NULL) {
                return m02 == f5.b.STRING ? Boolean.valueOf(Boolean.parseBoolean(aVar.k0())) : Boolean.valueOf(aVar.c0());
            }
            aVar.i0();
            return null;
        }

        @Override // com.google.gson.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(f5.c cVar, Boolean bool) {
            cVar.m0(bool);
        }
    }

    /* loaded from: classes.dex */
    class c extends com.google.gson.x<Number> {
        c() {
        }

        @Override // com.google.gson.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(f5.a aVar) {
            if (aVar.m0() != f5.b.NULL) {
                return Float.valueOf((float) aVar.d0());
            }
            aVar.i0();
            return null;
        }

        @Override // com.google.gson.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(f5.c cVar, Number number) {
            cVar.n0(number);
        }
    }

    /* loaded from: classes.dex */
    class c0 extends com.google.gson.x<Boolean> {
        c0() {
        }

        @Override // com.google.gson.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Boolean b(f5.a aVar) {
            if (aVar.m0() != f5.b.NULL) {
                return Boolean.valueOf(aVar.k0());
            }
            aVar.i0();
            return null;
        }

        @Override // com.google.gson.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(f5.c cVar, Boolean bool) {
            cVar.o0(bool == null ? "null" : bool.toString());
        }
    }

    /* loaded from: classes.dex */
    class d extends com.google.gson.x<Number> {
        d() {
        }

        @Override // com.google.gson.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(f5.a aVar) {
            if (aVar.m0() != f5.b.NULL) {
                return Double.valueOf(aVar.d0());
            }
            aVar.i0();
            return null;
        }

        @Override // com.google.gson.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(f5.c cVar, Number number) {
            cVar.n0(number);
        }
    }

    /* loaded from: classes.dex */
    class d0 extends com.google.gson.x<Number> {
        d0() {
        }

        @Override // com.google.gson.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(f5.a aVar) {
            if (aVar.m0() == f5.b.NULL) {
                aVar.i0();
                return null;
            }
            try {
                return Byte.valueOf((byte) aVar.e0());
            } catch (NumberFormatException e10) {
                throw new com.google.gson.t(e10);
            }
        }

        @Override // com.google.gson.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(f5.c cVar, Number number) {
            cVar.n0(number);
        }
    }

    /* loaded from: classes.dex */
    class e extends com.google.gson.x<Character> {
        e() {
        }

        @Override // com.google.gson.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Character b(f5.a aVar) {
            if (aVar.m0() == f5.b.NULL) {
                aVar.i0();
                return null;
            }
            String k02 = aVar.k0();
            if (k02.length() == 1) {
                return Character.valueOf(k02.charAt(0));
            }
            throw new com.google.gson.t("Expecting character, got: " + k02);
        }

        @Override // com.google.gson.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(f5.c cVar, Character ch) {
            cVar.o0(ch == null ? null : String.valueOf(ch));
        }
    }

    /* loaded from: classes.dex */
    class e0 extends com.google.gson.x<Number> {
        e0() {
        }

        @Override // com.google.gson.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(f5.a aVar) {
            if (aVar.m0() == f5.b.NULL) {
                aVar.i0();
                return null;
            }
            try {
                return Short.valueOf((short) aVar.e0());
            } catch (NumberFormatException e10) {
                throw new com.google.gson.t(e10);
            }
        }

        @Override // com.google.gson.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(f5.c cVar, Number number) {
            cVar.n0(number);
        }
    }

    /* loaded from: classes.dex */
    class f extends com.google.gson.x<String> {
        f() {
        }

        @Override // com.google.gson.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public String b(f5.a aVar) {
            f5.b m02 = aVar.m0();
            if (m02 != f5.b.NULL) {
                return m02 == f5.b.BOOLEAN ? Boolean.toString(aVar.c0()) : aVar.k0();
            }
            aVar.i0();
            return null;
        }

        @Override // com.google.gson.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(f5.c cVar, String str) {
            cVar.o0(str);
        }
    }

    /* loaded from: classes.dex */
    class f0 extends com.google.gson.x<Number> {
        f0() {
        }

        @Override // com.google.gson.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(f5.a aVar) {
            if (aVar.m0() == f5.b.NULL) {
                aVar.i0();
                return null;
            }
            try {
                return Integer.valueOf(aVar.e0());
            } catch (NumberFormatException e10) {
                throw new com.google.gson.t(e10);
            }
        }

        @Override // com.google.gson.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(f5.c cVar, Number number) {
            cVar.n0(number);
        }
    }

    /* loaded from: classes.dex */
    class g extends com.google.gson.x<BigDecimal> {
        g() {
        }

        @Override // com.google.gson.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public BigDecimal b(f5.a aVar) {
            if (aVar.m0() == f5.b.NULL) {
                aVar.i0();
                return null;
            }
            try {
                return new BigDecimal(aVar.k0());
            } catch (NumberFormatException e10) {
                throw new com.google.gson.t(e10);
            }
        }

        @Override // com.google.gson.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(f5.c cVar, BigDecimal bigDecimal) {
            cVar.n0(bigDecimal);
        }
    }

    /* loaded from: classes.dex */
    class g0 extends com.google.gson.x<AtomicInteger> {
        g0() {
        }

        @Override // com.google.gson.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public AtomicInteger b(f5.a aVar) {
            try {
                return new AtomicInteger(aVar.e0());
            } catch (NumberFormatException e10) {
                throw new com.google.gson.t(e10);
            }
        }

        @Override // com.google.gson.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(f5.c cVar, AtomicInteger atomicInteger) {
            cVar.l0(atomicInteger.get());
        }
    }

    /* loaded from: classes.dex */
    class h extends com.google.gson.x<BigInteger> {
        h() {
        }

        @Override // com.google.gson.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public BigInteger b(f5.a aVar) {
            if (aVar.m0() == f5.b.NULL) {
                aVar.i0();
                return null;
            }
            try {
                return new BigInteger(aVar.k0());
            } catch (NumberFormatException e10) {
                throw new com.google.gson.t(e10);
            }
        }

        @Override // com.google.gson.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(f5.c cVar, BigInteger bigInteger) {
            cVar.n0(bigInteger);
        }
    }

    /* loaded from: classes.dex */
    class h0 extends com.google.gson.x<AtomicBoolean> {
        h0() {
        }

        @Override // com.google.gson.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public AtomicBoolean b(f5.a aVar) {
            return new AtomicBoolean(aVar.c0());
        }

        @Override // com.google.gson.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(f5.c cVar, AtomicBoolean atomicBoolean) {
            cVar.p0(atomicBoolean.get());
        }
    }

    /* loaded from: classes.dex */
    class i extends com.google.gson.x<StringBuilder> {
        i() {
        }

        @Override // com.google.gson.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public StringBuilder b(f5.a aVar) {
            if (aVar.m0() != f5.b.NULL) {
                return new StringBuilder(aVar.k0());
            }
            aVar.i0();
            return null;
        }

        @Override // com.google.gson.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(f5.c cVar, StringBuilder sb2) {
            cVar.o0(sb2 == null ? null : sb2.toString());
        }
    }

    /* loaded from: classes.dex */
    private static final class i0<T extends Enum<T>> extends com.google.gson.x<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Map<String, T> f287a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        private final Map<T, String> f288b = new HashMap();

        /* loaded from: classes.dex */
        class a implements PrivilegedAction<Void> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Field f289a;

            a(i0 i0Var, Field field) {
                this.f289a = field;
            }

            @Override // java.security.PrivilegedAction
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void run() {
                this.f289a.setAccessible(true);
                return null;
            }
        }

        public i0(Class<T> cls) {
            try {
                for (Field field : cls.getDeclaredFields()) {
                    if (field.isEnumConstant()) {
                        AccessController.doPrivileged(new a(this, field));
                        Enum r42 = (Enum) field.get(null);
                        String name = r42.name();
                        y4.c cVar = (y4.c) field.getAnnotation(y4.c.class);
                        if (cVar != null) {
                            name = cVar.value();
                            for (String str : cVar.alternate()) {
                                this.f287a.put(str, r42);
                            }
                        }
                        this.f287a.put(name, r42);
                        this.f288b.put(r42, name);
                    }
                }
            } catch (IllegalAccessException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // com.google.gson.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public T b(f5.a aVar) {
            if (aVar.m0() != f5.b.NULL) {
                return this.f287a.get(aVar.k0());
            }
            aVar.i0();
            return null;
        }

        @Override // com.google.gson.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(f5.c cVar, T t10) {
            cVar.o0(t10 == null ? null : this.f288b.get(t10));
        }
    }

    /* loaded from: classes.dex */
    class j extends com.google.gson.x<StringBuffer> {
        j() {
        }

        @Override // com.google.gson.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public StringBuffer b(f5.a aVar) {
            if (aVar.m0() != f5.b.NULL) {
                return new StringBuffer(aVar.k0());
            }
            aVar.i0();
            return null;
        }

        @Override // com.google.gson.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(f5.c cVar, StringBuffer stringBuffer) {
            cVar.o0(stringBuffer == null ? null : stringBuffer.toString());
        }
    }

    /* loaded from: classes.dex */
    class k extends com.google.gson.x<Class> {
        k() {
        }

        @Override // com.google.gson.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Class b(f5.a aVar) {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }

        @Override // com.google.gson.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(f5.c cVar, Class cls) {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }
    }

    /* loaded from: classes.dex */
    class l extends com.google.gson.x<URL> {
        l() {
        }

        @Override // com.google.gson.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public URL b(f5.a aVar) {
            if (aVar.m0() == f5.b.NULL) {
                aVar.i0();
                return null;
            }
            String k02 = aVar.k0();
            if ("null".equals(k02)) {
                return null;
            }
            return new URL(k02);
        }

        @Override // com.google.gson.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(f5.c cVar, URL url) {
            cVar.o0(url == null ? null : url.toExternalForm());
        }
    }

    /* loaded from: classes.dex */
    class m extends com.google.gson.x<URI> {
        m() {
        }

        @Override // com.google.gson.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public URI b(f5.a aVar) {
            if (aVar.m0() == f5.b.NULL) {
                aVar.i0();
                return null;
            }
            try {
                String k02 = aVar.k0();
                if ("null".equals(k02)) {
                    return null;
                }
                return new URI(k02);
            } catch (URISyntaxException e10) {
                throw new com.google.gson.l(e10);
            }
        }

        @Override // com.google.gson.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(f5.c cVar, URI uri) {
            cVar.o0(uri == null ? null : uri.toASCIIString());
        }
    }

    /* renamed from: a5.n$n, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0010n extends com.google.gson.x<InetAddress> {
        C0010n() {
        }

        @Override // com.google.gson.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public InetAddress b(f5.a aVar) {
            if (aVar.m0() != f5.b.NULL) {
                return InetAddress.getByName(aVar.k0());
            }
            aVar.i0();
            return null;
        }

        @Override // com.google.gson.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(f5.c cVar, InetAddress inetAddress) {
            cVar.o0(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    }

    /* loaded from: classes.dex */
    class o extends com.google.gson.x<UUID> {
        o() {
        }

        @Override // com.google.gson.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public UUID b(f5.a aVar) {
            if (aVar.m0() != f5.b.NULL) {
                return UUID.fromString(aVar.k0());
            }
            aVar.i0();
            return null;
        }

        @Override // com.google.gson.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(f5.c cVar, UUID uuid) {
            cVar.o0(uuid == null ? null : uuid.toString());
        }
    }

    /* loaded from: classes.dex */
    class p extends com.google.gson.x<Currency> {
        p() {
        }

        @Override // com.google.gson.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Currency b(f5.a aVar) {
            return Currency.getInstance(aVar.k0());
        }

        @Override // com.google.gson.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(f5.c cVar, Currency currency) {
            cVar.o0(currency.getCurrencyCode());
        }
    }

    /* loaded from: classes.dex */
    class q extends com.google.gson.x<Calendar> {
        q() {
        }

        @Override // com.google.gson.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Calendar b(f5.a aVar) {
            if (aVar.m0() == f5.b.NULL) {
                aVar.i0();
                return null;
            }
            aVar.d();
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            while (aVar.m0() != f5.b.END_OBJECT) {
                String g02 = aVar.g0();
                int e02 = aVar.e0();
                if ("year".equals(g02)) {
                    i10 = e02;
                } else if ("month".equals(g02)) {
                    i11 = e02;
                } else if ("dayOfMonth".equals(g02)) {
                    i12 = e02;
                } else if ("hourOfDay".equals(g02)) {
                    i13 = e02;
                } else if ("minute".equals(g02)) {
                    i14 = e02;
                } else if ("second".equals(g02)) {
                    i15 = e02;
                }
            }
            aVar.D();
            return new GregorianCalendar(i10, i11, i12, i13, i14, i15);
        }

        @Override // com.google.gson.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(f5.c cVar, Calendar calendar) {
            if (calendar == null) {
                cVar.b0();
                return;
            }
            cVar.g();
            cVar.O("year");
            cVar.l0(calendar.get(1));
            cVar.O("month");
            cVar.l0(calendar.get(2));
            cVar.O("dayOfMonth");
            cVar.l0(calendar.get(5));
            cVar.O("hourOfDay");
            cVar.l0(calendar.get(11));
            cVar.O("minute");
            cVar.l0(calendar.get(12));
            cVar.O("second");
            cVar.l0(calendar.get(13));
            cVar.D();
        }
    }

    /* loaded from: classes.dex */
    class r extends com.google.gson.x<Locale> {
        r() {
        }

        @Override // com.google.gson.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Locale b(f5.a aVar) {
            if (aVar.m0() == f5.b.NULL) {
                aVar.i0();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(aVar.k0(), "_");
            String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            return (nextToken2 == null && nextToken3 == null) ? new Locale(nextToken) : nextToken3 == null ? new Locale(nextToken, nextToken2) : new Locale(nextToken, nextToken2, nextToken3);
        }

        @Override // com.google.gson.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(f5.c cVar, Locale locale) {
            cVar.o0(locale == null ? null : locale.toString());
        }
    }

    /* loaded from: classes.dex */
    class s extends com.google.gson.x<com.google.gson.k> {
        s() {
        }

        @Override // com.google.gson.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public com.google.gson.k b(f5.a aVar) {
            if (aVar instanceof a5.f) {
                return ((a5.f) aVar).z0();
            }
            switch (a0.f286a[aVar.m0().ordinal()]) {
                case 1:
                    return new com.google.gson.q(new z4.g(aVar.k0()));
                case 2:
                    return new com.google.gson.q(Boolean.valueOf(aVar.c0()));
                case 3:
                    return new com.google.gson.q(aVar.k0());
                case 4:
                    aVar.i0();
                    return com.google.gson.m.f7516a;
                case 5:
                    com.google.gson.h hVar = new com.google.gson.h();
                    aVar.c();
                    while (aVar.N()) {
                        hVar.x(b(aVar));
                    }
                    aVar.v();
                    return hVar;
                case 6:
                    com.google.gson.n nVar = new com.google.gson.n();
                    aVar.d();
                    while (aVar.N()) {
                        nVar.x(aVar.g0(), b(aVar));
                    }
                    aVar.D();
                    return nVar;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // com.google.gson.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(f5.c cVar, com.google.gson.k kVar) {
            if (kVar == null || kVar.u()) {
                cVar.b0();
                return;
            }
            if (kVar.w()) {
                com.google.gson.q j10 = kVar.j();
                if (j10.C()) {
                    cVar.n0(j10.z());
                    return;
                } else if (j10.A()) {
                    cVar.p0(j10.x());
                    return;
                } else {
                    cVar.o0(j10.s());
                    return;
                }
            }
            if (kVar.t()) {
                cVar.f();
                Iterator<com.google.gson.k> it = kVar.f().iterator();
                while (it.hasNext()) {
                    d(cVar, it.next());
                }
                cVar.v();
                return;
            }
            if (!kVar.v()) {
                throw new IllegalArgumentException("Couldn't write " + kVar.getClass());
            }
            cVar.g();
            for (Map.Entry<String, com.google.gson.k> entry : kVar.g().A()) {
                cVar.O(entry.getKey());
                d(cVar, entry.getValue());
            }
            cVar.D();
        }
    }

    /* loaded from: classes.dex */
    class t implements com.google.gson.y {
        t() {
        }

        @Override // com.google.gson.y
        public <T> com.google.gson.x<T> a(com.google.gson.e eVar, e5.a<T> aVar) {
            Class<? super T> c10 = aVar.c();
            if (!Enum.class.isAssignableFrom(c10) || c10 == Enum.class) {
                return null;
            }
            if (!c10.isEnum()) {
                c10 = c10.getSuperclass();
            }
            return new i0(c10);
        }
    }

    /* loaded from: classes.dex */
    class u implements com.google.gson.y {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ e5.a f290f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.google.gson.x f291g;

        u(e5.a aVar, com.google.gson.x xVar) {
            this.f290f = aVar;
            this.f291g = xVar;
        }

        @Override // com.google.gson.y
        public <T> com.google.gson.x<T> a(com.google.gson.e eVar, e5.a<T> aVar) {
            if (aVar.equals(this.f290f)) {
                return this.f291g;
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    class v extends com.google.gson.x<BitSet> {
        v() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
        
            if (java.lang.Integer.parseInt(r1) != 0) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x002e, code lost:
        
            r5 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0067, code lost:
        
            if (r8.e0() != 0) goto L23;
         */
        @Override // com.google.gson.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.util.BitSet b(f5.a r8) {
            /*
                r7 = this;
                java.util.BitSet r0 = new java.util.BitSet
                r0.<init>()
                r8.c()
                f5.b r1 = r8.m0()
                r2 = 0
                r3 = 0
            Le:
                f5.b r4 = f5.b.END_ARRAY
                if (r1 == r4) goto L75
                int[] r4 = a5.n.a0.f286a
                int r5 = r1.ordinal()
                r4 = r4[r5]
                r5 = 1
                if (r4 == r5) goto L63
                r6 = 2
                if (r4 == r6) goto L5e
                r6 = 3
                if (r4 != r6) goto L47
                java.lang.String r1 = r8.k0()
                int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.NumberFormatException -> L30
                if (r1 == 0) goto L2e
                goto L69
            L2e:
                r5 = 0
                goto L69
            L30:
                com.google.gson.t r8 = new com.google.gson.t
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "Error: Expecting: bitset number value (1, 0), Found: "
                r0.append(r2)
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r8.<init>(r0)
                throw r8
            L47:
                com.google.gson.t r8 = new com.google.gson.t
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "Invalid bitset value type: "
                r0.append(r2)
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r8.<init>(r0)
                throw r8
            L5e:
                boolean r5 = r8.c0()
                goto L69
            L63:
                int r1 = r8.e0()
                if (r1 == 0) goto L2e
            L69:
                if (r5 == 0) goto L6e
                r0.set(r3)
            L6e:
                int r3 = r3 + 1
                f5.b r1 = r8.m0()
                goto Le
            L75:
                r8.v()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: a5.n.v.b(f5.a):java.util.BitSet");
        }

        @Override // com.google.gson.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(f5.c cVar, BitSet bitSet) {
            cVar.f();
            int length = bitSet.length();
            for (int i10 = 0; i10 < length; i10++) {
                cVar.l0(bitSet.get(i10) ? 1L : 0L);
            }
            cVar.v();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class w implements com.google.gson.y {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Class f292f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.google.gson.x f293g;

        w(Class cls, com.google.gson.x xVar) {
            this.f292f = cls;
            this.f293g = xVar;
        }

        @Override // com.google.gson.y
        public <T> com.google.gson.x<T> a(com.google.gson.e eVar, e5.a<T> aVar) {
            if (aVar.c() == this.f292f) {
                return this.f293g;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f292f.getName() + ",adapter=" + this.f293g + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class x implements com.google.gson.y {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Class f294f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Class f295g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.google.gson.x f296h;

        x(Class cls, Class cls2, com.google.gson.x xVar) {
            this.f294f = cls;
            this.f295g = cls2;
            this.f296h = xVar;
        }

        @Override // com.google.gson.y
        public <T> com.google.gson.x<T> a(com.google.gson.e eVar, e5.a<T> aVar) {
            Class<? super T> c10 = aVar.c();
            if (c10 == this.f294f || c10 == this.f295g) {
                return this.f296h;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f295g.getName() + "+" + this.f294f.getName() + ",adapter=" + this.f296h + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class y implements com.google.gson.y {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Class f297f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Class f298g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.google.gson.x f299h;

        y(Class cls, Class cls2, com.google.gson.x xVar) {
            this.f297f = cls;
            this.f298g = cls2;
            this.f299h = xVar;
        }

        @Override // com.google.gson.y
        public <T> com.google.gson.x<T> a(com.google.gson.e eVar, e5.a<T> aVar) {
            Class<? super T> c10 = aVar.c();
            if (c10 == this.f297f || c10 == this.f298g) {
                return this.f299h;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f297f.getName() + "+" + this.f298g.getName() + ",adapter=" + this.f299h + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class z implements com.google.gson.y {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Class f300f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.google.gson.x f301g;

        /* JADX INFO: Add missing generic type declarations: [T1] */
        /* loaded from: classes.dex */
        class a<T1> extends com.google.gson.x<T1> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Class f302a;

            a(Class cls) {
                this.f302a = cls;
            }

            @Override // com.google.gson.x
            public T1 b(f5.a aVar) {
                T1 t12 = (T1) z.this.f301g.b(aVar);
                if (t12 == null || this.f302a.isInstance(t12)) {
                    return t12;
                }
                throw new com.google.gson.t("Expected a " + this.f302a.getName() + " but was " + t12.getClass().getName());
            }

            @Override // com.google.gson.x
            public void d(f5.c cVar, T1 t12) {
                z.this.f301g.d(cVar, t12);
            }
        }

        z(Class cls, com.google.gson.x xVar) {
            this.f300f = cls;
            this.f301g = xVar;
        }

        @Override // com.google.gson.y
        public <T2> com.google.gson.x<T2> a(com.google.gson.e eVar, e5.a<T2> aVar) {
            Class<? super T2> c10 = aVar.c();
            if (this.f300f.isAssignableFrom(c10)) {
                return new a(c10);
            }
            return null;
        }

        public String toString() {
            return "Factory[typeHierarchy=" + this.f300f.getName() + ",adapter=" + this.f301g + "]";
        }
    }

    static {
        com.google.gson.x<Class> a10 = new k().a();
        f260a = a10;
        f261b = b(Class.class, a10);
        com.google.gson.x<BitSet> a11 = new v().a();
        f262c = a11;
        f263d = b(BitSet.class, a11);
        b0 b0Var = new b0();
        f264e = b0Var;
        f265f = new c0();
        f266g = c(Boolean.TYPE, Boolean.class, b0Var);
        d0 d0Var = new d0();
        f267h = d0Var;
        f268i = c(Byte.TYPE, Byte.class, d0Var);
        e0 e0Var = new e0();
        f269j = e0Var;
        f270k = c(Short.TYPE, Short.class, e0Var);
        f0 f0Var = new f0();
        f271l = f0Var;
        f272m = c(Integer.TYPE, Integer.class, f0Var);
        com.google.gson.x<AtomicInteger> a12 = new g0().a();
        f273n = a12;
        f274o = b(AtomicInteger.class, a12);
        com.google.gson.x<AtomicBoolean> a13 = new h0().a();
        f275p = a13;
        f276q = b(AtomicBoolean.class, a13);
        com.google.gson.x<AtomicIntegerArray> a14 = new a().a();
        f277r = a14;
        f278s = b(AtomicIntegerArray.class, a14);
        f279t = new b();
        f280u = new c();
        f281v = new d();
        e eVar = new e();
        f282w = eVar;
        f283x = c(Character.TYPE, Character.class, eVar);
        f fVar = new f();
        f284y = fVar;
        f285z = new g();
        A = new h();
        B = b(String.class, fVar);
        i iVar = new i();
        C = iVar;
        D = b(StringBuilder.class, iVar);
        j jVar = new j();
        E = jVar;
        F = b(StringBuffer.class, jVar);
        l lVar = new l();
        G = lVar;
        H = b(URL.class, lVar);
        m mVar = new m();
        I = mVar;
        J = b(URI.class, mVar);
        C0010n c0010n = new C0010n();
        K = c0010n;
        L = e(InetAddress.class, c0010n);
        o oVar = new o();
        M = oVar;
        N = b(UUID.class, oVar);
        com.google.gson.x<Currency> a15 = new p().a();
        O = a15;
        P = b(Currency.class, a15);
        q qVar = new q();
        Q = qVar;
        R = d(Calendar.class, GregorianCalendar.class, qVar);
        r rVar = new r();
        S = rVar;
        T = b(Locale.class, rVar);
        s sVar = new s();
        U = sVar;
        V = e(com.google.gson.k.class, sVar);
        W = new t();
    }

    public static <TT> com.google.gson.y a(e5.a<TT> aVar, com.google.gson.x<TT> xVar) {
        return new u(aVar, xVar);
    }

    public static <TT> com.google.gson.y b(Class<TT> cls, com.google.gson.x<TT> xVar) {
        return new w(cls, xVar);
    }

    public static <TT> com.google.gson.y c(Class<TT> cls, Class<TT> cls2, com.google.gson.x<? super TT> xVar) {
        return new x(cls, cls2, xVar);
    }

    public static <TT> com.google.gson.y d(Class<TT> cls, Class<? extends TT> cls2, com.google.gson.x<? super TT> xVar) {
        return new y(cls, cls2, xVar);
    }

    public static <T1> com.google.gson.y e(Class<T1> cls, com.google.gson.x<T1> xVar) {
        return new z(cls, xVar);
    }
}
