package i9;

import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.List;
import m8.q;
import y8.k;

/* loaded from: classes.dex */
public final class j implements d {

    /* renamed from: a, reason: collision with root package name */
    public static final j f10789a = new j();

    private j() {
    }

    @Override // i9.d
    public Object a(Object[] objArr) {
        k.e(objArr, "args");
        throw new UnsupportedOperationException("call/callBy are not supported for this declaration.");
    }

    @Override // i9.d
    public List<Type> b() {
        List<Type> d10;
        d10 = q.d();
        return d10;
    }

    @Override // i9.d
    public /* bridge */ /* synthetic */ Member c() {
        return (Member) d();
    }

    public Void d() {
        return null;
    }

    @Override // i9.d
    public Type i() {
        Class cls = Void.TYPE;
        k.d(cls, "Void.TYPE");
        return cls;
    }
}
