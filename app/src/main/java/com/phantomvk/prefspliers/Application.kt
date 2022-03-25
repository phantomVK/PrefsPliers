package com.phantomvk.prefspliers

import com.phantomvk.prefspliers.library.PrefsPliers

class Application : android.app.Application() {

  override fun onCreate() {
    super.onCreate()

    try {
      PrefsPliers.init()
    } catch (t: Throwable) {
      // https://developer.android.com/guide/app-compatibility/restrictions-non-sdk-interfaces
      t.printStackTrace()
    }
  }
}