package com.hanshan.cli;

import com.hanshan.cli.command.ConfigCommand;
import com.hanshan.cli.command.GenerateCommand;
import com.hanshan.cli.command.ListCommand;
import picocli.CommandLine;

import picocli.CommandLine.Command;

@Command(name = "hanshan", mixinStandardHelpOptions = true)
public class CommandExecutor implements Runnable {

    private final CommandLine commandLine;

    {
        commandLine = new CommandLine(this)
                .addSubcommand(new ConfigCommand())
                .addSubcommand(new GenerateCommand())
                .addSubcommand(new ListCommand());
    }

    @Override
    public void run() {
        //不输入子命令时，给出提示
        System.out.println("请输入具体命令，或输入 --help 查看命令帮助手册");
    }

    //执行命令
    public Integer doExecute(String[] args) {
        return commandLine.execute(args);
    }
}
