package androidx.core.app;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.firebase.firestore.util.ExponentialBackoff;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class JobIntentService extends Service {
    static final Object h = new Object();
    static final HashMap<ComponentName, WorkEnqueuer> i = new HashMap<>();
    CompatJobEngine a;
    WorkEnqueuer b;
    CommandProcessor c;
    boolean d = false;
    boolean e = false;
    boolean f = false;
    final ArrayList<CompatWorkItem> g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class CommandProcessor extends AsyncTask<Void, Void, Void> {
        CommandProcessor() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            while (true) {
                GenericWorkItem a = JobIntentService.this.a();
                if (a == null) {
                    return null;
                }
                JobIntentService.this.a(a.getIntent());
                a.complete();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onCancelled(Void r1) {
            JobIntentService.this.c();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r1) {
            JobIntentService.this.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface CompatJobEngine {
        IBinder compatGetBinder();

        GenericWorkItem dequeueWork();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class CompatWorkEnqueuer extends WorkEnqueuer {
        boolean d;
        boolean e;
        private final Context mContext;
        private final PowerManager.WakeLock mLaunchWakeLock;
        private final PowerManager.WakeLock mRunWakeLock;

        CompatWorkEnqueuer(Context context, ComponentName componentName) {
            super(componentName);
            this.mContext = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            this.mLaunchWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.mLaunchWakeLock.setReferenceCounted(false);
            this.mRunWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.mRunWakeLock.setReferenceCounted(false);
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        void a(Intent intent) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(this.a);
            if (this.mContext.startService(intent2) != null) {
                synchronized (this) {
                    if (!this.d) {
                        this.d = true;
                        if (!this.e) {
                            this.mLaunchWakeLock.acquire(ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS);
                        }
                    }
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public void serviceProcessingFinished() {
            synchronized (this) {
                if (this.e) {
                    if (this.d) {
                        this.mLaunchWakeLock.acquire(ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS);
                    }
                    this.e = false;
                    this.mRunWakeLock.release();
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public void serviceProcessingStarted() {
            synchronized (this) {
                if (!this.e) {
                    this.e = true;
                    this.mRunWakeLock.acquire(600000L);
                    this.mLaunchWakeLock.release();
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public void serviceStartReceived() {
            synchronized (this) {
                this.d = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class CompatWorkItem implements GenericWorkItem {
        final Intent a;
        final int b;

        CompatWorkItem(Intent intent, int i) {
            this.a = intent;
            this.b = i;
        }

        @Override // androidx.core.app.JobIntentService.GenericWorkItem
        public void complete() {
            JobIntentService.this.stopSelf(this.b);
        }

        @Override // androidx.core.app.JobIntentService.GenericWorkItem
        public Intent getIntent() {
            return this.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface GenericWorkItem {
        void complete();

        Intent getIntent();
    }

    @RequiresApi(26)
    /* loaded from: classes.dex */
    static final class JobServiceEngineImpl extends JobServiceEngine implements CompatJobEngine {
        final JobIntentService a;
        final Object b;
        JobParameters c;

        /* loaded from: classes.dex */
        final class WrapperWorkItem implements GenericWorkItem {
            final JobWorkItem a;

            WrapperWorkItem(JobWorkItem jobWorkItem) {
                this.a = jobWorkItem;
            }

            @Override // androidx.core.app.JobIntentService.GenericWorkItem
            public void complete() {
                synchronized (JobServiceEngineImpl.this.b) {
                    if (JobServiceEngineImpl.this.c != null) {
                        JobServiceEngineImpl.this.c.completeWork(this.a);
                    }
                }
            }

            @Override // androidx.core.app.JobIntentService.GenericWorkItem
            public Intent getIntent() {
                return this.a.getIntent();
            }
        }

        JobServiceEngineImpl(JobIntentService jobIntentService) {
            super(jobIntentService);
            this.b = new Object();
            this.a = jobIntentService;
        }

        @Override // androidx.core.app.JobIntentService.CompatJobEngine
        public IBinder compatGetBinder() {
            return getBinder();
        }

        @Override // androidx.core.app.JobIntentService.CompatJobEngine
        public GenericWorkItem dequeueWork() {
            synchronized (this.b) {
                if (this.c == null) {
                    return null;
                }
                JobWorkItem dequeueWork = this.c.dequeueWork();
                if (dequeueWork == null) {
                    return null;
                }
                dequeueWork.getIntent().setExtrasClassLoader(this.a.getClassLoader());
                return new WrapperWorkItem(dequeueWork);
            }
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStartJob(JobParameters jobParameters) {
            this.c = jobParameters;
            this.a.a(false);
            return true;
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStopJob(JobParameters jobParameters) {
            boolean b = this.a.b();
            synchronized (this.b) {
                this.c = null;
            }
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RequiresApi(26)
    /* loaded from: classes.dex */
    public static final class JobWorkEnqueuer extends WorkEnqueuer {
        private final JobInfo mJobInfo;
        private final JobScheduler mJobScheduler;

        JobWorkEnqueuer(Context context, ComponentName componentName, int i) {
            super(componentName);
            a(i);
            this.mJobInfo = new JobInfo.Builder(i, this.a).setOverrideDeadline(0L).build();
            this.mJobScheduler = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        void a(Intent intent) {
            this.mJobScheduler.enqueue(this.mJobInfo, new JobWorkItem(intent));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class WorkEnqueuer {
        final ComponentName a;
        boolean b;
        int c;

        WorkEnqueuer(ComponentName componentName) {
            this.a = componentName;
        }

        void a(int i) {
            if (!this.b) {
                this.b = true;
                this.c = i;
            } else {
                if (this.c == i) {
                    return;
                }
                throw new IllegalArgumentException("Given job ID " + i + " is different than previous " + this.c);
            }
        }

        abstract void a(Intent intent);

        public void serviceProcessingFinished() {
        }

        public void serviceProcessingStarted() {
        }

        public void serviceStartReceived() {
        }
    }

    public JobIntentService() {
        this.g = Build.VERSION.SDK_INT >= 26 ? null : new ArrayList<>();
    }

    static WorkEnqueuer a(Context context, ComponentName componentName, boolean z, int i2) {
        WorkEnqueuer compatWorkEnqueuer;
        WorkEnqueuer workEnqueuer = i.get(componentName);
        if (workEnqueuer != null) {
            return workEnqueuer;
        }
        if (Build.VERSION.SDK_INT < 26) {
            compatWorkEnqueuer = new CompatWorkEnqueuer(context, componentName);
        } else {
            if (!z) {
                throw new IllegalArgumentException("Can't be here without a job id");
            }
            compatWorkEnqueuer = new JobWorkEnqueuer(context, componentName, i2);
        }
        WorkEnqueuer workEnqueuer2 = compatWorkEnqueuer;
        i.put(componentName, workEnqueuer2);
        return workEnqueuer2;
    }

    public static void enqueueWork(@NonNull Context context, @NonNull ComponentName componentName, int i2, @NonNull Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("work must not be null");
        }
        synchronized (h) {
            WorkEnqueuer a = a(context, componentName, true, i2);
            a.a(i2);
            a.a(intent);
        }
    }

    public static void enqueueWork(@NonNull Context context, @NonNull Class cls, int i2, @NonNull Intent intent) {
        enqueueWork(context, new ComponentName(context, (Class<?>) cls), i2, intent);
    }

    GenericWorkItem a() {
        CompatJobEngine compatJobEngine = this.a;
        if (compatJobEngine != null) {
            return compatJobEngine.dequeueWork();
        }
        synchronized (this.g) {
            if (this.g.size() <= 0) {
                return null;
            }
            return this.g.remove(0);
        }
    }

    protected abstract void a(@NonNull Intent intent);

    void a(boolean z) {
        if (this.c == null) {
            this.c = new CommandProcessor();
            WorkEnqueuer workEnqueuer = this.b;
            if (workEnqueuer != null && z) {
                workEnqueuer.serviceProcessingStarted();
            }
            this.c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    boolean b() {
        CommandProcessor commandProcessor = this.c;
        if (commandProcessor != null) {
            commandProcessor.cancel(this.d);
        }
        this.e = true;
        return onStopCurrentWork();
    }

    void c() {
        ArrayList<CompatWorkItem> arrayList = this.g;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.c = null;
                if (this.g != null && this.g.size() > 0) {
                    a(false);
                } else if (!this.f) {
                    this.b.serviceProcessingFinished();
                }
            }
        }
    }

    public boolean isStopped() {
        return this.e;
    }

    @Override // android.app.Service
    public IBinder onBind(@NonNull Intent intent) {
        CompatJobEngine compatJobEngine = this.a;
        if (compatJobEngine != null) {
            return compatJobEngine.compatGetBinder();
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.a = new JobServiceEngineImpl(this);
            this.b = null;
        } else {
            this.a = null;
            this.b = a(this, new ComponentName(this, (Class<?>) JobIntentService.class), false, 0);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ArrayList<CompatWorkItem> arrayList = this.g;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f = true;
                this.b.serviceProcessingFinished();
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i2, int i3) {
        if (this.g == null) {
            return 2;
        }
        this.b.serviceStartReceived();
        synchronized (this.g) {
            ArrayList<CompatWorkItem> arrayList = this.g;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new CompatWorkItem(intent, i3));
            a(true);
        }
        return 3;
    }

    public boolean onStopCurrentWork() {
        return true;
    }

    public void setInterruptIfStopped(boolean z) {
        this.d = z;
    }
}
