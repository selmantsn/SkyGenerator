# SkyGenerator
SkyGenerator Library

Step 1. Add the JitPack repository to your build file

    
 If you are using Gradle 6.8 or newer add these lines in settings.gradle
 
     dependencyResolutionManagement {
        repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
        repositories {
            google()
            mavenCentral()
            maven { url 'https://jitpack.io' }
        }
    }

If you are using older than Gradle 6.8 add these lines in build.gradle (Project)

    allprojects {
      repositories {
        maven { url 'https://jitpack.io' }
      }
    }

  
Step 2. Add the dependency

    dependencies {
            implementation 'com.github.selmantsn:SkyGenerator:Tag'
    }

Step 3. Use this line
  
  SkyGenerator().addStarInterface(this)

