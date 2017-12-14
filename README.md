rest-examples-java
==================

Java-based examples for the Europass REST API

System requirements:
====================

JDK 7/JRE 7 or newer (http://www.oracle.com/technetwork/java/javase/downloads/index.html)
Apache Maven Project (http://maven.apache.org/download.cgi#Installation)

Installation:
=============

1. Run **mvn install** in project root dir. After that under /target would be created the .jar files.
   e.g. -rest-examples-java-1.0.0-SNAPSHOT.jar 
		-rest-examples-java-1.0.0-SNAPSHOT-jar-with-dependencies.jar (runnable)

2. Run **java -jar target/rest-examples-java-1.0.0-SNAPSHOT-jar-with-dependencies.jar** with required arguments (check following examples)

Arguments:
=========

Arguments we can pass to java application are (through -Dkey command line key options):
- **_type_** (_required_): The REST action to use

type | descr | url extension | 
--- | --- | --- | 
xml-to-pdf-cv-esp  | XML to PDF CV+ESP | /v1/document/to/pdf |
xml-to-pdf-esp-only  | XML to PDF ESP | /v1/document/to/pdf-esp |
xml-to-pdf-cv-only  | XML to PDF CV | /v1/document/to/pdf-cv | 
xml-to-doc  | XML to Word | /v1/document/to/word |
xml-to-odt  | XML to ODT | /v1/document/to/opendoc | 
xml-to-json  | XML to JSON | /v1/document/to/json |
xml-upgrade  | XML Upgrade | /v1/document/upgrade |
extract-xml  | XML Extraction | /v1/document/extraction | 
|  |  |  | 
json-to-pdf-cv-esp  | JSON to PDF CV+ESP | /v1/document/to/pdf |
json-to-pdf-esp-only  | JSON to PDF ESP | /v1/document/to/pdf-esp |
json-to-pdf-cv-only  | JSON to PDF CV | /v1/document/to/pdf-cv | 
json-to-doc  | JSON to Word | /v1/document/to/word |
json-to-odt  | JSON to ODT | /v1/document/to/opendoc | 
json-to-xml-cv  | JSON to XML CV | /v1/document/to/xml-cv |
json-to-xml-esp  | JSON to XML ESP | /v1/document/to/xml-esp |
json-to-xml  | JSON to XML CV+ESP | /v1/document/to/xml | 

- **_inputPathFile_** (_required_): Full path of input file (xml, json, pdf) to use.
- **_outputPathFile_** (_required_): Full path of output file (xml, json, pdf, odt etc.) that would store your data in this format
- **_baseRestUrl_** (_optional_): Explicitly initialize the restfull service base url (default: https://europass.cedefop.europa.eu/rest).
- **_language_** (_optional_): Two-letter code of locale for convertion of input file (default: en).

Examples:
=========

- java -**Dtype**=xml-to-pdf-cv-esp -**DinputPathFile**=C:\europass-cv-esp-example-v3.3.0.xml -**DoutputPathFile**=C:\test1.pdf -jar rest-examples-java-1.0.0-SNAPSHOT-jar-with-dependencies.jar
    
    When running the above example, you get your CV+ESP in pdf format (C:\test1.pdf).

- java -**Dtype**=xml-to-pdf-esp-only -**DinputPathFile**=C:\europass-esp-example-v3.3.0.xml -**DoutputPathFile**=C:\test2.pdf -jar rest-examples-java-1.0.0-SNAPSHOT-jar-with-dependencies.jar

    Previous call is generating ESP in pdf format (C:\test2.pdf).

- java -**Dtype**=xml-to-pdf-cv-only -**DinputPathFile**=C:\europass-cv-example-v3.3.0.xml -**DoutputPathFile**=C:\test3.pdf -jar rest-examples-java-1.0.0-SNAPSHOT-jar-with-dependencies.jar

    When running the above example, you get your CV in pdf format (C:\test3.pdf).

- java -**Dtype**=xml-to-doc -**DinputPathFile**=C:\europass-cv-example-v3.3.0.xml -**DoutputPathFile**=C:\test4.doc -**_DbaseRestUrl_**=https://europassd.cedefop.europa.eu/rest -jar rest-examples-java-1.0.0-SNAPSHOT-jar-with-dependencies.jar

    The generated document is saved in C:\test4.doc (using custom restfull service base url).

- java -**Dtype**=json-to-odt -**DinputPathFile**=C:\europass-cv-example-v3.3.0.json -**DoutputPathFile**=C:\test5.odt -**_Dlanguage_**=fr -jar rest-examples-java-1.0.0-SNAPSHOT-jar-with-dependencies.jar

    The generated document is saved in C:\test5.odt (using json as input file and locale for conversion fr).

- java -**Dtype**=json-to-word -**DinputPathFile**=C:\europass-cv-example-v3.3.0.json -**DoutputPathFile**=C:\test6.doc -**_Dlanguage_**=fr -jar rest-examples-java-1.0.0-SNAPSHOT-jar-with-dependencies.jar

    The generated document is saved in C:\test6.doc (using json as input file and locale for conversion fr).

- java -**Dtype**=xml-to-json -**DinputPathFile**=C:\europass-cv-example-v3.3.0.xml -**DoutputPathFile**=C:\test7.json -jar rest-examples-java-1.0.0-SNAPSHOT-jar-with-dependencies.jar

    Previous example is generating a json from xml and saves in C:\test7.json.

- java -**Dtype**=json-to-xml -**DinputPathFile**=C:\europass-cv-example-v3.3.0.json -**DoutputPathFile**=C:\test8.xml -jar rest-examples-java-1.0.0-SNAPSHOT-jar-with-dependencies.jar

    Previous example is generating a xml from json and saves in C:\test8.xml.

- java -**Dtype**=xml-version-upgrade -**DinputPathFile**=C:\oldVersionFile.xml -**DoutputPathFile**=C:\newVersionFile.xml -jar rest-examples-java-1.0.0-SNAPSHOT-jar-with-dependencies.jar

    Converts a Europass CV (or LP) in XML format v2.0 or older to a Europass CV in XML format v3.0 or later.

- java -**Dtype**=extract-xml-attachment -**DinputPathFile**=C:\CV-Europass-2017-John-Smith.pdf -**DoutputPathFile**=C:\CVJohnSmith.xml -jar rest-examples-java-1.0.0-SNAPSHOT-jar-with-dependencies.jar

    Extracts the XML attachment from a Europass PDF+XML (v3.0 or older).

Other examples:
- java -**Dtype**=json-to-pdf-cv-esp -**DinputPathFile**=C:\europass-cv-example-v3.3.0.json -**DoutputPathFile**=C:\test9.pdf -jar rest-examples-java-1.0.0-SNAPSHOT-jar-with-dependencies.jar
- java -**Dtype**=json-to-pdf-cv-only -**DinputPathFile**=C:\europass-cv-example-v3.3.0.json -**DoutputPathFile**=C:\test10.pdf -jar rest-examples-java-1.0.0-SNAPSHOT-jar-with-dependencies.jar
- java -**Dtype**=json-to-pdf-esp-only -**DinputPathFile**=C:\europass-cv-example-v3.3.0.json -**DoutputPathFile**=C:\test11.pdf -jar rest-examples-java-1.0.0-SNAPSHOT-jar-with-dependencies.jar
