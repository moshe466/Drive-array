package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class DescriptorProtos {

    /* renamed from: com.google.protobuf.DescriptorProtos$1, reason: invalid class name */
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
    public static final class DescriptorProto extends GeneratedMessageLite<DescriptorProto, Builder> implements DescriptorProtoOrBuilder {
        private static final DescriptorProto DEFAULT_INSTANCE = new DescriptorProto();
        public static final int ENUM_TYPE_FIELD_NUMBER = 4;
        public static final int EXTENSION_FIELD_NUMBER = 6;
        public static final int EXTENSION_RANGE_FIELD_NUMBER = 5;
        public static final int FIELD_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int NESTED_TYPE_FIELD_NUMBER = 3;
        public static final int ONEOF_DECL_FIELD_NUMBER = 8;
        public static final int OPTIONS_FIELD_NUMBER = 7;
        private static volatile Parser<DescriptorProto> PARSER = null;
        public static final int RESERVED_NAME_FIELD_NUMBER = 10;
        public static final int RESERVED_RANGE_FIELD_NUMBER = 9;
        private int bitField0_;
        private MessageOptions options_;
        private byte memoizedIsInitialized = -1;
        private String name_ = "";
        private Internal.ProtobufList<FieldDescriptorProto> field_ = GeneratedMessageLite.f();
        private Internal.ProtobufList<FieldDescriptorProto> extension_ = GeneratedMessageLite.f();
        private Internal.ProtobufList<DescriptorProto> nestedType_ = GeneratedMessageLite.f();
        private Internal.ProtobufList<EnumDescriptorProto> enumType_ = GeneratedMessageLite.f();
        private Internal.ProtobufList<ExtensionRange> extensionRange_ = GeneratedMessageLite.f();
        private Internal.ProtobufList<OneofDescriptorProto> oneofDecl_ = GeneratedMessageLite.f();
        private Internal.ProtobufList<ReservedRange> reservedRange_ = GeneratedMessageLite.f();
        private Internal.ProtobufList<String> reservedName_ = GeneratedMessageLite.f();

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<DescriptorProto, Builder> implements DescriptorProtoOrBuilder {
            private Builder() {
                super(DescriptorProto.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllEnumType(Iterable<? extends EnumDescriptorProto> iterable) {
                a();
                ((DescriptorProto) this.a).addAllEnumType(iterable);
                return this;
            }

            public Builder addAllExtension(Iterable<? extends FieldDescriptorProto> iterable) {
                a();
                ((DescriptorProto) this.a).addAllExtension(iterable);
                return this;
            }

            public Builder addAllExtensionRange(Iterable<? extends ExtensionRange> iterable) {
                a();
                ((DescriptorProto) this.a).addAllExtensionRange(iterable);
                return this;
            }

            public Builder addAllField(Iterable<? extends FieldDescriptorProto> iterable) {
                a();
                ((DescriptorProto) this.a).addAllField(iterable);
                return this;
            }

            public Builder addAllNestedType(Iterable<? extends DescriptorProto> iterable) {
                a();
                ((DescriptorProto) this.a).addAllNestedType(iterable);
                return this;
            }

            public Builder addAllOneofDecl(Iterable<? extends OneofDescriptorProto> iterable) {
                a();
                ((DescriptorProto) this.a).addAllOneofDecl(iterable);
                return this;
            }

            public Builder addAllReservedName(Iterable<String> iterable) {
                a();
                ((DescriptorProto) this.a).addAllReservedName(iterable);
                return this;
            }

            public Builder addAllReservedRange(Iterable<? extends ReservedRange> iterable) {
                a();
                ((DescriptorProto) this.a).addAllReservedRange(iterable);
                return this;
            }

            public Builder addEnumType(int i, EnumDescriptorProto.Builder builder) {
                a();
                ((DescriptorProto) this.a).addEnumType(i, builder);
                return this;
            }

            public Builder addEnumType(int i, EnumDescriptorProto enumDescriptorProto) {
                a();
                ((DescriptorProto) this.a).addEnumType(i, enumDescriptorProto);
                return this;
            }

            public Builder addEnumType(EnumDescriptorProto.Builder builder) {
                a();
                ((DescriptorProto) this.a).addEnumType(builder);
                return this;
            }

            public Builder addEnumType(EnumDescriptorProto enumDescriptorProto) {
                a();
                ((DescriptorProto) this.a).addEnumType(enumDescriptorProto);
                return this;
            }

            public Builder addExtension(int i, FieldDescriptorProto.Builder builder) {
                a();
                ((DescriptorProto) this.a).addExtension(i, builder);
                return this;
            }

            public Builder addExtension(int i, FieldDescriptorProto fieldDescriptorProto) {
                a();
                ((DescriptorProto) this.a).addExtension(i, fieldDescriptorProto);
                return this;
            }

            public Builder addExtension(FieldDescriptorProto.Builder builder) {
                a();
                ((DescriptorProto) this.a).addExtension(builder);
                return this;
            }

            public Builder addExtension(FieldDescriptorProto fieldDescriptorProto) {
                a();
                ((DescriptorProto) this.a).addExtension(fieldDescriptorProto);
                return this;
            }

            public Builder addExtensionRange(int i, ExtensionRange.Builder builder) {
                a();
                ((DescriptorProto) this.a).addExtensionRange(i, builder);
                return this;
            }

            public Builder addExtensionRange(int i, ExtensionRange extensionRange) {
                a();
                ((DescriptorProto) this.a).addExtensionRange(i, extensionRange);
                return this;
            }

            public Builder addExtensionRange(ExtensionRange.Builder builder) {
                a();
                ((DescriptorProto) this.a).addExtensionRange(builder);
                return this;
            }

            public Builder addExtensionRange(ExtensionRange extensionRange) {
                a();
                ((DescriptorProto) this.a).addExtensionRange(extensionRange);
                return this;
            }

            public Builder addField(int i, FieldDescriptorProto.Builder builder) {
                a();
                ((DescriptorProto) this.a).addField(i, builder);
                return this;
            }

            public Builder addField(int i, FieldDescriptorProto fieldDescriptorProto) {
                a();
                ((DescriptorProto) this.a).addField(i, fieldDescriptorProto);
                return this;
            }

            public Builder addField(FieldDescriptorProto.Builder builder) {
                a();
                ((DescriptorProto) this.a).addField(builder);
                return this;
            }

            public Builder addField(FieldDescriptorProto fieldDescriptorProto) {
                a();
                ((DescriptorProto) this.a).addField(fieldDescriptorProto);
                return this;
            }

            public Builder addNestedType(int i, Builder builder) {
                a();
                ((DescriptorProto) this.a).addNestedType(i, builder);
                return this;
            }

            public Builder addNestedType(int i, DescriptorProto descriptorProto) {
                a();
                ((DescriptorProto) this.a).addNestedType(i, descriptorProto);
                return this;
            }

            public Builder addNestedType(Builder builder) {
                a();
                ((DescriptorProto) this.a).addNestedType(builder);
                return this;
            }

            public Builder addNestedType(DescriptorProto descriptorProto) {
                a();
                ((DescriptorProto) this.a).addNestedType(descriptorProto);
                return this;
            }

            public Builder addOneofDecl(int i, OneofDescriptorProto.Builder builder) {
                a();
                ((DescriptorProto) this.a).addOneofDecl(i, builder);
                return this;
            }

            public Builder addOneofDecl(int i, OneofDescriptorProto oneofDescriptorProto) {
                a();
                ((DescriptorProto) this.a).addOneofDecl(i, oneofDescriptorProto);
                return this;
            }

            public Builder addOneofDecl(OneofDescriptorProto.Builder builder) {
                a();
                ((DescriptorProto) this.a).addOneofDecl(builder);
                return this;
            }

            public Builder addOneofDecl(OneofDescriptorProto oneofDescriptorProto) {
                a();
                ((DescriptorProto) this.a).addOneofDecl(oneofDescriptorProto);
                return this;
            }

            public Builder addReservedName(String str) {
                a();
                ((DescriptorProto) this.a).addReservedName(str);
                return this;
            }

            public Builder addReservedNameBytes(ByteString byteString) {
                a();
                ((DescriptorProto) this.a).addReservedNameBytes(byteString);
                return this;
            }

            public Builder addReservedRange(int i, ReservedRange.Builder builder) {
                a();
                ((DescriptorProto) this.a).addReservedRange(i, builder);
                return this;
            }

            public Builder addReservedRange(int i, ReservedRange reservedRange) {
                a();
                ((DescriptorProto) this.a).addReservedRange(i, reservedRange);
                return this;
            }

            public Builder addReservedRange(ReservedRange.Builder builder) {
                a();
                ((DescriptorProto) this.a).addReservedRange(builder);
                return this;
            }

            public Builder addReservedRange(ReservedRange reservedRange) {
                a();
                ((DescriptorProto) this.a).addReservedRange(reservedRange);
                return this;
            }

            public Builder clearEnumType() {
                a();
                ((DescriptorProto) this.a).clearEnumType();
                return this;
            }

            public Builder clearExtension() {
                a();
                ((DescriptorProto) this.a).clearExtension();
                return this;
            }

            public Builder clearExtensionRange() {
                a();
                ((DescriptorProto) this.a).clearExtensionRange();
                return this;
            }

            public Builder clearField() {
                a();
                ((DescriptorProto) this.a).clearField();
                return this;
            }

            public Builder clearName() {
                a();
                ((DescriptorProto) this.a).clearName();
                return this;
            }

            public Builder clearNestedType() {
                a();
                ((DescriptorProto) this.a).clearNestedType();
                return this;
            }

            public Builder clearOneofDecl() {
                a();
                ((DescriptorProto) this.a).clearOneofDecl();
                return this;
            }

            public Builder clearOptions() {
                a();
                ((DescriptorProto) this.a).clearOptions();
                return this;
            }

            public Builder clearReservedName() {
                a();
                ((DescriptorProto) this.a).clearReservedName();
                return this;
            }

            public Builder clearReservedRange() {
                a();
                ((DescriptorProto) this.a).clearReservedRange();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public EnumDescriptorProto getEnumType(int i) {
                return ((DescriptorProto) this.a).getEnumType(i);
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public int getEnumTypeCount() {
                return ((DescriptorProto) this.a).getEnumTypeCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public List<EnumDescriptorProto> getEnumTypeList() {
                return Collections.unmodifiableList(((DescriptorProto) this.a).getEnumTypeList());
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public FieldDescriptorProto getExtension(int i) {
                return ((DescriptorProto) this.a).getExtension(i);
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public int getExtensionCount() {
                return ((DescriptorProto) this.a).getExtensionCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public List<FieldDescriptorProto> getExtensionList() {
                return Collections.unmodifiableList(((DescriptorProto) this.a).getExtensionList());
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public ExtensionRange getExtensionRange(int i) {
                return ((DescriptorProto) this.a).getExtensionRange(i);
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public int getExtensionRangeCount() {
                return ((DescriptorProto) this.a).getExtensionRangeCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public List<ExtensionRange> getExtensionRangeList() {
                return Collections.unmodifiableList(((DescriptorProto) this.a).getExtensionRangeList());
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public FieldDescriptorProto getField(int i) {
                return ((DescriptorProto) this.a).getField(i);
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public int getFieldCount() {
                return ((DescriptorProto) this.a).getFieldCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public List<FieldDescriptorProto> getFieldList() {
                return Collections.unmodifiableList(((DescriptorProto) this.a).getFieldList());
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public String getName() {
                return ((DescriptorProto) this.a).getName();
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public ByteString getNameBytes() {
                return ((DescriptorProto) this.a).getNameBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public DescriptorProto getNestedType(int i) {
                return ((DescriptorProto) this.a).getNestedType(i);
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public int getNestedTypeCount() {
                return ((DescriptorProto) this.a).getNestedTypeCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public List<DescriptorProto> getNestedTypeList() {
                return Collections.unmodifiableList(((DescriptorProto) this.a).getNestedTypeList());
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public OneofDescriptorProto getOneofDecl(int i) {
                return ((DescriptorProto) this.a).getOneofDecl(i);
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public int getOneofDeclCount() {
                return ((DescriptorProto) this.a).getOneofDeclCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public List<OneofDescriptorProto> getOneofDeclList() {
                return Collections.unmodifiableList(((DescriptorProto) this.a).getOneofDeclList());
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public MessageOptions getOptions() {
                return ((DescriptorProto) this.a).getOptions();
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public String getReservedName(int i) {
                return ((DescriptorProto) this.a).getReservedName(i);
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public ByteString getReservedNameBytes(int i) {
                return ((DescriptorProto) this.a).getReservedNameBytes(i);
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public int getReservedNameCount() {
                return ((DescriptorProto) this.a).getReservedNameCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public List<String> getReservedNameList() {
                return Collections.unmodifiableList(((DescriptorProto) this.a).getReservedNameList());
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public ReservedRange getReservedRange(int i) {
                return ((DescriptorProto) this.a).getReservedRange(i);
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public int getReservedRangeCount() {
                return ((DescriptorProto) this.a).getReservedRangeCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public List<ReservedRange> getReservedRangeList() {
                return Collections.unmodifiableList(((DescriptorProto) this.a).getReservedRangeList());
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public boolean hasName() {
                return ((DescriptorProto) this.a).hasName();
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public boolean hasOptions() {
                return ((DescriptorProto) this.a).hasOptions();
            }

            public Builder mergeOptions(MessageOptions messageOptions) {
                a();
                ((DescriptorProto) this.a).mergeOptions(messageOptions);
                return this;
            }

            public Builder removeEnumType(int i) {
                a();
                ((DescriptorProto) this.a).removeEnumType(i);
                return this;
            }

            public Builder removeExtension(int i) {
                a();
                ((DescriptorProto) this.a).removeExtension(i);
                return this;
            }

            public Builder removeExtensionRange(int i) {
                a();
                ((DescriptorProto) this.a).removeExtensionRange(i);
                return this;
            }

            public Builder removeField(int i) {
                a();
                ((DescriptorProto) this.a).removeField(i);
                return this;
            }

            public Builder removeNestedType(int i) {
                a();
                ((DescriptorProto) this.a).removeNestedType(i);
                return this;
            }

            public Builder removeOneofDecl(int i) {
                a();
                ((DescriptorProto) this.a).removeOneofDecl(i);
                return this;
            }

            public Builder removeReservedRange(int i) {
                a();
                ((DescriptorProto) this.a).removeReservedRange(i);
                return this;
            }

            public Builder setEnumType(int i, EnumDescriptorProto.Builder builder) {
                a();
                ((DescriptorProto) this.a).setEnumType(i, builder);
                return this;
            }

            public Builder setEnumType(int i, EnumDescriptorProto enumDescriptorProto) {
                a();
                ((DescriptorProto) this.a).setEnumType(i, enumDescriptorProto);
                return this;
            }

            public Builder setExtension(int i, FieldDescriptorProto.Builder builder) {
                a();
                ((DescriptorProto) this.a).setExtension(i, builder);
                return this;
            }

            public Builder setExtension(int i, FieldDescriptorProto fieldDescriptorProto) {
                a();
                ((DescriptorProto) this.a).setExtension(i, fieldDescriptorProto);
                return this;
            }

            public Builder setExtensionRange(int i, ExtensionRange.Builder builder) {
                a();
                ((DescriptorProto) this.a).setExtensionRange(i, builder);
                return this;
            }

            public Builder setExtensionRange(int i, ExtensionRange extensionRange) {
                a();
                ((DescriptorProto) this.a).setExtensionRange(i, extensionRange);
                return this;
            }

            public Builder setField(int i, FieldDescriptorProto.Builder builder) {
                a();
                ((DescriptorProto) this.a).setField(i, builder);
                return this;
            }

            public Builder setField(int i, FieldDescriptorProto fieldDescriptorProto) {
                a();
                ((DescriptorProto) this.a).setField(i, fieldDescriptorProto);
                return this;
            }

            public Builder setName(String str) {
                a();
                ((DescriptorProto) this.a).setName(str);
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                a();
                ((DescriptorProto) this.a).setNameBytes(byteString);
                return this;
            }

            public Builder setNestedType(int i, Builder builder) {
                a();
                ((DescriptorProto) this.a).setNestedType(i, builder);
                return this;
            }

            public Builder setNestedType(int i, DescriptorProto descriptorProto) {
                a();
                ((DescriptorProto) this.a).setNestedType(i, descriptorProto);
                return this;
            }

            public Builder setOneofDecl(int i, OneofDescriptorProto.Builder builder) {
                a();
                ((DescriptorProto) this.a).setOneofDecl(i, builder);
                return this;
            }

            public Builder setOneofDecl(int i, OneofDescriptorProto oneofDescriptorProto) {
                a();
                ((DescriptorProto) this.a).setOneofDecl(i, oneofDescriptorProto);
                return this;
            }

            public Builder setOptions(MessageOptions.Builder builder) {
                a();
                ((DescriptorProto) this.a).setOptions(builder);
                return this;
            }

            public Builder setOptions(MessageOptions messageOptions) {
                a();
                ((DescriptorProto) this.a).setOptions(messageOptions);
                return this;
            }

            public Builder setReservedName(int i, String str) {
                a();
                ((DescriptorProto) this.a).setReservedName(i, str);
                return this;
            }

            public Builder setReservedRange(int i, ReservedRange.Builder builder) {
                a();
                ((DescriptorProto) this.a).setReservedRange(i, builder);
                return this;
            }

            public Builder setReservedRange(int i, ReservedRange reservedRange) {
                a();
                ((DescriptorProto) this.a).setReservedRange(i, reservedRange);
                return this;
            }
        }

        /* loaded from: classes2.dex */
        public static final class ExtensionRange extends GeneratedMessageLite<ExtensionRange, Builder> implements ExtensionRangeOrBuilder {
            private static final ExtensionRange DEFAULT_INSTANCE = new ExtensionRange();
            public static final int END_FIELD_NUMBER = 2;
            public static final int OPTIONS_FIELD_NUMBER = 3;
            private static volatile Parser<ExtensionRange> PARSER = null;
            public static final int START_FIELD_NUMBER = 1;
            private int bitField0_;
            private int end_;
            private byte memoizedIsInitialized = -1;
            private ExtensionRangeOptions options_;
            private int start_;

            /* loaded from: classes2.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<ExtensionRange, Builder> implements ExtensionRangeOrBuilder {
                private Builder() {
                    super(ExtensionRange.DEFAULT_INSTANCE);
                }

                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                public Builder clearEnd() {
                    a();
                    ((ExtensionRange) this.a).clearEnd();
                    return this;
                }

                public Builder clearOptions() {
                    a();
                    ((ExtensionRange) this.a).clearOptions();
                    return this;
                }

                public Builder clearStart() {
                    a();
                    ((ExtensionRange) this.a).clearStart();
                    return this;
                }

                @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
                public int getEnd() {
                    return ((ExtensionRange) this.a).getEnd();
                }

                @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
                public ExtensionRangeOptions getOptions() {
                    return ((ExtensionRange) this.a).getOptions();
                }

                @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
                public int getStart() {
                    return ((ExtensionRange) this.a).getStart();
                }

                @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
                public boolean hasEnd() {
                    return ((ExtensionRange) this.a).hasEnd();
                }

                @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
                public boolean hasOptions() {
                    return ((ExtensionRange) this.a).hasOptions();
                }

                @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
                public boolean hasStart() {
                    return ((ExtensionRange) this.a).hasStart();
                }

                public Builder mergeOptions(ExtensionRangeOptions extensionRangeOptions) {
                    a();
                    ((ExtensionRange) this.a).mergeOptions(extensionRangeOptions);
                    return this;
                }

                public Builder setEnd(int i) {
                    a();
                    ((ExtensionRange) this.a).setEnd(i);
                    return this;
                }

                public Builder setOptions(ExtensionRangeOptions.Builder builder) {
                    a();
                    ((ExtensionRange) this.a).setOptions(builder);
                    return this;
                }

                public Builder setOptions(ExtensionRangeOptions extensionRangeOptions) {
                    a();
                    ((ExtensionRange) this.a).setOptions(extensionRangeOptions);
                    return this;
                }

                public Builder setStart(int i) {
                    a();
                    ((ExtensionRange) this.a).setStart(i);
                    return this;
                }
            }

            static {
                DEFAULT_INSTANCE.b();
            }

            private ExtensionRange() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearEnd() {
                this.bitField0_ &= -3;
                this.end_ = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearOptions() {
                this.options_ = null;
                this.bitField0_ &= -5;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearStart() {
                this.bitField0_ &= -2;
                this.start_ = 0;
            }

            public static ExtensionRange getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Multi-variable type inference failed */
            public void mergeOptions(ExtensionRangeOptions extensionRangeOptions) {
                ExtensionRangeOptions extensionRangeOptions2 = this.options_;
                if (extensionRangeOptions2 != null && extensionRangeOptions2 != ExtensionRangeOptions.getDefaultInstance()) {
                    extensionRangeOptions = ((ExtensionRangeOptions.Builder) ExtensionRangeOptions.newBuilder(this.options_).mergeFrom((ExtensionRangeOptions.Builder) extensionRangeOptions)).buildPartial();
                }
                this.options_ = extensionRangeOptions;
                this.bitField0_ |= 4;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(ExtensionRange extensionRange) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) extensionRange);
            }

            public static ExtensionRange parseDelimitedFrom(InputStream inputStream) {
                return (ExtensionRange) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
            }

            public static ExtensionRange parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (ExtensionRange) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ExtensionRange parseFrom(ByteString byteString) {
                return (ExtensionRange) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
            }

            public static ExtensionRange parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                return (ExtensionRange) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static ExtensionRange parseFrom(CodedInputStream codedInputStream) {
                return (ExtensionRange) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
            }

            public static ExtensionRange parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (ExtensionRange) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static ExtensionRange parseFrom(InputStream inputStream) {
                return (ExtensionRange) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
            }

            public static ExtensionRange parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (ExtensionRange) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ExtensionRange parseFrom(byte[] bArr) {
                return (ExtensionRange) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
            }

            public static ExtensionRange parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                return (ExtensionRange) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static Parser<ExtensionRange> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setEnd(int i) {
                this.bitField0_ |= 2;
                this.end_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Multi-variable type inference failed */
            public void setOptions(ExtensionRangeOptions.Builder builder) {
                this.options_ = (ExtensionRangeOptions) builder.build();
                this.bitField0_ |= 4;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setOptions(ExtensionRangeOptions extensionRangeOptions) {
                if (extensionRangeOptions == null) {
                    throw new NullPointerException();
                }
                this.options_ = extensionRangeOptions;
                this.bitField0_ |= 4;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setStart(int i) {
                this.bitField0_ |= 1;
                this.start_ = i;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                boolean z = false;
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new ExtensionRange();
                    case 2:
                        byte b = this.memoizedIsInitialized;
                        if (b == 1) {
                            return DEFAULT_INSTANCE;
                        }
                        if (b == 0) {
                            return null;
                        }
                        boolean booleanValue = ((Boolean) obj).booleanValue();
                        if (!hasOptions() || getOptions().isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = (byte) 1;
                            }
                            return DEFAULT_INSTANCE;
                        }
                        if (booleanValue) {
                            this.memoizedIsInitialized = (byte) 0;
                        }
                        return null;
                    case 3:
                        return null;
                    case 4:
                        return new Builder(anonymousClass1);
                    case 5:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        ExtensionRange extensionRange = (ExtensionRange) obj2;
                        this.start_ = visitor.visitInt(hasStart(), this.start_, extensionRange.hasStart(), extensionRange.start_);
                        this.end_ = visitor.visitInt(hasEnd(), this.end_, extensionRange.hasEnd(), extensionRange.end_);
                        this.options_ = (ExtensionRangeOptions) visitor.visitMessage(this.options_, extensionRange.options_);
                        if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                            this.bitField0_ |= extensionRange.bitField0_;
                        }
                        return this;
                    case 6:
                        CodedInputStream codedInputStream = (CodedInputStream) obj;
                        ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                        while (!z) {
                            try {
                                int readTag = codedInputStream.readTag();
                                if (readTag != 0) {
                                    if (readTag == 8) {
                                        this.bitField0_ |= 1;
                                        this.start_ = codedInputStream.readInt32();
                                    } else if (readTag == 16) {
                                        this.bitField0_ |= 2;
                                        this.end_ = codedInputStream.readInt32();
                                    } else if (readTag == 26) {
                                        ExtensionRangeOptions.Builder builder = (this.bitField0_ & 4) == 4 ? (ExtensionRangeOptions.Builder) this.options_.toBuilder() : null;
                                        this.options_ = (ExtensionRangeOptions) codedInputStream.readMessage(ExtensionRangeOptions.parser(), extensionRegistryLite);
                                        if (builder != null) {
                                            builder.mergeFrom((ExtensionRangeOptions.Builder) this.options_);
                                            this.options_ = builder.buildPartial();
                                        }
                                        this.bitField0_ |= 4;
                                    } else if (!a(readTag, codedInputStream)) {
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
                            synchronized (ExtensionRange.class) {
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

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
            public int getEnd() {
                return this.end_;
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
            public ExtensionRangeOptions getOptions() {
                ExtensionRangeOptions extensionRangeOptions = this.options_;
                return extensionRangeOptions == null ? ExtensionRangeOptions.getDefaultInstance() : extensionRangeOptions;
            }

            @Override // com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.c;
                if (i != -1) {
                    return i;
                }
                int computeInt32Size = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.start_) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    computeInt32Size += CodedOutputStream.computeInt32Size(2, this.end_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    computeInt32Size += CodedOutputStream.computeMessageSize(3, getOptions());
                }
                int serializedSize = computeInt32Size + this.b.getSerializedSize();
                this.c = serializedSize;
                return serializedSize;
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
            public int getStart() {
                return this.start_;
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
            public boolean hasEnd() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
            public boolean hasOptions() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
            public boolean hasStart() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) {
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.writeInt32(1, this.start_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.writeInt32(2, this.end_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    codedOutputStream.writeMessage(3, getOptions());
                }
                this.b.writeTo(codedOutputStream);
            }
        }

        /* loaded from: classes2.dex */
        public interface ExtensionRangeOrBuilder extends MessageLiteOrBuilder {
            int getEnd();

            ExtensionRangeOptions getOptions();

            int getStart();

            boolean hasEnd();

            boolean hasOptions();

            boolean hasStart();
        }

        /* loaded from: classes2.dex */
        public static final class ReservedRange extends GeneratedMessageLite<ReservedRange, Builder> implements ReservedRangeOrBuilder {
            private static final ReservedRange DEFAULT_INSTANCE = new ReservedRange();
            public static final int END_FIELD_NUMBER = 2;
            private static volatile Parser<ReservedRange> PARSER = null;
            public static final int START_FIELD_NUMBER = 1;
            private int bitField0_;
            private int end_;
            private int start_;

            /* loaded from: classes2.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<ReservedRange, Builder> implements ReservedRangeOrBuilder {
                private Builder() {
                    super(ReservedRange.DEFAULT_INSTANCE);
                }

                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                public Builder clearEnd() {
                    a();
                    ((ReservedRange) this.a).clearEnd();
                    return this;
                }

                public Builder clearStart() {
                    a();
                    ((ReservedRange) this.a).clearStart();
                    return this;
                }

                @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ReservedRangeOrBuilder
                public int getEnd() {
                    return ((ReservedRange) this.a).getEnd();
                }

                @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ReservedRangeOrBuilder
                public int getStart() {
                    return ((ReservedRange) this.a).getStart();
                }

                @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ReservedRangeOrBuilder
                public boolean hasEnd() {
                    return ((ReservedRange) this.a).hasEnd();
                }

                @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ReservedRangeOrBuilder
                public boolean hasStart() {
                    return ((ReservedRange) this.a).hasStart();
                }

                public Builder setEnd(int i) {
                    a();
                    ((ReservedRange) this.a).setEnd(i);
                    return this;
                }

                public Builder setStart(int i) {
                    a();
                    ((ReservedRange) this.a).setStart(i);
                    return this;
                }
            }

            static {
                DEFAULT_INSTANCE.b();
            }

            private ReservedRange() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearEnd() {
                this.bitField0_ &= -3;
                this.end_ = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearStart() {
                this.bitField0_ &= -2;
                this.start_ = 0;
            }

            public static ReservedRange getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(ReservedRange reservedRange) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) reservedRange);
            }

            public static ReservedRange parseDelimitedFrom(InputStream inputStream) {
                return (ReservedRange) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
            }

            public static ReservedRange parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (ReservedRange) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ReservedRange parseFrom(ByteString byteString) {
                return (ReservedRange) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
            }

            public static ReservedRange parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                return (ReservedRange) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static ReservedRange parseFrom(CodedInputStream codedInputStream) {
                return (ReservedRange) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
            }

            public static ReservedRange parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (ReservedRange) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static ReservedRange parseFrom(InputStream inputStream) {
                return (ReservedRange) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
            }

            public static ReservedRange parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (ReservedRange) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ReservedRange parseFrom(byte[] bArr) {
                return (ReservedRange) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
            }

            public static ReservedRange parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                return (ReservedRange) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static Parser<ReservedRange> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setEnd(int i) {
                this.bitField0_ |= 2;
                this.end_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setStart(int i) {
                this.bitField0_ |= 1;
                this.start_ = i;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new ReservedRange();
                    case 2:
                        return DEFAULT_INSTANCE;
                    case 3:
                        return null;
                    case 4:
                        return new Builder(anonymousClass1);
                    case 5:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        ReservedRange reservedRange = (ReservedRange) obj2;
                        this.start_ = visitor.visitInt(hasStart(), this.start_, reservedRange.hasStart(), reservedRange.start_);
                        this.end_ = visitor.visitInt(hasEnd(), this.end_, reservedRange.hasEnd(), reservedRange.end_);
                        if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                            this.bitField0_ |= reservedRange.bitField0_;
                        }
                        return this;
                    case 6:
                        CodedInputStream codedInputStream = (CodedInputStream) obj;
                        boolean z = false;
                        while (!z) {
                            try {
                                int readTag = codedInputStream.readTag();
                                if (readTag != 0) {
                                    if (readTag == 8) {
                                        this.bitField0_ |= 1;
                                        this.start_ = codedInputStream.readInt32();
                                    } else if (readTag == 16) {
                                        this.bitField0_ |= 2;
                                        this.end_ = codedInputStream.readInt32();
                                    } else if (!a(readTag, codedInputStream)) {
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
                            synchronized (ReservedRange.class) {
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

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ReservedRangeOrBuilder
            public int getEnd() {
                return this.end_;
            }

            @Override // com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.c;
                if (i != -1) {
                    return i;
                }
                int computeInt32Size = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.start_) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    computeInt32Size += CodedOutputStream.computeInt32Size(2, this.end_);
                }
                int serializedSize = computeInt32Size + this.b.getSerializedSize();
                this.c = serializedSize;
                return serializedSize;
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ReservedRangeOrBuilder
            public int getStart() {
                return this.start_;
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ReservedRangeOrBuilder
            public boolean hasEnd() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ReservedRangeOrBuilder
            public boolean hasStart() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) {
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.writeInt32(1, this.start_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.writeInt32(2, this.end_);
                }
                this.b.writeTo(codedOutputStream);
            }
        }

        /* loaded from: classes2.dex */
        public interface ReservedRangeOrBuilder extends MessageLiteOrBuilder {
            int getEnd();

            int getStart();

            boolean hasEnd();

            boolean hasStart();
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private DescriptorProto() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllEnumType(Iterable<? extends EnumDescriptorProto> iterable) {
            ensureEnumTypeIsMutable();
            AbstractMessageLite.a(iterable, this.enumType_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllExtension(Iterable<? extends FieldDescriptorProto> iterable) {
            ensureExtensionIsMutable();
            AbstractMessageLite.a(iterable, this.extension_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllExtensionRange(Iterable<? extends ExtensionRange> iterable) {
            ensureExtensionRangeIsMutable();
            AbstractMessageLite.a(iterable, this.extensionRange_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllField(Iterable<? extends FieldDescriptorProto> iterable) {
            ensureFieldIsMutable();
            AbstractMessageLite.a(iterable, this.field_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllNestedType(Iterable<? extends DescriptorProto> iterable) {
            ensureNestedTypeIsMutable();
            AbstractMessageLite.a(iterable, this.nestedType_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllOneofDecl(Iterable<? extends OneofDescriptorProto> iterable) {
            ensureOneofDeclIsMutable();
            AbstractMessageLite.a(iterable, this.oneofDecl_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllReservedName(Iterable<String> iterable) {
            ensureReservedNameIsMutable();
            AbstractMessageLite.a(iterable, this.reservedName_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllReservedRange(Iterable<? extends ReservedRange> iterable) {
            ensureReservedRangeIsMutable();
            AbstractMessageLite.a(iterable, this.reservedRange_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addEnumType(int i, EnumDescriptorProto.Builder builder) {
            ensureEnumTypeIsMutable();
            this.enumType_.add(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addEnumType(int i, EnumDescriptorProto enumDescriptorProto) {
            if (enumDescriptorProto == null) {
                throw new NullPointerException();
            }
            ensureEnumTypeIsMutable();
            this.enumType_.add(i, enumDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addEnumType(EnumDescriptorProto.Builder builder) {
            ensureEnumTypeIsMutable();
            this.enumType_.add(builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addEnumType(EnumDescriptorProto enumDescriptorProto) {
            if (enumDescriptorProto == null) {
                throw new NullPointerException();
            }
            ensureEnumTypeIsMutable();
            this.enumType_.add(enumDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addExtension(int i, FieldDescriptorProto.Builder builder) {
            ensureExtensionIsMutable();
            this.extension_.add(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addExtension(int i, FieldDescriptorProto fieldDescriptorProto) {
            if (fieldDescriptorProto == null) {
                throw new NullPointerException();
            }
            ensureExtensionIsMutable();
            this.extension_.add(i, fieldDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addExtension(FieldDescriptorProto.Builder builder) {
            ensureExtensionIsMutable();
            this.extension_.add(builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addExtension(FieldDescriptorProto fieldDescriptorProto) {
            if (fieldDescriptorProto == null) {
                throw new NullPointerException();
            }
            ensureExtensionIsMutable();
            this.extension_.add(fieldDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addExtensionRange(int i, ExtensionRange.Builder builder) {
            ensureExtensionRangeIsMutable();
            this.extensionRange_.add(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addExtensionRange(int i, ExtensionRange extensionRange) {
            if (extensionRange == null) {
                throw new NullPointerException();
            }
            ensureExtensionRangeIsMutable();
            this.extensionRange_.add(i, extensionRange);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addExtensionRange(ExtensionRange.Builder builder) {
            ensureExtensionRangeIsMutable();
            this.extensionRange_.add(builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addExtensionRange(ExtensionRange extensionRange) {
            if (extensionRange == null) {
                throw new NullPointerException();
            }
            ensureExtensionRangeIsMutable();
            this.extensionRange_.add(extensionRange);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addField(int i, FieldDescriptorProto.Builder builder) {
            ensureFieldIsMutable();
            this.field_.add(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addField(int i, FieldDescriptorProto fieldDescriptorProto) {
            if (fieldDescriptorProto == null) {
                throw new NullPointerException();
            }
            ensureFieldIsMutable();
            this.field_.add(i, fieldDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addField(FieldDescriptorProto.Builder builder) {
            ensureFieldIsMutable();
            this.field_.add(builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addField(FieldDescriptorProto fieldDescriptorProto) {
            if (fieldDescriptorProto == null) {
                throw new NullPointerException();
            }
            ensureFieldIsMutable();
            this.field_.add(fieldDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addNestedType(int i, Builder builder) {
            ensureNestedTypeIsMutable();
            this.nestedType_.add(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addNestedType(int i, DescriptorProto descriptorProto) {
            if (descriptorProto == null) {
                throw new NullPointerException();
            }
            ensureNestedTypeIsMutable();
            this.nestedType_.add(i, descriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addNestedType(Builder builder) {
            ensureNestedTypeIsMutable();
            this.nestedType_.add(builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addNestedType(DescriptorProto descriptorProto) {
            if (descriptorProto == null) {
                throw new NullPointerException();
            }
            ensureNestedTypeIsMutable();
            this.nestedType_.add(descriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addOneofDecl(int i, OneofDescriptorProto.Builder builder) {
            ensureOneofDeclIsMutable();
            this.oneofDecl_.add(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addOneofDecl(int i, OneofDescriptorProto oneofDescriptorProto) {
            if (oneofDescriptorProto == null) {
                throw new NullPointerException();
            }
            ensureOneofDeclIsMutable();
            this.oneofDecl_.add(i, oneofDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addOneofDecl(OneofDescriptorProto.Builder builder) {
            ensureOneofDeclIsMutable();
            this.oneofDecl_.add(builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addOneofDecl(OneofDescriptorProto oneofDescriptorProto) {
            if (oneofDescriptorProto == null) {
                throw new NullPointerException();
            }
            ensureOneofDeclIsMutable();
            this.oneofDecl_.add(oneofDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addReservedName(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            ensureReservedNameIsMutable();
            this.reservedName_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addReservedNameBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            ensureReservedNameIsMutable();
            this.reservedName_.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addReservedRange(int i, ReservedRange.Builder builder) {
            ensureReservedRangeIsMutable();
            this.reservedRange_.add(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addReservedRange(int i, ReservedRange reservedRange) {
            if (reservedRange == null) {
                throw new NullPointerException();
            }
            ensureReservedRangeIsMutable();
            this.reservedRange_.add(i, reservedRange);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addReservedRange(ReservedRange.Builder builder) {
            ensureReservedRangeIsMutable();
            this.reservedRange_.add(builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addReservedRange(ReservedRange reservedRange) {
            if (reservedRange == null) {
                throw new NullPointerException();
            }
            ensureReservedRangeIsMutable();
            this.reservedRange_.add(reservedRange);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEnumType() {
            this.enumType_ = GeneratedMessageLite.f();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearExtension() {
            this.extension_ = GeneratedMessageLite.f();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearExtensionRange() {
            this.extensionRange_ = GeneratedMessageLite.f();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearField() {
            this.field_ = GeneratedMessageLite.f();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearName() {
            this.bitField0_ &= -2;
            this.name_ = getDefaultInstance().getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNestedType() {
            this.nestedType_ = GeneratedMessageLite.f();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOneofDecl() {
            this.oneofDecl_ = GeneratedMessageLite.f();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOptions() {
            this.options_ = null;
            this.bitField0_ &= -3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearReservedName() {
            this.reservedName_ = GeneratedMessageLite.f();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearReservedRange() {
            this.reservedRange_ = GeneratedMessageLite.f();
        }

        private void ensureEnumTypeIsMutable() {
            if (this.enumType_.isModifiable()) {
                return;
            }
            this.enumType_ = GeneratedMessageLite.a(this.enumType_);
        }

        private void ensureExtensionIsMutable() {
            if (this.extension_.isModifiable()) {
                return;
            }
            this.extension_ = GeneratedMessageLite.a(this.extension_);
        }

        private void ensureExtensionRangeIsMutable() {
            if (this.extensionRange_.isModifiable()) {
                return;
            }
            this.extensionRange_ = GeneratedMessageLite.a(this.extensionRange_);
        }

        private void ensureFieldIsMutable() {
            if (this.field_.isModifiable()) {
                return;
            }
            this.field_ = GeneratedMessageLite.a(this.field_);
        }

        private void ensureNestedTypeIsMutable() {
            if (this.nestedType_.isModifiable()) {
                return;
            }
            this.nestedType_ = GeneratedMessageLite.a(this.nestedType_);
        }

        private void ensureOneofDeclIsMutable() {
            if (this.oneofDecl_.isModifiable()) {
                return;
            }
            this.oneofDecl_ = GeneratedMessageLite.a(this.oneofDecl_);
        }

        private void ensureReservedNameIsMutable() {
            if (this.reservedName_.isModifiable()) {
                return;
            }
            this.reservedName_ = GeneratedMessageLite.a(this.reservedName_);
        }

        private void ensureReservedRangeIsMutable() {
            if (this.reservedRange_.isModifiable()) {
                return;
            }
            this.reservedRange_ = GeneratedMessageLite.a(this.reservedRange_);
        }

        public static DescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public void mergeOptions(MessageOptions messageOptions) {
            MessageOptions messageOptions2 = this.options_;
            if (messageOptions2 != null && messageOptions2 != MessageOptions.getDefaultInstance()) {
                messageOptions = ((MessageOptions.Builder) MessageOptions.newBuilder(this.options_).mergeFrom((MessageOptions.Builder) messageOptions)).buildPartial();
            }
            this.options_ = messageOptions;
            this.bitField0_ |= 2;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DescriptorProto descriptorProto) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) descriptorProto);
        }

        public static DescriptorProto parseDelimitedFrom(InputStream inputStream) {
            return (DescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static DescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (DescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DescriptorProto parseFrom(ByteString byteString) {
            return (DescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static DescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (DescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static DescriptorProto parseFrom(CodedInputStream codedInputStream) {
            return (DescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static DescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (DescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static DescriptorProto parseFrom(InputStream inputStream) {
            return (DescriptorProto) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static DescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (DescriptorProto) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DescriptorProto parseFrom(byte[] bArr) {
            return (DescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static DescriptorProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (DescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<DescriptorProto> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeEnumType(int i) {
            ensureEnumTypeIsMutable();
            this.enumType_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeExtension(int i) {
            ensureExtensionIsMutable();
            this.extension_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeExtensionRange(int i) {
            ensureExtensionRangeIsMutable();
            this.extensionRange_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeField(int i) {
            ensureFieldIsMutable();
            this.field_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeNestedType(int i) {
            ensureNestedTypeIsMutable();
            this.nestedType_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeOneofDecl(int i) {
            ensureOneofDeclIsMutable();
            this.oneofDecl_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeReservedRange(int i) {
            ensureReservedRangeIsMutable();
            this.reservedRange_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEnumType(int i, EnumDescriptorProto.Builder builder) {
            ensureEnumTypeIsMutable();
            this.enumType_.set(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEnumType(int i, EnumDescriptorProto enumDescriptorProto) {
            if (enumDescriptorProto == null) {
                throw new NullPointerException();
            }
            ensureEnumTypeIsMutable();
            this.enumType_.set(i, enumDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExtension(int i, FieldDescriptorProto.Builder builder) {
            ensureExtensionIsMutable();
            this.extension_.set(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExtension(int i, FieldDescriptorProto fieldDescriptorProto) {
            if (fieldDescriptorProto == null) {
                throw new NullPointerException();
            }
            ensureExtensionIsMutable();
            this.extension_.set(i, fieldDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExtensionRange(int i, ExtensionRange.Builder builder) {
            ensureExtensionRangeIsMutable();
            this.extensionRange_.set(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExtensionRange(int i, ExtensionRange extensionRange) {
            if (extensionRange == null) {
                throw new NullPointerException();
            }
            ensureExtensionRangeIsMutable();
            this.extensionRange_.set(i, extensionRange);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setField(int i, FieldDescriptorProto.Builder builder) {
            ensureFieldIsMutable();
            this.field_.set(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setField(int i, FieldDescriptorProto fieldDescriptorProto) {
            if (fieldDescriptorProto == null) {
                throw new NullPointerException();
            }
            ensureFieldIsMutable();
            this.field_.set(i, fieldDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setName(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 1;
            this.name_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNameBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 1;
            this.name_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNestedType(int i, Builder builder) {
            ensureNestedTypeIsMutable();
            this.nestedType_.set(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNestedType(int i, DescriptorProto descriptorProto) {
            if (descriptorProto == null) {
                throw new NullPointerException();
            }
            ensureNestedTypeIsMutable();
            this.nestedType_.set(i, descriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOneofDecl(int i, OneofDescriptorProto.Builder builder) {
            ensureOneofDeclIsMutable();
            this.oneofDecl_.set(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOneofDecl(int i, OneofDescriptorProto oneofDescriptorProto) {
            if (oneofDescriptorProto == null) {
                throw new NullPointerException();
            }
            ensureOneofDeclIsMutable();
            this.oneofDecl_.set(i, oneofDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public void setOptions(MessageOptions.Builder builder) {
            this.options_ = (MessageOptions) builder.build();
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOptions(MessageOptions messageOptions) {
            if (messageOptions == null) {
                throw new NullPointerException();
            }
            this.options_ = messageOptions;
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setReservedName(int i, String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            ensureReservedNameIsMutable();
            this.reservedName_.set(i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setReservedRange(int i, ReservedRange.Builder builder) {
            ensureReservedRangeIsMutable();
            this.reservedRange_.set(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setReservedRange(int i, ReservedRange reservedRange) {
            if (reservedRange == null) {
                throw new NullPointerException();
            }
            ensureReservedRangeIsMutable();
            this.reservedRange_.set(i, reservedRange);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:26:0x003a. Please report as an issue. */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            List list;
            MessageLite messageLite;
            AnonymousClass1 anonymousClass1 = null;
            boolean z = false;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new DescriptorProto();
                case 2:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i = 0; i < getFieldCount(); i++) {
                        if (!getField(i).isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = (byte) 0;
                            }
                            return null;
                        }
                    }
                    for (int i2 = 0; i2 < getExtensionCount(); i2++) {
                        if (!getExtension(i2).isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = (byte) 0;
                            }
                            return null;
                        }
                    }
                    for (int i3 = 0; i3 < getNestedTypeCount(); i3++) {
                        if (!getNestedType(i3).isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = (byte) 0;
                            }
                            return null;
                        }
                    }
                    for (int i4 = 0; i4 < getEnumTypeCount(); i4++) {
                        if (!getEnumType(i4).isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = (byte) 0;
                            }
                            return null;
                        }
                    }
                    for (int i5 = 0; i5 < getExtensionRangeCount(); i5++) {
                        if (!getExtensionRange(i5).isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = (byte) 0;
                            }
                            return null;
                        }
                    }
                    for (int i6 = 0; i6 < getOneofDeclCount(); i6++) {
                        if (!getOneofDecl(i6).isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = (byte) 0;
                            }
                            return null;
                        }
                    }
                    if (!hasOptions() || getOptions().isInitialized()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = (byte) 1;
                        }
                        return DEFAULT_INSTANCE;
                    }
                    if (booleanValue) {
                        this.memoizedIsInitialized = (byte) 0;
                    }
                    return null;
                case 3:
                    this.field_.makeImmutable();
                    this.extension_.makeImmutable();
                    this.nestedType_.makeImmutable();
                    this.enumType_.makeImmutable();
                    this.extensionRange_.makeImmutable();
                    this.oneofDecl_.makeImmutable();
                    this.reservedRange_.makeImmutable();
                    this.reservedName_.makeImmutable();
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    DescriptorProto descriptorProto = (DescriptorProto) obj2;
                    this.name_ = visitor.visitString(hasName(), this.name_, descriptorProto.hasName(), descriptorProto.name_);
                    this.field_ = visitor.visitList(this.field_, descriptorProto.field_);
                    this.extension_ = visitor.visitList(this.extension_, descriptorProto.extension_);
                    this.nestedType_ = visitor.visitList(this.nestedType_, descriptorProto.nestedType_);
                    this.enumType_ = visitor.visitList(this.enumType_, descriptorProto.enumType_);
                    this.extensionRange_ = visitor.visitList(this.extensionRange_, descriptorProto.extensionRange_);
                    this.oneofDecl_ = visitor.visitList(this.oneofDecl_, descriptorProto.oneofDecl_);
                    this.options_ = (MessageOptions) visitor.visitMessage(this.options_, descriptorProto.options_);
                    this.reservedRange_ = visitor.visitList(this.reservedRange_, descriptorProto.reservedRange_);
                    this.reservedName_ = visitor.visitList(this.reservedName_, descriptorProto.reservedName_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= descriptorProto.bitField0_;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            try {
                                int readTag = codedInputStream.readTag();
                                switch (readTag) {
                                    case 0:
                                        z = true;
                                    case 10:
                                        String readString = codedInputStream.readString();
                                        this.bitField0_ |= 1;
                                        this.name_ = readString;
                                    case 18:
                                        if (!this.field_.isModifiable()) {
                                            this.field_ = GeneratedMessageLite.a(this.field_);
                                        }
                                        list = this.field_;
                                        messageLite = (FieldDescriptorProto) codedInputStream.readMessage(FieldDescriptorProto.parser(), extensionRegistryLite);
                                        list.add(messageLite);
                                    case 26:
                                        if (!this.nestedType_.isModifiable()) {
                                            this.nestedType_ = GeneratedMessageLite.a(this.nestedType_);
                                        }
                                        list = this.nestedType_;
                                        messageLite = (DescriptorProto) codedInputStream.readMessage(parser(), extensionRegistryLite);
                                        list.add(messageLite);
                                    case 34:
                                        if (!this.enumType_.isModifiable()) {
                                            this.enumType_ = GeneratedMessageLite.a(this.enumType_);
                                        }
                                        list = this.enumType_;
                                        messageLite = (EnumDescriptorProto) codedInputStream.readMessage(EnumDescriptorProto.parser(), extensionRegistryLite);
                                        list.add(messageLite);
                                    case 42:
                                        if (!this.extensionRange_.isModifiable()) {
                                            this.extensionRange_ = GeneratedMessageLite.a(this.extensionRange_);
                                        }
                                        list = this.extensionRange_;
                                        messageLite = (ExtensionRange) codedInputStream.readMessage(ExtensionRange.parser(), extensionRegistryLite);
                                        list.add(messageLite);
                                    case 50:
                                        if (!this.extension_.isModifiable()) {
                                            this.extension_ = GeneratedMessageLite.a(this.extension_);
                                        }
                                        list = this.extension_;
                                        messageLite = (FieldDescriptorProto) codedInputStream.readMessage(FieldDescriptorProto.parser(), extensionRegistryLite);
                                        list.add(messageLite);
                                    case 58:
                                        MessageOptions.Builder builder = (this.bitField0_ & 2) == 2 ? (MessageOptions.Builder) this.options_.toBuilder() : null;
                                        this.options_ = (MessageOptions) codedInputStream.readMessage(MessageOptions.parser(), extensionRegistryLite);
                                        if (builder != null) {
                                            builder.mergeFrom((MessageOptions.Builder) this.options_);
                                            this.options_ = builder.buildPartial();
                                        }
                                        this.bitField0_ |= 2;
                                    case 66:
                                        if (!this.oneofDecl_.isModifiable()) {
                                            this.oneofDecl_ = GeneratedMessageLite.a(this.oneofDecl_);
                                        }
                                        list = this.oneofDecl_;
                                        messageLite = (OneofDescriptorProto) codedInputStream.readMessage(OneofDescriptorProto.parser(), extensionRegistryLite);
                                        list.add(messageLite);
                                    case 74:
                                        if (!this.reservedRange_.isModifiable()) {
                                            this.reservedRange_ = GeneratedMessageLite.a(this.reservedRange_);
                                        }
                                        list = this.reservedRange_;
                                        messageLite = (ReservedRange) codedInputStream.readMessage(ReservedRange.parser(), extensionRegistryLite);
                                        list.add(messageLite);
                                    case 82:
                                        String readString2 = codedInputStream.readString();
                                        if (!this.reservedName_.isModifiable()) {
                                            this.reservedName_ = GeneratedMessageLite.a(this.reservedName_);
                                        }
                                        this.reservedName_.add(readString2);
                                    default:
                                        if (!a(readTag, codedInputStream)) {
                                            z = true;
                                        }
                                }
                            } catch (IOException e) {
                                throw new RuntimeException(new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this));
                            }
                        } catch (InvalidProtocolBufferException e2) {
                            throw new RuntimeException(e2.setUnfinishedMessage(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (PARSER == null) {
                        synchronized (DescriptorProto.class) {
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

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public EnumDescriptorProto getEnumType(int i) {
            return this.enumType_.get(i);
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public int getEnumTypeCount() {
            return this.enumType_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public List<EnumDescriptorProto> getEnumTypeList() {
            return this.enumType_;
        }

        public EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(int i) {
            return this.enumType_.get(i);
        }

        public List<? extends EnumDescriptorProtoOrBuilder> getEnumTypeOrBuilderList() {
            return this.enumType_;
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public FieldDescriptorProto getExtension(int i) {
            return this.extension_.get(i);
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public int getExtensionCount() {
            return this.extension_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public List<FieldDescriptorProto> getExtensionList() {
            return this.extension_;
        }

        public FieldDescriptorProtoOrBuilder getExtensionOrBuilder(int i) {
            return this.extension_.get(i);
        }

        public List<? extends FieldDescriptorProtoOrBuilder> getExtensionOrBuilderList() {
            return this.extension_;
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public ExtensionRange getExtensionRange(int i) {
            return this.extensionRange_.get(i);
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public int getExtensionRangeCount() {
            return this.extensionRange_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public List<ExtensionRange> getExtensionRangeList() {
            return this.extensionRange_;
        }

        public ExtensionRangeOrBuilder getExtensionRangeOrBuilder(int i) {
            return this.extensionRange_.get(i);
        }

        public List<? extends ExtensionRangeOrBuilder> getExtensionRangeOrBuilderList() {
            return this.extensionRange_;
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public FieldDescriptorProto getField(int i) {
            return this.field_.get(i);
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public int getFieldCount() {
            return this.field_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public List<FieldDescriptorProto> getFieldList() {
            return this.field_;
        }

        public FieldDescriptorProtoOrBuilder getFieldOrBuilder(int i) {
            return this.field_.get(i);
        }

        public List<? extends FieldDescriptorProtoOrBuilder> getFieldOrBuilderList() {
            return this.field_;
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public String getName() {
            return this.name_;
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public DescriptorProto getNestedType(int i) {
            return this.nestedType_.get(i);
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public int getNestedTypeCount() {
            return this.nestedType_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public List<DescriptorProto> getNestedTypeList() {
            return this.nestedType_;
        }

        public DescriptorProtoOrBuilder getNestedTypeOrBuilder(int i) {
            return this.nestedType_.get(i);
        }

        public List<? extends DescriptorProtoOrBuilder> getNestedTypeOrBuilderList() {
            return this.nestedType_;
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public OneofDescriptorProto getOneofDecl(int i) {
            return this.oneofDecl_.get(i);
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public int getOneofDeclCount() {
            return this.oneofDecl_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public List<OneofDescriptorProto> getOneofDeclList() {
            return this.oneofDecl_;
        }

        public OneofDescriptorProtoOrBuilder getOneofDeclOrBuilder(int i) {
            return this.oneofDecl_.get(i);
        }

        public List<? extends OneofDescriptorProtoOrBuilder> getOneofDeclOrBuilderList() {
            return this.oneofDecl_;
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public MessageOptions getOptions() {
            MessageOptions messageOptions = this.options_;
            return messageOptions == null ? MessageOptions.getDefaultInstance() : messageOptions;
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public String getReservedName(int i) {
            return this.reservedName_.get(i);
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public ByteString getReservedNameBytes(int i) {
            return ByteString.copyFromUtf8(this.reservedName_.get(i));
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public int getReservedNameCount() {
            return this.reservedName_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public List<String> getReservedNameList() {
            return this.reservedName_;
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public ReservedRange getReservedRange(int i) {
            return this.reservedRange_.get(i);
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public int getReservedRangeCount() {
            return this.reservedRange_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public List<ReservedRange> getReservedRangeList() {
            return this.reservedRange_;
        }

        public ReservedRangeOrBuilder getReservedRangeOrBuilder(int i) {
            return this.reservedRange_.get(i);
        }

        public List<? extends ReservedRangeOrBuilder> getReservedRangeOrBuilderList() {
            return this.reservedRange_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeStringSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeStringSize(1, getName()) + 0 : 0;
            for (int i2 = 0; i2 < this.field_.size(); i2++) {
                computeStringSize += CodedOutputStream.computeMessageSize(2, this.field_.get(i2));
            }
            for (int i3 = 0; i3 < this.nestedType_.size(); i3++) {
                computeStringSize += CodedOutputStream.computeMessageSize(3, this.nestedType_.get(i3));
            }
            for (int i4 = 0; i4 < this.enumType_.size(); i4++) {
                computeStringSize += CodedOutputStream.computeMessageSize(4, this.enumType_.get(i4));
            }
            for (int i5 = 0; i5 < this.extensionRange_.size(); i5++) {
                computeStringSize += CodedOutputStream.computeMessageSize(5, this.extensionRange_.get(i5));
            }
            for (int i6 = 0; i6 < this.extension_.size(); i6++) {
                computeStringSize += CodedOutputStream.computeMessageSize(6, this.extension_.get(i6));
            }
            if ((this.bitField0_ & 2) == 2) {
                computeStringSize += CodedOutputStream.computeMessageSize(7, getOptions());
            }
            for (int i7 = 0; i7 < this.oneofDecl_.size(); i7++) {
                computeStringSize += CodedOutputStream.computeMessageSize(8, this.oneofDecl_.get(i7));
            }
            for (int i8 = 0; i8 < this.reservedRange_.size(); i8++) {
                computeStringSize += CodedOutputStream.computeMessageSize(9, this.reservedRange_.get(i8));
            }
            int i9 = 0;
            for (int i10 = 0; i10 < this.reservedName_.size(); i10++) {
                i9 += CodedOutputStream.computeStringSizeNoTag(this.reservedName_.get(i10));
            }
            int size = computeStringSize + i9 + (getReservedNameList().size() * 1) + this.b.getSerializedSize();
            this.c = size;
            return size;
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public boolean hasOptions() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeString(1, getName());
            }
            for (int i = 0; i < this.field_.size(); i++) {
                codedOutputStream.writeMessage(2, this.field_.get(i));
            }
            for (int i2 = 0; i2 < this.nestedType_.size(); i2++) {
                codedOutputStream.writeMessage(3, this.nestedType_.get(i2));
            }
            for (int i3 = 0; i3 < this.enumType_.size(); i3++) {
                codedOutputStream.writeMessage(4, this.enumType_.get(i3));
            }
            for (int i4 = 0; i4 < this.extensionRange_.size(); i4++) {
                codedOutputStream.writeMessage(5, this.extensionRange_.get(i4));
            }
            for (int i5 = 0; i5 < this.extension_.size(); i5++) {
                codedOutputStream.writeMessage(6, this.extension_.get(i5));
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(7, getOptions());
            }
            for (int i6 = 0; i6 < this.oneofDecl_.size(); i6++) {
                codedOutputStream.writeMessage(8, this.oneofDecl_.get(i6));
            }
            for (int i7 = 0; i7 < this.reservedRange_.size(); i7++) {
                codedOutputStream.writeMessage(9, this.reservedRange_.get(i7));
            }
            for (int i8 = 0; i8 < this.reservedName_.size(); i8++) {
                codedOutputStream.writeString(10, this.reservedName_.get(i8));
            }
            this.b.writeTo(codedOutputStream);
        }
    }

    /* loaded from: classes2.dex */
    public interface DescriptorProtoOrBuilder extends MessageLiteOrBuilder {
        EnumDescriptorProto getEnumType(int i);

        int getEnumTypeCount();

        List<EnumDescriptorProto> getEnumTypeList();

        FieldDescriptorProto getExtension(int i);

        int getExtensionCount();

        List<FieldDescriptorProto> getExtensionList();

        DescriptorProto.ExtensionRange getExtensionRange(int i);

        int getExtensionRangeCount();

        List<DescriptorProto.ExtensionRange> getExtensionRangeList();

        FieldDescriptorProto getField(int i);

        int getFieldCount();

        List<FieldDescriptorProto> getFieldList();

        String getName();

        ByteString getNameBytes();

        DescriptorProto getNestedType(int i);

        int getNestedTypeCount();

        List<DescriptorProto> getNestedTypeList();

        OneofDescriptorProto getOneofDecl(int i);

        int getOneofDeclCount();

        List<OneofDescriptorProto> getOneofDeclList();

        MessageOptions getOptions();

        String getReservedName(int i);

        ByteString getReservedNameBytes(int i);

        int getReservedNameCount();

        List<String> getReservedNameList();

        DescriptorProto.ReservedRange getReservedRange(int i);

        int getReservedRangeCount();

        List<DescriptorProto.ReservedRange> getReservedRangeList();

        boolean hasName();

        boolean hasOptions();
    }

    /* loaded from: classes2.dex */
    public static final class EnumDescriptorProto extends GeneratedMessageLite<EnumDescriptorProto, Builder> implements EnumDescriptorProtoOrBuilder {
        private static final EnumDescriptorProto DEFAULT_INSTANCE = new EnumDescriptorProto();
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 3;
        private static volatile Parser<EnumDescriptorProto> PARSER = null;
        public static final int RESERVED_NAME_FIELD_NUMBER = 5;
        public static final int RESERVED_RANGE_FIELD_NUMBER = 4;
        public static final int VALUE_FIELD_NUMBER = 2;
        private int bitField0_;
        private EnumOptions options_;
        private byte memoizedIsInitialized = -1;
        private String name_ = "";
        private Internal.ProtobufList<EnumValueDescriptorProto> value_ = GeneratedMessageLite.f();
        private Internal.ProtobufList<EnumReservedRange> reservedRange_ = GeneratedMessageLite.f();
        private Internal.ProtobufList<String> reservedName_ = GeneratedMessageLite.f();

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<EnumDescriptorProto, Builder> implements EnumDescriptorProtoOrBuilder {
            private Builder() {
                super(EnumDescriptorProto.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllReservedName(Iterable<String> iterable) {
                a();
                ((EnumDescriptorProto) this.a).addAllReservedName(iterable);
                return this;
            }

            public Builder addAllReservedRange(Iterable<? extends EnumReservedRange> iterable) {
                a();
                ((EnumDescriptorProto) this.a).addAllReservedRange(iterable);
                return this;
            }

            public Builder addAllValue(Iterable<? extends EnumValueDescriptorProto> iterable) {
                a();
                ((EnumDescriptorProto) this.a).addAllValue(iterable);
                return this;
            }

            public Builder addReservedName(String str) {
                a();
                ((EnumDescriptorProto) this.a).addReservedName(str);
                return this;
            }

            public Builder addReservedNameBytes(ByteString byteString) {
                a();
                ((EnumDescriptorProto) this.a).addReservedNameBytes(byteString);
                return this;
            }

            public Builder addReservedRange(int i, EnumReservedRange.Builder builder) {
                a();
                ((EnumDescriptorProto) this.a).addReservedRange(i, builder);
                return this;
            }

            public Builder addReservedRange(int i, EnumReservedRange enumReservedRange) {
                a();
                ((EnumDescriptorProto) this.a).addReservedRange(i, enumReservedRange);
                return this;
            }

            public Builder addReservedRange(EnumReservedRange.Builder builder) {
                a();
                ((EnumDescriptorProto) this.a).addReservedRange(builder);
                return this;
            }

            public Builder addReservedRange(EnumReservedRange enumReservedRange) {
                a();
                ((EnumDescriptorProto) this.a).addReservedRange(enumReservedRange);
                return this;
            }

            public Builder addValue(int i, EnumValueDescriptorProto.Builder builder) {
                a();
                ((EnumDescriptorProto) this.a).addValue(i, builder);
                return this;
            }

            public Builder addValue(int i, EnumValueDescriptorProto enumValueDescriptorProto) {
                a();
                ((EnumDescriptorProto) this.a).addValue(i, enumValueDescriptorProto);
                return this;
            }

            public Builder addValue(EnumValueDescriptorProto.Builder builder) {
                a();
                ((EnumDescriptorProto) this.a).addValue(builder);
                return this;
            }

            public Builder addValue(EnumValueDescriptorProto enumValueDescriptorProto) {
                a();
                ((EnumDescriptorProto) this.a).addValue(enumValueDescriptorProto);
                return this;
            }

            public Builder clearName() {
                a();
                ((EnumDescriptorProto) this.a).clearName();
                return this;
            }

            public Builder clearOptions() {
                a();
                ((EnumDescriptorProto) this.a).clearOptions();
                return this;
            }

            public Builder clearReservedName() {
                a();
                ((EnumDescriptorProto) this.a).clearReservedName();
                return this;
            }

            public Builder clearReservedRange() {
                a();
                ((EnumDescriptorProto) this.a).clearReservedRange();
                return this;
            }

            public Builder clearValue() {
                a();
                ((EnumDescriptorProto) this.a).clearValue();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public String getName() {
                return ((EnumDescriptorProto) this.a).getName();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public ByteString getNameBytes() {
                return ((EnumDescriptorProto) this.a).getNameBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public EnumOptions getOptions() {
                return ((EnumDescriptorProto) this.a).getOptions();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public String getReservedName(int i) {
                return ((EnumDescriptorProto) this.a).getReservedName(i);
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public ByteString getReservedNameBytes(int i) {
                return ((EnumDescriptorProto) this.a).getReservedNameBytes(i);
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public int getReservedNameCount() {
                return ((EnumDescriptorProto) this.a).getReservedNameCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public List<String> getReservedNameList() {
                return Collections.unmodifiableList(((EnumDescriptorProto) this.a).getReservedNameList());
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public EnumReservedRange getReservedRange(int i) {
                return ((EnumDescriptorProto) this.a).getReservedRange(i);
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public int getReservedRangeCount() {
                return ((EnumDescriptorProto) this.a).getReservedRangeCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public List<EnumReservedRange> getReservedRangeList() {
                return Collections.unmodifiableList(((EnumDescriptorProto) this.a).getReservedRangeList());
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public EnumValueDescriptorProto getValue(int i) {
                return ((EnumDescriptorProto) this.a).getValue(i);
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public int getValueCount() {
                return ((EnumDescriptorProto) this.a).getValueCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public List<EnumValueDescriptorProto> getValueList() {
                return Collections.unmodifiableList(((EnumDescriptorProto) this.a).getValueList());
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public boolean hasName() {
                return ((EnumDescriptorProto) this.a).hasName();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public boolean hasOptions() {
                return ((EnumDescriptorProto) this.a).hasOptions();
            }

            public Builder mergeOptions(EnumOptions enumOptions) {
                a();
                ((EnumDescriptorProto) this.a).mergeOptions(enumOptions);
                return this;
            }

            public Builder removeReservedRange(int i) {
                a();
                ((EnumDescriptorProto) this.a).removeReservedRange(i);
                return this;
            }

            public Builder removeValue(int i) {
                a();
                ((EnumDescriptorProto) this.a).removeValue(i);
                return this;
            }

            public Builder setName(String str) {
                a();
                ((EnumDescriptorProto) this.a).setName(str);
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                a();
                ((EnumDescriptorProto) this.a).setNameBytes(byteString);
                return this;
            }

            public Builder setOptions(EnumOptions.Builder builder) {
                a();
                ((EnumDescriptorProto) this.a).setOptions(builder);
                return this;
            }

            public Builder setOptions(EnumOptions enumOptions) {
                a();
                ((EnumDescriptorProto) this.a).setOptions(enumOptions);
                return this;
            }

            public Builder setReservedName(int i, String str) {
                a();
                ((EnumDescriptorProto) this.a).setReservedName(i, str);
                return this;
            }

            public Builder setReservedRange(int i, EnumReservedRange.Builder builder) {
                a();
                ((EnumDescriptorProto) this.a).setReservedRange(i, builder);
                return this;
            }

            public Builder setReservedRange(int i, EnumReservedRange enumReservedRange) {
                a();
                ((EnumDescriptorProto) this.a).setReservedRange(i, enumReservedRange);
                return this;
            }

            public Builder setValue(int i, EnumValueDescriptorProto.Builder builder) {
                a();
                ((EnumDescriptorProto) this.a).setValue(i, builder);
                return this;
            }

            public Builder setValue(int i, EnumValueDescriptorProto enumValueDescriptorProto) {
                a();
                ((EnumDescriptorProto) this.a).setValue(i, enumValueDescriptorProto);
                return this;
            }
        }

        /* loaded from: classes2.dex */
        public static final class EnumReservedRange extends GeneratedMessageLite<EnumReservedRange, Builder> implements EnumReservedRangeOrBuilder {
            private static final EnumReservedRange DEFAULT_INSTANCE = new EnumReservedRange();
            public static final int END_FIELD_NUMBER = 2;
            private static volatile Parser<EnumReservedRange> PARSER = null;
            public static final int START_FIELD_NUMBER = 1;
            private int bitField0_;
            private int end_;
            private int start_;

            /* loaded from: classes2.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<EnumReservedRange, Builder> implements EnumReservedRangeOrBuilder {
                private Builder() {
                    super(EnumReservedRange.DEFAULT_INSTANCE);
                }

                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                public Builder clearEnd() {
                    a();
                    ((EnumReservedRange) this.a).clearEnd();
                    return this;
                }

                public Builder clearStart() {
                    a();
                    ((EnumReservedRange) this.a).clearStart();
                    return this;
                }

                @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProto.EnumReservedRangeOrBuilder
                public int getEnd() {
                    return ((EnumReservedRange) this.a).getEnd();
                }

                @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProto.EnumReservedRangeOrBuilder
                public int getStart() {
                    return ((EnumReservedRange) this.a).getStart();
                }

                @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProto.EnumReservedRangeOrBuilder
                public boolean hasEnd() {
                    return ((EnumReservedRange) this.a).hasEnd();
                }

                @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProto.EnumReservedRangeOrBuilder
                public boolean hasStart() {
                    return ((EnumReservedRange) this.a).hasStart();
                }

                public Builder setEnd(int i) {
                    a();
                    ((EnumReservedRange) this.a).setEnd(i);
                    return this;
                }

                public Builder setStart(int i) {
                    a();
                    ((EnumReservedRange) this.a).setStart(i);
                    return this;
                }
            }

            static {
                DEFAULT_INSTANCE.b();
            }

            private EnumReservedRange() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearEnd() {
                this.bitField0_ &= -3;
                this.end_ = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearStart() {
                this.bitField0_ &= -2;
                this.start_ = 0;
            }

            public static EnumReservedRange getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(EnumReservedRange enumReservedRange) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) enumReservedRange);
            }

            public static EnumReservedRange parseDelimitedFrom(InputStream inputStream) {
                return (EnumReservedRange) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
            }

            public static EnumReservedRange parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (EnumReservedRange) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static EnumReservedRange parseFrom(ByteString byteString) {
                return (EnumReservedRange) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
            }

            public static EnumReservedRange parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                return (EnumReservedRange) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static EnumReservedRange parseFrom(CodedInputStream codedInputStream) {
                return (EnumReservedRange) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
            }

            public static EnumReservedRange parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (EnumReservedRange) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static EnumReservedRange parseFrom(InputStream inputStream) {
                return (EnumReservedRange) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
            }

            public static EnumReservedRange parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (EnumReservedRange) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static EnumReservedRange parseFrom(byte[] bArr) {
                return (EnumReservedRange) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
            }

            public static EnumReservedRange parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                return (EnumReservedRange) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static Parser<EnumReservedRange> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setEnd(int i) {
                this.bitField0_ |= 2;
                this.end_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setStart(int i) {
                this.bitField0_ |= 1;
                this.start_ = i;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new EnumReservedRange();
                    case 2:
                        return DEFAULT_INSTANCE;
                    case 3:
                        return null;
                    case 4:
                        return new Builder(anonymousClass1);
                    case 5:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        EnumReservedRange enumReservedRange = (EnumReservedRange) obj2;
                        this.start_ = visitor.visitInt(hasStart(), this.start_, enumReservedRange.hasStart(), enumReservedRange.start_);
                        this.end_ = visitor.visitInt(hasEnd(), this.end_, enumReservedRange.hasEnd(), enumReservedRange.end_);
                        if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                            this.bitField0_ |= enumReservedRange.bitField0_;
                        }
                        return this;
                    case 6:
                        CodedInputStream codedInputStream = (CodedInputStream) obj;
                        boolean z = false;
                        while (!z) {
                            try {
                                int readTag = codedInputStream.readTag();
                                if (readTag != 0) {
                                    if (readTag == 8) {
                                        this.bitField0_ |= 1;
                                        this.start_ = codedInputStream.readInt32();
                                    } else if (readTag == 16) {
                                        this.bitField0_ |= 2;
                                        this.end_ = codedInputStream.readInt32();
                                    } else if (!a(readTag, codedInputStream)) {
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
                            synchronized (EnumReservedRange.class) {
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

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProto.EnumReservedRangeOrBuilder
            public int getEnd() {
                return this.end_;
            }

            @Override // com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.c;
                if (i != -1) {
                    return i;
                }
                int computeInt32Size = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.start_) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    computeInt32Size += CodedOutputStream.computeInt32Size(2, this.end_);
                }
                int serializedSize = computeInt32Size + this.b.getSerializedSize();
                this.c = serializedSize;
                return serializedSize;
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProto.EnumReservedRangeOrBuilder
            public int getStart() {
                return this.start_;
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProto.EnumReservedRangeOrBuilder
            public boolean hasEnd() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProto.EnumReservedRangeOrBuilder
            public boolean hasStart() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) {
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.writeInt32(1, this.start_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.writeInt32(2, this.end_);
                }
                this.b.writeTo(codedOutputStream);
            }
        }

        /* loaded from: classes2.dex */
        public interface EnumReservedRangeOrBuilder extends MessageLiteOrBuilder {
            int getEnd();

            int getStart();

            boolean hasEnd();

            boolean hasStart();
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private EnumDescriptorProto() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllReservedName(Iterable<String> iterable) {
            ensureReservedNameIsMutable();
            AbstractMessageLite.a(iterable, this.reservedName_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllReservedRange(Iterable<? extends EnumReservedRange> iterable) {
            ensureReservedRangeIsMutable();
            AbstractMessageLite.a(iterable, this.reservedRange_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllValue(Iterable<? extends EnumValueDescriptorProto> iterable) {
            ensureValueIsMutable();
            AbstractMessageLite.a(iterable, this.value_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addReservedName(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            ensureReservedNameIsMutable();
            this.reservedName_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addReservedNameBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            ensureReservedNameIsMutable();
            this.reservedName_.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addReservedRange(int i, EnumReservedRange.Builder builder) {
            ensureReservedRangeIsMutable();
            this.reservedRange_.add(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addReservedRange(int i, EnumReservedRange enumReservedRange) {
            if (enumReservedRange == null) {
                throw new NullPointerException();
            }
            ensureReservedRangeIsMutable();
            this.reservedRange_.add(i, enumReservedRange);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addReservedRange(EnumReservedRange.Builder builder) {
            ensureReservedRangeIsMutable();
            this.reservedRange_.add(builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addReservedRange(EnumReservedRange enumReservedRange) {
            if (enumReservedRange == null) {
                throw new NullPointerException();
            }
            ensureReservedRangeIsMutable();
            this.reservedRange_.add(enumReservedRange);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addValue(int i, EnumValueDescriptorProto.Builder builder) {
            ensureValueIsMutable();
            this.value_.add(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addValue(int i, EnumValueDescriptorProto enumValueDescriptorProto) {
            if (enumValueDescriptorProto == null) {
                throw new NullPointerException();
            }
            ensureValueIsMutable();
            this.value_.add(i, enumValueDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addValue(EnumValueDescriptorProto.Builder builder) {
            ensureValueIsMutable();
            this.value_.add(builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addValue(EnumValueDescriptorProto enumValueDescriptorProto) {
            if (enumValueDescriptorProto == null) {
                throw new NullPointerException();
            }
            ensureValueIsMutable();
            this.value_.add(enumValueDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearName() {
            this.bitField0_ &= -2;
            this.name_ = getDefaultInstance().getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOptions() {
            this.options_ = null;
            this.bitField0_ &= -3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearReservedName() {
            this.reservedName_ = GeneratedMessageLite.f();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearReservedRange() {
            this.reservedRange_ = GeneratedMessageLite.f();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearValue() {
            this.value_ = GeneratedMessageLite.f();
        }

        private void ensureReservedNameIsMutable() {
            if (this.reservedName_.isModifiable()) {
                return;
            }
            this.reservedName_ = GeneratedMessageLite.a(this.reservedName_);
        }

        private void ensureReservedRangeIsMutable() {
            if (this.reservedRange_.isModifiable()) {
                return;
            }
            this.reservedRange_ = GeneratedMessageLite.a(this.reservedRange_);
        }

        private void ensureValueIsMutable() {
            if (this.value_.isModifiable()) {
                return;
            }
            this.value_ = GeneratedMessageLite.a(this.value_);
        }

        public static EnumDescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public void mergeOptions(EnumOptions enumOptions) {
            EnumOptions enumOptions2 = this.options_;
            if (enumOptions2 != null && enumOptions2 != EnumOptions.getDefaultInstance()) {
                enumOptions = ((EnumOptions.Builder) EnumOptions.newBuilder(this.options_).mergeFrom((EnumOptions.Builder) enumOptions)).buildPartial();
            }
            this.options_ = enumOptions;
            this.bitField0_ |= 2;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(EnumDescriptorProto enumDescriptorProto) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) enumDescriptorProto);
        }

        public static EnumDescriptorProto parseDelimitedFrom(InputStream inputStream) {
            return (EnumDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static EnumDescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (EnumDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static EnumDescriptorProto parseFrom(ByteString byteString) {
            return (EnumDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static EnumDescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (EnumDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static EnumDescriptorProto parseFrom(CodedInputStream codedInputStream) {
            return (EnumDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static EnumDescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (EnumDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static EnumDescriptorProto parseFrom(InputStream inputStream) {
            return (EnumDescriptorProto) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static EnumDescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (EnumDescriptorProto) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static EnumDescriptorProto parseFrom(byte[] bArr) {
            return (EnumDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static EnumDescriptorProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (EnumDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<EnumDescriptorProto> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeReservedRange(int i) {
            ensureReservedRangeIsMutable();
            this.reservedRange_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeValue(int i) {
            ensureValueIsMutable();
            this.value_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setName(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 1;
            this.name_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNameBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 1;
            this.name_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public void setOptions(EnumOptions.Builder builder) {
            this.options_ = (EnumOptions) builder.build();
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOptions(EnumOptions enumOptions) {
            if (enumOptions == null) {
                throw new NullPointerException();
            }
            this.options_ = enumOptions;
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setReservedName(int i, String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            ensureReservedNameIsMutable();
            this.reservedName_.set(i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setReservedRange(int i, EnumReservedRange.Builder builder) {
            ensureReservedRangeIsMutable();
            this.reservedRange_.set(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setReservedRange(int i, EnumReservedRange enumReservedRange) {
            if (enumReservedRange == null) {
                throw new NullPointerException();
            }
            ensureReservedRangeIsMutable();
            this.reservedRange_.set(i, enumReservedRange);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setValue(int i, EnumValueDescriptorProto.Builder builder) {
            ensureValueIsMutable();
            this.value_.set(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setValue(int i, EnumValueDescriptorProto enumValueDescriptorProto) {
            if (enumValueDescriptorProto == null) {
                throw new NullPointerException();
            }
            ensureValueIsMutable();
            this.value_.set(i, enumValueDescriptorProto);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            List list;
            MessageLite messageLite;
            boolean z = false;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new EnumDescriptorProto();
                case 2:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i = 0; i < getValueCount(); i++) {
                        if (!getValue(i).isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = (byte) 0;
                            }
                            return null;
                        }
                    }
                    if (!hasOptions() || getOptions().isInitialized()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = (byte) 1;
                        }
                        return DEFAULT_INSTANCE;
                    }
                    if (booleanValue) {
                        this.memoizedIsInitialized = (byte) 0;
                    }
                    return null;
                case 3:
                    this.value_.makeImmutable();
                    this.reservedRange_.makeImmutable();
                    this.reservedName_.makeImmutable();
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    EnumDescriptorProto enumDescriptorProto = (EnumDescriptorProto) obj2;
                    this.name_ = visitor.visitString(hasName(), this.name_, enumDescriptorProto.hasName(), enumDescriptorProto.name_);
                    this.value_ = visitor.visitList(this.value_, enumDescriptorProto.value_);
                    this.options_ = (EnumOptions) visitor.visitMessage(this.options_, enumDescriptorProto.options_);
                    this.reservedRange_ = visitor.visitList(this.reservedRange_, enumDescriptorProto.reservedRange_);
                    this.reservedName_ = visitor.visitList(this.reservedName_, enumDescriptorProto.reservedName_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= enumDescriptorProto.bitField0_;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            try {
                                int readTag = codedInputStream.readTag();
                                if (readTag != 0) {
                                    if (readTag != 10) {
                                        if (readTag == 18) {
                                            if (!this.value_.isModifiable()) {
                                                this.value_ = GeneratedMessageLite.a(this.value_);
                                            }
                                            list = this.value_;
                                            messageLite = (EnumValueDescriptorProto) codedInputStream.readMessage(EnumValueDescriptorProto.parser(), extensionRegistryLite);
                                        } else if (readTag == 26) {
                                            EnumOptions.Builder builder = (this.bitField0_ & 2) == 2 ? (EnumOptions.Builder) this.options_.toBuilder() : null;
                                            this.options_ = (EnumOptions) codedInputStream.readMessage(EnumOptions.parser(), extensionRegistryLite);
                                            if (builder != null) {
                                                builder.mergeFrom((EnumOptions.Builder) this.options_);
                                                this.options_ = builder.buildPartial();
                                            }
                                            this.bitField0_ |= 2;
                                        } else if (readTag == 34) {
                                            if (!this.reservedRange_.isModifiable()) {
                                                this.reservedRange_ = GeneratedMessageLite.a(this.reservedRange_);
                                            }
                                            list = this.reservedRange_;
                                            messageLite = (EnumReservedRange) codedInputStream.readMessage(EnumReservedRange.parser(), extensionRegistryLite);
                                        } else if (readTag == 42) {
                                            String readString = codedInputStream.readString();
                                            if (!this.reservedName_.isModifiable()) {
                                                this.reservedName_ = GeneratedMessageLite.a(this.reservedName_);
                                            }
                                            this.reservedName_.add(readString);
                                        } else if (!a(readTag, codedInputStream)) {
                                        }
                                        list.add(messageLite);
                                    } else {
                                        String readString2 = codedInputStream.readString();
                                        this.bitField0_ |= 1;
                                        this.name_ = readString2;
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
                        synchronized (EnumDescriptorProto.class) {
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

        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public String getName() {
            return this.name_;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public EnumOptions getOptions() {
            EnumOptions enumOptions = this.options_;
            return enumOptions == null ? EnumOptions.getDefaultInstance() : enumOptions;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public String getReservedName(int i) {
            return this.reservedName_.get(i);
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public ByteString getReservedNameBytes(int i) {
            return ByteString.copyFromUtf8(this.reservedName_.get(i));
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public int getReservedNameCount() {
            return this.reservedName_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public List<String> getReservedNameList() {
            return this.reservedName_;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public EnumReservedRange getReservedRange(int i) {
            return this.reservedRange_.get(i);
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public int getReservedRangeCount() {
            return this.reservedRange_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public List<EnumReservedRange> getReservedRangeList() {
            return this.reservedRange_;
        }

        public EnumReservedRangeOrBuilder getReservedRangeOrBuilder(int i) {
            return this.reservedRange_.get(i);
        }

        public List<? extends EnumReservedRangeOrBuilder> getReservedRangeOrBuilderList() {
            return this.reservedRange_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeStringSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeStringSize(1, getName()) + 0 : 0;
            for (int i2 = 0; i2 < this.value_.size(); i2++) {
                computeStringSize += CodedOutputStream.computeMessageSize(2, this.value_.get(i2));
            }
            if ((this.bitField0_ & 2) == 2) {
                computeStringSize += CodedOutputStream.computeMessageSize(3, getOptions());
            }
            for (int i3 = 0; i3 < this.reservedRange_.size(); i3++) {
                computeStringSize += CodedOutputStream.computeMessageSize(4, this.reservedRange_.get(i3));
            }
            int i4 = 0;
            for (int i5 = 0; i5 < this.reservedName_.size(); i5++) {
                i4 += CodedOutputStream.computeStringSizeNoTag(this.reservedName_.get(i5));
            }
            int size = computeStringSize + i4 + (getReservedNameList().size() * 1) + this.b.getSerializedSize();
            this.c = size;
            return size;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public EnumValueDescriptorProto getValue(int i) {
            return this.value_.get(i);
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public int getValueCount() {
            return this.value_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public List<EnumValueDescriptorProto> getValueList() {
            return this.value_;
        }

        public EnumValueDescriptorProtoOrBuilder getValueOrBuilder(int i) {
            return this.value_.get(i);
        }

        public List<? extends EnumValueDescriptorProtoOrBuilder> getValueOrBuilderList() {
            return this.value_;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public boolean hasOptions() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeString(1, getName());
            }
            for (int i = 0; i < this.value_.size(); i++) {
                codedOutputStream.writeMessage(2, this.value_.get(i));
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(3, getOptions());
            }
            for (int i2 = 0; i2 < this.reservedRange_.size(); i2++) {
                codedOutputStream.writeMessage(4, this.reservedRange_.get(i2));
            }
            for (int i3 = 0; i3 < this.reservedName_.size(); i3++) {
                codedOutputStream.writeString(5, this.reservedName_.get(i3));
            }
            this.b.writeTo(codedOutputStream);
        }
    }

    /* loaded from: classes2.dex */
    public interface EnumDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
        String getName();

        ByteString getNameBytes();

        EnumOptions getOptions();

        String getReservedName(int i);

        ByteString getReservedNameBytes(int i);

        int getReservedNameCount();

        List<String> getReservedNameList();

        EnumDescriptorProto.EnumReservedRange getReservedRange(int i);

        int getReservedRangeCount();

        List<EnumDescriptorProto.EnumReservedRange> getReservedRangeList();

        EnumValueDescriptorProto getValue(int i);

        int getValueCount();

        List<EnumValueDescriptorProto> getValueList();

        boolean hasName();

        boolean hasOptions();
    }

    /* loaded from: classes2.dex */
    public static final class EnumOptions extends GeneratedMessageLite.ExtendableMessage<EnumOptions, Builder> implements EnumOptionsOrBuilder {
        public static final int ALLOW_ALIAS_FIELD_NUMBER = 2;
        private static final EnumOptions DEFAULT_INSTANCE = new EnumOptions();
        public static final int DEPRECATED_FIELD_NUMBER = 3;
        private static volatile Parser<EnumOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private boolean allowAlias_;
        private int bitField0_;
        private boolean deprecated_;
        private byte memoizedIsInitialized = -1;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = GeneratedMessageLite.f();

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<EnumOptions, Builder> implements EnumOptionsOrBuilder {
            private Builder() {
                super(EnumOptions.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
                a();
                ((EnumOptions) this.a).addAllUninterpretedOption(iterable);
                return this;
            }

            public Builder addUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                a();
                ((EnumOptions) this.a).addUninterpretedOption(i, builder);
                return this;
            }

            public Builder addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                a();
                ((EnumOptions) this.a).addUninterpretedOption(i, uninterpretedOption);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption.Builder builder) {
                a();
                ((EnumOptions) this.a).addUninterpretedOption(builder);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption uninterpretedOption) {
                a();
                ((EnumOptions) this.a).addUninterpretedOption(uninterpretedOption);
                return this;
            }

            public Builder clearAllowAlias() {
                a();
                ((EnumOptions) this.a).clearAllowAlias();
                return this;
            }

            public Builder clearDeprecated() {
                a();
                ((EnumOptions) this.a).clearDeprecated();
                return this;
            }

            public Builder clearUninterpretedOption() {
                a();
                ((EnumOptions) this.a).clearUninterpretedOption();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
            public boolean getAllowAlias() {
                return ((EnumOptions) this.a).getAllowAlias();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
            public boolean getDeprecated() {
                return ((EnumOptions) this.a).getDeprecated();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
            public UninterpretedOption getUninterpretedOption(int i) {
                return ((EnumOptions) this.a).getUninterpretedOption(i);
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
            public int getUninterpretedOptionCount() {
                return ((EnumOptions) this.a).getUninterpretedOptionCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(((EnumOptions) this.a).getUninterpretedOptionList());
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
            public boolean hasAllowAlias() {
                return ((EnumOptions) this.a).hasAllowAlias();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
            public boolean hasDeprecated() {
                return ((EnumOptions) this.a).hasDeprecated();
            }

            public Builder removeUninterpretedOption(int i) {
                a();
                ((EnumOptions) this.a).removeUninterpretedOption(i);
                return this;
            }

            public Builder setAllowAlias(boolean z) {
                a();
                ((EnumOptions) this.a).setAllowAlias(z);
                return this;
            }

            public Builder setDeprecated(boolean z) {
                a();
                ((EnumOptions) this.a).setDeprecated(z);
                return this;
            }

            public Builder setUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                a();
                ((EnumOptions) this.a).setUninterpretedOption(i, builder);
                return this;
            }

            public Builder setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                a();
                ((EnumOptions) this.a).setUninterpretedOption(i, uninterpretedOption);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private EnumOptions() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
            ensureUninterpretedOptionIsMutable();
            AbstractMessageLite.a(iterable, this.uninterpretedOption_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUninterpretedOption(int i, UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption == null) {
                throw new NullPointerException();
            }
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(i, uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption == null) {
                throw new NullPointerException();
            }
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAllowAlias() {
            this.bitField0_ &= -2;
            this.allowAlias_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDeprecated() {
            this.bitField0_ &= -3;
            this.deprecated_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUninterpretedOption() {
            this.uninterpretedOption_ = GeneratedMessageLite.f();
        }

        private void ensureUninterpretedOptionIsMutable() {
            if (this.uninterpretedOption_.isModifiable()) {
                return;
            }
            this.uninterpretedOption_ = GeneratedMessageLite.a(this.uninterpretedOption_);
        }

        public static EnumOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static Builder newBuilder(EnumOptions enumOptions) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom((Builder) enumOptions);
        }

        public static EnumOptions parseDelimitedFrom(InputStream inputStream) {
            return (EnumOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static EnumOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (EnumOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static EnumOptions parseFrom(ByteString byteString) {
            return (EnumOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static EnumOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (EnumOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static EnumOptions parseFrom(CodedInputStream codedInputStream) {
            return (EnumOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static EnumOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (EnumOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static EnumOptions parseFrom(InputStream inputStream) {
            return (EnumOptions) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static EnumOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (EnumOptions) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static EnumOptions parseFrom(byte[] bArr) {
            return (EnumOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static EnumOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (EnumOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<EnumOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeUninterpretedOption(int i) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAllowAlias(boolean z) {
            this.bitField0_ |= 1;
            this.allowAlias_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDeprecated(boolean z) {
            this.bitField0_ |= 2;
            this.deprecated_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUninterpretedOption(int i, UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption == null) {
                throw new NullPointerException();
            }
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(i, uninterpretedOption);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new EnumOptions();
                case 2:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i = 0; i < getUninterpretedOptionCount(); i++) {
                        if (!getUninterpretedOption(i).isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = (byte) 0;
                            }
                            return null;
                        }
                    }
                    if (g()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = (byte) 1;
                        }
                        return DEFAULT_INSTANCE;
                    }
                    if (booleanValue) {
                        this.memoizedIsInitialized = (byte) 0;
                    }
                    return null;
                case 3:
                    this.uninterpretedOption_.makeImmutable();
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    EnumOptions enumOptions = (EnumOptions) obj2;
                    this.allowAlias_ = visitor.visitBoolean(hasAllowAlias(), this.allowAlias_, enumOptions.hasAllowAlias(), enumOptions.allowAlias_);
                    this.deprecated_ = visitor.visitBoolean(hasDeprecated(), this.deprecated_, enumOptions.hasDeprecated(), enumOptions.deprecated_);
                    this.uninterpretedOption_ = visitor.visitList(this.uninterpretedOption_, enumOptions.uninterpretedOption_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= enumOptions.bitField0_;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 16) {
                                    this.bitField0_ |= 1;
                                    this.allowAlias_ = codedInputStream.readBool();
                                } else if (readTag == 24) {
                                    this.bitField0_ |= 2;
                                    this.deprecated_ = codedInputStream.readBool();
                                } else if (readTag == 7994) {
                                    if (!this.uninterpretedOption_.isModifiable()) {
                                        this.uninterpretedOption_ = GeneratedMessageLite.a(this.uninterpretedOption_);
                                    }
                                    this.uninterpretedOption_.add((UninterpretedOption) codedInputStream.readMessage(UninterpretedOption.parser(), extensionRegistryLite));
                                } else if (!a((EnumOptions) getDefaultInstanceForType(), codedInputStream, extensionRegistryLite, readTag)) {
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
                        synchronized (EnumOptions.class) {
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

        @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
        public boolean getAllowAlias() {
            return this.allowAlias_;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
        public boolean getDeprecated() {
            return this.deprecated_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeBoolSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeBoolSize(2, this.allowAlias_) + 0 : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeBoolSize += CodedOutputStream.computeBoolSize(3, this.deprecated_);
            }
            for (int i2 = 0; i2 < this.uninterpretedOption_.size(); i2++) {
                computeBoolSize += CodedOutputStream.computeMessageSize(999, this.uninterpretedOption_.get(i2));
            }
            int h = computeBoolSize + h() + this.b.getSerializedSize();
            this.c = h;
            return h;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
        public UninterpretedOption getUninterpretedOption(int i) {
            return this.uninterpretedOption_.get(i);
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i) {
            return this.uninterpretedOption_.get(i);
        }

        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
        public boolean hasAllowAlias() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
        public boolean hasDeprecated() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            GeneratedMessageLite.ExtendableMessage<MessageType, BuilderType>.ExtensionWriter i = i();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeBool(2, this.allowAlias_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBool(3, this.deprecated_);
            }
            for (int i2 = 0; i2 < this.uninterpretedOption_.size(); i2++) {
                codedOutputStream.writeMessage(999, this.uninterpretedOption_.get(i2));
            }
            i.writeUntil(536870912, codedOutputStream);
            this.b.writeTo(codedOutputStream);
        }
    }

    /* loaded from: classes2.dex */
    public interface EnumOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<EnumOptions, EnumOptions.Builder> {
        boolean getAllowAlias();

        boolean getDeprecated();

        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        boolean hasAllowAlias();

        boolean hasDeprecated();
    }

    /* loaded from: classes2.dex */
    public static final class EnumValueDescriptorProto extends GeneratedMessageLite<EnumValueDescriptorProto, Builder> implements EnumValueDescriptorProtoOrBuilder {
        private static final EnumValueDescriptorProto DEFAULT_INSTANCE = new EnumValueDescriptorProto();
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int NUMBER_FIELD_NUMBER = 2;
        public static final int OPTIONS_FIELD_NUMBER = 3;
        private static volatile Parser<EnumValueDescriptorProto> PARSER;
        private int bitField0_;
        private byte memoizedIsInitialized = -1;
        private String name_ = "";
        private int number_;
        private EnumValueOptions options_;

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<EnumValueDescriptorProto, Builder> implements EnumValueDescriptorProtoOrBuilder {
            private Builder() {
                super(EnumValueDescriptorProto.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearName() {
                a();
                ((EnumValueDescriptorProto) this.a).clearName();
                return this;
            }

            public Builder clearNumber() {
                a();
                ((EnumValueDescriptorProto) this.a).clearNumber();
                return this;
            }

            public Builder clearOptions() {
                a();
                ((EnumValueDescriptorProto) this.a).clearOptions();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
            public String getName() {
                return ((EnumValueDescriptorProto) this.a).getName();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
            public ByteString getNameBytes() {
                return ((EnumValueDescriptorProto) this.a).getNameBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
            public int getNumber() {
                return ((EnumValueDescriptorProto) this.a).getNumber();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
            public EnumValueOptions getOptions() {
                return ((EnumValueDescriptorProto) this.a).getOptions();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
            public boolean hasName() {
                return ((EnumValueDescriptorProto) this.a).hasName();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
            public boolean hasNumber() {
                return ((EnumValueDescriptorProto) this.a).hasNumber();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
            public boolean hasOptions() {
                return ((EnumValueDescriptorProto) this.a).hasOptions();
            }

            public Builder mergeOptions(EnumValueOptions enumValueOptions) {
                a();
                ((EnumValueDescriptorProto) this.a).mergeOptions(enumValueOptions);
                return this;
            }

            public Builder setName(String str) {
                a();
                ((EnumValueDescriptorProto) this.a).setName(str);
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                a();
                ((EnumValueDescriptorProto) this.a).setNameBytes(byteString);
                return this;
            }

            public Builder setNumber(int i) {
                a();
                ((EnumValueDescriptorProto) this.a).setNumber(i);
                return this;
            }

            public Builder setOptions(EnumValueOptions.Builder builder) {
                a();
                ((EnumValueDescriptorProto) this.a).setOptions(builder);
                return this;
            }

            public Builder setOptions(EnumValueOptions enumValueOptions) {
                a();
                ((EnumValueDescriptorProto) this.a).setOptions(enumValueOptions);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private EnumValueDescriptorProto() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearName() {
            this.bitField0_ &= -2;
            this.name_ = getDefaultInstance().getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNumber() {
            this.bitField0_ &= -3;
            this.number_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOptions() {
            this.options_ = null;
            this.bitField0_ &= -5;
        }

        public static EnumValueDescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public void mergeOptions(EnumValueOptions enumValueOptions) {
            EnumValueOptions enumValueOptions2 = this.options_;
            if (enumValueOptions2 != null && enumValueOptions2 != EnumValueOptions.getDefaultInstance()) {
                enumValueOptions = ((EnumValueOptions.Builder) EnumValueOptions.newBuilder(this.options_).mergeFrom((EnumValueOptions.Builder) enumValueOptions)).buildPartial();
            }
            this.options_ = enumValueOptions;
            this.bitField0_ |= 4;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(EnumValueDescriptorProto enumValueDescriptorProto) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) enumValueDescriptorProto);
        }

        public static EnumValueDescriptorProto parseDelimitedFrom(InputStream inputStream) {
            return (EnumValueDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static EnumValueDescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (EnumValueDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static EnumValueDescriptorProto parseFrom(ByteString byteString) {
            return (EnumValueDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static EnumValueDescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (EnumValueDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static EnumValueDescriptorProto parseFrom(CodedInputStream codedInputStream) {
            return (EnumValueDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static EnumValueDescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (EnumValueDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static EnumValueDescriptorProto parseFrom(InputStream inputStream) {
            return (EnumValueDescriptorProto) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static EnumValueDescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (EnumValueDescriptorProto) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static EnumValueDescriptorProto parseFrom(byte[] bArr) {
            return (EnumValueDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static EnumValueDescriptorProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (EnumValueDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<EnumValueDescriptorProto> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setName(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 1;
            this.name_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNameBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 1;
            this.name_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNumber(int i) {
            this.bitField0_ |= 2;
            this.number_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public void setOptions(EnumValueOptions.Builder builder) {
            this.options_ = (EnumValueOptions) builder.build();
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOptions(EnumValueOptions enumValueOptions) {
            if (enumValueOptions == null) {
                throw new NullPointerException();
            }
            this.options_ = enumValueOptions;
            this.bitField0_ |= 4;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new EnumValueDescriptorProto();
                case 2:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    if (!hasOptions() || getOptions().isInitialized()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = (byte) 1;
                        }
                        return DEFAULT_INSTANCE;
                    }
                    if (booleanValue) {
                        this.memoizedIsInitialized = (byte) 0;
                    }
                    return null;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    EnumValueDescriptorProto enumValueDescriptorProto = (EnumValueDescriptorProto) obj2;
                    this.name_ = visitor.visitString(hasName(), this.name_, enumValueDescriptorProto.hasName(), enumValueDescriptorProto.name_);
                    this.number_ = visitor.visitInt(hasNumber(), this.number_, enumValueDescriptorProto.hasNumber(), enumValueDescriptorProto.number_);
                    this.options_ = (EnumValueOptions) visitor.visitMessage(this.options_, enumValueDescriptorProto.options_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= enumValueDescriptorProto.bitField0_;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    String readString = codedInputStream.readString();
                                    this.bitField0_ |= 1;
                                    this.name_ = readString;
                                } else if (readTag == 16) {
                                    this.bitField0_ |= 2;
                                    this.number_ = codedInputStream.readInt32();
                                } else if (readTag == 26) {
                                    EnumValueOptions.Builder builder = (this.bitField0_ & 4) == 4 ? (EnumValueOptions.Builder) this.options_.toBuilder() : null;
                                    this.options_ = (EnumValueOptions) codedInputStream.readMessage(EnumValueOptions.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom((EnumValueOptions.Builder) this.options_);
                                        this.options_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 4;
                                } else if (!a(readTag, codedInputStream)) {
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
                        synchronized (EnumValueDescriptorProto.class) {
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

        @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
        public String getName() {
            return this.name_;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
        public ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
        public int getNumber() {
            return this.number_;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
        public EnumValueOptions getOptions() {
            EnumValueOptions enumValueOptions = this.options_;
            return enumValueOptions == null ? EnumValueOptions.getDefaultInstance() : enumValueOptions;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeStringSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeStringSize(1, getName()) : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeStringSize += CodedOutputStream.computeInt32Size(2, this.number_);
            }
            if ((this.bitField0_ & 4) == 4) {
                computeStringSize += CodedOutputStream.computeMessageSize(3, getOptions());
            }
            int serializedSize = computeStringSize + this.b.getSerializedSize();
            this.c = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
        public boolean hasNumber() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
        public boolean hasOptions() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeString(1, getName());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.number_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeMessage(3, getOptions());
            }
            this.b.writeTo(codedOutputStream);
        }
    }

    /* loaded from: classes2.dex */
    public interface EnumValueDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
        String getName();

        ByteString getNameBytes();

        int getNumber();

        EnumValueOptions getOptions();

        boolean hasName();

        boolean hasNumber();

        boolean hasOptions();
    }

    /* loaded from: classes2.dex */
    public static final class EnumValueOptions extends GeneratedMessageLite.ExtendableMessage<EnumValueOptions, Builder> implements EnumValueOptionsOrBuilder {
        private static final EnumValueOptions DEFAULT_INSTANCE = new EnumValueOptions();
        public static final int DEPRECATED_FIELD_NUMBER = 1;
        private static volatile Parser<EnumValueOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private int bitField0_;
        private boolean deprecated_;
        private byte memoizedIsInitialized = -1;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = GeneratedMessageLite.f();

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<EnumValueOptions, Builder> implements EnumValueOptionsOrBuilder {
            private Builder() {
                super(EnumValueOptions.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
                a();
                ((EnumValueOptions) this.a).addAllUninterpretedOption(iterable);
                return this;
            }

            public Builder addUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                a();
                ((EnumValueOptions) this.a).addUninterpretedOption(i, builder);
                return this;
            }

            public Builder addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                a();
                ((EnumValueOptions) this.a).addUninterpretedOption(i, uninterpretedOption);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption.Builder builder) {
                a();
                ((EnumValueOptions) this.a).addUninterpretedOption(builder);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption uninterpretedOption) {
                a();
                ((EnumValueOptions) this.a).addUninterpretedOption(uninterpretedOption);
                return this;
            }

            public Builder clearDeprecated() {
                a();
                ((EnumValueOptions) this.a).clearDeprecated();
                return this;
            }

            public Builder clearUninterpretedOption() {
                a();
                ((EnumValueOptions) this.a).clearUninterpretedOption();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumValueOptionsOrBuilder
            public boolean getDeprecated() {
                return ((EnumValueOptions) this.a).getDeprecated();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumValueOptionsOrBuilder
            public UninterpretedOption getUninterpretedOption(int i) {
                return ((EnumValueOptions) this.a).getUninterpretedOption(i);
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumValueOptionsOrBuilder
            public int getUninterpretedOptionCount() {
                return ((EnumValueOptions) this.a).getUninterpretedOptionCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumValueOptionsOrBuilder
            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(((EnumValueOptions) this.a).getUninterpretedOptionList());
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumValueOptionsOrBuilder
            public boolean hasDeprecated() {
                return ((EnumValueOptions) this.a).hasDeprecated();
            }

            public Builder removeUninterpretedOption(int i) {
                a();
                ((EnumValueOptions) this.a).removeUninterpretedOption(i);
                return this;
            }

            public Builder setDeprecated(boolean z) {
                a();
                ((EnumValueOptions) this.a).setDeprecated(z);
                return this;
            }

            public Builder setUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                a();
                ((EnumValueOptions) this.a).setUninterpretedOption(i, builder);
                return this;
            }

            public Builder setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                a();
                ((EnumValueOptions) this.a).setUninterpretedOption(i, uninterpretedOption);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private EnumValueOptions() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
            ensureUninterpretedOptionIsMutable();
            AbstractMessageLite.a(iterable, this.uninterpretedOption_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUninterpretedOption(int i, UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption == null) {
                throw new NullPointerException();
            }
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(i, uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption == null) {
                throw new NullPointerException();
            }
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDeprecated() {
            this.bitField0_ &= -2;
            this.deprecated_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUninterpretedOption() {
            this.uninterpretedOption_ = GeneratedMessageLite.f();
        }

        private void ensureUninterpretedOptionIsMutable() {
            if (this.uninterpretedOption_.isModifiable()) {
                return;
            }
            this.uninterpretedOption_ = GeneratedMessageLite.a(this.uninterpretedOption_);
        }

        public static EnumValueOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static Builder newBuilder(EnumValueOptions enumValueOptions) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom((Builder) enumValueOptions);
        }

        public static EnumValueOptions parseDelimitedFrom(InputStream inputStream) {
            return (EnumValueOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static EnumValueOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (EnumValueOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static EnumValueOptions parseFrom(ByteString byteString) {
            return (EnumValueOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static EnumValueOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (EnumValueOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static EnumValueOptions parseFrom(CodedInputStream codedInputStream) {
            return (EnumValueOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static EnumValueOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (EnumValueOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static EnumValueOptions parseFrom(InputStream inputStream) {
            return (EnumValueOptions) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static EnumValueOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (EnumValueOptions) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static EnumValueOptions parseFrom(byte[] bArr) {
            return (EnumValueOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static EnumValueOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (EnumValueOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<EnumValueOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeUninterpretedOption(int i) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDeprecated(boolean z) {
            this.bitField0_ |= 1;
            this.deprecated_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUninterpretedOption(int i, UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption == null) {
                throw new NullPointerException();
            }
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(i, uninterpretedOption);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new EnumValueOptions();
                case 2:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i = 0; i < getUninterpretedOptionCount(); i++) {
                        if (!getUninterpretedOption(i).isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = (byte) 0;
                            }
                            return null;
                        }
                    }
                    if (g()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = (byte) 1;
                        }
                        return DEFAULT_INSTANCE;
                    }
                    if (booleanValue) {
                        this.memoizedIsInitialized = (byte) 0;
                    }
                    return null;
                case 3:
                    this.uninterpretedOption_.makeImmutable();
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    EnumValueOptions enumValueOptions = (EnumValueOptions) obj2;
                    this.deprecated_ = visitor.visitBoolean(hasDeprecated(), this.deprecated_, enumValueOptions.hasDeprecated(), enumValueOptions.deprecated_);
                    this.uninterpretedOption_ = visitor.visitList(this.uninterpretedOption_, enumValueOptions.uninterpretedOption_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= enumValueOptions.bitField0_;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    this.bitField0_ |= 1;
                                    this.deprecated_ = codedInputStream.readBool();
                                } else if (readTag == 7994) {
                                    if (!this.uninterpretedOption_.isModifiable()) {
                                        this.uninterpretedOption_ = GeneratedMessageLite.a(this.uninterpretedOption_);
                                    }
                                    this.uninterpretedOption_.add((UninterpretedOption) codedInputStream.readMessage(UninterpretedOption.parser(), extensionRegistryLite));
                                } else if (!a((EnumValueOptions) getDefaultInstanceForType(), codedInputStream, extensionRegistryLite, readTag)) {
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
                        synchronized (EnumValueOptions.class) {
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

        @Override // com.google.protobuf.DescriptorProtos.EnumValueOptionsOrBuilder
        public boolean getDeprecated() {
            return this.deprecated_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeBoolSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeBoolSize(1, this.deprecated_) + 0 : 0;
            for (int i2 = 0; i2 < this.uninterpretedOption_.size(); i2++) {
                computeBoolSize += CodedOutputStream.computeMessageSize(999, this.uninterpretedOption_.get(i2));
            }
            int h = computeBoolSize + h() + this.b.getSerializedSize();
            this.c = h;
            return h;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumValueOptionsOrBuilder
        public UninterpretedOption getUninterpretedOption(int i) {
            return this.uninterpretedOption_.get(i);
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumValueOptionsOrBuilder
        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumValueOptionsOrBuilder
        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i) {
            return this.uninterpretedOption_.get(i);
        }

        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumValueOptionsOrBuilder
        public boolean hasDeprecated() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            GeneratedMessageLite.ExtendableMessage<MessageType, BuilderType>.ExtensionWriter i = i();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeBool(1, this.deprecated_);
            }
            for (int i2 = 0; i2 < this.uninterpretedOption_.size(); i2++) {
                codedOutputStream.writeMessage(999, this.uninterpretedOption_.get(i2));
            }
            i.writeUntil(536870912, codedOutputStream);
            this.b.writeTo(codedOutputStream);
        }
    }

    /* loaded from: classes2.dex */
    public interface EnumValueOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<EnumValueOptions, EnumValueOptions.Builder> {
        boolean getDeprecated();

        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        boolean hasDeprecated();
    }

    /* loaded from: classes2.dex */
    public static final class ExtensionRangeOptions extends GeneratedMessageLite.ExtendableMessage<ExtensionRangeOptions, Builder> implements ExtensionRangeOptionsOrBuilder {
        private static final ExtensionRangeOptions DEFAULT_INSTANCE = new ExtensionRangeOptions();
        private static volatile Parser<ExtensionRangeOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private byte memoizedIsInitialized = -1;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = GeneratedMessageLite.f();

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<ExtensionRangeOptions, Builder> implements ExtensionRangeOptionsOrBuilder {
            private Builder() {
                super(ExtensionRangeOptions.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
                a();
                ((ExtensionRangeOptions) this.a).addAllUninterpretedOption(iterable);
                return this;
            }

            public Builder addUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                a();
                ((ExtensionRangeOptions) this.a).addUninterpretedOption(i, builder);
                return this;
            }

            public Builder addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                a();
                ((ExtensionRangeOptions) this.a).addUninterpretedOption(i, uninterpretedOption);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption.Builder builder) {
                a();
                ((ExtensionRangeOptions) this.a).addUninterpretedOption(builder);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption uninterpretedOption) {
                a();
                ((ExtensionRangeOptions) this.a).addUninterpretedOption(uninterpretedOption);
                return this;
            }

            public Builder clearUninterpretedOption() {
                a();
                ((ExtensionRangeOptions) this.a).clearUninterpretedOption();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.ExtensionRangeOptionsOrBuilder
            public UninterpretedOption getUninterpretedOption(int i) {
                return ((ExtensionRangeOptions) this.a).getUninterpretedOption(i);
            }

            @Override // com.google.protobuf.DescriptorProtos.ExtensionRangeOptionsOrBuilder
            public int getUninterpretedOptionCount() {
                return ((ExtensionRangeOptions) this.a).getUninterpretedOptionCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.ExtensionRangeOptionsOrBuilder
            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(((ExtensionRangeOptions) this.a).getUninterpretedOptionList());
            }

            public Builder removeUninterpretedOption(int i) {
                a();
                ((ExtensionRangeOptions) this.a).removeUninterpretedOption(i);
                return this;
            }

            public Builder setUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                a();
                ((ExtensionRangeOptions) this.a).setUninterpretedOption(i, builder);
                return this;
            }

            public Builder setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                a();
                ((ExtensionRangeOptions) this.a).setUninterpretedOption(i, uninterpretedOption);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private ExtensionRangeOptions() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
            ensureUninterpretedOptionIsMutable();
            AbstractMessageLite.a(iterable, this.uninterpretedOption_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUninterpretedOption(int i, UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption == null) {
                throw new NullPointerException();
            }
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(i, uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption == null) {
                throw new NullPointerException();
            }
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUninterpretedOption() {
            this.uninterpretedOption_ = GeneratedMessageLite.f();
        }

        private void ensureUninterpretedOptionIsMutable() {
            if (this.uninterpretedOption_.isModifiable()) {
                return;
            }
            this.uninterpretedOption_ = GeneratedMessageLite.a(this.uninterpretedOption_);
        }

        public static ExtensionRangeOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static Builder newBuilder(ExtensionRangeOptions extensionRangeOptions) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom((Builder) extensionRangeOptions);
        }

        public static ExtensionRangeOptions parseDelimitedFrom(InputStream inputStream) {
            return (ExtensionRangeOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static ExtensionRangeOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ExtensionRangeOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ExtensionRangeOptions parseFrom(ByteString byteString) {
            return (ExtensionRangeOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static ExtensionRangeOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ExtensionRangeOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ExtensionRangeOptions parseFrom(CodedInputStream codedInputStream) {
            return (ExtensionRangeOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ExtensionRangeOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ExtensionRangeOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static ExtensionRangeOptions parseFrom(InputStream inputStream) {
            return (ExtensionRangeOptions) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static ExtensionRangeOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ExtensionRangeOptions) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ExtensionRangeOptions parseFrom(byte[] bArr) {
            return (ExtensionRangeOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static ExtensionRangeOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ExtensionRangeOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<ExtensionRangeOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeUninterpretedOption(int i) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUninterpretedOption(int i, UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption == null) {
                throw new NullPointerException();
            }
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(i, uninterpretedOption);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new ExtensionRangeOptions();
                case 2:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i = 0; i < getUninterpretedOptionCount(); i++) {
                        if (!getUninterpretedOption(i).isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = (byte) 0;
                            }
                            return null;
                        }
                    }
                    if (g()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = (byte) 1;
                        }
                        return DEFAULT_INSTANCE;
                    }
                    if (booleanValue) {
                        this.memoizedIsInitialized = (byte) 0;
                    }
                    return null;
                case 3:
                    this.uninterpretedOption_.makeImmutable();
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    this.uninterpretedOption_ = ((GeneratedMessageLite.Visitor) obj).visitList(this.uninterpretedOption_, ((ExtensionRangeOptions) obj2).uninterpretedOption_);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 7994) {
                                    if (!this.uninterpretedOption_.isModifiable()) {
                                        this.uninterpretedOption_ = GeneratedMessageLite.a(this.uninterpretedOption_);
                                    }
                                    this.uninterpretedOption_.add((UninterpretedOption) codedInputStream.readMessage(UninterpretedOption.parser(), extensionRegistryLite));
                                } else if (!a((ExtensionRangeOptions) getDefaultInstanceForType(), codedInputStream, extensionRegistryLite, readTag)) {
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
                        synchronized (ExtensionRangeOptions.class) {
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

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.uninterpretedOption_.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(999, this.uninterpretedOption_.get(i3));
            }
            int h = i2 + h() + this.b.getSerializedSize();
            this.c = h;
            return h;
        }

        @Override // com.google.protobuf.DescriptorProtos.ExtensionRangeOptionsOrBuilder
        public UninterpretedOption getUninterpretedOption(int i) {
            return this.uninterpretedOption_.get(i);
        }

        @Override // com.google.protobuf.DescriptorProtos.ExtensionRangeOptionsOrBuilder
        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.ExtensionRangeOptionsOrBuilder
        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i) {
            return this.uninterpretedOption_.get(i);
        }

        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            GeneratedMessageLite.ExtendableMessage<MessageType, BuilderType>.ExtensionWriter i = i();
            for (int i2 = 0; i2 < this.uninterpretedOption_.size(); i2++) {
                codedOutputStream.writeMessage(999, this.uninterpretedOption_.get(i2));
            }
            i.writeUntil(536870912, codedOutputStream);
            this.b.writeTo(codedOutputStream);
        }
    }

    /* loaded from: classes2.dex */
    public interface ExtensionRangeOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<ExtensionRangeOptions, ExtensionRangeOptions.Builder> {
        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();
    }

    /* loaded from: classes2.dex */
    public static final class FieldDescriptorProto extends GeneratedMessageLite<FieldDescriptorProto, Builder> implements FieldDescriptorProtoOrBuilder {
        private static final FieldDescriptorProto DEFAULT_INSTANCE = new FieldDescriptorProto();
        public static final int DEFAULT_VALUE_FIELD_NUMBER = 7;
        public static final int EXTENDEE_FIELD_NUMBER = 2;
        public static final int JSON_NAME_FIELD_NUMBER = 10;
        public static final int LABEL_FIELD_NUMBER = 4;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int NUMBER_FIELD_NUMBER = 3;
        public static final int ONEOF_INDEX_FIELD_NUMBER = 9;
        public static final int OPTIONS_FIELD_NUMBER = 8;
        private static volatile Parser<FieldDescriptorProto> PARSER = null;
        public static final int TYPE_FIELD_NUMBER = 5;
        public static final int TYPE_NAME_FIELD_NUMBER = 6;
        private int bitField0_;
        private int number_;
        private int oneofIndex_;
        private FieldOptions options_;
        private byte memoizedIsInitialized = -1;
        private String name_ = "";
        private int label_ = 1;
        private int type_ = 1;
        private String typeName_ = "";
        private String extendee_ = "";
        private String defaultValue_ = "";
        private String jsonName_ = "";

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<FieldDescriptorProto, Builder> implements FieldDescriptorProtoOrBuilder {
            private Builder() {
                super(FieldDescriptorProto.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearDefaultValue() {
                a();
                ((FieldDescriptorProto) this.a).clearDefaultValue();
                return this;
            }

            public Builder clearExtendee() {
                a();
                ((FieldDescriptorProto) this.a).clearExtendee();
                return this;
            }

            public Builder clearJsonName() {
                a();
                ((FieldDescriptorProto) this.a).clearJsonName();
                return this;
            }

            public Builder clearLabel() {
                a();
                ((FieldDescriptorProto) this.a).clearLabel();
                return this;
            }

            public Builder clearName() {
                a();
                ((FieldDescriptorProto) this.a).clearName();
                return this;
            }

            public Builder clearNumber() {
                a();
                ((FieldDescriptorProto) this.a).clearNumber();
                return this;
            }

            public Builder clearOneofIndex() {
                a();
                ((FieldDescriptorProto) this.a).clearOneofIndex();
                return this;
            }

            public Builder clearOptions() {
                a();
                ((FieldDescriptorProto) this.a).clearOptions();
                return this;
            }

            public Builder clearType() {
                a();
                ((FieldDescriptorProto) this.a).clearType();
                return this;
            }

            public Builder clearTypeName() {
                a();
                ((FieldDescriptorProto) this.a).clearTypeName();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public String getDefaultValue() {
                return ((FieldDescriptorProto) this.a).getDefaultValue();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public ByteString getDefaultValueBytes() {
                return ((FieldDescriptorProto) this.a).getDefaultValueBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public String getExtendee() {
                return ((FieldDescriptorProto) this.a).getExtendee();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public ByteString getExtendeeBytes() {
                return ((FieldDescriptorProto) this.a).getExtendeeBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public String getJsonName() {
                return ((FieldDescriptorProto) this.a).getJsonName();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public ByteString getJsonNameBytes() {
                return ((FieldDescriptorProto) this.a).getJsonNameBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public Label getLabel() {
                return ((FieldDescriptorProto) this.a).getLabel();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public String getName() {
                return ((FieldDescriptorProto) this.a).getName();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public ByteString getNameBytes() {
                return ((FieldDescriptorProto) this.a).getNameBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public int getNumber() {
                return ((FieldDescriptorProto) this.a).getNumber();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public int getOneofIndex() {
                return ((FieldDescriptorProto) this.a).getOneofIndex();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public FieldOptions getOptions() {
                return ((FieldDescriptorProto) this.a).getOptions();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public Type getType() {
                return ((FieldDescriptorProto) this.a).getType();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public String getTypeName() {
                return ((FieldDescriptorProto) this.a).getTypeName();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public ByteString getTypeNameBytes() {
                return ((FieldDescriptorProto) this.a).getTypeNameBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public boolean hasDefaultValue() {
                return ((FieldDescriptorProto) this.a).hasDefaultValue();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public boolean hasExtendee() {
                return ((FieldDescriptorProto) this.a).hasExtendee();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public boolean hasJsonName() {
                return ((FieldDescriptorProto) this.a).hasJsonName();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public boolean hasLabel() {
                return ((FieldDescriptorProto) this.a).hasLabel();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public boolean hasName() {
                return ((FieldDescriptorProto) this.a).hasName();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public boolean hasNumber() {
                return ((FieldDescriptorProto) this.a).hasNumber();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public boolean hasOneofIndex() {
                return ((FieldDescriptorProto) this.a).hasOneofIndex();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public boolean hasOptions() {
                return ((FieldDescriptorProto) this.a).hasOptions();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public boolean hasType() {
                return ((FieldDescriptorProto) this.a).hasType();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public boolean hasTypeName() {
                return ((FieldDescriptorProto) this.a).hasTypeName();
            }

            public Builder mergeOptions(FieldOptions fieldOptions) {
                a();
                ((FieldDescriptorProto) this.a).mergeOptions(fieldOptions);
                return this;
            }

            public Builder setDefaultValue(String str) {
                a();
                ((FieldDescriptorProto) this.a).setDefaultValue(str);
                return this;
            }

            public Builder setDefaultValueBytes(ByteString byteString) {
                a();
                ((FieldDescriptorProto) this.a).setDefaultValueBytes(byteString);
                return this;
            }

            public Builder setExtendee(String str) {
                a();
                ((FieldDescriptorProto) this.a).setExtendee(str);
                return this;
            }

            public Builder setExtendeeBytes(ByteString byteString) {
                a();
                ((FieldDescriptorProto) this.a).setExtendeeBytes(byteString);
                return this;
            }

            public Builder setJsonName(String str) {
                a();
                ((FieldDescriptorProto) this.a).setJsonName(str);
                return this;
            }

            public Builder setJsonNameBytes(ByteString byteString) {
                a();
                ((FieldDescriptorProto) this.a).setJsonNameBytes(byteString);
                return this;
            }

            public Builder setLabel(Label label) {
                a();
                ((FieldDescriptorProto) this.a).setLabel(label);
                return this;
            }

            public Builder setName(String str) {
                a();
                ((FieldDescriptorProto) this.a).setName(str);
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                a();
                ((FieldDescriptorProto) this.a).setNameBytes(byteString);
                return this;
            }

            public Builder setNumber(int i) {
                a();
                ((FieldDescriptorProto) this.a).setNumber(i);
                return this;
            }

            public Builder setOneofIndex(int i) {
                a();
                ((FieldDescriptorProto) this.a).setOneofIndex(i);
                return this;
            }

            public Builder setOptions(FieldOptions.Builder builder) {
                a();
                ((FieldDescriptorProto) this.a).setOptions(builder);
                return this;
            }

            public Builder setOptions(FieldOptions fieldOptions) {
                a();
                ((FieldDescriptorProto) this.a).setOptions(fieldOptions);
                return this;
            }

            public Builder setType(Type type) {
                a();
                ((FieldDescriptorProto) this.a).setType(type);
                return this;
            }

            public Builder setTypeName(String str) {
                a();
                ((FieldDescriptorProto) this.a).setTypeName(str);
                return this;
            }

            public Builder setTypeNameBytes(ByteString byteString) {
                a();
                ((FieldDescriptorProto) this.a).setTypeNameBytes(byteString);
                return this;
            }
        }

        /* loaded from: classes2.dex */
        public enum Label implements Internal.EnumLite {
            LABEL_OPTIONAL(1),
            LABEL_REQUIRED(2),
            LABEL_REPEATED(3);

            public static final int LABEL_OPTIONAL_VALUE = 1;
            public static final int LABEL_REPEATED_VALUE = 3;
            public static final int LABEL_REQUIRED_VALUE = 2;
            private static final Internal.EnumLiteMap<Label> internalValueMap = new Internal.EnumLiteMap<Label>() { // from class: com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Label.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public Label findValueByNumber(int i) {
                    return Label.forNumber(i);
                }
            };
            private final int value;

            Label(int i) {
                this.value = i;
            }

            public static Label forNumber(int i) {
                if (i == 1) {
                    return LABEL_OPTIONAL;
                }
                if (i == 2) {
                    return LABEL_REQUIRED;
                }
                if (i != 3) {
                    return null;
                }
                return LABEL_REPEATED;
            }

            public static Internal.EnumLiteMap<Label> internalGetValueMap() {
                return internalValueMap;
            }

            @Deprecated
            public static Label valueOf(int i) {
                return forNumber(i);
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }
        }

        /* loaded from: classes2.dex */
        public enum Type implements Internal.EnumLite {
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
            TYPE_SINT64(18);

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
            private static final Internal.EnumLiteMap<Type> internalValueMap = new Internal.EnumLiteMap<Type>() { // from class: com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public Type findValueByNumber(int i) {
                    return Type.forNumber(i);
                }
            };
            private final int value;

            Type(int i) {
                this.value = i;
            }

            public static Type forNumber(int i) {
                switch (i) {
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

            public static Internal.EnumLiteMap<Type> internalGetValueMap() {
                return internalValueMap;
            }

            @Deprecated
            public static Type valueOf(int i) {
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

        private FieldDescriptorProto() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDefaultValue() {
            this.bitField0_ &= -65;
            this.defaultValue_ = getDefaultInstance().getDefaultValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearExtendee() {
            this.bitField0_ &= -33;
            this.extendee_ = getDefaultInstance().getExtendee();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearJsonName() {
            this.bitField0_ &= -257;
            this.jsonName_ = getDefaultInstance().getJsonName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLabel() {
            this.bitField0_ &= -5;
            this.label_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearName() {
            this.bitField0_ &= -2;
            this.name_ = getDefaultInstance().getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNumber() {
            this.bitField0_ &= -3;
            this.number_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOneofIndex() {
            this.bitField0_ &= -129;
            this.oneofIndex_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOptions() {
            this.options_ = null;
            this.bitField0_ &= -513;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearType() {
            this.bitField0_ &= -9;
            this.type_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTypeName() {
            this.bitField0_ &= -17;
            this.typeName_ = getDefaultInstance().getTypeName();
        }

        public static FieldDescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public void mergeOptions(FieldOptions fieldOptions) {
            FieldOptions fieldOptions2 = this.options_;
            if (fieldOptions2 != null && fieldOptions2 != FieldOptions.getDefaultInstance()) {
                fieldOptions = ((FieldOptions.Builder) FieldOptions.newBuilder(this.options_).mergeFrom((FieldOptions.Builder) fieldOptions)).buildPartial();
            }
            this.options_ = fieldOptions;
            this.bitField0_ |= 512;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FieldDescriptorProto fieldDescriptorProto) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) fieldDescriptorProto);
        }

        public static FieldDescriptorProto parseDelimitedFrom(InputStream inputStream) {
            return (FieldDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static FieldDescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (FieldDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FieldDescriptorProto parseFrom(ByteString byteString) {
            return (FieldDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static FieldDescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (FieldDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static FieldDescriptorProto parseFrom(CodedInputStream codedInputStream) {
            return (FieldDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static FieldDescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (FieldDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static FieldDescriptorProto parseFrom(InputStream inputStream) {
            return (FieldDescriptorProto) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static FieldDescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (FieldDescriptorProto) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FieldDescriptorProto parseFrom(byte[] bArr) {
            return (FieldDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static FieldDescriptorProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (FieldDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<FieldDescriptorProto> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDefaultValue(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 64;
            this.defaultValue_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDefaultValueBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 64;
            this.defaultValue_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExtendee(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 32;
            this.extendee_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExtendeeBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 32;
            this.extendee_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setJsonName(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 256;
            this.jsonName_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setJsonNameBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 256;
            this.jsonName_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLabel(Label label) {
            if (label == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 4;
            this.label_ = label.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setName(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 1;
            this.name_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNameBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 1;
            this.name_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNumber(int i) {
            this.bitField0_ |= 2;
            this.number_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOneofIndex(int i) {
            this.bitField0_ |= 128;
            this.oneofIndex_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public void setOptions(FieldOptions.Builder builder) {
            this.options_ = (FieldOptions) builder.build();
            this.bitField0_ |= 512;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOptions(FieldOptions fieldOptions) {
            if (fieldOptions == null) {
                throw new NullPointerException();
            }
            this.options_ = fieldOptions;
            this.bitField0_ |= 512;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setType(Type type) {
            if (type == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 8;
            this.type_ = type.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTypeName(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 16;
            this.typeName_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTypeNameBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 16;
            this.typeName_ = byteString.toStringUtf8();
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:26:0x003a. Please report as an issue. */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new FieldDescriptorProto();
                case 2:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    if (!hasOptions() || getOptions().isInitialized()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = (byte) 1;
                        }
                        return DEFAULT_INSTANCE;
                    }
                    if (booleanValue) {
                        this.memoizedIsInitialized = (byte) 0;
                    }
                    return null;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    FieldDescriptorProto fieldDescriptorProto = (FieldDescriptorProto) obj2;
                    this.name_ = visitor.visitString(hasName(), this.name_, fieldDescriptorProto.hasName(), fieldDescriptorProto.name_);
                    this.number_ = visitor.visitInt(hasNumber(), this.number_, fieldDescriptorProto.hasNumber(), fieldDescriptorProto.number_);
                    this.label_ = visitor.visitInt(hasLabel(), this.label_, fieldDescriptorProto.hasLabel(), fieldDescriptorProto.label_);
                    this.type_ = visitor.visitInt(hasType(), this.type_, fieldDescriptorProto.hasType(), fieldDescriptorProto.type_);
                    this.typeName_ = visitor.visitString(hasTypeName(), this.typeName_, fieldDescriptorProto.hasTypeName(), fieldDescriptorProto.typeName_);
                    this.extendee_ = visitor.visitString(hasExtendee(), this.extendee_, fieldDescriptorProto.hasExtendee(), fieldDescriptorProto.extendee_);
                    this.defaultValue_ = visitor.visitString(hasDefaultValue(), this.defaultValue_, fieldDescriptorProto.hasDefaultValue(), fieldDescriptorProto.defaultValue_);
                    this.oneofIndex_ = visitor.visitInt(hasOneofIndex(), this.oneofIndex_, fieldDescriptorProto.hasOneofIndex(), fieldDescriptorProto.oneofIndex_);
                    this.jsonName_ = visitor.visitString(hasJsonName(), this.jsonName_, fieldDescriptorProto.hasJsonName(), fieldDescriptorProto.jsonName_);
                    this.options_ = (FieldOptions) visitor.visitMessage(this.options_, fieldDescriptorProto.options_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= fieldDescriptorProto.bitField0_;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            switch (readTag) {
                                case 0:
                                    z = true;
                                case 10:
                                    String readString = codedInputStream.readString();
                                    this.bitField0_ |= 1;
                                    this.name_ = readString;
                                case 18:
                                    String readString2 = codedInputStream.readString();
                                    this.bitField0_ |= 32;
                                    this.extendee_ = readString2;
                                case 24:
                                    this.bitField0_ |= 2;
                                    this.number_ = codedInputStream.readInt32();
                                case 32:
                                    int readEnum = codedInputStream.readEnum();
                                    if (Label.forNumber(readEnum) == null) {
                                        super.a(4, readEnum);
                                    } else {
                                        this.bitField0_ |= 4;
                                        this.label_ = readEnum;
                                    }
                                case 40:
                                    int readEnum2 = codedInputStream.readEnum();
                                    if (Type.forNumber(readEnum2) == null) {
                                        super.a(5, readEnum2);
                                    } else {
                                        this.bitField0_ |= 8;
                                        this.type_ = readEnum2;
                                    }
                                case 50:
                                    String readString3 = codedInputStream.readString();
                                    this.bitField0_ |= 16;
                                    this.typeName_ = readString3;
                                case 58:
                                    String readString4 = codedInputStream.readString();
                                    this.bitField0_ |= 64;
                                    this.defaultValue_ = readString4;
                                case 66:
                                    FieldOptions.Builder builder = (this.bitField0_ & 512) == 512 ? (FieldOptions.Builder) this.options_.toBuilder() : null;
                                    this.options_ = (FieldOptions) codedInputStream.readMessage(FieldOptions.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom((FieldOptions.Builder) this.options_);
                                        this.options_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 512;
                                case 72:
                                    this.bitField0_ |= 128;
                                    this.oneofIndex_ = codedInputStream.readInt32();
                                case 82:
                                    String readString5 = codedInputStream.readString();
                                    this.bitField0_ |= 256;
                                    this.jsonName_ = readString5;
                                default:
                                    if (!a(readTag, codedInputStream)) {
                                        z = true;
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
                        synchronized (FieldDescriptorProto.class) {
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

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public String getDefaultValue() {
            return this.defaultValue_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public ByteString getDefaultValueBytes() {
            return ByteString.copyFromUtf8(this.defaultValue_);
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public String getExtendee() {
            return this.extendee_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public ByteString getExtendeeBytes() {
            return ByteString.copyFromUtf8(this.extendee_);
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public String getJsonName() {
            return this.jsonName_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public ByteString getJsonNameBytes() {
            return ByteString.copyFromUtf8(this.jsonName_);
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public Label getLabel() {
            Label forNumber = Label.forNumber(this.label_);
            return forNumber == null ? Label.LABEL_OPTIONAL : forNumber;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public String getName() {
            return this.name_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public int getNumber() {
            return this.number_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public int getOneofIndex() {
            return this.oneofIndex_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public FieldOptions getOptions() {
            FieldOptions fieldOptions = this.options_;
            return fieldOptions == null ? FieldOptions.getDefaultInstance() : fieldOptions;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeStringSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeStringSize(1, getName()) : 0;
            if ((this.bitField0_ & 32) == 32) {
                computeStringSize += CodedOutputStream.computeStringSize(2, getExtendee());
            }
            if ((this.bitField0_ & 2) == 2) {
                computeStringSize += CodedOutputStream.computeInt32Size(3, this.number_);
            }
            if ((this.bitField0_ & 4) == 4) {
                computeStringSize += CodedOutputStream.computeEnumSize(4, this.label_);
            }
            if ((this.bitField0_ & 8) == 8) {
                computeStringSize += CodedOutputStream.computeEnumSize(5, this.type_);
            }
            if ((this.bitField0_ & 16) == 16) {
                computeStringSize += CodedOutputStream.computeStringSize(6, getTypeName());
            }
            if ((this.bitField0_ & 64) == 64) {
                computeStringSize += CodedOutputStream.computeStringSize(7, getDefaultValue());
            }
            if ((this.bitField0_ & 512) == 512) {
                computeStringSize += CodedOutputStream.computeMessageSize(8, getOptions());
            }
            if ((this.bitField0_ & 128) == 128) {
                computeStringSize += CodedOutputStream.computeInt32Size(9, this.oneofIndex_);
            }
            if ((this.bitField0_ & 256) == 256) {
                computeStringSize += CodedOutputStream.computeStringSize(10, getJsonName());
            }
            int serializedSize = computeStringSize + this.b.getSerializedSize();
            this.c = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public Type getType() {
            Type forNumber = Type.forNumber(this.type_);
            return forNumber == null ? Type.TYPE_DOUBLE : forNumber;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public String getTypeName() {
            return this.typeName_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public ByteString getTypeNameBytes() {
            return ByteString.copyFromUtf8(this.typeName_);
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public boolean hasDefaultValue() {
            return (this.bitField0_ & 64) == 64;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public boolean hasExtendee() {
            return (this.bitField0_ & 32) == 32;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public boolean hasJsonName() {
            return (this.bitField0_ & 256) == 256;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public boolean hasLabel() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public boolean hasNumber() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public boolean hasOneofIndex() {
            return (this.bitField0_ & 128) == 128;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public boolean hasOptions() {
            return (this.bitField0_ & 512) == 512;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public boolean hasType() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public boolean hasTypeName() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeString(1, getName());
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeString(2, getExtendee());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(3, this.number_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeEnum(4, this.label_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeEnum(5, this.type_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeString(6, getTypeName());
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeString(7, getDefaultValue());
            }
            if ((this.bitField0_ & 512) == 512) {
                codedOutputStream.writeMessage(8, getOptions());
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.writeInt32(9, this.oneofIndex_);
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.writeString(10, getJsonName());
            }
            this.b.writeTo(codedOutputStream);
        }
    }

    /* loaded from: classes2.dex */
    public interface FieldDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
        String getDefaultValue();

        ByteString getDefaultValueBytes();

        String getExtendee();

        ByteString getExtendeeBytes();

        String getJsonName();

        ByteString getJsonNameBytes();

        FieldDescriptorProto.Label getLabel();

        String getName();

        ByteString getNameBytes();

        int getNumber();

        int getOneofIndex();

        FieldOptions getOptions();

        FieldDescriptorProto.Type getType();

        String getTypeName();

        ByteString getTypeNameBytes();

        boolean hasDefaultValue();

        boolean hasExtendee();

        boolean hasJsonName();

        boolean hasLabel();

        boolean hasName();

        boolean hasNumber();

        boolean hasOneofIndex();

        boolean hasOptions();

        boolean hasType();

        boolean hasTypeName();
    }

    /* loaded from: classes2.dex */
    public static final class FieldOptions extends GeneratedMessageLite.ExtendableMessage<FieldOptions, Builder> implements FieldOptionsOrBuilder {
        public static final int CTYPE_FIELD_NUMBER = 1;
        private static final FieldOptions DEFAULT_INSTANCE = new FieldOptions();
        public static final int DEPRECATED_FIELD_NUMBER = 3;
        public static final int JSTYPE_FIELD_NUMBER = 6;
        public static final int LAZY_FIELD_NUMBER = 5;
        public static final int PACKED_FIELD_NUMBER = 2;
        private static volatile Parser<FieldOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        public static final int WEAK_FIELD_NUMBER = 10;
        private int bitField0_;
        private int ctype_;
        private boolean deprecated_;
        private int jstype_;
        private boolean lazy_;
        private boolean packed_;
        private boolean weak_;
        private byte memoizedIsInitialized = -1;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = GeneratedMessageLite.f();

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<FieldOptions, Builder> implements FieldOptionsOrBuilder {
            private Builder() {
                super(FieldOptions.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
                a();
                ((FieldOptions) this.a).addAllUninterpretedOption(iterable);
                return this;
            }

            public Builder addUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                a();
                ((FieldOptions) this.a).addUninterpretedOption(i, builder);
                return this;
            }

            public Builder addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                a();
                ((FieldOptions) this.a).addUninterpretedOption(i, uninterpretedOption);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption.Builder builder) {
                a();
                ((FieldOptions) this.a).addUninterpretedOption(builder);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption uninterpretedOption) {
                a();
                ((FieldOptions) this.a).addUninterpretedOption(uninterpretedOption);
                return this;
            }

            public Builder clearCtype() {
                a();
                ((FieldOptions) this.a).clearCtype();
                return this;
            }

            public Builder clearDeprecated() {
                a();
                ((FieldOptions) this.a).clearDeprecated();
                return this;
            }

            public Builder clearJstype() {
                a();
                ((FieldOptions) this.a).clearJstype();
                return this;
            }

            public Builder clearLazy() {
                a();
                ((FieldOptions) this.a).clearLazy();
                return this;
            }

            public Builder clearPacked() {
                a();
                ((FieldOptions) this.a).clearPacked();
                return this;
            }

            public Builder clearUninterpretedOption() {
                a();
                ((FieldOptions) this.a).clearUninterpretedOption();
                return this;
            }

            public Builder clearWeak() {
                a();
                ((FieldOptions) this.a).clearWeak();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public CType getCtype() {
                return ((FieldOptions) this.a).getCtype();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public boolean getDeprecated() {
                return ((FieldOptions) this.a).getDeprecated();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public JSType getJstype() {
                return ((FieldOptions) this.a).getJstype();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public boolean getLazy() {
                return ((FieldOptions) this.a).getLazy();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public boolean getPacked() {
                return ((FieldOptions) this.a).getPacked();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public UninterpretedOption getUninterpretedOption(int i) {
                return ((FieldOptions) this.a).getUninterpretedOption(i);
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public int getUninterpretedOptionCount() {
                return ((FieldOptions) this.a).getUninterpretedOptionCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(((FieldOptions) this.a).getUninterpretedOptionList());
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public boolean getWeak() {
                return ((FieldOptions) this.a).getWeak();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public boolean hasCtype() {
                return ((FieldOptions) this.a).hasCtype();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public boolean hasDeprecated() {
                return ((FieldOptions) this.a).hasDeprecated();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public boolean hasJstype() {
                return ((FieldOptions) this.a).hasJstype();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public boolean hasLazy() {
                return ((FieldOptions) this.a).hasLazy();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public boolean hasPacked() {
                return ((FieldOptions) this.a).hasPacked();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public boolean hasWeak() {
                return ((FieldOptions) this.a).hasWeak();
            }

            public Builder removeUninterpretedOption(int i) {
                a();
                ((FieldOptions) this.a).removeUninterpretedOption(i);
                return this;
            }

            public Builder setCtype(CType cType) {
                a();
                ((FieldOptions) this.a).setCtype(cType);
                return this;
            }

            public Builder setDeprecated(boolean z) {
                a();
                ((FieldOptions) this.a).setDeprecated(z);
                return this;
            }

            public Builder setJstype(JSType jSType) {
                a();
                ((FieldOptions) this.a).setJstype(jSType);
                return this;
            }

            public Builder setLazy(boolean z) {
                a();
                ((FieldOptions) this.a).setLazy(z);
                return this;
            }

            public Builder setPacked(boolean z) {
                a();
                ((FieldOptions) this.a).setPacked(z);
                return this;
            }

            public Builder setUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                a();
                ((FieldOptions) this.a).setUninterpretedOption(i, builder);
                return this;
            }

            public Builder setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                a();
                ((FieldOptions) this.a).setUninterpretedOption(i, uninterpretedOption);
                return this;
            }

            public Builder setWeak(boolean z) {
                a();
                ((FieldOptions) this.a).setWeak(z);
                return this;
            }
        }

        /* loaded from: classes2.dex */
        public enum CType implements Internal.EnumLite {
            STRING(0),
            CORD(1),
            STRING_PIECE(2);

            public static final int CORD_VALUE = 1;
            public static final int STRING_PIECE_VALUE = 2;
            public static final int STRING_VALUE = 0;
            private static final Internal.EnumLiteMap<CType> internalValueMap = new Internal.EnumLiteMap<CType>() { // from class: com.google.protobuf.DescriptorProtos.FieldOptions.CType.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public CType findValueByNumber(int i) {
                    return CType.forNumber(i);
                }
            };
            private final int value;

            CType(int i) {
                this.value = i;
            }

            public static CType forNumber(int i) {
                if (i == 0) {
                    return STRING;
                }
                if (i == 1) {
                    return CORD;
                }
                if (i != 2) {
                    return null;
                }
                return STRING_PIECE;
            }

            public static Internal.EnumLiteMap<CType> internalGetValueMap() {
                return internalValueMap;
            }

            @Deprecated
            public static CType valueOf(int i) {
                return forNumber(i);
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }
        }

        /* loaded from: classes2.dex */
        public enum JSType implements Internal.EnumLite {
            JS_NORMAL(0),
            JS_STRING(1),
            JS_NUMBER(2);

            public static final int JS_NORMAL_VALUE = 0;
            public static final int JS_NUMBER_VALUE = 2;
            public static final int JS_STRING_VALUE = 1;
            private static final Internal.EnumLiteMap<JSType> internalValueMap = new Internal.EnumLiteMap<JSType>() { // from class: com.google.protobuf.DescriptorProtos.FieldOptions.JSType.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public JSType findValueByNumber(int i) {
                    return JSType.forNumber(i);
                }
            };
            private final int value;

            JSType(int i) {
                this.value = i;
            }

            public static JSType forNumber(int i) {
                if (i == 0) {
                    return JS_NORMAL;
                }
                if (i == 1) {
                    return JS_STRING;
                }
                if (i != 2) {
                    return null;
                }
                return JS_NUMBER;
            }

            public static Internal.EnumLiteMap<JSType> internalGetValueMap() {
                return internalValueMap;
            }

            @Deprecated
            public static JSType valueOf(int i) {
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

        private FieldOptions() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
            ensureUninterpretedOptionIsMutable();
            AbstractMessageLite.a(iterable, this.uninterpretedOption_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUninterpretedOption(int i, UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption == null) {
                throw new NullPointerException();
            }
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(i, uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption == null) {
                throw new NullPointerException();
            }
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCtype() {
            this.bitField0_ &= -2;
            this.ctype_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDeprecated() {
            this.bitField0_ &= -17;
            this.deprecated_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearJstype() {
            this.bitField0_ &= -5;
            this.jstype_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLazy() {
            this.bitField0_ &= -9;
            this.lazy_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPacked() {
            this.bitField0_ &= -3;
            this.packed_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUninterpretedOption() {
            this.uninterpretedOption_ = GeneratedMessageLite.f();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearWeak() {
            this.bitField0_ &= -33;
            this.weak_ = false;
        }

        private void ensureUninterpretedOptionIsMutable() {
            if (this.uninterpretedOption_.isModifiable()) {
                return;
            }
            this.uninterpretedOption_ = GeneratedMessageLite.a(this.uninterpretedOption_);
        }

        public static FieldOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static Builder newBuilder(FieldOptions fieldOptions) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom((Builder) fieldOptions);
        }

        public static FieldOptions parseDelimitedFrom(InputStream inputStream) {
            return (FieldOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static FieldOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (FieldOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FieldOptions parseFrom(ByteString byteString) {
            return (FieldOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static FieldOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (FieldOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static FieldOptions parseFrom(CodedInputStream codedInputStream) {
            return (FieldOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static FieldOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (FieldOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static FieldOptions parseFrom(InputStream inputStream) {
            return (FieldOptions) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static FieldOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (FieldOptions) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FieldOptions parseFrom(byte[] bArr) {
            return (FieldOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static FieldOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (FieldOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<FieldOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeUninterpretedOption(int i) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCtype(CType cType) {
            if (cType == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 1;
            this.ctype_ = cType.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDeprecated(boolean z) {
            this.bitField0_ |= 16;
            this.deprecated_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setJstype(JSType jSType) {
            if (jSType == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 4;
            this.jstype_ = jSType.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLazy(boolean z) {
            this.bitField0_ |= 8;
            this.lazy_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPacked(boolean z) {
            this.bitField0_ |= 2;
            this.packed_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUninterpretedOption(int i, UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption == null) {
                throw new NullPointerException();
            }
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(i, uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setWeak(boolean z) {
            this.bitField0_ |= 32;
            this.weak_ = z;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new FieldOptions();
                case 2:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i = 0; i < getUninterpretedOptionCount(); i++) {
                        if (!getUninterpretedOption(i).isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = (byte) 0;
                            }
                            return null;
                        }
                    }
                    if (g()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = (byte) 1;
                        }
                        return DEFAULT_INSTANCE;
                    }
                    if (booleanValue) {
                        this.memoizedIsInitialized = (byte) 0;
                    }
                    return null;
                case 3:
                    this.uninterpretedOption_.makeImmutable();
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    FieldOptions fieldOptions = (FieldOptions) obj2;
                    this.ctype_ = visitor.visitInt(hasCtype(), this.ctype_, fieldOptions.hasCtype(), fieldOptions.ctype_);
                    this.packed_ = visitor.visitBoolean(hasPacked(), this.packed_, fieldOptions.hasPacked(), fieldOptions.packed_);
                    this.jstype_ = visitor.visitInt(hasJstype(), this.jstype_, fieldOptions.hasJstype(), fieldOptions.jstype_);
                    this.lazy_ = visitor.visitBoolean(hasLazy(), this.lazy_, fieldOptions.hasLazy(), fieldOptions.lazy_);
                    this.deprecated_ = visitor.visitBoolean(hasDeprecated(), this.deprecated_, fieldOptions.hasDeprecated(), fieldOptions.deprecated_);
                    this.weak_ = visitor.visitBoolean(hasWeak(), this.weak_, fieldOptions.hasWeak(), fieldOptions.weak_);
                    this.uninterpretedOption_ = visitor.visitList(this.uninterpretedOption_, fieldOptions.uninterpretedOption_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= fieldOptions.bitField0_;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    int readEnum = codedInputStream.readEnum();
                                    if (CType.forNumber(readEnum) == null) {
                                        super.a(1, readEnum);
                                    } else {
                                        this.bitField0_ |= 1;
                                        this.ctype_ = readEnum;
                                    }
                                } else if (readTag == 16) {
                                    this.bitField0_ |= 2;
                                    this.packed_ = codedInputStream.readBool();
                                } else if (readTag == 24) {
                                    this.bitField0_ |= 16;
                                    this.deprecated_ = codedInputStream.readBool();
                                } else if (readTag == 40) {
                                    this.bitField0_ |= 8;
                                    this.lazy_ = codedInputStream.readBool();
                                } else if (readTag == 48) {
                                    int readEnum2 = codedInputStream.readEnum();
                                    if (JSType.forNumber(readEnum2) == null) {
                                        super.a(6, readEnum2);
                                    } else {
                                        this.bitField0_ |= 4;
                                        this.jstype_ = readEnum2;
                                    }
                                } else if (readTag == 80) {
                                    this.bitField0_ |= 32;
                                    this.weak_ = codedInputStream.readBool();
                                } else if (readTag == 7994) {
                                    if (!this.uninterpretedOption_.isModifiable()) {
                                        this.uninterpretedOption_ = GeneratedMessageLite.a(this.uninterpretedOption_);
                                    }
                                    this.uninterpretedOption_.add((UninterpretedOption) codedInputStream.readMessage(UninterpretedOption.parser(), extensionRegistryLite));
                                } else if (!a((FieldOptions) getDefaultInstanceForType(), codedInputStream, extensionRegistryLite, readTag)) {
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
                        synchronized (FieldOptions.class) {
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

        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public CType getCtype() {
            CType forNumber = CType.forNumber(this.ctype_);
            return forNumber == null ? CType.STRING : forNumber;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public boolean getDeprecated() {
            return this.deprecated_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public JSType getJstype() {
            JSType forNumber = JSType.forNumber(this.jstype_);
            return forNumber == null ? JSType.JS_NORMAL : forNumber;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public boolean getLazy() {
            return this.lazy_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public boolean getPacked() {
            return this.packed_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeEnumSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeEnumSize(1, this.ctype_) + 0 : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeEnumSize += CodedOutputStream.computeBoolSize(2, this.packed_);
            }
            if ((this.bitField0_ & 16) == 16) {
                computeEnumSize += CodedOutputStream.computeBoolSize(3, this.deprecated_);
            }
            if ((this.bitField0_ & 8) == 8) {
                computeEnumSize += CodedOutputStream.computeBoolSize(5, this.lazy_);
            }
            if ((this.bitField0_ & 4) == 4) {
                computeEnumSize += CodedOutputStream.computeEnumSize(6, this.jstype_);
            }
            if ((this.bitField0_ & 32) == 32) {
                computeEnumSize += CodedOutputStream.computeBoolSize(10, this.weak_);
            }
            for (int i2 = 0; i2 < this.uninterpretedOption_.size(); i2++) {
                computeEnumSize += CodedOutputStream.computeMessageSize(999, this.uninterpretedOption_.get(i2));
            }
            int h = computeEnumSize + h() + this.b.getSerializedSize();
            this.c = h;
            return h;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public UninterpretedOption getUninterpretedOption(int i) {
            return this.uninterpretedOption_.get(i);
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i) {
            return this.uninterpretedOption_.get(i);
        }

        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public boolean getWeak() {
            return this.weak_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public boolean hasCtype() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public boolean hasDeprecated() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public boolean hasJstype() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public boolean hasLazy() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public boolean hasPacked() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public boolean hasWeak() {
            return (this.bitField0_ & 32) == 32;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            GeneratedMessageLite.ExtendableMessage<MessageType, BuilderType>.ExtensionWriter i = i();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeEnum(1, this.ctype_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBool(2, this.packed_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeBool(3, this.deprecated_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeBool(5, this.lazy_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeEnum(6, this.jstype_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeBool(10, this.weak_);
            }
            for (int i2 = 0; i2 < this.uninterpretedOption_.size(); i2++) {
                codedOutputStream.writeMessage(999, this.uninterpretedOption_.get(i2));
            }
            i.writeUntil(536870912, codedOutputStream);
            this.b.writeTo(codedOutputStream);
        }
    }

    /* loaded from: classes2.dex */
    public interface FieldOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<FieldOptions, FieldOptions.Builder> {
        FieldOptions.CType getCtype();

        boolean getDeprecated();

        FieldOptions.JSType getJstype();

        boolean getLazy();

        boolean getPacked();

        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        boolean getWeak();

        boolean hasCtype();

        boolean hasDeprecated();

        boolean hasJstype();

        boolean hasLazy();

        boolean hasPacked();

        boolean hasWeak();
    }

    /* loaded from: classes2.dex */
    public static final class FileDescriptorProto extends GeneratedMessageLite<FileDescriptorProto, Builder> implements FileDescriptorProtoOrBuilder {
        private static final FileDescriptorProto DEFAULT_INSTANCE = new FileDescriptorProto();
        public static final int DEPENDENCY_FIELD_NUMBER = 3;
        public static final int ENUM_TYPE_FIELD_NUMBER = 5;
        public static final int EXTENSION_FIELD_NUMBER = 7;
        public static final int MESSAGE_TYPE_FIELD_NUMBER = 4;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 8;
        public static final int PACKAGE_FIELD_NUMBER = 2;
        private static volatile Parser<FileDescriptorProto> PARSER = null;
        public static final int PUBLIC_DEPENDENCY_FIELD_NUMBER = 10;
        public static final int SERVICE_FIELD_NUMBER = 6;
        public static final int SOURCE_CODE_INFO_FIELD_NUMBER = 9;
        public static final int SYNTAX_FIELD_NUMBER = 12;
        public static final int WEAK_DEPENDENCY_FIELD_NUMBER = 11;
        private int bitField0_;
        private FileOptions options_;
        private SourceCodeInfo sourceCodeInfo_;
        private byte memoizedIsInitialized = -1;
        private String name_ = "";
        private String package_ = "";
        private Internal.ProtobufList<String> dependency_ = GeneratedMessageLite.f();
        private Internal.IntList publicDependency_ = GeneratedMessageLite.d();
        private Internal.IntList weakDependency_ = GeneratedMessageLite.d();
        private Internal.ProtobufList<DescriptorProto> messageType_ = GeneratedMessageLite.f();
        private Internal.ProtobufList<EnumDescriptorProto> enumType_ = GeneratedMessageLite.f();
        private Internal.ProtobufList<ServiceDescriptorProto> service_ = GeneratedMessageLite.f();
        private Internal.ProtobufList<FieldDescriptorProto> extension_ = GeneratedMessageLite.f();
        private String syntax_ = "";

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<FileDescriptorProto, Builder> implements FileDescriptorProtoOrBuilder {
            private Builder() {
                super(FileDescriptorProto.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllDependency(Iterable<String> iterable) {
                a();
                ((FileDescriptorProto) this.a).addAllDependency(iterable);
                return this;
            }

            public Builder addAllEnumType(Iterable<? extends EnumDescriptorProto> iterable) {
                a();
                ((FileDescriptorProto) this.a).addAllEnumType(iterable);
                return this;
            }

            public Builder addAllExtension(Iterable<? extends FieldDescriptorProto> iterable) {
                a();
                ((FileDescriptorProto) this.a).addAllExtension(iterable);
                return this;
            }

            public Builder addAllMessageType(Iterable<? extends DescriptorProto> iterable) {
                a();
                ((FileDescriptorProto) this.a).addAllMessageType(iterable);
                return this;
            }

            public Builder addAllPublicDependency(Iterable<? extends Integer> iterable) {
                a();
                ((FileDescriptorProto) this.a).addAllPublicDependency(iterable);
                return this;
            }

            public Builder addAllService(Iterable<? extends ServiceDescriptorProto> iterable) {
                a();
                ((FileDescriptorProto) this.a).addAllService(iterable);
                return this;
            }

            public Builder addAllWeakDependency(Iterable<? extends Integer> iterable) {
                a();
                ((FileDescriptorProto) this.a).addAllWeakDependency(iterable);
                return this;
            }

            public Builder addDependency(String str) {
                a();
                ((FileDescriptorProto) this.a).addDependency(str);
                return this;
            }

            public Builder addDependencyBytes(ByteString byteString) {
                a();
                ((FileDescriptorProto) this.a).addDependencyBytes(byteString);
                return this;
            }

            public Builder addEnumType(int i, EnumDescriptorProto.Builder builder) {
                a();
                ((FileDescriptorProto) this.a).addEnumType(i, builder);
                return this;
            }

            public Builder addEnumType(int i, EnumDescriptorProto enumDescriptorProto) {
                a();
                ((FileDescriptorProto) this.a).addEnumType(i, enumDescriptorProto);
                return this;
            }

            public Builder addEnumType(EnumDescriptorProto.Builder builder) {
                a();
                ((FileDescriptorProto) this.a).addEnumType(builder);
                return this;
            }

            public Builder addEnumType(EnumDescriptorProto enumDescriptorProto) {
                a();
                ((FileDescriptorProto) this.a).addEnumType(enumDescriptorProto);
                return this;
            }

            public Builder addExtension(int i, FieldDescriptorProto.Builder builder) {
                a();
                ((FileDescriptorProto) this.a).addExtension(i, builder);
                return this;
            }

            public Builder addExtension(int i, FieldDescriptorProto fieldDescriptorProto) {
                a();
                ((FileDescriptorProto) this.a).addExtension(i, fieldDescriptorProto);
                return this;
            }

            public Builder addExtension(FieldDescriptorProto.Builder builder) {
                a();
                ((FileDescriptorProto) this.a).addExtension(builder);
                return this;
            }

            public Builder addExtension(FieldDescriptorProto fieldDescriptorProto) {
                a();
                ((FileDescriptorProto) this.a).addExtension(fieldDescriptorProto);
                return this;
            }

            public Builder addMessageType(int i, DescriptorProto.Builder builder) {
                a();
                ((FileDescriptorProto) this.a).addMessageType(i, builder);
                return this;
            }

            public Builder addMessageType(int i, DescriptorProto descriptorProto) {
                a();
                ((FileDescriptorProto) this.a).addMessageType(i, descriptorProto);
                return this;
            }

            public Builder addMessageType(DescriptorProto.Builder builder) {
                a();
                ((FileDescriptorProto) this.a).addMessageType(builder);
                return this;
            }

            public Builder addMessageType(DescriptorProto descriptorProto) {
                a();
                ((FileDescriptorProto) this.a).addMessageType(descriptorProto);
                return this;
            }

            public Builder addPublicDependency(int i) {
                a();
                ((FileDescriptorProto) this.a).addPublicDependency(i);
                return this;
            }

            public Builder addService(int i, ServiceDescriptorProto.Builder builder) {
                a();
                ((FileDescriptorProto) this.a).addService(i, builder);
                return this;
            }

            public Builder addService(int i, ServiceDescriptorProto serviceDescriptorProto) {
                a();
                ((FileDescriptorProto) this.a).addService(i, serviceDescriptorProto);
                return this;
            }

            public Builder addService(ServiceDescriptorProto.Builder builder) {
                a();
                ((FileDescriptorProto) this.a).addService(builder);
                return this;
            }

            public Builder addService(ServiceDescriptorProto serviceDescriptorProto) {
                a();
                ((FileDescriptorProto) this.a).addService(serviceDescriptorProto);
                return this;
            }

            public Builder addWeakDependency(int i) {
                a();
                ((FileDescriptorProto) this.a).addWeakDependency(i);
                return this;
            }

            public Builder clearDependency() {
                a();
                ((FileDescriptorProto) this.a).clearDependency();
                return this;
            }

            public Builder clearEnumType() {
                a();
                ((FileDescriptorProto) this.a).clearEnumType();
                return this;
            }

            public Builder clearExtension() {
                a();
                ((FileDescriptorProto) this.a).clearExtension();
                return this;
            }

            public Builder clearMessageType() {
                a();
                ((FileDescriptorProto) this.a).clearMessageType();
                return this;
            }

            public Builder clearName() {
                a();
                ((FileDescriptorProto) this.a).clearName();
                return this;
            }

            public Builder clearOptions() {
                a();
                ((FileDescriptorProto) this.a).clearOptions();
                return this;
            }

            public Builder clearPackage() {
                a();
                ((FileDescriptorProto) this.a).clearPackage();
                return this;
            }

            public Builder clearPublicDependency() {
                a();
                ((FileDescriptorProto) this.a).clearPublicDependency();
                return this;
            }

            public Builder clearService() {
                a();
                ((FileDescriptorProto) this.a).clearService();
                return this;
            }

            public Builder clearSourceCodeInfo() {
                a();
                ((FileDescriptorProto) this.a).clearSourceCodeInfo();
                return this;
            }

            public Builder clearSyntax() {
                a();
                ((FileDescriptorProto) this.a).clearSyntax();
                return this;
            }

            public Builder clearWeakDependency() {
                a();
                ((FileDescriptorProto) this.a).clearWeakDependency();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public String getDependency(int i) {
                return ((FileDescriptorProto) this.a).getDependency(i);
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public ByteString getDependencyBytes(int i) {
                return ((FileDescriptorProto) this.a).getDependencyBytes(i);
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public int getDependencyCount() {
                return ((FileDescriptorProto) this.a).getDependencyCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public List<String> getDependencyList() {
                return Collections.unmodifiableList(((FileDescriptorProto) this.a).getDependencyList());
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public EnumDescriptorProto getEnumType(int i) {
                return ((FileDescriptorProto) this.a).getEnumType(i);
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public int getEnumTypeCount() {
                return ((FileDescriptorProto) this.a).getEnumTypeCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public List<EnumDescriptorProto> getEnumTypeList() {
                return Collections.unmodifiableList(((FileDescriptorProto) this.a).getEnumTypeList());
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public FieldDescriptorProto getExtension(int i) {
                return ((FileDescriptorProto) this.a).getExtension(i);
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public int getExtensionCount() {
                return ((FileDescriptorProto) this.a).getExtensionCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public List<FieldDescriptorProto> getExtensionList() {
                return Collections.unmodifiableList(((FileDescriptorProto) this.a).getExtensionList());
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public DescriptorProto getMessageType(int i) {
                return ((FileDescriptorProto) this.a).getMessageType(i);
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public int getMessageTypeCount() {
                return ((FileDescriptorProto) this.a).getMessageTypeCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public List<DescriptorProto> getMessageTypeList() {
                return Collections.unmodifiableList(((FileDescriptorProto) this.a).getMessageTypeList());
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public String getName() {
                return ((FileDescriptorProto) this.a).getName();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public ByteString getNameBytes() {
                return ((FileDescriptorProto) this.a).getNameBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public FileOptions getOptions() {
                return ((FileDescriptorProto) this.a).getOptions();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public String getPackage() {
                return ((FileDescriptorProto) this.a).getPackage();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public ByteString getPackageBytes() {
                return ((FileDescriptorProto) this.a).getPackageBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public int getPublicDependency(int i) {
                return ((FileDescriptorProto) this.a).getPublicDependency(i);
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public int getPublicDependencyCount() {
                return ((FileDescriptorProto) this.a).getPublicDependencyCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public List<Integer> getPublicDependencyList() {
                return Collections.unmodifiableList(((FileDescriptorProto) this.a).getPublicDependencyList());
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public ServiceDescriptorProto getService(int i) {
                return ((FileDescriptorProto) this.a).getService(i);
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public int getServiceCount() {
                return ((FileDescriptorProto) this.a).getServiceCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public List<ServiceDescriptorProto> getServiceList() {
                return Collections.unmodifiableList(((FileDescriptorProto) this.a).getServiceList());
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public SourceCodeInfo getSourceCodeInfo() {
                return ((FileDescriptorProto) this.a).getSourceCodeInfo();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public String getSyntax() {
                return ((FileDescriptorProto) this.a).getSyntax();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public ByteString getSyntaxBytes() {
                return ((FileDescriptorProto) this.a).getSyntaxBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public int getWeakDependency(int i) {
                return ((FileDescriptorProto) this.a).getWeakDependency(i);
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public int getWeakDependencyCount() {
                return ((FileDescriptorProto) this.a).getWeakDependencyCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public List<Integer> getWeakDependencyList() {
                return Collections.unmodifiableList(((FileDescriptorProto) this.a).getWeakDependencyList());
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public boolean hasName() {
                return ((FileDescriptorProto) this.a).hasName();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public boolean hasOptions() {
                return ((FileDescriptorProto) this.a).hasOptions();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public boolean hasPackage() {
                return ((FileDescriptorProto) this.a).hasPackage();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public boolean hasSourceCodeInfo() {
                return ((FileDescriptorProto) this.a).hasSourceCodeInfo();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public boolean hasSyntax() {
                return ((FileDescriptorProto) this.a).hasSyntax();
            }

            public Builder mergeOptions(FileOptions fileOptions) {
                a();
                ((FileDescriptorProto) this.a).mergeOptions(fileOptions);
                return this;
            }

            public Builder mergeSourceCodeInfo(SourceCodeInfo sourceCodeInfo) {
                a();
                ((FileDescriptorProto) this.a).mergeSourceCodeInfo(sourceCodeInfo);
                return this;
            }

            public Builder removeEnumType(int i) {
                a();
                ((FileDescriptorProto) this.a).removeEnumType(i);
                return this;
            }

            public Builder removeExtension(int i) {
                a();
                ((FileDescriptorProto) this.a).removeExtension(i);
                return this;
            }

            public Builder removeMessageType(int i) {
                a();
                ((FileDescriptorProto) this.a).removeMessageType(i);
                return this;
            }

            public Builder removeService(int i) {
                a();
                ((FileDescriptorProto) this.a).removeService(i);
                return this;
            }

            public Builder setDependency(int i, String str) {
                a();
                ((FileDescriptorProto) this.a).setDependency(i, str);
                return this;
            }

            public Builder setEnumType(int i, EnumDescriptorProto.Builder builder) {
                a();
                ((FileDescriptorProto) this.a).setEnumType(i, builder);
                return this;
            }

            public Builder setEnumType(int i, EnumDescriptorProto enumDescriptorProto) {
                a();
                ((FileDescriptorProto) this.a).setEnumType(i, enumDescriptorProto);
                return this;
            }

            public Builder setExtension(int i, FieldDescriptorProto.Builder builder) {
                a();
                ((FileDescriptorProto) this.a).setExtension(i, builder);
                return this;
            }

            public Builder setExtension(int i, FieldDescriptorProto fieldDescriptorProto) {
                a();
                ((FileDescriptorProto) this.a).setExtension(i, fieldDescriptorProto);
                return this;
            }

            public Builder setMessageType(int i, DescriptorProto.Builder builder) {
                a();
                ((FileDescriptorProto) this.a).setMessageType(i, builder);
                return this;
            }

            public Builder setMessageType(int i, DescriptorProto descriptorProto) {
                a();
                ((FileDescriptorProto) this.a).setMessageType(i, descriptorProto);
                return this;
            }

            public Builder setName(String str) {
                a();
                ((FileDescriptorProto) this.a).setName(str);
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                a();
                ((FileDescriptorProto) this.a).setNameBytes(byteString);
                return this;
            }

            public Builder setOptions(FileOptions.Builder builder) {
                a();
                ((FileDescriptorProto) this.a).setOptions(builder);
                return this;
            }

            public Builder setOptions(FileOptions fileOptions) {
                a();
                ((FileDescriptorProto) this.a).setOptions(fileOptions);
                return this;
            }

            public Builder setPackage(String str) {
                a();
                ((FileDescriptorProto) this.a).setPackage(str);
                return this;
            }

            public Builder setPackageBytes(ByteString byteString) {
                a();
                ((FileDescriptorProto) this.a).setPackageBytes(byteString);
                return this;
            }

            public Builder setPublicDependency(int i, int i2) {
                a();
                ((FileDescriptorProto) this.a).setPublicDependency(i, i2);
                return this;
            }

            public Builder setService(int i, ServiceDescriptorProto.Builder builder) {
                a();
                ((FileDescriptorProto) this.a).setService(i, builder);
                return this;
            }

            public Builder setService(int i, ServiceDescriptorProto serviceDescriptorProto) {
                a();
                ((FileDescriptorProto) this.a).setService(i, serviceDescriptorProto);
                return this;
            }

            public Builder setSourceCodeInfo(SourceCodeInfo.Builder builder) {
                a();
                ((FileDescriptorProto) this.a).setSourceCodeInfo(builder);
                return this;
            }

            public Builder setSourceCodeInfo(SourceCodeInfo sourceCodeInfo) {
                a();
                ((FileDescriptorProto) this.a).setSourceCodeInfo(sourceCodeInfo);
                return this;
            }

            public Builder setSyntax(String str) {
                a();
                ((FileDescriptorProto) this.a).setSyntax(str);
                return this;
            }

            public Builder setSyntaxBytes(ByteString byteString) {
                a();
                ((FileDescriptorProto) this.a).setSyntaxBytes(byteString);
                return this;
            }

            public Builder setWeakDependency(int i, int i2) {
                a();
                ((FileDescriptorProto) this.a).setWeakDependency(i, i2);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private FileDescriptorProto() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllDependency(Iterable<String> iterable) {
            ensureDependencyIsMutable();
            AbstractMessageLite.a(iterable, this.dependency_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllEnumType(Iterable<? extends EnumDescriptorProto> iterable) {
            ensureEnumTypeIsMutable();
            AbstractMessageLite.a(iterable, this.enumType_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllExtension(Iterable<? extends FieldDescriptorProto> iterable) {
            ensureExtensionIsMutable();
            AbstractMessageLite.a(iterable, this.extension_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllMessageType(Iterable<? extends DescriptorProto> iterable) {
            ensureMessageTypeIsMutable();
            AbstractMessageLite.a(iterable, this.messageType_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllPublicDependency(Iterable<? extends Integer> iterable) {
            ensurePublicDependencyIsMutable();
            AbstractMessageLite.a(iterable, this.publicDependency_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllService(Iterable<? extends ServiceDescriptorProto> iterable) {
            ensureServiceIsMutable();
            AbstractMessageLite.a(iterable, this.service_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllWeakDependency(Iterable<? extends Integer> iterable) {
            ensureWeakDependencyIsMutable();
            AbstractMessageLite.a(iterable, this.weakDependency_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDependency(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            ensureDependencyIsMutable();
            this.dependency_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDependencyBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            ensureDependencyIsMutable();
            this.dependency_.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addEnumType(int i, EnumDescriptorProto.Builder builder) {
            ensureEnumTypeIsMutable();
            this.enumType_.add(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addEnumType(int i, EnumDescriptorProto enumDescriptorProto) {
            if (enumDescriptorProto == null) {
                throw new NullPointerException();
            }
            ensureEnumTypeIsMutable();
            this.enumType_.add(i, enumDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addEnumType(EnumDescriptorProto.Builder builder) {
            ensureEnumTypeIsMutable();
            this.enumType_.add(builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addEnumType(EnumDescriptorProto enumDescriptorProto) {
            if (enumDescriptorProto == null) {
                throw new NullPointerException();
            }
            ensureEnumTypeIsMutable();
            this.enumType_.add(enumDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addExtension(int i, FieldDescriptorProto.Builder builder) {
            ensureExtensionIsMutable();
            this.extension_.add(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addExtension(int i, FieldDescriptorProto fieldDescriptorProto) {
            if (fieldDescriptorProto == null) {
                throw new NullPointerException();
            }
            ensureExtensionIsMutable();
            this.extension_.add(i, fieldDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addExtension(FieldDescriptorProto.Builder builder) {
            ensureExtensionIsMutable();
            this.extension_.add(builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addExtension(FieldDescriptorProto fieldDescriptorProto) {
            if (fieldDescriptorProto == null) {
                throw new NullPointerException();
            }
            ensureExtensionIsMutable();
            this.extension_.add(fieldDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addMessageType(int i, DescriptorProto.Builder builder) {
            ensureMessageTypeIsMutable();
            this.messageType_.add(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addMessageType(int i, DescriptorProto descriptorProto) {
            if (descriptorProto == null) {
                throw new NullPointerException();
            }
            ensureMessageTypeIsMutable();
            this.messageType_.add(i, descriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addMessageType(DescriptorProto.Builder builder) {
            ensureMessageTypeIsMutable();
            this.messageType_.add(builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addMessageType(DescriptorProto descriptorProto) {
            if (descriptorProto == null) {
                throw new NullPointerException();
            }
            ensureMessageTypeIsMutable();
            this.messageType_.add(descriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addPublicDependency(int i) {
            ensurePublicDependencyIsMutable();
            this.publicDependency_.addInt(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addService(int i, ServiceDescriptorProto.Builder builder) {
            ensureServiceIsMutable();
            this.service_.add(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addService(int i, ServiceDescriptorProto serviceDescriptorProto) {
            if (serviceDescriptorProto == null) {
                throw new NullPointerException();
            }
            ensureServiceIsMutable();
            this.service_.add(i, serviceDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addService(ServiceDescriptorProto.Builder builder) {
            ensureServiceIsMutable();
            this.service_.add(builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addService(ServiceDescriptorProto serviceDescriptorProto) {
            if (serviceDescriptorProto == null) {
                throw new NullPointerException();
            }
            ensureServiceIsMutable();
            this.service_.add(serviceDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addWeakDependency(int i) {
            ensureWeakDependencyIsMutable();
            this.weakDependency_.addInt(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDependency() {
            this.dependency_ = GeneratedMessageLite.f();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEnumType() {
            this.enumType_ = GeneratedMessageLite.f();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearExtension() {
            this.extension_ = GeneratedMessageLite.f();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMessageType() {
            this.messageType_ = GeneratedMessageLite.f();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearName() {
            this.bitField0_ &= -2;
            this.name_ = getDefaultInstance().getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOptions() {
            this.options_ = null;
            this.bitField0_ &= -5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPackage() {
            this.bitField0_ &= -3;
            this.package_ = getDefaultInstance().getPackage();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPublicDependency() {
            this.publicDependency_ = GeneratedMessageLite.d();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearService() {
            this.service_ = GeneratedMessageLite.f();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSourceCodeInfo() {
            this.sourceCodeInfo_ = null;
            this.bitField0_ &= -9;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSyntax() {
            this.bitField0_ &= -17;
            this.syntax_ = getDefaultInstance().getSyntax();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearWeakDependency() {
            this.weakDependency_ = GeneratedMessageLite.d();
        }

        private void ensureDependencyIsMutable() {
            if (this.dependency_.isModifiable()) {
                return;
            }
            this.dependency_ = GeneratedMessageLite.a(this.dependency_);
        }

        private void ensureEnumTypeIsMutable() {
            if (this.enumType_.isModifiable()) {
                return;
            }
            this.enumType_ = GeneratedMessageLite.a(this.enumType_);
        }

        private void ensureExtensionIsMutable() {
            if (this.extension_.isModifiable()) {
                return;
            }
            this.extension_ = GeneratedMessageLite.a(this.extension_);
        }

        private void ensureMessageTypeIsMutable() {
            if (this.messageType_.isModifiable()) {
                return;
            }
            this.messageType_ = GeneratedMessageLite.a(this.messageType_);
        }

        private void ensurePublicDependencyIsMutable() {
            if (this.publicDependency_.isModifiable()) {
                return;
            }
            this.publicDependency_ = GeneratedMessageLite.a(this.publicDependency_);
        }

        private void ensureServiceIsMutable() {
            if (this.service_.isModifiable()) {
                return;
            }
            this.service_ = GeneratedMessageLite.a(this.service_);
        }

        private void ensureWeakDependencyIsMutable() {
            if (this.weakDependency_.isModifiable()) {
                return;
            }
            this.weakDependency_ = GeneratedMessageLite.a(this.weakDependency_);
        }

        public static FileDescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public void mergeOptions(FileOptions fileOptions) {
            FileOptions fileOptions2 = this.options_;
            if (fileOptions2 != null && fileOptions2 != FileOptions.getDefaultInstance()) {
                fileOptions = ((FileOptions.Builder) FileOptions.newBuilder(this.options_).mergeFrom((FileOptions.Builder) fileOptions)).buildPartial();
            }
            this.options_ = fileOptions;
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeSourceCodeInfo(SourceCodeInfo sourceCodeInfo) {
            SourceCodeInfo sourceCodeInfo2 = this.sourceCodeInfo_;
            if (sourceCodeInfo2 != null && sourceCodeInfo2 != SourceCodeInfo.getDefaultInstance()) {
                sourceCodeInfo = SourceCodeInfo.newBuilder(this.sourceCodeInfo_).mergeFrom((SourceCodeInfo.Builder) sourceCodeInfo).buildPartial();
            }
            this.sourceCodeInfo_ = sourceCodeInfo;
            this.bitField0_ |= 8;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FileDescriptorProto fileDescriptorProto) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) fileDescriptorProto);
        }

        public static FileDescriptorProto parseDelimitedFrom(InputStream inputStream) {
            return (FileDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static FileDescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (FileDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FileDescriptorProto parseFrom(ByteString byteString) {
            return (FileDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static FileDescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (FileDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static FileDescriptorProto parseFrom(CodedInputStream codedInputStream) {
            return (FileDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static FileDescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (FileDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static FileDescriptorProto parseFrom(InputStream inputStream) {
            return (FileDescriptorProto) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static FileDescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (FileDescriptorProto) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FileDescriptorProto parseFrom(byte[] bArr) {
            return (FileDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static FileDescriptorProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (FileDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<FileDescriptorProto> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeEnumType(int i) {
            ensureEnumTypeIsMutable();
            this.enumType_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeExtension(int i) {
            ensureExtensionIsMutable();
            this.extension_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeMessageType(int i) {
            ensureMessageTypeIsMutable();
            this.messageType_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeService(int i) {
            ensureServiceIsMutable();
            this.service_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDependency(int i, String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            ensureDependencyIsMutable();
            this.dependency_.set(i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEnumType(int i, EnumDescriptorProto.Builder builder) {
            ensureEnumTypeIsMutable();
            this.enumType_.set(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEnumType(int i, EnumDescriptorProto enumDescriptorProto) {
            if (enumDescriptorProto == null) {
                throw new NullPointerException();
            }
            ensureEnumTypeIsMutable();
            this.enumType_.set(i, enumDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExtension(int i, FieldDescriptorProto.Builder builder) {
            ensureExtensionIsMutable();
            this.extension_.set(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExtension(int i, FieldDescriptorProto fieldDescriptorProto) {
            if (fieldDescriptorProto == null) {
                throw new NullPointerException();
            }
            ensureExtensionIsMutable();
            this.extension_.set(i, fieldDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMessageType(int i, DescriptorProto.Builder builder) {
            ensureMessageTypeIsMutable();
            this.messageType_.set(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMessageType(int i, DescriptorProto descriptorProto) {
            if (descriptorProto == null) {
                throw new NullPointerException();
            }
            ensureMessageTypeIsMutable();
            this.messageType_.set(i, descriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setName(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 1;
            this.name_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNameBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 1;
            this.name_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public void setOptions(FileOptions.Builder builder) {
            this.options_ = (FileOptions) builder.build();
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOptions(FileOptions fileOptions) {
            if (fileOptions == null) {
                throw new NullPointerException();
            }
            this.options_ = fileOptions;
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPackage(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 2;
            this.package_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPackageBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 2;
            this.package_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPublicDependency(int i, int i2) {
            ensurePublicDependencyIsMutable();
            this.publicDependency_.setInt(i, i2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setService(int i, ServiceDescriptorProto.Builder builder) {
            ensureServiceIsMutable();
            this.service_.set(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setService(int i, ServiceDescriptorProto serviceDescriptorProto) {
            if (serviceDescriptorProto == null) {
                throw new NullPointerException();
            }
            ensureServiceIsMutable();
            this.service_.set(i, serviceDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSourceCodeInfo(SourceCodeInfo.Builder builder) {
            this.sourceCodeInfo_ = builder.build();
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSourceCodeInfo(SourceCodeInfo sourceCodeInfo) {
            if (sourceCodeInfo == null) {
                throw new NullPointerException();
            }
            this.sourceCodeInfo_ = sourceCodeInfo;
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSyntax(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 16;
            this.syntax_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSyntaxBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 16;
            this.syntax_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setWeakDependency(int i, int i2) {
            ensureWeakDependencyIsMutable();
            this.weakDependency_.setInt(i, i2);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:26:0x003a. Please report as an issue. */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            List list;
            MessageLite messageLite;
            int i;
            int i2;
            Internal.IntList intList;
            int readInt32;
            int pushLimit;
            boolean z = false;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new FileDescriptorProto();
                case 2:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i3 = 0; i3 < getMessageTypeCount(); i3++) {
                        if (!getMessageType(i3).isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = (byte) 0;
                            }
                            return null;
                        }
                    }
                    for (int i4 = 0; i4 < getEnumTypeCount(); i4++) {
                        if (!getEnumType(i4).isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = (byte) 0;
                            }
                            return null;
                        }
                    }
                    for (int i5 = 0; i5 < getServiceCount(); i5++) {
                        if (!getService(i5).isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = (byte) 0;
                            }
                            return null;
                        }
                    }
                    for (int i6 = 0; i6 < getExtensionCount(); i6++) {
                        if (!getExtension(i6).isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = (byte) 0;
                            }
                            return null;
                        }
                    }
                    if (!hasOptions() || getOptions().isInitialized()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = (byte) 1;
                        }
                        return DEFAULT_INSTANCE;
                    }
                    if (booleanValue) {
                        this.memoizedIsInitialized = (byte) 0;
                    }
                    return null;
                case 3:
                    this.dependency_.makeImmutable();
                    this.publicDependency_.makeImmutable();
                    this.weakDependency_.makeImmutable();
                    this.messageType_.makeImmutable();
                    this.enumType_.makeImmutable();
                    this.service_.makeImmutable();
                    this.extension_.makeImmutable();
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    FileDescriptorProto fileDescriptorProto = (FileDescriptorProto) obj2;
                    this.name_ = visitor.visitString(hasName(), this.name_, fileDescriptorProto.hasName(), fileDescriptorProto.name_);
                    this.package_ = visitor.visitString(hasPackage(), this.package_, fileDescriptorProto.hasPackage(), fileDescriptorProto.package_);
                    this.dependency_ = visitor.visitList(this.dependency_, fileDescriptorProto.dependency_);
                    this.publicDependency_ = visitor.visitIntList(this.publicDependency_, fileDescriptorProto.publicDependency_);
                    this.weakDependency_ = visitor.visitIntList(this.weakDependency_, fileDescriptorProto.weakDependency_);
                    this.messageType_ = visitor.visitList(this.messageType_, fileDescriptorProto.messageType_);
                    this.enumType_ = visitor.visitList(this.enumType_, fileDescriptorProto.enumType_);
                    this.service_ = visitor.visitList(this.service_, fileDescriptorProto.service_);
                    this.extension_ = visitor.visitList(this.extension_, fileDescriptorProto.extension_);
                    this.options_ = (FileOptions) visitor.visitMessage(this.options_, fileDescriptorProto.options_);
                    this.sourceCodeInfo_ = (SourceCodeInfo) visitor.visitMessage(this.sourceCodeInfo_, fileDescriptorProto.sourceCodeInfo_);
                    this.syntax_ = visitor.visitString(hasSyntax(), this.syntax_, fileDescriptorProto.hasSyntax(), fileDescriptorProto.syntax_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= fileDescriptorProto.bitField0_;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            switch (readTag) {
                                case 0:
                                    z = true;
                                case 10:
                                    String readString = codedInputStream.readString();
                                    this.bitField0_ |= 1;
                                    this.name_ = readString;
                                case 18:
                                    String readString2 = codedInputStream.readString();
                                    this.bitField0_ |= 2;
                                    this.package_ = readString2;
                                case 26:
                                    String readString3 = codedInputStream.readString();
                                    if (!this.dependency_.isModifiable()) {
                                        this.dependency_ = GeneratedMessageLite.a(this.dependency_);
                                    }
                                    this.dependency_.add(readString3);
                                case 34:
                                    if (!this.messageType_.isModifiable()) {
                                        this.messageType_ = GeneratedMessageLite.a(this.messageType_);
                                    }
                                    list = this.messageType_;
                                    messageLite = (DescriptorProto) codedInputStream.readMessage(DescriptorProto.parser(), extensionRegistryLite);
                                    list.add(messageLite);
                                case 42:
                                    if (!this.enumType_.isModifiable()) {
                                        this.enumType_ = GeneratedMessageLite.a(this.enumType_);
                                    }
                                    list = this.enumType_;
                                    messageLite = (EnumDescriptorProto) codedInputStream.readMessage(EnumDescriptorProto.parser(), extensionRegistryLite);
                                    list.add(messageLite);
                                case 50:
                                    if (!this.service_.isModifiable()) {
                                        this.service_ = GeneratedMessageLite.a(this.service_);
                                    }
                                    list = this.service_;
                                    messageLite = (ServiceDescriptorProto) codedInputStream.readMessage(ServiceDescriptorProto.parser(), extensionRegistryLite);
                                    list.add(messageLite);
                                case 58:
                                    if (!this.extension_.isModifiable()) {
                                        this.extension_ = GeneratedMessageLite.a(this.extension_);
                                    }
                                    list = this.extension_;
                                    messageLite = (FieldDescriptorProto) codedInputStream.readMessage(FieldDescriptorProto.parser(), extensionRegistryLite);
                                    list.add(messageLite);
                                case 66:
                                    i = 4;
                                    FileOptions.Builder builder = (this.bitField0_ & 4) == 4 ? (FileOptions.Builder) this.options_.toBuilder() : null;
                                    this.options_ = (FileOptions) codedInputStream.readMessage(FileOptions.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom((FileOptions.Builder) this.options_);
                                        this.options_ = builder.buildPartial();
                                    }
                                    i2 = this.bitField0_;
                                    this.bitField0_ = i2 | i;
                                case 74:
                                    i = 8;
                                    SourceCodeInfo.Builder builder2 = (this.bitField0_ & 8) == 8 ? this.sourceCodeInfo_.toBuilder() : null;
                                    this.sourceCodeInfo_ = (SourceCodeInfo) codedInputStream.readMessage(SourceCodeInfo.parser(), extensionRegistryLite);
                                    if (builder2 != null) {
                                        builder2.mergeFrom((SourceCodeInfo.Builder) this.sourceCodeInfo_);
                                        this.sourceCodeInfo_ = builder2.buildPartial();
                                    }
                                    i2 = this.bitField0_;
                                    this.bitField0_ = i2 | i;
                                case 80:
                                    if (!this.publicDependency_.isModifiable()) {
                                        this.publicDependency_ = GeneratedMessageLite.a(this.publicDependency_);
                                    }
                                    intList = this.publicDependency_;
                                    readInt32 = codedInputStream.readInt32();
                                    intList.addInt(readInt32);
                                case 82:
                                    pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    if (!this.publicDependency_.isModifiable() && codedInputStream.getBytesUntilLimit() > 0) {
                                        this.publicDependency_ = GeneratedMessageLite.a(this.publicDependency_);
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.publicDependency_.addInt(codedInputStream.readInt32());
                                    }
                                    codedInputStream.popLimit(pushLimit);
                                    break;
                                case 88:
                                    if (!this.weakDependency_.isModifiable()) {
                                        this.weakDependency_ = GeneratedMessageLite.a(this.weakDependency_);
                                    }
                                    intList = this.weakDependency_;
                                    readInt32 = codedInputStream.readInt32();
                                    intList.addInt(readInt32);
                                case 90:
                                    pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    if (!this.weakDependency_.isModifiable() && codedInputStream.getBytesUntilLimit() > 0) {
                                        this.weakDependency_ = GeneratedMessageLite.a(this.weakDependency_);
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.weakDependency_.addInt(codedInputStream.readInt32());
                                    }
                                    codedInputStream.popLimit(pushLimit);
                                    break;
                                case 98:
                                    String readString4 = codedInputStream.readString();
                                    this.bitField0_ |= 16;
                                    this.syntax_ = readString4;
                                default:
                                    if (!a(readTag, codedInputStream)) {
                                        z = true;
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
                        synchronized (FileDescriptorProto.class) {
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

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public String getDependency(int i) {
            return this.dependency_.get(i);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public ByteString getDependencyBytes(int i) {
            return ByteString.copyFromUtf8(this.dependency_.get(i));
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public int getDependencyCount() {
            return this.dependency_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public List<String> getDependencyList() {
            return this.dependency_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public EnumDescriptorProto getEnumType(int i) {
            return this.enumType_.get(i);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public int getEnumTypeCount() {
            return this.enumType_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public List<EnumDescriptorProto> getEnumTypeList() {
            return this.enumType_;
        }

        public EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(int i) {
            return this.enumType_.get(i);
        }

        public List<? extends EnumDescriptorProtoOrBuilder> getEnumTypeOrBuilderList() {
            return this.enumType_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public FieldDescriptorProto getExtension(int i) {
            return this.extension_.get(i);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public int getExtensionCount() {
            return this.extension_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public List<FieldDescriptorProto> getExtensionList() {
            return this.extension_;
        }

        public FieldDescriptorProtoOrBuilder getExtensionOrBuilder(int i) {
            return this.extension_.get(i);
        }

        public List<? extends FieldDescriptorProtoOrBuilder> getExtensionOrBuilderList() {
            return this.extension_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public DescriptorProto getMessageType(int i) {
            return this.messageType_.get(i);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public int getMessageTypeCount() {
            return this.messageType_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public List<DescriptorProto> getMessageTypeList() {
            return this.messageType_;
        }

        public DescriptorProtoOrBuilder getMessageTypeOrBuilder(int i) {
            return this.messageType_.get(i);
        }

        public List<? extends DescriptorProtoOrBuilder> getMessageTypeOrBuilderList() {
            return this.messageType_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public String getName() {
            return this.name_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public FileOptions getOptions() {
            FileOptions fileOptions = this.options_;
            return fileOptions == null ? FileOptions.getDefaultInstance() : fileOptions;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public String getPackage() {
            return this.package_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public ByteString getPackageBytes() {
            return ByteString.copyFromUtf8(this.package_);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public int getPublicDependency(int i) {
            return this.publicDependency_.getInt(i);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public int getPublicDependencyCount() {
            return this.publicDependency_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public List<Integer> getPublicDependencyList() {
            return this.publicDependency_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeStringSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeStringSize(1, getName()) + 0 : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeStringSize += CodedOutputStream.computeStringSize(2, getPackage());
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.dependency_.size(); i3++) {
                i2 += CodedOutputStream.computeStringSizeNoTag(this.dependency_.get(i3));
            }
            int size = computeStringSize + i2 + (getDependencyList().size() * 1);
            for (int i4 = 0; i4 < this.messageType_.size(); i4++) {
                size += CodedOutputStream.computeMessageSize(4, this.messageType_.get(i4));
            }
            for (int i5 = 0; i5 < this.enumType_.size(); i5++) {
                size += CodedOutputStream.computeMessageSize(5, this.enumType_.get(i5));
            }
            for (int i6 = 0; i6 < this.service_.size(); i6++) {
                size += CodedOutputStream.computeMessageSize(6, this.service_.get(i6));
            }
            for (int i7 = 0; i7 < this.extension_.size(); i7++) {
                size += CodedOutputStream.computeMessageSize(7, this.extension_.get(i7));
            }
            if ((this.bitField0_ & 4) == 4) {
                size += CodedOutputStream.computeMessageSize(8, getOptions());
            }
            if ((this.bitField0_ & 8) == 8) {
                size += CodedOutputStream.computeMessageSize(9, getSourceCodeInfo());
            }
            int i8 = 0;
            for (int i9 = 0; i9 < this.publicDependency_.size(); i9++) {
                i8 += CodedOutputStream.computeInt32SizeNoTag(this.publicDependency_.getInt(i9));
            }
            int size2 = size + i8 + (getPublicDependencyList().size() * 1);
            int i10 = 0;
            for (int i11 = 0; i11 < this.weakDependency_.size(); i11++) {
                i10 += CodedOutputStream.computeInt32SizeNoTag(this.weakDependency_.getInt(i11));
            }
            int size3 = size2 + i10 + (getWeakDependencyList().size() * 1);
            if ((this.bitField0_ & 16) == 16) {
                size3 += CodedOutputStream.computeStringSize(12, getSyntax());
            }
            int serializedSize = size3 + this.b.getSerializedSize();
            this.c = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public ServiceDescriptorProto getService(int i) {
            return this.service_.get(i);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public int getServiceCount() {
            return this.service_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public List<ServiceDescriptorProto> getServiceList() {
            return this.service_;
        }

        public ServiceDescriptorProtoOrBuilder getServiceOrBuilder(int i) {
            return this.service_.get(i);
        }

        public List<? extends ServiceDescriptorProtoOrBuilder> getServiceOrBuilderList() {
            return this.service_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public SourceCodeInfo getSourceCodeInfo() {
            SourceCodeInfo sourceCodeInfo = this.sourceCodeInfo_;
            return sourceCodeInfo == null ? SourceCodeInfo.getDefaultInstance() : sourceCodeInfo;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public String getSyntax() {
            return this.syntax_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public ByteString getSyntaxBytes() {
            return ByteString.copyFromUtf8(this.syntax_);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public int getWeakDependency(int i) {
            return this.weakDependency_.getInt(i);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public int getWeakDependencyCount() {
            return this.weakDependency_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public List<Integer> getWeakDependencyList() {
            return this.weakDependency_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public boolean hasOptions() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public boolean hasPackage() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public boolean hasSourceCodeInfo() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public boolean hasSyntax() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeString(1, getName());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeString(2, getPackage());
            }
            for (int i = 0; i < this.dependency_.size(); i++) {
                codedOutputStream.writeString(3, this.dependency_.get(i));
            }
            for (int i2 = 0; i2 < this.messageType_.size(); i2++) {
                codedOutputStream.writeMessage(4, this.messageType_.get(i2));
            }
            for (int i3 = 0; i3 < this.enumType_.size(); i3++) {
                codedOutputStream.writeMessage(5, this.enumType_.get(i3));
            }
            for (int i4 = 0; i4 < this.service_.size(); i4++) {
                codedOutputStream.writeMessage(6, this.service_.get(i4));
            }
            for (int i5 = 0; i5 < this.extension_.size(); i5++) {
                codedOutputStream.writeMessage(7, this.extension_.get(i5));
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeMessage(8, getOptions());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeMessage(9, getSourceCodeInfo());
            }
            for (int i6 = 0; i6 < this.publicDependency_.size(); i6++) {
                codedOutputStream.writeInt32(10, this.publicDependency_.getInt(i6));
            }
            for (int i7 = 0; i7 < this.weakDependency_.size(); i7++) {
                codedOutputStream.writeInt32(11, this.weakDependency_.getInt(i7));
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeString(12, getSyntax());
            }
            this.b.writeTo(codedOutputStream);
        }
    }

    /* loaded from: classes2.dex */
    public interface FileDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
        String getDependency(int i);

        ByteString getDependencyBytes(int i);

        int getDependencyCount();

        List<String> getDependencyList();

        EnumDescriptorProto getEnumType(int i);

        int getEnumTypeCount();

        List<EnumDescriptorProto> getEnumTypeList();

        FieldDescriptorProto getExtension(int i);

        int getExtensionCount();

        List<FieldDescriptorProto> getExtensionList();

        DescriptorProto getMessageType(int i);

        int getMessageTypeCount();

        List<DescriptorProto> getMessageTypeList();

        String getName();

        ByteString getNameBytes();

        FileOptions getOptions();

        String getPackage();

        ByteString getPackageBytes();

        int getPublicDependency(int i);

        int getPublicDependencyCount();

        List<Integer> getPublicDependencyList();

        ServiceDescriptorProto getService(int i);

        int getServiceCount();

        List<ServiceDescriptorProto> getServiceList();

        SourceCodeInfo getSourceCodeInfo();

        String getSyntax();

        ByteString getSyntaxBytes();

        int getWeakDependency(int i);

        int getWeakDependencyCount();

        List<Integer> getWeakDependencyList();

        boolean hasName();

        boolean hasOptions();

        boolean hasPackage();

        boolean hasSourceCodeInfo();

        boolean hasSyntax();
    }

    /* loaded from: classes2.dex */
    public static final class FileDescriptorSet extends GeneratedMessageLite<FileDescriptorSet, Builder> implements FileDescriptorSetOrBuilder {
        private static final FileDescriptorSet DEFAULT_INSTANCE = new FileDescriptorSet();
        public static final int FILE_FIELD_NUMBER = 1;
        private static volatile Parser<FileDescriptorSet> PARSER;
        private byte memoizedIsInitialized = -1;
        private Internal.ProtobufList<FileDescriptorProto> file_ = GeneratedMessageLite.f();

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<FileDescriptorSet, Builder> implements FileDescriptorSetOrBuilder {
            private Builder() {
                super(FileDescriptorSet.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllFile(Iterable<? extends FileDescriptorProto> iterable) {
                a();
                ((FileDescriptorSet) this.a).addAllFile(iterable);
                return this;
            }

            public Builder addFile(int i, FileDescriptorProto.Builder builder) {
                a();
                ((FileDescriptorSet) this.a).addFile(i, builder);
                return this;
            }

            public Builder addFile(int i, FileDescriptorProto fileDescriptorProto) {
                a();
                ((FileDescriptorSet) this.a).addFile(i, fileDescriptorProto);
                return this;
            }

            public Builder addFile(FileDescriptorProto.Builder builder) {
                a();
                ((FileDescriptorSet) this.a).addFile(builder);
                return this;
            }

            public Builder addFile(FileDescriptorProto fileDescriptorProto) {
                a();
                ((FileDescriptorSet) this.a).addFile(fileDescriptorProto);
                return this;
            }

            public Builder clearFile() {
                a();
                ((FileDescriptorSet) this.a).clearFile();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorSetOrBuilder
            public FileDescriptorProto getFile(int i) {
                return ((FileDescriptorSet) this.a).getFile(i);
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorSetOrBuilder
            public int getFileCount() {
                return ((FileDescriptorSet) this.a).getFileCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorSetOrBuilder
            public List<FileDescriptorProto> getFileList() {
                return Collections.unmodifiableList(((FileDescriptorSet) this.a).getFileList());
            }

            public Builder removeFile(int i) {
                a();
                ((FileDescriptorSet) this.a).removeFile(i);
                return this;
            }

            public Builder setFile(int i, FileDescriptorProto.Builder builder) {
                a();
                ((FileDescriptorSet) this.a).setFile(i, builder);
                return this;
            }

            public Builder setFile(int i, FileDescriptorProto fileDescriptorProto) {
                a();
                ((FileDescriptorSet) this.a).setFile(i, fileDescriptorProto);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private FileDescriptorSet() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllFile(Iterable<? extends FileDescriptorProto> iterable) {
            ensureFileIsMutable();
            AbstractMessageLite.a(iterable, this.file_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addFile(int i, FileDescriptorProto.Builder builder) {
            ensureFileIsMutable();
            this.file_.add(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addFile(int i, FileDescriptorProto fileDescriptorProto) {
            if (fileDescriptorProto == null) {
                throw new NullPointerException();
            }
            ensureFileIsMutable();
            this.file_.add(i, fileDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addFile(FileDescriptorProto.Builder builder) {
            ensureFileIsMutable();
            this.file_.add(builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addFile(FileDescriptorProto fileDescriptorProto) {
            if (fileDescriptorProto == null) {
                throw new NullPointerException();
            }
            ensureFileIsMutable();
            this.file_.add(fileDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFile() {
            this.file_ = GeneratedMessageLite.f();
        }

        private void ensureFileIsMutable() {
            if (this.file_.isModifiable()) {
                return;
            }
            this.file_ = GeneratedMessageLite.a(this.file_);
        }

        public static FileDescriptorSet getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FileDescriptorSet fileDescriptorSet) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) fileDescriptorSet);
        }

        public static FileDescriptorSet parseDelimitedFrom(InputStream inputStream) {
            return (FileDescriptorSet) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static FileDescriptorSet parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (FileDescriptorSet) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FileDescriptorSet parseFrom(ByteString byteString) {
            return (FileDescriptorSet) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static FileDescriptorSet parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (FileDescriptorSet) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static FileDescriptorSet parseFrom(CodedInputStream codedInputStream) {
            return (FileDescriptorSet) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static FileDescriptorSet parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (FileDescriptorSet) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static FileDescriptorSet parseFrom(InputStream inputStream) {
            return (FileDescriptorSet) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static FileDescriptorSet parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (FileDescriptorSet) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FileDescriptorSet parseFrom(byte[] bArr) {
            return (FileDescriptorSet) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static FileDescriptorSet parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (FileDescriptorSet) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<FileDescriptorSet> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeFile(int i) {
            ensureFileIsMutable();
            this.file_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFile(int i, FileDescriptorProto.Builder builder) {
            ensureFileIsMutable();
            this.file_.set(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFile(int i, FileDescriptorProto fileDescriptorProto) {
            if (fileDescriptorProto == null) {
                throw new NullPointerException();
            }
            ensureFileIsMutable();
            this.file_.set(i, fileDescriptorProto);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new FileDescriptorSet();
                case 2:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i = 0; i < getFileCount(); i++) {
                        if (!getFile(i).isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = (byte) 0;
                            }
                            return null;
                        }
                    }
                    if (booleanValue) {
                        this.memoizedIsInitialized = (byte) 1;
                    }
                    return DEFAULT_INSTANCE;
                case 3:
                    this.file_.makeImmutable();
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    this.file_ = ((GeneratedMessageLite.Visitor) obj).visitList(this.file_, ((FileDescriptorSet) obj2).file_);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            try {
                                int readTag = codedInputStream.readTag();
                                if (readTag != 0) {
                                    if (readTag == 10) {
                                        if (!this.file_.isModifiable()) {
                                            this.file_ = GeneratedMessageLite.a(this.file_);
                                        }
                                        this.file_.add((FileDescriptorProto) codedInputStream.readMessage(FileDescriptorProto.parser(), extensionRegistryLite));
                                    } else if (!a(readTag, codedInputStream)) {
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
                        synchronized (FileDescriptorSet.class) {
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

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorSetOrBuilder
        public FileDescriptorProto getFile(int i) {
            return this.file_.get(i);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorSetOrBuilder
        public int getFileCount() {
            return this.file_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorSetOrBuilder
        public List<FileDescriptorProto> getFileList() {
            return this.file_;
        }

        public FileDescriptorProtoOrBuilder getFileOrBuilder(int i) {
            return this.file_.get(i);
        }

        public List<? extends FileDescriptorProtoOrBuilder> getFileOrBuilderList() {
            return this.file_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.file_.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(1, this.file_.get(i3));
            }
            int serializedSize = i2 + this.b.getSerializedSize();
            this.c = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            for (int i = 0; i < this.file_.size(); i++) {
                codedOutputStream.writeMessage(1, this.file_.get(i));
            }
            this.b.writeTo(codedOutputStream);
        }
    }

    /* loaded from: classes2.dex */
    public interface FileDescriptorSetOrBuilder extends MessageLiteOrBuilder {
        FileDescriptorProto getFile(int i);

        int getFileCount();

        List<FileDescriptorProto> getFileList();
    }

    /* loaded from: classes2.dex */
    public static final class FileOptions extends GeneratedMessageLite.ExtendableMessage<FileOptions, Builder> implements FileOptionsOrBuilder {
        public static final int CC_ENABLE_ARENAS_FIELD_NUMBER = 31;
        public static final int CC_GENERIC_SERVICES_FIELD_NUMBER = 16;
        public static final int CSHARP_NAMESPACE_FIELD_NUMBER = 37;
        private static final FileOptions DEFAULT_INSTANCE = new FileOptions();
        public static final int DEPRECATED_FIELD_NUMBER = 23;
        public static final int GO_PACKAGE_FIELD_NUMBER = 11;
        public static final int JAVA_GENERATE_EQUALS_AND_HASH_FIELD_NUMBER = 20;
        public static final int JAVA_GENERIC_SERVICES_FIELD_NUMBER = 17;
        public static final int JAVA_MULTIPLE_FILES_FIELD_NUMBER = 10;
        public static final int JAVA_OUTER_CLASSNAME_FIELD_NUMBER = 8;
        public static final int JAVA_PACKAGE_FIELD_NUMBER = 1;
        public static final int JAVA_STRING_CHECK_UTF8_FIELD_NUMBER = 27;
        public static final int OBJC_CLASS_PREFIX_FIELD_NUMBER = 36;
        public static final int OPTIMIZE_FOR_FIELD_NUMBER = 9;
        private static volatile Parser<FileOptions> PARSER = null;
        public static final int PHP_CLASS_PREFIX_FIELD_NUMBER = 40;
        public static final int PHP_GENERIC_SERVICES_FIELD_NUMBER = 42;
        public static final int PHP_NAMESPACE_FIELD_NUMBER = 41;
        public static final int PY_GENERIC_SERVICES_FIELD_NUMBER = 18;
        public static final int SWIFT_PREFIX_FIELD_NUMBER = 39;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private int bitField0_;
        private boolean ccEnableArenas_;
        private boolean ccGenericServices_;
        private boolean deprecated_;
        private boolean javaGenerateEqualsAndHash_;
        private boolean javaGenericServices_;
        private boolean javaMultipleFiles_;
        private boolean javaStringCheckUtf8_;
        private boolean phpGenericServices_;
        private boolean pyGenericServices_;
        private byte memoizedIsInitialized = -1;
        private String javaPackage_ = "";
        private String javaOuterClassname_ = "";
        private int optimizeFor_ = 1;
        private String goPackage_ = "";
        private String objcClassPrefix_ = "";
        private String csharpNamespace_ = "";
        private String swiftPrefix_ = "";
        private String phpClassPrefix_ = "";
        private String phpNamespace_ = "";
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = GeneratedMessageLite.f();

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<FileOptions, Builder> implements FileOptionsOrBuilder {
            private Builder() {
                super(FileOptions.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
                a();
                ((FileOptions) this.a).addAllUninterpretedOption(iterable);
                return this;
            }

            public Builder addUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                a();
                ((FileOptions) this.a).addUninterpretedOption(i, builder);
                return this;
            }

            public Builder addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                a();
                ((FileOptions) this.a).addUninterpretedOption(i, uninterpretedOption);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption.Builder builder) {
                a();
                ((FileOptions) this.a).addUninterpretedOption(builder);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption uninterpretedOption) {
                a();
                ((FileOptions) this.a).addUninterpretedOption(uninterpretedOption);
                return this;
            }

            public Builder clearCcEnableArenas() {
                a();
                ((FileOptions) this.a).clearCcEnableArenas();
                return this;
            }

            public Builder clearCcGenericServices() {
                a();
                ((FileOptions) this.a).clearCcGenericServices();
                return this;
            }

            public Builder clearCsharpNamespace() {
                a();
                ((FileOptions) this.a).clearCsharpNamespace();
                return this;
            }

            public Builder clearDeprecated() {
                a();
                ((FileOptions) this.a).clearDeprecated();
                return this;
            }

            public Builder clearGoPackage() {
                a();
                ((FileOptions) this.a).clearGoPackage();
                return this;
            }

            @Deprecated
            public Builder clearJavaGenerateEqualsAndHash() {
                a();
                ((FileOptions) this.a).clearJavaGenerateEqualsAndHash();
                return this;
            }

            public Builder clearJavaGenericServices() {
                a();
                ((FileOptions) this.a).clearJavaGenericServices();
                return this;
            }

            public Builder clearJavaMultipleFiles() {
                a();
                ((FileOptions) this.a).clearJavaMultipleFiles();
                return this;
            }

            public Builder clearJavaOuterClassname() {
                a();
                ((FileOptions) this.a).clearJavaOuterClassname();
                return this;
            }

            public Builder clearJavaPackage() {
                a();
                ((FileOptions) this.a).clearJavaPackage();
                return this;
            }

            public Builder clearJavaStringCheckUtf8() {
                a();
                ((FileOptions) this.a).clearJavaStringCheckUtf8();
                return this;
            }

            public Builder clearObjcClassPrefix() {
                a();
                ((FileOptions) this.a).clearObjcClassPrefix();
                return this;
            }

            public Builder clearOptimizeFor() {
                a();
                ((FileOptions) this.a).clearOptimizeFor();
                return this;
            }

            public Builder clearPhpClassPrefix() {
                a();
                ((FileOptions) this.a).clearPhpClassPrefix();
                return this;
            }

            public Builder clearPhpGenericServices() {
                a();
                ((FileOptions) this.a).clearPhpGenericServices();
                return this;
            }

            public Builder clearPhpNamespace() {
                a();
                ((FileOptions) this.a).clearPhpNamespace();
                return this;
            }

            public Builder clearPyGenericServices() {
                a();
                ((FileOptions) this.a).clearPyGenericServices();
                return this;
            }

            public Builder clearSwiftPrefix() {
                a();
                ((FileOptions) this.a).clearSwiftPrefix();
                return this;
            }

            public Builder clearUninterpretedOption() {
                a();
                ((FileOptions) this.a).clearUninterpretedOption();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean getCcEnableArenas() {
                return ((FileOptions) this.a).getCcEnableArenas();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean getCcGenericServices() {
                return ((FileOptions) this.a).getCcGenericServices();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public String getCsharpNamespace() {
                return ((FileOptions) this.a).getCsharpNamespace();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public ByteString getCsharpNamespaceBytes() {
                return ((FileOptions) this.a).getCsharpNamespaceBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean getDeprecated() {
                return ((FileOptions) this.a).getDeprecated();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public String getGoPackage() {
                return ((FileOptions) this.a).getGoPackage();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public ByteString getGoPackageBytes() {
                return ((FileOptions) this.a).getGoPackageBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            @Deprecated
            public boolean getJavaGenerateEqualsAndHash() {
                return ((FileOptions) this.a).getJavaGenerateEqualsAndHash();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean getJavaGenericServices() {
                return ((FileOptions) this.a).getJavaGenericServices();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean getJavaMultipleFiles() {
                return ((FileOptions) this.a).getJavaMultipleFiles();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public String getJavaOuterClassname() {
                return ((FileOptions) this.a).getJavaOuterClassname();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public ByteString getJavaOuterClassnameBytes() {
                return ((FileOptions) this.a).getJavaOuterClassnameBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public String getJavaPackage() {
                return ((FileOptions) this.a).getJavaPackage();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public ByteString getJavaPackageBytes() {
                return ((FileOptions) this.a).getJavaPackageBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean getJavaStringCheckUtf8() {
                return ((FileOptions) this.a).getJavaStringCheckUtf8();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public String getObjcClassPrefix() {
                return ((FileOptions) this.a).getObjcClassPrefix();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public ByteString getObjcClassPrefixBytes() {
                return ((FileOptions) this.a).getObjcClassPrefixBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public OptimizeMode getOptimizeFor() {
                return ((FileOptions) this.a).getOptimizeFor();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public String getPhpClassPrefix() {
                return ((FileOptions) this.a).getPhpClassPrefix();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public ByteString getPhpClassPrefixBytes() {
                return ((FileOptions) this.a).getPhpClassPrefixBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean getPhpGenericServices() {
                return ((FileOptions) this.a).getPhpGenericServices();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public String getPhpNamespace() {
                return ((FileOptions) this.a).getPhpNamespace();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public ByteString getPhpNamespaceBytes() {
                return ((FileOptions) this.a).getPhpNamespaceBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean getPyGenericServices() {
                return ((FileOptions) this.a).getPyGenericServices();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public String getSwiftPrefix() {
                return ((FileOptions) this.a).getSwiftPrefix();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public ByteString getSwiftPrefixBytes() {
                return ((FileOptions) this.a).getSwiftPrefixBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public UninterpretedOption getUninterpretedOption(int i) {
                return ((FileOptions) this.a).getUninterpretedOption(i);
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public int getUninterpretedOptionCount() {
                return ((FileOptions) this.a).getUninterpretedOptionCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(((FileOptions) this.a).getUninterpretedOptionList());
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasCcEnableArenas() {
                return ((FileOptions) this.a).hasCcEnableArenas();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasCcGenericServices() {
                return ((FileOptions) this.a).hasCcGenericServices();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasCsharpNamespace() {
                return ((FileOptions) this.a).hasCsharpNamespace();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasDeprecated() {
                return ((FileOptions) this.a).hasDeprecated();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasGoPackage() {
                return ((FileOptions) this.a).hasGoPackage();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            @Deprecated
            public boolean hasJavaGenerateEqualsAndHash() {
                return ((FileOptions) this.a).hasJavaGenerateEqualsAndHash();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasJavaGenericServices() {
                return ((FileOptions) this.a).hasJavaGenericServices();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasJavaMultipleFiles() {
                return ((FileOptions) this.a).hasJavaMultipleFiles();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasJavaOuterClassname() {
                return ((FileOptions) this.a).hasJavaOuterClassname();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasJavaPackage() {
                return ((FileOptions) this.a).hasJavaPackage();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasJavaStringCheckUtf8() {
                return ((FileOptions) this.a).hasJavaStringCheckUtf8();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasObjcClassPrefix() {
                return ((FileOptions) this.a).hasObjcClassPrefix();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasOptimizeFor() {
                return ((FileOptions) this.a).hasOptimizeFor();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasPhpClassPrefix() {
                return ((FileOptions) this.a).hasPhpClassPrefix();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasPhpGenericServices() {
                return ((FileOptions) this.a).hasPhpGenericServices();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasPhpNamespace() {
                return ((FileOptions) this.a).hasPhpNamespace();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasPyGenericServices() {
                return ((FileOptions) this.a).hasPyGenericServices();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasSwiftPrefix() {
                return ((FileOptions) this.a).hasSwiftPrefix();
            }

            public Builder removeUninterpretedOption(int i) {
                a();
                ((FileOptions) this.a).removeUninterpretedOption(i);
                return this;
            }

            public Builder setCcEnableArenas(boolean z) {
                a();
                ((FileOptions) this.a).setCcEnableArenas(z);
                return this;
            }

            public Builder setCcGenericServices(boolean z) {
                a();
                ((FileOptions) this.a).setCcGenericServices(z);
                return this;
            }

            public Builder setCsharpNamespace(String str) {
                a();
                ((FileOptions) this.a).setCsharpNamespace(str);
                return this;
            }

            public Builder setCsharpNamespaceBytes(ByteString byteString) {
                a();
                ((FileOptions) this.a).setCsharpNamespaceBytes(byteString);
                return this;
            }

            public Builder setDeprecated(boolean z) {
                a();
                ((FileOptions) this.a).setDeprecated(z);
                return this;
            }

            public Builder setGoPackage(String str) {
                a();
                ((FileOptions) this.a).setGoPackage(str);
                return this;
            }

            public Builder setGoPackageBytes(ByteString byteString) {
                a();
                ((FileOptions) this.a).setGoPackageBytes(byteString);
                return this;
            }

            @Deprecated
            public Builder setJavaGenerateEqualsAndHash(boolean z) {
                a();
                ((FileOptions) this.a).setJavaGenerateEqualsAndHash(z);
                return this;
            }

            public Builder setJavaGenericServices(boolean z) {
                a();
                ((FileOptions) this.a).setJavaGenericServices(z);
                return this;
            }

            public Builder setJavaMultipleFiles(boolean z) {
                a();
                ((FileOptions) this.a).setJavaMultipleFiles(z);
                return this;
            }

            public Builder setJavaOuterClassname(String str) {
                a();
                ((FileOptions) this.a).setJavaOuterClassname(str);
                return this;
            }

            public Builder setJavaOuterClassnameBytes(ByteString byteString) {
                a();
                ((FileOptions) this.a).setJavaOuterClassnameBytes(byteString);
                return this;
            }

            public Builder setJavaPackage(String str) {
                a();
                ((FileOptions) this.a).setJavaPackage(str);
                return this;
            }

            public Builder setJavaPackageBytes(ByteString byteString) {
                a();
                ((FileOptions) this.a).setJavaPackageBytes(byteString);
                return this;
            }

            public Builder setJavaStringCheckUtf8(boolean z) {
                a();
                ((FileOptions) this.a).setJavaStringCheckUtf8(z);
                return this;
            }

            public Builder setObjcClassPrefix(String str) {
                a();
                ((FileOptions) this.a).setObjcClassPrefix(str);
                return this;
            }

            public Builder setObjcClassPrefixBytes(ByteString byteString) {
                a();
                ((FileOptions) this.a).setObjcClassPrefixBytes(byteString);
                return this;
            }

            public Builder setOptimizeFor(OptimizeMode optimizeMode) {
                a();
                ((FileOptions) this.a).setOptimizeFor(optimizeMode);
                return this;
            }

            public Builder setPhpClassPrefix(String str) {
                a();
                ((FileOptions) this.a).setPhpClassPrefix(str);
                return this;
            }

            public Builder setPhpClassPrefixBytes(ByteString byteString) {
                a();
                ((FileOptions) this.a).setPhpClassPrefixBytes(byteString);
                return this;
            }

            public Builder setPhpGenericServices(boolean z) {
                a();
                ((FileOptions) this.a).setPhpGenericServices(z);
                return this;
            }

            public Builder setPhpNamespace(String str) {
                a();
                ((FileOptions) this.a).setPhpNamespace(str);
                return this;
            }

            public Builder setPhpNamespaceBytes(ByteString byteString) {
                a();
                ((FileOptions) this.a).setPhpNamespaceBytes(byteString);
                return this;
            }

            public Builder setPyGenericServices(boolean z) {
                a();
                ((FileOptions) this.a).setPyGenericServices(z);
                return this;
            }

            public Builder setSwiftPrefix(String str) {
                a();
                ((FileOptions) this.a).setSwiftPrefix(str);
                return this;
            }

            public Builder setSwiftPrefixBytes(ByteString byteString) {
                a();
                ((FileOptions) this.a).setSwiftPrefixBytes(byteString);
                return this;
            }

            public Builder setUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                a();
                ((FileOptions) this.a).setUninterpretedOption(i, builder);
                return this;
            }

            public Builder setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                a();
                ((FileOptions) this.a).setUninterpretedOption(i, uninterpretedOption);
                return this;
            }
        }

        /* loaded from: classes2.dex */
        public enum OptimizeMode implements Internal.EnumLite {
            SPEED(1),
            CODE_SIZE(2),
            LITE_RUNTIME(3);

            public static final int CODE_SIZE_VALUE = 2;
            public static final int LITE_RUNTIME_VALUE = 3;
            public static final int SPEED_VALUE = 1;
            private static final Internal.EnumLiteMap<OptimizeMode> internalValueMap = new Internal.EnumLiteMap<OptimizeMode>() { // from class: com.google.protobuf.DescriptorProtos.FileOptions.OptimizeMode.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public OptimizeMode findValueByNumber(int i) {
                    return OptimizeMode.forNumber(i);
                }
            };
            private final int value;

            OptimizeMode(int i) {
                this.value = i;
            }

            public static OptimizeMode forNumber(int i) {
                if (i == 1) {
                    return SPEED;
                }
                if (i == 2) {
                    return CODE_SIZE;
                }
                if (i != 3) {
                    return null;
                }
                return LITE_RUNTIME;
            }

            public static Internal.EnumLiteMap<OptimizeMode> internalGetValueMap() {
                return internalValueMap;
            }

            @Deprecated
            public static OptimizeMode valueOf(int i) {
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

        private FileOptions() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
            ensureUninterpretedOptionIsMutable();
            AbstractMessageLite.a(iterable, this.uninterpretedOption_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUninterpretedOption(int i, UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption == null) {
                throw new NullPointerException();
            }
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(i, uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption == null) {
                throw new NullPointerException();
            }
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCcEnableArenas() {
            this.bitField0_ &= -4097;
            this.ccEnableArenas_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCcGenericServices() {
            this.bitField0_ &= -129;
            this.ccGenericServices_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCsharpNamespace() {
            this.bitField0_ &= -16385;
            this.csharpNamespace_ = getDefaultInstance().getCsharpNamespace();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDeprecated() {
            this.bitField0_ &= -2049;
            this.deprecated_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearGoPackage() {
            this.bitField0_ &= -65;
            this.goPackage_ = getDefaultInstance().getGoPackage();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearJavaGenerateEqualsAndHash() {
            this.bitField0_ &= -9;
            this.javaGenerateEqualsAndHash_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearJavaGenericServices() {
            this.bitField0_ &= -257;
            this.javaGenericServices_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearJavaMultipleFiles() {
            this.bitField0_ &= -5;
            this.javaMultipleFiles_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearJavaOuterClassname() {
            this.bitField0_ &= -3;
            this.javaOuterClassname_ = getDefaultInstance().getJavaOuterClassname();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearJavaPackage() {
            this.bitField0_ &= -2;
            this.javaPackage_ = getDefaultInstance().getJavaPackage();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearJavaStringCheckUtf8() {
            this.bitField0_ &= -17;
            this.javaStringCheckUtf8_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearObjcClassPrefix() {
            this.bitField0_ &= -8193;
            this.objcClassPrefix_ = getDefaultInstance().getObjcClassPrefix();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOptimizeFor() {
            this.bitField0_ &= -33;
            this.optimizeFor_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPhpClassPrefix() {
            this.bitField0_ &= -65537;
            this.phpClassPrefix_ = getDefaultInstance().getPhpClassPrefix();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPhpGenericServices() {
            this.bitField0_ &= -1025;
            this.phpGenericServices_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPhpNamespace() {
            this.bitField0_ &= -131073;
            this.phpNamespace_ = getDefaultInstance().getPhpNamespace();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPyGenericServices() {
            this.bitField0_ &= -513;
            this.pyGenericServices_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSwiftPrefix() {
            this.bitField0_ &= -32769;
            this.swiftPrefix_ = getDefaultInstance().getSwiftPrefix();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUninterpretedOption() {
            this.uninterpretedOption_ = GeneratedMessageLite.f();
        }

        private void ensureUninterpretedOptionIsMutable() {
            if (this.uninterpretedOption_.isModifiable()) {
                return;
            }
            this.uninterpretedOption_ = GeneratedMessageLite.a(this.uninterpretedOption_);
        }

        public static FileOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static Builder newBuilder(FileOptions fileOptions) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom((Builder) fileOptions);
        }

        public static FileOptions parseDelimitedFrom(InputStream inputStream) {
            return (FileOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static FileOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (FileOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FileOptions parseFrom(ByteString byteString) {
            return (FileOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static FileOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (FileOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static FileOptions parseFrom(CodedInputStream codedInputStream) {
            return (FileOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static FileOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (FileOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static FileOptions parseFrom(InputStream inputStream) {
            return (FileOptions) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static FileOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (FileOptions) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FileOptions parseFrom(byte[] bArr) {
            return (FileOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static FileOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (FileOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<FileOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeUninterpretedOption(int i) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCcEnableArenas(boolean z) {
            this.bitField0_ |= 4096;
            this.ccEnableArenas_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCcGenericServices(boolean z) {
            this.bitField0_ |= 128;
            this.ccGenericServices_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCsharpNamespace(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 16384;
            this.csharpNamespace_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCsharpNamespaceBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 16384;
            this.csharpNamespace_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDeprecated(boolean z) {
            this.bitField0_ |= 2048;
            this.deprecated_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setGoPackage(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 64;
            this.goPackage_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setGoPackageBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 64;
            this.goPackage_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setJavaGenerateEqualsAndHash(boolean z) {
            this.bitField0_ |= 8;
            this.javaGenerateEqualsAndHash_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setJavaGenericServices(boolean z) {
            this.bitField0_ |= 256;
            this.javaGenericServices_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setJavaMultipleFiles(boolean z) {
            this.bitField0_ |= 4;
            this.javaMultipleFiles_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setJavaOuterClassname(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 2;
            this.javaOuterClassname_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setJavaOuterClassnameBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 2;
            this.javaOuterClassname_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setJavaPackage(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 1;
            this.javaPackage_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setJavaPackageBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 1;
            this.javaPackage_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setJavaStringCheckUtf8(boolean z) {
            this.bitField0_ |= 16;
            this.javaStringCheckUtf8_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setObjcClassPrefix(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 8192;
            this.objcClassPrefix_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setObjcClassPrefixBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 8192;
            this.objcClassPrefix_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOptimizeFor(OptimizeMode optimizeMode) {
            if (optimizeMode == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 32;
            this.optimizeFor_ = optimizeMode.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPhpClassPrefix(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 65536;
            this.phpClassPrefix_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPhpClassPrefixBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 65536;
            this.phpClassPrefix_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPhpGenericServices(boolean z) {
            this.bitField0_ |= 1024;
            this.phpGenericServices_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPhpNamespace(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 131072;
            this.phpNamespace_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPhpNamespaceBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 131072;
            this.phpNamespace_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPyGenericServices(boolean z) {
            this.bitField0_ |= 512;
            this.pyGenericServices_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSwiftPrefix(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 32768;
            this.swiftPrefix_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSwiftPrefixBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 32768;
            this.swiftPrefix_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUninterpretedOption(int i, UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption == null) {
                throw new NullPointerException();
            }
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(i, uninterpretedOption);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:26:0x003a. Please report as an issue. */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new FileOptions();
                case 2:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i = 0; i < getUninterpretedOptionCount(); i++) {
                        if (!getUninterpretedOption(i).isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = (byte) 0;
                            }
                            return null;
                        }
                    }
                    if (g()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = (byte) 1;
                        }
                        return DEFAULT_INSTANCE;
                    }
                    if (booleanValue) {
                        this.memoizedIsInitialized = (byte) 0;
                    }
                    return null;
                case 3:
                    this.uninterpretedOption_.makeImmutable();
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    FileOptions fileOptions = (FileOptions) obj2;
                    this.javaPackage_ = visitor.visitString(hasJavaPackage(), this.javaPackage_, fileOptions.hasJavaPackage(), fileOptions.javaPackage_);
                    this.javaOuterClassname_ = visitor.visitString(hasJavaOuterClassname(), this.javaOuterClassname_, fileOptions.hasJavaOuterClassname(), fileOptions.javaOuterClassname_);
                    this.javaMultipleFiles_ = visitor.visitBoolean(hasJavaMultipleFiles(), this.javaMultipleFiles_, fileOptions.hasJavaMultipleFiles(), fileOptions.javaMultipleFiles_);
                    this.javaGenerateEqualsAndHash_ = visitor.visitBoolean(hasJavaGenerateEqualsAndHash(), this.javaGenerateEqualsAndHash_, fileOptions.hasJavaGenerateEqualsAndHash(), fileOptions.javaGenerateEqualsAndHash_);
                    this.javaStringCheckUtf8_ = visitor.visitBoolean(hasJavaStringCheckUtf8(), this.javaStringCheckUtf8_, fileOptions.hasJavaStringCheckUtf8(), fileOptions.javaStringCheckUtf8_);
                    this.optimizeFor_ = visitor.visitInt(hasOptimizeFor(), this.optimizeFor_, fileOptions.hasOptimizeFor(), fileOptions.optimizeFor_);
                    this.goPackage_ = visitor.visitString(hasGoPackage(), this.goPackage_, fileOptions.hasGoPackage(), fileOptions.goPackage_);
                    this.ccGenericServices_ = visitor.visitBoolean(hasCcGenericServices(), this.ccGenericServices_, fileOptions.hasCcGenericServices(), fileOptions.ccGenericServices_);
                    this.javaGenericServices_ = visitor.visitBoolean(hasJavaGenericServices(), this.javaGenericServices_, fileOptions.hasJavaGenericServices(), fileOptions.javaGenericServices_);
                    this.pyGenericServices_ = visitor.visitBoolean(hasPyGenericServices(), this.pyGenericServices_, fileOptions.hasPyGenericServices(), fileOptions.pyGenericServices_);
                    this.phpGenericServices_ = visitor.visitBoolean(hasPhpGenericServices(), this.phpGenericServices_, fileOptions.hasPhpGenericServices(), fileOptions.phpGenericServices_);
                    this.deprecated_ = visitor.visitBoolean(hasDeprecated(), this.deprecated_, fileOptions.hasDeprecated(), fileOptions.deprecated_);
                    this.ccEnableArenas_ = visitor.visitBoolean(hasCcEnableArenas(), this.ccEnableArenas_, fileOptions.hasCcEnableArenas(), fileOptions.ccEnableArenas_);
                    this.objcClassPrefix_ = visitor.visitString(hasObjcClassPrefix(), this.objcClassPrefix_, fileOptions.hasObjcClassPrefix(), fileOptions.objcClassPrefix_);
                    this.csharpNamespace_ = visitor.visitString(hasCsharpNamespace(), this.csharpNamespace_, fileOptions.hasCsharpNamespace(), fileOptions.csharpNamespace_);
                    this.swiftPrefix_ = visitor.visitString(hasSwiftPrefix(), this.swiftPrefix_, fileOptions.hasSwiftPrefix(), fileOptions.swiftPrefix_);
                    this.phpClassPrefix_ = visitor.visitString(hasPhpClassPrefix(), this.phpClassPrefix_, fileOptions.hasPhpClassPrefix(), fileOptions.phpClassPrefix_);
                    this.phpNamespace_ = visitor.visitString(hasPhpNamespace(), this.phpNamespace_, fileOptions.hasPhpNamespace(), fileOptions.phpNamespace_);
                    this.uninterpretedOption_ = visitor.visitList(this.uninterpretedOption_, fileOptions.uninterpretedOption_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= fileOptions.bitField0_;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            switch (readTag) {
                                case 0:
                                    z = true;
                                case 10:
                                    String readString = codedInputStream.readString();
                                    this.bitField0_ |= 1;
                                    this.javaPackage_ = readString;
                                case 66:
                                    String readString2 = codedInputStream.readString();
                                    this.bitField0_ |= 2;
                                    this.javaOuterClassname_ = readString2;
                                case 72:
                                    int readEnum = codedInputStream.readEnum();
                                    if (OptimizeMode.forNumber(readEnum) == null) {
                                        super.a(9, readEnum);
                                    } else {
                                        this.bitField0_ |= 32;
                                        this.optimizeFor_ = readEnum;
                                    }
                                case 80:
                                    this.bitField0_ |= 4;
                                    this.javaMultipleFiles_ = codedInputStream.readBool();
                                case 90:
                                    String readString3 = codedInputStream.readString();
                                    this.bitField0_ |= 64;
                                    this.goPackage_ = readString3;
                                case 128:
                                    this.bitField0_ |= 128;
                                    this.ccGenericServices_ = codedInputStream.readBool();
                                case 136:
                                    this.bitField0_ |= 256;
                                    this.javaGenericServices_ = codedInputStream.readBool();
                                case 144:
                                    this.bitField0_ |= 512;
                                    this.pyGenericServices_ = codedInputStream.readBool();
                                case 160:
                                    this.bitField0_ |= 8;
                                    this.javaGenerateEqualsAndHash_ = codedInputStream.readBool();
                                case 184:
                                    this.bitField0_ |= 2048;
                                    this.deprecated_ = codedInputStream.readBool();
                                case 216:
                                    this.bitField0_ |= 16;
                                    this.javaStringCheckUtf8_ = codedInputStream.readBool();
                                case 248:
                                    this.bitField0_ |= 4096;
                                    this.ccEnableArenas_ = codedInputStream.readBool();
                                case 290:
                                    String readString4 = codedInputStream.readString();
                                    this.bitField0_ |= 8192;
                                    this.objcClassPrefix_ = readString4;
                                case 298:
                                    String readString5 = codedInputStream.readString();
                                    this.bitField0_ |= 16384;
                                    this.csharpNamespace_ = readString5;
                                case 314:
                                    String readString6 = codedInputStream.readString();
                                    this.bitField0_ |= 32768;
                                    this.swiftPrefix_ = readString6;
                                case 322:
                                    String readString7 = codedInputStream.readString();
                                    this.bitField0_ |= 65536;
                                    this.phpClassPrefix_ = readString7;
                                case 330:
                                    String readString8 = codedInputStream.readString();
                                    this.bitField0_ |= 131072;
                                    this.phpNamespace_ = readString8;
                                case 336:
                                    this.bitField0_ |= 1024;
                                    this.phpGenericServices_ = codedInputStream.readBool();
                                case 7994:
                                    if (!this.uninterpretedOption_.isModifiable()) {
                                        this.uninterpretedOption_ = GeneratedMessageLite.a(this.uninterpretedOption_);
                                    }
                                    this.uninterpretedOption_.add((UninterpretedOption) codedInputStream.readMessage(UninterpretedOption.parser(), extensionRegistryLite));
                                default:
                                    if (!a((FileOptions) getDefaultInstanceForType(), codedInputStream, extensionRegistryLite, readTag)) {
                                        z = true;
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
                        synchronized (FileOptions.class) {
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

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean getCcEnableArenas() {
            return this.ccEnableArenas_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean getCcGenericServices() {
            return this.ccGenericServices_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public String getCsharpNamespace() {
            return this.csharpNamespace_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public ByteString getCsharpNamespaceBytes() {
            return ByteString.copyFromUtf8(this.csharpNamespace_);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean getDeprecated() {
            return this.deprecated_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public String getGoPackage() {
            return this.goPackage_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public ByteString getGoPackageBytes() {
            return ByteString.copyFromUtf8(this.goPackage_);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        @Deprecated
        public boolean getJavaGenerateEqualsAndHash() {
            return this.javaGenerateEqualsAndHash_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean getJavaGenericServices() {
            return this.javaGenericServices_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean getJavaMultipleFiles() {
            return this.javaMultipleFiles_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public String getJavaOuterClassname() {
            return this.javaOuterClassname_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public ByteString getJavaOuterClassnameBytes() {
            return ByteString.copyFromUtf8(this.javaOuterClassname_);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public String getJavaPackage() {
            return this.javaPackage_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public ByteString getJavaPackageBytes() {
            return ByteString.copyFromUtf8(this.javaPackage_);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean getJavaStringCheckUtf8() {
            return this.javaStringCheckUtf8_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public String getObjcClassPrefix() {
            return this.objcClassPrefix_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public ByteString getObjcClassPrefixBytes() {
            return ByteString.copyFromUtf8(this.objcClassPrefix_);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public OptimizeMode getOptimizeFor() {
            OptimizeMode forNumber = OptimizeMode.forNumber(this.optimizeFor_);
            return forNumber == null ? OptimizeMode.SPEED : forNumber;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public String getPhpClassPrefix() {
            return this.phpClassPrefix_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public ByteString getPhpClassPrefixBytes() {
            return ByteString.copyFromUtf8(this.phpClassPrefix_);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean getPhpGenericServices() {
            return this.phpGenericServices_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public String getPhpNamespace() {
            return this.phpNamespace_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public ByteString getPhpNamespaceBytes() {
            return ByteString.copyFromUtf8(this.phpNamespace_);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean getPyGenericServices() {
            return this.pyGenericServices_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeStringSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeStringSize(1, getJavaPackage()) + 0 : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeStringSize += CodedOutputStream.computeStringSize(8, getJavaOuterClassname());
            }
            if ((this.bitField0_ & 32) == 32) {
                computeStringSize += CodedOutputStream.computeEnumSize(9, this.optimizeFor_);
            }
            if ((this.bitField0_ & 4) == 4) {
                computeStringSize += CodedOutputStream.computeBoolSize(10, this.javaMultipleFiles_);
            }
            if ((this.bitField0_ & 64) == 64) {
                computeStringSize += CodedOutputStream.computeStringSize(11, getGoPackage());
            }
            if ((this.bitField0_ & 128) == 128) {
                computeStringSize += CodedOutputStream.computeBoolSize(16, this.ccGenericServices_);
            }
            if ((this.bitField0_ & 256) == 256) {
                computeStringSize += CodedOutputStream.computeBoolSize(17, this.javaGenericServices_);
            }
            if ((this.bitField0_ & 512) == 512) {
                computeStringSize += CodedOutputStream.computeBoolSize(18, this.pyGenericServices_);
            }
            if ((this.bitField0_ & 8) == 8) {
                computeStringSize += CodedOutputStream.computeBoolSize(20, this.javaGenerateEqualsAndHash_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                computeStringSize += CodedOutputStream.computeBoolSize(23, this.deprecated_);
            }
            if ((this.bitField0_ & 16) == 16) {
                computeStringSize += CodedOutputStream.computeBoolSize(27, this.javaStringCheckUtf8_);
            }
            if ((this.bitField0_ & 4096) == 4096) {
                computeStringSize += CodedOutputStream.computeBoolSize(31, this.ccEnableArenas_);
            }
            if ((this.bitField0_ & 8192) == 8192) {
                computeStringSize += CodedOutputStream.computeStringSize(36, getObjcClassPrefix());
            }
            if ((this.bitField0_ & 16384) == 16384) {
                computeStringSize += CodedOutputStream.computeStringSize(37, getCsharpNamespace());
            }
            if ((this.bitField0_ & 32768) == 32768) {
                computeStringSize += CodedOutputStream.computeStringSize(39, getSwiftPrefix());
            }
            if ((this.bitField0_ & 65536) == 65536) {
                computeStringSize += CodedOutputStream.computeStringSize(40, getPhpClassPrefix());
            }
            if ((this.bitField0_ & 131072) == 131072) {
                computeStringSize += CodedOutputStream.computeStringSize(41, getPhpNamespace());
            }
            if ((this.bitField0_ & 1024) == 1024) {
                computeStringSize += CodedOutputStream.computeBoolSize(42, this.phpGenericServices_);
            }
            for (int i2 = 0; i2 < this.uninterpretedOption_.size(); i2++) {
                computeStringSize += CodedOutputStream.computeMessageSize(999, this.uninterpretedOption_.get(i2));
            }
            int h = computeStringSize + h() + this.b.getSerializedSize();
            this.c = h;
            return h;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public String getSwiftPrefix() {
            return this.swiftPrefix_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public ByteString getSwiftPrefixBytes() {
            return ByteString.copyFromUtf8(this.swiftPrefix_);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public UninterpretedOption getUninterpretedOption(int i) {
            return this.uninterpretedOption_.get(i);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i) {
            return this.uninterpretedOption_.get(i);
        }

        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasCcEnableArenas() {
            return (this.bitField0_ & 4096) == 4096;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasCcGenericServices() {
            return (this.bitField0_ & 128) == 128;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasCsharpNamespace() {
            return (this.bitField0_ & 16384) == 16384;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasDeprecated() {
            return (this.bitField0_ & 2048) == 2048;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasGoPackage() {
            return (this.bitField0_ & 64) == 64;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        @Deprecated
        public boolean hasJavaGenerateEqualsAndHash() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasJavaGenericServices() {
            return (this.bitField0_ & 256) == 256;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasJavaMultipleFiles() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasJavaOuterClassname() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasJavaPackage() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasJavaStringCheckUtf8() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasObjcClassPrefix() {
            return (this.bitField0_ & 8192) == 8192;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasOptimizeFor() {
            return (this.bitField0_ & 32) == 32;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasPhpClassPrefix() {
            return (this.bitField0_ & 65536) == 65536;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasPhpGenericServices() {
            return (this.bitField0_ & 1024) == 1024;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasPhpNamespace() {
            return (this.bitField0_ & 131072) == 131072;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasPyGenericServices() {
            return (this.bitField0_ & 512) == 512;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasSwiftPrefix() {
            return (this.bitField0_ & 32768) == 32768;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            GeneratedMessageLite.ExtendableMessage<MessageType, BuilderType>.ExtensionWriter i = i();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeString(1, getJavaPackage());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeString(8, getJavaOuterClassname());
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeEnum(9, this.optimizeFor_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeBool(10, this.javaMultipleFiles_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeString(11, getGoPackage());
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.writeBool(16, this.ccGenericServices_);
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.writeBool(17, this.javaGenericServices_);
            }
            if ((this.bitField0_ & 512) == 512) {
                codedOutputStream.writeBool(18, this.pyGenericServices_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeBool(20, this.javaGenerateEqualsAndHash_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                codedOutputStream.writeBool(23, this.deprecated_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeBool(27, this.javaStringCheckUtf8_);
            }
            if ((this.bitField0_ & 4096) == 4096) {
                codedOutputStream.writeBool(31, this.ccEnableArenas_);
            }
            if ((this.bitField0_ & 8192) == 8192) {
                codedOutputStream.writeString(36, getObjcClassPrefix());
            }
            if ((this.bitField0_ & 16384) == 16384) {
                codedOutputStream.writeString(37, getCsharpNamespace());
            }
            if ((this.bitField0_ & 32768) == 32768) {
                codedOutputStream.writeString(39, getSwiftPrefix());
            }
            if ((this.bitField0_ & 65536) == 65536) {
                codedOutputStream.writeString(40, getPhpClassPrefix());
            }
            if ((this.bitField0_ & 131072) == 131072) {
                codedOutputStream.writeString(41, getPhpNamespace());
            }
            if ((this.bitField0_ & 1024) == 1024) {
                codedOutputStream.writeBool(42, this.phpGenericServices_);
            }
            for (int i2 = 0; i2 < this.uninterpretedOption_.size(); i2++) {
                codedOutputStream.writeMessage(999, this.uninterpretedOption_.get(i2));
            }
            i.writeUntil(536870912, codedOutputStream);
            this.b.writeTo(codedOutputStream);
        }
    }

    /* loaded from: classes2.dex */
    public interface FileOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<FileOptions, FileOptions.Builder> {
        boolean getCcEnableArenas();

        boolean getCcGenericServices();

        String getCsharpNamespace();

        ByteString getCsharpNamespaceBytes();

        boolean getDeprecated();

        String getGoPackage();

        ByteString getGoPackageBytes();

        @Deprecated
        boolean getJavaGenerateEqualsAndHash();

        boolean getJavaGenericServices();

        boolean getJavaMultipleFiles();

        String getJavaOuterClassname();

        ByteString getJavaOuterClassnameBytes();

        String getJavaPackage();

        ByteString getJavaPackageBytes();

        boolean getJavaStringCheckUtf8();

        String getObjcClassPrefix();

        ByteString getObjcClassPrefixBytes();

        FileOptions.OptimizeMode getOptimizeFor();

        String getPhpClassPrefix();

        ByteString getPhpClassPrefixBytes();

        boolean getPhpGenericServices();

        String getPhpNamespace();

        ByteString getPhpNamespaceBytes();

        boolean getPyGenericServices();

        String getSwiftPrefix();

        ByteString getSwiftPrefixBytes();

        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        boolean hasCcEnableArenas();

        boolean hasCcGenericServices();

        boolean hasCsharpNamespace();

        boolean hasDeprecated();

        boolean hasGoPackage();

        @Deprecated
        boolean hasJavaGenerateEqualsAndHash();

        boolean hasJavaGenericServices();

        boolean hasJavaMultipleFiles();

        boolean hasJavaOuterClassname();

        boolean hasJavaPackage();

        boolean hasJavaStringCheckUtf8();

        boolean hasObjcClassPrefix();

        boolean hasOptimizeFor();

        boolean hasPhpClassPrefix();

        boolean hasPhpGenericServices();

        boolean hasPhpNamespace();

        boolean hasPyGenericServices();

        boolean hasSwiftPrefix();
    }

    /* loaded from: classes2.dex */
    public static final class GeneratedCodeInfo extends GeneratedMessageLite<GeneratedCodeInfo, Builder> implements GeneratedCodeInfoOrBuilder {
        public static final int ANNOTATION_FIELD_NUMBER = 1;
        private static final GeneratedCodeInfo DEFAULT_INSTANCE = new GeneratedCodeInfo();
        private static volatile Parser<GeneratedCodeInfo> PARSER;
        private Internal.ProtobufList<Annotation> annotation_ = GeneratedMessageLite.f();

        /* loaded from: classes2.dex */
        public static final class Annotation extends GeneratedMessageLite<Annotation, Builder> implements AnnotationOrBuilder {
            public static final int BEGIN_FIELD_NUMBER = 3;
            private static final Annotation DEFAULT_INSTANCE = new Annotation();
            public static final int END_FIELD_NUMBER = 4;
            private static volatile Parser<Annotation> PARSER = null;
            public static final int PATH_FIELD_NUMBER = 1;
            public static final int SOURCE_FILE_FIELD_NUMBER = 2;
            private int begin_;
            private int bitField0_;
            private int end_;
            private int pathMemoizedSerializedSize = -1;
            private Internal.IntList path_ = GeneratedMessageLite.d();
            private String sourceFile_ = "";

            /* loaded from: classes2.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<Annotation, Builder> implements AnnotationOrBuilder {
                private Builder() {
                    super(Annotation.DEFAULT_INSTANCE);
                }

                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                public Builder addAllPath(Iterable<? extends Integer> iterable) {
                    a();
                    ((Annotation) this.a).addAllPath(iterable);
                    return this;
                }

                public Builder addPath(int i) {
                    a();
                    ((Annotation) this.a).addPath(i);
                    return this;
                }

                public Builder clearBegin() {
                    a();
                    ((Annotation) this.a).clearBegin();
                    return this;
                }

                public Builder clearEnd() {
                    a();
                    ((Annotation) this.a).clearEnd();
                    return this;
                }

                public Builder clearPath() {
                    a();
                    ((Annotation) this.a).clearPath();
                    return this;
                }

                public Builder clearSourceFile() {
                    a();
                    ((Annotation) this.a).clearSourceFile();
                    return this;
                }

                @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
                public int getBegin() {
                    return ((Annotation) this.a).getBegin();
                }

                @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
                public int getEnd() {
                    return ((Annotation) this.a).getEnd();
                }

                @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
                public int getPath(int i) {
                    return ((Annotation) this.a).getPath(i);
                }

                @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
                public int getPathCount() {
                    return ((Annotation) this.a).getPathCount();
                }

                @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
                public List<Integer> getPathList() {
                    return Collections.unmodifiableList(((Annotation) this.a).getPathList());
                }

                @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
                public String getSourceFile() {
                    return ((Annotation) this.a).getSourceFile();
                }

                @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
                public ByteString getSourceFileBytes() {
                    return ((Annotation) this.a).getSourceFileBytes();
                }

                @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
                public boolean hasBegin() {
                    return ((Annotation) this.a).hasBegin();
                }

                @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
                public boolean hasEnd() {
                    return ((Annotation) this.a).hasEnd();
                }

                @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
                public boolean hasSourceFile() {
                    return ((Annotation) this.a).hasSourceFile();
                }

                public Builder setBegin(int i) {
                    a();
                    ((Annotation) this.a).setBegin(i);
                    return this;
                }

                public Builder setEnd(int i) {
                    a();
                    ((Annotation) this.a).setEnd(i);
                    return this;
                }

                public Builder setPath(int i, int i2) {
                    a();
                    ((Annotation) this.a).setPath(i, i2);
                    return this;
                }

                public Builder setSourceFile(String str) {
                    a();
                    ((Annotation) this.a).setSourceFile(str);
                    return this;
                }

                public Builder setSourceFileBytes(ByteString byteString) {
                    a();
                    ((Annotation) this.a).setSourceFileBytes(byteString);
                    return this;
                }
            }

            static {
                DEFAULT_INSTANCE.b();
            }

            private Annotation() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addAllPath(Iterable<? extends Integer> iterable) {
                ensurePathIsMutable();
                AbstractMessageLite.a(iterable, this.path_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addPath(int i) {
                ensurePathIsMutable();
                this.path_.addInt(i);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearBegin() {
                this.bitField0_ &= -3;
                this.begin_ = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearEnd() {
                this.bitField0_ &= -5;
                this.end_ = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearPath() {
                this.path_ = GeneratedMessageLite.d();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearSourceFile() {
                this.bitField0_ &= -2;
                this.sourceFile_ = getDefaultInstance().getSourceFile();
            }

            private void ensurePathIsMutable() {
                if (this.path_.isModifiable()) {
                    return;
                }
                this.path_ = GeneratedMessageLite.a(this.path_);
            }

            public static Annotation getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(Annotation annotation) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) annotation);
            }

            public static Annotation parseDelimitedFrom(InputStream inputStream) {
                return (Annotation) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
            }

            public static Annotation parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Annotation) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Annotation parseFrom(ByteString byteString) {
                return (Annotation) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
            }

            public static Annotation parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                return (Annotation) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Annotation parseFrom(CodedInputStream codedInputStream) {
                return (Annotation) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Annotation parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Annotation) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Annotation parseFrom(InputStream inputStream) {
                return (Annotation) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
            }

            public static Annotation parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Annotation) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Annotation parseFrom(byte[] bArr) {
                return (Annotation) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
            }

            public static Annotation parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                return (Annotation) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static Parser<Annotation> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setBegin(int i) {
                this.bitField0_ |= 2;
                this.begin_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setEnd(int i) {
                this.bitField0_ |= 4;
                this.end_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setPath(int i, int i2) {
                ensurePathIsMutable();
                this.path_.setInt(i, i2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setSourceFile(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 1;
                this.sourceFile_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setSourceFileBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 1;
                this.sourceFile_ = byteString.toStringUtf8();
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new Annotation();
                    case 2:
                        return DEFAULT_INSTANCE;
                    case 3:
                        this.path_.makeImmutable();
                        return null;
                    case 4:
                        return new Builder(anonymousClass1);
                    case 5:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        Annotation annotation = (Annotation) obj2;
                        this.path_ = visitor.visitIntList(this.path_, annotation.path_);
                        this.sourceFile_ = visitor.visitString(hasSourceFile(), this.sourceFile_, annotation.hasSourceFile(), annotation.sourceFile_);
                        this.begin_ = visitor.visitInt(hasBegin(), this.begin_, annotation.hasBegin(), annotation.begin_);
                        this.end_ = visitor.visitInt(hasEnd(), this.end_, annotation.hasEnd(), annotation.end_);
                        if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                            this.bitField0_ |= annotation.bitField0_;
                        }
                        return this;
                    case 6:
                        CodedInputStream codedInputStream = (CodedInputStream) obj;
                        boolean z = false;
                        while (!z) {
                            try {
                                int readTag = codedInputStream.readTag();
                                if (readTag != 0) {
                                    if (readTag == 8) {
                                        if (!this.path_.isModifiable()) {
                                            this.path_ = GeneratedMessageLite.a(this.path_);
                                        }
                                        this.path_.addInt(codedInputStream.readInt32());
                                    } else if (readTag == 10) {
                                        int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                        if (!this.path_.isModifiable() && codedInputStream.getBytesUntilLimit() > 0) {
                                            this.path_ = GeneratedMessageLite.a(this.path_);
                                        }
                                        while (codedInputStream.getBytesUntilLimit() > 0) {
                                            this.path_.addInt(codedInputStream.readInt32());
                                        }
                                        codedInputStream.popLimit(pushLimit);
                                    } else if (readTag == 18) {
                                        String readString = codedInputStream.readString();
                                        this.bitField0_ = 1 | this.bitField0_;
                                        this.sourceFile_ = readString;
                                    } else if (readTag == 24) {
                                        this.bitField0_ |= 2;
                                        this.begin_ = codedInputStream.readInt32();
                                    } else if (readTag == 32) {
                                        this.bitField0_ |= 4;
                                        this.end_ = codedInputStream.readInt32();
                                    } else if (!a(readTag, codedInputStream)) {
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
                            synchronized (Annotation.class) {
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

            @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
            public int getBegin() {
                return this.begin_;
            }

            @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
            public int getEnd() {
                return this.end_;
            }

            @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
            public int getPath(int i) {
                return this.path_.getInt(i);
            }

            @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
            public int getPathCount() {
                return this.path_.size();
            }

            @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
            public List<Integer> getPathList() {
                return this.path_;
            }

            @Override // com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.c;
                if (i != -1) {
                    return i;
                }
                int i2 = 0;
                for (int i3 = 0; i3 < this.path_.size(); i3++) {
                    i2 += CodedOutputStream.computeInt32SizeNoTag(this.path_.getInt(i3));
                }
                int i4 = 0 + i2;
                if (!getPathList().isEmpty()) {
                    i4 = i4 + 1 + CodedOutputStream.computeInt32SizeNoTag(i2);
                }
                this.pathMemoizedSerializedSize = i2;
                if ((this.bitField0_ & 1) == 1) {
                    i4 += CodedOutputStream.computeStringSize(2, getSourceFile());
                }
                if ((this.bitField0_ & 2) == 2) {
                    i4 += CodedOutputStream.computeInt32Size(3, this.begin_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    i4 += CodedOutputStream.computeInt32Size(4, this.end_);
                }
                int serializedSize = i4 + this.b.getSerializedSize();
                this.c = serializedSize;
                return serializedSize;
            }

            @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
            public String getSourceFile() {
                return this.sourceFile_;
            }

            @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
            public ByteString getSourceFileBytes() {
                return ByteString.copyFromUtf8(this.sourceFile_);
            }

            @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
            public boolean hasBegin() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
            public boolean hasEnd() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
            public boolean hasSourceFile() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) {
                getSerializedSize();
                if (getPathList().size() > 0) {
                    codedOutputStream.writeUInt32NoTag(10);
                    codedOutputStream.writeUInt32NoTag(this.pathMemoizedSerializedSize);
                }
                for (int i = 0; i < this.path_.size(); i++) {
                    codedOutputStream.writeInt32NoTag(this.path_.getInt(i));
                }
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.writeString(2, getSourceFile());
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.writeInt32(3, this.begin_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    codedOutputStream.writeInt32(4, this.end_);
                }
                this.b.writeTo(codedOutputStream);
            }
        }

        /* loaded from: classes2.dex */
        public interface AnnotationOrBuilder extends MessageLiteOrBuilder {
            int getBegin();

            int getEnd();

            int getPath(int i);

            int getPathCount();

            List<Integer> getPathList();

            String getSourceFile();

            ByteString getSourceFileBytes();

            boolean hasBegin();

            boolean hasEnd();

            boolean hasSourceFile();
        }

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<GeneratedCodeInfo, Builder> implements GeneratedCodeInfoOrBuilder {
            private Builder() {
                super(GeneratedCodeInfo.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllAnnotation(Iterable<? extends Annotation> iterable) {
                a();
                ((GeneratedCodeInfo) this.a).addAllAnnotation(iterable);
                return this;
            }

            public Builder addAnnotation(int i, Annotation.Builder builder) {
                a();
                ((GeneratedCodeInfo) this.a).addAnnotation(i, builder);
                return this;
            }

            public Builder addAnnotation(int i, Annotation annotation) {
                a();
                ((GeneratedCodeInfo) this.a).addAnnotation(i, annotation);
                return this;
            }

            public Builder addAnnotation(Annotation.Builder builder) {
                a();
                ((GeneratedCodeInfo) this.a).addAnnotation(builder);
                return this;
            }

            public Builder addAnnotation(Annotation annotation) {
                a();
                ((GeneratedCodeInfo) this.a).addAnnotation(annotation);
                return this;
            }

            public Builder clearAnnotation() {
                a();
                ((GeneratedCodeInfo) this.a).clearAnnotation();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfoOrBuilder
            public Annotation getAnnotation(int i) {
                return ((GeneratedCodeInfo) this.a).getAnnotation(i);
            }

            @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfoOrBuilder
            public int getAnnotationCount() {
                return ((GeneratedCodeInfo) this.a).getAnnotationCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfoOrBuilder
            public List<Annotation> getAnnotationList() {
                return Collections.unmodifiableList(((GeneratedCodeInfo) this.a).getAnnotationList());
            }

            public Builder removeAnnotation(int i) {
                a();
                ((GeneratedCodeInfo) this.a).removeAnnotation(i);
                return this;
            }

            public Builder setAnnotation(int i, Annotation.Builder builder) {
                a();
                ((GeneratedCodeInfo) this.a).setAnnotation(i, builder);
                return this;
            }

            public Builder setAnnotation(int i, Annotation annotation) {
                a();
                ((GeneratedCodeInfo) this.a).setAnnotation(i, annotation);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private GeneratedCodeInfo() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllAnnotation(Iterable<? extends Annotation> iterable) {
            ensureAnnotationIsMutable();
            AbstractMessageLite.a(iterable, this.annotation_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAnnotation(int i, Annotation.Builder builder) {
            ensureAnnotationIsMutable();
            this.annotation_.add(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAnnotation(int i, Annotation annotation) {
            if (annotation == null) {
                throw new NullPointerException();
            }
            ensureAnnotationIsMutable();
            this.annotation_.add(i, annotation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAnnotation(Annotation.Builder builder) {
            ensureAnnotationIsMutable();
            this.annotation_.add(builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAnnotation(Annotation annotation) {
            if (annotation == null) {
                throw new NullPointerException();
            }
            ensureAnnotationIsMutable();
            this.annotation_.add(annotation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAnnotation() {
            this.annotation_ = GeneratedMessageLite.f();
        }

        private void ensureAnnotationIsMutable() {
            if (this.annotation_.isModifiable()) {
                return;
            }
            this.annotation_ = GeneratedMessageLite.a(this.annotation_);
        }

        public static GeneratedCodeInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GeneratedCodeInfo generatedCodeInfo) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) generatedCodeInfo);
        }

        public static GeneratedCodeInfo parseDelimitedFrom(InputStream inputStream) {
            return (GeneratedCodeInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static GeneratedCodeInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (GeneratedCodeInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static GeneratedCodeInfo parseFrom(ByteString byteString) {
            return (GeneratedCodeInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static GeneratedCodeInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (GeneratedCodeInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static GeneratedCodeInfo parseFrom(CodedInputStream codedInputStream) {
            return (GeneratedCodeInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static GeneratedCodeInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (GeneratedCodeInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static GeneratedCodeInfo parseFrom(InputStream inputStream) {
            return (GeneratedCodeInfo) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static GeneratedCodeInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (GeneratedCodeInfo) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static GeneratedCodeInfo parseFrom(byte[] bArr) {
            return (GeneratedCodeInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static GeneratedCodeInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (GeneratedCodeInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<GeneratedCodeInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeAnnotation(int i) {
            ensureAnnotationIsMutable();
            this.annotation_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAnnotation(int i, Annotation.Builder builder) {
            ensureAnnotationIsMutable();
            this.annotation_.set(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAnnotation(int i, Annotation annotation) {
            if (annotation == null) {
                throw new NullPointerException();
            }
            ensureAnnotationIsMutable();
            this.annotation_.set(i, annotation);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new GeneratedCodeInfo();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    this.annotation_.makeImmutable();
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    this.annotation_ = ((GeneratedMessageLite.Visitor) obj).visitList(this.annotation_, ((GeneratedCodeInfo) obj2).annotation_);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    boolean z = false;
                    while (!z) {
                        try {
                            try {
                                int readTag = codedInputStream.readTag();
                                if (readTag != 0) {
                                    if (readTag == 10) {
                                        if (!this.annotation_.isModifiable()) {
                                            this.annotation_ = GeneratedMessageLite.a(this.annotation_);
                                        }
                                        this.annotation_.add((Annotation) codedInputStream.readMessage(Annotation.parser(), extensionRegistryLite));
                                    } else if (!a(readTag, codedInputStream)) {
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
                        synchronized (GeneratedCodeInfo.class) {
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

        @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfoOrBuilder
        public Annotation getAnnotation(int i) {
            return this.annotation_.get(i);
        }

        @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfoOrBuilder
        public int getAnnotationCount() {
            return this.annotation_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfoOrBuilder
        public List<Annotation> getAnnotationList() {
            return this.annotation_;
        }

        public AnnotationOrBuilder getAnnotationOrBuilder(int i) {
            return this.annotation_.get(i);
        }

        public List<? extends AnnotationOrBuilder> getAnnotationOrBuilderList() {
            return this.annotation_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.annotation_.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(1, this.annotation_.get(i3));
            }
            int serializedSize = i2 + this.b.getSerializedSize();
            this.c = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            for (int i = 0; i < this.annotation_.size(); i++) {
                codedOutputStream.writeMessage(1, this.annotation_.get(i));
            }
            this.b.writeTo(codedOutputStream);
        }
    }

    /* loaded from: classes2.dex */
    public interface GeneratedCodeInfoOrBuilder extends MessageLiteOrBuilder {
        GeneratedCodeInfo.Annotation getAnnotation(int i);

        int getAnnotationCount();

        List<GeneratedCodeInfo.Annotation> getAnnotationList();
    }

    /* loaded from: classes2.dex */
    public static final class MessageOptions extends GeneratedMessageLite.ExtendableMessage<MessageOptions, Builder> implements MessageOptionsOrBuilder {
        private static final MessageOptions DEFAULT_INSTANCE = new MessageOptions();
        public static final int DEPRECATED_FIELD_NUMBER = 3;
        public static final int MAP_ENTRY_FIELD_NUMBER = 7;
        public static final int MESSAGE_SET_WIRE_FORMAT_FIELD_NUMBER = 1;
        public static final int NO_STANDARD_DESCRIPTOR_ACCESSOR_FIELD_NUMBER = 2;
        private static volatile Parser<MessageOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private int bitField0_;
        private boolean deprecated_;
        private boolean mapEntry_;
        private boolean messageSetWireFormat_;
        private boolean noStandardDescriptorAccessor_;
        private byte memoizedIsInitialized = -1;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = GeneratedMessageLite.f();

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<MessageOptions, Builder> implements MessageOptionsOrBuilder {
            private Builder() {
                super(MessageOptions.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
                a();
                ((MessageOptions) this.a).addAllUninterpretedOption(iterable);
                return this;
            }

            public Builder addUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                a();
                ((MessageOptions) this.a).addUninterpretedOption(i, builder);
                return this;
            }

            public Builder addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                a();
                ((MessageOptions) this.a).addUninterpretedOption(i, uninterpretedOption);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption.Builder builder) {
                a();
                ((MessageOptions) this.a).addUninterpretedOption(builder);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption uninterpretedOption) {
                a();
                ((MessageOptions) this.a).addUninterpretedOption(uninterpretedOption);
                return this;
            }

            public Builder clearDeprecated() {
                a();
                ((MessageOptions) this.a).clearDeprecated();
                return this;
            }

            public Builder clearMapEntry() {
                a();
                ((MessageOptions) this.a).clearMapEntry();
                return this;
            }

            public Builder clearMessageSetWireFormat() {
                a();
                ((MessageOptions) this.a).clearMessageSetWireFormat();
                return this;
            }

            public Builder clearNoStandardDescriptorAccessor() {
                a();
                ((MessageOptions) this.a).clearNoStandardDescriptorAccessor();
                return this;
            }

            public Builder clearUninterpretedOption() {
                a();
                ((MessageOptions) this.a).clearUninterpretedOption();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
            public boolean getDeprecated() {
                return ((MessageOptions) this.a).getDeprecated();
            }

            @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
            public boolean getMapEntry() {
                return ((MessageOptions) this.a).getMapEntry();
            }

            @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
            public boolean getMessageSetWireFormat() {
                return ((MessageOptions) this.a).getMessageSetWireFormat();
            }

            @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
            public boolean getNoStandardDescriptorAccessor() {
                return ((MessageOptions) this.a).getNoStandardDescriptorAccessor();
            }

            @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
            public UninterpretedOption getUninterpretedOption(int i) {
                return ((MessageOptions) this.a).getUninterpretedOption(i);
            }

            @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
            public int getUninterpretedOptionCount() {
                return ((MessageOptions) this.a).getUninterpretedOptionCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(((MessageOptions) this.a).getUninterpretedOptionList());
            }

            @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
            public boolean hasDeprecated() {
                return ((MessageOptions) this.a).hasDeprecated();
            }

            @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
            public boolean hasMapEntry() {
                return ((MessageOptions) this.a).hasMapEntry();
            }

            @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
            public boolean hasMessageSetWireFormat() {
                return ((MessageOptions) this.a).hasMessageSetWireFormat();
            }

            @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
            public boolean hasNoStandardDescriptorAccessor() {
                return ((MessageOptions) this.a).hasNoStandardDescriptorAccessor();
            }

            public Builder removeUninterpretedOption(int i) {
                a();
                ((MessageOptions) this.a).removeUninterpretedOption(i);
                return this;
            }

            public Builder setDeprecated(boolean z) {
                a();
                ((MessageOptions) this.a).setDeprecated(z);
                return this;
            }

            public Builder setMapEntry(boolean z) {
                a();
                ((MessageOptions) this.a).setMapEntry(z);
                return this;
            }

            public Builder setMessageSetWireFormat(boolean z) {
                a();
                ((MessageOptions) this.a).setMessageSetWireFormat(z);
                return this;
            }

            public Builder setNoStandardDescriptorAccessor(boolean z) {
                a();
                ((MessageOptions) this.a).setNoStandardDescriptorAccessor(z);
                return this;
            }

            public Builder setUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                a();
                ((MessageOptions) this.a).setUninterpretedOption(i, builder);
                return this;
            }

            public Builder setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                a();
                ((MessageOptions) this.a).setUninterpretedOption(i, uninterpretedOption);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private MessageOptions() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
            ensureUninterpretedOptionIsMutable();
            AbstractMessageLite.a(iterable, this.uninterpretedOption_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUninterpretedOption(int i, UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption == null) {
                throw new NullPointerException();
            }
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(i, uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption == null) {
                throw new NullPointerException();
            }
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDeprecated() {
            this.bitField0_ &= -5;
            this.deprecated_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMapEntry() {
            this.bitField0_ &= -9;
            this.mapEntry_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMessageSetWireFormat() {
            this.bitField0_ &= -2;
            this.messageSetWireFormat_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNoStandardDescriptorAccessor() {
            this.bitField0_ &= -3;
            this.noStandardDescriptorAccessor_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUninterpretedOption() {
            this.uninterpretedOption_ = GeneratedMessageLite.f();
        }

        private void ensureUninterpretedOptionIsMutable() {
            if (this.uninterpretedOption_.isModifiable()) {
                return;
            }
            this.uninterpretedOption_ = GeneratedMessageLite.a(this.uninterpretedOption_);
        }

        public static MessageOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static Builder newBuilder(MessageOptions messageOptions) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom((Builder) messageOptions);
        }

        public static MessageOptions parseDelimitedFrom(InputStream inputStream) {
            return (MessageOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static MessageOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (MessageOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MessageOptions parseFrom(ByteString byteString) {
            return (MessageOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static MessageOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (MessageOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static MessageOptions parseFrom(CodedInputStream codedInputStream) {
            return (MessageOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static MessageOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (MessageOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static MessageOptions parseFrom(InputStream inputStream) {
            return (MessageOptions) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static MessageOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (MessageOptions) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MessageOptions parseFrom(byte[] bArr) {
            return (MessageOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static MessageOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (MessageOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<MessageOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeUninterpretedOption(int i) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDeprecated(boolean z) {
            this.bitField0_ |= 4;
            this.deprecated_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMapEntry(boolean z) {
            this.bitField0_ |= 8;
            this.mapEntry_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMessageSetWireFormat(boolean z) {
            this.bitField0_ |= 1;
            this.messageSetWireFormat_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNoStandardDescriptorAccessor(boolean z) {
            this.bitField0_ |= 2;
            this.noStandardDescriptorAccessor_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUninterpretedOption(int i, UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption == null) {
                throw new NullPointerException();
            }
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(i, uninterpretedOption);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new MessageOptions();
                case 2:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i = 0; i < getUninterpretedOptionCount(); i++) {
                        if (!getUninterpretedOption(i).isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = (byte) 0;
                            }
                            return null;
                        }
                    }
                    if (g()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = (byte) 1;
                        }
                        return DEFAULT_INSTANCE;
                    }
                    if (booleanValue) {
                        this.memoizedIsInitialized = (byte) 0;
                    }
                    return null;
                case 3:
                    this.uninterpretedOption_.makeImmutable();
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    MessageOptions messageOptions = (MessageOptions) obj2;
                    this.messageSetWireFormat_ = visitor.visitBoolean(hasMessageSetWireFormat(), this.messageSetWireFormat_, messageOptions.hasMessageSetWireFormat(), messageOptions.messageSetWireFormat_);
                    this.noStandardDescriptorAccessor_ = visitor.visitBoolean(hasNoStandardDescriptorAccessor(), this.noStandardDescriptorAccessor_, messageOptions.hasNoStandardDescriptorAccessor(), messageOptions.noStandardDescriptorAccessor_);
                    this.deprecated_ = visitor.visitBoolean(hasDeprecated(), this.deprecated_, messageOptions.hasDeprecated(), messageOptions.deprecated_);
                    this.mapEntry_ = visitor.visitBoolean(hasMapEntry(), this.mapEntry_, messageOptions.hasMapEntry(), messageOptions.mapEntry_);
                    this.uninterpretedOption_ = visitor.visitList(this.uninterpretedOption_, messageOptions.uninterpretedOption_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= messageOptions.bitField0_;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            try {
                                int readTag = codedInputStream.readTag();
                                if (readTag != 0) {
                                    if (readTag == 8) {
                                        this.bitField0_ |= 1;
                                        this.messageSetWireFormat_ = codedInputStream.readBool();
                                    } else if (readTag == 16) {
                                        this.bitField0_ |= 2;
                                        this.noStandardDescriptorAccessor_ = codedInputStream.readBool();
                                    } else if (readTag == 24) {
                                        this.bitField0_ |= 4;
                                        this.deprecated_ = codedInputStream.readBool();
                                    } else if (readTag == 56) {
                                        this.bitField0_ |= 8;
                                        this.mapEntry_ = codedInputStream.readBool();
                                    } else if (readTag == 7994) {
                                        if (!this.uninterpretedOption_.isModifiable()) {
                                            this.uninterpretedOption_ = GeneratedMessageLite.a(this.uninterpretedOption_);
                                        }
                                        this.uninterpretedOption_.add((UninterpretedOption) codedInputStream.readMessage(UninterpretedOption.parser(), extensionRegistryLite));
                                    } else if (!a((MessageOptions) getDefaultInstanceForType(), codedInputStream, extensionRegistryLite, readTag)) {
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
                        synchronized (MessageOptions.class) {
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

        @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
        public boolean getDeprecated() {
            return this.deprecated_;
        }

        @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
        public boolean getMapEntry() {
            return this.mapEntry_;
        }

        @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
        public boolean getMessageSetWireFormat() {
            return this.messageSetWireFormat_;
        }

        @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
        public boolean getNoStandardDescriptorAccessor() {
            return this.noStandardDescriptorAccessor_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeBoolSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeBoolSize(1, this.messageSetWireFormat_) + 0 : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeBoolSize += CodedOutputStream.computeBoolSize(2, this.noStandardDescriptorAccessor_);
            }
            if ((this.bitField0_ & 4) == 4) {
                computeBoolSize += CodedOutputStream.computeBoolSize(3, this.deprecated_);
            }
            if ((this.bitField0_ & 8) == 8) {
                computeBoolSize += CodedOutputStream.computeBoolSize(7, this.mapEntry_);
            }
            for (int i2 = 0; i2 < this.uninterpretedOption_.size(); i2++) {
                computeBoolSize += CodedOutputStream.computeMessageSize(999, this.uninterpretedOption_.get(i2));
            }
            int h = computeBoolSize + h() + this.b.getSerializedSize();
            this.c = h;
            return h;
        }

        @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
        public UninterpretedOption getUninterpretedOption(int i) {
            return this.uninterpretedOption_.get(i);
        }

        @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i) {
            return this.uninterpretedOption_.get(i);
        }

        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
        public boolean hasDeprecated() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
        public boolean hasMapEntry() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
        public boolean hasMessageSetWireFormat() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
        public boolean hasNoStandardDescriptorAccessor() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            GeneratedMessageLite.ExtendableMessage<MessageType, BuilderType>.ExtensionWriter i = i();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeBool(1, this.messageSetWireFormat_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBool(2, this.noStandardDescriptorAccessor_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeBool(3, this.deprecated_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeBool(7, this.mapEntry_);
            }
            for (int i2 = 0; i2 < this.uninterpretedOption_.size(); i2++) {
                codedOutputStream.writeMessage(999, this.uninterpretedOption_.get(i2));
            }
            i.writeUntil(536870912, codedOutputStream);
            this.b.writeTo(codedOutputStream);
        }
    }

    /* loaded from: classes2.dex */
    public interface MessageOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<MessageOptions, MessageOptions.Builder> {
        boolean getDeprecated();

        boolean getMapEntry();

        boolean getMessageSetWireFormat();

        boolean getNoStandardDescriptorAccessor();

        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        boolean hasDeprecated();

        boolean hasMapEntry();

        boolean hasMessageSetWireFormat();

        boolean hasNoStandardDescriptorAccessor();
    }

    /* loaded from: classes2.dex */
    public static final class MethodDescriptorProto extends GeneratedMessageLite<MethodDescriptorProto, Builder> implements MethodDescriptorProtoOrBuilder {
        public static final int CLIENT_STREAMING_FIELD_NUMBER = 5;
        private static final MethodDescriptorProto DEFAULT_INSTANCE = new MethodDescriptorProto();
        public static final int INPUT_TYPE_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 4;
        public static final int OUTPUT_TYPE_FIELD_NUMBER = 3;
        private static volatile Parser<MethodDescriptorProto> PARSER = null;
        public static final int SERVER_STREAMING_FIELD_NUMBER = 6;
        private int bitField0_;
        private boolean clientStreaming_;
        private MethodOptions options_;
        private boolean serverStreaming_;
        private byte memoizedIsInitialized = -1;
        private String name_ = "";
        private String inputType_ = "";
        private String outputType_ = "";

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<MethodDescriptorProto, Builder> implements MethodDescriptorProtoOrBuilder {
            private Builder() {
                super(MethodDescriptorProto.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearClientStreaming() {
                a();
                ((MethodDescriptorProto) this.a).clearClientStreaming();
                return this;
            }

            public Builder clearInputType() {
                a();
                ((MethodDescriptorProto) this.a).clearInputType();
                return this;
            }

            public Builder clearName() {
                a();
                ((MethodDescriptorProto) this.a).clearName();
                return this;
            }

            public Builder clearOptions() {
                a();
                ((MethodDescriptorProto) this.a).clearOptions();
                return this;
            }

            public Builder clearOutputType() {
                a();
                ((MethodDescriptorProto) this.a).clearOutputType();
                return this;
            }

            public Builder clearServerStreaming() {
                a();
                ((MethodDescriptorProto) this.a).clearServerStreaming();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public boolean getClientStreaming() {
                return ((MethodDescriptorProto) this.a).getClientStreaming();
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public String getInputType() {
                return ((MethodDescriptorProto) this.a).getInputType();
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public ByteString getInputTypeBytes() {
                return ((MethodDescriptorProto) this.a).getInputTypeBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public String getName() {
                return ((MethodDescriptorProto) this.a).getName();
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public ByteString getNameBytes() {
                return ((MethodDescriptorProto) this.a).getNameBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public MethodOptions getOptions() {
                return ((MethodDescriptorProto) this.a).getOptions();
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public String getOutputType() {
                return ((MethodDescriptorProto) this.a).getOutputType();
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public ByteString getOutputTypeBytes() {
                return ((MethodDescriptorProto) this.a).getOutputTypeBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public boolean getServerStreaming() {
                return ((MethodDescriptorProto) this.a).getServerStreaming();
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public boolean hasClientStreaming() {
                return ((MethodDescriptorProto) this.a).hasClientStreaming();
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public boolean hasInputType() {
                return ((MethodDescriptorProto) this.a).hasInputType();
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public boolean hasName() {
                return ((MethodDescriptorProto) this.a).hasName();
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public boolean hasOptions() {
                return ((MethodDescriptorProto) this.a).hasOptions();
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public boolean hasOutputType() {
                return ((MethodDescriptorProto) this.a).hasOutputType();
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public boolean hasServerStreaming() {
                return ((MethodDescriptorProto) this.a).hasServerStreaming();
            }

            public Builder mergeOptions(MethodOptions methodOptions) {
                a();
                ((MethodDescriptorProto) this.a).mergeOptions(methodOptions);
                return this;
            }

            public Builder setClientStreaming(boolean z) {
                a();
                ((MethodDescriptorProto) this.a).setClientStreaming(z);
                return this;
            }

            public Builder setInputType(String str) {
                a();
                ((MethodDescriptorProto) this.a).setInputType(str);
                return this;
            }

            public Builder setInputTypeBytes(ByteString byteString) {
                a();
                ((MethodDescriptorProto) this.a).setInputTypeBytes(byteString);
                return this;
            }

            public Builder setName(String str) {
                a();
                ((MethodDescriptorProto) this.a).setName(str);
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                a();
                ((MethodDescriptorProto) this.a).setNameBytes(byteString);
                return this;
            }

            public Builder setOptions(MethodOptions.Builder builder) {
                a();
                ((MethodDescriptorProto) this.a).setOptions(builder);
                return this;
            }

            public Builder setOptions(MethodOptions methodOptions) {
                a();
                ((MethodDescriptorProto) this.a).setOptions(methodOptions);
                return this;
            }

            public Builder setOutputType(String str) {
                a();
                ((MethodDescriptorProto) this.a).setOutputType(str);
                return this;
            }

            public Builder setOutputTypeBytes(ByteString byteString) {
                a();
                ((MethodDescriptorProto) this.a).setOutputTypeBytes(byteString);
                return this;
            }

            public Builder setServerStreaming(boolean z) {
                a();
                ((MethodDescriptorProto) this.a).setServerStreaming(z);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private MethodDescriptorProto() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearClientStreaming() {
            this.bitField0_ &= -17;
            this.clientStreaming_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearInputType() {
            this.bitField0_ &= -3;
            this.inputType_ = getDefaultInstance().getInputType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearName() {
            this.bitField0_ &= -2;
            this.name_ = getDefaultInstance().getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOptions() {
            this.options_ = null;
            this.bitField0_ &= -9;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOutputType() {
            this.bitField0_ &= -5;
            this.outputType_ = getDefaultInstance().getOutputType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearServerStreaming() {
            this.bitField0_ &= -33;
            this.serverStreaming_ = false;
        }

        public static MethodDescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public void mergeOptions(MethodOptions methodOptions) {
            MethodOptions methodOptions2 = this.options_;
            if (methodOptions2 != null && methodOptions2 != MethodOptions.getDefaultInstance()) {
                methodOptions = ((MethodOptions.Builder) MethodOptions.newBuilder(this.options_).mergeFrom((MethodOptions.Builder) methodOptions)).buildPartial();
            }
            this.options_ = methodOptions;
            this.bitField0_ |= 8;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MethodDescriptorProto methodDescriptorProto) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) methodDescriptorProto);
        }

        public static MethodDescriptorProto parseDelimitedFrom(InputStream inputStream) {
            return (MethodDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static MethodDescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (MethodDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MethodDescriptorProto parseFrom(ByteString byteString) {
            return (MethodDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static MethodDescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (MethodDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static MethodDescriptorProto parseFrom(CodedInputStream codedInputStream) {
            return (MethodDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static MethodDescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (MethodDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static MethodDescriptorProto parseFrom(InputStream inputStream) {
            return (MethodDescriptorProto) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static MethodDescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (MethodDescriptorProto) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MethodDescriptorProto parseFrom(byte[] bArr) {
            return (MethodDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static MethodDescriptorProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (MethodDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<MethodDescriptorProto> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClientStreaming(boolean z) {
            this.bitField0_ |= 16;
            this.clientStreaming_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setInputType(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 2;
            this.inputType_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setInputTypeBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 2;
            this.inputType_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setName(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 1;
            this.name_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNameBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 1;
            this.name_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public void setOptions(MethodOptions.Builder builder) {
            this.options_ = (MethodOptions) builder.build();
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOptions(MethodOptions methodOptions) {
            if (methodOptions == null) {
                throw new NullPointerException();
            }
            this.options_ = methodOptions;
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOutputType(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 4;
            this.outputType_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOutputTypeBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 4;
            this.outputType_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setServerStreaming(boolean z) {
            this.bitField0_ |= 32;
            this.serverStreaming_ = z;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new MethodDescriptorProto();
                case 2:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    if (!hasOptions() || getOptions().isInitialized()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = (byte) 1;
                        }
                        return DEFAULT_INSTANCE;
                    }
                    if (booleanValue) {
                        this.memoizedIsInitialized = (byte) 0;
                    }
                    return null;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    MethodDescriptorProto methodDescriptorProto = (MethodDescriptorProto) obj2;
                    this.name_ = visitor.visitString(hasName(), this.name_, methodDescriptorProto.hasName(), methodDescriptorProto.name_);
                    this.inputType_ = visitor.visitString(hasInputType(), this.inputType_, methodDescriptorProto.hasInputType(), methodDescriptorProto.inputType_);
                    this.outputType_ = visitor.visitString(hasOutputType(), this.outputType_, methodDescriptorProto.hasOutputType(), methodDescriptorProto.outputType_);
                    this.options_ = (MethodOptions) visitor.visitMessage(this.options_, methodDescriptorProto.options_);
                    this.clientStreaming_ = visitor.visitBoolean(hasClientStreaming(), this.clientStreaming_, methodDescriptorProto.hasClientStreaming(), methodDescriptorProto.clientStreaming_);
                    this.serverStreaming_ = visitor.visitBoolean(hasServerStreaming(), this.serverStreaming_, methodDescriptorProto.hasServerStreaming(), methodDescriptorProto.serverStreaming_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= methodDescriptorProto.bitField0_;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            try {
                                int readTag = codedInputStream.readTag();
                                if (readTag != 0) {
                                    if (readTag == 10) {
                                        String readString = codedInputStream.readString();
                                        this.bitField0_ |= 1;
                                        this.name_ = readString;
                                    } else if (readTag == 18) {
                                        String readString2 = codedInputStream.readString();
                                        this.bitField0_ |= 2;
                                        this.inputType_ = readString2;
                                    } else if (readTag == 26) {
                                        String readString3 = codedInputStream.readString();
                                        this.bitField0_ |= 4;
                                        this.outputType_ = readString3;
                                    } else if (readTag == 34) {
                                        MethodOptions.Builder builder = (this.bitField0_ & 8) == 8 ? (MethodOptions.Builder) this.options_.toBuilder() : null;
                                        this.options_ = (MethodOptions) codedInputStream.readMessage(MethodOptions.parser(), extensionRegistryLite);
                                        if (builder != null) {
                                            builder.mergeFrom((MethodOptions.Builder) this.options_);
                                            this.options_ = builder.buildPartial();
                                        }
                                        this.bitField0_ |= 8;
                                    } else if (readTag == 40) {
                                        this.bitField0_ |= 16;
                                        this.clientStreaming_ = codedInputStream.readBool();
                                    } else if (readTag == 48) {
                                        this.bitField0_ |= 32;
                                        this.serverStreaming_ = codedInputStream.readBool();
                                    } else if (!a(readTag, codedInputStream)) {
                                    }
                                }
                                z = true;
                            } catch (IOException e) {
                                throw new RuntimeException(new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this));
                            }
                        } catch (InvalidProtocolBufferException e2) {
                            throw new RuntimeException(e2.setUnfinishedMessage(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (PARSER == null) {
                        synchronized (MethodDescriptorProto.class) {
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

        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public boolean getClientStreaming() {
            return this.clientStreaming_;
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public String getInputType() {
            return this.inputType_;
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public ByteString getInputTypeBytes() {
            return ByteString.copyFromUtf8(this.inputType_);
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public String getName() {
            return this.name_;
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public MethodOptions getOptions() {
            MethodOptions methodOptions = this.options_;
            return methodOptions == null ? MethodOptions.getDefaultInstance() : methodOptions;
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public String getOutputType() {
            return this.outputType_;
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public ByteString getOutputTypeBytes() {
            return ByteString.copyFromUtf8(this.outputType_);
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeStringSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeStringSize(1, getName()) : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeStringSize += CodedOutputStream.computeStringSize(2, getInputType());
            }
            if ((this.bitField0_ & 4) == 4) {
                computeStringSize += CodedOutputStream.computeStringSize(3, getOutputType());
            }
            if ((this.bitField0_ & 8) == 8) {
                computeStringSize += CodedOutputStream.computeMessageSize(4, getOptions());
            }
            if ((this.bitField0_ & 16) == 16) {
                computeStringSize += CodedOutputStream.computeBoolSize(5, this.clientStreaming_);
            }
            if ((this.bitField0_ & 32) == 32) {
                computeStringSize += CodedOutputStream.computeBoolSize(6, this.serverStreaming_);
            }
            int serializedSize = computeStringSize + this.b.getSerializedSize();
            this.c = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public boolean getServerStreaming() {
            return this.serverStreaming_;
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public boolean hasClientStreaming() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public boolean hasInputType() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public boolean hasOptions() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public boolean hasOutputType() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public boolean hasServerStreaming() {
            return (this.bitField0_ & 32) == 32;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeString(1, getName());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeString(2, getInputType());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeString(3, getOutputType());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeMessage(4, getOptions());
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeBool(5, this.clientStreaming_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeBool(6, this.serverStreaming_);
            }
            this.b.writeTo(codedOutputStream);
        }
    }

    /* loaded from: classes2.dex */
    public interface MethodDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
        boolean getClientStreaming();

        String getInputType();

        ByteString getInputTypeBytes();

        String getName();

        ByteString getNameBytes();

        MethodOptions getOptions();

        String getOutputType();

        ByteString getOutputTypeBytes();

        boolean getServerStreaming();

        boolean hasClientStreaming();

        boolean hasInputType();

        boolean hasName();

        boolean hasOptions();

        boolean hasOutputType();

        boolean hasServerStreaming();
    }

    /* loaded from: classes2.dex */
    public static final class MethodOptions extends GeneratedMessageLite.ExtendableMessage<MethodOptions, Builder> implements MethodOptionsOrBuilder {
        private static final MethodOptions DEFAULT_INSTANCE = new MethodOptions();
        public static final int DEPRECATED_FIELD_NUMBER = 33;
        public static final int IDEMPOTENCY_LEVEL_FIELD_NUMBER = 34;
        private static volatile Parser<MethodOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private int bitField0_;
        private boolean deprecated_;
        private int idempotencyLevel_;
        private byte memoizedIsInitialized = -1;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = GeneratedMessageLite.f();

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<MethodOptions, Builder> implements MethodOptionsOrBuilder {
            private Builder() {
                super(MethodOptions.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
                a();
                ((MethodOptions) this.a).addAllUninterpretedOption(iterable);
                return this;
            }

            public Builder addUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                a();
                ((MethodOptions) this.a).addUninterpretedOption(i, builder);
                return this;
            }

            public Builder addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                a();
                ((MethodOptions) this.a).addUninterpretedOption(i, uninterpretedOption);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption.Builder builder) {
                a();
                ((MethodOptions) this.a).addUninterpretedOption(builder);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption uninterpretedOption) {
                a();
                ((MethodOptions) this.a).addUninterpretedOption(uninterpretedOption);
                return this;
            }

            public Builder clearDeprecated() {
                a();
                ((MethodOptions) this.a).clearDeprecated();
                return this;
            }

            public Builder clearIdempotencyLevel() {
                a();
                ((MethodOptions) this.a).clearIdempotencyLevel();
                return this;
            }

            public Builder clearUninterpretedOption() {
                a();
                ((MethodOptions) this.a).clearUninterpretedOption();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
            public boolean getDeprecated() {
                return ((MethodOptions) this.a).getDeprecated();
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
            public IdempotencyLevel getIdempotencyLevel() {
                return ((MethodOptions) this.a).getIdempotencyLevel();
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
            public UninterpretedOption getUninterpretedOption(int i) {
                return ((MethodOptions) this.a).getUninterpretedOption(i);
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
            public int getUninterpretedOptionCount() {
                return ((MethodOptions) this.a).getUninterpretedOptionCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(((MethodOptions) this.a).getUninterpretedOptionList());
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
            public boolean hasDeprecated() {
                return ((MethodOptions) this.a).hasDeprecated();
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
            public boolean hasIdempotencyLevel() {
                return ((MethodOptions) this.a).hasIdempotencyLevel();
            }

            public Builder removeUninterpretedOption(int i) {
                a();
                ((MethodOptions) this.a).removeUninterpretedOption(i);
                return this;
            }

            public Builder setDeprecated(boolean z) {
                a();
                ((MethodOptions) this.a).setDeprecated(z);
                return this;
            }

            public Builder setIdempotencyLevel(IdempotencyLevel idempotencyLevel) {
                a();
                ((MethodOptions) this.a).setIdempotencyLevel(idempotencyLevel);
                return this;
            }

            public Builder setUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                a();
                ((MethodOptions) this.a).setUninterpretedOption(i, builder);
                return this;
            }

            public Builder setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                a();
                ((MethodOptions) this.a).setUninterpretedOption(i, uninterpretedOption);
                return this;
            }
        }

        /* loaded from: classes2.dex */
        public enum IdempotencyLevel implements Internal.EnumLite {
            IDEMPOTENCY_UNKNOWN(0),
            NO_SIDE_EFFECTS(1),
            IDEMPOTENT(2);

            public static final int IDEMPOTENCY_UNKNOWN_VALUE = 0;
            public static final int IDEMPOTENT_VALUE = 2;
            public static final int NO_SIDE_EFFECTS_VALUE = 1;
            private static final Internal.EnumLiteMap<IdempotencyLevel> internalValueMap = new Internal.EnumLiteMap<IdempotencyLevel>() { // from class: com.google.protobuf.DescriptorProtos.MethodOptions.IdempotencyLevel.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public IdempotencyLevel findValueByNumber(int i) {
                    return IdempotencyLevel.forNumber(i);
                }
            };
            private final int value;

            IdempotencyLevel(int i) {
                this.value = i;
            }

            public static IdempotencyLevel forNumber(int i) {
                if (i == 0) {
                    return IDEMPOTENCY_UNKNOWN;
                }
                if (i == 1) {
                    return NO_SIDE_EFFECTS;
                }
                if (i != 2) {
                    return null;
                }
                return IDEMPOTENT;
            }

            public static Internal.EnumLiteMap<IdempotencyLevel> internalGetValueMap() {
                return internalValueMap;
            }

            @Deprecated
            public static IdempotencyLevel valueOf(int i) {
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

        private MethodOptions() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
            ensureUninterpretedOptionIsMutable();
            AbstractMessageLite.a(iterable, this.uninterpretedOption_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUninterpretedOption(int i, UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption == null) {
                throw new NullPointerException();
            }
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(i, uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption == null) {
                throw new NullPointerException();
            }
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDeprecated() {
            this.bitField0_ &= -2;
            this.deprecated_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIdempotencyLevel() {
            this.bitField0_ &= -3;
            this.idempotencyLevel_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUninterpretedOption() {
            this.uninterpretedOption_ = GeneratedMessageLite.f();
        }

        private void ensureUninterpretedOptionIsMutable() {
            if (this.uninterpretedOption_.isModifiable()) {
                return;
            }
            this.uninterpretedOption_ = GeneratedMessageLite.a(this.uninterpretedOption_);
        }

        public static MethodOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static Builder newBuilder(MethodOptions methodOptions) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom((Builder) methodOptions);
        }

        public static MethodOptions parseDelimitedFrom(InputStream inputStream) {
            return (MethodOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static MethodOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (MethodOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MethodOptions parseFrom(ByteString byteString) {
            return (MethodOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static MethodOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (MethodOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static MethodOptions parseFrom(CodedInputStream codedInputStream) {
            return (MethodOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static MethodOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (MethodOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static MethodOptions parseFrom(InputStream inputStream) {
            return (MethodOptions) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static MethodOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (MethodOptions) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MethodOptions parseFrom(byte[] bArr) {
            return (MethodOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static MethodOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (MethodOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<MethodOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeUninterpretedOption(int i) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDeprecated(boolean z) {
            this.bitField0_ |= 1;
            this.deprecated_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIdempotencyLevel(IdempotencyLevel idempotencyLevel) {
            if (idempotencyLevel == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 2;
            this.idempotencyLevel_ = idempotencyLevel.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUninterpretedOption(int i, UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption == null) {
                throw new NullPointerException();
            }
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(i, uninterpretedOption);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new MethodOptions();
                case 2:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i = 0; i < getUninterpretedOptionCount(); i++) {
                        if (!getUninterpretedOption(i).isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = (byte) 0;
                            }
                            return null;
                        }
                    }
                    if (g()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = (byte) 1;
                        }
                        return DEFAULT_INSTANCE;
                    }
                    if (booleanValue) {
                        this.memoizedIsInitialized = (byte) 0;
                    }
                    return null;
                case 3:
                    this.uninterpretedOption_.makeImmutable();
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    MethodOptions methodOptions = (MethodOptions) obj2;
                    this.deprecated_ = visitor.visitBoolean(hasDeprecated(), this.deprecated_, methodOptions.hasDeprecated(), methodOptions.deprecated_);
                    this.idempotencyLevel_ = visitor.visitInt(hasIdempotencyLevel(), this.idempotencyLevel_, methodOptions.hasIdempotencyLevel(), methodOptions.idempotencyLevel_);
                    this.uninterpretedOption_ = visitor.visitList(this.uninterpretedOption_, methodOptions.uninterpretedOption_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= methodOptions.bitField0_;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 264) {
                                    this.bitField0_ |= 1;
                                    this.deprecated_ = codedInputStream.readBool();
                                } else if (readTag == 272) {
                                    int readEnum = codedInputStream.readEnum();
                                    if (IdempotencyLevel.forNumber(readEnum) == null) {
                                        super.a(34, readEnum);
                                    } else {
                                        this.bitField0_ |= 2;
                                        this.idempotencyLevel_ = readEnum;
                                    }
                                } else if (readTag == 7994) {
                                    if (!this.uninterpretedOption_.isModifiable()) {
                                        this.uninterpretedOption_ = GeneratedMessageLite.a(this.uninterpretedOption_);
                                    }
                                    this.uninterpretedOption_.add((UninterpretedOption) codedInputStream.readMessage(UninterpretedOption.parser(), extensionRegistryLite));
                                } else if (!a((MethodOptions) getDefaultInstanceForType(), codedInputStream, extensionRegistryLite, readTag)) {
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
                        synchronized (MethodOptions.class) {
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

        @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
        public boolean getDeprecated() {
            return this.deprecated_;
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
        public IdempotencyLevel getIdempotencyLevel() {
            IdempotencyLevel forNumber = IdempotencyLevel.forNumber(this.idempotencyLevel_);
            return forNumber == null ? IdempotencyLevel.IDEMPOTENCY_UNKNOWN : forNumber;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeBoolSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeBoolSize(33, this.deprecated_) + 0 : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeBoolSize += CodedOutputStream.computeEnumSize(34, this.idempotencyLevel_);
            }
            for (int i2 = 0; i2 < this.uninterpretedOption_.size(); i2++) {
                computeBoolSize += CodedOutputStream.computeMessageSize(999, this.uninterpretedOption_.get(i2));
            }
            int h = computeBoolSize + h() + this.b.getSerializedSize();
            this.c = h;
            return h;
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
        public UninterpretedOption getUninterpretedOption(int i) {
            return this.uninterpretedOption_.get(i);
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i) {
            return this.uninterpretedOption_.get(i);
        }

        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
        public boolean hasDeprecated() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
        public boolean hasIdempotencyLevel() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            GeneratedMessageLite.ExtendableMessage<MessageType, BuilderType>.ExtensionWriter i = i();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeBool(33, this.deprecated_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeEnum(34, this.idempotencyLevel_);
            }
            for (int i2 = 0; i2 < this.uninterpretedOption_.size(); i2++) {
                codedOutputStream.writeMessage(999, this.uninterpretedOption_.get(i2));
            }
            i.writeUntil(536870912, codedOutputStream);
            this.b.writeTo(codedOutputStream);
        }
    }

    /* loaded from: classes2.dex */
    public interface MethodOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<MethodOptions, MethodOptions.Builder> {
        boolean getDeprecated();

        MethodOptions.IdempotencyLevel getIdempotencyLevel();

        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        boolean hasDeprecated();

        boolean hasIdempotencyLevel();
    }

    /* loaded from: classes2.dex */
    public static final class OneofDescriptorProto extends GeneratedMessageLite<OneofDescriptorProto, Builder> implements OneofDescriptorProtoOrBuilder {
        private static final OneofDescriptorProto DEFAULT_INSTANCE = new OneofDescriptorProto();
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 2;
        private static volatile Parser<OneofDescriptorProto> PARSER;
        private int bitField0_;
        private byte memoizedIsInitialized = -1;
        private String name_ = "";
        private OneofOptions options_;

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<OneofDescriptorProto, Builder> implements OneofDescriptorProtoOrBuilder {
            private Builder() {
                super(OneofDescriptorProto.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearName() {
                a();
                ((OneofDescriptorProto) this.a).clearName();
                return this;
            }

            public Builder clearOptions() {
                a();
                ((OneofDescriptorProto) this.a).clearOptions();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.OneofDescriptorProtoOrBuilder
            public String getName() {
                return ((OneofDescriptorProto) this.a).getName();
            }

            @Override // com.google.protobuf.DescriptorProtos.OneofDescriptorProtoOrBuilder
            public ByteString getNameBytes() {
                return ((OneofDescriptorProto) this.a).getNameBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.OneofDescriptorProtoOrBuilder
            public OneofOptions getOptions() {
                return ((OneofDescriptorProto) this.a).getOptions();
            }

            @Override // com.google.protobuf.DescriptorProtos.OneofDescriptorProtoOrBuilder
            public boolean hasName() {
                return ((OneofDescriptorProto) this.a).hasName();
            }

            @Override // com.google.protobuf.DescriptorProtos.OneofDescriptorProtoOrBuilder
            public boolean hasOptions() {
                return ((OneofDescriptorProto) this.a).hasOptions();
            }

            public Builder mergeOptions(OneofOptions oneofOptions) {
                a();
                ((OneofDescriptorProto) this.a).mergeOptions(oneofOptions);
                return this;
            }

            public Builder setName(String str) {
                a();
                ((OneofDescriptorProto) this.a).setName(str);
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                a();
                ((OneofDescriptorProto) this.a).setNameBytes(byteString);
                return this;
            }

            public Builder setOptions(OneofOptions.Builder builder) {
                a();
                ((OneofDescriptorProto) this.a).setOptions(builder);
                return this;
            }

            public Builder setOptions(OneofOptions oneofOptions) {
                a();
                ((OneofDescriptorProto) this.a).setOptions(oneofOptions);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private OneofDescriptorProto() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearName() {
            this.bitField0_ &= -2;
            this.name_ = getDefaultInstance().getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOptions() {
            this.options_ = null;
            this.bitField0_ &= -3;
        }

        public static OneofDescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public void mergeOptions(OneofOptions oneofOptions) {
            OneofOptions oneofOptions2 = this.options_;
            if (oneofOptions2 != null && oneofOptions2 != OneofOptions.getDefaultInstance()) {
                oneofOptions = ((OneofOptions.Builder) OneofOptions.newBuilder(this.options_).mergeFrom((OneofOptions.Builder) oneofOptions)).buildPartial();
            }
            this.options_ = oneofOptions;
            this.bitField0_ |= 2;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(OneofDescriptorProto oneofDescriptorProto) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) oneofDescriptorProto);
        }

        public static OneofDescriptorProto parseDelimitedFrom(InputStream inputStream) {
            return (OneofDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static OneofDescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (OneofDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static OneofDescriptorProto parseFrom(ByteString byteString) {
            return (OneofDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static OneofDescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (OneofDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static OneofDescriptorProto parseFrom(CodedInputStream codedInputStream) {
            return (OneofDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static OneofDescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (OneofDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static OneofDescriptorProto parseFrom(InputStream inputStream) {
            return (OneofDescriptorProto) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static OneofDescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (OneofDescriptorProto) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static OneofDescriptorProto parseFrom(byte[] bArr) {
            return (OneofDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static OneofDescriptorProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (OneofDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<OneofDescriptorProto> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setName(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 1;
            this.name_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNameBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 1;
            this.name_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public void setOptions(OneofOptions.Builder builder) {
            this.options_ = (OneofOptions) builder.build();
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOptions(OneofOptions oneofOptions) {
            if (oneofOptions == null) {
                throw new NullPointerException();
            }
            this.options_ = oneofOptions;
            this.bitField0_ |= 2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new OneofDescriptorProto();
                case 2:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    if (!hasOptions() || getOptions().isInitialized()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = (byte) 1;
                        }
                        return DEFAULT_INSTANCE;
                    }
                    if (booleanValue) {
                        this.memoizedIsInitialized = (byte) 0;
                    }
                    return null;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    OneofDescriptorProto oneofDescriptorProto = (OneofDescriptorProto) obj2;
                    this.name_ = visitor.visitString(hasName(), this.name_, oneofDescriptorProto.hasName(), oneofDescriptorProto.name_);
                    this.options_ = (OneofOptions) visitor.visitMessage(this.options_, oneofDescriptorProto.options_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= oneofDescriptorProto.bitField0_;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    String readString = codedInputStream.readString();
                                    this.bitField0_ |= 1;
                                    this.name_ = readString;
                                } else if (readTag == 18) {
                                    OneofOptions.Builder builder = (this.bitField0_ & 2) == 2 ? (OneofOptions.Builder) this.options_.toBuilder() : null;
                                    this.options_ = (OneofOptions) codedInputStream.readMessage(OneofOptions.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom((OneofOptions.Builder) this.options_);
                                        this.options_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 2;
                                } else if (!a(readTag, codedInputStream)) {
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
                        synchronized (OneofDescriptorProto.class) {
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

        @Override // com.google.protobuf.DescriptorProtos.OneofDescriptorProtoOrBuilder
        public String getName() {
            return this.name_;
        }

        @Override // com.google.protobuf.DescriptorProtos.OneofDescriptorProtoOrBuilder
        public ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        @Override // com.google.protobuf.DescriptorProtos.OneofDescriptorProtoOrBuilder
        public OneofOptions getOptions() {
            OneofOptions oneofOptions = this.options_;
            return oneofOptions == null ? OneofOptions.getDefaultInstance() : oneofOptions;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeStringSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeStringSize(1, getName()) : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeStringSize += CodedOutputStream.computeMessageSize(2, getOptions());
            }
            int serializedSize = computeStringSize + this.b.getSerializedSize();
            this.c = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.DescriptorProtos.OneofDescriptorProtoOrBuilder
        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.google.protobuf.DescriptorProtos.OneofDescriptorProtoOrBuilder
        public boolean hasOptions() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeString(1, getName());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(2, getOptions());
            }
            this.b.writeTo(codedOutputStream);
        }
    }

    /* loaded from: classes2.dex */
    public interface OneofDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
        String getName();

        ByteString getNameBytes();

        OneofOptions getOptions();

        boolean hasName();

        boolean hasOptions();
    }

    /* loaded from: classes2.dex */
    public static final class OneofOptions extends GeneratedMessageLite.ExtendableMessage<OneofOptions, Builder> implements OneofOptionsOrBuilder {
        private static final OneofOptions DEFAULT_INSTANCE = new OneofOptions();
        private static volatile Parser<OneofOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private byte memoizedIsInitialized = -1;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = GeneratedMessageLite.f();

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<OneofOptions, Builder> implements OneofOptionsOrBuilder {
            private Builder() {
                super(OneofOptions.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
                a();
                ((OneofOptions) this.a).addAllUninterpretedOption(iterable);
                return this;
            }

            public Builder addUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                a();
                ((OneofOptions) this.a).addUninterpretedOption(i, builder);
                return this;
            }

            public Builder addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                a();
                ((OneofOptions) this.a).addUninterpretedOption(i, uninterpretedOption);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption.Builder builder) {
                a();
                ((OneofOptions) this.a).addUninterpretedOption(builder);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption uninterpretedOption) {
                a();
                ((OneofOptions) this.a).addUninterpretedOption(uninterpretedOption);
                return this;
            }

            public Builder clearUninterpretedOption() {
                a();
                ((OneofOptions) this.a).clearUninterpretedOption();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.OneofOptionsOrBuilder
            public UninterpretedOption getUninterpretedOption(int i) {
                return ((OneofOptions) this.a).getUninterpretedOption(i);
            }

            @Override // com.google.protobuf.DescriptorProtos.OneofOptionsOrBuilder
            public int getUninterpretedOptionCount() {
                return ((OneofOptions) this.a).getUninterpretedOptionCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.OneofOptionsOrBuilder
            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(((OneofOptions) this.a).getUninterpretedOptionList());
            }

            public Builder removeUninterpretedOption(int i) {
                a();
                ((OneofOptions) this.a).removeUninterpretedOption(i);
                return this;
            }

            public Builder setUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                a();
                ((OneofOptions) this.a).setUninterpretedOption(i, builder);
                return this;
            }

            public Builder setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                a();
                ((OneofOptions) this.a).setUninterpretedOption(i, uninterpretedOption);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private OneofOptions() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
            ensureUninterpretedOptionIsMutable();
            AbstractMessageLite.a(iterable, this.uninterpretedOption_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUninterpretedOption(int i, UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption == null) {
                throw new NullPointerException();
            }
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(i, uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption == null) {
                throw new NullPointerException();
            }
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUninterpretedOption() {
            this.uninterpretedOption_ = GeneratedMessageLite.f();
        }

        private void ensureUninterpretedOptionIsMutable() {
            if (this.uninterpretedOption_.isModifiable()) {
                return;
            }
            this.uninterpretedOption_ = GeneratedMessageLite.a(this.uninterpretedOption_);
        }

        public static OneofOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static Builder newBuilder(OneofOptions oneofOptions) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom((Builder) oneofOptions);
        }

        public static OneofOptions parseDelimitedFrom(InputStream inputStream) {
            return (OneofOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static OneofOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (OneofOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static OneofOptions parseFrom(ByteString byteString) {
            return (OneofOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static OneofOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (OneofOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static OneofOptions parseFrom(CodedInputStream codedInputStream) {
            return (OneofOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static OneofOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (OneofOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static OneofOptions parseFrom(InputStream inputStream) {
            return (OneofOptions) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static OneofOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (OneofOptions) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static OneofOptions parseFrom(byte[] bArr) {
            return (OneofOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static OneofOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (OneofOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<OneofOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeUninterpretedOption(int i) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUninterpretedOption(int i, UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption == null) {
                throw new NullPointerException();
            }
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(i, uninterpretedOption);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new OneofOptions();
                case 2:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i = 0; i < getUninterpretedOptionCount(); i++) {
                        if (!getUninterpretedOption(i).isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = (byte) 0;
                            }
                            return null;
                        }
                    }
                    if (g()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = (byte) 1;
                        }
                        return DEFAULT_INSTANCE;
                    }
                    if (booleanValue) {
                        this.memoizedIsInitialized = (byte) 0;
                    }
                    return null;
                case 3:
                    this.uninterpretedOption_.makeImmutable();
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    this.uninterpretedOption_ = ((GeneratedMessageLite.Visitor) obj).visitList(this.uninterpretedOption_, ((OneofOptions) obj2).uninterpretedOption_);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 7994) {
                                    if (!this.uninterpretedOption_.isModifiable()) {
                                        this.uninterpretedOption_ = GeneratedMessageLite.a(this.uninterpretedOption_);
                                    }
                                    this.uninterpretedOption_.add((UninterpretedOption) codedInputStream.readMessage(UninterpretedOption.parser(), extensionRegistryLite));
                                } else if (!a((OneofOptions) getDefaultInstanceForType(), codedInputStream, extensionRegistryLite, readTag)) {
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
                        synchronized (OneofOptions.class) {
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

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.uninterpretedOption_.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(999, this.uninterpretedOption_.get(i3));
            }
            int h = i2 + h() + this.b.getSerializedSize();
            this.c = h;
            return h;
        }

        @Override // com.google.protobuf.DescriptorProtos.OneofOptionsOrBuilder
        public UninterpretedOption getUninterpretedOption(int i) {
            return this.uninterpretedOption_.get(i);
        }

        @Override // com.google.protobuf.DescriptorProtos.OneofOptionsOrBuilder
        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.OneofOptionsOrBuilder
        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i) {
            return this.uninterpretedOption_.get(i);
        }

        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            GeneratedMessageLite.ExtendableMessage<MessageType, BuilderType>.ExtensionWriter i = i();
            for (int i2 = 0; i2 < this.uninterpretedOption_.size(); i2++) {
                codedOutputStream.writeMessage(999, this.uninterpretedOption_.get(i2));
            }
            i.writeUntil(536870912, codedOutputStream);
            this.b.writeTo(codedOutputStream);
        }
    }

    /* loaded from: classes2.dex */
    public interface OneofOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<OneofOptions, OneofOptions.Builder> {
        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();
    }

    /* loaded from: classes2.dex */
    public static final class ServiceDescriptorProto extends GeneratedMessageLite<ServiceDescriptorProto, Builder> implements ServiceDescriptorProtoOrBuilder {
        private static final ServiceDescriptorProto DEFAULT_INSTANCE = new ServiceDescriptorProto();
        public static final int METHOD_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 3;
        private static volatile Parser<ServiceDescriptorProto> PARSER;
        private int bitField0_;
        private ServiceOptions options_;
        private byte memoizedIsInitialized = -1;
        private String name_ = "";
        private Internal.ProtobufList<MethodDescriptorProto> method_ = GeneratedMessageLite.f();

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<ServiceDescriptorProto, Builder> implements ServiceDescriptorProtoOrBuilder {
            private Builder() {
                super(ServiceDescriptorProto.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllMethod(Iterable<? extends MethodDescriptorProto> iterable) {
                a();
                ((ServiceDescriptorProto) this.a).addAllMethod(iterable);
                return this;
            }

            public Builder addMethod(int i, MethodDescriptorProto.Builder builder) {
                a();
                ((ServiceDescriptorProto) this.a).addMethod(i, builder);
                return this;
            }

            public Builder addMethod(int i, MethodDescriptorProto methodDescriptorProto) {
                a();
                ((ServiceDescriptorProto) this.a).addMethod(i, methodDescriptorProto);
                return this;
            }

            public Builder addMethod(MethodDescriptorProto.Builder builder) {
                a();
                ((ServiceDescriptorProto) this.a).addMethod(builder);
                return this;
            }

            public Builder addMethod(MethodDescriptorProto methodDescriptorProto) {
                a();
                ((ServiceDescriptorProto) this.a).addMethod(methodDescriptorProto);
                return this;
            }

            public Builder clearMethod() {
                a();
                ((ServiceDescriptorProto) this.a).clearMethod();
                return this;
            }

            public Builder clearName() {
                a();
                ((ServiceDescriptorProto) this.a).clearName();
                return this;
            }

            public Builder clearOptions() {
                a();
                ((ServiceDescriptorProto) this.a).clearOptions();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
            public MethodDescriptorProto getMethod(int i) {
                return ((ServiceDescriptorProto) this.a).getMethod(i);
            }

            @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
            public int getMethodCount() {
                return ((ServiceDescriptorProto) this.a).getMethodCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
            public List<MethodDescriptorProto> getMethodList() {
                return Collections.unmodifiableList(((ServiceDescriptorProto) this.a).getMethodList());
            }

            @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
            public String getName() {
                return ((ServiceDescriptorProto) this.a).getName();
            }

            @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
            public ByteString getNameBytes() {
                return ((ServiceDescriptorProto) this.a).getNameBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
            public ServiceOptions getOptions() {
                return ((ServiceDescriptorProto) this.a).getOptions();
            }

            @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
            public boolean hasName() {
                return ((ServiceDescriptorProto) this.a).hasName();
            }

            @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
            public boolean hasOptions() {
                return ((ServiceDescriptorProto) this.a).hasOptions();
            }

            public Builder mergeOptions(ServiceOptions serviceOptions) {
                a();
                ((ServiceDescriptorProto) this.a).mergeOptions(serviceOptions);
                return this;
            }

            public Builder removeMethod(int i) {
                a();
                ((ServiceDescriptorProto) this.a).removeMethod(i);
                return this;
            }

            public Builder setMethod(int i, MethodDescriptorProto.Builder builder) {
                a();
                ((ServiceDescriptorProto) this.a).setMethod(i, builder);
                return this;
            }

            public Builder setMethod(int i, MethodDescriptorProto methodDescriptorProto) {
                a();
                ((ServiceDescriptorProto) this.a).setMethod(i, methodDescriptorProto);
                return this;
            }

            public Builder setName(String str) {
                a();
                ((ServiceDescriptorProto) this.a).setName(str);
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                a();
                ((ServiceDescriptorProto) this.a).setNameBytes(byteString);
                return this;
            }

            public Builder setOptions(ServiceOptions.Builder builder) {
                a();
                ((ServiceDescriptorProto) this.a).setOptions(builder);
                return this;
            }

            public Builder setOptions(ServiceOptions serviceOptions) {
                a();
                ((ServiceDescriptorProto) this.a).setOptions(serviceOptions);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private ServiceDescriptorProto() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllMethod(Iterable<? extends MethodDescriptorProto> iterable) {
            ensureMethodIsMutable();
            AbstractMessageLite.a(iterable, this.method_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addMethod(int i, MethodDescriptorProto.Builder builder) {
            ensureMethodIsMutable();
            this.method_.add(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addMethod(int i, MethodDescriptorProto methodDescriptorProto) {
            if (methodDescriptorProto == null) {
                throw new NullPointerException();
            }
            ensureMethodIsMutable();
            this.method_.add(i, methodDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addMethod(MethodDescriptorProto.Builder builder) {
            ensureMethodIsMutable();
            this.method_.add(builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addMethod(MethodDescriptorProto methodDescriptorProto) {
            if (methodDescriptorProto == null) {
                throw new NullPointerException();
            }
            ensureMethodIsMutable();
            this.method_.add(methodDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMethod() {
            this.method_ = GeneratedMessageLite.f();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearName() {
            this.bitField0_ &= -2;
            this.name_ = getDefaultInstance().getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOptions() {
            this.options_ = null;
            this.bitField0_ &= -3;
        }

        private void ensureMethodIsMutable() {
            if (this.method_.isModifiable()) {
                return;
            }
            this.method_ = GeneratedMessageLite.a(this.method_);
        }

        public static ServiceDescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public void mergeOptions(ServiceOptions serviceOptions) {
            ServiceOptions serviceOptions2 = this.options_;
            if (serviceOptions2 != null && serviceOptions2 != ServiceOptions.getDefaultInstance()) {
                serviceOptions = ((ServiceOptions.Builder) ServiceOptions.newBuilder(this.options_).mergeFrom((ServiceOptions.Builder) serviceOptions)).buildPartial();
            }
            this.options_ = serviceOptions;
            this.bitField0_ |= 2;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ServiceDescriptorProto serviceDescriptorProto) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) serviceDescriptorProto);
        }

        public static ServiceDescriptorProto parseDelimitedFrom(InputStream inputStream) {
            return (ServiceDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static ServiceDescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ServiceDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ServiceDescriptorProto parseFrom(ByteString byteString) {
            return (ServiceDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static ServiceDescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ServiceDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ServiceDescriptorProto parseFrom(CodedInputStream codedInputStream) {
            return (ServiceDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ServiceDescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ServiceDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static ServiceDescriptorProto parseFrom(InputStream inputStream) {
            return (ServiceDescriptorProto) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static ServiceDescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ServiceDescriptorProto) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ServiceDescriptorProto parseFrom(byte[] bArr) {
            return (ServiceDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static ServiceDescriptorProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ServiceDescriptorProto) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<ServiceDescriptorProto> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeMethod(int i) {
            ensureMethodIsMutable();
            this.method_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMethod(int i, MethodDescriptorProto.Builder builder) {
            ensureMethodIsMutable();
            this.method_.set(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMethod(int i, MethodDescriptorProto methodDescriptorProto) {
            if (methodDescriptorProto == null) {
                throw new NullPointerException();
            }
            ensureMethodIsMutable();
            this.method_.set(i, methodDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setName(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 1;
            this.name_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNameBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 1;
            this.name_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public void setOptions(ServiceOptions.Builder builder) {
            this.options_ = (ServiceOptions) builder.build();
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOptions(ServiceOptions serviceOptions) {
            if (serviceOptions == null) {
                throw new NullPointerException();
            }
            this.options_ = serviceOptions;
            this.bitField0_ |= 2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new ServiceDescriptorProto();
                case 2:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i = 0; i < getMethodCount(); i++) {
                        if (!getMethod(i).isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = (byte) 0;
                            }
                            return null;
                        }
                    }
                    if (!hasOptions() || getOptions().isInitialized()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = (byte) 1;
                        }
                        return DEFAULT_INSTANCE;
                    }
                    if (booleanValue) {
                        this.memoizedIsInitialized = (byte) 0;
                    }
                    return null;
                case 3:
                    this.method_.makeImmutable();
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    ServiceDescriptorProto serviceDescriptorProto = (ServiceDescriptorProto) obj2;
                    this.name_ = visitor.visitString(hasName(), this.name_, serviceDescriptorProto.hasName(), serviceDescriptorProto.name_);
                    this.method_ = visitor.visitList(this.method_, serviceDescriptorProto.method_);
                    this.options_ = (ServiceOptions) visitor.visitMessage(this.options_, serviceDescriptorProto.options_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= serviceDescriptorProto.bitField0_;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    String readString = codedInputStream.readString();
                                    this.bitField0_ |= 1;
                                    this.name_ = readString;
                                } else if (readTag == 18) {
                                    if (!this.method_.isModifiable()) {
                                        this.method_ = GeneratedMessageLite.a(this.method_);
                                    }
                                    this.method_.add((MethodDescriptorProto) codedInputStream.readMessage(MethodDescriptorProto.parser(), extensionRegistryLite));
                                } else if (readTag == 26) {
                                    ServiceOptions.Builder builder = (this.bitField0_ & 2) == 2 ? (ServiceOptions.Builder) this.options_.toBuilder() : null;
                                    this.options_ = (ServiceOptions) codedInputStream.readMessage(ServiceOptions.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom((ServiceOptions.Builder) this.options_);
                                        this.options_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 2;
                                } else if (!a(readTag, codedInputStream)) {
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
                        synchronized (ServiceDescriptorProto.class) {
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

        @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
        public MethodDescriptorProto getMethod(int i) {
            return this.method_.get(i);
        }

        @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
        public int getMethodCount() {
            return this.method_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
        public List<MethodDescriptorProto> getMethodList() {
            return this.method_;
        }

        public MethodDescriptorProtoOrBuilder getMethodOrBuilder(int i) {
            return this.method_.get(i);
        }

        public List<? extends MethodDescriptorProtoOrBuilder> getMethodOrBuilderList() {
            return this.method_;
        }

        @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
        public String getName() {
            return this.name_;
        }

        @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
        public ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
        public ServiceOptions getOptions() {
            ServiceOptions serviceOptions = this.options_;
            return serviceOptions == null ? ServiceOptions.getDefaultInstance() : serviceOptions;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeStringSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeStringSize(1, getName()) + 0 : 0;
            for (int i2 = 0; i2 < this.method_.size(); i2++) {
                computeStringSize += CodedOutputStream.computeMessageSize(2, this.method_.get(i2));
            }
            if ((this.bitField0_ & 2) == 2) {
                computeStringSize += CodedOutputStream.computeMessageSize(3, getOptions());
            }
            int serializedSize = computeStringSize + this.b.getSerializedSize();
            this.c = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
        public boolean hasOptions() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeString(1, getName());
            }
            for (int i = 0; i < this.method_.size(); i++) {
                codedOutputStream.writeMessage(2, this.method_.get(i));
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(3, getOptions());
            }
            this.b.writeTo(codedOutputStream);
        }
    }

    /* loaded from: classes2.dex */
    public interface ServiceDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
        MethodDescriptorProto getMethod(int i);

        int getMethodCount();

        List<MethodDescriptorProto> getMethodList();

        String getName();

        ByteString getNameBytes();

        ServiceOptions getOptions();

        boolean hasName();

        boolean hasOptions();
    }

    /* loaded from: classes2.dex */
    public static final class ServiceOptions extends GeneratedMessageLite.ExtendableMessage<ServiceOptions, Builder> implements ServiceOptionsOrBuilder {
        private static final ServiceOptions DEFAULT_INSTANCE = new ServiceOptions();
        public static final int DEPRECATED_FIELD_NUMBER = 33;
        private static volatile Parser<ServiceOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private int bitField0_;
        private boolean deprecated_;
        private byte memoizedIsInitialized = -1;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = GeneratedMessageLite.f();

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<ServiceOptions, Builder> implements ServiceOptionsOrBuilder {
            private Builder() {
                super(ServiceOptions.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
                a();
                ((ServiceOptions) this.a).addAllUninterpretedOption(iterable);
                return this;
            }

            public Builder addUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                a();
                ((ServiceOptions) this.a).addUninterpretedOption(i, builder);
                return this;
            }

            public Builder addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                a();
                ((ServiceOptions) this.a).addUninterpretedOption(i, uninterpretedOption);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption.Builder builder) {
                a();
                ((ServiceOptions) this.a).addUninterpretedOption(builder);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption uninterpretedOption) {
                a();
                ((ServiceOptions) this.a).addUninterpretedOption(uninterpretedOption);
                return this;
            }

            public Builder clearDeprecated() {
                a();
                ((ServiceOptions) this.a).clearDeprecated();
                return this;
            }

            public Builder clearUninterpretedOption() {
                a();
                ((ServiceOptions) this.a).clearUninterpretedOption();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.ServiceOptionsOrBuilder
            public boolean getDeprecated() {
                return ((ServiceOptions) this.a).getDeprecated();
            }

            @Override // com.google.protobuf.DescriptorProtos.ServiceOptionsOrBuilder
            public UninterpretedOption getUninterpretedOption(int i) {
                return ((ServiceOptions) this.a).getUninterpretedOption(i);
            }

            @Override // com.google.protobuf.DescriptorProtos.ServiceOptionsOrBuilder
            public int getUninterpretedOptionCount() {
                return ((ServiceOptions) this.a).getUninterpretedOptionCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.ServiceOptionsOrBuilder
            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(((ServiceOptions) this.a).getUninterpretedOptionList());
            }

            @Override // com.google.protobuf.DescriptorProtos.ServiceOptionsOrBuilder
            public boolean hasDeprecated() {
                return ((ServiceOptions) this.a).hasDeprecated();
            }

            public Builder removeUninterpretedOption(int i) {
                a();
                ((ServiceOptions) this.a).removeUninterpretedOption(i);
                return this;
            }

            public Builder setDeprecated(boolean z) {
                a();
                ((ServiceOptions) this.a).setDeprecated(z);
                return this;
            }

            public Builder setUninterpretedOption(int i, UninterpretedOption.Builder builder) {
                a();
                ((ServiceOptions) this.a).setUninterpretedOption(i, builder);
                return this;
            }

            public Builder setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
                a();
                ((ServiceOptions) this.a).setUninterpretedOption(i, uninterpretedOption);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private ServiceOptions() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
            ensureUninterpretedOptionIsMutable();
            AbstractMessageLite.a(iterable, this.uninterpretedOption_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUninterpretedOption(int i, UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption == null) {
                throw new NullPointerException();
            }
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(i, uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUninterpretedOption(UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption == null) {
                throw new NullPointerException();
            }
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.add(uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDeprecated() {
            this.bitField0_ &= -2;
            this.deprecated_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUninterpretedOption() {
            this.uninterpretedOption_ = GeneratedMessageLite.f();
        }

        private void ensureUninterpretedOptionIsMutable() {
            if (this.uninterpretedOption_.isModifiable()) {
                return;
            }
            this.uninterpretedOption_ = GeneratedMessageLite.a(this.uninterpretedOption_);
        }

        public static ServiceOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.toBuilder();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static Builder newBuilder(ServiceOptions serviceOptions) {
            return (Builder) ((Builder) DEFAULT_INSTANCE.toBuilder()).mergeFrom((Builder) serviceOptions);
        }

        public static ServiceOptions parseDelimitedFrom(InputStream inputStream) {
            return (ServiceOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static ServiceOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ServiceOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ServiceOptions parseFrom(ByteString byteString) {
            return (ServiceOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static ServiceOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ServiceOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ServiceOptions parseFrom(CodedInputStream codedInputStream) {
            return (ServiceOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ServiceOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ServiceOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static ServiceOptions parseFrom(InputStream inputStream) {
            return (ServiceOptions) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static ServiceOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ServiceOptions) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ServiceOptions parseFrom(byte[] bArr) {
            return (ServiceOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static ServiceOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ServiceOptions) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<ServiceOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeUninterpretedOption(int i) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDeprecated(boolean z) {
            this.bitField0_ |= 1;
            this.deprecated_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUninterpretedOption(int i, UninterpretedOption.Builder builder) {
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUninterpretedOption(int i, UninterpretedOption uninterpretedOption) {
            if (uninterpretedOption == null) {
                throw new NullPointerException();
            }
            ensureUninterpretedOptionIsMutable();
            this.uninterpretedOption_.set(i, uninterpretedOption);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new ServiceOptions();
                case 2:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i = 0; i < getUninterpretedOptionCount(); i++) {
                        if (!getUninterpretedOption(i).isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = (byte) 0;
                            }
                            return null;
                        }
                    }
                    if (g()) {
                        if (booleanValue) {
                            this.memoizedIsInitialized = (byte) 1;
                        }
                        return DEFAULT_INSTANCE;
                    }
                    if (booleanValue) {
                        this.memoizedIsInitialized = (byte) 0;
                    }
                    return null;
                case 3:
                    this.uninterpretedOption_.makeImmutable();
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    ServiceOptions serviceOptions = (ServiceOptions) obj2;
                    this.deprecated_ = visitor.visitBoolean(hasDeprecated(), this.deprecated_, serviceOptions.hasDeprecated(), serviceOptions.deprecated_);
                    this.uninterpretedOption_ = visitor.visitList(this.uninterpretedOption_, serviceOptions.uninterpretedOption_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= serviceOptions.bitField0_;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 264) {
                                    this.bitField0_ |= 1;
                                    this.deprecated_ = codedInputStream.readBool();
                                } else if (readTag == 7994) {
                                    if (!this.uninterpretedOption_.isModifiable()) {
                                        this.uninterpretedOption_ = GeneratedMessageLite.a(this.uninterpretedOption_);
                                    }
                                    this.uninterpretedOption_.add((UninterpretedOption) codedInputStream.readMessage(UninterpretedOption.parser(), extensionRegistryLite));
                                } else if (!a((ServiceOptions) getDefaultInstanceForType(), codedInputStream, extensionRegistryLite, readTag)) {
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
                        synchronized (ServiceOptions.class) {
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

        @Override // com.google.protobuf.DescriptorProtos.ServiceOptionsOrBuilder
        public boolean getDeprecated() {
            return this.deprecated_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeBoolSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeBoolSize(33, this.deprecated_) + 0 : 0;
            for (int i2 = 0; i2 < this.uninterpretedOption_.size(); i2++) {
                computeBoolSize += CodedOutputStream.computeMessageSize(999, this.uninterpretedOption_.get(i2));
            }
            int h = computeBoolSize + h() + this.b.getSerializedSize();
            this.c = h;
            return h;
        }

        @Override // com.google.protobuf.DescriptorProtos.ServiceOptionsOrBuilder
        public UninterpretedOption getUninterpretedOption(int i) {
            return this.uninterpretedOption_.get(i);
        }

        @Override // com.google.protobuf.DescriptorProtos.ServiceOptionsOrBuilder
        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.ServiceOptionsOrBuilder
        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i) {
            return this.uninterpretedOption_.get(i);
        }

        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.DescriptorProtos.ServiceOptionsOrBuilder
        public boolean hasDeprecated() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            GeneratedMessageLite.ExtendableMessage<MessageType, BuilderType>.ExtensionWriter i = i();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeBool(33, this.deprecated_);
            }
            for (int i2 = 0; i2 < this.uninterpretedOption_.size(); i2++) {
                codedOutputStream.writeMessage(999, this.uninterpretedOption_.get(i2));
            }
            i.writeUntil(536870912, codedOutputStream);
            this.b.writeTo(codedOutputStream);
        }
    }

    /* loaded from: classes2.dex */
    public interface ServiceOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<ServiceOptions, ServiceOptions.Builder> {
        boolean getDeprecated();

        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        boolean hasDeprecated();
    }

    /* loaded from: classes2.dex */
    public static final class SourceCodeInfo extends GeneratedMessageLite<SourceCodeInfo, Builder> implements SourceCodeInfoOrBuilder {
        private static final SourceCodeInfo DEFAULT_INSTANCE = new SourceCodeInfo();
        public static final int LOCATION_FIELD_NUMBER = 1;
        private static volatile Parser<SourceCodeInfo> PARSER;
        private Internal.ProtobufList<Location> location_ = GeneratedMessageLite.f();

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<SourceCodeInfo, Builder> implements SourceCodeInfoOrBuilder {
            private Builder() {
                super(SourceCodeInfo.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllLocation(Iterable<? extends Location> iterable) {
                a();
                ((SourceCodeInfo) this.a).addAllLocation(iterable);
                return this;
            }

            public Builder addLocation(int i, Location.Builder builder) {
                a();
                ((SourceCodeInfo) this.a).addLocation(i, builder);
                return this;
            }

            public Builder addLocation(int i, Location location) {
                a();
                ((SourceCodeInfo) this.a).addLocation(i, location);
                return this;
            }

            public Builder addLocation(Location.Builder builder) {
                a();
                ((SourceCodeInfo) this.a).addLocation(builder);
                return this;
            }

            public Builder addLocation(Location location) {
                a();
                ((SourceCodeInfo) this.a).addLocation(location);
                return this;
            }

            public Builder clearLocation() {
                a();
                ((SourceCodeInfo) this.a).clearLocation();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfoOrBuilder
            public Location getLocation(int i) {
                return ((SourceCodeInfo) this.a).getLocation(i);
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfoOrBuilder
            public int getLocationCount() {
                return ((SourceCodeInfo) this.a).getLocationCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfoOrBuilder
            public List<Location> getLocationList() {
                return Collections.unmodifiableList(((SourceCodeInfo) this.a).getLocationList());
            }

            public Builder removeLocation(int i) {
                a();
                ((SourceCodeInfo) this.a).removeLocation(i);
                return this;
            }

            public Builder setLocation(int i, Location.Builder builder) {
                a();
                ((SourceCodeInfo) this.a).setLocation(i, builder);
                return this;
            }

            public Builder setLocation(int i, Location location) {
                a();
                ((SourceCodeInfo) this.a).setLocation(i, location);
                return this;
            }
        }

        /* loaded from: classes2.dex */
        public static final class Location extends GeneratedMessageLite<Location, Builder> implements LocationOrBuilder {
            private static final Location DEFAULT_INSTANCE = new Location();
            public static final int LEADING_COMMENTS_FIELD_NUMBER = 3;
            public static final int LEADING_DETACHED_COMMENTS_FIELD_NUMBER = 6;
            private static volatile Parser<Location> PARSER = null;
            public static final int PATH_FIELD_NUMBER = 1;
            public static final int SPAN_FIELD_NUMBER = 2;
            public static final int TRAILING_COMMENTS_FIELD_NUMBER = 4;
            private int bitField0_;
            private int pathMemoizedSerializedSize = -1;
            private int spanMemoizedSerializedSize = -1;
            private Internal.IntList path_ = GeneratedMessageLite.d();
            private Internal.IntList span_ = GeneratedMessageLite.d();
            private String leadingComments_ = "";
            private String trailingComments_ = "";
            private Internal.ProtobufList<String> leadingDetachedComments_ = GeneratedMessageLite.f();

            /* loaded from: classes2.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<Location, Builder> implements LocationOrBuilder {
                private Builder() {
                    super(Location.DEFAULT_INSTANCE);
                }

                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                public Builder addAllLeadingDetachedComments(Iterable<String> iterable) {
                    a();
                    ((Location) this.a).addAllLeadingDetachedComments(iterable);
                    return this;
                }

                public Builder addAllPath(Iterable<? extends Integer> iterable) {
                    a();
                    ((Location) this.a).addAllPath(iterable);
                    return this;
                }

                public Builder addAllSpan(Iterable<? extends Integer> iterable) {
                    a();
                    ((Location) this.a).addAllSpan(iterable);
                    return this;
                }

                public Builder addLeadingDetachedComments(String str) {
                    a();
                    ((Location) this.a).addLeadingDetachedComments(str);
                    return this;
                }

                public Builder addLeadingDetachedCommentsBytes(ByteString byteString) {
                    a();
                    ((Location) this.a).addLeadingDetachedCommentsBytes(byteString);
                    return this;
                }

                public Builder addPath(int i) {
                    a();
                    ((Location) this.a).addPath(i);
                    return this;
                }

                public Builder addSpan(int i) {
                    a();
                    ((Location) this.a).addSpan(i);
                    return this;
                }

                public Builder clearLeadingComments() {
                    a();
                    ((Location) this.a).clearLeadingComments();
                    return this;
                }

                public Builder clearLeadingDetachedComments() {
                    a();
                    ((Location) this.a).clearLeadingDetachedComments();
                    return this;
                }

                public Builder clearPath() {
                    a();
                    ((Location) this.a).clearPath();
                    return this;
                }

                public Builder clearSpan() {
                    a();
                    ((Location) this.a).clearSpan();
                    return this;
                }

                public Builder clearTrailingComments() {
                    a();
                    ((Location) this.a).clearTrailingComments();
                    return this;
                }

                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public String getLeadingComments() {
                    return ((Location) this.a).getLeadingComments();
                }

                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public ByteString getLeadingCommentsBytes() {
                    return ((Location) this.a).getLeadingCommentsBytes();
                }

                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public String getLeadingDetachedComments(int i) {
                    return ((Location) this.a).getLeadingDetachedComments(i);
                }

                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public ByteString getLeadingDetachedCommentsBytes(int i) {
                    return ((Location) this.a).getLeadingDetachedCommentsBytes(i);
                }

                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public int getLeadingDetachedCommentsCount() {
                    return ((Location) this.a).getLeadingDetachedCommentsCount();
                }

                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public List<String> getLeadingDetachedCommentsList() {
                    return Collections.unmodifiableList(((Location) this.a).getLeadingDetachedCommentsList());
                }

                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public int getPath(int i) {
                    return ((Location) this.a).getPath(i);
                }

                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public int getPathCount() {
                    return ((Location) this.a).getPathCount();
                }

                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public List<Integer> getPathList() {
                    return Collections.unmodifiableList(((Location) this.a).getPathList());
                }

                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public int getSpan(int i) {
                    return ((Location) this.a).getSpan(i);
                }

                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public int getSpanCount() {
                    return ((Location) this.a).getSpanCount();
                }

                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public List<Integer> getSpanList() {
                    return Collections.unmodifiableList(((Location) this.a).getSpanList());
                }

                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public String getTrailingComments() {
                    return ((Location) this.a).getTrailingComments();
                }

                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public ByteString getTrailingCommentsBytes() {
                    return ((Location) this.a).getTrailingCommentsBytes();
                }

                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public boolean hasLeadingComments() {
                    return ((Location) this.a).hasLeadingComments();
                }

                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public boolean hasTrailingComments() {
                    return ((Location) this.a).hasTrailingComments();
                }

                public Builder setLeadingComments(String str) {
                    a();
                    ((Location) this.a).setLeadingComments(str);
                    return this;
                }

                public Builder setLeadingCommentsBytes(ByteString byteString) {
                    a();
                    ((Location) this.a).setLeadingCommentsBytes(byteString);
                    return this;
                }

                public Builder setLeadingDetachedComments(int i, String str) {
                    a();
                    ((Location) this.a).setLeadingDetachedComments(i, str);
                    return this;
                }

                public Builder setPath(int i, int i2) {
                    a();
                    ((Location) this.a).setPath(i, i2);
                    return this;
                }

                public Builder setSpan(int i, int i2) {
                    a();
                    ((Location) this.a).setSpan(i, i2);
                    return this;
                }

                public Builder setTrailingComments(String str) {
                    a();
                    ((Location) this.a).setTrailingComments(str);
                    return this;
                }

                public Builder setTrailingCommentsBytes(ByteString byteString) {
                    a();
                    ((Location) this.a).setTrailingCommentsBytes(byteString);
                    return this;
                }
            }

            static {
                DEFAULT_INSTANCE.b();
            }

            private Location() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addAllLeadingDetachedComments(Iterable<String> iterable) {
                ensureLeadingDetachedCommentsIsMutable();
                AbstractMessageLite.a(iterable, this.leadingDetachedComments_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addAllPath(Iterable<? extends Integer> iterable) {
                ensurePathIsMutable();
                AbstractMessageLite.a(iterable, this.path_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addAllSpan(Iterable<? extends Integer> iterable) {
                ensureSpanIsMutable();
                AbstractMessageLite.a(iterable, this.span_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addLeadingDetachedComments(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                ensureLeadingDetachedCommentsIsMutable();
                this.leadingDetachedComments_.add(str);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addLeadingDetachedCommentsBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                ensureLeadingDetachedCommentsIsMutable();
                this.leadingDetachedComments_.add(byteString.toStringUtf8());
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addPath(int i) {
                ensurePathIsMutable();
                this.path_.addInt(i);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addSpan(int i) {
                ensureSpanIsMutable();
                this.span_.addInt(i);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearLeadingComments() {
                this.bitField0_ &= -2;
                this.leadingComments_ = getDefaultInstance().getLeadingComments();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearLeadingDetachedComments() {
                this.leadingDetachedComments_ = GeneratedMessageLite.f();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearPath() {
                this.path_ = GeneratedMessageLite.d();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearSpan() {
                this.span_ = GeneratedMessageLite.d();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearTrailingComments() {
                this.bitField0_ &= -3;
                this.trailingComments_ = getDefaultInstance().getTrailingComments();
            }

            private void ensureLeadingDetachedCommentsIsMutable() {
                if (this.leadingDetachedComments_.isModifiable()) {
                    return;
                }
                this.leadingDetachedComments_ = GeneratedMessageLite.a(this.leadingDetachedComments_);
            }

            private void ensurePathIsMutable() {
                if (this.path_.isModifiable()) {
                    return;
                }
                this.path_ = GeneratedMessageLite.a(this.path_);
            }

            private void ensureSpanIsMutable() {
                if (this.span_.isModifiable()) {
                    return;
                }
                this.span_ = GeneratedMessageLite.a(this.span_);
            }

            public static Location getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(Location location) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) location);
            }

            public static Location parseDelimitedFrom(InputStream inputStream) {
                return (Location) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
            }

            public static Location parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Location) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Location parseFrom(ByteString byteString) {
                return (Location) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
            }

            public static Location parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                return (Location) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Location parseFrom(CodedInputStream codedInputStream) {
                return (Location) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Location parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Location) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Location parseFrom(InputStream inputStream) {
                return (Location) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
            }

            public static Location parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (Location) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Location parseFrom(byte[] bArr) {
                return (Location) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
            }

            public static Location parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                return (Location) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static Parser<Location> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setLeadingComments(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 1;
                this.leadingComments_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setLeadingCommentsBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 1;
                this.leadingComments_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setLeadingDetachedComments(int i, String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                ensureLeadingDetachedCommentsIsMutable();
                this.leadingDetachedComments_.set(i, str);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setPath(int i, int i2) {
                ensurePathIsMutable();
                this.path_.setInt(i, i2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setSpan(int i, int i2) {
                ensureSpanIsMutable();
                this.span_.setInt(i, i2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setTrailingComments(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.trailingComments_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setTrailingCommentsBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.trailingComments_ = byteString.toStringUtf8();
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                Internal.IntList intList;
                int readInt32;
                int pushLimit;
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new Location();
                    case 2:
                        return DEFAULT_INSTANCE;
                    case 3:
                        this.path_.makeImmutable();
                        this.span_.makeImmutable();
                        this.leadingDetachedComments_.makeImmutable();
                        return null;
                    case 4:
                        return new Builder(anonymousClass1);
                    case 5:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        Location location = (Location) obj2;
                        this.path_ = visitor.visitIntList(this.path_, location.path_);
                        this.span_ = visitor.visitIntList(this.span_, location.span_);
                        this.leadingComments_ = visitor.visitString(hasLeadingComments(), this.leadingComments_, location.hasLeadingComments(), location.leadingComments_);
                        this.trailingComments_ = visitor.visitString(hasTrailingComments(), this.trailingComments_, location.hasTrailingComments(), location.trailingComments_);
                        this.leadingDetachedComments_ = visitor.visitList(this.leadingDetachedComments_, location.leadingDetachedComments_);
                        if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                            this.bitField0_ |= location.bitField0_;
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
                                        if (readTag != 8) {
                                            if (readTag == 10) {
                                                pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                                if (!this.path_.isModifiable() && codedInputStream.getBytesUntilLimit() > 0) {
                                                    this.path_ = GeneratedMessageLite.a(this.path_);
                                                }
                                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                                    this.path_.addInt(codedInputStream.readInt32());
                                                }
                                            } else if (readTag == 16) {
                                                if (!this.span_.isModifiable()) {
                                                    this.span_ = GeneratedMessageLite.a(this.span_);
                                                }
                                                intList = this.span_;
                                                readInt32 = codedInputStream.readInt32();
                                            } else if (readTag == 18) {
                                                pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                                if (!this.span_.isModifiable() && codedInputStream.getBytesUntilLimit() > 0) {
                                                    this.span_ = GeneratedMessageLite.a(this.span_);
                                                }
                                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                                    this.span_.addInt(codedInputStream.readInt32());
                                                }
                                            } else if (readTag == 26) {
                                                String readString = codedInputStream.readString();
                                                this.bitField0_ = 1 | this.bitField0_;
                                                this.leadingComments_ = readString;
                                            } else if (readTag == 34) {
                                                String readString2 = codedInputStream.readString();
                                                this.bitField0_ |= 2;
                                                this.trailingComments_ = readString2;
                                            } else if (readTag == 50) {
                                                String readString3 = codedInputStream.readString();
                                                if (!this.leadingDetachedComments_.isModifiable()) {
                                                    this.leadingDetachedComments_ = GeneratedMessageLite.a(this.leadingDetachedComments_);
                                                }
                                                this.leadingDetachedComments_.add(readString3);
                                            } else if (!a(readTag, codedInputStream)) {
                                            }
                                            codedInputStream.popLimit(pushLimit);
                                        } else {
                                            if (!this.path_.isModifiable()) {
                                                this.path_ = GeneratedMessageLite.a(this.path_);
                                            }
                                            intList = this.path_;
                                            readInt32 = codedInputStream.readInt32();
                                        }
                                        intList.addInt(readInt32);
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
                            synchronized (Location.class) {
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

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public String getLeadingComments() {
                return this.leadingComments_;
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public ByteString getLeadingCommentsBytes() {
                return ByteString.copyFromUtf8(this.leadingComments_);
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public String getLeadingDetachedComments(int i) {
                return this.leadingDetachedComments_.get(i);
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public ByteString getLeadingDetachedCommentsBytes(int i) {
                return ByteString.copyFromUtf8(this.leadingDetachedComments_.get(i));
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public int getLeadingDetachedCommentsCount() {
                return this.leadingDetachedComments_.size();
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public List<String> getLeadingDetachedCommentsList() {
                return this.leadingDetachedComments_;
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public int getPath(int i) {
                return this.path_.getInt(i);
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public int getPathCount() {
                return this.path_.size();
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public List<Integer> getPathList() {
                return this.path_;
            }

            @Override // com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.c;
                if (i != -1) {
                    return i;
                }
                int i2 = 0;
                for (int i3 = 0; i3 < this.path_.size(); i3++) {
                    i2 += CodedOutputStream.computeInt32SizeNoTag(this.path_.getInt(i3));
                }
                int i4 = 0 + i2;
                if (!getPathList().isEmpty()) {
                    i4 = i4 + 1 + CodedOutputStream.computeInt32SizeNoTag(i2);
                }
                this.pathMemoizedSerializedSize = i2;
                int i5 = 0;
                for (int i6 = 0; i6 < this.span_.size(); i6++) {
                    i5 += CodedOutputStream.computeInt32SizeNoTag(this.span_.getInt(i6));
                }
                int i7 = i4 + i5;
                if (!getSpanList().isEmpty()) {
                    i7 = i7 + 1 + CodedOutputStream.computeInt32SizeNoTag(i5);
                }
                this.spanMemoizedSerializedSize = i5;
                if ((this.bitField0_ & 1) == 1) {
                    i7 += CodedOutputStream.computeStringSize(3, getLeadingComments());
                }
                if ((this.bitField0_ & 2) == 2) {
                    i7 += CodedOutputStream.computeStringSize(4, getTrailingComments());
                }
                int i8 = 0;
                for (int i9 = 0; i9 < this.leadingDetachedComments_.size(); i9++) {
                    i8 += CodedOutputStream.computeStringSizeNoTag(this.leadingDetachedComments_.get(i9));
                }
                int size = i7 + i8 + (getLeadingDetachedCommentsList().size() * 1) + this.b.getSerializedSize();
                this.c = size;
                return size;
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public int getSpan(int i) {
                return this.span_.getInt(i);
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public int getSpanCount() {
                return this.span_.size();
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public List<Integer> getSpanList() {
                return this.span_;
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public String getTrailingComments() {
                return this.trailingComments_;
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public ByteString getTrailingCommentsBytes() {
                return ByteString.copyFromUtf8(this.trailingComments_);
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public boolean hasLeadingComments() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public boolean hasTrailingComments() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) {
                getSerializedSize();
                if (getPathList().size() > 0) {
                    codedOutputStream.writeUInt32NoTag(10);
                    codedOutputStream.writeUInt32NoTag(this.pathMemoizedSerializedSize);
                }
                for (int i = 0; i < this.path_.size(); i++) {
                    codedOutputStream.writeInt32NoTag(this.path_.getInt(i));
                }
                if (getSpanList().size() > 0) {
                    codedOutputStream.writeUInt32NoTag(18);
                    codedOutputStream.writeUInt32NoTag(this.spanMemoizedSerializedSize);
                }
                for (int i2 = 0; i2 < this.span_.size(); i2++) {
                    codedOutputStream.writeInt32NoTag(this.span_.getInt(i2));
                }
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.writeString(3, getLeadingComments());
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.writeString(4, getTrailingComments());
                }
                for (int i3 = 0; i3 < this.leadingDetachedComments_.size(); i3++) {
                    codedOutputStream.writeString(6, this.leadingDetachedComments_.get(i3));
                }
                this.b.writeTo(codedOutputStream);
            }
        }

        /* loaded from: classes2.dex */
        public interface LocationOrBuilder extends MessageLiteOrBuilder {
            String getLeadingComments();

            ByteString getLeadingCommentsBytes();

            String getLeadingDetachedComments(int i);

            ByteString getLeadingDetachedCommentsBytes(int i);

            int getLeadingDetachedCommentsCount();

            List<String> getLeadingDetachedCommentsList();

            int getPath(int i);

            int getPathCount();

            List<Integer> getPathList();

            int getSpan(int i);

            int getSpanCount();

            List<Integer> getSpanList();

            String getTrailingComments();

            ByteString getTrailingCommentsBytes();

            boolean hasLeadingComments();

            boolean hasTrailingComments();
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private SourceCodeInfo() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllLocation(Iterable<? extends Location> iterable) {
            ensureLocationIsMutable();
            AbstractMessageLite.a(iterable, this.location_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addLocation(int i, Location.Builder builder) {
            ensureLocationIsMutable();
            this.location_.add(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addLocation(int i, Location location) {
            if (location == null) {
                throw new NullPointerException();
            }
            ensureLocationIsMutable();
            this.location_.add(i, location);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addLocation(Location.Builder builder) {
            ensureLocationIsMutable();
            this.location_.add(builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addLocation(Location location) {
            if (location == null) {
                throw new NullPointerException();
            }
            ensureLocationIsMutable();
            this.location_.add(location);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLocation() {
            this.location_ = GeneratedMessageLite.f();
        }

        private void ensureLocationIsMutable() {
            if (this.location_.isModifiable()) {
                return;
            }
            this.location_ = GeneratedMessageLite.a(this.location_);
        }

        public static SourceCodeInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SourceCodeInfo sourceCodeInfo) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) sourceCodeInfo);
        }

        public static SourceCodeInfo parseDelimitedFrom(InputStream inputStream) {
            return (SourceCodeInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static SourceCodeInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (SourceCodeInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SourceCodeInfo parseFrom(ByteString byteString) {
            return (SourceCodeInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static SourceCodeInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (SourceCodeInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static SourceCodeInfo parseFrom(CodedInputStream codedInputStream) {
            return (SourceCodeInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static SourceCodeInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (SourceCodeInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static SourceCodeInfo parseFrom(InputStream inputStream) {
            return (SourceCodeInfo) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static SourceCodeInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (SourceCodeInfo) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SourceCodeInfo parseFrom(byte[] bArr) {
            return (SourceCodeInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static SourceCodeInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (SourceCodeInfo) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<SourceCodeInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeLocation(int i) {
            ensureLocationIsMutable();
            this.location_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLocation(int i, Location.Builder builder) {
            ensureLocationIsMutable();
            this.location_.set(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLocation(int i, Location location) {
            if (location == null) {
                throw new NullPointerException();
            }
            ensureLocationIsMutable();
            this.location_.set(i, location);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new SourceCodeInfo();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    this.location_.makeImmutable();
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    this.location_ = ((GeneratedMessageLite.Visitor) obj).visitList(this.location_, ((SourceCodeInfo) obj2).location_);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    boolean z = false;
                    while (!z) {
                        try {
                            try {
                                int readTag = codedInputStream.readTag();
                                if (readTag != 0) {
                                    if (readTag == 10) {
                                        if (!this.location_.isModifiable()) {
                                            this.location_ = GeneratedMessageLite.a(this.location_);
                                        }
                                        this.location_.add((Location) codedInputStream.readMessage(Location.parser(), extensionRegistryLite));
                                    } else if (!a(readTag, codedInputStream)) {
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
                        synchronized (SourceCodeInfo.class) {
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

        @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfoOrBuilder
        public Location getLocation(int i) {
            return this.location_.get(i);
        }

        @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfoOrBuilder
        public int getLocationCount() {
            return this.location_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfoOrBuilder
        public List<Location> getLocationList() {
            return this.location_;
        }

        public LocationOrBuilder getLocationOrBuilder(int i) {
            return this.location_.get(i);
        }

        public List<? extends LocationOrBuilder> getLocationOrBuilderList() {
            return this.location_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.location_.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(1, this.location_.get(i3));
            }
            int serializedSize = i2 + this.b.getSerializedSize();
            this.c = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            for (int i = 0; i < this.location_.size(); i++) {
                codedOutputStream.writeMessage(1, this.location_.get(i));
            }
            this.b.writeTo(codedOutputStream);
        }
    }

    /* loaded from: classes2.dex */
    public interface SourceCodeInfoOrBuilder extends MessageLiteOrBuilder {
        SourceCodeInfo.Location getLocation(int i);

        int getLocationCount();

        List<SourceCodeInfo.Location> getLocationList();
    }

    /* loaded from: classes2.dex */
    public static final class UninterpretedOption extends GeneratedMessageLite<UninterpretedOption, Builder> implements UninterpretedOptionOrBuilder {
        public static final int AGGREGATE_VALUE_FIELD_NUMBER = 8;
        private static final UninterpretedOption DEFAULT_INSTANCE = new UninterpretedOption();
        public static final int DOUBLE_VALUE_FIELD_NUMBER = 6;
        public static final int IDENTIFIER_VALUE_FIELD_NUMBER = 3;
        public static final int NAME_FIELD_NUMBER = 2;
        public static final int NEGATIVE_INT_VALUE_FIELD_NUMBER = 5;
        private static volatile Parser<UninterpretedOption> PARSER = null;
        public static final int POSITIVE_INT_VALUE_FIELD_NUMBER = 4;
        public static final int STRING_VALUE_FIELD_NUMBER = 7;
        private int bitField0_;
        private double doubleValue_;
        private long negativeIntValue_;
        private long positiveIntValue_;
        private byte memoizedIsInitialized = -1;
        private Internal.ProtobufList<NamePart> name_ = GeneratedMessageLite.f();
        private String identifierValue_ = "";
        private ByteString stringValue_ = ByteString.EMPTY;
        private String aggregateValue_ = "";

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<UninterpretedOption, Builder> implements UninterpretedOptionOrBuilder {
            private Builder() {
                super(UninterpretedOption.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllName(Iterable<? extends NamePart> iterable) {
                a();
                ((UninterpretedOption) this.a).addAllName(iterable);
                return this;
            }

            public Builder addName(int i, NamePart.Builder builder) {
                a();
                ((UninterpretedOption) this.a).addName(i, builder);
                return this;
            }

            public Builder addName(int i, NamePart namePart) {
                a();
                ((UninterpretedOption) this.a).addName(i, namePart);
                return this;
            }

            public Builder addName(NamePart.Builder builder) {
                a();
                ((UninterpretedOption) this.a).addName(builder);
                return this;
            }

            public Builder addName(NamePart namePart) {
                a();
                ((UninterpretedOption) this.a).addName(namePart);
                return this;
            }

            public Builder clearAggregateValue() {
                a();
                ((UninterpretedOption) this.a).clearAggregateValue();
                return this;
            }

            public Builder clearDoubleValue() {
                a();
                ((UninterpretedOption) this.a).clearDoubleValue();
                return this;
            }

            public Builder clearIdentifierValue() {
                a();
                ((UninterpretedOption) this.a).clearIdentifierValue();
                return this;
            }

            public Builder clearName() {
                a();
                ((UninterpretedOption) this.a).clearName();
                return this;
            }

            public Builder clearNegativeIntValue() {
                a();
                ((UninterpretedOption) this.a).clearNegativeIntValue();
                return this;
            }

            public Builder clearPositiveIntValue() {
                a();
                ((UninterpretedOption) this.a).clearPositiveIntValue();
                return this;
            }

            public Builder clearStringValue() {
                a();
                ((UninterpretedOption) this.a).clearStringValue();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public String getAggregateValue() {
                return ((UninterpretedOption) this.a).getAggregateValue();
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public ByteString getAggregateValueBytes() {
                return ((UninterpretedOption) this.a).getAggregateValueBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public double getDoubleValue() {
                return ((UninterpretedOption) this.a).getDoubleValue();
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public String getIdentifierValue() {
                return ((UninterpretedOption) this.a).getIdentifierValue();
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public ByteString getIdentifierValueBytes() {
                return ((UninterpretedOption) this.a).getIdentifierValueBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public NamePart getName(int i) {
                return ((UninterpretedOption) this.a).getName(i);
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public int getNameCount() {
                return ((UninterpretedOption) this.a).getNameCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public List<NamePart> getNameList() {
                return Collections.unmodifiableList(((UninterpretedOption) this.a).getNameList());
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public long getNegativeIntValue() {
                return ((UninterpretedOption) this.a).getNegativeIntValue();
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public long getPositiveIntValue() {
                return ((UninterpretedOption) this.a).getPositiveIntValue();
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public ByteString getStringValue() {
                return ((UninterpretedOption) this.a).getStringValue();
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public boolean hasAggregateValue() {
                return ((UninterpretedOption) this.a).hasAggregateValue();
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public boolean hasDoubleValue() {
                return ((UninterpretedOption) this.a).hasDoubleValue();
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public boolean hasIdentifierValue() {
                return ((UninterpretedOption) this.a).hasIdentifierValue();
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public boolean hasNegativeIntValue() {
                return ((UninterpretedOption) this.a).hasNegativeIntValue();
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public boolean hasPositiveIntValue() {
                return ((UninterpretedOption) this.a).hasPositiveIntValue();
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public boolean hasStringValue() {
                return ((UninterpretedOption) this.a).hasStringValue();
            }

            public Builder removeName(int i) {
                a();
                ((UninterpretedOption) this.a).removeName(i);
                return this;
            }

            public Builder setAggregateValue(String str) {
                a();
                ((UninterpretedOption) this.a).setAggregateValue(str);
                return this;
            }

            public Builder setAggregateValueBytes(ByteString byteString) {
                a();
                ((UninterpretedOption) this.a).setAggregateValueBytes(byteString);
                return this;
            }

            public Builder setDoubleValue(double d) {
                a();
                ((UninterpretedOption) this.a).setDoubleValue(d);
                return this;
            }

            public Builder setIdentifierValue(String str) {
                a();
                ((UninterpretedOption) this.a).setIdentifierValue(str);
                return this;
            }

            public Builder setIdentifierValueBytes(ByteString byteString) {
                a();
                ((UninterpretedOption) this.a).setIdentifierValueBytes(byteString);
                return this;
            }

            public Builder setName(int i, NamePart.Builder builder) {
                a();
                ((UninterpretedOption) this.a).setName(i, builder);
                return this;
            }

            public Builder setName(int i, NamePart namePart) {
                a();
                ((UninterpretedOption) this.a).setName(i, namePart);
                return this;
            }

            public Builder setNegativeIntValue(long j) {
                a();
                ((UninterpretedOption) this.a).setNegativeIntValue(j);
                return this;
            }

            public Builder setPositiveIntValue(long j) {
                a();
                ((UninterpretedOption) this.a).setPositiveIntValue(j);
                return this;
            }

            public Builder setStringValue(ByteString byteString) {
                a();
                ((UninterpretedOption) this.a).setStringValue(byteString);
                return this;
            }
        }

        /* loaded from: classes2.dex */
        public static final class NamePart extends GeneratedMessageLite<NamePart, Builder> implements NamePartOrBuilder {
            private static final NamePart DEFAULT_INSTANCE = new NamePart();
            public static final int IS_EXTENSION_FIELD_NUMBER = 2;
            public static final int NAME_PART_FIELD_NUMBER = 1;
            private static volatile Parser<NamePart> PARSER;
            private int bitField0_;
            private boolean isExtension_;
            private byte memoizedIsInitialized = -1;
            private String namePart_ = "";

            /* loaded from: classes2.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<NamePart, Builder> implements NamePartOrBuilder {
                private Builder() {
                    super(NamePart.DEFAULT_INSTANCE);
                }

                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                public Builder clearIsExtension() {
                    a();
                    ((NamePart) this.a).clearIsExtension();
                    return this;
                }

                public Builder clearNamePart() {
                    a();
                    ((NamePart) this.a).clearNamePart();
                    return this;
                }

                @Override // com.google.protobuf.DescriptorProtos.UninterpretedOption.NamePartOrBuilder
                public boolean getIsExtension() {
                    return ((NamePart) this.a).getIsExtension();
                }

                @Override // com.google.protobuf.DescriptorProtos.UninterpretedOption.NamePartOrBuilder
                public String getNamePart() {
                    return ((NamePart) this.a).getNamePart();
                }

                @Override // com.google.protobuf.DescriptorProtos.UninterpretedOption.NamePartOrBuilder
                public ByteString getNamePartBytes() {
                    return ((NamePart) this.a).getNamePartBytes();
                }

                @Override // com.google.protobuf.DescriptorProtos.UninterpretedOption.NamePartOrBuilder
                public boolean hasIsExtension() {
                    return ((NamePart) this.a).hasIsExtension();
                }

                @Override // com.google.protobuf.DescriptorProtos.UninterpretedOption.NamePartOrBuilder
                public boolean hasNamePart() {
                    return ((NamePart) this.a).hasNamePart();
                }

                public Builder setIsExtension(boolean z) {
                    a();
                    ((NamePart) this.a).setIsExtension(z);
                    return this;
                }

                public Builder setNamePart(String str) {
                    a();
                    ((NamePart) this.a).setNamePart(str);
                    return this;
                }

                public Builder setNamePartBytes(ByteString byteString) {
                    a();
                    ((NamePart) this.a).setNamePartBytes(byteString);
                    return this;
                }
            }

            static {
                DEFAULT_INSTANCE.b();
            }

            private NamePart() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearIsExtension() {
                this.bitField0_ &= -3;
                this.isExtension_ = false;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearNamePart() {
                this.bitField0_ &= -2;
                this.namePart_ = getDefaultInstance().getNamePart();
            }

            public static NamePart getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(NamePart namePart) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) namePart);
            }

            public static NamePart parseDelimitedFrom(InputStream inputStream) {
                return (NamePart) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
            }

            public static NamePart parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (NamePart) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static NamePart parseFrom(ByteString byteString) {
                return (NamePart) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
            }

            public static NamePart parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                return (NamePart) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static NamePart parseFrom(CodedInputStream codedInputStream) {
                return (NamePart) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
            }

            public static NamePart parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (NamePart) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static NamePart parseFrom(InputStream inputStream) {
                return (NamePart) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
            }

            public static NamePart parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (NamePart) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static NamePart parseFrom(byte[] bArr) {
                return (NamePart) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
            }

            public static NamePart parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                return (NamePart) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static Parser<NamePart> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setIsExtension(boolean z) {
                this.bitField0_ |= 2;
                this.isExtension_ = z;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setNamePart(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 1;
                this.namePart_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setNamePartBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 1;
                this.namePart_ = byteString.toStringUtf8();
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                boolean z = false;
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new NamePart();
                    case 2:
                        byte b = this.memoizedIsInitialized;
                        if (b == 1) {
                            return DEFAULT_INSTANCE;
                        }
                        if (b == 0) {
                            return null;
                        }
                        boolean booleanValue = ((Boolean) obj).booleanValue();
                        if (!hasNamePart()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = (byte) 0;
                            }
                            return null;
                        }
                        if (hasIsExtension()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = (byte) 1;
                            }
                            return DEFAULT_INSTANCE;
                        }
                        if (booleanValue) {
                            this.memoizedIsInitialized = (byte) 0;
                        }
                        return null;
                    case 3:
                        return null;
                    case 4:
                        return new Builder(anonymousClass1);
                    case 5:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        NamePart namePart = (NamePart) obj2;
                        this.namePart_ = visitor.visitString(hasNamePart(), this.namePart_, namePart.hasNamePart(), namePart.namePart_);
                        this.isExtension_ = visitor.visitBoolean(hasIsExtension(), this.isExtension_, namePart.hasIsExtension(), namePart.isExtension_);
                        if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                            this.bitField0_ |= namePart.bitField0_;
                        }
                        return this;
                    case 6:
                        CodedInputStream codedInputStream = (CodedInputStream) obj;
                        while (!z) {
                            try {
                                int readTag = codedInputStream.readTag();
                                if (readTag != 0) {
                                    if (readTag == 10) {
                                        String readString = codedInputStream.readString();
                                        this.bitField0_ |= 1;
                                        this.namePart_ = readString;
                                    } else if (readTag == 16) {
                                        this.bitField0_ |= 2;
                                        this.isExtension_ = codedInputStream.readBool();
                                    } else if (!a(readTag, codedInputStream)) {
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
                            synchronized (NamePart.class) {
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

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOption.NamePartOrBuilder
            public boolean getIsExtension() {
                return this.isExtension_;
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOption.NamePartOrBuilder
            public String getNamePart() {
                return this.namePart_;
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOption.NamePartOrBuilder
            public ByteString getNamePartBytes() {
                return ByteString.copyFromUtf8(this.namePart_);
            }

            @Override // com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.c;
                if (i != -1) {
                    return i;
                }
                int computeStringSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeStringSize(1, getNamePart()) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    computeStringSize += CodedOutputStream.computeBoolSize(2, this.isExtension_);
                }
                int serializedSize = computeStringSize + this.b.getSerializedSize();
                this.c = serializedSize;
                return serializedSize;
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOption.NamePartOrBuilder
            public boolean hasIsExtension() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOption.NamePartOrBuilder
            public boolean hasNamePart() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) {
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.writeString(1, getNamePart());
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.writeBool(2, this.isExtension_);
                }
                this.b.writeTo(codedOutputStream);
            }
        }

        /* loaded from: classes2.dex */
        public interface NamePartOrBuilder extends MessageLiteOrBuilder {
            boolean getIsExtension();

            String getNamePart();

            ByteString getNamePartBytes();

            boolean hasIsExtension();

            boolean hasNamePart();
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private UninterpretedOption() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllName(Iterable<? extends NamePart> iterable) {
            ensureNameIsMutable();
            AbstractMessageLite.a(iterable, this.name_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addName(int i, NamePart.Builder builder) {
            ensureNameIsMutable();
            this.name_.add(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addName(int i, NamePart namePart) {
            if (namePart == null) {
                throw new NullPointerException();
            }
            ensureNameIsMutable();
            this.name_.add(i, namePart);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addName(NamePart.Builder builder) {
            ensureNameIsMutable();
            this.name_.add(builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addName(NamePart namePart) {
            if (namePart == null) {
                throw new NullPointerException();
            }
            ensureNameIsMutable();
            this.name_.add(namePart);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAggregateValue() {
            this.bitField0_ &= -33;
            this.aggregateValue_ = getDefaultInstance().getAggregateValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDoubleValue() {
            this.bitField0_ &= -9;
            this.doubleValue_ = 0.0d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIdentifierValue() {
            this.bitField0_ &= -2;
            this.identifierValue_ = getDefaultInstance().getIdentifierValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearName() {
            this.name_ = GeneratedMessageLite.f();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNegativeIntValue() {
            this.bitField0_ &= -5;
            this.negativeIntValue_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPositiveIntValue() {
            this.bitField0_ &= -3;
            this.positiveIntValue_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStringValue() {
            this.bitField0_ &= -17;
            this.stringValue_ = getDefaultInstance().getStringValue();
        }

        private void ensureNameIsMutable() {
            if (this.name_.isModifiable()) {
                return;
            }
            this.name_ = GeneratedMessageLite.a(this.name_);
        }

        public static UninterpretedOption getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(UninterpretedOption uninterpretedOption) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) uninterpretedOption);
        }

        public static UninterpretedOption parseDelimitedFrom(InputStream inputStream) {
            return (UninterpretedOption) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static UninterpretedOption parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (UninterpretedOption) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UninterpretedOption parseFrom(ByteString byteString) {
            return (UninterpretedOption) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static UninterpretedOption parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (UninterpretedOption) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static UninterpretedOption parseFrom(CodedInputStream codedInputStream) {
            return (UninterpretedOption) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static UninterpretedOption parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (UninterpretedOption) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static UninterpretedOption parseFrom(InputStream inputStream) {
            return (UninterpretedOption) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static UninterpretedOption parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (UninterpretedOption) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UninterpretedOption parseFrom(byte[] bArr) {
            return (UninterpretedOption) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static UninterpretedOption parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (UninterpretedOption) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<UninterpretedOption> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeName(int i) {
            ensureNameIsMutable();
            this.name_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAggregateValue(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 32;
            this.aggregateValue_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAggregateValueBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 32;
            this.aggregateValue_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDoubleValue(double d) {
            this.bitField0_ |= 8;
            this.doubleValue_ = d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIdentifierValue(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 1;
            this.identifierValue_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIdentifierValueBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 1;
            this.identifierValue_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setName(int i, NamePart.Builder builder) {
            ensureNameIsMutable();
            this.name_.set(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setName(int i, NamePart namePart) {
            if (namePart == null) {
                throw new NullPointerException();
            }
            ensureNameIsMutable();
            this.name_.set(i, namePart);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNegativeIntValue(long j) {
            this.bitField0_ |= 4;
            this.negativeIntValue_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPositiveIntValue(long j) {
            this.bitField0_ |= 2;
            this.positiveIntValue_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStringValue(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 16;
            this.stringValue_ = byteString;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new UninterpretedOption();
                case 2:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i = 0; i < getNameCount(); i++) {
                        if (!getName(i).isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = (byte) 0;
                            }
                            return null;
                        }
                    }
                    if (booleanValue) {
                        this.memoizedIsInitialized = (byte) 1;
                    }
                    return DEFAULT_INSTANCE;
                case 3:
                    this.name_.makeImmutable();
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    UninterpretedOption uninterpretedOption = (UninterpretedOption) obj2;
                    this.name_ = visitor.visitList(this.name_, uninterpretedOption.name_);
                    this.identifierValue_ = visitor.visitString(hasIdentifierValue(), this.identifierValue_, uninterpretedOption.hasIdentifierValue(), uninterpretedOption.identifierValue_);
                    this.positiveIntValue_ = visitor.visitLong(hasPositiveIntValue(), this.positiveIntValue_, uninterpretedOption.hasPositiveIntValue(), uninterpretedOption.positiveIntValue_);
                    this.negativeIntValue_ = visitor.visitLong(hasNegativeIntValue(), this.negativeIntValue_, uninterpretedOption.hasNegativeIntValue(), uninterpretedOption.negativeIntValue_);
                    this.doubleValue_ = visitor.visitDouble(hasDoubleValue(), this.doubleValue_, uninterpretedOption.hasDoubleValue(), uninterpretedOption.doubleValue_);
                    this.stringValue_ = visitor.visitByteString(hasStringValue(), this.stringValue_, uninterpretedOption.hasStringValue(), uninterpretedOption.stringValue_);
                    this.aggregateValue_ = visitor.visitString(hasAggregateValue(), this.aggregateValue_, uninterpretedOption.hasAggregateValue(), uninterpretedOption.aggregateValue_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= uninterpretedOption.bitField0_;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 18) {
                                    if (!this.name_.isModifiable()) {
                                        this.name_ = GeneratedMessageLite.a(this.name_);
                                    }
                                    this.name_.add((NamePart) codedInputStream.readMessage(NamePart.parser(), extensionRegistryLite));
                                } else if (readTag == 26) {
                                    String readString = codedInputStream.readString();
                                    this.bitField0_ |= 1;
                                    this.identifierValue_ = readString;
                                } else if (readTag == 32) {
                                    this.bitField0_ |= 2;
                                    this.positiveIntValue_ = codedInputStream.readUInt64();
                                } else if (readTag == 40) {
                                    this.bitField0_ |= 4;
                                    this.negativeIntValue_ = codedInputStream.readInt64();
                                } else if (readTag == 49) {
                                    this.bitField0_ |= 8;
                                    this.doubleValue_ = codedInputStream.readDouble();
                                } else if (readTag == 58) {
                                    this.bitField0_ |= 16;
                                    this.stringValue_ = codedInputStream.readBytes();
                                } else if (readTag == 66) {
                                    String readString2 = codedInputStream.readString();
                                    this.bitField0_ = 32 | this.bitField0_;
                                    this.aggregateValue_ = readString2;
                                } else if (!a(readTag, codedInputStream)) {
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
                        synchronized (UninterpretedOption.class) {
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

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public String getAggregateValue() {
            return this.aggregateValue_;
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public ByteString getAggregateValueBytes() {
            return ByteString.copyFromUtf8(this.aggregateValue_);
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public double getDoubleValue() {
            return this.doubleValue_;
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public String getIdentifierValue() {
            return this.identifierValue_;
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public ByteString getIdentifierValueBytes() {
            return ByteString.copyFromUtf8(this.identifierValue_);
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public NamePart getName(int i) {
            return this.name_.get(i);
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public int getNameCount() {
            return this.name_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public List<NamePart> getNameList() {
            return this.name_;
        }

        public NamePartOrBuilder getNameOrBuilder(int i) {
            return this.name_.get(i);
        }

        public List<? extends NamePartOrBuilder> getNameOrBuilderList() {
            return this.name_;
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public long getNegativeIntValue() {
            return this.negativeIntValue_;
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public long getPositiveIntValue() {
            return this.positiveIntValue_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.name_.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(2, this.name_.get(i3));
            }
            if ((this.bitField0_ & 1) == 1) {
                i2 += CodedOutputStream.computeStringSize(3, getIdentifierValue());
            }
            if ((this.bitField0_ & 2) == 2) {
                i2 += CodedOutputStream.computeUInt64Size(4, this.positiveIntValue_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i2 += CodedOutputStream.computeInt64Size(5, this.negativeIntValue_);
            }
            if ((this.bitField0_ & 8) == 8) {
                i2 += CodedOutputStream.computeDoubleSize(6, this.doubleValue_);
            }
            if ((this.bitField0_ & 16) == 16) {
                i2 += CodedOutputStream.computeBytesSize(7, this.stringValue_);
            }
            if ((this.bitField0_ & 32) == 32) {
                i2 += CodedOutputStream.computeStringSize(8, getAggregateValue());
            }
            int serializedSize = i2 + this.b.getSerializedSize();
            this.c = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public ByteString getStringValue() {
            return this.stringValue_;
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public boolean hasAggregateValue() {
            return (this.bitField0_ & 32) == 32;
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public boolean hasDoubleValue() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public boolean hasIdentifierValue() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public boolean hasNegativeIntValue() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public boolean hasPositiveIntValue() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public boolean hasStringValue() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            for (int i = 0; i < this.name_.size(); i++) {
                codedOutputStream.writeMessage(2, this.name_.get(i));
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeString(3, getIdentifierValue());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeUInt64(4, this.positiveIntValue_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt64(5, this.negativeIntValue_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeDouble(6, this.doubleValue_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeBytes(7, this.stringValue_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeString(8, getAggregateValue());
            }
            this.b.writeTo(codedOutputStream);
        }
    }

    /* loaded from: classes2.dex */
    public interface UninterpretedOptionOrBuilder extends MessageLiteOrBuilder {
        String getAggregateValue();

        ByteString getAggregateValueBytes();

        double getDoubleValue();

        String getIdentifierValue();

        ByteString getIdentifierValueBytes();

        UninterpretedOption.NamePart getName(int i);

        int getNameCount();

        List<UninterpretedOption.NamePart> getNameList();

        long getNegativeIntValue();

        long getPositiveIntValue();

        ByteString getStringValue();

        boolean hasAggregateValue();

        boolean hasDoubleValue();

        boolean hasIdentifierValue();

        boolean hasNegativeIntValue();

        boolean hasPositiveIntValue();

        boolean hasStringValue();
    }

    private DescriptorProtos() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
