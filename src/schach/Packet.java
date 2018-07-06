package schach;

import java.util.HashMap;

public class Packet {
	HashMap<String, String> data = new HashMap<String, String>();
	String action;
	
	private Packet() {
	}
	
	public static Packet create(String action) {
		Packet p = new Packet();
		p.action = action;
		return p;
	}
	
	public static Packet creatFromString(String input) {
		Packet p = new Packet();
		String[] parts = input.split("#");
		if(parts.length<2)
			return null;
		p.action = parts[1];
		for(int i=2;i<parts.length;i++) {
			p.data.put(parts[i].split(":")[0], parts[i].split(":")[1]);
		}
		return p;
	}
	
	public void addData(String key,String value) {
		if(data.containsKey(key))
			return;
		data.put(key, value);
	}
	
	public String save() {
		String output = "#"+action+"#";
		for(String key:data.keySet()) {
			output += key + ":" + data.get(key) + "#";
		}
		
		return output;
	}
}
