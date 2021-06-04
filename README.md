# UID8
## UID System

UID8 is a uid creation system which the creation date can be parsed.
Useful for some applications which requires the creation date for a user (example)

## Install

Gradle
```groovy
repositories {
    mavenCentral()
    maven { url "https://jitpack.io" }
}

dependencies {
    implementation 'com.github.8ML:UID8:main-SNAPSHOT'
}
```

# Usage

```java

//Create UID | Returns new UID8 instance
UID8 uid = new UID8();

//Get creation epoch | Returns Long
uid.getCreationEpoch();

//Get creation date formatted | Returns String
uid.getCreationDate("dd/MM/YY");

//Parse existing uid to get its creation info | Returns UID8 instance
UID8 uid = UID8.parse(stringOfUid); 

```
