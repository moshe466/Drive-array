package io.flutter.plugins.imagepicker;

import android.util.Log;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugins.imagepicker.Messages;
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
    public static final class CacheRetrievalError {
        private String code;
        private String message;

        /* loaded from: classes.dex */
        public static final class Builder {
            private String code;
            private String message;

            public CacheRetrievalError build() {
                CacheRetrievalError cacheRetrievalError = new CacheRetrievalError();
                cacheRetrievalError.setCode(this.code);
                cacheRetrievalError.setMessage(this.message);
                return cacheRetrievalError;
            }

            public Builder setCode(String str) {
                this.code = str;
                return this;
            }

            public Builder setMessage(String str) {
                this.message = str;
                return this;
            }
        }

        public static CacheRetrievalError fromList(ArrayList<Object> arrayList) {
            CacheRetrievalError cacheRetrievalError = new CacheRetrievalError();
            cacheRetrievalError.setCode((String) arrayList.get(0));
            cacheRetrievalError.setMessage((String) arrayList.get(1));
            return cacheRetrievalError;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && CacheRetrievalError.class == obj.getClass()) {
                CacheRetrievalError cacheRetrievalError = (CacheRetrievalError) obj;
                if (this.code.equals(cacheRetrievalError.code) && Objects.equals(this.message, cacheRetrievalError.message)) {
                    return true;
                }
            }
            return false;
        }

        public String getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }

        public int hashCode() {
            return Objects.hash(this.code, this.message);
        }

        public void setCode(String str) {
            if (str != null) {
                this.code = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"code\" is null.");
        }

        public void setMessage(String str) {
            this.message = str;
        }

        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            arrayList.add(this.code);
            arrayList.add(this.message);
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public static final class CacheRetrievalResult {
        private CacheRetrievalError error;
        private List<String> paths;
        private CacheRetrievalType type;

        /* loaded from: classes.dex */
        public static final class Builder {
            private CacheRetrievalError error;
            private List<String> paths;
            private CacheRetrievalType type;

            public CacheRetrievalResult build() {
                CacheRetrievalResult cacheRetrievalResult = new CacheRetrievalResult();
                cacheRetrievalResult.setType(this.type);
                cacheRetrievalResult.setError(this.error);
                cacheRetrievalResult.setPaths(this.paths);
                return cacheRetrievalResult;
            }

            public Builder setError(CacheRetrievalError cacheRetrievalError) {
                this.error = cacheRetrievalError;
                return this;
            }

            public Builder setPaths(List<String> list) {
                this.paths = list;
                return this;
            }

            public Builder setType(CacheRetrievalType cacheRetrievalType) {
                this.type = cacheRetrievalType;
                return this;
            }
        }

        public static CacheRetrievalResult fromList(ArrayList<Object> arrayList) {
            CacheRetrievalResult cacheRetrievalResult = new CacheRetrievalResult();
            cacheRetrievalResult.setType((CacheRetrievalType) arrayList.get(0));
            cacheRetrievalResult.setError((CacheRetrievalError) arrayList.get(1));
            cacheRetrievalResult.setPaths((List) arrayList.get(2));
            return cacheRetrievalResult;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && CacheRetrievalResult.class == obj.getClass()) {
                CacheRetrievalResult cacheRetrievalResult = (CacheRetrievalResult) obj;
                if (this.type.equals(cacheRetrievalResult.type) && Objects.equals(this.error, cacheRetrievalResult.error) && this.paths.equals(cacheRetrievalResult.paths)) {
                    return true;
                }
            }
            return false;
        }

        public CacheRetrievalError getError() {
            return this.error;
        }

        public List<String> getPaths() {
            return this.paths;
        }

        public CacheRetrievalType getType() {
            return this.type;
        }

        public int hashCode() {
            return Objects.hash(this.type, this.error, this.paths);
        }

        public void setError(CacheRetrievalError cacheRetrievalError) {
            this.error = cacheRetrievalError;
        }

        public void setPaths(List<String> list) {
            if (list != null) {
                this.paths = list;
                return;
            }
            throw new IllegalStateException("Nonnull field \"paths\" is null.");
        }

        public void setType(CacheRetrievalType cacheRetrievalType) {
            if (cacheRetrievalType != null) {
                this.type = cacheRetrievalType;
                return;
            }
            throw new IllegalStateException("Nonnull field \"type\" is null.");
        }

        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(3);
            arrayList.add(this.type);
            arrayList.add(this.error);
            arrayList.add(this.paths);
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public enum CacheRetrievalType {
        IMAGE(0),
        VIDEO(1);

        final int index;

        CacheRetrievalType(int i) {
            this.index = i;
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
    public static final class GeneralOptions {
        private Boolean allowMultiple;
        private Long limit;
        private Boolean usePhotoPicker;

        /* loaded from: classes.dex */
        public static final class Builder {
            private Boolean allowMultiple;
            private Long limit;
            private Boolean usePhotoPicker;

            public GeneralOptions build() {
                GeneralOptions generalOptions = new GeneralOptions();
                generalOptions.setAllowMultiple(this.allowMultiple);
                generalOptions.setUsePhotoPicker(this.usePhotoPicker);
                generalOptions.setLimit(this.limit);
                return generalOptions;
            }

            public Builder setAllowMultiple(Boolean bool) {
                this.allowMultiple = bool;
                return this;
            }

            public Builder setLimit(Long l3) {
                this.limit = l3;
                return this;
            }

            public Builder setUsePhotoPicker(Boolean bool) {
                this.usePhotoPicker = bool;
                return this;
            }
        }

        public static GeneralOptions fromList(ArrayList<Object> arrayList) {
            GeneralOptions generalOptions = new GeneralOptions();
            generalOptions.setAllowMultiple((Boolean) arrayList.get(0));
            generalOptions.setUsePhotoPicker((Boolean) arrayList.get(1));
            generalOptions.setLimit((Long) arrayList.get(2));
            return generalOptions;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && GeneralOptions.class == obj.getClass()) {
                GeneralOptions generalOptions = (GeneralOptions) obj;
                if (this.allowMultiple.equals(generalOptions.allowMultiple) && this.usePhotoPicker.equals(generalOptions.usePhotoPicker) && Objects.equals(this.limit, generalOptions.limit)) {
                    return true;
                }
            }
            return false;
        }

        public Boolean getAllowMultiple() {
            return this.allowMultiple;
        }

        public Long getLimit() {
            return this.limit;
        }

        public Boolean getUsePhotoPicker() {
            return this.usePhotoPicker;
        }

        public int hashCode() {
            return Objects.hash(this.allowMultiple, this.usePhotoPicker, this.limit);
        }

        public void setAllowMultiple(Boolean bool) {
            if (bool != null) {
                this.allowMultiple = bool;
                return;
            }
            throw new IllegalStateException("Nonnull field \"allowMultiple\" is null.");
        }

        public void setLimit(Long l3) {
            this.limit = l3;
        }

        public void setUsePhotoPicker(Boolean bool) {
            if (bool != null) {
                this.usePhotoPicker = bool;
                return;
            }
            throw new IllegalStateException("Nonnull field \"usePhotoPicker\" is null.");
        }

        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(3);
            arrayList.add(this.allowMultiple);
            arrayList.add(this.usePhotoPicker);
            arrayList.add(this.limit);
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public interface ImagePickerApi {
        static MessageCodec<Object> getCodec() {
            return PigeonCodec.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$0(ImagePickerApi imagePickerApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            imagePickerApi.pickImages((SourceSpecification) arrayList2.get(0), (ImageSelectionOptions) arrayList2.get(1), (GeneralOptions) arrayList2.get(2), new Result<List<String>>() { // from class: io.flutter.plugins.imagepicker.Messages.ImagePickerApi.1
                @Override // io.flutter.plugins.imagepicker.Messages.Result
                public void error(Throwable th) {
                    reply.reply(Messages.wrapError(th));
                }

                @Override // io.flutter.plugins.imagepicker.Messages.Result
                public void success(List<String> list) {
                    arrayList.add(0, list);
                    reply.reply(arrayList);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$1(ImagePickerApi imagePickerApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            imagePickerApi.pickVideos((SourceSpecification) arrayList2.get(0), (VideoSelectionOptions) arrayList2.get(1), (GeneralOptions) arrayList2.get(2), new Result<List<String>>() { // from class: io.flutter.plugins.imagepicker.Messages.ImagePickerApi.2
                @Override // io.flutter.plugins.imagepicker.Messages.Result
                public void error(Throwable th) {
                    reply.reply(Messages.wrapError(th));
                }

                @Override // io.flutter.plugins.imagepicker.Messages.Result
                public void success(List<String> list) {
                    arrayList.add(0, list);
                    reply.reply(arrayList);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$2(ImagePickerApi imagePickerApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            imagePickerApi.pickMedia((MediaSelectionOptions) arrayList2.get(0), (GeneralOptions) arrayList2.get(1), new Result<List<String>>() { // from class: io.flutter.plugins.imagepicker.Messages.ImagePickerApi.3
                @Override // io.flutter.plugins.imagepicker.Messages.Result
                public void error(Throwable th) {
                    reply.reply(Messages.wrapError(th));
                }

                @Override // io.flutter.plugins.imagepicker.Messages.Result
                public void success(List<String> list) {
                    arrayList.add(0, list);
                    reply.reply(arrayList);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$3(ImagePickerApi imagePickerApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                arrayList.add(0, imagePickerApi.retrieveLostResults());
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        static void setUp(BinaryMessenger binaryMessenger, ImagePickerApi imagePickerApi) {
            setUp(binaryMessenger, "", imagePickerApi);
        }

        void pickImages(SourceSpecification sourceSpecification, ImageSelectionOptions imageSelectionOptions, GeneralOptions generalOptions, Result<List<String>> result);

        void pickMedia(MediaSelectionOptions mediaSelectionOptions, GeneralOptions generalOptions, Result<List<String>> result);

        void pickVideos(SourceSpecification sourceSpecification, VideoSelectionOptions videoSelectionOptions, GeneralOptions generalOptions, Result<List<String>> result);

        CacheRetrievalResult retrieveLostResults();

        static void setUp(BinaryMessenger binaryMessenger, String str, final ImagePickerApi imagePickerApi) {
            String concat = str.isEmpty() ? "" : ".".concat(str);
            BinaryMessenger.TaskQueue makeBackgroundTaskQueue = binaryMessenger.makeBackgroundTaskQueue();
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, e0.a.d("dev.flutter.pigeon.image_picker_android.ImagePickerApi.pickImages", concat), getCodec(), makeBackgroundTaskQueue);
            if (imagePickerApi != null) {
                final int i = 0;
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler(imagePickerApi) { // from class: io.flutter.plugins.imagepicker.e

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ Messages.ImagePickerApi f5082b;

                    {
                        this.f5082b = imagePickerApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i) {
                            case 0:
                                Messages.ImagePickerApi.lambda$setUp$0(this.f5082b, obj, reply);
                                return;
                            case 1:
                                Messages.ImagePickerApi.lambda$setUp$1(this.f5082b, obj, reply);
                                return;
                            case 2:
                                Messages.ImagePickerApi.lambda$setUp$2(this.f5082b, obj, reply);
                                return;
                            default:
                                Messages.ImagePickerApi.lambda$setUp$3(this.f5082b, obj, reply);
                                return;
                        }
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, e0.a.d("dev.flutter.pigeon.image_picker_android.ImagePickerApi.pickVideos", concat), getCodec(), makeBackgroundTaskQueue);
            if (imagePickerApi != null) {
                final int i3 = 1;
                basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler(imagePickerApi) { // from class: io.flutter.plugins.imagepicker.e

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ Messages.ImagePickerApi f5082b;

                    {
                        this.f5082b = imagePickerApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i3) {
                            case 0:
                                Messages.ImagePickerApi.lambda$setUp$0(this.f5082b, obj, reply);
                                return;
                            case 1:
                                Messages.ImagePickerApi.lambda$setUp$1(this.f5082b, obj, reply);
                                return;
                            case 2:
                                Messages.ImagePickerApi.lambda$setUp$2(this.f5082b, obj, reply);
                                return;
                            default:
                                Messages.ImagePickerApi.lambda$setUp$3(this.f5082b, obj, reply);
                                return;
                        }
                    }
                });
            } else {
                basicMessageChannel2.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, e0.a.d("dev.flutter.pigeon.image_picker_android.ImagePickerApi.pickMedia", concat), getCodec());
            if (imagePickerApi != null) {
                final int i4 = 2;
                basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler(imagePickerApi) { // from class: io.flutter.plugins.imagepicker.e

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ Messages.ImagePickerApi f5082b;

                    {
                        this.f5082b = imagePickerApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i4) {
                            case 0:
                                Messages.ImagePickerApi.lambda$setUp$0(this.f5082b, obj, reply);
                                return;
                            case 1:
                                Messages.ImagePickerApi.lambda$setUp$1(this.f5082b, obj, reply);
                                return;
                            case 2:
                                Messages.ImagePickerApi.lambda$setUp$2(this.f5082b, obj, reply);
                                return;
                            default:
                                Messages.ImagePickerApi.lambda$setUp$3(this.f5082b, obj, reply);
                                return;
                        }
                    }
                });
            } else {
                basicMessageChannel3.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, e0.a.d("dev.flutter.pigeon.image_picker_android.ImagePickerApi.retrieveLostResults", concat), getCodec(), makeBackgroundTaskQueue);
            if (imagePickerApi != null) {
                final int i5 = 3;
                basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler(imagePickerApi) { // from class: io.flutter.plugins.imagepicker.e

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ Messages.ImagePickerApi f5082b;

                    {
                        this.f5082b = imagePickerApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i5) {
                            case 0:
                                Messages.ImagePickerApi.lambda$setUp$0(this.f5082b, obj, reply);
                                return;
                            case 1:
                                Messages.ImagePickerApi.lambda$setUp$1(this.f5082b, obj, reply);
                                return;
                            case 2:
                                Messages.ImagePickerApi.lambda$setUp$2(this.f5082b, obj, reply);
                                return;
                            default:
                                Messages.ImagePickerApi.lambda$setUp$3(this.f5082b, obj, reply);
                                return;
                        }
                    }
                });
            } else {
                basicMessageChannel4.setMessageHandler(null);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class ImageSelectionOptions {
        private Double maxHeight;
        private Double maxWidth;
        private Long quality;

        /* loaded from: classes.dex */
        public static final class Builder {
            private Double maxHeight;
            private Double maxWidth;
            private Long quality;

            public ImageSelectionOptions build() {
                ImageSelectionOptions imageSelectionOptions = new ImageSelectionOptions();
                imageSelectionOptions.setMaxWidth(this.maxWidth);
                imageSelectionOptions.setMaxHeight(this.maxHeight);
                imageSelectionOptions.setQuality(this.quality);
                return imageSelectionOptions;
            }

            public Builder setMaxHeight(Double d2) {
                this.maxHeight = d2;
                return this;
            }

            public Builder setMaxWidth(Double d2) {
                this.maxWidth = d2;
                return this;
            }

            public Builder setQuality(Long l3) {
                this.quality = l3;
                return this;
            }
        }

        public static ImageSelectionOptions fromList(ArrayList<Object> arrayList) {
            ImageSelectionOptions imageSelectionOptions = new ImageSelectionOptions();
            imageSelectionOptions.setMaxWidth((Double) arrayList.get(0));
            imageSelectionOptions.setMaxHeight((Double) arrayList.get(1));
            imageSelectionOptions.setQuality((Long) arrayList.get(2));
            return imageSelectionOptions;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && ImageSelectionOptions.class == obj.getClass()) {
                ImageSelectionOptions imageSelectionOptions = (ImageSelectionOptions) obj;
                if (Objects.equals(this.maxWidth, imageSelectionOptions.maxWidth) && Objects.equals(this.maxHeight, imageSelectionOptions.maxHeight) && this.quality.equals(imageSelectionOptions.quality)) {
                    return true;
                }
            }
            return false;
        }

        public Double getMaxHeight() {
            return this.maxHeight;
        }

        public Double getMaxWidth() {
            return this.maxWidth;
        }

        public Long getQuality() {
            return this.quality;
        }

        public int hashCode() {
            return Objects.hash(this.maxWidth, this.maxHeight, this.quality);
        }

        public void setMaxHeight(Double d2) {
            this.maxHeight = d2;
        }

        public void setMaxWidth(Double d2) {
            this.maxWidth = d2;
        }

        public void setQuality(Long l3) {
            if (l3 != null) {
                this.quality = l3;
                return;
            }
            throw new IllegalStateException("Nonnull field \"quality\" is null.");
        }

        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(3);
            arrayList.add(this.maxWidth);
            arrayList.add(this.maxHeight);
            arrayList.add(this.quality);
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public static final class MediaSelectionOptions {
        private ImageSelectionOptions imageSelectionOptions;

        /* loaded from: classes.dex */
        public static final class Builder {
            private ImageSelectionOptions imageSelectionOptions;

            public MediaSelectionOptions build() {
                MediaSelectionOptions mediaSelectionOptions = new MediaSelectionOptions();
                mediaSelectionOptions.setImageSelectionOptions(this.imageSelectionOptions);
                return mediaSelectionOptions;
            }

            public Builder setImageSelectionOptions(ImageSelectionOptions imageSelectionOptions) {
                this.imageSelectionOptions = imageSelectionOptions;
                return this;
            }
        }

        public static MediaSelectionOptions fromList(ArrayList<Object> arrayList) {
            MediaSelectionOptions mediaSelectionOptions = new MediaSelectionOptions();
            mediaSelectionOptions.setImageSelectionOptions((ImageSelectionOptions) arrayList.get(0));
            return mediaSelectionOptions;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && MediaSelectionOptions.class == obj.getClass()) {
                return this.imageSelectionOptions.equals(((MediaSelectionOptions) obj).imageSelectionOptions);
            }
            return false;
        }

        public ImageSelectionOptions getImageSelectionOptions() {
            return this.imageSelectionOptions;
        }

        public int hashCode() {
            return Objects.hash(this.imageSelectionOptions);
        }

        public void setImageSelectionOptions(ImageSelectionOptions imageSelectionOptions) {
            if (imageSelectionOptions != null) {
                this.imageSelectionOptions = imageSelectionOptions;
                return;
            }
            throw new IllegalStateException("Nonnull field \"imageSelectionOptions\" is null.");
        }

        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(1);
            arrayList.add(this.imageSelectionOptions);
            return arrayList;
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
                    return SourceCamera.values()[((Long) readValue).intValue()];
                case -126:
                    Object readValue2 = readValue(byteBuffer);
                    if (readValue2 == null) {
                        return null;
                    }
                    return SourceType.values()[((Long) readValue2).intValue()];
                case -125:
                    Object readValue3 = readValue(byteBuffer);
                    if (readValue3 == null) {
                        return null;
                    }
                    return CacheRetrievalType.values()[((Long) readValue3).intValue()];
                case -124:
                    return GeneralOptions.fromList((ArrayList) readValue(byteBuffer));
                case -123:
                    return ImageSelectionOptions.fromList((ArrayList) readValue(byteBuffer));
                case -122:
                    return MediaSelectionOptions.fromList((ArrayList) readValue(byteBuffer));
                case -121:
                    return VideoSelectionOptions.fromList((ArrayList) readValue(byteBuffer));
                case -120:
                    return SourceSpecification.fromList((ArrayList) readValue(byteBuffer));
                case -119:
                    return CacheRetrievalError.fromList((ArrayList) readValue(byteBuffer));
                case -118:
                    return CacheRetrievalResult.fromList((ArrayList) readValue(byteBuffer));
                default:
                    return super.readValueOfType(b4, byteBuffer);
            }
        }

        @Override // io.flutter.plugin.common.StandardMessageCodec
        public void writeValue(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            Integer num = null;
            if (obj instanceof SourceCamera) {
                byteArrayOutputStream.write(129);
                if (obj != null) {
                    num = Integer.valueOf(((SourceCamera) obj).index);
                }
                writeValue(byteArrayOutputStream, num);
                return;
            }
            if (obj instanceof SourceType) {
                byteArrayOutputStream.write(130);
                if (obj != null) {
                    num = Integer.valueOf(((SourceType) obj).index);
                }
                writeValue(byteArrayOutputStream, num);
                return;
            }
            if (obj instanceof CacheRetrievalType) {
                byteArrayOutputStream.write(131);
                if (obj != null) {
                    num = Integer.valueOf(((CacheRetrievalType) obj).index);
                }
                writeValue(byteArrayOutputStream, num);
                return;
            }
            if (obj instanceof GeneralOptions) {
                byteArrayOutputStream.write(132);
                writeValue(byteArrayOutputStream, ((GeneralOptions) obj).toList());
                return;
            }
            if (obj instanceof ImageSelectionOptions) {
                byteArrayOutputStream.write(133);
                writeValue(byteArrayOutputStream, ((ImageSelectionOptions) obj).toList());
                return;
            }
            if (obj instanceof MediaSelectionOptions) {
                byteArrayOutputStream.write(134);
                writeValue(byteArrayOutputStream, ((MediaSelectionOptions) obj).toList());
                return;
            }
            if (obj instanceof VideoSelectionOptions) {
                byteArrayOutputStream.write(135);
                writeValue(byteArrayOutputStream, ((VideoSelectionOptions) obj).toList());
                return;
            }
            if (obj instanceof SourceSpecification) {
                byteArrayOutputStream.write(136);
                writeValue(byteArrayOutputStream, ((SourceSpecification) obj).toList());
            } else if (obj instanceof CacheRetrievalError) {
                byteArrayOutputStream.write(137);
                writeValue(byteArrayOutputStream, ((CacheRetrievalError) obj).toList());
            } else if (obj instanceof CacheRetrievalResult) {
                byteArrayOutputStream.write(138);
                writeValue(byteArrayOutputStream, ((CacheRetrievalResult) obj).toList());
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
    public enum SourceCamera {
        REAR(0),
        FRONT(1);

        final int index;

        SourceCamera(int i) {
            this.index = i;
        }
    }

    /* loaded from: classes.dex */
    public static final class SourceSpecification {
        private SourceCamera camera;
        private SourceType type;

        /* loaded from: classes.dex */
        public static final class Builder {
            private SourceCamera camera;
            private SourceType type;

            public SourceSpecification build() {
                SourceSpecification sourceSpecification = new SourceSpecification();
                sourceSpecification.setType(this.type);
                sourceSpecification.setCamera(this.camera);
                return sourceSpecification;
            }

            public Builder setCamera(SourceCamera sourceCamera) {
                this.camera = sourceCamera;
                return this;
            }

            public Builder setType(SourceType sourceType) {
                this.type = sourceType;
                return this;
            }
        }

        public static SourceSpecification fromList(ArrayList<Object> arrayList) {
            SourceSpecification sourceSpecification = new SourceSpecification();
            sourceSpecification.setType((SourceType) arrayList.get(0));
            sourceSpecification.setCamera((SourceCamera) arrayList.get(1));
            return sourceSpecification;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && SourceSpecification.class == obj.getClass()) {
                SourceSpecification sourceSpecification = (SourceSpecification) obj;
                if (this.type.equals(sourceSpecification.type) && Objects.equals(this.camera, sourceSpecification.camera)) {
                    return true;
                }
            }
            return false;
        }

        public SourceCamera getCamera() {
            return this.camera;
        }

        public SourceType getType() {
            return this.type;
        }

        public int hashCode() {
            return Objects.hash(this.type, this.camera);
        }

        public void setCamera(SourceCamera sourceCamera) {
            this.camera = sourceCamera;
        }

        public void setType(SourceType sourceType) {
            if (sourceType != null) {
                this.type = sourceType;
                return;
            }
            throw new IllegalStateException("Nonnull field \"type\" is null.");
        }

        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            arrayList.add(this.type);
            arrayList.add(this.camera);
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public enum SourceType {
        CAMERA(0),
        GALLERY(1);

        final int index;

        SourceType(int i) {
            this.index = i;
        }
    }

    /* loaded from: classes.dex */
    public static final class VideoSelectionOptions {
        private Long maxDurationSeconds;

        /* loaded from: classes.dex */
        public static final class Builder {
            private Long maxDurationSeconds;

            public VideoSelectionOptions build() {
                VideoSelectionOptions videoSelectionOptions = new VideoSelectionOptions();
                videoSelectionOptions.setMaxDurationSeconds(this.maxDurationSeconds);
                return videoSelectionOptions;
            }

            public Builder setMaxDurationSeconds(Long l3) {
                this.maxDurationSeconds = l3;
                return this;
            }
        }

        public static VideoSelectionOptions fromList(ArrayList<Object> arrayList) {
            VideoSelectionOptions videoSelectionOptions = new VideoSelectionOptions();
            videoSelectionOptions.setMaxDurationSeconds((Long) arrayList.get(0));
            return videoSelectionOptions;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && VideoSelectionOptions.class == obj.getClass()) {
                return Objects.equals(this.maxDurationSeconds, ((VideoSelectionOptions) obj).maxDurationSeconds);
            }
            return false;
        }

        public Long getMaxDurationSeconds() {
            return this.maxDurationSeconds;
        }

        public int hashCode() {
            return Objects.hash(this.maxDurationSeconds);
        }

        public void setMaxDurationSeconds(Long l3) {
            this.maxDurationSeconds = l3;
        }

        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(1);
            arrayList.add(this.maxDurationSeconds);
            return arrayList;
        }
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
