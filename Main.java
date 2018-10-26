
public class Main {

	public static void main(String[] args) {
		//System.out.println(Byte.getValue(isqrt((byte)11)));
		for(int i=1;i<255;i++)
		//	Byte.getValue(expr((byte)i));
			System.out.println(Byte.toString(isqrt((byte)i)));
	}

	static char isqrt(byte num) {
		char res = 0;
		char val = (char) (num << 8);
		byte bitIndex = 14; // only 4 bits
		byte i = 0; // only 3 bits
		byte buffer = 4; // only 3 bits
		// "bit" starts at the highest power of four <= the argument. bitIndex
		// is where 1 should go
		while (!((Byte.getValue(val, 15) | Byte.getValue(val, 14)) == 1)) {
			val <<= 2;
			buffer += 1;
		}
		//System.out.println(Byte.toString(val)+" " + buffer);

		while (i < 8) {
			if (!(val < res + (1 << bitIndex))) {
				val = (char) (val + ~(res + (1 << bitIndex)) + 1);
				res += 1 << (bitIndex + 1);
			} else {
			}
			res >>>= 1;
			bitIndex = (byte) (bitIndex + ~2 + 1);
			i++;
		}
		System.out.println("\n" + Byte.verifySqrt(Byte.toString(res)) / Math.pow(4, buffer) + " " + buffer);
		return res;
	}

	static Integer expr(byte num) {
		Integer res = 0;
		Integer val = (num << 24);
		Integer bitIndex = 30; // only 4 bits
		Integer i = 0; // only 4 bits
	    Integer buffer = 12; // only 3 bits
		// "bit" starts at the highest power of four <= the argument. bitIndex
		// is where 1 should go
		while (!((Byte.getValue(val, 31) | Byte.getValue(val, 30)) == 1)) {
			val <<= 2;
			buffer += 1;
		}
		System.out.println(Byte.toString(val)+" " + buffer);
		while (i<16) { 
			if (!(val < res + (1 << bitIndex))) {
				val = (val + ~(res + (1 << bitIndex)) + 1);
				res += 1 << (bitIndex + 1);
				//System.out.println("1");
			} else {
			}
			res >>>= 1;
			bitIndex = (bitIndex + ~2 + 1);
			i++;
		}
		//System.out.println(i);
		System.out.println(Byte.verifySqrt(Byte.toString(res)) / Math.pow(4, buffer) + " " + buffer);
		return res;
	}

}
