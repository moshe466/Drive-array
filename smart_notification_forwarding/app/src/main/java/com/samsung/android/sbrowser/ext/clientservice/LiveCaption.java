package com.samsung.android.sbrowser.ext.clientservice;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.samsung.android.sbrowser.ext.ExClientService;
import com.samsung.android.sbrowser.ext.clientservice.provider.TrackProvider;
import com.samsung.android.sbrowser.ext.clientservice.provider.TrackProviderClient;
import com.samsung.android.sbrowser.ext.clientservice.six.SixLog;
import com.samsung.android.sbrowser.ext.clientservice.six.SixObject;
import com.samsung.android.sbrowser.ext.clientservice.texttrack.Cue;
import com.samsung.android.sbrowser.ext.clientservice.translator.Translator;
import com.samsung.android.sbrowser.ext.clientservice.translator.TranslatorClient;
import com.samsung.android.sbrowser.ext.clientservice.translator.TranslatorFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class LiveCaption extends SixObject implements TrackProviderClient, TranslatorClient {
    private static final long CUE_EVENT_DELAY_MS = 1000;
    private static final boolean SPLIT_CUE_BY_CHAR_COUNT = true;
    private static final String TAG = "LiveCaption";
    private int mCharCountPerLine;
    ExClientService mClientService;
    Context mContext;
    private final HashMap<Integer, Cue> mCueHashMap;
    private final Queue<Cue> mCueQueue;
    private String mDstLocale;
    AtomicBoolean mEnableTranslate;
    Runnable mFireCueEventRunnable;
    private Boolean mNeedTranslate;
    private String mObjectName;
    boolean mPendingFireCueEventRunnable;
    private final String mPendingWaitAndGetResultId;
    private Handler mSixHandler;
    private TrackProvider mTrackProvider;
    private Translator mTranslator;

    public LiveCaption(Context context, ExClientService exClientService) {
        super(exClientService);
        this.mPendingWaitAndGetResultId = null;
        this.mContext = null;
        this.mClientService = null;
        this.mPendingFireCueEventRunnable = false;
        this.mSixHandler = null;
        this.mDstLocale = null;
        this.mNeedTranslate = false;
        this.mCharCountPerLine = 0;
        this.mFireCueEventRunnable = new Runnable() { // from class: com.samsung.android.sbrowser.ext.clientservice.LiveCaption.1
            @Override // java.lang.Runnable
            public void run() {
                LiveCaption.this.mPendingFireCueEventRunnable = false;
                LiveCaption.this.fireCueEvent(null);
            }
        };
        Log.d(TAG, "LiveCaption ctor");
        this.mContext = context;
        this.mClientService = exClientService;
        this.mCueQueue = new LinkedList();
        this.mSixHandler = new Handler(Looper.myLooper());
        this.mCueHashMap = new HashMap<>();
        this.mEnableTranslate = new AtomicBoolean(SPLIT_CUE_BY_CHAR_COUNT);
        this.mCharCountPerLine = 0;
    }

    void logException(Exception exc) {
        Log.e(TAG, exc.toString());
        exc.printStackTrace();
    }

    public void createObject(String str, String str2, String str3, String str4) {
        Log.d(TAG, "createObject called with  " + str2 + " " + str3);
        try {
            SixObject.registerObject(str2, this);
            this.mDstLocale = str3;
            this.mObjectName = str2;
            this.mCharCountPerLine = Integer.parseInt(str4);
            sendSuccess(str, new String[0]);
        } catch (Exception e) {
            sendFail(str, e);
        }
    }

    public void deleteObject(String str) {
        Log.i(TAG, "deleteObject called");
        try {
            SixObject.removeObject(this.mObjectName);
            sendSuccess(str, new String[0]);
        } catch (Exception e) {
            sendFail(str, e);
        }
    }

    public void setCharCountPerLine(String str, String str2) {
        Log.d(TAG, "setCharCountPerLine " + str2);
        try {
            this.mCharCountPerLine = Integer.parseInt(str2);
            sendSuccess(str, new String[0]);
        } catch (Exception e) {
            sendFail(str, e);
        }
    }

    public void enableTranslate(String str, String str2) {
        Log.d(TAG, "enableTranslate " + str2);
        try {
            this.mEnableTranslate.set(Boolean.parseBoolean(str2));
            sendSuccess(str, new String[0]);
        } catch (Exception e) {
            sendFail(str, e);
        }
    }

    @Override // com.samsung.android.sbrowser.ext.clientservice.provider.TrackProviderClient
    public void initTrackProviderClient(TrackProvider trackProvider) {
        try {
            this.mTrackProvider = trackProvider;
            Translator createTranslator = TranslatorFactory.createTranslator(this.mContext);
            this.mTranslator = createTranslator;
            if (createTranslator == null) {
                throw new RuntimeException("fail to create Translator ");
            }
            createTranslator.init(this.mContext, this);
        } catch (Exception e) {
            sendResult(null, e);
        }
    }

    @Override // com.samsung.android.sbrowser.ext.clientservice.provider.TrackProviderClient
    public void resetTrackProviderClient() {
        try {
            Translator translator = this.mTranslator;
            if (translator != null) {
                translator.delete();
                this.mTranslator = null;
            }
        } catch (Exception e) {
            sendResult(null, e);
        }
    }

    @Override // com.samsung.android.sbrowser.ext.clientservice.provider.TrackProviderClient
    public void onMoreTrackData(ArrayList<Cue> arrayList) {
        if (arrayList.size() <= 0) {
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            try {
                Cue cue = arrayList.get(i);
                if (cue.getText().length() >= 3) {
                    if (!this.mEnableTranslate.get()) {
                        if (!cue.getIsTrans()) {
                            sendResult(cue, null);
                        }
                    } else {
                        if (!cue.getIsTrans() && this.mNeedTranslate.booleanValue()) {
                            String langCode = cue.getLangCode();
                            if (langCode == null) {
                                SixLog.error(TAG, "onMoreTrackData : langcode is null");
                            } else if (langCode.equals(this.mDstLocale)) {
                                sendResult(cue, null);
                            } else {
                                this.mCueHashMap.put(new Integer(cue.getId()), cue);
                                this.mTranslator.translate(cue.getText(), cue.getId(), langCode, this.mDstLocale, false);
                                sendResult(cue, null);
                            }
                        }
                        sendResult(cue, null);
                    }
                }
            } catch (Exception e) {
                sendResult(null, e);
                return;
            }
        }
    }

    @Override // com.samsung.android.sbrowser.ext.clientservice.provider.TrackProviderClient
    public void onTrackProviderError(Exception exc) {
        sendResult(null, exc);
    }

    @Override // com.samsung.android.sbrowser.ext.clientservice.provider.TrackProviderClient
    public void resetTrackProviderClientSession(final boolean z) {
        this.mSixHandler.post(new Runnable() { // from class: com.samsung.android.sbrowser.ext.clientservice.LiveCaption.2
            @Override // java.lang.Runnable
            public void run() {
                LiveCaption.this.initSession(z);
            }
        });
    }

    @Override // com.samsung.android.sbrowser.ext.clientservice.translator.TranslatorClient
    public void onTranslated(String str, int i) {
        if (i > Cue.getCurrId()) {
            Log.e(TAG, "it would be pending result in previous session " + i);
            return;
        }
        Integer num = new Integer(i);
        Cue cue = this.mCueHashMap.get(num);
        if (cue == null) {
            Log.e(TAG, "invalid key from translator " + i);
            sendResult(null, new RuntimeException("invalid key from translator"));
            return;
        }
        this.mCueHashMap.remove(num);
        Cue cue2 = new Cue(cue.getStartSec(), cue.getEndSec(), str);
        cue2.setLangCode(this.mDstLocale);
        cue2.setIsTrans(SPLIT_CUE_BY_CHAR_COUNT);
        cue2.setRefCue(cue);
        sendResult(cue2, null);
    }

    void sendResult(final Cue cue, final Exception exc) {
        this.mSixHandler.post(new Runnable() { // from class: com.samsung.android.sbrowser.ext.clientservice.LiveCaption.3
            @Override // java.lang.Runnable
            public void run() {
                LiveCaption.this.onCueResult(cue, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSession(boolean z) {
        this.mNeedTranslate = Boolean.valueOf(z);
        this.mCueQueue.clear();
    }

    @Override // com.samsung.android.sbrowser.ext.clientservice.six.SixObject
    public void addEventListener(String str, String str2) {
        super.addEventListener(str, str2);
    }

    @Override // com.samsung.android.sbrowser.ext.clientservice.six.SixObject
    public void removeEventListener(String str, String str2) {
        super.removeEventListener(str, str2);
    }

    ArrayList<Cue> collectCues() {
        ArrayList<Cue> arrayList = new ArrayList<>();
        long j = 0;
        while (true) {
            Cue peek = this.mCueQueue.peek();
            if (peek == null) {
                break;
            }
            j = j + 8 + (peek.getText().length() * 3) + (peek.getLangCode().length() * 3);
            if (j >= CueEvent.MAX_CUEEVENT_LEN) {
                break;
            }
            arrayList.add(peek);
            this.mCueQueue.remove();
        }
        return arrayList;
    }

    void fireCueEvent(Exception exc) {
        try {
            if (exc != null) {
                fireEvent(new CueEvent(null, exc));
                return;
            }
            if (this.mCueQueue.size() <= 0) {
                Log.e(TAG, "no pending cue to fire cueEvent");
                return;
            }
            ArrayList<Cue> collectCues = collectCues();
            if (collectCues.size() <= 0) {
                Log.e(TAG, "no pending cues to fire cueEvent");
            } else {
                fireEvent(new CueEvent(splitCues(collectCues), null));
            }
        } catch (Exception e) {
            fireEvent(new CueEvent(null, e));
        }
    }

    ArrayList<Cue> splitCues(ArrayList<Cue> arrayList) {
        if (this.mCharCountPerLine <= 0) {
            SixLog.error(TAG, "LiveCaption::splitCues : mCharCountPerLine <= 0");
            return arrayList;
        }
        ArrayList<Cue> arrayList2 = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            List<Cue> splitCueByCharCount = arrayList.get(i).splitCueByCharCount(this.mCharCountPerLine, arrayList.get(i).getRefCue());
            for (int i2 = 0; i2 < splitCueByCharCount.size(); i2++) {
                arrayList2.add(splitCueByCharCount.get(i2));
            }
        }
        return arrayList2;
    }

    void queueCue(Cue cue) {
        Queue<Cue> queue = this.mCueQueue;
        if (queue != null) {
            queue.add(cue);
        }
    }

    void onCueResult(Cue cue, Exception exc) {
        if (exc != null) {
            logException(exc);
            fireCueEvent(exc);
        } else {
            queueCue(cue);
            fireDelayedCueEvent();
        }
    }

    void fireDelayedCueEvent() {
        if (this.mPendingFireCueEventRunnable) {
            Log.i(TAG, "fireDelayedCueEvent already exist");
        } else {
            this.mPendingFireCueEventRunnable = SPLIT_CUE_BY_CHAR_COUNT;
            this.mSixHandler.postDelayed(this.mFireCueEventRunnable, CUE_EVENT_DELAY_MS);
        }
    }
}
