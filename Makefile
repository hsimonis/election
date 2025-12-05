all: ElectionFx-1.0.exe

ElectionFx-1.0.exe: package.bat
	mvn clean package
	./package.bat

clean:
	rm -f *.exe

