package h9;

import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class i0 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a extends y8.l implements x8.l<Class<?>, CharSequence> {

        /* renamed from: f, reason: collision with root package name */
        public static final a f10584f = new a();

        a() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence h(Class<?> cls) {
            y8.k.d(cls, "it");
            return s9.b.c(cls);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String b(Method method) {
        String y10;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(method.getName());
        Class<?>[] parameterTypes = method.getParameterTypes();
        y8.k.d(parameterTypes, "parameterTypes");
        y10 = m8.k.y(parameterTypes, "", "(", ")", 0, null, a.f10584f, 24, null);
        sb2.append(y10);
        Class<?> returnType = method.getReturnType();
        y8.k.d(returnType, "returnType");
        sb2.append(s9.b.c(returnType));
        return sb2.toString();
    }
}
