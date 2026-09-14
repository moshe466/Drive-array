package com.crashlytics.android.core;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.EventLogger;
import com.crashlytics.android.core.CrashPromptDialog;
import com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler;
import com.crashlytics.android.core.LogFileManager;
import com.crashlytics.android.core.ReportUploader;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.Crash;
import io.fabric.sdk.android.services.common.DataCollectionArbiter;
import io.fabric.sdk.android.services.common.DeliveryMechanism;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.persistence.FileStore;
import io.fabric.sdk.android.services.settings.AppSettingsData;
import io.fabric.sdk.android.services.settings.FeaturesSettingsData;
import io.fabric.sdk.android.services.settings.PromptSettingsData;
import io.fabric.sdk.android.services.settings.SessionSettingsData;
import io.fabric.sdk.android.services.settings.Settings;
import io.fabric.sdk.android.services.settings.SettingsData;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Thread;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CrashlyticsController {
    private static final int ANALYZER_VERSION = 1;
    private static final String COLLECT_CUSTOM_KEYS = "com.crashlytics.CollectCustomKeys";
    private static final String CRASHLYTICS_API_ENDPOINT = "com.crashlytics.ApiEndpoint";
    private static final String EVENT_TYPE_CRASH = "crash";
    private static final String EVENT_TYPE_LOGGED = "error";
    private static final String GENERATOR_FORMAT = "Crashlytics Android SDK/%s";
    private static final int MAX_LOCAL_LOGGED_EXCEPTIONS = 64;
    private static final int SESSION_ID_LENGTH = 35;
    private static final boolean SHOULD_PROMPT_BEFORE_SENDING_REPORTS_DEFAULT = false;
    private final AppData appData;
    private final AppMeasurementEventListenerRegistrar appMeasurementEventListenerRegistrar;
    private final CrashlyticsBackgroundWorker backgroundWorker;
    private CrashlyticsUncaughtExceptionHandler crashHandler;
    private final CrashlyticsCore crashlyticsCore;
    private final DevicePowerStateListener devicePowerStateListener;
    private final AtomicInteger eventCounter = new AtomicInteger(0);
    private final FileStore fileStore;
    private final EventLogger firebaseAnalyticsLogger;
    private final ReportUploader.HandlingExceptionCheck handlingExceptionCheck;
    private final HttpRequestFactory httpRequestFactory;
    private final IdManager idManager;
    private final LogFileDirectoryProvider logFileDirectoryProvider;
    private final LogFileManager logFileManager;
    private final PreferenceManager preferenceManager;
    private final ReportUploader.ReportFilesProvider reportFilesProvider;
    private final StackTraceTrimmingStrategy stackTraceTrimmingStrategy;
    private final String unityVersion;
    static final FilenameFilter a = new FileNameContainsFilter("BeginSession") { // from class: com.crashlytics.android.core.CrashlyticsController.1
        @Override // com.crashlytics.android.core.CrashlyticsController.FileNameContainsFilter, java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return super.accept(file, str) && str.endsWith(ClsFileOutputStream.SESSION_FILE_EXTENSION);
        }
    };
    static final FilenameFilter b = new FilenameFilter() { // from class: com.crashlytics.android.core.CrashlyticsController.2
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.length() == 39 && str.endsWith(ClsFileOutputStream.SESSION_FILE_EXTENSION);
        }
    };
    static final FileFilter c = new FileFilter() { // from class: com.crashlytics.android.core.CrashlyticsController.3
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return file.isDirectory() && file.getName().length() == 35;
        }
    };
    static final Comparator<File> d = new Comparator<File>() { // from class: com.crashlytics.android.core.CrashlyticsController.4
        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            return file2.getName().compareTo(file.getName());
        }
    };
    static final Comparator<File> e = new Comparator<File>() { // from class: com.crashlytics.android.core.CrashlyticsController.5
        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            return file.getName().compareTo(file2.getName());
        }
    };
    private static final Pattern SESSION_FILE_PATTERN = Pattern.compile("([\\d|A-Z|a-z]{12}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{12}).+");
    private static final Map<String, String> SEND_AT_CRASHTIME_HEADER = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", "1");
    private static final String[] INITIAL_SESSION_PART_TAGS = {"SessionUser", "SessionApp", "SessionOS", "SessionDevice"};

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class AnySessionPartFileFilter implements FilenameFilter {
        private AnySessionPartFileFilter() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return !CrashlyticsController.b.accept(file, str) && CrashlyticsController.SESSION_FILE_PATTERN.matcher(str).matches();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface CodedOutputStreamWriteAction {
        void writeTo(CodedOutputStream codedOutputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class DefaultSettingsDataProvider implements CrashlyticsUncaughtExceptionHandler.SettingsDataProvider {
        private DefaultSettingsDataProvider() {
        }

        @Override // com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.SettingsDataProvider
        public SettingsData getSettingsData() {
            return Settings.getInstance().awaitSettingsData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class FileNameContainsFilter implements FilenameFilter {
        private final String string;

        public FileNameContainsFilter(String str) {
            this.string = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.contains(this.string) && !str.endsWith(ClsFileOutputStream.IN_PROGRESS_SESSION_FILE_EXTENSION);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface FileOutputStreamWriteAction {
        void writeTo(FileOutputStream fileOutputStream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class InvalidPartFileFilter implements FilenameFilter {
        InvalidPartFileFilter() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return ClsFileOutputStream.TEMP_FILENAME_FILTER.accept(file, str) || str.contains("SessionMissingBinaryImages");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class LogFileDirectoryProvider implements LogFileManager.DirectoryProvider {
        private static final String LOG_FILES_DIR = "log-files";
        private final FileStore rootFileStore;

        public LogFileDirectoryProvider(FileStore fileStore) {
            this.rootFileStore = fileStore;
        }

        @Override // com.crashlytics.android.core.LogFileManager.DirectoryProvider
        public File getLogFileDir() {
            File file = new File(this.rootFileStore.getFilesDir(), LOG_FILES_DIR);
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class PrivacyDialogCheck implements ReportUploader.SendCheck {
        private final Kit kit;
        private final PreferenceManager preferenceManager;
        private final PromptSettingsData promptData;

        public PrivacyDialogCheck(Kit kit, PreferenceManager preferenceManager, PromptSettingsData promptSettingsData) {
            this.kit = kit;
            this.preferenceManager = preferenceManager;
            this.promptData = promptSettingsData;
        }

        @Override // com.crashlytics.android.core.ReportUploader.SendCheck
        public boolean canSendReports() {
            Activity currentActivity = this.kit.getFabric().getCurrentActivity();
            if (currentActivity == null || currentActivity.isFinishing()) {
                return true;
            }
            final CrashPromptDialog create = CrashPromptDialog.create(currentActivity, this.promptData, new CrashPromptDialog.AlwaysSendCallback() { // from class: com.crashlytics.android.core.CrashlyticsController.PrivacyDialogCheck.1
                @Override // com.crashlytics.android.core.CrashPromptDialog.AlwaysSendCallback
                public void sendUserReportsWithoutPrompting(boolean z) {
                    PrivacyDialogCheck.this.preferenceManager.a(z);
                }
            });
            currentActivity.runOnUiThread(new Runnable(this) { // from class: com.crashlytics.android.core.CrashlyticsController.PrivacyDialogCheck.2
                @Override // java.lang.Runnable
                public void run() {
                    create.show();
                }
            });
            Fabric.getLogger().d(CrashlyticsCore.TAG, "Waiting for user opt-in.");
            create.await();
            return create.getOptIn();
        }
    }

    /* loaded from: classes.dex */
    private final class ReportUploaderFilesProvider implements ReportUploader.ReportFilesProvider {
        private ReportUploaderFilesProvider() {
        }

        @Override // com.crashlytics.android.core.ReportUploader.ReportFilesProvider
        public File[] getCompleteSessionFiles() {
            return CrashlyticsController.this.g();
        }

        @Override // com.crashlytics.android.core.ReportUploader.ReportFilesProvider
        public File[] getInvalidSessionFiles() {
            return CrashlyticsController.this.d().listFiles();
        }

        @Override // com.crashlytics.android.core.ReportUploader.ReportFilesProvider
        public File[] getNativeReportFiles() {
            return CrashlyticsController.this.h();
        }
    }

    /* loaded from: classes.dex */
    private final class ReportUploaderHandlingExceptionCheck implements ReportUploader.HandlingExceptionCheck {
        private ReportUploaderHandlingExceptionCheck() {
        }

        @Override // com.crashlytics.android.core.ReportUploader.HandlingExceptionCheck
        public boolean isHandlingException() {
            return CrashlyticsController.this.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class SendReportRunnable implements Runnable {
        private final Context context;
        private final Report report;
        private final ReportUploader reportUploader;

        public SendReportRunnable(Context context, Report report, ReportUploader reportUploader) {
            this.context = context;
            this.report = report;
            this.reportUploader = reportUploader;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CommonUtils.canTryConnection(this.context)) {
                Fabric.getLogger().d(CrashlyticsCore.TAG, "Attempting to send crash report at time of crash...");
                this.reportUploader.a(this.report);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SessionPartFileFilter implements FilenameFilter {
        private final String sessionId;

        public SessionPartFileFilter(String str) {
            this.sessionId = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.sessionId);
            sb.append(ClsFileOutputStream.SESSION_FILE_EXTENSION);
            return (str.equals(sb.toString()) || !str.contains(this.sessionId) || str.endsWith(ClsFileOutputStream.IN_PROGRESS_SESSION_FILE_EXTENSION)) ? false : true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CrashlyticsController(CrashlyticsCore crashlyticsCore, CrashlyticsBackgroundWorker crashlyticsBackgroundWorker, HttpRequestFactory httpRequestFactory, IdManager idManager, PreferenceManager preferenceManager, FileStore fileStore, AppData appData, UnityVersionProvider unityVersionProvider, AppMeasurementEventListenerRegistrar appMeasurementEventListenerRegistrar, EventLogger eventLogger) {
        this.crashlyticsCore = crashlyticsCore;
        this.backgroundWorker = crashlyticsBackgroundWorker;
        this.httpRequestFactory = httpRequestFactory;
        this.idManager = idManager;
        this.preferenceManager = preferenceManager;
        this.fileStore = fileStore;
        this.appData = appData;
        this.unityVersion = unityVersionProvider.getUnityVersion();
        this.appMeasurementEventListenerRegistrar = appMeasurementEventListenerRegistrar;
        this.firebaseAnalyticsLogger = eventLogger;
        Context context = crashlyticsCore.getContext();
        this.logFileDirectoryProvider = new LogFileDirectoryProvider(fileStore);
        this.logFileManager = new LogFileManager(context, this.logFileDirectoryProvider);
        this.reportFilesProvider = new ReportUploaderFilesProvider();
        this.handlingExceptionCheck = new ReportUploaderHandlingExceptionCheck();
        this.devicePowerStateListener = new DevicePowerStateListener(context);
        this.stackTraceTrimmingStrategy = new MiddleOutFallbackStrategy(1024, new RemoveRepeatsStrategy(10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(File file) {
        return file.getName().substring(0, 35);
    }

    private void closeOpenSessions(File[] fileArr, int i, int i2) {
        Fabric.getLogger().d(CrashlyticsCore.TAG, "Closing open sessions.");
        while (i < fileArr.length) {
            File file = fileArr[i];
            String a2 = a(file);
            Fabric.getLogger().d(CrashlyticsCore.TAG, "Closing session: " + a2);
            writeSessionPartsToSessionFile(file, a2, i2);
            i++;
        }
    }

    private void closeWithoutRenamingOrLog(ClsFileOutputStream clsFileOutputStream) {
        if (clsFileOutputStream == null) {
            return;
        }
        try {
            clsFileOutputStream.closeInProgressStream();
        } catch (IOException e2) {
            Fabric.getLogger().e(CrashlyticsCore.TAG, "Error closing session file stream in the presence of an exception", e2);
        }
    }

    private static void copyToCodedOutputStream(InputStream inputStream, CodedOutputStream codedOutputStream, int i) {
        int read;
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < bArr.length && (read = inputStream.read(bArr, i2, bArr.length - i2)) >= 0) {
            i2 += read;
        }
        codedOutputStream.writeRawBytes(bArr);
    }

    private void deleteSessionPartFilesFor(String str) {
        for (File file : listSessionPartFilesFor(str)) {
            file.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void doCloseSessions(SessionSettingsData sessionSettingsData, boolean z) {
        trimOpenSessions((z ? 1 : 0) + 8);
        File[] listSortedSessionBeginFiles = listSortedSessionBeginFiles();
        if (listSortedSessionBeginFiles.length <= z) {
            Fabric.getLogger().d(CrashlyticsCore.TAG, "No open sessions to be closed.");
            return;
        }
        writeSessionUser(a(listSortedSessionBeginFiles[z ? 1 : 0]));
        if (sessionSettingsData == null) {
            Fabric.getLogger().d(CrashlyticsCore.TAG, "Unable to close session. Settings are not loaded.");
        } else {
            closeOpenSessions(listSortedSessionBeginFiles, z ? 1 : 0, sessionSettingsData.maxCustomExceptionEvents);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doOpenSession() {
        Date date = new Date();
        String clsuuid = new CLSUUID(this.idManager).toString();
        Fabric.getLogger().d(CrashlyticsCore.TAG, "Opening a new session with ID " + clsuuid);
        writeBeginSession(clsuuid, date);
        writeSessionApp(clsuuid);
        writeSessionOS(clsuuid);
        writeSessionDevice(clsuuid);
        this.logFileManager.a(clsuuid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doWriteNonFatal(Date date, Thread thread, Throwable th) {
        ClsFileOutputStream clsFileOutputStream;
        CodedOutputStream newInstance;
        String currentSessionId = getCurrentSessionId();
        CodedOutputStream codedOutputStream = null;
        r1 = null;
        CodedOutputStream codedOutputStream2 = null;
        codedOutputStream = null;
        if (currentSessionId == null) {
            Fabric.getLogger().e(CrashlyticsCore.TAG, "Tried to write a non-fatal exception while no session was open.", null);
            return;
        }
        recordLoggedExceptionAnswersEvent(currentSessionId, th.getClass().getName());
        try {
            try {
                Fabric.getLogger().d(CrashlyticsCore.TAG, "Crashlytics is logging non-fatal exception \"" + th + "\" from thread " + thread.getName());
                clsFileOutputStream = new ClsFileOutputStream(c(), currentSessionId + "SessionEvent" + CommonUtils.padWithZerosToMaxIntWidth(this.eventCounter.getAndIncrement()));
                try {
                    newInstance = CodedOutputStream.newInstance(clsFileOutputStream);
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                CrashlyticsController crashlyticsController = this;
                crashlyticsController.writeSessionEvent(newInstance, date, thread, th, EVENT_TYPE_LOGGED, false);
                CommonUtils.flushOrLog(newInstance, "Failed to flush to non-fatal file.");
                codedOutputStream = crashlyticsController;
            } catch (Exception e3) {
                e = e3;
                codedOutputStream2 = newInstance;
                Fabric.getLogger().e(CrashlyticsCore.TAG, "An error occurred in the non-fatal exception logger", e);
                CommonUtils.flushOrLog(codedOutputStream2, "Failed to flush to non-fatal file.");
                codedOutputStream = codedOutputStream2;
                CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close non-fatal file output stream.");
                trimSessionEventFiles(currentSessionId, 64);
            } catch (Throwable th3) {
                th = th3;
                codedOutputStream = newInstance;
                CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to non-fatal file.");
                CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close non-fatal file output stream.");
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            clsFileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            clsFileOutputStream = null;
        }
        CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close non-fatal file output stream.");
        try {
            trimSessionEventFiles(currentSessionId, 64);
        } catch (Exception e5) {
            Fabric.getLogger().e(CrashlyticsCore.TAG, "An error occurred when trimming non-fatal files.", e5);
        }
    }

    private File[] ensureFileArrayNotNull(File[] fileArr) {
        return fileArr == null ? new File[0] : fileArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finalizeMostRecentNativeCrash(Context context, File file, String str) {
        byte[] b2 = NativeFileUtils.b(file);
        byte[] a2 = NativeFileUtils.a(file);
        byte[] a3 = NativeFileUtils.a(file, context);
        if (b2 == null || b2.length == 0) {
            Fabric.getLogger().w(CrashlyticsCore.TAG, "No minidump data found in directory " + file);
            return;
        }
        recordFatalExceptionAnswersEvent(str, "<native-crash: minidump>");
        byte[] readFile = readFile(str, "BeginSession.json");
        byte[] readFile2 = readFile(str, "SessionApp.json");
        byte[] readFile3 = readFile(str, "SessionDevice.json");
        byte[] readFile4 = readFile(str, "SessionOS.json");
        byte[] c2 = NativeFileUtils.c(new MetaDataStore(c()).getUserDataFileForSession(str));
        LogFileManager logFileManager = new LogFileManager(this.crashlyticsCore.getContext(), this.logFileDirectoryProvider, str);
        byte[] c3 = logFileManager.c();
        logFileManager.a();
        byte[] c4 = NativeFileUtils.c(new MetaDataStore(c()).getKeysFileForSession(str));
        File file2 = new File(this.fileStore.getFilesDir(), str);
        if (!file2.mkdir()) {
            Fabric.getLogger().d(CrashlyticsCore.TAG, "Couldn't create native sessions directory");
            return;
        }
        gzipIfNotEmpty(b2, new File(file2, "minidump"));
        gzipIfNotEmpty(a2, new File(file2, "metadata"));
        gzipIfNotEmpty(a3, new File(file2, "binaryImages"));
        gzipIfNotEmpty(readFile, new File(file2, SettingsJsonConstants.SESSION_KEY));
        gzipIfNotEmpty(readFile2, new File(file2, SettingsJsonConstants.APP_KEY));
        gzipIfNotEmpty(readFile3, new File(file2, "device"));
        gzipIfNotEmpty(readFile4, new File(file2, "os"));
        gzipIfNotEmpty(c2, new File(file2, "user"));
        gzipIfNotEmpty(c3, new File(file2, "logs"));
        gzipIfNotEmpty(c4, new File(file2, "keys"));
    }

    private boolean firebaseCrashExists() {
        try {
            Class.forName("com.google.firebase.crash.FirebaseCrash");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private CreateReportSpiCall getCreateReportSpiCall(String str, String str2) {
        String stringsFileValue = CommonUtils.getStringsFileValue(this.crashlyticsCore.getContext(), CRASHLYTICS_API_ENDPOINT);
        return new CompositeCreateReportSpiCall(new DefaultCreateReportSpiCall(this.crashlyticsCore, stringsFileValue, str, this.httpRequestFactory), new NativeCreateReportSpiCall(this.crashlyticsCore, stringsFileValue, str2, this.httpRequestFactory));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getCurrentSessionId() {
        File[] listSortedSessionBeginFiles = listSortedSessionBeginFiles();
        if (listSortedSessionBeginFiles.length > 0) {
            return a(listSortedSessionBeginFiles[0]);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getPreviousSessionId() {
        File[] listSortedSessionBeginFiles = listSortedSessionBeginFiles();
        if (listSortedSessionBeginFiles.length > 1) {
            return a(listSortedSessionBeginFiles[1]);
        }
        return null;
    }

    private File[] getTrimmedNonFatalFiles(String str, File[] fileArr, int i) {
        if (fileArr.length <= i) {
            return fileArr;
        }
        Fabric.getLogger().d(CrashlyticsCore.TAG, String.format(Locale.US, "Trimming down to %d logged exceptions.", Integer.valueOf(i)));
        trimSessionEventFiles(str, i);
        return listFilesMatching(new FileNameContainsFilter(str + "SessionEvent"));
    }

    private UserMetaData getUserMetaData(String str) {
        return f() ? new UserMetaData(this.crashlyticsCore.l(), this.crashlyticsCore.m(), this.crashlyticsCore.k()) : new MetaDataStore(c()).readUserData(str);
    }

    private void gzip(byte[] bArr, File file) {
        GZIPOutputStream gZIPOutputStream = null;
        try {
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(new FileOutputStream(file));
            try {
                gZIPOutputStream2.write(bArr);
                gZIPOutputStream2.finish();
                CommonUtils.closeQuietly(gZIPOutputStream2);
            } catch (Throwable th) {
                th = th;
                gZIPOutputStream = gZIPOutputStream2;
                CommonUtils.closeQuietly(gZIPOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void gzipIfNotEmpty(byte[] bArr, File file) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        gzip(bArr, file);
    }

    private File[] listFiles(File file) {
        return ensureFileArrayNotNull(file.listFiles());
    }

    private File[] listFilesMatching(File file, FilenameFilter filenameFilter) {
        return ensureFileArrayNotNull(file.listFiles(filenameFilter));
    }

    private File[] listFilesMatching(FileFilter fileFilter) {
        return ensureFileArrayNotNull(c().listFiles(fileFilter));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File[] listFilesMatching(FilenameFilter filenameFilter) {
        return listFilesMatching(c(), filenameFilter);
    }

    private File[] listSessionPartFilesFor(String str) {
        return listFilesMatching(new SessionPartFileFilter(str));
    }

    private File[] listSortedSessionBeginFiles() {
        File[] i = i();
        Arrays.sort(i, d);
        return i;
    }

    private byte[] readFile(String str, String str2) {
        return NativeFileUtils.c(new File(c(), str + str2));
    }

    private static void recordFatalExceptionAnswersEvent(String str, String str2) {
        Answers answers = (Answers) Fabric.getKit(Answers.class);
        if (answers == null) {
            Fabric.getLogger().d(CrashlyticsCore.TAG, "Answers is not available");
        } else {
            answers.onException(new Crash.FatalException(str, str2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recordFatalFirebaseEvent(long j) {
        if (firebaseCrashExists()) {
            Fabric.getLogger().d(CrashlyticsCore.TAG, "Skipping logging Crashlytics event to Firebase, FirebaseCrash exists");
            return;
        }
        if (this.firebaseAnalyticsLogger == null) {
            Fabric.getLogger().d(CrashlyticsCore.TAG, "Skipping logging Crashlytics event to Firebase, no Firebase Analytics");
            return;
        }
        Fabric.getLogger().d(CrashlyticsCore.TAG, "Logging Crashlytics event to Firebase");
        Bundle bundle = new Bundle();
        bundle.putInt("_r", 1);
        bundle.putInt("fatal", 1);
        bundle.putLong("timestamp", j);
        this.firebaseAnalyticsLogger.logEvent("clx", "_ae", bundle);
    }

    private static void recordLoggedExceptionAnswersEvent(String str, String str2) {
        Answers answers = (Answers) Fabric.getKit(Answers.class);
        if (answers == null) {
            Fabric.getLogger().d(CrashlyticsCore.TAG, "Answers is not available");
        } else {
            answers.onException(new Crash.LoggedException(str, str2));
        }
    }

    private void recursiveDelete(File file) {
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                recursiveDelete(file2);
            }
        }
        file.delete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recursiveDelete(Set<File> set) {
        Iterator<File> it = set.iterator();
        while (it.hasNext()) {
            recursiveDelete(it.next());
        }
    }

    private void retainSessions(File[] fileArr, Set<String> set) {
        Logger logger;
        StringBuilder sb;
        String str;
        for (File file : fileArr) {
            String name = file.getName();
            Matcher matcher = SESSION_FILE_PATTERN.matcher(name);
            if (!matcher.matches()) {
                logger = Fabric.getLogger();
                sb = new StringBuilder();
                str = "Deleting unknown file: ";
            } else if (!set.contains(matcher.group(1))) {
                logger = Fabric.getLogger();
                sb = new StringBuilder();
                str = "Trimming session file: ";
            }
            sb.append(str);
            sb.append(name);
            logger.d(CrashlyticsCore.TAG, sb.toString());
            file.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendSessionReports(SettingsData settingsData) {
        if (settingsData == null) {
            Fabric.getLogger().w(CrashlyticsCore.TAG, "Cannot send reports. Settings are unavailable.");
            return;
        }
        Context context = this.crashlyticsCore.getContext();
        AppSettingsData appSettingsData = settingsData.appData;
        ReportUploader reportUploader = new ReportUploader(this.appData.apiKey, getCreateReportSpiCall(appSettingsData.reportsUrl, appSettingsData.ndkReportsUrl), this.reportFilesProvider, this.handlingExceptionCheck);
        for (File file : g()) {
            this.backgroundWorker.a(new SendReportRunnable(context, new SessionReport(file, SEND_AT_CRASHTIME_HEADER), reportUploader));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldPromptUserBeforeSendingCrashReports(SettingsData settingsData) {
        return (settingsData == null || !settingsData.featuresData.promptEnabled || this.preferenceManager.a()) ? false : true;
    }

    private void synthesizeSessionFile(File file, String str, File[] fileArr, File file2) {
        ClsFileOutputStream clsFileOutputStream;
        boolean z = file2 != null;
        File b2 = z ? b() : e();
        if (!b2.exists()) {
            b2.mkdirs();
        }
        CodedOutputStream codedOutputStream = null;
        try {
            clsFileOutputStream = new ClsFileOutputStream(b2, str);
            try {
                try {
                    codedOutputStream = CodedOutputStream.newInstance(clsFileOutputStream);
                    Fabric.getLogger().d(CrashlyticsCore.TAG, "Collecting SessionStart data for session ID " + str);
                    writeToCosFromFile(codedOutputStream, file);
                    codedOutputStream.writeUInt64(4, new Date().getTime() / 1000);
                    codedOutputStream.writeBool(5, z);
                    codedOutputStream.writeUInt32(11, 1);
                    codedOutputStream.writeEnum(12, 3);
                    writeInitialPartsTo(codedOutputStream, str);
                    writeNonFatalEventsTo(codedOutputStream, fileArr, str);
                    if (z) {
                        writeToCosFromFile(codedOutputStream, file2);
                    }
                    CommonUtils.flushOrLog(codedOutputStream, "Error flushing session file stream");
                    CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close CLS file");
                } catch (Exception e2) {
                    e = e2;
                    Fabric.getLogger().e(CrashlyticsCore.TAG, "Failed to write session file for session ID: " + str, e);
                    CommonUtils.flushOrLog(codedOutputStream, "Error flushing session file stream");
                    closeWithoutRenamingOrLog(clsFileOutputStream);
                }
            } catch (Throwable th) {
                th = th;
                CommonUtils.flushOrLog(codedOutputStream, "Error flushing session file stream");
                CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close CLS file");
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            clsFileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            clsFileOutputStream = null;
            CommonUtils.flushOrLog(codedOutputStream, "Error flushing session file stream");
            CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close CLS file");
            throw th;
        }
    }

    private void trimInvalidSessionFiles() {
        File d2 = d();
        if (d2.exists()) {
            File[] listFilesMatching = listFilesMatching(d2, new InvalidPartFileFilter());
            Arrays.sort(listFilesMatching, Collections.reverseOrder());
            HashSet hashSet = new HashSet();
            for (int i = 0; i < listFilesMatching.length && hashSet.size() < 4; i++) {
                hashSet.add(a(listFilesMatching[i]));
            }
            retainSessions(listFiles(d2), hashSet);
        }
    }

    private void trimOpenSessions(int i) {
        HashSet hashSet = new HashSet();
        File[] listSortedSessionBeginFiles = listSortedSessionBeginFiles();
        int min = Math.min(i, listSortedSessionBeginFiles.length);
        for (int i2 = 0; i2 < min; i2++) {
            hashSet.add(a(listSortedSessionBeginFiles[i2]));
        }
        this.logFileManager.a(hashSet);
        retainSessions(listFilesMatching(new AnySessionPartFileFilter()), hashSet);
    }

    private void trimSessionEventFiles(String str, int i) {
        Utils.a(c(), new FileNameContainsFilter(str + "SessionEvent"), i, e);
    }

    private void writeBeginSession(final String str, Date date) {
        final String format = String.format(Locale.US, GENERATOR_FORMAT, this.crashlyticsCore.getVersion());
        final long time = date.getTime() / 1000;
        writeSessionPartFile(str, "BeginSession", new CodedOutputStreamWriteAction(this) { // from class: com.crashlytics.android.core.CrashlyticsController.17
            @Override // com.crashlytics.android.core.CrashlyticsController.CodedOutputStreamWriteAction
            public void writeTo(CodedOutputStream codedOutputStream) {
                SessionProtobufHelper.writeBeginSession(codedOutputStream, str, format, time);
            }
        });
        writeFile(str, "BeginSession.json", new FileOutputStreamWriteAction(this) { // from class: com.crashlytics.android.core.CrashlyticsController.18
            @Override // com.crashlytics.android.core.CrashlyticsController.FileOutputStreamWriteAction
            public void writeTo(FileOutputStream fileOutputStream) {
                fileOutputStream.write(new JSONObject(new HashMap<String, Object>() { // from class: com.crashlytics.android.core.CrashlyticsController.18.1
                    {
                        put("session_id", str);
                        put("generator", format);
                        put("started_at_seconds", Long.valueOf(time));
                    }
                }).toString().getBytes());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeFatal(Date date, Thread thread, Throwable th) {
        ClsFileOutputStream clsFileOutputStream;
        String currentSessionId;
        CodedOutputStream codedOutputStream = null;
        try {
            try {
                currentSessionId = getCurrentSessionId();
            } catch (Throwable th2) {
                th = th2;
                CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to session begin file.");
                CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close fatal exception file output stream.");
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            clsFileOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            clsFileOutputStream = null;
            CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to session begin file.");
            CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close fatal exception file output stream.");
            throw th;
        }
        if (currentSessionId == null) {
            Fabric.getLogger().e(CrashlyticsCore.TAG, "Tried to write a fatal exception while no session was open.", null);
            CommonUtils.flushOrLog(null, "Failed to flush to session begin file.");
            CommonUtils.closeOrLog(null, "Failed to close fatal exception file output stream.");
            return;
        }
        recordFatalExceptionAnswersEvent(currentSessionId, th.getClass().getName());
        clsFileOutputStream = new ClsFileOutputStream(c(), currentSessionId + "SessionCrash");
        try {
            codedOutputStream = CodedOutputStream.newInstance(clsFileOutputStream);
            writeSessionEvent(codedOutputStream, date, thread, th, "crash", true);
        } catch (Exception e3) {
            e = e3;
            Fabric.getLogger().e(CrashlyticsCore.TAG, "An error occurred in the fatal exception logger", e);
            CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to session begin file.");
            CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close fatal exception file output stream.");
        }
        CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to session begin file.");
        CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close fatal exception file output stream.");
    }

    private void writeFile(String str, String str2, FileOutputStreamWriteAction fileOutputStreamWriteAction) {
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(new File(c(), str + str2));
            try {
                fileOutputStreamWriteAction.writeTo(fileOutputStream2);
                CommonUtils.closeOrLog(fileOutputStream2, "Failed to close " + str2 + " file.");
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                CommonUtils.closeOrLog(fileOutputStream, "Failed to close " + str2 + " file.");
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void writeInitialPartsTo(CodedOutputStream codedOutputStream, String str) {
        for (String str2 : INITIAL_SESSION_PART_TAGS) {
            File[] listFilesMatching = listFilesMatching(new FileNameContainsFilter(str + str2 + ClsFileOutputStream.SESSION_FILE_EXTENSION));
            if (listFilesMatching.length == 0) {
                Fabric.getLogger().e(CrashlyticsCore.TAG, "Can't find " + str2 + " data for session ID " + str, null);
            } else {
                Fabric.getLogger().d(CrashlyticsCore.TAG, "Collecting " + str2 + " data for session ID " + str);
                writeToCosFromFile(codedOutputStream, listFilesMatching[0]);
            }
        }
    }

    private static void writeNonFatalEventsTo(CodedOutputStream codedOutputStream, File[] fileArr, String str) {
        Arrays.sort(fileArr, CommonUtils.FILE_MODIFIED_COMPARATOR);
        for (File file : fileArr) {
            try {
                Fabric.getLogger().d(CrashlyticsCore.TAG, String.format(Locale.US, "Found Non Fatal for session ID %s in %s ", str, file.getName()));
                writeToCosFromFile(codedOutputStream, file);
            } catch (Exception e2) {
                Fabric.getLogger().e(CrashlyticsCore.TAG, "Error writting non-fatal to session.", e2);
            }
        }
    }

    private void writeSessionApp(String str) {
        final String appIdentifier = this.idManager.getAppIdentifier();
        AppData appData = this.appData;
        final String str2 = appData.versionCode;
        final String str3 = appData.versionName;
        final String appInstallIdentifier = this.idManager.getAppInstallIdentifier();
        final int id = DeliveryMechanism.determineFrom(this.appData.installerPackageName).getId();
        writeSessionPartFile(str, "SessionApp", new CodedOutputStreamWriteAction() { // from class: com.crashlytics.android.core.CrashlyticsController.19
            @Override // com.crashlytics.android.core.CrashlyticsController.CodedOutputStreamWriteAction
            public void writeTo(CodedOutputStream codedOutputStream) {
                SessionProtobufHelper.writeSessionApp(codedOutputStream, appIdentifier, CrashlyticsController.this.appData.apiKey, str2, str3, appInstallIdentifier, id, CrashlyticsController.this.unityVersion);
            }
        });
        writeFile(str, "SessionApp.json", new FileOutputStreamWriteAction() { // from class: com.crashlytics.android.core.CrashlyticsController.20
            @Override // com.crashlytics.android.core.CrashlyticsController.FileOutputStreamWriteAction
            public void writeTo(FileOutputStream fileOutputStream) {
                fileOutputStream.write(new JSONObject(new HashMap<String, Object>() { // from class: com.crashlytics.android.core.CrashlyticsController.20.1
                    {
                        put("app_identifier", appIdentifier);
                        put("api_key", CrashlyticsController.this.appData.apiKey);
                        put("version_code", str2);
                        put("version_name", str3);
                        put("install_uuid", appInstallIdentifier);
                        put("delivery_mechanism", Integer.valueOf(id));
                        put("unity_version", TextUtils.isEmpty(CrashlyticsController.this.unityVersion) ? "" : CrashlyticsController.this.unityVersion);
                    }
                }).toString().getBytes());
            }
        });
    }

    private void writeSessionDevice(String str) {
        Context context = this.crashlyticsCore.getContext();
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        final int cpuArchitectureInt = CommonUtils.getCpuArchitectureInt();
        final int availableProcessors = Runtime.getRuntime().availableProcessors();
        final long totalRamInBytes = CommonUtils.getTotalRamInBytes();
        final long blockCount = statFs.getBlockCount() * statFs.getBlockSize();
        final boolean isEmulator = CommonUtils.isEmulator(context);
        final Map<IdManager.DeviceIdentifierType, String> deviceIdentifiers = this.idManager.getDeviceIdentifiers();
        final int deviceState = CommonUtils.getDeviceState(context);
        writeSessionPartFile(str, "SessionDevice", new CodedOutputStreamWriteAction(this) { // from class: com.crashlytics.android.core.CrashlyticsController.23
            @Override // com.crashlytics.android.core.CrashlyticsController.CodedOutputStreamWriteAction
            public void writeTo(CodedOutputStream codedOutputStream) {
                SessionProtobufHelper.writeSessionDevice(codedOutputStream, cpuArchitectureInt, Build.MODEL, availableProcessors, totalRamInBytes, blockCount, isEmulator, deviceIdentifiers, deviceState, Build.MANUFACTURER, Build.PRODUCT);
            }
        });
        writeFile(str, "SessionDevice.json", new FileOutputStreamWriteAction(this) { // from class: com.crashlytics.android.core.CrashlyticsController.24
            @Override // com.crashlytics.android.core.CrashlyticsController.FileOutputStreamWriteAction
            public void writeTo(FileOutputStream fileOutputStream) {
                fileOutputStream.write(new JSONObject(new HashMap<String, Object>() { // from class: com.crashlytics.android.core.CrashlyticsController.24.1
                    {
                        put("arch", Integer.valueOf(cpuArchitectureInt));
                        put("build_model", Build.MODEL);
                        put("available_processors", Integer.valueOf(availableProcessors));
                        put("total_ram", Long.valueOf(totalRamInBytes));
                        put("disk_space", Long.valueOf(blockCount));
                        put("is_emulator", Boolean.valueOf(isEmulator));
                        put("ids", deviceIdentifiers);
                        put("state", Integer.valueOf(deviceState));
                        put("build_manufacturer", Build.MANUFACTURER);
                        put("build_product", Build.PRODUCT);
                    }
                }).toString().getBytes());
            }
        });
    }

    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v5 */
    private void writeSessionEvent(CodedOutputStream codedOutputStream, Date date, Thread thread, Throwable th, String str, boolean z) {
        ?? r6;
        Thread[] threadArr;
        Map<String, String> i;
        Map<String, String> treeMap;
        TrimmedThrowableData trimmedThrowableData = new TrimmedThrowableData(th, this.stackTraceTrimmingStrategy);
        Context context = this.crashlyticsCore.getContext();
        long time = date.getTime() / 1000;
        Float batteryLevel = CommonUtils.getBatteryLevel(context);
        int batteryVelocity = CommonUtils.getBatteryVelocity(context, this.devicePowerStateListener.isPowerConnected());
        boolean proximitySensorEnabled = CommonUtils.getProximitySensorEnabled(context);
        int i2 = context.getResources().getConfiguration().orientation;
        long totalRamInBytes = CommonUtils.getTotalRamInBytes() - CommonUtils.calculateFreeRamInBytes(context);
        long calculateUsedDiskSpaceInBytes = CommonUtils.calculateUsedDiskSpaceInBytes(Environment.getDataDirectory().getPath());
        ActivityManager.RunningAppProcessInfo appProcessInfo = CommonUtils.getAppProcessInfo(context.getPackageName(), context);
        LinkedList linkedList = new LinkedList();
        StackTraceElement[] stackTraceElementArr = trimmedThrowableData.stacktrace;
        String str2 = this.appData.buildId;
        String appIdentifier = this.idManager.getAppIdentifier();
        int i3 = 0;
        if (z) {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            Thread[] threadArr2 = new Thread[allStackTraces.size()];
            for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
                threadArr2[i3] = entry.getKey();
                linkedList.add(this.stackTraceTrimmingStrategy.getTrimmedStackTrace(entry.getValue()));
                i3++;
            }
            r6 = 1;
            threadArr = threadArr2;
        } else {
            r6 = 1;
            threadArr = new Thread[0];
        }
        if (CommonUtils.getBooleanResourceValue(context, COLLECT_CUSTOM_KEYS, r6)) {
            i = this.crashlyticsCore.i();
            if (i != null && i.size() > r6) {
                treeMap = new TreeMap(i);
                SessionProtobufHelper.writeSessionEvent(codedOutputStream, time, str, trimmedThrowableData, thread, stackTraceElementArr, threadArr, linkedList, treeMap, this.logFileManager, appProcessInfo, i2, appIdentifier, str2, batteryLevel, batteryVelocity, proximitySensorEnabled, totalRamInBytes, calculateUsedDiskSpaceInBytes);
            }
        } else {
            i = new TreeMap<>();
        }
        treeMap = i;
        SessionProtobufHelper.writeSessionEvent(codedOutputStream, time, str, trimmedThrowableData, thread, stackTraceElementArr, threadArr, linkedList, treeMap, this.logFileManager, appProcessInfo, i2, appIdentifier, str2, batteryLevel, batteryVelocity, proximitySensorEnabled, totalRamInBytes, calculateUsedDiskSpaceInBytes);
    }

    private void writeSessionOS(String str) {
        final boolean isRooted = CommonUtils.isRooted(this.crashlyticsCore.getContext());
        writeSessionPartFile(str, "SessionOS", new CodedOutputStreamWriteAction(this) { // from class: com.crashlytics.android.core.CrashlyticsController.21
            @Override // com.crashlytics.android.core.CrashlyticsController.CodedOutputStreamWriteAction
            public void writeTo(CodedOutputStream codedOutputStream) {
                SessionProtobufHelper.writeSessionOS(codedOutputStream, Build.VERSION.RELEASE, Build.VERSION.CODENAME, isRooted);
            }
        });
        writeFile(str, "SessionOS.json", new FileOutputStreamWriteAction(this) { // from class: com.crashlytics.android.core.CrashlyticsController.22
            @Override // com.crashlytics.android.core.CrashlyticsController.FileOutputStreamWriteAction
            public void writeTo(FileOutputStream fileOutputStream) {
                fileOutputStream.write(new JSONObject(new HashMap<String, Object>() { // from class: com.crashlytics.android.core.CrashlyticsController.22.1
                    {
                        put("version", Build.VERSION.RELEASE);
                        put("build_version", Build.VERSION.CODENAME);
                        put("is_rooted", Boolean.valueOf(isRooted));
                    }
                }).toString().getBytes());
            }
        });
    }

    private void writeSessionPartFile(String str, String str2, CodedOutputStreamWriteAction codedOutputStreamWriteAction) {
        ClsFileOutputStream clsFileOutputStream;
        CodedOutputStream codedOutputStream = null;
        try {
            clsFileOutputStream = new ClsFileOutputStream(c(), str + str2);
            try {
                codedOutputStream = CodedOutputStream.newInstance(clsFileOutputStream);
                codedOutputStreamWriteAction.writeTo(codedOutputStream);
                CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to session " + str2 + " file.");
                CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close session " + str2 + " file.");
            } catch (Throwable th) {
                th = th;
                CommonUtils.flushOrLog(codedOutputStream, "Failed to flush to session " + str2 + " file.");
                CommonUtils.closeOrLog(clsFileOutputStream, "Failed to close session " + str2 + " file.");
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            clsFileOutputStream = null;
        }
    }

    private void writeSessionPartsToSessionFile(File file, String str, int i) {
        Fabric.getLogger().d(CrashlyticsCore.TAG, "Collecting session parts for ID " + str);
        File[] listFilesMatching = listFilesMatching(new FileNameContainsFilter(str + "SessionCrash"));
        boolean z = listFilesMatching != null && listFilesMatching.length > 0;
        Fabric.getLogger().d(CrashlyticsCore.TAG, String.format(Locale.US, "Session %s has fatal exception: %s", str, Boolean.valueOf(z)));
        File[] listFilesMatching2 = listFilesMatching(new FileNameContainsFilter(str + "SessionEvent"));
        boolean z2 = listFilesMatching2 != null && listFilesMatching2.length > 0;
        Fabric.getLogger().d(CrashlyticsCore.TAG, String.format(Locale.US, "Session %s has non-fatal exceptions: %s", str, Boolean.valueOf(z2)));
        if (z || z2) {
            synthesizeSessionFile(file, str, getTrimmedNonFatalFiles(str, listFilesMatching2, i), z ? listFilesMatching[0] : null);
        } else {
            Fabric.getLogger().d(CrashlyticsCore.TAG, "No events present for session ID " + str);
        }
        Fabric.getLogger().d(CrashlyticsCore.TAG, "Removing session part files for ID " + str);
        deleteSessionPartFilesFor(str);
    }

    private void writeSessionUser(String str) {
        final UserMetaData userMetaData = getUserMetaData(str);
        writeSessionPartFile(str, "SessionUser", new CodedOutputStreamWriteAction(this) { // from class: com.crashlytics.android.core.CrashlyticsController.25
            @Override // com.crashlytics.android.core.CrashlyticsController.CodedOutputStreamWriteAction
            public void writeTo(CodedOutputStream codedOutputStream) {
                UserMetaData userMetaData2 = userMetaData;
                SessionProtobufHelper.writeSessionUser(codedOutputStream, userMetaData2.id, userMetaData2.name, userMetaData2.email);
            }
        });
    }

    private static void writeToCosFromFile(CodedOutputStream codedOutputStream, File file) {
        FileInputStream fileInputStream;
        if (!file.exists()) {
            Fabric.getLogger().e(CrashlyticsCore.TAG, "Tried to include a file that doesn't exist: " + file.getName(), null);
            return;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                copyToCodedOutputStream(fileInputStream, codedOutputStream, (int) file.length());
                CommonUtils.closeOrLog(fileInputStream, "Failed to close file input stream.");
            } catch (Throwable th) {
                th = th;
                CommonUtils.closeOrLog(fileInputStream, "Failed to close file input stream.");
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.backgroundWorker.a(new Runnable() { // from class: com.crashlytics.android.core.CrashlyticsController.14
            @Override // java.lang.Runnable
            public void run() {
                CrashlyticsController crashlyticsController = CrashlyticsController.this;
                crashlyticsController.a(crashlyticsController.listFilesMatching(new InvalidPartFileFilter()));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f, SettingsData settingsData) {
        if (settingsData == null) {
            Fabric.getLogger().w(CrashlyticsCore.TAG, "Could not send reports. Settings are not available.");
            return;
        }
        AppSettingsData appSettingsData = settingsData.appData;
        new ReportUploader(this.appData.apiKey, getCreateReportSpiCall(appSettingsData.reportsUrl, appSettingsData.ndkReportsUrl), this.reportFilesProvider, this.handlingExceptionCheck).uploadReports(f, shouldPromptUserBeforeSendingCrashReports(settingsData) ? new PrivacyDialogCheck(this.crashlyticsCore, this.preferenceManager, settingsData.promptData) : new ReportUploader.AlwaysSendCheck());
    }

    void a(int i) {
        int a2 = i - Utils.a(b(), i, e);
        Utils.a(c(), b, a2 - Utils.a(e(), a2, e), e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final long j, final String str) {
        this.backgroundWorker.a(new Callable<Void>() { // from class: com.crashlytics.android.core.CrashlyticsController.8
            @Override // java.util.concurrent.Callable
            public Void call() {
                if (CrashlyticsController.this.f()) {
                    return null;
                }
                CrashlyticsController.this.logFileManager.a(j, str);
                return null;
            }
        });
    }

    synchronized void a(final CrashlyticsUncaughtExceptionHandler.SettingsDataProvider settingsDataProvider, final Thread thread, final Throwable th, final boolean z) {
        Fabric.getLogger().d(CrashlyticsCore.TAG, "Crashlytics is handling uncaught exception \"" + th + "\" from thread " + thread.getName());
        this.devicePowerStateListener.dispose();
        final Date date = new Date();
        this.backgroundWorker.b(new Callable<Void>() { // from class: com.crashlytics.android.core.CrashlyticsController.7
            @Override // java.util.concurrent.Callable
            public Void call() {
                SessionSettingsData sessionSettingsData;
                FeaturesSettingsData featuresSettingsData;
                CrashlyticsController.this.crashlyticsCore.g();
                CrashlyticsController.this.writeFatal(date, thread, th);
                SettingsData settingsData = settingsDataProvider.getSettingsData();
                if (settingsData != null) {
                    sessionSettingsData = settingsData.sessionData;
                    featuresSettingsData = settingsData.featuresData;
                } else {
                    sessionSettingsData = null;
                    featuresSettingsData = null;
                }
                boolean z2 = false;
                if ((featuresSettingsData == null || featuresSettingsData.firebaseCrashlyticsEnabled) || z) {
                    CrashlyticsController.this.recordFatalFirebaseEvent(date.getTime());
                }
                CrashlyticsController.this.a(sessionSettingsData);
                CrashlyticsController.this.doOpenSession();
                if (sessionSettingsData != null) {
                    CrashlyticsController.this.a(sessionSettingsData.maxCompleteSessionsCount);
                }
                if (DataCollectionArbiter.getInstance(CrashlyticsController.this.crashlyticsCore.getContext()).isDataCollectionEnabled() && !CrashlyticsController.this.shouldPromptUserBeforeSendingCrashReports(settingsData)) {
                    z2 = true;
                }
                if (z2) {
                    CrashlyticsController.this.sendSessionReports(settingsData);
                }
                return null;
            }
        });
    }

    void a(SessionSettingsData sessionSettingsData) {
        doCloseSessions(sessionSettingsData, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SettingsData settingsData) {
        if (settingsData.featuresData.firebaseCrashlyticsEnabled) {
            boolean register = this.appMeasurementEventListenerRegistrar.register();
            Fabric.getLogger().d(CrashlyticsCore.TAG, "Registered Firebase Analytics event listener for breadcrumbs: " + register);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final String str, final String str2, final String str3) {
        this.backgroundWorker.a(new Callable<Void>() { // from class: com.crashlytics.android.core.CrashlyticsController.10
            @Override // java.util.concurrent.Callable
            public Void call() {
                new MetaDataStore(CrashlyticsController.this.c()).writeUserData(CrashlyticsController.this.getCurrentSessionId(), new UserMetaData(str, str2, str3));
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, boolean z) {
        j();
        this.crashHandler = new CrashlyticsUncaughtExceptionHandler(new CrashlyticsUncaughtExceptionHandler.CrashListener() { // from class: com.crashlytics.android.core.CrashlyticsController.6
            @Override // com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.CrashListener
            public void onUncaughtException(CrashlyticsUncaughtExceptionHandler.SettingsDataProvider settingsDataProvider, Thread thread, Throwable th, boolean z2) {
                CrashlyticsController.this.a(settingsDataProvider, thread, th, z2);
            }
        }, new DefaultSettingsDataProvider(), z, uncaughtExceptionHandler);
        Thread.setDefaultUncaughtExceptionHandler(this.crashHandler);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final Thread thread, final Throwable th) {
        final Date date = new Date();
        this.backgroundWorker.a(new Runnable() { // from class: com.crashlytics.android.core.CrashlyticsController.9
            @Override // java.lang.Runnable
            public void run() {
                if (CrashlyticsController.this.f()) {
                    return;
                }
                CrashlyticsController.this.doWriteNonFatal(date, thread, th);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final Map<String, String> map) {
        this.backgroundWorker.a(new Callable<Void>() { // from class: com.crashlytics.android.core.CrashlyticsController.11
            @Override // java.util.concurrent.Callable
            public Void call() {
                new MetaDataStore(CrashlyticsController.this.c()).writeKeyData(CrashlyticsController.this.getCurrentSessionId(), map);
                return null;
            }
        });
    }

    void a(File[] fileArr) {
        final HashSet hashSet = new HashSet();
        for (File file : fileArr) {
            Fabric.getLogger().d(CrashlyticsCore.TAG, "Found invalid session part file: " + file);
            hashSet.add(a(file));
        }
        if (hashSet.isEmpty()) {
            return;
        }
        File d2 = d();
        if (!d2.exists()) {
            d2.mkdir();
        }
        for (File file2 : listFilesMatching(new FilenameFilter(this) { // from class: com.crashlytics.android.core.CrashlyticsController.15
            @Override // java.io.FilenameFilter
            public boolean accept(File file3, String str) {
                if (str.length() < 35) {
                    return false;
                }
                return hashSet.contains(str.substring(0, 35));
            }
        })) {
            Fabric.getLogger().d(CrashlyticsCore.TAG, "Moving session file: " + file2);
            if (!file2.renameTo(new File(d2, file2.getName()))) {
                Fabric.getLogger().d(CrashlyticsCore.TAG, "Could not move session file. Deleting " + file2);
                file2.delete();
            }
        }
        trimInvalidSessionFiles();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(final CrashlyticsNdkData crashlyticsNdkData) {
        if (crashlyticsNdkData == null) {
            return true;
        }
        return ((Boolean) this.backgroundWorker.b(new Callable<Boolean>() { // from class: com.crashlytics.android.core.CrashlyticsController.16
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Boolean call() {
                File first;
                TreeSet<File> treeSet = crashlyticsNdkData.timestampedDirectories;
                String previousSessionId = CrashlyticsController.this.getPreviousSessionId();
                if (previousSessionId != null && !treeSet.isEmpty() && (first = treeSet.first()) != null) {
                    CrashlyticsController crashlyticsController = CrashlyticsController.this;
                    crashlyticsController.finalizeMostRecentNativeCrash(crashlyticsController.crashlyticsCore.getContext(), first, previousSessionId);
                }
                CrashlyticsController.this.recursiveDelete(treeSet);
                return Boolean.TRUE;
            }
        })).booleanValue();
    }

    File b() {
        return new File(c(), "fatal-sessions");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(final SessionSettingsData sessionSettingsData) {
        return ((Boolean) this.backgroundWorker.b(new Callable<Boolean>() { // from class: com.crashlytics.android.core.CrashlyticsController.13
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Boolean call() {
                if (CrashlyticsController.this.f()) {
                    Fabric.getLogger().d(CrashlyticsCore.TAG, "Skipping session finalization because a crash has already occurred.");
                    return Boolean.FALSE;
                }
                Fabric.getLogger().d(CrashlyticsCore.TAG, "Finalizing previously open sessions.");
                CrashlyticsController.this.doCloseSessions(sessionSettingsData, true);
                Fabric.getLogger().d(CrashlyticsCore.TAG, "Closed all previously open sessions");
                return Boolean.TRUE;
            }
        })).booleanValue();
    }

    File c() {
        return this.fileStore.getFilesDir();
    }

    File d() {
        return new File(c(), "invalidClsFiles");
    }

    File e() {
        return new File(c(), "nonfatal-sessions");
    }

    boolean f() {
        CrashlyticsUncaughtExceptionHandler crashlyticsUncaughtExceptionHandler = this.crashHandler;
        return crashlyticsUncaughtExceptionHandler != null && crashlyticsUncaughtExceptionHandler.a();
    }

    File[] g() {
        LinkedList linkedList = new LinkedList();
        Collections.addAll(linkedList, listFilesMatching(b(), b));
        Collections.addAll(linkedList, listFilesMatching(e(), b));
        Collections.addAll(linkedList, listFilesMatching(c(), b));
        return (File[]) linkedList.toArray(new File[linkedList.size()]);
    }

    File[] h() {
        return listFilesMatching(c);
    }

    File[] i() {
        return listFilesMatching(a);
    }

    void j() {
        this.backgroundWorker.a(new Callable<Void>() { // from class: com.crashlytics.android.core.CrashlyticsController.12
            @Override // java.util.concurrent.Callable
            public Void call() {
                CrashlyticsController.this.doOpenSession();
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k() {
        this.devicePowerStateListener.initialize();
    }
}
