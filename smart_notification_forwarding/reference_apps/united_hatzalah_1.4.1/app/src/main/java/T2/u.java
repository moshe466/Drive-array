package t2;

import a.AbstractC0228a;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import s2.C0679d;

/* loaded from: classes.dex */
public abstract class u extends AbstractC0228a {
    public static int F(int i) {
        if (i < 0) {
            return i;
        }
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        }
        return Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public static Map G(C0679d... c0679dArr) {
        if (c0679dArr.length > 0) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(F(c0679dArr.length));
            H(linkedHashMap, c0679dArr);
            return linkedHashMap;
        }
        return s.f6477a;
    }

    public static final void H(HashMap hashMap, C0679d[] c0679dArr) {
        for (C0679d c0679d : c0679dArr) {
            hashMap.put(c0679d.f6332a, c0679d.f6333b);
        }
    }

    public static Map I(ArrayList arrayList) {
        int size = arrayList.size();
        if (size != 0) {
            if (size != 1) {
                LinkedHashMap linkedHashMap = new LinkedHashMap(F(arrayList.size()));
                int size2 = arrayList.size();
                int i = 0;
                while (i < size2) {
                    Object obj = arrayList.get(i);
                    i++;
                    C0679d c0679d = (C0679d) obj;
                    linkedHashMap.put(c0679d.f6332a, c0679d.f6333b);
                }
                return linkedHashMap;
            }
            C0679d pair = (C0679d) arrayList.get(0);
            kotlin.jvm.internal.j.e(pair, "pair");
            Map singletonMap = Collections.singletonMap(pair.f6332a, pair.f6333b);
            kotlin.jvm.internal.j.d(singletonMap, "singletonMap(...)");
            return singletonMap;
        }
        return s.f6477a;
    }
}
