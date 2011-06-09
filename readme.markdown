sbt-sh
======

If you're like me you will often find yourself typing in shell commands into the sbt shell without thinking:

	> git status
	[error] Not a valid key: git (similar: target)
	[error] git status
	[error]    ^
	>

Using the sbt-sh plugin (and sbt-0.10) you can invoke shell commands:

	> sh git status
	# On branch master
	nothing to commit (working directory clean)
	> 

Happiness and productivity ensues without the hassle exiting sbt or opening multiple terminals.  

Usage
=====

The sbt-sh plugin introduces a *sh* command to sbt, this will execute the rest of the line as a shell command. Some examples:

	> sh ls
	build.sbt
	LICENSE
	project
	sbt
	sbt-launch-0.10.0.jar
	src
	target
	>

	> sh ls -l
	total 940
	-rw-r--r-- 1 swells developers     66 Jun  9 15:08 build.sbt
	-rw-r--r-- 1 swells developers   1394 Jun  9 15:08 LICENSE
	drwxr-xr-x 4 swells developers   4096 Jun  9 15:23 project
	-rwxr-xr-x 1 swells developers     69 Jun  9 15:08 sbt
	-rw-r--r-- 1 swells developers 935142 Jun  9 15:08 sbt-launch-0.10.0.jar
	drwxr-xr-x 3 swells developers   4096 Jun  9 15:08 src
	drwxr-xr-x 3 swells developers   4096 Jun  9 15:23 target
	>

	> sh cat build.sbt
	sbtPlugin := true
	
	name := "xsbt-sh"
	
	organization := "org.sbtsh"
	> 

By now I'm sure you've got the idea...

Installing
----------

The easiest way to install the sbt-sh plugin is to add it to your global sbt plugin list. To do this create a *.sbt/plugins/project* file (if it does not already exist). In this file add the dependency on the sbt-sh plugin:

	import sbt._
	
	object MyPlugins extends Build {
	  lazy val root = Project("root", file(".")) dependsOn(
	    uri("git://github.com/steppenwells/sbt-sh.git")
	  )
	}

The sh plugin will be downloaded, built and installed next time you fire up sbt-0.10, and then available in all your sbt-0.10 builds.
