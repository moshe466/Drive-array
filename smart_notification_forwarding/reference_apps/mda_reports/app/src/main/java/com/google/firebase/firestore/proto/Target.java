package com.google.firebase.firestore.proto;

import com.google.firestore.v1.Target;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class Target extends GeneratedMessageLite<Target, Builder> implements TargetOrBuilder {
    private static final Target DEFAULT_INSTANCE = new Target();
    public static final int DOCUMENTS_FIELD_NUMBER = 6;
    public static final int LAST_LIMBO_FREE_SNAPSHOT_VERSION_FIELD_NUMBER = 7;
    public static final int LAST_LISTEN_SEQUENCE_NUMBER_FIELD_NUMBER = 4;
    private static volatile Parser<Target> PARSER = null;
    public static final int QUERY_FIELD_NUMBER = 5;
    public static final int RESUME_TOKEN_FIELD_NUMBER = 3;
    public static final int SNAPSHOT_VERSION_FIELD_NUMBER = 2;
    public static final int TARGET_ID_FIELD_NUMBER = 1;
    private Timestamp lastLimboFreeSnapshotVersion_;
    private long lastListenSequenceNumber_;
    private Timestamp snapshotVersion_;
    private int targetId_;
    private Object targetType_;
    private int targetTypeCase_ = 0;
    private ByteString resumeToken_ = ByteString.EMPTY;

    /* renamed from: com.google.firebase.firestore.proto.Target$1, reason: invalid class name */
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
            a = new int[TargetTypeCase.values().length];
            try {
                a[TargetTypeCase.QUERY.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[TargetTypeCase.DOCUMENTS.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[TargetTypeCase.TARGETTYPE_NOT_SET.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Target, Builder> implements TargetOrBuilder {
        private Builder() {
            super(Target.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearDocuments() {
            a();
            ((Target) this.a).clearDocuments();
            return this;
        }

        public Builder clearLastLimboFreeSnapshotVersion() {
            a();
            ((Target) this.a).clearLastLimboFreeSnapshotVersion();
            return this;
        }

        public Builder clearLastListenSequenceNumber() {
            a();
            ((Target) this.a).clearLastListenSequenceNumber();
            return this;
        }

        public Builder clearQuery() {
            a();
            ((Target) this.a).clearQuery();
            return this;
        }

        public Builder clearResumeToken() {
            a();
            ((Target) this.a).clearResumeToken();
            return this;
        }

        public Builder clearSnapshotVersion() {
            a();
            ((Target) this.a).clearSnapshotVersion();
            return this;
        }

        public Builder clearTargetId() {
            a();
            ((Target) this.a).clearTargetId();
            return this;
        }

        public Builder clearTargetType() {
            a();
            ((Target) this.a).clearTargetType();
            return this;
        }

        @Override // com.google.firebase.firestore.proto.TargetOrBuilder
        public Target.DocumentsTarget getDocuments() {
            return ((Target) this.a).getDocuments();
        }

        @Override // com.google.firebase.firestore.proto.TargetOrBuilder
        public Timestamp getLastLimboFreeSnapshotVersion() {
            return ((Target) this.a).getLastLimboFreeSnapshotVersion();
        }

        @Override // com.google.firebase.firestore.proto.TargetOrBuilder
        public long getLastListenSequenceNumber() {
            return ((Target) this.a).getLastListenSequenceNumber();
        }

        @Override // com.google.firebase.firestore.proto.TargetOrBuilder
        public Target.QueryTarget getQuery() {
            return ((Target) this.a).getQuery();
        }

        @Override // com.google.firebase.firestore.proto.TargetOrBuilder
        public ByteString getResumeToken() {
            return ((Target) this.a).getResumeToken();
        }

        @Override // com.google.firebase.firestore.proto.TargetOrBuilder
        public Timestamp getSnapshotVersion() {
            return ((Target) this.a).getSnapshotVersion();
        }

        @Override // com.google.firebase.firestore.proto.TargetOrBuilder
        public int getTargetId() {
            return ((Target) this.a).getTargetId();
        }

        @Override // com.google.firebase.firestore.proto.TargetOrBuilder
        public TargetTypeCase getTargetTypeCase() {
            return ((Target) this.a).getTargetTypeCase();
        }

        @Override // com.google.firebase.firestore.proto.TargetOrBuilder
        public boolean hasLastLimboFreeSnapshotVersion() {
            return ((Target) this.a).hasLastLimboFreeSnapshotVersion();
        }

        @Override // com.google.firebase.firestore.proto.TargetOrBuilder
        public boolean hasSnapshotVersion() {
            return ((Target) this.a).hasSnapshotVersion();
        }

        public Builder mergeDocuments(Target.DocumentsTarget documentsTarget) {
            a();
            ((Target) this.a).mergeDocuments(documentsTarget);
            return this;
        }

        public Builder mergeLastLimboFreeSnapshotVersion(Timestamp timestamp) {
            a();
            ((Target) this.a).mergeLastLimboFreeSnapshotVersion(timestamp);
            return this;
        }

        public Builder mergeQuery(Target.QueryTarget queryTarget) {
            a();
            ((Target) this.a).mergeQuery(queryTarget);
            return this;
        }

        public Builder mergeSnapshotVersion(Timestamp timestamp) {
            a();
            ((Target) this.a).mergeSnapshotVersion(timestamp);
            return this;
        }

        public Builder setDocuments(Target.DocumentsTarget.Builder builder) {
            a();
            ((Target) this.a).setDocuments(builder);
            return this;
        }

        public Builder setDocuments(Target.DocumentsTarget documentsTarget) {
            a();
            ((Target) this.a).setDocuments(documentsTarget);
            return this;
        }

        public Builder setLastLimboFreeSnapshotVersion(Timestamp.Builder builder) {
            a();
            ((Target) this.a).setLastLimboFreeSnapshotVersion(builder);
            return this;
        }

        public Builder setLastLimboFreeSnapshotVersion(Timestamp timestamp) {
            a();
            ((Target) this.a).setLastLimboFreeSnapshotVersion(timestamp);
            return this;
        }

        public Builder setLastListenSequenceNumber(long j) {
            a();
            ((Target) this.a).setLastListenSequenceNumber(j);
            return this;
        }

        public Builder setQuery(Target.QueryTarget.Builder builder) {
            a();
            ((Target) this.a).setQuery(builder);
            return this;
        }

        public Builder setQuery(Target.QueryTarget queryTarget) {
            a();
            ((Target) this.a).setQuery(queryTarget);
            return this;
        }

        public Builder setResumeToken(ByteString byteString) {
            a();
            ((Target) this.a).setResumeToken(byteString);
            return this;
        }

        public Builder setSnapshotVersion(Timestamp.Builder builder) {
            a();
            ((Target) this.a).setSnapshotVersion(builder);
            return this;
        }

        public Builder setSnapshotVersion(Timestamp timestamp) {
            a();
            ((Target) this.a).setSnapshotVersion(timestamp);
            return this;
        }

        public Builder setTargetId(int i) {
            a();
            ((Target) this.a).setTargetId(i);
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public enum TargetTypeCase implements Internal.EnumLite {
        QUERY(5),
        DOCUMENTS(6),
        TARGETTYPE_NOT_SET(0);

        private final int value;

        TargetTypeCase(int i) {
            this.value = i;
        }

        public static TargetTypeCase forNumber(int i) {
            if (i == 0) {
                return TARGETTYPE_NOT_SET;
            }
            if (i == 5) {
                return QUERY;
            }
            if (i != 6) {
                return null;
            }
            return DOCUMENTS;
        }

        @Deprecated
        public static TargetTypeCase valueOf(int i) {
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

    private Target() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDocuments() {
        if (this.targetTypeCase_ == 6) {
            this.targetTypeCase_ = 0;
            this.targetType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLastLimboFreeSnapshotVersion() {
        this.lastLimboFreeSnapshotVersion_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLastListenSequenceNumber() {
        this.lastListenSequenceNumber_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearQuery() {
        if (this.targetTypeCase_ == 5) {
            this.targetTypeCase_ = 0;
            this.targetType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResumeToken() {
        this.resumeToken_ = getDefaultInstance().getResumeToken();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSnapshotVersion() {
        this.snapshotVersion_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTargetId() {
        this.targetId_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTargetType() {
        this.targetTypeCase_ = 0;
        this.targetType_ = null;
    }

    public static Target getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeDocuments(Target.DocumentsTarget documentsTarget) {
        if (this.targetTypeCase_ == 6 && this.targetType_ != Target.DocumentsTarget.getDefaultInstance()) {
            documentsTarget = Target.DocumentsTarget.newBuilder((Target.DocumentsTarget) this.targetType_).mergeFrom((Target.DocumentsTarget.Builder) documentsTarget).buildPartial();
        }
        this.targetType_ = documentsTarget;
        this.targetTypeCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeLastLimboFreeSnapshotVersion(Timestamp timestamp) {
        Timestamp timestamp2 = this.lastLimboFreeSnapshotVersion_;
        if (timestamp2 != null && timestamp2 != Timestamp.getDefaultInstance()) {
            timestamp = Timestamp.newBuilder(this.lastLimboFreeSnapshotVersion_).mergeFrom((Timestamp.Builder) timestamp).buildPartial();
        }
        this.lastLimboFreeSnapshotVersion_ = timestamp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeQuery(Target.QueryTarget queryTarget) {
        if (this.targetTypeCase_ == 5 && this.targetType_ != Target.QueryTarget.getDefaultInstance()) {
            queryTarget = Target.QueryTarget.newBuilder((Target.QueryTarget) this.targetType_).mergeFrom((Target.QueryTarget.Builder) queryTarget).buildPartial();
        }
        this.targetType_ = queryTarget;
        this.targetTypeCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSnapshotVersion(Timestamp timestamp) {
        Timestamp timestamp2 = this.snapshotVersion_;
        if (timestamp2 != null && timestamp2 != Timestamp.getDefaultInstance()) {
            timestamp = Timestamp.newBuilder(this.snapshotVersion_).mergeFrom((Timestamp.Builder) timestamp).buildPartial();
        }
        this.snapshotVersion_ = timestamp;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Target target) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) target);
    }

    public static Target parseDelimitedFrom(InputStream inputStream) {
        return (Target) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static Target parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Target) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Target parseFrom(ByteString byteString) {
        return (Target) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static Target parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Target) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Target parseFrom(CodedInputStream codedInputStream) {
        return (Target) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Target parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Target) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Target parseFrom(InputStream inputStream) {
        return (Target) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static Target parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Target) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Target parseFrom(byte[] bArr) {
        return (Target) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static Target parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Target) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<Target> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDocuments(Target.DocumentsTarget.Builder builder) {
        this.targetType_ = builder.build();
        this.targetTypeCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDocuments(Target.DocumentsTarget documentsTarget) {
        if (documentsTarget == null) {
            throw new NullPointerException();
        }
        this.targetType_ = documentsTarget;
        this.targetTypeCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLastLimboFreeSnapshotVersion(Timestamp.Builder builder) {
        this.lastLimboFreeSnapshotVersion_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLastLimboFreeSnapshotVersion(Timestamp timestamp) {
        if (timestamp == null) {
            throw new NullPointerException();
        }
        this.lastLimboFreeSnapshotVersion_ = timestamp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLastListenSequenceNumber(long j) {
        this.lastListenSequenceNumber_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setQuery(Target.QueryTarget.Builder builder) {
        this.targetType_ = builder.build();
        this.targetTypeCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setQuery(Target.QueryTarget queryTarget) {
        if (queryTarget == null) {
            throw new NullPointerException();
        }
        this.targetType_ = queryTarget;
        this.targetTypeCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResumeToken(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.resumeToken_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSnapshotVersion(Timestamp.Builder builder) {
        this.snapshotVersion_ = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSnapshotVersion(Timestamp timestamp) {
        if (timestamp == null) {
            throw new NullPointerException();
        }
        this.snapshotVersion_ = timestamp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTargetId(int i) {
        this.targetId_ = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:155:0x01ed, code lost:
    
        if (r16.targetTypeCase_ == 6) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x01f5, code lost:
    
        r16.targetType_ = r0.visitOneofMessage(r5, r16.targetType_, r4.targetType_);
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x01f4, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x01f2, code lost:
    
        if (r16.targetTypeCase_ == 5) goto L127;
     */
    @Override // com.google.protobuf.GeneratedMessageLite
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final java.lang.Object a(com.google.protobuf.GeneratedMessageLite.MethodToInvoke r17, java.lang.Object r18, java.lang.Object r19) {
        /*
            Method dump skipped, instructions count: 558
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.firestore.proto.Target.a(com.google.protobuf.GeneratedMessageLite$MethodToInvoke, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    @Override // com.google.firebase.firestore.proto.TargetOrBuilder
    public Target.DocumentsTarget getDocuments() {
        return this.targetTypeCase_ == 6 ? (Target.DocumentsTarget) this.targetType_ : Target.DocumentsTarget.getDefaultInstance();
    }

    @Override // com.google.firebase.firestore.proto.TargetOrBuilder
    public Timestamp getLastLimboFreeSnapshotVersion() {
        Timestamp timestamp = this.lastLimboFreeSnapshotVersion_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // com.google.firebase.firestore.proto.TargetOrBuilder
    public long getLastListenSequenceNumber() {
        return this.lastListenSequenceNumber_;
    }

    @Override // com.google.firebase.firestore.proto.TargetOrBuilder
    public Target.QueryTarget getQuery() {
        return this.targetTypeCase_ == 5 ? (Target.QueryTarget) this.targetType_ : Target.QueryTarget.getDefaultInstance();
    }

    @Override // com.google.firebase.firestore.proto.TargetOrBuilder
    public ByteString getResumeToken() {
        return this.resumeToken_;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int i2 = this.targetId_;
        int computeInt32Size = i2 != 0 ? 0 + CodedOutputStream.computeInt32Size(1, i2) : 0;
        if (this.snapshotVersion_ != null) {
            computeInt32Size += CodedOutputStream.computeMessageSize(2, getSnapshotVersion());
        }
        if (!this.resumeToken_.isEmpty()) {
            computeInt32Size += CodedOutputStream.computeBytesSize(3, this.resumeToken_);
        }
        long j = this.lastListenSequenceNumber_;
        if (j != 0) {
            computeInt32Size += CodedOutputStream.computeInt64Size(4, j);
        }
        if (this.targetTypeCase_ == 5) {
            computeInt32Size += CodedOutputStream.computeMessageSize(5, (Target.QueryTarget) this.targetType_);
        }
        if (this.targetTypeCase_ == 6) {
            computeInt32Size += CodedOutputStream.computeMessageSize(6, (Target.DocumentsTarget) this.targetType_);
        }
        if (this.lastLimboFreeSnapshotVersion_ != null) {
            computeInt32Size += CodedOutputStream.computeMessageSize(7, getLastLimboFreeSnapshotVersion());
        }
        this.c = computeInt32Size;
        return computeInt32Size;
    }

    @Override // com.google.firebase.firestore.proto.TargetOrBuilder
    public Timestamp getSnapshotVersion() {
        Timestamp timestamp = this.snapshotVersion_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // com.google.firebase.firestore.proto.TargetOrBuilder
    public int getTargetId() {
        return this.targetId_;
    }

    @Override // com.google.firebase.firestore.proto.TargetOrBuilder
    public TargetTypeCase getTargetTypeCase() {
        return TargetTypeCase.forNumber(this.targetTypeCase_);
    }

    @Override // com.google.firebase.firestore.proto.TargetOrBuilder
    public boolean hasLastLimboFreeSnapshotVersion() {
        return this.lastLimboFreeSnapshotVersion_ != null;
    }

    @Override // com.google.firebase.firestore.proto.TargetOrBuilder
    public boolean hasSnapshotVersion() {
        return this.snapshotVersion_ != null;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        int i = this.targetId_;
        if (i != 0) {
            codedOutputStream.writeInt32(1, i);
        }
        if (this.snapshotVersion_ != null) {
            codedOutputStream.writeMessage(2, getSnapshotVersion());
        }
        if (!this.resumeToken_.isEmpty()) {
            codedOutputStream.writeBytes(3, this.resumeToken_);
        }
        long j = this.lastListenSequenceNumber_;
        if (j != 0) {
            codedOutputStream.writeInt64(4, j);
        }
        if (this.targetTypeCase_ == 5) {
            codedOutputStream.writeMessage(5, (Target.QueryTarget) this.targetType_);
        }
        if (this.targetTypeCase_ == 6) {
            codedOutputStream.writeMessage(6, (Target.DocumentsTarget) this.targetType_);
        }
        if (this.lastLimboFreeSnapshotVersion_ != null) {
            codedOutputStream.writeMessage(7, getLastLimboFreeSnapshotVersion());
        }
    }
}
