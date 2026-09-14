package io.flutter.plugins.localauth;

import android.util.Log;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugins.localauth.Messages;
import java.io.ByteArrayOutputStream;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class Messages {

    /* loaded from: classes.dex */
    public enum AuthClassification {
        WEAK(0),
        STRONG(1);

        final int index;

        AuthClassification(int i) {
            this.index = i;
        }
    }

    /* loaded from: classes.dex */
    public static final class AuthOptions {
        private Boolean biometricOnly;
        private Boolean sensitiveTransaction;
        private Boolean sticky;
        private Boolean useErrorDialgs;

        /* loaded from: classes.dex */
        public static final class Builder {
            private Boolean biometricOnly;
            private Boolean sensitiveTransaction;
            private Boolean sticky;
            private Boolean useErrorDialgs;

            public AuthOptions build() {
                AuthOptions authOptions = new AuthOptions();
                authOptions.setBiometricOnly(this.biometricOnly);
                authOptions.setSensitiveTransaction(this.sensitiveTransaction);
                authOptions.setSticky(this.sticky);
                authOptions.setUseErrorDialgs(this.useErrorDialgs);
                return authOptions;
            }

            public Builder setBiometricOnly(Boolean bool) {
                this.biometricOnly = bool;
                return this;
            }

            public Builder setSensitiveTransaction(Boolean bool) {
                this.sensitiveTransaction = bool;
                return this;
            }

            public Builder setSticky(Boolean bool) {
                this.sticky = bool;
                return this;
            }

            public Builder setUseErrorDialgs(Boolean bool) {
                this.useErrorDialgs = bool;
                return this;
            }
        }

        public static AuthOptions fromList(ArrayList<Object> arrayList) {
            AuthOptions authOptions = new AuthOptions();
            authOptions.setBiometricOnly((Boolean) arrayList.get(0));
            authOptions.setSensitiveTransaction((Boolean) arrayList.get(1));
            authOptions.setSticky((Boolean) arrayList.get(2));
            authOptions.setUseErrorDialgs((Boolean) arrayList.get(3));
            return authOptions;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && AuthOptions.class == obj.getClass()) {
                AuthOptions authOptions = (AuthOptions) obj;
                if (this.biometricOnly.equals(authOptions.biometricOnly) && this.sensitiveTransaction.equals(authOptions.sensitiveTransaction) && this.sticky.equals(authOptions.sticky) && this.useErrorDialgs.equals(authOptions.useErrorDialgs)) {
                    return true;
                }
            }
            return false;
        }

        public Boolean getBiometricOnly() {
            return this.biometricOnly;
        }

        public Boolean getSensitiveTransaction() {
            return this.sensitiveTransaction;
        }

        public Boolean getSticky() {
            return this.sticky;
        }

        public Boolean getUseErrorDialgs() {
            return this.useErrorDialgs;
        }

        public int hashCode() {
            return Objects.hash(this.biometricOnly, this.sensitiveTransaction, this.sticky, this.useErrorDialgs);
        }

        public void setBiometricOnly(Boolean bool) {
            if (bool != null) {
                this.biometricOnly = bool;
                return;
            }
            throw new IllegalStateException("Nonnull field \"biometricOnly\" is null.");
        }

        public void setSensitiveTransaction(Boolean bool) {
            if (bool != null) {
                this.sensitiveTransaction = bool;
                return;
            }
            throw new IllegalStateException("Nonnull field \"sensitiveTransaction\" is null.");
        }

        public void setSticky(Boolean bool) {
            if (bool != null) {
                this.sticky = bool;
                return;
            }
            throw new IllegalStateException("Nonnull field \"sticky\" is null.");
        }

        public void setUseErrorDialgs(Boolean bool) {
            if (bool != null) {
                this.useErrorDialgs = bool;
                return;
            }
            throw new IllegalStateException("Nonnull field \"useErrorDialgs\" is null.");
        }

        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(4);
            arrayList.add(this.biometricOnly);
            arrayList.add(this.sensitiveTransaction);
            arrayList.add(this.sticky);
            arrayList.add(this.useErrorDialgs);
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public enum AuthResult {
        SUCCESS(0),
        FAILURE(1),
        ERROR_ALREADY_IN_PROGRESS(2),
        ERROR_NO_ACTIVITY(3),
        ERROR_NOT_FRAGMENT_ACTIVITY(4),
        ERROR_NOT_AVAILABLE(5),
        ERROR_NOT_ENROLLED(6),
        ERROR_LOCKED_OUT_TEMPORARILY(7),
        ERROR_LOCKED_OUT_PERMANENTLY(8);

        final int index;

        AuthResult(int i) {
            this.index = i;
        }
    }

    /* loaded from: classes.dex */
    public static final class AuthStrings {
        private String biometricHint;
        private String biometricNotRecognized;
        private String biometricRequiredTitle;
        private String cancelButton;
        private String deviceCredentialsRequiredTitle;
        private String deviceCredentialsSetupDescription;
        private String goToSettingsButton;
        private String goToSettingsDescription;
        private String reason;
        private String signInTitle;

        /* loaded from: classes.dex */
        public static final class Builder {
            private String biometricHint;
            private String biometricNotRecognized;
            private String biometricRequiredTitle;
            private String cancelButton;
            private String deviceCredentialsRequiredTitle;
            private String deviceCredentialsSetupDescription;
            private String goToSettingsButton;
            private String goToSettingsDescription;
            private String reason;
            private String signInTitle;

            public AuthStrings build() {
                AuthStrings authStrings = new AuthStrings();
                authStrings.setReason(this.reason);
                authStrings.setBiometricHint(this.biometricHint);
                authStrings.setBiometricNotRecognized(this.biometricNotRecognized);
                authStrings.setBiometricRequiredTitle(this.biometricRequiredTitle);
                authStrings.setCancelButton(this.cancelButton);
                authStrings.setDeviceCredentialsRequiredTitle(this.deviceCredentialsRequiredTitle);
                authStrings.setDeviceCredentialsSetupDescription(this.deviceCredentialsSetupDescription);
                authStrings.setGoToSettingsButton(this.goToSettingsButton);
                authStrings.setGoToSettingsDescription(this.goToSettingsDescription);
                authStrings.setSignInTitle(this.signInTitle);
                return authStrings;
            }

            public Builder setBiometricHint(String str) {
                this.biometricHint = str;
                return this;
            }

            public Builder setBiometricNotRecognized(String str) {
                this.biometricNotRecognized = str;
                return this;
            }

            public Builder setBiometricRequiredTitle(String str) {
                this.biometricRequiredTitle = str;
                return this;
            }

            public Builder setCancelButton(String str) {
                this.cancelButton = str;
                return this;
            }

            public Builder setDeviceCredentialsRequiredTitle(String str) {
                this.deviceCredentialsRequiredTitle = str;
                return this;
            }

            public Builder setDeviceCredentialsSetupDescription(String str) {
                this.deviceCredentialsSetupDescription = str;
                return this;
            }

            public Builder setGoToSettingsButton(String str) {
                this.goToSettingsButton = str;
                return this;
            }

            public Builder setGoToSettingsDescription(String str) {
                this.goToSettingsDescription = str;
                return this;
            }

            public Builder setReason(String str) {
                this.reason = str;
                return this;
            }

            public Builder setSignInTitle(String str) {
                this.signInTitle = str;
                return this;
            }
        }

        public static AuthStrings fromList(ArrayList<Object> arrayList) {
            AuthStrings authStrings = new AuthStrings();
            authStrings.setReason((String) arrayList.get(0));
            authStrings.setBiometricHint((String) arrayList.get(1));
            authStrings.setBiometricNotRecognized((String) arrayList.get(2));
            authStrings.setBiometricRequiredTitle((String) arrayList.get(3));
            authStrings.setCancelButton((String) arrayList.get(4));
            authStrings.setDeviceCredentialsRequiredTitle((String) arrayList.get(5));
            authStrings.setDeviceCredentialsSetupDescription((String) arrayList.get(6));
            authStrings.setGoToSettingsButton((String) arrayList.get(7));
            authStrings.setGoToSettingsDescription((String) arrayList.get(8));
            authStrings.setSignInTitle((String) arrayList.get(9));
            return authStrings;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && AuthStrings.class == obj.getClass()) {
                AuthStrings authStrings = (AuthStrings) obj;
                if (this.reason.equals(authStrings.reason) && this.biometricHint.equals(authStrings.biometricHint) && this.biometricNotRecognized.equals(authStrings.biometricNotRecognized) && this.biometricRequiredTitle.equals(authStrings.biometricRequiredTitle) && this.cancelButton.equals(authStrings.cancelButton) && this.deviceCredentialsRequiredTitle.equals(authStrings.deviceCredentialsRequiredTitle) && this.deviceCredentialsSetupDescription.equals(authStrings.deviceCredentialsSetupDescription) && this.goToSettingsButton.equals(authStrings.goToSettingsButton) && this.goToSettingsDescription.equals(authStrings.goToSettingsDescription) && this.signInTitle.equals(authStrings.signInTitle)) {
                    return true;
                }
            }
            return false;
        }

        public String getBiometricHint() {
            return this.biometricHint;
        }

        public String getBiometricNotRecognized() {
            return this.biometricNotRecognized;
        }

        public String getBiometricRequiredTitle() {
            return this.biometricRequiredTitle;
        }

        public String getCancelButton() {
            return this.cancelButton;
        }

        public String getDeviceCredentialsRequiredTitle() {
            return this.deviceCredentialsRequiredTitle;
        }

        public String getDeviceCredentialsSetupDescription() {
            return this.deviceCredentialsSetupDescription;
        }

        public String getGoToSettingsButton() {
            return this.goToSettingsButton;
        }

        public String getGoToSettingsDescription() {
            return this.goToSettingsDescription;
        }

        public String getReason() {
            return this.reason;
        }

        public String getSignInTitle() {
            return this.signInTitle;
        }

        public int hashCode() {
            return Objects.hash(this.reason, this.biometricHint, this.biometricNotRecognized, this.biometricRequiredTitle, this.cancelButton, this.deviceCredentialsRequiredTitle, this.deviceCredentialsSetupDescription, this.goToSettingsButton, this.goToSettingsDescription, this.signInTitle);
        }

        public void setBiometricHint(String str) {
            if (str != null) {
                this.biometricHint = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"biometricHint\" is null.");
        }

        public void setBiometricNotRecognized(String str) {
            if (str != null) {
                this.biometricNotRecognized = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"biometricNotRecognized\" is null.");
        }

        public void setBiometricRequiredTitle(String str) {
            if (str != null) {
                this.biometricRequiredTitle = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"biometricRequiredTitle\" is null.");
        }

        public void setCancelButton(String str) {
            if (str != null) {
                this.cancelButton = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"cancelButton\" is null.");
        }

        public void setDeviceCredentialsRequiredTitle(String str) {
            if (str != null) {
                this.deviceCredentialsRequiredTitle = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"deviceCredentialsRequiredTitle\" is null.");
        }

        public void setDeviceCredentialsSetupDescription(String str) {
            if (str != null) {
                this.deviceCredentialsSetupDescription = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"deviceCredentialsSetupDescription\" is null.");
        }

        public void setGoToSettingsButton(String str) {
            if (str != null) {
                this.goToSettingsButton = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"goToSettingsButton\" is null.");
        }

        public void setGoToSettingsDescription(String str) {
            if (str != null) {
                this.goToSettingsDescription = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"goToSettingsDescription\" is null.");
        }

        public void setReason(String str) {
            if (str != null) {
                this.reason = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"reason\" is null.");
        }

        public void setSignInTitle(String str) {
            if (str != null) {
                this.signInTitle = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"signInTitle\" is null.");
        }

        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(10);
            arrayList.add(this.reason);
            arrayList.add(this.biometricHint);
            arrayList.add(this.biometricNotRecognized);
            arrayList.add(this.biometricRequiredTitle);
            arrayList.add(this.cancelButton);
            arrayList.add(this.deviceCredentialsRequiredTitle);
            arrayList.add(this.deviceCredentialsSetupDescription);
            arrayList.add(this.goToSettingsButton);
            arrayList.add(this.goToSettingsDescription);
            arrayList.add(this.signInTitle);
            return arrayList;
        }
    }

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface CanIgnoreReturnValue {
    }

    /* loaded from: classes.dex */
    public static class FlutterError extends RuntimeException {
        public final String code;
        public final Object details;

        public FlutterError(String str, String str2, Object obj) {
            super(str2);
            this.code = str;
            this.details = obj;
        }
    }

    /* loaded from: classes.dex */
    public interface LocalAuthApi {
        static MessageCodec<Object> getCodec() {
            return PigeonCodec.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$0(LocalAuthApi localAuthApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                arrayList.add(0, localAuthApi.isDeviceSupported());
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$1(LocalAuthApi localAuthApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                arrayList.add(0, localAuthApi.deviceCanSupportBiometrics());
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$2(LocalAuthApi localAuthApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                arrayList.add(0, localAuthApi.stopAuthentication());
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$3(LocalAuthApi localAuthApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                arrayList.add(0, localAuthApi.getEnrolledBiometrics());
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$4(LocalAuthApi localAuthApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            localAuthApi.authenticate((AuthOptions) arrayList2.get(0), (AuthStrings) arrayList2.get(1), new Result<AuthResult>() { // from class: io.flutter.plugins.localauth.Messages.LocalAuthApi.1
                @Override // io.flutter.plugins.localauth.Messages.Result
                public void error(Throwable th) {
                    reply.reply(Messages.wrapError(th));
                }

                @Override // io.flutter.plugins.localauth.Messages.Result
                public void success(AuthResult authResult) {
                    arrayList.add(0, authResult);
                    reply.reply(arrayList);
                }
            });
        }

        static void setUp(BinaryMessenger binaryMessenger, LocalAuthApi localAuthApi) {
            setUp(binaryMessenger, "", localAuthApi);
        }

        void authenticate(AuthOptions authOptions, AuthStrings authStrings, Result<AuthResult> result);

        Boolean deviceCanSupportBiometrics();

        List<AuthClassification> getEnrolledBiometrics();

        Boolean isDeviceSupported();

        Boolean stopAuthentication();

        static void setUp(BinaryMessenger binaryMessenger, String str, final LocalAuthApi localAuthApi) {
            String concat = str.isEmpty() ? "" : ".".concat(str);
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, e0.a.d("dev.flutter.pigeon.local_auth_android.LocalAuthApi.isDeviceSupported", concat), getCodec());
            if (localAuthApi != null) {
                final int i = 0;
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler(localAuthApi) { // from class: io.flutter.plugins.localauth.d

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ Messages.LocalAuthApi f5090b;

                    {
                        this.f5090b = localAuthApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i) {
                            case 0:
                                Messages.LocalAuthApi.lambda$setUp$0(this.f5090b, obj, reply);
                                return;
                            case 1:
                                Messages.LocalAuthApi.lambda$setUp$1(this.f5090b, obj, reply);
                                return;
                            case 2:
                                Messages.LocalAuthApi.lambda$setUp$2(this.f5090b, obj, reply);
                                return;
                            case 3:
                                Messages.LocalAuthApi.lambda$setUp$3(this.f5090b, obj, reply);
                                return;
                            default:
                                Messages.LocalAuthApi.lambda$setUp$4(this.f5090b, obj, reply);
                                return;
                        }
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, e0.a.d("dev.flutter.pigeon.local_auth_android.LocalAuthApi.deviceCanSupportBiometrics", concat), getCodec());
            if (localAuthApi != null) {
                final int i3 = 1;
                basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler(localAuthApi) { // from class: io.flutter.plugins.localauth.d

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ Messages.LocalAuthApi f5090b;

                    {
                        this.f5090b = localAuthApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i3) {
                            case 0:
                                Messages.LocalAuthApi.lambda$setUp$0(this.f5090b, obj, reply);
                                return;
                            case 1:
                                Messages.LocalAuthApi.lambda$setUp$1(this.f5090b, obj, reply);
                                return;
                            case 2:
                                Messages.LocalAuthApi.lambda$setUp$2(this.f5090b, obj, reply);
                                return;
                            case 3:
                                Messages.LocalAuthApi.lambda$setUp$3(this.f5090b, obj, reply);
                                return;
                            default:
                                Messages.LocalAuthApi.lambda$setUp$4(this.f5090b, obj, reply);
                                return;
                        }
                    }
                });
            } else {
                basicMessageChannel2.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, e0.a.d("dev.flutter.pigeon.local_auth_android.LocalAuthApi.stopAuthentication", concat), getCodec());
            if (localAuthApi != null) {
                final int i4 = 2;
                basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler(localAuthApi) { // from class: io.flutter.plugins.localauth.d

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ Messages.LocalAuthApi f5090b;

                    {
                        this.f5090b = localAuthApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i4) {
                            case 0:
                                Messages.LocalAuthApi.lambda$setUp$0(this.f5090b, obj, reply);
                                return;
                            case 1:
                                Messages.LocalAuthApi.lambda$setUp$1(this.f5090b, obj, reply);
                                return;
                            case 2:
                                Messages.LocalAuthApi.lambda$setUp$2(this.f5090b, obj, reply);
                                return;
                            case 3:
                                Messages.LocalAuthApi.lambda$setUp$3(this.f5090b, obj, reply);
                                return;
                            default:
                                Messages.LocalAuthApi.lambda$setUp$4(this.f5090b, obj, reply);
                                return;
                        }
                    }
                });
            } else {
                basicMessageChannel3.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, e0.a.d("dev.flutter.pigeon.local_auth_android.LocalAuthApi.getEnrolledBiometrics", concat), getCodec());
            if (localAuthApi != null) {
                final int i5 = 3;
                basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler(localAuthApi) { // from class: io.flutter.plugins.localauth.d

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ Messages.LocalAuthApi f5090b;

                    {
                        this.f5090b = localAuthApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i5) {
                            case 0:
                                Messages.LocalAuthApi.lambda$setUp$0(this.f5090b, obj, reply);
                                return;
                            case 1:
                                Messages.LocalAuthApi.lambda$setUp$1(this.f5090b, obj, reply);
                                return;
                            case 2:
                                Messages.LocalAuthApi.lambda$setUp$2(this.f5090b, obj, reply);
                                return;
                            case 3:
                                Messages.LocalAuthApi.lambda$setUp$3(this.f5090b, obj, reply);
                                return;
                            default:
                                Messages.LocalAuthApi.lambda$setUp$4(this.f5090b, obj, reply);
                                return;
                        }
                    }
                });
            } else {
                basicMessageChannel4.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, e0.a.d("dev.flutter.pigeon.local_auth_android.LocalAuthApi.authenticate", concat), getCodec());
            if (localAuthApi != null) {
                final int i6 = 4;
                basicMessageChannel5.setMessageHandler(new BasicMessageChannel.MessageHandler(localAuthApi) { // from class: io.flutter.plugins.localauth.d

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ Messages.LocalAuthApi f5090b;

                    {
                        this.f5090b = localAuthApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i6) {
                            case 0:
                                Messages.LocalAuthApi.lambda$setUp$0(this.f5090b, obj, reply);
                                return;
                            case 1:
                                Messages.LocalAuthApi.lambda$setUp$1(this.f5090b, obj, reply);
                                return;
                            case 2:
                                Messages.LocalAuthApi.lambda$setUp$2(this.f5090b, obj, reply);
                                return;
                            case 3:
                                Messages.LocalAuthApi.lambda$setUp$3(this.f5090b, obj, reply);
                                return;
                            default:
                                Messages.LocalAuthApi.lambda$setUp$4(this.f5090b, obj, reply);
                                return;
                        }
                    }
                });
            } else {
                basicMessageChannel5.setMessageHandler(null);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface NullableResult<T> {
        void error(Throwable th);

        void success(T t3);
    }

    /* loaded from: classes.dex */
    public static class PigeonCodec extends StandardMessageCodec {
        public static final PigeonCodec INSTANCE = new PigeonCodec();

        private PigeonCodec() {
        }

        @Override // io.flutter.plugin.common.StandardMessageCodec
        public Object readValueOfType(byte b4, ByteBuffer byteBuffer) {
            switch (b4) {
                case -127:
                    Object readValue = readValue(byteBuffer);
                    if (readValue == null) {
                        return null;
                    }
                    return AuthResult.values()[((Long) readValue).intValue()];
                case -126:
                    Object readValue2 = readValue(byteBuffer);
                    if (readValue2 == null) {
                        return null;
                    }
                    return AuthClassification.values()[((Long) readValue2).intValue()];
                case -125:
                    return AuthStrings.fromList((ArrayList) readValue(byteBuffer));
                case -124:
                    return AuthOptions.fromList((ArrayList) readValue(byteBuffer));
                default:
                    return super.readValueOfType(b4, byteBuffer);
            }
        }

        @Override // io.flutter.plugin.common.StandardMessageCodec
        public void writeValue(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            Integer num = null;
            if (obj instanceof AuthResult) {
                byteArrayOutputStream.write(129);
                if (obj != null) {
                    num = Integer.valueOf(((AuthResult) obj).index);
                }
                writeValue(byteArrayOutputStream, num);
                return;
            }
            if (obj instanceof AuthClassification) {
                byteArrayOutputStream.write(130);
                if (obj != null) {
                    num = Integer.valueOf(((AuthClassification) obj).index);
                }
                writeValue(byteArrayOutputStream, num);
                return;
            }
            if (obj instanceof AuthStrings) {
                byteArrayOutputStream.write(131);
                writeValue(byteArrayOutputStream, ((AuthStrings) obj).toList());
            } else if (obj instanceof AuthOptions) {
                byteArrayOutputStream.write(132);
                writeValue(byteArrayOutputStream, ((AuthOptions) obj).toList());
            } else {
                super.writeValue(byteArrayOutputStream, obj);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface Result<T> {
        void error(Throwable th);

        void success(T t3);
    }

    /* loaded from: classes.dex */
    public interface VoidResult {
        void error(Throwable th);

        void success();
    }

    public static ArrayList<Object> wrapError(Throwable th) {
        ArrayList<Object> arrayList = new ArrayList<>(3);
        if (th instanceof FlutterError) {
            FlutterError flutterError = (FlutterError) th;
            arrayList.add(flutterError.code);
            arrayList.add(flutterError.getMessage());
            arrayList.add(flutterError.details);
            return arrayList;
        }
        arrayList.add(th.toString());
        arrayList.add(th.getClass().getSimpleName());
        arrayList.add("Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th));
        return arrayList;
    }
}
