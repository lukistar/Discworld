#school - ТУЕС www.elsys-bg.org
#class - 11Б
#num - 20
#name - Красимир Светославов Стойков
#task - Да се направят класове Site и Page, да може да се свали съдържанието на страница по url, да могат да се намерят линковете в съдържанието и т.н
require 'open-uri'
class Site

	attr_accessor :url
	attr_accessor :protocol
	attr_accessor :pages
	attr_accessor :title
	
	def initialize(url)
		@url = url
		set_protocol()
		@pages = Array.new{Page.new}
		set_title()
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
	def set_title()
		open(@url).read.scan(/<title>(.*?)<\/title>/)
		@title = $1
	end
	def print
		puts "URL: " + @url
		puts "PROTOCOL: " + @protocol
		puts "TITLE: : " + @title
		puts "PAGES: "
		for page in @pages
			page.print()
		end
	end
end
class Page

	attr_accessor :url
	attr_accessor :content
	attr_accessor :links
	attr_accessor :title
	
	def initialize(url)
		@url = url
		set_content()
		create_file_content()
		set_title()
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
	def set_title()
		open(@url).read.scan(/<title>(.*?)<\/title>/)
		@title = $1
	end
	def print()
		puts "URL: " + @url
		puts "TITLE: " + @title
		puts "LINKS: "
		for link in @links
			puts link
		end
	end
end

page = Page.new('http://en.wikipedia.org/wiki/Regular_expression')
site = Site.new("http://en.wikipedia.org")
site.add_page(page)
site.print
