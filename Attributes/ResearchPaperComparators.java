package Attributes;

import Attributes.ResearchPaper;
import java.util.Comparator;

public class ResearchPaperComparators {

    public static Comparator<ResearchPaper> sortByDatePublished() {
        return Comparator.comparing(ResearchPaper::getDatePublished);
    }

    public static Comparator<ResearchPaper> sortByCitations() {
        return Comparator.comparingInt(ResearchPaper::getCitations).reversed();
    }

    public static Comparator<ResearchPaper> sortByPageCount() {
        return Comparator.comparingInt(ResearchPaper::getPages);
    }

    public static Comparator<ResearchPaper> sortByName() {
        return Comparator.comparing(ResearchPaper::getName);
    }
}
