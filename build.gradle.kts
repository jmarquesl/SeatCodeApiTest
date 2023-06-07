import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val slf4jVersion = "1.7.7"
val serenityCoreVersion = "2.0.19"
val junitVersion = "4.13.1"
val assertJVersion = "3.8.0"
val logbackVersion = "1.2.3"
val restAssuredVersion = "3.0.5"

plugins {
    java
    kotlin("jvm") version "1.8.0"
}

group = "com.seatcode"
version = "1.0-SNAPSHOT"

apply(plugin = "net.serenity-bdd.aggregator")

buildscript{
    repositories {
        mavenCentral()
        jcenter()
    }
    dependencies {
        classpath("net.serenity-bdd:serenity-gradle-plugin:2.2.1")
    }
}

repositories {
    mavenCentral()
}


dependencies {
    testImplementation ("net.serenity-bdd:serenity-core:${serenityCoreVersion}")
    testImplementation ( "net.serenity-bdd:serenity-junit:${serenityCoreVersion}")
    testImplementation ("net.serenity-bdd:serenity-screenplay:${serenityCoreVersion}")
    testImplementation ("net.serenity-bdd:serenity-screenplay-rest:${serenityCoreVersion}")
    testImplementation ("junit:junit:${junitVersion}")
    testImplementation ("org.assertj:assertj-core:${assertJVersion}")
    testImplementation ("net.serenity-bdd:serenity-cucumber:1.9.51")
    testImplementation ("io.rest-assured:json-schema-validator:$restAssuredVersion")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "11"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "11"
    }
}
repositories {
    mavenCentral()
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "11"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "11"
}