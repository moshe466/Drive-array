package k0;

import androidx.lifecycle.a0;
import androidx.lifecycle.b0;
import androidx.lifecycle.c0;
import androidx.lifecycle.viewmodel.ViewModelInitializer;
import y8.k;

/* loaded from: classes.dex */
public final class b implements b0.b {

    /* renamed from: a, reason: collision with root package name */
    private final ViewModelInitializer<?>[] f11123a;

    public b(ViewModelInitializer<?>... viewModelInitializerArr) {
        k.e(viewModelInitializerArr, "initializers");
        this.f11123a = viewModelInitializerArr;
    }

    @Override // androidx.lifecycle.b0.b
    public <T extends a0> T a(Class<T> cls, a aVar) {
        k.e(cls, "modelClass");
        k.e(aVar, "extras");
        T t10 = null;
        for (f fVar : this.f11123a) {
            if (k.a(fVar.a(), cls)) {
                T h10 = fVar.b().h(aVar);
                t10 = h10 instanceof a0 ? h10 : null;
            }
        }
        if (t10 != null) {
            return t10;
        }
        throw new IllegalArgumentException("No initializer set for given class " + cls.getName());
    }

    @Override // androidx.lifecycle.b0.b
    public /* synthetic */ a0 b(Class cls) {
        return c0.a(this, cls);
    }
}
