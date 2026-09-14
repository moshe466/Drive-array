package androidx.lifecycle;

import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import m8.l0;
import p0.c;

/* loaded from: classes.dex */
public final class w {

    /* renamed from: f, reason: collision with root package name */
    public static final a f3231f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    private static final Class<? extends Object>[] f3232g;

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, Object> f3233a = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, c.InterfaceC0267c> f3234b = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, Object> f3235c = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name */
    private final Map<String, pb.a<Object>> f3236d = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    private final c.InterfaceC0267c f3237e = new c.InterfaceC0267c() { // from class: androidx.lifecycle.v
        @Override // p0.c.InterfaceC0267c
        public final Bundle a() {
            Bundle d10;
            d10 = w.d(w.this);
            return d10;
        }
    };

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }

        public final boolean a(Object obj) {
            if (obj == null) {
                return true;
            }
            for (Class cls : w.f3232g) {
                y8.k.b(cls);
                if (cls.isInstance(obj)) {
                    return true;
                }
            }
            return false;
        }
    }

    static {
        Class<? extends Object>[] clsArr = new Class[29];
        clsArr[0] = Boolean.TYPE;
        clsArr[1] = boolean[].class;
        clsArr[2] = Double.TYPE;
        clsArr[3] = double[].class;
        Class<SizeF> cls = Integer.TYPE;
        clsArr[4] = cls;
        clsArr[5] = int[].class;
        clsArr[6] = Long.TYPE;
        clsArr[7] = long[].class;
        clsArr[8] = String.class;
        clsArr[9] = String[].class;
        clsArr[10] = Binder.class;
        clsArr[11] = Bundle.class;
        clsArr[12] = Byte.TYPE;
        clsArr[13] = byte[].class;
        clsArr[14] = Character.TYPE;
        clsArr[15] = char[].class;
        clsArr[16] = CharSequence.class;
        clsArr[17] = CharSequence[].class;
        clsArr[18] = ArrayList.class;
        clsArr[19] = Float.TYPE;
        clsArr[20] = float[].class;
        clsArr[21] = Parcelable.class;
        clsArr[22] = Parcelable[].class;
        clsArr[23] = Serializable.class;
        clsArr[24] = Short.TYPE;
        clsArr[25] = short[].class;
        clsArr[26] = SparseArray.class;
        int i10 = Build.VERSION.SDK_INT;
        clsArr[27] = i10 >= 21 ? Size.class : cls;
        if (i10 >= 21) {
            cls = SizeF.class;
        }
        clsArr[28] = cls;
        f3232g = clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle d(w wVar) {
        Map r10;
        y8.k.e(wVar, "this$0");
        r10 = l0.r(wVar.f3234b);
        for (Map.Entry entry : r10.entrySet()) {
            wVar.e((String) entry.getKey(), ((c.InterfaceC0267c) entry.getValue()).a());
        }
        Set<String> keySet = wVar.f3233a.keySet();
        ArrayList arrayList = new ArrayList(keySet.size());
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (String str : keySet) {
            arrayList.add(str);
            arrayList2.add(wVar.f3233a.get(str));
        }
        return androidx.core.os.d.a(l8.t.a("keys", arrayList), l8.t.a("values", arrayList2));
    }

    public final c.InterfaceC0267c c() {
        return this.f3237e;
    }

    public final <T> void e(String str, T t10) {
        y8.k.e(str, "key");
        if (!f3231f.a(t10)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Can't put value with type ");
            y8.k.b(t10);
            sb2.append(t10.getClass());
            sb2.append(" into saved state");
            throw new IllegalArgumentException(sb2.toString());
        }
        Object obj = this.f3235c.get(str);
        q qVar = obj instanceof q ? (q) obj : null;
        if (qVar != null) {
            qVar.j(t10);
        } else {
            this.f3233a.put(str, t10);
        }
        pb.a<Object> aVar = this.f3236d.get(str);
        if (aVar == null) {
            return;
        }
        aVar.setValue(t10);
    }
}
