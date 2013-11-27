package net.xeric.maven;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.h2.tools.Server;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * Starts an instance of h2 server based on the <code>args</code>
 * configuration parameters.
 *
 * @goal h2-start
 * @phase pre-integration-test
 */
public class H2Start extends AbstractMojo {

    /**
     * H2 Database connection string for a tcp based connection.
     * @parameter
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
