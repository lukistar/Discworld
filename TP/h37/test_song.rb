require 'test/unit'
require './song.rb'


class TestSong < Test::Unit::TestCase
	def setup
		@artist_tags =	{
			  'John Coltrane' => %w[saxophone],
			  'Bach' => %w[piano polyphony],
		}
		@songs_as_string = File.read("songs.txt")
		@collection = Collection.new(@songs_as_string, @artist_tags)
		@parsed_song = {
			:name => "My Favourite Things",
			:artist => "John Coltrane",
			:genre => ["Jazz", "Bebop"], 
			:tags => ["popular", "cover", "jazz", "bebop", "saxophone"],
		}
		@first_line = "My Favourite Things.John Coltrane.Jazz, Bebop.popular, cover"
		@lambda = lambda {|x=1| true }
		@criteria = {
			:tags => "saxophone",
			:name => "Ruby, My Dear",
			:artist => "Thelonious Monk",
			:filter => @lambda
		}
		@song = Song.new(@collection.parse("Ruby, My Dear.Thelonious Monk.Jazz.saxophone"))
	end

	def test_parse
		assert_equal(@parsed_song, @collection.parse(@first_line))		
	end
	
	def test_equal_tags?
		assert_equal(true, @song.equal_tags?("saxophone"))
	end
	
	def test_equal?
		assert_equal(true, @song.equal?(@criteria))
	end
	
	def test_find
		assert_equal(@song.name, @collection.find(@criteria)[0].name)
		assert_equal(@song.artist, @collection.find(@criteria)[0].artist)
		assert_equal(@song.genre, @collection.find(@criteria)[0].genre)
		assert_equal(@song.subgenre, @collection.find(@criteria)[0].subgenre)
		assert_equal(@song.tags, @collection.find(@criteria)[0].tags)
	end
	
end
