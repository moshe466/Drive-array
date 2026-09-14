package com.google.firebase.firestore;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class FieldValue {
    private static final DeleteFieldValue DELETE_INSTANCE = new DeleteFieldValue();
    private static final ServerTimestampFieldValue SERVER_TIMESTAMP_INSTANCE = new ServerTimestampFieldValue();

    /* loaded from: classes2.dex */
    static class ArrayRemoveFieldValue extends FieldValue {
        private final List<Object> elements;

        ArrayRemoveFieldValue(List<Object> list) {
            this.elements = list;
        }

        @Override // com.google.firebase.firestore.FieldValue
        String a() {
            return "FieldValue.arrayRemove";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public List<Object> b() {
            return this.elements;
        }
    }

    /* loaded from: classes2.dex */
    static class ArrayUnionFieldValue extends FieldValue {
        private final List<Object> elements;

        ArrayUnionFieldValue(List<Object> list) {
            this.elements = list;
        }

        @Override // com.google.firebase.firestore.FieldValue
        String a() {
            return "FieldValue.arrayUnion";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public List<Object> b() {
            return this.elements;
        }
    }

    /* loaded from: classes2.dex */
    static class DeleteFieldValue extends FieldValue {
        DeleteFieldValue() {
        }

        @Override // com.google.firebase.firestore.FieldValue
        String a() {
            return "FieldValue.delete";
        }
    }

    /* loaded from: classes2.dex */
    static class NumericIncrementFieldValue extends FieldValue {
        private final Number operand;

        NumericIncrementFieldValue(Number number) {
            this.operand = number;
        }

        @Override // com.google.firebase.firestore.FieldValue
        String a() {
            return "FieldValue.increment";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Number b() {
            return this.operand;
        }
    }

    /* loaded from: classes2.dex */
    static class ServerTimestampFieldValue extends FieldValue {
        ServerTimestampFieldValue() {
        }

        @Override // com.google.firebase.firestore.FieldValue
        String a() {
            return "FieldValue.serverTimestamp";
        }
    }

    FieldValue() {
    }

    @NonNull
    public static FieldValue arrayRemove(Object... objArr) {
        return new ArrayRemoveFieldValue(Arrays.asList(objArr));
    }

    @NonNull
    public static FieldValue arrayUnion(Object... objArr) {
        return new ArrayUnionFieldValue(Arrays.asList(objArr));
    }

    @NonNull
    public static FieldValue delete() {
        return DELETE_INSTANCE;
    }

    @NonNull
    public static FieldValue increment(double d) {
        return new NumericIncrementFieldValue(Double.valueOf(d));
    }

    @NonNull
    public static FieldValue increment(long j) {
        return new NumericIncrementFieldValue(Long.valueOf(j));
    }

    @NonNull
    public static FieldValue serverTimestamp() {
        return SERVER_TIMESTAMP_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract String a();
}
