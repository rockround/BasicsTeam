
public class Byte {

	public static String toString(char b){
		String s = "";
		for(int i=15;i>=0;i--){
			if((b>>>i&1)==1)
				s+="1";
		else
				s+="0";
		}
		return s;
	}
	public static float verifySqrt(String s){
	return (float)Math.pow(getValue(s),2);
	}
	public static float getValue(String s){
		float result = 0;
		int counter=s.length()-1;
		
		//System.out.println(s);
		for(char c : s.toCharArray()){
			if(c!='.'){
			result+=(float)Math.pow(2f,counter)*(c=='1'?1f:0f);
			//System.out.println(result);
			counter--;
			}
		}
		return result;
	}
	public static float getValue(char c){
		return getValue(toString(c));
	}
	public static float getValue(long c){
		return getValue(toString(c));
	}
	public static String toString(byte b){
		String s = "";
		for(int i=7;i>=0;i--){
			if((b>>>i&1)==1)
				s+="1";
			else
				s+="0";
		}
		return s;
	}
	public static byte priorityEncoder(char b){
		byte result = 0;
		while(getValue(b,15)!=1){
			b<<=2;
			result++;
		}
		return result;
	}
	public static byte priorityEncoderOred(char b){//output 3 bit number representing high bit
		byte result = 0;
		while((getValue(b,14)|getValue(b,15))!=1){	//Remove this char 
			b<<=2;
			result+=2;
		}
		return (byte)(15+~result+1);
	}
	public static byte decoder(byte b){//expand 3 bit number into 8 bit
		byte result = 1;
		while(b!=1){
			b--;
			result<<=1;
		}
		return result;
	}
	public static byte getValue(char b, int bitNum){
		return (byte) ((b >>> bitNum) & 1);
	}
	public static byte setValue(char index, byte b, byte t){
		return (byte)(b + ~(b<<index)+1 + t<<index);
	}
	public static Integer getValue(Integer val, int bitNum) {
		// TODO Auto-generated method stub
		return  ((val >>> bitNum) & 1);
	}
	public static long getValue(long val, int bitNum) {
		// TODO Auto-generated method stub
		return  ((val >>> bitNum) & 1);
	}
	public static String toString(Integer res) {
		String s = "";
		for(int i=31;i>=0;i--){
			if((res>>>i&1)==1)
				s+="1";
			else
				s+="0";
		}
		return s;
	}
	public static String toString(long b){
		String s = "";
		for(int i=63;i>=0;i--){
			if((b>>>i&1)==1)
				s+="1";
		else
				s+="0";
		}
		return s;
	}
	public static float getValue(Integer expr) {
		// TODO Auto-generated method stub
		return getValue(toString(expr));
	}
}
