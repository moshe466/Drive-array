package com.google.firebase.firestore.model.mutation;

import androidx.annotation.Nullable;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.value.FieldValue;
import com.google.firebase.firestore.model.value.ServerTimestampValue;

/* loaded from: classes2.dex */
public class ServerTimestampOperation implements TransformOperation {
    private static final ServerTimestampOperation SHARED_INSTANCE = new ServerTimestampOperation();

    private ServerTimestampOperation() {
    }

    public static ServerTimestampOperation getInstance() {
        return SHARED_INSTANCE;
    }

    @Override // com.google.firebase.firestore.model.mutation.TransformOperation
    public FieldValue applyToLocalView(@Nullable FieldValue fieldValue, Timestamp timestamp) {
        return new ServerTimestampValue(timestamp, fieldValue);
    }

    @Override // com.google.firebase.firestore.model.mutation.TransformOperation
    public FieldValue applyToRemoteDocument(@Nullable FieldValue fieldValue, FieldValue fieldValue2) {
        return fieldValue2;
    }

    @Override // com.google.firebase.firestore.model.mutation.TransformOperation
    @Nullable
    public FieldValue computeBaseValue(@Nullable FieldValue fieldValue) {
        return null;
    }
}
