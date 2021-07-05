package utils;

public class Error_Msg {

	public static void error_msg(String elementName) {
		try {
			throw new Exception("unable to find this element -->"+ elementName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
