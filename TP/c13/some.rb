class Some
	attr_accessor: value
	def method
		p "..."
	end
end
o = Some.new
p o.value
o.value = 10
p o.value
