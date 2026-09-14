package com.google.api;

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
public final class ContextRule extends GeneratedMessageLite<ContextRule, Builder> implements ContextRuleOrBuilder {
    private static final ContextRule DEFAULT_INSTANCE = new ContextRule();
    private static volatile Parser<ContextRule> PARSER = null;
    public static final int PROVIDED_FIELD_NUMBER = 3;
    public static final int REQUESTED_FIELD_NUMBER = 2;
    public static final int SELECTOR_FIELD_NUMBER = 1;
    private int bitField0_;
    private String selector_ = "";
    private Internal.ProtobufList<String> requested_ = GeneratedMessageLite.f();
    private Internal.ProtobufList<String> provided_ = GeneratedMessageLite.f();

    /* renamed from: com.google.api.ContextRule$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<ContextRule, Builder> implements ContextRuleOrBuilder {
        private Builder() {
            super(ContextRule.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllProvided(Iterable<String> iterable) {
            a();
            ((ContextRule) this.a).addAllProvided(iterable);
            return this;
        }

        public Builder addAllRequested(Iterable<String> iterable) {
            a();
            ((ContextRule) this.a).addAllRequested(iterable);
            return this;
        }

        public Builder addProvided(String str) {
            a();
            ((ContextRule) this.a).addProvided(str);
            return this;
        }

        public Builder addProvidedBytes(ByteString byteString) {
            a();
            ((ContextRule) this.a).addProvidedBytes(byteString);
            return this;
        }

        public Builder addRequested(String str) {
            a();
            ((ContextRule) this.a).addRequested(str);
            return this;
        }

        public Builder addRequestedBytes(ByteString byteString) {
            a();
            ((ContextRule) this.a).addRequestedBytes(byteString);
            return this;
        }

        public Builder clearProvided() {
            a();
            ((ContextRule) this.a).clearProvided();
            return this;
        }

        public Builder clearRequested() {
            a();
            ((ContextRule) this.a).clearRequested();
            return this;
        }

        public Builder clearSelector() {
            a();
            ((ContextRule) this.a).clearSelector();
            return this;
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public String getProvided(int i) {
            return ((ContextRule) this.a).getProvided(i);
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public ByteString getProvidedBytes(int i) {
            return ((ContextRule) this.a).getProvidedBytes(i);
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public int getProvidedCount() {
            return ((ContextRule) this.a).getProvidedCount();
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public List<String> getProvidedList() {
            return Collections.unmodifiableList(((ContextRule) this.a).getProvidedList());
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public String getRequested(int i) {
            return ((ContextRule) this.a).getRequested(i);
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public ByteString getRequestedBytes(int i) {
            return ((ContextRule) this.a).getRequestedBytes(i);
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public int getRequestedCount() {
            return ((ContextRule) this.a).getRequestedCount();
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public List<String> getRequestedList() {
            return Collections.unmodifiableList(((ContextRule) this.a).getRequestedList());
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public String getSelector() {
            return ((ContextRule) this.a).getSelector();
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public ByteString getSelectorBytes() {
            return ((ContextRule) this.a).getSelectorBytes();
        }

        public Builder setProvided(int i, String str) {
            a();
            ((ContextRule) this.a).setProvided(i, str);
            return this;
        }

        public Builder setRequested(int i, String str) {
            a();
            ((ContextRule) this.a).setRequested(i, str);
            return this;
        }

        public Builder setSelector(String str) {
            a();
            ((ContextRule) this.a).setSelector(str);
            return this;
        }

        public Builder setSelectorBytes(ByteString byteString) {
            a();
            ((ContextRule) this.a).setSelectorBytes(byteString);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private ContextRule() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllProvided(Iterable<String> iterable) {
        ensureProvidedIsMutable();
        AbstractMessageLite.a(iterable, this.provided_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllRequested(Iterable<String> iterable) {
        ensureRequestedIsMutable();
        AbstractMessageLite.a(iterable, this.requested_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addProvided(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        ensureProvidedIsMutable();
        this.provided_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addProvidedBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        ensureProvidedIsMutable();
        this.provided_.add(byteString.toStringUtf8());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRequested(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        ensureRequestedIsMutable();
        this.requested_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRequestedBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        ensureRequestedIsMutable();
        this.requested_.add(byteString.toStringUtf8());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearProvided() {
        this.provided_ = GeneratedMessageLite.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRequested() {
        this.requested_ = GeneratedMessageLite.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSelector() {
        this.selector_ = getDefaultInstance().getSelector();
    }

    private void ensureProvidedIsMutable() {
        if (this.provided_.isModifiable()) {
            return;
        }
        this.provided_ = GeneratedMessageLite.a(this.provided_);
    }

    private void ensureRequestedIsMutable() {
        if (this.requested_.isModifiable()) {
            return;
        }
        this.requested_ = GeneratedMessageLite.a(this.requested_);
    }

    public static ContextRule getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ContextRule contextRule) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) contextRule);
    }

    public static ContextRule parseDelimitedFrom(InputStream inputStream) {
        return (ContextRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static ContextRule parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ContextRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ContextRule parseFrom(ByteString byteString) {
        return (ContextRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static ContextRule parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ContextRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ContextRule parseFrom(CodedInputStream codedInputStream) {
        return (ContextRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ContextRule parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ContextRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static ContextRule parseFrom(InputStream inputStream) {
        return (ContextRule) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static ContextRule parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ContextRule) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ContextRule parseFrom(byte[] bArr) {
        return (ContextRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static ContextRule parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (ContextRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<ContextRule> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProvided(int i, String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        ensureProvidedIsMutable();
        this.provided_.set(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequested(int i, String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        ensureRequestedIsMutable();
        this.requested_.set(i, str);
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
        String readStringRequireUtf8;
        Internal.ProtobufList<String> protobufList;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new ContextRule();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.requested_.makeImmutable();
                this.provided_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                ContextRule contextRule = (ContextRule) obj2;
                this.selector_ = visitor.visitString(!this.selector_.isEmpty(), this.selector_, true ^ contextRule.selector_.isEmpty(), contextRule.selector_);
                this.requested_ = visitor.visitList(this.requested_, contextRule.requested_);
                this.provided_ = visitor.visitList(this.provided_, contextRule.provided_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= contextRule.bitField0_;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag != 10) {
                                    if (readTag == 18) {
                                        readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                        if (!this.requested_.isModifiable()) {
                                            this.requested_ = GeneratedMessageLite.a(this.requested_);
                                        }
                                        protobufList = this.requested_;
                                    } else if (readTag == 26) {
                                        readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                        if (!this.provided_.isModifiable()) {
                                            this.provided_ = GeneratedMessageLite.a(this.provided_);
                                        }
                                        protobufList = this.provided_;
                                    } else if (!codedInputStream.skipField(readTag)) {
                                    }
                                    protobufList.add(readStringRequireUtf8);
                                } else {
                                    this.selector_ = codedInputStream.readStringRequireUtf8();
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
                    synchronized (ContextRule.class) {
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

    @Override // com.google.api.ContextRuleOrBuilder
    public String getProvided(int i) {
        return this.provided_.get(i);
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public ByteString getProvidedBytes(int i) {
        return ByteString.copyFromUtf8(this.provided_.get(i));
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public int getProvidedCount() {
        return this.provided_.size();
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public List<String> getProvidedList() {
        return this.provided_;
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public String getRequested(int i) {
        return this.requested_.get(i);
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public ByteString getRequestedBytes(int i) {
        return ByteString.copyFromUtf8(this.requested_.get(i));
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public int getRequestedCount() {
        return this.requested_.size();
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public List<String> getRequestedList() {
        return this.requested_;
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public String getSelector() {
        return this.selector_;
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public ByteString getSelectorBytes() {
        return ByteString.copyFromUtf8(this.selector_);
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeStringSize = !this.selector_.isEmpty() ? CodedOutputStream.computeStringSize(1, getSelector()) + 0 : 0;
        int i2 = 0;
        for (int i3 = 0; i3 < this.requested_.size(); i3++) {
            i2 += CodedOutputStream.computeStringSizeNoTag(this.requested_.get(i3));
        }
        int size = computeStringSize + i2 + (getRequestedList().size() * 1);
        int i4 = 0;
        for (int i5 = 0; i5 < this.provided_.size(); i5++) {
            i4 += CodedOutputStream.computeStringSizeNoTag(this.provided_.get(i5));
        }
        int size2 = size + i4 + (getProvidedList().size() * 1);
        this.c = size2;
        return size2;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!this.selector_.isEmpty()) {
            codedOutputStream.writeString(1, getSelector());
        }
        for (int i = 0; i < this.requested_.size(); i++) {
            codedOutputStream.writeString(2, this.requested_.get(i));
        }
        for (int i2 = 0; i2 < this.provided_.size(); i2++) {
            codedOutputStream.writeString(3, this.provided_.get(i2));
        }
    }
}
