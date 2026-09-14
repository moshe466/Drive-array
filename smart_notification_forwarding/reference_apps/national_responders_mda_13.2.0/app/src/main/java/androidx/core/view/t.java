package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    private int f2625a;

    /* renamed from: b, reason: collision with root package name */
    private int f2626b;

    public t(ViewGroup viewGroup) {
    }

    public int a() {
        return this.f2625a | this.f2626b;
    }

    public void b(View view, View view2, int i10) {
        c(view, view2, i10, 0);
    }

    public void c(View view, View view2, int i10, int i11) {
        if (i11 == 1) {
            this.f2626b = i10;
        } else {
            this.f2625a = i10;
        }
    }

    public void d(View view) {
        e(view, 0);
    }

    public void e(View view, int i10) {
        if (i10 == 1) {
            this.f2626b = 0;
        } else {
            this.f2625a = 0;
        }
    }
}
