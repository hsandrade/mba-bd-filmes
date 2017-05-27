import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HiveJdbcTest {
	private static String driverName = "org.apache.hive.jdbc.HiveDriver";
	
	public static void main(String[] args) throws Exception {
		new HiveJdbcTest().test();
	}

	public void test() throws Exception {
		/*
		 * String inputFile =
		 * getClass().getResource("loremipsum.txt").toURI().toString(); new
		 * WordCountTask().run(inputFile);
		 */

		try {
			Class.forName(driverName);
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		
		System.out.println("Conectando ao banco...");
		Connection con = DriverManager.getConnection("jdbc:hive2://54.202.121.152:10000/default", "", "");
	    //PreparedStatement pstm = con.prepareStatement("select * from csvTable2");
		PreparedStatement pstm = con.prepareStatement("select * from cliente");
	    
	    System.out.println("Executando query...");
	    ResultSet rs = pstm.executeQuery();
	    
	    System.out.println("Query executada. >>>>>> ");
	    while (rs.next()) {
	    	System.out.println(rs.getInt(1) + ", " + rs.getString(2));
	    }
	}
}
