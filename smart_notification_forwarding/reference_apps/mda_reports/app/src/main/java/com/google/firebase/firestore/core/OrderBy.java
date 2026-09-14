package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.value.FieldValue;
import com.google.firebase.firestore.util.Assert;

/* loaded from: classes2.dex */
public class OrderBy {
    final FieldPath a;
    private final Direction direction;

    /* loaded from: classes2.dex */
    public enum Direction {
        ASCENDING(1),
        DESCENDING(-1);

        private final int comparisonModifier;

        Direction(int i) {
            this.comparisonModifier = i;
        }

        int a() {
            return this.comparisonModifier;
        }
    }

    private OrderBy(Direction direction, FieldPath fieldPath) {
        this.direction = direction;
        this.a = fieldPath;
    }

    public static OrderBy getInstance(Direction direction, FieldPath fieldPath) {
        return new OrderBy(direction, fieldPath);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(Document document, Document document2) {
        int a;
        int compareTo;
        if (this.a.equals(FieldPath.KEY_PATH)) {
            a = this.direction.a();
            compareTo = document.getKey().compareTo(document2.getKey());
        } else {
            FieldValue field = document.getField(this.a);
            FieldValue field2 = document2.getField(this.a);
            Assert.hardAssert((field == null || field2 == null) ? false : true, "Trying to compare documents on fields that don't exist.", new Object[0]);
            a = this.direction.a();
            compareTo = field.compareTo(field2);
        }
        return a * compareTo;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof OrderBy)) {
            return false;
        }
        OrderBy orderBy = (OrderBy) obj;
        return this.direction == orderBy.direction && this.a.equals(orderBy.a);
    }

    public Direction getDirection() {
        return this.direction;
    }

    public FieldPath getField() {
        return this.a;
    }

    public int hashCode() {
        return ((899 + this.direction.hashCode()) * 31) + this.a.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.direction == Direction.ASCENDING ? "" : "-");
        sb.append(this.a.canonicalString());
        return sb.toString();
    }
}
