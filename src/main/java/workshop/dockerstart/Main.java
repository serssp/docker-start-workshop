package workshop.dockerstart;

import io.prometheus.client.exporter.HTTPServer;
import io.prometheus.client.hotspot.DefaultExports;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            readLines(args[0]);
        }
        exposeMetrics();
    }

    private static void readLines(String dir) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(dir + "/my-file.txt"));
        System.out.println("MyFile lines=" + lines.size());
        for (String line : lines) {
            System.out.println("> " + line);
        }
    }

    private static void exposeMetrics() throws IOException {
        DefaultExports.initialize();
        new HTTPServer(80);
    }
}
