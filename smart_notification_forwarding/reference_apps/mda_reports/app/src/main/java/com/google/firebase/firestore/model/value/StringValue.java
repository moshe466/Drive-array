package com.google.firebase.firestore.model.value;

/* loaded from: classes2.dex */
public class StringValue extends FieldValue {
    private final String internalValue;

    private StringValue(String str) {
        this.internalValue = str;
    }

    public static StringValue valueOf(String str) {
        return new StringValue(str);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.firebase.firestore.model.value.FieldValue, java.lang.Comparable
    public int compareTo(FieldValue fieldValue) {
        return fieldValue instanceof StringValue ? this.internalValue.compareTo(((StringValue) fieldValue).internalValue) : a(fieldValue);
    }

    @Override // com.google.firebase.firestore.model.value.FieldValue
    public boolean equals(Object obj) {
        return (obj instanceof StringValue) && this.internalValue.equals(((StringValue) obj).internalValue);
    }

    @Override // com.google.firebase.firestore.model.value.FieldValue
    public int hashCode() {
        return this.internalValue.hashCode();
    }

    @Override // com.google.firebase.firestore.model.value.FieldValue
    public int typeOrder() {
        return 4;
    }

    @Override // com.google.firebase.firestore.model.value.FieldValue
    public String value() {
        return this.internalValue;
    }
}
