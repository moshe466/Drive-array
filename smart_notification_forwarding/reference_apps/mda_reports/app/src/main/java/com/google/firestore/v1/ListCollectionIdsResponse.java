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
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class ListCollectionIdsResponse extends GeneratedMessageLite<ListCollectionIdsResponse, Builder> implements ListCollectionIdsResponseOrBuilder {
    public static final int COLLECTION_IDS_FIELD_NUMBER = 1;
    private static final ListCollectionIdsResponse DEFAULT_INSTANCE = new ListCollectionIdsResponse();
    public static final int NEXT_PAGE_TOKEN_FIELD_NUMBER = 2;
    private static volatile Parser<ListCollectionIdsResponse> PARSER;
    private int bitField0_;
    private Internal.ProtobufList<String> collectionIds_ = GeneratedMessageLite.f();
    private String nextPageToken_ = "";

    /* renamed from: com.google.firestore.v1.ListCollectionIdsResponse$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<ListCollectionIdsResponse, Builder> implements ListCollectionIdsResponseOrBuilder {
        private Builder() {
            super(ListCollectionIdsResponse.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllCollectionIds(Iterable<String> iterable) {
            a();
            ((ListCollectionIdsResponse) this.a).addAllCollectionIds(iterable);
            return this;
        }

        public Builder addCollectionIds(String str) {
            a();
            ((ListCollectionIdsResponse) this.a).addCollectionIds(str);
            return this;
        }

        public Builder addCollectionIdsBytes(ByteString byteString) {
            a();
            ((ListCollectionIdsResponse) this.a).addCollectionIdsBytes(byteString);
            return this;
        }

        public Builder clearCollectionIds() {
            a();
            ((ListCollectionIdsResponse) this.a).clearCollectionIds();
            return this;
        }

        public Builder clearNextPageToken() {
            a();
            ((ListCollectionIdsResponse) this.a).clearNextPageToken();
            return this;
        }

        @Override // com.google.firestore.v1.ListCollectionIdsResponseOrBuilder
        public String getCollectionIds(int i) {
            return ((ListCollectionIdsResponse) this.a).getCollectionIds(i);
        }

        @Override // com.google.firestore.v1.ListCollectionIdsResponseOrBuilder
        public ByteString getCollectionIdsBytes(int i) {
            return ((ListCollectionIdsResponse) this.a).getCollectionIdsBytes(i);
        }

        @Override // com.google.firestore.v1.ListCollectionIdsResponseOrBuilder
        public int getCollectionIdsCount() {
            return ((ListCollectionIdsResponse) this.a).getCollectionIdsCount();
        }

        @Override // com.google.firestore.v1.ListCollectionIdsResponseOrBuilder
        public List<String> getCollectionIdsList() {
            return Collections.unmodifiableList(((ListCollectionIdsResponse) this.a).getCollectionIdsList());
        }

        @Override // com.google.firestore.v1.ListCollectionIdsResponseOrBuilder
        public String getNextPageToken() {
            return ((ListCollectionIdsResponse) this.a).getNextPageToken();
        }

        @Override // com.google.firestore.v1.ListCollectionIdsResponseOrBuilder
        public ByteString getNextPageTokenBytes() {
            return ((ListCollectionIdsResponse) this.a).getNextPageTokenBytes();
        }

        public Builder setCollectionIds(int i, String str) {
            a();
            ((ListCollectionIdsResponse) this.a).setCollectionIds(i, str);
            return this;
        }

        public Builder setNextPageToken(String str) {
            a();
            ((ListCollectionIdsResponse) this.a).setNextPageToken(str);
            return this;
        }

        public Builder setNextPageTokenBytes(ByteString byteString) {
            a();
            ((ListCollectionIdsResponse) this.a).setNextPageTokenBytes(byteString);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private ListCollectionIdsResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllCollectionIds(Iterable<String> iterable) {
        ensureCollectionIdsIsMutable();
        AbstractMessageLite.a(iterable, this.collectionIds_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCollectionIds(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        ensureCollectionIdsIsMutable();
        this.collectionIds_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCollectionIdsBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        ensureCollectionIdsIsMutable();
        this.collectionIds_.add(byteString.toStringUtf8());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCollectionIds() {
        this.collectionIds_ = GeneratedMessageLite.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNextPageToken() {
        this.nextPageToken_ = getDefaultInstance().getNextPageToken();
    }

    private void ensureCollectionIdsIsMutable() {
        if (this.collectionIds_.isModifiable()) {
            return;
        }
        this.collectionIds_ = GeneratedMessageLite.a(this.collectionIds_);
    }

    public static ListCollectionIdsResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ListCollectionIdsResponse listCollectionIdsResponse) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) listCollectionIdsResponse);
    }

    public static ListCollectionIdsResponse parseDelimitedFrom(InputStream inputStream) {
        return (ListCollectionIdsResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static ListCollectionIdsResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ListCollectionIdsResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ListCollectionIdsResponse parseFrom(ByteString byteString) {
        return (ListCollectionIdsResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static ListCollectionIdsResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ListCollectionIdsResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ListCollectionIdsResponse parseFrom(CodedInputStream codedInputStream) {
        return (ListCollectionIdsResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ListCollectionIdsResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ListCollectionIdsResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static ListCollectionIdsResponse parseFrom(InputStream inputStream) {
        return (ListCollectionIdsResponse) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static ListCollectionIdsResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ListCollectionIdsResponse) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ListCollectionIdsResponse parseFrom(byte[] bArr) {
        return (ListCollectionIdsResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static ListCollectionIdsResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (ListCollectionIdsResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<ListCollectionIdsResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCollectionIds(int i, String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        ensureCollectionIdsIsMutable();
        this.collectionIds_.set(i, str);
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
                return new ListCollectionIdsResponse();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.collectionIds_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                ListCollectionIdsResponse listCollectionIdsResponse = (ListCollectionIdsResponse) obj2;
                this.collectionIds_ = visitor.visitList(this.collectionIds_, listCollectionIdsResponse.collectionIds_);
                this.nextPageToken_ = visitor.visitString(!this.nextPageToken_.isEmpty(), this.nextPageToken_, true ^ listCollectionIdsResponse.nextPageToken_.isEmpty(), listCollectionIdsResponse.nextPageToken_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= listCollectionIdsResponse.bitField0_;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                boolean z = false;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                String readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                if (!this.collectionIds_.isModifiable()) {
                                    this.collectionIds_ = GeneratedMessageLite.a(this.collectionIds_);
                                }
                                this.collectionIds_.add(readStringRequireUtf8);
                            } else if (readTag == 18) {
                                this.nextPageToken_ = codedInputStream.readStringRequireUtf8();
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
                    synchronized (ListCollectionIdsResponse.class) {
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

    @Override // com.google.firestore.v1.ListCollectionIdsResponseOrBuilder
    public String getCollectionIds(int i) {
        return this.collectionIds_.get(i);
    }

    @Override // com.google.firestore.v1.ListCollectionIdsResponseOrBuilder
    public ByteString getCollectionIdsBytes(int i) {
        return ByteString.copyFromUtf8(this.collectionIds_.get(i));
    }

    @Override // com.google.firestore.v1.ListCollectionIdsResponseOrBuilder
    public int getCollectionIdsCount() {
        return this.collectionIds_.size();
    }

    @Override // com.google.firestore.v1.ListCollectionIdsResponseOrBuilder
    public List<String> getCollectionIdsList() {
        return this.collectionIds_;
    }

    @Override // com.google.firestore.v1.ListCollectionIdsResponseOrBuilder
    public String getNextPageToken() {
        return this.nextPageToken_;
    }

    @Override // com.google.firestore.v1.ListCollectionIdsResponseOrBuilder
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
        for (int i3 = 0; i3 < this.collectionIds_.size(); i3++) {
            i2 += CodedOutputStream.computeStringSizeNoTag(this.collectionIds_.get(i3));
        }
        int size = 0 + i2 + (getCollectionIdsList().size() * 1);
        if (!this.nextPageToken_.isEmpty()) {
            size += CodedOutputStream.computeStringSize(2, getNextPageToken());
        }
        this.c = size;
        return size;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        for (int i = 0; i < this.collectionIds_.size(); i++) {
            codedOutputStream.writeString(1, this.collectionIds_.get(i));
        }
        if (this.nextPageToken_.isEmpty()) {
            return;
        }
        codedOutputStream.writeString(2, getNextPageToken());
    }
}
