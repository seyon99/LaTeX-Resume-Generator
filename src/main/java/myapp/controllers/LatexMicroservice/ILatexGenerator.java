package myapp.controllers.LatexMicroservice;

import java.util.HashMap;
import java.util.List;

public interface ILatexGenerator {

    public String generateHeader(String name, String address, String phoneNum, String email, String linkedIn,
                                 String github, String website);


    public String generateEducation(String instName, String dateRange, String degreeName, List<String> relCoursework);


    public String generateTechnicalSkills(List<String> langs, List<String> frameworks, List<String> techTools,
                                          List<String> prodInfra);

}

