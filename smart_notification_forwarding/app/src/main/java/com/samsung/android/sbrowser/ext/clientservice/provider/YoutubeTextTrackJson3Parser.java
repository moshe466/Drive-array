package com.samsung.android.sbrowser.ext.clientservice.provider;

import android.util.JsonReader;
import android.util.Log;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.android.sbrowser.ext.clientservice.texttrack.Cue;
import com.samsung.android.sbrowser.ext.clientservice.texttrack.CueSeg;
import com.samsung.android.sbrowser.ext.clientservice.texttrack.TextTrack;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class YoutubeTextTrackJson3Parser {
    private static final double SEC_TO_MS = 1000.0d;
    private static final String TAG = "YtTextTrackJson3Parser";

    public TextTrack parseTextTrack(InputStream inputStream) throws Exception {
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        try {
            jsonReader.beginObject();
            TextTrack textTrack = null;
            while (jsonReader.hasNext()) {
                if (!jsonReader.nextName().equals("events")) {
                    jsonReader.skipValue();
                } else {
                    if (textTrack != null) {
                        Log.e(TAG, "only one events must exist");
                        throw new RuntimeException("only one events must exist");
                    }
                    textTrack = readCueArray(jsonReader);
                }
            }
            jsonReader.endObject();
            return textTrack;
        } finally {
            jsonReader.close();
        }
    }

    private TextTrack readCueArray(JsonReader jsonReader) throws Exception {
        TextTrack textTrack = new TextTrack();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            Cue readCue = readCue(jsonReader);
            if (readCue != null) {
                textTrack.addCue(readCue);
            }
        }
        jsonReader.endArray();
        return textTrack;
    }

    private Cue readCue(JsonReader jsonReader) throws Exception {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginObject();
        double d = Cue.INVALID_SEC;
        List<CueSeg> list = arrayList;
        double d2 = 0.0d;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("tStartMs")) {
                d = jsonReader.nextInt();
            } else if (nextName.equals("dDurationMs")) {
                d2 = jsonReader.nextInt();
            } else if (nextName.equals("segs")) {
                list = readCueSegArray(jsonReader);
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        CueSeg cueSeg = null;
        if (list == null || list.isEmpty()) {
            return null;
        }
        double d3 = d / SEC_TO_MS;
        double d4 = d2 / SEC_TO_MS;
        Cue cue = new Cue(d3, d3 + d4, list);
        Iterator<CueSeg> it = cue.iterator();
        while (true) {
            CueSeg cueSeg2 = cueSeg;
            if (it.hasNext()) {
                cueSeg = it.next();
                if (cueSeg2 != null) {
                    cueSeg2.setDuration(cueSeg.getOffsetSec() - cueSeg2.getOffsetSec());
                }
            } else {
                cueSeg.setDuration(d4 - cueSeg.getOffsetSec());
                return cue;
            }
        }
    }

    private List<CueSeg> readCueSegArray(JsonReader jsonReader) throws Exception {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(readCueSeg(jsonReader));
        }
        jsonReader.endArray();
        return arrayList;
    }

    private CueSeg readCueSeg(JsonReader jsonReader) throws Exception {
        jsonReader.beginObject();
        String str = JsonProperty.USE_DEFAULT_NAME;
        double d = Cue.INVALID_SEC;
        while (true) {
            String str2 = str;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (nextName.equals("utf8")) {
                    break;
                }
                if (nextName.equals("tOffsetMs")) {
                    d = jsonReader.nextInt();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            return new CueSeg(d / SEC_TO_MS, -1.0d, str2);
            str = jsonReader.nextString();
        }
    }
}
