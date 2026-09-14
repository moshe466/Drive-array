package io.flutter.plugins;

import H0.b;
import a1.C0232c;
import b1.C0323b;
import com.github.dart_lang.jni.JniPlugin;
import com.github.dart_lang.jni_flutter.JniFlutterPlugin;
import com.lt.plugin.lt_plugin.LtPlugin;
import com.pichillilorenzo.flutter_inappwebview_android.InAppWebViewFlutterPlugin;
import f2.C0423d;
import i2.C0454e;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugins.firebase.core.FlutterFirebaseCorePlugin;
import io.flutter.plugins.firebase.crashlytics.FlutterFirebaseCrashlyticsPlugin;
import io.flutter.plugins.flutter_plugin_android_lifecycle.FlutterAndroidLifecyclePlugin;
import io.flutter.plugins.imagepicker.ImagePickerPlugin;
import io.flutter.plugins.localauth.LocalAuthPlugin;
import io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin;
import io.flutter.plugins.urllauncher.UrlLauncherPlugin;
import k2.C0496f;
import l2.C0521d;
import m2.C0588a;
import n2.C0595a;
import o1.j;
import q2.C0623a;

/* loaded from: classes.dex */
public final class GeneratedPluginRegistrant {
    private static final String TAG = "GeneratedPluginRegistrant";

    public static void registerWith(FlutterEngine flutterEngine) {
        try {
            flutterEngine.getPlugins().add(new C0521d());
        } catch (Exception e4) {
            Log.e(TAG, "Error registering plugin connectivity_plus, dev.fluttercommunity.plus.connectivity.ConnectivityPlugin", e4);
        }
        try {
            flutterEngine.getPlugins().add(new C0588a());
        } catch (Exception e5) {
            Log.e(TAG, "Error registering plugin device_info_plus, dev.fluttercommunity.plus.device_info.DeviceInfoPlusPlugin", e5);
        }
        try {
            flutterEngine.getPlugins().add(new C0454e());
        } catch (Exception e6) {
            Log.e(TAG, "Error registering plugin file_picker, com.mr.flutter.plugin.filepicker.FilePickerPlugin", e6);
        }
        try {
            flutterEngine.getPlugins().add(new FlutterFirebaseCorePlugin());
        } catch (Exception e7) {
            Log.e(TAG, "Error registering plugin firebase_core, io.flutter.plugins.firebase.core.FlutterFirebaseCorePlugin", e7);
        }
        try {
            flutterEngine.getPlugins().add(new FlutterFirebaseCrashlyticsPlugin());
        } catch (Exception e8) {
            Log.e(TAG, "Error registering plugin firebase_crashlytics, io.flutter.plugins.firebase.crashlytics.FlutterFirebaseCrashlyticsPlugin", e8);
        }
        try {
            flutterEngine.getPlugins().add(new InAppWebViewFlutterPlugin());
        } catch (Exception e9) {
            Log.e(TAG, "Error registering plugin flutter_inappwebview_android, com.pichillilorenzo.flutter_inappwebview_android.InAppWebViewFlutterPlugin", e9);
        }
        try {
            flutterEngine.getPlugins().add(new FlutterAndroidLifecyclePlugin());
        } catch (Exception e10) {
            Log.e(TAG, "Error registering plugin flutter_plugin_android_lifecycle, io.flutter.plugins.flutter_plugin_android_lifecycle.FlutterAndroidLifecyclePlugin", e10);
        }
        try {
            flutterEngine.getPlugins().add(new C0423d());
        } catch (Exception e11) {
            Log.e(TAG, "Error registering plugin flutter_secure_storage, com.it_nomads.fluttersecurestorage.FlutterSecureStoragePlugin", e11);
        }
        try {
            flutterEngine.getPlugins().add(new C0623a());
        } catch (Exception e12) {
            Log.e(TAG, "Error registering plugin fluttertoast, io.github.ponnamkarthik.toast.fluttertoast.FlutterToastPlugin", e12);
        }
        try {
            flutterEngine.getPlugins().add(new b());
        } catch (Exception e13) {
            Log.e(TAG, "Error registering plugin freerasp, com.aheaditec.freerasp.FreeraspPlugin", e13);
        }
        try {
            flutterEngine.getPlugins().add(new ImagePickerPlugin());
        } catch (Exception e14) {
            Log.e(TAG, "Error registering plugin image_picker_android, io.flutter.plugins.imagepicker.ImagePickerPlugin", e14);
        }
        try {
            flutterEngine.getPlugins().add(new C0496f());
        } catch (Exception e15) {
            Log.e(TAG, "Error registering plugin in_app_update, de.ffuf.in_app_update.InAppUpdatePlugin", e15);
        }
        try {
            flutterEngine.getPlugins().add(new JniPlugin());
        } catch (Exception e16) {
            Log.e(TAG, "Error registering plugin jni, com.github.dart_lang.jni.JniPlugin", e16);
        }
        try {
            flutterEngine.getPlugins().add(new JniFlutterPlugin());
        } catch (Exception e17) {
            Log.e(TAG, "Error registering plugin jni_flutter, com.github.dart_lang.jni_flutter.JniFlutterPlugin", e17);
        }
        try {
            flutterEngine.getPlugins().add(new LocalAuthPlugin());
        } catch (Exception e18) {
            Log.e(TAG, "Error registering plugin local_auth_android, io.flutter.plugins.localauth.LocalAuthPlugin", e18);
        }
        try {
            flutterEngine.getPlugins().add(new LtPlugin());
        } catch (Exception e19) {
            Log.e(TAG, "Error registering plugin lt_plugin, com.lt.plugin.lt_plugin.LtPlugin", e19);
        }
        try {
            flutterEngine.getPlugins().add(new j());
        } catch (Exception e20) {
            Log.e(TAG, "Error registering plugin no_screenshot, com.flutterplaza.no_screenshot.NoScreenshotPlugin", e20);
        }
        try {
            flutterEngine.getPlugins().add(new C0595a());
        } catch (Exception e21) {
            Log.e(TAG, "Error registering plugin package_info_plus, dev.fluttercommunity.plus.packageinfo.PackageInfoPlugin", e21);
        }
        try {
            flutterEngine.getPlugins().add(new C0232c());
        } catch (Exception e22) {
            Log.e(TAG, "Error registering plugin permission_handler_android, com.baseflow.permissionhandler.PermissionHandlerPlugin", e22);
        }
        try {
            flutterEngine.getPlugins().add(new SharedPreferencesPlugin());
        } catch (Exception e23) {
            Log.e(TAG, "Error registering plugin shared_preferences_android, io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin", e23);
        }
        try {
            flutterEngine.getPlugins().add(new UrlLauncherPlugin());
        } catch (Exception e24) {
            Log.e(TAG, "Error registering plugin url_launcher_android, io.flutter.plugins.urllauncher.UrlLauncherPlugin", e24);
        }
        try {
            flutterEngine.getPlugins().add(new C0323b());
        } catch (Exception e25) {
            Log.e(TAG, "Error registering plugin vibration, com.benjaminabel.vibration.VibrationPlugin", e25);
        }
    }
}
