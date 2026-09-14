package k0;

import androidx.lifecycle.a0;
import androidx.lifecycle.b0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import x8.l;
import y8.k;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final List<f<?>> f11124a = new ArrayList();

    public final <T extends a0> void a(e9.b<T> bVar, l<? super a, ? extends T> lVar) {
        k.e(bVar, "clazz");
        k.e(lVar, "initializer");
        this.f11124a.add(new f<>(w8.a.b(bVar), lVar));
    }

    public final b0.b b() {
        Object[] array = this.f11124a.toArray(new f[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        f[] fVarArr = (f[]) array;
        return new b((f[]) Arrays.copyOf(fVarArr, fVarArr.length));
    }
}
