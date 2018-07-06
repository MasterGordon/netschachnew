package schach;

public class MainTest {
	public static void main(String[] args) {
		Packet test1 = Packet.create("login");
		test1.addData("username", "MasterGordon");
		test1.addData("password", "1234");
		System.out.println(test1.save());
		Packet test2 = Packet.creatFromString(test1.save());
		System.out.println(test2.save());
	}
}
