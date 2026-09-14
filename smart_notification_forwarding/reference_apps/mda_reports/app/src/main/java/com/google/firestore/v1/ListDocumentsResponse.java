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
public final class ListDocumentsResponse extends GeneratedMessageLite<ListDocumentsResponse, Builder> implements ListDocumentsResponseOrBuilder {
    private static final ListDocumentsResponse DEFAULT_INSTANCE = new ListDocumentsResponse();
    public static final int DOCUMENTS_FIELD_NUMBER = 1;
    public static final int NEXT_PAGE_TOKEN_FIELD_NUMBER = 2;
    private static volatile Parser<ListDocumentsResponse> PARSER;
    private int bitField0_;
    private Internal.ProtobufList<Document> documents_ = GeneratedMessageLite.f();
    private String nextPageToken_ = "";

    /* renamed from: com.google.firestore.v1.ListDocumentsResponse$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<ListDocumentsResponse, Builder> implements ListDocumentsResponseOrBuilder {
        private Builder() {
            super(ListDocumentsResponse.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllDocuments(Iterable<? extends Document> iterable) {
            a();
            ((ListDocumentsResponse) this.a).addAllDocuments(iterable);
            return this;
        }

        public Builder addDocuments(int i, Document.Builder builder) {
            a();
            ((ListDocumentsResponse) this.a).addDocuments(i, builder);
            return this;
        }

        public Builder addDocuments(int i, Document document) {
            a();
            ((ListDocumentsResponse) this.a).addDocuments(i, document);
            return this;
        }

        public Builder addDocuments(Document.Builder builder) {
            a();
            ((ListDocumentsResponse) this.a).addDocuments(builder);
            return this;
        }

        public Builder addDocuments(Document document) {
            a();
            ((ListDocumentsResponse) this.a).addDocuments(document);
            return this;
        }

        public Builder clearDocuments() {
            a();
            ((ListDocumentsResponse) this.a).clearDocuments();
            return this;
        }

        public Builder clearNextPageToken() {
            a();
            ((ListDocumentsResponse) this.a).clearNextPageToken();
            return this;
        }

        @Override // com.google.firestore.v1.ListDocumentsResponseOrBuilder
        public Document getDocuments(int i) {
            return ((ListDocumentsResponse) this.a).getDocuments(i);
        }

        @Override // com.google.firestore.v1.ListDocumentsResponseOrBuilder
        public int getDocumentsCount() {
            return ((ListDocumentsResponse) this.a).getDocumentsCount();
        }

        @Override // com.google.firestore.v1.ListDocumentsResponseOrBuilder
        public List<Document> getDocumentsList() {
            return Collections.unmodifiableList(((ListDocumentsResponse) this.a).getDocumentsList());
        }

        @Override // com.google.firestore.v1.ListDocumentsResponseOrBuilder
        public String getNextPageToken() {
            return ((ListDocumentsResponse) this.a).getNextPageToken();
        }

        @Override // com.google.firestore.v1.ListDocumentsResponseOrBuilder
        public ByteString getNextPageTokenBytes() {
            return ((ListDocumentsResponse) this.a).getNextPageTokenBytes();
        }

        public Builder removeDocuments(int i) {
            a();
            ((ListDocumentsResponse) this.a).removeDocuments(i);
            return this;
        }

        public Builder setDocuments(int i, Document.Builder builder) {
            a();
            ((ListDocumentsResponse) this.a).setDocuments(i, builder);
            return this;
        }

        public Builder setDocuments(int i, Document document) {
            a();
            ((ListDocumentsResponse) this.a).setDocuments(i, document);
            return this;
        }

        public Builder setNextPageToken(String str) {
            a();
            ((ListDocumentsResponse) this.a).setNextPageToken(str);
            return this;
        }

        public Builder setNextPageTokenBytes(ByteString byteString) {
            a();
            ((ListDocumentsResponse) this.a).setNextPageTokenBytes(byteString);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private ListDocumentsResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllDocuments(Iterable<? extends Document> iterable) {
        ensureDocumentsIsMutable();
        AbstractMessageLite.a(iterable, this.documents_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDocuments(int i, Document.Builder builder) {
        ensureDocumentsIsMutable();
        this.documents_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDocuments(int i, Document document) {
        if (document == null) {
            throw new NullPointerException();
        }
        ensureDocumentsIsMutable();
        this.documents_.add(i, document);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDocuments(Document.Builder builder) {
        ensureDocumentsIsMutable();
        this.documents_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDocuments(Document document) {
        if (document == null) {
            throw new NullPointerException();
        }
        ensureDocumentsIsMutable();
        this.documents_.add(document);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDocuments() {
        this.documents_ = GeneratedMessageLite.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNextPageToken() {
        this.nextPageToken_ = getDefaultInstance().getNextPageToken();
    }

    private void ensureDocumentsIsMutable() {
        if (this.documents_.isModifiable()) {
            return;
        }
        this.documents_ = GeneratedMessageLite.a(this.documents_);
    }

    public static ListDocumentsResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ListDocumentsResponse listDocumentsResponse) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) listDocumentsResponse);
    }

    public static ListDocumentsResponse parseDelimitedFrom(InputStream inputStream) {
        return (ListDocumentsResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static ListDocumentsResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ListDocumentsResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ListDocumentsResponse parseFrom(ByteString byteString) {
        return (ListDocumentsResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static ListDocumentsResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ListDocumentsResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ListDocumentsResponse parseFrom(CodedInputStream codedInputStream) {
        return (ListDocumentsResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ListDocumentsResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ListDocumentsResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static ListDocumentsResponse parseFrom(InputStream inputStream) {
        return (ListDocumentsResponse) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static ListDocumentsResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ListDocumentsResponse) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ListDocumentsResponse parseFrom(byte[] bArr) {
        return (ListDocumentsResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static ListDocumentsResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (ListDocumentsResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<ListDocumentsResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeDocuments(int i) {
        ensureDocumentsIsMutable();
        this.documents_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDocuments(int i, Document.Builder builder) {
        ensureDocumentsIsMutable();
        this.documents_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDocuments(int i, Document document) {
        if (document == null) {
            throw new NullPointerException();
        }
        ensureDocumentsIsMutable();
        this.documents_.set(i, document);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNextPageToken(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.nextPageToken_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNextPageTokenBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.nextPageToken_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new ListDocumentsResponse();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.documents_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                ListDocumentsResponse listDocumentsResponse = (ListDocumentsResponse) obj2;
                this.documents_ = visitor.visitList(this.documents_, listDocumentsResponse.documents_);
                this.nextPageToken_ = visitor.visitString(!this.nextPageToken_.isEmpty(), this.nextPageToken_, true ^ listDocumentsResponse.nextPageToken_.isEmpty(), listDocumentsResponse.nextPageToken_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= listDocumentsResponse.bitField0_;
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
                                    if (!this.documents_.isModifiable()) {
                                        this.documents_ = GeneratedMessageLite.a(this.documents_);
                                    }
                                    this.documents_.add((Document) codedInputStream.readMessage(Document.parser(), extensionRegistryLite));
                                } else if (readTag == 18) {
                                    this.nextPageToken_ = codedInputStream.readStringRequireUtf8();
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
                    synchronized (ListDocumentsResponse.class) {
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

    @Override // com.google.firestore.v1.ListDocumentsResponseOrBuilder
    public Document getDocuments(int i) {
        return this.documents_.get(i);
    }

    @Override // com.google.firestore.v1.ListDocumentsResponseOrBuilder
    public int getDocumentsCount() {
        return this.documents_.size();
    }

    @Override // com.google.firestore.v1.ListDocumentsResponseOrBuilder
    public List<Document> getDocumentsList() {
        return this.documents_;
    }

    public DocumentOrBuilder getDocumentsOrBuilder(int i) {
        return this.documents_.get(i);
    }

    public List<? extends DocumentOrBuilder> getDocumentsOrBuilderList() {
        return this.documents_;
    }

    @Override // com.google.firestore.v1.ListDocumentsResponseOrBuilder
    public String getNextPageToken() {
        return this.nextPageToken_;
    }

    @Override // com.google.firestore.v1.ListDocumentsResponseOrBuilder
    public ByteString getNextPageTokenBytes() {
        return ByteString.copyFromUtf8(this.nextPageToken_);
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.documents_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(1, this.documents_.get(i3));
        }
        if (!this.nextPageToken_.isEmpty()) {
            i2 += CodedOutputStream.computeStringSize(2, getNextPageToken());
        }
        this.c = i2;
        return i2;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        for (int i = 0; i < this.documents_.size(); i++) {
            codedOutputStream.writeMessage(1, this.documents_.get(i));
        }
        if (this.nextPageToken_.isEmpty()) {
            return;
        }
        codedOutputStream.writeString(2, getNextPageToken());
    }
}
