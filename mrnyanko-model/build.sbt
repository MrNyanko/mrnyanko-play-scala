name := "mrnyanko-model"

val slickVersion = "3.2.1"

libraryDependencies ++= Seq(
    "com.typesafe" % "config" % "1.3.0",
    "com.typesafe.slick" %% "slick" % slickVersion,
    "com.typesafe.slick" %% "slick-codegen" % slickVersion,
    "org.slf4j" % "slf4j-nop" % "1.7.19",
    "mysql" % "mysql-connector-java" % "5.1.38"
)

