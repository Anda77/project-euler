#!/usr/bin/env groovy

def scriptFile = new File(args[0])

//  Else fall back to generic
if (!scriptFile.exists()) {
    scriptFile = new File("src/groovy/${args[0]}.groovy")
}

if (!scriptFile.exists()) {
    def scriptsDir = new File('src/groovy')
    def fileName = scriptsDir.list().find { it.matches("Problem${args[0]}_.+") }
    if (!fileName) {
        println "${args[0]} not found."
        return 1
    }
    scriptFile = new File('src/groovy', fileName)
}

if (!scriptFile.exists()) {
    println "File '${scriptFile.absolutePath}' not found"
    return 1
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
