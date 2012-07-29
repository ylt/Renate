package co.d3s.ylt.renate.world;

import java.util.EnumSet;

public enum Atmosphere {
	Nether(-1, "Nether") {
		
	},
	Normal(0, "Normal"){
		
	},
	Ender(1, "Ender"){
		
	};
	
	private static Atmosphere[] types = new Atmosphere[3]; //TODO: find better solution later
	static
    {
		for (Atmosphere a : EnumSet.allOf(Atmosphere.class)) {
			types[a.getID()+1] = a;
		}
    }
	
	private int value;
	private String name;
	
	private Atmosphere(int value, String name) {
		this.value = value;
		this.name = name;
	}
	
	public static Atmosphere get(int id) {
		return types[id+1];
	}
	
	public int getID() {
		return value;
	}
	public String getName() {
		return name;
	}
}
