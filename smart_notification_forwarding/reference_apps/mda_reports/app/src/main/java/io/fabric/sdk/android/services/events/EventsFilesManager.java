package io.fabric.sdk.android.services.events;

import android.content.Context;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.CurrentTimeProvider;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public abstract class EventsFilesManager<T> {
    public static final int MAX_BYTE_SIZE_PER_FILE = 8000;
    public static final int MAX_FILES_IN_BATCH = 1;
    public static final int MAX_FILES_TO_KEEP = 100;
    public static final String ROLL_OVER_FILE_NAME_SEPARATOR = "_";
    protected final Context a;
    protected final EventTransform<T> b;
    protected final CurrentTimeProvider c;
    protected final EventsStorage d;
    private final int defaultMaxFilesToKeep;
    protected volatile long e;
    protected final List<EventsStorageListener> f = new CopyOnWriteArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class FileWithTimestamp {
        final File a;
        final long b;

        public FileWithTimestamp(File file, long j) {
            this.a = file;
            this.b = j;
        }
    }

    public EventsFilesManager(Context context, EventTransform<T> eventTransform, CurrentTimeProvider currentTimeProvider, EventsStorage eventsStorage, int i) {
        this.a = context.getApplicationContext();
        this.b = eventTransform;
        this.d = eventsStorage;
        this.c = currentTimeProvider;
        this.e = this.c.getCurrentTimeMillis();
        this.defaultMaxFilesToKeep = i;
    }

    private void rollFileOverIfNeeded(int i) {
        if (this.d.canWorkingFileStore(i, b())) {
            return;
        }
        CommonUtils.logControlled(this.a, 4, Fabric.TAG, String.format(Locale.US, "session analytics events file is %d bytes, new event is %d bytes, this is over flush limit of %d, rolling it over", Integer.valueOf(this.d.getWorkingFileUsedSizeInBytes()), Integer.valueOf(i), Integer.valueOf(b())));
        rollFileOver();
    }

    private void triggerRollOverOnListeners(String str) {
        Iterator<EventsStorageListener> it = this.f.iterator();
        while (it.hasNext()) {
            try {
                it.next().onRollOver(str);
            } catch (Exception e) {
                CommonUtils.logControlledError(this.a, "One of the roll over listeners threw an exception", e);
            }
        }
    }

    protected abstract String a();

    /* JADX INFO: Access modifiers changed from: protected */
    public int b() {
        return 8000;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int c() {
        return this.defaultMaxFilesToKeep;
    }

    public void deleteAllEventsFiles() {
        EventsStorage eventsStorage = this.d;
        eventsStorage.deleteFilesInRollOverDirectory(eventsStorage.getAllFilesInRollOverDirectory());
        this.d.deleteWorkingFile();
    }

    public void deleteOldestInRollOverIfOverMax() {
        List<File> allFilesInRollOverDirectory = this.d.getAllFilesInRollOverDirectory();
        int c = c();
        if (allFilesInRollOverDirectory.size() <= c) {
            return;
        }
        int size = allFilesInRollOverDirectory.size() - c;
        CommonUtils.logControlled(this.a, String.format(Locale.US, "Found %d files in  roll over directory, this is greater than %d, deleting %d oldest files", Integer.valueOf(allFilesInRollOverDirectory.size()), Integer.valueOf(c), Integer.valueOf(size)));
        TreeSet treeSet = new TreeSet(new Comparator<FileWithTimestamp>(this) { // from class: io.fabric.sdk.android.services.events.EventsFilesManager.1
            @Override // java.util.Comparator
            public int compare(FileWithTimestamp fileWithTimestamp, FileWithTimestamp fileWithTimestamp2) {
                return (int) (fileWithTimestamp.b - fileWithTimestamp2.b);
            }
        });
        for (File file : allFilesInRollOverDirectory) {
            treeSet.add(new FileWithTimestamp(file, parseCreationTimestampFromFileName(file.getName())));
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            arrayList.add(((FileWithTimestamp) it.next()).a);
            if (arrayList.size() == size) {
                break;
            }
        }
        this.d.deleteFilesInRollOverDirectory(arrayList);
    }

    public void deleteSentFiles(List<File> list) {
        this.d.deleteFilesInRollOverDirectory(list);
    }

    public List<File> getBatchOfFilesToSend() {
        return this.d.getBatchOfFilesToSend(1);
    }

    public long getLastRollOverTime() {
        return this.e;
    }

    public long parseCreationTimestampFromFileName(String str) {
        String[] split = str.split(ROLL_OVER_FILE_NAME_SEPARATOR);
        if (split.length != 3) {
            return 0L;
        }
        try {
            return Long.valueOf(split[2]).longValue();
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    public void registerRollOverListener(EventsStorageListener eventsStorageListener) {
        if (eventsStorageListener != null) {
            this.f.add(eventsStorageListener);
        }
    }

    public boolean rollFileOver() {
        String str;
        boolean z = true;
        if (this.d.isWorkingFileEmpty()) {
            str = null;
            z = false;
        } else {
            str = a();
            this.d.rollOver(str);
            CommonUtils.logControlled(this.a, 4, Fabric.TAG, String.format(Locale.US, "generated new file %s", str));
            this.e = this.c.getCurrentTimeMillis();
        }
        triggerRollOverOnListeners(str);
        return z;
    }

    public void writeEvent(T t) {
        byte[] bytes = this.b.toBytes(t);
        rollFileOverIfNeeded(bytes.length);
        this.d.add(bytes);
    }
}
