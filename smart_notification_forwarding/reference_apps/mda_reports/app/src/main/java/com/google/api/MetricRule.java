package com.google.api;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public final class MetricRule extends GeneratedMessageLite<MetricRule, Builder> implements MetricRuleOrBuilder {
    private static final MetricRule DEFAULT_INSTANCE = new MetricRule();
    public static final int METRIC_COSTS_FIELD_NUMBER = 2;
    private static volatile Parser<MetricRule> PARSER = null;
    public static final int SELECTOR_FIELD_NUMBER = 1;
    private int bitField0_;
    private MapFieldLite<String, Long> metricCosts_ = MapFieldLite.emptyMapField();
    private String selector_ = "";

    /* renamed from: com.google.api.MetricRule$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<MetricRule, Builder> implements MetricRuleOrBuilder {
        private Builder() {
            super(MetricRule.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearMetricCosts() {
            a();
            ((MetricRule) this.a).getMutableMetricCostsMap().clear();
            return this;
        }

        public Builder clearSelector() {
            a();
            ((MetricRule) this.a).clearSelector();
            return this;
        }

        @Override // com.google.api.MetricRuleOrBuilder
        public boolean containsMetricCosts(String str) {
            if (str != null) {
                return ((MetricRule) this.a).getMetricCostsMap().containsKey(str);
            }
            throw new NullPointerException();
        }

        @Override // com.google.api.MetricRuleOrBuilder
        @Deprecated
        public Map<String, Long> getMetricCosts() {
            return getMetricCostsMap();
        }

        @Override // com.google.api.MetricRuleOrBuilder
        public int getMetricCostsCount() {
            return ((MetricRule) this.a).getMetricCostsMap().size();
        }

        @Override // com.google.api.MetricRuleOrBuilder
        public Map<String, Long> getMetricCostsMap() {
            return Collections.unmodifiableMap(((MetricRule) this.a).getMetricCostsMap());
        }

        @Override // com.google.api.MetricRuleOrBuilder
        public long getMetricCostsOrDefault(String str, long j) {
            if (str == null) {
                throw new NullPointerException();
            }
            Map<String, Long> metricCostsMap = ((MetricRule) this.a).getMetricCostsMap();
            return metricCostsMap.containsKey(str) ? metricCostsMap.get(str).longValue() : j;
        }

        @Override // com.google.api.MetricRuleOrBuilder
        public long getMetricCostsOrThrow(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            Map<String, Long> metricCostsMap = ((MetricRule) this.a).getMetricCostsMap();
            if (metricCostsMap.containsKey(str)) {
                return metricCostsMap.get(str).longValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // com.google.api.MetricRuleOrBuilder
        public String getSelector() {
            return ((MetricRule) this.a).getSelector();
        }

        @Override // com.google.api.MetricRuleOrBuilder
        public ByteString getSelectorBytes() {
            return ((MetricRule) this.a).getSelectorBytes();
        }

        public Builder putAllMetricCosts(Map<String, Long> map) {
            a();
            ((MetricRule) this.a).getMutableMetricCostsMap().putAll(map);
            return this;
        }

        public Builder putMetricCosts(String str, long j) {
            if (str == null) {
                throw new NullPointerException();
            }
            a();
            ((MetricRule) this.a).getMutableMetricCostsMap().put(str, Long.valueOf(j));
            return this;
        }

        public Builder removeMetricCosts(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            a();
            ((MetricRule) this.a).getMutableMetricCostsMap().remove(str);
            return this;
        }

        public Builder setSelector(String str) {
            a();
            ((MetricRule) this.a).setSelector(str);
            return this;
        }

        public Builder setSelectorBytes(ByteString byteString) {
            a();
            ((MetricRule) this.a).setSelectorBytes(byteString);
            return this;
        }
    }

    /* loaded from: classes2.dex */
    private static final class MetricCostsDefaultEntryHolder {
        static final MapEntryLite<String, Long> a = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.INT64, 0L);

        private MetricCostsDefaultEntryHolder() {
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private MetricRule() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSelector() {
        this.selector_ = getDefaultInstance().getSelector();
    }

    public static MetricRule getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Long> getMutableMetricCostsMap() {
        return internalGetMutableMetricCosts();
    }

    private MapFieldLite<String, Long> internalGetMetricCosts() {
        return this.metricCosts_;
    }

    private MapFieldLite<String, Long> internalGetMutableMetricCosts() {
        if (!this.metricCosts_.isMutable()) {
            this.metricCosts_ = this.metricCosts_.mutableCopy();
        }
        return this.metricCosts_;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(MetricRule metricRule) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) metricRule);
    }

    public static MetricRule parseDelimitedFrom(InputStream inputStream) {
        return (MetricRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static MetricRule parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MetricRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MetricRule parseFrom(ByteString byteString) {
        return (MetricRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static MetricRule parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MetricRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MetricRule parseFrom(CodedInputStream codedInputStream) {
        return (MetricRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MetricRule parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MetricRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static MetricRule parseFrom(InputStream inputStream) {
        return (MetricRule) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static MetricRule parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MetricRule) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MetricRule parseFrom(byte[] bArr) {
        return (MetricRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static MetricRule parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MetricRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<MetricRule> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSelector(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.selector_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSelectorBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.selector_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new MetricRule();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.metricCosts_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                MetricRule metricRule = (MetricRule) obj2;
                this.selector_ = visitor.visitString(!this.selector_.isEmpty(), this.selector_, true ^ metricRule.selector_.isEmpty(), metricRule.selector_);
                this.metricCosts_ = visitor.visitMap(this.metricCosts_, metricRule.internalGetMetricCosts());
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= metricRule.bitField0_;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                boolean z = false;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.selector_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                if (!this.metricCosts_.isMutable()) {
                                    this.metricCosts_ = this.metricCosts_.mutableCopy();
                                }
                                MetricCostsDefaultEntryHolder.a.parseInto(this.metricCosts_, codedInputStream, extensionRegistryLite);
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
                    synchronized (MetricRule.class) {
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

    @Override // com.google.api.MetricRuleOrBuilder
    public boolean containsMetricCosts(String str) {
        if (str != null) {
            return internalGetMetricCosts().containsKey(str);
        }
        throw new NullPointerException();
    }

    @Override // com.google.api.MetricRuleOrBuilder
    @Deprecated
    public Map<String, Long> getMetricCosts() {
        return getMetricCostsMap();
    }

    @Override // com.google.api.MetricRuleOrBuilder
    public int getMetricCostsCount() {
        return internalGetMetricCosts().size();
    }

    @Override // com.google.api.MetricRuleOrBuilder
    public Map<String, Long> getMetricCostsMap() {
        return Collections.unmodifiableMap(internalGetMetricCosts());
    }

    @Override // com.google.api.MetricRuleOrBuilder
    public long getMetricCostsOrDefault(String str, long j) {
        if (str == null) {
            throw new NullPointerException();
        }
        MapFieldLite<String, Long> internalGetMetricCosts = internalGetMetricCosts();
        return internalGetMetricCosts.containsKey(str) ? internalGetMetricCosts.get(str).longValue() : j;
    }

    @Override // com.google.api.MetricRuleOrBuilder
    public long getMetricCostsOrThrow(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        MapFieldLite<String, Long> internalGetMetricCosts = internalGetMetricCosts();
        if (internalGetMetricCosts.containsKey(str)) {
            return internalGetMetricCosts.get(str).longValue();
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.api.MetricRuleOrBuilder
    public String getSelector() {
        return this.selector_;
    }

    @Override // com.google.api.MetricRuleOrBuilder
    public ByteString getSelectorBytes() {
        return ByteString.copyFromUtf8(this.selector_);
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeStringSize = this.selector_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getSelector());
        for (Map.Entry<String, Long> entry : internalGetMetricCosts().entrySet()) {
            computeStringSize += MetricCostsDefaultEntryHolder.a.computeMessageSize(2, entry.getKey(), entry.getValue());
        }
        this.c = computeStringSize;
        return computeStringSize;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!this.selector_.isEmpty()) {
            codedOutputStream.writeString(1, getSelector());
        }
        for (Map.Entry<String, Long> entry : internalGetMetricCosts().entrySet()) {
            MetricCostsDefaultEntryHolder.a.serializeTo(codedOutputStream, 2, entry.getKey(), entry.getValue());
        }
    }
}
