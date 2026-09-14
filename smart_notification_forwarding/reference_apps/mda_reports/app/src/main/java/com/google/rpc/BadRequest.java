package com.google.rpc;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class BadRequest extends GeneratedMessageLite<BadRequest, Builder> implements BadRequestOrBuilder {
    private static final BadRequest DEFAULT_INSTANCE = new BadRequest();
    public static final int FIELD_VIOLATIONS_FIELD_NUMBER = 1;
    private static volatile Parser<BadRequest> PARSER;
    private Internal.ProtobufList<FieldViolation> fieldViolations_ = GeneratedMessageLite.f();

    /* renamed from: com.google.rpc.BadRequest$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<BadRequest, Builder> implements BadRequestOrBuilder {
        private Builder() {
            super(BadRequest.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllFieldViolations(Iterable<? extends FieldViolation> iterable) {
            a();
            ((BadRequest) this.a).addAllFieldViolations(iterable);
            return this;
        }

        public Builder addFieldViolations(int i, FieldViolation.Builder builder) {
            a();
            ((BadRequest) this.a).addFieldViolations(i, builder);
            return this;
        }

        public Builder addFieldViolations(int i, FieldViolation fieldViolation) {
            a();
            ((BadRequest) this.a).addFieldViolations(i, fieldViolation);
            return this;
        }

        public Builder addFieldViolations(FieldViolation.Builder builder) {
            a();
            ((BadRequest) this.a).addFieldViolations(builder);
            return this;
        }

        public Builder addFieldViolations(FieldViolation fieldViolation) {
            a();
            ((BadRequest) this.a).addFieldViolations(fieldViolation);
            return this;
        }

        public Builder clearFieldViolations() {
            a();
            ((BadRequest) this.a).clearFieldViolations();
            return this;
        }

        @Override // com.google.rpc.BadRequestOrBuilder
        public FieldViolation getFieldViolations(int i) {
            return ((BadRequest) this.a).getFieldViolations(i);
        }

        @Override // com.google.rpc.BadRequestOrBuilder
        public int getFieldViolationsCount() {
            return ((BadRequest) this.a).getFieldViolationsCount();
        }

        @Override // com.google.rpc.BadRequestOrBuilder
        public List<FieldViolation> getFieldViolationsList() {
            return Collections.unmodifiableList(((BadRequest) this.a).getFieldViolationsList());
        }

        public Builder removeFieldViolations(int i) {
            a();
            ((BadRequest) this.a).removeFieldViolations(i);
            return this;
        }

        public Builder setFieldViolations(int i, FieldViolation.Builder builder) {
            a();
            ((BadRequest) this.a).setFieldViolations(i, builder);
            return this;
        }

        public Builder setFieldViolations(int i, FieldViolation fieldViolation) {
            a();
            ((BadRequest) this.a).setFieldViolations(i, fieldViolation);
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static final class FieldViolation extends GeneratedMessageLite<FieldViolation, Builder> implements FieldViolationOrBuilder {
        private static final FieldViolation DEFAULT_INSTANCE = new FieldViolation();
        public static final int DESCRIPTION_FIELD_NUMBER = 2;
        public static final int FIELD_FIELD_NUMBER = 1;
        private static volatile Parser<FieldViolation> PARSER;
        private String field_ = "";
        private String description_ = "";

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<FieldViolation, Builder> implements FieldViolationOrBuilder {
            private Builder() {
                super(FieldViolation.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearDescription() {
                a();
                ((FieldViolation) this.a).clearDescription();
                return this;
            }

            public Builder clearField() {
                a();
                ((FieldViolation) this.a).clearField();
                return this;
            }

            @Override // com.google.rpc.BadRequest.FieldViolationOrBuilder
            public String getDescription() {
                return ((FieldViolation) this.a).getDescription();
            }

            @Override // com.google.rpc.BadRequest.FieldViolationOrBuilder
            public ByteString getDescriptionBytes() {
                return ((FieldViolation) this.a).getDescriptionBytes();
            }

            @Override // com.google.rpc.BadRequest.FieldViolationOrBuilder
            public String getField() {
                return ((FieldViolation) this.a).getField();
            }

            @Override // com.google.rpc.BadRequest.FieldViolationOrBuilder
            public ByteString getFieldBytes() {
                return ((FieldViolation) this.a).getFieldBytes();
            }

            public Builder setDescription(String str) {
                a();
                ((FieldViolation) this.a).setDescription(str);
                return this;
            }

            public Builder setDescriptionBytes(ByteString byteString) {
                a();
                ((FieldViolation) this.a).setDescriptionBytes(byteString);
                return this;
            }

            public Builder setField(String str) {
                a();
                ((FieldViolation) this.a).setField(str);
                return this;
            }

            public Builder setFieldBytes(ByteString byteString) {
                a();
                ((FieldViolation) this.a).setFieldBytes(byteString);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private FieldViolation() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDescription() {
            this.description_ = getDefaultInstance().getDescription();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearField() {
            this.field_ = getDefaultInstance().getField();
        }

        public static FieldViolation getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FieldViolation fieldViolation) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) fieldViolation);
        }

        public static FieldViolation parseDelimitedFrom(InputStream inputStream) {
            return (FieldViolation) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static FieldViolation parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (FieldViolation) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FieldViolation parseFrom(ByteString byteString) {
            return (FieldViolation) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static FieldViolation parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (FieldViolation) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static FieldViolation parseFrom(CodedInputStream codedInputStream) {
            return (FieldViolation) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static FieldViolation parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (FieldViolation) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static FieldViolation parseFrom(InputStream inputStream) {
            return (FieldViolation) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static FieldViolation parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (FieldViolation) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FieldViolation parseFrom(byte[] bArr) {
            return (FieldViolation) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static FieldViolation parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (FieldViolation) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<FieldViolation> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDescription(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.description_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDescriptionBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.a(byteString);
            this.description_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setField(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.field_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFieldBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.a(byteString);
            this.field_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new FieldViolation();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    FieldViolation fieldViolation = (FieldViolation) obj2;
                    this.field_ = visitor.visitString(!this.field_.isEmpty(), this.field_, !fieldViolation.field_.isEmpty(), fieldViolation.field_);
                    this.description_ = visitor.visitString(!this.description_.isEmpty(), this.description_, true ^ fieldViolation.description_.isEmpty(), fieldViolation.description_);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    boolean z = false;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.field_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 18) {
                                    this.description_ = codedInputStream.readStringRequireUtf8();
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
                        synchronized (FieldViolation.class) {
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

        @Override // com.google.rpc.BadRequest.FieldViolationOrBuilder
        public String getDescription() {
            return this.description_;
        }

        @Override // com.google.rpc.BadRequest.FieldViolationOrBuilder
        public ByteString getDescriptionBytes() {
            return ByteString.copyFromUtf8(this.description_);
        }

        @Override // com.google.rpc.BadRequest.FieldViolationOrBuilder
        public String getField() {
            return this.field_;
        }

        @Override // com.google.rpc.BadRequest.FieldViolationOrBuilder
        public ByteString getFieldBytes() {
            return ByteString.copyFromUtf8(this.field_);
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeStringSize = this.field_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getField());
            if (!this.description_.isEmpty()) {
                computeStringSize += CodedOutputStream.computeStringSize(2, getDescription());
            }
            this.c = computeStringSize;
            return computeStringSize;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if (!this.field_.isEmpty()) {
                codedOutputStream.writeString(1, getField());
            }
            if (this.description_.isEmpty()) {
                return;
            }
            codedOutputStream.writeString(2, getDescription());
        }
    }

    /* loaded from: classes2.dex */
    public interface FieldViolationOrBuilder extends MessageLiteOrBuilder {
        String getDescription();

        ByteString getDescriptionBytes();

        String getField();

        ByteString getFieldBytes();
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private BadRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllFieldViolations(Iterable<? extends FieldViolation> iterable) {
        ensureFieldViolationsIsMutable();
        AbstractMessageLite.a(iterable, this.fieldViolations_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFieldViolations(int i, FieldViolation.Builder builder) {
        ensureFieldViolationsIsMutable();
        this.fieldViolations_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFieldViolations(int i, FieldViolation fieldViolation) {
        if (fieldViolation == null) {
            throw new NullPointerException();
        }
        ensureFieldViolationsIsMutable();
        this.fieldViolations_.add(i, fieldViolation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFieldViolations(FieldViolation.Builder builder) {
        ensureFieldViolationsIsMutable();
        this.fieldViolations_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFieldViolations(FieldViolation fieldViolation) {
        if (fieldViolation == null) {
            throw new NullPointerException();
        }
        ensureFieldViolationsIsMutable();
        this.fieldViolations_.add(fieldViolation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFieldViolations() {
        this.fieldViolations_ = GeneratedMessageLite.f();
    }

    private void ensureFieldViolationsIsMutable() {
        if (this.fieldViolations_.isModifiable()) {
            return;
        }
        this.fieldViolations_ = GeneratedMessageLite.a(this.fieldViolations_);
    }

    public static BadRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(BadRequest badRequest) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) badRequest);
    }

    public static BadRequest parseDelimitedFrom(InputStream inputStream) {
        return (BadRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static BadRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BadRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BadRequest parseFrom(ByteString byteString) {
        return (BadRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static BadRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (BadRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static BadRequest parseFrom(CodedInputStream codedInputStream) {
        return (BadRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static BadRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BadRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static BadRequest parseFrom(InputStream inputStream) {
        return (BadRequest) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static BadRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BadRequest) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BadRequest parseFrom(byte[] bArr) {
        return (BadRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static BadRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (BadRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<BadRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeFieldViolations(int i) {
        ensureFieldViolationsIsMutable();
        this.fieldViolations_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFieldViolations(int i, FieldViolation.Builder builder) {
        ensureFieldViolationsIsMutable();
        this.fieldViolations_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFieldViolations(int i, FieldViolation fieldViolation) {
        if (fieldViolation == null) {
            throw new NullPointerException();
        }
        ensureFieldViolationsIsMutable();
        this.fieldViolations_.set(i, fieldViolation);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new BadRequest();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.fieldViolations_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                this.fieldViolations_ = ((GeneratedMessageLite.Visitor) obj).visitList(this.fieldViolations_, ((BadRequest) obj2).fieldViolations_);
                GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
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
                                    if (!this.fieldViolations_.isModifiable()) {
                                        this.fieldViolations_ = GeneratedMessageLite.a(this.fieldViolations_);
                                    }
                                    this.fieldViolations_.add((FieldViolation) codedInputStream.readMessage(FieldViolation.parser(), extensionRegistryLite));
                                } else if (!codedInputStream.skipField(readTag)) {
                                }
                            }
                            z = true;
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
                    synchronized (BadRequest.class) {
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

    @Override // com.google.rpc.BadRequestOrBuilder
    public FieldViolation getFieldViolations(int i) {
        return this.fieldViolations_.get(i);
    }

    @Override // com.google.rpc.BadRequestOrBuilder
    public int getFieldViolationsCount() {
        return this.fieldViolations_.size();
    }

    @Override // com.google.rpc.BadRequestOrBuilder
    public List<FieldViolation> getFieldViolationsList() {
        return this.fieldViolations_;
    }

    public FieldViolationOrBuilder getFieldViolationsOrBuilder(int i) {
        return this.fieldViolations_.get(i);
    }

    public List<? extends FieldViolationOrBuilder> getFieldViolationsOrBuilderList() {
        return this.fieldViolations_;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.fieldViolations_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(1, this.fieldViolations_.get(i3));
        }
        this.c = i2;
        return i2;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        for (int i = 0; i < this.fieldViolations_.size(); i++) {
            codedOutputStream.writeMessage(1, this.fieldViolations_.get(i));
        }
    }
}
