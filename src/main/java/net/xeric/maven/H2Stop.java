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

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.h2.tools.Server;

/**
 * Stops running h2 instance instantiated by {@link H2Start}.
 *
 * @goal h2-stop
 * @phase post-integration-test
 */
public class H2Stop extends AbstractMojo {

    public void execute() throws MojoExecutionException, MojoFailureException {
        Server server = (Server) getPluginContext().get("server");
        if (server != null) {
            server.stop();
            getLog().info("Stopped H2 server");
        }
    }

}

