package com.samsung.android.sbrowser.ext.clientservice.provider;

import android.content.Context;
import android.util.Log;
import com.samsung.android.sbrowser.ext.ExClientService;
import com.samsung.android.sbrowser.ext.clientservice.six.SixObject;

/* loaded from: classes.dex */
public class WebVttTrackProvider extends SixObject {
    private static final String TAG = "WebVttTrackProvider";
    ExClientService mClientService;
    Context mContext;
    private TrackProviderClient mTrackProviderClient;
    private WebVttTrackProviderWorker mWorker;

    public WebVttTrackProvider(Context context, ExClientService exClientService) {
        super(exClientService);
        this.mContext = null;
        this.mClientService = null;
        this.mWorker = null;
        this.mTrackProviderClient = null;
        Log.d(TAG, "WebVttTrackProvider ctor");
        this.mContext = context;
        this.mClientService = exClientService;
    }

    public void initProvider(String str, String str2, String str3) {
        Log.d(TAG, "init called with ");
        try {
            TrackProviderClient trackProviderClient = (TrackProviderClient) SixObject.findObject(str2);
            this.mTrackProviderClient = trackProviderClient;
            if (trackProviderClient == null) {
                throw new Exception("WebVttTrackProvider init : cant find consumer");
            }
            WebVttTrackProviderWorker webVttTrackProviderWorker = new WebVttTrackProviderWorker(this.mContext, this, this.mTrackProviderClient);
            this.mWorker = webVttTrackProviderWorker;
            webVttTrackProviderWorker.initProvider(str, str3);
        } catch (Exception e) {
            sendFail(str, e);
        }
    }

    public void deleteProvider(String str) {
        Log.d(TAG, "deleteProvider called with");
        try {
            WebVttTrackProviderWorker webVttTrackProviderWorker = this.mWorker;
            if (webVttTrackProviderWorker != null) {
                webVttTrackProviderWorker.deleteProvider(str);
            }
        } catch (Exception e) {
            sendFail(str, e);
        }
    }

    public void sendMoreCues(String str, String str2) {
        try {
            this.mWorker.sendMoreCues(str, str2);
        } catch (Exception e) {
            sendFail(str, e);
        }
    }

    public void resetSession(String str) {
        try {
            this.mWorker.resetSession(str);
        } catch (Exception e) {
            sendFail(str, e);
        }
    }
}
