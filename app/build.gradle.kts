plugins {
    id("java")
    id ("application")
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.3"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

application {
    // Входная точка
    mainClass.set("hexlet.code.App")
}

tasks.test {
    useJUnitPlatform()
}