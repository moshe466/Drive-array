package w6;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    static String f15181a = "yyyy-MM-dd HH:mm:ss";

    /* renamed from: b, reason: collision with root package name */
    static String f15182b = "yyyy-MM-ddTHH:mm:ss";

    /* loaded from: classes.dex */
    public static class a implements com.google.gson.s<Date> {
        @Override // com.google.gson.s
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.gson.k a(Date date, Type type, com.google.gson.r rVar) {
            return new com.google.gson.q(new SimpleDateFormat(j.f15181a).format(date));
        }
    }

    /* loaded from: classes.dex */
    public static class b implements com.google.gson.j<Date> {
        @Override // com.google.gson.j
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Date a(com.google.gson.k kVar, Type type, com.google.gson.i iVar) {
            String s10 = kVar.s();
            Date B = l0.B(s10, j.f15181a);
            return B == null ? l0.B(s10, j.f15182b) : B;
        }
    }

    public static <T> T a(String str, Class<T> cls) {
        if (str != null && str.length() != 0) {
            try {
                return (T) new com.google.gson.f().c(Date.class, new b()).b().i(str, cls);
            } catch (Exception unused) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("failed to parse to :");
                sb2.append(cls.getClass().getName());
                sb2.append("/n");
                sb2.append(str);
                sb2.append("/n");
            }
        }
        return null;
    }

    public static String b(Object obj) {
        if (obj == null) {
            return "";
        }
        try {
            return new com.google.gson.f().c(Date.class, new a()).b().r(obj);
        } catch (Exception unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("failed to parse to json string");
            sb2.append(obj);
            return "";
        }
    }
}
