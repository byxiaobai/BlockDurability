package pers.blockdurability.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.block.Block;

import com.comphenix.protocol.events.PacketContainer;

import pers.blockdurability.utils.PacketUtil;

public class DurabilityManager {
	public static final DurabilityManager INSTANCE=new DurabilityManager();
	private HashMap<Location,DurabilityInfo> packetMap=new HashMap<>();
	
	public void setBlockDurability(Block block,int dur) {
		PacketContainer packet=PacketUtil.sendBreakAnimationPacket(1, block, dur);
		if(dur>9||dur<0)dur=-1;
		packetMap.put(block.getLocation(), new DurabilityInfo(packet,dur));
	}
	
	public int getBlockDurability(Block block) {
		if(block==null)return -1;
		DurabilityInfo info=packetMap.get(block.getLocation());
		return info==null?-1:info.getDurability();
	}
	
	public DurabilityInfo getBlockDurabilityInfo(Block block) {
		if(block==null)return null;
		return packetMap.get(block.getLocation());
	}
	
	public Collection<PacketContainer> getSendedPackets() {
		List<PacketContainer> packets=new ArrayList<>();
		for(DurabilityInfo info:packetMap.values()) {
			packets.add(info.getPacket());
		}
		return packets;
	}
	
}
