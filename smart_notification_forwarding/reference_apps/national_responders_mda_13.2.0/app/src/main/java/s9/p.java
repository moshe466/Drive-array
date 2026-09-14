package s9;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import s9.w;

/* loaded from: classes.dex */
public final class p extends r implements ca.n {

    /* renamed from: a, reason: collision with root package name */
    private final Field f14175a;

    public p(Field field) {
        y8.k.e(field, "member");
        this.f14175a = field;
    }

    @Override // ca.n
    public boolean C() {
        return c0().isEnumConstant();
    }

    @Override // ca.n
    public boolean R() {
        return false;
    }

    @Override // s9.r
    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public Field c0() {
        return this.f14175a;
    }

    @Override // ca.n
    /* renamed from: f0, reason: merged with bridge method [inline-methods] */
    public w b() {
        w.a aVar = w.f14182a;
        Type genericType = c0().getGenericType();
        y8.k.d(genericType, "member.genericType");
        return aVar.a(genericType);
    }
}
