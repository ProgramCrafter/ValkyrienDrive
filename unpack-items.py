import json
import os

base = os.path.abspath(__file__ + '/../')

boilerplate_block = (
'''package org.octechnics.valkdrive.items;

import net.minecraft.world.item.BlockItem;

import org.octechnics.valkdrive.ValkyrienDrive;

public class %s extends BlockItem {
    public %s() {
        super(ValkyrienDrive.%s.get(),
              new Properties() /* .tab(ItemGroup.COMMON) */ );
    }
}
''')
boilerplate_item = (
'''package org.octechnics.valkdrive.items;

import net.minecraft.world.item.Item;

import org.octechnics.valkdrive.ValkyrienDrive;

public class %s extends Item {
    public %s() {
        super(new Properties() /* .tab(ItemGroup.COMMON) */ );
    }
}
''')

with open(base + '/unpack-data-items.json', encoding='utf-8') as f:
  items = json.load(f)

with open(base + '/unpack-data-assets.json', encoding='utf-8') as f:
  assets = json.load(f)

for name, data in items.items():
  item_type, class_name = data[:2]
  
  file = f'{base}/src/main/java/org/octechnics/valkdrive/items/{class_name}.java'
  
  if f'models/item/{name}.json' not in assets:
    print(f'Unpacking {file} failed: item model not found in assets')
    continue
  
  if item_type == 'block':
    if f'models/block/{name}.json' not in assets:
      print(f'Unpacking {file} failed: block model not found in assets')
      continue
    
    lang_key = 'block.valkdrive.' + name
    if lang_key not in assets['lang/en_us.json']:
      print(f'WARNING: {lang_key} name is not localized')
    elif lang_key not in assets['lang/ru_ru.json']:
      print(f'WARNING: {lang_key} name is not translated into Russian')
    
    block_var_name = data[2]
    
    with open(file, 'w', encoding='utf-8') as f:
      f.write(boilerplate_block % (class_name, class_name, block_var_name))
      print(f'Unpacked {file}')
    
    continue
  elif item_type == 'item':
    lang_key = 'item.valkdrive.' + name
    if lang_key not in assets['lang/en_us.json']:
      print(f'WARNING: {lang_key} name is not localized')
    elif lang_key not in assets['lang/ru_ru.json']:
      print(f'WARNING: {lang_key} name is not translated into Russian')
    
    with open(file, 'w', encoding='utf-8') as f:
      f.write(boilerplate_item % (class_name, class_name))
      print(f'Unpacked {file}')
    
    continue
    
  print(f'Unpacking {file} failed: unsupported item type {item_type}')
  continue
