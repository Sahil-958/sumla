# Add project-specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /home/sawhill/Android/Sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.

# Mumla specific rules
-keep class se.lublin.humla.** { *; }
-keep class se.lublin.mumla.** { *; }

# SpongyCastle
-keep class org.spongycastle.** { *; }
-dontwarn org.spongycastle.**

# Protobuf
-keep class com.google.protobuf.** { *; }

# Jsoup
-keep class org.jsoup.** { *; }

# Guava
-dontwarn com.google.common.**
-keep class com.google.common.** { *; }

# Android support / AndroidX
-keep class androidx.** { *; }
-dontwarn androidx.**

# JNI
-keepclasseswithmembernames class * {
    native <methods>;
}
