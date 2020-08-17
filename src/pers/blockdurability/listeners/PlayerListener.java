package pers.blockdurability.listeners;

import java.lang.reflect.InvocationTargetException;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketContainer;

import pers.blockdurability.data.DurabilityManager;

public class PlayerListener implements Listener{
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent evt) {
		Player player=evt.getPlayer();
		try {
		for(PacketContainer packet:DurabilityManager.INSTANCE.getSendedPackets()) {
			ProtocolLibrary.getProtocolManager().sendServerPacket(player,packet);
		}
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
