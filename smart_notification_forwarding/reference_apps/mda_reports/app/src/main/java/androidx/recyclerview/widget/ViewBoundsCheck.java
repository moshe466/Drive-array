package androidx.recyclerview.widget;

import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
class ViewBoundsCheck {
    final Callback a;
    BoundFlags b = new BoundFlags();

    /* loaded from: classes.dex */
    static class BoundFlags {
        int a = 0;
        int b;
        int c;
        int d;
        int e;

        BoundFlags() {
        }

        int a(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }

        void a(int i) {
            this.a = i | this.a;
        }

        void a(int i, int i2, int i3, int i4) {
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }

        boolean a() {
            int i = this.a;
            if ((i & 7) != 0 && (i & (a(this.d, this.b) << 0)) == 0) {
                return false;
            }
            int i2 = this.a;
            if ((i2 & 112) != 0 && (i2 & (a(this.d, this.c) << 4)) == 0) {
                return false;
            }
            int i3 = this.a;
            if ((i3 & 1792) != 0 && (i3 & (a(this.e, this.b) << 8)) == 0) {
                return false;
            }
            int i4 = this.a;
            return (i4 & 28672) == 0 || (i4 & (a(this.e, this.c) << 12)) != 0;
        }

        void b() {
            this.a = 0;
        }
    }

    /* loaded from: classes.dex */
    interface Callback {
        View getChildAt(int i);

        int getChildEnd(View view);

        int getChildStart(View view);

        int getParentEnd();

        int getParentStart();
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface ViewBounds {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewBoundsCheck(Callback callback) {
        this.a = callback;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View a(int i, int i2, int i3, int i4) {
        int parentStart = this.a.getParentStart();
        int parentEnd = this.a.getParentEnd();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View childAt = this.a.getChildAt(i);
            this.b.a(parentStart, parentEnd, this.a.getChildStart(childAt), this.a.getChildEnd(childAt));
            if (i3 != 0) {
                this.b.b();
                this.b.a(i3);
                if (this.b.a()) {
                    return childAt;
                }
            }
            if (i4 != 0) {
                this.b.b();
                this.b.a(i4);
                if (this.b.a()) {
                    view = childAt;
                }
            }
            i += i5;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(View view, int i) {
        this.b.a(this.a.getParentStart(), this.a.getParentEnd(), this.a.getChildStart(view), this.a.getChildEnd(view));
        if (i == 0) {
            return false;
        }
        this.b.b();
        this.b.a(i);
        return this.b.a();
    }
}
