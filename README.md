_Disclaimer: This README is like 85% ChatGPT yap, but edited to contain accurate information. I can't stand repos with no README, but I also can't stand writing READMEs. If you have any questions, message me on Discord: @fakename131_
# BlockEngine
_BlockEngine: Add custom building blocks to Minecraft with a simple, efficient plugin._

[![Download on BuiltByBit](https://img.shields.io/badge/Download%20on-BuiltByBit-blue)](https://builtbybit.com/resources/blockengine-no-lag-no-bs-just-blocks.48602/)

## Overview
BlockEngine is a Minecraft plugin designed to enable new types of building blocks without needing client-side mods. By using unused waterlogged block states, BlockEngine brings innovative new mechanics to Minecraft that blend seamlessly with traditional gameplay. 

## Key Features
- **Custom Building Blocks**: BlockEngine introduces new building block types that can be used in construction just like regular blocks.
  
  - **Under the Hood**: BlockEngine utilizes unused waterlogged block states in Minecraft to create these custom blocks. Normally, these block states are not accessible to players, but with BlockEngine, they become a useful tool for adding dynamic block interactions. By modifying how the server interprets these specific block states using Java Agents (the 10th circle of hell, don't get me started), BlockEngine allows for pushable, waterlogged blockstates — something not possible with default Minecraft mechanics.

- **Optimized for Performance**: Designed to minimize any impact on server performance, BlockEngine maintains smooth gameplay even with the added complexity of custom blocks. 

- **Server-Side Only**: BlockEngine is entirely server-side, meaning players can join and use the new blocks without needing to install any mods on their client, just accept the resource pack. This makes setup easy for server owners and players alike.

- **Easy Setup for Resource Pack Makers**: Everything (yes, EVERYTHING) is configured inside the resource pack. Everything = textures and names (thats it because they are just meant for building blocks).

## Installation
1. Download the plugin from [BuiltByBit](https://builtbybit.com/resources/blockengine-no-lag-no-bs-just-blocks.48602/).
2. Extract the zip.
3. Place the downloaded `.jar` file in your server’s `plugins` directory.
4. Congfigure the resource pack as per the README file in the zip
5. Restart your server to activate BlockEngine.
6. Optionally, use the hotbars.nbt file in the zip for the extra creative tab.

## Usage
After installation, BlockEngine will enable custom block mechanics by default. Waterlogged blocks can now be pushed with pistons, and you’ll have access to the new building blocks that use these modified states.

## FAQs
**Q: Does BlockEngine require any client mods?**  
A: No, BlockEngine is fully server-side. Players don’t need to install anything on their client to use the new blocks.

**Q: Will BlockEngine slow down my server?**  
A: BlockEngine is designed to optimize for performance, ensuring minimal impact on server speed even with the added mechanics.