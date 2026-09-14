package a5;

import com.google.gson.v;
import com.google.gson.w;
import com.google.gson.x;
import com.google.gson.y;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class j extends x<Object> {

    /* renamed from: c, reason: collision with root package name */
    private static final y f224c = f(v.DOUBLE);

    /* renamed from: a, reason: collision with root package name */
    private final com.google.gson.e f225a;

    /* renamed from: b, reason: collision with root package name */
    private final w f226b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements y {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ w f227f;

        a(w wVar) {
            this.f227f = wVar;
        }

        @Override // com.google.gson.y
        public <T> x<T> a(com.google.gson.e eVar, e5.a<T> aVar) {
            a aVar2 = null;
            if (aVar.c() == Object.class) {
                return new j(eVar, this.f227f, aVar2);
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f228a;

        static {
            int[] iArr = new int[f5.b.values().length];
            f228a = iArr;
            try {
                iArr[f5.b.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f228a[f5.b.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f228a[f5.b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f228a[f5.b.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f228a[f5.b.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f228a[f5.b.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private j(com.google.gson.e eVar, w wVar) {
        this.f225a = eVar;
        this.f226b = wVar;
    }

    /* synthetic */ j(com.google.gson.e eVar, w wVar, a aVar) {
        this(eVar, wVar);
    }

    public static y e(w wVar) {
        return wVar == v.DOUBLE ? f224c : f(wVar);
    }

    private static y f(w wVar) {
        return new a(wVar);
    }

    @Override // com.google.gson.x
    public Object b(f5.a aVar) {
        switch (b.f228a[aVar.m0().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                aVar.c();
                while (aVar.N()) {
                    arrayList.add(b(aVar));
                }
                aVar.v();
                return arrayList;
            case 2:
                z4.h hVar = new z4.h();
                aVar.d();
                while (aVar.N()) {
                    hVar.put(aVar.g0(), b(aVar));
                }
                aVar.D();
                return hVar;
            case 3:
                return aVar.k0();
            case 4:
                return this.f226b.readNumber(aVar);
            case 5:
                return Boolean.valueOf(aVar.c0());
            case 6:
                aVar.i0();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.x
    public void d(f5.c cVar, Object obj) {
        if (obj == null) {
            cVar.b0();
            return;
        }
        x l10 = this.f225a.l(obj.getClass());
        if (!(l10 instanceof j)) {
            l10.d(cVar, obj);
        } else {
            cVar.g();
            cVar.D();
        }
    }
}
