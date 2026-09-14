package io.opencensus.trace.propagation;

import io.opencensus.internal.Utils;
import io.opencensus.trace.SpanContext;
import java.text.ParseException;

/* loaded from: classes2.dex */
public abstract class BinaryFormat {
    static final NoopBinaryFormat a = new NoopBinaryFormat();

    /* loaded from: classes2.dex */
    private static final class NoopBinaryFormat extends BinaryFormat {
        private NoopBinaryFormat() {
        }

        @Override // io.opencensus.trace.propagation.BinaryFormat
        public SpanContext fromByteArray(byte[] bArr) {
            Utils.checkNotNull(bArr, "bytes");
            return SpanContext.INVALID;
        }

        @Override // io.opencensus.trace.propagation.BinaryFormat
        public byte[] toByteArray(SpanContext spanContext) {
            Utils.checkNotNull(spanContext, "spanContext");
            return new byte[0];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BinaryFormat a() {
        return a;
    }

    @Deprecated
    public SpanContext fromBinaryValue(byte[] bArr) {
        try {
            return fromByteArray(bArr);
        } catch (SpanContextParseException e) {
            throw new ParseException(e.toString(), 0);
        }
    }

    public SpanContext fromByteArray(byte[] bArr) {
        try {
            return fromBinaryValue(bArr);
        } catch (ParseException e) {
            throw new SpanContextParseException("Error while parsing.", e);
        }
    }

    @Deprecated
    public byte[] toBinaryValue(SpanContext spanContext) {
        return toByteArray(spanContext);
    }

    public byte[] toByteArray(SpanContext spanContext) {
        return toBinaryValue(spanContext);
    }
}
