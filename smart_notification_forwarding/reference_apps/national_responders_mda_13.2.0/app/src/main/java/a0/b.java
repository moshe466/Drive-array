package a0;

import a0.a;
import a0.b;
import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.core.view.a0;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class b<T extends b<T>> implements a.b {

    /* renamed from: e, reason: collision with root package name */
    final a0.d f21e;

    /* renamed from: a, reason: collision with root package name */
    float f17a = 0.0f;

    /* renamed from: b, reason: collision with root package name */
    float f18b = Float.MAX_VALUE;

    /* renamed from: c, reason: collision with root package name */
    boolean f19c = false;

    /* renamed from: f, reason: collision with root package name */
    boolean f22f = false;

    /* renamed from: g, reason: collision with root package name */
    float f23g = Float.MAX_VALUE;

    /* renamed from: h, reason: collision with root package name */
    float f24h = -Float.MAX_VALUE;

    /* renamed from: i, reason: collision with root package name */
    private long f25i = 0;

    /* renamed from: k, reason: collision with root package name */
    private final ArrayList<q> f27k = new ArrayList<>();

    /* renamed from: l, reason: collision with root package name */
    private final ArrayList<r> f28l = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    final Object f20d = null;

    /* renamed from: j, reason: collision with root package name */
    private float f26j = 1.0f;

    /* loaded from: classes.dex */
    static class a extends s {
        a(String str) {
            super(str, null);
        }

        @Override // a0.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getY();
        }

        @Override // a0.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setY(f10);
        }
    }

    /* renamed from: a0.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0005b extends s {
        C0005b(String str) {
            super(str, null);
        }

        @Override // a0.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return a0.L(view);
        }

        @Override // a0.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            a0.D0(view, f10);
        }
    }

    /* loaded from: classes.dex */
    static class c extends s {
        c(String str) {
            super(str, null);
        }

        @Override // a0.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getAlpha();
        }

        @Override // a0.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setAlpha(f10);
        }
    }

    /* loaded from: classes.dex */
    static class d extends s {
        d(String str) {
            super(str, null);
        }

        @Override // a0.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScrollX();
        }

        @Override // a0.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setScrollX((int) f10);
        }
    }

    /* loaded from: classes.dex */
    static class e extends s {
        e(String str) {
            super(str, null);
        }

        @Override // a0.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScrollY();
        }

        @Override // a0.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setScrollY((int) f10);
        }
    }

    /* loaded from: classes.dex */
    class f extends a0.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a0.e f29a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(b bVar, String str, a0.e eVar) {
            super(str);
            this.f29a = eVar;
        }

        @Override // a0.d
        public float a(Object obj) {
            return this.f29a.a();
        }

        @Override // a0.d
        public void b(Object obj, float f10) {
            this.f29a.b(f10);
        }
    }

    /* loaded from: classes.dex */
    static class g extends s {
        g(String str) {
            super(str, null);
        }

        @Override // a0.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getTranslationX();
        }

        @Override // a0.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setTranslationX(f10);
        }
    }

    /* loaded from: classes.dex */
    static class h extends s {
        h(String str) {
            super(str, null);
        }

        @Override // a0.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getTranslationY();
        }

        @Override // a0.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setTranslationY(f10);
        }
    }

    /* loaded from: classes.dex */
    static class i extends s {
        i(String str) {
            super(str, null);
        }

        @Override // a0.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return a0.J(view);
        }

        @Override // a0.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            a0.B0(view, f10);
        }
    }

    /* loaded from: classes.dex */
    static class j extends s {
        j(String str) {
            super(str, null);
        }

        @Override // a0.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScaleX();
        }

        @Override // a0.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setScaleX(f10);
        }
    }

    /* loaded from: classes.dex */
    static class k extends s {
        k(String str) {
            super(str, null);
        }

        @Override // a0.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScaleY();
        }

        @Override // a0.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setScaleY(f10);
        }
    }

    /* loaded from: classes.dex */
    static class l extends s {
        l(String str) {
            super(str, null);
        }

        @Override // a0.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getRotation();
        }

        @Override // a0.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setRotation(f10);
        }
    }

    /* loaded from: classes.dex */
    static class m extends s {
        m(String str) {
            super(str, null);
        }

        @Override // a0.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getRotationX();
        }

        @Override // a0.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setRotationX(f10);
        }
    }

    /* loaded from: classes.dex */
    static class n extends s {
        n(String str) {
            super(str, null);
        }

        @Override // a0.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getRotationY();
        }

        @Override // a0.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setRotationY(f10);
        }
    }

    /* loaded from: classes.dex */
    static class o extends s {
        o(String str) {
            super(str, null);
        }

        @Override // a0.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getX();
        }

        @Override // a0.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setX(f10);
        }
    }

    /* loaded from: classes.dex */
    static class p {

        /* renamed from: a, reason: collision with root package name */
        float f30a;

        /* renamed from: b, reason: collision with root package name */
        float f31b;
    }

    /* loaded from: classes.dex */
    public interface q {
        void a(b bVar, boolean z10, float f10, float f11);
    }

    /* loaded from: classes.dex */
    public interface r {
        void a(b bVar, float f10, float f11);
    }

    /* loaded from: classes.dex */
    public static abstract class s extends a0.d<View> {
        private s(String str) {
            super(str);
        }

        /* synthetic */ s(String str, g gVar) {
            this(str);
        }
    }

    static {
        new g("translationX");
        new h("translationY");
        new i("translationZ");
        new j("scaleX");
        new k("scaleY");
        new l("rotation");
        new m("rotationX");
        new n("rotationY");
        new o("x");
        new a("y");
        new C0005b("z");
        new c("alpha");
        new d("scrollX");
        new e("scrollY");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a0.e eVar) {
        this.f21e = new f(this, "FloatValueHolder", eVar);
    }

    private void c(boolean z10) {
        this.f22f = false;
        a0.a.d().g(this);
        this.f25i = 0L;
        this.f19c = false;
        for (int i10 = 0; i10 < this.f27k.size(); i10++) {
            if (this.f27k.get(i10) != null) {
                this.f27k.get(i10).a(this, z10, this.f18b, this.f17a);
            }
        }
        g(this.f27k);
    }

    private float d() {
        return this.f21e.a(this.f20d);
    }

    private static <T> void g(ArrayList<T> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    private void p() {
        if (this.f22f) {
            return;
        }
        this.f22f = true;
        if (!this.f19c) {
            this.f18b = d();
        }
        float f10 = this.f18b;
        if (f10 > this.f23g || f10 < this.f24h) {
            throw new IllegalArgumentException("Starting value need to be in between min value and max value");
        }
        a0.a.d().a(this, 0L);
    }

    @Override // a0.a.b
    public boolean a(long j10) {
        long j11 = this.f25i;
        if (j11 == 0) {
            this.f25i = j10;
            k(this.f18b);
            return false;
        }
        this.f25i = j10;
        boolean q10 = q(j10 - j11);
        float min = Math.min(this.f18b, this.f23g);
        this.f18b = min;
        float max = Math.max(min, this.f24h);
        this.f18b = max;
        k(max);
        if (q10) {
            c(false);
        }
        return q10;
    }

    public T b(r rVar) {
        if (f()) {
            throw new UnsupportedOperationException("Error: Update listeners must be added beforethe animation.");
        }
        if (!this.f28l.contains(rVar)) {
            this.f28l.add(rVar);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float e() {
        return this.f26j * 0.75f;
    }

    public boolean f() {
        return this.f22f;
    }

    public T h(float f10) {
        this.f23g = f10;
        return this;
    }

    public T i(float f10) {
        this.f24h = f10;
        return this;
    }

    public T j(float f10) {
        if (f10 <= 0.0f) {
            throw new IllegalArgumentException("Minimum visible change must be positive.");
        }
        this.f26j = f10;
        n(f10 * 0.75f);
        return this;
    }

    void k(float f10) {
        this.f21e.b(this.f20d, f10);
        for (int i10 = 0; i10 < this.f28l.size(); i10++) {
            if (this.f28l.get(i10) != null) {
                this.f28l.get(i10).a(this, this.f18b, this.f17a);
            }
        }
        g(this.f28l);
    }

    public T l(float f10) {
        this.f18b = f10;
        this.f19c = true;
        return this;
    }

    public T m(float f10) {
        this.f17a = f10;
        return this;
    }

    abstract void n(float f10);

    public void o() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        if (this.f22f) {
            return;
        }
        p();
    }

    abstract boolean q(long j10);
}
