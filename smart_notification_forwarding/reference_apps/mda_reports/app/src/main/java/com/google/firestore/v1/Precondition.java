package com.google.firestore.v1;

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

/* loaded from: classes2.dex */
public final class Precondition extends GeneratedMessageLite<Precondition, Builder> implements PreconditionOrBuilder {
    private static final Precondition DEFAULT_INSTANCE = new Precondition();
    public static final int EXISTS_FIELD_NUMBER = 1;
    private static volatile Parser<Precondition> PARSER = null;
    public static final int UPDATE_TIME_FIELD_NUMBER = 2;
    private int conditionTypeCase_ = 0;
    private Object conditionType_;

    /* renamed from: com.google.firestore.v1.Precondition$1, reason: invalid class name */
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
            a = new int[ConditionTypeCase.values().length];
            try {
                a[ConditionTypeCase.EXISTS.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[ConditionTypeCase.UPDATE_TIME.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[ConditionTypeCase.CONDITIONTYPE_NOT_SET.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Precondition, Builder> implements PreconditionOrBuilder {
        private Builder() {
            super(Precondition.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearConditionType() {
            a();
            ((Precondition) this.a).clearConditionType();
            return this;
        }

        public Builder clearExists() {
            a();
            ((Precondition) this.a).clearExists();
            return this;
        }

        public Builder clearUpdateTime() {
            a();
            ((Precondition) this.a).clearUpdateTime();
            return this;
        }

        @Override // com.google.firestore.v1.PreconditionOrBuilder
        public ConditionTypeCase getConditionTypeCase() {
            return ((Precondition) this.a).getConditionTypeCase();
        }

        @Override // com.google.firestore.v1.PreconditionOrBuilder
        public boolean getExists() {
            return ((Precondition) this.a).getExists();
        }

        @Override // com.google.firestore.v1.PreconditionOrBuilder
        public Timestamp getUpdateTime() {
            return ((Precondition) this.a).getUpdateTime();
        }

        public Builder mergeUpdateTime(Timestamp timestamp) {
            a();
            ((Precondition) this.a).mergeUpdateTime(timestamp);
            return this;
        }

        public Builder setExists(boolean z) {
            a();
            ((Precondition) this.a).setExists(z);
            return this;
        }

        public Builder setUpdateTime(Timestamp.Builder builder) {
            a();
            ((Precondition) this.a).setUpdateTime(builder);
            return this;
        }

        public Builder setUpdateTime(Timestamp timestamp) {
            a();
            ((Precondition) this.a).setUpdateTime(timestamp);
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public enum ConditionTypeCase implements Internal.EnumLite {
        EXISTS(1),
        UPDATE_TIME(2),
        CONDITIONTYPE_NOT_SET(0);

        private final int value;

        ConditionTypeCase(int i) {
            this.value = i;
        }

        public static ConditionTypeCase forNumber(int i) {
            if (i == 0) {
                return CONDITIONTYPE_NOT_SET;
            }
            if (i == 1) {
                return EXISTS;
            }
            if (i != 2) {
                return null;
            }
            return UPDATE_TIME;
        }

        @Deprecated
        public static ConditionTypeCase valueOf(int i) {
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

    private Precondition() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearConditionType() {
        this.conditionTypeCase_ = 0;
        this.conditionType_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearExists() {
        if (this.conditionTypeCase_ == 1) {
            this.conditionTypeCase_ = 0;
            this.conditionType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUpdateTime() {
        if (this.conditionTypeCase_ == 2) {
            this.conditionTypeCase_ = 0;
            this.conditionType_ = null;
        }
    }

    public static Precondition getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeUpdateTime(Timestamp timestamp) {
        if (this.conditionTypeCase_ == 2 && this.conditionType_ != Timestamp.getDefaultInstance()) {
            timestamp = Timestamp.newBuilder((Timestamp) this.conditionType_).mergeFrom((Timestamp.Builder) timestamp).buildPartial();
        }
        this.conditionType_ = timestamp;
        this.conditionTypeCase_ = 2;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Precondition precondition) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) precondition);
    }

    public static Precondition parseDelimitedFrom(InputStream inputStream) {
        return (Precondition) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static Precondition parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Precondition) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Precondition parseFrom(ByteString byteString) {
        return (Precondition) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static Precondition parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Precondition) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Precondition parseFrom(CodedInputStream codedInputStream) {
        return (Precondition) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Precondition parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Precondition) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Precondition parseFrom(InputStream inputStream) {
        return (Precondition) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static Precondition parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Precondition) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Precondition parseFrom(byte[] bArr) {
        return (Precondition) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static Precondition parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Precondition) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<Precondition> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExists(boolean z) {
        this.conditionTypeCase_ = 1;
        this.conditionType_ = Boolean.valueOf(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUpdateTime(Timestamp.Builder builder) {
        this.conditionType_ = builder.build();
        this.conditionTypeCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUpdateTime(Timestamp timestamp) {
        if (timestamp == null) {
            throw new NullPointerException();
        }
        this.conditionType_ = timestamp;
        this.conditionTypeCase_ = 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Object visitOneofBoolean;
        int i;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.b[methodToInvoke.ordinal()]) {
            case 1:
                return new Precondition();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Precondition precondition = (Precondition) obj2;
                int i2 = AnonymousClass1.a[precondition.getConditionTypeCase().ordinal()];
                if (i2 == 1) {
                    visitOneofBoolean = visitor.visitOneofBoolean(this.conditionTypeCase_ == 1, this.conditionType_, precondition.conditionType_);
                } else {
                    if (i2 != 2) {
                        if (i2 == 3) {
                            visitor.visitOneofNotSet(this.conditionTypeCase_ != 0);
                        }
                        if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE && (i = precondition.conditionTypeCase_) != 0) {
                            this.conditionTypeCase_ = i;
                        }
                        return this;
                    }
                    visitOneofBoolean = visitor.visitOneofMessage(this.conditionTypeCase_ == 2, this.conditionType_, precondition.conditionType_);
                }
                this.conditionType_ = visitOneofBoolean;
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.conditionTypeCase_ = i;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                while (!r1) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.conditionTypeCase_ = 1;
                                this.conditionType_ = Boolean.valueOf(codedInputStream.readBool());
                            } else if (readTag == 18) {
                                Timestamp.Builder builder = this.conditionTypeCase_ == 2 ? ((Timestamp) this.conditionType_).toBuilder() : null;
                                this.conditionType_ = codedInputStream.readMessage(Timestamp.parser(), extensionRegistryLite);
                                if (builder != null) {
                                    builder.mergeFrom((Timestamp.Builder) this.conditionType_);
                                    this.conditionType_ = builder.buildPartial();
                                }
                                this.conditionTypeCase_ = 2;
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
                    synchronized (Precondition.class) {
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

    @Override // com.google.firestore.v1.PreconditionOrBuilder
    public ConditionTypeCase getConditionTypeCase() {
        return ConditionTypeCase.forNumber(this.conditionTypeCase_);
    }

    @Override // com.google.firestore.v1.PreconditionOrBuilder
    public boolean getExists() {
        if (this.conditionTypeCase_ == 1) {
            return ((Boolean) this.conditionType_).booleanValue();
        }
        return false;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeBoolSize = this.conditionTypeCase_ == 1 ? 0 + CodedOutputStream.computeBoolSize(1, ((Boolean) this.conditionType_).booleanValue()) : 0;
        if (this.conditionTypeCase_ == 2) {
            computeBoolSize += CodedOutputStream.computeMessageSize(2, (Timestamp) this.conditionType_);
        }
        this.c = computeBoolSize;
        return computeBoolSize;
    }

    @Override // com.google.firestore.v1.PreconditionOrBuilder
    public Timestamp getUpdateTime() {
        return this.conditionTypeCase_ == 2 ? (Timestamp) this.conditionType_ : Timestamp.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (this.conditionTypeCase_ == 1) {
            codedOutputStream.writeBool(1, ((Boolean) this.conditionType_).booleanValue());
        }
        if (this.conditionTypeCase_ == 2) {
            codedOutputStream.writeMessage(2, (Timestamp) this.conditionType_);
        }
    }
}
