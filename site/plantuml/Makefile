all: description.pdf

description.pdf: description.tex compact.png classes.png full.png ApplicationDataset.png ApplicationDifference.png ApplicationObject.png ApplicationWarning.png Area.png ConstituencyType.png County.png Distance.png DistanceError.png ElectoralDivision.png Lea.png MapLocation.png NeighborCounty.png Nuts3.png Province.png Scenario.png Shaped.png SolConstType.png SolCounty.png SolTransfer.png Solution.png
	pdflatex description
	pdflatex description
	pdflatex description

%.png:%.txt
	java -jar plantuml-1.2024.7.jar $<

clean:
	rm -f *.png *.pdf

