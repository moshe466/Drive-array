package com.google.firebase.firestore.core;

import com.google.firebase.firestore.core.Filter;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.value.ArrayValue;
import com.google.firebase.firestore.model.value.DoubleValue;
import com.google.firebase.firestore.model.value.FieldValue;
import com.google.firebase.firestore.model.value.NullValue;
import com.google.firebase.firestore.model.value.ReferenceValue;
import com.google.firebase.firestore.util.Assert;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class FieldFilter extends Filter {
    private final FieldPath field;
    private final Filter.Operator operator;
    private final FieldValue value;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.firestore.core.FieldFilter$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[Filter.Operator.values().length];

        static {
            try {
                a[Filter.Operator.LESS_THAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Filter.Operator.LESS_THAN_OR_EQUAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Filter.Operator.EQUAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Filter.Operator.GREATER_THAN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Filter.Operator.GREATER_THAN_OR_EQUAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FieldFilter(FieldPath fieldPath, Filter.Operator operator, FieldValue fieldValue) {
        this.field = fieldPath;
        this.operator = operator;
        this.value = fieldValue;
    }

    public static FieldFilter create(FieldPath fieldPath, Filter.Operator operator, FieldValue fieldValue) {
        if (fieldPath.isKeyField()) {
            if (operator == Filter.Operator.IN) {
                Assert.hardAssert(fieldValue instanceof ArrayValue, "Comparing on key with IN, but the value was not an ArrayValue", new Object[0]);
                return new KeyFieldInFilter(fieldPath, (ArrayValue) fieldValue);
            }
            Assert.hardAssert(fieldValue instanceof ReferenceValue, "Comparing on key, but filter value not a ReferenceValue", new Object[0]);
            Assert.hardAssert((operator == Filter.Operator.ARRAY_CONTAINS || operator == Filter.Operator.ARRAY_CONTAINS_ANY) ? false : true, operator.toString() + "queries don't make sense on document keys", new Object[0]);
            return new KeyFieldFilter(fieldPath, operator, (ReferenceValue) fieldValue);
        }
        if (fieldValue.equals(NullValue.nullValue())) {
            if (operator == Filter.Operator.EQUAL) {
                return new FieldFilter(fieldPath, operator, fieldValue);
            }
            throw new IllegalArgumentException("Invalid Query. Null supports only equality comparisons (via whereEqualTo()).");
        }
        if (fieldValue.equals(DoubleValue.NaN)) {
            if (operator == Filter.Operator.EQUAL) {
                return new FieldFilter(fieldPath, operator, fieldValue);
            }
            throw new IllegalArgumentException("Invalid Query. NaN supports only equality comparisons (via whereEqualTo()).");
        }
        if (operator == Filter.Operator.ARRAY_CONTAINS) {
            return new ArrayContainsFilter(fieldPath, fieldValue);
        }
        if (operator == Filter.Operator.IN) {
            Assert.hardAssert(fieldValue instanceof ArrayValue, "IN filter has invalid value: " + fieldValue.toString(), new Object[0]);
            return new InFilter(fieldPath, (ArrayValue) fieldValue);
        }
        if (operator != Filter.Operator.ARRAY_CONTAINS_ANY) {
            return new FieldFilter(fieldPath, operator, fieldValue);
        }
        Assert.hardAssert(fieldValue instanceof ArrayValue, "ARRAY_CONTAINS_ANY filter has invalid value: " + fieldValue.toString(), new Object[0]);
        return new ArrayContainsAnyFilter(fieldPath, (ArrayValue) fieldValue);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(int i) {
        int i2 = AnonymousClass1.a[this.operator.ordinal()];
        if (i2 == 1) {
            return i < 0;
        }
        if (i2 == 2) {
            return i <= 0;
        }
        if (i2 == 3) {
            return i == 0;
        }
        if (i2 == 4) {
            return i > 0;
        }
        if (i2 == 5) {
            return i >= 0;
        }
        throw Assert.fail("Unknown FieldFilter operator: %s", this.operator);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof FieldFilter)) {
            return false;
        }
        FieldFilter fieldFilter = (FieldFilter) obj;
        return this.operator == fieldFilter.operator && this.field.equals(fieldFilter.field) && this.value.equals(fieldFilter.value);
    }

    @Override // com.google.firebase.firestore.core.Filter
    public String getCanonicalId() {
        return getField().canonicalString() + getOperator().toString() + getValue().toString();
    }

    @Override // com.google.firebase.firestore.core.Filter
    public FieldPath getField() {
        return this.field;
    }

    public Filter.Operator getOperator() {
        return this.operator;
    }

    public FieldValue getValue() {
        return this.value;
    }

    public int hashCode() {
        return ((((1147 + this.operator.hashCode()) * 31) + this.field.hashCode()) * 31) + this.value.hashCode();
    }

    public boolean isInequality() {
        return Arrays.asList(Filter.Operator.LESS_THAN, Filter.Operator.LESS_THAN_OR_EQUAL, Filter.Operator.GREATER_THAN, Filter.Operator.GREATER_THAN_OR_EQUAL).contains(this.operator);
    }

    @Override // com.google.firebase.firestore.core.Filter
    public boolean matches(Document document) {
        FieldValue field = document.getField(this.field);
        return field != null && this.value.typeOrder() == field.typeOrder() && a(field.compareTo(this.value));
    }

    public String toString() {
        return this.field.canonicalString() + " " + this.operator + " " + this.value;
    }
}
