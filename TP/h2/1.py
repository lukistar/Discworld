#!/usr/local/bin/python

def is_number(s):
    try:
        float(s)
        return 1
    except ValueError:
        return 0

def read_CSV(FILE):
 import csv
 lines = []
 f = open(FILE)
 csv_reader = csv.reader( f, delimiter="," )
 for row in csv_reader:
   lines.append(row)
 return lines

data = read_CSV("file.csv")

def SUMA(column):
	i = 0 #broqch za sravnenie s izbranata ot potr kolonka
	suma = 0 #sumata na chislata
	z = 0 #broqch za elementite na "string" chisloto za zamenqne na ',' s '.'
	print data[1:] 
	for br in data[1:]:
		i = 0 #nuliram broqcha s koito dostigam jelanata kolonka
		for br2 in br:
			if (i == int(column)): #iznamiram zelanata ot potrebitelq kolonka
				z = 0 #nuliram preturvacha za ',' vmesto '.'(zashtoto floata strada ot ',' ;d)
				BREAK = 0
				while z <= len(br2)-1: #pretursvam dadento "chislo" za da proverq dali e vuv validen float format
					if br2[z] == ',':
						float_ = str(br2[:z]) + str('.') + str(br2[z+1:])
						if is_number(float_):
							suma = suma + float(float_)
						break
					z = z + 1
				if is_number(br2):
					if (BREAK == 0):
						suma = suma + float(br2)
					
			i = i + 1
	return suma
sbor = SUMA(5) #funkciqta priema nomera na kolonkata, chiqto suma se iska(nomeriraneto zapochva ot 0!)
print sbor
