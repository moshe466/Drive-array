package com.samsung.android.sbrowser.ext.clientservice.provider;

import com.samsung.android.sbrowser.ext.clientservice.sentence_splitter.YoutubeJson3SentenceSplitter;
import com.samsung.android.sbrowser.ext.clientservice.six.SixLog;
import com.samsung.android.sbrowser.ext.clientservice.texttrack.Cue;
import com.samsung.android.sbrowser.ext.clientservice.texttrack.TextTrack;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class YoutubeTextTrack {
    private static final String JSON3_PARAM = "fmt=json3";
    private static final String TAG = "YoutubeTextTrack";
    private final String mBaseUrl;
    private final String mLocale;
    private final boolean mNeedSplitSentence;
    private boolean mNeedTrans;
    private final String mTlangParam;
    private final boolean mUseJson3;

    public YoutubeTextTrack(String str, String str2, boolean z, String str3, boolean z2, String str4, boolean z3) {
        this.mLocale = str;
        this.mBaseUrl = str2;
        this.mNeedTrans = z;
        this.mNeedSplitSentence = z2;
        this.mTlangParam = str3;
        this.mUseJson3 = z3;
    }

    public void setNeedTrans(boolean z) {
        this.mNeedTrans = z;
    }

    public TextTrack loadTrack(boolean z) throws Exception {
        TextTrack loadJson3Track;
        String str;
        String str2 = this.mBaseUrl;
        if (z && !this.mNeedTrans && (str = this.mTlangParam) != null && str.length() > 0) {
            str2 = (str2 + "&") + this.mTlangParam;
        }
        if (this.mNeedSplitSentence || this.mUseJson3) {
            loadJson3Track = loadJson3Track((str2 + "&") + JSON3_PARAM);
        } else {
            loadJson3Track = loadBaseTrack(str2);
        }
        if (loadJson3Track.size() == 0) {
            return null;
        }
        String str3 = this.mLocale;
        if (z) {
            str3 = this.mTlangParam.split("=")[1].trim();
        }
        Iterator<Cue> it = loadJson3Track.iterator();
        while (it.hasNext()) {
            Cue next = it.next();
            next.setLangCode(str3);
            if (z) {
                next.setIsTrans(true);
            }
        }
        return loadJson3Track;
    }

    public boolean needToReload(YoutubeTextTrack youtubeTextTrack) {
        return !this.mBaseUrl.equals(youtubeTextTrack.mBaseUrl);
    }

    public String getLocale() {
        return this.mLocale;
    }

    private TextTrack loadJson3Track(String str) throws Exception {
        InputStream inputStream = null;
        try {
            try {
                inputStream = connectTrackUrl(str);
                TextTrack parseTextTrack = new YoutubeTextTrackJson3Parser().parseTextTrack(inputStream);
                if (this.mNeedSplitSentence) {
                    return splitSentenceJson3(parseTextTrack);
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                return parseTextTrack;
            } catch (Exception e) {
                throw e;
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    private TextTrack loadBaseTrack(String str) throws Exception {
        InputStream inputStream = null;
        try {
            try {
                inputStream = connectTrackUrl(str);
                return new YoutubeTextTrackBaseParser().parseTextTrack(inputStream);
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    private TextTrack splitSentenceJson3(TextTrack textTrack) throws Exception {
        Iterator<Cue> it = textTrack.iterator();
        String str = this.mTlangParam;
        YoutubeJson3SentenceSplitter youtubeJson3SentenceSplitter = new YoutubeJson3SentenceSplitter(textTrack, str != null && str.length() > 0);
        youtubeJson3SentenceSplitter.initSplitter();
        TextTrack textTrack2 = new TextTrack();
        while (it.hasNext()) {
            for (Cue cue : youtubeJson3SentenceSplitter.addMoreCueForSplit(it.next())) {
                if (cue != null) {
                    SixLog.dlog(TAG, "NewCue" + cue.toString());
                    textTrack2.addCue(cue);
                }
            }
        }
        for (Cue cue2 : youtubeJson3SentenceSplitter.addMoreCueForSplit(null)) {
            SixLog.dlog(TAG, "NewCue " + cue2.toString());
            textTrack2.addCue(cue2);
        }
        return textTrack2;
    }

    private InputStream connectTrackUrl(String str) throws Exception {
        try {
            SixLog.dlog(TAG, "connectTrackUrl : " + str);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            return httpURLConnection.getInputStream();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
