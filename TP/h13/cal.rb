#school - ТУЕС www.elsys-bg.org
#class - 11Б
#num - 20
#name - Красимир Светославов Стойков
#task - Калкулатор с обратен полски запис

class String
	def is_number?
    	self.to_i.to_s == self
  	end
  	def is_operator?
  		self.eql?"+" or self.eql?"-" or self.eql?"*" or self.eql?"/" or self.eql?"%" or self.eql?"**"
  	end
end
def Cal
	puts "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"
	puts "@@@ Using only numbers, spaces and operators works @@@"
	puts "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"
	input = gets
	input = input.split(" ")
	Array numbers = Array.new()
	for symbol in input
		if (symbol.is_number?)
			numbers.push(symbol.to_f)
		elsif (symbol.is_operator?)
			if (input.size > 1)
				if symbol.eql?"+"
					result = numbers.pop() + numbers.pop()
					numbers.push(result)				
				elsif symbol.eql?"-"
					result = -numbers.pop() + numbers.pop()
					numbers.push(result)
				elsif symbol.eql?"*"
					result = numbers.pop() * numbers.pop()
					numbers.push(result)
				elsif symbol.eql?"/"
					num1 = numbers.pop()
					result = numbers.pop() / num1
					numbers.push(result)
				elsif symbol.eql?"%"
					num1 = numbers.pop()
					result = numbers.pop() % num1
					numbers.push(result)
				elsif symbol.eql?"**"
					num1 = numbers.pop()
					result = numbers.pop() ** num1
					numbers.push(result)
				end
			else
				puts "ERROR! Suggestion: Type first two numbers and then some operator. Put space after every symbol"
				break;	
			end
		else
			puts "ERROR! Suggestion: Use only numbers, spaces and operators."
			break; 
		end
	end
	puts numbers[0]
end
check = ""
while (!check.eql?"exit")
	Cal()
	puts "If you want to exit type 'exit'. If you want to continue using the program press enter."
	check = gets.chomp
end