val newContents = "bbbbbbbbb"

val rootContentFile = "root.txt"

scalaVersion := "2.10.2"

scalacOptions in (Compile, doc) := Seq("-doc-root-content", rootContentFile)

TaskKey[Unit]("changeRootContent") := {
  IO.write(file(rootContentFile), newContents)
}

TaskKey[Unit]("check") := {
  assert(IO.read((target in Compile in doc).value / "package.html").contains(newContents))
}
