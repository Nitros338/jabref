package org.jabref.model.groups;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.jabref.logic.auxparser.AuxParserTest;
import org.jabref.logic.auxparser.DefaultAuxParser;
import org.jabref.model.database.BibDatabase;
import org.jabref.model.entry.BibEntry;
import org.jabref.model.util.DummyFileUpdateMonitor;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TexGroupTest {

    @Test
    public void containsReturnsTrueForEntryInAux() throws Exception {
        Path auxFile = Paths.get(AuxParserTest.class.getResource("paper.aux").toURI());
        TexGroup group = new TexGroup("paper", GroupHierarchyType.INDEPENDENT, auxFile, new DefaultAuxParser(new BibDatabase()), new DummyFileUpdateMonitor());
        BibEntry inAux = new BibEntry();
        inAux.setCiteKey("Darwin1888");

        assertTrue(group.contains(inAux));
    }

    @Test
    public void containsReturnsTrueForEntryNotInAux() throws Exception {
        Path auxFile = Paths.get(AuxParserTest.class.getResource("paper.aux").toURI());
        TexGroup group = new TexGroup("paper", GroupHierarchyType.INDEPENDENT, auxFile, new DefaultAuxParser(new BibDatabase()), new DummyFileUpdateMonitor());
        BibEntry notInAux = new BibEntry();
        notInAux.setCiteKey("NotInAux2017");

        assertFalse(group.contains(notInAux));
    }
}
