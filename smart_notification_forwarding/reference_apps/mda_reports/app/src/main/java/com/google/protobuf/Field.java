package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Option;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class Field extends GeneratedMessageLite<Field, Builder> implements FieldOrBuilder {
    public static final int CARDINALITY_FIELD_NUMBER = 2;
    private static final Field DEFAULT_INSTANCE = new Field();
    public static final int DEFAULT_VALUE_FIELD_NUMBER = 11;
    public static final int JSON_NAME_FIELD_NUMBER = 10;
    public static final int KIND_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 4;
    public static final int NUMBER_FIELD_NUMBER = 3;
    public static final int ONEOF_INDEX_FIELD_NUMBER = 7;
    public static final int OPTIONS_FIELD_NUMBER = 9;
    public static final int PACKED_FIELD_NUMBER = 8;
    private static volatile Parser<Field> PARSER = null;
    public static final int TYPE_URL_FIELD_NUMBER = 6;
    private int bitField0_;
    private int cardinality_;
    private int kind_;
    private int number_;
    private int oneofIndex_;
    private boolean packed_;
    private String name_ = "";
    private String typeUrl_ = "";
    private Internal.ProtobufList<Option> options_ = GeneratedMessageLite.f();
    private String jsonName_ = "";
    private String defaultValue_ = "";

    /* renamed from: com.google.protobuf.Field$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<Field, Builder> implements FieldOrBuilder {
        private Builder() {
            super(Field.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllOptions(Iterable<? extends Option> iterable) {
            a();
            ((Field) this.a).addAllOptions(iterable);
            return this;
        }

        public Builder addOptions(int i, Option.Builder builder) {
            a();
            ((Field) this.a).addOptions(i, builder);
            return this;
        }

        public Builder addOptions(int i, Option option) {
            a();
            ((Field) this.a).addOptions(i, option);
            return this;
        }

        public Builder addOptions(Option.Builder builder) {
            a();
            ((Field) this.a).addOptions(builder);
            return this;
        }

        public Builder addOptions(Option option) {
            a();
            ((Field) this.a).addOptions(option);
            return this;
        }

        public Builder clearCardinality() {
            a();
            ((Field) this.a).clearCardinality();
            return this;
        }

        public Builder clearDefaultValue() {
            a();
            ((Field) this.a).clearDefaultValue();
            return this;
        }

        public Builder clearJsonName() {
            a();
            ((Field) this.a).clearJsonName();
            return this;
        }

        public Builder clearKind() {
            a();
            ((Field) this.a).clearKind();
            return this;
        }

        public Builder clearName() {
            a();
            ((Field) this.a).clearName();
            return this;
        }

        public Builder clearNumber() {
            a();
            ((Field) this.a).clearNumber();
            return this;
        }

        public Builder clearOneofIndex() {
            a();
            ((Field) this.a).clearOneofIndex();
            return this;
        }

        public Builder clearOptions() {
            a();
            ((Field) this.a).clearOptions();
            return this;
        }

        public Builder clearPacked() {
            a();
            ((Field) this.a).clearPacked();
            return this;
        }

        public Builder clearTypeUrl() {
            a();
            ((Field) this.a).clearTypeUrl();
            return this;
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public Cardinality getCardinality() {
            return ((Field) this.a).getCardinality();
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public int getCardinalityValue() {
            return ((Field) this.a).getCardinalityValue();
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public String getDefaultValue() {
            return ((Field) this.a).getDefaultValue();
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public ByteString getDefaultValueBytes() {
            return ((Field) this.a).getDefaultValueBytes();
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public String getJsonName() {
            return ((Field) this.a).getJsonName();
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public ByteString getJsonNameBytes() {
            return ((Field) this.a).getJsonNameBytes();
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public Kind getKind() {
            return ((Field) this.a).getKind();
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public int getKindValue() {
            return ((Field) this.a).getKindValue();
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public String getName() {
            return ((Field) this.a).getName();
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public ByteString getNameBytes() {
            return ((Field) this.a).getNameBytes();
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public int getNumber() {
            return ((Field) this.a).getNumber();
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public int getOneofIndex() {
            return ((Field) this.a).getOneofIndex();
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public Option getOptions(int i) {
            return ((Field) this.a).getOptions(i);
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public int getOptionsCount() {
            return ((Field) this.a).getOptionsCount();
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public List<Option> getOptionsList() {
            return Collections.unmodifiableList(((Field) this.a).getOptionsList());
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public boolean getPacked() {
            return ((Field) this.a).getPacked();
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public String getTypeUrl() {
            return ((Field) this.a).getTypeUrl();
        }

        @Override // com.google.protobuf.FieldOrBuilder
        public ByteString getTypeUrlBytes() {
            return ((Field) this.a).getTypeUrlBytes();
        }

        public Builder removeOptions(int i) {
            a();
            ((Field) this.a).removeOptions(i);
            return this;
        }

        public Builder setCardinality(Cardinality cardinality) {
            a();
            ((Field) this.a).setCardinality(cardinality);
            return this;
        }

        public Builder setCardinalityValue(int i) {
            a();
            ((Field) this.a).setCardinalityValue(i);
            return this;
        }

        public Builder setDefaultValue(String str) {
            a();
            ((Field) this.a).setDefaultValue(str);
            return this;
        }

        public Builder setDefaultValueBytes(ByteString byteString) {
            a();
            ((Field) this.a).setDefaultValueBytes(byteString);
            return this;
        }

        public Builder setJsonName(String str) {
            a();
            ((Field) this.a).setJsonName(str);
            return this;
        }

        public Builder setJsonNameBytes(ByteString byteString) {
            a();
            ((Field) this.a).setJsonNameBytes(byteString);
            return this;
        }

        public Builder setKind(Kind kind) {
            a();
            ((Field) this.a).setKind(kind);
            return this;
        }

        public Builder setKindValue(int i) {
            a();
            ((Field) this.a).setKindValue(i);
            return this;
        }

        public Builder setName(String str) {
            a();
            ((Field) this.a).setName(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            a();
            ((Field) this.a).setNameBytes(byteString);
            return this;
        }

        public Builder setNumber(int i) {
            a();
            ((Field) this.a).setNumber(i);
            return this;
        }

        public Builder setOneofIndex(int i) {
            a();
            ((Field) this.a).setOneofIndex(i);
            return this;
        }

        public Builder setOptions(int i, Option.Builder builder) {
            a();
            ((Field) this.a).setOptions(i, builder);
            return this;
        }

        public Builder setOptions(int i, Option option) {
            a();
            ((Field) this.a).setOptions(i, option);
            return this;
        }

        public Builder setPacked(boolean z) {
            a();
            ((Field) this.a).setPacked(z);
            return this;
        }

        public Builder setTypeUrl(String str) {
            a();
            ((Field) this.a).setTypeUrl(str);
            return this;
        }

        public Builder setTypeUrlBytes(ByteString byteString) {
            a();
            ((Field) this.a).setTypeUrlBytes(byteString);
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public enum Cardinality implements Internal.EnumLite {
        CARDINALITY_UNKNOWN(0),
        CARDINALITY_OPTIONAL(1),
        CARDINALITY_REQUIRED(2),
        CARDINALITY_REPEATED(3),
        UNRECOGNIZED(-1);

        public static final int CARDINALITY_OPTIONAL_VALUE = 1;
        public static final int CARDINALITY_REPEATED_VALUE = 3;
        public static final int CARDINALITY_REQUIRED_VALUE = 2;
        public static final int CARDINALITY_UNKNOWN_VALUE = 0;
        private static final Internal.EnumLiteMap<Cardinality> internalValueMap = new Internal.EnumLiteMap<Cardinality>() { // from class: com.google.protobuf.Field.Cardinality.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public Cardinality findValueByNumber(int i) {
                return Cardinality.forNumber(i);
            }
        };
        private final int value;

        Cardinality(int i) {
            this.value = i;
        }

        public static Cardinality forNumber(int i) {
            if (i == 0) {
                return CARDINALITY_UNKNOWN;
            }
            if (i == 1) {
                return CARDINALITY_OPTIONAL;
            }
            if (i == 2) {
                return CARDINALITY_REQUIRED;
            }
            if (i != 3) {
                return null;
            }
            return CARDINALITY_REPEATED;
        }

        public static Internal.EnumLiteMap<Cardinality> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static Cardinality valueOf(int i) {
            return forNumber(i);
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }
    }

    /* loaded from: classes2.dex */
    public enum Kind implements Internal.EnumLite {
        TYPE_UNKNOWN(0),
        TYPE_DOUBLE(1),
        TYPE_FLOAT(2),
        TYPE_INT64(3),
        TYPE_UINT64(4),
        TYPE_INT32(5),
        TYPE_FIXED64(6),
        TYPE_FIXED32(7),
        TYPE_BOOL(8),
        TYPE_STRING(9),
        TYPE_GROUP(10),
        TYPE_MESSAGE(11),
        TYPE_BYTES(12),
        TYPE_UINT32(13),
        TYPE_ENUM(14),
        TYPE_SFIXED32(15),
        TYPE_SFIXED64(16),
        TYPE_SINT32(17),
        TYPE_SINT64(18),
        UNRECOGNIZED(-1);

        public static final int TYPE_BOOL_VALUE = 8;
        public static final int TYPE_BYTES_VALUE = 12;
        public static final int TYPE_DOUBLE_VALUE = 1;
        public static final int TYPE_ENUM_VALUE = 14;
        public static final int TYPE_FIXED32_VALUE = 7;
        public static final int TYPE_FIXED64_VALUE = 6;
        public static final int TYPE_FLOAT_VALUE = 2;
        public static final int TYPE_GROUP_VALUE = 10;
        public static final int TYPE_INT32_VALUE = 5;
        public static final int TYPE_INT64_VALUE = 3;
        public static final int TYPE_MESSAGE_VALUE = 11;
        public static final int TYPE_SFIXED32_VALUE = 15;
        public static final int TYPE_SFIXED64_VALUE = 16;
        public static final int TYPE_SINT32_VALUE = 17;
        public static final int TYPE_SINT64_VALUE = 18;
        public static final int TYPE_STRING_VALUE = 9;
        public static final int TYPE_UINT32_VALUE = 13;
        public static final int TYPE_UINT64_VALUE = 4;
        public static final int TYPE_UNKNOWN_VALUE = 0;
        private static final Internal.EnumLiteMap<Kind> internalValueMap = new Internal.EnumLiteMap<Kind>() { // from class: com.google.protobuf.Field.Kind.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public Kind findValueByNumber(int i) {
                return Kind.forNumber(i);
            }
        };
        private final int value;

        Kind(int i) {
            this.value = i;
        }

        public static Kind forNumber(int i) {
            switch (i) {
                case 0:
                    return TYPE_UNKNOWN;
                case 1:
                    return TYPE_DOUBLE;
                case 2:
                    return TYPE_FLOAT;
                case 3:
                    return TYPE_INT64;
                case 4:
                    return TYPE_UINT64;
                case 5:
                    return TYPE_INT32;
                case 6:
                    return TYPE_FIXED64;
                case 7:
                    return TYPE_FIXED32;
                case 8:
                    return TYPE_BOOL;
                case 9:
                    return TYPE_STRING;
                case 10:
                    return TYPE_GROUP;
                case 11:
                    return TYPE_MESSAGE;
                case 12:
                    return TYPE_BYTES;
                case 13:
                    return TYPE_UINT32;
                case 14:
                    return TYPE_ENUM;
                case 15:
                    return TYPE_SFIXED32;
                case 16:
                    return TYPE_SFIXED64;
                case 17:
                    return TYPE_SINT32;
                case 18:
                    return TYPE_SINT64;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<Kind> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static Kind valueOf(int i) {
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

    private Field() {
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
    public void clearCardinality() {
        this.cardinality_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDefaultValue() {
        this.defaultValue_ = getDefaultInstance().getDefaultValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearJsonName() {
        this.jsonName_ = getDefaultInstance().getJsonName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKind() {
        this.kind_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNumber() {
        this.number_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOneofIndex() {
        this.oneofIndex_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOptions() {
        this.options_ = GeneratedMessageLite.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPacked() {
        this.packed_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTypeUrl() {
        this.typeUrl_ = getDefaultInstance().getTypeUrl();
    }

    private void ensureOptionsIsMutable() {
        if (this.options_.isModifiable()) {
            return;
        }
        this.options_ = GeneratedMessageLite.a(this.options_);
    }

    public static Field getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Field field) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) field);
    }

    public static Field parseDelimitedFrom(InputStream inputStream) {
        return (Field) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static Field parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Field) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Field parseFrom(ByteString byteString) {
        return (Field) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static Field parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Field) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Field parseFrom(CodedInputStream codedInputStream) {
        return (Field) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Field parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Field) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Field parseFrom(InputStream inputStream) {
        return (Field) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static Field parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Field) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Field parseFrom(byte[] bArr) {
        return (Field) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static Field parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Field) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<Field> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeOptions(int i) {
        ensureOptionsIsMutable();
        this.options_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCardinality(Cardinality cardinality) {
        if (cardinality == null) {
            throw new NullPointerException();
        }
        this.cardinality_ = cardinality.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCardinalityValue(int i) {
        this.cardinality_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDefaultValue(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.defaultValue_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDefaultValueBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.defaultValue_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJsonName(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.jsonName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJsonNameBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.jsonName_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKind(Kind kind) {
        if (kind == null) {
            throw new NullPointerException();
        }
        this.kind_ = kind.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKindValue(int i) {
        this.kind_ = i;
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
    public void setNumber(int i) {
        this.number_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOneofIndex(int i) {
        this.oneofIndex_ = i;
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
    public void setPacked(boolean z) {
        this.packed_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTypeUrl(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.typeUrl_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTypeUrlBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.typeUrl_ = byteString.toStringUtf8();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:26:0x003a. Please report as an issue. */
    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new Field();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.options_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Field field = (Field) obj2;
                this.kind_ = visitor.visitInt(this.kind_ != 0, this.kind_, field.kind_ != 0, field.kind_);
                this.cardinality_ = visitor.visitInt(this.cardinality_ != 0, this.cardinality_, field.cardinality_ != 0, field.cardinality_);
                this.number_ = visitor.visitInt(this.number_ != 0, this.number_, field.number_ != 0, field.number_);
                this.name_ = visitor.visitString(!this.name_.isEmpty(), this.name_, !field.name_.isEmpty(), field.name_);
                this.typeUrl_ = visitor.visitString(!this.typeUrl_.isEmpty(), this.typeUrl_, !field.typeUrl_.isEmpty(), field.typeUrl_);
                this.oneofIndex_ = visitor.visitInt(this.oneofIndex_ != 0, this.oneofIndex_, field.oneofIndex_ != 0, field.oneofIndex_);
                boolean z = this.packed_;
                boolean z2 = field.packed_;
                this.packed_ = visitor.visitBoolean(z, z, z2, z2);
                this.options_ = visitor.visitList(this.options_, field.options_);
                this.jsonName_ = visitor.visitString(!this.jsonName_.isEmpty(), this.jsonName_, !field.jsonName_.isEmpty(), field.jsonName_);
                this.defaultValue_ = visitor.visitString(!this.defaultValue_.isEmpty(), this.defaultValue_, !field.defaultValue_.isEmpty(), field.defaultValue_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= field.bitField0_;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!r1) {
                    try {
                        int readTag = codedInputStream.readTag();
                        switch (readTag) {
                            case 0:
                                r1 = true;
                            case 8:
                                this.kind_ = codedInputStream.readEnum();
                            case 16:
                                this.cardinality_ = codedInputStream.readEnum();
                            case 24:
                                this.number_ = codedInputStream.readInt32();
                            case 34:
                                this.name_ = codedInputStream.readStringRequireUtf8();
                            case 50:
                                this.typeUrl_ = codedInputStream.readStringRequireUtf8();
                            case 56:
                                this.oneofIndex_ = codedInputStream.readInt32();
                            case 64:
                                this.packed_ = codedInputStream.readBool();
                            case 74:
                                if (!this.options_.isModifiable()) {
                                    this.options_ = GeneratedMessageLite.a(this.options_);
                                }
                                this.options_.add((Option) codedInputStream.readMessage(Option.parser(), extensionRegistryLite));
                            case 82:
                                this.jsonName_ = codedInputStream.readStringRequireUtf8();
                            case 90:
                                this.defaultValue_ = codedInputStream.readStringRequireUtf8();
                            default:
                                if (!codedInputStream.skipField(readTag)) {
                                    r1 = true;
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
                    synchronized (Field.class) {
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

    @Override // com.google.protobuf.FieldOrBuilder
    public Cardinality getCardinality() {
        Cardinality forNumber = Cardinality.forNumber(this.cardinality_);
        return forNumber == null ? Cardinality.UNRECOGNIZED : forNumber;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public int getCardinalityValue() {
        return this.cardinality_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public String getDefaultValue() {
        return this.defaultValue_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public ByteString getDefaultValueBytes() {
        return ByteString.copyFromUtf8(this.defaultValue_);
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public String getJsonName() {
        return this.jsonName_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public ByteString getJsonNameBytes() {
        return ByteString.copyFromUtf8(this.jsonName_);
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public Kind getKind() {
        Kind forNumber = Kind.forNumber(this.kind_);
        return forNumber == null ? Kind.UNRECOGNIZED : forNumber;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public int getKindValue() {
        return this.kind_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public int getNumber() {
        return this.number_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public int getOneofIndex() {
        return this.oneofIndex_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public Option getOptions(int i) {
        return this.options_.get(i);
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public List<Option> getOptionsList() {
        return this.options_;
    }

    public OptionOrBuilder getOptionsOrBuilder(int i) {
        return this.options_.get(i);
    }

    public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.options_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public boolean getPacked() {
        return this.packed_;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeEnumSize = this.kind_ != Kind.TYPE_UNKNOWN.getNumber() ? CodedOutputStream.computeEnumSize(1, this.kind_) + 0 : 0;
        if (this.cardinality_ != Cardinality.CARDINALITY_UNKNOWN.getNumber()) {
            computeEnumSize += CodedOutputStream.computeEnumSize(2, this.cardinality_);
        }
        int i2 = this.number_;
        if (i2 != 0) {
            computeEnumSize += CodedOutputStream.computeInt32Size(3, i2);
        }
        if (!this.name_.isEmpty()) {
            computeEnumSize += CodedOutputStream.computeStringSize(4, getName());
        }
        if (!this.typeUrl_.isEmpty()) {
            computeEnumSize += CodedOutputStream.computeStringSize(6, getTypeUrl());
        }
        int i3 = this.oneofIndex_;
        if (i3 != 0) {
            computeEnumSize += CodedOutputStream.computeInt32Size(7, i3);
        }
        boolean z = this.packed_;
        if (z) {
            computeEnumSize += CodedOutputStream.computeBoolSize(8, z);
        }
        for (int i4 = 0; i4 < this.options_.size(); i4++) {
            computeEnumSize += CodedOutputStream.computeMessageSize(9, this.options_.get(i4));
        }
        if (!this.jsonName_.isEmpty()) {
            computeEnumSize += CodedOutputStream.computeStringSize(10, getJsonName());
        }
        if (!this.defaultValue_.isEmpty()) {
            computeEnumSize += CodedOutputStream.computeStringSize(11, getDefaultValue());
        }
        this.c = computeEnumSize;
        return computeEnumSize;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public String getTypeUrl() {
        return this.typeUrl_;
    }

    @Override // com.google.protobuf.FieldOrBuilder
    public ByteString getTypeUrlBytes() {
        return ByteString.copyFromUtf8(this.typeUrl_);
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (this.kind_ != Kind.TYPE_UNKNOWN.getNumber()) {
            codedOutputStream.writeEnum(1, this.kind_);
        }
        if (this.cardinality_ != Cardinality.CARDINALITY_UNKNOWN.getNumber()) {
            codedOutputStream.writeEnum(2, this.cardinality_);
        }
        int i = this.number_;
        if (i != 0) {
            codedOutputStream.writeInt32(3, i);
        }
        if (!this.name_.isEmpty()) {
            codedOutputStream.writeString(4, getName());
        }
        if (!this.typeUrl_.isEmpty()) {
            codedOutputStream.writeString(6, getTypeUrl());
        }
        int i2 = this.oneofIndex_;
        if (i2 != 0) {
            codedOutputStream.writeInt32(7, i2);
        }
        boolean z = this.packed_;
        if (z) {
            codedOutputStream.writeBool(8, z);
        }
        for (int i3 = 0; i3 < this.options_.size(); i3++) {
            codedOutputStream.writeMessage(9, this.options_.get(i3));
        }
        if (!this.jsonName_.isEmpty()) {
            codedOutputStream.writeString(10, getJsonName());
        }
        if (this.defaultValue_.isEmpty()) {
            return;
        }
        codedOutputStream.writeString(11, getDefaultValue());
    }
}
