package io.opencensus.trace;

import io.opencensus.trace.AttributeValue;

/* loaded from: classes2.dex */
final class AutoValue_AttributeValue_AttributeValueDouble extends AttributeValue.AttributeValueDouble {
    private final Double doubleValue;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_AttributeValue_AttributeValueDouble(Double d) {
        if (d == null) {
            throw new NullPointerException("Null doubleValue");
        }
        this.doubleValue = d;
    }

    @Override // io.opencensus.trace.AttributeValue.AttributeValueDouble
    Double a() {
        return this.doubleValue;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AttributeValue.AttributeValueDouble) {
            return this.doubleValue.equals(((AttributeValue.AttributeValueDouble) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return this.doubleValue.hashCode() ^ 1000003;
    }

    public String toString() {
        return "AttributeValueDouble{doubleValue=" + this.doubleValue + "}";
    }
}
