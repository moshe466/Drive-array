package com.google.firebase.inappmessaging.display.internal;

import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.FirebaseAppScope;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import javax.inject.Inject;

@FirebaseAppScope
/* loaded from: classes2.dex */
public class FiamImageLoader {
    private final Picasso picasso;

    /* loaded from: classes2.dex */
    public static class FiamImageRequestCreator {
        private final RequestCreator mRequestCreator;

        public FiamImageRequestCreator(RequestCreator requestCreator) {
            this.mRequestCreator = requestCreator;
        }

        public void into(ImageView imageView, Callback callback) {
            this.mRequestCreator.into(imageView, callback);
        }

        public FiamImageRequestCreator placeholder(int i) {
            this.mRequestCreator.placeholder(i);
            return this;
        }

        public FiamImageRequestCreator tag(Class cls) {
            this.mRequestCreator.tag(cls);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public FiamImageLoader(Picasso picasso) {
        this.picasso = picasso;
    }

    public void cancelTag(Class cls) {
        this.picasso.cancelTag(cls);
    }

    public FiamImageRequestCreator load(@Nullable String str) {
        return new FiamImageRequestCreator(this.picasso.load(str));
    }
}
