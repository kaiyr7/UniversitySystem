package Attributes;

import java.util.Vector;
import Interfaces.Researchable;

public class ResearchProject {
    private String researchName;
    private Vector<ResearchPaper> researchPapers;
    private Vector<Researchable> researchers;

    public ResearchProject(String researchName) {
        this.researchName = researchName;
        this.researchPapers = new Vector<>();
        this.researchers = new Vector<>();
    }

    public void addResearchPaper(ResearchPaper paper) {
        if (paper != null) {
            researchPapers.add(paper);
            researchers.add(paper.getResearcher());
        }
    }

    public boolean removeResearchPaper(ResearchPaper paper) {
        if (paper != null) {
            boolean removed = researchPapers.remove(paper);
            researchers.remove(paper.getResearcher());
            return removed;
        }
        return false;
    }


    public Vector<ResearchPaper> getResearchPapers() {
        return new Vector<>(researchPapers);
    }

    public String getResearchName() {
        return researchName;
    }

    public void setResearchName(String researchName) {
        this.researchName = researchName;
    }

    public Vector<Researchable> getResearchers() {
        return new Vector<>(researchers);
    }


    public String getResearchInfo() {
        StringBuilder info = new StringBuilder("Research Project: ").append(researchName).append("\n");
        for (ResearchPaper paper : researchPapers) {
            info.append(paper.toString()).append("\n");
        }
        return info.toString();
    }
}
