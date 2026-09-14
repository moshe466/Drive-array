package com.google.longrunning;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import com.google.rpc.Status;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class Operation extends GeneratedMessageLite<Operation, Builder> implements OperationOrBuilder {
    private static final Operation DEFAULT_INSTANCE = new Operation();
    public static final int DONE_FIELD_NUMBER = 3;
    public static final int ERROR_FIELD_NUMBER = 4;
    public static final int METADATA_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<Operation> PARSER = null;
    public static final int RESPONSE_FIELD_NUMBER = 5;
    private boolean done_;
    private Any metadata_;
    private Object result_;
    private int resultCase_ = 0;
    private String name_ = "";

    /* renamed from: com.google.longrunning.Operation$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b = new int[GeneratedMessageLite.MethodToInvoke.values().length];

        static {
            try {
                b[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[GeneratedMessageLite.MethodToInvoke.IS_INITIALIZED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[GeneratedMessageLite.MethodToInvoke.MAKE_IMMUTABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[GeneratedMessageLite.MethodToInvoke.VISIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[GeneratedMessageLite.MethodToInvoke.MERGE_FROM_STREAM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            a = new int[ResultCase.values().length];
            try {
                a[ResultCase.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[ResultCase.RESPONSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[ResultCase.RESULT_NOT_SET.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Operation, Builder> implements OperationOrBuilder {
        private Builder() {
            super(Operation.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearDone() {
            a();
            ((Operation) this.a).clearDone();
            return this;
        }

        public Builder clearError() {
            a();
            ((Operation) this.a).clearError();
            return this;
        }

        public Builder clearMetadata() {
            a();
            ((Operation) this.a).clearMetadata();
            return this;
        }

        public Builder clearName() {
            a();
            ((Operation) this.a).clearName();
            return this;
        }

        public Builder clearResponse() {
            a();
            ((Operation) this.a).clearResponse();
            return this;
        }

        public Builder clearResult() {
            a();
            ((Operation) this.a).clearResult();
            return this;
        }

        @Override // com.google.longrunning.OperationOrBuilder
        public boolean getDone() {
            return ((Operation) this.a).getDone();
        }

        @Override // com.google.longrunning.OperationOrBuilder
        public Status getError() {
            return ((Operation) this.a).getError();
        }

        @Override // com.google.longrunning.OperationOrBuilder
        public Any getMetadata() {
            return ((Operation) this.a).getMetadata();
        }

        @Override // com.google.longrunning.OperationOrBuilder
        public String getName() {
            return ((Operation) this.a).getName();
        }

        @Override // com.google.longrunning.OperationOrBuilder
        public ByteString getNameBytes() {
            return ((Operation) this.a).getNameBytes();
        }

        @Override // com.google.longrunning.OperationOrBuilder
        public Any getResponse() {
            return ((Operation) this.a).getResponse();
        }

        @Override // com.google.longrunning.OperationOrBuilder
        public ResultCase getResultCase() {
            return ((Operation) this.a).getResultCase();
        }

        @Override // com.google.longrunning.OperationOrBuilder
        public boolean hasMetadata() {
            return ((Operation) this.a).hasMetadata();
        }

        public Builder mergeError(Status status) {
            a();
            ((Operation) this.a).mergeError(status);
            return this;
        }

        public Builder mergeMetadata(Any any) {
            a();
            ((Operation) this.a).mergeMetadata(any);
            return this;
        }

        public Builder mergeResponse(Any any) {
            a();
            ((Operation) this.a).mergeResponse(any);
            return this;
        }

        public Builder setDone(boolean z) {
            a();
            ((Operation) this.a).setDone(z);
            return this;
        }

        public Builder setError(Status.Builder builder) {
            a();
            ((Operation) this.a).setError(builder);
            return this;
        }

        public Builder setError(Status status) {
            a();
            ((Operation) this.a).setError(status);
            return this;
        }

        public Builder setMetadata(Any.Builder builder) {
            a();
            ((Operation) this.a).setMetadata(builder);
            return this;
        }

        public Builder setMetadata(Any any) {
            a();
            ((Operation) this.a).setMetadata(any);
            return this;
        }

        public Builder setName(String str) {
            a();
            ((Operation) this.a).setName(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            a();
            ((Operation) this.a).setNameBytes(byteString);
            return this;
        }

        public Builder setResponse(Any.Builder builder) {
            a();
            ((Operation) this.a).setResponse(builder);
            return this;
        }

        public Builder setResponse(Any any) {
            a();
            ((Operation) this.a).setResponse(any);
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public enum ResultCase implements Internal.EnumLite {
        ERROR(4),
        RESPONSE(5),
        RESULT_NOT_SET(0);

        private final int value;

        ResultCase(int i) {
            this.value = i;
        }

        public static ResultCase forNumber(int i) {
            if (i == 0) {
                return RESULT_NOT_SET;
            }
            if (i == 4) {
                return ERROR;
            }
            if (i != 5) {
                return null;
            }
            return RESPONSE;
        }

        @Deprecated
        public static ResultCase valueOf(int i) {
            return forNumber(i);
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public int getNumber() {
            return this.value;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private Operation() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDone() {
        this.done_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearError() {
        if (this.resultCase_ == 4) {
            this.resultCase_ = 0;
            this.result_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMetadata() {
        this.metadata_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResponse() {
        if (this.resultCase_ == 5) {
            this.resultCase_ = 0;
            this.result_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResult() {
        this.resultCase_ = 0;
        this.result_ = null;
    }

    public static Operation getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeError(Status status) {
        if (this.resultCase_ == 4 && this.result_ != Status.getDefaultInstance()) {
            status = Status.newBuilder((Status) this.result_).mergeFrom((Status.Builder) status).buildPartial();
        }
        this.result_ = status;
        this.resultCase_ = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeMetadata(Any any) {
        Any any2 = this.metadata_;
        if (any2 != null && any2 != Any.getDefaultInstance()) {
            any = Any.newBuilder(this.metadata_).mergeFrom((Any.Builder) any).buildPartial();
        }
        this.metadata_ = any;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeResponse(Any any) {
        if (this.resultCase_ == 5 && this.result_ != Any.getDefaultInstance()) {
            any = Any.newBuilder((Any) this.result_).mergeFrom((Any.Builder) any).buildPartial();
        }
        this.result_ = any;
        this.resultCase_ = 5;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Operation operation) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) operation);
    }

    public static Operation parseDelimitedFrom(InputStream inputStream) {
        return (Operation) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static Operation parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Operation) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Operation parseFrom(ByteString byteString) {
        return (Operation) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static Operation parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Operation) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Operation parseFrom(CodedInputStream codedInputStream) {
        return (Operation) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Operation parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Operation) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Operation parseFrom(InputStream inputStream) {
        return (Operation) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static Operation parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Operation) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Operation parseFrom(byte[] bArr) {
        return (Operation) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static Operation parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Operation) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<Operation> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDone(boolean z) {
        this.done_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setError(Status.Builder builder) {
        this.result_ = builder.build();
        this.resultCase_ = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setError(Status status) {
        if (status == null) {
            throw new NullPointerException();
        }
        this.result_ = status;
        this.resultCase_ = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetadata(Any.Builder builder) {
        this.metadata_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetadata(Any any) {
        if (any == null) {
            throw new NullPointerException();
        }
        this.metadata_ = any;
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
    public void setResponse(Any.Builder builder) {
        this.result_ = builder.build();
        this.resultCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResponse(Any any) {
        if (any == null) {
            throw new NullPointerException();
        }
        this.result_ = any;
        this.resultCase_ = 5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:117:0x0167, code lost:
    
        if (r7.resultCase_ == 5) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x016f, code lost:
    
        r7.result_ = r9.visitOneofMessage(r2, r7.result_, r10.result_);
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x016e, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x016c, code lost:
    
        if (r7.resultCase_ == 4) goto L91;
     */
    @Override // com.google.protobuf.GeneratedMessageLite
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final java.lang.Object a(com.google.protobuf.GeneratedMessageLite.MethodToInvoke r8, java.lang.Object r9, java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 424
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.longrunning.Operation.a(com.google.protobuf.GeneratedMessageLite$MethodToInvoke, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    @Override // com.google.longrunning.OperationOrBuilder
    public boolean getDone() {
        return this.done_;
    }

    @Override // com.google.longrunning.OperationOrBuilder
    public Status getError() {
        return this.resultCase_ == 4 ? (Status) this.result_ : Status.getDefaultInstance();
    }

    @Override // com.google.longrunning.OperationOrBuilder
    public Any getMetadata() {
        Any any = this.metadata_;
        return any == null ? Any.getDefaultInstance() : any;
    }

    @Override // com.google.longrunning.OperationOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // com.google.longrunning.OperationOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    @Override // com.google.longrunning.OperationOrBuilder
    public Any getResponse() {
        return this.resultCase_ == 5 ? (Any) this.result_ : Any.getDefaultInstance();
    }

    @Override // com.google.longrunning.OperationOrBuilder
    public ResultCase getResultCase() {
        return ResultCase.forNumber(this.resultCase_);
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeStringSize = this.name_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getName());
        if (this.metadata_ != null) {
            computeStringSize += CodedOutputStream.computeMessageSize(2, getMetadata());
        }
        boolean z = this.done_;
        if (z) {
            computeStringSize += CodedOutputStream.computeBoolSize(3, z);
        }
        if (this.resultCase_ == 4) {
            computeStringSize += CodedOutputStream.computeMessageSize(4, (Status) this.result_);
        }
        if (this.resultCase_ == 5) {
            computeStringSize += CodedOutputStream.computeMessageSize(5, (Any) this.result_);
        }
        this.c = computeStringSize;
        return computeStringSize;
    }

    @Override // com.google.longrunning.OperationOrBuilder
    public boolean hasMetadata() {
        return this.metadata_ != null;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!this.name_.isEmpty()) {
            codedOutputStream.writeString(1, getName());
        }
        if (this.metadata_ != null) {
            codedOutputStream.writeMessage(2, getMetadata());
        }
        boolean z = this.done_;
        if (z) {
            codedOutputStream.writeBool(3, z);
        }
        if (this.resultCase_ == 4) {
            codedOutputStream.writeMessage(4, (Status) this.result_);
        }
        if (this.resultCase_ == 5) {
            codedOutputStream.writeMessage(5, (Any) this.result_);
        }
    }
}
