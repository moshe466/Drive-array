package com.google.firebase.firestore.model.mutation;

import androidx.annotation.Nullable;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.value.FieldValue;

/* loaded from: classes2.dex */
public interface TransformOperation {
    FieldValue applyToLocalView(@Nullable FieldValue fieldValue, Timestamp timestamp);

    FieldValue applyToRemoteDocument(@Nullable FieldValue fieldValue, FieldValue fieldValue2);

    @Nullable
    FieldValue computeBaseValue(@Nullable FieldValue fieldValue);
}
