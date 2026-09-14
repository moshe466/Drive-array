package com.samsung.android.sbrowser.ext.clientservice.provider;

import android.content.Context;
import android.util.Log;
import com.samsung.android.sbrowser.ext.ExClientService;
import com.samsung.android.sbrowser.ext.clientservice.six.SixObject;

/* loaded from: classes.dex */
public class YoutubeApiTrackProvider extends SixObject {
    private static final int BUFFER_LATENCY = 10;
    private static final String TAG = "YoutubeApiTrackProvider";
    ExClientService mClientService;
    Context mContext;
    private TrackProviderClient mTrackProviderClient;
    private YoutubeApiTrackProviderWorker mWorker;

    public YoutubeApiTrackProvider(Context context, ExClientService exClientService) {
        super(exClientService);
        this.mContext = null;
        this.mClientService = null;
        this.mWorker = null;
        this.mTrackProviderClient = null;
        Log.d(TAG, "YoutubeApiTrackProvider ctor");
        this.mContext = context;
        this.mClientService = exClientService;
    }

    public void initProvider(String str, String str2, String str3) {
        Log.d(TAG, "init called with " + str2 + " " + str3 + " ");
        try {
            TrackProviderClient trackProviderClient = (TrackProviderClient) SixObject.findObject(str2);
            this.mTrackProviderClient = trackProviderClient;
            if (trackProviderClient == null) {
                throw new Exception("YoutubeApiTrackProvider init : cant find consumer");
            }
            YoutubeApiTrackProviderWorker youtubeApiTrackProviderWorker = new YoutubeApiTrackProviderWorker(this.mContext, this, this.mTrackProviderClient, 10.0d);
            this.mWorker = youtubeApiTrackProviderWorker;
            youtubeApiTrackProviderWorker.initProvider(str, str3);
        } catch (Exception e) {
            sendFail(str, e);
        }
    }

    public void deleteProvider(String str) {
        Log.d(TAG, "deleteProvider called with");
        try {
            YoutubeApiTrackProviderWorker youtubeApiTrackProviderWorker = this.mWorker;
            if (youtubeApiTrackProviderWorker != null) {
                youtubeApiTrackProviderWorker.deleteProvider(str);
            }
        } catch (Exception e) {
            sendFail(str, e);
        }
    }

    public void loadTextTrack(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        try {
            this.mWorker.loadTextTrack(str, str2, str3, str4, str5, str6, str7, str8);
        } catch (Exception e) {
            sendFail(str, e);
        }
    }

    public void startSendData(String str, String str2) {
        Log.d(TAG, "startSendData " + str2);
        try {
            this.mWorker.startSendData(str, str2);
        } catch (Exception e) {
            sendFail(str, e);
        }
    }

    public void pauseSendData(String str) {
        Log.d(TAG, "pauseSendData ");
        try {
            this.mWorker.pauseSendData(str);
        } catch (Exception e) {
            sendFail(str, e);
        }
    }

    public void resetSession(String str) {
        Log.d(TAG, "resetSession ");
        try {
            this.mWorker.resetSession(str);
        } catch (Exception e) {
            sendFail(str, e);
        }
    }
}
