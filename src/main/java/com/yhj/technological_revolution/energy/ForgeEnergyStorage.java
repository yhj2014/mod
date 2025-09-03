package com.yhj.technological_revolution.energy;

import net.minecraftforge.energy.EnergyStorage;

public class ForgeEnergyStorage extends EnergyStorage {
    
    public ForgeEnergyStorage(int capacity) {
        super(capacity);
    }
    
    public ForgeEnergyStorage(int capacity, int maxTransfer) {
        super(capacity, maxTransfer);
    }
    
    public ForgeEnergyStorage(int capacity, int maxReceive, int maxExtract) {
        super(capacity, maxReceive, maxExtract);
    }
    
    public ForgeEnergyStorage(int capacity, int maxReceive, int maxExtract, int energy) {
        super(capacity, maxReceive, maxExtract, energy);
    }
    
    // 允许外部修改能量存储
    public void setEnergy(int energy) {
        this.energy = energy;
    }
    
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    public void setMaxReceive(int maxReceive) {
        this.maxReceive = maxReceive;
    }
    
    public void setMaxExtract(int maxExtract) {
        this.maxExtract = maxExtract;
    }
}
