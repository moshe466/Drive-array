package com.google.longrunning;

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
public final class ListOperationsRequest extends GeneratedMessageLite<ListOperationsRequest, Builder> implements ListOperationsRequestOrBuilder {
    private static final ListOperationsRequest DEFAULT_INSTANCE = new ListOperationsRequest();
    public static final int FILTER_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 4;
    public static final int PAGE_SIZE_FIELD_NUMBER = 2;
    public static final int PAGE_TOKEN_FIELD_NUMBER = 3;
    private static volatile Parser<ListOperationsRequest> PARSER;
    private int pageSize_;
    private String name_ = "";
    private String filter_ = "";
    private String pageToken_ = "";

    /* renamed from: com.google.longrunning.ListOperationsRequest$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<ListOperationsRequest, Builder> implements ListOperationsRequestOrBuilder {
        private Builder() {
            super(ListOperationsRequest.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearFilter() {
            a();
            ((ListOperationsRequest) this.a).clearFilter();
            return this;
        }

        public Builder clearName() {
            a();
            ((ListOperationsRequest) this.a).clearName();
            return this;
        }

        public Builder clearPageSize() {
            a();
            ((ListOperationsRequest) this.a).clearPageSize();
            return this;
        }

        public Builder clearPageToken() {
            a();
            ((ListOperationsRequest) this.a).clearPageToken();
            return this;
        }

        @Override // com.google.longrunning.ListOperationsRequestOrBuilder
        public String getFilter() {
            return ((ListOperationsRequest) this.a).getFilter();
        }

        @Override // com.google.longrunning.ListOperationsRequestOrBuilder
        public ByteString getFilterBytes() {
            return ((ListOperationsRequest) this.a).getFilterBytes();
        }

        @Override // com.google.longrunning.ListOperationsRequestOrBuilder
        public String getName() {
            return ((ListOperationsRequest) this.a).getName();
        }

        @Override // com.google.longrunning.ListOperationsRequestOrBuilder
        public ByteString getNameBytes() {
            return ((ListOperationsRequest) this.a).getNameBytes();
        }

        @Override // com.google.longrunning.ListOperationsRequestOrBuilder
        public int getPageSize() {
            return ((ListOperationsRequest) this.a).getPageSize();
        }

        @Override // com.google.longrunning.ListOperationsRequestOrBuilder
        public String getPageToken() {
            return ((ListOperationsRequest) this.a).getPageToken();
        }

        @Override // com.google.longrunning.ListOperationsRequestOrBuilder
        public ByteString getPageTokenBytes() {
            return ((ListOperationsRequest) this.a).getPageTokenBytes();
        }

        public Builder setFilter(String str) {
            a();
            ((ListOperationsRequest) this.a).setFilter(str);
            return this;
        }

        public Builder setFilterBytes(ByteString byteString) {
            a();
            ((ListOperationsRequest) this.a).setFilterBytes(byteString);
            return this;
        }

        public Builder setName(String str) {
            a();
            ((ListOperationsRequest) this.a).setName(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            a();
            ((ListOperationsRequest) this.a).setNameBytes(byteString);
            return this;
        }

        public Builder setPageSize(int i) {
            a();
            ((ListOperationsRequest) this.a).setPageSize(i);
            return this;
        }

        public Builder setPageToken(String str) {
            a();
            ((ListOperationsRequest) this.a).setPageToken(str);
            return this;
        }

        public Builder setPageTokenBytes(ByteString byteString) {
            a();
            ((ListOperationsRequest) this.a).setPageTokenBytes(byteString);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private ListOperationsRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFilter() {
        this.filter_ = getDefaultInstance().getFilter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPageSize() {
        this.pageSize_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPageToken() {
        this.pageToken_ = getDefaultInstance().getPageToken();
    }

    public static ListOperationsRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ListOperationsRequest listOperationsRequest) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) listOperationsRequest);
    }

    public static ListOperationsRequest parseDelimitedFrom(InputStream inputStream) {
        return (ListOperationsRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static ListOperationsRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ListOperationsRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ListOperationsRequest parseFrom(ByteString byteString) {
        return (ListOperationsRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static ListOperationsRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ListOperationsRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ListOperationsRequest parseFrom(CodedInputStream codedInputStream) {
        return (ListOperationsRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ListOperationsRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ListOperationsRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static ListOperationsRequest parseFrom(InputStream inputStream) {
        return (ListOperationsRequest) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static ListOperationsRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ListOperationsRequest) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ListOperationsRequest parseFrom(byte[] bArr) {
        return (ListOperationsRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static ListOperationsRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (ListOperationsRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<ListOperationsRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFilter(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.filter_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFilterBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.filter_ = byteString.toStringUtf8();
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

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new ListOperationsRequest();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                ListOperationsRequest listOperationsRequest = (ListOperationsRequest) obj2;
                this.name_ = visitor.visitString(!this.name_.isEmpty(), this.name_, !listOperationsRequest.name_.isEmpty(), listOperationsRequest.name_);
                this.filter_ = visitor.visitString(!this.filter_.isEmpty(), this.filter_, !listOperationsRequest.filter_.isEmpty(), listOperationsRequest.filter_);
                this.pageSize_ = visitor.visitInt(this.pageSize_ != 0, this.pageSize_, listOperationsRequest.pageSize_ != 0, listOperationsRequest.pageSize_);
                this.pageToken_ = visitor.visitString(!this.pageToken_.isEmpty(), this.pageToken_, !listOperationsRequest.pageToken_.isEmpty(), listOperationsRequest.pageToken_);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                while (!r1) {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.filter_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 16) {
                                    this.pageSize_ = codedInputStream.readInt32();
                                } else if (readTag == 26) {
                                    this.pageToken_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 34) {
                                    this.name_ = codedInputStream.readStringRequireUtf8();
                                } else if (!codedInputStream.skipField(readTag)) {
                                }
                            }
                            r1 = true;
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
                    synchronized (ListOperationsRequest.class) {
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

    @Override // com.google.longrunning.ListOperationsRequestOrBuilder
    public String getFilter() {
        return this.filter_;
    }

    @Override // com.google.longrunning.ListOperationsRequestOrBuilder
    public ByteString getFilterBytes() {
        return ByteString.copyFromUtf8(this.filter_);
    }

    @Override // com.google.longrunning.ListOperationsRequestOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // com.google.longrunning.ListOperationsRequestOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    @Override // com.google.longrunning.ListOperationsRequestOrBuilder
    public int getPageSize() {
        return this.pageSize_;
    }

    @Override // com.google.longrunning.ListOperationsRequestOrBuilder
    public String getPageToken() {
        return this.pageToken_;
    }

    @Override // com.google.longrunning.ListOperationsRequestOrBuilder
    public ByteString getPageTokenBytes() {
        return ByteString.copyFromUtf8(this.pageToken_);
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeStringSize = this.filter_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getFilter());
        int i2 = this.pageSize_;
        if (i2 != 0) {
            computeStringSize += CodedOutputStream.computeInt32Size(2, i2);
        }
        if (!this.pageToken_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(3, getPageToken());
        }
        if (!this.name_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(4, getName());
        }
        this.c = computeStringSize;
        return computeStringSize;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!this.filter_.isEmpty()) {
            codedOutputStream.writeString(1, getFilter());
        }
        int i = this.pageSize_;
        if (i != 0) {
            codedOutputStream.writeInt32(2, i);
        }
        if (!this.pageToken_.isEmpty()) {
            codedOutputStream.writeString(3, getPageToken());
        }
        if (this.name_.isEmpty()) {
            return;
        }
        codedOutputStream.writeString(4, getName());
    }
}
