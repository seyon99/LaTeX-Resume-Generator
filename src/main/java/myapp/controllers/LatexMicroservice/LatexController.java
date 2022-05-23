package myapp.controllers.LatexMicroservice;

import java.util.HashMap;
import java.util.List;

public class LatexController implements ILatexGenerator {

    private HashMap<String, String> settings;


    public LatexController() {
        this.settings = new HashMap<String, String>();

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
        this.settings.put("packages", packages);

        String presets = "\\pagestyle{fancy}\n" +
                "\\fancyhf{}\n" +
                "\\fancyfoot{}\n" +
                "\\renewcommand{\\headrulewidth}{0pt}\n" +
                "\\renewcommand{\\footrulewidth}{0pt}\n" +
                "\\addtolength{\\oddsidemargin}{-0.6in}\n" +
                "\\addtolength{\\evensidemargin}{-0.5in}\n" +
                "\\addtolength{\\textwidth}{1.19in}\n" +
                "\\addtolength{\\topmargin}{-.7in}\n" +
                "\\addtolength{\\textheight}{1.4in}\n" +
                "\\urlstyle{same}\n" +
                "\\raggedbottom\n" +
                "\\raggedright\n" +
                "\\setlength{\\tabcolsep}{0in}\n" +
                "\\titleformat{\\section}{\n" +
                "\\vspace{-4pt}\\scshape\\raggedright\\large\\bfseries\n" +
                "}{}{0em}{}[\\color{black}\\titlerule \\vspace{-5pt}]\n" +
                "\\pdfgentounicode=1";
        this.settings.put("presets", presets);

        String customCommands = "\\newcommand{\\resumeItem}[1]{\n" +
                "  \\item\\small{\n" +
                "    {#1 \\vspace{-2pt}}\n" +
                "  }\n" +
                "}\n" +
                "\n" +
                "\\newcommand{\\classesList}[4]{\n" +
                "    \\item\\small{\n" +
                "        {#1 #2 #3 #4 \\vspace{-2pt}}\n" +
                "  }\n" +
                "}\n" +
                "\n" +
                "\\newcommand{\\resumeSubheading}[4]{\n" +
                "  \\vspace{-2pt}\\item\n" +
                "    \\begin{tabular*}{1.0\\textwidth}[t]{l@{\\extracolsep{\\fill}}r}\n" +
                "      \\textbf{#1} & \\textbf{\\small #2} \\\\\n" +
                "      \\textit{\\small#3} & \\textit{\\small #4} \\\\\n" +
                "    \\end{tabular*}\\vspace{-7pt}\n" +
                "}\n" +
                "\n" +
                "\\newcommand{\\resumeSubSubheading}[2]{\n" +
                "    \\item\n" +
                "    \\begin{tabular*}{0.97\\textwidth}{l@{\\extracolsep{\\fill}}r}\n" +
                "      \\textit{\\small#1} & \\textit{\\small #2} \\\\\n" +
                "    \\end{tabular*}\\vspace{-7pt}\n" +
                "}\n" +
                "\n" +
                "\\newcommand{\\resumeProjectHeading}[2]{\n" +
                "    \\item\n" +
                "    \\begin{tabular*}{1.001\\textwidth}{l@{\\extracolsep{\\fill}}r}\n" +
                "      \\small#1 & \\textbf{\\small #2}\\\\\n" +
                "    \\end{tabular*}\\vspace{-7pt}\n" +
                "}\n" +
                "\n" +
                "\\newcommand{\\resumeSubItem}[1]{\\resumeItem{#1}\\vspace{-4pt}}\n" +
                "\n" +
                "\\renewcommand\\labelitemi{$\\vcenter{\\hbox{\\tiny$\\bullet$}}$}\n" +
                "\\renewcommand\\labelitemii{$\\vcenter{\\hbox{\\tiny$\\bullet$}}$}\n" +
                "\n" +
                "\\newcommand{\\resumeSubHeadingListStart}{\\begin{itemize}[leftmargin=0.0in, label={}]}\n" +
                "\\newcommand{\\resumeSubHeadingListEnd}{\\end{itemize}}\n" +
                "\\newcommand{\\resumeItemListStart}{\\begin{itemize}}\n" +
                "\\newcommand{\\resumeItemListEnd}{\\end{itemize}\\vspace{-5pt}}";
        this.settings.put("customCommands", customCommands);

    }


    public String generateHeader(String name, String address, String phoneNum, String email, String linkedIn,
                                 String github, String website) {
        try {
            String headerTemplate = "\\begin{center}\n" +
                    "    {\\Huge \\scshape %s} \\\\ \\vspace{1pt}\n" +
                    "     %s \\\\ \\vspace{1pt}\n" +
                    "    \\small \\raisebox{-0.1\\height}\\faPhone\\ %s ~ \\href{mailto:%s}{\\raisebox{-0.2\\height}" +
                    "\\faEnvelope\\  \\underline{%s}} ~ \n" +
                    "    \\href{https://linkedin.com/in/%s}{\\raisebox{-0.2\\height}\\faLinkedin\\ " +
                    "\\underline{%s}}  ~\n" +
                    "    \\href{https://github.com/%s}{\\raisebox{-0.2\\height}\\faGithub\\ \\underline{%s}} ~\n" +
                    "    \\href{%s}{\\raisebox{-0.2\\height}\\faGlobe\\ \\underline{%s}}\n" +
                    "    \\vspace{-8pt}\n" +
                    "\\end{center}";

            String[] displayWebsite = null;
            if (website.contains("https://") || website.contains("http://")){
                displayWebsite = website.split("://");
            }

            String headerFormatted;
            if (displayWebsite != null) {
                headerFormatted = String.format(headerTemplate, name, address, phoneNum, email, email,
                        linkedIn, linkedIn, github, github, displayWebsite[1], website);
            }
            else {
                String websiteUrl = "https://" + website;
                headerFormatted = String.format(headerTemplate, name, address, phoneNum, email, email,
                        linkedIn, linkedIn, github, github, websiteUrl, website);
            }

            return headerFormatted;
        } catch (Exception e) {
            // Handle logging at the end
            return e.getMessage();
        }
    }

    @Override
    public String generateEducation(String instName, String dateRange, String degreeName, List<String> relCoursework) {
        return null;
    }

    @Override
    public String generateExperience(String companyName, String posName, String location, String dateRange, List<String> bulletPoints) {
        return null;
    }

    @Override
    public String generateProjects(String projName, String techStack, String dateRange, List<String> bulletPoints) {
        return null;
    }

    @Override
    public String generateTechnicalSkills(String langs, String frameworks, String devTools, String libs) {
        return null;
    }
}
