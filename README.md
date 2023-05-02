# Regionous

[![](https://jitpack.io/v/PartlySunnyDev/Regionous.svg)](https://jitpack.io/#PartlySunnyDev/Regionous)
![](https://img.shields.io/github/languages/top/PartlySunnyDev/Regionous)
![](https://img.shields.io/github/v/release/PartlySunnyDev/Regionous)
![](https://img.shields.io/github/stars/PartlySunnyDev/Regionous?style=social)

## Easy regions and areas API for your Spigot plugins

Event based, hooks into WorldEdit and WorldGuard, and supports dynamic and static shapes

### Features

- [x] Easy creation of regions and areas
- [x] Events for entering and leaving regions and areas
- [x] Hooks into WorldEdit and WorldGuard

### Setup

1. Add the jitpack repository to your pom.xml

```xml

<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url> <!-- Add this repository -->
    </repository>
</repositories>
```

2. Add the dependency to your pom.xml

```xml

<dependencies>
    <dependency>
        <groupId>com.github.PartlySunnyDev</groupId>
        <artifactId>Regionous</artifactId>
        <version>VERSION</version> <!-- Add this dependency -->
    </dependency>
</dependencies>
```

3. Shade the dependency into your plugin

```xml

<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-shade-plugin</artifactId> <!-- Add this plugin -->
            <version>3.2.4</version>
            <configuration>
                <relocations>
                    <relocation>
                        <pattern>me.partlysunny.regionous</pattern>
                        <shadedPattern>your.plugin.package.regionous</shadedPattern> <!-- Add this relocation -->
                    </relocation>
                </relocations>
            </configuration>
        </plugin>
    </plugins>
</build>
```