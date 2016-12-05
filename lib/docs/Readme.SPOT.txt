The Microlog4SPOT code has been merged into the Microlog and is now an official part of Microlog.
This document is the original documentation from the Microlog3SPOT download.

Thanks for M Kranz for donating this code to the Microlog project.

------------------------------------------------------------------------------------------------


Introduction
------------

This is a quick port of MicroLog ( http://sourceforge.net/projects/microlog/ )
to the SunSPOTs. I might not develop this any further, but it has been released
in the hope that someone else might find it useful.

Incompatible code has been removed (all lcdui code, UTF-8 encoding), as well as
a couple of quick fixes (ConfigurableFormatter now works properly).

Note: I have not updated the javadoc to include my 'fixes'

Quickstart
----------

Building
--------

Build this library as a SPOT utility library:

ant jar-deploy -Djar.file=microlog.jar


Now compile your SPOT application against this library:

ant -Dutility.jars=$MICROLOG/microlog.jar deploy

where MICROLOG is the microlog folder

Running
-------

In your application's directory, enter

ant run

, which will connect to the target SPOT, and redirect it's stdout stream to the
local terminal (Useful for directly reading a ConsoleAppender). Use CTRL+C to
disconnect.

Loading logs
------------

If a node has been running with a RecordStoreAppender, the log messages will be
redirected to the onboard flash. To read this log, deploy and run the
microlog.jar library -- the manifest is set to run
net.sf.microlog.example.RecordStoreLogViewer by default.

ant -Djar.file=microlog.jar jar-deploy run

Using loggin in a program
-------------------------

Make sure the logger is initialised at the beginning of the MIDlet

  Logger log = Logger.getLogger();
  GlobalProperties.init(this);
  GlobalProperties props = GlobalProperties.getInstance();
  log.configure(props.getProperties());

Then just use the logger in the same manner as log4j:

  log.debug("Something is happening");
  log.info("Some info");
  log.error("An error!");


ConfigFile
----------

Here is a sample file with inline comments:

# Sets the level to log. See log4j documentation for a more in-depth discussion
microlog.level=DEBUG
#
# Comma seperated list of appenders. FileAppender was removed (no FS on SPOTs)
#   ConsoleAppender -- can only be viewed when SPOT client is connected via
#                      'ant run'
#   RecordStoreAppender -- stores log to record store, can be viewed by
#                      deploying and running the microlog jar file
#                      
microlog.appender=net.sf.microlog.appender.RecordStoreAppender;net.sf.microlog.appender.ConsoleAppender
# The maximum number of log entries to be held in the record store
microlog.appender.RecordStoreAppender.maxLogEntries=500
# Note- time is only needed for console appender
# RecordStoreLogViewer will still display time without this variable set 
#
# The formatter to use
#   SimpleFormatter -- logs the debug level and message only
#   ConfigurableFormatter -- has the following options
#                      level     :  if true, logs the debug level
#                      message   :  if true, logs the debug message
#                      time      :  'date' to print entire date with message
#                                   'millis' to print time in milliseconds
#                                   NOTE: only needed for consoleviewer
#                                       date is always stored/viewed when
#                                       reading RMS log
#                      delimiter :  delimiter string between message parts
microlog.formatter=net.sf.microlog.format.ConfigurableFormatter;level=true;message=true;time=none;delimiter= :  
# End of file. Do not remove this line.



Notes
-----

Streaming uses sectors 39-46, so RMS gets sectors 47-69 (64kb per sector)
To give more space to RMS, set less space for streaming

spot.sectors.reserved.for.streaming (default=8)


Future
------

* Per class and per app appenders, per appender formatters (ala log4j)
* Deploy as library to flash, for reuse in all apps


Contact
-------
Mark Kranz
<mkranz@gmail.com>






