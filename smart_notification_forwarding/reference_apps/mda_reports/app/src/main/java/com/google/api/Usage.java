package com.google.api;

import com.google.api.UsageRule;
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
public final class Usage extends GeneratedMessageLite<Usage, Builder> implements UsageOrBuilder {
    private static final Usage DEFAULT_INSTANCE = new Usage();
    private static volatile Parser<Usage> PARSER = null;
    public static final int PRODUCER_NOTIFICATION_CHANNEL_FIELD_NUMBER = 7;
    public static final int REQUIREMENTS_FIELD_NUMBER = 1;
    public static final int RULES_FIELD_NUMBER = 6;
    private int bitField0_;
    private Internal.ProtobufList<String> requirements_ = GeneratedMessageLite.f();
    private Internal.ProtobufList<UsageRule> rules_ = GeneratedMessageLite.f();
    private String producerNotificationChannel_ = "";

    /* renamed from: com.google.api.Usage$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<Usage, Builder> implements UsageOrBuilder {
        private Builder() {
            super(Usage.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllRequirements(Iterable<String> iterable) {
            a();
            ((Usage) this.a).addAllRequirements(iterable);
            return this;
        }

        public Builder addAllRules(Iterable<? extends UsageRule> iterable) {
            a();
            ((Usage) this.a).addAllRules(iterable);
            return this;
        }

        public Builder addRequirements(String str) {
            a();
            ((Usage) this.a).addRequirements(str);
            return this;
        }

        public Builder addRequirementsBytes(ByteString byteString) {
            a();
            ((Usage) this.a).addRequirementsBytes(byteString);
            return this;
        }

        public Builder addRules(int i, UsageRule.Builder builder) {
            a();
            ((Usage) this.a).addRules(i, builder);
            return this;
        }

        public Builder addRules(int i, UsageRule usageRule) {
            a();
            ((Usage) this.a).addRules(i, usageRule);
            return this;
        }

        public Builder addRules(UsageRule.Builder builder) {
            a();
            ((Usage) this.a).addRules(builder);
            return this;
        }

        public Builder addRules(UsageRule usageRule) {
            a();
            ((Usage) this.a).addRules(usageRule);
            return this;
        }

        public Builder clearProducerNotificationChannel() {
            a();
            ((Usage) this.a).clearProducerNotificationChannel();
            return this;
        }

        public Builder clearRequirements() {
            a();
            ((Usage) this.a).clearRequirements();
            return this;
        }

        public Builder clearRules() {
            a();
            ((Usage) this.a).clearRules();
            return this;
        }

        @Override // com.google.api.UsageOrBuilder
        public String getProducerNotificationChannel() {
            return ((Usage) this.a).getProducerNotificationChannel();
        }

        @Override // com.google.api.UsageOrBuilder
        public ByteString getProducerNotificationChannelBytes() {
            return ((Usage) this.a).getProducerNotificationChannelBytes();
        }

        @Override // com.google.api.UsageOrBuilder
        public String getRequirements(int i) {
            return ((Usage) this.a).getRequirements(i);
        }

        @Override // com.google.api.UsageOrBuilder
        public ByteString getRequirementsBytes(int i) {
            return ((Usage) this.a).getRequirementsBytes(i);
        }

        @Override // com.google.api.UsageOrBuilder
        public int getRequirementsCount() {
            return ((Usage) this.a).getRequirementsCount();
        }

        @Override // com.google.api.UsageOrBuilder
        public List<String> getRequirementsList() {
            return Collections.unmodifiableList(((Usage) this.a).getRequirementsList());
        }

        @Override // com.google.api.UsageOrBuilder
        public UsageRule getRules(int i) {
            return ((Usage) this.a).getRules(i);
        }

        @Override // com.google.api.UsageOrBuilder
        public int getRulesCount() {
            return ((Usage) this.a).getRulesCount();
        }

        @Override // com.google.api.UsageOrBuilder
        public List<UsageRule> getRulesList() {
            return Collections.unmodifiableList(((Usage) this.a).getRulesList());
        }

        public Builder removeRules(int i) {
            a();
            ((Usage) this.a).removeRules(i);
            return this;
        }

        public Builder setProducerNotificationChannel(String str) {
            a();
            ((Usage) this.a).setProducerNotificationChannel(str);
            return this;
        }

        public Builder setProducerNotificationChannelBytes(ByteString byteString) {
            a();
            ((Usage) this.a).setProducerNotificationChannelBytes(byteString);
            return this;
        }

        public Builder setRequirements(int i, String str) {
            a();
            ((Usage) this.a).setRequirements(i, str);
            return this;
        }

        public Builder setRules(int i, UsageRule.Builder builder) {
            a();
            ((Usage) this.a).setRules(i, builder);
            return this;
        }

        public Builder setRules(int i, UsageRule usageRule) {
            a();
            ((Usage) this.a).setRules(i, usageRule);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private Usage() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllRequirements(Iterable<String> iterable) {
        ensureRequirementsIsMutable();
        AbstractMessageLite.a(iterable, this.requirements_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllRules(Iterable<? extends UsageRule> iterable) {
        ensureRulesIsMutable();
        AbstractMessageLite.a(iterable, this.rules_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRequirements(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        ensureRequirementsIsMutable();
        this.requirements_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRequirementsBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        ensureRequirementsIsMutable();
        this.requirements_.add(byteString.toStringUtf8());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRules(int i, UsageRule.Builder builder) {
        ensureRulesIsMutable();
        this.rules_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRules(int i, UsageRule usageRule) {
        if (usageRule == null) {
            throw new NullPointerException();
        }
        ensureRulesIsMutable();
        this.rules_.add(i, usageRule);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRules(UsageRule.Builder builder) {
        ensureRulesIsMutable();
        this.rules_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRules(UsageRule usageRule) {
        if (usageRule == null) {
            throw new NullPointerException();
        }
        ensureRulesIsMutable();
        this.rules_.add(usageRule);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearProducerNotificationChannel() {
        this.producerNotificationChannel_ = getDefaultInstance().getProducerNotificationChannel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRequirements() {
        this.requirements_ = GeneratedMessageLite.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRules() {
        this.rules_ = GeneratedMessageLite.f();
    }

    private void ensureRequirementsIsMutable() {
        if (this.requirements_.isModifiable()) {
            return;
        }
        this.requirements_ = GeneratedMessageLite.a(this.requirements_);
    }

    private void ensureRulesIsMutable() {
        if (this.rules_.isModifiable()) {
            return;
        }
        this.rules_ = GeneratedMessageLite.a(this.rules_);
    }

    public static Usage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Usage usage) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) usage);
    }

    public static Usage parseDelimitedFrom(InputStream inputStream) {
        return (Usage) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static Usage parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Usage) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Usage parseFrom(ByteString byteString) {
        return (Usage) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static Usage parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Usage) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Usage parseFrom(CodedInputStream codedInputStream) {
        return (Usage) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Usage parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Usage) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Usage parseFrom(InputStream inputStream) {
        return (Usage) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static Usage parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Usage) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Usage parseFrom(byte[] bArr) {
        return (Usage) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static Usage parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Usage) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<Usage> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeRules(int i) {
        ensureRulesIsMutable();
        this.rules_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProducerNotificationChannel(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.producerNotificationChannel_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProducerNotificationChannelBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.producerNotificationChannel_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequirements(int i, String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        ensureRequirementsIsMutable();
        this.requirements_.set(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRules(int i, UsageRule.Builder builder) {
        ensureRulesIsMutable();
        this.rules_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRules(int i, UsageRule usageRule) {
        if (usageRule == null) {
            throw new NullPointerException();
        }
        ensureRulesIsMutable();
        this.rules_.set(i, usageRule);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new Usage();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.requirements_.makeImmutable();
                this.rules_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Usage usage = (Usage) obj2;
                this.requirements_ = visitor.visitList(this.requirements_, usage.requirements_);
                this.rules_ = visitor.visitList(this.rules_, usage.rules_);
                this.producerNotificationChannel_ = visitor.visitString(!this.producerNotificationChannel_.isEmpty(), this.producerNotificationChannel_, true ^ usage.producerNotificationChannel_.isEmpty(), usage.producerNotificationChannel_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= usage.bitField0_;
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
                                String readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                if (!this.requirements_.isModifiable()) {
                                    this.requirements_ = GeneratedMessageLite.a(this.requirements_);
                                }
                                this.requirements_.add(readStringRequireUtf8);
                            } else if (readTag == 50) {
                                if (!this.rules_.isModifiable()) {
                                    this.rules_ = GeneratedMessageLite.a(this.rules_);
                                }
                                this.rules_.add((UsageRule) codedInputStream.readMessage(UsageRule.parser(), extensionRegistryLite));
                            } else if (readTag == 58) {
                                this.producerNotificationChannel_ = codedInputStream.readStringRequireUtf8();
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
                    synchronized (Usage.class) {
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

    @Override // com.google.api.UsageOrBuilder
    public String getProducerNotificationChannel() {
        return this.producerNotificationChannel_;
    }

    @Override // com.google.api.UsageOrBuilder
    public ByteString getProducerNotificationChannelBytes() {
        return ByteString.copyFromUtf8(this.producerNotificationChannel_);
    }

    @Override // com.google.api.UsageOrBuilder
    public String getRequirements(int i) {
        return this.requirements_.get(i);
    }

    @Override // com.google.api.UsageOrBuilder
    public ByteString getRequirementsBytes(int i) {
        return ByteString.copyFromUtf8(this.requirements_.get(i));
    }

    @Override // com.google.api.UsageOrBuilder
    public int getRequirementsCount() {
        return this.requirements_.size();
    }

    @Override // com.google.api.UsageOrBuilder
    public List<String> getRequirementsList() {
        return this.requirements_;
    }

    @Override // com.google.api.UsageOrBuilder
    public UsageRule getRules(int i) {
        return this.rules_.get(i);
    }

    @Override // com.google.api.UsageOrBuilder
    public int getRulesCount() {
        return this.rules_.size();
    }

    @Override // com.google.api.UsageOrBuilder
    public List<UsageRule> getRulesList() {
        return this.rules_;
    }

    public UsageRuleOrBuilder getRulesOrBuilder(int i) {
        return this.rules_.get(i);
    }

    public List<? extends UsageRuleOrBuilder> getRulesOrBuilderList() {
        return this.rules_;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.requirements_.size(); i3++) {
            i2 += CodedOutputStream.computeStringSizeNoTag(this.requirements_.get(i3));
        }
        int size = i2 + 0 + (getRequirementsList().size() * 1);
        for (int i4 = 0; i4 < this.rules_.size(); i4++) {
            size += CodedOutputStream.computeMessageSize(6, this.rules_.get(i4));
        }
        if (!this.producerNotificationChannel_.isEmpty()) {
            size += CodedOutputStream.computeStringSize(7, getProducerNotificationChannel());
        }
        this.c = size;
        return size;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        for (int i = 0; i < this.requirements_.size(); i++) {
            codedOutputStream.writeString(1, this.requirements_.get(i));
        }
        for (int i2 = 0; i2 < this.rules_.size(); i2++) {
            codedOutputStream.writeMessage(6, this.rules_.get(i2));
        }
        if (this.producerNotificationChannel_.isEmpty()) {
            return;
        }
        codedOutputStream.writeString(7, getProducerNotificationChannel());
    }
}
