package com.hinaplugin.randomnumbergenerator.randomnumbergenerator;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class Commands implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 3){
            if (isNumeric(args[0]) || isNumeric(args[1])){
                sender.sendMessage(ChatColor.RED + "usage: /rng <range1> <range2> <count>");
                return true;
            }

            int range1 = Integer.parseInt(args[0]);
            int range2 = Integer.parseInt(args[1]);
            int count = Integer.parseInt(args[2]);
            final StringBuilder builder = new StringBuilder();
            if (range1 <= range2){
                for (int i = 0; i < count; i++){
                    final Random random = new Random();
                    final int answer = random.nextInt((range2 - range1) + 1) + range1;
                    builder.append(answer);
                    if (i != count - 1){
                        builder.append(", ");
                    }
                }
                sender.sendMessage(ChatColor.GREEN + String.valueOf(range1) + "から" + range2 + "までの範囲で" + count + "回生成しました．");
            }else {
                for (int i = 0; i < count; i++){
                    final Random random = new Random();
                    final int answer = random.nextInt((range1 - range2) + 1) + range2;
                    builder.append(answer);
                    if (i == count - 1){
                        builder.append(", ");
                    }
                }
                sender.sendMessage(ChatColor.GREEN + String.valueOf(range2) + "から" + range1 + "までの範囲で" + count + "回生成しました．");
            }
            sender.sendMessage(builder.toString());
            return true;
        }
        sender.sendMessage(ChatColor.RED + "usage: /rng <range1> <range2> <count>");
        return true;
    }

    private boolean isNumeric(String number){
        return !number.chars().allMatch(Character::isDigit);
    }
}
