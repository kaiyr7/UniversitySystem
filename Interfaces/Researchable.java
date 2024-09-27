package Interfaces;

import java.util.Comparator;
import java.util.Vector;

import Attributes.ResearchPaper;

public interface Researchable {
	double calculateHIndex();
	void doResearchPapers(ResearchPaper researchPaper);
	void printResearchPapers(Comparator<ResearchPaper> comparator);
	Vector<ResearchPaper> getResearchPapers();
}
