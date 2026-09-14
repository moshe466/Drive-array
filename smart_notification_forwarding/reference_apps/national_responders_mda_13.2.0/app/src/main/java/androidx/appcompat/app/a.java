package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.b;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: androidx.appcompat.app.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0018a extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public int f603a;

        public C0018a(int i10, int i11) {
            super(i10, i11);
            this.f603a = 0;
            this.f603a = 8388627;
        }

        public C0018a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f603a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.j.f9087t);
            this.f603a = obtainStyledAttributes.getInt(e.j.f9092u, 0);
            obtainStyledAttributes.recycle();
        }

        public C0018a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f603a = 0;
        }

        public C0018a(C0018a c0018a) {
            super((ViewGroup.MarginLayoutParams) c0018a);
            this.f603a = 0;
            this.f603a = c0018a.f603a;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(boolean z10);
    }

    @Deprecated
    /* loaded from: classes.dex */
    public static abstract class c {
        public abstract CharSequence a();

        public abstract View b();

        public abstract Drawable c();

        public abstract CharSequence d();

        public abstract void e();
    }

    public abstract androidx.appcompat.view.b A(b.a aVar);

    public boolean g() {
        return false;
    }

    public abstract boolean h();

    public abstract void i(boolean z10);

    public abstract int j();

    public abstract Context k();

    public boolean l() {
        return false;
    }

    public abstract void m(Configuration configuration);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n() {
    }

    public abstract boolean o(int i10, KeyEvent keyEvent);

    public boolean p(KeyEvent keyEvent) {
        return false;
    }

    public boolean q() {
        return false;
    }

    public abstract void r(Drawable drawable);

    public abstract void s(int i10);

    public abstract void t(View view);

    public abstract void u(boolean z10);

    public abstract void v(boolean z10);

    public abstract void w(boolean z10);

    public abstract void x(boolean z10);

    public abstract void y(boolean z10);

    public abstract void z(CharSequence charSequence);
}
