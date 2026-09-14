package n3;

import java.io.Serializable;

/* loaded from: classes.dex */
public interface b {
    void A(String str, Object obj, Serializable serializable);

    boolean a();

    boolean b();

    void c(Object obj, Object obj2);

    void e(String str, Throwable th);

    void f(Object obj, String str);

    boolean g();

    String getName();

    void h(String str, Object... objArr);

    boolean i();

    void j(String str);

    boolean k();

    void l(String str, Integer num);

    void m(String str, Object obj, Serializable serializable);

    void n(String str, Object... objArr);

    void o(Object... objArr);

    void p(String str, Throwable th);

    void q(Object obj, String str);

    void r(Object obj, String str, Object obj2);

    void s(String str, Throwable th);

    void t(String str);

    void u(String str);

    void v(String str);

    default boolean w(int i) {
        char c4;
        String str;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i == 5) {
                            c4 = 0;
                        } else {
                            throw null;
                        }
                    } else {
                        c4 = '\n';
                    }
                } else {
                    c4 = 20;
                }
            } else {
                c4 = 30;
            }
        } else {
            c4 = '(';
        }
        if (c4 != 0) {
            if (c4 != '\n') {
                if (c4 != 20) {
                    if (c4 != 30) {
                        if (c4 == '(') {
                            return g();
                        }
                        StringBuilder sb = new StringBuilder("Level [");
                        if (i != 1) {
                            if (i != 2) {
                                if (i != 3) {
                                    if (i != 4) {
                                        if (i != 5) {
                                            str = "null";
                                        } else {
                                            str = "TRACE";
                                        }
                                    } else {
                                        str = "DEBUG";
                                    }
                                } else {
                                    str = "INFO";
                                }
                            } else {
                                str = "WARN";
                            }
                        } else {
                            str = "ERROR";
                        }
                        sb.append(str);
                        sb.append("] not recognized.");
                        throw new IllegalArgumentException(sb.toString());
                    }
                    return a();
                }
                return i();
            }
            return b();
        }
        return k();
    }

    void x(Object obj, String str);

    void y(Object obj, String str, Object obj2);

    void z(String str, Integer num);
}
