package androidx.loader.content;

import F0.AbstractC0008a;
import android.content.Context;
import android.os.Looper;
import f0.C0374c;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public abstract class e {
    boolean mAbandoned;
    boolean mContentChanged;
    Context mContext;
    int mId;
    d mListener;
    c mOnLoadCanceledListener;
    boolean mProcessingChange;
    boolean mReset;
    boolean mStarted;

    public void abandon() {
        this.mAbandoned = true;
        onAbandon();
    }

    public boolean cancelLoad() {
        return onCancelLoad();
    }

    public void commitContentChanged() {
        this.mProcessingChange = false;
    }

    public String dataToString(Object obj) {
        StringBuilder sb = new StringBuilder(64);
        I.d.a(obj, sb);
        sb.append("}");
        return sb.toString();
    }

    public void deliverCancellation() {
    }

    public void deliverResult(Object obj) {
        d dVar = this.mListener;
        if (dVar != null) {
            C0374c c0374c = (C0374c) dVar;
            if (Looper.myLooper() == Looper.getMainLooper()) {
                c0374c.h(obj);
            } else {
                c0374c.i(obj);
            }
        }
    }

    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public void forceLoad() {
        onForceLoad();
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getId() {
        return this.mId;
    }

    public boolean isAbandoned() {
        return this.mAbandoned;
    }

    public boolean isReset() {
        return this.mReset;
    }

    public boolean isStarted() {
        return this.mStarted;
    }

    public void onAbandon() {
    }

    public abstract boolean onCancelLoad();

    public void onContentChanged() {
        if (this.mStarted) {
            forceLoad();
        } else {
            this.mContentChanged = true;
        }
    }

    public abstract void onForceLoad();

    public void onReset() {
    }

    public abstract void onStartLoading();

    public void onStopLoading() {
    }

    public void registerListener(int i, d dVar) {
        if (this.mListener == null) {
            this.mListener = dVar;
            this.mId = i;
            return;
        }
        throw new IllegalStateException("There is already a listener registered");
    }

    public void registerOnLoadCanceledListener(c cVar) {
    }

    public void reset() {
        onReset();
        this.mReset = true;
        this.mStarted = false;
        this.mAbandoned = false;
        this.mContentChanged = false;
        this.mProcessingChange = false;
    }

    public void rollbackContentChanged() {
        if (this.mProcessingChange) {
            onContentChanged();
        }
    }

    public final void startLoading() {
        this.mStarted = true;
        this.mReset = false;
        this.mAbandoned = false;
        onStartLoading();
    }

    public void stopLoading() {
        this.mStarted = false;
        onStopLoading();
    }

    public boolean takeContentChanged() {
        boolean z3 = this.mContentChanged;
        this.mContentChanged = false;
        this.mProcessingChange |= z3;
        return z3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        I.d.a(this, sb);
        sb.append(" id=");
        return AbstractC0008a.r(sb, this.mId, "}");
    }

    public void unregisterListener(d dVar) {
        d dVar2 = this.mListener;
        if (dVar2 != null) {
            if (dVar2 == dVar) {
                this.mListener = null;
                return;
            }
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        throw new IllegalStateException("No listener register");
    }

    public void unregisterOnLoadCanceledListener(c cVar) {
        throw new IllegalStateException("No listener register");
    }
}
