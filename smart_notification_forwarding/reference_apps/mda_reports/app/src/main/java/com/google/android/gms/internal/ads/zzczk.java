package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class zzczk {
    public final int height;
    public final int width;
    public final boolean zzglh;

    public zzczk(int i, int i2, boolean z) {
        this.width = i;
        this.height = i2;
        this.zzglh = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<zzczk> a(JsonReader jsonReader) {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            jsonReader.beginObject();
            int i = 0;
            int i2 = 0;
            boolean z = false;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (SettingsJsonConstants.ICON_WIDTH_KEY.equals(nextName)) {
                    i = jsonReader.nextInt();
                } else if (SettingsJsonConstants.ICON_HEIGHT_KEY.equals(nextName)) {
                    i2 = jsonReader.nextInt();
                } else if ("is_fluid_height".equals(nextName)) {
                    z = jsonReader.nextBoolean();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            arrayList.add(new zzczk(i, i2, z));
        }
        jsonReader.endArray();
        return arrayList;
    }
}
