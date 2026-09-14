package com.google.android.play.core.splitinstall;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class h {
    private final Map<String, Map<String, String>> a = new HashMap();

    public final f a() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, Map<String, String>> entry : this.a.entrySet()) {
            hashMap.put(entry.getKey(), Collections.unmodifiableMap(new HashMap(entry.getValue())));
        }
        return new f(Collections.unmodifiableMap(hashMap), (byte) 0);
    }

    public final h a(String str, String str2, String str3) {
        if (!this.a.containsKey(str2)) {
            this.a.put(str2, new HashMap());
        }
        this.a.get(str2).put(str, str3);
        return this;
    }
}
