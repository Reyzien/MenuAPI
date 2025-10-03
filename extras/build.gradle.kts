repositories {
    maven("https://repo.codemc.io/repository/nms/")
}

dependencies {
    compileOnly(project(":core"))
    compileOnly("org.spigotmc:spigot:1.8.8-R0.1-SNAPSHOT")
    implementation("com.github.cryptomorin:XSeries:13.4.0")
}