Android testing
============================================================================
## Coroutine test
```kotlin
// test rule
@ExperimentalCoroutinesApi
class MainCoroutineRule(val dispatcher: TestDispatcher = StandardTestDispatcher()):
    TestWatcher() {
    override fun starting(description: Description) {
        super.starting(description)
        Dispatchers.setMain(dispatcher)
    }

    override fun finished(description: Description) {
        super.finished(description)
        Dispatchers.resetMain()
    }
}


@ExperimentalCoroutinesApi
@get:Rule
var mainCoroutineRule = MainCoroutineRule()

fun scope_test_in_object() {
    // coroutine blocking
    mainCoroutineRule.dispatcher.scheduler.advanceUntilIdle()
    
    ...
    
    // coroutine resume
    mainCoroutineRule.dispatcher.scheduler.runCurrent()
}

fun coroutine_test() = runTest(mainCoroutineRule.dispatcher) {

}
```



## Mockito Fragment
```kotlin
val scenario = launchFragmentInContainer<TestFragment>(Bundle(), R.style.AppTheme)

val navController = mock(NavController::class.java)

scenario.onFragment {
    Navigation.setViewNavController(it.view!!, navController)
}

verify(navController).navigate(
        TestFragmentDirections.actionTestFragmentToTestDetailFragment( "id1")
    )
```


## Espresso
Static Espresso method : onView, onData<br />
ViewMatcher : withId<br />
ViewAction : perform<br />
ViewAssertion : check<br />
```kotlin
onView(withId(R.id.task_detail_complete_checkbox)).perform(click()).check(matches(isChecked()))
```

## Fragment test
Fragment로 전달되는 Bundle을 만듭니다.<br />
launchFragmentInContainer함수로 번들과 테마를 주입하여 FragmentScenario를 만듭니다.
```kotlin
@MediumTest
@RunWith(AndroidJUnit4::class)
class TaskDetailFragmentTest {
    // use navigation
    val bundle = TestFragmentArgs(activeTask.id).toBundle()
    launchFragmentInContainer<TestFragment>(bundle, R.style.AppTheme)
}
```


## Test Doubles
```
Fake : 클래스의 동작만 구현하는 방법, 테스트에는 적합하나 프로덕션에는 부적합한 방식으로 구현되는 테스트 더블입니다.
Mock : 어떤 메서드가 호출되었을때 기대값을 호출하는 테스트 더블입니다. 그런 다음 메서드가 올바르게 호출되었는지 여부에 따라 테스트를 통과하거나 실패합니다.
```


## LiveData test
참조 getOrAwaitValue
<br/>
https://medium.com/androiddevelopers/unit-testing-livedata-and-other-common-observability-problems-bb477262eb04


## AndroidX test
```kotlin
@RunWith(AndroidJUnit4::class)
class TasksViewModelTest {
    // Test code
}

// use applicationContext
ApplicationProvider.getApplicationContext()
```


## Test Driven Development
```
Give, When, Then 구조를 사용하고 규칙을 따르는 이름으로 테스트를 작성합니다.
테스트 실패를 확인합니다.
테스트를 통과하도록 최소한의 코드를 작성하세요.
모든 테스트에 대해 반복하세요
```


## readable tests Given, When, Then
```
Given : 테스트에 필요한 객체나 앱의 상태를 설정
When : 테스트 중인 개체에 대한 실제 작업을 수행
Then : 테스트 실행여부를 통과 여부 확인
```


## Hamcrest
```kotlin
// REPLACE
assertEquals(result, 100f)
// WITH
assertThat(result, `is`(100f))
```


## source sets
```
main: 앱의 코드
androidTest : 계측 테스트 코드
test: 유닛 테스트
```

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
