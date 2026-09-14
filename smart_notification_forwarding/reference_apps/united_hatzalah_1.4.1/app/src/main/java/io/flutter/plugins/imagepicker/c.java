package io.flutter.plugins.imagepicker;

import io.flutter.plugins.imagepicker.ImagePickerDelegate;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements ImagePickerDelegate.OnPathReadyListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5078a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImagePickerDelegate f5079b;

    public /* synthetic */ c(ImagePickerDelegate imagePickerDelegate, int i) {
        this.f5078a = i;
        this.f5079b = imagePickerDelegate;
    }

    @Override // io.flutter.plugins.imagepicker.ImagePickerDelegate.OnPathReadyListener
    public final void onPathReady(String str) {
        switch (this.f5078a) {
            case 0:
                this.f5079b.lambda$handleCaptureImageResult$7(str);
                return;
            default:
                this.f5079b.finishWithSuccess(str);
                return;
        }
    }
}
