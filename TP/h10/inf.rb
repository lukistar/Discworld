#encoding: utf-8

#school - ТУЕС www.elsys-bg.org
#class - 11Б
#num - 20
#name - Красимир Светославов Стойков
#task - Програма за обработка на разностранна информация от множество csv файлове.

require 'csv'
require 'time'

class Homework

	@number
	@name
	@last_date
	@sent_date
	@on_time
	@link
	
	def g_number() return @number; end
	def g_name() return @name; end
	def g_last_date() return @last_date; end
	def g_sent_date() return @sent_date; end
	def g_on_time() return @on_time; end
	def g_link() return @link; end
	
	def initialize(number = 0, name = "", last_date = 0, sent_date = "", on_time = "yes", link = "") 
		@number = number
		@name = name
		@last_date = last_date
		@sent_date = sent_date
		@on_time = on_time
		@link = link
	end
	
	def init(number, name, last_date, sent_date, on_time, link) 
		@number = number
		@name = name
		@last_date = last_date
		@sent_date = sent_date
		@on_time = on_time
		@link = link
	end
	
	def print_
		print "number: ", @number, "\n"
	end
end

class Student

	@grade
	@number
	@name
	@email
	@belt
	@homeworks #array of homeworks
	@count #count of homeworks
	
	def g_grade() return @grade; end
	def g_number() return @number; end
	def g_name() return @name; end
	def g_email() return @email; end
	def g_belt() return @belt; end
	
	def s_grade(grade) @grade = grade; end  
	def s_number(number) @number = number; end
	def s_name(name) @name = name; end
	def s_email(email) @email = email; end
	def s_belt(belt) @belt = belt; end
	
	def gh_number() return @homeworks[0].g_number(); end
	def gh_name() return @homeworks[0].g_name(); end
	def gh_last_date() return @homeworks[0].g_last_date(); end
	def gh_sent_date() return @homeworks[0].g_sent_date(); end
	def gh_on_time() return @homeworks[0].g_on_time(); end
	def gh_link() return @homeworks[0].g_link(); end
	
	def g_homeworks() return @homeworks; end
	def g_count() return @count; end
	
	def initialize(grade = "", number = "", name = "", email = "", belt = "white")
		@grade = grade
		@number = number
		@name = name
		@email = email
		@belt = belt
		@count = 0
		Array.new @homeworks = Array.new(1){Homework.new} 
	end
	
	def init(grade, number, name, email, belt = "white")
		@grade = grade
		@number = number
		@name = name
		@email = email
		@belt = belt
	end
	
	def add(number, name, last_date, sent_date, on_time, link)
		@homeworks[@count] = Homework.new(number, name, last_date, sent_date, on_time, link)
		@count+=1
	end
	
	def print_
		print "class: ", @grade, " number: ", @number, " name: ", @name, " email: ", @email, " belt: ", @belt, "\n"
		for zz in @homeworks
			print zz.g_number, " ", zz.g_name, zz.g_last_date, " ", zz.g_sent_date, " ", zz.g_on_time, " ", zz.g_link, "\n" 
		end 
	end
end

Array.new $dates = Array.new
$dates[0] = "10/10/2013 00:00:00"
$dates[1] = "10/10/2013 00:00:00"
$dates[2] = "10/10/2013 00:00:00"
$dates[3] = "10/10/2013 00:00:00"
$dates[4] = "10/10/2013 00:00:00"
$dates[5] = "10/10/2012 20:00:00"
$dates[6] = "15/10/2012 20:00:00"
$dates[7] = "17/10/2012 20:00:00"
$dates[8] = "22/10/2012 20:00:00"

count = 0
count_sent = 0
Array.new students = Array.new
lists = Dir.glob("*.csv")
for list in lists
	count = 0
	CSV.foreach(list) do |row|
		if (count == 0)
		
		else
			if (row[2] != nil)
				count_sent+=1	
				students[count_sent-1] = Student.new
				students[count_sent-1].init(row[1], row[2], row[3], row[4])
				number = list[0] #homework number
				name = list[3..-14] #homework name
				last_date = Time.parse($dates[number.to_i-1])
				t = row[0].split(" ")
				t2 = t[0].split("/")
				t[0] = t2[1] + "/" + t2[0] + "/" + t2[2]
				sent_date = t[0] + " " + t[1]
				sent_date = Time.parse(sent_date)
				if last_date - sent_date > 0
					on_time = true
				else
					on_time = false
				end
				for l in row
					if l =~ /http/
						link = l
					end
				end
				students[count_sent-1].add(number, name, last_date, sent_date, on_time, link)
			end
		end
		count+=1
	end
end

lat_bul1 = { "zh"=>"ж", "ch"=>"ч", "sh"=>"ш", "sht"=>"щ", "yu"=>"ю", "ju"=>"ю", "ja"=>"я", "ya"=>"я" }
lat_bul2 = { "Zh"=>"Ж", "Ch"=>"Ч", "Sh"=>"Ш", "Sht"=>"Щ", "Yu"=>"Ю", "Ju"=>"Ю", "Ja"=>"Я", "Ya"=>"Я" }
lat_bul3 = { 
		"a" => "а",
		"b" => "б",
		"v" => "в",
		"w" => "в",
		"g" => "г",
		"d" => "д",
		"e" => "е",
		"z" => "з",
		"i" => "и",
		"j" => "й",
		"k" => "к",
		"l" => "л",
		"m" => "м",
		"n" => "н",
		"o" => "о",
		"p" => "п",
		"r" => "р",
		"s" => "с",
		"t" => "т",
		"u" => "у",
		"f" => "ф",
		"h" => "х",
		"x" => "х",
		"c" => "ц",
		"q" => "я" 
}
lat_bul4 = { 
		"A" => "А",
		"B" => "Б",
		"V" => "В",
		"W" => "В",
		"G" => "Г",
		"D" => "Д",
		"E" => "Е",
		"Z" => "З",
		"I" => "И",
		"J" => "Й",
		"K" => "К",
		"L" => "Л",
		"M" => "М",
		"N" => "Н",
		"O" => "О",
		"P" => "П",
		"R" => "Р",
		"S" => "С",
		"T" => "Т",
		"U" => "У",
		"F" => "Ф",
		"H" => "Х",
		"X" => "Х",
		"C" => "Ц",
		"Q" => "Я" 
}
lat_bul_class = {"a" => "А", "b" => "Б", "A" => "Б", "B" => "Б"}
for student in students
	if (student.g_name == nil)
		students.delete(student)
	end
end
for student in students
	lat_bul_class.each do |key, word|
		if student.g_grade().include?key
			student.g_grade()[key] = lat_bul_class[key] 
		end
	end
	lat_bul1.each do |key, word|
		while(student.g_name().include?key)
			student.g_name()[key] = lat_bul1[key]
		end
	end
	lat_bul2.each do |key, word|
		while(student.g_name().include?key)
			student.g_name()[key] = lat_bul2[key]
		end
	end
	lat_bul3.each do |key, word|
		while(student.g_name().include?key)
			student.g_name()[key] = lat_bul3[key]
		end
	end
	lat_bul4.each do |key, word|
		while(student.g_name().include?key)
			student.g_name()[key] = lat_bul4[key]
		end
	end
end

size1 = students.size-1
founded = 0
size2 = size1
for i1 in 0..size1
	for i2 in i1..size1
		if i2 <= size2
			equals2 = 0
			if students[i1].g_number().eql?students[i2].g_number()
				equals2+=1
			end
			if students[i1].g_name().eql?students[i2].g_name()
				equals2+=1
			end
			if students[i1].g_email().eql?students[i2].g_email()
				equals2+=1
			end
			if equals2 >= 3
				bool = false
				if i2!=i1
					for i3 in 0..students[i2].g_count-1
						stud = students[i2].g_homeworks[i3]
						students[i1].add(stud.g_number(), stud.g_name(), stud.g_last_date(), stud.g_sent_date(), stud.g_on_time(), stud.g_link())
					end
					students.delete(students[i2])
					size2-=1
				end
			end
			
		end
		i2+=1 
	end
	i1+=1
end



size11 = students.size-1
founded = 0
size22 = size11
for i1 in 0..size11
	for i2 in i1..size11
		if i2 <= size22
			equals2 = 0
			if students[i1].g_number().eql?students[i2].g_number()
				equals2+=1
			end
			if students[i1].g_name().eql?students[i2].g_name()
				equals2+=1
			end
			if students[i1].g_email().eql?students[i2].g_email()
				equals2+=1
			end
			if equals2 >= 2
				bool = false
				if i2!=i1
					for i3 in 0..students[i2].g_count-1
						stud = students[i2].g_homeworks[i3]
						students[i1].add(stud.g_number(), stud.g_name(), stud.g_last_date(), stud.g_sent_date(), stud.g_on_time(), stud.g_link())
					end
					students.delete(students[i2])
					size22-=1
				end
			end
			
		end
		i2+=1 
	end
	i1+=1
end

size111 = students.size-1
founded = 0
size222 = size111
for i1 in 0..size111
	for i2 in i1..size111
		if i2 <= size222
			equals2 = 0
			if students[i1].g_email().eql?students[i2].g_email()
				equals2+=1
			end
			if equals2 >= 1
				bool = false
				if i2!=i1
					for i3 in 0..students[i2].g_count-1
						stud = students[i2].g_homeworks[i3]
						students[i1].add(stud.g_number(), stud.g_name(), stud.g_last_date(), stud.g_sent_date(), stud.g_on_time(), stud.g_link())
					end
					students.delete(students[i2])
					size222-=1
				end
			end
			
		end
		i2+=1 
	end
	i1+=1
end

for student in students
	if (student.g_grade.include?"b" or student.g_grade.include?"B" or student.g_grade.force_encoding("UTF-8").include?"б" or student.g_grade.force_encoding("UTF-8").include?"Б")
		student.s_grade("11Б".force_encoding("UTF-8"))
	end
	if student.g_grade.include?"a" or student.g_grade.include?"A" or student.g_grade.force_encoding("UTF-8").include?"а" or student.g_grade.force_encoding("UTF-8").include?"А"
		student.s_grade("11А".force_encoding("UTF-8"))
	end
end
for student in students
	student.g_homeworks.sort_by! {|x| [x.g_number, x.g_sent_date] }
end
students = students.sort_by { |x| [x.g_grade, x.g_number.to_i, x.g_name] }
CSV.open('output_file.csv', 'w') do |writer|
	for student in students
		if student.g_email != nil
		writer << [student.g_grade.force_encoding("UTF-8"), student.g_number.force_encoding("UTF-8"), student.g_name.force_encoding("UTF-8"), student.g_email.force_encoding("UTF-8"), student.g_belt.force_encoding("UTF-8")]
		for ggg in 0..student.g_homeworks.size-1
			temp = student.g_homeworks[ggg]
			writer << [temp.g_number.force_encoding("UTF-8"), temp.g_name, temp.g_last_date, temp.g_sent_date, temp.g_on_time, temp.g_link]
		end
		end
	end
end


