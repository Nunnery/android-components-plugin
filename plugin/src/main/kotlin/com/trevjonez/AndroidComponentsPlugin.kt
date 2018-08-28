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

package com.trevjonez

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.internal.attributes.ImmutableAttributesFactory
import javax.inject.Inject

@Suppress("unused")
class AndroidComponentsPlugin
@Inject constructor(
    private val attributesFactory: ImmutableAttributesFactory
) : Plugin<Project> {

  override fun apply(project: Project) {
    project.pluginManager.withPlugin("com.android.library") {
      addExtension(project)
      project.pluginManager.apply(AndroidLibraryComponentsPlugin::class.java)
    }
    project.pluginManager.withPlugin("com.android.application") {
      addExtension(project)
      TODO()
    }
    project.pluginManager.withPlugin("com.android.test") {
      addExtension(project)
      TODO()
    }
    project.afterEvaluate {
      extensions.findByType(AndroidComponentsExtension::class.java)
          ?: throw IllegalStateException("No valid android plugin found on project: $path")
    }
  }

  private fun addExtension(project: Project) {
    project.extensions.create(
        "androidComponents", AndroidComponentsExtension::class.java
    )
  }
}
