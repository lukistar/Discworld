#school - ТУЕС www.elsys-bg.org
#class - 11Б
#num - 20
#name - Красимир Светославов Стойков
#task - Програмата взима име на csv файл от подадените й аргументи и го отваря. В нов файл се записват резултатите от делението на числата в файла, от който четем, с две. Намира се сумата на числата от втората колонка на файла, от който четем. Сумата се извежда.
require 'csv'
input_file = ARGV[0]
p input_file

output_file = "output" + input_file
puts output_file
sum=0
CSV.open(output_file, "w") do |csv|
	CSV.foreach(input_file) do |row|
		csv << [row[0].to_i/2, row[1].to_i/2]
		sum += row[1].to_i
	end
end
p sum



