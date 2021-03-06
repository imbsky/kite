plugins {
  `module-config`
  id("com.android.library")
  kotlin("android")
  id("com.vanniktech.maven.publish")
  `artifactory-publish-config`
  `bintray-publish-config`
}

dependencies {
  api(project(":kite-core"))

  api(Kotlin.stdlib.jdk8)

  api(Airbnb.epoxy)

  testImplementation(project(":androidtestcommon"))
}
