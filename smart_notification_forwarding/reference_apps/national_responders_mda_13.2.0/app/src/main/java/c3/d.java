package c3;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;

/* loaded from: classes.dex */
public interface d {

    /* loaded from: classes.dex */
    public static class b implements TypeEvaluator<e> {

        /* renamed from: b, reason: collision with root package name */
        public static final TypeEvaluator<e> f4376b = new b();

        /* renamed from: a, reason: collision with root package name */
        private final e f4377a = new e();

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e evaluate(float f10, e eVar, e eVar2) {
            this.f4377a.a(f3.a.c(eVar.f4380a, eVar2.f4380a, f10), f3.a.c(eVar.f4381b, eVar2.f4381b, f10), f3.a.c(eVar.f4382c, eVar2.f4382c, f10));
            return this.f4377a;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends Property<d, e> {

        /* renamed from: a, reason: collision with root package name */
        public static final Property<d, e> f4378a = new c("circularReveal");

        private c(String str) {
            super(e.class, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e get(d dVar) {
            return dVar.getRevealInfo();
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(d dVar, e eVar) {
            dVar.setRevealInfo(eVar);
        }
    }

    /* renamed from: c3.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0077d extends Property<d, Integer> {

        /* renamed from: a, reason: collision with root package name */
        public static final Property<d, Integer> f4379a = new C0077d("circularRevealScrimColor");

        private C0077d(String str) {
            super(Integer.class, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer get(d dVar) {
            return Integer.valueOf(dVar.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(d dVar, Integer num) {
            dVar.setCircularRevealScrimColor(num.intValue());
        }
    }

    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public float f4380a;

        /* renamed from: b, reason: collision with root package name */
        public float f4381b;

        /* renamed from: c, reason: collision with root package name */
        public float f4382c;

        private e() {
        }

        public e(float f10, float f11, float f12) {
            this.f4380a = f10;
            this.f4381b = f11;
            this.f4382c = f12;
        }

        public void a(float f10, float f11, float f12) {
            this.f4380a = f10;
            this.f4381b = f11;
            this.f4382c = f12;
        }
    }

    void a();

    void b();

    int getCircularRevealScrimColor();

    e getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i10);

    void setRevealInfo(e eVar);
}
