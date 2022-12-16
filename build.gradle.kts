plugins {
    application
}

application {
    mainClass.set("App")
}

sourceSets {
    main {
        java {
            setSrcDirs(listOf("src"))
        }
    }
}