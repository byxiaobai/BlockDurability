package pers.blockdurability.runnable;

import java.lang.reflect.InvocationTargetException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketContainer;

import pers.blockdurability.data.DurabilityManager;

public class BlockStateUpdater extends BukkitRunnable{

	@Override
	public void run() {
		try {
		for(Player player:Bukkit.getOnlinePlayers()) {
			for(PacketContainer packet:DurabilityManager.INSTANCE.getSendedPackets()) {
				ProtocolLibrary.getProtocolManager().sendServerPacket(player,packet);
			}
		}
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
