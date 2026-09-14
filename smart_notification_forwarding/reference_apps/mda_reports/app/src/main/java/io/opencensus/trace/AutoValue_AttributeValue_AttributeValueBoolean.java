package io.opencensus.trace;

import io.opencensus.trace.AttributeValue;

/* loaded from: classes2.dex */
final class AutoValue_AttributeValue_AttributeValueBoolean extends AttributeValue.AttributeValueBoolean {
    private final Boolean booleanValue;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_AttributeValue_AttributeValueBoolean(Boolean bool) {
        if (bool == null) {
            throw new NullPointerException("Null booleanValue");
        }
        this.booleanValue = bool;
    }

    @Override // io.opencensus.trace.AttributeValue.AttributeValueBoolean
    Boolean a() {
        return this.booleanValue;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AttributeValue.AttributeValueBoolean) {
            return this.booleanValue.equals(((AttributeValue.AttributeValueBoolean) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return this.booleanValue.hashCode() ^ 1000003;
    }

    public String toString() {
        return "AttributeValueBoolean{booleanValue=" + this.booleanValue + "}";
    }
}
