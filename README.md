# ValkyrienDrive

### Description

> One ***Mod*** to rule them all, One ***Mod*** to find them,
> 
> One ***Mod*** to bring them all and in the ***warp field*** bind them.

Sci-fi mod for Minecraft with benefits of WarpDrive, Valkyrien Skies and SGCraft, controllable by OpenComputers.

### Ideas

- ships like in Valkyrien Skies
  - smooth movement
  - smooth rotation, not bound by blocks grid
  - physics
    - ship core (physics infuser), requiring EU (from IndustrialCraft 2) or RF energy
    - size of ship should be program-definable, like in WarpDrive
  - engines controllable by OpenComputers
- cloaking fields from WarpDrive, maybe bound to ship instead of area
- warp gates from SGCraft, instead of WarpDrive teleporters
- reactor from WarpDrive

### RFC

1. Minecraft version: ~~either 1.7.10, 1.12.2 or latest (1.18-1.19)~~ (started at 1.18.2);
2. Way of ship storing: 
  - in shipyard (remote chunks in same dimension where the ship was built)
    - shipyard CAN be reached by players without cheating, and that creates significant problems
  - in separate dimension
    - chunkloading will be hard
  - no block-grid-aligned storage at all
    - all tile entities require for them to be positioned
    - there won't be any block tick, so, for example, farms won't work
3. Any remaining interesting ideas.

### Progress

| Stage        | State       |
| ------------ | ----------- |
| Designing    | in progress |
| Development  | not started |
| Testing      | not started |

At the moment, this repository is RFC for collecting useful ideas.
