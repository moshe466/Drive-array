package com.google.firestore.v1;

import com.google.firestore.v1.ArrayValue;
import com.google.firestore.v1.MapValue;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.NullValue;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp;
import com.google.type.LatLng;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class Value extends GeneratedMessageLite<Value, Builder> implements ValueOrBuilder {
    public static final int ARRAY_VALUE_FIELD_NUMBER = 9;
    public static final int BOOLEAN_VALUE_FIELD_NUMBER = 1;
    public static final int BYTES_VALUE_FIELD_NUMBER = 18;
    private static final Value DEFAULT_INSTANCE = new Value();
    public static final int DOUBLE_VALUE_FIELD_NUMBER = 3;
    public static final int GEO_POINT_VALUE_FIELD_NUMBER = 8;
    public static final int INTEGER_VALUE_FIELD_NUMBER = 2;
    public static final int MAP_VALUE_FIELD_NUMBER = 6;
    public static final int NULL_VALUE_FIELD_NUMBER = 11;
    private static volatile Parser<Value> PARSER = null;
    public static final int REFERENCE_VALUE_FIELD_NUMBER = 5;
    public static final int STRING_VALUE_FIELD_NUMBER = 17;
    public static final int TIMESTAMP_VALUE_FIELD_NUMBER = 10;
    private int valueTypeCase_ = 0;
    private Object valueType_;

    /* renamed from: com.google.firestore.v1.Value$1, reason: invalid class name */
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
            a = new int[ValueTypeCase.values().length];
            try {
                a[ValueTypeCase.NULL_VALUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[ValueTypeCase.BOOLEAN_VALUE.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[ValueTypeCase.INTEGER_VALUE.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[ValueTypeCase.DOUBLE_VALUE.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[ValueTypeCase.TIMESTAMP_VALUE.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[ValueTypeCase.STRING_VALUE.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[ValueTypeCase.BYTES_VALUE.ordinal()] = 7;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[ValueTypeCase.REFERENCE_VALUE.ordinal()] = 8;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                a[ValueTypeCase.GEO_POINT_VALUE.ordinal()] = 9;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                a[ValueTypeCase.ARRAY_VALUE.ordinal()] = 10;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                a[ValueTypeCase.MAP_VALUE.ordinal()] = 11;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                a[ValueTypeCase.VALUETYPE_NOT_SET.ordinal()] = 12;
            } catch (NoSuchFieldError unused20) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Value, Builder> implements ValueOrBuilder {
        private Builder() {
            super(Value.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearArrayValue() {
            a();
            ((Value) this.a).clearArrayValue();
            return this;
        }

        public Builder clearBooleanValue() {
            a();
            ((Value) this.a).clearBooleanValue();
            return this;
        }

        public Builder clearBytesValue() {
            a();
            ((Value) this.a).clearBytesValue();
            return this;
        }

        public Builder clearDoubleValue() {
            a();
            ((Value) this.a).clearDoubleValue();
            return this;
        }

        public Builder clearGeoPointValue() {
            a();
            ((Value) this.a).clearGeoPointValue();
            return this;
        }

        public Builder clearIntegerValue() {
            a();
            ((Value) this.a).clearIntegerValue();
            return this;
        }

        public Builder clearMapValue() {
            a();
            ((Value) this.a).clearMapValue();
            return this;
        }

        public Builder clearNullValue() {
            a();
            ((Value) this.a).clearNullValue();
            return this;
        }

        public Builder clearReferenceValue() {
            a();
            ((Value) this.a).clearReferenceValue();
            return this;
        }

        public Builder clearStringValue() {
            a();
            ((Value) this.a).clearStringValue();
            return this;
        }

        public Builder clearTimestampValue() {
            a();
            ((Value) this.a).clearTimestampValue();
            return this;
        }

        public Builder clearValueType() {
            a();
            ((Value) this.a).clearValueType();
            return this;
        }

        @Override // com.google.firestore.v1.ValueOrBuilder
        public ArrayValue getArrayValue() {
            return ((Value) this.a).getArrayValue();
        }

        @Override // com.google.firestore.v1.ValueOrBuilder
        public boolean getBooleanValue() {
            return ((Value) this.a).getBooleanValue();
        }

        @Override // com.google.firestore.v1.ValueOrBuilder
        public ByteString getBytesValue() {
            return ((Value) this.a).getBytesValue();
        }

        @Override // com.google.firestore.v1.ValueOrBuilder
        public double getDoubleValue() {
            return ((Value) this.a).getDoubleValue();
        }

        @Override // com.google.firestore.v1.ValueOrBuilder
        public LatLng getGeoPointValue() {
            return ((Value) this.a).getGeoPointValue();
        }

        @Override // com.google.firestore.v1.ValueOrBuilder
        public long getIntegerValue() {
            return ((Value) this.a).getIntegerValue();
        }

        @Override // com.google.firestore.v1.ValueOrBuilder
        public MapValue getMapValue() {
            return ((Value) this.a).getMapValue();
        }

        @Override // com.google.firestore.v1.ValueOrBuilder
        public NullValue getNullValue() {
            return ((Value) this.a).getNullValue();
        }

        @Override // com.google.firestore.v1.ValueOrBuilder
        public int getNullValueValue() {
            return ((Value) this.a).getNullValueValue();
        }

        @Override // com.google.firestore.v1.ValueOrBuilder
        public String getReferenceValue() {
            return ((Value) this.a).getReferenceValue();
        }

        @Override // com.google.firestore.v1.ValueOrBuilder
        public ByteString getReferenceValueBytes() {
            return ((Value) this.a).getReferenceValueBytes();
        }

        @Override // com.google.firestore.v1.ValueOrBuilder
        public String getStringValue() {
            return ((Value) this.a).getStringValue();
        }

        @Override // com.google.firestore.v1.ValueOrBuilder
        public ByteString getStringValueBytes() {
            return ((Value) this.a).getStringValueBytes();
        }

        @Override // com.google.firestore.v1.ValueOrBuilder
        public Timestamp getTimestampValue() {
            return ((Value) this.a).getTimestampValue();
        }

        @Override // com.google.firestore.v1.ValueOrBuilder
        public ValueTypeCase getValueTypeCase() {
            return ((Value) this.a).getValueTypeCase();
        }

        public Builder mergeArrayValue(ArrayValue arrayValue) {
            a();
            ((Value) this.a).mergeArrayValue(arrayValue);
            return this;
        }

        public Builder mergeGeoPointValue(LatLng latLng) {
            a();
            ((Value) this.a).mergeGeoPointValue(latLng);
            return this;
        }

        public Builder mergeMapValue(MapValue mapValue) {
            a();
            ((Value) this.a).mergeMapValue(mapValue);
            return this;
        }

        public Builder mergeTimestampValue(Timestamp timestamp) {
            a();
            ((Value) this.a).mergeTimestampValue(timestamp);
            return this;
        }

        public Builder setArrayValue(ArrayValue.Builder builder) {
            a();
            ((Value) this.a).setArrayValue(builder);
            return this;
        }

        public Builder setArrayValue(ArrayValue arrayValue) {
            a();
            ((Value) this.a).setArrayValue(arrayValue);
            return this;
        }

        public Builder setBooleanValue(boolean z) {
            a();
            ((Value) this.a).setBooleanValue(z);
            return this;
        }

        public Builder setBytesValue(ByteString byteString) {
            a();
            ((Value) this.a).setBytesValue(byteString);
            return this;
        }

        public Builder setDoubleValue(double d) {
            a();
            ((Value) this.a).setDoubleValue(d);
            return this;
        }

        public Builder setGeoPointValue(LatLng.Builder builder) {
            a();
            ((Value) this.a).setGeoPointValue(builder);
            return this;
        }

        public Builder setGeoPointValue(LatLng latLng) {
            a();
            ((Value) this.a).setGeoPointValue(latLng);
            return this;
        }

        public Builder setIntegerValue(long j) {
            a();
            ((Value) this.a).setIntegerValue(j);
            return this;
        }

        public Builder setMapValue(MapValue.Builder builder) {
            a();
            ((Value) this.a).setMapValue(builder);
            return this;
        }

        public Builder setMapValue(MapValue mapValue) {
            a();
            ((Value) this.a).setMapValue(mapValue);
            return this;
        }

        public Builder setNullValue(NullValue nullValue) {
            a();
            ((Value) this.a).setNullValue(nullValue);
            return this;
        }

        public Builder setNullValueValue(int i) {
            a();
            ((Value) this.a).setNullValueValue(i);
            return this;
        }

        public Builder setReferenceValue(String str) {
            a();
            ((Value) this.a).setReferenceValue(str);
            return this;
        }

        public Builder setReferenceValueBytes(ByteString byteString) {
            a();
            ((Value) this.a).setReferenceValueBytes(byteString);
            return this;
        }

        public Builder setStringValue(String str) {
            a();
            ((Value) this.a).setStringValue(str);
            return this;
        }

        public Builder setStringValueBytes(ByteString byteString) {
            a();
            ((Value) this.a).setStringValueBytes(byteString);
            return this;
        }

        public Builder setTimestampValue(Timestamp.Builder builder) {
            a();
            ((Value) this.a).setTimestampValue(builder);
            return this;
        }

        public Builder setTimestampValue(Timestamp timestamp) {
            a();
            ((Value) this.a).setTimestampValue(timestamp);
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public enum ValueTypeCase implements Internal.EnumLite {
        NULL_VALUE(11),
        BOOLEAN_VALUE(1),
        INTEGER_VALUE(2),
        DOUBLE_VALUE(3),
        TIMESTAMP_VALUE(10),
        STRING_VALUE(17),
        BYTES_VALUE(18),
        REFERENCE_VALUE(5),
        GEO_POINT_VALUE(8),
        ARRAY_VALUE(9),
        MAP_VALUE(6),
        VALUETYPE_NOT_SET(0);

        private final int value;

        ValueTypeCase(int i) {
            this.value = i;
        }

        public static ValueTypeCase forNumber(int i) {
            if (i == 0) {
                return VALUETYPE_NOT_SET;
            }
            if (i == 1) {
                return BOOLEAN_VALUE;
            }
            if (i == 2) {
                return INTEGER_VALUE;
            }
            if (i == 3) {
                return DOUBLE_VALUE;
            }
            if (i == 5) {
                return REFERENCE_VALUE;
            }
            if (i == 6) {
                return MAP_VALUE;
            }
            if (i == 17) {
                return STRING_VALUE;
            }
            if (i == 18) {
                return BYTES_VALUE;
            }
            switch (i) {
                case 8:
                    return GEO_POINT_VALUE;
                case 9:
                    return ARRAY_VALUE;
                case 10:
                    return TIMESTAMP_VALUE;
                case 11:
                    return NULL_VALUE;
                default:
                    return null;
            }
        }

        @Deprecated
        public static ValueTypeCase valueOf(int i) {
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

    private Value() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearArrayValue() {
        if (this.valueTypeCase_ == 9) {
            this.valueTypeCase_ = 0;
            this.valueType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBooleanValue() {
        if (this.valueTypeCase_ == 1) {
            this.valueTypeCase_ = 0;
            this.valueType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBytesValue() {
        if (this.valueTypeCase_ == 18) {
            this.valueTypeCase_ = 0;
            this.valueType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDoubleValue() {
        if (this.valueTypeCase_ == 3) {
            this.valueTypeCase_ = 0;
            this.valueType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearGeoPointValue() {
        if (this.valueTypeCase_ == 8) {
            this.valueTypeCase_ = 0;
            this.valueType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIntegerValue() {
        if (this.valueTypeCase_ == 2) {
            this.valueTypeCase_ = 0;
            this.valueType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMapValue() {
        if (this.valueTypeCase_ == 6) {
            this.valueTypeCase_ = 0;
            this.valueType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNullValue() {
        if (this.valueTypeCase_ == 11) {
            this.valueTypeCase_ = 0;
            this.valueType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReferenceValue() {
        if (this.valueTypeCase_ == 5) {
            this.valueTypeCase_ = 0;
            this.valueType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStringValue() {
        if (this.valueTypeCase_ == 17) {
            this.valueTypeCase_ = 0;
            this.valueType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTimestampValue() {
        if (this.valueTypeCase_ == 10) {
            this.valueTypeCase_ = 0;
            this.valueType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearValueType() {
        this.valueTypeCase_ = 0;
        this.valueType_ = null;
    }

    public static Value getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeArrayValue(ArrayValue arrayValue) {
        if (this.valueTypeCase_ == 9 && this.valueType_ != ArrayValue.getDefaultInstance()) {
            arrayValue = ArrayValue.newBuilder((ArrayValue) this.valueType_).mergeFrom((ArrayValue.Builder) arrayValue).buildPartial();
        }
        this.valueType_ = arrayValue;
        this.valueTypeCase_ = 9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeGeoPointValue(LatLng latLng) {
        if (this.valueTypeCase_ == 8 && this.valueType_ != LatLng.getDefaultInstance()) {
            latLng = LatLng.newBuilder((LatLng) this.valueType_).mergeFrom((LatLng.Builder) latLng).buildPartial();
        }
        this.valueType_ = latLng;
        this.valueTypeCase_ = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeMapValue(MapValue mapValue) {
        if (this.valueTypeCase_ == 6 && this.valueType_ != MapValue.getDefaultInstance()) {
            mapValue = MapValue.newBuilder((MapValue) this.valueType_).mergeFrom((MapValue.Builder) mapValue).buildPartial();
        }
        this.valueType_ = mapValue;
        this.valueTypeCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeTimestampValue(Timestamp timestamp) {
        if (this.valueTypeCase_ == 10 && this.valueType_ != Timestamp.getDefaultInstance()) {
            timestamp = Timestamp.newBuilder((Timestamp) this.valueType_).mergeFrom((Timestamp.Builder) timestamp).buildPartial();
        }
        this.valueType_ = timestamp;
        this.valueTypeCase_ = 10;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Value value) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) value);
    }

    public static Value parseDelimitedFrom(InputStream inputStream) {
        return (Value) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static Value parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Value) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Value parseFrom(ByteString byteString) {
        return (Value) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static Value parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Value) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Value parseFrom(CodedInputStream codedInputStream) {
        return (Value) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Value parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Value) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Value parseFrom(InputStream inputStream) {
        return (Value) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static Value parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Value) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Value parseFrom(byte[] bArr) {
        return (Value) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static Value parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Value) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<Value> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setArrayValue(ArrayValue.Builder builder) {
        this.valueType_ = builder.build();
        this.valueTypeCase_ = 9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setArrayValue(ArrayValue arrayValue) {
        if (arrayValue == null) {
            throw new NullPointerException();
        }
        this.valueType_ = arrayValue;
        this.valueTypeCase_ = 9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBooleanValue(boolean z) {
        this.valueTypeCase_ = 1;
        this.valueType_ = Boolean.valueOf(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBytesValue(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.valueTypeCase_ = 18;
        this.valueType_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDoubleValue(double d) {
        this.valueTypeCase_ = 3;
        this.valueType_ = Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGeoPointValue(LatLng.Builder builder) {
        this.valueType_ = builder.build();
        this.valueTypeCase_ = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGeoPointValue(LatLng latLng) {
        if (latLng == null) {
            throw new NullPointerException();
        }
        this.valueType_ = latLng;
        this.valueTypeCase_ = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIntegerValue(long j) {
        this.valueTypeCase_ = 2;
        this.valueType_ = Long.valueOf(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMapValue(MapValue.Builder builder) {
        this.valueType_ = builder.build();
        this.valueTypeCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMapValue(MapValue mapValue) {
        if (mapValue == null) {
            throw new NullPointerException();
        }
        this.valueType_ = mapValue;
        this.valueTypeCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNullValue(NullValue nullValue) {
        if (nullValue == null) {
            throw new NullPointerException();
        }
        this.valueTypeCase_ = 11;
        this.valueType_ = Integer.valueOf(nullValue.getNumber());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNullValueValue(int i) {
        this.valueTypeCase_ = 11;
        this.valueType_ = Integer.valueOf(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReferenceValue(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.valueTypeCase_ = 5;
        this.valueType_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReferenceValueBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.valueTypeCase_ = 5;
        this.valueType_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStringValue(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.valueTypeCase_ = 17;
        this.valueType_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStringValueBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.valueTypeCase_ = 17;
        this.valueType_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTimestampValue(Timestamp.Builder builder) {
        this.valueType_ = builder.build();
        this.valueTypeCase_ = 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTimestampValue(Timestamp timestamp) {
        if (timestamp == null) {
            throw new NullPointerException();
        }
        this.valueType_ = timestamp;
        this.valueTypeCase_ = 10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x01d9, code lost:
    
        r2 = r0.visitOneofMessage(r13, r18.valueType_, r7.valueType_);
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01d8, code lost:
    
        r13 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01ab, code lost:
    
        if (r18.valueTypeCase_ == 9) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01b0, code lost:
    
        if (r18.valueTypeCase_ == 8) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x01b5, code lost:
    
        if (r18.valueTypeCase_ == 5) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x01cb, code lost:
    
        r2 = r0.visitOneofString(r13, r18.valueType_, r7.valueType_);
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x01ca, code lost:
    
        r13 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x01c8, code lost:
    
        if (r18.valueTypeCase_ == 17) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x01d6, code lost:
    
        if (r18.valueTypeCase_ == 10) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01a6, code lost:
    
        if (r18.valueTypeCase_ == 6) goto L111;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:26:0x004f. Please report as an issue. */
    @Override // com.google.protobuf.GeneratedMessageLite
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final java.lang.Object a(com.google.protobuf.GeneratedMessageLite.MethodToInvoke r19, java.lang.Object r20, java.lang.Object r21) {
        /*
            Method dump skipped, instructions count: 668
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firestore.v1.Value.a(com.google.protobuf.GeneratedMessageLite$MethodToInvoke, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    @Override // com.google.firestore.v1.ValueOrBuilder
    public ArrayValue getArrayValue() {
        return this.valueTypeCase_ == 9 ? (ArrayValue) this.valueType_ : ArrayValue.getDefaultInstance();
    }

    @Override // com.google.firestore.v1.ValueOrBuilder
    public boolean getBooleanValue() {
        if (this.valueTypeCase_ == 1) {
            return ((Boolean) this.valueType_).booleanValue();
        }
        return false;
    }

    @Override // com.google.firestore.v1.ValueOrBuilder
    public ByteString getBytesValue() {
        return this.valueTypeCase_ == 18 ? (ByteString) this.valueType_ : ByteString.EMPTY;
    }

    @Override // com.google.firestore.v1.ValueOrBuilder
    public double getDoubleValue() {
        if (this.valueTypeCase_ == 3) {
            return ((Double) this.valueType_).doubleValue();
        }
        return 0.0d;
    }

    @Override // com.google.firestore.v1.ValueOrBuilder
    public LatLng getGeoPointValue() {
        return this.valueTypeCase_ == 8 ? (LatLng) this.valueType_ : LatLng.getDefaultInstance();
    }

    @Override // com.google.firestore.v1.ValueOrBuilder
    public long getIntegerValue() {
        if (this.valueTypeCase_ == 2) {
            return ((Long) this.valueType_).longValue();
        }
        return 0L;
    }

    @Override // com.google.firestore.v1.ValueOrBuilder
    public MapValue getMapValue() {
        return this.valueTypeCase_ == 6 ? (MapValue) this.valueType_ : MapValue.getDefaultInstance();
    }

    @Override // com.google.firestore.v1.ValueOrBuilder
    public NullValue getNullValue() {
        if (this.valueTypeCase_ != 11) {
            return NullValue.NULL_VALUE;
        }
        NullValue forNumber = NullValue.forNumber(((Integer) this.valueType_).intValue());
        return forNumber == null ? NullValue.UNRECOGNIZED : forNumber;
    }

    @Override // com.google.firestore.v1.ValueOrBuilder
    public int getNullValueValue() {
        if (this.valueTypeCase_ == 11) {
            return ((Integer) this.valueType_).intValue();
        }
        return 0;
    }

    @Override // com.google.firestore.v1.ValueOrBuilder
    public String getReferenceValue() {
        return this.valueTypeCase_ == 5 ? (String) this.valueType_ : "";
    }

    @Override // com.google.firestore.v1.ValueOrBuilder
    public ByteString getReferenceValueBytes() {
        return ByteString.copyFromUtf8(this.valueTypeCase_ == 5 ? (String) this.valueType_ : "");
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeBoolSize = this.valueTypeCase_ == 1 ? 0 + CodedOutputStream.computeBoolSize(1, ((Boolean) this.valueType_).booleanValue()) : 0;
        if (this.valueTypeCase_ == 2) {
            computeBoolSize += CodedOutputStream.computeInt64Size(2, ((Long) this.valueType_).longValue());
        }
        if (this.valueTypeCase_ == 3) {
            computeBoolSize += CodedOutputStream.computeDoubleSize(3, ((Double) this.valueType_).doubleValue());
        }
        if (this.valueTypeCase_ == 5) {
            computeBoolSize += CodedOutputStream.computeStringSize(5, getReferenceValue());
        }
        if (this.valueTypeCase_ == 6) {
            computeBoolSize += CodedOutputStream.computeMessageSize(6, (MapValue) this.valueType_);
        }
        if (this.valueTypeCase_ == 8) {
            computeBoolSize += CodedOutputStream.computeMessageSize(8, (LatLng) this.valueType_);
        }
        if (this.valueTypeCase_ == 9) {
            computeBoolSize += CodedOutputStream.computeMessageSize(9, (ArrayValue) this.valueType_);
        }
        if (this.valueTypeCase_ == 10) {
            computeBoolSize += CodedOutputStream.computeMessageSize(10, (Timestamp) this.valueType_);
        }
        if (this.valueTypeCase_ == 11) {
            computeBoolSize += CodedOutputStream.computeEnumSize(11, ((Integer) this.valueType_).intValue());
        }
        if (this.valueTypeCase_ == 17) {
            computeBoolSize += CodedOutputStream.computeStringSize(17, getStringValue());
        }
        if (this.valueTypeCase_ == 18) {
            computeBoolSize += CodedOutputStream.computeBytesSize(18, (ByteString) this.valueType_);
        }
        this.c = computeBoolSize;
        return computeBoolSize;
    }

    @Override // com.google.firestore.v1.ValueOrBuilder
    public String getStringValue() {
        return this.valueTypeCase_ == 17 ? (String) this.valueType_ : "";
    }

    @Override // com.google.firestore.v1.ValueOrBuilder
    public ByteString getStringValueBytes() {
        return ByteString.copyFromUtf8(this.valueTypeCase_ == 17 ? (String) this.valueType_ : "");
    }

    @Override // com.google.firestore.v1.ValueOrBuilder
    public Timestamp getTimestampValue() {
        return this.valueTypeCase_ == 10 ? (Timestamp) this.valueType_ : Timestamp.getDefaultInstance();
    }

    @Override // com.google.firestore.v1.ValueOrBuilder
    public ValueTypeCase getValueTypeCase() {
        return ValueTypeCase.forNumber(this.valueTypeCase_);
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (this.valueTypeCase_ == 1) {
            codedOutputStream.writeBool(1, ((Boolean) this.valueType_).booleanValue());
        }
        if (this.valueTypeCase_ == 2) {
            codedOutputStream.writeInt64(2, ((Long) this.valueType_).longValue());
        }
        if (this.valueTypeCase_ == 3) {
            codedOutputStream.writeDouble(3, ((Double) this.valueType_).doubleValue());
        }
        if (this.valueTypeCase_ == 5) {
            codedOutputStream.writeString(5, getReferenceValue());
        }
        if (this.valueTypeCase_ == 6) {
            codedOutputStream.writeMessage(6, (MapValue) this.valueType_);
        }
        if (this.valueTypeCase_ == 8) {
            codedOutputStream.writeMessage(8, (LatLng) this.valueType_);
        }
        if (this.valueTypeCase_ == 9) {
            codedOutputStream.writeMessage(9, (ArrayValue) this.valueType_);
        }
        if (this.valueTypeCase_ == 10) {
            codedOutputStream.writeMessage(10, (Timestamp) this.valueType_);
        }
        if (this.valueTypeCase_ == 11) {
            codedOutputStream.writeEnum(11, ((Integer) this.valueType_).intValue());
        }
        if (this.valueTypeCase_ == 17) {
            codedOutputStream.writeString(17, getStringValue());
        }
        if (this.valueTypeCase_ == 18) {
            codedOutputStream.writeBytes(18, (ByteString) this.valueType_);
        }
    }
}
