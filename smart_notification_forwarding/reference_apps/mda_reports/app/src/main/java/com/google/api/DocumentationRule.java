package com.google.api;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class DocumentationRule extends GeneratedMessageLite<DocumentationRule, Builder> implements DocumentationRuleOrBuilder {
    private static final DocumentationRule DEFAULT_INSTANCE = new DocumentationRule();
    public static final int DEPRECATION_DESCRIPTION_FIELD_NUMBER = 3;
    public static final int DESCRIPTION_FIELD_NUMBER = 2;
    private static volatile Parser<DocumentationRule> PARSER = null;
    public static final int SELECTOR_FIELD_NUMBER = 1;
    private String selector_ = "";
    private String description_ = "";
    private String deprecationDescription_ = "";

    /* renamed from: com.google.api.DocumentationRule$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<DocumentationRule, Builder> implements DocumentationRuleOrBuilder {
        private Builder() {
            super(DocumentationRule.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearDeprecationDescription() {
            a();
            ((DocumentationRule) this.a).clearDeprecationDescription();
            return this;
        }

        public Builder clearDescription() {
            a();
            ((DocumentationRule) this.a).clearDescription();
            return this;
        }

        public Builder clearSelector() {
            a();
            ((DocumentationRule) this.a).clearSelector();
            return this;
        }

        @Override // com.google.api.DocumentationRuleOrBuilder
        public String getDeprecationDescription() {
            return ((DocumentationRule) this.a).getDeprecationDescription();
        }

        @Override // com.google.api.DocumentationRuleOrBuilder
        public ByteString getDeprecationDescriptionBytes() {
            return ((DocumentationRule) this.a).getDeprecationDescriptionBytes();
        }

        @Override // com.google.api.DocumentationRuleOrBuilder
        public String getDescription() {
            return ((DocumentationRule) this.a).getDescription();
        }

        @Override // com.google.api.DocumentationRuleOrBuilder
        public ByteString getDescriptionBytes() {
            return ((DocumentationRule) this.a).getDescriptionBytes();
        }

        @Override // com.google.api.DocumentationRuleOrBuilder
        public String getSelector() {
            return ((DocumentationRule) this.a).getSelector();
        }

        @Override // com.google.api.DocumentationRuleOrBuilder
        public ByteString getSelectorBytes() {
            return ((DocumentationRule) this.a).getSelectorBytes();
        }

        public Builder setDeprecationDescription(String str) {
            a();
            ((DocumentationRule) this.a).setDeprecationDescription(str);
            return this;
        }

        public Builder setDeprecationDescriptionBytes(ByteString byteString) {
            a();
            ((DocumentationRule) this.a).setDeprecationDescriptionBytes(byteString);
            return this;
        }

        public Builder setDescription(String str) {
            a();
            ((DocumentationRule) this.a).setDescription(str);
            return this;
        }

        public Builder setDescriptionBytes(ByteString byteString) {
            a();
            ((DocumentationRule) this.a).setDescriptionBytes(byteString);
            return this;
        }

        public Builder setSelector(String str) {
            a();
            ((DocumentationRule) this.a).setSelector(str);
            return this;
        }

        public Builder setSelectorBytes(ByteString byteString) {
            a();
            ((DocumentationRule) this.a).setSelectorBytes(byteString);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private DocumentationRule() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDeprecationDescription() {
        this.deprecationDescription_ = getDefaultInstance().getDeprecationDescription();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSelector() {
        this.selector_ = getDefaultInstance().getSelector();
    }

    public static DocumentationRule getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(DocumentationRule documentationRule) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) documentationRule);
    }

    public static DocumentationRule parseDelimitedFrom(InputStream inputStream) {
        return (DocumentationRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static DocumentationRule parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DocumentationRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DocumentationRule parseFrom(ByteString byteString) {
        return (DocumentationRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static DocumentationRule parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DocumentationRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static DocumentationRule parseFrom(CodedInputStream codedInputStream) {
        return (DocumentationRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static DocumentationRule parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DocumentationRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static DocumentationRule parseFrom(InputStream inputStream) {
        return (DocumentationRule) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static DocumentationRule parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DocumentationRule) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DocumentationRule parseFrom(byte[] bArr) {
        return (DocumentationRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static DocumentationRule parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (DocumentationRule) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<DocumentationRule> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeprecationDescription(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.deprecationDescription_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeprecationDescriptionBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.deprecationDescription_ = byteString.toStringUtf8();
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
                return new DocumentationRule();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                DocumentationRule documentationRule = (DocumentationRule) obj2;
                this.selector_ = visitor.visitString(!this.selector_.isEmpty(), this.selector_, !documentationRule.selector_.isEmpty(), documentationRule.selector_);
                this.description_ = visitor.visitString(!this.description_.isEmpty(), this.description_, !documentationRule.description_.isEmpty(), documentationRule.description_);
                this.deprecationDescription_ = visitor.visitString(!this.deprecationDescription_.isEmpty(), this.deprecationDescription_, true ^ documentationRule.deprecationDescription_.isEmpty(), documentationRule.deprecationDescription_);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                boolean z = false;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.selector_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                this.description_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 26) {
                                this.deprecationDescription_ = codedInputStream.readStringRequireUtf8();
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
                    synchronized (DocumentationRule.class) {
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

    @Override // com.google.api.DocumentationRuleOrBuilder
    public String getDeprecationDescription() {
        return this.deprecationDescription_;
    }

    @Override // com.google.api.DocumentationRuleOrBuilder
    public ByteString getDeprecationDescriptionBytes() {
        return ByteString.copyFromUtf8(this.deprecationDescription_);
    }

    @Override // com.google.api.DocumentationRuleOrBuilder
    public String getDescription() {
        return this.description_;
    }

    @Override // com.google.api.DocumentationRuleOrBuilder
    public ByteString getDescriptionBytes() {
        return ByteString.copyFromUtf8(this.description_);
    }

    @Override // com.google.api.DocumentationRuleOrBuilder
    public String getSelector() {
        return this.selector_;
    }

    @Override // com.google.api.DocumentationRuleOrBuilder
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
        if (!this.description_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(2, getDescription());
        }
        if (!this.deprecationDescription_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(3, getDeprecationDescription());
        }
        this.c = computeStringSize;
        return computeStringSize;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!this.selector_.isEmpty()) {
            codedOutputStream.writeString(1, getSelector());
        }
        if (!this.description_.isEmpty()) {
            codedOutputStream.writeString(2, getDescription());
        }
        if (this.deprecationDescription_.isEmpty()) {
            return;
        }
        codedOutputStream.writeString(3, getDeprecationDescription());
    }
}
