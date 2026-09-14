package com.google.type;

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
public final class PostalAddress extends GeneratedMessageLite<PostalAddress, Builder> implements PostalAddressOrBuilder {
    public static final int ADDRESS_LINES_FIELD_NUMBER = 9;
    public static final int ADMINISTRATIVE_AREA_FIELD_NUMBER = 6;
    private static final PostalAddress DEFAULT_INSTANCE = new PostalAddress();
    public static final int LANGUAGE_CODE_FIELD_NUMBER = 3;
    public static final int LOCALITY_FIELD_NUMBER = 7;
    public static final int ORGANIZATION_FIELD_NUMBER = 11;
    private static volatile Parser<PostalAddress> PARSER = null;
    public static final int POSTAL_CODE_FIELD_NUMBER = 4;
    public static final int RECIPIENTS_FIELD_NUMBER = 10;
    public static final int REGION_CODE_FIELD_NUMBER = 2;
    public static final int REVISION_FIELD_NUMBER = 1;
    public static final int SORTING_CODE_FIELD_NUMBER = 5;
    public static final int SUBLOCALITY_FIELD_NUMBER = 8;
    private int bitField0_;
    private int revision_;
    private String regionCode_ = "";
    private String languageCode_ = "";
    private String postalCode_ = "";
    private String sortingCode_ = "";
    private String administrativeArea_ = "";
    private String locality_ = "";
    private String sublocality_ = "";
    private Internal.ProtobufList<String> addressLines_ = GeneratedMessageLite.f();
    private Internal.ProtobufList<String> recipients_ = GeneratedMessageLite.f();
    private String organization_ = "";

    /* renamed from: com.google.type.PostalAddress$1, reason: invalid class name */
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
    public static final class Builder extends GeneratedMessageLite.Builder<PostalAddress, Builder> implements PostalAddressOrBuilder {
        private Builder() {
            super(PostalAddress.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAddressLines(String str) {
            a();
            ((PostalAddress) this.a).addAddressLines(str);
            return this;
        }

        public Builder addAddressLinesBytes(ByteString byteString) {
            a();
            ((PostalAddress) this.a).addAddressLinesBytes(byteString);
            return this;
        }

        public Builder addAllAddressLines(Iterable<String> iterable) {
            a();
            ((PostalAddress) this.a).addAllAddressLines(iterable);
            return this;
        }

        public Builder addAllRecipients(Iterable<String> iterable) {
            a();
            ((PostalAddress) this.a).addAllRecipients(iterable);
            return this;
        }

        public Builder addRecipients(String str) {
            a();
            ((PostalAddress) this.a).addRecipients(str);
            return this;
        }

        public Builder addRecipientsBytes(ByteString byteString) {
            a();
            ((PostalAddress) this.a).addRecipientsBytes(byteString);
            return this;
        }

        public Builder clearAddressLines() {
            a();
            ((PostalAddress) this.a).clearAddressLines();
            return this;
        }

        public Builder clearAdministrativeArea() {
            a();
            ((PostalAddress) this.a).clearAdministrativeArea();
            return this;
        }

        public Builder clearLanguageCode() {
            a();
            ((PostalAddress) this.a).clearLanguageCode();
            return this;
        }

        public Builder clearLocality() {
            a();
            ((PostalAddress) this.a).clearLocality();
            return this;
        }

        public Builder clearOrganization() {
            a();
            ((PostalAddress) this.a).clearOrganization();
            return this;
        }

        public Builder clearPostalCode() {
            a();
            ((PostalAddress) this.a).clearPostalCode();
            return this;
        }

        public Builder clearRecipients() {
            a();
            ((PostalAddress) this.a).clearRecipients();
            return this;
        }

        public Builder clearRegionCode() {
            a();
            ((PostalAddress) this.a).clearRegionCode();
            return this;
        }

        public Builder clearRevision() {
            a();
            ((PostalAddress) this.a).clearRevision();
            return this;
        }

        public Builder clearSortingCode() {
            a();
            ((PostalAddress) this.a).clearSortingCode();
            return this;
        }

        public Builder clearSublocality() {
            a();
            ((PostalAddress) this.a).clearSublocality();
            return this;
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public String getAddressLines(int i) {
            return ((PostalAddress) this.a).getAddressLines(i);
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getAddressLinesBytes(int i) {
            return ((PostalAddress) this.a).getAddressLinesBytes(i);
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public int getAddressLinesCount() {
            return ((PostalAddress) this.a).getAddressLinesCount();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public List<String> getAddressLinesList() {
            return Collections.unmodifiableList(((PostalAddress) this.a).getAddressLinesList());
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public String getAdministrativeArea() {
            return ((PostalAddress) this.a).getAdministrativeArea();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getAdministrativeAreaBytes() {
            return ((PostalAddress) this.a).getAdministrativeAreaBytes();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public String getLanguageCode() {
            return ((PostalAddress) this.a).getLanguageCode();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getLanguageCodeBytes() {
            return ((PostalAddress) this.a).getLanguageCodeBytes();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public String getLocality() {
            return ((PostalAddress) this.a).getLocality();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getLocalityBytes() {
            return ((PostalAddress) this.a).getLocalityBytes();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public String getOrganization() {
            return ((PostalAddress) this.a).getOrganization();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getOrganizationBytes() {
            return ((PostalAddress) this.a).getOrganizationBytes();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public String getPostalCode() {
            return ((PostalAddress) this.a).getPostalCode();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getPostalCodeBytes() {
            return ((PostalAddress) this.a).getPostalCodeBytes();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public String getRecipients(int i) {
            return ((PostalAddress) this.a).getRecipients(i);
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getRecipientsBytes(int i) {
            return ((PostalAddress) this.a).getRecipientsBytes(i);
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public int getRecipientsCount() {
            return ((PostalAddress) this.a).getRecipientsCount();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public List<String> getRecipientsList() {
            return Collections.unmodifiableList(((PostalAddress) this.a).getRecipientsList());
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public String getRegionCode() {
            return ((PostalAddress) this.a).getRegionCode();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getRegionCodeBytes() {
            return ((PostalAddress) this.a).getRegionCodeBytes();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public int getRevision() {
            return ((PostalAddress) this.a).getRevision();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public String getSortingCode() {
            return ((PostalAddress) this.a).getSortingCode();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getSortingCodeBytes() {
            return ((PostalAddress) this.a).getSortingCodeBytes();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public String getSublocality() {
            return ((PostalAddress) this.a).getSublocality();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getSublocalityBytes() {
            return ((PostalAddress) this.a).getSublocalityBytes();
        }

        public Builder setAddressLines(int i, String str) {
            a();
            ((PostalAddress) this.a).setAddressLines(i, str);
            return this;
        }

        public Builder setAdministrativeArea(String str) {
            a();
            ((PostalAddress) this.a).setAdministrativeArea(str);
            return this;
        }

        public Builder setAdministrativeAreaBytes(ByteString byteString) {
            a();
            ((PostalAddress) this.a).setAdministrativeAreaBytes(byteString);
            return this;
        }

        public Builder setLanguageCode(String str) {
            a();
            ((PostalAddress) this.a).setLanguageCode(str);
            return this;
        }

        public Builder setLanguageCodeBytes(ByteString byteString) {
            a();
            ((PostalAddress) this.a).setLanguageCodeBytes(byteString);
            return this;
        }

        public Builder setLocality(String str) {
            a();
            ((PostalAddress) this.a).setLocality(str);
            return this;
        }

        public Builder setLocalityBytes(ByteString byteString) {
            a();
            ((PostalAddress) this.a).setLocalityBytes(byteString);
            return this;
        }

        public Builder setOrganization(String str) {
            a();
            ((PostalAddress) this.a).setOrganization(str);
            return this;
        }

        public Builder setOrganizationBytes(ByteString byteString) {
            a();
            ((PostalAddress) this.a).setOrganizationBytes(byteString);
            return this;
        }

        public Builder setPostalCode(String str) {
            a();
            ((PostalAddress) this.a).setPostalCode(str);
            return this;
        }

        public Builder setPostalCodeBytes(ByteString byteString) {
            a();
            ((PostalAddress) this.a).setPostalCodeBytes(byteString);
            return this;
        }

        public Builder setRecipients(int i, String str) {
            a();
            ((PostalAddress) this.a).setRecipients(i, str);
            return this;
        }

        public Builder setRegionCode(String str) {
            a();
            ((PostalAddress) this.a).setRegionCode(str);
            return this;
        }

        public Builder setRegionCodeBytes(ByteString byteString) {
            a();
            ((PostalAddress) this.a).setRegionCodeBytes(byteString);
            return this;
        }

        public Builder setRevision(int i) {
            a();
            ((PostalAddress) this.a).setRevision(i);
            return this;
        }

        public Builder setSortingCode(String str) {
            a();
            ((PostalAddress) this.a).setSortingCode(str);
            return this;
        }

        public Builder setSortingCodeBytes(ByteString byteString) {
            a();
            ((PostalAddress) this.a).setSortingCodeBytes(byteString);
            return this;
        }

        public Builder setSublocality(String str) {
            a();
            ((PostalAddress) this.a).setSublocality(str);
            return this;
        }

        public Builder setSublocalityBytes(ByteString byteString) {
            a();
            ((PostalAddress) this.a).setSublocalityBytes(byteString);
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE.b();
    }

    private PostalAddress() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAddressLines(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        ensureAddressLinesIsMutable();
        this.addressLines_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAddressLinesBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        ensureAddressLinesIsMutable();
        this.addressLines_.add(byteString.toStringUtf8());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllAddressLines(Iterable<String> iterable) {
        ensureAddressLinesIsMutable();
        AbstractMessageLite.a(iterable, this.addressLines_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllRecipients(Iterable<String> iterable) {
        ensureRecipientsIsMutable();
        AbstractMessageLite.a(iterable, this.recipients_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRecipients(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        ensureRecipientsIsMutable();
        this.recipients_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRecipientsBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        ensureRecipientsIsMutable();
        this.recipients_.add(byteString.toStringUtf8());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAddressLines() {
        this.addressLines_ = GeneratedMessageLite.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAdministrativeArea() {
        this.administrativeArea_ = getDefaultInstance().getAdministrativeArea();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLanguageCode() {
        this.languageCode_ = getDefaultInstance().getLanguageCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLocality() {
        this.locality_ = getDefaultInstance().getLocality();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOrganization() {
        this.organization_ = getDefaultInstance().getOrganization();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPostalCode() {
        this.postalCode_ = getDefaultInstance().getPostalCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRecipients() {
        this.recipients_ = GeneratedMessageLite.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRegionCode() {
        this.regionCode_ = getDefaultInstance().getRegionCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRevision() {
        this.revision_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSortingCode() {
        this.sortingCode_ = getDefaultInstance().getSortingCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSublocality() {
        this.sublocality_ = getDefaultInstance().getSublocality();
    }

    private void ensureAddressLinesIsMutable() {
        if (this.addressLines_.isModifiable()) {
            return;
        }
        this.addressLines_ = GeneratedMessageLite.a(this.addressLines_);
    }

    private void ensureRecipientsIsMutable() {
        if (this.recipients_.isModifiable()) {
            return;
        }
        this.recipients_ = GeneratedMessageLite.a(this.recipients_);
    }

    public static PostalAddress getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(PostalAddress postalAddress) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) postalAddress);
    }

    public static PostalAddress parseDelimitedFrom(InputStream inputStream) {
        return (PostalAddress) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
    }

    public static PostalAddress parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PostalAddress) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PostalAddress parseFrom(ByteString byteString) {
        return (PostalAddress) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
    }

    public static PostalAddress parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (PostalAddress) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static PostalAddress parseFrom(CodedInputStream codedInputStream) {
        return (PostalAddress) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
    }

    public static PostalAddress parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PostalAddress) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static PostalAddress parseFrom(InputStream inputStream) {
        return (PostalAddress) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
    }

    public static PostalAddress parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PostalAddress) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PostalAddress parseFrom(byte[] bArr) {
        return (PostalAddress) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
    }

    public static PostalAddress parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (PostalAddress) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<PostalAddress> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAddressLines(int i, String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        ensureAddressLinesIsMutable();
        this.addressLines_.set(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdministrativeArea(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.administrativeArea_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdministrativeAreaBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.administrativeArea_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLanguageCode(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.languageCode_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLanguageCodeBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.languageCode_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLocality(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.locality_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLocalityBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.locality_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOrganization(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.organization_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOrganizationBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.organization_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPostalCode(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.postalCode_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPostalCodeBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.postalCode_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRecipients(int i, String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        ensureRecipientsIsMutable();
        this.recipients_.set(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRegionCode(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.regionCode_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRegionCodeBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.regionCode_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRevision(int i) {
        this.revision_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSortingCode(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.sortingCode_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSortingCodeBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.sortingCode_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSublocality(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.sublocality_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSublocalityBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        AbstractMessageLite.a(byteString);
        this.sublocality_ = byteString.toStringUtf8();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:26:0x003a. Please report as an issue. */
    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        String readStringRequireUtf8;
        Internal.ProtobufList<String> protobufList;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.a[methodToInvoke.ordinal()]) {
            case 1:
                return new PostalAddress();
            case 2:
                return DEFAULT_INSTANCE;
            case 3:
                this.addressLines_.makeImmutable();
                this.recipients_.makeImmutable();
                return null;
            case 4:
                return new Builder(anonymousClass1);
            case 5:
                GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                PostalAddress postalAddress = (PostalAddress) obj2;
                this.revision_ = visitor.visitInt(this.revision_ != 0, this.revision_, postalAddress.revision_ != 0, postalAddress.revision_);
                this.regionCode_ = visitor.visitString(!this.regionCode_.isEmpty(), this.regionCode_, !postalAddress.regionCode_.isEmpty(), postalAddress.regionCode_);
                this.languageCode_ = visitor.visitString(!this.languageCode_.isEmpty(), this.languageCode_, !postalAddress.languageCode_.isEmpty(), postalAddress.languageCode_);
                this.postalCode_ = visitor.visitString(!this.postalCode_.isEmpty(), this.postalCode_, !postalAddress.postalCode_.isEmpty(), postalAddress.postalCode_);
                this.sortingCode_ = visitor.visitString(!this.sortingCode_.isEmpty(), this.sortingCode_, !postalAddress.sortingCode_.isEmpty(), postalAddress.sortingCode_);
                this.administrativeArea_ = visitor.visitString(!this.administrativeArea_.isEmpty(), this.administrativeArea_, !postalAddress.administrativeArea_.isEmpty(), postalAddress.administrativeArea_);
                this.locality_ = visitor.visitString(!this.locality_.isEmpty(), this.locality_, !postalAddress.locality_.isEmpty(), postalAddress.locality_);
                this.sublocality_ = visitor.visitString(!this.sublocality_.isEmpty(), this.sublocality_, !postalAddress.sublocality_.isEmpty(), postalAddress.sublocality_);
                this.addressLines_ = visitor.visitList(this.addressLines_, postalAddress.addressLines_);
                this.recipients_ = visitor.visitList(this.recipients_, postalAddress.recipients_);
                this.organization_ = visitor.visitString(!this.organization_.isEmpty(), this.organization_, !postalAddress.organization_.isEmpty(), postalAddress.organization_);
                if (visitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                    this.bitField0_ |= postalAddress.bitField0_;
                }
                return this;
            case 6:
                CodedInputStream codedInputStream = (CodedInputStream) obj;
                while (!r1) {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            switch (readTag) {
                                case 0:
                                    r1 = true;
                                case 8:
                                    this.revision_ = codedInputStream.readInt32();
                                case 18:
                                    this.regionCode_ = codedInputStream.readStringRequireUtf8();
                                case 26:
                                    this.languageCode_ = codedInputStream.readStringRequireUtf8();
                                case 34:
                                    this.postalCode_ = codedInputStream.readStringRequireUtf8();
                                case 42:
                                    this.sortingCode_ = codedInputStream.readStringRequireUtf8();
                                case 50:
                                    this.administrativeArea_ = codedInputStream.readStringRequireUtf8();
                                case 58:
                                    this.locality_ = codedInputStream.readStringRequireUtf8();
                                case 66:
                                    this.sublocality_ = codedInputStream.readStringRequireUtf8();
                                case 74:
                                    readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                    if (!this.addressLines_.isModifiable()) {
                                        this.addressLines_ = GeneratedMessageLite.a(this.addressLines_);
                                    }
                                    protobufList = this.addressLines_;
                                    protobufList.add(readStringRequireUtf8);
                                case 82:
                                    readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                    if (!this.recipients_.isModifiable()) {
                                        this.recipients_ = GeneratedMessageLite.a(this.recipients_);
                                    }
                                    protobufList = this.recipients_;
                                    protobufList.add(readStringRequireUtf8);
                                case 90:
                                    this.organization_ = codedInputStream.readStringRequireUtf8();
                                default:
                                    if (!codedInputStream.skipField(readTag)) {
                                        r1 = true;
                                    }
                            }
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
                    synchronized (PostalAddress.class) {
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

    @Override // com.google.type.PostalAddressOrBuilder
    public String getAddressLines(int i) {
        return this.addressLines_.get(i);
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getAddressLinesBytes(int i) {
        return ByteString.copyFromUtf8(this.addressLines_.get(i));
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public int getAddressLinesCount() {
        return this.addressLines_.size();
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public List<String> getAddressLinesList() {
        return this.addressLines_;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public String getAdministrativeArea() {
        return this.administrativeArea_;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getAdministrativeAreaBytes() {
        return ByteString.copyFromUtf8(this.administrativeArea_);
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public String getLanguageCode() {
        return this.languageCode_;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getLanguageCodeBytes() {
        return ByteString.copyFromUtf8(this.languageCode_);
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public String getLocality() {
        return this.locality_;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getLocalityBytes() {
        return ByteString.copyFromUtf8(this.locality_);
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public String getOrganization() {
        return this.organization_;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getOrganizationBytes() {
        return ByteString.copyFromUtf8(this.organization_);
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public String getPostalCode() {
        return this.postalCode_;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getPostalCodeBytes() {
        return ByteString.copyFromUtf8(this.postalCode_);
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public String getRecipients(int i) {
        return this.recipients_.get(i);
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getRecipientsBytes(int i) {
        return ByteString.copyFromUtf8(this.recipients_.get(i));
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public int getRecipientsCount() {
        return this.recipients_.size();
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public List<String> getRecipientsList() {
        return this.recipients_;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public String getRegionCode() {
        return this.regionCode_;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getRegionCodeBytes() {
        return ByteString.copyFromUtf8(this.regionCode_);
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public int getRevision() {
        return this.revision_;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int i2 = this.revision_;
        int computeInt32Size = i2 != 0 ? CodedOutputStream.computeInt32Size(1, i2) + 0 : 0;
        if (!this.regionCode_.isEmpty()) {
            computeInt32Size += CodedOutputStream.computeStringSize(2, getRegionCode());
        }
        if (!this.languageCode_.isEmpty()) {
            computeInt32Size += CodedOutputStream.computeStringSize(3, getLanguageCode());
        }
        if (!this.postalCode_.isEmpty()) {
            computeInt32Size += CodedOutputStream.computeStringSize(4, getPostalCode());
        }
        if (!this.sortingCode_.isEmpty()) {
            computeInt32Size += CodedOutputStream.computeStringSize(5, getSortingCode());
        }
        if (!this.administrativeArea_.isEmpty()) {
            computeInt32Size += CodedOutputStream.computeStringSize(6, getAdministrativeArea());
        }
        if (!this.locality_.isEmpty()) {
            computeInt32Size += CodedOutputStream.computeStringSize(7, getLocality());
        }
        if (!this.sublocality_.isEmpty()) {
            computeInt32Size += CodedOutputStream.computeStringSize(8, getSublocality());
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.addressLines_.size(); i4++) {
            i3 += CodedOutputStream.computeStringSizeNoTag(this.addressLines_.get(i4));
        }
        int size = computeInt32Size + i3 + (getAddressLinesList().size() * 1);
        int i5 = 0;
        for (int i6 = 0; i6 < this.recipients_.size(); i6++) {
            i5 += CodedOutputStream.computeStringSizeNoTag(this.recipients_.get(i6));
        }
        int size2 = size + i5 + (getRecipientsList().size() * 1);
        if (!this.organization_.isEmpty()) {
            size2 += CodedOutputStream.computeStringSize(11, getOrganization());
        }
        this.c = size2;
        return size2;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public String getSortingCode() {
        return this.sortingCode_;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getSortingCodeBytes() {
        return ByteString.copyFromUtf8(this.sortingCode_);
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public String getSublocality() {
        return this.sublocality_;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getSublocalityBytes() {
        return ByteString.copyFromUtf8(this.sublocality_);
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        int i = this.revision_;
        if (i != 0) {
            codedOutputStream.writeInt32(1, i);
        }
        if (!this.regionCode_.isEmpty()) {
            codedOutputStream.writeString(2, getRegionCode());
        }
        if (!this.languageCode_.isEmpty()) {
            codedOutputStream.writeString(3, getLanguageCode());
        }
        if (!this.postalCode_.isEmpty()) {
            codedOutputStream.writeString(4, getPostalCode());
        }
        if (!this.sortingCode_.isEmpty()) {
            codedOutputStream.writeString(5, getSortingCode());
        }
        if (!this.administrativeArea_.isEmpty()) {
            codedOutputStream.writeString(6, getAdministrativeArea());
        }
        if (!this.locality_.isEmpty()) {
            codedOutputStream.writeString(7, getLocality());
        }
        if (!this.sublocality_.isEmpty()) {
            codedOutputStream.writeString(8, getSublocality());
        }
        for (int i2 = 0; i2 < this.addressLines_.size(); i2++) {
            codedOutputStream.writeString(9, this.addressLines_.get(i2));
        }
        for (int i3 = 0; i3 < this.recipients_.size(); i3++) {
            codedOutputStream.writeString(10, this.recipients_.get(i3));
        }
        if (this.organization_.isEmpty()) {
            return;
        }
        codedOutputStream.writeString(11, getOrganization());
    }
}
