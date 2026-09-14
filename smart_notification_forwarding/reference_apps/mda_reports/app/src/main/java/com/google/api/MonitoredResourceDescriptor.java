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
public final class MonitoredResourceDescriptor extends GeneratedMessageLite<MonitoredResourceDescriptor, Builder> implements MonitoredResourceDescriptorOrBuilder {
    private static final MonitoredResourceDescriptor DEFAULT_INSTANCE = new MonitoredResourceDescriptor();
    public static final int DESCRIPTION_FIELD_NUMBER = 3;
    public static final int DISPLAY_NAME_FIELD_NUMBER = 2;
    public static final int LABELS_FIELD_NUMBER = 4;
    public static final int NAME_FIELD_NUMBER = 5;
    private static volatile Parser<MonitoredResourceDescriptor> PARSER = null;
    public static final int TYPE_FIELD_NUMBER = 1;
    private int bitField0_;
    private String name_ = "";
    private String type_ = "";
    private String displayName_ = "";
    private String description_ = "";
    private Internal.ProtobufList<LabelDescriptor> labels_ = GeneratedMessageLite.f();

    /* renamed from: com.google.api.MonitoredResourceDescriptor$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<MonitoredResourceDescriptor, Builder> implements MonitoredResourceDescriptorOrBuilder {
        private Builder() {
            super(MonitoredResourceDescriptor.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllLabels(Iterable<? extends LabelDescriptor> iterable) {
            a();
            ((MonitoredResourceDescriptor) this.a).addAllLabels(iterable);
            return this;
        }

        public Builder addLabels(int i, LabelDescriptor.Builder builder) {
            a();
            ((MonitoredResourceDescriptor) this.a).addLabels(i, builder);
            return this;
        }

        public Builder addLabels(int i, LabelDescriptor labelDescriptor) {
            a();
            ((MonitoredResourceDescriptor) this.a).addLabels(i, labelDescriptor);
            return this;
        }

        public Builder addLabels(LabelDescriptor.Builder builder) {
            a();
            ((MonitoredResourceDescriptor) this.a).addLabels(builder);
            return this;
        }

        public Builder addLabels(LabelDescriptor labelDescriptor) {
            a();
            ((MonitoredResourceDescriptor) this.a).addLabels(labelDescriptor);
            return this;
        }

        public Builder clearDescription() {
            a();
            ((MonitoredResourceDescriptor) this.a).clearDescription();
            return this;
        }

        public Builder clearDisplayName() {
            a();
            ((MonitoredResourceDescriptor) this.a).clearDisplayName();
            return this;
        }

        public Builder clearLabels() {
            a();
            ((MonitoredResourceDescriptor) this.a).clearLabels();
            return this;
        }

        public Builder clearName() {
            a();
            ((MonitoredResourceDescriptor) this.a).clearName();
            return this;
        }

        public Builder clearType() {
            a();
            ((MonitoredResourceDescriptor) this.a).clearType();
            return this;
        }

        @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
        public String getDescription() {
            return ((MonitoredResourceDescriptor) this.a).getDescription();
        }

        @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
        public ByteString getDescriptionBytes() {
            return ((MonitoredResourceDescriptor) this.a).getDescriptionBytes();
        }

        @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
        public String getDisplayName() {
            return ((MonitoredResourceDescriptor) this.a).getDisplayName();
        }

        @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
        public ByteString getDisplayNameBytes() {
            return ((MonitoredResourceDescriptor) this.a).getDisplayNameBytes();
        }

        @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
        public LabelDescriptor getLabels(int i) {
            return ((MonitoredResourceDescriptor) this.a).getLabels(i);
        }

        @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
        public int getLabelsCount() {
            return ((MonitoredResourceDescriptor) this.a).getLabelsCount();
        }

        @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
        public List<LabelDescriptor> getLabelsList() {
            return Collections.unmodifiableList(((MonitoredResourceDescriptor) this.a).getLabelsList());
        }

        @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
        public String getName() {
            return ((MonitoredResourceDescriptor) this.a).getName();
        }

        @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
        public ByteString getNameBytes() {
            return ((MonitoredResourceDescriptor) this.a).getNameBytes();
        }

        @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
        public String getType() {
            return ((MonitoredResourceDescriptor) this.a).getType();
        }

        @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
        public ByteString getTypeBytes() {
            return ((MonitoredResourceDescriptor) this.a).getTypeBytes();
        }

        public Builder removeLabels(int i) {
            a();
            ((MonitoredResourceDescriptor) this.a).removeLabels(i);
            return this;
        }

        public Builder setDescription(String str) {
            a();
            ((MonitoredResourceDescriptor) this.a).setDescription(str);
            return this;
        }

        public Builder setDescriptionBytes(ByteString byteString) {
            a();
            ((MonitoredResourceDescriptor) this.a).setDescriptionBytes(byteString);
            return this;
        }

        public Builder setDisplayName(String str) {
            a();
            ((MonitoredResourceDescriptor) this.a).setDisplayName(str);
            return this;
        }

        public Builder setDisplayNameBytes(ByteString byteString) {
            a();
            ((MonitoredResourceDescriptor) this.a).setDisplayNameBytes(byteString);
            return this;
        }

        public Builder setLabels(int i, LabelDescriptor.Builder builder) {
            a();
            ((MonitoredResourceDescriptor) this.a).setLabels(i, builder);
            return this;
        }

        public Builder setLabels(int i, LabelDescriptor labelDescriptor) {
            a();
            ((MonitoredResourceDescriptor) this.a).setLabels(i, labelDescriptor);
            return this;
        }

        public Builder setName(String str) {
            a();
            ((MonitoredResourceDescriptor) this.a).setName(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            a();
            ((MonitoredResourceDescriptor) this.a).setNameBytes(byteString);
            return this;
        }

        public Builder setType(String str) {
            a();
            ((MonitoredResourceDescriptor) this.a).setType(str);
            return this;
        }

        public Builder setTypeBytes(ByteString byteString) {
            a();
            ((MonitoredResourceDescriptor) this.a).setTypeBytes(byteString);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private MonitoredResourceDescriptor() {
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
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearType() {
        this.type_ = getDefaultInstance().getType();
    }

    private void ensureLabelsIsMutable() {
        if (this.labels_.isModifiable()) {
            return;
        }
        this.labels_ = GeneratedMessageLite.a(this.labels_);
    }

    public static MonitoredResourceDescriptor getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(MonitoredResourceDescriptor monitoredResourceDescriptor) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) monitoredResourceDescriptor);
    }

    public static MonitoredResourceDescriptor parseDelimitedFrom(InputStream inputStream) {
        return (MonitoredResourceDescriptor) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static MonitoredResourceDescriptor parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MonitoredResourceDescriptor) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MonitoredResourceDescriptor parseFrom(ByteString byteString) {
        return (MonitoredResourceDescriptor) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static MonitoredResourceDescriptor parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MonitoredResourceDescriptor) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MonitoredResourceDescriptor parseFrom(CodedInputStream codedInputStream) {
        return (MonitoredResourceDescriptor) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MonitoredResourceDescriptor parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MonitoredResourceDescriptor) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static MonitoredResourceDescriptor parseFrom(InputStream inputStream) {
        return (MonitoredResourceDescriptor) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static MonitoredResourceDescriptor parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MonitoredResourceDescriptor) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MonitoredResourceDescriptor parseFrom(byte[] bArr) {
        return (MonitoredResourceDescriptor) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static MonitoredResourceDescriptor parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MonitoredResourceDescriptor) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<MonitoredResourceDescriptor> parser() {
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

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new MonitoredResourceDescriptor();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.labels_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                MonitoredResourceDescriptor monitoredResourceDescriptor = (MonitoredResourceDescriptor) obj2;
                this.name_ = visitor.visitString(!this.name_.isEmpty(), this.name_, !monitoredResourceDescriptor.name_.isEmpty(), monitoredResourceDescriptor.name_);
                this.type_ = visitor.visitString(!this.type_.isEmpty(), this.type_, !monitoredResourceDescriptor.type_.isEmpty(), monitoredResourceDescriptor.type_);
                this.displayName_ = visitor.visitString(!this.displayName_.isEmpty(), this.displayName_, !monitoredResourceDescriptor.displayName_.isEmpty(), monitoredResourceDescriptor.displayName_);
                this.description_ = visitor.visitString(!this.description_.isEmpty(), this.description_, true ^ monitoredResourceDescriptor.description_.isEmpty(), monitoredResourceDescriptor.description_);
                this.labels_ = visitor.visitList(this.labels_, monitoredResourceDescriptor.labels_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= monitoredResourceDescriptor.bitField0_;
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
                                this.type_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                this.displayName_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 26) {
                                this.description_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 34) {
                                if (!this.labels_.isModifiable()) {
                                    this.labels_ = GeneratedMessageLite.a(this.labels_);
                                }
                                this.labels_.add((LabelDescriptor) codedInputStream.readMessage(LabelDescriptor.parser(), extensionRegistryLite));
                            } else if (readTag == 42) {
                                this.name_ = codedInputStream.readStringRequireUtf8();
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
                    synchronized (MonitoredResourceDescriptor.class) {
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

    @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
    public String getDescription() {
        return this.description_;
    }

    @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
    public ByteString getDescriptionBytes() {
        return ByteString.copyFromUtf8(this.description_);
    }

    @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
    public String getDisplayName() {
        return this.displayName_;
    }

    @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
    public ByteString getDisplayNameBytes() {
        return ByteString.copyFromUtf8(this.displayName_);
    }

    @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
    public LabelDescriptor getLabels(int i) {
        return this.labels_.get(i);
    }

    @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
    public int getLabelsCount() {
        return this.labels_.size();
    }

    @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
    public List<LabelDescriptor> getLabelsList() {
        return this.labels_;
    }

    public LabelDescriptorOrBuilder getLabelsOrBuilder(int i) {
        return this.labels_.get(i);
    }

    public List<? extends LabelDescriptorOrBuilder> getLabelsOrBuilderList() {
        return this.labels_;
    }

    @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeStringSize = !this.type_.isEmpty() ? CodedOutputStream.computeStringSize(1, getType()) + 0 : 0;
        if (!this.displayName_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(2, getDisplayName());
        }
        if (!this.description_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(3, getDescription());
        }
        for (int i2 = 0; i2 < this.labels_.size(); i2++) {
            computeStringSize += CodedOutputStream.computeMessageSize(4, this.labels_.get(i2));
        }
        if (!this.name_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(5, getName());
        }
        this.c = computeStringSize;
        return computeStringSize;
    }

    @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
    public String getType() {
        return this.type_;
    }

    @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
    public ByteString getTypeBytes() {
        return ByteString.copyFromUtf8(this.type_);
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!this.type_.isEmpty()) {
            codedOutputStream.writeString(1, getType());
        }
        if (!this.displayName_.isEmpty()) {
            codedOutputStream.writeString(2, getDisplayName());
        }
        if (!this.description_.isEmpty()) {
            codedOutputStream.writeString(3, getDescription());
        }
        for (int i = 0; i < this.labels_.size(); i++) {
            codedOutputStream.writeMessage(4, this.labels_.get(i));
        }
        if (this.name_.isEmpty()) {
            return;
        }
        codedOutputStream.writeString(5, getName());
    }
}
