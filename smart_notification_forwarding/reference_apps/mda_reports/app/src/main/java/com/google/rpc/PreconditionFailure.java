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
public final class PreconditionFailure extends GeneratedMessageLite<PreconditionFailure, Builder> implements PreconditionFailureOrBuilder {
    private static final PreconditionFailure DEFAULT_INSTANCE = new PreconditionFailure();
    private static volatile Parser<PreconditionFailure> PARSER = null;
    public static final int VIOLATIONS_FIELD_NUMBER = 1;
    private Internal.ProtobufList<Violation> violations_ = GeneratedMessageLite.f();

    /* renamed from: com.google.rpc.PreconditionFailure$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<PreconditionFailure, Builder> implements PreconditionFailureOrBuilder {
        private Builder() {
            super(PreconditionFailure.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllViolations(Iterable<? extends Violation> iterable) {
            a();
            ((PreconditionFailure) this.a).addAllViolations(iterable);
            return this;
        }

        public Builder addViolations(int i, Violation.Builder builder) {
            a();
            ((PreconditionFailure) this.a).addViolations(i, builder);
            return this;
        }

        public Builder addViolations(int i, Violation violation) {
            a();
            ((PreconditionFailure) this.a).addViolations(i, violation);
            return this;
        }

        public Builder addViolations(Violation.Builder builder) {
            a();
            ((PreconditionFailure) this.a).addViolations(builder);
            return this;
        }

        public Builder addViolations(Violation violation) {
            a();
            ((PreconditionFailure) this.a).addViolations(violation);
            return this;
        }

        public Builder clearViolations() {
            a();
            ((PreconditionFailure) this.a).clearViolations();
            return this;
        }

        @Override // com.google.rpc.PreconditionFailureOrBuilder
        public Violation getViolations(int i) {
            return ((PreconditionFailure) this.a).getViolations(i);
        }

        @Override // com.google.rpc.PreconditionFailureOrBuilder
        public int getViolationsCount() {
            return ((PreconditionFailure) this.a).getViolationsCount();
        }

        @Override // com.google.rpc.PreconditionFailureOrBuilder
        public List<Violation> getViolationsList() {
            return Collections.unmodifiableList(((PreconditionFailure) this.a).getViolationsList());
        }

        public Builder removeViolations(int i) {
            a();
            ((PreconditionFailure) this.a).removeViolations(i);
            return this;
        }

        public Builder setViolations(int i, Violation.Builder builder) {
            a();
            ((PreconditionFailure) this.a).setViolations(i, builder);
            return this;
        }

        public Builder setViolations(int i, Violation violation) {
            a();
            ((PreconditionFailure) this.a).setViolations(i, violation);
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static final class Violation extends GeneratedMessageLite<Violation, Builder> implements ViolationOrBuilder {
        private static final Violation DEFAULT_INSTANCE = new Violation();
        public static final int DESCRIPTION_FIELD_NUMBER = 3;
        private static volatile Parser<Violation> PARSER = null;
        public static final int SUBJECT_FIELD_NUMBER = 2;
        public static final int TYPE_FIELD_NUMBER = 1;
        private String type_ = "";
        private String subject_ = "";
        private String description_ = "";

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Violation, Builder> implements ViolationOrBuilder {
            private Builder() {
                super(Violation.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearDescription() {
                a();
                ((Violation) this.a).clearDescription();
                return this;
            }

            public Builder clearSubject() {
                a();
                ((Violation) this.a).clearSubject();
                return this;
            }

            public Builder clearType() {
                a();
                ((Violation) this.a).clearType();
                return this;
            }

            @Override // com.google.rpc.PreconditionFailure.ViolationOrBuilder
            public String getDescription() {
                return ((Violation) this.a).getDescription();
            }

            @Override // com.google.rpc.PreconditionFailure.ViolationOrBuilder
            public ByteString getDescriptionBytes() {
                return ((Violation) this.a).getDescriptionBytes();
            }

            @Override // com.google.rpc.PreconditionFailure.ViolationOrBuilder
            public String getSubject() {
                return ((Violation) this.a).getSubject();
            }

            @Override // com.google.rpc.PreconditionFailure.ViolationOrBuilder
            public ByteString getSubjectBytes() {
                return ((Violation) this.a).getSubjectBytes();
            }

            @Override // com.google.rpc.PreconditionFailure.ViolationOrBuilder
            public String getType() {
                return ((Violation) this.a).getType();
            }

            @Override // com.google.rpc.PreconditionFailure.ViolationOrBuilder
            public ByteString getTypeBytes() {
                return ((Violation) this.a).getTypeBytes();
            }

            public Builder setDescription(String str) {
                a();
                ((Violation) this.a).setDescription(str);
                return this;
            }

            public Builder setDescriptionBytes(ByteString byteString) {
                a();
                ((Violation) this.a).setDescriptionBytes(byteString);
                return this;
            }

            public Builder setSubject(String str) {
                a();
                ((Violation) this.a).setSubject(str);
                return this;
            }

            public Builder setSubjectBytes(ByteString byteString) {
                a();
                ((Violation) this.a).setSubjectBytes(byteString);
                return this;
            }

            public Builder setType(String str) {
                a();
                ((Violation) this.a).setType(str);
                return this;
            }

            public Builder setTypeBytes(ByteString byteString) {
                a();
                ((Violation) this.a).setTypeBytes(byteString);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private Violation() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDescription() {
            this.description_ = getDefaultInstance().getDescription();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSubject() {
            this.subject_ = getDefaultInstance().getSubject();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearType() {
            this.type_ = getDefaultInstance().getType();
        }

        public static Violation getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Violation violation) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) violation);
        }

        public static Violation parseDelimitedFrom(InputStream inputStream) {
            return (Violation) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static Violation parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Violation) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Violation parseFrom(ByteString byteString) {
            return (Violation) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static Violation parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (Violation) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Violation parseFrom(CodedInputStream codedInputStream) {
            return (Violation) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Violation parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Violation) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Violation parseFrom(InputStream inputStream) {
            return (Violation) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static Violation parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Violation) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Violation parseFrom(byte[] bArr) {
            return (Violation) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static Violation parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (Violation) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<Violation> parser() {
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
        public void setSubject(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.subject_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSubjectBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.a(byteString);
            this.subject_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setType(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.type_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTypeBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.a(byteString);
            this.type_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new Violation();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    Violation violation = (Violation) obj2;
                    this.type_ = visitor.visitString(!this.type_.isEmpty(), this.type_, !violation.type_.isEmpty(), violation.type_);
                    this.subject_ = visitor.visitString(!this.subject_.isEmpty(), this.subject_, !violation.subject_.isEmpty(), violation.subject_);
                    this.description_ = visitor.visitString(!this.description_.isEmpty(), this.description_, true ^ violation.description_.isEmpty(), violation.description_);
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
                                    this.type_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 18) {
                                    this.subject_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 26) {
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
                        synchronized (Violation.class) {
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

        @Override // com.google.rpc.PreconditionFailure.ViolationOrBuilder
        public String getDescription() {
            return this.description_;
        }

        @Override // com.google.rpc.PreconditionFailure.ViolationOrBuilder
        public ByteString getDescriptionBytes() {
            return ByteString.copyFromUtf8(this.description_);
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeStringSize = this.type_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getType());
            if (!this.subject_.isEmpty()) {
                computeStringSize += CodedOutputStream.computeStringSize(2, getSubject());
            }
            if (!this.description_.isEmpty()) {
                computeStringSize += CodedOutputStream.computeStringSize(3, getDescription());
            }
            this.c = computeStringSize;
            return computeStringSize;
        }

        @Override // com.google.rpc.PreconditionFailure.ViolationOrBuilder
        public String getSubject() {
            return this.subject_;
        }

        @Override // com.google.rpc.PreconditionFailure.ViolationOrBuilder
        public ByteString getSubjectBytes() {
            return ByteString.copyFromUtf8(this.subject_);
        }

        @Override // com.google.rpc.PreconditionFailure.ViolationOrBuilder
        public String getType() {
            return this.type_;
        }

        @Override // com.google.rpc.PreconditionFailure.ViolationOrBuilder
        public ByteString getTypeBytes() {
            return ByteString.copyFromUtf8(this.type_);
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if (!this.type_.isEmpty()) {
                codedOutputStream.writeString(1, getType());
            }
            if (!this.subject_.isEmpty()) {
                codedOutputStream.writeString(2, getSubject());
            }
            if (this.description_.isEmpty()) {
                return;
            }
            codedOutputStream.writeString(3, getDescription());
        }
    }

    /* loaded from: classes2.dex */
    public interface ViolationOrBuilder extends MessageLiteOrBuilder {
        String getDescription();

        ByteString getDescriptionBytes();

        String getSubject();

        ByteString getSubjectBytes();

        String getType();

        ByteString getTypeBytes();
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private PreconditionFailure() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllViolations(Iterable<? extends Violation> iterable) {
        ensureViolationsIsMutable();
        AbstractMessageLite.a(iterable, this.violations_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addViolations(int i, Violation.Builder builder) {
        ensureViolationsIsMutable();
        this.violations_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addViolations(int i, Violation violation) {
        if (violation == null) {
            throw new NullPointerException();
        }
        ensureViolationsIsMutable();
        this.violations_.add(i, violation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addViolations(Violation.Builder builder) {
        ensureViolationsIsMutable();
        this.violations_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addViolations(Violation violation) {
        if (violation == null) {
            throw new NullPointerException();
        }
        ensureViolationsIsMutable();
        this.violations_.add(violation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearViolations() {
        this.violations_ = GeneratedMessageLite.f();
    }

    private void ensureViolationsIsMutable() {
        if (this.violations_.isModifiable()) {
            return;
        }
        this.violations_ = GeneratedMessageLite.a(this.violations_);
    }

    public static PreconditionFailure getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(PreconditionFailure preconditionFailure) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) preconditionFailure);
    }

    public static PreconditionFailure parseDelimitedFrom(InputStream inputStream) {
        return (PreconditionFailure) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static PreconditionFailure parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PreconditionFailure) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PreconditionFailure parseFrom(ByteString byteString) {
        return (PreconditionFailure) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static PreconditionFailure parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (PreconditionFailure) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static PreconditionFailure parseFrom(CodedInputStream codedInputStream) {
        return (PreconditionFailure) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static PreconditionFailure parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PreconditionFailure) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static PreconditionFailure parseFrom(InputStream inputStream) {
        return (PreconditionFailure) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static PreconditionFailure parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PreconditionFailure) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PreconditionFailure parseFrom(byte[] bArr) {
        return (PreconditionFailure) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static PreconditionFailure parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (PreconditionFailure) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<PreconditionFailure> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeViolations(int i) {
        ensureViolationsIsMutable();
        this.violations_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViolations(int i, Violation.Builder builder) {
        ensureViolationsIsMutable();
        this.violations_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViolations(int i, Violation violation) {
        if (violation == null) {
            throw new NullPointerException();
        }
        ensureViolationsIsMutable();
        this.violations_.set(i, violation);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new PreconditionFailure();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.violations_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                this.violations_ = ((GeneratedMessageLite.Visitor) obj).visitList(this.violations_, ((PreconditionFailure) obj2).violations_);
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
                                    if (!this.violations_.isModifiable()) {
                                        this.violations_ = GeneratedMessageLite.a(this.violations_);
                                    }
                                    this.violations_.add((Violation) codedInputStream.readMessage(Violation.parser(), extensionRegistryLite));
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
                    synchronized (PreconditionFailure.class) {
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

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.violations_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(1, this.violations_.get(i3));
        }
        this.c = i2;
        return i2;
    }

    @Override // com.google.rpc.PreconditionFailureOrBuilder
    public Violation getViolations(int i) {
        return this.violations_.get(i);
    }

    @Override // com.google.rpc.PreconditionFailureOrBuilder
    public int getViolationsCount() {
        return this.violations_.size();
    }

    @Override // com.google.rpc.PreconditionFailureOrBuilder
    public List<Violation> getViolationsList() {
        return this.violations_;
    }

    public ViolationOrBuilder getViolationsOrBuilder(int i) {
        return this.violations_.get(i);
    }

    public List<? extends ViolationOrBuilder> getViolationsOrBuilderList() {
        return this.violations_;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        for (int i = 0; i < this.violations_.size(); i++) {
            codedOutputStream.writeMessage(1, this.violations_.get(i));
        }
    }
}
