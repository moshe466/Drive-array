package com.google.firebase.firestore.core;

import com.google.firebase.firestore.core.OrderBy;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.value.FieldValue;
import com.google.firebase.firestore.util.Assert;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class Bound {
    private final boolean before;
    private final List<FieldValue> position;

    public Bound(List<FieldValue> list, boolean z) {
        this.position = list;
        this.before = z;
    }

    public String canonicalString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.before ? "b:" : "a:");
        Iterator<FieldValue> it = this.position.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Bound.class != obj.getClass()) {
            return false;
        }
        Bound bound = (Bound) obj;
        return this.before == bound.before && this.position.equals(bound.position);
    }

    public List<FieldValue> getPosition() {
        return this.position;
    }

    public int hashCode() {
        return ((this.before ? 1 : 0) * 31) + this.position.hashCode();
    }

    public boolean isBefore() {
        return this.before;
    }

    public boolean sortsBeforeDocument(List<OrderBy> list, Document document) {
        int compareTo;
        Assert.hardAssert(this.position.size() <= list.size(), "Bound has more components than query's orderBy", new Object[0]);
        int i = 0;
        for (int i2 = 0; i2 < this.position.size(); i2++) {
            OrderBy orderBy = list.get(i2);
            FieldValue fieldValue = this.position.get(i2);
            if (orderBy.a.equals(FieldPath.KEY_PATH)) {
                Object value = fieldValue.value();
                Assert.hardAssert(value instanceof DocumentKey, "Bound has a non-key value where the key path is being used %s", fieldValue);
                compareTo = ((DocumentKey) value).compareTo(document.getKey());
            } else {
                FieldValue field = document.getField(orderBy.getField());
                Assert.hardAssert(field != null, "Field should exist since document matched the orderBy already.", new Object[0]);
                compareTo = fieldValue.compareTo(field);
            }
            if (orderBy.getDirection().equals(OrderBy.Direction.DESCENDING)) {
                compareTo *= -1;
            }
            i = compareTo;
            if (i != 0) {
                break;
            }
        }
        if (this.before) {
            if (i <= 0) {
                return true;
            }
        } else if (i < 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "Bound{before=" + this.before + ", position=" + this.position + '}';
    }
}
