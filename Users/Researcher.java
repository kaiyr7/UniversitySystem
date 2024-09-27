package Users;

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

import Attributes.DataBase;
import Attributes.ResearchPaper;
import Attributes.ResearchProject;
import Interfaces.Researchable;

public class Researcher extends Employee implements Researchable {
    private Vector<ResearchPaper> researchPapers = new Vector<>();

    public Researcher(String password, String firstName, String lastName, int age) {
        super(password, firstName, lastName, age);
        this.setId(this.idGenerator());
    }

    public double calculateHIndex() {
        Vector<Integer> citationsVec = new Vector<>();
        for (ResearchPaper researchPaper : researchPapers) {
            citationsVec.add(researchPaper.getCitations());
        }
        Collections.sort(citationsVec, Collections.reverseOrder());

        int hIndex = 0;
        for (int i = 0; i < citationsVec.size(); i++) {
            if (citationsVec.get(i) >= i + 1) {
                hIndex = i + 1;
            } else {
                break;
            }
        }
        return hIndex;
    }


    public Vector<ResearchPaper> getResearchPapers() {

    	return researchPapers; 
    }
    public void doResearchPapers(ResearchPaper researchPaper) { 
    	researchPapers.add(researchPaper);
    }
    
    public void printResearchPapers(Comparator<ResearchPaper> comparator) {
        Collections.sort(researchPapers, comparator);
        for (ResearchPaper paper : researchPapers) {
            System.out.println(paper.getName() + " - Published on: " + paper.getDatePublished() +
                               " - Citations: " + paper.getCitations() +
                               " - Pages: " + paper.getPages());
        }
    }
}