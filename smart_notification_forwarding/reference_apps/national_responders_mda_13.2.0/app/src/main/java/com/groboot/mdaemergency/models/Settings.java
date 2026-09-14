package com.groboot.mdaemergency.models;

import com.groboot.mdaemergency.async.d;
import com.groboot.mdaemergency.enums.i;
import com.groboot.mdaemergency.enums.k;
import com.groboot.mdaemergency.enums.l;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class Settings {
    public static l defaultSound = l.Siren_1;
    public HashMap<Integer, AlertSound> alertSounds;
    public boolean isPlayPushListSound;
    public String pttActive = "0";
    public String pttVolumeInSilent;

    /* loaded from: classes.dex */
    public static class AlertSound {
        public String key;
        public String settingSound;
        public String settingVibrate;
        public l sound;

        public AlertSound() {
            this.sound = Settings.defaultSound;
            this.settingSound = i.normal.getKey();
            this.settingVibrate = k.withVibrate.getKey();
        }

        public AlertSound(l lVar, String str, String str2) {
            this.sound = lVar;
            this.settingSound = str;
            this.settingVibrate = str2;
        }

        public AlertSound(String str, String str2) {
            this.sound = Settings.defaultSound;
            this.settingSound = str;
            this.settingVibrate = str2;
        }
    }

    public void init() {
        if (this.alertSounds == null) {
            this.alertSounds = new HashMap<>();
            if (d.v().f7636f != null && d.v().f7636f.Settings != null) {
                Iterator<SettingSound> it = d.v().f7636f.SettingsSound.iterator();
                while (it.hasNext()) {
                    this.alertSounds.put(Integer.valueOf(it.next().Type), new AlertSound(defaultSound, i.normal.getKey(), k.withVibrate.getKey()));
                }
            }
            this.pttVolumeInSilent = "-1";
        }
    }
}
