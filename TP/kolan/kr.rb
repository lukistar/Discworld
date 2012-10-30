#school - ТУЕС www.elsys-bg.org
#class - 11Б
#num - 20
#name - Красимир Светославов Стойков
#task - Програма за събиране на числата в първата колонка спрямо налично изискване във втората
require 'csv'

	sum = 0
	CSV.foreach("feature_scenarios_times.csv") do |row|
		if row[1].eql?"features/instance_create_update.feature"
			sum = sum + row[0].to_f
		end
	end
	print sum
	CSV.open("output.csv", "w") do |write|
	write << [sum.to_i]
	break	
	end
