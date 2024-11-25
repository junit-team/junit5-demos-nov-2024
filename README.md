# junit5-demos-nov-2024
Demos for the IntelliJ IDEA Livestream in November 2024

## Standalone Console Launcher

Download executable JAR file from Maven Central:

```shell
wget https://repo.maven.apache.org/maven2/org/junit/platform/junit-platform-console-standalone/1.11.3/junit-platform-console-standalone-1.11.3.jar
```

Display help message:

```shell
java -jar junit-platform-console-standalone-1.11.3.jar --help
```

Show version of JUnit, Java, and the Operating System:

```shell
java -jar junit-platform-console-standalone-1.11.3.jar --version
```

List test engines included in the standalone JAR file:

```shell
java -jar junit-platform-console-standalone-1.11.3.jar engines
```

Compile classes.

```shell
./gradlew build
```

```shell
java @junit discover --scan-class-path
```

```shell
java @junit execute --scan-class-path --dry-run
```

```shell
java @junit execute --scan-class-path --details testfeed
```

````shell
export NO_COLOR=1
```

No more colors, no more escaped control characters:

```shell
java @junit execute --scan-class-path --details testfeed
```
