package com.google.firebase.remoteconfig.internal;

/* loaded from: classes.dex */
public class DefaultsXmlParser {
    private static final String XML_TAG_ENTRY = "entry";
    private static final String XML_TAG_KEY = "key";
    private static final String XML_TAG_VALUE = "value";

    /* JADX WARN: Removed duplicated region for block: B:36:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007d A[Catch: IOException -> 0x0013, XmlPullParserException -> 0x0016, TryCatch #2 {IOException -> 0x0013, XmlPullParserException -> 0x0016, blocks: (B:3:0x0007, B:5:0x000d, B:8:0x0019, B:13:0x002b, B:15:0x0081, B:18:0x0033, B:22:0x0043, B:29:0x004f, B:39:0x0078, B:41:0x007d, B:43:0x005e, B:46:0x0068), top: B:2:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Map<java.lang.String, java.lang.String> getDefaultsFromXml(android.content.Context r8, int r9) {
        /*
            java.lang.String r0 = "FirebaseRemoteConfig"
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            android.content.res.Resources r8 = r8.getResources()     // Catch: java.io.IOException -> L13 org.xmlpull.v1.XmlPullParserException -> L16
            if (r8 != 0) goto L19
            java.lang.String r8 = "Could not find the resources of the current context while trying to set defaults from an XML."
            android.util.Log.e(r0, r8)     // Catch: java.io.IOException -> L13 org.xmlpull.v1.XmlPullParserException -> L16
            return r1
        L13:
            r8 = move-exception
            goto L87
        L16:
            r8 = move-exception
            goto L87
        L19:
            android.content.res.XmlResourceParser r8 = r8.getXml(r9)     // Catch: java.io.IOException -> L13 org.xmlpull.v1.XmlPullParserException -> L16
            int r9 = r8.getEventType()     // Catch: java.io.IOException -> L13 org.xmlpull.v1.XmlPullParserException -> L16
            r2 = 0
            r3 = r2
            r4 = r3
            r5 = r4
        L25:
            r6 = 1
            if (r9 == r6) goto L86
            r7 = 2
            if (r9 != r7) goto L30
            java.lang.String r3 = r8.getName()     // Catch: java.io.IOException -> L13 org.xmlpull.v1.XmlPullParserException -> L16
            goto L81
        L30:
            r7 = 3
            if (r9 != r7) goto L4a
            java.lang.String r9 = r8.getName()     // Catch: java.io.IOException -> L13 org.xmlpull.v1.XmlPullParserException -> L16
            java.lang.String r3 = "entry"
            boolean r9 = r9.equals(r3)     // Catch: java.io.IOException -> L13 org.xmlpull.v1.XmlPullParserException -> L16
            if (r9 == 0) goto L48
            if (r4 == 0) goto L46
            if (r5 == 0) goto L46
            r1.put(r4, r5)     // Catch: java.io.IOException -> L13 org.xmlpull.v1.XmlPullParserException -> L16
        L46:
            r4 = r2
            r5 = r4
        L48:
            r3 = r2
            goto L81
        L4a:
            r7 = 4
            if (r9 != r7) goto L81
            if (r3 == 0) goto L81
            int r9 = r3.hashCode()     // Catch: java.io.IOException -> L13 org.xmlpull.v1.XmlPullParserException -> L16
            r7 = 106079(0x19e5f, float:1.48648E-40)
            if (r9 == r7) goto L68
            r7 = 111972721(0x6ac9171, float:6.4912916E-35)
            if (r9 == r7) goto L5e
            goto L72
        L5e:
            java.lang.String r9 = "value"
            boolean r9 = r3.equals(r9)     // Catch: java.io.IOException -> L13 org.xmlpull.v1.XmlPullParserException -> L16
            if (r9 == 0) goto L72
            r9 = r6
            goto L73
        L68:
            java.lang.String r9 = "key"
            boolean r9 = r3.equals(r9)     // Catch: java.io.IOException -> L13 org.xmlpull.v1.XmlPullParserException -> L16
            if (r9 == 0) goto L72
            r9 = 0
            goto L73
        L72:
            r9 = -1
        L73:
            if (r9 == 0) goto L7d
            if (r9 == r6) goto L78
            goto L81
        L78:
            java.lang.String r5 = r8.getText()     // Catch: java.io.IOException -> L13 org.xmlpull.v1.XmlPullParserException -> L16
            goto L81
        L7d:
            java.lang.String r4 = r8.getText()     // Catch: java.io.IOException -> L13 org.xmlpull.v1.XmlPullParserException -> L16
        L81:
            int r9 = r8.next()     // Catch: java.io.IOException -> L13 org.xmlpull.v1.XmlPullParserException -> L16
            goto L25
        L86:
            return r1
        L87:
            java.lang.String r9 = "Encountered an error while parsing the defaults XML file."
            android.util.Log.e(r0, r9, r8)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.DefaultsXmlParser.getDefaultsFromXml(android.content.Context, int):java.util.Map");
    }
}
