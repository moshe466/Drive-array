package com.samsung.android.sbrowser.ext.clientservice.provider;

import android.text.Html;
import android.util.Log;
import android.util.Xml;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.android.sbrowser.ext.clientservice.texttrack.Cue;
import com.samsung.android.sbrowser.ext.clientservice.texttrack.TextTrack;
import java.io.InputStream;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
class YoutubeTextTrackBaseParser {
    private static final String TAG = "YtTextTrackBaseParser";
    private static final String ns = null;

    public TextTrack parseTextTrack(InputStream inputStream) throws Exception {
        Log.i(TAG, "YoutubeTextTrackBaseParser parse ");
        try {
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
            newPullParser.setInput(inputStream, null);
            newPullParser.nextTag();
            return readTranscript(newPullParser);
        } finally {
            inputStream.close();
        }
    }

    private TextTrack readTranscript(XmlPullParser xmlPullParser) throws Exception {
        ArrayList arrayList = new ArrayList();
        xmlPullParser.require(2, ns, "transcript");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("text")) {
                    arrayList.add(readCue(xmlPullParser));
                } else {
                    Log.e(TAG, "no such tag name " + name);
                }
            }
        }
        return new TextTrack(arrayList);
    }

    private Cue readCue(XmlPullParser xmlPullParser) throws Exception {
        String str = ns;
        xmlPullParser.require(2, str, "text");
        String attributeValue = xmlPullParser.getAttributeValue(null, "start");
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "dur");
        double parseDouble = Double.parseDouble(attributeValue);
        Cue cue = new Cue(parseDouble, parseDouble + Double.parseDouble(attributeValue2), readText(xmlPullParser));
        xmlPullParser.require(3, str, "text");
        return cue;
    }

    private String readText(XmlPullParser xmlPullParser) throws Exception {
        String str;
        if (xmlPullParser.next() == 4) {
            str = xmlPullParser.getText();
            xmlPullParser.nextTag();
        } else {
            str = JsonProperty.USE_DEFAULT_NAME;
        }
        return Html.fromHtml(str).toString();
    }
}
