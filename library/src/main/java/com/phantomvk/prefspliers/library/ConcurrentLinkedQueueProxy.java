package com.phantomvk.prefspliers.library;

import java.util.concurrent.ConcurrentLinkedQueue;

class ConcurrentLinkedQueueProxy extends ConcurrentLinkedQueue<Runnable> {

  private final ConcurrentLinkedQueue<Runnable> finishers;

  ConcurrentLinkedQueueProxy(ConcurrentLinkedQueue<Runnable> queue) {
    finishers = queue;
  }

  @Override
  public boolean add(Runnable runnable) {
    return finishers.add(runnable);
  }

  @Override
  public boolean remove(Object o) {
    return finishers.remove(o);
  }

  @Override
  public Runnable poll() {
    return null;
  }

  @Override
  public boolean isEmpty() {
    return true;
  }
}
