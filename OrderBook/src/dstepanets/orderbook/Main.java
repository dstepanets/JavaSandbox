package dstepanets.orderbook;

public class Main {

    public static void main(String[] args) {

        String inputFilePath;
        if (args.length > 0) {
            inputFilePath = args[0];
        } else {
            inputFilePath = "src/resources/input.csv";
        }

        OrderBook orderBook = new OrderBook();

//        Output.logError();

        Input.parseInputFile(inputFilePath);

        Output.closeFile();


    }
}
