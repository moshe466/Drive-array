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
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class CommitRequest extends GeneratedMessageLite<CommitRequest, Builder> implements CommitRequestOrBuilder {
    public static final int DATABASE_FIELD_NUMBER = 1;
    private static final CommitRequest DEFAULT_INSTANCE = new CommitRequest();
    private static volatile Parser<CommitRequest> PARSER = null;
    public static final int TRANSACTION_FIELD_NUMBER = 3;
    public static final int WRITES_FIELD_NUMBER = 2;
    private int bitField0_;
    private String database_ = "";
    private Internal.ProtobufList<Write> writes_ = GeneratedMessageLite.f();
    private ByteString transaction_ = ByteString.EMPTY;

    /* renamed from: com.google.firestore.v1.CommitRequest$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<CommitRequest, Builder> implements CommitRequestOrBuilder {
        private Builder() {
            super(CommitRequest.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllWrites(Iterable<? extends Write> iterable) {
            a();
            ((CommitRequest) this.a).addAllWrites(iterable);
            return this;
        }

        public Builder addWrites(int i, Write.Builder builder) {
            a();
            ((CommitRequest) this.a).addWrites(i, builder);
            return this;
        }

        public Builder addWrites(int i, Write write) {
            a();
            ((CommitRequest) this.a).addWrites(i, write);
            return this;
        }

        public Builder addWrites(Write.Builder builder) {
            a();
            ((CommitRequest) this.a).addWrites(builder);
            return this;
        }

        public Builder addWrites(Write write) {
            a();
            ((CommitRequest) this.a).addWrites(write);
            return this;
        }

        public Builder clearDatabase() {
            a();
            ((CommitRequest) this.a).clearDatabase();
            return this;
        }

        public Builder clearTransaction() {
            a();
            ((CommitRequest) this.a).clearTransaction();
            return this;
        }

        public Builder clearWrites() {
            a();
            ((CommitRequest) this.a).clearWrites();
            return this;
        }

        @Override // com.google.firestore.v1.CommitRequestOrBuilder
        public String getDatabase() {
            return ((CommitRequest) this.a).getDatabase();
        }

        @Override // com.google.firestore.v1.CommitRequestOrBuilder
        public ByteString getDatabaseBytes() {
            return ((CommitRequest) this.a).getDatabaseBytes();
        }

        @Override // com.google.firestore.v1.CommitRequestOrBuilder
        public ByteString getTransaction() {
            return ((CommitRequest) this.a).getTransaction();
        }

        @Override // com.google.firestore.v1.CommitRequestOrBuilder
        public Write getWrites(int i) {
            return ((CommitRequest) this.a).getWrites(i);
        }

        @Override // com.google.firestore.v1.CommitRequestOrBuilder
        public int getWritesCount() {
            return ((CommitRequest) this.a).getWritesCount();
        }

        @Override // com.google.firestore.v1.CommitRequestOrBuilder
        public List<Write> getWritesList() {
            return Collections.unmodifiableList(((CommitRequest) this.a).getWritesList());
        }

        public Builder removeWrites(int i) {
            a();
            ((CommitRequest) this.a).removeWrites(i);
            return this;
        }

        public Builder setDatabase(String str) {
            a();
            ((CommitRequest) this.a).setDatabase(str);
            return this;
        }

        public Builder setDatabaseBytes(ByteString byteString) {
            a();
            ((CommitRequest) this.a).setDatabaseBytes(byteString);
            return this;
        }

        public Builder setTransaction(ByteString byteString) {
            a();
            ((CommitRequest) this.a).setTransaction(byteString);
            return this;
        }

        public Builder setWrites(int i, Write.Builder builder) {
            a();
            ((CommitRequest) this.a).setWrites(i, builder);
            return this;
        }

        public Builder setWrites(int i, Write write) {
            a();
            ((CommitRequest) this.a).setWrites(i, write);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private CommitRequest() {
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
    public void clearTransaction() {
        this.transaction_ = getDefaultInstance().getTransaction();
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

    public static CommitRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(CommitRequest commitRequest) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) commitRequest);
    }

    public static CommitRequest parseDelimitedFrom(InputStream inputStream) {
        return (CommitRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static CommitRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CommitRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CommitRequest parseFrom(ByteString byteString) {
        return (CommitRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static CommitRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (CommitRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static CommitRequest parseFrom(CodedInputStream codedInputStream) {
        return (CommitRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static CommitRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CommitRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static CommitRequest parseFrom(InputStream inputStream) {
        return (CommitRequest) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static CommitRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CommitRequest) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CommitRequest parseFrom(byte[] bArr) {
        return (CommitRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static CommitRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (CommitRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<CommitRequest> parser() {
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
    public void setTransaction(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.transaction_ = byteString;
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
                return new CommitRequest();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.writes_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                CommitRequest commitRequest = (CommitRequest) obj2;
                this.database_ = visitor.visitString(!this.database_.isEmpty(), this.database_, !commitRequest.database_.isEmpty(), commitRequest.database_);
                this.writes_ = visitor.visitList(this.writes_, commitRequest.writes_);
                this.transaction_ = visitor.visitByteString(this.transaction_ != ByteString.EMPTY, this.transaction_, commitRequest.transaction_ != ByteString.EMPTY, commitRequest.transaction_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= commitRequest.bitField0_;
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
                                if (!this.writes_.isModifiable()) {
                                    this.writes_ = GeneratedMessageLite.a(this.writes_);
                                }
                                this.writes_.add((Write) codedInputStream.readMessage(Write.parser(), extensionRegistryLite));
                            } else if (readTag == 26) {
                                this.transaction_ = codedInputStream.readBytes();
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
                    synchronized (CommitRequest.class) {
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

    @Override // com.google.firestore.v1.CommitRequestOrBuilder
    public String getDatabase() {
        return this.database_;
    }

    @Override // com.google.firestore.v1.CommitRequestOrBuilder
    public ByteString getDatabaseBytes() {
        return ByteString.copyFromUtf8(this.database_);
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeStringSize = !this.database_.isEmpty() ? CodedOutputStream.computeStringSize(1, getDatabase()) + 0 : 0;
        for (int i2 = 0; i2 < this.writes_.size(); i2++) {
            computeStringSize += CodedOutputStream.computeMessageSize(2, this.writes_.get(i2));
        }
        if (!this.transaction_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeBytesSize(3, this.transaction_);
        }
        this.c = computeStringSize;
        return computeStringSize;
    }

    @Override // com.google.firestore.v1.CommitRequestOrBuilder
    public ByteString getTransaction() {
        return this.transaction_;
    }

    @Override // com.google.firestore.v1.CommitRequestOrBuilder
    public Write getWrites(int i) {
        return this.writes_.get(i);
    }

    @Override // com.google.firestore.v1.CommitRequestOrBuilder
    public int getWritesCount() {
        return this.writes_.size();
    }

    @Override // com.google.firestore.v1.CommitRequestOrBuilder
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
        for (int i = 0; i < this.writes_.size(); i++) {
            codedOutputStream.writeMessage(2, this.writes_.get(i));
        }
        if (this.transaction_.isEmpty()) {
            return;
        }
        codedOutputStream.writeBytes(3, this.transaction_);
    }
}
