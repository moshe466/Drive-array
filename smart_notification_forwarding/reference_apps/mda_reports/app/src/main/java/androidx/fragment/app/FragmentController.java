package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Preconditions;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class FragmentController {
    private final FragmentHostCallback<?> mHost;

    private FragmentController(FragmentHostCallback<?> fragmentHostCallback) {
        this.mHost = fragmentHostCallback;
    }

    @NonNull
    public static FragmentController createController(@NonNull FragmentHostCallback<?> fragmentHostCallback) {
        return new FragmentController((FragmentHostCallback) Preconditions.checkNotNull(fragmentHostCallback, "callbacks == null"));
    }

    public void attachHost(@Nullable Fragment fragment) {
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        fragmentHostCallback.a.attachController(fragmentHostCallback, fragmentHostCallback, fragment);
    }

    public void dispatchActivityCreated() {
        this.mHost.a.dispatchActivityCreated();
    }

    public void dispatchConfigurationChanged(@NonNull Configuration configuration) {
        this.mHost.a.dispatchConfigurationChanged(configuration);
    }

    public boolean dispatchContextItemSelected(@NonNull MenuItem menuItem) {
        return this.mHost.a.dispatchContextItemSelected(menuItem);
    }

    public void dispatchCreate() {
        this.mHost.a.dispatchCreate();
    }

    public boolean dispatchCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        return this.mHost.a.dispatchCreateOptionsMenu(menu, menuInflater);
    }

    public void dispatchDestroy() {
        this.mHost.a.dispatchDestroy();
    }

    public void dispatchDestroyView() {
        this.mHost.a.dispatchDestroyView();
    }

    public void dispatchLowMemory() {
        this.mHost.a.dispatchLowMemory();
    }

    public void dispatchMultiWindowModeChanged(boolean z) {
        this.mHost.a.dispatchMultiWindowModeChanged(z);
    }

    public boolean dispatchOptionsItemSelected(@NonNull MenuItem menuItem) {
        return this.mHost.a.dispatchOptionsItemSelected(menuItem);
    }

    public void dispatchOptionsMenuClosed(@NonNull Menu menu) {
        this.mHost.a.dispatchOptionsMenuClosed(menu);
    }

    public void dispatchPause() {
        this.mHost.a.dispatchPause();
    }

    public void dispatchPictureInPictureModeChanged(boolean z) {
        this.mHost.a.dispatchPictureInPictureModeChanged(z);
    }

    public boolean dispatchPrepareOptionsMenu(@NonNull Menu menu) {
        return this.mHost.a.dispatchPrepareOptionsMenu(menu);
    }

    @Deprecated
    public void dispatchReallyStop() {
    }

    public void dispatchResume() {
        this.mHost.a.dispatchResume();
    }

    public void dispatchStart() {
        this.mHost.a.dispatchStart();
    }

    public void dispatchStop() {
        this.mHost.a.dispatchStop();
    }

    @Deprecated
    public void doLoaderDestroy() {
    }

    @Deprecated
    public void doLoaderRetain() {
    }

    @Deprecated
    public void doLoaderStart() {
    }

    @Deprecated
    public void doLoaderStop(boolean z) {
    }

    @Deprecated
    public void dumpLoaders(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
    }

    public boolean execPendingActions() {
        return this.mHost.a.execPendingActions();
    }

    @Nullable
    public Fragment findFragmentByWho(@NonNull String str) {
        return this.mHost.a.findFragmentByWho(str);
    }

    @NonNull
    public List<Fragment> getActiveFragments(@SuppressLint({"UnknownNullness"}) List<Fragment> list) {
        return this.mHost.a.e();
    }

    public int getActiveFragmentsCount() {
        return this.mHost.a.d();
    }

    @NonNull
    public FragmentManager getSupportFragmentManager() {
        return this.mHost.a;
    }

    @SuppressLint({"UnknownNullness"})
    @Deprecated
    public LoaderManager getSupportLoaderManager() {
        throw new UnsupportedOperationException("Loaders are managed separately from FragmentController, use LoaderManager.getInstance() to obtain a LoaderManager.");
    }

    public void noteStateNotSaved() {
        this.mHost.a.noteStateNotSaved();
    }

    @Nullable
    public View onCreateView(@Nullable View view, @NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        return this.mHost.a.onCreateView(view, str, context, attributeSet);
    }

    @Deprecated
    public void reportLoaderStart() {
    }

    @Deprecated
    public void restoreAllState(@Nullable Parcelable parcelable, @Nullable FragmentManagerNonConfig fragmentManagerNonConfig) {
        this.mHost.a.a(parcelable, fragmentManagerNonConfig);
    }

    @Deprecated
    public void restoreAllState(@Nullable Parcelable parcelable, @Nullable List<Fragment> list) {
        this.mHost.a.a(parcelable, new FragmentManagerNonConfig(list, null, null));
    }

    @Deprecated
    public void restoreLoaderNonConfig(@SuppressLint({"UnknownNullness"}) SimpleArrayMap<String, LoaderManager> simpleArrayMap) {
    }

    public void restoreSaveState(@Nullable Parcelable parcelable) {
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        if (!(fragmentHostCallback instanceof ViewModelStoreOwner)) {
            throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
        }
        fragmentHostCallback.a.a(parcelable);
    }

    @Nullable
    @Deprecated
    public SimpleArrayMap<String, LoaderManager> retainLoaderNonConfig() {
        return null;
    }

    @Nullable
    @Deprecated
    public FragmentManagerNonConfig retainNestedNonConfig() {
        return this.mHost.a.i();
    }

    @Nullable
    @Deprecated
    public List<Fragment> retainNonConfig() {
        FragmentManagerNonConfig i = this.mHost.a.i();
        if (i == null || i.b() == null) {
            return null;
        }
        return new ArrayList(i.b());
    }

    @Nullable
    public Parcelable saveAllState() {
        return this.mHost.a.j();
    }
}
