import java.text.DecimalFormat;

public class AppBrown {

    public static DecimalFormat df = new DecimalFormat("###.###");

    public static void collectAndConvert(double[] num, String[] formats) {

        double total = 0;
        double amountUSD = 0;
        double amountGBP = 0;
        double amountSGD = 0;
        double amountEUR = 0;
        double amountINR = 0;
        double amountQAR = 0;

        System.out.print("Total amount collected: ");

        for (int i = 0; i < num.length; i++) {
            String format = formats[i];
            String addition = " + ";
            if (i == num.length - 1) {
                addition = " = ";
            }

            switch (format) {
                case "USD":
                    amountUSD = (num[i]) * 0.77;
                    total = total + amountUSD;
                    System.out.print(df.format(amountUSD) + addition);
                    break;
                case "GBP":
                    amountGBP = amountGBP + (num[i]);
                    total = total + amountGBP;
                    System.out.print(df.format(amountGBP) + addition);
                    break;
                case "SGD":
                    amountSGD = amountSGD + (num[i]) * 0.57;
                    total = total + amountSGD;
                    System.out.print(df.format(amountSGD) + addition);
                    break;
                case "EUR":
                    amountEUR = amountEUR + (num[i]) * 0.91;
                    total = total + amountEUR;
                    System.out.print(df.format(amountEUR) + addition);
                    break;
                case "INR":
                    amountINR = amountINR + (num[i]) * 0.011;
                    total = total + amountINR;
                    System.out.print(df.format(amountINR) + addition);
                    break;
                case "QAR":
                    amountQAR = amountQAR + (num[i]) * 0.21;
                    total = total + amountQAR;
                    System.out.print(df.format(amountQAR) + addition);
                    break;
            }
        }
        System.out.print(df.format(total) + " GBP");
        System.out.println("\n");
    }

    public static void main(String[] args) {

        double[] arr1 = new double[] {75,120,10,500,10};
        String[] arr2 = new String[] {"USD", "USD", "GBP", "INR","EUR"};

        double[] arr3 = new double[] {665,120,22,12312,67};
        String[] arr4 = new String[] {"USD", "INR", "GBP", "INR","USD"};

        collectAndConvert(arr1, arr2);
        collectAndConvert(arr3, arr4);
    }
}
