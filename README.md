# ValkyrienDrive

### Description

> One ***Mod*** to rule them all, One ***Mod*** to find them,
> 
> One ***Mod*** to bring them all and in the ***warp field*** bind them.

Sci-fi mod for Minecraft with benefits of WarpDrive, Valkyrien Skies and SGCraft, controllable by OpenComputers.

### Bound **~~rings~~** mods
- [WarpDrive](https://github.com/LemADEC/WarpDrive/)
- [Valkyrien Skies 2](https://github.com/ValkyrienSkies/Valkyrien-Skies-2/)
- [SGCraft](https://github.com/gcewing/SGCraft/tree/mc1.7/)
- [OpenComputers 2](https://github.com/fnuecke/oc2) (or [OC "classic"](https://github.com/MightyPirates/OpenComputers)?)
- mod adding energy: IC2/BuildCraft/RailCraft/Forestry/AE2/...

### Development blocked on
Release of either of these:
| Mod | Status | Issues | Milestone |
| --- | ------ | ------ | --------- |
| Valkyrien Skies 2 | ![GitHub release (latest by date)](https://img.shields.io/github/v/release/ValkyrienSkies/Valkyrien-Skies-2?style=flat-square) | ![GitHub issues](https://img.shields.io/github/issues-raw/ValkyrienSkies/Valkyrien-Skies-2?style=flat-square) | ![GitHub milestone](https://img.shields.io/github/milestones/progress-percent/ValkyrienSkies/Valkyrien-Skies-2/1?style=flat-square) |
| OpenComputers 2 | ![GitHub release (latest by date)](https://img.shields.io/github/v/release/fnuecke/oc2?style=flat-square) | ![GitHub issues](https://img.shields.io/github/issues-raw/fnuecke/oc2?style=flat-square) | ![GitHub release (latest by date including pre-releases)](https://img.shields.io/github/v/release/fnuecke/oc2?include_prereleases&label=prerelease&style=flat-square) |

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
    - seems like this is requirement of Valkyrien Skies
  - in separate dimension
    - chunkloading will be hard
  - no block-grid-aligned storage at all
    - all tile entities require for them to be positioned
    - there won't be any block tick, so, for example, farms won't work
3. Any remaining interesting ideas.

### Progress

![](https://img.shields.io/badge/designing-in%20progress-5f7?style=for-the-badge)  
![](https://img.shields.io/badge/development-in%20progress-5f7?style=for-the-badge)  
![](https://img.shields.io/badge/testing-not%20started-ff7?style=for-the-badge)

At the moment, this repository is RFC for collecting useful ideas.

### Licensing

JAR built with supllied tools can contain non-up-to-date license information. Please, be aware of this.

Possibly non-exhaustive list of content borrowed from other mods:
- Currently, most of textures were just copied from SGCraft.
