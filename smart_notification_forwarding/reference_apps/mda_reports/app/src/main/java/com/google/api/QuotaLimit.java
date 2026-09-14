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
public final class QuotaLimit extends GeneratedMessageLite<QuotaLimit, Builder> implements QuotaLimitOrBuilder {
    private static final QuotaLimit DEFAULT_INSTANCE = new QuotaLimit();
    public static final int DEFAULT_LIMIT_FIELD_NUMBER = 3;
    public static final int DESCRIPTION_FIELD_NUMBER = 2;
    public static final int DISPLAY_NAME_FIELD_NUMBER = 12;
    public static final int DURATION_FIELD_NUMBER = 5;
    public static final int FREE_TIER_FIELD_NUMBER = 7;
    public static final int MAX_LIMIT_FIELD_NUMBER = 4;
    public static final int METRIC_FIELD_NUMBER = 8;
    public static final int NAME_FIELD_NUMBER = 6;
    private static volatile Parser<QuotaLimit> PARSER = null;
    public static final int UNIT_FIELD_NUMBER = 9;
    public static final int VALUES_FIELD_NUMBER = 10;
    private int bitField0_;
    private long defaultLimit_;
    private long freeTier_;
    private long maxLimit_;
    private MapFieldLite<String, Long> values_ = MapFieldLite.emptyMapField();
    private String name_ = "";
    private String description_ = "";
    private String duration_ = "";
    private String metric_ = "";
    private String unit_ = "";
    private String displayName_ = "";

    /* renamed from: com.google.api.QuotaLimit$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<QuotaLimit, Builder> implements QuotaLimitOrBuilder {
        private Builder() {
            super(QuotaLimit.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearDefaultLimit() {
            a();
            ((QuotaLimit) this.a).clearDefaultLimit();
            return this;
        }

        public Builder clearDescription() {
            a();
            ((QuotaLimit) this.a).clearDescription();
            return this;
        }

        public Builder clearDisplayName() {
            a();
            ((QuotaLimit) this.a).clearDisplayName();
            return this;
        }

        public Builder clearDuration() {
            a();
            ((QuotaLimit) this.a).clearDuration();
            return this;
        }

        public Builder clearFreeTier() {
            a();
            ((QuotaLimit) this.a).clearFreeTier();
            return this;
        }

        public Builder clearMaxLimit() {
            a();
            ((QuotaLimit) this.a).clearMaxLimit();
            return this;
        }

        public Builder clearMetric() {
            a();
            ((QuotaLimit) this.a).clearMetric();
            return this;
        }

        public Builder clearName() {
            a();
            ((QuotaLimit) this.a).clearName();
            return this;
        }

        public Builder clearUnit() {
            a();
            ((QuotaLimit) this.a).clearUnit();
            return this;
        }

        public Builder clearValues() {
            a();
            ((QuotaLimit) this.a).getMutableValuesMap().clear();
            return this;
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public boolean containsValues(String str) {
            if (str != null) {
                return ((QuotaLimit) this.a).getValuesMap().containsKey(str);
            }
            throw new NullPointerException();
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public long getDefaultLimit() {
            return ((QuotaLimit) this.a).getDefaultLimit();
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public String getDescription() {
            return ((QuotaLimit) this.a).getDescription();
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public ByteString getDescriptionBytes() {
            return ((QuotaLimit) this.a).getDescriptionBytes();
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public String getDisplayName() {
            return ((QuotaLimit) this.a).getDisplayName();
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public ByteString getDisplayNameBytes() {
            return ((QuotaLimit) this.a).getDisplayNameBytes();
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public String getDuration() {
            return ((QuotaLimit) this.a).getDuration();
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public ByteString getDurationBytes() {
            return ((QuotaLimit) this.a).getDurationBytes();
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public long getFreeTier() {
            return ((QuotaLimit) this.a).getFreeTier();
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public long getMaxLimit() {
            return ((QuotaLimit) this.a).getMaxLimit();
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public String getMetric() {
            return ((QuotaLimit) this.a).getMetric();
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public ByteString getMetricBytes() {
            return ((QuotaLimit) this.a).getMetricBytes();
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public String getName() {
            return ((QuotaLimit) this.a).getName();
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public ByteString getNameBytes() {
            return ((QuotaLimit) this.a).getNameBytes();
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public String getUnit() {
            return ((QuotaLimit) this.a).getUnit();
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public ByteString getUnitBytes() {
            return ((QuotaLimit) this.a).getUnitBytes();
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        @Deprecated
        public Map<String, Long> getValues() {
            return getValuesMap();
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public int getValuesCount() {
            return ((QuotaLimit) this.a).getValuesMap().size();
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public Map<String, Long> getValuesMap() {
            return Collections.unmodifiableMap(((QuotaLimit) this.a).getValuesMap());
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public long getValuesOrDefault(String str, long j) {
            if (str == null) {
                throw new NullPointerException();
            }
            Map<String, Long> valuesMap = ((QuotaLimit) this.a).getValuesMap();
            return valuesMap.containsKey(str) ? valuesMap.get(str).longValue() : j;
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public long getValuesOrThrow(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            Map<String, Long> valuesMap = ((QuotaLimit) this.a).getValuesMap();
            if (valuesMap.containsKey(str)) {
                return valuesMap.get(str).longValue();
            }
            throw new IllegalArgumentException();
        }

        public Builder putAllValues(Map<String, Long> map) {
            a();
            ((QuotaLimit) this.a).getMutableValuesMap().putAll(map);
            return this;
        }

        public Builder putValues(String str, long j) {
            if (str == null) {
                throw new NullPointerException();
            }
            a();
            ((QuotaLimit) this.a).getMutableValuesMap().put(str, Long.valueOf(j));
            return this;
        }

        public Builder removeValues(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            a();
            ((QuotaLimit) this.a).getMutableValuesMap().remove(str);
            return this;
        }

        public Builder setDefaultLimit(long j) {
            a();
            ((QuotaLimit) this.a).setDefaultLimit(j);
            return this;
        }

        public Builder setDescription(String str) {
            a();
            ((QuotaLimit) this.a).setDescription(str);
            return this;
        }

        public Builder setDescriptionBytes(ByteString byteString) {
            a();
            ((QuotaLimit) this.a).setDescriptionBytes(byteString);
            return this;
        }

        public Builder setDisplayName(String str) {
            a();
            ((QuotaLimit) this.a).setDisplayName(str);
            return this;
        }

        public Builder setDisplayNameBytes(ByteString byteString) {
            a();
            ((QuotaLimit) this.a).setDisplayNameBytes(byteString);
            return this;
        }

        public Builder setDuration(String str) {
            a();
            ((QuotaLimit) this.a).setDuration(str);
            return this;
        }

        public Builder setDurationBytes(ByteString byteString) {
            a();
            ((QuotaLimit) this.a).setDurationBytes(byteString);
            return this;
        }

        public Builder setFreeTier(long j) {
            a();
            ((QuotaLimit) this.a).setFreeTier(j);
            return this;
        }

        public Builder setMaxLimit(long j) {
            a();
            ((QuotaLimit) this.a).setMaxLimit(j);
            return this;
        }

        public Builder setMetric(String str) {
            a();
            ((QuotaLimit) this.a).setMetric(str);
            return this;
        }

        public Builder setMetricBytes(ByteString byteString) {
            a();
            ((QuotaLimit) this.a).setMetricBytes(byteString);
            return this;
        }

        public Builder setName(String str) {
            a();
            ((QuotaLimit) this.a).setName(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            a();
            ((QuotaLimit) this.a).setNameBytes(byteString);
            return this;
        }

        public Builder setUnit(String str) {
            a();
            ((QuotaLimit) this.a).setUnit(str);
            return this;
        }

        public Builder setUnitBytes(ByteString byteString) {
            a();
            ((QuotaLimit) this.a).setUnitBytes(byteString);
            return this;
        }
    }

    /* loaded from: classes2.dex */
    private static final class ValuesDefaultEntryHolder {
        static final MapEntryLite<String, Long> a = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.INT64, 0L);

        private ValuesDefaultEntryHolder() {
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private QuotaLimit() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDefaultLimit() {
        this.defaultLimit_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDisplayName() {
        this.displayName_ = getDefaultInstance().getDisplayName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDuration() {
        this.duration_ = getDefaultInstance().getDuration();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFreeTier() {
        this.freeTier_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMaxLimit() {
        this.maxLimit_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMetric() {
        this.metric_ = getDefaultInstance().getMetric();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUnit() {
        this.unit_ = getDefaultInstance().getUnit();
    }

    public static QuotaLimit getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Long> getMutableValuesMap() {
        return internalGetMutableValues();
    }

    private MapFieldLite<String, Long> internalGetMutableValues() {
        if (!this.values_.isMutable()) {
            this.values_ = this.values_.mutableCopy();
        }
        return this.values_;
    }

    private MapFieldLite<String, Long> internalGetValues() {
        return this.values_;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(QuotaLimit quotaLimit) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) quotaLimit);
    }

    public static QuotaLimit parseDelimitedFrom(InputStream inputStream) {
        return (QuotaLimit) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static QuotaLimit parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (QuotaLimit) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static QuotaLimit parseFrom(ByteString byteString) {
        return (QuotaLimit) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static QuotaLimit parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (QuotaLimit) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static QuotaLimit parseFrom(CodedInputStream codedInputStream) {
        return (QuotaLimit) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static QuotaLimit parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (QuotaLimit) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static QuotaLimit parseFrom(InputStream inputStream) {
        return (QuotaLimit) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static QuotaLimit parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (QuotaLimit) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static QuotaLimit parseFrom(byte[] bArr) {
        return (QuotaLimit) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static QuotaLimit parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (QuotaLimit) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<QuotaLimit> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDefaultLimit(long j) {
        this.defaultLimit_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDescription(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.description_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDescriptionBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.description_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisplayName(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.displayName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisplayNameBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.displayName_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDuration(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.duration_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDurationBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.duration_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFreeTier(long j) {
        this.freeTier_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaxLimit(long j) {
        this.maxLimit_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetric(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.metric_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetricBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.metric_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setName(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNameBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.name_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUnit(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.unit_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUnitBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.unit_ = byteString.toStringUtf8();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:26:0x003a. Please report as an issue. */
    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        boolean z = false;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new QuotaLimit();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.values_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                QuotaLimit quotaLimit = (QuotaLimit) obj2;
                this.name_ = visitor.visitString(!this.name_.isEmpty(), this.name_, !quotaLimit.name_.isEmpty(), quotaLimit.name_);
                this.description_ = visitor.visitString(!this.description_.isEmpty(), this.description_, !quotaLimit.description_.isEmpty(), quotaLimit.description_);
                this.defaultLimit_ = visitor.visitLong(this.defaultLimit_ != 0, this.defaultLimit_, quotaLimit.defaultLimit_ != 0, quotaLimit.defaultLimit_);
                this.maxLimit_ = visitor.visitLong(this.maxLimit_ != 0, this.maxLimit_, quotaLimit.maxLimit_ != 0, quotaLimit.maxLimit_);
                this.freeTier_ = visitor.visitLong(this.freeTier_ != 0, this.freeTier_, quotaLimit.freeTier_ != 0, quotaLimit.freeTier_);
                this.duration_ = visitor.visitString(!this.duration_.isEmpty(), this.duration_, !quotaLimit.duration_.isEmpty(), quotaLimit.duration_);
                this.metric_ = visitor.visitString(!this.metric_.isEmpty(), this.metric_, !quotaLimit.metric_.isEmpty(), quotaLimit.metric_);
                this.unit_ = visitor.visitString(!this.unit_.isEmpty(), this.unit_, !quotaLimit.unit_.isEmpty(), quotaLimit.unit_);
                this.values_ = visitor.visitMap(this.values_, quotaLimit.internalGetValues());
                this.displayName_ = visitor.visitString(!this.displayName_.isEmpty(), this.displayName_, !quotaLimit.displayName_.isEmpty(), quotaLimit.displayName_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= quotaLimit.bitField0_;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        switch (readTag) {
                            case 0:
                                z = true;
                            case 18:
                                this.description_ = codedInputStream.readStringRequireUtf8();
                            case 24:
                                this.defaultLimit_ = codedInputStream.readInt64();
                            case 32:
                                this.maxLimit_ = codedInputStream.readInt64();
                            case 42:
                                this.duration_ = codedInputStream.readStringRequireUtf8();
                            case 50:
                                this.name_ = codedInputStream.readStringRequireUtf8();
                            case 56:
                                this.freeTier_ = codedInputStream.readInt64();
                            case 66:
                                this.metric_ = codedInputStream.readStringRequireUtf8();
                            case 74:
                                this.unit_ = codedInputStream.readStringRequireUtf8();
                            case 82:
                                if (!this.values_.isMutable()) {
                                    this.values_ = this.values_.mutableCopy();
                                }
                                ValuesDefaultEntryHolder.a.parseInto(this.values_, codedInputStream, extensionRegistryLite);
                            case 98:
                                this.displayName_ = codedInputStream.readStringRequireUtf8();
                            default:
                                if (!codedInputStream.skipField(readTag)) {
                                    z = true;
                                }
                        }
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
                    synchronized (QuotaLimit.class) {
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

    @Override // com.google.api.QuotaLimitOrBuilder
    public boolean containsValues(String str) {
        if (str != null) {
            return internalGetValues().containsKey(str);
        }
        throw new NullPointerException();
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public long getDefaultLimit() {
        return this.defaultLimit_;
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public String getDescription() {
        return this.description_;
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public ByteString getDescriptionBytes() {
        return ByteString.copyFromUtf8(this.description_);
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public String getDisplayName() {
        return this.displayName_;
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public ByteString getDisplayNameBytes() {
        return ByteString.copyFromUtf8(this.displayName_);
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public String getDuration() {
        return this.duration_;
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public ByteString getDurationBytes() {
        return ByteString.copyFromUtf8(this.duration_);
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public long getFreeTier() {
        return this.freeTier_;
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public long getMaxLimit() {
        return this.maxLimit_;
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public String getMetric() {
        return this.metric_;
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public ByteString getMetricBytes() {
        return ByteString.copyFromUtf8(this.metric_);
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeStringSize = this.description_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(2, getDescription());
        long j = this.defaultLimit_;
        if (j != 0) {
            computeStringSize += CodedOutputStream.computeInt64Size(3, j);
        }
        long j2 = this.maxLimit_;
        if (j2 != 0) {
            computeStringSize += CodedOutputStream.computeInt64Size(4, j2);
        }
        if (!this.duration_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(5, getDuration());
        }
        if (!this.name_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(6, getName());
        }
        long j3 = this.freeTier_;
        if (j3 != 0) {
            computeStringSize += CodedOutputStream.computeInt64Size(7, j3);
        }
        if (!this.metric_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(8, getMetric());
        }
        if (!this.unit_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(9, getUnit());
        }
        for (Map.Entry<String, Long> entry : internalGetValues().entrySet()) {
            computeStringSize += ValuesDefaultEntryHolder.a.computeMessageSize(10, entry.getKey(), entry.getValue());
        }
        if (!this.displayName_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(12, getDisplayName());
        }
        this.c = computeStringSize;
        return computeStringSize;
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public String getUnit() {
        return this.unit_;
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public ByteString getUnitBytes() {
        return ByteString.copyFromUtf8(this.unit_);
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    @Deprecated
    public Map<String, Long> getValues() {
        return getValuesMap();
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public int getValuesCount() {
        return internalGetValues().size();
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public Map<String, Long> getValuesMap() {
        return Collections.unmodifiableMap(internalGetValues());
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public long getValuesOrDefault(String str, long j) {
        if (str == null) {
            throw new NullPointerException();
        }
        MapFieldLite<String, Long> internalGetValues = internalGetValues();
        return internalGetValues.containsKey(str) ? internalGetValues.get(str).longValue() : j;
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public long getValuesOrThrow(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        MapFieldLite<String, Long> internalGetValues = internalGetValues();
        if (internalGetValues.containsKey(str)) {
            return internalGetValues.get(str).longValue();
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!this.description_.isEmpty()) {
            codedOutputStream.writeString(2, getDescription());
        }
        long j = this.defaultLimit_;
        if (j != 0) {
            codedOutputStream.writeInt64(3, j);
        }
        long j2 = this.maxLimit_;
        if (j2 != 0) {
            codedOutputStream.writeInt64(4, j2);
        }
        if (!this.duration_.isEmpty()) {
            codedOutputStream.writeString(5, getDuration());
        }
        if (!this.name_.isEmpty()) {
            codedOutputStream.writeString(6, getName());
        }
        long j3 = this.freeTier_;
        if (j3 != 0) {
            codedOutputStream.writeInt64(7, j3);
        }
        if (!this.metric_.isEmpty()) {
            codedOutputStream.writeString(8, getMetric());
        }
        if (!this.unit_.isEmpty()) {
            codedOutputStream.writeString(9, getUnit());
        }
        for (Map.Entry<String, Long> entry : internalGetValues().entrySet()) {
            ValuesDefaultEntryHolder.a.serializeTo(codedOutputStream, 10, entry.getKey(), entry.getValue());
        }
        if (this.displayName_.isEmpty()) {
            return;
        }
        codedOutputStream.writeString(12, getDisplayName());
    }
}
