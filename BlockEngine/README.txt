# 1) Installation
The JAR file goes in your plugins folder like any other plugin.

The resource pack should be configured for your server. See §4 and §5.
The plugin will not force your game client to use the resource pack, although it will seem to work if the pack is not installed.
It is up to the server owner to require the use of the pack.

The hotbar.nbt file should be put in your .minecraft folder to give access to the custom blocks via a tab in the creative inventory.
If you please, once you have used these items in your desired way (see §6), you can revert to your previous hotbar.nbt file.

# 2) Configuration
The plugin has no configuration because all block customization is done in the resource pack.

# 3) Blocks
Up to 60 blocks can be added.

# 4) Selecting hardness and tool
It is evident when opening the resource pack that each block is bound to a slab variant (nothing is overwritten, but the properties are copied)
To customize a block's hardness and preferred tool, base it off a block with your desired settings.
- If you want it to be mined by an axe, use planks.
- If you want it to take a while to mine with early-game tools, use deepslate.

# 5) Customizing textures, models, and block names
Here are some helpful places to look in the resource pack:
- assets/blockengine/textures/block to change individual block textures
- assets/blockengine/models to make more advanced blocks (different texture on top like a crafting table, for instance)
- assets/blockengine/lang for translating and naming the blocks

# 6) Adding your items into the game
Items can be introduced into your server's economy in a few ways. Here are some examples:
- Adding these items via a crafting recipe in a datapack
- Adding these to a crate plugin
- Adding these to a chest shop
- Distributing the hotbar.nbt file on a creative server to let your players use the blocks

# 7) Notes about the creative tab
The default resource pack renames the saved hotbars creative tab to "Custom Blocks".
This was added to be used in conjunction with the hotbar.nbt file bundled with the plugin
You can revert the creative tab name by deleting the assets/minecraft/lang folder.
If you want to add on to this customization, there is a resource pack on Modrinth that lets you change the creative inventory icons.
I am not endorsing this project, but it is interesting and I may look into it in the future.
https://modrinth.com/resourcepack/custom-tabs
