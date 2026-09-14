package com.squareup.picasso;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestHandler;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class ResourceRequestHandler extends RequestHandler {
    private final Context context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResourceRequestHandler(Context context) {
        this.context = context;
    }

    private static Bitmap decodeResource(Resources resources, int i, Request request) {
        BitmapFactory.Options a = RequestHandler.a(request);
        if (RequestHandler.a(a)) {
            BitmapFactory.decodeResource(resources, i, a);
            RequestHandler.a(request.targetWidth, request.targetHeight, a, request);
        }
        return BitmapFactory.decodeResource(resources, i, a);
    }

    @Override // com.squareup.picasso.RequestHandler
    public boolean canHandleRequest(Request request) {
        if (request.resourceId != 0) {
            return true;
        }
        return "android.resource".equals(request.uri.getScheme());
    }

    @Override // com.squareup.picasso.RequestHandler
    public RequestHandler.Result load(Request request, int i) {
        Resources a = Utils.a(this.context, request);
        return new RequestHandler.Result(decodeResource(a, Utils.a(a, request), request), Picasso.LoadedFrom.DISK);
    }
}
