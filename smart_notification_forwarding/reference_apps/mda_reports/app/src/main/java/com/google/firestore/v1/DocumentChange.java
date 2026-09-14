package com.google.firestore.v1;

import com.google.firestore.v1.Document;
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
public final class DocumentChange extends GeneratedMessageLite<DocumentChange, Builder> implements DocumentChangeOrBuilder {
    private static final DocumentChange DEFAULT_INSTANCE = new DocumentChange();
    public static final int DOCUMENT_FIELD_NUMBER = 1;
    private static volatile Parser<DocumentChange> PARSER = null;
    public static final int REMOVED_TARGET_IDS_FIELD_NUMBER = 6;
    public static final int TARGET_IDS_FIELD_NUMBER = 5;
    private int bitField0_;
    private Document document_;
    private Internal.IntList targetIds_ = GeneratedMessageLite.d();
    private Internal.IntList removedTargetIds_ = GeneratedMessageLite.d();

    /* renamed from: com.google.firestore.v1.DocumentChange$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<DocumentChange, Builder> implements DocumentChangeOrBuilder {
        private Builder() {
            super(DocumentChange.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllRemovedTargetIds(Iterable<? extends Integer> iterable) {
            a();
            ((DocumentChange) this.a).addAllRemovedTargetIds(iterable);
            return this;
        }

        public Builder addAllTargetIds(Iterable<? extends Integer> iterable) {
            a();
            ((DocumentChange) this.a).addAllTargetIds(iterable);
            return this;
        }

        public Builder addRemovedTargetIds(int i) {
            a();
            ((DocumentChange) this.a).addRemovedTargetIds(i);
            return this;
        }

        public Builder addTargetIds(int i) {
            a();
            ((DocumentChange) this.a).addTargetIds(i);
            return this;
        }

        public Builder clearDocument() {
            a();
            ((DocumentChange) this.a).clearDocument();
            return this;
        }

        public Builder clearRemovedTargetIds() {
            a();
            ((DocumentChange) this.a).clearRemovedTargetIds();
            return this;
        }

        public Builder clearTargetIds() {
            a();
            ((DocumentChange) this.a).clearTargetIds();
            return this;
        }

        @Override // com.google.firestore.v1.DocumentChangeOrBuilder
        public Document getDocument() {
            return ((DocumentChange) this.a).getDocument();
        }

        @Override // com.google.firestore.v1.DocumentChangeOrBuilder
        public int getRemovedTargetIds(int i) {
            return ((DocumentChange) this.a).getRemovedTargetIds(i);
        }

        @Override // com.google.firestore.v1.DocumentChangeOrBuilder
        public int getRemovedTargetIdsCount() {
            return ((DocumentChange) this.a).getRemovedTargetIdsCount();
        }

        @Override // com.google.firestore.v1.DocumentChangeOrBuilder
        public List<Integer> getRemovedTargetIdsList() {
            return Collections.unmodifiableList(((DocumentChange) this.a).getRemovedTargetIdsList());
        }

        @Override // com.google.firestore.v1.DocumentChangeOrBuilder
        public int getTargetIds(int i) {
            return ((DocumentChange) this.a).getTargetIds(i);
        }

        @Override // com.google.firestore.v1.DocumentChangeOrBuilder
        public int getTargetIdsCount() {
            return ((DocumentChange) this.a).getTargetIdsCount();
        }

        @Override // com.google.firestore.v1.DocumentChangeOrBuilder
        public List<Integer> getTargetIdsList() {
            return Collections.unmodifiableList(((DocumentChange) this.a).getTargetIdsList());
        }

        @Override // com.google.firestore.v1.DocumentChangeOrBuilder
        public boolean hasDocument() {
            return ((DocumentChange) this.a).hasDocument();
        }

        public Builder mergeDocument(Document document) {
            a();
            ((DocumentChange) this.a).mergeDocument(document);
            return this;
        }

        public Builder setDocument(Document.Builder builder) {
            a();
            ((DocumentChange) this.a).setDocument(builder);
            return this;
        }

        public Builder setDocument(Document document) {
            a();
            ((DocumentChange) this.a).setDocument(document);
            return this;
        }

        public Builder setRemovedTargetIds(int i, int i2) {
            a();
            ((DocumentChange) this.a).setRemovedTargetIds(i, i2);
            return this;
        }

        public Builder setTargetIds(int i, int i2) {
            a();
            ((DocumentChange) this.a).setTargetIds(i, i2);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private DocumentChange() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllRemovedTargetIds(Iterable<? extends Integer> iterable) {
        ensureRemovedTargetIdsIsMutable();
        AbstractMessageLite.a(iterable, this.removedTargetIds_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllTargetIds(Iterable<? extends Integer> iterable) {
        ensureTargetIdsIsMutable();
        AbstractMessageLite.a(iterable, this.targetIds_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRemovedTargetIds(int i) {
        ensureRemovedTargetIdsIsMutable();
        this.removedTargetIds_.addInt(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTargetIds(int i) {
        ensureTargetIdsIsMutable();
        this.targetIds_.addInt(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDocument() {
        this.document_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRemovedTargetIds() {
        this.removedTargetIds_ = GeneratedMessageLite.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTargetIds() {
        this.targetIds_ = GeneratedMessageLite.d();
    }

    private void ensureRemovedTargetIdsIsMutable() {
        if (this.removedTargetIds_.isModifiable()) {
            return;
        }
        this.removedTargetIds_ = GeneratedMessageLite.a(this.removedTargetIds_);
    }

    private void ensureTargetIdsIsMutable() {
        if (this.targetIds_.isModifiable()) {
            return;
        }
        this.targetIds_ = GeneratedMessageLite.a(this.targetIds_);
    }

    public static DocumentChange getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeDocument(Document document) {
        Document document2 = this.document_;
        if (document2 != null && document2 != Document.getDefaultInstance()) {
            document = Document.newBuilder(this.document_).mergeFrom((Document.Builder) document).buildPartial();
        }
        this.document_ = document;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(DocumentChange documentChange) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) documentChange);
    }

    public static DocumentChange parseDelimitedFrom(InputStream inputStream) {
        return (DocumentChange) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static DocumentChange parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DocumentChange) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DocumentChange parseFrom(ByteString byteString) {
        return (DocumentChange) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static DocumentChange parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DocumentChange) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static DocumentChange parseFrom(CodedInputStream codedInputStream) {
        return (DocumentChange) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static DocumentChange parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DocumentChange) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static DocumentChange parseFrom(InputStream inputStream) {
        return (DocumentChange) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static DocumentChange parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DocumentChange) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DocumentChange parseFrom(byte[] bArr) {
        return (DocumentChange) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static DocumentChange parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (DocumentChange) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<DocumentChange> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDocument(Document.Builder builder) {
        this.document_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDocument(Document document) {
        if (document == null) {
            throw new NullPointerException();
        }
        this.document_ = document;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRemovedTargetIds(int i, int i2) {
        ensureRemovedTargetIdsIsMutable();
        this.removedTargetIds_.setInt(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTargetIds(int i, int i2) {
        ensureTargetIdsIsMutable();
        this.targetIds_.setInt(i, i2);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Internal.IntList intList;
        int readInt32;
        int pushLimit;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new DocumentChange();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.targetIds_.makeImmutable();
                this.removedTargetIds_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                DocumentChange documentChange = (DocumentChange) obj2;
                this.document_ = (Document) visitor.visitMessage(this.document_, documentChange.document_);
                this.targetIds_ = visitor.visitIntList(this.targetIds_, documentChange.targetIds_);
                this.removedTargetIds_ = visitor.visitIntList(this.removedTargetIds_, documentChange.removedTargetIds_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= documentChange.bitField0_;
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
                            if (readTag != 10) {
                                if (readTag != 40) {
                                    if (readTag == 42) {
                                        pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                        if (!this.targetIds_.isModifiable() && codedInputStream.getBytesUntilLimit() > 0) {
                                            this.targetIds_ = GeneratedMessageLite.a(this.targetIds_);
                                        }
                                        while (codedInputStream.getBytesUntilLimit() > 0) {
                                            this.targetIds_.addInt(codedInputStream.readInt32());
                                        }
                                    } else if (readTag == 48) {
                                        if (!this.removedTargetIds_.isModifiable()) {
                                            this.removedTargetIds_ = GeneratedMessageLite.a(this.removedTargetIds_);
                                        }
                                        intList = this.removedTargetIds_;
                                        readInt32 = codedInputStream.readInt32();
                                    } else if (readTag == 50) {
                                        pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                        if (!this.removedTargetIds_.isModifiable() && codedInputStream.getBytesUntilLimit() > 0) {
                                            this.removedTargetIds_ = GeneratedMessageLite.a(this.removedTargetIds_);
                                        }
                                        while (codedInputStream.getBytesUntilLimit() > 0) {
                                            this.removedTargetIds_.addInt(codedInputStream.readInt32());
                                        }
                                    } else if (!codedInputStream.skipField(readTag)) {
                                    }
                                    codedInputStream.popLimit(pushLimit);
                                } else {
                                    if (!this.targetIds_.isModifiable()) {
                                        this.targetIds_ = GeneratedMessageLite.a(this.targetIds_);
                                    }
                                    intList = this.targetIds_;
                                    readInt32 = codedInputStream.readInt32();
                                }
                                intList.addInt(readInt32);
                            } else {
                                Document.Builder builder = this.document_ != null ? this.document_.toBuilder() : null;
                                this.document_ = (Document) codedInputStream.readMessage(Document.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom((Document.Builder) this.document_);
                                    this.document_ = builder.buildPartial();
                                }
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
                    synchronized (DocumentChange.class) {
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

    @Override // com.google.firestore.v1.DocumentChangeOrBuilder
    public Document getDocument() {
        Document document = this.document_;
        return document == null ? Document.getDefaultInstance() : document;
    }

    @Override // com.google.firestore.v1.DocumentChangeOrBuilder
    public int getRemovedTargetIds(int i) {
        return this.removedTargetIds_.getInt(i);
    }

    @Override // com.google.firestore.v1.DocumentChangeOrBuilder
    public int getRemovedTargetIdsCount() {
        return this.removedTargetIds_.size();
    }

    @Override // com.google.firestore.v1.DocumentChangeOrBuilder
    public List<Integer> getRemovedTargetIdsList() {
        return this.removedTargetIds_;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeMessageSize = this.document_ != null ? CodedOutputStream.computeMessageSize(1, getDocument()) + 0 : 0;
        int i2 = 0;
        for (int i3 = 0; i3 < this.targetIds_.size(); i3++) {
            i2 += CodedOutputStream.computeInt32SizeNoTag(this.targetIds_.getInt(i3));
        }
        int size = computeMessageSize + i2 + (getTargetIdsList().size() * 1);
        int i4 = 0;
        for (int i5 = 0; i5 < this.removedTargetIds_.size(); i5++) {
            i4 += CodedOutputStream.computeInt32SizeNoTag(this.removedTargetIds_.getInt(i5));
        }
        int size2 = size + i4 + (getRemovedTargetIdsList().size() * 1);
        this.c = size2;
        return size2;
    }

    @Override // com.google.firestore.v1.DocumentChangeOrBuilder
    public int getTargetIds(int i) {
        return this.targetIds_.getInt(i);
    }

    @Override // com.google.firestore.v1.DocumentChangeOrBuilder
    public int getTargetIdsCount() {
        return this.targetIds_.size();
    }

    @Override // com.google.firestore.v1.DocumentChangeOrBuilder
    public List<Integer> getTargetIdsList() {
        return this.targetIds_;
    }

    @Override // com.google.firestore.v1.DocumentChangeOrBuilder
    public boolean hasDocument() {
        return this.document_ != null;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        getSerializedSize();
        if (this.document_ != null) {
            codedOutputStream.writeMessage(1, getDocument());
        }
        for (int i = 0; i < this.targetIds_.size(); i++) {
            codedOutputStream.writeInt32(5, this.targetIds_.getInt(i));
        }
        for (int i2 = 0; i2 < this.removedTargetIds_.size(); i2++) {
            codedOutputStream.writeInt32(6, this.removedTargetIds_.getInt(i2));
        }
    }
}
