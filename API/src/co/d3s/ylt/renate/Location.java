package co.d3s.ylt.renate;

import co.d3s.ylt.renate.world.World;

public class Location implements Cloneable {
	private World world;
	private double x;
	private double y;
	private double z;
	private float pitch;
	private float yaw;

	public Location(final World world, final double x, final double y,
			final double z) {
		this(world, x, y, z, 0, 0);
	}

	public Location(final World world, final double x, final double y,
			final double z, final float yaw, final float pitch) {
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
		this.pitch = pitch;
		this.yaw = yaw;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public World getWorld() {
		return world;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getX() {
		return x;
	}

	public int getBlockX() {
		return (int) x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getY() {
		return y;
	}

	public int getBlockY() {
		return (int) y;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public double getZ() {
		return z;
	}

	public int getBlockZ() {
		return (int) z;
	}

	public void setYaw(float yaw) {
		this.yaw = yaw;
	}

	public float getYaw() {
		return yaw;
	}

	public void setPitch(float pitch) {
		this.pitch = pitch;
	}

	public float getPitch() {
		return pitch;
	}

	public Location add(double x, double y, double z) {
		this.x += x;
		this.y += y;
		this.z += z;
		return this;
	}

	public Location subtract(double x, double y, double z) {
		this.x -= x;
		this.y -= y;
		this.z -= z;
		return this;
	}

	public double distance(Location o) {
		if (o == null || o.getWorld() != getWorld()) {
			throw new IllegalArgumentException(
					"Cannot measure distance between worlds or to null");
		}

		return Math.sqrt(Math.pow(x - o.x, 2) + Math.pow(y - o.y, 2)
				+ Math.pow(z - o.z, 2));
	}

	public double distanceSquared(Location o) {
		if (o == null || o.getWorld() != getWorld()) {
			throw new IllegalArgumentException(
					"Cannot measure distance between worlds or to null");
		}

		return Math.pow(x - o.x, 2) + Math.pow(y - o.y, 2)
				+ Math.pow(z - o.z, 2);
	}

	public Location multiply(double m) {
		x *= m;
		y *= m;
		z *= m;
		return this;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Location other = (Location) obj;

		if (this.world != other.world
				&& (this.world == null || !this.world.equals(other.world))) {
			return false;
		}
		if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
			return false;
		}
		if (Double.doubleToLongBits(this.y) != Double.doubleToLongBits(other.y)) {
			return false;
		}
		if (Double.doubleToLongBits(this.z) != Double.doubleToLongBits(other.z)) {
			return false;
		}
		if (Float.floatToIntBits(this.pitch) != Float
				.floatToIntBits(other.pitch)) {
			return false;
		}
		if (Float.floatToIntBits(this.yaw) != Float.floatToIntBits(other.yaw)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 3;

		hash = 19 * hash + (this.world != null ? this.world.hashCode() : 0);
		hash = 19
				* hash
				+ (int) (Double.doubleToLongBits(this.x) ^ (Double
						.doubleToLongBits(this.x) >>> 32));
		hash = 19
				* hash
				+ (int) (Double.doubleToLongBits(this.y) ^ (Double
						.doubleToLongBits(this.y) >>> 32));
		hash = 19
				* hash
				+ (int) (Double.doubleToLongBits(this.z) ^ (Double
						.doubleToLongBits(this.z) >>> 32));
		hash = 19 * hash + Float.floatToIntBits(this.pitch);
		hash = 19 * hash + Float.floatToIntBits(this.yaw);
		return hash;
	}

	@Override
	public String toString() {
		return "Location{" + "world=" + world + ",x=" + x + ",y=" + y + ",z="
				+ z + ",pitch=" + pitch + ",yaw=" + yaw + '}';
	}

	@Override
	public Location clone() {
		try {
			Location l = (Location) super.clone();

			l.world = world;
			l.x = x;
			l.y = y;
			l.z = z;
			l.yaw = yaw;
			l.pitch = pitch;
			return l;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
}