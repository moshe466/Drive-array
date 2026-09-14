package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Option;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class Method extends GeneratedMessageLite<Method, Builder> implements MethodOrBuilder {
    private static final Method DEFAULT_INSTANCE = new Method();
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 6;
    private static volatile Parser<Method> PARSER = null;
    public static final int REQUEST_STREAMING_FIELD_NUMBER = 3;
    public static final int REQUEST_TYPE_URL_FIELD_NUMBER = 2;
    public static final int RESPONSE_STREAMING_FIELD_NUMBER = 5;
    public static final int RESPONSE_TYPE_URL_FIELD_NUMBER = 4;
    public static final int SYNTAX_FIELD_NUMBER = 7;
    private int bitField0_;
    private boolean requestStreaming_;
    private boolean responseStreaming_;
    private int syntax_;
    private String name_ = "";
    private String requestTypeUrl_ = "";
    private String responseTypeUrl_ = "";
    private Internal.ProtobufList<Option> options_ = GeneratedMessageLite.f();

    /* renamed from: com.google.protobuf.Method$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<Method, Builder> implements MethodOrBuilder {
        private Builder() {
            super(Method.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllOptions(Iterable<? extends Option> iterable) {
            a();
            ((Method) this.a).addAllOptions(iterable);
            return this;
        }

        public Builder addOptions(int i, Option.Builder builder) {
            a();
            ((Method) this.a).addOptions(i, builder);
            return this;
        }

        public Builder addOptions(int i, Option option) {
            a();
            ((Method) this.a).addOptions(i, option);
            return this;
        }

        public Builder addOptions(Option.Builder builder) {
            a();
            ((Method) this.a).addOptions(builder);
            return this;
        }

        public Builder addOptions(Option option) {
            a();
            ((Method) this.a).addOptions(option);
            return this;
        }

        public Builder clearName() {
            a();
            ((Method) this.a).clearName();
            return this;
        }

        public Builder clearOptions() {
            a();
            ((Method) this.a).clearOptions();
            return this;
        }

        public Builder clearRequestStreaming() {
            a();
            ((Method) this.a).clearRequestStreaming();
            return this;
        }

        public Builder clearRequestTypeUrl() {
            a();
            ((Method) this.a).clearRequestTypeUrl();
            return this;
        }

        public Builder clearResponseStreaming() {
            a();
            ((Method) this.a).clearResponseStreaming();
            return this;
        }

        public Builder clearResponseTypeUrl() {
            a();
            ((Method) this.a).clearResponseTypeUrl();
            return this;
        }

        public Builder clearSyntax() {
            a();
            ((Method) this.a).clearSyntax();
            return this;
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public String getName() {
            return ((Method) this.a).getName();
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public ByteString getNameBytes() {
            return ((Method) this.a).getNameBytes();
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public Option getOptions(int i) {
            return ((Method) this.a).getOptions(i);
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public int getOptionsCount() {
            return ((Method) this.a).getOptionsCount();
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public List<Option> getOptionsList() {
            return Collections.unmodifiableList(((Method) this.a).getOptionsList());
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public boolean getRequestStreaming() {
            return ((Method) this.a).getRequestStreaming();
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public String getRequestTypeUrl() {
            return ((Method) this.a).getRequestTypeUrl();
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public ByteString getRequestTypeUrlBytes() {
            return ((Method) this.a).getRequestTypeUrlBytes();
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public boolean getResponseStreaming() {
            return ((Method) this.a).getResponseStreaming();
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public String getResponseTypeUrl() {
            return ((Method) this.a).getResponseTypeUrl();
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public ByteString getResponseTypeUrlBytes() {
            return ((Method) this.a).getResponseTypeUrlBytes();
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public Syntax getSyntax() {
            return ((Method) this.a).getSyntax();
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public int getSyntaxValue() {
            return ((Method) this.a).getSyntaxValue();
        }

        public Builder removeOptions(int i) {
            a();
            ((Method) this.a).removeOptions(i);
            return this;
        }

        public Builder setName(String str) {
            a();
            ((Method) this.a).setName(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            a();
            ((Method) this.a).setNameBytes(byteString);
            return this;
        }

        public Builder setOptions(int i, Option.Builder builder) {
            a();
            ((Method) this.a).setOptions(i, builder);
            return this;
        }

        public Builder setOptions(int i, Option option) {
            a();
            ((Method) this.a).setOptions(i, option);
            return this;
        }

        public Builder setRequestStreaming(boolean z) {
            a();
            ((Method) this.a).setRequestStreaming(z);
            return this;
        }

        public Builder setRequestTypeUrl(String str) {
            a();
            ((Method) this.a).setRequestTypeUrl(str);
            return this;
        }

        public Builder setRequestTypeUrlBytes(ByteString byteString) {
            a();
            ((Method) this.a).setRequestTypeUrlBytes(byteString);
            return this;
        }

        public Builder setResponseStreaming(boolean z) {
            a();
            ((Method) this.a).setResponseStreaming(z);
            return this;
        }

        public Builder setResponseTypeUrl(String str) {
            a();
            ((Method) this.a).setResponseTypeUrl(str);
            return this;
        }

        public Builder setResponseTypeUrlBytes(ByteString byteString) {
            a();
            ((Method) this.a).setResponseTypeUrlBytes(byteString);
            return this;
        }

        public Builder setSyntax(Syntax syntax) {
            a();
            ((Method) this.a).setSyntax(syntax);
            return this;
        }

        public Builder setSyntaxValue(int i) {
            a();
            ((Method) this.a).setSyntaxValue(i);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private Method() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllOptions(Iterable<? extends Option> iterable) {
        ensureOptionsIsMutable();
        AbstractMessageLite.a(iterable, this.options_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOptions(int i, Option.Builder builder) {
        ensureOptionsIsMutable();
        this.options_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOptions(int i, Option option) {
        if (option == null) {
            throw new NullPointerException();
        }
        ensureOptionsIsMutable();
        this.options_.add(i, option);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOptions(Option.Builder builder) {
        ensureOptionsIsMutable();
        this.options_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOptions(Option option) {
        if (option == null) {
            throw new NullPointerException();
        }
        ensureOptionsIsMutable();
        this.options_.add(option);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOptions() {
        this.options_ = GeneratedMessageLite.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRequestStreaming() {
        this.requestStreaming_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRequestTypeUrl() {
        this.requestTypeUrl_ = getDefaultInstance().getRequestTypeUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResponseStreaming() {
        this.responseStreaming_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResponseTypeUrl() {
        this.responseTypeUrl_ = getDefaultInstance().getResponseTypeUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSyntax() {
        this.syntax_ = 0;
    }

    private void ensureOptionsIsMutable() {
        if (this.options_.isModifiable()) {
            return;
        }
        this.options_ = GeneratedMessageLite.a(this.options_);
    }

    public static Method getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Method method) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) method);
    }

    public static Method parseDelimitedFrom(InputStream inputStream) {
        return (Method) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static Method parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Method) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Method parseFrom(ByteString byteString) {
        return (Method) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static Method parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Method) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Method parseFrom(CodedInputStream codedInputStream) {
        return (Method) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Method parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Method) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Method parseFrom(InputStream inputStream) {
        return (Method) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static Method parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Method) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Method parseFrom(byte[] bArr) {
        return (Method) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static Method parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Method) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<Method> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeOptions(int i) {
        ensureOptionsIsMutable();
        this.options_.remove(i);
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
    public void setOptions(int i, Option.Builder builder) {
        ensureOptionsIsMutable();
        this.options_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOptions(int i, Option option) {
        if (option == null) {
            throw new NullPointerException();
        }
        ensureOptionsIsMutable();
        this.options_.set(i, option);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequestStreaming(boolean z) {
        this.requestStreaming_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequestTypeUrl(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.requestTypeUrl_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequestTypeUrlBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.requestTypeUrl_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResponseStreaming(boolean z) {
        this.responseStreaming_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResponseTypeUrl(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.responseTypeUrl_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResponseTypeUrlBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.responseTypeUrl_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSyntax(Syntax syntax) {
        if (syntax == null) {
            throw new NullPointerException();
        }
        this.syntax_ = syntax.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSyntaxValue(int i) {
        this.syntax_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new Method();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.options_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Method method = (Method) obj2;
                this.name_ = visitor.visitString(!this.name_.isEmpty(), this.name_, !method.name_.isEmpty(), method.name_);
                this.requestTypeUrl_ = visitor.visitString(!this.requestTypeUrl_.isEmpty(), this.requestTypeUrl_, !method.requestTypeUrl_.isEmpty(), method.requestTypeUrl_);
                boolean z = this.requestStreaming_;
                boolean z2 = method.requestStreaming_;
                this.requestStreaming_ = visitor.visitBoolean(z, z, z2, z2);
                this.responseTypeUrl_ = visitor.visitString(!this.responseTypeUrl_.isEmpty(), this.responseTypeUrl_, !method.responseTypeUrl_.isEmpty(), method.responseTypeUrl_);
                boolean z3 = this.responseStreaming_;
                boolean z4 = method.responseStreaming_;
                this.responseStreaming_ = visitor.visitBoolean(z3, z3, z4, z4);
                this.options_ = visitor.visitList(this.options_, method.options_);
                this.syntax_ = visitor.visitInt(this.syntax_ != 0, this.syntax_, method.syntax_ != 0, method.syntax_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= method.bitField0_;
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
                                this.requestTypeUrl_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 24) {
                                this.requestStreaming_ = codedInputStream.readBool();
                            } else if (readTag == 34) {
                                this.responseTypeUrl_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 40) {
                                this.responseStreaming_ = codedInputStream.readBool();
                            } else if (readTag == 50) {
                                if (!this.options_.isModifiable()) {
                                    this.options_ = GeneratedMessageLite.a(this.options_);
                                }
                                this.options_.add((Option) codedInputStream.readMessage(Option.parser(), extensionRegistryLite));
                            } else if (readTag == 56) {
                                this.syntax_ = codedInputStream.readEnum();
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
                    synchronized (Method.class) {
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

    @Override // com.google.protobuf.MethodOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public Option getOptions(int i) {
        return this.options_.get(i);
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public List<Option> getOptionsList() {
        return this.options_;
    }

    public OptionOrBuilder getOptionsOrBuilder(int i) {
        return this.options_.get(i);
    }

    public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.options_;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public boolean getRequestStreaming() {
        return this.requestStreaming_;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public String getRequestTypeUrl() {
        return this.requestTypeUrl_;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public ByteString getRequestTypeUrlBytes() {
        return ByteString.copyFromUtf8(this.requestTypeUrl_);
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public boolean getResponseStreaming() {
        return this.responseStreaming_;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public String getResponseTypeUrl() {
        return this.responseTypeUrl_;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public ByteString getResponseTypeUrlBytes() {
        return ByteString.copyFromUtf8(this.responseTypeUrl_);
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeStringSize = !this.name_.isEmpty() ? CodedOutputStream.computeStringSize(1, getName()) + 0 : 0;
        if (!this.requestTypeUrl_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(2, getRequestTypeUrl());
        }
        boolean z = this.requestStreaming_;
        if (z) {
            computeStringSize += CodedOutputStream.computeBoolSize(3, z);
        }
        if (!this.responseTypeUrl_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(4, getResponseTypeUrl());
        }
        boolean z2 = this.responseStreaming_;
        if (z2) {
            computeStringSize += CodedOutputStream.computeBoolSize(5, z2);
        }
        for (int i2 = 0; i2 < this.options_.size(); i2++) {
            computeStringSize += CodedOutputStream.computeMessageSize(6, this.options_.get(i2));
        }
        if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
            computeStringSize += CodedOutputStream.computeEnumSize(7, this.syntax_);
        }
        this.c = computeStringSize;
        return computeStringSize;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public Syntax getSyntax() {
        Syntax forNumber = Syntax.forNumber(this.syntax_);
        return forNumber == null ? Syntax.UNRECOGNIZED : forNumber;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public int getSyntaxValue() {
        return this.syntax_;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!this.name_.isEmpty()) {
            codedOutputStream.writeString(1, getName());
        }
        if (!this.requestTypeUrl_.isEmpty()) {
            codedOutputStream.writeString(2, getRequestTypeUrl());
        }
        boolean z = this.requestStreaming_;
        if (z) {
            codedOutputStream.writeBool(3, z);
        }
        if (!this.responseTypeUrl_.isEmpty()) {
            codedOutputStream.writeString(4, getResponseTypeUrl());
        }
        boolean z2 = this.responseStreaming_;
        if (z2) {
            codedOutputStream.writeBool(5, z2);
        }
        for (int i = 0; i < this.options_.size(); i++) {
            codedOutputStream.writeMessage(6, this.options_.get(i));
        }
        if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
            codedOutputStream.writeEnum(7, this.syntax_);
        }
    }
}
