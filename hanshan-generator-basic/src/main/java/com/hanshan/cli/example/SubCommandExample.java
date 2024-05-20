package com.hanshan.cli.example;

import picocli.CommandLine;

import picocli.CommandLine.Command;

@Command(name = "main", mixinStandardHelpOptions = true)
public class SubCommandExample implements Runnable {

    @Override
    public void run() {
        System.out.println("执行主命令");
    }

    @Command(name = "add", mixinStandardHelpOptions = true)
    static class AddCommand implements Runnable {

        @Override
        public void run() {
            System.out.println("执行添加命令");
        }
    }

    @Command(name = "delete", mixinStandardHelpOptions = true)
    static class DeleteCommand implements Runnable {

        @Override
        public void run() {
            System.out.println("执行删除命令");
        }
    }

    @Command(name = "query", mixinStandardHelpOptions = true)
    static class QueryCommand implements Runnable {

        @Override
        public void run() {
            System.out.println("执行查询命令");
        }
    }

    public static void main(String[] args) {
        //String[] myArgs = new String[] {};
        //String[] myArgs = new String[] {"-h"};
        //String[] myArgs = new String[] {"add"};
        //String[] myArgs = new String[] {"add", "-h"};
        //String[] myArgs = new String[] {"delete"};
        String[] myArgs = new String[] {"update"};
        int exitCode = new CommandLine(new SubCommandExample())
                .addSubcommand(new AddCommand())
                .addSubcommand(new DeleteCommand())
                .addSubcommand(new QueryCommand())
                .execute(myArgs);
        System.exit(exitCode);
    }
}
