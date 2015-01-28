#!/usr/bin/env groovy

def scriptFile = new File(args[0])

//  Else fall back to generic
if (!scriptFile.exists()) {
    scriptFile = new File(scriptsDir as String, "${membership.bookingAgent.code.toLowerCase()}-room-mappings.groovy")
}

if (!scriptFile.exists()) {
    throw new RuntimeException("File '${scriptFile.absolutePath}' not found")
}

def script = new GroovyShell().evaluate(scriptFile.text)

def title = " ${script.title()} "
while (title.size() < 100) {
	title = "*${title}*"
}

println ''
println title
println script.description()

def start = System.currentTimeMillis()
println "Answer: ${script.solve()} in ${System.currentTimeMillis() - start}ms"
println ''
