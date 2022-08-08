Android testing
============================================================================

## source sets
```
main: 앱의 코드
androidTest : 계측 테스트 코드
test: 유닛 테스트
```

## Hamcrest
```kotlin
// REPLACE
assertEquals(result, 100f)
// WITH
assertThat(result, `is`(100f))
```

## readable tests Given, When, Then
```
Given : 테스트에 필요한 객체나 앱의 상태를 설정
When : 테스트 중인 개체에 대한 실제 작업을 수행
Then : 테스트 실행여부를 통과 여부 확인
```

## Test Driven Development
```
Give, When, Then 구조를 사용하고 규칙을 따르는 이름으로 테스트를 작성합니다.
테스트 실패를 확인합니다.
테스트를 통과하도록 최소한의 코드를 작성하세요.
모든 테스트에 대해 반복하세요
```

## AndroidX test
```
@RunWith(AndroidJUnit4::class)
class TasksViewModelTest {
    // Test code
}

// use applicationContext
ApplicationProvider.getApplicationContext()
```

## LiveData test
참조 getOrAwaitValue
<br/>
https://medium.com/androiddevelopers/unit-testing-livedata-and-other-common-observability-problems-bb477262eb04




TO-DO Notes - Code for 5.1-5.3 Testing Codelab
============================================================================

Code for the Advanced Android Kotlin Testing Codelab 5.1-5.3

Introduction
------------

TO-DO Notes is an app where you to write down tasks to complete. The app displays them in a list.
You can then mark them as completed or not, filter them and delete them.

![App main screen, screenshot](screenshot.png)

This codelab has four branches, representing different code states:

* [starter_code](https://github.com/googlecodelabs/android-testing/tree/starter_code)
* [end_codelab_1](https://github.com/googlecodelabs/android-testing/tree/end_codelab_1)
* [end_codelab_2](https://github.com/googlecodelabs/android-testing/tree/end_codelab_2)
* [end_codelab_3](https://github.com/googlecodelabs/android-testing/tree/end_codelab_3)

The codelabs in this series are:
* [Testing Basics](https://codelabs.developers.google.com/codelabs/advanced-android-kotlin-training-testing-basics)
* [Introduction to Test Doubles and Dependency Injection](https://codelabs.developers.google.com/codelabs/advanced-android-kotlin-training-testing-test-doubles)
* [Survey of Testing Topics](https://codelabs.developers.google.com/codelabs/advanced-android-kotlin-training-testing-survey)


Pre-requisites
--------------

You should be familiar with:

* The Kotlin programming language, including [Kotlin coroutines](https://developer.android.com/kotlin/coroutines) and their interaction with [Android Jetpack components](https://developer.android.com/topic/libraries/architecture/coroutines).
* The following core Android Jetpack libraries: [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel),
 [LiveData](https://developer.android.com/topic/libraries/architecture/livedata),
  [Navigation Component](https://developer.android.com/guide/navigation) and 
  [Data Binding](https://developer.android.com/topic/libraries/data-binding).
* Application architecture, following the pattern from the [Guide to app architecture](https://developer.android.com/jetpack/docs/guide) and [Android Fundamentals codelabs](https://developer.android.com/courses/kotlin-android-fundamentals/toc).


Getting Started
---------------

1. Download and run the app.
2. Check out one of the codelabs mentioned above.

License
-------

Copyright 2019 Google, Inc.

Licensed to the Apache Software Foundation (ASF) under one or more contributor
license agreements.  See the NOTICE file distributed with this work for
additional information regarding copyright ownership.  The ASF licenses this
file to you under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License.  You may obtain a copy of
the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
License for the specific language governing permissions and limitations under
the License.
