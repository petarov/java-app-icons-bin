package net.vexelon.appicons.bin;

import picocli.CommandLine;

public class Main {

    public static void main(String[] args) {
        var exitCode = new CommandLine(new Executor()).execute(args);
//        if (exitCode != 0 && exitCode != 2) {
//            System.exit(exitCode);
//        }
    }
}
