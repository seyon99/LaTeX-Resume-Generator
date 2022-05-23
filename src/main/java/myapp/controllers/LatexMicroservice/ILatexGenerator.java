package myapp.controllers.LatexMicroservice;

import java.util.HashMap;
import java.util.List;

public interface ILatexGenerator {

    /**
     * Generates LaTeX for a resume header using the provided parameters
     * @param name Name of resume subject
     * @param address Address of resume subject (in whichever format the user prefers)
     * @param phoneNum Phone number of the resume subject
     * @param email Email of the resume subject
     * @param linkedIn LinkedIn username of the resume subject (i.e. john-doe)
     * @param github GitHub username of the resume subject (i.e. johndoe11)
     * @param website Personal website url of the resume subject (https://www.johndoe.com)
     * @return  formatted String LaTeX for a resume header
     */
    public String generateHeader(String name, String address, String phoneNum, String email, String linkedIn,
                                 String github, String website);


    public String generateEducation(String instName, String dateRange, String degreeName, List<String> relCoursework);


    public String generateExperience(String companyName, String posName, String location, String dateRange,
                                     List<String> bulletPoints);


    public String generateProjects(String projName, String techStack, String dateRange, List<String> bulletPoints);


    public String generateTechnicalSkills(String langs, String frameworks, String devTools,
                                          String libs);

}

