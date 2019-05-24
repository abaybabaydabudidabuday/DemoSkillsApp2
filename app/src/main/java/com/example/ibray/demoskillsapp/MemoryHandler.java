package com.example.ibray.demoskillsapp;


import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Debug;

public class MemoryHandler {

    private Activity activity;
    private long CRITICAL_MEMORY = 120;
    private long LOW_MEMORY = 80;

//    public MemoryHandler(Activity activity) {
//        this.activity = activity;
//    }

    public static String checkHeapSizeUsage() {
        final Runtime runtime = Runtime.getRuntime();
        final long usedMemInMB = (runtime.totalMemory() - runtime.freeMemory()) / 1048576L;
        final long maxHeapSizeInMB = runtime.maxMemory() / 1048576L;
        final long availHeapSizeInMB = maxHeapSizeInMB - usedMemInMB;
        String memory = "Memory usage RUNTIME: usedMem ---- " + usedMemInMB + "------ maxHeapSizeInMB: " + maxHeapSizeInMB + "------------ availHeapSizeInMB: " + availHeapSizeInMB;
//        System.out.println(memory);
//        double nativeHeapSize = Debug.getNativeHeapSize();
//        double nativeHeapFreeSize = Debug.getNativeHeapFreeSize();
//        double usedMemInBytes = nativeHeapSize - nativeHeapFreeSize;
//        double usedMemInPercentage = usedMemInBytes * 100 / nativeHeapSize;
//        System.out.println(text);
        return memory;
    }


    public static String checkMemoryUsage(Context context) {
        ActivityManager.MemoryInfo mi = new ActivityManager.MemoryInfo();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(context.ACTIVITY_SERVICE);
        activityManager.getMemoryInfo(mi);
        double availableMegs = mi.availMem / 0x100000L;
        double totalMegs = mi.totalMem / 0x100000L;
//Percentage can be calculated for API 16+
        double percentAvail = mi.availMem / (double) mi.totalMem * 100.0;
        String memTRAM = "Memory usage:  availableMegs -  " + availableMegs + "     ----   percentAvail: " + percentAvail + "------------ totalMegs -----" + totalMegs;
        return memTRAM;
    }


}

