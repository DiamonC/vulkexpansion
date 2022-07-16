package io.github.diamonc.vulkexpansion.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;

public class StalkerMob extends PathAwareEntity {
	public StalkerMob(EntityType<? extends PathAwareEntity> entityType, World world) {
		super(entityType, world);
	}
}
