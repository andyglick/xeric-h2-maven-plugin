package net.xeric.maven;

import org.h2.tools.Server;

import java.sql.SQLException;

public class H2Utils {

    public static Server startServer(String [] args) throws SQLException {
        Server server = Server.createTcpServer(args);
        server.start();
        return server;
    }

    public static void stopServer(Server server){
        server.stop();
    }

}
