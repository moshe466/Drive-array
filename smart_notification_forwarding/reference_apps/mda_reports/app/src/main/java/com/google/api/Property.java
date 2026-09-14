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

/* loaded from: classes2.dex */
public final class Property extends GeneratedMessageLite<Property, Builder> implements PropertyOrBuilder {
    private static final Property DEFAULT_INSTANCE = new Property();
    public static final int DESCRIPTION_FIELD_NUMBER = 3;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<Property> PARSER = null;
    public static final int TYPE_FIELD_NUMBER = 2;
    private int type_;
    private String name_ = "";
    private String description_ = "";

    /* renamed from: com.google.api.Property$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<Property, Builder> implements PropertyOrBuilder {
        private Builder() {
            super(Property.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearDescription() {
            a();
            ((Property) this.a).clearDescription();
            return this;
        }

        public Builder clearName() {
            a();
            ((Property) this.a).clearName();
            return this;
        }

        public Builder clearType() {
            a();
            ((Property) this.a).clearType();
            return this;
        }

        @Override // com.google.api.PropertyOrBuilder
        public String getDescription() {
            return ((Property) this.a).getDescription();
        }

        @Override // com.google.api.PropertyOrBuilder
        public ByteString getDescriptionBytes() {
            return ((Property) this.a).getDescriptionBytes();
        }

        @Override // com.google.api.PropertyOrBuilder
        public String getName() {
            return ((Property) this.a).getName();
        }

        @Override // com.google.api.PropertyOrBuilder
        public ByteString getNameBytes() {
            return ((Property) this.a).getNameBytes();
        }

        @Override // com.google.api.PropertyOrBuilder
        public PropertyType getType() {
            return ((Property) this.a).getType();
        }

        @Override // com.google.api.PropertyOrBuilder
        public int getTypeValue() {
            return ((Property) this.a).getTypeValue();
        }

        public Builder setDescription(String str) {
            a();
            ((Property) this.a).setDescription(str);
            return this;
        }

        public Builder setDescriptionBytes(ByteString byteString) {
            a();
            ((Property) this.a).setDescriptionBytes(byteString);
            return this;
        }

        public Builder setName(String str) {
            a();
            ((Property) this.a).setName(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            a();
            ((Property) this.a).setNameBytes(byteString);
            return this;
        }

        public Builder setType(PropertyType propertyType) {
            a();
            ((Property) this.a).setType(propertyType);
            return this;
        }

        public Builder setTypeValue(int i) {
            a();
            ((Property) this.a).setTypeValue(i);
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public enum PropertyType implements Internal.EnumLite {
        UNSPECIFIED(0),
        INT64(1),
        BOOL(2),
        STRING(3),
        DOUBLE(4),
        UNRECOGNIZED(-1);

        public static final int BOOL_VALUE = 2;
        public static final int DOUBLE_VALUE = 4;
        public static final int INT64_VALUE = 1;
        public static final int STRING_VALUE = 3;
        public static final int UNSPECIFIED_VALUE = 0;
        private static final Internal.EnumLiteMap<PropertyType> internalValueMap = new Internal.EnumLiteMap<PropertyType>() { // from class: com.google.api.Property.PropertyType.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public PropertyType findValueByNumber(int i) {
                return PropertyType.forNumber(i);
            }
        };
        private final int value;

        PropertyType(int i) {
            this.value = i;
        }

        public static PropertyType forNumber(int i) {
            if (i == 0) {
                return UNSPECIFIED;
            }
            if (i == 1) {
                return INT64;
            }
            if (i == 2) {
                return BOOL;
            }
            if (i == 3) {
                return STRING;
            }
            if (i != 4) {
                return null;
            }
            return DOUBLE;
        }

        public static Internal.EnumLiteMap<PropertyType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static PropertyType valueOf(int i) {
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

    private Property() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearType() {
        this.type_ = 0;
    }

    public static Property getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Property property) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) property);
    }

    public static Property parseDelimitedFrom(InputStream inputStream) {
        return (Property) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static Property parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Property) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Property parseFrom(ByteString byteString) {
        return (Property) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static Property parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Property) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Property parseFrom(CodedInputStream codedInputStream) {
        return (Property) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Property parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Property) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Property parseFrom(InputStream inputStream) {
        return (Property) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static Property parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Property) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Property parseFrom(byte[] bArr) {
        return (Property) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static Property parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Property) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<Property> parser() {
        return DEFAULT_INSTANCE.getParserForType();
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
    public void setType(PropertyType propertyType) {
        if (propertyType == null) {
            throw new NullPointerException();
        }
        this.type_ = propertyType.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTypeValue(int i) {
        this.type_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new Property();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Property property = (Property) obj2;
                this.name_ = visitor.visitString(!this.name_.isEmpty(), this.name_, !property.name_.isEmpty(), property.name_);
                this.type_ = visitor.visitInt(this.type_ != 0, this.type_, property.type_ != 0, property.type_);
                this.description_ = visitor.visitString(!this.description_.isEmpty(), this.description_, !property.description_.isEmpty(), property.description_);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                while (!r1) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.name_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 16) {
                                this.type_ = codedInputStream.readEnum();
                            } else if (readTag == 26) {
                                this.description_ = codedInputStream.readStringRequireUtf8();
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
                    synchronized (Property.class) {
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

    @Override // com.google.api.PropertyOrBuilder
    public String getDescription() {
        return this.description_;
    }

    @Override // com.google.api.PropertyOrBuilder
    public ByteString getDescriptionBytes() {
        return ByteString.copyFromUtf8(this.description_);
    }

    @Override // com.google.api.PropertyOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // com.google.api.PropertyOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeStringSize = this.name_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getName());
        if (this.type_ != PropertyType.UNSPECIFIED.getNumber()) {
            computeStringSize += CodedOutputStream.computeEnumSize(2, this.type_);
        }
        if (!this.description_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(3, getDescription());
        }
        this.c = computeStringSize;
        return computeStringSize;
    }

    @Override // com.google.api.PropertyOrBuilder
    public PropertyType getType() {
        PropertyType forNumber = PropertyType.forNumber(this.type_);
        return forNumber == null ? PropertyType.UNRECOGNIZED : forNumber;
    }

    @Override // com.google.api.PropertyOrBuilder
    public int getTypeValue() {
        return this.type_;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!this.name_.isEmpty()) {
            codedOutputStream.writeString(1, getName());
        }
        if (this.type_ != PropertyType.UNSPECIFIED.getNumber()) {
            codedOutputStream.writeEnum(2, this.type_);
        }
        if (this.description_.isEmpty()) {
            return;
        }
        codedOutputStream.writeString(3, getDescription());
    }
}
