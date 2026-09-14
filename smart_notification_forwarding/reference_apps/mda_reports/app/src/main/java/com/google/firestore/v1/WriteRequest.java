package com.google.firestore.v1;

import com.google.firestore.v1.Write;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class WriteRequest extends GeneratedMessageLite<WriteRequest, Builder> implements WriteRequestOrBuilder {
    public static final int DATABASE_FIELD_NUMBER = 1;
    private static final WriteRequest DEFAULT_INSTANCE = new WriteRequest();
    public static final int LABELS_FIELD_NUMBER = 5;
    private static volatile Parser<WriteRequest> PARSER = null;
    public static final int STREAM_ID_FIELD_NUMBER = 2;
    public static final int STREAM_TOKEN_FIELD_NUMBER = 4;
    public static final int WRITES_FIELD_NUMBER = 3;
    private int bitField0_;
    private MapFieldLite<String, String> labels_ = MapFieldLite.emptyMapField();
    private String database_ = "";
    private String streamId_ = "";
    private Internal.ProtobufList<Write> writes_ = GeneratedMessageLite.f();
    private ByteString streamToken_ = ByteString.EMPTY;

    /* renamed from: com.google.firestore.v1.WriteRequest$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<WriteRequest, Builder> implements WriteRequestOrBuilder {
        private Builder() {
            super(WriteRequest.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllWrites(Iterable<? extends Write> iterable) {
            a();
            ((WriteRequest) this.a).addAllWrites(iterable);
            return this;
        }

        public Builder addWrites(int i, Write.Builder builder) {
            a();
            ((WriteRequest) this.a).addWrites(i, builder);
            return this;
        }

        public Builder addWrites(int i, Write write) {
            a();
            ((WriteRequest) this.a).addWrites(i, write);
            return this;
        }

        public Builder addWrites(Write.Builder builder) {
            a();
            ((WriteRequest) this.a).addWrites(builder);
            return this;
        }

        public Builder addWrites(Write write) {
            a();
            ((WriteRequest) this.a).addWrites(write);
            return this;
        }

        public Builder clearDatabase() {
            a();
            ((WriteRequest) this.a).clearDatabase();
            return this;
        }

        public Builder clearLabels() {
            a();
            ((WriteRequest) this.a).getMutableLabelsMap().clear();
            return this;
        }

        public Builder clearStreamId() {
            a();
            ((WriteRequest) this.a).clearStreamId();
            return this;
        }

        public Builder clearStreamToken() {
            a();
            ((WriteRequest) this.a).clearStreamToken();
            return this;
        }

        public Builder clearWrites() {
            a();
            ((WriteRequest) this.a).clearWrites();
            return this;
        }

        @Override // com.google.firestore.v1.WriteRequestOrBuilder
        public boolean containsLabels(String str) {
            if (str != null) {
                return ((WriteRequest) this.a).getLabelsMap().containsKey(str);
            }
            throw new NullPointerException();
        }

        @Override // com.google.firestore.v1.WriteRequestOrBuilder
        public String getDatabase() {
            return ((WriteRequest) this.a).getDatabase();
        }

        @Override // com.google.firestore.v1.WriteRequestOrBuilder
        public ByteString getDatabaseBytes() {
            return ((WriteRequest) this.a).getDatabaseBytes();
        }

        @Override // com.google.firestore.v1.WriteRequestOrBuilder
        @Deprecated
        public Map<String, String> getLabels() {
            return getLabelsMap();
        }

        @Override // com.google.firestore.v1.WriteRequestOrBuilder
        public int getLabelsCount() {
            return ((WriteRequest) this.a).getLabelsMap().size();
        }

        @Override // com.google.firestore.v1.WriteRequestOrBuilder
        public Map<String, String> getLabelsMap() {
            return Collections.unmodifiableMap(((WriteRequest) this.a).getLabelsMap());
        }

        @Override // com.google.firestore.v1.WriteRequestOrBuilder
        public String getLabelsOrDefault(String str, String str2) {
            if (str == null) {
                throw new NullPointerException();
            }
            Map<String, String> labelsMap = ((WriteRequest) this.a).getLabelsMap();
            return labelsMap.containsKey(str) ? labelsMap.get(str) : str2;
        }

        @Override // com.google.firestore.v1.WriteRequestOrBuilder
        public String getLabelsOrThrow(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            Map<String, String> labelsMap = ((WriteRequest) this.a).getLabelsMap();
            if (labelsMap.containsKey(str)) {
                return labelsMap.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.google.firestore.v1.WriteRequestOrBuilder
        public String getStreamId() {
            return ((WriteRequest) this.a).getStreamId();
        }

        @Override // com.google.firestore.v1.WriteRequestOrBuilder
        public ByteString getStreamIdBytes() {
            return ((WriteRequest) this.a).getStreamIdBytes();
        }

        @Override // com.google.firestore.v1.WriteRequestOrBuilder
        public ByteString getStreamToken() {
            return ((WriteRequest) this.a).getStreamToken();
        }

        @Override // com.google.firestore.v1.WriteRequestOrBuilder
        public Write getWrites(int i) {
            return ((WriteRequest) this.a).getWrites(i);
        }

        @Override // com.google.firestore.v1.WriteRequestOrBuilder
        public int getWritesCount() {
            return ((WriteRequest) this.a).getWritesCount();
        }

        @Override // com.google.firestore.v1.WriteRequestOrBuilder
        public List<Write> getWritesList() {
            return Collections.unmodifiableList(((WriteRequest) this.a).getWritesList());
        }

        public Builder putAllLabels(Map<String, String> map) {
            a();
            ((WriteRequest) this.a).getMutableLabelsMap().putAll(map);
            return this;
        }

        public Builder putLabels(String str, String str2) {
            if (str == null) {
                throw new NullPointerException();
            }
            if (str2 == null) {
                throw new NullPointerException();
            }
            a();
            ((WriteRequest) this.a).getMutableLabelsMap().put(str, str2);
            return this;
        }

        public Builder removeLabels(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            a();
            ((WriteRequest) this.a).getMutableLabelsMap().remove(str);
            return this;
        }

        public Builder removeWrites(int i) {
            a();
            ((WriteRequest) this.a).removeWrites(i);
            return this;
        }

        public Builder setDatabase(String str) {
            a();
            ((WriteRequest) this.a).setDatabase(str);
            return this;
        }

        public Builder setDatabaseBytes(ByteString byteString) {
            a();
            ((WriteRequest) this.a).setDatabaseBytes(byteString);
            return this;
        }

        public Builder setStreamId(String str) {
            a();
            ((WriteRequest) this.a).setStreamId(str);
            return this;
        }

        public Builder setStreamIdBytes(ByteString byteString) {
            a();
            ((WriteRequest) this.a).setStreamIdBytes(byteString);
            return this;
        }

        public Builder setStreamToken(ByteString byteString) {
            a();
            ((WriteRequest) this.a).setStreamToken(byteString);
            return this;
        }

        public Builder setWrites(int i, Write.Builder builder) {
            a();
            ((WriteRequest) this.a).setWrites(i, builder);
            return this;
        }

        public Builder setWrites(int i, Write write) {
            a();
            ((WriteRequest) this.a).setWrites(i, write);
            return this;
        }
    }

    /* loaded from: classes2.dex */
    private static final class LabelsDefaultEntryHolder {
        static final MapEntryLite<String, String> a;

        static {
            WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
            a = MapEntryLite.newDefaultInstance(fieldType, "", fieldType, "");
        }

        private LabelsDefaultEntryHolder() {
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private WriteRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllWrites(Iterable<? extends Write> iterable) {
        ensureWritesIsMutable();
        AbstractMessageLite.a(iterable, this.writes_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addWrites(int i, Write.Builder builder) {
        ensureWritesIsMutable();
        this.writes_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addWrites(int i, Write write) {
        if (write == null) {
            throw new NullPointerException();
        }
        ensureWritesIsMutable();
        this.writes_.add(i, write);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addWrites(Write.Builder builder) {
        ensureWritesIsMutable();
        this.writes_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addWrites(Write write) {
        if (write == null) {
            throw new NullPointerException();
        }
        ensureWritesIsMutable();
        this.writes_.add(write);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDatabase() {
        this.database_ = getDefaultInstance().getDatabase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStreamId() {
        this.streamId_ = getDefaultInstance().getStreamId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStreamToken() {
        this.streamToken_ = getDefaultInstance().getStreamToken();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearWrites() {
        this.writes_ = GeneratedMessageLite.f();
    }

    private void ensureWritesIsMutable() {
        if (this.writes_.isModifiable()) {
            return;
        }
        this.writes_ = GeneratedMessageLite.a(this.writes_);
    }

    public static WriteRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> getMutableLabelsMap() {
        return internalGetMutableLabels();
    }

    private MapFieldLite<String, String> internalGetLabels() {
        return this.labels_;
    }

    private MapFieldLite<String, String> internalGetMutableLabels() {
        if (!this.labels_.isMutable()) {
            this.labels_ = this.labels_.mutableCopy();
        }
        return this.labels_;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(WriteRequest writeRequest) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) writeRequest);
    }

    public static WriteRequest parseDelimitedFrom(InputStream inputStream) {
        return (WriteRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static WriteRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (WriteRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static WriteRequest parseFrom(ByteString byteString) {
        return (WriteRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static WriteRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (WriteRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static WriteRequest parseFrom(CodedInputStream codedInputStream) {
        return (WriteRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static WriteRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (WriteRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static WriteRequest parseFrom(InputStream inputStream) {
        return (WriteRequest) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static WriteRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (WriteRequest) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static WriteRequest parseFrom(byte[] bArr) {
        return (WriteRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static WriteRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (WriteRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<WriteRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeWrites(int i) {
        ensureWritesIsMutable();
        this.writes_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDatabase(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.database_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDatabaseBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.database_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStreamId(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.streamId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStreamIdBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.streamId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStreamToken(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.streamToken_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWrites(int i, Write.Builder builder) {
        ensureWritesIsMutable();
        this.writes_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWrites(int i, Write write) {
        if (write == null) {
            throw new NullPointerException();
        }
        ensureWritesIsMutable();
        this.writes_.set(i, write);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new WriteRequest();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.writes_.makeImmutable();
                this.labels_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                WriteRequest writeRequest = (WriteRequest) obj2;
                this.database_ = visitor.visitString(!this.database_.isEmpty(), this.database_, !writeRequest.database_.isEmpty(), writeRequest.database_);
                this.streamId_ = visitor.visitString(!this.streamId_.isEmpty(), this.streamId_, !writeRequest.streamId_.isEmpty(), writeRequest.streamId_);
                this.writes_ = visitor.visitList(this.writes_, writeRequest.writes_);
                this.streamToken_ = visitor.visitByteString(this.streamToken_ != ByteString.EMPTY, this.streamToken_, writeRequest.streamToken_ != ByteString.EMPTY, writeRequest.streamToken_);
                this.labels_ = visitor.visitMap(this.labels_, writeRequest.internalGetLabels());
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= writeRequest.bitField0_;
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
                                this.database_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                this.streamId_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 26) {
                                if (!this.writes_.isModifiable()) {
                                    this.writes_ = GeneratedMessageLite.a(this.writes_);
                                }
                                this.writes_.add((Write) codedInputStream.readMessage(Write.parser(), extensionRegistryLite));
                            } else if (readTag == 34) {
                                this.streamToken_ = codedInputStream.readBytes();
                            } else if (readTag == 42) {
                                if (!this.labels_.isMutable()) {
                                    this.labels_ = this.labels_.mutableCopy();
                                }
                                LabelsDefaultEntryHolder.a.parseInto(this.labels_, codedInputStream, extensionRegistryLite);
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
                    synchronized (WriteRequest.class) {
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

    @Override // com.google.firestore.v1.WriteRequestOrBuilder
    public boolean containsLabels(String str) {
        if (str != null) {
            return internalGetLabels().containsKey(str);
        }
        throw new NullPointerException();
    }

    @Override // com.google.firestore.v1.WriteRequestOrBuilder
    public String getDatabase() {
        return this.database_;
    }

    @Override // com.google.firestore.v1.WriteRequestOrBuilder
    public ByteString getDatabaseBytes() {
        return ByteString.copyFromUtf8(this.database_);
    }

    @Override // com.google.firestore.v1.WriteRequestOrBuilder
    @Deprecated
    public Map<String, String> getLabels() {
        return getLabelsMap();
    }

    @Override // com.google.firestore.v1.WriteRequestOrBuilder
    public int getLabelsCount() {
        return internalGetLabels().size();
    }

    @Override // com.google.firestore.v1.WriteRequestOrBuilder
    public Map<String, String> getLabelsMap() {
        return Collections.unmodifiableMap(internalGetLabels());
    }

    @Override // com.google.firestore.v1.WriteRequestOrBuilder
    public String getLabelsOrDefault(String str, String str2) {
        if (str == null) {
            throw new NullPointerException();
        }
        MapFieldLite<String, String> internalGetLabels = internalGetLabels();
        return internalGetLabels.containsKey(str) ? internalGetLabels.get(str) : str2;
    }

    @Override // com.google.firestore.v1.WriteRequestOrBuilder
    public String getLabelsOrThrow(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        MapFieldLite<String, String> internalGetLabels = internalGetLabels();
        if (internalGetLabels.containsKey(str)) {
            return internalGetLabels.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeStringSize = !this.database_.isEmpty() ? CodedOutputStream.computeStringSize(1, getDatabase()) + 0 : 0;
        if (!this.streamId_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(2, getStreamId());
        }
        for (int i2 = 0; i2 < this.writes_.size(); i2++) {
            computeStringSize += CodedOutputStream.computeMessageSize(3, this.writes_.get(i2));
        }
        if (!this.streamToken_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeBytesSize(4, this.streamToken_);
        }
        for (Map.Entry<String, String> entry : internalGetLabels().entrySet()) {
            computeStringSize += LabelsDefaultEntryHolder.a.computeMessageSize(5, entry.getKey(), entry.getValue());
        }
        this.c = computeStringSize;
        return computeStringSize;
    }

    @Override // com.google.firestore.v1.WriteRequestOrBuilder
    public String getStreamId() {
        return this.streamId_;
    }

    @Override // com.google.firestore.v1.WriteRequestOrBuilder
    public ByteString getStreamIdBytes() {
        return ByteString.copyFromUtf8(this.streamId_);
    }

    @Override // com.google.firestore.v1.WriteRequestOrBuilder
    public ByteString getStreamToken() {
        return this.streamToken_;
    }

    @Override // com.google.firestore.v1.WriteRequestOrBuilder
    public Write getWrites(int i) {
        return this.writes_.get(i);
    }

    @Override // com.google.firestore.v1.WriteRequestOrBuilder
    public int getWritesCount() {
        return this.writes_.size();
    }

    @Override // com.google.firestore.v1.WriteRequestOrBuilder
    public List<Write> getWritesList() {
        return this.writes_;
    }

    public WriteOrBuilder getWritesOrBuilder(int i) {
        return this.writes_.get(i);
    }

    public List<? extends WriteOrBuilder> getWritesOrBuilderList() {
        return this.writes_;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!this.database_.isEmpty()) {
            codedOutputStream.writeString(1, getDatabase());
        }
        if (!this.streamId_.isEmpty()) {
            codedOutputStream.writeString(2, getStreamId());
        }
        for (int i = 0; i < this.writes_.size(); i++) {
            codedOutputStream.writeMessage(3, this.writes_.get(i));
        }
        if (!this.streamToken_.isEmpty()) {
            codedOutputStream.writeBytes(4, this.streamToken_);
        }
        for (Map.Entry<String, String> entry : internalGetLabels().entrySet()) {
            LabelsDefaultEntryHolder.a.serializeTo(codedOutputStream, 5, entry.getKey(), entry.getValue());
        }
    }
}
