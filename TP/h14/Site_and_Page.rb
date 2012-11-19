#school - ТУЕС www.elsys-bg.org
#class - 11Б
#num - 20
#name - Красимир Светославов Стойков
#task - Да се направят класове Site и Page, да може да се свали съдържанието на страница по url, да могат да се намерят линковете в съдържанието
require 'open-uri'
class Site

	attr_accessor :url
	attr_accessor :protocol
	attr_accessor :pages
	
	def initialize(url)
		@url = url
		set_protocol()
		@pages = Array.new{Page.new}
	end
	def set_protocol()
		if @url.include?"https"
			@protocol = "https"
		elsif @url.include?"http"
			@protocol = "http"
		end
	end
	def add_page(page)
		@pages.push(page)
	end
	def print
		puts "URL: " + @url
		puts "PROTOCOL: " + @protocol
		puts "PAGES: "
		for page in @pages
			page.print
		end
	end
end
class Page

	attr_accessor :url
	attr_accessor :content
	attr_accessor :links
	
	def initialize(url)
		@url = url
		set_content()
		create_file_content()
		set_links()
	end
	def set_content()
		file = open(@url)
		@content = file.read
	end
	def create_file_content() #useless for now
		@file_content = "page.html"
		File.open(@file_content, "w+") { |file| file.write(@content) }
	end
	def set_links()
		@links = @content.scan(/a\s+href\s*=\s*"(.*?)"/)
	end
	def print()
		puts "URL: " + @url
		puts "LINKS: "
		for link in @links
			puts link
		end
	end
end

page = Page.new('http://stackoverflow.com/questions/1854207/getting-webpage-content-with-ruby-im-having-troubles')
site = Site.new("http://stackoverflow.com")
site.add_page(page)
site.print
