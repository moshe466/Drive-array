package com.google.firestore.v1;

import com.google.firestore.v1.ArrayValue;
import com.google.firestore.v1.Value;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class DocumentTransform extends GeneratedMessageLite<DocumentTransform, Builder> implements DocumentTransformOrBuilder {
    private static final DocumentTransform DEFAULT_INSTANCE = new DocumentTransform();
    public static final int DOCUMENT_FIELD_NUMBER = 1;
    public static final int FIELD_TRANSFORMS_FIELD_NUMBER = 2;
    private static volatile Parser<DocumentTransform> PARSER;
    private int bitField0_;
    private String document_ = "";
    private Internal.ProtobufList<FieldTransform> fieldTransforms_ = GeneratedMessageLite.f();

    /* renamed from: com.google.firestore.v1.DocumentTransform$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b = new int[GeneratedMessageLite.MethodToInvoke.values().length];

        static {
            try {
                b[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[GeneratedMessageLite.MethodToInvoke.IS_INITIALIZED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[GeneratedMessageLite.MethodToInvoke.MAKE_IMMUTABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[GeneratedMessageLite.MethodToInvoke.VISIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[GeneratedMessageLite.MethodToInvoke.MERGE_FROM_STREAM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            a = new int[FieldTransform.TransformTypeCase.values().length];
            try {
                a[FieldTransform.TransformTypeCase.SET_TO_SERVER_VALUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[FieldTransform.TransformTypeCase.INCREMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[FieldTransform.TransformTypeCase.MAXIMUM.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[FieldTransform.TransformTypeCase.MINIMUM.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[FieldTransform.TransformTypeCase.APPEND_MISSING_ELEMENTS.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[FieldTransform.TransformTypeCase.REMOVE_ALL_FROM_ARRAY.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[FieldTransform.TransformTypeCase.TRANSFORMTYPE_NOT_SET.ordinal()] = 7;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<DocumentTransform, Builder> implements DocumentTransformOrBuilder {
        private Builder() {
            super(DocumentTransform.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllFieldTransforms(Iterable<? extends FieldTransform> iterable) {
            a();
            ((DocumentTransform) this.a).addAllFieldTransforms(iterable);
            return this;
        }

        public Builder addFieldTransforms(int i, FieldTransform.Builder builder) {
            a();
            ((DocumentTransform) this.a).addFieldTransforms(i, builder);
            return this;
        }

        public Builder addFieldTransforms(int i, FieldTransform fieldTransform) {
            a();
            ((DocumentTransform) this.a).addFieldTransforms(i, fieldTransform);
            return this;
        }

        public Builder addFieldTransforms(FieldTransform.Builder builder) {
            a();
            ((DocumentTransform) this.a).addFieldTransforms(builder);
            return this;
        }

        public Builder addFieldTransforms(FieldTransform fieldTransform) {
            a();
            ((DocumentTransform) this.a).addFieldTransforms(fieldTransform);
            return this;
        }

        public Builder clearDocument() {
            a();
            ((DocumentTransform) this.a).clearDocument();
            return this;
        }

        public Builder clearFieldTransforms() {
            a();
            ((DocumentTransform) this.a).clearFieldTransforms();
            return this;
        }

        @Override // com.google.firestore.v1.DocumentTransformOrBuilder
        public String getDocument() {
            return ((DocumentTransform) this.a).getDocument();
        }

        @Override // com.google.firestore.v1.DocumentTransformOrBuilder
        public ByteString getDocumentBytes() {
            return ((DocumentTransform) this.a).getDocumentBytes();
        }

        @Override // com.google.firestore.v1.DocumentTransformOrBuilder
        public FieldTransform getFieldTransforms(int i) {
            return ((DocumentTransform) this.a).getFieldTransforms(i);
        }

        @Override // com.google.firestore.v1.DocumentTransformOrBuilder
        public int getFieldTransformsCount() {
            return ((DocumentTransform) this.a).getFieldTransformsCount();
        }

        @Override // com.google.firestore.v1.DocumentTransformOrBuilder
        public List<FieldTransform> getFieldTransformsList() {
            return Collections.unmodifiableList(((DocumentTransform) this.a).getFieldTransformsList());
        }

        public Builder removeFieldTransforms(int i) {
            a();
            ((DocumentTransform) this.a).removeFieldTransforms(i);
            return this;
        }

        public Builder setDocument(String str) {
            a();
            ((DocumentTransform) this.a).setDocument(str);
            return this;
        }

        public Builder setDocumentBytes(ByteString byteString) {
            a();
            ((DocumentTransform) this.a).setDocumentBytes(byteString);
            return this;
        }

        public Builder setFieldTransforms(int i, FieldTransform.Builder builder) {
            a();
            ((DocumentTransform) this.a).setFieldTransforms(i, builder);
            return this;
        }

        public Builder setFieldTransforms(int i, FieldTransform fieldTransform) {
            a();
            ((DocumentTransform) this.a).setFieldTransforms(i, fieldTransform);
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static final class FieldTransform extends GeneratedMessageLite<FieldTransform, Builder> implements FieldTransformOrBuilder {
        public static final int APPEND_MISSING_ELEMENTS_FIELD_NUMBER = 6;
        private static final FieldTransform DEFAULT_INSTANCE = new FieldTransform();
        public static final int FIELD_PATH_FIELD_NUMBER = 1;
        public static final int INCREMENT_FIELD_NUMBER = 3;
        public static final int MAXIMUM_FIELD_NUMBER = 4;
        public static final int MINIMUM_FIELD_NUMBER = 5;
        private static volatile Parser<FieldTransform> PARSER = null;
        public static final int REMOVE_ALL_FROM_ARRAY_FIELD_NUMBER = 7;
        public static final int SET_TO_SERVER_VALUE_FIELD_NUMBER = 2;
        private Object transformType_;
        private int transformTypeCase_ = 0;
        private String fieldPath_ = "";

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<FieldTransform, Builder> implements FieldTransformOrBuilder {
            private Builder() {
                super(FieldTransform.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAppendMissingElements() {
                a();
                ((FieldTransform) this.a).clearAppendMissingElements();
                return this;
            }

            public Builder clearFieldPath() {
                a();
                ((FieldTransform) this.a).clearFieldPath();
                return this;
            }

            public Builder clearIncrement() {
                a();
                ((FieldTransform) this.a).clearIncrement();
                return this;
            }

            public Builder clearMaximum() {
                a();
                ((FieldTransform) this.a).clearMaximum();
                return this;
            }

            public Builder clearMinimum() {
                a();
                ((FieldTransform) this.a).clearMinimum();
                return this;
            }

            public Builder clearRemoveAllFromArray() {
                a();
                ((FieldTransform) this.a).clearRemoveAllFromArray();
                return this;
            }

            public Builder clearSetToServerValue() {
                a();
                ((FieldTransform) this.a).clearSetToServerValue();
                return this;
            }

            public Builder clearTransformType() {
                a();
                ((FieldTransform) this.a).clearTransformType();
                return this;
            }

            @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
            public ArrayValue getAppendMissingElements() {
                return ((FieldTransform) this.a).getAppendMissingElements();
            }

            @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
            public String getFieldPath() {
                return ((FieldTransform) this.a).getFieldPath();
            }

            @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
            public ByteString getFieldPathBytes() {
                return ((FieldTransform) this.a).getFieldPathBytes();
            }

            @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
            public Value getIncrement() {
                return ((FieldTransform) this.a).getIncrement();
            }

            @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
            public Value getMaximum() {
                return ((FieldTransform) this.a).getMaximum();
            }

            @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
            public Value getMinimum() {
                return ((FieldTransform) this.a).getMinimum();
            }

            @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
            public ArrayValue getRemoveAllFromArray() {
                return ((FieldTransform) this.a).getRemoveAllFromArray();
            }

            @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
            public ServerValue getSetToServerValue() {
                return ((FieldTransform) this.a).getSetToServerValue();
            }

            @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
            public int getSetToServerValueValue() {
                return ((FieldTransform) this.a).getSetToServerValueValue();
            }

            @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
            public TransformTypeCase getTransformTypeCase() {
                return ((FieldTransform) this.a).getTransformTypeCase();
            }

            public Builder mergeAppendMissingElements(ArrayValue arrayValue) {
                a();
                ((FieldTransform) this.a).mergeAppendMissingElements(arrayValue);
                return this;
            }

            public Builder mergeIncrement(Value value) {
                a();
                ((FieldTransform) this.a).mergeIncrement(value);
                return this;
            }

            public Builder mergeMaximum(Value value) {
                a();
                ((FieldTransform) this.a).mergeMaximum(value);
                return this;
            }

            public Builder mergeMinimum(Value value) {
                a();
                ((FieldTransform) this.a).mergeMinimum(value);
                return this;
            }

            public Builder mergeRemoveAllFromArray(ArrayValue arrayValue) {
                a();
                ((FieldTransform) this.a).mergeRemoveAllFromArray(arrayValue);
                return this;
            }

            public Builder setAppendMissingElements(ArrayValue.Builder builder) {
                a();
                ((FieldTransform) this.a).setAppendMissingElements(builder);
                return this;
            }

            public Builder setAppendMissingElements(ArrayValue arrayValue) {
                a();
                ((FieldTransform) this.a).setAppendMissingElements(arrayValue);
                return this;
            }

            public Builder setFieldPath(String str) {
                a();
                ((FieldTransform) this.a).setFieldPath(str);
                return this;
            }

            public Builder setFieldPathBytes(ByteString byteString) {
                a();
                ((FieldTransform) this.a).setFieldPathBytes(byteString);
                return this;
            }

            public Builder setIncrement(Value.Builder builder) {
                a();
                ((FieldTransform) this.a).setIncrement(builder);
                return this;
            }

            public Builder setIncrement(Value value) {
                a();
                ((FieldTransform) this.a).setIncrement(value);
                return this;
            }

            public Builder setMaximum(Value.Builder builder) {
                a();
                ((FieldTransform) this.a).setMaximum(builder);
                return this;
            }

            public Builder setMaximum(Value value) {
                a();
                ((FieldTransform) this.a).setMaximum(value);
                return this;
            }

            public Builder setMinimum(Value.Builder builder) {
                a();
                ((FieldTransform) this.a).setMinimum(builder);
                return this;
            }

            public Builder setMinimum(Value value) {
                a();
                ((FieldTransform) this.a).setMinimum(value);
                return this;
            }

            public Builder setRemoveAllFromArray(ArrayValue.Builder builder) {
                a();
                ((FieldTransform) this.a).setRemoveAllFromArray(builder);
                return this;
            }

            public Builder setRemoveAllFromArray(ArrayValue arrayValue) {
                a();
                ((FieldTransform) this.a).setRemoveAllFromArray(arrayValue);
                return this;
            }

            public Builder setSetToServerValue(ServerValue serverValue) {
                a();
                ((FieldTransform) this.a).setSetToServerValue(serverValue);
                return this;
            }

            public Builder setSetToServerValueValue(int i) {
                a();
                ((FieldTransform) this.a).setSetToServerValueValue(i);
                return this;
            }
        }

        /* loaded from: classes2.dex */
        public enum ServerValue implements Internal.EnumLite {
            SERVER_VALUE_UNSPECIFIED(0),
            REQUEST_TIME(1),
            UNRECOGNIZED(-1);

            public static final int REQUEST_TIME_VALUE = 1;
            public static final int SERVER_VALUE_UNSPECIFIED_VALUE = 0;
            private static final Internal.EnumLiteMap<ServerValue> internalValueMap = new Internal.EnumLiteMap<ServerValue>() { // from class: com.google.firestore.v1.DocumentTransform.FieldTransform.ServerValue.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public ServerValue findValueByNumber(int i) {
                    return ServerValue.forNumber(i);
                }
            };
            private final int value;

            ServerValue(int i) {
                this.value = i;
            }

            public static ServerValue forNumber(int i) {
                if (i == 0) {
                    return SERVER_VALUE_UNSPECIFIED;
                }
                if (i != 1) {
                    return null;
                }
                return REQUEST_TIME;
            }

            public static Internal.EnumLiteMap<ServerValue> internalGetValueMap() {
                return internalValueMap;
            }

            @Deprecated
            public static ServerValue valueOf(int i) {
                return forNumber(i);
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }
        }

        /* loaded from: classes2.dex */
        public enum TransformTypeCase implements Internal.EnumLite {
            SET_TO_SERVER_VALUE(2),
            INCREMENT(3),
            MAXIMUM(4),
            MINIMUM(5),
            APPEND_MISSING_ELEMENTS(6),
            REMOVE_ALL_FROM_ARRAY(7),
            TRANSFORMTYPE_NOT_SET(0);

            private final int value;

            TransformTypeCase(int i) {
                this.value = i;
            }

            public static TransformTypeCase forNumber(int i) {
                if (i == 0) {
                    return TRANSFORMTYPE_NOT_SET;
                }
                switch (i) {
                    case 2:
                        return SET_TO_SERVER_VALUE;
                    case 3:
                        return INCREMENT;
                    case 4:
                        return MAXIMUM;
                    case 5:
                        return MINIMUM;
                    case 6:
                        return APPEND_MISSING_ELEMENTS;
                    case 7:
                        return REMOVE_ALL_FROM_ARRAY;
                    default:
                        return null;
                }
            }

            @Deprecated
            public static TransformTypeCase valueOf(int i) {
                return forNumber(i);
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private FieldTransform() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppendMissingElements() {
            if (this.transformTypeCase_ == 6) {
                this.transformTypeCase_ = 0;
                this.transformType_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFieldPath() {
            this.fieldPath_ = getDefaultInstance().getFieldPath();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIncrement() {
            if (this.transformTypeCase_ == 3) {
                this.transformTypeCase_ = 0;
                this.transformType_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMaximum() {
            if (this.transformTypeCase_ == 4) {
                this.transformTypeCase_ = 0;
                this.transformType_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMinimum() {
            if (this.transformTypeCase_ == 5) {
                this.transformTypeCase_ = 0;
                this.transformType_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRemoveAllFromArray() {
            if (this.transformTypeCase_ == 7) {
                this.transformTypeCase_ = 0;
                this.transformType_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSetToServerValue() {
            if (this.transformTypeCase_ == 2) {
                this.transformTypeCase_ = 0;
                this.transformType_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTransformType() {
            this.transformTypeCase_ = 0;
            this.transformType_ = null;
        }

        public static FieldTransform getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeAppendMissingElements(ArrayValue arrayValue) {
            if (this.transformTypeCase_ == 6 && this.transformType_ != ArrayValue.getDefaultInstance()) {
                arrayValue = ArrayValue.newBuilder((ArrayValue) this.transformType_).mergeFrom((ArrayValue.Builder) arrayValue).buildPartial();
            }
            this.transformType_ = arrayValue;
            this.transformTypeCase_ = 6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeIncrement(Value value) {
            if (this.transformTypeCase_ == 3 && this.transformType_ != Value.getDefaultInstance()) {
                value = Value.newBuilder((Value) this.transformType_).mergeFrom((Value.Builder) value).buildPartial();
            }
            this.transformType_ = value;
            this.transformTypeCase_ = 3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeMaximum(Value value) {
            if (this.transformTypeCase_ == 4 && this.transformType_ != Value.getDefaultInstance()) {
                value = Value.newBuilder((Value) this.transformType_).mergeFrom((Value.Builder) value).buildPartial();
            }
            this.transformType_ = value;
            this.transformTypeCase_ = 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeMinimum(Value value) {
            if (this.transformTypeCase_ == 5 && this.transformType_ != Value.getDefaultInstance()) {
                value = Value.newBuilder((Value) this.transformType_).mergeFrom((Value.Builder) value).buildPartial();
            }
            this.transformType_ = value;
            this.transformTypeCase_ = 5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeRemoveAllFromArray(ArrayValue arrayValue) {
            if (this.transformTypeCase_ == 7 && this.transformType_ != ArrayValue.getDefaultInstance()) {
                arrayValue = ArrayValue.newBuilder((ArrayValue) this.transformType_).mergeFrom((ArrayValue.Builder) arrayValue).buildPartial();
            }
            this.transformType_ = arrayValue;
            this.transformTypeCase_ = 7;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FieldTransform fieldTransform) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) fieldTransform);
        }

        public static FieldTransform parseDelimitedFrom(InputStream inputStream) {
            return (FieldTransform) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static FieldTransform parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (FieldTransform) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FieldTransform parseFrom(ByteString byteString) {
            return (FieldTransform) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static FieldTransform parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (FieldTransform) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static FieldTransform parseFrom(CodedInputStream codedInputStream) {
            return (FieldTransform) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static FieldTransform parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (FieldTransform) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static FieldTransform parseFrom(InputStream inputStream) {
            return (FieldTransform) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static FieldTransform parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (FieldTransform) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FieldTransform parseFrom(byte[] bArr) {
            return (FieldTransform) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static FieldTransform parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (FieldTransform) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<FieldTransform> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppendMissingElements(ArrayValue.Builder builder) {
            this.transformType_ = builder.build();
            this.transformTypeCase_ = 6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppendMissingElements(ArrayValue arrayValue) {
            if (arrayValue == null) {
                throw new NullPointerException();
            }
            this.transformType_ = arrayValue;
            this.transformTypeCase_ = 6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFieldPath(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.fieldPath_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFieldPathBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.a(byteString);
            this.fieldPath_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIncrement(Value.Builder builder) {
            this.transformType_ = builder.build();
            this.transformTypeCase_ = 3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIncrement(Value value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.transformType_ = value;
            this.transformTypeCase_ = 3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMaximum(Value.Builder builder) {
            this.transformType_ = builder.build();
            this.transformTypeCase_ = 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMaximum(Value value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.transformType_ = value;
            this.transformTypeCase_ = 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMinimum(Value.Builder builder) {
            this.transformType_ = builder.build();
            this.transformTypeCase_ = 5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMinimum(Value value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.transformType_ = value;
            this.transformTypeCase_ = 5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRemoveAllFromArray(ArrayValue.Builder builder) {
            this.transformType_ = builder.build();
            this.transformTypeCase_ = 7;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRemoveAllFromArray(ArrayValue arrayValue) {
            if (arrayValue == null) {
                throw new NullPointerException();
            }
            this.transformType_ = arrayValue;
            this.transformTypeCase_ = 7;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSetToServerValue(ServerValue serverValue) {
            if (serverValue == null) {
                throw new NullPointerException();
            }
            this.transformTypeCase_ = 2;
            this.transformType_ = Integer.valueOf(serverValue.getNumber());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSetToServerValueValue(int i) {
            this.transformTypeCase_ = 2;
            this.transformType_ = Integer.valueOf(i);
        }

        /* JADX WARN: Code restructure failed: missing block: B:132:0x01bb, code lost:
        
            if (r11.transformTypeCase_ == 7) goto L117;
         */
        /* JADX WARN: Code restructure failed: missing block: B:133:0x01d2, code lost:
        
            r12 = r13.visitOneofMessage(r7, r11.transformType_, r14.transformType_);
         */
        /* JADX WARN: Code restructure failed: missing block: B:135:0x01d1, code lost:
        
            r7 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:137:0x01c0, code lost:
        
            if (r11.transformTypeCase_ == 6) goto L117;
         */
        /* JADX WARN: Code restructure failed: missing block: B:139:0x01c5, code lost:
        
            if (r11.transformTypeCase_ == 5) goto L117;
         */
        /* JADX WARN: Code restructure failed: missing block: B:141:0x01ca, code lost:
        
            if (r11.transformTypeCase_ == 4) goto L117;
         */
        /* JADX WARN: Code restructure failed: missing block: B:143:0x01cf, code lost:
        
            if (r11.transformTypeCase_ == 3) goto L117;
         */
        @Override // com.google.protobuf.GeneratedMessageLite
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected final java.lang.Object a(com.google.protobuf.GeneratedMessageLite.MethodToInvoke r12, java.lang.Object r13, java.lang.Object r14) {
            /*
                Method dump skipped, instructions count: 556
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firestore.v1.DocumentTransform.FieldTransform.a(com.google.protobuf.GeneratedMessageLite$MethodToInvoke, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
        public ArrayValue getAppendMissingElements() {
            return this.transformTypeCase_ == 6 ? (ArrayValue) this.transformType_ : ArrayValue.getDefaultInstance();
        }

        @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
        public String getFieldPath() {
            return this.fieldPath_;
        }

        @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
        public ByteString getFieldPathBytes() {
            return ByteString.copyFromUtf8(this.fieldPath_);
        }

        @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
        public Value getIncrement() {
            return this.transformTypeCase_ == 3 ? (Value) this.transformType_ : Value.getDefaultInstance();
        }

        @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
        public Value getMaximum() {
            return this.transformTypeCase_ == 4 ? (Value) this.transformType_ : Value.getDefaultInstance();
        }

        @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
        public Value getMinimum() {
            return this.transformTypeCase_ == 5 ? (Value) this.transformType_ : Value.getDefaultInstance();
        }

        @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
        public ArrayValue getRemoveAllFromArray() {
            return this.transformTypeCase_ == 7 ? (ArrayValue) this.transformType_ : ArrayValue.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeStringSize = this.fieldPath_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getFieldPath());
            if (this.transformTypeCase_ == 2) {
                computeStringSize += CodedOutputStream.computeEnumSize(2, ((Integer) this.transformType_).intValue());
            }
            if (this.transformTypeCase_ == 3) {
                computeStringSize += CodedOutputStream.computeMessageSize(3, (Value) this.transformType_);
            }
            if (this.transformTypeCase_ == 4) {
                computeStringSize += CodedOutputStream.computeMessageSize(4, (Value) this.transformType_);
            }
            if (this.transformTypeCase_ == 5) {
                computeStringSize += CodedOutputStream.computeMessageSize(5, (Value) this.transformType_);
            }
            if (this.transformTypeCase_ == 6) {
                computeStringSize += CodedOutputStream.computeMessageSize(6, (ArrayValue) this.transformType_);
            }
            if (this.transformTypeCase_ == 7) {
                computeStringSize += CodedOutputStream.computeMessageSize(7, (ArrayValue) this.transformType_);
            }
            this.c = computeStringSize;
            return computeStringSize;
        }

        @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
        public ServerValue getSetToServerValue() {
            if (this.transformTypeCase_ != 2) {
                return ServerValue.SERVER_VALUE_UNSPECIFIED;
            }
            ServerValue forNumber = ServerValue.forNumber(((Integer) this.transformType_).intValue());
            return forNumber == null ? ServerValue.UNRECOGNIZED : forNumber;
        }

        @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
        public int getSetToServerValueValue() {
            if (this.transformTypeCase_ == 2) {
                return ((Integer) this.transformType_).intValue();
            }
            return 0;
        }

        @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
        public TransformTypeCase getTransformTypeCase() {
            return TransformTypeCase.forNumber(this.transformTypeCase_);
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if (!this.fieldPath_.isEmpty()) {
                codedOutputStream.writeString(1, getFieldPath());
            }
            if (this.transformTypeCase_ == 2) {
                codedOutputStream.writeEnum(2, ((Integer) this.transformType_).intValue());
            }
            if (this.transformTypeCase_ == 3) {
                codedOutputStream.writeMessage(3, (Value) this.transformType_);
            }
            if (this.transformTypeCase_ == 4) {
                codedOutputStream.writeMessage(4, (Value) this.transformType_);
            }
            if (this.transformTypeCase_ == 5) {
                codedOutputStream.writeMessage(5, (Value) this.transformType_);
            }
            if (this.transformTypeCase_ == 6) {
                codedOutputStream.writeMessage(6, (ArrayValue) this.transformType_);
            }
            if (this.transformTypeCase_ == 7) {
                codedOutputStream.writeMessage(7, (ArrayValue) this.transformType_);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface FieldTransformOrBuilder extends MessageLiteOrBuilder {
        ArrayValue getAppendMissingElements();

        String getFieldPath();

        ByteString getFieldPathBytes();

        Value getIncrement();

        Value getMaximum();

        Value getMinimum();

        ArrayValue getRemoveAllFromArray();

        FieldTransform.ServerValue getSetToServerValue();

        int getSetToServerValueValue();

        FieldTransform.TransformTypeCase getTransformTypeCase();
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private DocumentTransform() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllFieldTransforms(Iterable<? extends FieldTransform> iterable) {
        ensureFieldTransformsIsMutable();
        AbstractMessageLite.a(iterable, this.fieldTransforms_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFieldTransforms(int i, FieldTransform.Builder builder) {
        ensureFieldTransformsIsMutable();
        this.fieldTransforms_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFieldTransforms(int i, FieldTransform fieldTransform) {
        if (fieldTransform == null) {
            throw new NullPointerException();
        }
        ensureFieldTransformsIsMutable();
        this.fieldTransforms_.add(i, fieldTransform);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFieldTransforms(FieldTransform.Builder builder) {
        ensureFieldTransformsIsMutable();
        this.fieldTransforms_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFieldTransforms(FieldTransform fieldTransform) {
        if (fieldTransform == null) {
            throw new NullPointerException();
        }
        ensureFieldTransformsIsMutable();
        this.fieldTransforms_.add(fieldTransform);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDocument() {
        this.document_ = getDefaultInstance().getDocument();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFieldTransforms() {
        this.fieldTransforms_ = GeneratedMessageLite.f();
    }

    private void ensureFieldTransformsIsMutable() {
        if (this.fieldTransforms_.isModifiable()) {
            return;
        }
        this.fieldTransforms_ = GeneratedMessageLite.a(this.fieldTransforms_);
    }

    public static DocumentTransform getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(DocumentTransform documentTransform) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) documentTransform);
    }

    public static DocumentTransform parseDelimitedFrom(InputStream inputStream) {
        return (DocumentTransform) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static DocumentTransform parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DocumentTransform) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DocumentTransform parseFrom(ByteString byteString) {
        return (DocumentTransform) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static DocumentTransform parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DocumentTransform) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static DocumentTransform parseFrom(CodedInputStream codedInputStream) {
        return (DocumentTransform) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static DocumentTransform parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DocumentTransform) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static DocumentTransform parseFrom(InputStream inputStream) {
        return (DocumentTransform) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static DocumentTransform parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DocumentTransform) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DocumentTransform parseFrom(byte[] bArr) {
        return (DocumentTransform) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static DocumentTransform parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (DocumentTransform) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<DocumentTransform> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeFieldTransforms(int i) {
        ensureFieldTransformsIsMutable();
        this.fieldTransforms_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDocument(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.document_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDocumentBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.document_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFieldTransforms(int i, FieldTransform.Builder builder) {
        ensureFieldTransformsIsMutable();
        this.fieldTransforms_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFieldTransforms(int i, FieldTransform fieldTransform) {
        if (fieldTransform == null) {
            throw new NullPointerException();
        }
        ensureFieldTransformsIsMutable();
        this.fieldTransforms_.set(i, fieldTransform);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.b[methodToInvoke.ordinal()]) {
            case 1:
                return new DocumentTransform();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.fieldTransforms_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                DocumentTransform documentTransform = (DocumentTransform) obj2;
                this.document_ = visitor.visitString(!this.document_.isEmpty(), this.document_, true ^ documentTransform.document_.isEmpty(), documentTransform.document_);
                this.fieldTransforms_ = visitor.visitList(this.fieldTransforms_, documentTransform.fieldTransforms_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= documentTransform.bitField0_;
                }
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
                                    this.document_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 18) {
                                    if (!this.fieldTransforms_.isModifiable()) {
                                        this.fieldTransforms_ = GeneratedMessageLite.a(this.fieldTransforms_);
                                    }
                                    this.fieldTransforms_.add((FieldTransform) codedInputStream.readMessage(FieldTransform.parser(), extensionRegistryLite));
                                } else if (!codedInputStream.skipField(readTag)) {
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
                    synchronized (DocumentTransform.class) {
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

    @Override // com.google.firestore.v1.DocumentTransformOrBuilder
    public String getDocument() {
        return this.document_;
    }

    @Override // com.google.firestore.v1.DocumentTransformOrBuilder
    public ByteString getDocumentBytes() {
        return ByteString.copyFromUtf8(this.document_);
    }

    @Override // com.google.firestore.v1.DocumentTransformOrBuilder
    public FieldTransform getFieldTransforms(int i) {
        return this.fieldTransforms_.get(i);
    }

    @Override // com.google.firestore.v1.DocumentTransformOrBuilder
    public int getFieldTransformsCount() {
        return this.fieldTransforms_.size();
    }

    @Override // com.google.firestore.v1.DocumentTransformOrBuilder
    public List<FieldTransform> getFieldTransformsList() {
        return this.fieldTransforms_;
    }

    public FieldTransformOrBuilder getFieldTransformsOrBuilder(int i) {
        return this.fieldTransforms_.get(i);
    }

    public List<? extends FieldTransformOrBuilder> getFieldTransformsOrBuilderList() {
        return this.fieldTransforms_;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeStringSize = !this.document_.isEmpty() ? CodedOutputStream.computeStringSize(1, getDocument()) + 0 : 0;
        for (int i2 = 0; i2 < this.fieldTransforms_.size(); i2++) {
            computeStringSize += CodedOutputStream.computeMessageSize(2, this.fieldTransforms_.get(i2));
        }
        this.c = computeStringSize;
        return computeStringSize;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!this.document_.isEmpty()) {
            codedOutputStream.writeString(1, getDocument());
        }
        for (int i = 0; i < this.fieldTransforms_.size(); i++) {
            codedOutputStream.writeMessage(2, this.fieldTransforms_.get(i));
        }
    }
}
