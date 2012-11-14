#school - ТУЕС www.elsys-bg.org
#class - 11Б
#num - 20
#name - Красимир Светославов Стойков
#task - Калкулатор с обратен полски запис

class String
  def is_integer?
    self.to_i.to_s == self
  end
  def is_operator?
  	self.eql?"+" or self.eql?"-" or self.eql?"*" or self.eql?"/"
  end
end
Array numbers = Array.new()
input = gets
input = input.split(" ")
count = 0
for index in 0..input.size-1
	if input[index].is_integer?
			numbers[count] = input[index].to_i
			count+=1
	elsif input[index].is_operator?
			result = 0
			if input[index].eql?"+"
				result = numbers[0] + numbers[1]
			elsif input[index].eql?"-"
				result = numbers[0] - numbers[1]
			elsif input[index].eql?"*"
				result = numbers[0] * numbers[1]
			elsif input[index].eql?"/"
				result = numbers[0] / numbers[1]
			end
			count = 1
			numbers.clear
			numbers[0] = result
	end
end
print numbers[0]
