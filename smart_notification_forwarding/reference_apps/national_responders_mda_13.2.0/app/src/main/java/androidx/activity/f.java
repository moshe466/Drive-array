package androidx.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.lifecycle.g0;
import androidx.lifecycle.h;
import androidx.lifecycle.l;
import androidx.lifecycle.m;
import y8.k;

/* loaded from: classes.dex */
public class f extends Dialog implements l, h {

    /* renamed from: f, reason: collision with root package name */
    private m f491f;

    /* renamed from: g, reason: collision with root package name */
    private final OnBackPressedDispatcher f492g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context, int i10) {
        super(context, i10);
        k.e(context, "context");
        this.f492g = new OnBackPressedDispatcher(new Runnable() { // from class: androidx.activity.e
            @Override // java.lang.Runnable
            public final void run() {
                f.g(f.this);
            }
        });
    }

    private final m c() {
        m mVar = this.f491f;
        if (mVar != null) {
            return mVar;
        }
        m mVar2 = new m(this);
        this.f491f = mVar2;
        return mVar2;
    }

    private final void d() {
        Window window = getWindow();
        k.b(window);
        g0.a(window.getDecorView(), this);
        Window window2 = getWindow();
        k.b(window2);
        View decorView = window2.getDecorView();
        k.d(decorView, "window!!.decorView");
        j.a(decorView, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(f fVar) {
        k.e(fVar, "this$0");
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        k.e(view, "view");
        d();
        super.addContentView(view, layoutParams);
    }

    @Override // androidx.lifecycle.l
    public final androidx.lifecycle.h b() {
        return c();
    }

    @Override // androidx.activity.h
    public final OnBackPressedDispatcher e() {
        return this.f492g;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        this.f492g.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c().h(h.b.ON_CREATE);
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        c().h(h.b.ON_RESUME);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onStop() {
        c().h(h.b.ON_DESTROY);
        this.f491f = null;
        super.onStop();
    }

    @Override // android.app.Dialog
    public void setContentView(int i10) {
        d();
        super.setContentView(i10);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        k.e(view, "view");
        d();
        super.setContentView(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        k.e(view, "view");
        d();
        super.setContentView(view, layoutParams);
    }
}
