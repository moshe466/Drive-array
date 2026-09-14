package X;

import A.n;
import F0.C0018c1;
import android.text.Editable;
import android.text.method.KeyListener;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.View;

/* loaded from: classes.dex */
public final class e implements KeyListener {

    /* renamed from: a, reason: collision with root package name */
    public final KeyListener f2563a;

    /* renamed from: b, reason: collision with root package name */
    public final n f2564b;

    public e(KeyListener keyListener) {
        n nVar = new n(16);
        this.f2563a = keyListener;
        this.f2564b = nVar;
    }

    @Override // android.text.method.KeyListener
    public final void clearMetaKeyState(View view, Editable editable, int i) {
        this.f2563a.clearMetaKeyState(view, editable, i);
    }

    @Override // android.text.method.KeyListener
    public final int getInputType() {
        return this.f2563a.getInputType();
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyDown(View view, Editable editable, int i, KeyEvent keyEvent) {
        boolean d2;
        boolean z3;
        this.f2564b.getClass();
        if (i != 67) {
            if (i != 112) {
                d2 = false;
            } else {
                d2 = C0018c1.d(editable, keyEvent, true);
            }
        } else {
            d2 = C0018c1.d(editable, keyEvent, false);
        }
        if (d2) {
            MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3 || this.f2563a.onKeyDown(view, editable, i, keyEvent)) {
            return true;
        }
        return false;
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.f2563a.onKeyOther(view, editable, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyUp(View view, Editable editable, int i, KeyEvent keyEvent) {
        return this.f2563a.onKeyUp(view, editable, i, keyEvent);
    }
}
