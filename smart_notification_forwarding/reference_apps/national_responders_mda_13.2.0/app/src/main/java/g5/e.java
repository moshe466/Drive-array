package g5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import w6.m;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static ArrayList<a> f9807a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    public static boolean f9808b = true;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f9809a;

        /* renamed from: b, reason: collision with root package name */
        public String f9810b;

        /* renamed from: c, reason: collision with root package name */
        public String f9811c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f9812d;

        public a(String str, String str2, String str3, boolean z10) {
            if (m.k() == null) {
                return;
            }
            m.k().getID();
            this.f9809a = str.toUpperCase();
            this.f9811c = str3;
            this.f9812d = z10;
            this.f9810b = str2;
            if (str2 == null || str2.length() <= 200) {
                return;
            }
            this.f9810b = str2.substring(0, 200) + "...(" + str2.length() + ")";
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public List<a> f9813a;

        public b(List<a> list) {
            this.f9813a = list;
        }
    }

    public static a a() {
        if (f9807a.size() == 0) {
            return null;
        }
        return f9807a.get(0);
    }

    public static ArrayList<a> b(String str) {
        if (str == null || str.length() == 0) {
            return f9807a;
        }
        String upperCase = str.toUpperCase();
        ArrayList<a> arrayList = new ArrayList<>();
        Iterator<a> it = f9807a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.f9809a.indexOf(upperCase) > -1) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static b c() {
        return new b(b(""));
    }

    public static String[] d() {
        ArrayList arrayList = new ArrayList();
        Iterator<a> it = f9807a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && !arrayList.contains(next.f9809a)) {
                arrayList.add(next.f9809a);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
