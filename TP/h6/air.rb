#school - ТУЕС www.elsys-bg.org
#class - 11Б
#num - 20
#name - Красимир Светославов Стойков
#task - Програма за автоматично разпределяне на пътници по места в самолет
 
class AirPlane
	$seats = Array.new(6) {Array.new(27){0}}
	$sum = 0
	$Break = false
	
	def free_seats
			return 162-$sum
	end
	
	def print_seats
		for i in 0..26
			for i2 in 0..5
				print $seats[i2][i]
				if (i2 == 2) 
					print " "
				end
			end
			print "\n"
		end
	end
	
	def add(rvalue)
			for j in 0..26
				for k in 0..5
					if ($seats[k][j] == 0)  
						if (rvalue == 1)  
							$seats[k][j] = 1						
							$sum+=1
							$Break = true
							break					
						end
						if (rvalue == 2 && k<5 && k!=2 && $seats[k+1][j] == 0) 
							$seats[k][j] = 1
							$seats[k+1][j] = 1
							$sum+=2
							$Break = true
							break
						end
						if (rvalue == 3 && (k == 0 || k == 3) && $seats[k+1][j] == 0 && $seats[k+2][j] == 0) 
							$seats[k][j] = 1
							$seats[k+1][j] = 1
							$seats[k+2][j] = 1
							$sum+=3
							$Break = true
							break 
						end 
					end
				end
				if ($Break == true) 
					$Break = false
					break
				end				
			end
	
		end
end

Plane = AirPlane.new
while(Plane.free_seats != 0)
				rvalue = rand(3)+1
				if (Plane.free_seats >= rvalue) 
					Plane.add(rvalue)
				else
					print "No seats for you!\n" 
				end
end
Plane.print_seats
