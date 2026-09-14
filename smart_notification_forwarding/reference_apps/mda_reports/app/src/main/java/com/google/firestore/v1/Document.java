package com.google.firestore.v1;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public final class Document extends GeneratedMessageLite<Document, Builder> implements DocumentOrBuilder {
    public static final int CREATE_TIME_FIELD_NUMBER = 3;
    private static final Document DEFAULT_INSTANCE = new Document();
    public static final int FIELDS_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<Document> PARSER = null;
    public static final int UPDATE_TIME_FIELD_NUMBER = 4;
    private int bitField0_;
    private Timestamp createTime_;
    private MapFieldLite<String, Value> fields_ = MapFieldLite.emptyMapField();
    private String name_ = "";
    private Timestamp updateTime_;

    /* renamed from: com.google.firestore.v1.Document$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<Document, Builder> implements DocumentOrBuilder {
        private Builder() {
            super(Document.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearCreateTime() {
            a();
            ((Document) this.a).clearCreateTime();
            return this;
        }

        public Builder clearFields() {
            a();
            ((Document) this.a).getMutableFieldsMap().clear();
            return this;
        }

        public Builder clearName() {
            a();
            ((Document) this.a).clearName();
            return this;
        }

        public Builder clearUpdateTime() {
            a();
            ((Document) this.a).clearUpdateTime();
            return this;
        }

        @Override // com.google.firestore.v1.DocumentOrBuilder
        public boolean containsFields(String str) {
            if (str != null) {
                return ((Document) this.a).getFieldsMap().containsKey(str);
            }
            throw new NullPointerException();
        }

        @Override // com.google.firestore.v1.DocumentOrBuilder
        public Timestamp getCreateTime() {
            return ((Document) this.a).getCreateTime();
        }

        @Override // com.google.firestore.v1.DocumentOrBuilder
        @Deprecated
        public Map<String, Value> getFields() {
            return getFieldsMap();
        }

        @Override // com.google.firestore.v1.DocumentOrBuilder
        public int getFieldsCount() {
            return ((Document) this.a).getFieldsMap().size();
        }

        @Override // com.google.firestore.v1.DocumentOrBuilder
        public Map<String, Value> getFieldsMap() {
            return Collections.unmodifiableMap(((Document) this.a).getFieldsMap());
        }

        @Override // com.google.firestore.v1.DocumentOrBuilder
        public Value getFieldsOrDefault(String str, Value value) {
            if (str == null) {
                throw new NullPointerException();
            }
            Map<String, Value> fieldsMap = ((Document) this.a).getFieldsMap();
            return fieldsMap.containsKey(str) ? fieldsMap.get(str) : value;
        }

        @Override // com.google.firestore.v1.DocumentOrBuilder
        public Value getFieldsOrThrow(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            Map<String, Value> fieldsMap = ((Document) this.a).getFieldsMap();
            if (fieldsMap.containsKey(str)) {
                return fieldsMap.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.google.firestore.v1.DocumentOrBuilder
        public String getName() {
            return ((Document) this.a).getName();
        }

        @Override // com.google.firestore.v1.DocumentOrBuilder
        public ByteString getNameBytes() {
            return ((Document) this.a).getNameBytes();
        }

        @Override // com.google.firestore.v1.DocumentOrBuilder
        public Timestamp getUpdateTime() {
            return ((Document) this.a).getUpdateTime();
        }

        @Override // com.google.firestore.v1.DocumentOrBuilder
        public boolean hasCreateTime() {
            return ((Document) this.a).hasCreateTime();
        }

        @Override // com.google.firestore.v1.DocumentOrBuilder
        public boolean hasUpdateTime() {
            return ((Document) this.a).hasUpdateTime();
        }

        public Builder mergeCreateTime(Timestamp timestamp) {
            a();
            ((Document) this.a).mergeCreateTime(timestamp);
            return this;
        }

        public Builder mergeUpdateTime(Timestamp timestamp) {
            a();
            ((Document) this.a).mergeUpdateTime(timestamp);
            return this;
        }

        public Builder putAllFields(Map<String, Value> map) {
            a();
            ((Document) this.a).getMutableFieldsMap().putAll(map);
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
            ((Document) this.a).getMutableFieldsMap().put(str, value);
            return this;
        }

        public Builder removeFields(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            a();
            ((Document) this.a).getMutableFieldsMap().remove(str);
            return this;
        }

        public Builder setCreateTime(Timestamp.Builder builder) {
            a();
            ((Document) this.a).setCreateTime(builder);
            return this;
        }

        public Builder setCreateTime(Timestamp timestamp) {
            a();
            ((Document) this.a).setCreateTime(timestamp);
            return this;
        }

        public Builder setName(String str) {
            a();
            ((Document) this.a).setName(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            a();
            ((Document) this.a).setNameBytes(byteString);
            return this;
        }

        public Builder setUpdateTime(Timestamp.Builder builder) {
            a();
            ((Document) this.a).setUpdateTime(builder);
            return this;
        }

        public Builder setUpdateTime(Timestamp timestamp) {
            a();
            ((Document) this.a).setUpdateTime(timestamp);
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

    private Document() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCreateTime() {
        this.createTime_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUpdateTime() {
        this.updateTime_ = null;
    }

    public static Document getDefaultInstance() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeCreateTime(Timestamp timestamp) {
        Timestamp timestamp2 = this.createTime_;
        if (timestamp2 != null && timestamp2 != Timestamp.getDefaultInstance()) {
            timestamp = Timestamp.newBuilder(this.createTime_).mergeFrom((Timestamp.Builder) timestamp).buildPartial();
        }
        this.createTime_ = timestamp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeUpdateTime(Timestamp timestamp) {
        Timestamp timestamp2 = this.updateTime_;
        if (timestamp2 != null && timestamp2 != Timestamp.getDefaultInstance()) {
            timestamp = Timestamp.newBuilder(this.updateTime_).mergeFrom((Timestamp.Builder) timestamp).buildPartial();
        }
        this.updateTime_ = timestamp;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Document document) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) document);
    }

    public static Document parseDelimitedFrom(InputStream inputStream) {
        return (Document) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static Document parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Document) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Document parseFrom(ByteString byteString) {
        return (Document) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static Document parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Document) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Document parseFrom(CodedInputStream codedInputStream) {
        return (Document) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Document parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Document) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Document parseFrom(InputStream inputStream) {
        return (Document) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static Document parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Document) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Document parseFrom(byte[] bArr) {
        return (Document) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static Document parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Document) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<Document> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCreateTime(Timestamp.Builder builder) {
        this.createTime_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCreateTime(Timestamp timestamp) {
        if (timestamp == null) {
            throw new NullPointerException();
        }
        this.createTime_ = timestamp;
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
    public void setUpdateTime(Timestamp.Builder builder) {
        this.updateTime_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUpdateTime(Timestamp timestamp) {
        if (timestamp == null) {
            throw new NullPointerException();
        }
        this.updateTime_ = timestamp;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new Document();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.fields_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Document document = (Document) obj2;
                this.name_ = visitor.visitString(!this.name_.isEmpty(), this.name_, true ^ document.name_.isEmpty(), document.name_);
                this.fields_ = visitor.visitMap(this.fields_, document.internalGetFields());
                this.createTime_ = (Timestamp) visitor.visitMessage(this.createTime_, document.createTime_);
                this.updateTime_ = (Timestamp) visitor.visitMessage(this.updateTime_, document.updateTime_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= document.bitField0_;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                boolean z = false;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.name_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                if (!this.fields_.isMutable()) {
                                    this.fields_ = this.fields_.mutableCopy();
                                }
                                FieldsDefaultEntryHolder.a.parseInto(this.fields_, codedInputStream, extensionRegistryLite);
                            } else if (readTag == 26) {
                                Timestamp.Builder builder = this.createTime_ != null ? this.createTime_.toBuilder() : null;
                                this.createTime_ = (Timestamp) codedInputStream.readMessage(Timestamp.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom((Timestamp.Builder) this.createTime_);
                                    this.createTime_ = builder.buildPartial();
                                }
                            } else if (readTag == 34) {
                                Timestamp.Builder builder2 = this.updateTime_ != null ? this.updateTime_.toBuilder() : null;
                                this.updateTime_ = (Timestamp) codedInputStream.readMessage(Timestamp.parser(), extensionRegistryLite);
                                if (builder2 != null) {
                                    builder2.mergeFrom((Timestamp.Builder) this.updateTime_);
                                    this.updateTime_ = builder2.buildPartial();
                                }
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
                    synchronized (Document.class) {
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

    @Override // com.google.firestore.v1.DocumentOrBuilder
    public boolean containsFields(String str) {
        if (str != null) {
            return internalGetFields().containsKey(str);
        }
        throw new NullPointerException();
    }

    @Override // com.google.firestore.v1.DocumentOrBuilder
    public Timestamp getCreateTime() {
        Timestamp timestamp = this.createTime_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // com.google.firestore.v1.DocumentOrBuilder
    @Deprecated
    public Map<String, Value> getFields() {
        return getFieldsMap();
    }

    @Override // com.google.firestore.v1.DocumentOrBuilder
    public int getFieldsCount() {
        return internalGetFields().size();
    }

    @Override // com.google.firestore.v1.DocumentOrBuilder
    public Map<String, Value> getFieldsMap() {
        return Collections.unmodifiableMap(internalGetFields());
    }

    @Override // com.google.firestore.v1.DocumentOrBuilder
    public Value getFieldsOrDefault(String str, Value value) {
        if (str == null) {
            throw new NullPointerException();
        }
        MapFieldLite<String, Value> internalGetFields = internalGetFields();
        return internalGetFields.containsKey(str) ? internalGetFields.get(str) : value;
    }

    @Override // com.google.firestore.v1.DocumentOrBuilder
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

    @Override // com.google.firestore.v1.DocumentOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // com.google.firestore.v1.DocumentOrBuilder
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
        for (Map.Entry<String, Value> entry : internalGetFields().entrySet()) {
            computeStringSize += FieldsDefaultEntryHolder.a.computeMessageSize(2, entry.getKey(), entry.getValue());
        }
        if (this.createTime_ != null) {
            computeStringSize += CodedOutputStream.computeMessageSize(3, getCreateTime());
        }
        if (this.updateTime_ != null) {
            computeStringSize += CodedOutputStream.computeMessageSize(4, getUpdateTime());
        }
        this.c = computeStringSize;
        return computeStringSize;
    }

    @Override // com.google.firestore.v1.DocumentOrBuilder
    public Timestamp getUpdateTime() {
        Timestamp timestamp = this.updateTime_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // com.google.firestore.v1.DocumentOrBuilder
    public boolean hasCreateTime() {
        return this.createTime_ != null;
    }

    @Override // com.google.firestore.v1.DocumentOrBuilder
    public boolean hasUpdateTime() {
        return this.updateTime_ != null;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!this.name_.isEmpty()) {
            codedOutputStream.writeString(1, getName());
        }
        for (Map.Entry<String, Value> entry : internalGetFields().entrySet()) {
            FieldsDefaultEntryHolder.a.serializeTo(codedOutputStream, 2, entry.getKey(), entry.getValue());
        }
        if (this.createTime_ != null) {
            codedOutputStream.writeMessage(3, getCreateTime());
        }
        if (this.updateTime_ != null) {
            codedOutputStream.writeMessage(4, getUpdateTime());
        }
    }
}
