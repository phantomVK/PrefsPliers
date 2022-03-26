PrefsPliers
===============

[![](https://jitpack.io/v/phantomVK/PrefsPliers.svg)](https://jitpack.io/#phantomVK/PrefsPliers)

治理提交到 android.app.QueuedWork  (主要来自SharedPreferences) 任务而引起的ANR.

支持 Android 4.1 到 Android 11.



下载
-----------

通过 __Gradle__ 从 __JitPack__ 下载.

```groovy
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}

dependencies {
  implementation "com.github.phantomVK:PrefsPliers:latest.release"
}
```



用法
-------

```kotlin
try {
  PrefsPliers.init()
} catch(e: Exception) {
}
```



许可证
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