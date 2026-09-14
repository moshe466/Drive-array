package com.google.firebase.firestore.model.mutation;

import androidx.annotation.Nullable;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.value.ArrayValue;
import com.google.firebase.firestore.model.value.FieldValue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class ArrayTransformOperation implements TransformOperation {
    private final List<FieldValue> elements;

    /* loaded from: classes2.dex */
    public static class Remove extends ArrayTransformOperation {
        public Remove(List<FieldValue> list) {
            super(list);
        }

        @Override // com.google.firebase.firestore.model.mutation.ArrayTransformOperation
        protected ArrayValue a(@Nullable FieldValue fieldValue) {
            ArrayList<FieldValue> b = ArrayTransformOperation.b(fieldValue);
            Iterator<FieldValue> it = getElements().iterator();
            while (it.hasNext()) {
                b.removeAll(Collections.singleton(it.next()));
            }
            return ArrayValue.fromList(b);
        }
    }

    /* loaded from: classes2.dex */
    public static class Union extends ArrayTransformOperation {
        public Union(List<FieldValue> list) {
            super(list);
        }

        @Override // com.google.firebase.firestore.model.mutation.ArrayTransformOperation
        protected ArrayValue a(@Nullable FieldValue fieldValue) {
            ArrayList<FieldValue> b = ArrayTransformOperation.b(fieldValue);
            for (FieldValue fieldValue2 : getElements()) {
                if (!b.contains(fieldValue2)) {
                    b.add(fieldValue2);
                }
            }
            return ArrayValue.fromList(b);
        }
    }

    ArrayTransformOperation(List<FieldValue> list) {
        this.elements = Collections.unmodifiableList(list);
    }

    static ArrayList<FieldValue> b(@Nullable FieldValue fieldValue) {
        return fieldValue instanceof ArrayValue ? new ArrayList<>(((ArrayValue) fieldValue).getInternalValue()) : new ArrayList<>();
    }

    protected abstract ArrayValue a(@Nullable FieldValue fieldValue);

    @Override // com.google.firebase.firestore.model.mutation.TransformOperation
    public FieldValue applyToLocalView(@Nullable FieldValue fieldValue, Timestamp timestamp) {
        return a(fieldValue);
    }

    @Override // com.google.firebase.firestore.model.mutation.TransformOperation
    public FieldValue applyToRemoteDocument(@Nullable FieldValue fieldValue, FieldValue fieldValue2) {
        return a(fieldValue);
    }

    @Override // com.google.firebase.firestore.model.mutation.TransformOperation
    @Nullable
    public FieldValue computeBaseValue(@Nullable FieldValue fieldValue) {
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.elements.equals(((ArrayTransformOperation) obj).elements);
    }

    public List<FieldValue> getElements() {
        return this.elements;
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.elements.hashCode();
    }
}
