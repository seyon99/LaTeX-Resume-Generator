package myapp.controllers;

import java.util.HashMap;

public class LatexController {

    private HashMap<String, String> latexStrings;


    public LatexController(){
        this.latexStrings = new HashMap<String, String>();
        String packages = "\\documentclass[letterpaper,11pt]{article}+" +
                "\\usepackage{latexsym}\n" +
                "\\usepackage[empty]{fullpage}\n" +
                "\\usepackage{titlesec}\n" +
                "\\usepackage{marvosym}\n" +
                "\\usepackage[usenames,dvipsnames]{color}\n" +
                "\\usepackage{verbatim}\n" +
                "\\usepackage{enumitem}\n" +
                "\\usepackage[hidelinks]{hyperref}\n" +
                "\\usepackage{fancyhdr}\n" +
                "\\usepackage[english]{babel}\n" +
                "\\usepackage{tabularx}\n" +
                "\\usepackage{fontawesome5}\n" +
                "\\usepackage{multicol}\n" +
                "\\setlength{\\multicolsep}{-3.0pt}\n" +
                "\\setlength{\\columnsep}{-1pt}\n" +
                "\\input{glyphtounicode}";
        this.latexStrings.put("packages", packages);

    }


    public String generateHeader(String name){
        return "";
    }
}
