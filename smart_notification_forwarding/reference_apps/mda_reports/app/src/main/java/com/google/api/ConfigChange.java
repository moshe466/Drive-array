package com.google.api;

import com.google.api.Advice;
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
public final class ConfigChange extends GeneratedMessageLite<ConfigChange, Builder> implements ConfigChangeOrBuilder {
    public static final int ADVICES_FIELD_NUMBER = 5;
    public static final int CHANGE_TYPE_FIELD_NUMBER = 4;
    private static final ConfigChange DEFAULT_INSTANCE = new ConfigChange();
    public static final int ELEMENT_FIELD_NUMBER = 1;
    public static final int NEW_VALUE_FIELD_NUMBER = 3;
    public static final int OLD_VALUE_FIELD_NUMBER = 2;
    private static volatile Parser<ConfigChange> PARSER;
    private int bitField0_;
    private int changeType_;
    private String element_ = "";
    private String oldValue_ = "";
    private String newValue_ = "";
    private Internal.ProtobufList<Advice> advices_ = GeneratedMessageLite.f();

    /* renamed from: com.google.api.ConfigChange$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<ConfigChange, Builder> implements ConfigChangeOrBuilder {
        private Builder() {
            super(ConfigChange.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAdvices(int i, Advice.Builder builder) {
            a();
            ((ConfigChange) this.a).addAdvices(i, builder);
            return this;
        }

        public Builder addAdvices(int i, Advice advice) {
            a();
            ((ConfigChange) this.a).addAdvices(i, advice);
            return this;
        }

        public Builder addAdvices(Advice.Builder builder) {
            a();
            ((ConfigChange) this.a).addAdvices(builder);
            return this;
        }

        public Builder addAdvices(Advice advice) {
            a();
            ((ConfigChange) this.a).addAdvices(advice);
            return this;
        }

        public Builder addAllAdvices(Iterable<? extends Advice> iterable) {
            a();
            ((ConfigChange) this.a).addAllAdvices(iterable);
            return this;
        }

        public Builder clearAdvices() {
            a();
            ((ConfigChange) this.a).clearAdvices();
            return this;
        }

        public Builder clearChangeType() {
            a();
            ((ConfigChange) this.a).clearChangeType();
            return this;
        }

        public Builder clearElement() {
            a();
            ((ConfigChange) this.a).clearElement();
            return this;
        }

        public Builder clearNewValue() {
            a();
            ((ConfigChange) this.a).clearNewValue();
            return this;
        }

        public Builder clearOldValue() {
            a();
            ((ConfigChange) this.a).clearOldValue();
            return this;
        }

        @Override // com.google.api.ConfigChangeOrBuilder
        public Advice getAdvices(int i) {
            return ((ConfigChange) this.a).getAdvices(i);
        }

        @Override // com.google.api.ConfigChangeOrBuilder
        public int getAdvicesCount() {
            return ((ConfigChange) this.a).getAdvicesCount();
        }

        @Override // com.google.api.ConfigChangeOrBuilder
        public List<Advice> getAdvicesList() {
            return Collections.unmodifiableList(((ConfigChange) this.a).getAdvicesList());
        }

        @Override // com.google.api.ConfigChangeOrBuilder
        public ChangeType getChangeType() {
            return ((ConfigChange) this.a).getChangeType();
        }

        @Override // com.google.api.ConfigChangeOrBuilder
        public int getChangeTypeValue() {
            return ((ConfigChange) this.a).getChangeTypeValue();
        }

        @Override // com.google.api.ConfigChangeOrBuilder
        public String getElement() {
            return ((ConfigChange) this.a).getElement();
        }

        @Override // com.google.api.ConfigChangeOrBuilder
        public ByteString getElementBytes() {
            return ((ConfigChange) this.a).getElementBytes();
        }

        @Override // com.google.api.ConfigChangeOrBuilder
        public String getNewValue() {
            return ((ConfigChange) this.a).getNewValue();
        }

        @Override // com.google.api.ConfigChangeOrBuilder
        public ByteString getNewValueBytes() {
            return ((ConfigChange) this.a).getNewValueBytes();
        }

        @Override // com.google.api.ConfigChangeOrBuilder
        public String getOldValue() {
            return ((ConfigChange) this.a).getOldValue();
        }

        @Override // com.google.api.ConfigChangeOrBuilder
        public ByteString getOldValueBytes() {
            return ((ConfigChange) this.a).getOldValueBytes();
        }

        public Builder removeAdvices(int i) {
            a();
            ((ConfigChange) this.a).removeAdvices(i);
            return this;
        }

        public Builder setAdvices(int i, Advice.Builder builder) {
            a();
            ((ConfigChange) this.a).setAdvices(i, builder);
            return this;
        }

        public Builder setAdvices(int i, Advice advice) {
            a();
            ((ConfigChange) this.a).setAdvices(i, advice);
            return this;
        }

        public Builder setChangeType(ChangeType changeType) {
            a();
            ((ConfigChange) this.a).setChangeType(changeType);
            return this;
        }

        public Builder setChangeTypeValue(int i) {
            a();
            ((ConfigChange) this.a).setChangeTypeValue(i);
            return this;
        }

        public Builder setElement(String str) {
            a();
            ((ConfigChange) this.a).setElement(str);
            return this;
        }

        public Builder setElementBytes(ByteString byteString) {
            a();
            ((ConfigChange) this.a).setElementBytes(byteString);
            return this;
        }

        public Builder setNewValue(String str) {
            a();
            ((ConfigChange) this.a).setNewValue(str);
            return this;
        }

        public Builder setNewValueBytes(ByteString byteString) {
            a();
            ((ConfigChange) this.a).setNewValueBytes(byteString);
            return this;
        }

        public Builder setOldValue(String str) {
            a();
            ((ConfigChange) this.a).setOldValue(str);
            return this;
        }

        public Builder setOldValueBytes(ByteString byteString) {
            a();
            ((ConfigChange) this.a).setOldValueBytes(byteString);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private ConfigChange() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAdvices(int i, Advice.Builder builder) {
        ensureAdvicesIsMutable();
        this.advices_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAdvices(int i, Advice advice) {
        if (advice == null) {
            throw new NullPointerException();
        }
        ensureAdvicesIsMutable();
        this.advices_.add(i, advice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAdvices(Advice.Builder builder) {
        ensureAdvicesIsMutable();
        this.advices_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAdvices(Advice advice) {
        if (advice == null) {
            throw new NullPointerException();
        }
        ensureAdvicesIsMutable();
        this.advices_.add(advice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllAdvices(Iterable<? extends Advice> iterable) {
        ensureAdvicesIsMutable();
        AbstractMessageLite.a(iterable, this.advices_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAdvices() {
        this.advices_ = GeneratedMessageLite.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearChangeType() {
        this.changeType_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearElement() {
        this.element_ = getDefaultInstance().getElement();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNewValue() {
        this.newValue_ = getDefaultInstance().getNewValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOldValue() {
        this.oldValue_ = getDefaultInstance().getOldValue();
    }

    private void ensureAdvicesIsMutable() {
        if (this.advices_.isModifiable()) {
            return;
        }
        this.advices_ = GeneratedMessageLite.a(this.advices_);
    }

    public static ConfigChange getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ConfigChange configChange) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) configChange);
    }

    public static ConfigChange parseDelimitedFrom(InputStream inputStream) {
        return (ConfigChange) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static ConfigChange parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ConfigChange) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ConfigChange parseFrom(ByteString byteString) {
        return (ConfigChange) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static ConfigChange parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ConfigChange) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ConfigChange parseFrom(CodedInputStream codedInputStream) {
        return (ConfigChange) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ConfigChange parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ConfigChange) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static ConfigChange parseFrom(InputStream inputStream) {
        return (ConfigChange) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static ConfigChange parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ConfigChange) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ConfigChange parseFrom(byte[] bArr) {
        return (ConfigChange) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static ConfigChange parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (ConfigChange) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<ConfigChange> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeAdvices(int i) {
        ensureAdvicesIsMutable();
        this.advices_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdvices(int i, Advice.Builder builder) {
        ensureAdvicesIsMutable();
        this.advices_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdvices(int i, Advice advice) {
        if (advice == null) {
            throw new NullPointerException();
        }
        ensureAdvicesIsMutable();
        this.advices_.set(i, advice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChangeType(ChangeType changeType) {
        if (changeType == null) {
            throw new NullPointerException();
        }
        this.changeType_ = changeType.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChangeTypeValue(int i) {
        this.changeType_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setElement(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.element_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setElementBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.element_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNewValue(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.newValue_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNewValueBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.newValue_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOldValue(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.oldValue_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOldValueBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.oldValue_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new ConfigChange();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.advices_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                ConfigChange configChange = (ConfigChange) obj2;
                this.element_ = visitor.visitString(!this.element_.isEmpty(), this.element_, !configChange.element_.isEmpty(), configChange.element_);
                this.oldValue_ = visitor.visitString(!this.oldValue_.isEmpty(), this.oldValue_, !configChange.oldValue_.isEmpty(), configChange.oldValue_);
                this.newValue_ = visitor.visitString(!this.newValue_.isEmpty(), this.newValue_, !configChange.newValue_.isEmpty(), configChange.newValue_);
                this.changeType_ = visitor.visitInt(this.changeType_ != 0, this.changeType_, configChange.changeType_ != 0, configChange.changeType_);
                this.advices_ = visitor.visitList(this.advices_, configChange.advices_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= configChange.bitField0_;
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
                                this.element_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                this.oldValue_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 26) {
                                this.newValue_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 32) {
                                this.changeType_ = codedInputStream.readEnum();
                            } else if (readTag == 42) {
                                if (!this.advices_.isModifiable()) {
                                    this.advices_ = GeneratedMessageLite.a(this.advices_);
                                }
                                this.advices_.add((Advice) codedInputStream.readMessage(Advice.parser(), extensionRegistryLite));
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
                    synchronized (ConfigChange.class) {
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

    @Override // com.google.api.ConfigChangeOrBuilder
    public Advice getAdvices(int i) {
        return this.advices_.get(i);
    }

    @Override // com.google.api.ConfigChangeOrBuilder
    public int getAdvicesCount() {
        return this.advices_.size();
    }

    @Override // com.google.api.ConfigChangeOrBuilder
    public List<Advice> getAdvicesList() {
        return this.advices_;
    }

    public AdviceOrBuilder getAdvicesOrBuilder(int i) {
        return this.advices_.get(i);
    }

    public List<? extends AdviceOrBuilder> getAdvicesOrBuilderList() {
        return this.advices_;
    }

    @Override // com.google.api.ConfigChangeOrBuilder
    public ChangeType getChangeType() {
        ChangeType forNumber = ChangeType.forNumber(this.changeType_);
        return forNumber == null ? ChangeType.UNRECOGNIZED : forNumber;
    }

    @Override // com.google.api.ConfigChangeOrBuilder
    public int getChangeTypeValue() {
        return this.changeType_;
    }

    @Override // com.google.api.ConfigChangeOrBuilder
    public String getElement() {
        return this.element_;
    }

    @Override // com.google.api.ConfigChangeOrBuilder
    public ByteString getElementBytes() {
        return ByteString.copyFromUtf8(this.element_);
    }

    @Override // com.google.api.ConfigChangeOrBuilder
    public String getNewValue() {
        return this.newValue_;
    }

    @Override // com.google.api.ConfigChangeOrBuilder
    public ByteString getNewValueBytes() {
        return ByteString.copyFromUtf8(this.newValue_);
    }

    @Override // com.google.api.ConfigChangeOrBuilder
    public String getOldValue() {
        return this.oldValue_;
    }

    @Override // com.google.api.ConfigChangeOrBuilder
    public ByteString getOldValueBytes() {
        return ByteString.copyFromUtf8(this.oldValue_);
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeStringSize = !this.element_.isEmpty() ? CodedOutputStream.computeStringSize(1, getElement()) + 0 : 0;
        if (!this.oldValue_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(2, getOldValue());
        }
        if (!this.newValue_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(3, getNewValue());
        }
        if (this.changeType_ != ChangeType.CHANGE_TYPE_UNSPECIFIED.getNumber()) {
            computeStringSize += CodedOutputStream.computeEnumSize(4, this.changeType_);
        }
        for (int i2 = 0; i2 < this.advices_.size(); i2++) {
            computeStringSize += CodedOutputStream.computeMessageSize(5, this.advices_.get(i2));
        }
        this.c = computeStringSize;
        return computeStringSize;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!this.element_.isEmpty()) {
            codedOutputStream.writeString(1, getElement());
        }
        if (!this.oldValue_.isEmpty()) {
            codedOutputStream.writeString(2, getOldValue());
        }
        if (!this.newValue_.isEmpty()) {
            codedOutputStream.writeString(3, getNewValue());
        }
        if (this.changeType_ != ChangeType.CHANGE_TYPE_UNSPECIFIED.getNumber()) {
            codedOutputStream.writeEnum(4, this.changeType_);
        }
        for (int i = 0; i < this.advices_.size(); i++) {
            codedOutputStream.writeMessage(5, this.advices_.get(i));
        }
    }
}
