
# Eagler Context Redacted Diff
# Copyright (c) 2022 lax1dude. All rights reserved.

# Version: 1.0
# Author: lax1dude

> CHANGE  3 : 4  @  3 : 5

~ 

> CHANGE  13 : 14  @  14 : 23

~ 	public static PropertyEnum<BlockRailBase.EnumRailDirection> SHAPE;

> INSERT  23 : 35  @  32

+ 	public static void bootstrapStates() {
+ 		SHAPE = PropertyEnum.create("shape", BlockRailBase.EnumRailDirection.class,
+ 				new Predicate<BlockRailBase.EnumRailDirection>() {
+ 					public boolean apply(BlockRailBase.EnumRailDirection blockrailbase$enumraildirection) {
+ 						return blockrailbase$enumraildirection != BlockRailBase.EnumRailDirection.NORTH_EAST
+ 								&& blockrailbase$enumraildirection != BlockRailBase.EnumRailDirection.NORTH_WEST
+ 								&& blockrailbase$enumraildirection != BlockRailBase.EnumRailDirection.SOUTH_EAST
+ 								&& blockrailbase$enumraildirection != BlockRailBase.EnumRailDirection.SOUTH_WEST;
+ 					}
+ 				});
+ 	}
+ 

> EOF
