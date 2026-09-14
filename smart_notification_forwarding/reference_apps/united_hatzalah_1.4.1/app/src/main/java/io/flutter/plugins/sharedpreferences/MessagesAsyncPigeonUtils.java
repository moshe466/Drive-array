package io.flutter.plugins.sharedpreferences;

import K2.d;
import K2.e;
import android.util.Log;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.j;
import t2.AbstractC0708j;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class MessagesAsyncPigeonUtils {
    public static final MessagesAsyncPigeonUtils INSTANCE = new MessagesAsyncPigeonUtils();

    private MessagesAsyncPigeonUtils() {
    }

    public final boolean deepEquals(Object obj, Object obj2) {
        if ((obj instanceof byte[]) && (obj2 instanceof byte[])) {
            return Arrays.equals((byte[]) obj, (byte[]) obj2);
        }
        if ((obj instanceof int[]) && (obj2 instanceof int[])) {
            return Arrays.equals((int[]) obj, (int[]) obj2);
        }
        if ((obj instanceof long[]) && (obj2 instanceof long[])) {
            return Arrays.equals((long[]) obj, (long[]) obj2);
        }
        if ((obj instanceof double[]) && (obj2 instanceof double[])) {
            return Arrays.equals((double[]) obj, (double[]) obj2);
        }
        if ((obj instanceof Object[]) && (obj2 instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            Object[] objArr2 = (Object[]) obj2;
            if (objArr.length == objArr2.length) {
                Iterable dVar = new d(0, objArr.length - 1, 1);
                if (!(dVar instanceof Collection) || !((Collection) dVar).isEmpty()) {
                    Iterator it = dVar.iterator();
                    while (((e) it).f1123c) {
                        int nextInt = ((e) it).nextInt();
                        if (!INSTANCE.deepEquals(objArr[nextInt], objArr2[nextInt])) {
                        }
                    }
                }
                return true;
            }
            return false;
        }
        if ((obj instanceof List) && (obj2 instanceof List)) {
            List list = (List) obj;
            List list2 = (List) obj2;
            if (list.size() == list2.size()) {
                Collection collection = (Collection) obj;
                j.e(collection, "<this>");
                Iterable dVar2 = new d(0, collection.size() - 1, 1);
                if (!(dVar2 instanceof Collection) || !((Collection) dVar2).isEmpty()) {
                    Iterator it2 = dVar2.iterator();
                    while (((e) it2).f1123c) {
                        int nextInt2 = ((e) it2).nextInt();
                        if (!INSTANCE.deepEquals(list.get(nextInt2), list2.get(nextInt2))) {
                        }
                    }
                }
                return true;
            }
            return false;
        }
        if ((obj instanceof Map) && (obj2 instanceof Map)) {
            Map map = (Map) obj;
            Map map2 = (Map) obj2;
            if (map.size() == map2.size()) {
                if (!map.isEmpty()) {
                    for (Map.Entry entry : map.entrySet()) {
                        if (map2.containsKey(entry.getKey()) && INSTANCE.deepEquals(entry.getValue(), map2.get(entry.getKey()))) {
                        }
                    }
                }
                return true;
            }
            return false;
        }
        return j.a(obj, obj2);
    }

    public final List<Object> wrapError(Throwable exception) {
        j.e(exception, "exception");
        if (exception instanceof SharedPreferencesError) {
            SharedPreferencesError sharedPreferencesError = (SharedPreferencesError) exception;
            return AbstractC0708j.W(sharedPreferencesError.getCode(), sharedPreferencesError.getMessage(), sharedPreferencesError.getDetails());
        }
        return AbstractC0708j.W(exception.getClass().getSimpleName(), exception.toString(), "Cause: " + exception.getCause() + ", Stacktrace: " + Log.getStackTraceString(exception));
    }

    public final List<Object> wrapResult(Object obj) {
        return T.b.B(obj);
    }
}
