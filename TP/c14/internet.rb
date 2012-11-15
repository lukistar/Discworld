require 'net/http'
class Site
	@url
	@protocol
	def initialize(url)
		@url = url
		if @url.include?("https")
			@protocol = "https"
		elsif @url.include?("http")
			@protocol = "http"
		end
	end
	def print()
		puts("url: " + @url)
		puts("protocol: " + @protocol)
	end  
end
class Page
	def initialize(url)
		open(url, "wb") do |file|
			http_response = Net::HTTP.get_response(URI.parse(url))
  			puts http_response.body
  			file.write(http_response.body)
		end
	end
	def print()
		puts("url: " + @url)
	end
end

z = Page.new("http://stackoverflow.com/questions/4833333/determine-whether-a-string-contains-any-of-a-set-of-strings")



