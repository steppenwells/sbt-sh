package org.sbtsh

import sbt._
import sbt.CommandSupport._

object SbtShPlugin extends Plugin {

  override lazy val settings = Seq(Keys.commands += shCommand)

  def shCommand = Command.args("sh", "<shell command>") { (state, args) => 
    val ret = args.mkString(" ") !
    
    state
  }

}
