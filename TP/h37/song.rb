class String
	def to_a
		[self]
	end
end

class Song
	attr_accessor :name, :artist, :genre, :subgenre, :tags
	
	def initialize(song)
		@name 		= song[:name]
		@artist 	= song[:artist]
		@genre  	= song[:genre]
		@subgenre 	= song[:genre]
		@tags 		= song[:tags]
	end
	
	def equal?(criteria)
		return false unless equal_tags?(criteria[:tags]) 
		return false unless criteria[:name].eql?(@name)
		return false unless criteria[:artist].eql?(@artist)
		return false unless criteria[:filter].call(self)
		true
	end 
	def equal_tags?(tags)
		tags = tags.to_a
		tags.each do |tag|
			bool = @tags.include?(tag.chomp("!"))
			if tag[-1, 1] == ("!")
				return false if bool
			else
				return false if !bool
			end 
		end
		return true
	end 
end

class Collection
	def initialize(songs_as_string, artist_tags)
		@songs_string = songs_as_string
		@artist_tags = artist_tags
		@songs = []
		self.to_songs
	end
	
	def find(criteria)
		return @songs if criteria.empty?
		array = []
   		@songs.each do |song|
   			if song.equal?(criteria)
   				array.push(song)
   			end
   		end
   		array
  	end
  	
  	def to_songs
  		@songs_string.each_line  { |line| @songs.push(Song.new( parse(line) )) }
  		@songs
  	end
  	
  	def parse(line)
  		line = line.split(".").each { |string| string.strip!}
  		line[2] = line[2].split(",").each { |string| string.strip!}
  		line[3] = line[3].split(",").each { |string| string.strip!}
  		line[2].each { |genre| line[3].push(genre.downcase) }
  		more_tags = @artist_tags[ line[1] ].each {
  			|tag| line[3].push(tag.downcase)
  		} unless @artist_tags[ line[1] ].nil?
  		keys = [:name, :artist, :genre, :tags]
  		hash = Hash[keys.zip(line)]
  	end
end



