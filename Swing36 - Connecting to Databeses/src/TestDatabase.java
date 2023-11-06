import model.Database;

public class TestDatabase {
	public static void main(String[] args) {
		System.out.println("Running Database Test");
		
		Database db = new Database();
		try {
			db.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		db.disconnect();
	}
}