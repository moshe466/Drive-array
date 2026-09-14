package com.google.protobuf;

import com.google.protobuf.EnumValue;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Option;
import com.google.protobuf.SourceContext;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class Enum extends GeneratedMessageLite<Enum, Builder> implements EnumOrBuilder {
    private static final Enum DEFAULT_INSTANCE = new Enum();
    public static final int ENUMVALUE_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private static volatile Parser<Enum> PARSER = null;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 4;
    public static final int SYNTAX_FIELD_NUMBER = 5;
    private int bitField0_;
    private SourceContext sourceContext_;
    private int syntax_;
    private String name_ = "";
    private Internal.ProtobufList<EnumValue> enumvalue_ = GeneratedMessageLite.f();
    private Internal.ProtobufList<Option> options_ = GeneratedMessageLite.f();

    /* renamed from: com.google.protobuf.Enum$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<Enum, Builder> implements EnumOrBuilder {
        private Builder() {
            super(Enum.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllEnumvalue(Iterable<? extends EnumValue> iterable) {
            a();
            ((Enum) this.a).addAllEnumvalue(iterable);
            return this;
        }

        public Builder addAllOptions(Iterable<? extends Option> iterable) {
            a();
            ((Enum) this.a).addAllOptions(iterable);
            return this;
        }

        public Builder addEnumvalue(int i, EnumValue.Builder builder) {
            a();
            ((Enum) this.a).addEnumvalue(i, builder);
            return this;
        }

        public Builder addEnumvalue(int i, EnumValue enumValue) {
            a();
            ((Enum) this.a).addEnumvalue(i, enumValue);
            return this;
        }

        public Builder addEnumvalue(EnumValue.Builder builder) {
            a();
            ((Enum) this.a).addEnumvalue(builder);
            return this;
        }

        public Builder addEnumvalue(EnumValue enumValue) {
            a();
            ((Enum) this.a).addEnumvalue(enumValue);
            return this;
        }

        public Builder addOptions(int i, Option.Builder builder) {
            a();
            ((Enum) this.a).addOptions(i, builder);
            return this;
        }

        public Builder addOptions(int i, Option option) {
            a();
            ((Enum) this.a).addOptions(i, option);
            return this;
        }

        public Builder addOptions(Option.Builder builder) {
            a();
            ((Enum) this.a).addOptions(builder);
            return this;
        }

        public Builder addOptions(Option option) {
            a();
            ((Enum) this.a).addOptions(option);
            return this;
        }

        public Builder clearEnumvalue() {
            a();
            ((Enum) this.a).clearEnumvalue();
            return this;
        }

        public Builder clearName() {
            a();
            ((Enum) this.a).clearName();
            return this;
        }

        public Builder clearOptions() {
            a();
            ((Enum) this.a).clearOptions();
            return this;
        }

        public Builder clearSourceContext() {
            a();
            ((Enum) this.a).clearSourceContext();
            return this;
        }

        public Builder clearSyntax() {
            a();
            ((Enum) this.a).clearSyntax();
            return this;
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public EnumValue getEnumvalue(int i) {
            return ((Enum) this.a).getEnumvalue(i);
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public int getEnumvalueCount() {
            return ((Enum) this.a).getEnumvalueCount();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public List<EnumValue> getEnumvalueList() {
            return Collections.unmodifiableList(((Enum) this.a).getEnumvalueList());
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public String getName() {
            return ((Enum) this.a).getName();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public ByteString getNameBytes() {
            return ((Enum) this.a).getNameBytes();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public Option getOptions(int i) {
            return ((Enum) this.a).getOptions(i);
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public int getOptionsCount() {
            return ((Enum) this.a).getOptionsCount();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public List<Option> getOptionsList() {
            return Collections.unmodifiableList(((Enum) this.a).getOptionsList());
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public SourceContext getSourceContext() {
            return ((Enum) this.a).getSourceContext();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public Syntax getSyntax() {
            return ((Enum) this.a).getSyntax();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public int getSyntaxValue() {
            return ((Enum) this.a).getSyntaxValue();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public boolean hasSourceContext() {
            return ((Enum) this.a).hasSourceContext();
        }

        public Builder mergeSourceContext(SourceContext sourceContext) {
            a();
            ((Enum) this.a).mergeSourceContext(sourceContext);
            return this;
        }

        public Builder removeEnumvalue(int i) {
            a();
            ((Enum) this.a).removeEnumvalue(i);
            return this;
        }

        public Builder removeOptions(int i) {
            a();
            ((Enum) this.a).removeOptions(i);
            return this;
        }

        public Builder setEnumvalue(int i, EnumValue.Builder builder) {
            a();
            ((Enum) this.a).setEnumvalue(i, builder);
            return this;
        }

        public Builder setEnumvalue(int i, EnumValue enumValue) {
            a();
            ((Enum) this.a).setEnumvalue(i, enumValue);
            return this;
        }

        public Builder setName(String str) {
            a();
            ((Enum) this.a).setName(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            a();
            ((Enum) this.a).setNameBytes(byteString);
            return this;
        }

        public Builder setOptions(int i, Option.Builder builder) {
            a();
            ((Enum) this.a).setOptions(i, builder);
            return this;
        }

        public Builder setOptions(int i, Option option) {
            a();
            ((Enum) this.a).setOptions(i, option);
            return this;
        }

        public Builder setSourceContext(SourceContext.Builder builder) {
            a();
            ((Enum) this.a).setSourceContext(builder);
            return this;
        }

        public Builder setSourceContext(SourceContext sourceContext) {
            a();
            ((Enum) this.a).setSourceContext(sourceContext);
            return this;
        }

        public Builder setSyntax(Syntax syntax) {
            a();
            ((Enum) this.a).setSyntax(syntax);
            return this;
        }

        public Builder setSyntaxValue(int i) {
            a();
            ((Enum) this.a).setSyntaxValue(i);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private Enum() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllEnumvalue(Iterable<? extends EnumValue> iterable) {
        ensureEnumvalueIsMutable();
        AbstractMessageLite.a(iterable, this.enumvalue_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllOptions(Iterable<? extends Option> iterable) {
        ensureOptionsIsMutable();
        AbstractMessageLite.a(iterable, this.options_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addEnumvalue(int i, EnumValue.Builder builder) {
        ensureEnumvalueIsMutable();
        this.enumvalue_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addEnumvalue(int i, EnumValue enumValue) {
        if (enumValue == null) {
            throw new NullPointerException();
        }
        ensureEnumvalueIsMutable();
        this.enumvalue_.add(i, enumValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addEnumvalue(EnumValue.Builder builder) {
        ensureEnumvalueIsMutable();
        this.enumvalue_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addEnumvalue(EnumValue enumValue) {
        if (enumValue == null) {
            throw new NullPointerException();
        }
        ensureEnumvalueIsMutable();
        this.enumvalue_.add(enumValue);
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
    public void clearEnumvalue() {
        this.enumvalue_ = GeneratedMessageLite.f();
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
    public void clearSourceContext() {
        this.sourceContext_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSyntax() {
        this.syntax_ = 0;
    }

    private void ensureEnumvalueIsMutable() {
        if (this.enumvalue_.isModifiable()) {
            return;
        }
        this.enumvalue_ = GeneratedMessageLite.a(this.enumvalue_);
    }

    private void ensureOptionsIsMutable() {
        if (this.options_.isModifiable()) {
            return;
        }
        this.options_ = GeneratedMessageLite.a(this.options_);
    }

    public static Enum getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSourceContext(SourceContext sourceContext) {
        SourceContext sourceContext2 = this.sourceContext_;
        if (sourceContext2 != null && sourceContext2 != SourceContext.getDefaultInstance()) {
            sourceContext = SourceContext.newBuilder(this.sourceContext_).mergeFrom((SourceContext.Builder) sourceContext).buildPartial();
        }
        this.sourceContext_ = sourceContext;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Enum r1) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) r1);
    }

    public static Enum parseDelimitedFrom(InputStream inputStream) {
        return (Enum) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static Enum parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Enum) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Enum parseFrom(ByteString byteString) {
        return (Enum) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static Enum parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Enum) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Enum parseFrom(CodedInputStream codedInputStream) {
        return (Enum) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Enum parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Enum) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Enum parseFrom(InputStream inputStream) {
        return (Enum) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static Enum parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Enum) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Enum parseFrom(byte[] bArr) {
        return (Enum) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static Enum parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Enum) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<Enum> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeEnumvalue(int i) {
        ensureEnumvalueIsMutable();
        this.enumvalue_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeOptions(int i) {
        ensureOptionsIsMutable();
        this.options_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEnumvalue(int i, EnumValue.Builder builder) {
        ensureEnumvalueIsMutable();
        this.enumvalue_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEnumvalue(int i, EnumValue enumValue) {
        if (enumValue == null) {
            throw new NullPointerException();
        }
        ensureEnumvalueIsMutable();
        this.enumvalue_.set(i, enumValue);
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
    public void setSourceContext(SourceContext.Builder builder) {
        this.sourceContext_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSourceContext(SourceContext sourceContext) {
        if (sourceContext == null) {
            throw new NullPointerException();
        }
        this.sourceContext_ = sourceContext;
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
        List list;
        MessageLite messageLite;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new Enum();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.enumvalue_.makeImmutable();
                this.options_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Enum r8 = (Enum) obj2;
                this.name_ = visitor.visitString(!this.name_.isEmpty(), this.name_, !r8.name_.isEmpty(), r8.name_);
                this.enumvalue_ = visitor.visitList(this.enumvalue_, r8.enumvalue_);
                this.options_ = visitor.visitList(this.options_, r8.options_);
                this.sourceContext_ = (SourceContext) visitor.visitMessage(this.sourceContext_, r8.sourceContext_);
                this.syntax_ = visitor.visitInt(this.syntax_ != 0, this.syntax_, r8.syntax_ != 0, r8.syntax_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= r8.bitField0_;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!r0) {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag != 10) {
                                    if (readTag == 18) {
                                        if (!this.enumvalue_.isModifiable()) {
                                            this.enumvalue_ = GeneratedMessageLite.a(this.enumvalue_);
                                        }
                                        list = this.enumvalue_;
                                        messageLite = (EnumValue) codedInputStream.readMessage(EnumValue.parser(), extensionRegistryLite);
                                    } else if (readTag == 26) {
                                        if (!this.options_.isModifiable()) {
                                            this.options_ = GeneratedMessageLite.a(this.options_);
                                        }
                                        list = this.options_;
                                        messageLite = (Option) codedInputStream.readMessage(Option.parser(), extensionRegistryLite);
                                    } else if (readTag == 34) {
                                        SourceContext.Builder builder = this.sourceContext_ != null ? this.sourceContext_.toBuilder() : null;
                                        this.sourceContext_ = (SourceContext) codedInputStream.readMessage(SourceContext.parser(), extensionRegistryLite);
                                        if (builder != null) {
                                            builder.mergeFrom((SourceContext.Builder) this.sourceContext_);
                                            this.sourceContext_ = builder.buildPartial();
                                        }
                                    } else if (readTag == 40) {
                                        this.syntax_ = codedInputStream.readEnum();
                                    } else if (!codedInputStream.skipField(readTag)) {
                                    }
                                    list.add(messageLite);
                                } else {
                                    this.name_ = codedInputStream.readStringRequireUtf8();
                                }
                            }
                            r0 = true;
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
                    synchronized (Enum.class) {
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

    @Override // com.google.protobuf.EnumOrBuilder
    public EnumValue getEnumvalue(int i) {
        return this.enumvalue_.get(i);
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public int getEnumvalueCount() {
        return this.enumvalue_.size();
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public List<EnumValue> getEnumvalueList() {
        return this.enumvalue_;
    }

    public EnumValueOrBuilder getEnumvalueOrBuilder(int i) {
        return this.enumvalue_.get(i);
    }

    public List<? extends EnumValueOrBuilder> getEnumvalueOrBuilderList() {
        return this.enumvalue_;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public Option getOptions(int i) {
        return this.options_.get(i);
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public List<Option> getOptionsList() {
        return this.options_;
    }

    public OptionOrBuilder getOptionsOrBuilder(int i) {
        return this.options_.get(i);
    }

    public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.options_;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeStringSize = !this.name_.isEmpty() ? CodedOutputStream.computeStringSize(1, getName()) + 0 : 0;
        for (int i2 = 0; i2 < this.enumvalue_.size(); i2++) {
            computeStringSize += CodedOutputStream.computeMessageSize(2, this.enumvalue_.get(i2));
        }
        for (int i3 = 0; i3 < this.options_.size(); i3++) {
            computeStringSize += CodedOutputStream.computeMessageSize(3, this.options_.get(i3));
        }
        if (this.sourceContext_ != null) {
            computeStringSize += CodedOutputStream.computeMessageSize(4, getSourceContext());
        }
        if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
            computeStringSize += CodedOutputStream.computeEnumSize(5, this.syntax_);
        }
        this.c = computeStringSize;
        return computeStringSize;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public SourceContext getSourceContext() {
        SourceContext sourceContext = this.sourceContext_;
        return sourceContext == null ? SourceContext.getDefaultInstance() : sourceContext;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public Syntax getSyntax() {
        Syntax forNumber = Syntax.forNumber(this.syntax_);
        return forNumber == null ? Syntax.UNRECOGNIZED : forNumber;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public int getSyntaxValue() {
        return this.syntax_;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public boolean hasSourceContext() {
        return this.sourceContext_ != null;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!this.name_.isEmpty()) {
            codedOutputStream.writeString(1, getName());
        }
        for (int i = 0; i < this.enumvalue_.size(); i++) {
            codedOutputStream.writeMessage(2, this.enumvalue_.get(i));
        }
        for (int i2 = 0; i2 < this.options_.size(); i2++) {
            codedOutputStream.writeMessage(3, this.options_.get(i2));
        }
        if (this.sourceContext_ != null) {
            codedOutputStream.writeMessage(4, getSourceContext());
        }
        if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
            codedOutputStream.writeEnum(5, this.syntax_);
        }
    }
}
