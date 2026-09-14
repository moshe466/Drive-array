package com.google.longrunning;

import com.google.longrunning.Operation;
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
public final class ListOperationsResponse extends GeneratedMessageLite<ListOperationsResponse, Builder> implements ListOperationsResponseOrBuilder {
    private static final ListOperationsResponse DEFAULT_INSTANCE = new ListOperationsResponse();
    public static final int NEXT_PAGE_TOKEN_FIELD_NUMBER = 2;
    public static final int OPERATIONS_FIELD_NUMBER = 1;
    private static volatile Parser<ListOperationsResponse> PARSER;
    private int bitField0_;
    private Internal.ProtobufList<Operation> operations_ = GeneratedMessageLite.f();
    private String nextPageToken_ = "";

    /* renamed from: com.google.longrunning.ListOperationsResponse$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<ListOperationsResponse, Builder> implements ListOperationsResponseOrBuilder {
        private Builder() {
            super(ListOperationsResponse.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllOperations(Iterable<? extends Operation> iterable) {
            a();
            ((ListOperationsResponse) this.a).addAllOperations(iterable);
            return this;
        }

        public Builder addOperations(int i, Operation.Builder builder) {
            a();
            ((ListOperationsResponse) this.a).addOperations(i, builder);
            return this;
        }

        public Builder addOperations(int i, Operation operation) {
            a();
            ((ListOperationsResponse) this.a).addOperations(i, operation);
            return this;
        }

        public Builder addOperations(Operation.Builder builder) {
            a();
            ((ListOperationsResponse) this.a).addOperations(builder);
            return this;
        }

        public Builder addOperations(Operation operation) {
            a();
            ((ListOperationsResponse) this.a).addOperations(operation);
            return this;
        }

        public Builder clearNextPageToken() {
            a();
            ((ListOperationsResponse) this.a).clearNextPageToken();
            return this;
        }

        public Builder clearOperations() {
            a();
            ((ListOperationsResponse) this.a).clearOperations();
            return this;
        }

        @Override // com.google.longrunning.ListOperationsResponseOrBuilder
        public String getNextPageToken() {
            return ((ListOperationsResponse) this.a).getNextPageToken();
        }

        @Override // com.google.longrunning.ListOperationsResponseOrBuilder
        public ByteString getNextPageTokenBytes() {
            return ((ListOperationsResponse) this.a).getNextPageTokenBytes();
        }

        @Override // com.google.longrunning.ListOperationsResponseOrBuilder
        public Operation getOperations(int i) {
            return ((ListOperationsResponse) this.a).getOperations(i);
        }

        @Override // com.google.longrunning.ListOperationsResponseOrBuilder
        public int getOperationsCount() {
            return ((ListOperationsResponse) this.a).getOperationsCount();
        }

        @Override // com.google.longrunning.ListOperationsResponseOrBuilder
        public List<Operation> getOperationsList() {
            return Collections.unmodifiableList(((ListOperationsResponse) this.a).getOperationsList());
        }

        public Builder removeOperations(int i) {
            a();
            ((ListOperationsResponse) this.a).removeOperations(i);
            return this;
        }

        public Builder setNextPageToken(String str) {
            a();
            ((ListOperationsResponse) this.a).setNextPageToken(str);
            return this;
        }

        public Builder setNextPageTokenBytes(ByteString byteString) {
            a();
            ((ListOperationsResponse) this.a).setNextPageTokenBytes(byteString);
            return this;
        }

        public Builder setOperations(int i, Operation.Builder builder) {
            a();
            ((ListOperationsResponse) this.a).setOperations(i, builder);
            return this;
        }

        public Builder setOperations(int i, Operation operation) {
            a();
            ((ListOperationsResponse) this.a).setOperations(i, operation);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private ListOperationsResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllOperations(Iterable<? extends Operation> iterable) {
        ensureOperationsIsMutable();
        AbstractMessageLite.a(iterable, this.operations_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOperations(int i, Operation.Builder builder) {
        ensureOperationsIsMutable();
        this.operations_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOperations(int i, Operation operation) {
        if (operation == null) {
            throw new NullPointerException();
        }
        ensureOperationsIsMutable();
        this.operations_.add(i, operation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOperations(Operation.Builder builder) {
        ensureOperationsIsMutable();
        this.operations_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOperations(Operation operation) {
        if (operation == null) {
            throw new NullPointerException();
        }
        ensureOperationsIsMutable();
        this.operations_.add(operation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNextPageToken() {
        this.nextPageToken_ = getDefaultInstance().getNextPageToken();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOperations() {
        this.operations_ = GeneratedMessageLite.f();
    }

    private void ensureOperationsIsMutable() {
        if (this.operations_.isModifiable()) {
            return;
        }
        this.operations_ = GeneratedMessageLite.a(this.operations_);
    }

    public static ListOperationsResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ListOperationsResponse listOperationsResponse) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) listOperationsResponse);
    }

    public static ListOperationsResponse parseDelimitedFrom(InputStream inputStream) {
        return (ListOperationsResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static ListOperationsResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ListOperationsResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ListOperationsResponse parseFrom(ByteString byteString) {
        return (ListOperationsResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static ListOperationsResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ListOperationsResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ListOperationsResponse parseFrom(CodedInputStream codedInputStream) {
        return (ListOperationsResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ListOperationsResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ListOperationsResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static ListOperationsResponse parseFrom(InputStream inputStream) {
        return (ListOperationsResponse) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static ListOperationsResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ListOperationsResponse) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ListOperationsResponse parseFrom(byte[] bArr) {
        return (ListOperationsResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static ListOperationsResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (ListOperationsResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<ListOperationsResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeOperations(int i) {
        ensureOperationsIsMutable();
        this.operations_.remove(i);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void setOperations(int i, Operation.Builder builder) {
        ensureOperationsIsMutable();
        this.operations_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOperations(int i, Operation operation) {
        if (operation == null) {
            throw new NullPointerException();
        }
        ensureOperationsIsMutable();
        this.operations_.set(i, operation);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new ListOperationsResponse();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.operations_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                ListOperationsResponse listOperationsResponse = (ListOperationsResponse) obj2;
                this.operations_ = visitor.visitList(this.operations_, listOperationsResponse.operations_);
                this.nextPageToken_ = visitor.visitString(!this.nextPageToken_.isEmpty(), this.nextPageToken_, true ^ listOperationsResponse.nextPageToken_.isEmpty(), listOperationsResponse.nextPageToken_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= listOperationsResponse.bitField0_;
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
                                    if (!this.operations_.isModifiable()) {
                                        this.operations_ = GeneratedMessageLite.a(this.operations_);
                                    }
                                    this.operations_.add((Operation) codedInputStream.readMessage(Operation.parser(), extensionRegistryLite));
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
                    synchronized (ListOperationsResponse.class) {
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

    @Override // com.google.longrunning.ListOperationsResponseOrBuilder
    public String getNextPageToken() {
        return this.nextPageToken_;
    }

    @Override // com.google.longrunning.ListOperationsResponseOrBuilder
    public ByteString getNextPageTokenBytes() {
        return ByteString.copyFromUtf8(this.nextPageToken_);
    }

    @Override // com.google.longrunning.ListOperationsResponseOrBuilder
    public Operation getOperations(int i) {
        return this.operations_.get(i);
    }

    @Override // com.google.longrunning.ListOperationsResponseOrBuilder
    public int getOperationsCount() {
        return this.operations_.size();
    }

    @Override // com.google.longrunning.ListOperationsResponseOrBuilder
    public List<Operation> getOperationsList() {
        return this.operations_;
    }

    public OperationOrBuilder getOperationsOrBuilder(int i) {
        return this.operations_.get(i);
    }

    public List<? extends OperationOrBuilder> getOperationsOrBuilderList() {
        return this.operations_;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.operations_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(1, this.operations_.get(i3));
        }
        if (!this.nextPageToken_.isEmpty()) {
            i2 += CodedOutputStream.computeStringSize(2, getNextPageToken());
        }
        this.c = i2;
        return i2;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        for (int i = 0; i < this.operations_.size(); i++) {
            codedOutputStream.writeMessage(1, this.operations_.get(i));
        }
        if (this.nextPageToken_.isEmpty()) {
            return;
        }
        codedOutputStream.writeString(2, getNextPageToken());
    }
}
