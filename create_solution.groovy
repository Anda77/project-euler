#!/usr/bin/env groovy

def srcSlashGroovy = new File('src/groovy')

if (!srcSlashGroovy.exists() && !srcSlashGroovy.isDirectory()) {
    println "Call from project root."
    return 1
}
def title = "${args[0][0]}${args[0][1..-1].split('_').join(': ')}"
title = title.replaceAll(/\B[A-Z]/) { ' ' + it }
title = title.replaceAll(/Problem(\d+)/, 'Problem $1')
def template = """
title = { '${title}' }

description = {
    \"\"\"

\"\"\"
}

solve = {
    def result
    return result
}
"""

new File(srcSlashGroovy, "${args[0]}.groovy").write(template)
