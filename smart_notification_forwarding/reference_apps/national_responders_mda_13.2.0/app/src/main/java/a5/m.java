package a5;

import a5.k;
import com.google.gson.x;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m<T> extends x<T> {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.gson.e f257a;

    /* renamed from: b, reason: collision with root package name */
    private final x<T> f258b;

    /* renamed from: c, reason: collision with root package name */
    private final Type f259c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(com.google.gson.e eVar, x<T> xVar, Type type) {
        this.f257a = eVar;
        this.f258b = xVar;
        this.f259c = type;
    }

    private Type e(Type type, Object obj) {
        return obj != null ? (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) ? obj.getClass() : type : type;
    }

    @Override // com.google.gson.x
    public T b(f5.a aVar) {
        return this.f258b.b(aVar);
    }

    @Override // com.google.gson.x
    public void d(f5.c cVar, T t10) {
        x<T> xVar = this.f258b;
        Type e10 = e(this.f259c, t10);
        if (e10 != this.f259c) {
            xVar = this.f257a.k(e5.a.b(e10));
            if (xVar instanceof k.b) {
                x<T> xVar2 = this.f258b;
                if (!(xVar2 instanceof k.b)) {
                    xVar = xVar2;
                }
            }
        }
        xVar.d(cVar, t10);
    }
}
