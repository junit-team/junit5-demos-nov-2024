# junit5-demos-nov-2024
Demos for the IntelliJ IDEA Livestream in November 2024

## Standalone Console Launcher Playbook

Download executable JAR file from Maven Central:

```shell
curl --output junit.jar https://oss.sonatype.org/content/repositories/snapshots/org/junit/platform/junit-platform-console-standalone/1.12.0-SNAPSHOT/junit-platform-console-standalone-1.12.0-20241126.075817-258.jar
```

Display help message:

```shell
java -jar junit.jar --help
```

Show version of JUnit, Java, and the Operating System:

```shell
java -jar junit.jar --version
```

List test engines included in the standalone JAR file:

```shell
java -jar junit.jar engines
```

Compile classes.

```shell
./gradlew build
```

Discover containers and tests:

```shell
java @junit discover --scan-class-path
```

Execute all tests:

```shell
java @junit execute --scan-class-path
```

Show test feed:

```shell
java @junit execute --scan-class-path --details testfeed
```

Dry-run via system property in `junit` argfile:

```shell
java @junit execute --scan-class-path --details testfeed
```

No more colors, no more escaped control characters:

```shell
export NO_COLOR=1
java @junit execute --scan-class-path --details testfeed
```
