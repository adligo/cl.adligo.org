cl = command line (yea its unix time)

this project contains reusable code for writing command line java programs
it also establishes some conventions;

1) If no arguments are passed to the command line program a 
	help/howto is displayed
	
2) Command line arguments are passed in inside of double quotes and 
   the key to the argument starts with a dash '-' ie;
   foo.sh -threads='25'

3) a -help command line argument should be provided
  
4) The layout of deployed adligo command line programs will follow;
   program_name_folder
   	bin
   		run.sh
   		run.bat (if windows is supported)
   	lib
   		someFiles.jar
   	conf
   		program_name_default_or_example_configuration.xml
   		
   		