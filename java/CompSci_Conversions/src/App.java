
public class App {
	
	public static double[] digitExtract(double n) {
		int count = 0;
        int numLength = (int) (Math.log10(n) + 1);
        int operand = 10;
        int divisor = 1;
        double[] numArray = new double[numLength];
        for (int i = (numLength - 1); i >= 0; i--) {
            numArray[i] = ((n % operand) - count) / divisor;
            count += numArray[i];
            operand = operand * 10;
            divisor = divisor * 10;
        }
        return numArray;
	}
	
	public static void int2Bin(int x) {
		int[] bin = new int[8];
		int count = 0;
		while (x > 0) {
			bin[count] = x % 2;
			x = x/2;
			count++;
		}
		for (int i =  bin.length - 1; i >= 0; i--) {
			System.out.print(bin[i] + " ");
		}
	}
	
	public static int bin2Int(String bin) {
		int out = 0;
		int count = 0;
		for (int i = bin.length() - 1; i >= 0; i--) {
			out = (int) (out + (Integer.parseInt(String.valueOf(bin.charAt(i))) * Math.pow(2, count)));
			count++;
		} return out;
	}
	
	public static void bin2Hex(String bin) {
		// Math from here - https://www.rapidtables.com/convert/number/how-decimal-to-hex.html
		StringBuilder sb = new StringBuilder();
		int remainder;
		int decimal = bin2Int(bin);
		
		while (decimal > 0) {
			remainder = decimal % 16;
			decimal = decimal / 16;
			if (remainder < 9) {
				sb.append(remainder);
			} else {
				switch (remainder) {
				case 10:
					sb.append('A');
					break;
				case 11:
					sb.append('B');
					break;
				case 12:
					sb.append('C');
					break;
				case 13:
					sb.append('D');
					break;
				case 14:
					sb.append('E');
					break;
				case 15:
					sb.append('F');
					break;	
				}
			}
		} System.out.println(sb.reverse());
	}
	
	
	public static void main(String[] args) {
		int2Bin(10);
		System.out.println();
		System.out.println(bin2Int("1010"));
		bin2Hex("1011101010111110");
	}
}
