#!/usr/bin/env groovy

def srcSlashGroovy = new File('src/groovy')

if (!srcSlashGroovy.exists() && !srcSlashGroovy.isDirectory()) {
    println "Call from project root."
    return 1
}

def template = """
title = { 'Problem : ' }

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
