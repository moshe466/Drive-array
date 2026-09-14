package io.opencensus.tags;

import java.util.HashMap;
import java.util.Iterator;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* loaded from: classes2.dex */
public abstract class TagContext {
    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Iterator<Tag> a();

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof TagContext)) {
            return false;
        }
        Iterator<Tag> a = a();
        Iterator<Tag> a2 = ((TagContext) obj).a();
        HashMap hashMap = new HashMap();
        while (a != null && a.hasNext()) {
            Tag next = a.next();
            hashMap.put(next, hashMap.containsKey(next) ? Integer.valueOf(((Integer) hashMap.get(next)).intValue() + 1) : 1);
        }
        while (a2 != null && a2.hasNext()) {
            Tag next2 = a2.next();
            if (!hashMap.containsKey(next2)) {
                return false;
            }
            int intValue = ((Integer) hashMap.get(next2)).intValue();
            if (intValue > 1) {
                hashMap.put(next2, Integer.valueOf(intValue - 1));
            } else {
                hashMap.remove(next2);
            }
        }
        return hashMap.isEmpty();
    }

    public final int hashCode() {
        Iterator<Tag> a = a();
        int i = 0;
        if (a == null) {
            return 0;
        }
        while (a.hasNext()) {
            Tag next = a.next();
            if (next != null) {
                i += next.hashCode();
            }
        }
        return i;
    }

    public String toString() {
        return "TagContext";
    }
}
