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

