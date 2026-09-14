package J;

import android.text.TextUtils;
import android.view.View;

/* loaded from: classes.dex */
public final class E extends G {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f941e;

    public E(int i, Class cls, int i3, int i4, int i5) {
        this.f941e = i5;
        this.f943a = i;
        this.f946d = cls;
        this.f945c = i3;
        this.f944b = i4;
    }

    @Override // J.G
    public final Object b(View view) {
        switch (this.f941e) {
            case 0:
                return Boolean.valueOf(M.c(view));
            case 1:
                return M.a(view);
            case 2:
                return O.b(view);
            default:
                return Boolean.valueOf(M.b(view));
        }
    }

    @Override // J.G
    public final void c(View view, Object obj) {
        switch (this.f941e) {
            case 0:
                M.f(view, ((Boolean) obj).booleanValue());
                return;
            case 1:
                M.e(view, (CharSequence) obj);
                return;
            case 2:
                O.c(view, (CharSequence) obj);
                return;
            default:
                M.d(view, ((Boolean) obj).booleanValue());
                return;
        }
    }

    @Override // J.G
    public final boolean e(Object obj, Object obj2) {
        boolean z3;
        boolean z4;
        boolean equals;
        boolean z5;
        boolean z6;
        switch (this.f941e) {
            case 0:
                Boolean bool = (Boolean) obj;
                Boolean bool2 = (Boolean) obj2;
                boolean z7 = false;
                if (bool != null && bool.booleanValue()) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (bool2 != null && bool2.booleanValue()) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (z3 == z4) {
                    z7 = true;
                }
                return !z7;
            case 1:
                equals = TextUtils.equals((CharSequence) obj, (CharSequence) obj2);
                break;
            case 2:
                equals = TextUtils.equals((CharSequence) obj, (CharSequence) obj2);
                break;
            default:
                Boolean bool3 = (Boolean) obj;
                Boolean bool4 = (Boolean) obj2;
                boolean z8 = false;
                if (bool3 != null && bool3.booleanValue()) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (bool4 != null && bool4.booleanValue()) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (z5 == z6) {
                    z8 = true;
                }
                return !z8;
        }
        return !equals;
    }
}
