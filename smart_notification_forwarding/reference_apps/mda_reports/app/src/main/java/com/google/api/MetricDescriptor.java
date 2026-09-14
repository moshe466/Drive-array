package com.google.api;

import com.google.api.LabelDescriptor;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class MetricDescriptor extends GeneratedMessageLite<MetricDescriptor, Builder> implements MetricDescriptorOrBuilder {
    private static final MetricDescriptor DEFAULT_INSTANCE = new MetricDescriptor();
    public static final int DESCRIPTION_FIELD_NUMBER = 6;
    public static final int DISPLAY_NAME_FIELD_NUMBER = 7;
    public static final int LABELS_FIELD_NUMBER = 2;
    public static final int METRIC_KIND_FIELD_NUMBER = 3;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<MetricDescriptor> PARSER = null;
    public static final int TYPE_FIELD_NUMBER = 8;
    public static final int UNIT_FIELD_NUMBER = 5;
    public static final int VALUE_TYPE_FIELD_NUMBER = 4;
    private int bitField0_;
    private int metricKind_;
    private int valueType_;
    private String name_ = "";
    private String type_ = "";
    private Internal.ProtobufList<LabelDescriptor> labels_ = GeneratedMessageLite.f();
    private String unit_ = "";
    private String description_ = "";
    private String displayName_ = "";

    /* renamed from: com.google.api.MetricDescriptor$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<MetricDescriptor, Builder> implements MetricDescriptorOrBuilder {
        private Builder() {
            super(MetricDescriptor.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllLabels(Iterable<? extends LabelDescriptor> iterable) {
            a();
            ((MetricDescriptor) this.a).addAllLabels(iterable);
            return this;
        }

        public Builder addLabels(int i, LabelDescriptor.Builder builder) {
            a();
            ((MetricDescriptor) this.a).addLabels(i, builder);
            return this;
        }

        public Builder addLabels(int i, LabelDescriptor labelDescriptor) {
            a();
            ((MetricDescriptor) this.a).addLabels(i, labelDescriptor);
            return this;
        }

        public Builder addLabels(LabelDescriptor.Builder builder) {
            a();
            ((MetricDescriptor) this.a).addLabels(builder);
            return this;
        }

        public Builder addLabels(LabelDescriptor labelDescriptor) {
            a();
            ((MetricDescriptor) this.a).addLabels(labelDescriptor);
            return this;
        }

        public Builder clearDescription() {
            a();
            ((MetricDescriptor) this.a).clearDescription();
            return this;
        }

        public Builder clearDisplayName() {
            a();
            ((MetricDescriptor) this.a).clearDisplayName();
            return this;
        }

        public Builder clearLabels() {
            a();
            ((MetricDescriptor) this.a).clearLabels();
            return this;
        }

        public Builder clearMetricKind() {
            a();
            ((MetricDescriptor) this.a).clearMetricKind();
            return this;
        }

        public Builder clearName() {
            a();
            ((MetricDescriptor) this.a).clearName();
            return this;
        }

        public Builder clearType() {
            a();
            ((MetricDescriptor) this.a).clearType();
            return this;
        }

        public Builder clearUnit() {
            a();
            ((MetricDescriptor) this.a).clearUnit();
            return this;
        }

        public Builder clearValueType() {
            a();
            ((MetricDescriptor) this.a).clearValueType();
            return this;
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public String getDescription() {
            return ((MetricDescriptor) this.a).getDescription();
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public ByteString getDescriptionBytes() {
            return ((MetricDescriptor) this.a).getDescriptionBytes();
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public String getDisplayName() {
            return ((MetricDescriptor) this.a).getDisplayName();
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public ByteString getDisplayNameBytes() {
            return ((MetricDescriptor) this.a).getDisplayNameBytes();
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public LabelDescriptor getLabels(int i) {
            return ((MetricDescriptor) this.a).getLabels(i);
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public int getLabelsCount() {
            return ((MetricDescriptor) this.a).getLabelsCount();
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public List<LabelDescriptor> getLabelsList() {
            return Collections.unmodifiableList(((MetricDescriptor) this.a).getLabelsList());
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public MetricKind getMetricKind() {
            return ((MetricDescriptor) this.a).getMetricKind();
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public int getMetricKindValue() {
            return ((MetricDescriptor) this.a).getMetricKindValue();
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public String getName() {
            return ((MetricDescriptor) this.a).getName();
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public ByteString getNameBytes() {
            return ((MetricDescriptor) this.a).getNameBytes();
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public String getType() {
            return ((MetricDescriptor) this.a).getType();
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public ByteString getTypeBytes() {
            return ((MetricDescriptor) this.a).getTypeBytes();
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public String getUnit() {
            return ((MetricDescriptor) this.a).getUnit();
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public ByteString getUnitBytes() {
            return ((MetricDescriptor) this.a).getUnitBytes();
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public ValueType getValueType() {
            return ((MetricDescriptor) this.a).getValueType();
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public int getValueTypeValue() {
            return ((MetricDescriptor) this.a).getValueTypeValue();
        }

        public Builder removeLabels(int i) {
            a();
            ((MetricDescriptor) this.a).removeLabels(i);
            return this;
        }

        public Builder setDescription(String str) {
            a();
            ((MetricDescriptor) this.a).setDescription(str);
            return this;
        }

        public Builder setDescriptionBytes(ByteString byteString) {
            a();
            ((MetricDescriptor) this.a).setDescriptionBytes(byteString);
            return this;
        }

        public Builder setDisplayName(String str) {
            a();
            ((MetricDescriptor) this.a).setDisplayName(str);
            return this;
        }

        public Builder setDisplayNameBytes(ByteString byteString) {
            a();
            ((MetricDescriptor) this.a).setDisplayNameBytes(byteString);
            return this;
        }

        public Builder setLabels(int i, LabelDescriptor.Builder builder) {
            a();
            ((MetricDescriptor) this.a).setLabels(i, builder);
            return this;
        }

        public Builder setLabels(int i, LabelDescriptor labelDescriptor) {
            a();
            ((MetricDescriptor) this.a).setLabels(i, labelDescriptor);
            return this;
        }

        public Builder setMetricKind(MetricKind metricKind) {
            a();
            ((MetricDescriptor) this.a).setMetricKind(metricKind);
            return this;
        }

        public Builder setMetricKindValue(int i) {
            a();
            ((MetricDescriptor) this.a).setMetricKindValue(i);
            return this;
        }

        public Builder setName(String str) {
            a();
            ((MetricDescriptor) this.a).setName(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            a();
            ((MetricDescriptor) this.a).setNameBytes(byteString);
            return this;
        }

        public Builder setType(String str) {
            a();
            ((MetricDescriptor) this.a).setType(str);
            return this;
        }

        public Builder setTypeBytes(ByteString byteString) {
            a();
            ((MetricDescriptor) this.a).setTypeBytes(byteString);
            return this;
        }

        public Builder setUnit(String str) {
            a();
            ((MetricDescriptor) this.a).setUnit(str);
            return this;
        }

        public Builder setUnitBytes(ByteString byteString) {
            a();
            ((MetricDescriptor) this.a).setUnitBytes(byteString);
            return this;
        }

        public Builder setValueType(ValueType valueType) {
            a();
            ((MetricDescriptor) this.a).setValueType(valueType);
            return this;
        }

        public Builder setValueTypeValue(int i) {
            a();
            ((MetricDescriptor) this.a).setValueTypeValue(i);
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public enum MetricKind implements Internal.EnumLite {
        METRIC_KIND_UNSPECIFIED(0),
        GAUGE(1),
        DELTA(2),
        CUMULATIVE(3),
        UNRECOGNIZED(-1);

        public static final int CUMULATIVE_VALUE = 3;
        public static final int DELTA_VALUE = 2;
        public static final int GAUGE_VALUE = 1;
        public static final int METRIC_KIND_UNSPECIFIED_VALUE = 0;
        private static final Internal.EnumLiteMap<MetricKind> internalValueMap = new Internal.EnumLiteMap<MetricKind>() { // from class: com.google.api.MetricDescriptor.MetricKind.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public MetricKind findValueByNumber(int i) {
                return MetricKind.forNumber(i);
            }
        };
        private final int value;

        MetricKind(int i) {
            this.value = i;
        }

        public static MetricKind forNumber(int i) {
            if (i == 0) {
                return METRIC_KIND_UNSPECIFIED;
            }
            if (i == 1) {
                return GAUGE;
            }
            if (i == 2) {
                return DELTA;
            }
            if (i != 3) {
                return null;
            }
            return CUMULATIVE;
        }

        public static Internal.EnumLiteMap<MetricKind> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static MetricKind valueOf(int i) {
            return forNumber(i);
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }
    }

    /* loaded from: classes2.dex */
    public enum ValueType implements Internal.EnumLite {
        VALUE_TYPE_UNSPECIFIED(0),
        BOOL(1),
        INT64(2),
        DOUBLE(3),
        STRING(4),
        DISTRIBUTION(5),
        MONEY(6),
        UNRECOGNIZED(-1);

        public static final int BOOL_VALUE = 1;
        public static final int DISTRIBUTION_VALUE = 5;
        public static final int DOUBLE_VALUE = 3;
        public static final int INT64_VALUE = 2;
        public static final int MONEY_VALUE = 6;
        public static final int STRING_VALUE = 4;
        public static final int VALUE_TYPE_UNSPECIFIED_VALUE = 0;
        private static final Internal.EnumLiteMap<ValueType> internalValueMap = new Internal.EnumLiteMap<ValueType>() { // from class: com.google.api.MetricDescriptor.ValueType.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public ValueType findValueByNumber(int i) {
                return ValueType.forNumber(i);
            }
        };
        private final int value;

        ValueType(int i) {
            this.value = i;
        }

        public static ValueType forNumber(int i) {
            switch (i) {
                case 0:
                    return VALUE_TYPE_UNSPECIFIED;
                case 1:
                    return BOOL;
                case 2:
                    return INT64;
                case 3:
                    return DOUBLE;
                case 4:
                    return STRING;
                case 5:
                    return DISTRIBUTION;
                case 6:
                    return MONEY;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<ValueType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static ValueType valueOf(int i) {
            return forNumber(i);
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private MetricDescriptor() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllLabels(Iterable<? extends LabelDescriptor> iterable) {
        ensureLabelsIsMutable();
        AbstractMessageLite.a(iterable, this.labels_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLabels(int i, LabelDescriptor.Builder builder) {
        ensureLabelsIsMutable();
        this.labels_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLabels(int i, LabelDescriptor labelDescriptor) {
        if (labelDescriptor == null) {
            throw new NullPointerException();
        }
        ensureLabelsIsMutable();
        this.labels_.add(i, labelDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLabels(LabelDescriptor.Builder builder) {
        ensureLabelsIsMutable();
        this.labels_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLabels(LabelDescriptor labelDescriptor) {
        if (labelDescriptor == null) {
            throw new NullPointerException();
        }
        ensureLabelsIsMutable();
        this.labels_.add(labelDescriptor);
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
    public void clearLabels() {
        this.labels_ = GeneratedMessageLite.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMetricKind() {
        this.metricKind_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearType() {
        this.type_ = getDefaultInstance().getType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUnit() {
        this.unit_ = getDefaultInstance().getUnit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearValueType() {
        this.valueType_ = 0;
    }

    private void ensureLabelsIsMutable() {
        if (this.labels_.isModifiable()) {
            return;
        }
        this.labels_ = GeneratedMessageLite.a(this.labels_);
    }

    public static MetricDescriptor getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(MetricDescriptor metricDescriptor) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) metricDescriptor);
    }

    public static MetricDescriptor parseDelimitedFrom(InputStream inputStream) {
        return (MetricDescriptor) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static MetricDescriptor parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MetricDescriptor) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MetricDescriptor parseFrom(ByteString byteString) {
        return (MetricDescriptor) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static MetricDescriptor parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MetricDescriptor) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MetricDescriptor parseFrom(CodedInputStream codedInputStream) {
        return (MetricDescriptor) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MetricDescriptor parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MetricDescriptor) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static MetricDescriptor parseFrom(InputStream inputStream) {
        return (MetricDescriptor) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static MetricDescriptor parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MetricDescriptor) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MetricDescriptor parseFrom(byte[] bArr) {
        return (MetricDescriptor) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static MetricDescriptor parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MetricDescriptor) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<MetricDescriptor> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeLabels(int i) {
        ensureLabelsIsMutable();
        this.labels_.remove(i);
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
    public void setLabels(int i, LabelDescriptor.Builder builder) {
        ensureLabelsIsMutable();
        this.labels_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLabels(int i, LabelDescriptor labelDescriptor) {
        if (labelDescriptor == null) {
            throw new NullPointerException();
        }
        ensureLabelsIsMutable();
        this.labels_.set(i, labelDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetricKind(MetricKind metricKind) {
        if (metricKind == null) {
            throw new NullPointerException();
        }
        this.metricKind_ = metricKind.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetricKindValue(int i) {
        this.metricKind_ = i;
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
    public void setType(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.type_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTypeBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.type_ = byteString.toStringUtf8();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void setValueType(ValueType valueType) {
        if (valueType == null) {
            throw new NullPointerException();
        }
        this.valueType_ = valueType.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValueTypeValue(int i) {
        this.valueType_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new MetricDescriptor();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.labels_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                MetricDescriptor metricDescriptor = (MetricDescriptor) obj2;
                this.name_ = visitor.visitString(!this.name_.isEmpty(), this.name_, !metricDescriptor.name_.isEmpty(), metricDescriptor.name_);
                this.type_ = visitor.visitString(!this.type_.isEmpty(), this.type_, !metricDescriptor.type_.isEmpty(), metricDescriptor.type_);
                this.labels_ = visitor.visitList(this.labels_, metricDescriptor.labels_);
                this.metricKind_ = visitor.visitInt(this.metricKind_ != 0, this.metricKind_, metricDescriptor.metricKind_ != 0, metricDescriptor.metricKind_);
                this.valueType_ = visitor.visitInt(this.valueType_ != 0, this.valueType_, metricDescriptor.valueType_ != 0, metricDescriptor.valueType_);
                this.unit_ = visitor.visitString(!this.unit_.isEmpty(), this.unit_, !metricDescriptor.unit_.isEmpty(), metricDescriptor.unit_);
                this.description_ = visitor.visitString(!this.description_.isEmpty(), this.description_, !metricDescriptor.description_.isEmpty(), metricDescriptor.description_);
                this.displayName_ = visitor.visitString(!this.displayName_.isEmpty(), this.displayName_, !metricDescriptor.displayName_.isEmpty(), metricDescriptor.displayName_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= metricDescriptor.bitField0_;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!r1) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.name_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                if (!this.labels_.isModifiable()) {
                                    this.labels_ = GeneratedMessageLite.a(this.labels_);
                                }
                                this.labels_.add((LabelDescriptor) codedInputStream.readMessage(LabelDescriptor.parser(), extensionRegistryLite));
                            } else if (readTag == 24) {
                                this.metricKind_ = codedInputStream.readEnum();
                            } else if (readTag == 32) {
                                this.valueType_ = codedInputStream.readEnum();
                            } else if (readTag == 42) {
                                this.unit_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 50) {
                                this.description_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 58) {
                                this.displayName_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 66) {
                                this.type_ = codedInputStream.readStringRequireUtf8();
                            } else if (!codedInputStream.skipField(readTag)) {
                            }
                        }
                        r1 = true;
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
                    synchronized (MetricDescriptor.class) {
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

    @Override // com.google.api.MetricDescriptorOrBuilder
    public String getDescription() {
        return this.description_;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public ByteString getDescriptionBytes() {
        return ByteString.copyFromUtf8(this.description_);
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public String getDisplayName() {
        return this.displayName_;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public ByteString getDisplayNameBytes() {
        return ByteString.copyFromUtf8(this.displayName_);
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public LabelDescriptor getLabels(int i) {
        return this.labels_.get(i);
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public int getLabelsCount() {
        return this.labels_.size();
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public List<LabelDescriptor> getLabelsList() {
        return this.labels_;
    }

    public LabelDescriptorOrBuilder getLabelsOrBuilder(int i) {
        return this.labels_.get(i);
    }

    public List<? extends LabelDescriptorOrBuilder> getLabelsOrBuilderList() {
        return this.labels_;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public MetricKind getMetricKind() {
        MetricKind forNumber = MetricKind.forNumber(this.metricKind_);
        return forNumber == null ? MetricKind.UNRECOGNIZED : forNumber;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public int getMetricKindValue() {
        return this.metricKind_;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeStringSize = !this.name_.isEmpty() ? CodedOutputStream.computeStringSize(1, getName()) + 0 : 0;
        for (int i2 = 0; i2 < this.labels_.size(); i2++) {
            computeStringSize += CodedOutputStream.computeMessageSize(2, this.labels_.get(i2));
        }
        if (this.metricKind_ != MetricKind.METRIC_KIND_UNSPECIFIED.getNumber()) {
            computeStringSize += CodedOutputStream.computeEnumSize(3, this.metricKind_);
        }
        if (this.valueType_ != ValueType.VALUE_TYPE_UNSPECIFIED.getNumber()) {
            computeStringSize += CodedOutputStream.computeEnumSize(4, this.valueType_);
        }
        if (!this.unit_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(5, getUnit());
        }
        if (!this.description_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(6, getDescription());
        }
        if (!this.displayName_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(7, getDisplayName());
        }
        if (!this.type_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(8, getType());
        }
        this.c = computeStringSize;
        return computeStringSize;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public String getType() {
        return this.type_;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public ByteString getTypeBytes() {
        return ByteString.copyFromUtf8(this.type_);
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public String getUnit() {
        return this.unit_;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public ByteString getUnitBytes() {
        return ByteString.copyFromUtf8(this.unit_);
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public ValueType getValueType() {
        ValueType forNumber = ValueType.forNumber(this.valueType_);
        return forNumber == null ? ValueType.UNRECOGNIZED : forNumber;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public int getValueTypeValue() {
        return this.valueType_;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!this.name_.isEmpty()) {
            codedOutputStream.writeString(1, getName());
        }
        for (int i = 0; i < this.labels_.size(); i++) {
            codedOutputStream.writeMessage(2, this.labels_.get(i));
        }
        if (this.metricKind_ != MetricKind.METRIC_KIND_UNSPECIFIED.getNumber()) {
            codedOutputStream.writeEnum(3, this.metricKind_);
        }
        if (this.valueType_ != ValueType.VALUE_TYPE_UNSPECIFIED.getNumber()) {
            codedOutputStream.writeEnum(4, this.valueType_);
        }
        if (!this.unit_.isEmpty()) {
            codedOutputStream.writeString(5, getUnit());
        }
        if (!this.description_.isEmpty()) {
            codedOutputStream.writeString(6, getDescription());
        }
        if (!this.displayName_.isEmpty()) {
            codedOutputStream.writeString(7, getDisplayName());
        }
        if (this.type_.isEmpty()) {
            return;
        }
        codedOutputStream.writeString(8, getType());
    }
}
