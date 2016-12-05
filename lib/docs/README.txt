Microlog Java ME library
========================

Introduction
------------

Features/benefits
* Similar to Log4j. The Logger class could be found here.
* Easy to setup.
* Small
* Fast
* Many different Appenders

  On-device appenders
  ===================
  -ConsoleAppender - Appends to the console, e.g. System.out.'
  -RecordStoreAppender - Appends to the RecordStore.
  -FileAppender  -  Appends to a file using a FileConnection.
  -CanvasAppender - Appends to a Canvas.
  -FormAppender - Appends to a Form.
  
  Off-device appenders
  ====================
  -BluetoothSerialAppender - Appends to a Bluetooth serial connection (btspp).
  -HttpAppender - Appends to a HTTP server using HTTP PUT. 
  -SerialAppender - Appends to a serial port (CommConnection).
  -SmsAppender - Appends to a cyclic buffer and send the buffer as an SMS.
  -MmsAppender - Appends to a cyclic buffer and send the buffer as an MMS and/or e-mail.
  -DatagramAppender - Appends to a datagram and send it using UDP.
  -SyslogAppender - Appends to syslog server.
  -SocketAppender - Appends to a socket connection (also SSL).
  -S3FileAppender - Appends to a file, as in the FileAppender, and stores the file on Amazon S3.
  -S3BufferAppender - Appends to a cyclic buffer and stores it as a file on Amazon S3.
  
* Customizable formatting with PatternFormatter.
* Quality Assurance with
  -Unit tests (JMUnit and Hammocks for Java ME combined with JUnit tests under Java SE)
  -Code checks (FindBugs & Lint4j)


Getting Started
---------------
There are numerous articles on the Internet about Microlog:

* For tips and tricks, please visit the official Microlog blog:
http://myossdevblog.blogspot.com/

* A good introduction to Microlog V2 (actually it is written for the 2.0.0-SNAPSHOT version):
http://wiki.forum.nokia.com/index.php/Microlog:_A_Log4j-based_tool_for_the_JavaME_platform


Note: The Microlog Bluetooth server requires Java 5 or newer


Examples
--------
See the example MIDlets in the Microlog Java ME library Example module in the 
package net.sf.microlog.example.

Credits
-------

We would like to thank the following people for contributing with their code
Ricardo Amores Hernández - CanvasAppender.
Marius de Beer - DatagramAppender formerly known as GPRSAppender.

Contact
-------
Please use the forums for bug reports, feature requests or questions about
Microlog: http://sourceforge.net/projects/microlog/

The Microlog team consists of:
Johan Karlsson  - project admin, developer & initiator
Darius Katz     - project admin, developer & graphics artist
Karsten Ohme    - developer & Maven specialist
Jarle Hansen    - developer and Bluetooth specialist









