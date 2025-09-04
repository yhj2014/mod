# Technological Revolution Mod

A technological revolution mod for Minecraft 1.20.1 with Forge 47.3.27

## Features

### Energy System
- Forge Energy (FE) implementation for all machines and devices
- Multiple generators:
  - Solar Generator: Generates energy during daylight when not obstructed
  - Wind Generator: Generates energy at higher altitudes when exposed to air
  - Water Generator: Generates energy when surrounded by water
  - Nuclear Reactor: Generates large amounts of energy using nuclear fuel

### Machines
- Ore Crusher: Crushes ores into powder for higher yield
- Advanced Furnace: Faster smelting than regular furnace
- Auto Farm: Automatically plants, grows, and harvests crops
- Auto Miner: Automatically mines ores underground

### Energy Components
- Energy Converter: Converts FE to other energy types (like redstone signals)
- Energy Storage: Stores excess FE for later use

### Wiring System
- Copper Wire: Basic wire for energy transmission
- Gold Wire: Higher efficiency wire for energy transmission

### New Ores
- Uranium Ore: Used for nuclear fuel
- Lithium Ore: Used for advanced electronics

### Special Tools
- Energy Pickaxe: Uses FE to mine blocks more efficiently

## Recipes

All blocks and items in this mod have crafting recipes. Here are some examples:

### Generators
- Solar Generator: 3 Glass, 4 Iron Ingots, 1 Redstone, 3 Stone
- Wind Generator: 8 Iron Ingots, 1 Redstone, 3 Stone
- Water Generator: 8 Iron Ingots, 2 Buckets, 1 Redstone, 3 Stone
- Nuclear Reactor: 4 Iron Ingots, 4 Redstone, 1 Glowstone Dust

### Machines
- Ore Crusher: 4 Iron Ingots, 2 Pistons, 3 Stone
- Advanced Furnace: 4 Iron Ingots, 1 Furnace, 3 Stone
- Auto Farm: 8 Stone, 4 Pistons, 1 Hay Block
- Auto Miner: 4 Iron Ingots, 2 Pistons, 1 Diamond, 3 Stone

### Energy Components
- Energy Converter: 4 Iron Ingots, 4 Redstone, 1 Gold Ingot
- Energy Storage: 4 Iron Ingots, 4 Redstone, 1 Gold Ingot

### Wiring
- Copper Wire: 3 Copper Ingots = 6 Copper Wire
- Gold Wire: 3 Gold Ingots = 6 Gold Wire

### Special Tools
- Energy Pickaxe: 3 Redstone, 6 Iron Ingots, 1 Stick

### New Ores
- Uranium Ore: 8 Glowstone Dust, 1 Coal Ore = 1 Uranium Ore
- Lithium Ore: 8 Redstone, 1 Lapis Ore = 1 Lithium Ore

Smelting recipes:
- Uranium Ore → Iron Ingot
- Lithium Ore → Copper Ingot

## Installation

1. Download the mod jar file
2. Place it in your Minecraft `mods` folder
3. Launch Minecraft with Forge 47.3.27 for Minecraft 1.20.1

## Development

This mod is built with Forge MDK 1.20.1-47.3.27. To set up the development environment:

1. Clone this repository
2. Run `./gradlew genSources` to generate sources
3. Import into your preferred IDE (IntelliJ IDEA recommended)
4. Run `./gradlew runClient` to launch the client

## Building

To build the mod:
```bash
./gradlew build
```

The built jar will be in `build/libs/`.

## License

All Rights Reserved.
