/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlemail.mcdjuady.nbttest;

import me.dpohvar.powernbt.PowerNBT;
import me.dpohvar.powernbt.api.NBTCompound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Max
 */
public class NBTTest extends JavaPlugin {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("nbttest") && (sender instanceof Player)) {
            NBTCompound main = PowerNBT.getApi().read(PowerNBT.getApi().asCraftItemStack(((Player)sender).getItemInHand()));
            NBTCompound cmpd = main.compound("TestCompound");
            cmpd.put("test", false);
            PowerNBT.getApi().write(((Player)sender).getItemInHand(), main);
            return true;
        }
        return false;
    }

}
