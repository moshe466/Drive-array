package yb;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;
import okhttp3.w;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends f {

    /* renamed from: c, reason: collision with root package name */
    private final Method f16020c;

    /* renamed from: d, reason: collision with root package name */
    private final Method f16021d;

    /* renamed from: e, reason: collision with root package name */
    private final Method f16022e;

    /* renamed from: f, reason: collision with root package name */
    private final Class<?> f16023f;

    /* renamed from: g, reason: collision with root package name */
    private final Class<?> f16024g;

    /* loaded from: classes.dex */
    private static class a implements InvocationHandler {

        /* renamed from: a, reason: collision with root package name */
        private final List<String> f16025a;

        /* renamed from: b, reason: collision with root package name */
        boolean f16026b;

        /* renamed from: c, reason: collision with root package name */
        String f16027c;

        a(List<String> list) {
            this.f16025a = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            Object obj2;
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = sb.c.f14197b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f16026b = true;
                return null;
            }
            if (name.equals("protocols") && objArr.length == 0) {
                return this.f16025a;
            }
            if ((!name.equals("selectProtocol") && !name.equals("select")) || String.class != returnType || objArr.length != 1 || !(objArr[0] instanceof List)) {
                if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                    return method.invoke(this, objArr);
                }
                this.f16027c = (String) objArr[0];
                return null;
            }
            List list = (List) objArr[0];
            int size = list.size();
            int i10 = 0;
            while (true) {
                if (i10 >= size) {
                    obj2 = this.f16025a.get(0);
                    break;
                }
                if (this.f16025a.contains(list.get(i10))) {
                    obj2 = list.get(i10);
                    break;
                }
                i10++;
            }
            String str = (String) obj2;
            this.f16027c = str;
            return str;
        }
    }

    d(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f16020c = method;
        this.f16021d = method2;
        this.f16022e = method3;
        this.f16023f = cls;
        this.f16024g = cls2;
    }

    public static f r() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
            return new d(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod("get", SSLSocket.class), cls.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // yb.f
    public void a(SSLSocket sSLSocket) {
        try {
            this.f16022e.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw sb.c.b("unable to remove alpn", e10);
        }
    }

    @Override // yb.f
    public void g(SSLSocket sSLSocket, String str, List<w> list) {
        try {
            this.f16020c.invoke(null, sSLSocket, Proxy.newProxyInstance(f.class.getClassLoader(), new Class[]{this.f16023f, this.f16024g}, new a(f.b(list))));
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw sb.c.b("unable to set alpn", e10);
        }
    }

    @Override // yb.f
    public String l(SSLSocket sSLSocket) {
        try {
            a aVar = (a) Proxy.getInvocationHandler(this.f16021d.invoke(null, sSLSocket));
            boolean z10 = aVar.f16026b;
            if (!z10 && aVar.f16027c == null) {
                f.j().p(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", null);
                return null;
            }
            if (z10) {
                return null;
            }
            return aVar.f16027c;
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw sb.c.b("unable to get selected protocol", e10);
        }
    }
}
