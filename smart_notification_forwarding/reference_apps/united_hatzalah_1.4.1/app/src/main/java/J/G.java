package J;

import android.os.Build;
import android.view.View;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public abstract class G {

    /* renamed from: a, reason: collision with root package name */
    public int f943a;

    /* renamed from: b, reason: collision with root package name */
    public int f944b;

    /* renamed from: c, reason: collision with root package name */
    public int f945c;

    /* renamed from: d, reason: collision with root package name */
    public Object f946d;

    public G() {
        if (A.n.f25b == null) {
            A.n.f25b = new A.n(14);
        }
    }

    public int a(int i) {
        if (i < this.f945c) {
            return ((ByteBuffer) this.f946d).getShort(this.f944b + i);
        }
        return 0;
    }

    public abstract Object b(View view);

    public abstract void c(View view, Object obj);

    public void d(View view, Object obj) {
        Object tag;
        C0114b c0114b;
        if (Build.VERSION.SDK_INT >= this.f944b) {
            c(view, obj);
            return;
        }
        if (Build.VERSION.SDK_INT >= this.f944b) {
            tag = b(view);
        } else {
            tag = view.getTag(this.f943a);
            if (!((Class) this.f946d).isInstance(tag)) {
                tag = null;
            }
        }
        if (e(tag, obj)) {
            View.AccessibilityDelegate d2 = S.d(view);
            if (d2 == null) {
                c0114b = null;
            } else if (d2 instanceof C0113a) {
                c0114b = ((C0113a) d2).f971a;
            } else {
                c0114b = new C0114b(d2);
            }
            if (c0114b == null) {
                c0114b = new C0114b();
            }
            S.i(view, c0114b);
            view.setTag(this.f943a, obj);
            S.f(view, this.f945c);
        }
    }

    public abstract boolean e(Object obj, Object obj2);
}
