#!/usr/local/bin/python
#school - ТУЕС
#class - 11Б
#num - 20
#name - Красимир Светославов Стойков
#task - Да се съберат номерата от една колонка  зажисимост от нещо в някоя друга. От csv файл

def is_int(s):
    try:
        int(s)
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

# column1 - column with numbers (1 - first column!!!)
# column2 - column with languages
def h(data, column1, column2):
	sums = [0, 0, 0]
	for row in data[1:]:
		st = row[column2-1]
		if is_int(row[column1-1]):
			if st == "Ruby":
				sums[0] = sums[0] + int(row[column1-1])
			elif st == "Python":
				sums[1] = sums[1] + int(row[column1-1])
			elif st == "Perl":
				sums[2] = sums[2] + int(row[column1-1])
	return sums

choice1 = raw_input("Insert the number of the column with class numbers(1 - first column)")
choice2 = raw_input("Insert the number of the column with used languages(1 - first column)")
sums = h(read_CSV("file3.csv"), int(choice1), int(choice2))
print "Ruby: ", sums[0]
print "Python: ", sums[1]
print "Perl: ", sums[2]
