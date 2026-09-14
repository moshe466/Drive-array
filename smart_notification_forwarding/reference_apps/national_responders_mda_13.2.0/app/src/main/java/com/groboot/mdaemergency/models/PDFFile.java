package com.groboot.mdaemergency.models;

import android.os.Environment;
import java.io.File;
import java.util.Hashtable;
import java.util.UUID;

/* loaded from: classes.dex */
public class PDFFile {
    public static Hashtable<String, UUID> files = new Hashtable<>();
    private String localPath;
    public String name;
    public int openType;
    public int page = 1;
    public String url;

    public static String getFolderPath() {
        return Environment.getExternalStorageDirectory() + "/md0/sys";
    }

    public boolean exist() {
        return new File(getLocalPath()).exists();
    }

    public String getLocalPath() {
        if (!files.contains(this.url)) {
            files.put(this.url, UUID.randomUUID());
        }
        if (this.localPath == null) {
            this.localPath = getFolderPath() + "/" + files.get(this.url);
        }
        return this.localPath;
    }
}
