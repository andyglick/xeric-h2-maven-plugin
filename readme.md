h2-maven-plugin
=================

Introduction
------------
A maven plugin to start and stop an [h2](http://www.h2database.com/) instance. It creates a tcp based instance which can be configured using `args`.

Configuration
--------------
Add the following to your pom.xml under build->plugins tag.

    ::::xml
    <build>
        ...
        <plugins>
            <plugin>
                <groupId>net.xeric.maven</groupId>
                <artifactId>h2-maven-plugin</artifactId>
                <version>1.0-SNAPSHOT</version>
               <configuration>
                    <args>
                        <arg>-tcp</arg>
                        <arg>-tcpAllowOthers</arg>
                        <arg>-tcpPort</arg>
                        <arg>5555</arg>
                    </args>
                </configuration>
                <executions>
                    <execution>
                        <phase>pre-integration-test</phase>
                        <goals>
                            <goal>h2-start</goal>
                        </goals>
                    </execution>
                    <execution>
                        <phase>post-integration-test</phase>
                        <goals>
                            <goal>h2-stop</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    <build>        
    <pluginRepositories>
        <pluginRepository>
            <id>sonatype-nexus-snapshots</id>
            <url>https://oss.sonatype.org/content/repositories/snapshots</url>
        </pluginRepository>
    </pluginRepositories>

If phases are not specified, the default phases are chosen.

Goals
-----

#### h2-start
Starts an h2 instance. This goal is bound to `pre-integration-test` phase by default.

#### h2-stop
Stops the h2 instance started by `h2-start` goal. This goal is bound to `post-integration-test` by default.

#### help
Displays help.

Example
--------
Checkout a simple example in the test folder.

References
----------
1. [Writing a custom plugin](http://books.sonatype.com/mvnref-book/reference/writing-plugins-sect-custom-plugin.html) from Maven: The complete reference.
2. [H2 Tutorial](http://www.h2database.com/html/tutorial.html)




 
