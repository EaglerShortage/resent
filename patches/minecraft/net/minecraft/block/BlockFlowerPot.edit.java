
# Eagler Context Redacted Diff
# Copyright (c) 2022 lax1dude. All rights reserved.

# Version: 1.0
# Author: lax1dude

> CHANGE  2 : 4  @  2 : 8

~ import net.lax1dude.eaglercraft.v1_8.EaglercraftRandom;
~ 

> CHANGE  29 : 30  @  33 : 35

~ 	public static PropertyEnum<BlockFlowerPot.EnumFlowerType> CONTENTS;

> INSERT  38 : 42  @  43

+ 	public static void bootstrapStates() {
+ 		CONTENTS = PropertyEnum.<BlockFlowerPot.EnumFlowerType>create("contents", BlockFlowerPot.EnumFlowerType.class);
+ 	}
+ 

> CHANGE  166 : 167  @  167 : 168

~ 	public Item getItemDropped(IBlockState var1, EaglercraftRandom var2, int var3) {

> EOF
