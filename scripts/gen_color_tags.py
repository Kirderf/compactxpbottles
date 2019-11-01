#!/usr/bin/env python3
import pprint
from collections import defaultdict
import json

COLORS = {
    "white": "!!!",
    "orange": "!. ",
    "magenta": "! !",
    "light_blue": " !!",
    "yellow": "!! ",
    "lime": ".! ",
    "pink": "!.!",
    "gray": "   ",
    "light_gray": "...",
    "cyan": " ..",
    "purple": ". !",
    "blue": "  .",
    "brown": ".  ",
    "green": " . ",
    "red": ".  ",
    "black": "   ",
}

BLOCK_TEMPLATES = [
    "minecraft:COLOR_wool",
    "minecraft:COLOR_terracotta",
    "minecraft:COLOR_stained_glass",
    "minecraft:COLOR_concrete",
    "minecraft:COLOR_concrete_powder",
    "minecraft:COLOR_shulker_box"
]


def get_tags(rgb):
    tag_colors = ["red", "green", "blue"]
    symbols = {
        "!": ["strong_TAG", "TAG"],
        ".": ["TAG"],
        " ": []
    }

    ret = []
    for i in range(0, len(tag_colors)):
        ret += [t.replace("TAG", tag_colors[i]) for t in symbols[rgb[i]]]
    return ret

def file_for_tag(tag_name):
    return f"src/main/resources/data/composableautomation/tags/blocks/{tag_name}.json"


if __name__ == '__main__':
    tag_blocks = defaultdict(lambda: [])
    for color in COLORS.keys():
        tags = get_tags(COLORS[color])
        for tag in tags:
            for template in BLOCK_TEMPLATES:
                tag_blocks[tag].append(template.replace("COLOR", color))

    for tag, blocks in tag_blocks.items():
        json_data = {"replace": False, "values": blocks}
        with open(file_for_tag(tag), "w") as json_file:
            json.dump(json_data, json_file, indent=4)
