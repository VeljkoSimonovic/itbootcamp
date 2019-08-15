package ZavrsniRad;

public class proba {
	public static boolean isNumeric(String strNum) {
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException | NullPointerException nfe) {
	        return false;
	    }
	    return true;
	}
	public static void main(String[] args) {
		String s = "rec,255.rec1!rec2?rec3.  rec4'rec5";
		String[] str = s.split("[,\\.\\?! ]");
		System.out.println(isNumeric("2g2"));
	}

}
