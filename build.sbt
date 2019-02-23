/**
 * Licensed to the Minutemen Group under one or more contributor license
 * agreements. See the COPYRIGHT file distributed with this work for
 * additional information regarding copyright ownership.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you
 * may not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import sbt._

lazy val buildVersions = taskKey[Unit]("Show some build versions")

lazy val `silhouette-play-http` = project in file("modules/http")
lazy val `silhouette-play-action` = (project in file("modules/action"))
  .dependsOn(
    `silhouette-play-http`
  )

lazy val `silhouette-play` = (project in file("."))
  .aggregate(
    `silhouette-play-http`,
    `silhouette-play-action`
  ).settings(
  publish := {},
  buildVersions := {
    // scalastyle:off println
    println(s"PROJECT_VERSION ${version.value}")
    println(s"SCALA_VERSION ${scalaVersion.value}")
    // scalastyle:on println
  }
)
