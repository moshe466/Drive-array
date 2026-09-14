package n4;

import android.util.Base64;
import android.util.JsonWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import l4.f;
import l4.g;

/* loaded from: classes.dex */
final class e implements l4.e, g {

    /* renamed from: a, reason: collision with root package name */
    private e f12218a = null;

    /* renamed from: b, reason: collision with root package name */
    private boolean f12219b = true;

    /* renamed from: c, reason: collision with root package name */
    private final JsonWriter f12220c;

    /* renamed from: d, reason: collision with root package name */
    private final Map<Class<?>, l4.d<?>> f12221d;

    /* renamed from: e, reason: collision with root package name */
    private final Map<Class<?>, f<?>> f12222e;

    /* renamed from: f, reason: collision with root package name */
    private final l4.d<Object> f12223f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f12224g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Writer writer, Map<Class<?>, l4.d<?>> map, Map<Class<?>, f<?>> map2, l4.d<Object> dVar, boolean z10) {
        this.f12220c = new JsonWriter(writer);
        this.f12221d = map;
        this.f12222e = map2;
        this.f12223f = dVar;
        this.f12224g = z10;
    }

    private boolean s(Object obj) {
        return obj == null || obj.getClass().isArray() || (obj instanceof Collection) || (obj instanceof Date) || (obj instanceof Enum) || (obj instanceof Number);
    }

    private e v(String str, Object obj) {
        x();
        this.f12220c.name(str);
        if (obj != null) {
            return k(obj, false);
        }
        this.f12220c.nullValue();
        return this;
    }

    private e w(String str, Object obj) {
        if (obj == null) {
            return this;
        }
        x();
        this.f12220c.name(str);
        return k(obj, false);
    }

    private void x() {
        if (!this.f12219b) {
            throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
        }
        e eVar = this.f12218a;
        if (eVar != null) {
            eVar.x();
            this.f12218a.f12219b = false;
            this.f12218a = null;
            this.f12220c.endObject();
        }
    }

    @Override // l4.e
    public l4.e c(l4.c cVar, Object obj) {
        return g(cVar.a(), obj);
    }

    @Override // l4.e
    public l4.e h(l4.c cVar, long j10) {
        return b(cVar.a(), j10);
    }

    public e i(int i10) {
        x();
        this.f12220c.value(i10);
        return this;
    }

    public e j(long j10) {
        x();
        this.f12220c.value(j10);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e k(Object obj, boolean z10) {
        int i10 = 0;
        if (z10 && s(obj)) {
            Object[] objArr = new Object[1];
            objArr[0] = obj == null ? null : obj.getClass();
            throw new l4.b(String.format("%s cannot be encoded inline", objArr));
        }
        if (obj == null) {
            this.f12220c.nullValue();
            return this;
        }
        if (obj instanceof Number) {
            this.f12220c.value((Number) obj);
            return this;
        }
        if (!obj.getClass().isArray()) {
            if (obj instanceof Collection) {
                this.f12220c.beginArray();
                Iterator it = ((Collection) obj).iterator();
                while (it.hasNext()) {
                    k(it.next(), false);
                }
                this.f12220c.endArray();
                return this;
            }
            if (obj instanceof Map) {
                this.f12220c.beginObject();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    Object key = entry.getKey();
                    try {
                        g((String) key, entry.getValue());
                    } catch (ClassCastException e10) {
                        throw new l4.b(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", key, key.getClass()), e10);
                    }
                }
                this.f12220c.endObject();
                return this;
            }
            l4.d<?> dVar = this.f12221d.get(obj.getClass());
            if (dVar != null) {
                return u(dVar, obj, z10);
            }
            f<?> fVar = this.f12222e.get(obj.getClass());
            if (fVar != null) {
                fVar.a(obj, this);
                return this;
            }
            if (!(obj instanceof Enum)) {
                return u(this.f12223f, obj, z10);
            }
            e(((Enum) obj).name());
            return this;
        }
        if (obj instanceof byte[]) {
            return r((byte[]) obj);
        }
        this.f12220c.beginArray();
        if (obj instanceof int[]) {
            int length = ((int[]) obj).length;
            while (i10 < length) {
                this.f12220c.value(r6[i10]);
                i10++;
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            int length2 = jArr.length;
            while (i10 < length2) {
                j(jArr[i10]);
                i10++;
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length3 = dArr.length;
            while (i10 < length3) {
                this.f12220c.value(dArr[i10]);
                i10++;
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            int length4 = zArr.length;
            while (i10 < length4) {
                this.f12220c.value(zArr[i10]);
                i10++;
            }
        } else if (obj instanceof Number[]) {
            for (Number number : (Number[]) obj) {
                k(number, false);
            }
        } else {
            for (Object obj2 : (Object[]) obj) {
                k(obj2, false);
            }
        }
        this.f12220c.endArray();
        return this;
    }

    @Override // l4.g
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public e e(String str) {
        x();
        this.f12220c.value(str);
        return this;
    }

    @Override // l4.e
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public e d(String str, int i10) {
        x();
        this.f12220c.name(str);
        return i(i10);
    }

    @Override // l4.e
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public e b(String str, long j10) {
        x();
        this.f12220c.name(str);
        return j(j10);
    }

    @Override // l4.e
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public e g(String str, Object obj) {
        return this.f12224g ? w(str, obj) : v(str, obj);
    }

    @Override // l4.e
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public e a(String str, boolean z10) {
        x();
        this.f12220c.name(str);
        return f(z10);
    }

    @Override // l4.g
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public e f(boolean z10) {
        x();
        this.f12220c.value(z10);
        return this;
    }

    public e r(byte[] bArr) {
        x();
        if (bArr == null) {
            this.f12220c.nullValue();
        } else {
            this.f12220c.value(Base64.encodeToString(bArr, 2));
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t() {
        x();
        this.f12220c.flush();
    }

    e u(l4.d<Object> dVar, Object obj, boolean z10) {
        if (!z10) {
            this.f12220c.beginObject();
        }
        dVar.a(obj, this);
        if (!z10) {
            this.f12220c.endObject();
        }
        return this;
    }
}
