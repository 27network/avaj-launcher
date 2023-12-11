package me.xtrm.avaj;

import me.xtrm.avaj.exception.InvalidInputFileException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws InvalidInputFileException {
        if (args.length != 1) {
            System.out.println("Usage: java me.xtrm.avaj.launcher.Main <scenario_file>");
            System.exit(-1);
        }

        Path inputFile = Paths.get(args[0]);
        SimulationInput simulationInput = SimulationInput.fromFile(inputFile);
    }
}
