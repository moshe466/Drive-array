package X;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;

/* loaded from: classes.dex */
public final class f extends m3.b {

    /* renamed from: d, reason: collision with root package name */
    public final TextView f2565d;

    /* renamed from: e, reason: collision with root package name */
    public final d f2566e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f2567f = true;

    public f(TextView textView) {
        this.f2565d = textView;
        this.f2566e = new d(textView);
    }

    @Override // m3.b
    public final boolean B() {
        return this.f2567f;
    }

    @Override // m3.b
    public final void I(boolean z3) {
        if (z3) {
            TextView textView = this.f2565d;
            textView.setTransformationMethod(V(textView.getTransformationMethod()));
        }
    }

    @Override // m3.b
    public final void J(boolean z3) {
        this.f2567f = z3;
        TextView textView = this.f2565d;
        textView.setTransformationMethod(V(textView.getTransformationMethod()));
        textView.setFilters(p(textView.getFilters()));
    }

    @Override // m3.b
    public final TransformationMethod V(TransformationMethod transformationMethod) {
        if (this.f2567f) {
            if (transformationMethod instanceof j) {
                return transformationMethod;
            }
            if (transformationMethod instanceof PasswordTransformationMethod) {
                return transformationMethod;
            }
            return new j(transformationMethod);
        }
        if (transformationMethod instanceof j) {
            return ((j) transformationMethod).f2574a;
        }
        return transformationMethod;
    }

    @Override // m3.b
    public final InputFilter[] p(InputFilter[] inputFilterArr) {
        if (!this.f2567f) {
            SparseArray sparseArray = new SparseArray(1);
            for (int i = 0; i < inputFilterArr.length; i++) {
                InputFilter inputFilter = inputFilterArr[i];
                if (inputFilter instanceof d) {
                    sparseArray.put(i, inputFilter);
                }
            }
            if (sparseArray.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - sparseArray.size()];
            int i3 = 0;
            for (int i4 = 0; i4 < length; i4++) {
                if (sparseArray.indexOfKey(i4) < 0) {
                    inputFilterArr2[i3] = inputFilterArr[i4];
                    i3++;
                }
            }
            return inputFilterArr2;
        }
        int length2 = inputFilterArr.length;
        int i5 = 0;
        while (true) {
            d dVar = this.f2566e;
            if (i5 < length2) {
                if (inputFilterArr[i5] == dVar) {
                    return inputFilterArr;
                }
                i5++;
            } else {
                InputFilter[] inputFilterArr3 = new InputFilter[inputFilterArr.length + 1];
                System.arraycopy(inputFilterArr, 0, inputFilterArr3, 0, length2);
                inputFilterArr3[length2] = dVar;
                return inputFilterArr3;
            }
        }
    }
}
