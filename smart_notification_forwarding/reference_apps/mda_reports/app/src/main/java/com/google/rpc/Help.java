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
public final class Help extends GeneratedMessageLite<Help, Builder> implements HelpOrBuilder {
    private static final Help DEFAULT_INSTANCE = new Help();
    public static final int LINKS_FIELD_NUMBER = 1;
    private static volatile Parser<Help> PARSER;
    private Internal.ProtobufList<Link> links_ = GeneratedMessageLite.f();

    /* renamed from: com.google.rpc.Help$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<Help, Builder> implements HelpOrBuilder {
        private Builder() {
            super(Help.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllLinks(Iterable<? extends Link> iterable) {
            a();
            ((Help) this.a).addAllLinks(iterable);
            return this;
        }

        public Builder addLinks(int i, Link.Builder builder) {
            a();
            ((Help) this.a).addLinks(i, builder);
            return this;
        }

        public Builder addLinks(int i, Link link) {
            a();
            ((Help) this.a).addLinks(i, link);
            return this;
        }

        public Builder addLinks(Link.Builder builder) {
            a();
            ((Help) this.a).addLinks(builder);
            return this;
        }

        public Builder addLinks(Link link) {
            a();
            ((Help) this.a).addLinks(link);
            return this;
        }

        public Builder clearLinks() {
            a();
            ((Help) this.a).clearLinks();
            return this;
        }

        @Override // com.google.rpc.HelpOrBuilder
        public Link getLinks(int i) {
            return ((Help) this.a).getLinks(i);
        }

        @Override // com.google.rpc.HelpOrBuilder
        public int getLinksCount() {
            return ((Help) this.a).getLinksCount();
        }

        @Override // com.google.rpc.HelpOrBuilder
        public List<Link> getLinksList() {
            return Collections.unmodifiableList(((Help) this.a).getLinksList());
        }

        public Builder removeLinks(int i) {
            a();
            ((Help) this.a).removeLinks(i);
            return this;
        }

        public Builder setLinks(int i, Link.Builder builder) {
            a();
            ((Help) this.a).setLinks(i, builder);
            return this;
        }

        public Builder setLinks(int i, Link link) {
            a();
            ((Help) this.a).setLinks(i, link);
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static final class Link extends GeneratedMessageLite<Link, Builder> implements LinkOrBuilder {
        private static final Link DEFAULT_INSTANCE = new Link();
        public static final int DESCRIPTION_FIELD_NUMBER = 1;
        private static volatile Parser<Link> PARSER = null;
        public static final int URL_FIELD_NUMBER = 2;
        private String description_ = "";
        private String url_ = "";

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Link, Builder> implements LinkOrBuilder {
            private Builder() {
                super(Link.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearDescription() {
                a();
                ((Link) this.a).clearDescription();
                return this;
            }

            public Builder clearUrl() {
                a();
                ((Link) this.a).clearUrl();
                return this;
            }

            @Override // com.google.rpc.Help.LinkOrBuilder
            public String getDescription() {
                return ((Link) this.a).getDescription();
            }

            @Override // com.google.rpc.Help.LinkOrBuilder
            public ByteString getDescriptionBytes() {
                return ((Link) this.a).getDescriptionBytes();
            }

            @Override // com.google.rpc.Help.LinkOrBuilder
            public String getUrl() {
                return ((Link) this.a).getUrl();
            }

            @Override // com.google.rpc.Help.LinkOrBuilder
            public ByteString getUrlBytes() {
                return ((Link) this.a).getUrlBytes();
            }

            public Builder setDescription(String str) {
                a();
                ((Link) this.a).setDescription(str);
                return this;
            }

            public Builder setDescriptionBytes(ByteString byteString) {
                a();
                ((Link) this.a).setDescriptionBytes(byteString);
                return this;
            }

            public Builder setUrl(String str) {
                a();
                ((Link) this.a).setUrl(str);
                return this;
            }

            public Builder setUrlBytes(ByteString byteString) {
                a();
                ((Link) this.a).setUrlBytes(byteString);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private Link() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDescription() {
            this.description_ = getDefaultInstance().getDescription();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUrl() {
            this.url_ = getDefaultInstance().getUrl();
        }

        public static Link getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Link link) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) link);
        }

        public static Link parseDelimitedFrom(InputStream inputStream) {
            return (Link) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static Link parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Link) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Link parseFrom(ByteString byteString) {
            return (Link) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static Link parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (Link) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Link parseFrom(CodedInputStream codedInputStream) {
            return (Link) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Link parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Link) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Link parseFrom(InputStream inputStream) {
            return (Link) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static Link parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Link) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Link parseFrom(byte[] bArr) {
            return (Link) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static Link parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (Link) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<Link> parser() {
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
        public void setUrl(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.url_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUrlBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.a(byteString);
            this.url_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
                case 1:
                    return new Link();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    Link link = (Link) obj2;
                    this.description_ = visitor.visitString(!this.description_.isEmpty(), this.description_, !link.description_.isEmpty(), link.description_);
                    this.url_ = visitor.visitString(!this.url_.isEmpty(), this.url_, true ^ link.url_.isEmpty(), link.url_);
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
                                    this.description_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 18) {
                                    this.url_ = codedInputStream.readStringRequireUtf8();
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
                        synchronized (Link.class) {
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

        @Override // com.google.rpc.Help.LinkOrBuilder
        public String getDescription() {
            return this.description_;
        }

        @Override // com.google.rpc.Help.LinkOrBuilder
        public ByteString getDescriptionBytes() {
            return ByteString.copyFromUtf8(this.description_);
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeStringSize = this.description_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getDescription());
            if (!this.url_.isEmpty()) {
                computeStringSize += CodedOutputStream.computeStringSize(2, getUrl());
            }
            this.c = computeStringSize;
            return computeStringSize;
        }

        @Override // com.google.rpc.Help.LinkOrBuilder
        public String getUrl() {
            return this.url_;
        }

        @Override // com.google.rpc.Help.LinkOrBuilder
        public ByteString getUrlBytes() {
            return ByteString.copyFromUtf8(this.url_);
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if (!this.description_.isEmpty()) {
                codedOutputStream.writeString(1, getDescription());
            }
            if (this.url_.isEmpty()) {
                return;
            }
            codedOutputStream.writeString(2, getUrl());
        }
    }

    /* loaded from: classes2.dex */
    public interface LinkOrBuilder extends MessageLiteOrBuilder {
        String getDescription();

        ByteString getDescriptionBytes();

        String getUrl();

        ByteString getUrlBytes();
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private Help() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllLinks(Iterable<? extends Link> iterable) {
        ensureLinksIsMutable();
        AbstractMessageLite.a(iterable, this.links_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLinks(int i, Link.Builder builder) {
        ensureLinksIsMutable();
        this.links_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLinks(int i, Link link) {
        if (link == null) {
            throw new NullPointerException();
        }
        ensureLinksIsMutable();
        this.links_.add(i, link);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLinks(Link.Builder builder) {
        ensureLinksIsMutable();
        this.links_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLinks(Link link) {
        if (link == null) {
            throw new NullPointerException();
        }
        ensureLinksIsMutable();
        this.links_.add(link);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLinks() {
        this.links_ = GeneratedMessageLite.f();
    }

    private void ensureLinksIsMutable() {
        if (this.links_.isModifiable()) {
            return;
        }
        this.links_ = GeneratedMessageLite.a(this.links_);
    }

    public static Help getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Help help) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) help);
    }

    public static Help parseDelimitedFrom(InputStream inputStream) {
        return (Help) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static Help parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Help) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Help parseFrom(ByteString byteString) {
        return (Help) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static Help parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Help) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Help parseFrom(CodedInputStream codedInputStream) {
        return (Help) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Help parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Help) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Help parseFrom(InputStream inputStream) {
        return (Help) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static Help parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Help) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Help parseFrom(byte[] bArr) {
        return (Help) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static Help parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Help) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<Help> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeLinks(int i) {
        ensureLinksIsMutable();
        this.links_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLinks(int i, Link.Builder builder) {
        ensureLinksIsMutable();
        this.links_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLinks(int i, Link link) {
        if (link == null) {
            throw new NullPointerException();
        }
        ensureLinksIsMutable();
        this.links_.set(i, link);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new Help();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.links_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                this.links_ = ((GeneratedMessageLite.Visitor) obj).visitList(this.links_, ((Help) obj2).links_);
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
                                    if (!this.links_.isModifiable()) {
                                        this.links_ = GeneratedMessageLite.a(this.links_);
                                    }
                                    this.links_.add((Link) codedInputStream.readMessage(Link.parser(), extensionRegistryLite));
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
                    synchronized (Help.class) {
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

    @Override // com.google.rpc.HelpOrBuilder
    public Link getLinks(int i) {
        return this.links_.get(i);
    }

    @Override // com.google.rpc.HelpOrBuilder
    public int getLinksCount() {
        return this.links_.size();
    }

    @Override // com.google.rpc.HelpOrBuilder
    public List<Link> getLinksList() {
        return this.links_;
    }

    public LinkOrBuilder getLinksOrBuilder(int i) {
        return this.links_.get(i);
    }

    public List<? extends LinkOrBuilder> getLinksOrBuilderList() {
        return this.links_;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.links_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(1, this.links_.get(i3));
        }
        this.c = i2;
        return i2;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        for (int i = 0; i < this.links_.size(); i++) {
            codedOutputStream.writeMessage(1, this.links_.get(i));
        }
    }
}
