package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class e {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        static int a(TypedArray typedArray, int i10) {
            return typedArray.getType(i10);
        }
    }

    /* loaded from: classes.dex */
    public interface b {
    }

    /* loaded from: classes.dex */
    public static final class c implements b {

        /* renamed from: a, reason: collision with root package name */
        private final d[] f2324a;

        public c(d[] dVarArr) {
            this.f2324a = dVarArr;
        }

        public d[] a() {
            return this.f2324a;
        }
    }

    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        private final String f2325a;

        /* renamed from: b, reason: collision with root package name */
        private final int f2326b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f2327c;

        /* renamed from: d, reason: collision with root package name */
        private final String f2328d;

        /* renamed from: e, reason: collision with root package name */
        private final int f2329e;

        /* renamed from: f, reason: collision with root package name */
        private final int f2330f;

        public d(String str, int i10, boolean z10, String str2, int i11, int i12) {
            this.f2325a = str;
            this.f2326b = i10;
            this.f2327c = z10;
            this.f2328d = str2;
            this.f2329e = i11;
            this.f2330f = i12;
        }

        public String a() {
            return this.f2325a;
        }

        public int b() {
            return this.f2330f;
        }

        public int c() {
            return this.f2329e;
        }

        public String d() {
            return this.f2328d;
        }

        public int e() {
            return this.f2326b;
        }

        public boolean f() {
            return this.f2327c;
        }
    }

    /* renamed from: androidx.core.content.res.e$e, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0031e implements b {

        /* renamed from: a, reason: collision with root package name */
        private final androidx.core.provider.e f2331a;

        /* renamed from: b, reason: collision with root package name */
        private final int f2332b;

        /* renamed from: c, reason: collision with root package name */
        private final int f2333c;

        /* renamed from: d, reason: collision with root package name */
        private final String f2334d;

        public C0031e(androidx.core.provider.e eVar, int i10, int i11, String str) {
            this.f2331a = eVar;
            this.f2333c = i10;
            this.f2332b = i11;
            this.f2334d = str;
        }

        public int a() {
            return this.f2333c;
        }

        public androidx.core.provider.e b() {
            return this.f2331a;
        }

        public String c() {
            return this.f2334d;
        }

        public int d() {
            return this.f2332b;
        }
    }

    private static int a(TypedArray typedArray, int i10) {
        if (Build.VERSION.SDK_INT >= 21) {
            return a.a(typedArray, i10);
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i10, typedValue);
        return typedValue.type;
    }

    public static b b(XmlPullParser xmlPullParser, Resources resources) {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return d(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List<List<byte[]>> c(Resources resources, int i10) {
        if (i10 == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i10);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a(obtainTypedArray, 0) == 1) {
                for (int i11 = 0; i11 < obtainTypedArray.length(); i11++) {
                    int resourceId = obtainTypedArray.getResourceId(i11, 0);
                    if (resourceId != 0) {
                        arrayList.add(h(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(h(resources.getStringArray(i10)));
            }
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    private static b d(XmlPullParser xmlPullParser, Resources resources) {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return e(xmlPullParser, resources);
        }
        g(xmlPullParser);
        return null;
    }

    private static b e(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), t.d.f14240g);
        String string = obtainAttributes.getString(t.d.f14241h);
        String string2 = obtainAttributes.getString(t.d.f14245l);
        String string3 = obtainAttributes.getString(t.d.f14246m);
        int resourceId = obtainAttributes.getResourceId(t.d.f14242i, 0);
        int integer = obtainAttributes.getInteger(t.d.f14243j, 1);
        int integer2 = obtainAttributes.getInteger(t.d.f14244k, 500);
        String string4 = obtainAttributes.getString(t.d.f14247n);
        obtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                g(xmlPullParser);
            }
            return new C0031e(new androidx.core.provider.e(string, string2, string3, c(resources, resourceId)), integer, integer2, string4);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(f(xmlPullParser, resources));
                } else {
                    g(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new c((d[]) arrayList.toArray(new d[0]));
    }

    private static d f(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), t.d.f14248o);
        int i10 = t.d.f14257x;
        if (!obtainAttributes.hasValue(i10)) {
            i10 = t.d.f14250q;
        }
        int i11 = obtainAttributes.getInt(i10, 400);
        int i12 = t.d.f14255v;
        if (!obtainAttributes.hasValue(i12)) {
            i12 = t.d.f14251r;
        }
        boolean z10 = 1 == obtainAttributes.getInt(i12, 0);
        int i13 = t.d.f14258y;
        if (!obtainAttributes.hasValue(i13)) {
            i13 = t.d.f14252s;
        }
        int i14 = t.d.f14256w;
        if (!obtainAttributes.hasValue(i14)) {
            i14 = t.d.f14253t;
        }
        String string = obtainAttributes.getString(i14);
        int i15 = obtainAttributes.getInt(i13, 0);
        int i16 = t.d.f14254u;
        if (!obtainAttributes.hasValue(i16)) {
            i16 = t.d.f14249p;
        }
        int resourceId = obtainAttributes.getResourceId(i16, 0);
        String string2 = obtainAttributes.getString(i16);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new d(string2, i11, z10, string, i15, resourceId);
    }

    private static void g(XmlPullParser xmlPullParser) {
        int i10 = 1;
        while (i10 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i10++;
            } else if (next == 3) {
                i10--;
            }
        }
    }

    private static List<byte[]> h(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }
}
