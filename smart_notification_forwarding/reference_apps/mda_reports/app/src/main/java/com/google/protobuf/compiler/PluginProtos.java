package com.google.protobuf.compiler;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
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
public final class PluginProtos {

    /* renamed from: com.google.protobuf.compiler.PluginProtos$1, reason: invalid class name */
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
    public static final class CodeGeneratorRequest extends GeneratedMessageLite<CodeGeneratorRequest, Builder> implements CodeGeneratorRequestOrBuilder {
        public static final int COMPILER_VERSION_FIELD_NUMBER = 3;
        private static final CodeGeneratorRequest DEFAULT_INSTANCE = new CodeGeneratorRequest();
        public static final int FILE_TO_GENERATE_FIELD_NUMBER = 1;
        public static final int PARAMETER_FIELD_NUMBER = 2;
        private static volatile Parser<CodeGeneratorRequest> PARSER = null;
        public static final int PROTO_FILE_FIELD_NUMBER = 15;
        private int bitField0_;
        private Version compilerVersion_;
        private byte memoizedIsInitialized = -1;
        private Internal.ProtobufList<String> fileToGenerate_ = GeneratedMessageLite.f();
        private String parameter_ = "";
        private Internal.ProtobufList<DescriptorProtos.FileDescriptorProto> protoFile_ = GeneratedMessageLite.f();

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<CodeGeneratorRequest, Builder> implements CodeGeneratorRequestOrBuilder {
            private Builder() {
                super(CodeGeneratorRequest.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllFileToGenerate(Iterable<String> iterable) {
                a();
                ((CodeGeneratorRequest) this.a).addAllFileToGenerate(iterable);
                return this;
            }

            public Builder addAllProtoFile(Iterable<? extends DescriptorProtos.FileDescriptorProto> iterable) {
                a();
                ((CodeGeneratorRequest) this.a).addAllProtoFile(iterable);
                return this;
            }

            public Builder addFileToGenerate(String str) {
                a();
                ((CodeGeneratorRequest) this.a).addFileToGenerate(str);
                return this;
            }

            public Builder addFileToGenerateBytes(ByteString byteString) {
                a();
                ((CodeGeneratorRequest) this.a).addFileToGenerateBytes(byteString);
                return this;
            }

            public Builder addProtoFile(int i, DescriptorProtos.FileDescriptorProto.Builder builder) {
                a();
                ((CodeGeneratorRequest) this.a).addProtoFile(i, builder);
                return this;
            }

            public Builder addProtoFile(int i, DescriptorProtos.FileDescriptorProto fileDescriptorProto) {
                a();
                ((CodeGeneratorRequest) this.a).addProtoFile(i, fileDescriptorProto);
                return this;
            }

            public Builder addProtoFile(DescriptorProtos.FileDescriptorProto.Builder builder) {
                a();
                ((CodeGeneratorRequest) this.a).addProtoFile(builder);
                return this;
            }

            public Builder addProtoFile(DescriptorProtos.FileDescriptorProto fileDescriptorProto) {
                a();
                ((CodeGeneratorRequest) this.a).addProtoFile(fileDescriptorProto);
                return this;
            }

            public Builder clearCompilerVersion() {
                a();
                ((CodeGeneratorRequest) this.a).clearCompilerVersion();
                return this;
            }

            public Builder clearFileToGenerate() {
                a();
                ((CodeGeneratorRequest) this.a).clearFileToGenerate();
                return this;
            }

            public Builder clearParameter() {
                a();
                ((CodeGeneratorRequest) this.a).clearParameter();
                return this;
            }

            public Builder clearProtoFile() {
                a();
                ((CodeGeneratorRequest) this.a).clearProtoFile();
                return this;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public Version getCompilerVersion() {
                return ((CodeGeneratorRequest) this.a).getCompilerVersion();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public String getFileToGenerate(int i) {
                return ((CodeGeneratorRequest) this.a).getFileToGenerate(i);
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public ByteString getFileToGenerateBytes(int i) {
                return ((CodeGeneratorRequest) this.a).getFileToGenerateBytes(i);
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public int getFileToGenerateCount() {
                return ((CodeGeneratorRequest) this.a).getFileToGenerateCount();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public List<String> getFileToGenerateList() {
                return Collections.unmodifiableList(((CodeGeneratorRequest) this.a).getFileToGenerateList());
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public String getParameter() {
                return ((CodeGeneratorRequest) this.a).getParameter();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public ByteString getParameterBytes() {
                return ((CodeGeneratorRequest) this.a).getParameterBytes();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public DescriptorProtos.FileDescriptorProto getProtoFile(int i) {
                return ((CodeGeneratorRequest) this.a).getProtoFile(i);
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public int getProtoFileCount() {
                return ((CodeGeneratorRequest) this.a).getProtoFileCount();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public List<DescriptorProtos.FileDescriptorProto> getProtoFileList() {
                return Collections.unmodifiableList(((CodeGeneratorRequest) this.a).getProtoFileList());
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public boolean hasCompilerVersion() {
                return ((CodeGeneratorRequest) this.a).hasCompilerVersion();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public boolean hasParameter() {
                return ((CodeGeneratorRequest) this.a).hasParameter();
            }

            public Builder mergeCompilerVersion(Version version) {
                a();
                ((CodeGeneratorRequest) this.a).mergeCompilerVersion(version);
                return this;
            }

            public Builder removeProtoFile(int i) {
                a();
                ((CodeGeneratorRequest) this.a).removeProtoFile(i);
                return this;
            }

            public Builder setCompilerVersion(Version.Builder builder) {
                a();
                ((CodeGeneratorRequest) this.a).setCompilerVersion(builder);
                return this;
            }

            public Builder setCompilerVersion(Version version) {
                a();
                ((CodeGeneratorRequest) this.a).setCompilerVersion(version);
                return this;
            }

            public Builder setFileToGenerate(int i, String str) {
                a();
                ((CodeGeneratorRequest) this.a).setFileToGenerate(i, str);
                return this;
            }

            public Builder setParameter(String str) {
                a();
                ((CodeGeneratorRequest) this.a).setParameter(str);
                return this;
            }

            public Builder setParameterBytes(ByteString byteString) {
                a();
                ((CodeGeneratorRequest) this.a).setParameterBytes(byteString);
                return this;
            }

            public Builder setProtoFile(int i, DescriptorProtos.FileDescriptorProto.Builder builder) {
                a();
                ((CodeGeneratorRequest) this.a).setProtoFile(i, builder);
                return this;
            }

            public Builder setProtoFile(int i, DescriptorProtos.FileDescriptorProto fileDescriptorProto) {
                a();
                ((CodeGeneratorRequest) this.a).setProtoFile(i, fileDescriptorProto);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private CodeGeneratorRequest() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllFileToGenerate(Iterable<String> iterable) {
            ensureFileToGenerateIsMutable();
            AbstractMessageLite.a(iterable, this.fileToGenerate_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllProtoFile(Iterable<? extends DescriptorProtos.FileDescriptorProto> iterable) {
            ensureProtoFileIsMutable();
            AbstractMessageLite.a(iterable, this.protoFile_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addFileToGenerate(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            ensureFileToGenerateIsMutable();
            this.fileToGenerate_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addFileToGenerateBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            ensureFileToGenerateIsMutable();
            this.fileToGenerate_.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addProtoFile(int i, DescriptorProtos.FileDescriptorProto.Builder builder) {
            ensureProtoFileIsMutable();
            this.protoFile_.add(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addProtoFile(int i, DescriptorProtos.FileDescriptorProto fileDescriptorProto) {
            if (fileDescriptorProto == null) {
                throw new NullPointerException();
            }
            ensureProtoFileIsMutable();
            this.protoFile_.add(i, fileDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addProtoFile(DescriptorProtos.FileDescriptorProto.Builder builder) {
            ensureProtoFileIsMutable();
            this.protoFile_.add(builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addProtoFile(DescriptorProtos.FileDescriptorProto fileDescriptorProto) {
            if (fileDescriptorProto == null) {
                throw new NullPointerException();
            }
            ensureProtoFileIsMutable();
            this.protoFile_.add(fileDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCompilerVersion() {
            this.compilerVersion_ = null;
            this.bitField0_ &= -3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFileToGenerate() {
            this.fileToGenerate_ = GeneratedMessageLite.f();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearParameter() {
            this.bitField0_ &= -2;
            this.parameter_ = getDefaultInstance().getParameter();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearProtoFile() {
            this.protoFile_ = GeneratedMessageLite.f();
        }

        private void ensureFileToGenerateIsMutable() {
            if (this.fileToGenerate_.isModifiable()) {
                return;
            }
            this.fileToGenerate_ = GeneratedMessageLite.a(this.fileToGenerate_);
        }

        private void ensureProtoFileIsMutable() {
            if (this.protoFile_.isModifiable()) {
                return;
            }
            this.protoFile_ = GeneratedMessageLite.a(this.protoFile_);
        }

        public static CodeGeneratorRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeCompilerVersion(Version version) {
            Version version2 = this.compilerVersion_;
            if (version2 != null && version2 != Version.getDefaultInstance()) {
                version = Version.newBuilder(this.compilerVersion_).mergeFrom((Version.Builder) version).buildPartial();
            }
            this.compilerVersion_ = version;
            this.bitField0_ |= 2;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CodeGeneratorRequest codeGeneratorRequest) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) codeGeneratorRequest);
        }

        public static CodeGeneratorRequest parseDelimitedFrom(InputStream inputStream) {
            return (CodeGeneratorRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static CodeGeneratorRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CodeGeneratorRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CodeGeneratorRequest parseFrom(ByteString byteString) {
            return (CodeGeneratorRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static CodeGeneratorRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (CodeGeneratorRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static CodeGeneratorRequest parseFrom(CodedInputStream codedInputStream) {
            return (CodeGeneratorRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static CodeGeneratorRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CodeGeneratorRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static CodeGeneratorRequest parseFrom(InputStream inputStream) {
            return (CodeGeneratorRequest) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static CodeGeneratorRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CodeGeneratorRequest) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CodeGeneratorRequest parseFrom(byte[] bArr) {
            return (CodeGeneratorRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static CodeGeneratorRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (CodeGeneratorRequest) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<CodeGeneratorRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeProtoFile(int i) {
            ensureProtoFileIsMutable();
            this.protoFile_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCompilerVersion(Version.Builder builder) {
            this.compilerVersion_ = builder.build();
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCompilerVersion(Version version) {
            if (version == null) {
                throw new NullPointerException();
            }
            this.compilerVersion_ = version;
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFileToGenerate(int i, String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            ensureFileToGenerateIsMutable();
            this.fileToGenerate_.set(i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setParameter(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 1;
            this.parameter_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setParameterBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 1;
            this.parameter_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProtoFile(int i, DescriptorProtos.FileDescriptorProto.Builder builder) {
            ensureProtoFileIsMutable();
            this.protoFile_.set(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProtoFile(int i, DescriptorProtos.FileDescriptorProto fileDescriptorProto) {
            if (fileDescriptorProto == null) {
                throw new NullPointerException();
            }
            ensureProtoFileIsMutable();
            this.protoFile_.set(i, fileDescriptorProto);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new CodeGeneratorRequest();
                case 2:
                    byte b = this.memoizedIsInitialized;
                    if (b == 1) {
                        return DEFAULT_INSTANCE;
                    }
                    if (b == 0) {
                        return null;
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    for (int i = 0; i < getProtoFileCount(); i++) {
                        if (!getProtoFile(i).isInitialized()) {
                            if (booleanValue) {
                                this.memoizedIsInitialized = (byte) 0;
                            }
                            return null;
                        }
                    }
                    if (booleanValue) {
                        this.memoizedIsInitialized = (byte) 1;
                    }
                    return DEFAULT_INSTANCE;
                case 3:
                    this.fileToGenerate_.makeImmutable();
                    this.protoFile_.makeImmutable();
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    CodeGeneratorRequest codeGeneratorRequest = (CodeGeneratorRequest) obj2;
                    this.fileToGenerate_ = visitor.visitList(this.fileToGenerate_, codeGeneratorRequest.fileToGenerate_);
                    this.parameter_ = visitor.visitString(hasParameter(), this.parameter_, codeGeneratorRequest.hasParameter(), codeGeneratorRequest.parameter_);
                    this.protoFile_ = visitor.visitList(this.protoFile_, codeGeneratorRequest.protoFile_);
                    this.compilerVersion_ = (Version) visitor.visitMessage(this.compilerVersion_, codeGeneratorRequest.compilerVersion_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= codeGeneratorRequest.bitField0_;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    String readString = codedInputStream.readString();
                                    if (!this.fileToGenerate_.isModifiable()) {
                                        this.fileToGenerate_ = GeneratedMessageLite.a(this.fileToGenerate_);
                                    }
                                    this.fileToGenerate_.add(readString);
                                } else if (readTag == 18) {
                                    String readString2 = codedInputStream.readString();
                                    this.bitField0_ |= 1;
                                    this.parameter_ = readString2;
                                } else if (readTag == 26) {
                                    Version.Builder builder = (this.bitField0_ & 2) == 2 ? this.compilerVersion_.toBuilder() : null;
                                    this.compilerVersion_ = (Version) codedInputStream.readMessage(Version.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom((Version.Builder) this.compilerVersion_);
                                        this.compilerVersion_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 2;
                                } else if (readTag == 122) {
                                    if (!this.protoFile_.isModifiable()) {
                                        this.protoFile_ = GeneratedMessageLite.a(this.protoFile_);
                                    }
                                    this.protoFile_.add((DescriptorProtos.FileDescriptorProto) codedInputStream.readMessage(DescriptorProtos.FileDescriptorProto.parser(), extensionRegistryLite));
                                } else if (!a(readTag, codedInputStream)) {
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
                        synchronized (CodeGeneratorRequest.class) {
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

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public Version getCompilerVersion() {
            Version version = this.compilerVersion_;
            return version == null ? Version.getDefaultInstance() : version;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public String getFileToGenerate(int i) {
            return this.fileToGenerate_.get(i);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public ByteString getFileToGenerateBytes(int i) {
            return ByteString.copyFromUtf8(this.fileToGenerate_.get(i));
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public int getFileToGenerateCount() {
            return this.fileToGenerate_.size();
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public List<String> getFileToGenerateList() {
            return this.fileToGenerate_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public String getParameter() {
            return this.parameter_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public ByteString getParameterBytes() {
            return ByteString.copyFromUtf8(this.parameter_);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public DescriptorProtos.FileDescriptorProto getProtoFile(int i) {
            return this.protoFile_.get(i);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public int getProtoFileCount() {
            return this.protoFile_.size();
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public List<DescriptorProtos.FileDescriptorProto> getProtoFileList() {
            return this.protoFile_;
        }

        public DescriptorProtos.FileDescriptorProtoOrBuilder getProtoFileOrBuilder(int i) {
            return this.protoFile_.get(i);
        }

        public List<? extends DescriptorProtos.FileDescriptorProtoOrBuilder> getProtoFileOrBuilderList() {
            return this.protoFile_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.fileToGenerate_.size(); i3++) {
                i2 += CodedOutputStream.computeStringSizeNoTag(this.fileToGenerate_.get(i3));
            }
            int size = i2 + 0 + (getFileToGenerateList().size() * 1);
            if ((this.bitField0_ & 1) == 1) {
                size += CodedOutputStream.computeStringSize(2, getParameter());
            }
            if ((this.bitField0_ & 2) == 2) {
                size += CodedOutputStream.computeMessageSize(3, getCompilerVersion());
            }
            for (int i4 = 0; i4 < this.protoFile_.size(); i4++) {
                size += CodedOutputStream.computeMessageSize(15, this.protoFile_.get(i4));
            }
            int serializedSize = size + this.b.getSerializedSize();
            this.c = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public boolean hasCompilerVersion() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public boolean hasParameter() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            for (int i = 0; i < this.fileToGenerate_.size(); i++) {
                codedOutputStream.writeString(1, this.fileToGenerate_.get(i));
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeString(2, getParameter());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(3, getCompilerVersion());
            }
            for (int i2 = 0; i2 < this.protoFile_.size(); i2++) {
                codedOutputStream.writeMessage(15, this.protoFile_.get(i2));
            }
            this.b.writeTo(codedOutputStream);
        }
    }

    /* loaded from: classes2.dex */
    public interface CodeGeneratorRequestOrBuilder extends MessageLiteOrBuilder {
        Version getCompilerVersion();

        String getFileToGenerate(int i);

        ByteString getFileToGenerateBytes(int i);

        int getFileToGenerateCount();

        List<String> getFileToGenerateList();

        String getParameter();

        ByteString getParameterBytes();

        DescriptorProtos.FileDescriptorProto getProtoFile(int i);

        int getProtoFileCount();

        List<DescriptorProtos.FileDescriptorProto> getProtoFileList();

        boolean hasCompilerVersion();

        boolean hasParameter();
    }

    /* loaded from: classes2.dex */
    public static final class CodeGeneratorResponse extends GeneratedMessageLite<CodeGeneratorResponse, Builder> implements CodeGeneratorResponseOrBuilder {
        private static final CodeGeneratorResponse DEFAULT_INSTANCE = new CodeGeneratorResponse();
        public static final int ERROR_FIELD_NUMBER = 1;
        public static final int FILE_FIELD_NUMBER = 15;
        private static volatile Parser<CodeGeneratorResponse> PARSER;
        private int bitField0_;
        private String error_ = "";
        private Internal.ProtobufList<File> file_ = GeneratedMessageLite.f();

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<CodeGeneratorResponse, Builder> implements CodeGeneratorResponseOrBuilder {
            private Builder() {
                super(CodeGeneratorResponse.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllFile(Iterable<? extends File> iterable) {
                a();
                ((CodeGeneratorResponse) this.a).addAllFile(iterable);
                return this;
            }

            public Builder addFile(int i, File.Builder builder) {
                a();
                ((CodeGeneratorResponse) this.a).addFile(i, builder);
                return this;
            }

            public Builder addFile(int i, File file) {
                a();
                ((CodeGeneratorResponse) this.a).addFile(i, file);
                return this;
            }

            public Builder addFile(File.Builder builder) {
                a();
                ((CodeGeneratorResponse) this.a).addFile(builder);
                return this;
            }

            public Builder addFile(File file) {
                a();
                ((CodeGeneratorResponse) this.a).addFile(file);
                return this;
            }

            public Builder clearError() {
                a();
                ((CodeGeneratorResponse) this.a).clearError();
                return this;
            }

            public Builder clearFile() {
                a();
                ((CodeGeneratorResponse) this.a).clearFile();
                return this;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public String getError() {
                return ((CodeGeneratorResponse) this.a).getError();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public ByteString getErrorBytes() {
                return ((CodeGeneratorResponse) this.a).getErrorBytes();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public File getFile(int i) {
                return ((CodeGeneratorResponse) this.a).getFile(i);
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public int getFileCount() {
                return ((CodeGeneratorResponse) this.a).getFileCount();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public List<File> getFileList() {
                return Collections.unmodifiableList(((CodeGeneratorResponse) this.a).getFileList());
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public boolean hasError() {
                return ((CodeGeneratorResponse) this.a).hasError();
            }

            public Builder removeFile(int i) {
                a();
                ((CodeGeneratorResponse) this.a).removeFile(i);
                return this;
            }

            public Builder setError(String str) {
                a();
                ((CodeGeneratorResponse) this.a).setError(str);
                return this;
            }

            public Builder setErrorBytes(ByteString byteString) {
                a();
                ((CodeGeneratorResponse) this.a).setErrorBytes(byteString);
                return this;
            }

            public Builder setFile(int i, File.Builder builder) {
                a();
                ((CodeGeneratorResponse) this.a).setFile(i, builder);
                return this;
            }

            public Builder setFile(int i, File file) {
                a();
                ((CodeGeneratorResponse) this.a).setFile(i, file);
                return this;
            }
        }

        /* loaded from: classes2.dex */
        public static final class File extends GeneratedMessageLite<File, Builder> implements FileOrBuilder {
            public static final int CONTENT_FIELD_NUMBER = 15;
            private static final File DEFAULT_INSTANCE = new File();
            public static final int INSERTION_POINT_FIELD_NUMBER = 2;
            public static final int NAME_FIELD_NUMBER = 1;
            private static volatile Parser<File> PARSER;
            private int bitField0_;
            private String name_ = "";
            private String insertionPoint_ = "";
            private String content_ = "";

            /* loaded from: classes2.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<File, Builder> implements FileOrBuilder {
                private Builder() {
                    super(File.DEFAULT_INSTANCE);
                }

                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                public Builder clearContent() {
                    a();
                    ((File) this.a).clearContent();
                    return this;
                }

                public Builder clearInsertionPoint() {
                    a();
                    ((File) this.a).clearInsertionPoint();
                    return this;
                }

                public Builder clearName() {
                    a();
                    ((File) this.a).clearName();
                    return this;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public String getContent() {
                    return ((File) this.a).getContent();
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public ByteString getContentBytes() {
                    return ((File) this.a).getContentBytes();
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public String getInsertionPoint() {
                    return ((File) this.a).getInsertionPoint();
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public ByteString getInsertionPointBytes() {
                    return ((File) this.a).getInsertionPointBytes();
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public String getName() {
                    return ((File) this.a).getName();
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public ByteString getNameBytes() {
                    return ((File) this.a).getNameBytes();
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public boolean hasContent() {
                    return ((File) this.a).hasContent();
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public boolean hasInsertionPoint() {
                    return ((File) this.a).hasInsertionPoint();
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public boolean hasName() {
                    return ((File) this.a).hasName();
                }

                public Builder setContent(String str) {
                    a();
                    ((File) this.a).setContent(str);
                    return this;
                }

                public Builder setContentBytes(ByteString byteString) {
                    a();
                    ((File) this.a).setContentBytes(byteString);
                    return this;
                }

                public Builder setInsertionPoint(String str) {
                    a();
                    ((File) this.a).setInsertionPoint(str);
                    return this;
                }

                public Builder setInsertionPointBytes(ByteString byteString) {
                    a();
                    ((File) this.a).setInsertionPointBytes(byteString);
                    return this;
                }

                public Builder setName(String str) {
                    a();
                    ((File) this.a).setName(str);
                    return this;
                }

                public Builder setNameBytes(ByteString byteString) {
                    a();
                    ((File) this.a).setNameBytes(byteString);
                    return this;
                }
            }

            static {
                DEFAULT_INSTANCE.b();
            }

            private File() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearContent() {
                this.bitField0_ &= -5;
                this.content_ = getDefaultInstance().getContent();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearInsertionPoint() {
                this.bitField0_ &= -3;
                this.insertionPoint_ = getDefaultInstance().getInsertionPoint();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearName() {
                this.bitField0_ &= -2;
                this.name_ = getDefaultInstance().getName();
            }

            public static File getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(File file) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) file);
            }

            public static File parseDelimitedFrom(InputStream inputStream) {
                return (File) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
            }

            public static File parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (File) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static File parseFrom(ByteString byteString) {
                return (File) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
            }

            public static File parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                return (File) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static File parseFrom(CodedInputStream codedInputStream) {
                return (File) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
            }

            public static File parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (File) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static File parseFrom(InputStream inputStream) {
                return (File) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
            }

            public static File parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (File) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static File parseFrom(byte[] bArr) {
                return (File) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
            }

            public static File parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                return (File) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static Parser<File> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setContent(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.content_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setContentBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.content_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setInsertionPoint(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.insertionPoint_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setInsertionPointBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.insertionPoint_ = byteString.toStringUtf8();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setName(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 1;
                this.name_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setNameBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 1;
                this.name_ = byteString.toStringUtf8();
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new File();
                    case 2:
                        return DEFAULT_INSTANCE;
                    case 3:
                        return null;
                    case 4:
                        return new Builder(anonymousClass1);
                    case 5:
                        GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                        File file = (File) obj2;
                        this.name_ = visitor.visitString(hasName(), this.name_, file.hasName(), file.name_);
                        this.insertionPoint_ = visitor.visitString(hasInsertionPoint(), this.insertionPoint_, file.hasInsertionPoint(), file.insertionPoint_);
                        this.content_ = visitor.visitString(hasContent(), this.content_, file.hasContent(), file.content_);
                        if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                            this.bitField0_ |= file.bitField0_;
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
                                        String readString = codedInputStream.readString();
                                        this.bitField0_ = 1 | this.bitField0_;
                                        this.name_ = readString;
                                    } else if (readTag == 18) {
                                        String readString2 = codedInputStream.readString();
                                        this.bitField0_ |= 2;
                                        this.insertionPoint_ = readString2;
                                    } else if (readTag == 122) {
                                        String readString3 = codedInputStream.readString();
                                        this.bitField0_ |= 4;
                                        this.content_ = readString3;
                                    } else if (!a(readTag, codedInputStream)) {
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
                            synchronized (File.class) {
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

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public String getContent() {
                return this.content_;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public ByteString getContentBytes() {
                return ByteString.copyFromUtf8(this.content_);
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public String getInsertionPoint() {
                return this.insertionPoint_;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public ByteString getInsertionPointBytes() {
                return ByteString.copyFromUtf8(this.insertionPoint_);
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public String getName() {
                return this.name_;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public ByteString getNameBytes() {
                return ByteString.copyFromUtf8(this.name_);
            }

            @Override // com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.c;
                if (i != -1) {
                    return i;
                }
                int computeStringSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeStringSize(1, getName()) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    computeStringSize += CodedOutputStream.computeStringSize(2, getInsertionPoint());
                }
                if ((this.bitField0_ & 4) == 4) {
                    computeStringSize += CodedOutputStream.computeStringSize(15, getContent());
                }
                int serializedSize = computeStringSize + this.b.getSerializedSize();
                this.c = serializedSize;
                return serializedSize;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public boolean hasContent() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public boolean hasInsertionPoint() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public boolean hasName() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) {
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.writeString(1, getName());
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.writeString(2, getInsertionPoint());
                }
                if ((this.bitField0_ & 4) == 4) {
                    codedOutputStream.writeString(15, getContent());
                }
                this.b.writeTo(codedOutputStream);
            }
        }

        /* loaded from: classes2.dex */
        public interface FileOrBuilder extends MessageLiteOrBuilder {
            String getContent();

            ByteString getContentBytes();

            String getInsertionPoint();

            ByteString getInsertionPointBytes();

            String getName();

            ByteString getNameBytes();

            boolean hasContent();

            boolean hasInsertionPoint();

            boolean hasName();
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private CodeGeneratorResponse() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllFile(Iterable<? extends File> iterable) {
            ensureFileIsMutable();
            AbstractMessageLite.a(iterable, this.file_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addFile(int i, File.Builder builder) {
            ensureFileIsMutable();
            this.file_.add(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addFile(int i, File file) {
            if (file == null) {
                throw new NullPointerException();
            }
            ensureFileIsMutable();
            this.file_.add(i, file);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addFile(File.Builder builder) {
            ensureFileIsMutable();
            this.file_.add(builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addFile(File file) {
            if (file == null) {
                throw new NullPointerException();
            }
            ensureFileIsMutable();
            this.file_.add(file);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearError() {
            this.bitField0_ &= -2;
            this.error_ = getDefaultInstance().getError();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFile() {
            this.file_ = GeneratedMessageLite.f();
        }

        private void ensureFileIsMutable() {
            if (this.file_.isModifiable()) {
                return;
            }
            this.file_ = GeneratedMessageLite.a(this.file_);
        }

        public static CodeGeneratorResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CodeGeneratorResponse codeGeneratorResponse) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) codeGeneratorResponse);
        }

        public static CodeGeneratorResponse parseDelimitedFrom(InputStream inputStream) {
            return (CodeGeneratorResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static CodeGeneratorResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CodeGeneratorResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CodeGeneratorResponse parseFrom(ByteString byteString) {
            return (CodeGeneratorResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static CodeGeneratorResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (CodeGeneratorResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static CodeGeneratorResponse parseFrom(CodedInputStream codedInputStream) {
            return (CodeGeneratorResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static CodeGeneratorResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CodeGeneratorResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static CodeGeneratorResponse parseFrom(InputStream inputStream) {
            return (CodeGeneratorResponse) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static CodeGeneratorResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CodeGeneratorResponse) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CodeGeneratorResponse parseFrom(byte[] bArr) {
            return (CodeGeneratorResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static CodeGeneratorResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (CodeGeneratorResponse) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<CodeGeneratorResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeFile(int i) {
            ensureFileIsMutable();
            this.file_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setError(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 1;
            this.error_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setErrorBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 1;
            this.error_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFile(int i, File.Builder builder) {
            ensureFileIsMutable();
            this.file_.set(i, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFile(int i, File file) {
            if (file == null) {
                throw new NullPointerException();
            }
            ensureFileIsMutable();
            this.file_.set(i, file);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new CodeGeneratorResponse();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    this.file_.makeImmutable();
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    CodeGeneratorResponse codeGeneratorResponse = (CodeGeneratorResponse) obj2;
                    this.error_ = visitor.visitString(hasError(), this.error_, codeGeneratorResponse.hasError(), codeGeneratorResponse.error_);
                    this.file_ = visitor.visitList(this.file_, codeGeneratorResponse.file_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= codeGeneratorResponse.bitField0_;
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
                                        String readString = codedInputStream.readString();
                                        this.bitField0_ = 1 | this.bitField0_;
                                        this.error_ = readString;
                                    } else if (readTag == 122) {
                                        if (!this.file_.isModifiable()) {
                                            this.file_ = GeneratedMessageLite.a(this.file_);
                                        }
                                        this.file_.add((File) codedInputStream.readMessage(File.parser(), extensionRegistryLite));
                                    } else if (!a(readTag, codedInputStream)) {
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
                        synchronized (CodeGeneratorResponse.class) {
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

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public String getError() {
            return this.error_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public ByteString getErrorBytes() {
            return ByteString.copyFromUtf8(this.error_);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public File getFile(int i) {
            return this.file_.get(i);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public int getFileCount() {
            return this.file_.size();
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public List<File> getFileList() {
            return this.file_;
        }

        public FileOrBuilder getFileOrBuilder(int i) {
            return this.file_.get(i);
        }

        public List<? extends FileOrBuilder> getFileOrBuilderList() {
            return this.file_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeStringSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeStringSize(1, getError()) + 0 : 0;
            for (int i2 = 0; i2 < this.file_.size(); i2++) {
                computeStringSize += CodedOutputStream.computeMessageSize(15, this.file_.get(i2));
            }
            int serializedSize = computeStringSize + this.b.getSerializedSize();
            this.c = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public boolean hasError() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeString(1, getError());
            }
            for (int i = 0; i < this.file_.size(); i++) {
                codedOutputStream.writeMessage(15, this.file_.get(i));
            }
            this.b.writeTo(codedOutputStream);
        }
    }

    /* loaded from: classes2.dex */
    public interface CodeGeneratorResponseOrBuilder extends MessageLiteOrBuilder {
        String getError();

        ByteString getErrorBytes();

        CodeGeneratorResponse.File getFile(int i);

        int getFileCount();

        List<CodeGeneratorResponse.File> getFileList();

        boolean hasError();
    }

    /* loaded from: classes2.dex */
    public static final class Version extends GeneratedMessageLite<Version, Builder> implements VersionOrBuilder {
        private static final Version DEFAULT_INSTANCE = new Version();
        public static final int MAJOR_FIELD_NUMBER = 1;
        public static final int MINOR_FIELD_NUMBER = 2;
        private static volatile Parser<Version> PARSER = null;
        public static final int PATCH_FIELD_NUMBER = 3;
        public static final int SUFFIX_FIELD_NUMBER = 4;
        private int bitField0_;
        private int major_;
        private int minor_;
        private int patch_;
        private String suffix_ = "";

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Version, Builder> implements VersionOrBuilder {
            private Builder() {
                super(Version.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearMajor() {
                a();
                ((Version) this.a).clearMajor();
                return this;
            }

            public Builder clearMinor() {
                a();
                ((Version) this.a).clearMinor();
                return this;
            }

            public Builder clearPatch() {
                a();
                ((Version) this.a).clearPatch();
                return this;
            }

            public Builder clearSuffix() {
                a();
                ((Version) this.a).clearSuffix();
                return this;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public int getMajor() {
                return ((Version) this.a).getMajor();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public int getMinor() {
                return ((Version) this.a).getMinor();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public int getPatch() {
                return ((Version) this.a).getPatch();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public String getSuffix() {
                return ((Version) this.a).getSuffix();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public ByteString getSuffixBytes() {
                return ((Version) this.a).getSuffixBytes();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public boolean hasMajor() {
                return ((Version) this.a).hasMajor();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public boolean hasMinor() {
                return ((Version) this.a).hasMinor();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public boolean hasPatch() {
                return ((Version) this.a).hasPatch();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public boolean hasSuffix() {
                return ((Version) this.a).hasSuffix();
            }

            public Builder setMajor(int i) {
                a();
                ((Version) this.a).setMajor(i);
                return this;
            }

            public Builder setMinor(int i) {
                a();
                ((Version) this.a).setMinor(i);
                return this;
            }

            public Builder setPatch(int i) {
                a();
                ((Version) this.a).setPatch(i);
                return this;
            }

            public Builder setSuffix(String str) {
                a();
                ((Version) this.a).setSuffix(str);
                return this;
            }

            public Builder setSuffixBytes(ByteString byteString) {
                a();
                ((Version) this.a).setSuffixBytes(byteString);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private Version() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMajor() {
            this.bitField0_ &= -2;
            this.major_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMinor() {
            this.bitField0_ &= -3;
            this.minor_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPatch() {
            this.bitField0_ &= -5;
            this.patch_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSuffix() {
            this.bitField0_ &= -9;
            this.suffix_ = getDefaultInstance().getSuffix();
        }

        public static Version getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Version version) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) version);
        }

        public static Version parseDelimitedFrom(InputStream inputStream) {
            return (Version) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static Version parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Version) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Version parseFrom(ByteString byteString) {
            return (Version) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static Version parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (Version) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Version parseFrom(CodedInputStream codedInputStream) {
            return (Version) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Version parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Version) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Version parseFrom(InputStream inputStream) {
            return (Version) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static Version parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Version) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Version parseFrom(byte[] bArr) {
            return (Version) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static Version parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (Version) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<Version> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMajor(int i) {
            this.bitField0_ |= 1;
            this.major_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMinor(int i) {
            this.bitField0_ |= 2;
            this.minor_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPatch(int i) {
            this.bitField0_ |= 4;
            this.patch_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSuffix(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 8;
            this.suffix_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSuffixBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 8;
            this.suffix_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new Version();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    Version version = (Version) obj2;
                    this.major_ = visitor.visitInt(hasMajor(), this.major_, version.hasMajor(), version.major_);
                    this.minor_ = visitor.visitInt(hasMinor(), this.minor_, version.hasMinor(), version.minor_);
                    this.patch_ = visitor.visitInt(hasPatch(), this.patch_, version.hasPatch(), version.patch_);
                    this.suffix_ = visitor.visitString(hasSuffix(), this.suffix_, version.hasSuffix(), version.suffix_);
                    if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= version.bitField0_;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    boolean z = false;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    this.bitField0_ |= 1;
                                    this.major_ = codedInputStream.readInt32();
                                } else if (readTag == 16) {
                                    this.bitField0_ |= 2;
                                    this.minor_ = codedInputStream.readInt32();
                                } else if (readTag == 24) {
                                    this.bitField0_ |= 4;
                                    this.patch_ = codedInputStream.readInt32();
                                } else if (readTag == 34) {
                                    String readString = codedInputStream.readString();
                                    this.bitField0_ |= 8;
                                    this.suffix_ = readString;
                                } else if (!a(readTag, codedInputStream)) {
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
                        synchronized (Version.class) {
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

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public int getMajor() {
            return this.major_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public int getMinor() {
            return this.minor_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public int getPatch() {
            return this.patch_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeInt32Size = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.major_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeInt32Size += CodedOutputStream.computeInt32Size(2, this.minor_);
            }
            if ((this.bitField0_ & 4) == 4) {
                computeInt32Size += CodedOutputStream.computeInt32Size(3, this.patch_);
            }
            if ((this.bitField0_ & 8) == 8) {
                computeInt32Size += CodedOutputStream.computeStringSize(4, getSuffix());
            }
            int serializedSize = computeInt32Size + this.b.getSerializedSize();
            this.c = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public String getSuffix() {
            return this.suffix_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public ByteString getSuffixBytes() {
            return ByteString.copyFromUtf8(this.suffix_);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public boolean hasMajor() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public boolean hasMinor() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public boolean hasPatch() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public boolean hasSuffix() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.major_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.minor_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt32(3, this.patch_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeString(4, getSuffix());
            }
            this.b.writeTo(codedOutputStream);
        }
    }

    /* loaded from: classes2.dex */
    public interface VersionOrBuilder extends MessageLiteOrBuilder {
        int getMajor();

        int getMinor();

        int getPatch();

        String getSuffix();

        ByteString getSuffixBytes();

        boolean hasMajor();

        boolean hasMinor();

        boolean hasPatch();

        boolean hasSuffix();
    }

    private PluginProtos() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
