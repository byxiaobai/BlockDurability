package pers.blockdurability;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import pers.blockdurability.data.DurabilityManager;
import pers.blockdurability.listeners.PlayerListener;
import pers.blockdurability.runnable.BlockStateUpdater;
import pers.blockdurability.utils.PacketUtil;
import pers.byxiaobai.diedays.api.managers.config.Config;
import pers.byxiaobai.diedays.api.managers.config.ConfigManager;

public class BlockDurability extends JavaPlugin{
	
	private static BlockDurability plugin;
	
	@Override
	public void onEnable() {
		setPlugin(this);
		Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
		BlockStateUpdater updater=new BlockStateUpdater();
		Config config=ConfigManager.INSTANCE.getConfig("config.yml");
		updater.runTaskTimer(this, 1, (long)(20*config.getConfigYaml().getDouble("UpdateTime")));
		getLogger().info("插件加载完毕");
	}
	
	@Override
	public void onDisable() {
		getLogger().info("插件已卸载");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	    if (label.equalsIgnoreCase("blockdur")){
	    	if(sender instanceof Player) {
	    	   Player player = (Player)sender;
	    	   if(args.length==1) {
	    		   int dur=Integer.parseInt(args[0]);
	    		   Block block=player.getTargetBlock(10);
	    		   if(block!=null) {
	    			   DurabilityManager.INSTANCE.setBlockDurability(block, dur);
	    		   }
	    		   player.sendMessage("§a设置成功！!");
	    	   }else {
	    		   player.sendMessage("§c指令输入错误");
	    	   }
	    	   return true;
	    	}else {
	    		sender.sendMessage("本指令为玩家专用指令");
	    	}
	    }
	    return false;
	}

	public static BlockDurability getPlugin() {
		return plugin;
	}

	public static void setPlugin(BlockDurability plugin) {
		BlockDurability.plugin = plugin;
	}
	
}
