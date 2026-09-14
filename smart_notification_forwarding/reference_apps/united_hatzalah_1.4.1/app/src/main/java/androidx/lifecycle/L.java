package androidx.lifecycle;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import l0.InterfaceC0513c;
import s2.C0679d;

/* loaded from: classes.dex */
public final class L {

    /* renamed from: f, reason: collision with root package name */
    public static final Class[] f3562f = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f3563a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f3564b;

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f3565c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f3566d;

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC0513c f3567e;

    public L(HashMap hashMap) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f3563a = linkedHashMap;
        this.f3564b = new LinkedHashMap();
        this.f3565c = new LinkedHashMap();
        this.f3566d = new LinkedHashMap();
        this.f3567e = new K(this, 0);
        linkedHashMap.putAll(hashMap);
    }

    public static Bundle a(L l3) {
        Map map;
        B b4;
        LinkedHashMap linkedHashMap = l3.f3563a;
        LinkedHashMap linkedHashMap2 = l3.f3564b;
        kotlin.jvm.internal.j.e(linkedHashMap2, "<this>");
        int size = linkedHashMap2.size();
        if (size != 0) {
            if (size != 1) {
                map = new LinkedHashMap(linkedHashMap2);
            } else {
                kotlin.jvm.internal.j.e(linkedHashMap2, "<this>");
                Map.Entry entry = (Map.Entry) linkedHashMap2.entrySet().iterator().next();
                map = Collections.singletonMap(entry.getKey(), entry.getValue());
                kotlin.jvm.internal.j.d(map, "with(...)");
            }
        } else {
            map = t2.s.f6477a;
        }
        Iterator it = map.entrySet().iterator();
        while (true) {
            int i = 0;
            if (it.hasNext()) {
                Map.Entry entry2 = (Map.Entry) it.next();
                String key = (String) entry2.getKey();
                Object a2 = ((InterfaceC0513c) entry2.getValue()).a();
                kotlin.jvm.internal.j.e(key, "key");
                if (a2 != null) {
                    while (i < 29) {
                        Class cls = f3562f[i];
                        kotlin.jvm.internal.j.b(cls);
                        if (!cls.isInstance(a2)) {
                            i++;
                        }
                    }
                    throw new IllegalArgumentException("Can't put value with type " + a2.getClass() + " into saved state");
                }
                Object obj = l3.f3565c.get(key);
                if (obj instanceof B) {
                    b4 = (B) obj;
                } else {
                    b4 = null;
                }
                if (b4 != null) {
                    b4.h(a2);
                } else {
                    linkedHashMap.put(key, a2);
                }
                S2.w wVar = (S2.w) l3.f3566d.get(key);
                if (wVar != null) {
                    S2.y yVar = (S2.y) wVar;
                    if (a2 == null) {
                        a2 = T2.j.f2291a;
                    }
                    yVar.b(null, a2);
                }
            } else {
                Set<String> keySet = linkedHashMap.keySet();
                ArrayList arrayList = new ArrayList(keySet.size());
                ArrayList arrayList2 = new ArrayList(arrayList.size());
                for (String str : keySet) {
                    arrayList.add(str);
                    arrayList2.add(linkedHashMap.get(str));
                }
                C0679d[] c0679dArr = {new C0679d(UserMetadata.KEYDATA_FILENAME, arrayList), new C0679d("values", arrayList2)};
                Bundle bundle = new Bundle(2);
                while (i < 2) {
                    C0679d c0679d = c0679dArr[i];
                    String str2 = (String) c0679d.f6332a;
                    Object obj2 = c0679d.f6333b;
                    if (obj2 == null) {
                        bundle.putString(str2, null);
                    } else if (obj2 instanceof Boolean) {
                        bundle.putBoolean(str2, ((Boolean) obj2).booleanValue());
                    } else if (obj2 instanceof Byte) {
                        bundle.putByte(str2, ((Number) obj2).byteValue());
                    } else if (obj2 instanceof Character) {
                        bundle.putChar(str2, ((Character) obj2).charValue());
                    } else if (obj2 instanceof Double) {
                        bundle.putDouble(str2, ((Number) obj2).doubleValue());
                    } else if (obj2 instanceof Float) {
                        bundle.putFloat(str2, ((Number) obj2).floatValue());
                    } else if (obj2 instanceof Integer) {
                        bundle.putInt(str2, ((Number) obj2).intValue());
                    } else if (obj2 instanceof Long) {
                        bundle.putLong(str2, ((Number) obj2).longValue());
                    } else if (obj2 instanceof Short) {
                        bundle.putShort(str2, ((Number) obj2).shortValue());
                    } else if (obj2 instanceof Bundle) {
                        bundle.putBundle(str2, (Bundle) obj2);
                    } else if (obj2 instanceof CharSequence) {
                        bundle.putCharSequence(str2, (CharSequence) obj2);
                    } else if (obj2 instanceof Parcelable) {
                        bundle.putParcelable(str2, (Parcelable) obj2);
                    } else if (obj2 instanceof boolean[]) {
                        bundle.putBooleanArray(str2, (boolean[]) obj2);
                    } else if (obj2 instanceof byte[]) {
                        bundle.putByteArray(str2, (byte[]) obj2);
                    } else if (obj2 instanceof char[]) {
                        bundle.putCharArray(str2, (char[]) obj2);
                    } else if (obj2 instanceof double[]) {
                        bundle.putDoubleArray(str2, (double[]) obj2);
                    } else if (obj2 instanceof float[]) {
                        bundle.putFloatArray(str2, (float[]) obj2);
                    } else if (obj2 instanceof int[]) {
                        bundle.putIntArray(str2, (int[]) obj2);
                    } else if (obj2 instanceof long[]) {
                        bundle.putLongArray(str2, (long[]) obj2);
                    } else if (obj2 instanceof short[]) {
                        bundle.putShortArray(str2, (short[]) obj2);
                    } else if (obj2 instanceof Object[]) {
                        Class<?> componentType = obj2.getClass().getComponentType();
                        kotlin.jvm.internal.j.b(componentType);
                        if (Parcelable.class.isAssignableFrom(componentType)) {
                            bundle.putParcelableArray(str2, (Parcelable[]) obj2);
                        } else if (String.class.isAssignableFrom(componentType)) {
                            bundle.putStringArray(str2, (String[]) obj2);
                        } else if (CharSequence.class.isAssignableFrom(componentType)) {
                            bundle.putCharSequenceArray(str2, (CharSequence[]) obj2);
                        } else if (Serializable.class.isAssignableFrom(componentType)) {
                            bundle.putSerializable(str2, (Serializable) obj2);
                        } else {
                            throw new IllegalArgumentException("Illegal value array type " + componentType.getCanonicalName() + " for key \"" + str2 + '\"');
                        }
                    } else if (obj2 instanceof Serializable) {
                        bundle.putSerializable(str2, (Serializable) obj2);
                    } else if (obj2 instanceof IBinder) {
                        bundle.putBinder(str2, (IBinder) obj2);
                    } else if (obj2 instanceof Size) {
                        bundle.putSize(str2, (Size) obj2);
                    } else if (obj2 instanceof SizeF) {
                        bundle.putSizeF(str2, (SizeF) obj2);
                    } else {
                        throw new IllegalArgumentException("Illegal value type " + obj2.getClass().getCanonicalName() + " for key \"" + str2 + '\"');
                    }
                    i++;
                }
                return bundle;
            }
        }
    }

    public L() {
        this.f3563a = new LinkedHashMap();
        this.f3564b = new LinkedHashMap();
        this.f3565c = new LinkedHashMap();
        this.f3566d = new LinkedHashMap();
        this.f3567e = new K(this, 0);
    }
}
