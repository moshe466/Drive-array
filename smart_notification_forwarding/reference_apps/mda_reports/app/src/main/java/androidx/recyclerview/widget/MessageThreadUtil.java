package androidx.recyclerview.widget;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.recyclerview.widget.ThreadUtil;
import androidx.recyclerview.widget.TileList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
class MessageThreadUtil<T> implements ThreadUtil<T> {

    /* renamed from: androidx.recyclerview.widget.MessageThreadUtil$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements ThreadUtil.MainThreadCallback<T> {
        final /* synthetic */ ThreadUtil.MainThreadCallback b;
        final MessageQueue a = new MessageQueue();
        private final Handler mMainThreadHandler = new Handler(Looper.getMainLooper());
        private Runnable mMainThreadRunnable = new Runnable() { // from class: androidx.recyclerview.widget.MessageThreadUtil.1.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    SyncQueueItem a = AnonymousClass1.this.a.a();
                    if (a == null) {
                        return;
                    }
                    int i = a.what;
                    if (i == 1) {
                        AnonymousClass1.this.b.updateItemCount(a.arg1, a.arg2);
                    } else if (i == 2) {
                        AnonymousClass1.this.b.addTile(a.arg1, (TileList.Tile) a.data);
                    } else if (i != 3) {
                        Log.e("ThreadUtil", "Unsupported message, what=" + a.what);
                    } else {
                        AnonymousClass1.this.b.removeTile(a.arg1, a.arg2);
                    }
                }
            }
        };

        AnonymousClass1(MessageThreadUtil messageThreadUtil, ThreadUtil.MainThreadCallback mainThreadCallback) {
            this.b = mainThreadCallback;
        }

        private void sendMessage(SyncQueueItem syncQueueItem) {
            this.a.a(syncQueueItem);
            this.mMainThreadHandler.post(this.mMainThreadRunnable);
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void addTile(int i, TileList.Tile<T> tile) {
            sendMessage(SyncQueueItem.a(2, i, tile));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void removeTile(int i, int i2) {
            sendMessage(SyncQueueItem.a(3, i, i2));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void updateItemCount(int i, int i2) {
            sendMessage(SyncQueueItem.a(1, i, i2));
        }
    }

    /* renamed from: androidx.recyclerview.widget.MessageThreadUtil$2, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 implements ThreadUtil.BackgroundCallback<T> {
        final /* synthetic */ ThreadUtil.BackgroundCallback c;
        final MessageQueue a = new MessageQueue();
        private final Executor mExecutor = AsyncTask.THREAD_POOL_EXECUTOR;
        AtomicBoolean b = new AtomicBoolean(false);
        private Runnable mBackgroundRunnable = new Runnable() { // from class: androidx.recyclerview.widget.MessageThreadUtil.2.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    SyncQueueItem a = AnonymousClass2.this.a.a();
                    if (a == null) {
                        AnonymousClass2.this.b.set(false);
                        return;
                    }
                    int i = a.what;
                    if (i == 1) {
                        AnonymousClass2.this.a.a(1);
                        AnonymousClass2.this.c.refresh(a.arg1);
                    } else if (i == 2) {
                        AnonymousClass2.this.a.a(2);
                        AnonymousClass2.this.a.a(3);
                        AnonymousClass2.this.c.updateRange(a.arg1, a.arg2, a.arg3, a.arg4, a.arg5);
                    } else if (i == 3) {
                        AnonymousClass2.this.c.loadTile(a.arg1, a.arg2);
                    } else if (i != 4) {
                        Log.e("ThreadUtil", "Unsupported message, what=" + a.what);
                    } else {
                        AnonymousClass2.this.c.recycleTile((TileList.Tile) a.data);
                    }
                }
            }
        };

        AnonymousClass2(MessageThreadUtil messageThreadUtil, ThreadUtil.BackgroundCallback backgroundCallback) {
            this.c = backgroundCallback;
        }

        private void maybeExecuteBackgroundRunnable() {
            if (this.b.compareAndSet(false, true)) {
                this.mExecutor.execute(this.mBackgroundRunnable);
            }
        }

        private void sendMessage(SyncQueueItem syncQueueItem) {
            this.a.a(syncQueueItem);
            maybeExecuteBackgroundRunnable();
        }

        private void sendMessageAtFrontOfQueue(SyncQueueItem syncQueueItem) {
            this.a.b(syncQueueItem);
            maybeExecuteBackgroundRunnable();
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void loadTile(int i, int i2) {
            sendMessage(SyncQueueItem.a(3, i, i2));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void recycleTile(TileList.Tile<T> tile) {
            sendMessage(SyncQueueItem.a(4, 0, tile));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void refresh(int i) {
            sendMessageAtFrontOfQueue(SyncQueueItem.a(1, i, (Object) null));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void updateRange(int i, int i2, int i3, int i4, int i5) {
            sendMessageAtFrontOfQueue(SyncQueueItem.a(2, i, i2, i3, i4, i5, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class MessageQueue {
        private SyncQueueItem mRoot;

        MessageQueue() {
        }

        synchronized SyncQueueItem a() {
            if (this.mRoot == null) {
                return null;
            }
            SyncQueueItem syncQueueItem = this.mRoot;
            this.mRoot = this.mRoot.a;
            return syncQueueItem;
        }

        synchronized void a(int i) {
            while (this.mRoot != null && this.mRoot.what == i) {
                SyncQueueItem syncQueueItem = this.mRoot;
                this.mRoot = this.mRoot.a;
                syncQueueItem.a();
            }
            if (this.mRoot != null) {
                SyncQueueItem syncQueueItem2 = this.mRoot;
                SyncQueueItem syncQueueItem3 = syncQueueItem2.a;
                while (syncQueueItem3 != null) {
                    SyncQueueItem syncQueueItem4 = syncQueueItem3.a;
                    if (syncQueueItem3.what == i) {
                        syncQueueItem2.a = syncQueueItem4;
                        syncQueueItem3.a();
                    } else {
                        syncQueueItem2 = syncQueueItem3;
                    }
                    syncQueueItem3 = syncQueueItem4;
                }
            }
        }

        synchronized void a(SyncQueueItem syncQueueItem) {
            if (this.mRoot == null) {
                this.mRoot = syncQueueItem;
                return;
            }
            SyncQueueItem syncQueueItem2 = this.mRoot;
            while (syncQueueItem2.a != null) {
                syncQueueItem2 = syncQueueItem2.a;
            }
            syncQueueItem2.a = syncQueueItem;
        }

        synchronized void b(SyncQueueItem syncQueueItem) {
            syncQueueItem.a = this.mRoot;
            this.mRoot = syncQueueItem;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SyncQueueItem {
        private static SyncQueueItem sPool;
        private static final Object sPoolLock = new Object();
        SyncQueueItem a;
        public int arg1;
        public int arg2;
        public int arg3;
        public int arg4;
        public int arg5;
        public Object data;
        public int what;

        SyncQueueItem() {
        }

        static SyncQueueItem a(int i, int i2, int i3) {
            return a(i, i2, i3, 0, 0, 0, null);
        }

        static SyncQueueItem a(int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
            SyncQueueItem syncQueueItem;
            synchronized (sPoolLock) {
                if (sPool == null) {
                    syncQueueItem = new SyncQueueItem();
                } else {
                    syncQueueItem = sPool;
                    sPool = sPool.a;
                    syncQueueItem.a = null;
                }
                syncQueueItem.what = i;
                syncQueueItem.arg1 = i2;
                syncQueueItem.arg2 = i3;
                syncQueueItem.arg3 = i4;
                syncQueueItem.arg4 = i5;
                syncQueueItem.arg5 = i6;
                syncQueueItem.data = obj;
            }
            return syncQueueItem;
        }

        static SyncQueueItem a(int i, int i2, Object obj) {
            return a(i, i2, 0, 0, 0, 0, obj);
        }

        void a() {
            this.a = null;
            this.arg5 = 0;
            this.arg4 = 0;
            this.arg3 = 0;
            this.arg2 = 0;
            this.arg1 = 0;
            this.what = 0;
            this.data = null;
            synchronized (sPoolLock) {
                if (sPool != null) {
                    this.a = sPool;
                }
                sPool = this;
            }
        }
    }

    @Override // androidx.recyclerview.widget.ThreadUtil
    public ThreadUtil.BackgroundCallback<T> getBackgroundProxy(ThreadUtil.BackgroundCallback<T> backgroundCallback) {
        return new AnonymousClass2(this, backgroundCallback);
    }

    @Override // androidx.recyclerview.widget.ThreadUtil
    public ThreadUtil.MainThreadCallback<T> getMainThreadProxy(ThreadUtil.MainThreadCallback<T> mainThreadCallback) {
        return new AnonymousClass1(this, mainThreadCallback);
    }
}
