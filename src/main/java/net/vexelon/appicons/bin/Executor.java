package net.vexelon.appicons.bin;

import net.vexelon.appicons.AbstractBuilder;
import net.vexelon.appicons.AppIcons;
import net.vexelon.appicons.BuilderConfig;
import net.vexelon.appicons.appstore.AppStoreBuilder;
import net.vexelon.appicons.wireframe.BioDownloader;
import net.vexelon.appicons.wireframe.entities.IconURL;
import picocli.CommandLine;

import java.nio.file.Path;
import java.util.Set;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "app-icons-bin", version = "1.0", mixinStandardHelpOptions = true)
public class Executor implements Callable<Integer> {

//    @CommandLine.Option(names = {"-h", "--help"}, usageHelp = true, description = "Shows help")
//    boolean isShowHelp = false;

    @CommandLine.Option(names = {"-s", "--store"}, required = true,
            description = "Store type: ${COMPLETION-CANDIDATES}")
    StoreType storeType = null;

    @CommandLine.Option(names = {"-a", "--apps"},
            description = "One ore more app identifiers separated by commas, e.g., 389801252 or com.instagram.android.")
    Set<String> appIds;

    @CommandLine.Option(names = {"-o", "--out"}, description = "Output path where the app icons will be saved to")
    String outputPath = ".";

    @CommandLine.Option(names = {"-u", "--urls"}, description = "Only shows icon URLs and does not download any files")
    boolean isUrlOnly = false;

    public void download(BioDownloader downloader) {
        if (isUrlOnly) {
            var result = downloader.getMultiUrls(appIds).values();
            if (result.isEmpty()) {
                System.err.println("No apps found for the ids specified.");
            } else {
                result.stream().flatMap(url -> url.stream()).map(IconURL::getUrl).forEach(System.out::println);
            }
        } else {
            var destination = Path.of(outputPath);
            var total = downloader.getMultiFiles(appIds, destination).entrySet().stream().mapToLong(entry ->
                    entry.getValue().size()).sum();
            System.out.println(total + " icon files downloaded to " + destination.toAbsolutePath().toString());
        }
    }

    @Override
    public Integer call() throws Exception {
        try {
            AbstractBuilder<?> builder;

            switch (storeType) {
                case APPSTORE:
                    builder = AppIcons.appstore();
                    break;

                case PLAYSTORE:
                    builder = AppIcons.playstore();
                    break;

                default:
                    return -1;
            }

            download(builder.namingStrategy(BuilderConfig.NamingStrategy.APPID_AND_SIZE).build());

            return 0;
        } catch (Throwable t) {
            System.err.println(t.getLocalizedMessage());
//            t.printStackTrace();
        }

        return -1;
    }
}
