package com.google.firebase.firestore.model.mutation;

import androidx.annotation.Nullable;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.value.DoubleValue;
import com.google.firebase.firestore.model.value.FieldValue;
import com.google.firebase.firestore.model.value.IntegerValue;
import com.google.firebase.firestore.model.value.NumberValue;
import com.google.firebase.firestore.util.Assert;

/* loaded from: classes2.dex */
public class NumericIncrementTransformOperation implements TransformOperation {
    private NumberValue operand;

    public NumericIncrementTransformOperation(NumberValue numberValue) {
        this.operand = numberValue;
    }

    private double operandAsDouble() {
        NumberValue numberValue = this.operand;
        if (numberValue instanceof DoubleValue) {
            return ((DoubleValue) numberValue).getInternalValue();
        }
        if (numberValue instanceof IntegerValue) {
            return ((IntegerValue) numberValue).getInternalValue();
        }
        throw Assert.fail("Expected 'operand' to be of Number type, but was " + this.operand.getClass().getCanonicalName(), new Object[0]);
    }

    private long operandAsLong() {
        NumberValue numberValue = this.operand;
        if (numberValue instanceof DoubleValue) {
            return (long) ((DoubleValue) numberValue).getInternalValue();
        }
        if (numberValue instanceof IntegerValue) {
            return ((IntegerValue) numberValue).getInternalValue();
        }
        throw Assert.fail("Expected 'operand' to be of Number type, but was " + this.operand.getClass().getCanonicalName(), new Object[0]);
    }

    private long safeIncrement(long j, long j2) {
        long j3 = j + j2;
        return ((j ^ j3) & (j2 ^ j3)) >= 0 ? j3 : j3 >= 0 ? Long.MIN_VALUE : Long.MAX_VALUE;
    }

    @Override // com.google.firebase.firestore.model.mutation.TransformOperation
    public FieldValue applyToLocalView(@Nullable FieldValue fieldValue, Timestamp timestamp) {
        NumberValue computeBaseValue = computeBaseValue(fieldValue);
        boolean z = computeBaseValue instanceof IntegerValue;
        if (z && (this.operand instanceof IntegerValue)) {
            return IntegerValue.valueOf(Long.valueOf(safeIncrement(((IntegerValue) computeBaseValue).getInternalValue(), operandAsLong())));
        }
        if (!z) {
            Assert.hardAssert(computeBaseValue instanceof DoubleValue, "Expected NumberValue to be of type DoubleValue, but was ", fieldValue.getClass().getCanonicalName());
            return DoubleValue.valueOf(Double.valueOf(((DoubleValue) computeBaseValue).getInternalValue() + operandAsDouble()));
        }
        double internalValue = ((IntegerValue) computeBaseValue).getInternalValue();
        double operandAsDouble = operandAsDouble();
        Double.isNaN(internalValue);
        return DoubleValue.valueOf(Double.valueOf(internalValue + operandAsDouble));
    }

    @Override // com.google.firebase.firestore.model.mutation.TransformOperation
    public FieldValue applyToRemoteDocument(@Nullable FieldValue fieldValue, FieldValue fieldValue2) {
        return fieldValue2;
    }

    @Override // com.google.firebase.firestore.model.mutation.TransformOperation
    public NumberValue computeBaseValue(@Nullable FieldValue fieldValue) {
        return fieldValue instanceof NumberValue ? (NumberValue) fieldValue : IntegerValue.valueOf(0L);
    }

    public FieldValue getOperand() {
        return this.operand;
    }
}
