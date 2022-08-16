# SkyGenerator
SkyGenerator Library

Step 1. Add the JitPack repository to your build file

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

