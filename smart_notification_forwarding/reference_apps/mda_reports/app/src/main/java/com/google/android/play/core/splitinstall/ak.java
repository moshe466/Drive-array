package com.google.android.play.core.splitinstall;

import android.util.Log;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
final class ak {
    private final XmlPullParser a;
    private final h b = new h();

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(XmlPullParser xmlPullParser) {
        this.a = xmlPullParser;
    }

    private final String a(String str) {
        for (int i = 0; i < this.a.getAttributeCount(); i++) {
            if (this.a.getAttributeName(i).equals(str)) {
                return this.a.getAttributeValue(i);
            }
        }
        return null;
    }

    private final void b() {
        int i = 1;
        while (i != 0) {
            int next = this.a.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final f a() {
        String a;
        while (this.a.next() != 1) {
            try {
                if (this.a.getEventType() == 2) {
                    if (this.a.getName().equals("splits")) {
                        while (this.a.next() != 3) {
                            if (this.a.getEventType() == 2) {
                                if (!this.a.getName().equals("module") || (a = a(AppMeasurementSdk.ConditionalUserProperty.NAME)) == null) {
                                    b();
                                } else {
                                    while (this.a.next() != 3) {
                                        if (this.a.getEventType() == 2) {
                                            if (this.a.getName().equals("language")) {
                                                while (this.a.next() != 3) {
                                                    if (this.a.getEventType() == 2) {
                                                        if (this.a.getName().equals("entry")) {
                                                            String a2 = a("key");
                                                            String a3 = a("split");
                                                            b();
                                                            if (a2 != null && a3 != null) {
                                                                this.b.a(a, a2, a3);
                                                            }
                                                        } else {
                                                            b();
                                                        }
                                                    }
                                                }
                                            } else {
                                                b();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        b();
                    }
                }
            } catch (IOException | IllegalStateException | XmlPullParserException e) {
                Log.e("SplitInstall", "Error while parsing splits.xml", e);
                return null;
            }
        }
        return this.b.a();
    }
}
