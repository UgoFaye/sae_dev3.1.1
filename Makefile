
default : run

run : compil exec

compil: 
	javac -d build -classpath "build:/export/documents/mariadb-client.jar" -sourcepath "src:tmp" src/fr/iutfbleau/remindme/*.java

exec:
	java -classpath "build:/export/documents/mariadb-client.jar" fr.iutfbleau.remindme.StartApp
