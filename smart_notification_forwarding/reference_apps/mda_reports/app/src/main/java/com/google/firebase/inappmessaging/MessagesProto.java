package com.google.firebase.inappmessaging;

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

/* loaded from: classes2.dex */
public final class MessagesProto {

    /* renamed from: com.google.firebase.inappmessaging.MessagesProto$1, reason: invalid class name */
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
            a = new int[Content.MessageDetailsCase.values().length];
            try {
                a[Content.MessageDetailsCase.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[Content.MessageDetailsCase.MODAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[Content.MessageDetailsCase.IMAGE_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[Content.MessageDetailsCase.CARD.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[Content.MessageDetailsCase.MESSAGEDETAILS_NOT_SET.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Action extends GeneratedMessageLite<Action, Builder> implements ActionOrBuilder {
        public static final int ACTION_URL_FIELD_NUMBER = 1;
        private static final Action DEFAULT_INSTANCE = new Action();
        private static volatile Parser<Action> PARSER;
        private String actionUrl_ = "";

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Action, Builder> implements ActionOrBuilder {
            private Builder() {
                super(Action.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearActionUrl() {
                a();
                ((Action) this.a).clearActionUrl();
                return this;
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.ActionOrBuilder
            public String getActionUrl() {
                return ((Action) this.a).getActionUrl();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.ActionOrBuilder
            public ByteString getActionUrlBytes() {
                return ((Action) this.a).getActionUrlBytes();
            }

            public Builder setActionUrl(String str) {
                a();
                ((Action) this.a).setActionUrl(str);
                return this;
            }

            public Builder setActionUrlBytes(ByteString byteString) {
                a();
                ((Action) this.a).setActionUrlBytes(byteString);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private Action() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearActionUrl() {
            this.actionUrl_ = getDefaultInstance().getActionUrl();
        }

        public static Action getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Action action) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) action);
        }

        public static Action parseDelimitedFrom(InputStream inputStream) {
            return (Action) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static Action parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Action) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Action parseFrom(ByteString byteString) {
            return (Action) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static Action parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (Action) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Action parseFrom(CodedInputStream codedInputStream) {
            return (Action) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Action parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Action) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Action parseFrom(InputStream inputStream) {
            return (Action) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static Action parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Action) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Action parseFrom(byte[] bArr) {
            return (Action) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static Action parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (Action) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<Action> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setActionUrl(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.actionUrl_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setActionUrlBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.a(byteString);
            this.actionUrl_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.b[methodToInvoke.ordinal()]) {
                case 1:
                    return new Action();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    Action action = (Action) obj2;
                    this.actionUrl_ = ((GeneratedMessageLite.Visitor) obj).visitString(!this.actionUrl_.isEmpty(), this.actionUrl_, true ^ action.actionUrl_.isEmpty(), action.actionUrl_);
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
                                    this.actionUrl_ = codedInputStream.readStringRequireUtf8();
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
                        synchronized (Action.class) {
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

        @Override // com.google.firebase.inappmessaging.MessagesProto.ActionOrBuilder
        public String getActionUrl() {
            return this.actionUrl_;
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.ActionOrBuilder
        public ByteString getActionUrlBytes() {
            return ByteString.copyFromUtf8(this.actionUrl_);
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeStringSize = this.actionUrl_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getActionUrl());
            this.c = computeStringSize;
            return computeStringSize;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if (this.actionUrl_.isEmpty()) {
                return;
            }
            codedOutputStream.writeString(1, getActionUrl());
        }
    }

    /* loaded from: classes2.dex */
    public interface ActionOrBuilder extends MessageLiteOrBuilder {
        String getActionUrl();

        ByteString getActionUrlBytes();
    }

    /* loaded from: classes2.dex */
    public static final class BannerMessage extends GeneratedMessageLite<BannerMessage, Builder> implements BannerMessageOrBuilder {
        public static final int ACTION_FIELD_NUMBER = 4;
        public static final int BACKGROUND_HEX_COLOR_FIELD_NUMBER = 5;
        public static final int BODY_FIELD_NUMBER = 2;
        private static final BannerMessage DEFAULT_INSTANCE = new BannerMessage();
        public static final int IMAGE_URL_FIELD_NUMBER = 3;
        private static volatile Parser<BannerMessage> PARSER = null;
        public static final int TITLE_FIELD_NUMBER = 1;
        private Action action_;
        private Text body_;
        private Text title_;
        private String imageUrl_ = "";
        private String backgroundHexColor_ = "";

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<BannerMessage, Builder> implements BannerMessageOrBuilder {
            private Builder() {
                super(BannerMessage.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAction() {
                a();
                ((BannerMessage) this.a).clearAction();
                return this;
            }

            public Builder clearBackgroundHexColor() {
                a();
                ((BannerMessage) this.a).clearBackgroundHexColor();
                return this;
            }

            public Builder clearBody() {
                a();
                ((BannerMessage) this.a).clearBody();
                return this;
            }

            public Builder clearImageUrl() {
                a();
                ((BannerMessage) this.a).clearImageUrl();
                return this;
            }

            public Builder clearTitle() {
                a();
                ((BannerMessage) this.a).clearTitle();
                return this;
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.BannerMessageOrBuilder
            public Action getAction() {
                return ((BannerMessage) this.a).getAction();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.BannerMessageOrBuilder
            public String getBackgroundHexColor() {
                return ((BannerMessage) this.a).getBackgroundHexColor();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.BannerMessageOrBuilder
            public ByteString getBackgroundHexColorBytes() {
                return ((BannerMessage) this.a).getBackgroundHexColorBytes();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.BannerMessageOrBuilder
            public Text getBody() {
                return ((BannerMessage) this.a).getBody();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.BannerMessageOrBuilder
            public String getImageUrl() {
                return ((BannerMessage) this.a).getImageUrl();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.BannerMessageOrBuilder
            public ByteString getImageUrlBytes() {
                return ((BannerMessage) this.a).getImageUrlBytes();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.BannerMessageOrBuilder
            public Text getTitle() {
                return ((BannerMessage) this.a).getTitle();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.BannerMessageOrBuilder
            public boolean hasAction() {
                return ((BannerMessage) this.a).hasAction();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.BannerMessageOrBuilder
            public boolean hasBody() {
                return ((BannerMessage) this.a).hasBody();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.BannerMessageOrBuilder
            public boolean hasTitle() {
                return ((BannerMessage) this.a).hasTitle();
            }

            public Builder mergeAction(Action action) {
                a();
                ((BannerMessage) this.a).mergeAction(action);
                return this;
            }

            public Builder mergeBody(Text text) {
                a();
                ((BannerMessage) this.a).mergeBody(text);
                return this;
            }

            public Builder mergeTitle(Text text) {
                a();
                ((BannerMessage) this.a).mergeTitle(text);
                return this;
            }

            public Builder setAction(Action.Builder builder) {
                a();
                ((BannerMessage) this.a).setAction(builder);
                return this;
            }

            public Builder setAction(Action action) {
                a();
                ((BannerMessage) this.a).setAction(action);
                return this;
            }

            public Builder setBackgroundHexColor(String str) {
                a();
                ((BannerMessage) this.a).setBackgroundHexColor(str);
                return this;
            }

            public Builder setBackgroundHexColorBytes(ByteString byteString) {
                a();
                ((BannerMessage) this.a).setBackgroundHexColorBytes(byteString);
                return this;
            }

            public Builder setBody(Text.Builder builder) {
                a();
                ((BannerMessage) this.a).setBody(builder);
                return this;
            }

            public Builder setBody(Text text) {
                a();
                ((BannerMessage) this.a).setBody(text);
                return this;
            }

            public Builder setImageUrl(String str) {
                a();
                ((BannerMessage) this.a).setImageUrl(str);
                return this;
            }

            public Builder setImageUrlBytes(ByteString byteString) {
                a();
                ((BannerMessage) this.a).setImageUrlBytes(byteString);
                return this;
            }

            public Builder setTitle(Text.Builder builder) {
                a();
                ((BannerMessage) this.a).setTitle(builder);
                return this;
            }

            public Builder setTitle(Text text) {
                a();
                ((BannerMessage) this.a).setTitle(text);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private BannerMessage() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAction() {
            this.action_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBackgroundHexColor() {
            this.backgroundHexColor_ = getDefaultInstance().getBackgroundHexColor();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBody() {
            this.body_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearImageUrl() {
            this.imageUrl_ = getDefaultInstance().getImageUrl();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTitle() {
            this.title_ = null;
        }

        public static BannerMessage getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeAction(Action action) {
            Action action2 = this.action_;
            if (action2 != null && action2 != Action.getDefaultInstance()) {
                action = Action.newBuilder(this.action_).mergeFrom((Action.Builder) action).buildPartial();
            }
            this.action_ = action;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeBody(Text text) {
            Text text2 = this.body_;
            if (text2 != null && text2 != Text.getDefaultInstance()) {
                text = Text.newBuilder(this.body_).mergeFrom((Text.Builder) text).buildPartial();
            }
            this.body_ = text;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeTitle(Text text) {
            Text text2 = this.title_;
            if (text2 != null && text2 != Text.getDefaultInstance()) {
                text = Text.newBuilder(this.title_).mergeFrom((Text.Builder) text).buildPartial();
            }
            this.title_ = text;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BannerMessage bannerMessage) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) bannerMessage);
        }

        public static BannerMessage parseDelimitedFrom(InputStream inputStream) {
            return (BannerMessage) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static BannerMessage parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (BannerMessage) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static BannerMessage parseFrom(ByteString byteString) {
            return (BannerMessage) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static BannerMessage parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (BannerMessage) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static BannerMessage parseFrom(CodedInputStream codedInputStream) {
            return (BannerMessage) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static BannerMessage parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (BannerMessage) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static BannerMessage parseFrom(InputStream inputStream) {
            return (BannerMessage) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static BannerMessage parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (BannerMessage) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static BannerMessage parseFrom(byte[] bArr) {
            return (BannerMessage) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static BannerMessage parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (BannerMessage) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<BannerMessage> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAction(Action.Builder builder) {
            this.action_ = builder.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAction(Action action) {
            if (action == null) {
                throw new NullPointerException();
            }
            this.action_ = action;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBackgroundHexColor(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.backgroundHexColor_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBackgroundHexColorBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.a(byteString);
            this.backgroundHexColor_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBody(Text.Builder builder) {
            this.body_ = builder.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBody(Text text) {
            if (text == null) {
                throw new NullPointerException();
            }
            this.body_ = text;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setImageUrl(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.imageUrl_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setImageUrlBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.a(byteString);
            this.imageUrl_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTitle(Text.Builder builder) {
            this.title_ = builder.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTitle(Text text) {
            if (text == null) {
                throw new NullPointerException();
            }
            this.title_ = text;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.b[methodToInvoke.ordinal()]) {
                case 1:
                    return new BannerMessage();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    BannerMessage bannerMessage = (BannerMessage) obj2;
                    this.title_ = (Text) visitor.visitMessage(this.title_, bannerMessage.title_);
                    this.body_ = (Text) visitor.visitMessage(this.body_, bannerMessage.body_);
                    this.imageUrl_ = visitor.visitString(!this.imageUrl_.isEmpty(), this.imageUrl_, !bannerMessage.imageUrl_.isEmpty(), bannerMessage.imageUrl_);
                    this.action_ = (Action) visitor.visitMessage(this.action_, bannerMessage.action_);
                    this.backgroundHexColor_ = visitor.visitString(!this.backgroundHexColor_.isEmpty(), this.backgroundHexColor_, true ^ bannerMessage.backgroundHexColor_.isEmpty(), bannerMessage.backgroundHexColor_);
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
                                        Text.Builder builder = this.title_ != null ? this.title_.toBuilder() : null;
                                        this.title_ = (Text) codedInputStream.readMessage(Text.parser(), extensionRegistryLite);
                                        if (builder != null) {
                                            builder.mergeFrom((Text.Builder) this.title_);
                                            this.title_ = builder.buildPartial();
                                        }
                                    } else if (readTag == 18) {
                                        Text.Builder builder2 = this.body_ != null ? this.body_.toBuilder() : null;
                                        this.body_ = (Text) codedInputStream.readMessage(Text.parser(), extensionRegistryLite);
                                        if (builder2 != null) {
                                            builder2.mergeFrom((Text.Builder) this.body_);
                                            this.body_ = builder2.buildPartial();
                                        }
                                    } else if (readTag == 26) {
                                        this.imageUrl_ = codedInputStream.readStringRequireUtf8();
                                    } else if (readTag == 34) {
                                        Action.Builder builder3 = this.action_ != null ? this.action_.toBuilder() : null;
                                        this.action_ = (Action) codedInputStream.readMessage(Action.parser(), extensionRegistryLite);
                                        if (builder3 != null) {
                                            builder3.mergeFrom((Action.Builder) this.action_);
                                            this.action_ = builder3.buildPartial();
                                        }
                                    } else if (readTag == 42) {
                                        this.backgroundHexColor_ = codedInputStream.readStringRequireUtf8();
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
                        synchronized (BannerMessage.class) {
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

        @Override // com.google.firebase.inappmessaging.MessagesProto.BannerMessageOrBuilder
        public Action getAction() {
            Action action = this.action_;
            return action == null ? Action.getDefaultInstance() : action;
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.BannerMessageOrBuilder
        public String getBackgroundHexColor() {
            return this.backgroundHexColor_;
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.BannerMessageOrBuilder
        public ByteString getBackgroundHexColorBytes() {
            return ByteString.copyFromUtf8(this.backgroundHexColor_);
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.BannerMessageOrBuilder
        public Text getBody() {
            Text text = this.body_;
            return text == null ? Text.getDefaultInstance() : text;
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.BannerMessageOrBuilder
        public String getImageUrl() {
            return this.imageUrl_;
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.BannerMessageOrBuilder
        public ByteString getImageUrlBytes() {
            return ByteString.copyFromUtf8(this.imageUrl_);
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeMessageSize = this.title_ != null ? 0 + CodedOutputStream.computeMessageSize(1, getTitle()) : 0;
            if (this.body_ != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(2, getBody());
            }
            if (!this.imageUrl_.isEmpty()) {
                computeMessageSize += CodedOutputStream.computeStringSize(3, getImageUrl());
            }
            if (this.action_ != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(4, getAction());
            }
            if (!this.backgroundHexColor_.isEmpty()) {
                computeMessageSize += CodedOutputStream.computeStringSize(5, getBackgroundHexColor());
            }
            this.c = computeMessageSize;
            return computeMessageSize;
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.BannerMessageOrBuilder
        public Text getTitle() {
            Text text = this.title_;
            return text == null ? Text.getDefaultInstance() : text;
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.BannerMessageOrBuilder
        public boolean hasAction() {
            return this.action_ != null;
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.BannerMessageOrBuilder
        public boolean hasBody() {
            return this.body_ != null;
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.BannerMessageOrBuilder
        public boolean hasTitle() {
            return this.title_ != null;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if (this.title_ != null) {
                codedOutputStream.writeMessage(1, getTitle());
            }
            if (this.body_ != null) {
                codedOutputStream.writeMessage(2, getBody());
            }
            if (!this.imageUrl_.isEmpty()) {
                codedOutputStream.writeString(3, getImageUrl());
            }
            if (this.action_ != null) {
                codedOutputStream.writeMessage(4, getAction());
            }
            if (this.backgroundHexColor_.isEmpty()) {
                return;
            }
            codedOutputStream.writeString(5, getBackgroundHexColor());
        }
    }

    /* loaded from: classes2.dex */
    public interface BannerMessageOrBuilder extends MessageLiteOrBuilder {
        Action getAction();

        String getBackgroundHexColor();

        ByteString getBackgroundHexColorBytes();

        Text getBody();

        String getImageUrl();

        ByteString getImageUrlBytes();

        Text getTitle();

        boolean hasAction();

        boolean hasBody();

        boolean hasTitle();
    }

    /* loaded from: classes2.dex */
    public static final class Button extends GeneratedMessageLite<Button, Builder> implements ButtonOrBuilder {
        public static final int BUTTON_HEX_COLOR_FIELD_NUMBER = 2;
        private static final Button DEFAULT_INSTANCE = new Button();
        private static volatile Parser<Button> PARSER = null;
        public static final int TEXT_FIELD_NUMBER = 1;
        private String buttonHexColor_ = "";
        private Text text_;

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Button, Builder> implements ButtonOrBuilder {
            private Builder() {
                super(Button.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearButtonHexColor() {
                a();
                ((Button) this.a).clearButtonHexColor();
                return this;
            }

            public Builder clearText() {
                a();
                ((Button) this.a).clearText();
                return this;
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.ButtonOrBuilder
            public String getButtonHexColor() {
                return ((Button) this.a).getButtonHexColor();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.ButtonOrBuilder
            public ByteString getButtonHexColorBytes() {
                return ((Button) this.a).getButtonHexColorBytes();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.ButtonOrBuilder
            public Text getText() {
                return ((Button) this.a).getText();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.ButtonOrBuilder
            public boolean hasText() {
                return ((Button) this.a).hasText();
            }

            public Builder mergeText(Text text) {
                a();
                ((Button) this.a).mergeText(text);
                return this;
            }

            public Builder setButtonHexColor(String str) {
                a();
                ((Button) this.a).setButtonHexColor(str);
                return this;
            }

            public Builder setButtonHexColorBytes(ByteString byteString) {
                a();
                ((Button) this.a).setButtonHexColorBytes(byteString);
                return this;
            }

            public Builder setText(Text.Builder builder) {
                a();
                ((Button) this.a).setText(builder);
                return this;
            }

            public Builder setText(Text text) {
                a();
                ((Button) this.a).setText(text);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private Button() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearButtonHexColor() {
            this.buttonHexColor_ = getDefaultInstance().getButtonHexColor();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearText() {
            this.text_ = null;
        }

        public static Button getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeText(Text text) {
            Text text2 = this.text_;
            if (text2 != null && text2 != Text.getDefaultInstance()) {
                text = Text.newBuilder(this.text_).mergeFrom((Text.Builder) text).buildPartial();
            }
            this.text_ = text;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Button button) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) button);
        }

        public static Button parseDelimitedFrom(InputStream inputStream) {
            return (Button) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static Button parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Button) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Button parseFrom(ByteString byteString) {
            return (Button) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static Button parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (Button) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Button parseFrom(CodedInputStream codedInputStream) {
            return (Button) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Button parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Button) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Button parseFrom(InputStream inputStream) {
            return (Button) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static Button parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Button) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Button parseFrom(byte[] bArr) {
            return (Button) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static Button parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (Button) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<Button> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setButtonHexColor(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.buttonHexColor_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setButtonHexColorBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.a(byteString);
            this.buttonHexColor_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setText(Text.Builder builder) {
            this.text_ = builder.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setText(Text text) {
            if (text == null) {
                throw new NullPointerException();
            }
            this.text_ = text;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.b[methodToInvoke.ordinal()]) {
                case 1:
                    return new Button();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    Button button = (Button) obj2;
                    this.text_ = (Text) visitor.visitMessage(this.text_, button.text_);
                    this.buttonHexColor_ = visitor.visitString(!this.buttonHexColor_.isEmpty(), this.buttonHexColor_, true ^ button.buttonHexColor_.isEmpty(), button.buttonHexColor_);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
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
                                    Text.Builder builder = this.text_ != null ? this.text_.toBuilder() : null;
                                    this.text_ = (Text) codedInputStream.readMessage(Text.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom((Text.Builder) this.text_);
                                        this.text_ = builder.buildPartial();
                                    }
                                } else if (readTag == 18) {
                                    this.buttonHexColor_ = codedInputStream.readStringRequireUtf8();
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
                        synchronized (Button.class) {
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

        @Override // com.google.firebase.inappmessaging.MessagesProto.ButtonOrBuilder
        public String getButtonHexColor() {
            return this.buttonHexColor_;
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.ButtonOrBuilder
        public ByteString getButtonHexColorBytes() {
            return ByteString.copyFromUtf8(this.buttonHexColor_);
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeMessageSize = this.text_ != null ? 0 + CodedOutputStream.computeMessageSize(1, getText()) : 0;
            if (!this.buttonHexColor_.isEmpty()) {
                computeMessageSize += CodedOutputStream.computeStringSize(2, getButtonHexColor());
            }
            this.c = computeMessageSize;
            return computeMessageSize;
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.ButtonOrBuilder
        public Text getText() {
            Text text = this.text_;
            return text == null ? Text.getDefaultInstance() : text;
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.ButtonOrBuilder
        public boolean hasText() {
            return this.text_ != null;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if (this.text_ != null) {
                codedOutputStream.writeMessage(1, getText());
            }
            if (this.buttonHexColor_.isEmpty()) {
                return;
            }
            codedOutputStream.writeString(2, getButtonHexColor());
        }
    }

    /* loaded from: classes2.dex */
    public interface ButtonOrBuilder extends MessageLiteOrBuilder {
        String getButtonHexColor();

        ByteString getButtonHexColorBytes();

        Text getText();

        boolean hasText();
    }

    /* loaded from: classes2.dex */
    public static final class CardMessage extends GeneratedMessageLite<CardMessage, Builder> implements CardMessageOrBuilder {
        public static final int BACKGROUND_HEX_COLOR_FIELD_NUMBER = 5;
        public static final int BODY_FIELD_NUMBER = 2;
        private static final CardMessage DEFAULT_INSTANCE = new CardMessage();
        public static final int LANDSCAPE_IMAGE_URL_FIELD_NUMBER = 4;
        private static volatile Parser<CardMessage> PARSER = null;
        public static final int PORTRAIT_IMAGE_URL_FIELD_NUMBER = 3;
        public static final int PRIMARY_ACTION_BUTTON_FIELD_NUMBER = 6;
        public static final int PRIMARY_ACTION_FIELD_NUMBER = 7;
        public static final int SECONDARY_ACTION_BUTTON_FIELD_NUMBER = 8;
        public static final int SECONDARY_ACTION_FIELD_NUMBER = 9;
        public static final int TITLE_FIELD_NUMBER = 1;
        private Text body_;
        private Button primaryActionButton_;
        private Action primaryAction_;
        private Button secondaryActionButton_;
        private Action secondaryAction_;
        private Text title_;
        private String portraitImageUrl_ = "";
        private String landscapeImageUrl_ = "";
        private String backgroundHexColor_ = "";

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<CardMessage, Builder> implements CardMessageOrBuilder {
            private Builder() {
                super(CardMessage.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearBackgroundHexColor() {
                a();
                ((CardMessage) this.a).clearBackgroundHexColor();
                return this;
            }

            public Builder clearBody() {
                a();
                ((CardMessage) this.a).clearBody();
                return this;
            }

            public Builder clearLandscapeImageUrl() {
                a();
                ((CardMessage) this.a).clearLandscapeImageUrl();
                return this;
            }

            public Builder clearPortraitImageUrl() {
                a();
                ((CardMessage) this.a).clearPortraitImageUrl();
                return this;
            }

            public Builder clearPrimaryAction() {
                a();
                ((CardMessage) this.a).clearPrimaryAction();
                return this;
            }

            public Builder clearPrimaryActionButton() {
                a();
                ((CardMessage) this.a).clearPrimaryActionButton();
                return this;
            }

            public Builder clearSecondaryAction() {
                a();
                ((CardMessage) this.a).clearSecondaryAction();
                return this;
            }

            public Builder clearSecondaryActionButton() {
                a();
                ((CardMessage) this.a).clearSecondaryActionButton();
                return this;
            }

            public Builder clearTitle() {
                a();
                ((CardMessage) this.a).clearTitle();
                return this;
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.CardMessageOrBuilder
            public String getBackgroundHexColor() {
                return ((CardMessage) this.a).getBackgroundHexColor();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.CardMessageOrBuilder
            public ByteString getBackgroundHexColorBytes() {
                return ((CardMessage) this.a).getBackgroundHexColorBytes();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.CardMessageOrBuilder
            public Text getBody() {
                return ((CardMessage) this.a).getBody();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.CardMessageOrBuilder
            public String getLandscapeImageUrl() {
                return ((CardMessage) this.a).getLandscapeImageUrl();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.CardMessageOrBuilder
            public ByteString getLandscapeImageUrlBytes() {
                return ((CardMessage) this.a).getLandscapeImageUrlBytes();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.CardMessageOrBuilder
            public String getPortraitImageUrl() {
                return ((CardMessage) this.a).getPortraitImageUrl();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.CardMessageOrBuilder
            public ByteString getPortraitImageUrlBytes() {
                return ((CardMessage) this.a).getPortraitImageUrlBytes();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.CardMessageOrBuilder
            public Action getPrimaryAction() {
                return ((CardMessage) this.a).getPrimaryAction();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.CardMessageOrBuilder
            public Button getPrimaryActionButton() {
                return ((CardMessage) this.a).getPrimaryActionButton();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.CardMessageOrBuilder
            public Action getSecondaryAction() {
                return ((CardMessage) this.a).getSecondaryAction();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.CardMessageOrBuilder
            public Button getSecondaryActionButton() {
                return ((CardMessage) this.a).getSecondaryActionButton();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.CardMessageOrBuilder
            public Text getTitle() {
                return ((CardMessage) this.a).getTitle();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.CardMessageOrBuilder
            public boolean hasBody() {
                return ((CardMessage) this.a).hasBody();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.CardMessageOrBuilder
            public boolean hasPrimaryAction() {
                return ((CardMessage) this.a).hasPrimaryAction();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.CardMessageOrBuilder
            public boolean hasPrimaryActionButton() {
                return ((CardMessage) this.a).hasPrimaryActionButton();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.CardMessageOrBuilder
            public boolean hasSecondaryAction() {
                return ((CardMessage) this.a).hasSecondaryAction();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.CardMessageOrBuilder
            public boolean hasSecondaryActionButton() {
                return ((CardMessage) this.a).hasSecondaryActionButton();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.CardMessageOrBuilder
            public boolean hasTitle() {
                return ((CardMessage) this.a).hasTitle();
            }

            public Builder mergeBody(Text text) {
                a();
                ((CardMessage) this.a).mergeBody(text);
                return this;
            }

            public Builder mergePrimaryAction(Action action) {
                a();
                ((CardMessage) this.a).mergePrimaryAction(action);
                return this;
            }

            public Builder mergePrimaryActionButton(Button button) {
                a();
                ((CardMessage) this.a).mergePrimaryActionButton(button);
                return this;
            }

            public Builder mergeSecondaryAction(Action action) {
                a();
                ((CardMessage) this.a).mergeSecondaryAction(action);
                return this;
            }

            public Builder mergeSecondaryActionButton(Button button) {
                a();
                ((CardMessage) this.a).mergeSecondaryActionButton(button);
                return this;
            }

            public Builder mergeTitle(Text text) {
                a();
                ((CardMessage) this.a).mergeTitle(text);
                return this;
            }

            public Builder setBackgroundHexColor(String str) {
                a();
                ((CardMessage) this.a).setBackgroundHexColor(str);
                return this;
            }

            public Builder setBackgroundHexColorBytes(ByteString byteString) {
                a();
                ((CardMessage) this.a).setBackgroundHexColorBytes(byteString);
                return this;
            }

            public Builder setBody(Text.Builder builder) {
                a();
                ((CardMessage) this.a).setBody(builder);
                return this;
            }

            public Builder setBody(Text text) {
                a();
                ((CardMessage) this.a).setBody(text);
                return this;
            }

            public Builder setLandscapeImageUrl(String str) {
                a();
                ((CardMessage) this.a).setLandscapeImageUrl(str);
                return this;
            }

            public Builder setLandscapeImageUrlBytes(ByteString byteString) {
                a();
                ((CardMessage) this.a).setLandscapeImageUrlBytes(byteString);
                return this;
            }

            public Builder setPortraitImageUrl(String str) {
                a();
                ((CardMessage) this.a).setPortraitImageUrl(str);
                return this;
            }

            public Builder setPortraitImageUrlBytes(ByteString byteString) {
                a();
                ((CardMessage) this.a).setPortraitImageUrlBytes(byteString);
                return this;
            }

            public Builder setPrimaryAction(Action.Builder builder) {
                a();
                ((CardMessage) this.a).setPrimaryAction(builder);
                return this;
            }

            public Builder setPrimaryAction(Action action) {
                a();
                ((CardMessage) this.a).setPrimaryAction(action);
                return this;
            }

            public Builder setPrimaryActionButton(Button.Builder builder) {
                a();
                ((CardMessage) this.a).setPrimaryActionButton(builder);
                return this;
            }

            public Builder setPrimaryActionButton(Button button) {
                a();
                ((CardMessage) this.a).setPrimaryActionButton(button);
                return this;
            }

            public Builder setSecondaryAction(Action.Builder builder) {
                a();
                ((CardMessage) this.a).setSecondaryAction(builder);
                return this;
            }

            public Builder setSecondaryAction(Action action) {
                a();
                ((CardMessage) this.a).setSecondaryAction(action);
                return this;
            }

            public Builder setSecondaryActionButton(Button.Builder builder) {
                a();
                ((CardMessage) this.a).setSecondaryActionButton(builder);
                return this;
            }

            public Builder setSecondaryActionButton(Button button) {
                a();
                ((CardMessage) this.a).setSecondaryActionButton(button);
                return this;
            }

            public Builder setTitle(Text.Builder builder) {
                a();
                ((CardMessage) this.a).setTitle(builder);
                return this;
            }

            public Builder setTitle(Text text) {
                a();
                ((CardMessage) this.a).setTitle(text);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private CardMessage() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBackgroundHexColor() {
            this.backgroundHexColor_ = getDefaultInstance().getBackgroundHexColor();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBody() {
            this.body_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLandscapeImageUrl() {
            this.landscapeImageUrl_ = getDefaultInstance().getLandscapeImageUrl();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPortraitImageUrl() {
            this.portraitImageUrl_ = getDefaultInstance().getPortraitImageUrl();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPrimaryAction() {
            this.primaryAction_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPrimaryActionButton() {
            this.primaryActionButton_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSecondaryAction() {
            this.secondaryAction_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSecondaryActionButton() {
            this.secondaryActionButton_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTitle() {
            this.title_ = null;
        }

        public static CardMessage getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeBody(Text text) {
            Text text2 = this.body_;
            if (text2 != null && text2 != Text.getDefaultInstance()) {
                text = Text.newBuilder(this.body_).mergeFrom((Text.Builder) text).buildPartial();
            }
            this.body_ = text;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergePrimaryAction(Action action) {
            Action action2 = this.primaryAction_;
            if (action2 != null && action2 != Action.getDefaultInstance()) {
                action = Action.newBuilder(this.primaryAction_).mergeFrom((Action.Builder) action).buildPartial();
            }
            this.primaryAction_ = action;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergePrimaryActionButton(Button button) {
            Button button2 = this.primaryActionButton_;
            if (button2 != null && button2 != Button.getDefaultInstance()) {
                button = Button.newBuilder(this.primaryActionButton_).mergeFrom((Button.Builder) button).buildPartial();
            }
            this.primaryActionButton_ = button;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeSecondaryAction(Action action) {
            Action action2 = this.secondaryAction_;
            if (action2 != null && action2 != Action.getDefaultInstance()) {
                action = Action.newBuilder(this.secondaryAction_).mergeFrom((Action.Builder) action).buildPartial();
            }
            this.secondaryAction_ = action;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeSecondaryActionButton(Button button) {
            Button button2 = this.secondaryActionButton_;
            if (button2 != null && button2 != Button.getDefaultInstance()) {
                button = Button.newBuilder(this.secondaryActionButton_).mergeFrom((Button.Builder) button).buildPartial();
            }
            this.secondaryActionButton_ = button;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeTitle(Text text) {
            Text text2 = this.title_;
            if (text2 != null && text2 != Text.getDefaultInstance()) {
                text = Text.newBuilder(this.title_).mergeFrom((Text.Builder) text).buildPartial();
            }
            this.title_ = text;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CardMessage cardMessage) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) cardMessage);
        }

        public static CardMessage parseDelimitedFrom(InputStream inputStream) {
            return (CardMessage) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static CardMessage parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CardMessage) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CardMessage parseFrom(ByteString byteString) {
            return (CardMessage) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static CardMessage parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (CardMessage) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static CardMessage parseFrom(CodedInputStream codedInputStream) {
            return (CardMessage) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static CardMessage parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CardMessage) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static CardMessage parseFrom(InputStream inputStream) {
            return (CardMessage) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static CardMessage parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CardMessage) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CardMessage parseFrom(byte[] bArr) {
            return (CardMessage) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static CardMessage parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (CardMessage) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<CardMessage> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBackgroundHexColor(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.backgroundHexColor_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBackgroundHexColorBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.a(byteString);
            this.backgroundHexColor_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBody(Text.Builder builder) {
            this.body_ = builder.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBody(Text text) {
            if (text == null) {
                throw new NullPointerException();
            }
            this.body_ = text;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLandscapeImageUrl(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.landscapeImageUrl_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLandscapeImageUrlBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.a(byteString);
            this.landscapeImageUrl_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPortraitImageUrl(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.portraitImageUrl_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPortraitImageUrlBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.a(byteString);
            this.portraitImageUrl_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPrimaryAction(Action.Builder builder) {
            this.primaryAction_ = builder.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPrimaryAction(Action action) {
            if (action == null) {
                throw new NullPointerException();
            }
            this.primaryAction_ = action;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPrimaryActionButton(Button.Builder builder) {
            this.primaryActionButton_ = builder.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPrimaryActionButton(Button button) {
            if (button == null) {
                throw new NullPointerException();
            }
            this.primaryActionButton_ = button;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSecondaryAction(Action.Builder builder) {
            this.secondaryAction_ = builder.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSecondaryAction(Action action) {
            if (action == null) {
                throw new NullPointerException();
            }
            this.secondaryAction_ = action;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSecondaryActionButton(Button.Builder builder) {
            this.secondaryActionButton_ = builder.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSecondaryActionButton(Button button) {
            if (button == null) {
                throw new NullPointerException();
            }
            this.secondaryActionButton_ = button;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTitle(Text.Builder builder) {
            this.title_ = builder.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTitle(Text text) {
            if (text == null) {
                throw new NullPointerException();
            }
            this.title_ = text;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.b[methodToInvoke.ordinal()]) {
                case 1:
                    return new CardMessage();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    CardMessage cardMessage = (CardMessage) obj2;
                    this.title_ = (Text) visitor.visitMessage(this.title_, cardMessage.title_);
                    this.body_ = (Text) visitor.visitMessage(this.body_, cardMessage.body_);
                    this.portraitImageUrl_ = visitor.visitString(!this.portraitImageUrl_.isEmpty(), this.portraitImageUrl_, !cardMessage.portraitImageUrl_.isEmpty(), cardMessage.portraitImageUrl_);
                    this.landscapeImageUrl_ = visitor.visitString(!this.landscapeImageUrl_.isEmpty(), this.landscapeImageUrl_, !cardMessage.landscapeImageUrl_.isEmpty(), cardMessage.landscapeImageUrl_);
                    this.backgroundHexColor_ = visitor.visitString(!this.backgroundHexColor_.isEmpty(), this.backgroundHexColor_, true ^ cardMessage.backgroundHexColor_.isEmpty(), cardMessage.backgroundHexColor_);
                    this.primaryActionButton_ = (Button) visitor.visitMessage(this.primaryActionButton_, cardMessage.primaryActionButton_);
                    this.primaryAction_ = (Action) visitor.visitMessage(this.primaryAction_, cardMessage.primaryAction_);
                    this.secondaryActionButton_ = (Button) visitor.visitMessage(this.secondaryActionButton_, cardMessage.secondaryActionButton_);
                    this.secondaryAction_ = (Action) visitor.visitMessage(this.secondaryAction_, cardMessage.secondaryAction_);
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
                                        Text.Builder builder = this.title_ != null ? this.title_.toBuilder() : null;
                                        this.title_ = (Text) codedInputStream.readMessage(Text.parser(), extensionRegistryLite);
                                        if (builder != null) {
                                            builder.mergeFrom((Text.Builder) this.title_);
                                            this.title_ = builder.buildPartial();
                                        }
                                    } else if (readTag == 18) {
                                        Text.Builder builder2 = this.body_ != null ? this.body_.toBuilder() : null;
                                        this.body_ = (Text) codedInputStream.readMessage(Text.parser(), extensionRegistryLite);
                                        if (builder2 != null) {
                                            builder2.mergeFrom((Text.Builder) this.body_);
                                            this.body_ = builder2.buildPartial();
                                        }
                                    } else if (readTag == 26) {
                                        this.portraitImageUrl_ = codedInputStream.readStringRequireUtf8();
                                    } else if (readTag == 34) {
                                        this.landscapeImageUrl_ = codedInputStream.readStringRequireUtf8();
                                    } else if (readTag == 42) {
                                        this.backgroundHexColor_ = codedInputStream.readStringRequireUtf8();
                                    } else if (readTag == 50) {
                                        Button.Builder builder3 = this.primaryActionButton_ != null ? this.primaryActionButton_.toBuilder() : null;
                                        this.primaryActionButton_ = (Button) codedInputStream.readMessage(Button.parser(), extensionRegistryLite);
                                        if (builder3 != null) {
                                            builder3.mergeFrom((Button.Builder) this.primaryActionButton_);
                                            this.primaryActionButton_ = builder3.buildPartial();
                                        }
                                    } else if (readTag == 58) {
                                        Action.Builder builder4 = this.primaryAction_ != null ? this.primaryAction_.toBuilder() : null;
                                        this.primaryAction_ = (Action) codedInputStream.readMessage(Action.parser(), extensionRegistryLite);
                                        if (builder4 != null) {
                                            builder4.mergeFrom((Action.Builder) this.primaryAction_);
                                            this.primaryAction_ = builder4.buildPartial();
                                        }
                                    } else if (readTag == 66) {
                                        Button.Builder builder5 = this.secondaryActionButton_ != null ? this.secondaryActionButton_.toBuilder() : null;
                                        this.secondaryActionButton_ = (Button) codedInputStream.readMessage(Button.parser(), extensionRegistryLite);
                                        if (builder5 != null) {
                                            builder5.mergeFrom((Button.Builder) this.secondaryActionButton_);
                                            this.secondaryActionButton_ = builder5.buildPartial();
                                        }
                                    } else if (readTag == 74) {
                                        Action.Builder builder6 = this.secondaryAction_ != null ? this.secondaryAction_.toBuilder() : null;
                                        this.secondaryAction_ = (Action) codedInputStream.readMessage(Action.parser(), extensionRegistryLite);
                                        if (builder6 != null) {
                                            builder6.mergeFrom((Action.Builder) this.secondaryAction_);
                                            this.secondaryAction_ = builder6.buildPartial();
                                        }
                                    } else if (!codedInputStream.skipField(readTag)) {
                                    }
                                }
                                z = true;
                            } catch (IOException e) {
                                throw new RuntimeException(new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this));
                            }
                        } catch (InvalidProtocolBufferException e2) {
                            throw new RuntimeException(e2.setUnfinishedMessage(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (PARSER == null) {
                        synchronized (CardMessage.class) {
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

        @Override // com.google.firebase.inappmessaging.MessagesProto.CardMessageOrBuilder
        public String getBackgroundHexColor() {
            return this.backgroundHexColor_;
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.CardMessageOrBuilder
        public ByteString getBackgroundHexColorBytes() {
            return ByteString.copyFromUtf8(this.backgroundHexColor_);
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.CardMessageOrBuilder
        public Text getBody() {
            Text text = this.body_;
            return text == null ? Text.getDefaultInstance() : text;
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.CardMessageOrBuilder
        public String getLandscapeImageUrl() {
            return this.landscapeImageUrl_;
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.CardMessageOrBuilder
        public ByteString getLandscapeImageUrlBytes() {
            return ByteString.copyFromUtf8(this.landscapeImageUrl_);
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.CardMessageOrBuilder
        public String getPortraitImageUrl() {
            return this.portraitImageUrl_;
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.CardMessageOrBuilder
        public ByteString getPortraitImageUrlBytes() {
            return ByteString.copyFromUtf8(this.portraitImageUrl_);
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.CardMessageOrBuilder
        public Action getPrimaryAction() {
            Action action = this.primaryAction_;
            return action == null ? Action.getDefaultInstance() : action;
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.CardMessageOrBuilder
        public Button getPrimaryActionButton() {
            Button button = this.primaryActionButton_;
            return button == null ? Button.getDefaultInstance() : button;
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.CardMessageOrBuilder
        public Action getSecondaryAction() {
            Action action = this.secondaryAction_;
            return action == null ? Action.getDefaultInstance() : action;
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.CardMessageOrBuilder
        public Button getSecondaryActionButton() {
            Button button = this.secondaryActionButton_;
            return button == null ? Button.getDefaultInstance() : button;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeMessageSize = this.title_ != null ? 0 + CodedOutputStream.computeMessageSize(1, getTitle()) : 0;
            if (this.body_ != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(2, getBody());
            }
            if (!this.portraitImageUrl_.isEmpty()) {
                computeMessageSize += CodedOutputStream.computeStringSize(3, getPortraitImageUrl());
            }
            if (!this.landscapeImageUrl_.isEmpty()) {
                computeMessageSize += CodedOutputStream.computeStringSize(4, getLandscapeImageUrl());
            }
            if (!this.backgroundHexColor_.isEmpty()) {
                computeMessageSize += CodedOutputStream.computeStringSize(5, getBackgroundHexColor());
            }
            if (this.primaryActionButton_ != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(6, getPrimaryActionButton());
            }
            if (this.primaryAction_ != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(7, getPrimaryAction());
            }
            if (this.secondaryActionButton_ != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(8, getSecondaryActionButton());
            }
            if (this.secondaryAction_ != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(9, getSecondaryAction());
            }
            this.c = computeMessageSize;
            return computeMessageSize;
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.CardMessageOrBuilder
        public Text getTitle() {
            Text text = this.title_;
            return text == null ? Text.getDefaultInstance() : text;
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.CardMessageOrBuilder
        public boolean hasBody() {
            return this.body_ != null;
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.CardMessageOrBuilder
        public boolean hasPrimaryAction() {
            return this.primaryAction_ != null;
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.CardMessageOrBuilder
        public boolean hasPrimaryActionButton() {
            return this.primaryActionButton_ != null;
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.CardMessageOrBuilder
        public boolean hasSecondaryAction() {
            return this.secondaryAction_ != null;
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.CardMessageOrBuilder
        public boolean hasSecondaryActionButton() {
            return this.secondaryActionButton_ != null;
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.CardMessageOrBuilder
        public boolean hasTitle() {
            return this.title_ != null;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if (this.title_ != null) {
                codedOutputStream.writeMessage(1, getTitle());
            }
            if (this.body_ != null) {
                codedOutputStream.writeMessage(2, getBody());
            }
            if (!this.portraitImageUrl_.isEmpty()) {
                codedOutputStream.writeString(3, getPortraitImageUrl());
            }
            if (!this.landscapeImageUrl_.isEmpty()) {
                codedOutputStream.writeString(4, getLandscapeImageUrl());
            }
            if (!this.backgroundHexColor_.isEmpty()) {
                codedOutputStream.writeString(5, getBackgroundHexColor());
            }
            if (this.primaryActionButton_ != null) {
                codedOutputStream.writeMessage(6, getPrimaryActionButton());
            }
            if (this.primaryAction_ != null) {
                codedOutputStream.writeMessage(7, getPrimaryAction());
            }
            if (this.secondaryActionButton_ != null) {
                codedOutputStream.writeMessage(8, getSecondaryActionButton());
            }
            if (this.secondaryAction_ != null) {
                codedOutputStream.writeMessage(9, getSecondaryAction());
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface CardMessageOrBuilder extends MessageLiteOrBuilder {
        String getBackgroundHexColor();

        ByteString getBackgroundHexColorBytes();

        Text getBody();

        String getLandscapeImageUrl();

        ByteString getLandscapeImageUrlBytes();

        String getPortraitImageUrl();

        ByteString getPortraitImageUrlBytes();

        Action getPrimaryAction();

        Button getPrimaryActionButton();

        Action getSecondaryAction();

        Button getSecondaryActionButton();

        Text getTitle();

        boolean hasBody();

        boolean hasPrimaryAction();

        boolean hasPrimaryActionButton();

        boolean hasSecondaryAction();

        boolean hasSecondaryActionButton();

        boolean hasTitle();
    }

    /* loaded from: classes2.dex */
    public static final class Content extends GeneratedMessageLite<Content, Builder> implements ContentOrBuilder {
        public static final int BANNER_FIELD_NUMBER = 1;
        public static final int CARD_FIELD_NUMBER = 4;
        private static final Content DEFAULT_INSTANCE = new Content();
        public static final int IMAGE_ONLY_FIELD_NUMBER = 3;
        public static final int MODAL_FIELD_NUMBER = 2;
        private static volatile Parser<Content> PARSER;
        private int messageDetailsCase_ = 0;
        private Object messageDetails_;

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Content, Builder> implements ContentOrBuilder {
            private Builder() {
                super(Content.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearBanner() {
                a();
                ((Content) this.a).clearBanner();
                return this;
            }

            public Builder clearCard() {
                a();
                ((Content) this.a).clearCard();
                return this;
            }

            public Builder clearImageOnly() {
                a();
                ((Content) this.a).clearImageOnly();
                return this;
            }

            public Builder clearMessageDetails() {
                a();
                ((Content) this.a).clearMessageDetails();
                return this;
            }

            public Builder clearModal() {
                a();
                ((Content) this.a).clearModal();
                return this;
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.ContentOrBuilder
            public BannerMessage getBanner() {
                return ((Content) this.a).getBanner();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.ContentOrBuilder
            public CardMessage getCard() {
                return ((Content) this.a).getCard();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.ContentOrBuilder
            public ImageOnlyMessage getImageOnly() {
                return ((Content) this.a).getImageOnly();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.ContentOrBuilder
            public MessageDetailsCase getMessageDetailsCase() {
                return ((Content) this.a).getMessageDetailsCase();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.ContentOrBuilder
            public ModalMessage getModal() {
                return ((Content) this.a).getModal();
            }

            public Builder mergeBanner(BannerMessage bannerMessage) {
                a();
                ((Content) this.a).mergeBanner(bannerMessage);
                return this;
            }

            public Builder mergeCard(CardMessage cardMessage) {
                a();
                ((Content) this.a).mergeCard(cardMessage);
                return this;
            }

            public Builder mergeImageOnly(ImageOnlyMessage imageOnlyMessage) {
                a();
                ((Content) this.a).mergeImageOnly(imageOnlyMessage);
                return this;
            }

            public Builder mergeModal(ModalMessage modalMessage) {
                a();
                ((Content) this.a).mergeModal(modalMessage);
                return this;
            }

            public Builder setBanner(BannerMessage.Builder builder) {
                a();
                ((Content) this.a).setBanner(builder);
                return this;
            }

            public Builder setBanner(BannerMessage bannerMessage) {
                a();
                ((Content) this.a).setBanner(bannerMessage);
                return this;
            }

            public Builder setCard(CardMessage.Builder builder) {
                a();
                ((Content) this.a).setCard(builder);
                return this;
            }

            public Builder setCard(CardMessage cardMessage) {
                a();
                ((Content) this.a).setCard(cardMessage);
                return this;
            }

            public Builder setImageOnly(ImageOnlyMessage.Builder builder) {
                a();
                ((Content) this.a).setImageOnly(builder);
                return this;
            }

            public Builder setImageOnly(ImageOnlyMessage imageOnlyMessage) {
                a();
                ((Content) this.a).setImageOnly(imageOnlyMessage);
                return this;
            }

            public Builder setModal(ModalMessage.Builder builder) {
                a();
                ((Content) this.a).setModal(builder);
                return this;
            }

            public Builder setModal(ModalMessage modalMessage) {
                a();
                ((Content) this.a).setModal(modalMessage);
                return this;
            }
        }

        /* loaded from: classes2.dex */
        public enum MessageDetailsCase implements Internal.EnumLite {
            BANNER(1),
            MODAL(2),
            IMAGE_ONLY(3),
            CARD(4),
            MESSAGEDETAILS_NOT_SET(0);

            private final int value;

            MessageDetailsCase(int i) {
                this.value = i;
            }

            public static MessageDetailsCase forNumber(int i) {
                if (i == 0) {
                    return MESSAGEDETAILS_NOT_SET;
                }
                if (i == 1) {
                    return BANNER;
                }
                if (i == 2) {
                    return MODAL;
                }
                if (i == 3) {
                    return IMAGE_ONLY;
                }
                if (i != 4) {
                    return null;
                }
                return CARD;
            }

            @Deprecated
            public static MessageDetailsCase valueOf(int i) {
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

        private Content() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBanner() {
            if (this.messageDetailsCase_ == 1) {
                this.messageDetailsCase_ = 0;
                this.messageDetails_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCard() {
            if (this.messageDetailsCase_ == 4) {
                this.messageDetailsCase_ = 0;
                this.messageDetails_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearImageOnly() {
            if (this.messageDetailsCase_ == 3) {
                this.messageDetailsCase_ = 0;
                this.messageDetails_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMessageDetails() {
            this.messageDetailsCase_ = 0;
            this.messageDetails_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearModal() {
            if (this.messageDetailsCase_ == 2) {
                this.messageDetailsCase_ = 0;
                this.messageDetails_ = null;
            }
        }

        public static Content getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeBanner(BannerMessage bannerMessage) {
            if (this.messageDetailsCase_ == 1 && this.messageDetails_ != BannerMessage.getDefaultInstance()) {
                bannerMessage = BannerMessage.newBuilder((BannerMessage) this.messageDetails_).mergeFrom((BannerMessage.Builder) bannerMessage).buildPartial();
            }
            this.messageDetails_ = bannerMessage;
            this.messageDetailsCase_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeCard(CardMessage cardMessage) {
            if (this.messageDetailsCase_ == 4 && this.messageDetails_ != CardMessage.getDefaultInstance()) {
                cardMessage = CardMessage.newBuilder((CardMessage) this.messageDetails_).mergeFrom((CardMessage.Builder) cardMessage).buildPartial();
            }
            this.messageDetails_ = cardMessage;
            this.messageDetailsCase_ = 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeImageOnly(ImageOnlyMessage imageOnlyMessage) {
            if (this.messageDetailsCase_ == 3 && this.messageDetails_ != ImageOnlyMessage.getDefaultInstance()) {
                imageOnlyMessage = ImageOnlyMessage.newBuilder((ImageOnlyMessage) this.messageDetails_).mergeFrom((ImageOnlyMessage.Builder) imageOnlyMessage).buildPartial();
            }
            this.messageDetails_ = imageOnlyMessage;
            this.messageDetailsCase_ = 3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeModal(ModalMessage modalMessage) {
            if (this.messageDetailsCase_ == 2 && this.messageDetails_ != ModalMessage.getDefaultInstance()) {
                modalMessage = ModalMessage.newBuilder((ModalMessage) this.messageDetails_).mergeFrom((ModalMessage.Builder) modalMessage).buildPartial();
            }
            this.messageDetails_ = modalMessage;
            this.messageDetailsCase_ = 2;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Content content) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) content);
        }

        public static Content parseDelimitedFrom(InputStream inputStream) {
            return (Content) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static Content parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Content) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Content parseFrom(ByteString byteString) {
            return (Content) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static Content parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (Content) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Content parseFrom(CodedInputStream codedInputStream) {
            return (Content) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Content parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Content) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Content parseFrom(InputStream inputStream) {
            return (Content) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static Content parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Content) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Content parseFrom(byte[] bArr) {
            return (Content) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static Content parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (Content) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<Content> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBanner(BannerMessage.Builder builder) {
            this.messageDetails_ = builder.build();
            this.messageDetailsCase_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBanner(BannerMessage bannerMessage) {
            if (bannerMessage == null) {
                throw new NullPointerException();
            }
            this.messageDetails_ = bannerMessage;
            this.messageDetailsCase_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCard(CardMessage.Builder builder) {
            this.messageDetails_ = builder.build();
            this.messageDetailsCase_ = 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCard(CardMessage cardMessage) {
            if (cardMessage == null) {
                throw new NullPointerException();
            }
            this.messageDetails_ = cardMessage;
            this.messageDetailsCase_ = 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setImageOnly(ImageOnlyMessage.Builder builder) {
            this.messageDetails_ = builder.build();
            this.messageDetailsCase_ = 3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setImageOnly(ImageOnlyMessage imageOnlyMessage) {
            if (imageOnlyMessage == null) {
                throw new NullPointerException();
            }
            this.messageDetails_ = imageOnlyMessage;
            this.messageDetailsCase_ = 3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setModal(ModalMessage.Builder builder) {
            this.messageDetails_ = builder.build();
            this.messageDetailsCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setModal(ModalMessage modalMessage) {
            if (modalMessage == null) {
                throw new NullPointerException();
            }
            this.messageDetails_ = modalMessage;
            this.messageDetailsCase_ = 2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:118:0x0158, code lost:
        
            if (r7.messageDetailsCase_ == 4) goto L103;
         */
        /* JADX WARN: Code restructure failed: missing block: B:119:0x016a, code lost:
        
            r7.messageDetails_ = r9.visitOneofMessage(r3, r7.messageDetails_, r10.messageDetails_);
         */
        /* JADX WARN: Code restructure failed: missing block: B:120:0x0169, code lost:
        
            r3 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:122:0x015d, code lost:
        
            if (r7.messageDetailsCase_ == 3) goto L103;
         */
        /* JADX WARN: Code restructure failed: missing block: B:124:0x0162, code lost:
        
            if (r7.messageDetailsCase_ == 2) goto L103;
         */
        /* JADX WARN: Code restructure failed: missing block: B:126:0x0167, code lost:
        
            if (r7.messageDetailsCase_ == 1) goto L103;
         */
        @Override // com.google.protobuf.GeneratedMessageLite
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected final java.lang.Object a(com.google.protobuf.GeneratedMessageLite.MethodToInvoke r8, java.lang.Object r9, java.lang.Object r10) {
            /*
                Method dump skipped, instructions count: 420
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.inappmessaging.MessagesProto.Content.a(com.google.protobuf.GeneratedMessageLite$MethodToInvoke, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.ContentOrBuilder
        public BannerMessage getBanner() {
            return this.messageDetailsCase_ == 1 ? (BannerMessage) this.messageDetails_ : BannerMessage.getDefaultInstance();
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.ContentOrBuilder
        public CardMessage getCard() {
            return this.messageDetailsCase_ == 4 ? (CardMessage) this.messageDetails_ : CardMessage.getDefaultInstance();
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.ContentOrBuilder
        public ImageOnlyMessage getImageOnly() {
            return this.messageDetailsCase_ == 3 ? (ImageOnlyMessage) this.messageDetails_ : ImageOnlyMessage.getDefaultInstance();
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.ContentOrBuilder
        public MessageDetailsCase getMessageDetailsCase() {
            return MessageDetailsCase.forNumber(this.messageDetailsCase_);
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.ContentOrBuilder
        public ModalMessage getModal() {
            return this.messageDetailsCase_ == 2 ? (ModalMessage) this.messageDetails_ : ModalMessage.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeMessageSize = this.messageDetailsCase_ == 1 ? 0 + CodedOutputStream.computeMessageSize(1, (BannerMessage) this.messageDetails_) : 0;
            if (this.messageDetailsCase_ == 2) {
                computeMessageSize += CodedOutputStream.computeMessageSize(2, (ModalMessage) this.messageDetails_);
            }
            if (this.messageDetailsCase_ == 3) {
                computeMessageSize += CodedOutputStream.computeMessageSize(3, (ImageOnlyMessage) this.messageDetails_);
            }
            if (this.messageDetailsCase_ == 4) {
                computeMessageSize += CodedOutputStream.computeMessageSize(4, (CardMessage) this.messageDetails_);
            }
            this.c = computeMessageSize;
            return computeMessageSize;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if (this.messageDetailsCase_ == 1) {
                codedOutputStream.writeMessage(1, (BannerMessage) this.messageDetails_);
            }
            if (this.messageDetailsCase_ == 2) {
                codedOutputStream.writeMessage(2, (ModalMessage) this.messageDetails_);
            }
            if (this.messageDetailsCase_ == 3) {
                codedOutputStream.writeMessage(3, (ImageOnlyMessage) this.messageDetails_);
            }
            if (this.messageDetailsCase_ == 4) {
                codedOutputStream.writeMessage(4, (CardMessage) this.messageDetails_);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface ContentOrBuilder extends MessageLiteOrBuilder {
        BannerMessage getBanner();

        CardMessage getCard();

        ImageOnlyMessage getImageOnly();

        Content.MessageDetailsCase getMessageDetailsCase();

        ModalMessage getModal();
    }

    /* loaded from: classes2.dex */
    public static final class ImageOnlyMessage extends GeneratedMessageLite<ImageOnlyMessage, Builder> implements ImageOnlyMessageOrBuilder {
        public static final int ACTION_FIELD_NUMBER = 2;
        private static final ImageOnlyMessage DEFAULT_INSTANCE = new ImageOnlyMessage();
        public static final int IMAGE_URL_FIELD_NUMBER = 1;
        private static volatile Parser<ImageOnlyMessage> PARSER;
        private Action action_;
        private String imageUrl_ = "";

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<ImageOnlyMessage, Builder> implements ImageOnlyMessageOrBuilder {
            private Builder() {
                super(ImageOnlyMessage.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAction() {
                a();
                ((ImageOnlyMessage) this.a).clearAction();
                return this;
            }

            public Builder clearImageUrl() {
                a();
                ((ImageOnlyMessage) this.a).clearImageUrl();
                return this;
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.ImageOnlyMessageOrBuilder
            public Action getAction() {
                return ((ImageOnlyMessage) this.a).getAction();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.ImageOnlyMessageOrBuilder
            public String getImageUrl() {
                return ((ImageOnlyMessage) this.a).getImageUrl();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.ImageOnlyMessageOrBuilder
            public ByteString getImageUrlBytes() {
                return ((ImageOnlyMessage) this.a).getImageUrlBytes();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.ImageOnlyMessageOrBuilder
            public boolean hasAction() {
                return ((ImageOnlyMessage) this.a).hasAction();
            }

            public Builder mergeAction(Action action) {
                a();
                ((ImageOnlyMessage) this.a).mergeAction(action);
                return this;
            }

            public Builder setAction(Action.Builder builder) {
                a();
                ((ImageOnlyMessage) this.a).setAction(builder);
                return this;
            }

            public Builder setAction(Action action) {
                a();
                ((ImageOnlyMessage) this.a).setAction(action);
                return this;
            }

            public Builder setImageUrl(String str) {
                a();
                ((ImageOnlyMessage) this.a).setImageUrl(str);
                return this;
            }

            public Builder setImageUrlBytes(ByteString byteString) {
                a();
                ((ImageOnlyMessage) this.a).setImageUrlBytes(byteString);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private ImageOnlyMessage() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAction() {
            this.action_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearImageUrl() {
            this.imageUrl_ = getDefaultInstance().getImageUrl();
        }

        public static ImageOnlyMessage getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeAction(Action action) {
            Action action2 = this.action_;
            if (action2 != null && action2 != Action.getDefaultInstance()) {
                action = Action.newBuilder(this.action_).mergeFrom((Action.Builder) action).buildPartial();
            }
            this.action_ = action;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ImageOnlyMessage imageOnlyMessage) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) imageOnlyMessage);
        }

        public static ImageOnlyMessage parseDelimitedFrom(InputStream inputStream) {
            return (ImageOnlyMessage) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static ImageOnlyMessage parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ImageOnlyMessage) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ImageOnlyMessage parseFrom(ByteString byteString) {
            return (ImageOnlyMessage) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static ImageOnlyMessage parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ImageOnlyMessage) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ImageOnlyMessage parseFrom(CodedInputStream codedInputStream) {
            return (ImageOnlyMessage) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ImageOnlyMessage parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ImageOnlyMessage) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static ImageOnlyMessage parseFrom(InputStream inputStream) {
            return (ImageOnlyMessage) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static ImageOnlyMessage parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ImageOnlyMessage) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ImageOnlyMessage parseFrom(byte[] bArr) {
            return (ImageOnlyMessage) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static ImageOnlyMessage parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ImageOnlyMessage) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<ImageOnlyMessage> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAction(Action.Builder builder) {
            this.action_ = builder.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAction(Action action) {
            if (action == null) {
                throw new NullPointerException();
            }
            this.action_ = action;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setImageUrl(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.imageUrl_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setImageUrlBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.a(byteString);
            this.imageUrl_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.b[methodToInvoke.ordinal()]) {
                case 1:
                    return new ImageOnlyMessage();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    ImageOnlyMessage imageOnlyMessage = (ImageOnlyMessage) obj2;
                    this.imageUrl_ = visitor.visitString(!this.imageUrl_.isEmpty(), this.imageUrl_, true ^ imageOnlyMessage.imageUrl_.isEmpty(), imageOnlyMessage.imageUrl_);
                    this.action_ = (Action) visitor.visitMessage(this.action_, imageOnlyMessage.action_);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
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
                                    this.imageUrl_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 18) {
                                    Action.Builder builder = this.action_ != null ? this.action_.toBuilder() : null;
                                    this.action_ = (Action) codedInputStream.readMessage(Action.parser(), extensionRegistryLite);
                                    if (builder != null) {
                                        builder.mergeFrom((Action.Builder) this.action_);
                                        this.action_ = builder.buildPartial();
                                    }
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
                        synchronized (ImageOnlyMessage.class) {
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

        @Override // com.google.firebase.inappmessaging.MessagesProto.ImageOnlyMessageOrBuilder
        public Action getAction() {
            Action action = this.action_;
            return action == null ? Action.getDefaultInstance() : action;
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.ImageOnlyMessageOrBuilder
        public String getImageUrl() {
            return this.imageUrl_;
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.ImageOnlyMessageOrBuilder
        public ByteString getImageUrlBytes() {
            return ByteString.copyFromUtf8(this.imageUrl_);
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeStringSize = this.imageUrl_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getImageUrl());
            if (this.action_ != null) {
                computeStringSize += CodedOutputStream.computeMessageSize(2, getAction());
            }
            this.c = computeStringSize;
            return computeStringSize;
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.ImageOnlyMessageOrBuilder
        public boolean hasAction() {
            return this.action_ != null;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if (!this.imageUrl_.isEmpty()) {
                codedOutputStream.writeString(1, getImageUrl());
            }
            if (this.action_ != null) {
                codedOutputStream.writeMessage(2, getAction());
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface ImageOnlyMessageOrBuilder extends MessageLiteOrBuilder {
        Action getAction();

        String getImageUrl();

        ByteString getImageUrlBytes();

        boolean hasAction();
    }

    /* loaded from: classes2.dex */
    public static final class ModalMessage extends GeneratedMessageLite<ModalMessage, Builder> implements ModalMessageOrBuilder {
        public static final int ACTION_BUTTON_FIELD_NUMBER = 4;
        public static final int ACTION_FIELD_NUMBER = 5;
        public static final int BACKGROUND_HEX_COLOR_FIELD_NUMBER = 6;
        public static final int BODY_FIELD_NUMBER = 2;
        private static final ModalMessage DEFAULT_INSTANCE = new ModalMessage();
        public static final int IMAGE_URL_FIELD_NUMBER = 3;
        private static volatile Parser<ModalMessage> PARSER = null;
        public static final int TITLE_FIELD_NUMBER = 1;
        private Button actionButton_;
        private Action action_;
        private Text body_;
        private Text title_;
        private String imageUrl_ = "";
        private String backgroundHexColor_ = "";

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<ModalMessage, Builder> implements ModalMessageOrBuilder {
            private Builder() {
                super(ModalMessage.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAction() {
                a();
                ((ModalMessage) this.a).clearAction();
                return this;
            }

            public Builder clearActionButton() {
                a();
                ((ModalMessage) this.a).clearActionButton();
                return this;
            }

            public Builder clearBackgroundHexColor() {
                a();
                ((ModalMessage) this.a).clearBackgroundHexColor();
                return this;
            }

            public Builder clearBody() {
                a();
                ((ModalMessage) this.a).clearBody();
                return this;
            }

            public Builder clearImageUrl() {
                a();
                ((ModalMessage) this.a).clearImageUrl();
                return this;
            }

            public Builder clearTitle() {
                a();
                ((ModalMessage) this.a).clearTitle();
                return this;
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.ModalMessageOrBuilder
            public Action getAction() {
                return ((ModalMessage) this.a).getAction();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.ModalMessageOrBuilder
            public Button getActionButton() {
                return ((ModalMessage) this.a).getActionButton();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.ModalMessageOrBuilder
            public String getBackgroundHexColor() {
                return ((ModalMessage) this.a).getBackgroundHexColor();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.ModalMessageOrBuilder
            public ByteString getBackgroundHexColorBytes() {
                return ((ModalMessage) this.a).getBackgroundHexColorBytes();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.ModalMessageOrBuilder
            public Text getBody() {
                return ((ModalMessage) this.a).getBody();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.ModalMessageOrBuilder
            public String getImageUrl() {
                return ((ModalMessage) this.a).getImageUrl();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.ModalMessageOrBuilder
            public ByteString getImageUrlBytes() {
                return ((ModalMessage) this.a).getImageUrlBytes();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.ModalMessageOrBuilder
            public Text getTitle() {
                return ((ModalMessage) this.a).getTitle();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.ModalMessageOrBuilder
            public boolean hasAction() {
                return ((ModalMessage) this.a).hasAction();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.ModalMessageOrBuilder
            public boolean hasActionButton() {
                return ((ModalMessage) this.a).hasActionButton();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.ModalMessageOrBuilder
            public boolean hasBody() {
                return ((ModalMessage) this.a).hasBody();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.ModalMessageOrBuilder
            public boolean hasTitle() {
                return ((ModalMessage) this.a).hasTitle();
            }

            public Builder mergeAction(Action action) {
                a();
                ((ModalMessage) this.a).mergeAction(action);
                return this;
            }

            public Builder mergeActionButton(Button button) {
                a();
                ((ModalMessage) this.a).mergeActionButton(button);
                return this;
            }

            public Builder mergeBody(Text text) {
                a();
                ((ModalMessage) this.a).mergeBody(text);
                return this;
            }

            public Builder mergeTitle(Text text) {
                a();
                ((ModalMessage) this.a).mergeTitle(text);
                return this;
            }

            public Builder setAction(Action.Builder builder) {
                a();
                ((ModalMessage) this.a).setAction(builder);
                return this;
            }

            public Builder setAction(Action action) {
                a();
                ((ModalMessage) this.a).setAction(action);
                return this;
            }

            public Builder setActionButton(Button.Builder builder) {
                a();
                ((ModalMessage) this.a).setActionButton(builder);
                return this;
            }

            public Builder setActionButton(Button button) {
                a();
                ((ModalMessage) this.a).setActionButton(button);
                return this;
            }

            public Builder setBackgroundHexColor(String str) {
                a();
                ((ModalMessage) this.a).setBackgroundHexColor(str);
                return this;
            }

            public Builder setBackgroundHexColorBytes(ByteString byteString) {
                a();
                ((ModalMessage) this.a).setBackgroundHexColorBytes(byteString);
                return this;
            }

            public Builder setBody(Text.Builder builder) {
                a();
                ((ModalMessage) this.a).setBody(builder);
                return this;
            }

            public Builder setBody(Text text) {
                a();
                ((ModalMessage) this.a).setBody(text);
                return this;
            }

            public Builder setImageUrl(String str) {
                a();
                ((ModalMessage) this.a).setImageUrl(str);
                return this;
            }

            public Builder setImageUrlBytes(ByteString byteString) {
                a();
                ((ModalMessage) this.a).setImageUrlBytes(byteString);
                return this;
            }

            public Builder setTitle(Text.Builder builder) {
                a();
                ((ModalMessage) this.a).setTitle(builder);
                return this;
            }

            public Builder setTitle(Text text) {
                a();
                ((ModalMessage) this.a).setTitle(text);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private ModalMessage() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAction() {
            this.action_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearActionButton() {
            this.actionButton_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBackgroundHexColor() {
            this.backgroundHexColor_ = getDefaultInstance().getBackgroundHexColor();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBody() {
            this.body_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearImageUrl() {
            this.imageUrl_ = getDefaultInstance().getImageUrl();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTitle() {
            this.title_ = null;
        }

        public static ModalMessage getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeAction(Action action) {
            Action action2 = this.action_;
            if (action2 != null && action2 != Action.getDefaultInstance()) {
                action = Action.newBuilder(this.action_).mergeFrom((Action.Builder) action).buildPartial();
            }
            this.action_ = action;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeActionButton(Button button) {
            Button button2 = this.actionButton_;
            if (button2 != null && button2 != Button.getDefaultInstance()) {
                button = Button.newBuilder(this.actionButton_).mergeFrom((Button.Builder) button).buildPartial();
            }
            this.actionButton_ = button;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeBody(Text text) {
            Text text2 = this.body_;
            if (text2 != null && text2 != Text.getDefaultInstance()) {
                text = Text.newBuilder(this.body_).mergeFrom((Text.Builder) text).buildPartial();
            }
            this.body_ = text;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeTitle(Text text) {
            Text text2 = this.title_;
            if (text2 != null && text2 != Text.getDefaultInstance()) {
                text = Text.newBuilder(this.title_).mergeFrom((Text.Builder) text).buildPartial();
            }
            this.title_ = text;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ModalMessage modalMessage) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) modalMessage);
        }

        public static ModalMessage parseDelimitedFrom(InputStream inputStream) {
            return (ModalMessage) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static ModalMessage parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ModalMessage) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ModalMessage parseFrom(ByteString byteString) {
            return (ModalMessage) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static ModalMessage parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ModalMessage) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ModalMessage parseFrom(CodedInputStream codedInputStream) {
            return (ModalMessage) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ModalMessage parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ModalMessage) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static ModalMessage parseFrom(InputStream inputStream) {
            return (ModalMessage) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static ModalMessage parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ModalMessage) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ModalMessage parseFrom(byte[] bArr) {
            return (ModalMessage) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static ModalMessage parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ModalMessage) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<ModalMessage> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAction(Action.Builder builder) {
            this.action_ = builder.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAction(Action action) {
            if (action == null) {
                throw new NullPointerException();
            }
            this.action_ = action;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setActionButton(Button.Builder builder) {
            this.actionButton_ = builder.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setActionButton(Button button) {
            if (button == null) {
                throw new NullPointerException();
            }
            this.actionButton_ = button;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBackgroundHexColor(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.backgroundHexColor_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBackgroundHexColorBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.a(byteString);
            this.backgroundHexColor_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBody(Text.Builder builder) {
            this.body_ = builder.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBody(Text text) {
            if (text == null) {
                throw new NullPointerException();
            }
            this.body_ = text;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setImageUrl(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.imageUrl_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setImageUrlBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.a(byteString);
            this.imageUrl_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTitle(Text.Builder builder) {
            this.title_ = builder.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTitle(Text text) {
            if (text == null) {
                throw new NullPointerException();
            }
            this.title_ = text;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.b[methodToInvoke.ordinal()]) {
                case 1:
                    return new ModalMessage();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    ModalMessage modalMessage = (ModalMessage) obj2;
                    this.title_ = (Text) visitor.visitMessage(this.title_, modalMessage.title_);
                    this.body_ = (Text) visitor.visitMessage(this.body_, modalMessage.body_);
                    this.imageUrl_ = visitor.visitString(!this.imageUrl_.isEmpty(), this.imageUrl_, !modalMessage.imageUrl_.isEmpty(), modalMessage.imageUrl_);
                    this.actionButton_ = (Button) visitor.visitMessage(this.actionButton_, modalMessage.actionButton_);
                    this.action_ = (Action) visitor.visitMessage(this.action_, modalMessage.action_);
                    this.backgroundHexColor_ = visitor.visitString(!this.backgroundHexColor_.isEmpty(), this.backgroundHexColor_, true ^ modalMessage.backgroundHexColor_.isEmpty(), modalMessage.backgroundHexColor_);
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
                                        Text.Builder builder = this.title_ != null ? this.title_.toBuilder() : null;
                                        this.title_ = (Text) codedInputStream.readMessage(Text.parser(), extensionRegistryLite);
                                        if (builder != null) {
                                            builder.mergeFrom((Text.Builder) this.title_);
                                            this.title_ = builder.buildPartial();
                                        }
                                    } else if (readTag == 18) {
                                        Text.Builder builder2 = this.body_ != null ? this.body_.toBuilder() : null;
                                        this.body_ = (Text) codedInputStream.readMessage(Text.parser(), extensionRegistryLite);
                                        if (builder2 != null) {
                                            builder2.mergeFrom((Text.Builder) this.body_);
                                            this.body_ = builder2.buildPartial();
                                        }
                                    } else if (readTag == 26) {
                                        this.imageUrl_ = codedInputStream.readStringRequireUtf8();
                                    } else if (readTag == 34) {
                                        Button.Builder builder3 = this.actionButton_ != null ? this.actionButton_.toBuilder() : null;
                                        this.actionButton_ = (Button) codedInputStream.readMessage(Button.parser(), extensionRegistryLite);
                                        if (builder3 != null) {
                                            builder3.mergeFrom((Button.Builder) this.actionButton_);
                                            this.actionButton_ = builder3.buildPartial();
                                        }
                                    } else if (readTag == 42) {
                                        Action.Builder builder4 = this.action_ != null ? this.action_.toBuilder() : null;
                                        this.action_ = (Action) codedInputStream.readMessage(Action.parser(), extensionRegistryLite);
                                        if (builder4 != null) {
                                            builder4.mergeFrom((Action.Builder) this.action_);
                                            this.action_ = builder4.buildPartial();
                                        }
                                    } else if (readTag == 50) {
                                        this.backgroundHexColor_ = codedInputStream.readStringRequireUtf8();
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
                        synchronized (ModalMessage.class) {
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

        @Override // com.google.firebase.inappmessaging.MessagesProto.ModalMessageOrBuilder
        public Action getAction() {
            Action action = this.action_;
            return action == null ? Action.getDefaultInstance() : action;
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.ModalMessageOrBuilder
        public Button getActionButton() {
            Button button = this.actionButton_;
            return button == null ? Button.getDefaultInstance() : button;
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.ModalMessageOrBuilder
        public String getBackgroundHexColor() {
            return this.backgroundHexColor_;
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.ModalMessageOrBuilder
        public ByteString getBackgroundHexColorBytes() {
            return ByteString.copyFromUtf8(this.backgroundHexColor_);
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.ModalMessageOrBuilder
        public Text getBody() {
            Text text = this.body_;
            return text == null ? Text.getDefaultInstance() : text;
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.ModalMessageOrBuilder
        public String getImageUrl() {
            return this.imageUrl_;
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.ModalMessageOrBuilder
        public ByteString getImageUrlBytes() {
            return ByteString.copyFromUtf8(this.imageUrl_);
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeMessageSize = this.title_ != null ? 0 + CodedOutputStream.computeMessageSize(1, getTitle()) : 0;
            if (this.body_ != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(2, getBody());
            }
            if (!this.imageUrl_.isEmpty()) {
                computeMessageSize += CodedOutputStream.computeStringSize(3, getImageUrl());
            }
            if (this.actionButton_ != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(4, getActionButton());
            }
            if (this.action_ != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(5, getAction());
            }
            if (!this.backgroundHexColor_.isEmpty()) {
                computeMessageSize += CodedOutputStream.computeStringSize(6, getBackgroundHexColor());
            }
            this.c = computeMessageSize;
            return computeMessageSize;
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.ModalMessageOrBuilder
        public Text getTitle() {
            Text text = this.title_;
            return text == null ? Text.getDefaultInstance() : text;
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.ModalMessageOrBuilder
        public boolean hasAction() {
            return this.action_ != null;
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.ModalMessageOrBuilder
        public boolean hasActionButton() {
            return this.actionButton_ != null;
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.ModalMessageOrBuilder
        public boolean hasBody() {
            return this.body_ != null;
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.ModalMessageOrBuilder
        public boolean hasTitle() {
            return this.title_ != null;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if (this.title_ != null) {
                codedOutputStream.writeMessage(1, getTitle());
            }
            if (this.body_ != null) {
                codedOutputStream.writeMessage(2, getBody());
            }
            if (!this.imageUrl_.isEmpty()) {
                codedOutputStream.writeString(3, getImageUrl());
            }
            if (this.actionButton_ != null) {
                codedOutputStream.writeMessage(4, getActionButton());
            }
            if (this.action_ != null) {
                codedOutputStream.writeMessage(5, getAction());
            }
            if (this.backgroundHexColor_.isEmpty()) {
                return;
            }
            codedOutputStream.writeString(6, getBackgroundHexColor());
        }
    }

    /* loaded from: classes2.dex */
    public interface ModalMessageOrBuilder extends MessageLiteOrBuilder {
        Action getAction();

        Button getActionButton();

        String getBackgroundHexColor();

        ByteString getBackgroundHexColorBytes();

        Text getBody();

        String getImageUrl();

        ByteString getImageUrlBytes();

        Text getTitle();

        boolean hasAction();

        boolean hasActionButton();

        boolean hasBody();

        boolean hasTitle();
    }

    /* loaded from: classes2.dex */
    public static final class Text extends GeneratedMessageLite<Text, Builder> implements TextOrBuilder {
        private static final Text DEFAULT_INSTANCE = new Text();
        public static final int HEX_COLOR_FIELD_NUMBER = 2;
        private static volatile Parser<Text> PARSER = null;
        public static final int TEXT_FIELD_NUMBER = 1;
        private String text_ = "";
        private String hexColor_ = "";

        /* loaded from: classes2.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Text, Builder> implements TextOrBuilder {
            private Builder() {
                super(Text.DEFAULT_INSTANCE);
            }

            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearHexColor() {
                a();
                ((Text) this.a).clearHexColor();
                return this;
            }

            public Builder clearText() {
                a();
                ((Text) this.a).clearText();
                return this;
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.TextOrBuilder
            public String getHexColor() {
                return ((Text) this.a).getHexColor();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.TextOrBuilder
            public ByteString getHexColorBytes() {
                return ((Text) this.a).getHexColorBytes();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.TextOrBuilder
            public String getText() {
                return ((Text) this.a).getText();
            }

            @Override // com.google.firebase.inappmessaging.MessagesProto.TextOrBuilder
            public ByteString getTextBytes() {
                return ((Text) this.a).getTextBytes();
            }

            public Builder setHexColor(String str) {
                a();
                ((Text) this.a).setHexColor(str);
                return this;
            }

            public Builder setHexColorBytes(ByteString byteString) {
                a();
                ((Text) this.a).setHexColorBytes(byteString);
                return this;
            }

            public Builder setText(String str) {
                a();
                ((Text) this.a).setText(str);
                return this;
            }

            public Builder setTextBytes(ByteString byteString) {
                a();
                ((Text) this.a).setTextBytes(byteString);
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE.b();
        }

        private Text() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearHexColor() {
            this.hexColor_ = getDefaultInstance().getHexColor();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearText() {
            this.text_ = getDefaultInstance().getText();
        }

        public static Text getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Text text) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom((Builder) text);
        }

        public static Text parseDelimitedFrom(InputStream inputStream) {
            return (Text) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream);
        }

        public static Text parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Text) GeneratedMessageLite.a(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Text parseFrom(ByteString byteString) {
            return (Text) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString);
        }

        public static Text parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (Text) GeneratedMessageLite.a(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Text parseFrom(CodedInputStream codedInputStream) {
            return (Text) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Text parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Text) GeneratedMessageLite.a(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Text parseFrom(InputStream inputStream) {
            return (Text) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream);
        }

        public static Text parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Text) GeneratedMessageLite.b(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Text parseFrom(byte[] bArr) {
            return (Text) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr);
        }

        public static Text parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (Text) GeneratedMessageLite.a(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Parser<Text> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHexColor(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.hexColor_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHexColorBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.a(byteString);
            this.hexColor_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setText(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.text_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTextBytes(ByteString byteString) {
            if (byteString == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.a(byteString);
            this.text_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object a(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.b[methodToInvoke.ordinal()]) {
                case 1:
                    return new Text();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder(anonymousClass1);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    Text text = (Text) obj2;
                    this.text_ = visitor.visitString(!this.text_.isEmpty(), this.text_, !text.text_.isEmpty(), text.text_);
                    this.hexColor_ = visitor.visitString(!this.hexColor_.isEmpty(), this.hexColor_, true ^ text.hexColor_.isEmpty(), text.hexColor_);
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
                                    this.text_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 18) {
                                    this.hexColor_ = codedInputStream.readStringRequireUtf8();
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
                        synchronized (Text.class) {
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

        @Override // com.google.firebase.inappmessaging.MessagesProto.TextOrBuilder
        public String getHexColor() {
            return this.hexColor_;
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.TextOrBuilder
        public ByteString getHexColorBytes() {
            return ByteString.copyFromUtf8(this.hexColor_);
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int computeStringSize = this.text_.isEmpty() ? 0 : 0 + CodedOutputStream.computeStringSize(1, getText());
            if (!this.hexColor_.isEmpty()) {
                computeStringSize += CodedOutputStream.computeStringSize(2, getHexColor());
            }
            this.c = computeStringSize;
            return computeStringSize;
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.TextOrBuilder
        public String getText() {
            return this.text_;
        }

        @Override // com.google.firebase.inappmessaging.MessagesProto.TextOrBuilder
        public ByteString getTextBytes() {
            return ByteString.copyFromUtf8(this.text_);
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if (!this.text_.isEmpty()) {
                codedOutputStream.writeString(1, getText());
            }
            if (this.hexColor_.isEmpty()) {
                return;
            }
            codedOutputStream.writeString(2, getHexColor());
        }
    }

    /* loaded from: classes2.dex */
    public interface TextOrBuilder extends MessageLiteOrBuilder {
        String getHexColor();

        ByteString getHexColorBytes();

        String getText();

        ByteString getTextBytes();
    }

    private MessagesProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
