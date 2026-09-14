package com.google.api;

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
public final class Page extends GeneratedMessageLite<Page, Builder> implements PageOrBuilder {
    public static final int CONTENT_FIELD_NUMBER = 2;
    private static final Page DEFAULT_INSTANCE = new Page();
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<Page> PARSER = null;
    public static final int SUBPAGES_FIELD_NUMBER = 3;
    private int bitField0_;
    private String name_ = "";
    private String content_ = "";
    private Internal.ProtobufList<Page> subpages_ = GeneratedMessageLite.f();

    /* renamed from: com.google.api.Page$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<Page, Builder> implements PageOrBuilder {
        private Builder() {
            super(Page.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllSubpages(Iterable<? extends Page> iterable) {
            a();
            ((Page) this.a).addAllSubpages(iterable);
            return this;
        }

        public Builder addSubpages(int i, Builder builder) {
            a();
            ((Page) this.a).addSubpages(i, builder);
            return this;
        }

        public Builder addSubpages(int i, Page page) {
            a();
            ((Page) this.a).addSubpages(i, page);
            return this;
        }

        public Builder addSubpages(Builder builder) {
            a();
            ((Page) this.a).addSubpages(builder);
            return this;
        }

        public Builder addSubpages(Page page) {
            a();
            ((Page) this.a).addSubpages(page);
            return this;
        }

        public Builder clearContent() {
            a();
            ((Page) this.a).clearContent();
            return this;
        }

        public Builder clearName() {
            a();
            ((Page) this.a).clearName();
            return this;
        }

        public Builder clearSubpages() {
            a();
            ((Page) this.a).clearSubpages();
            return this;
        }

        @Override // com.google.api.PageOrBuilder
        public String getContent() {
            return ((Page) this.a).getContent();
        }

        @Override // com.google.api.PageOrBuilder
        public ByteString getContentBytes() {
            return ((Page) this.a).getContentBytes();
        }

        @Override // com.google.api.PageOrBuilder
        public String getName() {
            return ((Page) this.a).getName();
        }

        @Override // com.google.api.PageOrBuilder
        public ByteString getNameBytes() {
            return ((Page) this.a).getNameBytes();
        }

        @Override // com.google.api.PageOrBuilder
        public Page getSubpages(int i) {
            return ((Page) this.a).getSubpages(i);
        }

        @Override // com.google.api.PageOrBuilder
        public int getSubpagesCount() {
            return ((Page) this.a).getSubpagesCount();
        }

        @Override // com.google.api.PageOrBuilder
        public List<Page> getSubpagesList() {
            return Collections.unmodifiableList(((Page) this.a).getSubpagesList());
        }

        public Builder removeSubpages(int i) {
            a();
            ((Page) this.a).removeSubpages(i);
            return this;
        }

        public Builder setContent(String str) {
            a();
            ((Page) this.a).setContent(str);
            return this;
        }

        public Builder setContentBytes(ByteString byteString) {
            a();
            ((Page) this.a).setContentBytes(byteString);
            return this;
        }

        public Builder setName(String str) {
            a();
            ((Page) this.a).setName(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            a();
            ((Page) this.a).setNameBytes(byteString);
            return this;
        }

        public Builder setSubpages(int i, Builder builder) {
            a();
            ((Page) this.a).setSubpages(i, builder);
            return this;
        }

        public Builder setSubpages(int i, Page page) {
            a();
            ((Page) this.a).setSubpages(i, page);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private Page() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllSubpages(Iterable<? extends Page> iterable) {
        ensureSubpagesIsMutable();
        AbstractMessageLite.a(iterable, this.subpages_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSubpages(int i, Builder builder) {
        ensureSubpagesIsMutable();
        this.subpages_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSubpages(int i, Page page) {
        if (page == null) {
            throw new NullPointerException();
        }
        ensureSubpagesIsMutable();
        this.subpages_.add(i, page);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSubpages(Builder builder) {
        ensureSubpagesIsMutable();
        this.subpages_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSubpages(Page page) {
        if (page == null) {
            throw new NullPointerException();
        }
        ensureSubpagesIsMutable();
        this.subpages_.add(page);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearContent() {
        this.content_ = getDefaultInstance().getContent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSubpages() {
        this.subpages_ = GeneratedMessageLite.f();
    }

    private void ensureSubpagesIsMutable() {
        if (this.subpages_.isModifiable()) {
            return;
        }
        this.subpages_ = GeneratedMessageLite.a(this.subpages_);
    }

    public static Page getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Page page) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) page);
    }

    public static Page parseDelimitedFrom(InputStream inputStream) {
        return (Page) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static Page parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Page) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Page parseFrom(ByteString byteString) {
        return (Page) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static Page parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Page) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Page parseFrom(CodedInputStream codedInputStream) {
        return (Page) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Page parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Page) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Page parseFrom(InputStream inputStream) {
        return (Page) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static Page parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Page) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Page parseFrom(byte[] bArr) {
        return (Page) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static Page parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Page) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<Page> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeSubpages(int i) {
        ensureSubpagesIsMutable();
        this.subpages_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setContent(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.content_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setContentBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.content_ = byteString.toStringUtf8();
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
    public void setSubpages(int i, Builder builder) {
        ensureSubpagesIsMutable();
        this.subpages_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSubpages(int i, Page page) {
        if (page == null) {
            throw new NullPointerException();
        }
        ensureSubpagesIsMutable();
        this.subpages_.set(i, page);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new Page();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.subpages_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Page page = (Page) obj2;
                this.name_ = visitor.visitString(!this.name_.isEmpty(), this.name_, !page.name_.isEmpty(), page.name_);
                this.content_ = visitor.visitString(!this.content_.isEmpty(), this.content_, true ^ page.content_.isEmpty(), page.content_);
                this.subpages_ = visitor.visitList(this.subpages_, page.subpages_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= page.bitField0_;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                boolean z = false;
                while (!z) {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.name_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                this.content_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 26) {
                                if (!this.subpages_.isModifiable()) {
                                    this.subpages_ = GeneratedMessageLite.a(this.subpages_);
                                }
                                this.subpages_.add((Page) codedInputStream.readMessage(parser(), extensionRegistryLite));
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
                    synchronized (Page.class) {
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

    @Override // com.google.api.PageOrBuilder
    public String getContent() {
        return this.content_;
    }

    @Override // com.google.api.PageOrBuilder
    public ByteString getContentBytes() {
        return ByteString.copyFromUtf8(this.content_);
    }

    @Override // com.google.api.PageOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // com.google.api.PageOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeStringSize = !this.name_.isEmpty() ? CodedOutputStream.computeStringSize(1, getName()) + 0 : 0;
        if (!this.content_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(2, getContent());
        }
        for (int i2 = 0; i2 < this.subpages_.size(); i2++) {
            computeStringSize += CodedOutputStream.computeMessageSize(3, this.subpages_.get(i2));
        }
        this.c = computeStringSize;
        return computeStringSize;
    }

    @Override // com.google.api.PageOrBuilder
    public Page getSubpages(int i) {
        return this.subpages_.get(i);
    }

    @Override // com.google.api.PageOrBuilder
    public int getSubpagesCount() {
        return this.subpages_.size();
    }

    @Override // com.google.api.PageOrBuilder
    public List<Page> getSubpagesList() {
        return this.subpages_;
    }

    public PageOrBuilder getSubpagesOrBuilder(int i) {
        return this.subpages_.get(i);
    }

    public List<? extends PageOrBuilder> getSubpagesOrBuilderList() {
        return this.subpages_;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!this.name_.isEmpty()) {
            codedOutputStream.writeString(1, getName());
        }
        if (!this.content_.isEmpty()) {
            codedOutputStream.writeString(2, getContent());
        }
        for (int i = 0; i < this.subpages_.size(); i++) {
            codedOutputStream.writeMessage(3, this.subpages_.get(i));
        }
    }
}
