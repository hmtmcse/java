package com.hmtmcse.console.menu;

import org.apache.commons.cli.*;

public class CLITester2 {

    public static void main(String[] args) throws ParseException {

        Options options = new Options();

        Option logfile   = Option.builder("Agol")
                .longOpt("logFile")
                .argName("file" )
                .hasArg()
                .desc("use given file for log" )
                .build();

        options.addOption(logfile);

        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("CLITester", options);

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse( options, args);

        // has the logFile argument been passed?
        if(cmd.hasOption("logFile")) {

            //get the logFile argument passed
            System.out.println( cmd.getOptionValue( "logFile" ) );
        }
    }
}
