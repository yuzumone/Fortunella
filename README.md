# Fortunella
[![License](https://img.shields.io/badge/license-Apache%202-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)
[![JitPack](https://img.shields.io/badge/jitpack-1.0.0-brightgreen.svg)](https://jitpack.io/#yuzumone/Fortunella/)
[![BuildStatus](https://travis-ci.org/yuzumone/Fortunella.svg?branch=master)](https://travis-ci.org/yuzumone/Fortunella)

## Gradle
### Repository
Add this to your root `build.gradle` file.
```gradle
allprojects {
    repositories {
         ...
         maven { url 'https://jitpack.io' }
    }
}
```

### Dependency
Add this to your app `build.gradle` file.
```gradle
dependencies {
    ...
    implementation 'com.github.yuzumone:Fortunella:1.0.0'
}
```

## Example
```kotlin
class ExampleUseCase : UseCase<Unit, String>() {
    override suspend fun run(params: Unit) = "ok"
}
```
```kotlin
useCase(Unit) {
    when (it) {
        is Success -> hoge = it.value
        is Filure -> error = it.reason
    }
}
```

## License
```
Copyright 2018 yuzumone

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
