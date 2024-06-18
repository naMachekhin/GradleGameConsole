plugins {
    id("application")
}

application {
    mainClass = "org.example.Main"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(project(":UICustom"))
    implementation(project(":ScoreSaver"))
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}

tasks.register("CheckSaveFilePresence") {
    val path="../ScoreSaver/src/main/resources/Score.txt"
    doLast {
        val file = file(path)
        if (file.exists())
            println("Score file exists, check is successful.")
        else
            println("Error, cannot find score file!")
    };
}

tasks.register("EnshureCleanScoreboard") {
    val path="../ScoreSaver/src/main/resources/Score.txt"
    val new_path="../ScoreSaver/src/main/resources/Old_Score.txt"
    val file = file(path)
    if(!file.exists()) {
        file.writeText("")
        println("Crated new empty score file")
    }
    else
    {
        val new_file=file(new_path)
        if(new_file.exists()) new_file.delete()
        println("Deleted previous old score")
        file.renameTo(new_file)
        file.writeText("")
        println("Crated new empty score file")
    }
}


tasks.test {
    useJUnitPlatform()
}