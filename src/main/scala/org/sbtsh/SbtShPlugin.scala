package org.sbtsh

import sbt._

object SbtShPlugin extends Plugin {

  override lazy val settings = Seq(Keys.commands += shCommand)

  def shCommand = Command.args("sh", "<shell command>") { (state, args) => 
    val ret = args.mkString(" ") !
    
    state
  }

}
