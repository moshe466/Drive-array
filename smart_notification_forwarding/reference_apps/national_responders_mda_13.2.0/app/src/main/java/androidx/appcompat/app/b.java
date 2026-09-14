package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AlertController;

/* loaded from: classes.dex */
public class b extends h {

    /* renamed from: j, reason: collision with root package name */
    final AlertController f604j;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final AlertController.f f605a;

        /* renamed from: b, reason: collision with root package name */
        private final int f606b;

        public a(Context context) {
            this(context, b.m(context, 0));
        }

        public a(Context context, int i10) {
            this.f605a = new AlertController.f(new ContextThemeWrapper(context, b.m(context, i10)));
            this.f606b = i10;
        }

        public b a() {
            b bVar = new b(this.f605a.f564a, this.f606b);
            this.f605a.a(bVar.f604j);
            bVar.setCancelable(this.f605a.f581r);
            if (this.f605a.f581r) {
                bVar.setCanceledOnTouchOutside(true);
            }
            bVar.setOnCancelListener(this.f605a.f582s);
            bVar.setOnDismissListener(this.f605a.f583t);
            DialogInterface.OnKeyListener onKeyListener = this.f605a.f584u;
            if (onKeyListener != null) {
                bVar.setOnKeyListener(onKeyListener);
            }
            return bVar;
        }

        public Context b() {
            return this.f605a.f564a;
        }

        public a c(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f605a;
            fVar.f586w = listAdapter;
            fVar.f587x = onClickListener;
            return this;
        }

        public a d(boolean z10) {
            this.f605a.f581r = z10;
            return this;
        }

        public a e(View view) {
            this.f605a.f570g = view;
            return this;
        }

        public a f(Drawable drawable) {
            this.f605a.f567d = drawable;
            return this;
        }

        public a g(CharSequence charSequence) {
            this.f605a.f571h = charSequence;
            return this;
        }

        public a h(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f605a;
            fVar.f575l = charSequence;
            fVar.f577n = onClickListener;
            return this;
        }

        public a i(DialogInterface.OnKeyListener onKeyListener) {
            this.f605a.f584u = onKeyListener;
            return this;
        }

        public a j(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f605a;
            fVar.f572i = charSequence;
            fVar.f574k = onClickListener;
            return this;
        }

        public a k(ListAdapter listAdapter, int i10, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f605a;
            fVar.f586w = listAdapter;
            fVar.f587x = onClickListener;
            fVar.I = i10;
            fVar.H = true;
            return this;
        }

        public a l(CharSequence charSequence) {
            this.f605a.f569f = charSequence;
            return this;
        }

        public b m() {
            b a10 = a();
            a10.show();
            return a10;
        }
    }

    protected b(Context context, int i10) {
        super(context, m(context, i10));
        this.f604j = new AlertController(getContext(), this, getWindow());
    }

    static int m(Context context, int i10) {
        if (((i10 >>> 24) & 255) >= 1) {
            return i10;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(e.a.f8868o, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView l() {
        return this.f604j.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.h, androidx.activity.f, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f604j.e();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (this.f604j.g(i10, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        if (this.f604j.h(i10, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i10, keyEvent);
    }

    @Override // androidx.appcompat.app.h, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f604j.q(charSequence);
    }
}
