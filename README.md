PrefsPliers
===============

[![](https://jitpack.io/v/phantomVK/PrefsPliers.svg)](https://jitpack.io/#phantomVK/PrefsPliers)

[中文版README](./README_CN.md)

A library that fixed Android ANR caused by tasks which commited (mainly from SharedPreferences) to android.app.QueuedWork.

Available from Android 4.1 to Android 11.



Download
-----------

You can download the dependency from __JitPack__ using __Gradle__.

```groovy
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}

dependencies {
  implementation 'com.github.phantomVK:PrefsPliers:latest'
}
```



Usage
-------

```kotlin
try {
  PrefsPliers.init()
} catch(e: Exception) {
}
```



License
--------

```
Copyright 2021 WenKang Tan(phantomVK)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```