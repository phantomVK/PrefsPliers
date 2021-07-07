package com.phantomvk.prefspliers.library;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;

import android.annotation.SuppressLint;
import android.os.Build;

@SuppressWarnings({"unchecked", "SynchronizationOnLocalVariableOrMethodParameter"})
@SuppressLint("PrivateApi")
public class PrefsPliers {

  /**
   * Init PrefsPliers and injects proxy containers to class android.app.QueuedWork to avoid ANR.
   *
   * @throws Exception see {@link ClassNotFoundException}, {@link SecurityException}, {@link NoSuchFieldException},
   *                   {@link IllegalArgumentException}, {@link IllegalAccessException}
   */
  public static void init() throws Exception {
    if (Build.VERSION.SDK_INT >= 26) {
      initAPI26();
    } else {
      initAPI16();
    }
  }

  /**
   * Available from Android4.1(API16) to Android7.1(API25)
   */
  private static void initAPI16() throws Exception {
    Class<?> clazz = Class.forName("android.app.QueuedWork");

    Field field = clazz.getDeclaredField("sPendingWorkFinishers");
    field.setAccessible(true);
    Object object = new ConcurrentLinkedQueueProxy((ConcurrentLinkedQueue<Runnable>) field.get(null));

    field.set(null, object);
  }

  /**
   * Available since Android8.0(API26).
   */
  private static void initAPI26() throws Exception {
    Class<?> clazz = Class.forName("android.app.QueuedWork");

    Field sLock = clazz.getDeclaredField("sLock");
    sLock.setAccessible(true);
    Object lock = sLock.get(null);

    if (lock != null) {
      Field field = clazz.getDeclaredField("sFinishers");
      field.setAccessible(true);
      Object o = new LinkedListProxy((LinkedList<Runnable>) field.get(null));

      synchronized (lock) {
        field.set(null, o);
      }
    }
  }
}
