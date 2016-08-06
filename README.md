# coding
## How to build
Use command 'mvn package assembly:single' can build a jar with dependencies

## How to run
Use command 'java -jar *.jar <input_file> <output_file> <policy>'
e.g. 'java -jar target/coding-0.0.1-SNAPSHOT-jar-with-dependencies.jar src/test/resource/sample.txt ./out.txt fifo'
