package Attributes;

import java.io.Serializable;
import java.time.LocalDate;
import Interfaces.Researchable;

public class ResearchPaper implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String description;
    private int citations;
    private int pages;
    private LocalDate datePublished;
    private Researchable researcher; 
    
    
    public ResearchPaper(Researchable researcher, String name, String description, int citations, int pages) {
        this.researcher = researcher;
        this.name = name;
        this.description = description;
        this.citations = citations;
        this.pages = pages;
        this.datePublished = LocalDate.now();
    }

    public String getName() { 
        return name; 
    }

    public void setName(String name) { 
        this.name = name; 
    }

    public String getDescription() { 
        return description; 
    }

    public void setDescription(String description) { 
        this.description = description; 
    }

    public int getCitations() { 
        return citations; 
    }

    public void setCitations(int citations) { 
        this.citations = citations; 
    }

    public int getPages() { 
        return pages; 
    }

    public void setPages(int pages) { 
        this.pages = pages; 
    }

    public LocalDate getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(LocalDate datePublished) {
        this.datePublished = datePublished;
    }

    public Researchable getResearcher() {
        return researcher;
    }

    public void setResearcher(Researchable researcher) {
        this.researcher = researcher;
    }

    @Override
    public String toString() {
        return "Research Paper: " + name + "\nDescription: " + description +
               "\nCitations: " + citations + "\nPages: " + pages +
               "\nPublished on: " + datePublished +
               "\nResearcher: " + researcher.toString();
    }
}
