/*
 * Copyright 2011-2019 GatlingCorp (https://gatling.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.gatling.commons.util

import java.util.Locale

object Platform {

  val OsName: String = System.getProperty("os.name")

  def isLinux: Boolean = OsName.toLowerCase(Locale.US).startsWith("linux")

  val JavaMajorVersion = {
    val javaVersionSystemProp = System.getProperty("java.version")
    val majorVersionString =
      if (javaVersionSystemProp.startsWith("1.")) {
        // up to java 8
        val index = javaVersionSystemProp.indexOf('.', 2)
        javaVersionSystemProp.substring(2, index)
      } else {
        val index = javaVersionSystemProp.indexOf('.')
        if (index == -1) {
          javaVersionSystemProp
        } else {
          javaVersionSystemProp.substring(0, index)
        }
      }
    majorVersionString.toInt
  }
}
