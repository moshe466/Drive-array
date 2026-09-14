package com.squareup.picasso;

import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestHandler;
import java.io.InputStream;
import okio.Okio;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class ContentStreamRequestHandler extends RequestHandler {
    final Context a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ContentStreamRequestHandler(Context context) {
        this.a = context;
    }

    @Override // com.squareup.picasso.RequestHandler
    public boolean canHandleRequest(Request request) {
        return FirebaseAnalytics.Param.CONTENT.equals(request.uri.getScheme());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InputStream getInputStream(Request request) {
        return this.a.getContentResolver().openInputStream(request.uri);
    }

    @Override // com.squareup.picasso.RequestHandler
    public RequestHandler.Result load(Request request, int i) {
        return new RequestHandler.Result(Okio.source(getInputStream(request)), Picasso.LoadedFrom.DISK);
    }
}
