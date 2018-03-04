name := "mrnyanko-play-scala"

lazy val commonSetting = Seq(
    organization := "mr.nyanko",
    version := "1.0.0-SNAPSHOT",
    scalaVersion := "2.12.4"
)

lazy val `mrnyanko-play-scala` = project in file(".") settings (commonSetting: _*)

lazy val `mrnyanko-model` = project in file("mrnyanko-model") settings (commonSetting: _*)

lazy val `mrnyanko-common` = project in file("mrnyanko-common") settings(commonSetting: _*)

lazy val `mrnyanko-web` = project in file("mrnyanko-web") settings(commonSetting: _*) enablePlugins PlayScala dependsOn (`mrnyanko-model`,`mrnyanko-common`)
