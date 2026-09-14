package com.samsung.android.sbrowser.ext.clientservice.provider;

import android.content.Context;
import android.util.Log;
import com.samsung.android.sbrowser.ext.clientservice.texttrack.Cue;
import com.samsung.android.sbrowser.ext.clientservice.texttrack.TextTrack;
import java.util.ArrayList;
import java.util.Comparator;

/* loaded from: classes.dex */
class YoutubeApiTrackProviderWorker extends Worker implements TrackProvider {
    private static final double SENDDATA_INTERVAL_SEC = 1.0d;
    private static final String TAG = "YoutubeApiTPWorker";
    private final double mBufferLatency;
    private final YoutubeApiTrackProvider mClient;
    private final Context mContext;
    private final double mHandledEndTime;
    private final double mHandledStartTime;
    private String mLocale;
    private boolean mPausedSendData;
    private TrackSession mTextTrack;
    private final TrackProviderClient mTrackProviderClient;
    private TrackSession mTransTrack;
    private YoutubeTextTrack mYoutubeTextTrack;

    public YoutubeApiTrackProviderWorker(Context context, YoutubeApiTrackProvider youtubeApiTrackProvider, TrackProviderClient trackProviderClient, double d) {
        super(context, "YoutubeApiTrackProviderWorker", youtubeApiTrackProvider);
        this.mHandledStartTime = Double.MAX_VALUE;
        this.mHandledEndTime = Double.MIN_VALUE;
        this.mPausedSendData = false;
        Log.i(TAG, "YoutubeApiTrackProviderWorker ctor");
        this.mContext = context;
        this.mClient = youtubeApiTrackProvider;
        this.mTrackProviderClient = trackProviderClient;
        this.mBufferLatency = d;
    }

    public void initProvider(final String str, final String str2) throws Exception {
        Log.d(TAG, "initProvider called with " + str2);
        initThread();
        postToWorker(new Runnable() { // from class: com.samsung.android.sbrowser.ext.clientservice.provider.YoutubeApiTrackProviderWorker.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Log.d(YoutubeApiTrackProviderWorker.TAG, "initProviderOnWorker " + str2);
                    YoutubeApiTrackProviderWorker.this.mLocale = str2;
                    YoutubeApiTrackProviderWorker.this.mTrackProviderClient.initTrackProviderClient(YoutubeApiTrackProviderWorker.this);
                    YoutubeApiTrackProviderWorker youtubeApiTrackProviderWorker = YoutubeApiTrackProviderWorker.this;
                    youtubeApiTrackProviderWorker.sendSuccessToClient(str, Double.toString(youtubeApiTrackProviderWorker.mBufferLatency));
                } catch (Exception e) {
                    YoutubeApiTrackProviderWorker.this.sendFailToClient(str, e);
                }
            }
        });
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
        Log.i(TAG, "onDeleteOnWorker called");
        try {
            this.mTrackProviderClient.resetTrackProviderClient();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.i(TAG, "onDeleteOnWorker finished");
    }

    public void loadTextTrack(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final String str8) throws Exception {
        Log.d(TAG, "loadTextTrack  " + str2 + " | " + str3 + " | " + str4 + " | " + str5 + " | " + str6 + " | " + str7 + " | " + str8);
        postToWorker(new Runnable() { // from class: com.samsung.android.sbrowser.ext.clientservice.provider.YoutubeApiTrackProviderWorker.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    boolean parseBoolean = Boolean.parseBoolean(str4);
                    YoutubeApiTrackProviderWorker.this.resetSessionOnWorker();
                    YoutubeTextTrack youtubeTextTrack = new YoutubeTextTrack(str2, str3, parseBoolean, str5, Boolean.parseBoolean(str6), str7, Boolean.parseBoolean(str8));
                    if (YoutubeApiTrackProviderWorker.this.mYoutubeTextTrack != null && YoutubeApiTrackProviderWorker.this.mYoutubeTextTrack.needToReload(youtubeTextTrack)) {
                        Log.i(YoutubeApiTrackProviderWorker.TAG, "loadTextTrack : no need to reload");
                        return;
                    }
                    YoutubeApiTrackProviderWorker.this.mYoutubeTextTrack = youtubeTextTrack;
                    YoutubeApiTrackProviderWorker youtubeApiTrackProviderWorker = YoutubeApiTrackProviderWorker.this;
                    youtubeApiTrackProviderWorker.mLocale = youtubeApiTrackProviderWorker.mYoutubeTextTrack.getLocale();
                    YoutubeApiTrackProviderWorker youtubeApiTrackProviderWorker2 = YoutubeApiTrackProviderWorker.this;
                    YoutubeApiTrackProviderWorker youtubeApiTrackProviderWorker3 = YoutubeApiTrackProviderWorker.this;
                    youtubeApiTrackProviderWorker2.mTextTrack = new TrackSession(youtubeApiTrackProviderWorker3.mYoutubeTextTrack.loadTrack(false), YoutubeApiTrackProviderWorker.this.mBufferLatency);
                    if (str5.length() > 0) {
                        TextTrack loadTrack = YoutubeApiTrackProviderWorker.this.mYoutubeTextTrack.loadTrack(true);
                        if (loadTrack != null) {
                            YoutubeApiTrackProviderWorker youtubeApiTrackProviderWorker4 = YoutubeApiTrackProviderWorker.this;
                            YoutubeApiTrackProviderWorker youtubeApiTrackProviderWorker5 = YoutubeApiTrackProviderWorker.this;
                            youtubeApiTrackProviderWorker4.mTransTrack = new TrackSession(loadTrack, youtubeApiTrackProviderWorker5.mBufferLatency);
                        } else {
                            YoutubeApiTrackProviderWorker.this.mYoutubeTextTrack.setNeedTrans(true);
                            YoutubeApiTrackProviderWorker.this.mTransTrack = null;
                            parseBoolean = true;
                        }
                    } else {
                        YoutubeApiTrackProviderWorker.this.mTransTrack = null;
                    }
                    YoutubeApiTrackProviderWorker.this.mTrackProviderClient.resetTrackProviderClientSession(parseBoolean);
                    Log.i(YoutubeApiTrackProviderWorker.TAG, "new track is ready " + YoutubeApiTrackProviderWorker.this.mTextTrack.getTrack().size());
                    YoutubeApiTrackProviderWorker.this.sendSuccessToClient(str, new String[0]);
                } catch (Exception e) {
                    YoutubeApiTrackProviderWorker.this.sendFailToClient(str, e);
                }
            }
        });
    }

    void resetSessionOnWorker() {
        this.mPausedSendData = true;
        TrackSession trackSession = this.mTextTrack;
        if (trackSession != null) {
            trackSession.reset();
        }
        TrackSession trackSession2 = this.mTransTrack;
        if (trackSession2 != null) {
            trackSession2.reset();
        }
    }

    public void startSendData(final String str, final String str2) throws Exception {
        Log.d(TAG, "startSendData " + str2);
        postToWorker(new Runnable() { // from class: com.samsung.android.sbrowser.ext.clientservice.provider.YoutubeApiTrackProviderWorker.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Log.d(YoutubeApiTrackProviderWorker.TAG, "startSendData " + str2);
                    YoutubeApiTrackProviderWorker.this.mPausedSendData = false;
                    YoutubeApiTrackProviderWorker.this.onSendData(Double.parseDouble(str2));
                    YoutubeApiTrackProviderWorker.this.sendSuccessToClient(str, new String[0]);
                } catch (Exception e) {
                    YoutubeApiTrackProviderWorker.this.sendFailToClient(str, e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSendData(final double d) throws Exception {
        if (this.mPausedSendData) {
            Log.i(TAG, "onSendData is paused");
            return;
        }
        ArrayList<Cue> findCues = this.mTextTrack.findCues(d);
        if (findCues.size() > 0) {
            sendResult(findCues, null);
        }
        TrackSession trackSession = this.mTransTrack;
        if (trackSession != null) {
            ArrayList<Cue> findCues2 = trackSession.findCues(d);
            if (findCues2.size() > 0) {
                sendResult(findCues2, null);
            }
        }
        postDelayedToWorker(new Runnable() { // from class: com.samsung.android.sbrowser.ext.clientservice.provider.YoutubeApiTrackProviderWorker.4
            @Override // java.lang.Runnable
            public void run() {
                if (!YoutubeApiTrackProviderWorker.this.mPausedSendData) {
                    try {
                        YoutubeApiTrackProviderWorker.this.onSendData(d + YoutubeApiTrackProviderWorker.SENDDATA_INTERVAL_SEC);
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
                Log.i(YoutubeApiTrackProviderWorker.TAG, "onSendData is paused");
            }
        }, 1000L);
    }

    public void pauseSendData(final String str) {
        postToWorker(new Runnable() { // from class: com.samsung.android.sbrowser.ext.clientservice.provider.YoutubeApiTrackProviderWorker.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Log.d(YoutubeApiTrackProviderWorker.TAG, "pauseSendData ");
                    YoutubeApiTrackProviderWorker.this.mPausedSendData = true;
                    YoutubeApiTrackProviderWorker.this.sendSuccessToClient(str, new String[0]);
                } catch (Exception e) {
                    YoutubeApiTrackProviderWorker.this.sendFailToClient(str, e);
                }
            }
        });
    }

    public void resetSession(final String str) {
        postToWorker(new Runnable() { // from class: com.samsung.android.sbrowser.ext.clientservice.provider.YoutubeApiTrackProviderWorker.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Log.d(YoutubeApiTrackProviderWorker.TAG, "resetSession ");
                    YoutubeApiTrackProviderWorker.this.resetSessionOnWorker();
                    YoutubeApiTrackProviderWorker.this.sendSuccessToClient(str, new String[0]);
                } catch (Exception e) {
                    YoutubeApiTrackProviderWorker.this.sendFailToClient(str, e);
                }
            }
        });
    }

    @Override // com.samsung.android.sbrowser.ext.clientservice.provider.TrackProvider
    public String getLocale() {
        return this.mLocale;
    }

    void sendResult(final ArrayList<Cue> arrayList, final Exception exc) {
        postToWorker(new Runnable() { // from class: com.samsung.android.sbrowser.ext.clientservice.provider.YoutubeApiTrackProviderWorker.7
            @Override // java.lang.Runnable
            public void run() {
                if (arrayList != null && exc == null) {
                    YoutubeApiTrackProviderWorker.this.mTrackProviderClient.onMoreTrackData(arrayList);
                } else if (exc != null) {
                    YoutubeApiTrackProviderWorker.this.mTrackProviderClient.onTrackProviderError(exc);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class TrackSession {
        Comparator<Cue> mCompOp = new Comparator<Cue>() { // from class: com.samsung.android.sbrowser.ext.clientservice.provider.YoutubeApiTrackProviderWorker.TrackSession.1
            @Override // java.util.Comparator
            public int compare(Cue cue, Cue cue2) {
                if (cue.getStartSec() > cue2.getStartSec() || cue2.getStartSec() > cue.getEndSec()) {
                    return cue2.getStartSec() > cue.getEndSec() ? -1 : 1;
                }
                return 0;
            }
        };
        private int mLastCueIdx = -1;
        private double mLatency;
        private TextTrack mTextTrack;

        TrackSession(TextTrack textTrack, double d) {
            this.mTextTrack = textTrack;
            this.mLatency = d;
        }

        void reset() {
            this.mLastCueIdx = -1;
        }

        TextTrack getTrack() {
            return this.mTextTrack;
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x002f, code lost:
        
            r3 = r3 + 1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        java.util.ArrayList<com.samsung.android.sbrowser.ext.clientservice.texttrack.Cue> findCues(double r11) {
            /*
                r10 = this;
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                com.samsung.android.sbrowser.ext.clientservice.texttrack.TextTrack r1 = r10.mTextTrack
                java.lang.String r2 = "YoutubeApiTPWorker"
                if (r1 != 0) goto L11
                java.lang.String r11 = "mTextTrack is not ready"
                android.util.Log.i(r2, r11)
                return r0
            L11:
                int r3 = r10.mLastCueIdx
                r4 = -1
                if (r3 == r4) goto L17
                goto L5a
            L17:
                java.util.List r1 = r1.getCues()
                com.samsung.android.sbrowser.ext.clientservice.texttrack.Cue r3 = new com.samsung.android.sbrowser.ext.clientservice.texttrack.Cue
                r3.<init>(r11, r11)
                java.util.Comparator<com.samsung.android.sbrowser.ext.clientservice.texttrack.Cue> r4 = r10.mCompOp
                int r1 = java.util.Collections.binarySearch(r1, r3, r4)
                if (r1 >= 0) goto L2b
                int r1 = -r1
                int r1 = r1 + (-1)
            L2b:
                r3 = r1
                if (r3 >= 0) goto L2f
                r3 = 0
            L2f:
                com.samsung.android.sbrowser.ext.clientservice.texttrack.TextTrack r1 = r10.mTextTrack
                java.util.List r1 = r1.getCues()
                int r1 = r1.size()
                if (r3 >= r1) goto L7d
                com.samsung.android.sbrowser.ext.clientservice.texttrack.TextTrack r1 = r10.mTextTrack
                java.util.List r1 = r1.getCues()
                java.lang.Object r1 = r1.get(r3)
                com.samsung.android.sbrowser.ext.clientservice.texttrack.Cue r1 = (com.samsung.android.sbrowser.ext.clientservice.texttrack.Cue) r1
                double r4 = r1.getStartSec()
                double r6 = r10.mLatency
                double r6 = r6 + r11
                r8 = 4607182418800017408(0x3ff0000000000000, double:1.0)
                double r6 = r6 + r8
                int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r4 >= 0) goto L5d
                r0.add(r1)
                r10.mLastCueIdx = r3
            L5a:
                int r3 = r3 + 1
                goto L2f
            L5d:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                java.lang.String r4 = "cue is outside the buffer latency "
                r3.<init>(r4)
                double r4 = r1.getStartSec()
                java.lang.StringBuilder r1 = r3.append(r4)
                java.lang.String r3 = " "
                java.lang.StringBuilder r1 = r1.append(r3)
                java.lang.StringBuilder r11 = r1.append(r11)
                java.lang.String r11 = r11.toString()
                android.util.Log.i(r2, r11)
            L7d:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.samsung.android.sbrowser.ext.clientservice.provider.YoutubeApiTrackProviderWorker.TrackSession.findCues(double):java.util.ArrayList");
        }
    }
}
