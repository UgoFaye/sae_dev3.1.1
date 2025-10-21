default : run

run : compil exec

compil:
	mkdir -p build
	javac -d build -classpath "build:/export/documents/mariadb-client.jar" -sourcepath "src:tmp" src/fr/iutfbleau/remindme/*.java

exec:
	java -classpath "build:/export/documents/mariadb-client.jar" fr.iutfbleau.remindme.StartApp

papillon.jar : compil
	jar cvfe papillon.jar fr.iutfbleau.remindme.StartApp -C build .

clean :
	rm -rf build papillon.jar

.PHONY: default run compil exec clean