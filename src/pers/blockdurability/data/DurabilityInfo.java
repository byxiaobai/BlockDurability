package pers.blockdurability.data;

import com.comphenix.protocol.events.PacketContainer;

public class DurabilityInfo {
	private PacketContainer packet;
	private int durability;
	
	public DurabilityInfo(PacketContainer packet,int durability) {
		this.packet=packet;
		this.durability=durability;
	}

	public PacketContainer getPacket() {
		return packet;
	}

	public void setPacket(PacketContainer packet) {
		this.packet = packet;
	}

	public int getDurability() {
		return durability;
	}

	public void setDurability(int durability) {
		this.durability = durability;
	}
}
