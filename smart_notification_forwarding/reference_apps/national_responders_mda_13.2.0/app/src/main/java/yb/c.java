package yb;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import okhttp3.w;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c extends f {

    /* renamed from: c, reason: collision with root package name */
    final Method f16018c;

    /* renamed from: d, reason: collision with root package name */
    final Method f16019d;

    c(Method method, Method method2) {
        this.f16018c = method;
        this.f16019d = method2;
    }

    public static c r() {
        try {
            return new c(SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // yb.f
    public void g(SSLSocket sSLSocket, String str, List<w> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> b10 = f.b(list);
            this.f16018c.invoke(sSLParameters, b10.toArray(new String[b10.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw sb.c.b("unable to set ssl parameters", e10);
        }
    }

    @Override // yb.f
    public String l(SSLSocket sSLSocket) {
        try {
            String str = (String) this.f16019d.invoke(sSLSocket, new Object[0]);
            if (str == null) {
                return null;
            }
            if (str.equals("")) {
                return null;
            }
            return str;
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw sb.c.b("unable to get selected protocols", e10);
        }
    }
}
