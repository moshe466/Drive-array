package X;

import V.k;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.widget.TextView;

/* loaded from: classes.dex */
public final class g extends m3.b {

    /* renamed from: d, reason: collision with root package name */
    public final f f2568d;

    public g(TextView textView) {
        this.f2568d = new f(textView);
    }

    @Override // m3.b
    public final boolean B() {
        return this.f2568d.f2567f;
    }

    @Override // m3.b
    public final void I(boolean z3) {
        boolean z4;
        if (k.f2396j != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (!z4) {
            return;
        }
        this.f2568d.I(z3);
    }

    @Override // m3.b
    public final void J(boolean z3) {
        boolean z4;
        f fVar = this.f2568d;
        if (k.f2396j != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (!z4) {
            fVar.f2567f = z3;
        } else {
            fVar.J(z3);
        }
    }

    @Override // m3.b
    public final TransformationMethod V(TransformationMethod transformationMethod) {
        boolean z3;
        if (k.f2396j != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            return transformationMethod;
        }
        return this.f2568d.V(transformationMethod);
    }

    @Override // m3.b
    public final InputFilter[] p(InputFilter[] inputFilterArr) {
        boolean z3;
        if (k.f2396j != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            return inputFilterArr;
        }
        return this.f2568d.p(inputFilterArr);
    }
}
