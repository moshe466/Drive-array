package com.groboot.mdaemergency.models;

import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class AppSettings {
    public boolean HasOnCallDrive;
    public boolean IsBiker;
    public int KeepAliveInterval = (int) TimeUnit.SECONDS.toMillis(60);
    public int MainScreenFeatureType = -1;
    public List<SettingsListGroup> Settings;
    public List<SettingSound> SettingsSound;
}
