package com.google.firestore.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public final class MapValue extends GeneratedMessageLite<MapValue, Builder> implements MapValueOrBuilder {
    private static final MapValue DEFAULT_INSTANCE = new MapValue();
    public static final int FIELDS_FIELD_NUMBER = 1;
    private static volatile Parser<MapValue> PARSER;
    private MapFieldLite<String, Value> fields_ = MapFieldLite.emptyMapField();

    /* renamed from: com.google.firestore.v1.MapValue$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<MapValue, Builder> implements MapValueOrBuilder {
        private Builder() {
            super(MapValue.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearFields() {
            a();
            ((MapValue) this.a).getMutableFieldsMap().clear();
            return this;
        }

        @Override // com.google.firestore.v1.MapValueOrBuilder
        public boolean containsFields(String str) {
            if (str != null) {
                return ((MapValue) this.a).getFieldsMap().containsKey(str);
            }
            throw new NullPointerException();
        }

        @Override // com.google.firestore.v1.MapValueOrBuilder
        @Deprecated
        public Map<String, Value> getFields() {
            return getFieldsMap();
        }

        @Override // com.google.firestore.v1.MapValueOrBuilder
        public int getFieldsCount() {
            return ((MapValue) this.a).getFieldsMap().size();
        }

        @Override // com.google.firestore.v1.MapValueOrBuilder
        public Map<String, Value> getFieldsMap() {
            return Collections.unmodifiableMap(((MapValue) this.a).getFieldsMap());
        }

        @Override // com.google.firestore.v1.MapValueOrBuilder
        public Value getFieldsOrDefault(String str, Value value) {
            if (str == null) {
                throw new NullPointerException();
            }
            Map<String, Value> fieldsMap = ((MapValue) this.a).getFieldsMap();
            return fieldsMap.containsKey(str) ? fieldsMap.get(str) : value;
        }

        @Override // com.google.firestore.v1.MapValueOrBuilder
        public Value getFieldsOrThrow(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            Map<String, Value> fieldsMap = ((MapValue) this.a).getFieldsMap();
            if (fieldsMap.containsKey(str)) {
                return fieldsMap.get(str);
            }
            throw new IllegalArgumentException();
        }

        public Builder putAllFields(Map<String, Value> map) {
            a();
            ((MapValue) this.a).getMutableFieldsMap().putAll(map);
            return this;
        }

        public Builder putFields(String str, Value value) {
            if (str == null) {
                throw new NullPointerException();
            }
            if (value == null) {
                throw new NullPointerException();
            }
            a();
            ((MapValue) this.a).getMutableFieldsMap().put(str, value);
            return this;
        }

        public Builder removeFields(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            a();
            ((MapValue) this.a).getMutableFieldsMap().remove(str);
            return this;
        }
    }

    /* loaded from: classes2.dex */
    private static final class FieldsDefaultEntryHolder {
        static final MapEntryLite<String, Value> a = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, Value.getDefaultInstance());

        private FieldsDefaultEntryHolder() {
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private MapValue() {
    }

    public static MapValue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Value> getMutableFieldsMap() {
        return internalGetMutableFields();
    }

    private MapFieldLite<String, Value> internalGetFields() {
        return this.fields_;
    }

    private MapFieldLite<String, Value> internalGetMutableFields() {
        if (!this.fields_.isMutable()) {
            this.fields_ = this.fields_.mutableCopy();
        }
        return this.fields_;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(MapValue mapValue) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) mapValue);
    }

    public static MapValue parseDelimitedFrom(InputStream inputStream) {
        return (MapValue) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static MapValue parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MapValue) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MapValue parseFrom(ByteString byteString) {
        return (MapValue) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static MapValue parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MapValue) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MapValue parseFrom(CodedInputStream codedInputStream) {
        return (MapValue) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MapValue parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MapValue) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static MapValue parseFrom(InputStream inputStream) {
        return (MapValue) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static MapValue parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MapValue) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MapValue parseFrom(byte[] bArr) {
        return (MapValue) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static MapValue parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MapValue) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<MapValue> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new MapValue();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.fields_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                this.fields_ = ((GeneratedMessageLite.Visitor) obj).visitMap(this.fields_, ((MapValue) obj2).internalGetFields());
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
                                    if (!this.fields_.isMutable()) {
                                        this.fields_ = this.fields_.mutableCopy();
                                    }
                                    FieldsDefaultEntryHolder.a.parseInto(this.fields_, codedInputStream, extensionRegistryLite);
                                } else if (!codedInputStream.skipField(readTag)) {
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
                    synchronized (MapValue.class) {
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

    @Override // com.google.firestore.v1.MapValueOrBuilder
    public boolean containsFields(String str) {
        if (str != null) {
            return internalGetFields().containsKey(str);
        }
        throw new NullPointerException();
    }

    @Override // com.google.firestore.v1.MapValueOrBuilder
    @Deprecated
    public Map<String, Value> getFields() {
        return getFieldsMap();
    }

    @Override // com.google.firestore.v1.MapValueOrBuilder
    public int getFieldsCount() {
        return internalGetFields().size();
    }

    @Override // com.google.firestore.v1.MapValueOrBuilder
    public Map<String, Value> getFieldsMap() {
        return Collections.unmodifiableMap(internalGetFields());
    }

    @Override // com.google.firestore.v1.MapValueOrBuilder
    public Value getFieldsOrDefault(String str, Value value) {
        if (str == null) {
            throw new NullPointerException();
        }
        MapFieldLite<String, Value> internalGetFields = internalGetFields();
        return internalGetFields.containsKey(str) ? internalGetFields.get(str) : value;
    }

    @Override // com.google.firestore.v1.MapValueOrBuilder
    public Value getFieldsOrThrow(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        MapFieldLite<String, Value> internalGetFields = internalGetFields();
        if (internalGetFields.containsKey(str)) {
            return internalGetFields.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (Map.Entry<String, Value> entry : internalGetFields().entrySet()) {
            i2 += FieldsDefaultEntryHolder.a.computeMessageSize(1, entry.getKey(), entry.getValue());
        }
        this.c = i2;
        return i2;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        for (Map.Entry<String, Value> entry : internalGetFields().entrySet()) {
            FieldsDefaultEntryHolder.a.serializeTo(codedOutputStream, 1, entry.getKey(), entry.getValue());
        }
    }
}
