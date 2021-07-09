package com.phantomvk.prefspliers.library;

import java.util.LinkedList;

class LinkedListProxy extends LinkedList<Runnable> {

  private final LinkedList<Runnable> finishers;

  LinkedListProxy(LinkedList<Runnable> list) {
    finishers = list;
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
