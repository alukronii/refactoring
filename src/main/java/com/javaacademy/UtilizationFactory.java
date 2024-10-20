package com.javaacademy;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Фабрика по переработке мусора
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UtilizationFactory {
    public static final double BOTTLE_SIZE = 500;

    private static Bottle refactorGlassGarbage(Garbage garbage) throws GarbageNotRefactorableException {
        if (garbage.getGarbageType() != GarbageType.GLASS) {
            throw new GarbageNotRefactorableException("Мусор не состоит полностью из стекла!");
        }
        return new Bottle(BOTTLE_SIZE, garbage.getCityFrom());
    }

    private static Cartoon refactorPaperGarbage(Garbage garbage) throws GarbageNotRefactorableException {
        if (garbage.getGarbageType() != GarbageType.PAPER) {
            throw new GarbageNotRefactorableException("Мусор не состоит полностью из бумаги!");
        }
        return new Cartoon(garbage.getWeight() / 2);
    }

    public static void refactorGarbage(Garbage[] garbageArray, BufferedWriter journal)
            throws GarbageNotRefactorableException, IOException {
        for (Garbage garbage : garbageArray) {
            switch (garbage.getGarbageType()) {
                case GLASS -> journal.write(new JournalRecord(UtilizationFactory.refactorGlassGarbage(garbage)).toString());
                case PAPER -> journal.write(new JournalRecord(UtilizationFactory.refactorPaperGarbage(garbage)).toString());
                default -> journal.write(new JournalRecord(garbage.getWeight()).toString());
            }
        }
    }
}
