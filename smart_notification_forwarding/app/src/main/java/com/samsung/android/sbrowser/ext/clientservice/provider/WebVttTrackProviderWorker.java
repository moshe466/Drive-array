package com.samsung.android.sbrowser.ext.clientservice.provider;

import android.content.Context;
import android.util.Log;
import com.samsung.android.sbrowser.ext.clientservice.six.SixLog;
import com.samsung.android.sbrowser.ext.clientservice.six.SixObject;
import com.samsung.android.sbrowser.ext.clientservice.texttrack.Cue;
import java.util.ArrayList;

/* loaded from: classes.dex */
class WebVttTrackProviderWorker extends Worker implements TrackProvider {
    private static final String TAG = "WebVttTPWorker";
    private final WebVttTrackProvider mClient;
    private final Context mContext;
    private String mLocale;
    private final TrackProviderClient mTrackProviderClient;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebVttTrackProviderWorker(Context context, WebVttTrackProvider webVttTrackProvider, TrackProviderClient trackProviderClient) {
        super(context, "WebVttTrackProviderWorker", webVttTrackProvider);
        Log.i(TAG, "WebVttTrackProviderWorker ctor");
        this.mContext = context;
        this.mClient = webVttTrackProvider;
        this.mTrackProviderClient = trackProviderClient;
    }

    public void initProvider(final String str, final String str2) throws Exception {
        SixLog.dlog(TAG, "init called with " + str2);
        initThread();
        postToWorker(new Runnable() { // from class: com.samsung.android.sbrowser.ext.clientservice.provider.WebVttTrackProviderWorker.1
            @Override // java.lang.Runnable
            public void run() {
                WebVttTrackProviderWorker.this.initProviderOnWorker(str, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initProviderOnWorker(String str, String str2) {
        try {
            this.mLocale = str2;
            SixLog.dlog(TAG, "initProviderOnWorker " + this.mLocale);
            this.mTrackProviderClient.initTrackProviderClient(this);
            sendSuccessToClient(str, new String[0]);
        } catch (Exception e) {
            sendFailToClient(str, e);
        }
    }

    public void deleteProvider(String str) {
        try {
            deleteThread();
            sendSuccessToClient(str, new String[0]);
        } catch (Exception e) {
            sendFailToClient(str, e);
        }
    }

    @Override // com.samsung.android.sbrowser.ext.clientservice.provider.Worker
    protected void onDeleteOnWorker() {
        SixLog.dlog(TAG, "onDeleteOnWorker called");
        try {
            this.mTrackProviderClient.resetTrackProviderClient();
        } catch (Exception e) {
            e.printStackTrace();
        }
        SixLog.dlog(TAG, "onDeleteOnWorker finished");
    }

    public void sendMoreCues(final String str, final String str2) throws Exception {
        SixLog.dlog(TAG, "sendMoreCues");
        postToWorker(new Runnable() { // from class: com.samsung.android.sbrowser.ext.clientservice.provider.WebVttTrackProviderWorker.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String[] strArr = SixObject.tokenizeParam(str2);
                    if (strArr.length != 0 && strArr.length % 3 == 0) {
                        ArrayList<Cue> arrayList = new ArrayList<>();
                        for (int i = 0; i < strArr.length; i += 3) {
                            Cue cue = new Cue(Double.parseDouble(strArr[i]), Double.parseDouble(strArr[i + 1]), strArr[i + 2]);
                            cue.setLangCode(WebVttTrackProviderWorker.this.getLocale());
                            arrayList.add(cue);
                        }
                        WebVttTrackProviderWorker.this.mTrackProviderClient.onMoreTrackData(arrayList);
                        return;
                    }
                    SixLog.error(WebVttTrackProviderWorker.TAG, "sendMoreCues : wrong length of cues");
                    WebVttTrackProviderWorker.this.sendFailToClient(str, new RuntimeException("wrong length of cues"));
                } catch (Exception e) {
                    WebVttTrackProviderWorker.this.sendFailToClient(str, e);
                }
            }
        });
    }

    public void resetSession(final String str) throws Exception {
        SixLog.dlog(TAG, "resetSession");
        postToWorker(new Runnable() { // from class: com.samsung.android.sbrowser.ext.clientservice.provider.WebVttTrackProviderWorker.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebVttTrackProviderWorker.this.mTrackProviderClient.resetTrackProviderClientSession(true);
                } catch (Exception e) {
                    WebVttTrackProviderWorker.this.sendFailToClient(str, e);
                }
            }
        });
    }

    @Override // com.samsung.android.sbrowser.ext.clientservice.provider.TrackProvider
    public String getLocale() throws Exception {
        return this.mLocale;
    }
}
