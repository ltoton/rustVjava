package Bench;

import java.io.File;

public class Benches {

    static int warmupIterations = 3, measurementIterations = 3;

    public static void main(String[] args) throws Exception {
//        bench(10, 100, "image");
//        bench(10, 100, "recursive");
//        bench(10, 100, "iterative");
//        bench(10, 100, "file");
    }

    public static void bench(int warmupIterations, int measurementIterations, String benchName) throws Exception {
        for (int i = 0; i < warmupIterations; i++) {
            System.out.println("Warmup iteration " + i);
            long start = System.nanoTime() / 1000;
            switch (benchName) {
                case "image":
                    ImageProcessing.imageProcessing();
                    break;
                case "file":
                    FileExecution.run();
                    break;
                case "iterative":
                    BinarySearch.init();
                    break;
                case "recursive":
                    Sierpinski.getSierpinskiTriangle(14);
                    break;
                default:
                    throw new Exception("You dumb");
            }
            long end = System.nanoTime() / 1000;
            System.out.println("Completed in " + (end - start) + " µs");
        }

        int[] measurements = new int[measurementIterations];
        for (int i = 0; i < measurementIterations; i++) {
            System.out.println("Measurement iteration " + i);
            long start = System.nanoTime() / 1000;
            switch (benchName) {
                case "image":
                    ImageProcessing.imageProcessing();
                    break;
                case "file":
                    FileExecution.run();
                    break;
                case "iterative":
                    BinarySearch.init();
                    break;
                case "recursive":
                    Sierpinski.getSierpinskiTriangle(14);
                    break;
                default:
                    throw new Exception("You dumb");
            }
            long end = System.nanoTime() / 1000;
            measurements[i] = (int) (end - start);
            System.out.println("Completed in " + (end - start) + " µs");
        }

        int average = 0;
        for (int i = 0; i < measurementIterations; i++) {
            average += measurements[i];
        }
        average /= measurementIterations;
        System.out.println("Average execution time for " + benchName + ": " + average + " µs");
    }


}