package X;

import V.k;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;

/* loaded from: classes.dex */
public final class j implements TransformationMethod {

    /* renamed from: a, reason: collision with root package name */
    public final TransformationMethod f2574a;

    public j(TransformationMethod transformationMethod) {
        this.f2574a = transformationMethod;
    }

    @Override // android.text.method.TransformationMethod
    public final CharSequence getTransformation(CharSequence charSequence, View view) {
        if (view.isInEditMode()) {
            return charSequence;
        }
        TransformationMethod transformationMethod = this.f2574a;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, view);
        }
        if (charSequence != null && k.a().b() == 1) {
            k a2 = k.a();
            a2.getClass();
            return a2.e(charSequence, 0, charSequence.length());
        }
        return charSequence;
    }

    @Override // android.text.method.TransformationMethod
    public final void onFocusChanged(View view, CharSequence charSequence, boolean z3, int i, Rect rect) {
        TransformationMethod transformationMethod = this.f2574a;
        if (transformationMethod != null) {
            transformationMethod.onFocusChanged(view, charSequence, z3, i, rect);
        }
    }
}
