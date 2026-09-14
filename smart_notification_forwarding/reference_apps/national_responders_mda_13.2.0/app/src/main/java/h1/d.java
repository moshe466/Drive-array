package h1;

import com.shockwave.pdfium.util.Size;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private b f10431a;

    /* renamed from: b, reason: collision with root package name */
    private final Size f10432b;

    /* renamed from: c, reason: collision with root package name */
    private final Size f10433c;

    /* renamed from: d, reason: collision with root package name */
    private final Size f10434d;

    /* renamed from: e, reason: collision with root package name */
    private a7.a f10435e;

    /* renamed from: f, reason: collision with root package name */
    private a7.a f10436f;

    /* renamed from: g, reason: collision with root package name */
    private float f10437g;

    /* renamed from: h, reason: collision with root package name */
    private float f10438h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f10439a;

        static {
            int[] iArr = new int[b.values().length];
            f10439a = iArr;
            try {
                iArr[b.HEIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10439a[b.BOTH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public d(b bVar, Size size, Size size2, Size size3) {
        this.f10431a = bVar;
        this.f10432b = size;
        this.f10433c = size2;
        this.f10434d = size3;
        b();
    }

    private void b() {
        int i10 = a.f10439a[this.f10431a.ordinal()];
        if (i10 == 1) {
            a7.a d10 = d(this.f10433c, this.f10434d.a());
            this.f10436f = d10;
            this.f10438h = d10.a() / this.f10433c.a();
            this.f10435e = d(this.f10432b, r0.a() * this.f10438h);
            return;
        }
        if (i10 != 2) {
            a7.a e10 = e(this.f10432b, this.f10434d.b());
            this.f10435e = e10;
            this.f10437g = e10.b() / this.f10432b.b();
            this.f10436f = e(this.f10433c, r0.b() * this.f10437g);
            return;
        }
        float b10 = c(this.f10432b, this.f10434d.b(), this.f10434d.a()).b() / this.f10432b.b();
        a7.a c10 = c(this.f10433c, r1.b() * b10, this.f10434d.a());
        this.f10436f = c10;
        this.f10438h = c10.a() / this.f10433c.a();
        a7.a c11 = c(this.f10432b, this.f10434d.b(), this.f10432b.a() * this.f10438h);
        this.f10435e = c11;
        this.f10437g = c11.b() / this.f10432b.b();
    }

    private a7.a c(Size size, float f10, float f11) {
        float b10 = size.b() / size.a();
        float floor = (float) Math.floor(f10 / b10);
        if (floor > f11) {
            f10 = (float) Math.floor(b10 * f11);
        } else {
            f11 = floor;
        }
        return new a7.a(f10, f11);
    }

    private a7.a d(Size size, float f10) {
        return new a7.a((float) Math.floor(f10 / (size.a() / size.b())), f10);
    }

    private a7.a e(Size size, float f10) {
        return new a7.a(f10, (float) Math.floor(f10 / (size.b() / size.a())));
    }

    public a7.a a(Size size) {
        if (size.b() <= 0 || size.a() <= 0) {
            return new a7.a(0.0f, 0.0f);
        }
        int i10 = a.f10439a[this.f10431a.ordinal()];
        return i10 != 1 ? i10 != 2 ? e(size, size.b() * this.f10437g) : c(size, size.b() * this.f10437g, size.a() * this.f10438h) : d(size, size.a() * this.f10438h);
    }

    public a7.a f() {
        return this.f10436f;
    }

    public a7.a g() {
        return this.f10435e;
    }
}
