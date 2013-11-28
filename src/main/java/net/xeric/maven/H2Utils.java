// Copyright 2013 Xeric Corporation
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http:// www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

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
