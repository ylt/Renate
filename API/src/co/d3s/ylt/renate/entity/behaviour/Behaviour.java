package co.d3s.ylt.renate.entity.behaviour;

import co.d3s.ylt.renate.entity.Entity;

/*
 * Behaviours are assigned to mobs, each tick behaviours will be triggered from mobs in order to do their jobs
 * TODO: plan out ways to reduce collisions,
 *    (maybe authenticate actions with the other behaviours?)
 */
public interface Behaviour {
	public void tick(Entity entity);
}
