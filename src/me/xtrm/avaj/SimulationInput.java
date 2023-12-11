package me.xtrm.avaj;

import me.xtrm.avaj.exception.InvalidInputFileException;
import me.xtrm.avaj.exception.InvalidInputFormatException;
import me.xtrm.avaj.type.Aircraft;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static me.xtrm.avaj.exception.InvalidInputFileException.fileError;
import static me.xtrm.avaj.exception.InvalidInputFormatException.formatError;

public class SimulationInput {
    private final int nTimes;
    private final List<Aircraft> aircrafts;

    private SimulationInput(int nTimes, List<Aircraft> aircrafts) {
        this.nTimes = nTimes;
        this.aircrafts = aircrafts;
    }

    public static SimulationInput fromFile(Path file) throws InvalidInputFileException {
        String absolutePath = file.toAbsolutePath().toString();
        ensureFileValid(file, absolutePath);

        List<String> lines;
        try {
            lines = Files.readAllLines(file);
        } catch (IOException e) {
            throw fileError("Error while reading file %s", absolutePath, e);
        }
        if (lines.isEmpty()) throw fileError("File %s is empty", absolutePath);

        int times;
        try {
            times = Integer.parseInt(lines.get(0));
        } catch (NumberFormatException e) {
            throw formatError("Couldn't parse simulation iterations number", e);
        }
        if (times < 0) {
            throw formatError("Simulation iterations number is negative");
        }

        List<Aircraft> aircraftList = new ArrayList<>();
        if (lines.size() > 1) {
            lines = lines.subList(1, lines.size() - 1);
            for (String line : lines) {
                aircraftList.add(parseAircraftDeclaration(line));
            }
        }

        return new SimulationInput(times, Collections.unmodifiableList(aircraftList));
    }

    private static Aircraft parseAircraftDeclaration(String line) throws InvalidInputFormatException {
        //TODO
        return null;
    }

    private static void ensureFileValid(Path file, String absolutePath) throws InvalidInputFileException {
        if (!Files.exists(file)) throw fileError("File %s doesn't exist", absolutePath);
        if (!Files.isRegularFile(file)) throw fileError("File %s isn't a regular file", absolutePath);
        if (!Files.isReadable(file)) throw fileError("File %s isn't readable", absolutePath);
    }
}
