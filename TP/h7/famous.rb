#school - ТУЕС www.elsys-bg.org
#class - 11Б
#num - 20
#name - Красимир Светославов Стойков
#task - Програма за намиране на най-много споменатото число(номер на ученик) в група от csv файлове
require 'csv'
lists = Dir.glob("*.csv")
Array.new number = Array.new(29){0}
for list_ in lists
	
	CSV.foreach(list_) do |row|
		for num in row
			if (num.to_i > 0)
				number[num.to_i-1] = number[num.to_i-1].to_i + 1
			end
		end
	end
	
end
max = number[0]
min = number[0]
print "Student's 'voices': \n"
for n in 0..29
	print (n+1).to_s + " - " + number[n].to_s + "\n"
	if (max < number[n])
		max = number[n]
		num_famous = n
	end 
	if (min > number[n])
		min = number[n]
		num_unfamous = n
	end 
end
print "\nThe most famous student(s) has(have) " + max.to_s + " and is(are) number(s): "
for n2 in 0..29
	if (number[n2] == max)
		print (n2+1).to_s + " "
	end
end
print "\nThe most unfamous student(s) has(have) " + min.to_s + " and is(are) number(s): "
for n3 in 0..29
	if (number[n3] == min)
		print (n3+1).to_s + " "
	end
end
print "\n"
