package c0;

import android.os.Build;
import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private final b f4360a;

    /* loaded from: classes.dex */
    private static class a extends b {

        /* renamed from: a, reason: collision with root package name */
        private final TextView f4361a;

        /* renamed from: b, reason: collision with root package name */
        private final d f4362b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f4363c = true;

        a(TextView textView) {
            this.f4361a = textView;
            this.f4362b = new d(textView);
        }

        private InputFilter[] d(InputFilter[] inputFilterArr) {
            int length = inputFilterArr.length;
            for (InputFilter inputFilter : inputFilterArr) {
                if (inputFilter == this.f4362b) {
                    return inputFilterArr;
                }
            }
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length + 1];
            System.arraycopy(inputFilterArr, 0, inputFilterArr2, 0, length);
            inputFilterArr2[length] = this.f4362b;
            return inputFilterArr2;
        }

        private SparseArray<InputFilter> e(InputFilter[] inputFilterArr) {
            SparseArray<InputFilter> sparseArray = new SparseArray<>(1);
            for (int i10 = 0; i10 < inputFilterArr.length; i10++) {
                if (inputFilterArr[i10] instanceof d) {
                    sparseArray.put(i10, inputFilterArr[i10]);
                }
            }
            return sparseArray;
        }

        private InputFilter[] f(InputFilter[] inputFilterArr) {
            SparseArray<InputFilter> e10 = e(inputFilterArr);
            if (e10.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - e10.size()];
            int i10 = 0;
            for (int i11 = 0; i11 < length; i11++) {
                if (e10.indexOfKey(i11) < 0) {
                    inputFilterArr2[i10] = inputFilterArr[i11];
                    i10++;
                }
            }
            return inputFilterArr2;
        }

        private TransformationMethod h(TransformationMethod transformationMethod) {
            return transformationMethod instanceof h ? ((h) transformationMethod).a() : transformationMethod;
        }

        private void i() {
            this.f4361a.setFilters(a(this.f4361a.getFilters()));
        }

        private TransformationMethod k(TransformationMethod transformationMethod) {
            return ((transformationMethod instanceof h) || (transformationMethod instanceof PasswordTransformationMethod)) ? transformationMethod : new h(transformationMethod);
        }

        @Override // c0.f.b
        InputFilter[] a(InputFilter[] inputFilterArr) {
            return !this.f4363c ? f(inputFilterArr) : d(inputFilterArr);
        }

        @Override // c0.f.b
        void b(boolean z10) {
            if (z10) {
                j();
            }
        }

        @Override // c0.f.b
        void c(boolean z10) {
            this.f4363c = z10;
            j();
            i();
        }

        void g(boolean z10) {
            this.f4363c = z10;
        }

        void j() {
            this.f4361a.setTransformationMethod(l(this.f4361a.getTransformationMethod()));
        }

        TransformationMethod l(TransformationMethod transformationMethod) {
            return this.f4363c ? k(transformationMethod) : h(transformationMethod);
        }
    }

    /* loaded from: classes.dex */
    static class b {
        b() {
        }

        InputFilter[] a(InputFilter[] inputFilterArr) {
            return inputFilterArr;
        }

        void b(boolean z10) {
        }

        void c(boolean z10) {
        }
    }

    /* loaded from: classes.dex */
    private static class c extends b {

        /* renamed from: a, reason: collision with root package name */
        private final a f4364a;

        c(TextView textView) {
            this.f4364a = new a(textView);
        }

        private boolean d() {
            return !androidx.emoji2.text.e.h();
        }

        @Override // c0.f.b
        InputFilter[] a(InputFilter[] inputFilterArr) {
            return d() ? inputFilterArr : this.f4364a.a(inputFilterArr);
        }

        @Override // c0.f.b
        void b(boolean z10) {
            if (d()) {
                return;
            }
            this.f4364a.b(z10);
        }

        @Override // c0.f.b
        void c(boolean z10) {
            if (d()) {
                this.f4364a.g(z10);
            } else {
                this.f4364a.c(z10);
            }
        }
    }

    public f(TextView textView, boolean z10) {
        androidx.core.util.h.g(textView, "textView cannot be null");
        if (Build.VERSION.SDK_INT < 19) {
            this.f4360a = new b();
        } else {
            this.f4360a = !z10 ? new c(textView) : new a(textView);
        }
    }

    public InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.f4360a.a(inputFilterArr);
    }

    public void b(boolean z10) {
        this.f4360a.b(z10);
    }

    public void c(boolean z10) {
        this.f4360a.c(z10);
    }
}
