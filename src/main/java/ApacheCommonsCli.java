import org.apache.commons.cli.*;

public class ApacheCommonsCli {


    public static void main(String[] args) throws Exception {

        /**
         * 1. Definition Stage
         * Each command line must define the set of options that will be used to define the interface to the application.
         *
         * CLI uses the Options class, as a container for Option instances. There are two ways to create Options in CLI. One of them is via the constructors, the other way is via the factory methods defined in Options.
         *
         * The Usage Scenarios document provides examples how to create an Options object and also provides some real world examples.
         *
         * The result of the definition stage is an Options instance.
         */
        Options options = new Options();

        Option input = new Option("i", "input", true, "input file path");
        input.setRequired(true);
        options.addOption(input);

        Option output = new Option("o", "output", true, "output file");
        output.setRequired(true);
        options.addOption(output);

        /**
         * 2. Parsing Stage
         * The parsing stage is where the text passed into the application via the command line is processed. The text is processed according to the rules defined by the parser implementation.
         *
         * The parse method defined on CommandLineParser takes an Options instance and a String[] of arguments and returns a CommandLine.
         *
         * The result of the parsing stage is a CommandLine instance.
         */
        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd = null;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("utility-name", options);

            System.exit(1);
        }

        /**
         * 3. Interrogation Stage
         * The interrogation stage is where the application queries the CommandLine to decide what execution branch to take depending on boolean options and uses the option values to provide the application data.
         *
         * This stage is implemented in the user code. The accessor methods on CommandLine provide the interrogation capability to the user code.
         *
         * The result of the interrogation stage is that the user code is fully informed of all the text that was supplied on the command line and processed according to the parser and Options rules.
         */
        String inputFilePath = cmd.getOptionValue("input");
        String outputFilePath = cmd.getOptionValue("output");

        System.out.println(inputFilePath);
        System.out.println(outputFilePath);

    }

}