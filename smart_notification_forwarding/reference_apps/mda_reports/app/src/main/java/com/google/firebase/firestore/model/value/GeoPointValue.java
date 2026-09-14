package com.google.firebase.firestore.model.value;

import com.google.firebase.firestore.GeoPoint;

/* loaded from: classes2.dex */
public class GeoPointValue extends FieldValue {
    private final GeoPoint internalValue;

    private GeoPointValue(GeoPoint geoPoint) {
        this.internalValue = geoPoint;
    }

    public static GeoPointValue valueOf(GeoPoint geoPoint) {
        return new GeoPointValue(geoPoint);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.firebase.firestore.model.value.FieldValue, java.lang.Comparable
    public int compareTo(FieldValue fieldValue) {
        return fieldValue instanceof GeoPointValue ? this.internalValue.compareTo(((GeoPointValue) fieldValue).internalValue) : a(fieldValue);
    }

    @Override // com.google.firebase.firestore.model.value.FieldValue
    public boolean equals(Object obj) {
        return (obj instanceof GeoPointValue) && this.internalValue.equals(((GeoPointValue) obj).internalValue);
    }

    @Override // com.google.firebase.firestore.model.value.FieldValue
    public int hashCode() {
        return this.internalValue.hashCode();
    }

    @Override // com.google.firebase.firestore.model.value.FieldValue
    public int typeOrder() {
        return 7;
    }

    @Override // com.google.firebase.firestore.model.value.FieldValue
    public GeoPoint value() {
        return this.internalValue;
    }
}
