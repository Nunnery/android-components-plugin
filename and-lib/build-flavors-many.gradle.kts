/*
 *    Copyright 2018 Trevor Jones
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

plugins {
  id("com.trevjonez.android-components")
  id("com.android.library")
  `maven-publish`
}

group = "com.trevjonez"
version = "0.1.0"

repositories {
  google()
  jcenter()
}

android {
  compileSdkVersion(28)
  defaultConfig {
    minSdkVersion(21)
    targetSdkVersion(28)
  }
  defaultPublishConfig("blueSquareRelease")
  flavorDimensions("color", "shape")
  productFlavors {
    create("red") {
      dimension = "color"
    }
    create("blue") {
      dimension = "color"
    }
    create("square") {
      dimension = "shape"
    }
    create("circle") {
      dimension = "shape"
    }
  }
}

dependencies {
  api("io.reactivex.rxjava2:rxjava:2.2.0")
  implementation("com.squareup.moshi:moshi:1.6.0")
}

publishing {
  repositories {
    maven {
      name = "buildDir"
      url = uri("${buildDir.absolutePath}/.m2")
    }
  }
}