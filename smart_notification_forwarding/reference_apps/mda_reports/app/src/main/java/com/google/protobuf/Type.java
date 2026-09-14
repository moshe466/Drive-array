package com.google.protobuf;

import com.google.protobuf.Field;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Option;
import com.google.protobuf.SourceContext;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class Type extends GeneratedMessageLite<Type, Builder> implements TypeOrBuilder {
    private static final Type DEFAULT_INSTANCE = new Type();
    public static final int FIELDS_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int ONEOFS_FIELD_NUMBER = 3;
    public static final int OPTIONS_FIELD_NUMBER = 4;
    private static volatile Parser<Type> PARSER = null;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 5;
    public static final int SYNTAX_FIELD_NUMBER = 6;
    private int bitField0_;
    private SourceContext sourceContext_;
    private int syntax_;
    private String name_ = "";
    private Internal.ProtobufList<Field> fields_ = GeneratedMessageLite.f();
    private Internal.ProtobufList<String> oneofs_ = GeneratedMessageLite.f();
    private Internal.ProtobufList<Option> options_ = GeneratedMessageLite.f();

    /* renamed from: com.google.protobuf.Type$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<Type, Builder> implements TypeOrBuilder {
        private Builder() {
            super(Type.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllFields(Iterable<? extends Field> iterable) {
            a();
            ((Type) this.a).addAllFields(iterable);
            return this;
        }

        public Builder addAllOneofs(Iterable<String> iterable) {
            a();
            ((Type) this.a).addAllOneofs(iterable);
            return this;
        }

        public Builder addAllOptions(Iterable<? extends Option> iterable) {
            a();
            ((Type) this.a).addAllOptions(iterable);
            return this;
        }

        public Builder addFields(int i, Field.Builder builder) {
            a();
            ((Type) this.a).addFields(i, builder);
            return this;
        }

        public Builder addFields(int i, Field field) {
            a();
            ((Type) this.a).addFields(i, field);
            return this;
        }

        public Builder addFields(Field.Builder builder) {
            a();
            ((Type) this.a).addFields(builder);
            return this;
        }

        public Builder addFields(Field field) {
            a();
            ((Type) this.a).addFields(field);
            return this;
        }

        public Builder addOneofs(String str) {
            a();
            ((Type) this.a).addOneofs(str);
            return this;
        }

        public Builder addOneofsBytes(ByteString byteString) {
            a();
            ((Type) this.a).addOneofsBytes(byteString);
            return this;
        }

        public Builder addOptions(int i, Option.Builder builder) {
            a();
            ((Type) this.a).addOptions(i, builder);
            return this;
        }

        public Builder addOptions(int i, Option option) {
            a();
            ((Type) this.a).addOptions(i, option);
            return this;
        }

        public Builder addOptions(Option.Builder builder) {
            a();
            ((Type) this.a).addOptions(builder);
            return this;
        }

        public Builder addOptions(Option option) {
            a();
            ((Type) this.a).addOptions(option);
            return this;
        }

        public Builder clearFields() {
            a();
            ((Type) this.a).clearFields();
            return this;
        }

        public Builder clearName() {
            a();
            ((Type) this.a).clearName();
            return this;
        }

        public Builder clearOneofs() {
            a();
            ((Type) this.a).clearOneofs();
            return this;
        }

        public Builder clearOptions() {
            a();
            ((Type) this.a).clearOptions();
            return this;
        }

        public Builder clearSourceContext() {
            a();
            ((Type) this.a).clearSourceContext();
            return this;
        }

        public Builder clearSyntax() {
            a();
            ((Type) this.a).clearSyntax();
            return this;
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public Field getFields(int i) {
            return ((Type) this.a).getFields(i);
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public int getFieldsCount() {
            return ((Type) this.a).getFieldsCount();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public List<Field> getFieldsList() {
            return Collections.unmodifiableList(((Type) this.a).getFieldsList());
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public String getName() {
            return ((Type) this.a).getName();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public ByteString getNameBytes() {
            return ((Type) this.a).getNameBytes();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public String getOneofs(int i) {
            return ((Type) this.a).getOneofs(i);
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public ByteString getOneofsBytes(int i) {
            return ((Type) this.a).getOneofsBytes(i);
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public int getOneofsCount() {
            return ((Type) this.a).getOneofsCount();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public List<String> getOneofsList() {
            return Collections.unmodifiableList(((Type) this.a).getOneofsList());
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public Option getOptions(int i) {
            return ((Type) this.a).getOptions(i);
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public int getOptionsCount() {
            return ((Type) this.a).getOptionsCount();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public List<Option> getOptionsList() {
            return Collections.unmodifiableList(((Type) this.a).getOptionsList());
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public SourceContext getSourceContext() {
            return ((Type) this.a).getSourceContext();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public Syntax getSyntax() {
            return ((Type) this.a).getSyntax();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public int getSyntaxValue() {
            return ((Type) this.a).getSyntaxValue();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public boolean hasSourceContext() {
            return ((Type) this.a).hasSourceContext();
        }

        public Builder mergeSourceContext(SourceContext sourceContext) {
            a();
            ((Type) this.a).mergeSourceContext(sourceContext);
            return this;
        }

        public Builder removeFields(int i) {
            a();
            ((Type) this.a).removeFields(i);
            return this;
        }

        public Builder removeOptions(int i) {
            a();
            ((Type) this.a).removeOptions(i);
            return this;
        }

        public Builder setFields(int i, Field.Builder builder) {
            a();
            ((Type) this.a).setFields(i, builder);
            return this;
        }

        public Builder setFields(int i, Field field) {
            a();
            ((Type) this.a).setFields(i, field);
            return this;
        }

        public Builder setName(String str) {
            a();
            ((Type) this.a).setName(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            a();
            ((Type) this.a).setNameBytes(byteString);
            return this;
        }

        public Builder setOneofs(int i, String str) {
            a();
            ((Type) this.a).setOneofs(i, str);
            return this;
        }

        public Builder setOptions(int i, Option.Builder builder) {
            a();
            ((Type) this.a).setOptions(i, builder);
            return this;
        }

        public Builder setOptions(int i, Option option) {
            a();
            ((Type) this.a).setOptions(i, option);
            return this;
        }

        public Builder setSourceContext(SourceContext.Builder builder) {
            a();
            ((Type) this.a).setSourceContext(builder);
            return this;
        }

        public Builder setSourceContext(SourceContext sourceContext) {
            a();
            ((Type) this.a).setSourceContext(sourceContext);
            return this;
        }

        public Builder setSyntax(Syntax syntax) {
            a();
            ((Type) this.a).setSyntax(syntax);
            return this;
        }

        public Builder setSyntaxValue(int i) {
            a();
            ((Type) this.a).setSyntaxValue(i);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private Type() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllFields(Iterable<? extends Field> iterable) {
        ensureFieldsIsMutable();
        AbstractMessageLite.a(iterable, this.fields_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllOneofs(Iterable<String> iterable) {
        ensureOneofsIsMutable();
        AbstractMessageLite.a(iterable, this.oneofs_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllOptions(Iterable<? extends Option> iterable) {
        ensureOptionsIsMutable();
        AbstractMessageLite.a(iterable, this.options_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFields(int i, Field.Builder builder) {
        ensureFieldsIsMutable();
        this.fields_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFields(int i, Field field) {
        if (field == null) {
            throw new NullPointerException();
        }
        ensureFieldsIsMutable();
        this.fields_.add(i, field);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFields(Field.Builder builder) {
        ensureFieldsIsMutable();
        this.fields_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFields(Field field) {
        if (field == null) {
            throw new NullPointerException();
        }
        ensureFieldsIsMutable();
        this.fields_.add(field);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOneofs(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        ensureOneofsIsMutable();
        this.oneofs_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOneofsBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        ensureOneofsIsMutable();
        this.oneofs_.add(byteString.toStringUtf8());
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
    public void clearFields() {
        this.fields_ = GeneratedMessageLite.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOneofs() {
        this.oneofs_ = GeneratedMessageLite.f();
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

    private void ensureFieldsIsMutable() {
        if (this.fields_.isModifiable()) {
            return;
        }
        this.fields_ = GeneratedMessageLite.a(this.fields_);
    }

    private void ensureOneofsIsMutable() {
        if (this.oneofs_.isModifiable()) {
            return;
        }
        this.oneofs_ = GeneratedMessageLite.a(this.oneofs_);
    }

    private void ensureOptionsIsMutable() {
        if (this.options_.isModifiable()) {
            return;
        }
        this.options_ = GeneratedMessageLite.a(this.options_);
    }

    public static Type getDefaultInstance() {
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

    public static Builder newBuilder(Type type) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) type);
    }

    public static Type parseDelimitedFrom(InputStream inputStream) {
        return (Type) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static Type parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Type) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Type parseFrom(ByteString byteString) {
        return (Type) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static Type parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Type) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Type parseFrom(CodedInputStream codedInputStream) {
        return (Type) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Type parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Type) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Type parseFrom(InputStream inputStream) {
        return (Type) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static Type parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Type) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Type parseFrom(byte[] bArr) {
        return (Type) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static Type parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Type) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<Type> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeFields(int i) {
        ensureFieldsIsMutable();
        this.fields_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeOptions(int i) {
        ensureOptionsIsMutable();
        this.options_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFields(int i, Field.Builder builder) {
        ensureFieldsIsMutable();
        this.fields_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFields(int i, Field field) {
        if (field == null) {
            throw new NullPointerException();
        }
        ensureFieldsIsMutable();
        this.fields_.set(i, field);
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
    public void setOneofs(int i, String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        ensureOneofsIsMutable();
        this.oneofs_.set(i, str);
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
                return new Type();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.fields_.makeImmutable();
                this.oneofs_.makeImmutable();
                this.options_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Type type = (Type) obj2;
                this.name_ = visitor.visitString(!this.name_.isEmpty(), this.name_, !type.name_.isEmpty(), type.name_);
                this.fields_ = visitor.visitList(this.fields_, type.fields_);
                this.oneofs_ = visitor.visitList(this.oneofs_, type.oneofs_);
                this.options_ = visitor.visitList(this.options_, type.options_);
                this.sourceContext_ = (SourceContext) visitor.visitMessage(this.sourceContext_, type.sourceContext_);
                this.syntax_ = visitor.visitInt(this.syntax_ != 0, this.syntax_, type.syntax_ != 0, type.syntax_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= type.bitField0_;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!r0) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag != 10) {
                                if (readTag == 18) {
                                    if (!this.fields_.isModifiable()) {
                                        this.fields_ = GeneratedMessageLite.a(this.fields_);
                                    }
                                    list = this.fields_;
                                    messageLite = (Field) codedInputStream.readMessage(Field.parser(), extensionRegistryLite);
                                } else if (readTag == 26) {
                                    String readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                    if (!this.oneofs_.isModifiable()) {
                                        this.oneofs_ = GeneratedMessageLite.a(this.oneofs_);
                                    }
                                    this.oneofs_.add(readStringRequireUtf8);
                                } else if (readTag == 34) {
                                    if (!this.options_.isModifiable()) {
                                        this.options_ = GeneratedMessageLite.a(this.options_);
                                    }
                                    list = this.options_;
                                    messageLite = (Option) codedInputStream.readMessage(Option.parser(), extensionRegistryLite);
                                } else if (readTag == 42) {
                                    SourceContext.Builder builder = this.sourceContext_ != null ? this.sourceContext_.toBuilder() : null;
                                    this.sourceContext_ = (SourceContext) codedInputStream.readMessage(SourceContext.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom((SourceContext.Builder) this.sourceContext_);
                                        this.sourceContext_ = builder.buildPartial();
                                    }
                                } else if (readTag == 48) {
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
                    } catch (IOException e2) {
                        throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                    }
                }
                break;
            case 7:
                break;
            case 8:
                if (PARSER == null) {
                    synchronized (Type.class) {
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

    @Override // com.google.protobuf.TypeOrBuilder
    public Field getFields(int i) {
        return this.fields_.get(i);
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public int getFieldsCount() {
        return this.fields_.size();
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public List<Field> getFieldsList() {
        return this.fields_;
    }

    public FieldOrBuilder getFieldsOrBuilder(int i) {
        return this.fields_.get(i);
    }

    public List<? extends FieldOrBuilder> getFieldsOrBuilderList() {
        return this.fields_;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public String getOneofs(int i) {
        return this.oneofs_.get(i);
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public ByteString getOneofsBytes(int i) {
        return ByteString.copyFromUtf8(this.oneofs_.get(i));
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public int getOneofsCount() {
        return this.oneofs_.size();
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public List<String> getOneofsList() {
        return this.oneofs_;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public Option getOptions(int i) {
        return this.options_.get(i);
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.google.protobuf.TypeOrBuilder
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
        for (int i2 = 0; i2 < this.fields_.size(); i2++) {
            computeStringSize += CodedOutputStream.computeMessageSize(2, this.fields_.get(i2));
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.oneofs_.size(); i4++) {
            i3 += CodedOutputStream.computeStringSizeNoTag(this.oneofs_.get(i4));
        }
        int size = computeStringSize + i3 + (getOneofsList().size() * 1);
        for (int i5 = 0; i5 < this.options_.size(); i5++) {
            size += CodedOutputStream.computeMessageSize(4, this.options_.get(i5));
        }
        if (this.sourceContext_ != null) {
            size += CodedOutputStream.computeMessageSize(5, getSourceContext());
        }
        if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
            size += CodedOutputStream.computeEnumSize(6, this.syntax_);
        }
        this.c = size;
        return size;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public SourceContext getSourceContext() {
        SourceContext sourceContext = this.sourceContext_;
        return sourceContext == null ? SourceContext.getDefaultInstance() : sourceContext;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public Syntax getSyntax() {
        Syntax forNumber = Syntax.forNumber(this.syntax_);
        return forNumber == null ? Syntax.UNRECOGNIZED : forNumber;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public int getSyntaxValue() {
        return this.syntax_;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public boolean hasSourceContext() {
        return this.sourceContext_ != null;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!this.name_.isEmpty()) {
            codedOutputStream.writeString(1, getName());
        }
        for (int i = 0; i < this.fields_.size(); i++) {
            codedOutputStream.writeMessage(2, this.fields_.get(i));
        }
        for (int i2 = 0; i2 < this.oneofs_.size(); i2++) {
            codedOutputStream.writeString(3, this.oneofs_.get(i2));
        }
        for (int i3 = 0; i3 < this.options_.size(); i3++) {
            codedOutputStream.writeMessage(4, this.options_.get(i3));
        }
        if (this.sourceContext_ != null) {
            codedOutputStream.writeMessage(5, getSourceContext());
        }
        if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
            codedOutputStream.writeEnum(6, this.syntax_);
        }
    }
}
