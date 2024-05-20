package com.hanshan.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

@Command(name = "ASCIIArt", version = "ASCIIArt 1.0", mixinStandardHelpOptions = true)
public class Login implements Callable<Integer> {

    @Option(names = {"-u", "--username"}, description = "用户名")
    String username = "hanshan";

    @Option(names = {"-p", "--password"}, description = "密码", interactive = true)
    String password = "1234qwer";

    @Override
    public Integer call() throws Exception {
        System.out.println("password = " + password);
        return 0;
    }

    public static void main(String[] args) {
        new CommandLine(new Login()).execute("-u", "zhangsan", "-p");
    }
}
