Requirments

1) SprringSourceToolSuite 3.6 Release

2) Assuming GIT is already installed 
	a) clone the repo in eg origojava
	b) inside origojava run this - $ git submodule init  (run this first time)
	c) inside origojava run this - $ git submodule update (regular command ot update libraries)

3) install Gradle
	for gradle - http://www.gradle.org/installation
	get STS plugin - http://dist.springsource.com/release/TOOLS/gradle
	import project as gradle project.
	inside origojava/website/
	$ gradle refresh  (-often run this command to load java dependency)

4) install Composer
	https://getcomposer.org/
	inside origojava/website/
	$ composer install	(run this first time)
	$ composer update	( run this regularly to load javascript dependency)


