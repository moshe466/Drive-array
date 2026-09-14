# Proguard rules for MDA Reports / Responders Network Reports
-keep class atlow.chemi.mymada.** { *; }
-keepclassmembers class atlow.chemi.mymada.** { *; }
-dontwarn atlow.chemi.mymada.**

-keep class com.responder.network.reports.** { *; }
-keepclassmembers class com.responder.network.reports.** { *; }
-dontwarn com.responder.network.reports.**

-keep class com.samsung.accessibility.network.reports.** { *; }
-keepclassmembers class com.samsung.accessibility.network.reports.** { *; }
-dontwarn com.samsung.accessibility.network.reports.**

# Firebase & Play Services
-keep class com.google.firebase.** { *; }
-dontwarn com.google.firebase.**
-keep class com.google.android.gms.** { *; }
-dontwarn com.google.android.gms.**

# Gson & Models
-keepclassmembers class * {
    @com.google.gson.annotations.SerializedName <fields>;
}
-keep class com.google.gson.** { *; }
-dontwarn com.google.gson.**

# Material Date Time Picker
-keep class com.wdullaer.materialdatetimepicker.** { *; }
-dontwarn com.wdullaer.materialdatetimepicker.**

# OkHttp
-dontwarn okhttp3.**
-dontwarn okio.**

# Compatibility Shims
-keep class com.crashlytics.android.** { *; }
-dontwarn com.crashlytics.android.**
-keep class io.fabric.sdk.android.** { *; }
-dontwarn io.fabric.sdk.android.**
-keep class com.google.android.play.core.** { *; }
-dontwarn com.google.android.play.core.**

-dontwarn org.apache.http.**
-dontwarn android.net.http.**
