package org.chromium.support_lib_boundary;

import java.util.Set;

/* loaded from: classes.dex */
public interface ServiceWorkerWebSettingsBoundaryInterface {
    boolean getAllowContentAccess();

    boolean getAllowFileAccess();

    boolean getBlockNetworkLoads();

    int getCacheMode();

    Set<String> getRequestedWithHeaderOriginAllowList();

    void setAllowContentAccess(boolean z3);

    void setAllowFileAccess(boolean z3);

    void setBlockNetworkLoads(boolean z3);

    void setCacheMode(int i);

    void setRequestedWithHeaderOriginAllowList(Set<String> set);
}
