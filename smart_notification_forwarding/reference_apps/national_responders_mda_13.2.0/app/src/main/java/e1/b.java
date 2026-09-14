package e1;

import android.graphics.Bitmap;
import android.graphics.RectF;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private int f9134a;

    /* renamed from: b, reason: collision with root package name */
    private Bitmap f9135b;

    /* renamed from: c, reason: collision with root package name */
    private RectF f9136c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f9137d;

    /* renamed from: e, reason: collision with root package name */
    private int f9138e;

    public b(int i10, Bitmap bitmap, RectF rectF, boolean z10, int i11) {
        this.f9134a = i10;
        this.f9135b = bitmap;
        this.f9136c = rectF;
        this.f9137d = z10;
        this.f9138e = i11;
    }

    public int a() {
        return this.f9138e;
    }

    public int b() {
        return this.f9134a;
    }

    public RectF c() {
        return this.f9136c;
    }

    public Bitmap d() {
        return this.f9135b;
    }

    public boolean e() {
        return this.f9137d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return bVar.b() == this.f9134a && bVar.c().left == this.f9136c.left && bVar.c().right == this.f9136c.right && bVar.c().top == this.f9136c.top && bVar.c().bottom == this.f9136c.bottom;
    }

    public void f(int i10) {
        this.f9138e = i10;
    }
}
