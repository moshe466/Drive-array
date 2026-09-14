package a5;

import com.google.gson.t;
import com.google.gson.v;
import com.google.gson.w;
import com.google.gson.x;
import com.google.gson.y;

/* loaded from: classes.dex */
public final class i extends x<Number> {

    /* renamed from: b, reason: collision with root package name */
    private static final y f220b = f(v.LAZILY_PARSED_NUMBER);

    /* renamed from: a, reason: collision with root package name */
    private final w f221a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements y {
        a() {
        }

        @Override // com.google.gson.y
        public <T> x<T> a(com.google.gson.e eVar, e5.a<T> aVar) {
            if (aVar.c() == Number.class) {
                return i.this;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f223a;

        static {
            int[] iArr = new int[f5.b.values().length];
            f223a = iArr;
            try {
                iArr[f5.b.NULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f223a[f5.b.NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f223a[f5.b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private i(w wVar) {
        this.f221a = wVar;
    }

    public static y e(w wVar) {
        return wVar == v.LAZILY_PARSED_NUMBER ? f220b : f(wVar);
    }

    private static y f(w wVar) {
        return new a();
    }

    @Override // com.google.gson.x
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public Number b(f5.a aVar) {
        f5.b m02 = aVar.m0();
        int i10 = b.f223a[m02.ordinal()];
        if (i10 == 1) {
            aVar.i0();
            return null;
        }
        if (i10 == 2 || i10 == 3) {
            return this.f221a.readNumber(aVar);
        }
        throw new t("Expecting number, got: " + m02);
    }

    @Override // com.google.gson.x
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void d(f5.c cVar, Number number) {
        cVar.n0(number);
    }
}
