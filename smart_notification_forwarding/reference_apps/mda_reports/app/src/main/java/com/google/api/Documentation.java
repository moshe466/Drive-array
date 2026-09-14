package com.google.api;

import com.google.api.DocumentationRule;
import com.google.api.Page;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class Documentation extends GeneratedMessageLite<Documentation, Builder> implements DocumentationOrBuilder {
    private static final Documentation DEFAULT_INSTANCE = new Documentation();
    public static final int DOCUMENTATION_ROOT_URL_FIELD_NUMBER = 4;
    public static final int OVERVIEW_FIELD_NUMBER = 2;
    public static final int PAGES_FIELD_NUMBER = 5;
    private static volatile Parser<Documentation> PARSER = null;
    public static final int RULES_FIELD_NUMBER = 3;
    public static final int SUMMARY_FIELD_NUMBER = 1;
    private int bitField0_;
    private String summary_ = "";
    private Internal.ProtobufList<Page> pages_ = GeneratedMessageLite.f();
    private Internal.ProtobufList<DocumentationRule> rules_ = GeneratedMessageLite.f();
    private String documentationRootUrl_ = "";
    private String overview_ = "";

    /* renamed from: com.google.api.Documentation$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<Documentation, Builder> implements DocumentationOrBuilder {
        private Builder() {
            super(Documentation.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllPages(Iterable<? extends Page> iterable) {
            a();
            ((Documentation) this.a).addAllPages(iterable);
            return this;
        }

        public Builder addAllRules(Iterable<? extends DocumentationRule> iterable) {
            a();
            ((Documentation) this.a).addAllRules(iterable);
            return this;
        }

        public Builder addPages(int i, Page.Builder builder) {
            a();
            ((Documentation) this.a).addPages(i, builder);
            return this;
        }

        public Builder addPages(int i, Page page) {
            a();
            ((Documentation) this.a).addPages(i, page);
            return this;
        }

        public Builder addPages(Page.Builder builder) {
            a();
            ((Documentation) this.a).addPages(builder);
            return this;
        }

        public Builder addPages(Page page) {
            a();
            ((Documentation) this.a).addPages(page);
            return this;
        }

        public Builder addRules(int i, DocumentationRule.Builder builder) {
            a();
            ((Documentation) this.a).addRules(i, builder);
            return this;
        }

        public Builder addRules(int i, DocumentationRule documentationRule) {
            a();
            ((Documentation) this.a).addRules(i, documentationRule);
            return this;
        }

        public Builder addRules(DocumentationRule.Builder builder) {
            a();
            ((Documentation) this.a).addRules(builder);
            return this;
        }

        public Builder addRules(DocumentationRule documentationRule) {
            a();
            ((Documentation) this.a).addRules(documentationRule);
            return this;
        }

        public Builder clearDocumentationRootUrl() {
            a();
            ((Documentation) this.a).clearDocumentationRootUrl();
            return this;
        }

        public Builder clearOverview() {
            a();
            ((Documentation) this.a).clearOverview();
            return this;
        }

        public Builder clearPages() {
            a();
            ((Documentation) this.a).clearPages();
            return this;
        }

        public Builder clearRules() {
            a();
            ((Documentation) this.a).clearRules();
            return this;
        }

        public Builder clearSummary() {
            a();
            ((Documentation) this.a).clearSummary();
            return this;
        }

        @Override // com.google.api.DocumentationOrBuilder
        public String getDocumentationRootUrl() {
            return ((Documentation) this.a).getDocumentationRootUrl();
        }

        @Override // com.google.api.DocumentationOrBuilder
        public ByteString getDocumentationRootUrlBytes() {
            return ((Documentation) this.a).getDocumentationRootUrlBytes();
        }

        @Override // com.google.api.DocumentationOrBuilder
        public String getOverview() {
            return ((Documentation) this.a).getOverview();
        }

        @Override // com.google.api.DocumentationOrBuilder
        public ByteString getOverviewBytes() {
            return ((Documentation) this.a).getOverviewBytes();
        }

        @Override // com.google.api.DocumentationOrBuilder
        public Page getPages(int i) {
            return ((Documentation) this.a).getPages(i);
        }

        @Override // com.google.api.DocumentationOrBuilder
        public int getPagesCount() {
            return ((Documentation) this.a).getPagesCount();
        }

        @Override // com.google.api.DocumentationOrBuilder
        public List<Page> getPagesList() {
            return Collections.unmodifiableList(((Documentation) this.a).getPagesList());
        }

        @Override // com.google.api.DocumentationOrBuilder
        public DocumentationRule getRules(int i) {
            return ((Documentation) this.a).getRules(i);
        }

        @Override // com.google.api.DocumentationOrBuilder
        public int getRulesCount() {
            return ((Documentation) this.a).getRulesCount();
        }

        @Override // com.google.api.DocumentationOrBuilder
        public List<DocumentationRule> getRulesList() {
            return Collections.unmodifiableList(((Documentation) this.a).getRulesList());
        }

        @Override // com.google.api.DocumentationOrBuilder
        public String getSummary() {
            return ((Documentation) this.a).getSummary();
        }

        @Override // com.google.api.DocumentationOrBuilder
        public ByteString getSummaryBytes() {
            return ((Documentation) this.a).getSummaryBytes();
        }

        public Builder removePages(int i) {
            a();
            ((Documentation) this.a).removePages(i);
            return this;
        }

        public Builder removeRules(int i) {
            a();
            ((Documentation) this.a).removeRules(i);
            return this;
        }

        public Builder setDocumentationRootUrl(String str) {
            a();
            ((Documentation) this.a).setDocumentationRootUrl(str);
            return this;
        }

        public Builder setDocumentationRootUrlBytes(ByteString byteString) {
            a();
            ((Documentation) this.a).setDocumentationRootUrlBytes(byteString);
            return this;
        }

        public Builder setOverview(String str) {
            a();
            ((Documentation) this.a).setOverview(str);
            return this;
        }

        public Builder setOverviewBytes(ByteString byteString) {
            a();
            ((Documentation) this.a).setOverviewBytes(byteString);
            return this;
        }

        public Builder setPages(int i, Page.Builder builder) {
            a();
            ((Documentation) this.a).setPages(i, builder);
            return this;
        }

        public Builder setPages(int i, Page page) {
            a();
            ((Documentation) this.a).setPages(i, page);
            return this;
        }

        public Builder setRules(int i, DocumentationRule.Builder builder) {
            a();
            ((Documentation) this.a).setRules(i, builder);
            return this;
        }

        public Builder setRules(int i, DocumentationRule documentationRule) {
            a();
            ((Documentation) this.a).setRules(i, documentationRule);
            return this;
        }

        public Builder setSummary(String str) {
            a();
            ((Documentation) this.a).setSummary(str);
            return this;
        }

        public Builder setSummaryBytes(ByteString byteString) {
            a();
            ((Documentation) this.a).setSummaryBytes(byteString);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private Documentation() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllPages(Iterable<? extends Page> iterable) {
        ensurePagesIsMutable();
        AbstractMessageLite.a(iterable, this.pages_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllRules(Iterable<? extends DocumentationRule> iterable) {
        ensureRulesIsMutable();
        AbstractMessageLite.a(iterable, this.rules_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPages(int i, Page.Builder builder) {
        ensurePagesIsMutable();
        this.pages_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPages(int i, Page page) {
        if (page == null) {
            throw new NullPointerException();
        }
        ensurePagesIsMutable();
        this.pages_.add(i, page);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPages(Page.Builder builder) {
        ensurePagesIsMutable();
        this.pages_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPages(Page page) {
        if (page == null) {
            throw new NullPointerException();
        }
        ensurePagesIsMutable();
        this.pages_.add(page);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRules(int i, DocumentationRule.Builder builder) {
        ensureRulesIsMutable();
        this.rules_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRules(int i, DocumentationRule documentationRule) {
        if (documentationRule == null) {
            throw new NullPointerException();
        }
        ensureRulesIsMutable();
        this.rules_.add(i, documentationRule);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRules(DocumentationRule.Builder builder) {
        ensureRulesIsMutable();
        this.rules_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRules(DocumentationRule documentationRule) {
        if (documentationRule == null) {
            throw new NullPointerException();
        }
        ensureRulesIsMutable();
        this.rules_.add(documentationRule);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDocumentationRootUrl() {
        this.documentationRootUrl_ = getDefaultInstance().getDocumentationRootUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOverview() {
        this.overview_ = getDefaultInstance().getOverview();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPages() {
        this.pages_ = GeneratedMessageLite.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRules() {
        this.rules_ = GeneratedMessageLite.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSummary() {
        this.summary_ = getDefaultInstance().getSummary();
    }

    private void ensurePagesIsMutable() {
        if (this.pages_.isModifiable()) {
            return;
        }
        this.pages_ = GeneratedMessageLite.a(this.pages_);
    }

    private void ensureRulesIsMutable() {
        if (this.rules_.isModifiable()) {
            return;
        }
        this.rules_ = GeneratedMessageLite.a(this.rules_);
    }

    public static Documentation getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Documentation documentation) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) documentation);
    }

    public static Documentation parseDelimitedFrom(InputStream inputStream) {
        return (Documentation) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static Documentation parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Documentation) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Documentation parseFrom(ByteString byteString) {
        return (Documentation) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static Documentation parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Documentation) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Documentation parseFrom(CodedInputStream codedInputStream) {
        return (Documentation) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Documentation parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Documentation) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Documentation parseFrom(InputStream inputStream) {
        return (Documentation) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static Documentation parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Documentation) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Documentation parseFrom(byte[] bArr) {
        return (Documentation) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static Documentation parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Documentation) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<Documentation> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removePages(int i) {
        ensurePagesIsMutable();
        this.pages_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeRules(int i) {
        ensureRulesIsMutable();
        this.rules_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDocumentationRootUrl(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.documentationRootUrl_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDocumentationRootUrlBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.documentationRootUrl_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOverview(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.overview_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOverviewBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.overview_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPages(int i, Page.Builder builder) {
        ensurePagesIsMutable();
        this.pages_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPages(int i, Page page) {
        if (page == null) {
            throw new NullPointerException();
        }
        ensurePagesIsMutable();
        this.pages_.set(i, page);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRules(int i, DocumentationRule.Builder builder) {
        ensureRulesIsMutable();
        this.rules_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRules(int i, DocumentationRule documentationRule) {
        if (documentationRule == null) {
            throw new NullPointerException();
        }
        ensureRulesIsMutable();
        this.rules_.set(i, documentationRule);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSummary(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.summary_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSummaryBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.summary_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        List list;
        MessageLite messageLite;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new Documentation();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.pages_.makeImmutable();
                this.rules_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                Documentation documentation = (Documentation) obj2;
                this.summary_ = visitor.visitString(!this.summary_.isEmpty(), this.summary_, !documentation.summary_.isEmpty(), documentation.summary_);
                this.pages_ = visitor.visitList(this.pages_, documentation.pages_);
                this.rules_ = visitor.visitList(this.rules_, documentation.rules_);
                this.documentationRootUrl_ = visitor.visitString(!this.documentationRootUrl_.isEmpty(), this.documentationRootUrl_, !documentation.documentationRootUrl_.isEmpty(), documentation.documentationRootUrl_);
                this.overview_ = visitor.visitString(!this.overview_.isEmpty(), this.overview_, true ^ documentation.overview_.isEmpty(), documentation.overview_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= documentation.bitField0_;
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
                                this.summary_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag != 18) {
                                if (readTag == 26) {
                                    if (!this.rules_.isModifiable()) {
                                        this.rules_ = GeneratedMessageLite.a(this.rules_);
                                    }
                                    list = this.rules_;
                                    messageLite = (DocumentationRule) codedInputStream.readMessage(DocumentationRule.parser(), extensionRegistryLite);
                                } else if (readTag == 34) {
                                    this.documentationRootUrl_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 42) {
                                    if (!this.pages_.isModifiable()) {
                                        this.pages_ = GeneratedMessageLite.a(this.pages_);
                                    }
                                    list = this.pages_;
                                    messageLite = (Page) codedInputStream.readMessage(Page.parser(), extensionRegistryLite);
                                } else if (!codedInputStream.skipField(readTag)) {
                                }
                                list.add(messageLite);
                            } else {
                                this.overview_ = codedInputStream.readStringRequireUtf8();
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
                    synchronized (Documentation.class) {
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

    @Override // com.google.api.DocumentationOrBuilder
    public String getDocumentationRootUrl() {
        return this.documentationRootUrl_;
    }

    @Override // com.google.api.DocumentationOrBuilder
    public ByteString getDocumentationRootUrlBytes() {
        return ByteString.copyFromUtf8(this.documentationRootUrl_);
    }

    @Override // com.google.api.DocumentationOrBuilder
    public String getOverview() {
        return this.overview_;
    }

    @Override // com.google.api.DocumentationOrBuilder
    public ByteString getOverviewBytes() {
        return ByteString.copyFromUtf8(this.overview_);
    }

    @Override // com.google.api.DocumentationOrBuilder
    public Page getPages(int i) {
        return this.pages_.get(i);
    }

    @Override // com.google.api.DocumentationOrBuilder
    public int getPagesCount() {
        return this.pages_.size();
    }

    @Override // com.google.api.DocumentationOrBuilder
    public List<Page> getPagesList() {
        return this.pages_;
    }

    public PageOrBuilder getPagesOrBuilder(int i) {
        return this.pages_.get(i);
    }

    public List<? extends PageOrBuilder> getPagesOrBuilderList() {
        return this.pages_;
    }

    @Override // com.google.api.DocumentationOrBuilder
    public DocumentationRule getRules(int i) {
        return this.rules_.get(i);
    }

    @Override // com.google.api.DocumentationOrBuilder
    public int getRulesCount() {
        return this.rules_.size();
    }

    @Override // com.google.api.DocumentationOrBuilder
    public List<DocumentationRule> getRulesList() {
        return this.rules_;
    }

    public DocumentationRuleOrBuilder getRulesOrBuilder(int i) {
        return this.rules_.get(i);
    }

    public List<? extends DocumentationRuleOrBuilder> getRulesOrBuilderList() {
        return this.rules_;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int computeStringSize = !this.summary_.isEmpty() ? CodedOutputStream.computeStringSize(1, getSummary()) + 0 : 0;
        if (!this.overview_.isEmpty()) {
            computeStringSize += CodedOutputStream.computeStringSize(2, getOverview());
        }
        int i2 = computeStringSize;
        for (int i3 = 0; i3 < this.rules_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(3, this.rules_.get(i3));
        }
        if (!this.documentationRootUrl_.isEmpty()) {
            i2 += CodedOutputStream.computeStringSize(4, getDocumentationRootUrl());
        }
        for (int i4 = 0; i4 < this.pages_.size(); i4++) {
            i2 += CodedOutputStream.computeMessageSize(5, this.pages_.get(i4));
        }
        this.c = i2;
        return i2;
    }

    @Override // com.google.api.DocumentationOrBuilder
    public String getSummary() {
        return this.summary_;
    }

    @Override // com.google.api.DocumentationOrBuilder
    public ByteString getSummaryBytes() {
        return ByteString.copyFromUtf8(this.summary_);
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        if (!this.summary_.isEmpty()) {
            codedOutputStream.writeString(1, getSummary());
        }
        if (!this.overview_.isEmpty()) {
            codedOutputStream.writeString(2, getOverview());
        }
        for (int i = 0; i < this.rules_.size(); i++) {
            codedOutputStream.writeMessage(3, this.rules_.get(i));
        }
        if (!this.documentationRootUrl_.isEmpty()) {
            codedOutputStream.writeString(4, getDocumentationRootUrl());
        }
        for (int i2 = 0; i2 < this.pages_.size(); i2++) {
            codedOutputStream.writeMessage(5, this.pages_.get(i2));
        }
    }
}
