plugins {
    id("java")
}


group = "org.example"
version = "2.0.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(project(":UICustom"))
    implementation(project(":ScoreSaver"))
    implementation(project(":Main"))
}


tasks.test {
    useJUnitPlatform()
}