#school - ТУЕС www.elsys-bg.org
#class - 11Б
#num - 20
#name - Красимир Светославов Стойков
#task - Програма за намиране на най-много споменатото число(номер на ученик) в група от csv файлове
require 'csv'
lists = Dir.glob("*.csv")
Array.new number = Array.new(30){0}
Array.new taken = Array.new(30){Array.new(30){0}}
br = 0
z = 0
for list_ in lists
	check_ = false
	for check in 1..9
		check_ = list_[1].eql?check.to_s
		if (check_)
			break
		end
	end
	if (check_ == true)
		last_number = list_[0].to_i + list_[1].to_i
	else
		last_number = list_[0].to_i
	end
	CSV.foreach(list_) do |num| 
			if (num[0].to_i > 0)
				number[num[0].to_i-1] = number[num[0].to_i-1].to_i + 1
				taken[num[0].to_i-1][last_number.to_i] = taken[num[0].to_i-1][last_number.to_i].to_i
				taken[num[0].to_i-1][last_number.to_i]+=1
				last_number = num[0].to_i-1
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
Array.new maxxx = Array.new(30){0}
for h1 in 0..29
	maxxx[h1] = taken[h1][0]
	for h2 in 1..29
		if (maxxx[h1] < taken[h1][h2]) 
			maxxx[h1] = taken[h1][h2]
		end
	end
end
Array.new maxxx_ = Array.new(30){Array.new(1){0}}
for b1 in 0..29
	z = 0
	for b2 in 0..29
		if (taken[b1][b2] == maxxx[b1])
			maxxx_[b1][z] = b2+1
			z+=1
		end
	end
end
print "Ot koi chovek vseki e pulichil lista si nai-mnogo: \n"
for g in 0..29
	print "number" + (g+1).to_s + " from: "
	print maxxx_[g]
	print "\n"
end