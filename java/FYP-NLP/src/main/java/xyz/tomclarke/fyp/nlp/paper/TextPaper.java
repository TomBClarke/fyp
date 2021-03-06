package xyz.tomclarke.fyp.nlp.paper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Supports reading text (.txt) papers
 * 
 * @author tbc452
 *
 */
public class TextPaper extends Paper {

    private static final long serialVersionUID = 1673335959412177249L;
    private static final Logger log = LogManager.getLogger(Paper.class);

    public TextPaper(String textLocation, boolean canAttemptAnnRead, boolean saveUpdatedToDisk) {
        super(textLocation, canAttemptAnnRead, saveUpdatedToDisk);

        // Text may have been loaded in.
        if (getText() == null) {
            try {
                setText(new String(Files.readAllBytes(Paths.get(textLocation))));
                File file = new File(textLocation);
                setTitle(file.getName().replace(".txt", ""));
            } catch (IOException e) {
                log.error("Problem loading text document", e);
            }
        }
    }

}
