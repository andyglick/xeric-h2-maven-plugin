h2-maven-plugin
=================

Introduction
------------
A maven plugin to start and stop an [h2](http://www.h2database.com/) instance. It creates a tcp based instance which can be configured using `args`.

Configuration
--------------
Add the following to your pom.xml under build/plugins/

    ::::xml
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

If phases are not specified, the default phases are chosen.

Goals
-----
| Goal    | Description                                    | Default Phase          |
|-----------------------------------------------------------------------------------|
| h2-start| Starts an h2 instance                          | pre-integration-test   |
| h2-stop | Stops the h2 instance started by h2-start goal | post-integration-test  |
| help    | Displays help                                  | N.A.                   |

Example
--------
Checkout a simple [example](/test)



 
