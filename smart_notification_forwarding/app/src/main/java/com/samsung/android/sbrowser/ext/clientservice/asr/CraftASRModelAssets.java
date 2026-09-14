package com.samsung.android.sbrowser.ext.clientservice.asr;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class CraftASRModelAssets {
    public static final String ASSET_LIST_NAME = "assets.lst";
    public static final String HASH_EXT = ".md5";
    public static final String SYNC_DIR = "sync";
    protected static final String TAG = "CraftASRModelAssets";
    private final AssetManager assetManager;
    private final File externalDir;

    public CraftASRModelAssets(Context context, String str) {
        this.externalDir = new File(str);
        this.assetManager = context.getAssets();
    }

    public File getExternalDir() {
        return this.externalDir;
    }

    public Map<String, String> getItems() throws IOException {
        HashMap hashMap = new HashMap();
        for (String str : readLines(openAsset(ASSET_LIST_NAME))) {
            hashMap.put(str, new BufferedReader(new InputStreamReader(openAsset(str + HASH_EXT))).readLine());
        }
        return hashMap;
    }

    public Map<String, String> getExternalItems() {
        try {
            HashMap hashMap = new HashMap();
            Iterator<String> it = readLines(new FileInputStream(new File(this.externalDir, ASSET_LIST_NAME))).iterator();
            while (it.hasNext()) {
                String[] split = it.next().split(" ");
                hashMap.put(split[0], split[1]);
            }
            return hashMap;
        } catch (IOException unused) {
            return Collections.emptyMap();
        }
    }

    public Collection<String> getItemsToCopy(String str) throws IOException {
        ArrayList arrayList = new ArrayList();
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.offer(str);
        while (!arrayDeque.isEmpty()) {
            String str2 = (String) arrayDeque.poll();
            String[] list = this.assetManager.list(str2);
            for (String str3 : list) {
                arrayDeque.offer(str3);
            }
            if (list.length == 0) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    private List<String> readLines(InputStream inputStream) throws IOException {
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return arrayList;
            }
            arrayList.add(readLine);
        }
    }

    private InputStream openAsset(String str) throws IOException {
        return this.assetManager.open(new File(SYNC_DIR, str).getPath());
    }

    public void updateItemList(Map<String, String> map) throws IOException {
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File(this.externalDir, ASSET_LIST_NAME)));
        for (Map.Entry<String, String> entry : map.entrySet()) {
            printWriter.format("%s %s\n", entry.getKey(), entry.getValue());
        }
        printWriter.close();
    }

    public File copy(String str) throws IOException {
        InputStream openAsset = openAsset(str);
        File file = new File(this.externalDir, str);
        file.getParentFile().mkdirs();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = openAsset.read(bArr);
            if (read == -1) {
                break;
            }
            if (read == 0) {
                int read2 = openAsset.read();
                if (read2 < 0) {
                    break;
                }
                fileOutputStream.write(read2);
            } else {
                fileOutputStream.write(bArr, 0, read);
            }
        }
        fileOutputStream.close();
        return file;
    }

    public File syncAssets() throws IOException {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Map<String, String> items = getItems();
        Map<String, String> externalItems = getExternalItems();
        for (String str : items.keySet()) {
            if (!items.get(str).equals(externalItems.get(str)) || !new File(this.externalDir, str).exists()) {
                arrayList.add(str);
            }
        }
        arrayList2.addAll(externalItems.keySet());
        arrayList2.removeAll(items.keySet());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            copy((String) it.next());
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            new File(this.externalDir, (String) it2.next()).delete();
        }
        updateItemList(items);
        return this.externalDir;
    }
}
