package com.hmtmcse.cli;

import org.apache.commons.cli.*;

public class CLITester {
    public static void main(String[] args) throws ParseException {

// create the command line parser
        CommandLineParser parser = new DefaultParser();

// create the Options
        Options options = new Options();
        options.addOption( "a", "all", false, "do not hide entries starting with ." );
        options.addOption( "A", "almost-all", false, "do not list implied . and .." );
        options.addOption( "b", "escape", false, "print octal escapes for nongraphic "
                + "characters" );

        options.addOption( "B", "ignore-backups", false, "do not list implied entried "
                + "ending with ~");
        options.addOption( "c", false, "with -lt: sort by, and show, ctime (time of last "
                + "modification of file status information) with "
                + "-l:show ctime and sort by name otherwise: sort "
                + "by ctime" );
        options.addOption( "C", false, "list entries by columns" );

        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("CLITester", options);

         args = new String[]{ "--block-size=10" };

        try {
            // parse the command line arguments
            CommandLine line = parser.parse( options, args );

            // validate that block-size has been set
            if( line.hasOption( "block-size" ) ) {
                // print the value of block-size
                System.out.println( line.getOptionValue( "block-size" ) );
            }
        }
        catch( ParseException exp ) {
            System.out.println( "Unexpected exception:" + exp.getMessage() );
        }
    }
}