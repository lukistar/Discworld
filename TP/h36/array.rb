class Array
	def to_hash
		Hash[*self.flatten]
	end
	
	def index_by
		inject({}) { |hash, elem| hash.merge!(yield(elem) => elem) }
	end
	
	def subarray_count(subarray)
		self.each_cons(subarray.size).to_a.select {|item| item == subarray}.size
	end
	
	def occurences_count
		inject(Hash.new(0)) {|hash, elem| hash.merge!(elem => self.count(elem))}
	end
	
	def densities
		inject([]) { |array, elem| array.push( self.count(elem) ) }
	end
end
