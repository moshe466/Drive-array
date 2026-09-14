package io.flutter.plugins.imagepicker;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.FileProvider;
import com.google.firebase.messaging.Constants;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugins.imagepicker.ImagePickerCache;
import io.flutter.plugins.imagepicker.ImagePickerDelegate;
import io.flutter.plugins.imagepicker.Messages;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import w.AbstractC0744b;
import x.AbstractC0773d;

/* loaded from: classes.dex */
public class ImagePickerDelegate implements PluginRegistry.ActivityResultListener, PluginRegistry.RequestPermissionsResultListener {
    static final int REQUEST_CAMERA_IMAGE_PERMISSION = 2345;
    static final int REQUEST_CAMERA_VIDEO_PERMISSION = 2355;
    static final int REQUEST_CODE_CHOOSE_IMAGE_FROM_GALLERY = 2342;
    static final int REQUEST_CODE_CHOOSE_MEDIA_FROM_GALLERY = 2347;
    static final int REQUEST_CODE_CHOOSE_MULTI_IMAGE_FROM_GALLERY = 2346;
    static final int REQUEST_CODE_CHOOSE_MULTI_VIDEO_FROM_GALLERY = 2348;
    static final int REQUEST_CODE_CHOOSE_VIDEO_FROM_GALLERY = 2352;
    static final int REQUEST_CODE_TAKE_IMAGE_WITH_CAMERA = 2343;
    static final int REQUEST_CODE_TAKE_VIDEO_WITH_CAMERA = 2353;
    private final Activity activity;
    private final ImagePickerCache cache;
    private CameraDevice cameraDevice;
    private final ExecutorService executor;
    final String fileProviderName;
    private final FileUriResolver fileUriResolver;
    private final FileUtils fileUtils;
    private final ImageResizer imageResizer;
    private PendingCallState pendingCallState;
    private final Object pendingCallStateLock;
    private Uri pendingCameraMediaUri;
    private final PermissionManager permissionManager;

    /* renamed from: io.flutter.plugins.imagepicker.ImagePickerDelegate$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements PermissionManager {
        final /* synthetic */ Activity val$activity;

        public AnonymousClass1(Activity activity) {
            r1 = activity;
        }

        @Override // io.flutter.plugins.imagepicker.ImagePickerDelegate.PermissionManager
        public void askForPermission(String str, int i) {
            AbstractC0744b.d(r1, new String[]{str}, i);
        }

        @Override // io.flutter.plugins.imagepicker.ImagePickerDelegate.PermissionManager
        public boolean isPermissionGranted(String str) {
            if (AbstractC0773d.a(r1, str) == 0) {
                return true;
            }
            return false;
        }

        @Override // io.flutter.plugins.imagepicker.ImagePickerDelegate.PermissionManager
        public boolean needRequestCameraPermission() {
            return ImagePickerUtils.needRequestCameraPermission(r1);
        }
    }

    /* renamed from: io.flutter.plugins.imagepicker.ImagePickerDelegate$2 */
    /* loaded from: classes.dex */
    public class AnonymousClass2 implements FileUriResolver {
        final /* synthetic */ Activity val$activity;

        public AnonymousClass2(Activity activity) {
            this.val$activity = activity;
        }

        @Override // io.flutter.plugins.imagepicker.ImagePickerDelegate.FileUriResolver
        public void getFullImagePath(Uri uri, final OnPathReadyListener onPathReadyListener) {
            String str;
            Activity activity = this.val$activity;
            if (uri != null) {
                str = uri.getPath();
            } else {
                str = "";
            }
            MediaScannerConnection.scanFile(activity, new String[]{str}, null, new MediaScannerConnection.OnScanCompletedListener() { // from class: io.flutter.plugins.imagepicker.d
                @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                public final void onScanCompleted(String str2, Uri uri2) {
                    ImagePickerDelegate.OnPathReadyListener.this.onPathReady(str2);
                }
            });
        }

        @Override // io.flutter.plugins.imagepicker.ImagePickerDelegate.FileUriResolver
        public Uri resolveFileProviderUriForFile(String str, File file) {
            return FileProvider.getUriForFile(this.val$activity, str, file);
        }
    }

    /* loaded from: classes.dex */
    public enum CameraDevice {
        REAR,
        FRONT
    }

    /* loaded from: classes.dex */
    public interface FileUriResolver {
        void getFullImagePath(Uri uri, OnPathReadyListener onPathReadyListener);

        Uri resolveFileProviderUriForFile(String str, File file);
    }

    /* loaded from: classes.dex */
    public class MediaPath {
        final String mimeType;
        final String path;

        public MediaPath(String str, String str2) {
            this.path = str;
            this.mimeType = str2;
        }

        public String getMimeType() {
            return this.mimeType;
        }

        public String getPath() {
            return this.path;
        }
    }

    /* loaded from: classes.dex */
    public interface OnPathReadyListener {
        void onPathReady(String str);
    }

    /* loaded from: classes.dex */
    public static class PendingCallState {
        public final Messages.ImageSelectionOptions imageOptions;
        public final Messages.Result<List<String>> result;
        public final Messages.VideoSelectionOptions videoOptions;

        public PendingCallState(Messages.ImageSelectionOptions imageSelectionOptions, Messages.VideoSelectionOptions videoSelectionOptions, Messages.Result<List<String>> result) {
            this.imageOptions = imageSelectionOptions;
            this.videoOptions = videoSelectionOptions;
            this.result = result;
        }
    }

    /* loaded from: classes.dex */
    public interface PermissionManager {
        void askForPermission(String str, int i);

        boolean isPermissionGranted(String str);

        boolean needRequestCameraPermission();
    }

    public ImagePickerDelegate(Activity activity, ImageResizer imageResizer, ImagePickerCache imagePickerCache) {
        this(activity, imageResizer, null, null, null, imagePickerCache, new PermissionManager() { // from class: io.flutter.plugins.imagepicker.ImagePickerDelegate.1
            final /* synthetic */ Activity val$activity;

            public AnonymousClass1(Activity activity2) {
                r1 = activity2;
            }

            @Override // io.flutter.plugins.imagepicker.ImagePickerDelegate.PermissionManager
            public void askForPermission(String str, int i) {
                AbstractC0744b.d(r1, new String[]{str}, i);
            }

            @Override // io.flutter.plugins.imagepicker.ImagePickerDelegate.PermissionManager
            public boolean isPermissionGranted(String str) {
                if (AbstractC0773d.a(r1, str) == 0) {
                    return true;
                }
                return false;
            }

            @Override // io.flutter.plugins.imagepicker.ImagePickerDelegate.PermissionManager
            public boolean needRequestCameraPermission() {
                return ImagePickerUtils.needRequestCameraPermission(r1);
            }
        }, new AnonymousClass2(activity2), new FileUtils(), Executors.newSingleThreadExecutor());
    }

    private File createTemporaryWritableFile(String str) {
        String uuid = UUID.randomUUID().toString();
        File cacheDir = this.activity.getCacheDir();
        try {
            cacheDir.mkdirs();
            return File.createTempFile(uuid, str, cacheDir);
        } catch (IOException e4) {
            throw new RuntimeException(e4);
        }
    }

    private File createTemporaryWritableImageFile() {
        return createTemporaryWritableFile(".jpg");
    }

    private File createTemporaryWritableVideoFile() {
        return createTemporaryWritableFile(".mp4");
    }

    private void finishWithAlreadyActiveError(Messages.Result<List<String>> result) {
        result.error(new Messages.FlutterError("already_active", "Image picker is already active", null));
    }

    private void finishWithError(String str, String str2) {
        Messages.Result<List<String>> result;
        synchronized (this.pendingCallStateLock) {
            try {
                PendingCallState pendingCallState = this.pendingCallState;
                if (pendingCallState != null) {
                    result = pendingCallState.result;
                } else {
                    result = null;
                }
                this.pendingCallState = null;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (result == null) {
            this.cache.saveResult(null, str, str2);
        } else {
            result.error(new Messages.FlutterError(str, str2, null));
        }
    }

    private void finishWithListSuccess(ArrayList<String> arrayList) {
        Messages.Result<List<String>> result;
        synchronized (this.pendingCallStateLock) {
            try {
                PendingCallState pendingCallState = this.pendingCallState;
                if (pendingCallState != null) {
                    result = pendingCallState.result;
                } else {
                    result = null;
                }
                this.pendingCallState = null;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (result == null) {
            this.cache.saveResult(arrayList, null, null);
        } else {
            result.success(arrayList);
        }
    }

    public void finishWithSuccess(String str) {
        Messages.Result<List<String>> result;
        ArrayList<String> arrayList = new ArrayList<>();
        if (str != null) {
            arrayList.add(str);
        }
        synchronized (this.pendingCallStateLock) {
            try {
                PendingCallState pendingCallState = this.pendingCallState;
                if (pendingCallState != null) {
                    result = pendingCallState.result;
                } else {
                    result = null;
                }
                this.pendingCallState = null;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (result == null) {
            if (!arrayList.isEmpty()) {
                this.cache.saveResult(arrayList, null, null);
                return;
            }
            return;
        }
        result.success(arrayList);
    }

    private ArrayList<MediaPath> getPathsFromIntent(Intent intent, boolean z3) {
        String pathFromUri;
        String str;
        ArrayList<MediaPath> arrayList = new ArrayList<>();
        Uri data = intent.getData();
        if (data == null) {
            if (intent.getClipData() == null) {
                return null;
            }
            for (int i = 0; i < intent.getClipData().getItemCount(); i++) {
                Uri uri = intent.getClipData().getItemAt(i).getUri();
                if (uri == null || (pathFromUri = this.fileUtils.getPathFromUri(this.activity, uri)) == null) {
                    return null;
                }
                if (z3) {
                    str = this.activity.getContentResolver().getType(uri);
                } else {
                    str = null;
                }
                arrayList.add(new MediaPath(pathFromUri, str));
            }
            return arrayList;
        }
        String pathFromUri2 = this.fileUtils.getPathFromUri(this.activity, data);
        if (pathFromUri2 == null) {
            return null;
        }
        arrayList.add(new MediaPath(pathFromUri2, null));
        return arrayList;
    }

    private String getResizedImagePath(String str, Messages.ImageSelectionOptions imageSelectionOptions) {
        return this.imageResizer.resizeImageIfNeeded(str, imageSelectionOptions.getMaxWidth(), imageSelectionOptions.getMaxHeight(), imageSelectionOptions.getQuality().intValue());
    }

    private void grantUriPermissions(Intent intent, Uri uri) {
        List<ResolveInfo> queryIntentActivitiesPreApi33;
        PackageManager.ResolveInfoFlags of;
        PackageManager packageManager = this.activity.getPackageManager();
        if (Build.VERSION.SDK_INT >= 33) {
            of = PackageManager.ResolveInfoFlags.of(65536L);
            queryIntentActivitiesPreApi33 = packageManager.queryIntentActivities(intent, of);
        } else {
            queryIntentActivitiesPreApi33 = queryIntentActivitiesPreApi33(packageManager, intent);
        }
        Iterator<ResolveInfo> it = queryIntentActivitiesPreApi33.iterator();
        while (it.hasNext()) {
            this.activity.grantUriPermission(it.next().activityInfo.packageName, uri, 3);
        }
    }

    /* renamed from: handleCaptureImageResult */
    public void lambda$onActivityResult$3(int i) {
        if (i == -1) {
            Uri uri = this.pendingCameraMediaUri;
            FileUriResolver fileUriResolver = this.fileUriResolver;
            if (uri == null) {
                uri = Uri.parse(this.cache.retrievePendingCameraMediaUriPath());
            }
            fileUriResolver.getFullImagePath(uri, new c(this, 0));
            return;
        }
        finishWithSuccess(null);
    }

    /* renamed from: handleCaptureVideoResult */
    public void lambda$onActivityResult$6(int i) {
        if (i == -1) {
            Uri uri = this.pendingCameraMediaUri;
            FileUriResolver fileUriResolver = this.fileUriResolver;
            if (uri == null) {
                uri = Uri.parse(this.cache.retrievePendingCameraMediaUriPath());
            }
            fileUriResolver.getFullImagePath(uri, new c(this, 1));
            return;
        }
        finishWithSuccess(null);
    }

    /* renamed from: handleChooseImageResult */
    public void lambda$onActivityResult$0(int i, Intent intent) {
        if (i == -1 && intent != null) {
            ArrayList<MediaPath> pathsFromIntent = getPathsFromIntent(intent, false);
            if (pathsFromIntent == null) {
                finishWithError("no_valid_image_uri", "Cannot find the selected image.");
                return;
            } else {
                handleMediaResult(pathsFromIntent);
                return;
            }
        }
        finishWithSuccess(null);
    }

    /* renamed from: handleChooseMediaResult */
    public void lambda$onActivityResult$4(int i, Intent intent) {
        if (i == -1 && intent != null) {
            ArrayList<MediaPath> pathsFromIntent = getPathsFromIntent(intent, true);
            if (pathsFromIntent == null) {
                finishWithError("no_valid_media_uri", "Cannot find the selected media.");
                return;
            } else {
                handleMediaResult(pathsFromIntent);
                return;
            }
        }
        finishWithSuccess(null);
    }

    /* renamed from: handleChooseMultiImageResult */
    public void lambda$onActivityResult$1(int i, Intent intent) {
        if (i == -1 && intent != null) {
            ArrayList<MediaPath> pathsFromIntent = getPathsFromIntent(intent, false);
            if (pathsFromIntent == null) {
                finishWithError("missing_valid_image_uri", "Cannot find at least one of the selected images.");
                return;
            } else {
                handleMediaResult(pathsFromIntent);
                return;
            }
        }
        finishWithSuccess(null);
    }

    /* renamed from: handleChooseMultiVideoResult */
    public void lambda$onActivityResult$2(int i, Intent intent) {
        if (i == -1 && intent != null) {
            ArrayList<MediaPath> pathsFromIntent = getPathsFromIntent(intent, false);
            if (pathsFromIntent == null) {
                finishWithError("missing_valid_video_uri", "Cannot find at least one of the selected videos.");
                return;
            } else {
                handleMediaResult(pathsFromIntent);
                return;
            }
        }
        finishWithSuccess(null);
    }

    /* renamed from: handleChooseVideoResult */
    public void lambda$onActivityResult$5(int i, Intent intent) {
        if (i == -1 && intent != null) {
            ArrayList<MediaPath> pathsFromIntent = getPathsFromIntent(intent, false);
            if (pathsFromIntent != null && pathsFromIntent.size() >= 1) {
                finishWithSuccess(pathsFromIntent.get(0).path);
                return;
            } else {
                finishWithError("no_valid_video_uri", "Cannot find the selected video.");
                return;
            }
        }
        finishWithSuccess(null);
    }

    private void handleMediaResult(ArrayList<MediaPath> arrayList) {
        Messages.ImageSelectionOptions imageSelectionOptions;
        synchronized (this.pendingCallStateLock) {
            try {
                PendingCallState pendingCallState = this.pendingCallState;
                if (pendingCallState != null) {
                    imageSelectionOptions = pendingCallState.imageOptions;
                } else {
                    imageSelectionOptions = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        ArrayList<String> arrayList2 = new ArrayList<>();
        int i = 0;
        if (imageSelectionOptions != null) {
            while (i < arrayList.size()) {
                MediaPath mediaPath = arrayList.get(i);
                String str = mediaPath.path;
                String str2 = mediaPath.mimeType;
                if (str2 == null || !str2.startsWith("video/")) {
                    str = getResizedImagePath(mediaPath.path, imageSelectionOptions);
                }
                arrayList2.add(str);
                i++;
            }
            finishWithListSuccess(arrayList2);
            return;
        }
        while (i < arrayList.size()) {
            arrayList2.add(arrayList.get(i).path);
            i++;
        }
        finishWithListSuccess(arrayList2);
    }

    public /* synthetic */ void lambda$handleCaptureImageResult$7(String str) {
        handleImageResult(str, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0039, code lost:
    
        if (r0 >= 2) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001d, code lost:
    
        if (r4 >= 2) goto L33;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0033  */
    /* JADX WARN: Type inference failed for: r5v0, types: [e.k, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void launchMultiPickImageFromGalleryIntent(java.lang.Boolean r8, int r9) {
        /*
            r7 = this;
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L4d
            f.b r8 = new f.b
            r8.<init>(r9)
            android.app.Activity r9 = r7.activity
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 2
            r2 = 33
            r3 = 30
            if (r0 < r2) goto L17
            goto L1f
        L17:
            if (r0 < r3) goto L24
            int r4 = com.google.firebase.crashlytics.internal.common.i.a()
            if (r4 < r1) goto L24
        L1f:
            int r4 = F0.H2.a()
            goto L27
        L24:
            r4 = 2147483647(0x7fffffff, float:NaN)
        L27:
            e.k r5 = new e.k
            r5.<init>()
            f.d r6 = f.C0368d.f4476a
            r5.f4440a = r6
            if (r0 < r2) goto L33
            goto L3b
        L33:
            if (r0 < r3) goto L3e
            int r0 = com.google.firebase.crashlytics.internal.common.i.a()
            if (r0 < r1) goto L3e
        L3b:
            F0.H2.a()
        L3e:
            f.e r0 = f.C0369e.f4477a
            r5.f4440a = r0
            r5.f4441b = r4
            f.c r0 = f.C0367c.f4475a
            r5.f4442c = r0
            android.content.Intent r8 = r8.a(r9, r5)
            goto L5f
        L4d:
            android.content.Intent r8 = new android.content.Intent
            java.lang.String r9 = "android.intent.action.GET_CONTENT"
            r8.<init>(r9)
            java.lang.String r9 = "image/*"
            r8.setType(r9)
            java.lang.String r9 = "android.intent.extra.ALLOW_MULTIPLE"
            r0 = 1
            r8.putExtra(r9, r0)
        L5f:
            android.app.Activity r9 = r7.activity
            r0 = 2346(0x92a, float:3.287E-42)
            r9.startActivityForResult(r8, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.imagepicker.ImagePickerDelegate.launchMultiPickImageFromGalleryIntent(java.lang.Boolean, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0039, code lost:
    
        if (r0 >= 2) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001d, code lost:
    
        if (r4 >= 2) goto L33;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0033  */
    /* JADX WARN: Type inference failed for: r5v0, types: [e.k, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void launchMultiPickVideoFromGalleryIntent(java.lang.Boolean r8, int r9) {
        /*
            r7 = this;
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L4d
            f.b r8 = new f.b
            r8.<init>(r9)
            android.app.Activity r9 = r7.activity
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 2
            r2 = 33
            r3 = 30
            if (r0 < r2) goto L17
            goto L1f
        L17:
            if (r0 < r3) goto L24
            int r4 = com.google.firebase.crashlytics.internal.common.i.a()
            if (r4 < r1) goto L24
        L1f:
            int r4 = F0.H2.a()
            goto L27
        L24:
            r4 = 2147483647(0x7fffffff, float:NaN)
        L27:
            e.k r5 = new e.k
            r5.<init>()
            f.d r6 = f.C0368d.f4476a
            r5.f4440a = r6
            if (r0 < r2) goto L33
            goto L3b
        L33:
            if (r0 < r3) goto L3e
            int r0 = com.google.firebase.crashlytics.internal.common.i.a()
            if (r0 < r1) goto L3e
        L3b:
            F0.H2.a()
        L3e:
            f.f r0 = f.C0370f.f4478a
            r5.f4440a = r0
            r5.f4441b = r4
            f.c r0 = f.C0367c.f4475a
            r5.f4442c = r0
            android.content.Intent r8 = r8.a(r9, r5)
            goto L5f
        L4d:
            android.content.Intent r8 = new android.content.Intent
            java.lang.String r9 = "android.intent.action.GET_CONTENT"
            r8.<init>(r9)
            java.lang.String r9 = "video/*"
            r8.setType(r9)
            java.lang.String r9 = "android.intent.extra.ALLOW_MULTIPLE"
            r0 = 1
            r8.putExtra(r9, r0)
        L5f:
            android.app.Activity r9 = r7.activity
            r0 = 2348(0x92c, float:3.29E-42)
            r9.startActivityForResult(r8, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.imagepicker.ImagePickerDelegate.launchMultiPickVideoFromGalleryIntent(java.lang.Boolean, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003a, code lost:
    
        if (r1 >= 2) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001e, code lost:
    
        if (r5 >= 2) goto L33;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /* JADX WARN: Type inference failed for: r6v0, types: [e.k, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void launchPickImageFromGalleryIntent(java.lang.Boolean r9) {
        /*
            r8 = this;
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L4e
            androidx.fragment.app.b0 r9 = new androidx.fragment.app.b0
            r0 = 1
            r9.<init>(r0)
            android.app.Activity r0 = r8.activity
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 2
            r3 = 33
            r4 = 30
            if (r1 < r3) goto L18
            goto L20
        L18:
            if (r1 < r4) goto L25
            int r5 = com.google.firebase.crashlytics.internal.common.i.a()
            if (r5 < r2) goto L25
        L20:
            int r5 = F0.H2.a()
            goto L28
        L25:
            r5 = 2147483647(0x7fffffff, float:NaN)
        L28:
            e.k r6 = new e.k
            r6.<init>()
            f.d r7 = f.C0368d.f4476a
            r6.f4440a = r7
            if (r1 < r3) goto L34
            goto L3c
        L34:
            if (r1 < r4) goto L3f
            int r1 = com.google.firebase.crashlytics.internal.common.i.a()
            if (r1 < r2) goto L3f
        L3c:
            F0.H2.a()
        L3f:
            f.e r1 = f.C0369e.f4477a
            r6.f4440a = r1
            r6.f4441b = r5
            f.c r1 = f.C0367c.f4475a
            r6.f4442c = r1
            android.content.Intent r9 = r9.d(r0, r6)
            goto L5a
        L4e:
            android.content.Intent r9 = new android.content.Intent
            java.lang.String r0 = "android.intent.action.GET_CONTENT"
            r9.<init>(r0)
            java.lang.String r0 = "image/*"
            r9.setType(r0)
        L5a:
            android.app.Activity r0 = r8.activity
            r1 = 2342(0x926, float:3.282E-42)
            r0.startActivityForResult(r9, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.imagepicker.ImagePickerDelegate.launchPickImageFromGalleryIntent(java.lang.Boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004c, code lost:
    
        if (r4 >= 2) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006f, code lost:
    
        if (r8 >= 2) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0085, code lost:
    
        if (r4 >= 2) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0036, code lost:
    
        if (r8 >= 2) goto L51;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007f  */
    /* JADX WARN: Type inference failed for: r8v0, types: [e.k, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v2, types: [e.k, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void launchPickMediaFromGalleryIntent(io.flutter.plugins.imagepicker.Messages.GeneralOptions r10) {
        /*
            r9 = this;
            java.lang.Boolean r0 = r10.getUsePhotoPicker()
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L95
            java.lang.Boolean r0 = r10.getAllowMultiple()
            boolean r0 = r0.booleanValue()
            f.c r1 = f.C0367c.f4475a
            r2 = 2147483647(0x7fffffff, float:NaN)
            r3 = 2
            r4 = 33
            r5 = 30
            f.d r6 = f.C0368d.f4476a
            if (r0 == 0) goto L5c
            int r10 = io.flutter.plugins.imagepicker.ImagePickerUtils.getLimitFromOption(r10)
            f.b r0 = new f.b
            r0.<init>(r10)
            android.app.Activity r10 = r9.activity
            int r7 = android.os.Build.VERSION.SDK_INT
            if (r7 < r4) goto L30
            goto L38
        L30:
            if (r7 < r5) goto L3c
            int r8 = com.google.firebase.crashlytics.internal.common.i.a()
            if (r8 < r3) goto L3c
        L38:
            int r2 = F0.H2.a()
        L3c:
            e.k r8 = new e.k
            r8.<init>()
            r8.f4440a = r6
            if (r7 < r4) goto L46
            goto L4e
        L46:
            if (r7 < r5) goto L51
            int r4 = com.google.firebase.crashlytics.internal.common.i.a()
            if (r4 < r3) goto L51
        L4e:
            F0.H2.a()
        L51:
            r8.f4440a = r6
            r8.f4441b = r2
            r8.f4442c = r1
            android.content.Intent r10 = r0.a(r10, r8)
            goto Lb8
        L5c:
            androidx.fragment.app.b0 r10 = new androidx.fragment.app.b0
            r0 = 1
            r10.<init>(r0)
            android.app.Activity r0 = r9.activity
            int r7 = android.os.Build.VERSION.SDK_INT
            if (r7 < r4) goto L69
            goto L71
        L69:
            if (r7 < r5) goto L75
            int r8 = com.google.firebase.crashlytics.internal.common.i.a()
            if (r8 < r3) goto L75
        L71:
            int r2 = F0.H2.a()
        L75:
            e.k r8 = new e.k
            r8.<init>()
            r8.f4440a = r6
            if (r7 < r4) goto L7f
            goto L87
        L7f:
            if (r7 < r5) goto L8a
            int r4 = com.google.firebase.crashlytics.internal.common.i.a()
            if (r4 < r3) goto L8a
        L87:
            F0.H2.a()
        L8a:
            r8.f4440a = r6
            r8.f4441b = r2
            r8.f4442c = r1
            android.content.Intent r10 = r10.d(r0, r8)
            goto Lb8
        L95:
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "android.intent.action.GET_CONTENT"
            r0.<init>(r1)
        */
        //  java.lang.String r1 = "*/*"
        /*
            r0.setType(r1)
            java.lang.String r1 = "video/*"
            java.lang.String r2 = "image/*"
            java.lang.String[] r1 = new java.lang.String[]{r1, r2}
            java.lang.String r2 = "CONTENT_TYPE"
            r0.putExtra(r2, r1)
            java.lang.String r1 = "android.intent.extra.ALLOW_MULTIPLE"
            java.lang.Boolean r10 = r10.getAllowMultiple()
            r0.putExtra(r1, r10)
            r10 = r0
        Lb8:
            android.app.Activity r0 = r9.activity
            r1 = 2347(0x92b, float:3.289E-42)
            r0.startActivityForResult(r10, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.imagepicker.ImagePickerDelegate.launchPickMediaFromGalleryIntent(io.flutter.plugins.imagepicker.Messages$GeneralOptions):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003a, code lost:
    
        if (r1 >= 2) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001e, code lost:
    
        if (r5 >= 2) goto L33;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /* JADX WARN: Type inference failed for: r6v0, types: [e.k, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void launchPickVideoFromGalleryIntent(java.lang.Boolean r9) {
        /*
            r8 = this;
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L4e
            androidx.fragment.app.b0 r9 = new androidx.fragment.app.b0
            r0 = 1
            r9.<init>(r0)
            android.app.Activity r0 = r8.activity
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 2
            r3 = 33
            r4 = 30
            if (r1 < r3) goto L18
            goto L20
        L18:
            if (r1 < r4) goto L25
            int r5 = com.google.firebase.crashlytics.internal.common.i.a()
            if (r5 < r2) goto L25
        L20:
            int r5 = F0.H2.a()
            goto L28
        L25:
            r5 = 2147483647(0x7fffffff, float:NaN)
        L28:
            e.k r6 = new e.k
            r6.<init>()
            f.d r7 = f.C0368d.f4476a
            r6.f4440a = r7
            if (r1 < r3) goto L34
            goto L3c
        L34:
            if (r1 < r4) goto L3f
            int r1 = com.google.firebase.crashlytics.internal.common.i.a()
            if (r1 < r2) goto L3f
        L3c:
            F0.H2.a()
        L3f:
            f.f r1 = f.C0370f.f4478a
            r6.f4440a = r1
            r6.f4441b = r5
            f.c r1 = f.C0367c.f4475a
            r6.f4442c = r1
            android.content.Intent r9 = r9.d(r0, r6)
            goto L5a
        L4e:
            android.content.Intent r9 = new android.content.Intent
            java.lang.String r0 = "android.intent.action.GET_CONTENT"
            r9.<init>(r0)
            java.lang.String r0 = "video/*"
            r9.setType(r0)
        L5a:
            android.app.Activity r0 = r8.activity
            r1 = 2352(0x930, float:3.296E-42)
            r0.startActivityForResult(r9, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.imagepicker.ImagePickerDelegate.launchPickVideoFromGalleryIntent(java.lang.Boolean):void");
    }

    private void launchTakeImageWithCameraIntent() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (this.cameraDevice == CameraDevice.FRONT) {
            useFrontCamera(intent);
        }
        File createTemporaryWritableImageFile = createTemporaryWritableImageFile();
        this.pendingCameraMediaUri = Uri.parse("file:" + createTemporaryWritableImageFile.getAbsolutePath());
        Uri resolveFileProviderUriForFile = this.fileUriResolver.resolveFileProviderUriForFile(this.fileProviderName, createTemporaryWritableImageFile);
        intent.putExtra("output", resolveFileProviderUriForFile);
        grantUriPermissions(intent, resolveFileProviderUriForFile);
        try {
            try {
                this.activity.startActivityForResult(intent, REQUEST_CODE_TAKE_IMAGE_WITH_CAMERA);
            } catch (ActivityNotFoundException unused) {
                createTemporaryWritableImageFile.delete();
                finishWithError("no_available_camera", "No cameras available for taking pictures.");
            }
        } catch (SecurityException e4) {
            e4.printStackTrace();
            finishWithError("no_available_camera", "No cameras available for taking pictures.");
        }
    }

    private void launchTakeVideoWithCameraIntent() {
        Messages.VideoSelectionOptions videoSelectionOptions;
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        synchronized (this.pendingCallStateLock) {
            try {
                PendingCallState pendingCallState = this.pendingCallState;
                if (pendingCallState != null) {
                    videoSelectionOptions = pendingCallState.videoOptions;
                } else {
                    videoSelectionOptions = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (videoSelectionOptions != null && videoSelectionOptions.getMaxDurationSeconds() != null) {
            intent.putExtra("android.intent.extra.durationLimit", videoSelectionOptions.getMaxDurationSeconds().intValue());
        }
        if (this.cameraDevice == CameraDevice.FRONT) {
            useFrontCamera(intent);
        }
        File createTemporaryWritableVideoFile = createTemporaryWritableVideoFile();
        this.pendingCameraMediaUri = Uri.parse("file:" + createTemporaryWritableVideoFile.getAbsolutePath());
        Uri resolveFileProviderUriForFile = this.fileUriResolver.resolveFileProviderUriForFile(this.fileProviderName, createTemporaryWritableVideoFile);
        intent.putExtra("output", resolveFileProviderUriForFile);
        grantUriPermissions(intent, resolveFileProviderUriForFile);
        try {
            try {
                this.activity.startActivityForResult(intent, REQUEST_CODE_TAKE_VIDEO_WITH_CAMERA);
            } catch (ActivityNotFoundException unused) {
                createTemporaryWritableVideoFile.delete();
                finishWithError("no_available_camera", "No cameras available for taking pictures.");
            }
        } catch (SecurityException e4) {
            e4.printStackTrace();
            finishWithError("no_available_camera", "No cameras available for taking pictures.");
        }
    }

    private boolean needRequestCameraPermission() {
        PermissionManager permissionManager = this.permissionManager;
        if (permissionManager == null) {
            return false;
        }
        return permissionManager.needRequestCameraPermission();
    }

    private static List<ResolveInfo> queryIntentActivitiesPreApi33(PackageManager packageManager, Intent intent) {
        return packageManager.queryIntentActivities(intent, 65536);
    }

    private boolean setPendingOptionsAndResult(Messages.ImageSelectionOptions imageSelectionOptions, Messages.VideoSelectionOptions videoSelectionOptions, Messages.Result<List<String>> result) {
        synchronized (this.pendingCallStateLock) {
            try {
                if (this.pendingCallState != null) {
                    return false;
                }
                this.pendingCallState = new PendingCallState(imageSelectionOptions, videoSelectionOptions, result);
                this.cache.clear();
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void useFrontCamera(Intent intent) {
        intent.putExtra("android.intent.extras.CAMERA_FACING", 0);
        if (Build.VERSION.SDK_INT >= 26) {
            intent.putExtra("android.intent.extra.USE_FRONT_CAMERA", true);
        }
    }

    public void chooseImageFromGallery(Messages.ImageSelectionOptions imageSelectionOptions, boolean z3, Messages.Result<List<String>> result) {
        if (!setPendingOptionsAndResult(imageSelectionOptions, null, result)) {
            finishWithAlreadyActiveError(result);
        } else {
            launchPickImageFromGalleryIntent(Boolean.valueOf(z3));
        }
    }

    public void chooseMediaFromGallery(Messages.MediaSelectionOptions mediaSelectionOptions, Messages.GeneralOptions generalOptions, Messages.Result<List<String>> result) {
        if (!setPendingOptionsAndResult(mediaSelectionOptions.getImageSelectionOptions(), null, result)) {
            finishWithAlreadyActiveError(result);
        } else {
            launchPickMediaFromGalleryIntent(generalOptions);
        }
    }

    public void chooseMultiImageFromGallery(Messages.ImageSelectionOptions imageSelectionOptions, boolean z3, int i, Messages.Result<List<String>> result) {
        if (!setPendingOptionsAndResult(imageSelectionOptions, null, result)) {
            finishWithAlreadyActiveError(result);
        } else {
            launchMultiPickImageFromGalleryIntent(Boolean.valueOf(z3), i);
        }
    }

    public void chooseMultiVideoFromGallery(Messages.VideoSelectionOptions videoSelectionOptions, boolean z3, int i, Messages.Result<List<String>> result) {
        if (!setPendingOptionsAndResult(null, videoSelectionOptions, result)) {
            finishWithAlreadyActiveError(result);
        } else {
            launchMultiPickVideoFromGalleryIntent(Boolean.valueOf(z3), i);
        }
    }

    public void chooseVideoFromGallery(Messages.VideoSelectionOptions videoSelectionOptions, boolean z3, Messages.Result<List<String>> result) {
        if (!setPendingOptionsAndResult(null, videoSelectionOptions, result)) {
            finishWithAlreadyActiveError(result);
        } else {
            launchPickVideoFromGalleryIntent(Boolean.valueOf(z3));
        }
    }

    public void handleImageResult(String str, boolean z3) {
        Messages.ImageSelectionOptions imageSelectionOptions;
        synchronized (this.pendingCallStateLock) {
            try {
                PendingCallState pendingCallState = this.pendingCallState;
                if (pendingCallState != null) {
                    imageSelectionOptions = pendingCallState.imageOptions;
                } else {
                    imageSelectionOptions = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (imageSelectionOptions != null) {
            String resizedImagePath = getResizedImagePath(str, imageSelectionOptions);
            if (resizedImagePath != null && !resizedImagePath.equals(str) && z3) {
                new File(str).delete();
            }
            finishWithSuccess(resizedImagePath);
            return;
        }
        finishWithSuccess(str);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0010. Please report as an issue. */
    @Override // io.flutter.plugin.common.PluginRegistry.ActivityResultListener
    public boolean onActivityResult(int i, final int i3, final Intent intent) {
        Runnable runnable;
        if (i != REQUEST_CODE_CHOOSE_IMAGE_FROM_GALLERY) {
            if (i != REQUEST_CODE_TAKE_IMAGE_WITH_CAMERA) {
                if (i != REQUEST_CODE_CHOOSE_VIDEO_FROM_GALLERY) {
                    if (i != REQUEST_CODE_TAKE_VIDEO_WITH_CAMERA) {
                        switch (i) {
                            case REQUEST_CODE_CHOOSE_MULTI_IMAGE_FROM_GALLERY /* 2346 */:
                                final int i4 = 1;
                                runnable = new Runnable(this) { // from class: io.flutter.plugins.imagepicker.a

                                    /* renamed from: b, reason: collision with root package name */
                                    public final /* synthetic */ ImagePickerDelegate f5072b;

                                    {
                                        this.f5072b = this;
                                    }

                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        switch (i4) {
                                            case 0:
                                                this.f5072b.lambda$onActivityResult$0(i3, intent);
                                                return;
                                            case 1:
                                                this.f5072b.lambda$onActivityResult$1(i3, intent);
                                                return;
                                            case 2:
                                                this.f5072b.lambda$onActivityResult$2(i3, intent);
                                                return;
                                            case 3:
                                                this.f5072b.lambda$onActivityResult$4(i3, intent);
                                                return;
                                            default:
                                                this.f5072b.lambda$onActivityResult$5(i3, intent);
                                                return;
                                        }
                                    }
                                };
                                break;
                            case REQUEST_CODE_CHOOSE_MEDIA_FROM_GALLERY /* 2347 */:
                                final int i5 = 3;
                                runnable = new Runnable(this) { // from class: io.flutter.plugins.imagepicker.a

                                    /* renamed from: b, reason: collision with root package name */
                                    public final /* synthetic */ ImagePickerDelegate f5072b;

                                    {
                                        this.f5072b = this;
                                    }

                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        switch (i5) {
                                            case 0:
                                                this.f5072b.lambda$onActivityResult$0(i3, intent);
                                                return;
                                            case 1:
                                                this.f5072b.lambda$onActivityResult$1(i3, intent);
                                                return;
                                            case 2:
                                                this.f5072b.lambda$onActivityResult$2(i3, intent);
                                                return;
                                            case 3:
                                                this.f5072b.lambda$onActivityResult$4(i3, intent);
                                                return;
                                            default:
                                                this.f5072b.lambda$onActivityResult$5(i3, intent);
                                                return;
                                        }
                                    }
                                };
                                break;
                            case REQUEST_CODE_CHOOSE_MULTI_VIDEO_FROM_GALLERY /* 2348 */:
                                final int i6 = 2;
                                runnable = new Runnable(this) { // from class: io.flutter.plugins.imagepicker.a

                                    /* renamed from: b, reason: collision with root package name */
                                    public final /* synthetic */ ImagePickerDelegate f5072b;

                                    {
                                        this.f5072b = this;
                                    }

                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        switch (i6) {
                                            case 0:
                                                this.f5072b.lambda$onActivityResult$0(i3, intent);
                                                return;
                                            case 1:
                                                this.f5072b.lambda$onActivityResult$1(i3, intent);
                                                return;
                                            case 2:
                                                this.f5072b.lambda$onActivityResult$2(i3, intent);
                                                return;
                                            case 3:
                                                this.f5072b.lambda$onActivityResult$4(i3, intent);
                                                return;
                                            default:
                                                this.f5072b.lambda$onActivityResult$5(i3, intent);
                                                return;
                                        }
                                    }
                                };
                                break;
                            default:
                                return false;
                        }
                    } else {
                        runnable = new b(this, i3, 1);
                    }
                } else {
                    final int i7 = 4;
                    runnable = new Runnable(this) { // from class: io.flutter.plugins.imagepicker.a

                        /* renamed from: b, reason: collision with root package name */
                        public final /* synthetic */ ImagePickerDelegate f5072b;

                        {
                            this.f5072b = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            switch (i7) {
                                case 0:
                                    this.f5072b.lambda$onActivityResult$0(i3, intent);
                                    return;
                                case 1:
                                    this.f5072b.lambda$onActivityResult$1(i3, intent);
                                    return;
                                case 2:
                                    this.f5072b.lambda$onActivityResult$2(i3, intent);
                                    return;
                                case 3:
                                    this.f5072b.lambda$onActivityResult$4(i3, intent);
                                    return;
                                default:
                                    this.f5072b.lambda$onActivityResult$5(i3, intent);
                                    return;
                            }
                        }
                    };
                }
            } else {
                runnable = new b(this, i3, 0);
            }
        } else {
            final int i8 = 0;
            runnable = new Runnable(this) { // from class: io.flutter.plugins.imagepicker.a

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ ImagePickerDelegate f5072b;

                {
                    this.f5072b = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    switch (i8) {
                        case 0:
                            this.f5072b.lambda$onActivityResult$0(i3, intent);
                            return;
                        case 1:
                            this.f5072b.lambda$onActivityResult$1(i3, intent);
                            return;
                        case 2:
                            this.f5072b.lambda$onActivityResult$2(i3, intent);
                            return;
                        case 3:
                            this.f5072b.lambda$onActivityResult$4(i3, intent);
                            return;
                        default:
                            this.f5072b.lambda$onActivityResult$5(i3, intent);
                            return;
                    }
                }
            };
        }
        this.executor.execute(runnable);
        return true;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.RequestPermissionsResultListener
    public boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        boolean z3;
        if (iArr.length > 0 && iArr[0] == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (i != REQUEST_CAMERA_IMAGE_PERMISSION) {
            if (i != REQUEST_CAMERA_VIDEO_PERMISSION) {
                return false;
            }
            if (z3) {
                launchTakeVideoWithCameraIntent();
            }
        } else if (z3) {
            launchTakeImageWithCameraIntent();
        }
        if (!z3 && (i == REQUEST_CAMERA_IMAGE_PERMISSION || i == REQUEST_CAMERA_VIDEO_PERMISSION)) {
            finishWithError("camera_access_denied", "The user did not allow camera access.");
        }
        return true;
    }

    public Messages.CacheRetrievalResult retrieveLostImage() {
        int intValue;
        Map<String, Object> cacheMap = this.cache.getCacheMap();
        if (cacheMap.isEmpty()) {
            return null;
        }
        Messages.CacheRetrievalResult.Builder builder = new Messages.CacheRetrievalResult.Builder();
        Messages.CacheRetrievalType cacheRetrievalType = (Messages.CacheRetrievalType) cacheMap.get("type");
        if (cacheRetrievalType != null) {
            builder.setType(cacheRetrievalType);
        }
        builder.setError((Messages.CacheRetrievalError) cacheMap.get(Constants.IPC_BUNDLE_KEY_SEND_ERROR));
        ArrayList arrayList = (ArrayList) cacheMap.get("pathList");
        if (arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                String str = (String) obj;
                Double d2 = (Double) cacheMap.get("maxWidth");
                Double d4 = (Double) cacheMap.get("maxHeight");
                Integer num = (Integer) cacheMap.get("imageQuality");
                if (num == null) {
                    intValue = 100;
                } else {
                    intValue = num.intValue();
                }
                arrayList2.add(this.imageResizer.resizeImageIfNeeded(str, d2, d4, intValue));
            }
            builder.setPaths(arrayList2);
        }
        this.cache.clear();
        return builder.build();
    }

    public void saveStateBeforeResult() {
        ImagePickerCache.CacheType cacheType;
        synchronized (this.pendingCallStateLock) {
            try {
                PendingCallState pendingCallState = this.pendingCallState;
                if (pendingCallState == null) {
                    return;
                }
                Messages.ImageSelectionOptions imageSelectionOptions = pendingCallState.imageOptions;
                ImagePickerCache imagePickerCache = this.cache;
                if (imageSelectionOptions != null) {
                    cacheType = ImagePickerCache.CacheType.IMAGE;
                } else {
                    cacheType = ImagePickerCache.CacheType.VIDEO;
                }
                imagePickerCache.saveType(cacheType);
                if (imageSelectionOptions != null) {
                    this.cache.saveDimensionWithOutputOptions(imageSelectionOptions);
                }
                Uri uri = this.pendingCameraMediaUri;
                if (uri != null) {
                    this.cache.savePendingCameraMediaUriPath(uri);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setCameraDevice(CameraDevice cameraDevice) {
        this.cameraDevice = cameraDevice;
    }

    public void takeImageWithCamera(Messages.ImageSelectionOptions imageSelectionOptions, Messages.Result<List<String>> result) {
        if (!setPendingOptionsAndResult(imageSelectionOptions, null, result)) {
            finishWithAlreadyActiveError(result);
        } else if (needRequestCameraPermission() && !this.permissionManager.isPermissionGranted("android.permission.CAMERA")) {
            this.permissionManager.askForPermission("android.permission.CAMERA", REQUEST_CAMERA_IMAGE_PERMISSION);
        } else {
            launchTakeImageWithCameraIntent();
        }
    }

    public void takeVideoWithCamera(Messages.VideoSelectionOptions videoSelectionOptions, Messages.Result<List<String>> result) {
        if (!setPendingOptionsAndResult(null, videoSelectionOptions, result)) {
            finishWithAlreadyActiveError(result);
        } else if (needRequestCameraPermission() && !this.permissionManager.isPermissionGranted("android.permission.CAMERA")) {
            this.permissionManager.askForPermission("android.permission.CAMERA", REQUEST_CAMERA_VIDEO_PERMISSION);
        } else {
            launchTakeVideoWithCameraIntent();
        }
    }

    public ImagePickerDelegate(Activity activity, ImageResizer imageResizer, Messages.ImageSelectionOptions imageSelectionOptions, Messages.VideoSelectionOptions videoSelectionOptions, Messages.Result<List<String>> result, ImagePickerCache imagePickerCache, PermissionManager permissionManager, FileUriResolver fileUriResolver, FileUtils fileUtils, ExecutorService executorService) {
        this.pendingCallStateLock = new Object();
        this.activity = activity;
        this.imageResizer = imageResizer;
        this.fileProviderName = activity.getPackageName() + ".flutter.image_provider";
        if (result != null) {
            this.pendingCallState = new PendingCallState(imageSelectionOptions, videoSelectionOptions, result);
        }
        this.permissionManager = permissionManager;
        this.fileUriResolver = fileUriResolver;
        this.fileUtils = fileUtils;
        this.cache = imagePickerCache;
        this.executor = executorService;
    }
}
