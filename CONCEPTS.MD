# Concepts of Valkyrien Drive

Currently chosen concepts are in bold.

### Stargates (SGCraft)

- Placement:
  - **single block with model extending to outside**:
    - **requiring blocks around to be air**:
      - **if space is occupied, stargate looks minimized and does not work**;
    - having model collide with other blocks (isn't beautiful);
  - single block (will not reproduce the high complexity things atmosphere);
  - multiblock (hard time debugging and optimizing multiblock building);

- Energy requirement: of course, yes; EU/RF.

### Ships (Valkyrien Skies 2)

- **Need to wait for VS2 to be released to integrate their mechanics inside this mod**;

- Movement:
  - block-grid-aligned (there will not be point in installing this mod as there already is WarpDrive);
  - **smooth with physics** (taken from VS2, of course);

- Sizing:
  - determining connected blocks on assembly (no way to detach smaller ship);
  - determining connected blocks regularly (heavy computations);
  - **programmatically, just like in WarpDrive**;

- Energy requirement: slightly less than stargates, but still needed; **renewable energy sources only**.

### Cloaking (WarpDrive)

- Zone:
  - **full ship** (sometimes inconvenient but easiest to implement);
  - some range from cloaking mechanism (how to cloak terrain if ship is not aligned to blocks grid?);
  - some range from cloaking mechanism, but only on ship.
