package com.google.firebase.inappmessaging.internal;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public final class RateLimitProto {

    /* renamed from: com.google.firebase.inappmessaging.internal.RateLimitProto$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[GeneratedMessageLite.MethodToInvoke.values().length];

        static {
            try {
                a[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.IS_INITIALIZED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.MAKE_IMMUTABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.VISIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.MERGE_FROM_STREAM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Counter extends GeneratedMessageLite<Counter, Builder> implements CounterOrBuilder {
        private static final Counter DEFAULT_INSTANCE = new Counter();
        private static volatile Parser<Counter> PARSER = null;
        public static final int START_TIME_EPOCH_FIELD_NUMBER = 2;
        public static final int VALUE_FIELD_NUMBER = 1;
        private long startTimeEpoch_;
        private long value_;

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Counter, Builder> implements CounterOrBuilder {
            private Builder() {
                super(Counter.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearStartTimeEpoch() {
                a();
                ((Counter) this.a).clearStartTimeEpoch();
                return this;
            }

            public Builder clearValue() {
                a();
                ((Counter) this.a).clearValue();
                return this;
            }

            @Override // com.google.firebase.inappmessaging.internal.RateLimitProto.CounterOrBuilder
            public long getStartTimeEpoch() {
                return ((Counter) this.a).getStartTimeEpoch();
            }

            @Override // com.google.firebase.inappmessaging.internal.RateLimitProto.CounterOrBuilder
            public long getValue() {
                return ((Counter) this.a).getValue();
            }

            public Builder setStartTimeEpoch(long j) {
                a();
                ((Counter) this.a).setStartTimeEpoch(j);
                return this;
            }

            public Builder setValue(long j) {
                a();
                ((Counter) this.a).setValue(j);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private Counter() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStartTimeEpoch() {
            this.startTimeEpoch_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearValue() {
            this.value_ = 0L;
        }

        public static Counter getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Counter counter) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) counter);
        }

        public static Counter parseDelimitedFrom(InputStream inputStream) {
            return (Counter) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static Counter parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Counter) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Counter parseFrom(ByteString byteString) {
            return (Counter) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static Counter parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (Counter) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Counter parseFrom(CodedInputStream codedInputStream) {
            return (Counter) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Counter parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Counter) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Counter parseFrom(InputStream inputStream) {
            return (Counter) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static Counter parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Counter) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Counter parseFrom(byte[] bArr) {
            return (Counter) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static Counter parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (Counter) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<Counter> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStartTimeEpoch(long j) {
            this.startTimeEpoch_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setValue(long j) {
            this.value_ = j;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            boolean z = false;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new Counter();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    Counter counter = (Counter) obj2;
                    this.value_ = visitor.visitLong(this.value_ != 0, this.value_, counter.value_ != 0, counter.value_);
                    this.startTimeEpoch_ = visitor.visitLong(this.startTimeEpoch_ != 0, this.startTimeEpoch_, counter.startTimeEpoch_ != 0, counter.startTimeEpoch_);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    this.value_ = codedInputStream.readInt64();
                                } else if (readTag == 16) {
                                    this.startTimeEpoch_ = codedInputStream.readInt64();
                                } else if (!codedInputStream.skipField(readTag)) {
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e) {
                            throw new RuntimeException(e.setUnfinishedMessage(this));
                        } catch (IOException e2) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (PARSER == null) {
                        synchronized (Counter.class) {
                            if (PARSER == null) {
                                PARSER = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            }
                        }
                    }
                    return PARSER;
                default:
                    throw new UnsupportedOperationException();
            }
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            long j = this.value_;
            int computeInt64Size = j != 0 ? 0 + CodedOutputStream.computeInt64Size(1, j) : 0;
            long j2 = this.startTimeEpoch_;
            if (j2 != 0) {
                computeInt64Size += CodedOutputStream.computeInt64Size(2, j2);
            }
            this.c = computeInt64Size;
            return computeInt64Size;
        }

        @Override // com.google.firebase.inappmessaging.internal.RateLimitProto.CounterOrBuilder
        public long getStartTimeEpoch() {
            return this.startTimeEpoch_;
        }

        @Override // com.google.firebase.inappmessaging.internal.RateLimitProto.CounterOrBuilder
        public long getValue() {
            return this.value_;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            long j = this.value_;
            if (j != 0) {
                codedOutputStream.writeInt64(1, j);
            }
            long j2 = this.startTimeEpoch_;
            if (j2 != 0) {
                codedOutputStream.writeInt64(2, j2);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface CounterOrBuilder extends MessageLiteOrBuilder {
        long getStartTimeEpoch();

        long getValue();
    }

    /* loaded from: classes2.dex */
    public static final class RateLimit extends GeneratedMessageLite<RateLimit, Builder> implements RateLimitOrBuilder {
        private static final RateLimit DEFAULT_INSTANCE = new RateLimit();
        public static final int LIMITS_FIELD_NUMBER = 1;
        private static volatile Parser<RateLimit> PARSER;
        private MapFieldLite<String, Counter> limits_ = MapFieldLite.emptyMapField();

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<RateLimit, Builder> implements RateLimitOrBuilder {
            private Builder() {
                super(RateLimit.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearLimits() {
                a();
                ((RateLimit) this.a).getMutableLimitsMap().clear();
                return this;
            }

            @Override // com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimitOrBuilder
            public boolean containsLimits(String str) {
                if (str != null) {
                    return ((RateLimit) this.a).getLimitsMap().containsKey(str);
                }
                throw new NullPointerException();
            }

            @Override // com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimitOrBuilder
            @Deprecated
            public Map<String, Counter> getLimits() {
                return getLimitsMap();
            }

            @Override // com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimitOrBuilder
            public int getLimitsCount() {
                return ((RateLimit) this.a).getLimitsMap().size();
            }

            @Override // com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimitOrBuilder
            public Map<String, Counter> getLimitsMap() {
                return Collections.unmodifiableMap(((RateLimit) this.a).getLimitsMap());
            }

            @Override // com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimitOrBuilder
            public Counter getLimitsOrDefault(String str, Counter counter) {
                if (str == null) {
                    throw new NullPointerException();
                }
                Map<String, Counter> limitsMap = ((RateLimit) this.a).getLimitsMap();
                return limitsMap.containsKey(str) ? limitsMap.get(str) : counter;
            }

            @Override // com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimitOrBuilder
            public Counter getLimitsOrThrow(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                Map<String, Counter> limitsMap = ((RateLimit) this.a).getLimitsMap();
                if (limitsMap.containsKey(str)) {
                    return limitsMap.get(str);
                }
                throw new IllegalArgumentException();
            }

            public Builder putAllLimits(Map<String, Counter> map) {
                a();
                ((RateLimit) this.a).getMutableLimitsMap().putAll(map);
                return this;
            }

            public Builder putLimits(String str, Counter counter) {
                if (str == null) {
                    throw new NullPointerException();
                }
                if (counter == null) {
                    throw new NullPointerException();
                }
                a();
                ((RateLimit) this.a).getMutableLimitsMap().put(str, counter);
                return this;
            }

            public Builder removeLimits(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                a();
                ((RateLimit) this.a).getMutableLimitsMap().remove(str);
                return this;
            }
        }

        /* loaded from: classes2.dex */
        private static final class LimitsDefaultEntryHolder {
            static final MapEntryLite<String, Counter> a = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, Counter.getDefaultInstance());

            private LimitsDefaultEntryHolder() {
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private RateLimit() {
        }

        public static RateLimit getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, Counter> getMutableLimitsMap() {
            return internalGetMutableLimits();
        }

        private MapFieldLite<String, Counter> internalGetLimits() {
            return this.limits_;
        }

        private MapFieldLite<String, Counter> internalGetMutableLimits() {
            if (!this.limits_.isMutable()) {
                this.limits_ = this.limits_.mutableCopy();
            }
            return this.limits_;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(RateLimit rateLimit) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) rateLimit);
        }

        public static RateLimit parseDelimitedFrom(InputStream inputStream) {
            return (RateLimit) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static RateLimit parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (RateLimit) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static RateLimit parseFrom(ByteString byteString) {
            return (RateLimit) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static RateLimit parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (RateLimit) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static RateLimit parseFrom(CodedInputStream codedInputStream) {
            return (RateLimit) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static RateLimit parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (RateLimit) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static RateLimit parseFrom(InputStream inputStream) {
            return (RateLimit) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static RateLimit parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (RateLimit) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static RateLimit parseFrom(byte[] bArr) {
            return (RateLimit) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static RateLimit parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (RateLimit) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<RateLimit> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new RateLimit();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    this.limits_.makeImmutable();
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    this.limits_ = ((GeneratedMessageLite.Visitor) obj).visitMap(this.limits_, ((RateLimit) obj2).internalGetLimits());
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    boolean z = false;
                    while (!z) {
                        try {
                            try {
                                int readTag = codedInputStream.readTag();
                                if (readTag != 0) {
                                    if (readTag == 10) {
                                        if (!this.limits_.isMutable()) {
                                            this.limits_ = this.limits_.mutableCopy();
                                        }
                                        LimitsDefaultEntryHolder.a.parseInto(this.limits_, codedInputStream, extensionRegistryLite);
                                    } else if (!codedInputStream.skipField(readTag)) {
                                    }
                                }
                                z = true;
                            } catch (InvalidProtocolBufferException e) {
                                throw new RuntimeException(e.setUnfinishedMessage(this));
                            }
                        } catch (IOException e2) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (PARSER == null) {
                        synchronized (RateLimit.class) {
                            if (PARSER == null) {
                                PARSER = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            }
                        }
                    }
                    return PARSER;
                default:
                    throw new UnsupportedOperationException();
            }
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimitOrBuilder
        public boolean containsLimits(String str) {
            if (str != null) {
                return internalGetLimits().containsKey(str);
            }
            throw new NullPointerException();
        }

        @Override // com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimitOrBuilder
        @Deprecated
        public Map<String, Counter> getLimits() {
            return getLimitsMap();
        }

        @Override // com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimitOrBuilder
        public int getLimitsCount() {
            return internalGetLimits().size();
        }

        @Override // com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimitOrBuilder
        public Map<String, Counter> getLimitsMap() {
            return Collections.unmodifiableMap(internalGetLimits());
        }

        @Override // com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimitOrBuilder
        public Counter getLimitsOrDefault(String str, Counter counter) {
            if (str == null) {
                throw new NullPointerException();
            }
            MapFieldLite<String, Counter> internalGetLimits = internalGetLimits();
            return internalGetLimits.containsKey(str) ? internalGetLimits.get(str) : counter;
        }

        @Override // com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimitOrBuilder
        public Counter getLimitsOrThrow(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            MapFieldLite<String, Counter> internalGetLimits = internalGetLimits();
            if (internalGetLimits.containsKey(str)) {
                return internalGetLimits.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (Map.Entry<String, Counter> entry : internalGetLimits().entrySet()) {
                i2 += LimitsDefaultEntryHolder.a.computeMessageSize(1, entry.getKey(), entry.getValue());
            }
            this.c = i2;
            return i2;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            for (Map.Entry<String, Counter> entry : internalGetLimits().entrySet()) {
                LimitsDefaultEntryHolder.a.serializeTo(codedOutputStream, 1, entry.getKey(), entry.getValue());
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface RateLimitOrBuilder extends MessageLiteOrBuilder {
        boolean containsLimits(String str);

        @Deprecated
        Map<String, Counter> getLimits();

        int getLimitsCount();

        Map<String, Counter> getLimitsMap();

        Counter getLimitsOrDefault(String str, Counter counter);

        Counter getLimitsOrThrow(String str);
    }

    private RateLimitProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
