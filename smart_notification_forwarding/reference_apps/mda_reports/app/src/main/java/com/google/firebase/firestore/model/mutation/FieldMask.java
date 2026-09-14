package com.google.firebase.firestore.model.mutation;

import com.google.firebase.firestore.model.FieldPath;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
public final class FieldMask {
    private final Set<FieldPath> mask;

    private FieldMask(Set<FieldPath> set) {
        this.mask = set;
    }

    public static FieldMask fromSet(Set<FieldPath> set) {
        return new FieldMask(set);
    }

    public boolean covers(FieldPath fieldPath) {
        Iterator<FieldPath> it = this.mask.iterator();
        while (it.hasNext()) {
            if (it.next().isPrefixOf(fieldPath)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || FieldMask.class != obj.getClass()) {
            return false;
        }
        return this.mask.equals(((FieldMask) obj).mask);
    }

    public Set<FieldPath> getMask() {
        return this.mask;
    }

    public int hashCode() {
        return this.mask.hashCode();
    }

    public String toString() {
        return "FieldMask{mask=" + this.mask.toString() + "}";
    }
}
