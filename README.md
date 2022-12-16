# vscode-playground

📚 Learning and exploring Visual Studio Code (VS Code).

> Code editing. **Redefined.** Free. Built on open source. Runs everywhere.
>
> -- <cite>https://code.visualstudio.com/</cite>


## Overview

With this repository I am trying out Visual Studio Code (abbreviated "VS Code") in detail. Before, I have only used it
for basic text editing but I would like to explore its many other features like [VS Code Remote Development](https://code.visualstudio.com/docs/remote/remote-overview)
and in particular [Dev Containers](https://code.visualstudio.com/docs/devcontainers/containers). In 2022, the [Development Containers](https://containers.dev/)
specification and development user experience has blossomed inside VS Code. If I can use VS Code to get up and running
with toolchains that I'm not familiar with like machine learning, C/C++/autoconf, Dart, Raspberry Pi, etc, then this makes
me more likely to learn and experiment with those technologies.

Please note: I still love Intellij.


## Design

This project is designed to be developed in VS Code where VS Code is attached to a project-specific dev container. The dev
container, per convention, is defined in `.devcontainer/devcontainer.json`. I scaffolded the configuration file using the
VS Code command "Dev Containers: Add Dev Container Configuration Files...".

The project defines a toy Java program. It's built and executed using Gradle.


## Instructions

Follow these instructions to get up and running with this project.

1. Attach VS Code to the dev container
   * When you open VS Code in a project that contains a dev container configuration file (`.devcontainer/devcontainer.json`),
     VS Code will usefully prompt you with a notification like the following.
   * <img src="screenshots/reopen-in-containers-screenshot.png" alt="Folder contains a Dev Container configuration file. Reopen folder to develop in a container" width=500/>
   * Click the "Reopen in Container" button and VS Code will start a dev container (Docker container), VS Code will reload
     itself (the screen flashes) in a remote development mode where it attaches to some kind of backend VS Code server
     that's running in the dev container.
   * Now you are ready to start building, running and developing the project because you have a working development
     environment. You don't have to worry about installing Java (OpenJDK) or Gradle.
1. Run the Java program
   * Execute the following command from the built-in VS Code terminal.
   * ```shell
     gradle run --args "hello there!"
     ```
   * Gradle will compile and run the program using the JDK installed in the dev container. Altogether, it should look
     something like this.
   * ```text
     vscode ➜ /workspaces/vscode-playground (main ✗) $ gradle run --args "hello there!"
     
     > Task :run
     Hello, World! I'm a Java program. I was passed 2 arguments. They are: [hello, there!]
     Bye!
     
     BUILD SUCCESSFUL in 5s
     2 actionable tasks: 2 executed
     ```


## Observations about Visual Studio Code

* I like VS Code's "launch configurations" (an analog to Intellij's "run configurations") for two reasons. 1) they are
  defined in JSON (and ostensibly I should version control them in Git?) and 2) they simply kick off a command in the
  in-app terminal. It's a very simple model! By contrast, Intellij executes a run configuration in a separate "Run"
  window. While this isn't a major difference, the VS Code model is delightfully "obvious".
* Visual Studio Code is stylized/abbreviated as "VS Code". It's easy to forget the space!
* There is a control struggle with the dev containers experience. When using VS Code in the dev container, I don't have
  my "host system" (VS Code calls these "local") extensions (like GitHub Copilot). Instead, I only have the extensions prescribed in the dev container
  config. I think this makes sense (or am missing something?), because the VS Code "backend" is running in the container,
  right? And it's correct that dev containers shouldn't by default be granted the same trust that your host VS Code is
  granted. For example, a dev container should not be authorized to access the GitHub APIs (like repo permissions,
  Copilot permissions) unless I grant it. So, in other words, the dev container has taken control of the VS Code
  experience (for better and worse). I think dev containers are completely compelling for demo environments (espeically
  Codespaces demos right from the browser!), learning environments, bug reproduction environments, perhaps QA environments,
  etc. But if you're in the same codebase day in and day out, for months or years then I think you might want to take
  back your control.
* Lack of Kotlin support. VS Code has out-of-the-box syntax highlighting for 20+ programming languages. It does
  this by way of a grammar configuration file. For simple languages like Clojure, which is designed to have very few language
  features, [the grammar configuration is rudimentary](https://github.com/microsoft/vscode/blob/main/extensions/clojure/syntaxes/clojure.tmLanguage.json).
  For languages like Groovy, [the grammar configuration is sophisticated](https://github.com/microsoft/vscode/blob/f75d676e8df401c52e10df470970d251380e875a/extensions/groovy/syntaxes/groovy.tmLanguage.json).
  There are configurations for other programming languages: CoffeeScript, C++, C#, CSS, Dart, Dockerfile, Emmet, F#, Go,
  HTML, Java, JavaScript, Julia, LaTeX, Less, Lua, Perl, PHP, PowerShell, Python, R, Ruby, Rust, generic Shell, SQL, Swift,
  and VisualBasic. For many of these languages, VS Code goes above and beyond basic syntax highlighting and supports a
  rich IDE-like language experience with more complete syntax highlighting, smart autocompletion, error checking, jump-to-definition,
  and other features. These rich experiences are powered by [language servers](https://code.visualstudio.com/api/language-extensions/language-server-extension-guide)
  which are installed as VS Code extension. Example language extensions include:
   * [Microsoft owns and develops a Python extension](https://marketplace.visualstudio.com/items?itemName=ms-python.python).
   * [Microsoft owns and develops a C/C++ extension](https://marketplace.visualstudio.com/items?itemName=ms-vscode.cpptools).
   * [Microsoft owns and develops a C# extension](https://marketplace.visualstudio.com/items?itemName=ms-dotnettools.csharp)
   * [RedHat owns and develops a Java extension](https://marketplace.visualstudio.com/items?itemName=redhat.java)
   * [Google owns and develops a Go extension](https://marketplace.visualstudio.com/items?itemName=golang.Go)
   * [An individual owns and generously maintains a Ruby extension](https://marketplace.visualstudio.com/items?itemName=rebornix.Ruby)
   * [An individual owns and generously maintains a Kotlin extension in 'preview'](https://marketplace.visualstudio.com/items?itemName=fwcd.kotlin)
   * [An individual formerly generously maintained a popular Kotlin extension. This is unmaintained for three years](https://marketplace.visualstudio.com/items?itemName=mathiasfrohlich.Kotlin)
  
  It's interesting that there is neither out-of-the-box syntax support for Kotlin nor is there an organization-sponsored
  language extension. JetBrains owns Kotlin so it's reasonable that JetBrains would consider contributing the grammar or
  maintaining a language extension for Kotlin. But of course, JetBrains has a competing IDE product. And to be fair,
  Microsoft could contribute a grammar configuration for Kotlin. That is much less expensive to maintain than a full-on
  language server. This leaves programmers like me in a tough place because I want to use VS Code, dev containers and
  Codespaces for my Gradle-based projects that are using the Gradle Kotlin DSL. I've been using the Kotlin DSL for a few
  years and it is not strategic to go back to the Groovy DSL. What should I do?
* VS Code is a text editor (compared to an IDE) in the same way that React is a library (compared to a framework). They
  have both tremendously overachieved mass adoption and commensurately grown in sophistication and lines-of-code. When
  you compare Sublime Text and VS Code on the "editor-to-IDE" spectrum, Sublime Text inches to the right while VS Code
  leaps to the right. Make a similar comparison between React and Mustache/Handlebars. Be aware of these spectrums of
  low-to-high tooling sophistication. Sometimes we need one tool, and sometimes we need the other. All options have their
  own strengths and weaknesses. Inform yourself the best you can!


## Wish List

This is a list of things I wish to explore, answer and/or implement.

* [x] DONE Get a dev container working
* [x] DONE Get a Gradle-based Java program working
* [ ] Get a Go program working
* [ ] Get a Python program working (which build tool?)
* [ ] Get an NPM-based TypeScript program working
* [ ] What is the interop story between a dev container-powered VS Code experience and "local" extensions? For example, when
  I'm in a dev container project, the dev container might specify that VS Code extensions "A", "B", and "C" are installed.
  But I'm used to my special extension "Z" because it helps me with keyboard shortcuts or accessility or something. Can
  I use "Z" still without editing the shared dev containers config file?
* [ ] How are project files shared between my host system and the dev container? I read somewhere that dev containers don't
  use bind mounts, only volumes. Do my file edits in the dev container show up on my host? Or not? And when I have to
  rebuild the dev container, for example to add a new extension, then what happens to my project state, like my file edits?
* [x] NOT POSSIBLE (The Gradle VS Code extension supports Gradle tasks and project detection but when it comes to Kotlin
  language support, that's not its job. See my earlier note about Kotlin language support in VS Code. While the preview
  Kotlin extension maintained by an individual is promising, I will stick with "paved road" tooling). I can't get syntax
  highlighting in the `settings.gradle.kts` or `build.gradle.kts` files even though I'm getting the Gradle tool button
  thing and can run Gradle tasks like "run" successfully. So the Gradle VS Code is partly working. I need syntax
  highlighting and autocomplete for `build.gradle.kts`.
* [ ] Can I globally configure preferences in VS Code? I want word wrap always off, for example.
* [ ] Create a launch configuration (I have a working one but I haven't explored the feature enough).
* [ ] Describe how to run the project in debug mode.


## Reference

* [Visual Studio docs: *Java in Visual Studio Code*](https://code.visualstudio.com/docs/languages/java)