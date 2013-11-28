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

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.h2.tools.Server;


/**
 * Starts an instance of h2 server based on the <code>args</code>
 * configuration parameters.
 */
public class H2Start extends AbstractMojo {

    /**
     * H2 Database connection string for a tcp based connection.
     */
    private String[] args;

    @SuppressWarnings("unchecked")
    public void execute() throws MojoExecutionException, MojoFailureException {
        List<String> argList = Arrays.asList(args);

        try {
            Server server = H2Utils.startServer(args);
            getPluginContext().put("server", server);
            getLog().info("Started H2 Server : " + argList);
        } catch (SQLException e) {
            throw new MojoExecutionException(
                "Could not start h2 server with connection string: " + argList, e);
        }
    }

}
