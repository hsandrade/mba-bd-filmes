import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonTest {

	public static void main(String[] args) throws Exception {
		new GsonTest().test();
	}
	
	@Test
	public void test() throws Exception {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String strJson = "{\"idcli\":\"1001\",\"cidade\":\"Rio de Janeiro\"}";
		
		Cliente cliente = gson.fromJson(strJson, Cliente.class);
		
		System.out.println("Parseado: " + cliente);
	}

}
