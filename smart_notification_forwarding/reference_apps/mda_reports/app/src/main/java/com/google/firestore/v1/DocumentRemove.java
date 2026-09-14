package com.google.firestore.v1;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class DocumentRemove extends GeneratedMessageLite<DocumentRemove, Builder> implements DocumentRemoveOrBuilder {
    private static final DocumentRemove DEFAULT_INSTANCE = new DocumentRemove();
    public static final int DOCUMENT_FIELD_NUMBER = 1;
    private static volatile Parser<DocumentRemove> PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 4;
    public static final int REMOVED_TARGET_IDS_FIELD_NUMBER = 2;
    private int bitField0_;
    private Timestamp readTime_;
    private String document_ = "";
    private Internal.IntList removedTargetIds_ = GeneratedMessageLite.d();

    /* renamed from: com.google.firestore.v1.DocumentRemove$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<DocumentRemove, Builder> implements DocumentRemoveOrBuilder {
        private Builder() {
            super(DocumentRemove.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllRemovedTargetIds(Iterable<? extends Integer> iterable) {
            a();
            ((DocumentRemove) this.a).addAllRemovedTargetIds(iterable);
            return this;
        }

        public Builder addRemovedTargetIds(int i) {
            a();
            ((DocumentRemove) this.a).addRemovedTargetIds(i);
            return this;
        }

        public Builder clearDocument() {
            a();
            ((DocumentRemove) this.a).clearDocument();
            return this;
        }

        public Builder clearReadTime() {
            a();
            ((DocumentRemove) this.a).clearReadTime();
            return this;
        }

        public Builder clearRemovedTargetIds() {
            a();
            ((DocumentRemove) this.a).clearRemovedTargetIds();
            return this;
        }

        @Override // com.google.firestore.v1.DocumentRemoveOrBuilder
        public String getDocument() {
            return ((DocumentRemove) this.a).getDocument();
        }

        @Override // com.google.firestore.v1.DocumentRemoveOrBuilder
        public ByteString getDocumentBytes() {
            return ((DocumentRemove) this.a).getDocumentBytes();
        }

        @Override // com.google.firestore.v1.DocumentRemoveOrBuilder
        public Timestamp getReadTime() {
            return ((DocumentRemove) this.a).getReadTime();
        }

        @Override // com.google.firestore.v1.DocumentRemoveOrBuilder
        public int getRemovedTargetIds(int i) {
            return ((DocumentRemove) this.a).getRemovedTargetIds(i);
        }

        @Override // com.google.firestore.v1.DocumentRemoveOrBuilder
        public int getRemovedTargetIdsCount() {
            return ((DocumentRemove) this.a).getRemovedTargetIdsCount();
        }

        @Override // com.google.firestore.v1.DocumentRemoveOrBuilder
        public List<Integer> getRemovedTargetIdsList() {
            return Collections.unmodifiableList(((DocumentRemove) this.a).getRemovedTargetIdsList());
        }

        @Override // com.google.firestore.v1.DocumentRemoveOrBuilder
        public boolean hasReadTime() {
            return ((DocumentRemove) this.a).hasReadTime();
        }

        public Builder mergeReadTime(Timestamp timestamp) {
            a();
            ((DocumentRemove) this.a).mergeReadTime(timestamp);
            return this;
        }

        public Builder setDocument(String str) {
            a();
            ((DocumentRemove) this.a).setDocument(str);
            return this;
        }

        public Builder setDocumentBytes(ByteString byteString) {
            a();
            ((DocumentRemove) this.a).setDocumentBytes(byteString);
            return this;
        }

        public Builder setReadTime(Timestamp.Builder builder) {
            a();
            ((DocumentRemove) this.a).setReadTime(builder);
            return this;
        }

        public Builder setReadTime(Timestamp timestamp) {
            a();
            ((DocumentRemove) this.a).setReadTime(timestamp);
            return this;
        }

        public Builder setRemovedTargetIds(int i, int i2) {
            a();
            ((DocumentRemove) this.a).setRemovedTargetIds(i, i2);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private DocumentRemove() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllRemovedTargetIds(Iterable<? extends Integer> iterable) {
        ensureRemovedTargetIdsIsMutable();
        AbstractMessageLite.a(iterable, this.removedTargetIds_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRemovedTargetIds(int i) {
        ensureRemovedTargetIdsIsMutable();
        this.removedTargetIds_.addInt(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDocument() {
        this.document_ = getDefaultInstance().getDocument();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReadTime() {
        this.readTime_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRemovedTargetIds() {
        this.removedTargetIds_ = GeneratedMessageLite.d();
    }

    private void ensureRemovedTargetIdsIsMutable() {
        if (this.removedTargetIds_.isModifiable()) {
            return;
        }
        this.removedTargetIds_ = GeneratedMessageLite.a(this.removedTargetIds_);
    }

    public static DocumentRemove getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeReadTime(Timestamp timestamp) {
        Timestamp timestamp2 = this.readTime_;
        if (timestamp2 != null && timestamp2 != Timestamp.getDefaultInstance()) {
            timestamp = Timestamp.newBuilder(this.readTime_).mergeFrom((Timestamp.Builder) timestamp).buildPartial();
        }
        this.readTime_ = timestamp;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(DocumentRemove documentRemove) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) documentRemove);
    }

    public static DocumentRemove parseDelimitedFrom(InputStream inputStream) {
        return (DocumentRemove) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static DocumentRemove parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DocumentRemove) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DocumentRemove parseFrom(ByteString byteString) {
        return (DocumentRemove) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static DocumentRemove parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DocumentRemove) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static DocumentRemove parseFrom(CodedInputStream codedInputStream) {
        return (DocumentRemove) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static DocumentRemove parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DocumentRemove) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static DocumentRemove parseFrom(InputStream inputStream) {
        return (DocumentRemove) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static DocumentRemove parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DocumentRemove) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DocumentRemove parseFrom(byte[] bArr) {
        return (DocumentRemove) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static DocumentRemove parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (DocumentRemove) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<DocumentRemove> parser() {
        return DEFAULT_INSTANCE.getParserForType();
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
    public void setReadTime(Timestamp.Builder builder) {
        this.readTime_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReadTime(Timestamp timestamp) {
        if (timestamp == null) {
            throw new NullPointerException();
        }
        this.readTime_ = timestamp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRemovedTargetIds(int i, int i2) {
        ensureRemovedTargetIdsIsMutable();
        this.removedTargetIds_.setInt(i, i2);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new DocumentRemove();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.removedTargetIds_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                DocumentRemove documentRemove = (DocumentRemove) obj2;
                this.document_ = visitor.visitString(!this.document_.isEmpty(), this.document_, true ^ documentRemove.document_.isEmpty(), documentRemove.document_);
                this.removedTargetIds_ = visitor.visitIntList(this.removedTargetIds_, documentRemove.removedTargetIds_);
                this.readTime_ = (Timestamp) visitor.visitMessage(this.readTime_, documentRemove.readTime_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= documentRemove.bitField0_;
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
                                this.document_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 16) {
                                if (!this.removedTargetIds_.isModifiable()) {
                                    this.removedTargetIds_ = GeneratedMessageLite.a(this.removedTargetIds_);
                                }
                                this.removedTargetIds_.addInt(codedInputStream.readInt32());
                            } else if (readTag == 18) {
                                int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                if (!this.removedTargetIds_.isModifiable() && codedInputStream.getBytesUntilLimit() > 0) {
                                    this.removedTargetIds_ = GeneratedMessageLite.a(this.removedTargetIds_);
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.removedTargetIds_.addInt(codedInputStream.readInt32());
                                }
                                codedInputStream.popLimit(pushLimit);
                            } else if (readTag == 34) {
                                Timestamp.Builder builder = this.readTime_ != null ? this.readTime_.toBuilder() : null;
                                this.readTime_ = (Timestamp) codedInputStream.readMessage(Timestamp.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom((Timestamp.Builder) this.readTime_);
                                    this.readTime_ = builder.buildPartial();
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
                    synchronized (DocumentRemove.class) {
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

    @Override // com.google.firestore.v1.DocumentRemoveOrBuilder
    public String getDocument() {
        return this.document_;
    }

    @Override // com.google.firestore.v1.DocumentRemoveOrBuilder
    public ByteString getDocumentBytes() {
        return ByteString.copyFromUtf8(this.document_);
    }

    @Override // com.google.firestore.v1.DocumentRemoveOrBuilder
    public Timestamp getReadTime() {
        Timestamp timestamp = this.readTime_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // com.google.firestore.v1.DocumentRemoveOrBuilder
    public int getRemovedTargetIds(int i) {
        return this.removedTargetIds_.getInt(i);
    }

    @Override // com.google.firestore.v1.DocumentRemoveOrBuilder
    public int getRemovedTargetIdsCount() {
        return this.removedTargetIds_.size();
    }

    @Override // com.google.firestore.v1.DocumentRemoveOrBuilder
    public List<Integer> getRemovedTargetIdsList() {
        return this.removedTargetIds_;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeStringSize = !this.document_.isEmpty() ? CodedOutputStream.computeStringSize(1, getDocument()) + 0 : 0;
        int i2 = 0;
        for (int i3 = 0; i3 < this.removedTargetIds_.size(); i3++) {
            i2 += CodedOutputStream.computeInt32SizeNoTag(this.removedTargetIds_.getInt(i3));
        }
        int size = computeStringSize + i2 + (getRemovedTargetIdsList().size() * 1);
        if (this.readTime_ != null) {
            size += CodedOutputStream.computeMessageSize(4, getReadTime());
        }
        this.c = size;
        return size;
    }

    @Override // com.google.firestore.v1.DocumentRemoveOrBuilder
    public boolean hasReadTime() {
        return this.readTime_ != null;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        getSerializedSize();
        if (!this.document_.isEmpty()) {
            codedOutputStream.writeString(1, getDocument());
        }
        for (int i = 0; i < this.removedTargetIds_.size(); i++) {
            codedOutputStream.writeInt32(2, this.removedTargetIds_.getInt(i));
        }
        if (this.readTime_ != null) {
            codedOutputStream.writeMessage(4, getReadTime());
        }
    }
}
