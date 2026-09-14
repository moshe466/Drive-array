package androidx.appcompat.app;

import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.b;
import androidx.core.view.f;

/* loaded from: classes.dex */
public class h extends androidx.activity.f implements d {

    /* renamed from: h, reason: collision with root package name */
    private e f690h;

    /* renamed from: i, reason: collision with root package name */
    private final f.a f691i;

    public h(Context context, int i10) {
        super(context, i(context, i10));
        this.f691i = new f.a() { // from class: androidx.appcompat.app.g
            @Override // androidx.core.view.f.a
            public final boolean i(KeyEvent keyEvent) {
                return h.this.j(keyEvent);
            }
        };
        e h10 = h();
        h10.D(i(context, i10));
        h10.q(null);
    }

    private static int i(Context context, int i10) {
        if (i10 != 0) {
            return i10;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(e.a.f8879z, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // androidx.appcompat.app.d
    public androidx.appcompat.view.b H(b.a aVar) {
        return null;
    }

    @Override // androidx.activity.f, android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        h().d(view, layoutParams);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        h().r();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return androidx.core.view.f.e(this.f691i, getWindow().getDecorView(), this, keyEvent);
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i10) {
        return (T) h().i(i10);
    }

    public e h() {
        if (this.f690h == null) {
            this.f690h = e.h(this, this);
        }
        return this.f690h;
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        h().o();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean j(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean k(int i10) {
        return h().z(i10);
    }

    @Override // androidx.appcompat.app.d
    public void n(androidx.appcompat.view.b bVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.f, android.app.Dialog
    public void onCreate(Bundle bundle) {
        h().n();
        super.onCreate(bundle);
        h().q(bundle);
    }

    @Override // androidx.activity.f, android.app.Dialog
    protected void onStop() {
        super.onStop();
        h().w();
    }

    @Override // androidx.appcompat.app.d
    public void p(androidx.appcompat.view.b bVar) {
    }

    @Override // androidx.activity.f, android.app.Dialog
    public void setContentView(int i10) {
        h().A(i10);
    }

    @Override // androidx.activity.f, android.app.Dialog
    public void setContentView(View view) {
        h().B(view);
    }

    @Override // androidx.activity.f, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        h().C(view, layoutParams);
    }

    @Override // android.app.Dialog
    public void setTitle(int i10) {
        super.setTitle(i10);
        h().E(getContext().getString(i10));
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        h().E(charSequence);
    }
}
