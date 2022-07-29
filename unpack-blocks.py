import json
import os

base = os.path.abspath(__file__ + '/../')

boilerplate = (
'''package org.octechnics.valkdrive.blocks;

import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class %s extends Block {
    public %s() {
        super(Properties.of(Material.METAL)
                        .sound(SoundType.METAL)
                     /* .harvestTool(ToolType.PICKAXE) */ );
    }
}

''')

with open(base + '/unpack-data-blocks.json', encoding='utf-8') as f:
  blocks = json.load(f)

with open(base + '/unpack-data-items.json', encoding='utf-8') as f:
  items = json.load(f)

with open(base + '/unpack-data-assets.json', encoding='utf-8') as f:
  assets = json.load(f)

for name, data in blocks.items():
  item_type, class_name = data[:2]
  
  file = f'{base}/src/main/java/org/octechnics/valkdrive/blocks/{class_name}.java'
  
  if item_type == 'standard':
    if f'models/block/{name}.json' not in assets:
      print(f'Unpacking {file} failed: block model not found in assets')
      continue
    
    lang_key = 'block.valkdrive.' + name
    if lang_key not in assets['lang/en_us.json']:
      print(f'WARNING: {lang_key} name is not localized')
    elif lang_key not in assets['lang/ru_ru.json']:
      print(f'WARNING: {lang_key} name is not translated into Russian')
    
    if name not in items:
      print(f'WARNING: {name} not present in items list')
    elif items[name][0] != 'block':
      print(f'Unpacking {file} failed: associated item not marked as block')
      continue
    
    with open(file, 'w', encoding='utf-8') as f:
      f.write(boilerplate % (class_name, class_name))
      print(f'Unpacked {file}')
    
    continue
  
  # TODO: tile entities support
  
  print(f'Unpacking {file} failed: unsupported block type {item_type}')
  continue
