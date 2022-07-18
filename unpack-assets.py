import json
import os

base = os.path.abspath(__file__ + '/../')

with open(base + '/unpack-data-assets.json', encoding='utf-8') as f:
  assets = json.load(f)

for file, data in assets.items():
  if '/' in file:
    dirname = file[:file.rfind('/')]
    os.makedirs(base + '/src/main/resources/assets/valkdrive/' + dirname, exist_ok=True)
  
  with open(base + '/src/main/resources/assets/valkdrive/' + file, 'w',
            encoding='utf-8') as f:
    json.dump(data, f)
    print(f'Unpacked {base}/src/main/resources/assets/valkdrive/{file}')
