package m;

import F0.G1;
import J.C0116d;
import J.C0118f;
import J.InterfaceC0115c;
import J.InterfaceC0133v;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import android.widget.TextView;
import com.uh.sf.R;

/* renamed from: m.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0571u extends EditText implements InterfaceC0133v {

    /* renamed from: a, reason: collision with root package name */
    public final C0558n f5787a;

    /* renamed from: b, reason: collision with root package name */
    public final Z f5788b;

    /* renamed from: c, reason: collision with root package name */
    public final C0522A f5789c;

    /* renamed from: d, reason: collision with root package name */
    public final M.j f5790d;

    /* renamed from: e, reason: collision with root package name */
    public final C0522A f5791e;

    /* renamed from: f, reason: collision with root package name */
    public C0569t f5792f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r5v5, types: [M.j, java.lang.Object] */
    public C0571u(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.editTextStyle);
        j1.a(context);
        i1.a(this, getContext());
        C0558n c0558n = new C0558n(this);
        this.f5787a = c0558n;
        c0558n.d(attributeSet, R.attr.editTextStyle);
        Z z3 = new Z(this);
        this.f5788b = z3;
        z3.f(attributeSet, R.attr.editTextStyle);
        z3.b();
        C0522A c0522a = new C0522A();
        c0522a.f5495b = this;
        this.f5789c = c0522a;
        this.f5790d = new Object();
        C0522A c0522a2 = new C0522A(this);
        this.f5791e = c0522a2;
        c0522a2.b(attributeSet, R.attr.editTextStyle);
        KeyListener keyListener = getKeyListener();
        if (!(keyListener instanceof NumberKeyListener)) {
            boolean isFocusable = isFocusable();
            boolean isClickable = isClickable();
            boolean isLongClickable = isLongClickable();
            int inputType = getInputType();
            KeyListener a2 = c0522a2.a(keyListener);
            if (a2 != keyListener) {
                super.setKeyListener(a2);
                setRawInputType(inputType);
                setFocusable(isFocusable);
                setClickable(isClickable);
                setLongClickable(isLongClickable);
            }
        }
    }

    private C0569t getSuperCaller() {
        if (this.f5792f == null) {
            this.f5792f = new C0569t(this);
        }
        return this.f5792f;
    }

    @Override // J.InterfaceC0133v
    public final C0118f a(C0118f c0118f) {
        this.f5790d.getClass();
        return M.j.a(this, c0118f);
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0558n c0558n = this.f5787a;
        if (c0558n != null) {
            c0558n.a();
        }
        Z z3 = this.f5788b;
        if (z3 != null) {
            z3.b();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return m3.b.S(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0558n c0558n = this.f5787a;
        if (c0558n != null) {
            return c0558n.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0558n c0558n = this.f5787a;
        if (c0558n != null) {
            return c0558n.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f5788b.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f5788b.e();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        C0522A c0522a;
        if (Build.VERSION.SDK_INT < 28 && (c0522a = this.f5789c) != null) {
            TextClassifier textClassifier = (TextClassifier) c0522a.f5496c;
            if (textClassifier == null) {
                return T.a((TextView) c0522a.f5495b);
            }
            return textClassifier;
        }
        return super.getTextClassifier();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0039, code lost:
    
        if (r1 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003b, code lost:
    
        r4 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0052, code lost:
    
        if (r1 != null) goto L16;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.inputmethod.InputConnection onCreateInputConnection(android.view.inputmethod.EditorInfo r6) {
        /*
            r5 = this;
            android.view.inputmethod.InputConnection r0 = super.onCreateInputConnection(r6)
            m.Z r1 = r5.f5788b
            r1.getClass()
            m.Z.h(r6, r0, r5)
            m3.b.E(r6, r0, r5)
            if (r0 == 0) goto L5f
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 30
            if (r1 > r2) goto L5f
            java.lang.String[] r2 = J.S.e(r5)
            if (r2 == 0) goto L5f
            L.d.a(r6, r2)
            J0.d r2 = new J0.d
            r3 = 1
            r2.<init>(r5, r3)
            r3 = 25
            if (r1 < r3) goto L31
            L.e r1 = new L.e
            r1.<init>(r0, r2)
        L2f:
            r0 = r1
            goto L5f
        L31:
            java.lang.String[] r4 = L.d.f1126a
            if (r1 < r3) goto L3d
            java.lang.String[] r1 = L.a.e(r6)
            if (r1 == 0) goto L55
        L3b:
            r4 = r1
            goto L55
        L3d:
            android.os.Bundle r1 = r6.extras
            if (r1 != 0) goto L42
            goto L55
        L42:
            java.lang.String r3 = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES"
            java.lang.String[] r1 = r1.getStringArray(r3)
            if (r1 != 0) goto L52
            android.os.Bundle r1 = r6.extras
            java.lang.String r3 = "android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES"
            java.lang.String[] r1 = r1.getStringArray(r3)
        L52:
            if (r1 == 0) goto L55
            goto L3b
        L55:
            int r1 = r4.length
            if (r1 != 0) goto L59
            goto L5f
        L59:
            L.f r1 = new L.f
            r1.<init>(r0, r2)
            goto L2f
        L5f:
            m.A r1 = r5.f5791e
            X.b r6 = r1.c(r0, r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: m.C0571u.onCreateInputConnection(android.view.inputmethod.EditorInfo):android.view.inputmethod.InputConnection");
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onDragEvent(DragEvent dragEvent) {
        Activity activity;
        boolean z3 = false;
        if (Build.VERSION.SDK_INT < 31 && dragEvent.getLocalState() == null && J.S.e(this) != null) {
            Context context = getContext();
            while (true) {
                if (context instanceof ContextWrapper) {
                    if (context instanceof Activity) {
                        activity = (Activity) context;
                        break;
                    }
                    context = ((ContextWrapper) context).getBaseContext();
                } else {
                    activity = null;
                    break;
                }
            }
            if (activity == null) {
                toString();
            } else if (dragEvent.getAction() != 1 && dragEvent.getAction() == 3) {
                z3 = AbstractC0525D.a(dragEvent, this, activity);
            }
        }
        if (z3) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public final boolean onTextContextMenuItem(int i) {
        ClipData primaryClip;
        InterfaceC0115c interfaceC0115c;
        int i3;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 31 && J.S.e(this) != null && (i == 16908322 || i == 16908337)) {
            ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
            if (clipboardManager == null) {
                primaryClip = null;
            } else {
                primaryClip = clipboardManager.getPrimaryClip();
            }
            if (primaryClip != null && primaryClip.getItemCount() > 0) {
                if (i4 >= 31) {
                    interfaceC0115c = new G1(primaryClip, 1);
                } else {
                    C0116d c0116d = new C0116d();
                    c0116d.f977b = primaryClip;
                    c0116d.f978c = 1;
                    interfaceC0115c = c0116d;
                }
                if (i == 16908322) {
                    i3 = 0;
                } else {
                    i3 = 1;
                }
                interfaceC0115c.c(i3);
                J.S.g(this, interfaceC0115c.build());
            }
            return true;
        }
        return super.onTextContextMenuItem(i);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0558n c0558n = this.f5787a;
        if (c0558n != null) {
            c0558n.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C0558n c0558n = this.f5787a;
        if (c0558n != null) {
            c0558n.f(i);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        Z z3 = this.f5788b;
        if (z3 != null) {
            z3.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        Z z3 = this.f5788b;
        if (z3 != null) {
            z3.b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(m3.b.U(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z3) {
        this.f5791e.d(z3);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f5791e.a(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0558n c0558n = this.f5787a;
        if (c0558n != null) {
            c0558n.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0558n c0558n = this.f5787a;
        if (c0558n != null) {
            c0558n.i(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        Z z3 = this.f5788b;
        z3.l(colorStateList);
        z3.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        Z z3 = this.f5788b;
        z3.m(mode);
        z3.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        Z z3 = this.f5788b;
        if (z3 != null) {
            z3.g(context, i);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        C0522A c0522a;
        if (Build.VERSION.SDK_INT < 28 && (c0522a = this.f5789c) != null) {
            c0522a.f5496c = textClassifier;
        } else {
            super.setTextClassifier(textClassifier);
        }
    }

    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        if (Build.VERSION.SDK_INT >= 28) {
            return super.getText();
        }
        return getEditableText();
    }
}
