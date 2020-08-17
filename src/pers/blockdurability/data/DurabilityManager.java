package pers.blockdurability.data;

import java.util.Collection;
import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.block.Block;

import com.comphenix.protocol.events.PacketContainer;

import pers.blockdurability.utils.PacketUtil;

public class DurabilityManager {
	public static final DurabilityManager INSTANCE=new DurabilityManager();
	private HashMap<Location,PacketContainer> packetMap=new HashMap<>();
	
	public void setBlockDurability(Block block,int dur) {
		PacketContainer packet=PacketUtil.sendBreakAnimationPacket(1, block, dur);
		packetMap.put(block.getLocation(), packet);
	}
	
	public Collection<PacketContainer> getSendedPackets() {
		return packetMap.values();
	}
	
}
