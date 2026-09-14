package com.google.firestore.v1;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class ListCollectionIdsRequest extends GeneratedMessageLite<ListCollectionIdsRequest, Builder> implements ListCollectionIdsRequestOrBuilder {
    private static final ListCollectionIdsRequest DEFAULT_INSTANCE = new ListCollectionIdsRequest();
    public static final int PAGE_SIZE_FIELD_NUMBER = 2;
    public static final int PAGE_TOKEN_FIELD_NUMBER = 3;
    public static final int PARENT_FIELD_NUMBER = 1;
    private static volatile Parser<ListCollectionIdsRequest> PARSER;
    private int pageSize_;
    private String parent_ = "";
    private String pageToken_ = "";

    /* renamed from: com.google.firestore.v1.ListCollectionIdsRequest$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<ListCollectionIdsRequest, Builder> implements ListCollectionIdsRequestOrBuilder {
        private Builder() {
            super(ListCollectionIdsRequest.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearPageSize() {
            a();
            ((ListCollectionIdsRequest) this.a).clearPageSize();
            return this;
        }

        public Builder clearPageToken() {
            a();
            ((ListCollectionIdsRequest) this.a).clearPageToken();
            return this;
        }

        public Builder clearParent() {
            a();
            ((ListCollectionIdsRequest) this.a).clearParent();
            return this;
        }

        @Override // com.google.firestore.v1.ListCollectionIdsRequestOrBuilder
        public int getPageSize() {
            return ((ListCollectionIdsRequest) this.a).getPageSize();
        }

        @Override // com.google.firestore.v1.ListCollectionIdsRequestOrBuilder
        public String getPageToken() {
            return ((ListCollectionIdsRequest) this.a).getPageToken();
        }

        @Override // com.google.firestore.v1.ListCollectionIdsRequestOrBuilder
        public ByteString getPageTokenBytes() {
            return ((ListCollectionIdsRequest) this.a).getPageTokenBytes();
        }

        @Override // com.google.firestore.v1.ListCollectionIdsRequestOrBuilder
        public String getParent() {
            return ((ListCollectionIdsRequest) this.a).getParent();
        }

        @Override // com.google.firestore.v1.ListCollectionIdsRequestOrBuilder
        public ByteString getParentBytes() {
            return ((ListCollectionIdsRequest) this.a).getParentBytes();
        }

        public Builder setPageSize(int i) {
            a();
            ((ListCollectionIdsRequest) this.a).setPageSize(i);
            return this;
        }

        public Builder setPageToken(String str) {
            a();
            ((ListCollectionIdsRequest) this.a).setPageToken(str);
            return this;
        }

        public Builder setPageTokenBytes(ByteString byteString) {
            a();
            ((ListCollectionIdsRequest) this.a).setPageTokenBytes(byteString);
            return this;
        }

        public Builder setParent(String str) {
            a();
            ((ListCollectionIdsRequest) this.a).setParent(str);
            return this;
        }

        public Builder setParentBytes(ByteString byteString) {
            a();
            ((ListCollectionIdsRequest) this.a).setParentBytes(byteString);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private ListCollectionIdsRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPageSize() {
        this.pageSize_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPageToken() {
        this.pageToken_ = getDefaultInstance().getPageToken();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParent() {
        this.parent_ = getDefaultInstance().getParent();
    }

    public static ListCollectionIdsRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ListCollectionIdsRequest listCollectionIdsRequest) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) listCollectionIdsRequest);
    }

    public static ListCollectionIdsRequest parseDelimitedFrom(InputStream inputStream) {
        return (ListCollectionIdsRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static ListCollectionIdsRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ListCollectionIdsRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ListCollectionIdsRequest parseFrom(ByteString byteString) {
        return (ListCollectionIdsRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static ListCollectionIdsRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ListCollectionIdsRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ListCollectionIdsRequest parseFrom(CodedInputStream codedInputStream) {
        return (ListCollectionIdsRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ListCollectionIdsRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ListCollectionIdsRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static ListCollectionIdsRequest parseFrom(InputStream inputStream) {
        return (ListCollectionIdsRequest) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static ListCollectionIdsRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ListCollectionIdsRequest) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ListCollectionIdsRequest parseFrom(byte[] bArr) {
        return (ListCollectionIdsRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static ListCollectionIdsRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (ListCollectionIdsRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<ListCollectionIdsRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPageSize(int i) {
        this.pageSize_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPageToken(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.pageToken_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPageTokenBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.pageToken_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParent(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.parent_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParentBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.parent_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new ListCollectionIdsRequest();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                ListCollectionIdsRequest listCollectionIdsRequest = (ListCollectionIdsRequest) obj2;
                this.parent_ = visitor.visitString(!this.parent_.isEmpty(), this.parent_, !listCollectionIdsRequest.parent_.isEmpty(), listCollectionIdsRequest.parent_);
                this.pageSize_ = visitor.visitInt(this.pageSize_ != 0, this.pageSize_, listCollectionIdsRequest.pageSize_ != 0, listCollectionIdsRequest.pageSize_);
                this.pageToken_ = visitor.visitString(!this.pageToken_.isEmpty(), this.pageToken_, !listCollectionIdsRequest.pageToken_.isEmpty(), listCollectionIdsRequest.pageToken_);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                while (!r1) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.parent_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 16) {
                                this.pageSize_ = codedInputStream.readInt32();
                            } else if (readTag == 26) {
                                this.pageToken_ = codedInputStream.readStringRequireUtf8();
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
                    synchronized (ListCollectionIdsRequest.class) {
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

    @Override // com.google.firestore.v1.ListCollectionIdsRequestOrBuilder
    public int getPageSize() {
        return this.pageSize_;
    }

    @Override // com.google.firestore.v1.ListCollectionIdsRequestOrBuilder
    public String getPageToken() {
        return this.pageToken_;
    }

    @Override // com.google.firestore.v1.ListCollectionIdsRequestOrBuilder
    public ByteString getPageTokenBytes() {
        return ByteString.copyFromUtf8(this.pageToken_);
    }

    @Override // com.google.firestore.v1.ListCollectionIdsRequestOrBuilder
    public String getParent() {
        return this.parent_;
    }

    @Override // com.google.firestore.v1.ListCollectionIdsRequestOrBuilder
    public ByteString getParentBytes() {
        return ByteString.copyFromUtf8(this.parent_);
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeStringSize = this.parent_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getParent());
        int i2 = this.pageSize_;
        if (i2 != 0) {
            computeStringSize += CodedOutputStream.computeInt32Size(2, i2);
        }
        if (!this.pageToken_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(3, getPageToken());
        }
        this.c = computeStringSize;
        return computeStringSize;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!this.parent_.isEmpty()) {
            codedOutputStream.writeString(1, getParent());
        }
        int i = this.pageSize_;
        if (i != 0) {
            codedOutputStream.writeInt32(2, i);
        }
        if (this.pageToken_.isEmpty()) {
            return;
        }
        codedOutputStream.writeString(3, getPageToken());
    }
}
