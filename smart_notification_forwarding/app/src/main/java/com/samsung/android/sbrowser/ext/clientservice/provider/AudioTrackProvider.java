package com.samsung.android.sbrowser.ext.clientservice.provider;

import android.content.Context;
import android.util.Log;
import com.samsung.android.sbrowser.ext.ExClientService;
import com.samsung.android.sbrowser.ext.clientservice.six.SixObject;

/* loaded from: classes.dex */
public class AudioTrackProvider extends SixObject {
    private static final String TAG = "AudioTrackProvider";
    ExClientService mClientService;
    Context mContext;
    private TrackProviderClient mTrackProviderClient;
    private AudioTrackProviderWorker mWorker;

    public AudioTrackProvider(Context context, ExClientService exClientService) {
        super(exClientService);
        this.mContext = null;
        this.mClientService = null;
        this.mWorker = null;
        this.mTrackProviderClient = null;
        Log.d(TAG, "AudioTrackProvider ctor");
        this.mContext = context;
        this.mClientService = exClientService;
    }

    public void initProvider(String str, String str2, String str3, String str4) {
        Log.d(TAG, "initProvider called with ");
        try {
            TrackProviderClient trackProviderClient = (TrackProviderClient) SixObject.findObject(str2);
            this.mTrackProviderClient = trackProviderClient;
            if (trackProviderClient == null) {
                throw new Exception("AudioTrackProvider init : cant find consumer");
            }
            AudioTrackProviderWorker audioTrackProviderWorker = new AudioTrackProviderWorker(this.mContext, this, this.mTrackProviderClient);
            this.mWorker = audioTrackProviderWorker;
            audioTrackProviderWorker.initProvider(str, str3, str4);
        } catch (Exception e) {
            sendFail(str, e);
        }
    }

    public void deleteProvider(String str) {
        Log.d(TAG, "deleteProvider called with");
        try {
            AudioTrackProviderWorker audioTrackProviderWorker = this.mWorker;
            if (audioTrackProviderWorker != null) {
                audioTrackProviderWorker.deleteProvider(str);
            }
        } catch (Exception e) {
            sendFail(str, e);
        }
    }

    public void addAudio(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        try {
            this.mWorker.addAudio(str, str2, str3, str4, str5, str6, str7, str8);
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
