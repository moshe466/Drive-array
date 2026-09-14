package kotlinx.coroutines.internal;

import java.util.Objects;

/* loaded from: classes.dex */
public class a<T> {

    /* renamed from: a, reason: collision with root package name */
    private Object[] f11597a = new Object[16];

    /* renamed from: b, reason: collision with root package name */
    private int f11598b;

    /* renamed from: c, reason: collision with root package name */
    private int f11599c;

    private final void b() {
        Object[] objArr = this.f11597a;
        int length = objArr.length;
        Object[] objArr2 = new Object[length << 1];
        m8.g.e(objArr, objArr2, 0, this.f11598b, 0, 10, null);
        Object[] objArr3 = this.f11597a;
        int length2 = objArr3.length;
        int i10 = this.f11598b;
        m8.g.e(objArr3, objArr2, length2 - i10, 0, i10, 4, null);
        this.f11597a = objArr2;
        this.f11598b = 0;
        this.f11599c = length;
    }

    public final void a(T t10) {
        Object[] objArr = this.f11597a;
        int i10 = this.f11599c;
        objArr[i10] = t10;
        int length = (objArr.length - 1) & (i10 + 1);
        this.f11599c = length;
        if (length == this.f11598b) {
            b();
        }
    }

    public final boolean c() {
        return this.f11598b == this.f11599c;
    }

    public final T d() {
        int i10 = this.f11598b;
        if (i10 == this.f11599c) {
            return null;
        }
        Object[] objArr = this.f11597a;
        T t10 = (T) objArr[i10];
        objArr[i10] = null;
        this.f11598b = (i10 + 1) & (objArr.length - 1);
        Objects.requireNonNull(t10, "null cannot be cast to non-null type T of kotlinx.coroutines.internal.ArrayQueue");
        return t10;
    }
}
