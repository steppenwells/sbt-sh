package org.sbtsh

import sbt._

import scala.language.postfixOps

object SbtShPlugin extends Plugin {

  override lazy val settings = Seq(Keys.commands += shCommand)

  def shCommand = Command.args("sh", "<shell command>") { (state, args) =>
    // Execute the shell command.
    args.mkString(" ") !

    state
  }

}
